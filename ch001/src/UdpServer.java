import java.net.*;
import java.nio.charset.Charset;
import java.util.Formatter;
import java.io.*;
import java.lang.*;

public class UdpServer {
	public static void main(String args[]) {
		try {
			DatagramSocket ds = new DatagramSocket(12344);

			while(true) {
				try {
					byte[] bf = new byte[300];
					DatagramPacket dp = new DatagramPacket(bf, bf.length);
					ds.receive(dp);
					String rs1 = new String(dp.getData());
					Charset charset = Charset.forName("UTF-8");
					byte[] brs1 = rs1.getBytes(charset);
					String rs2 = new String(rs1.trim());
					System.out.println("주소:" + dp.getAddress() + " 포트번호:" +
							dp.getPort());
					System.out.println("수신된 메시지(Client->Server): " + bytesToHex(brs1));
				} catch(IOException e){}
			}
		} catch(IOException e){}
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