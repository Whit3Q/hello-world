import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Formatter;
import java.io.*;

public class UdpClient {
	public static void main(String args[]) throws Exception {
		File publicKeyFile = new File("public.key");
		File privateKeyFile = new File("private.key");
		PublicKey publicKey = null;
		PrivateKey privateKey = null;
		
		if (publicKeyFile.exists() && privateKeyFile.exists()) {
			// 파일에서 키 읽어오기
			Path publicFile = Paths.get("public.key");
			byte[] publicKeyBytes = Files.readAllBytes(publicFile);
			Path privateFile = Paths.get("private.key");
			byte[] privateKeyBytes = Files.readAllBytes(privateFile);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyBytes));
			privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
		} else {
			// 공개키쌍 생성
			KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(2048);
			KeyPair pair = generator.generateKeyPair();
			publicKey = pair.getPublic();
			privateKey = pair.getPrivate();
			FileOutputStream outputPublic = new FileOutputStream(new File("public.key"));
			outputPublic.write(publicKey.getEncoded());
			FileOutputStream outputPrivate = new FileOutputStream(new File("private.key"));
			outputPrivate.write(privateKey.getEncoded());
		}
		
		System.out.println("공개키: "+bytesToHex(publicKey.getEncoded()));
		System.out.println("개인키: "+bytesToHex(privateKey.getEncoded()));
		
		try {
			DatagramSocket ds = new DatagramSocket();
			InetAddress ia = InetAddress.getByName("localhost");
			byte[] bf = privateKey.getEncoded();
			DatagramPacket dp = new DatagramPacket(bf, bf.length, ia, 12344);
			ds.send(dp);
		} catch(Exception e){
			System.out.println(e);
		}
	}
	public static String bytesToHex(byte[] bytes) {
	    StringBuilder sb = new StringBuilder(bytes.length * 2);
	    @SuppressWarnings("resource")
		Formatter formatter = new Formatter(sb);
	    for (byte b : bytes) {
	        formatter.format("%02x", b);
	    }
	    return sb.toString();
	}
	
}