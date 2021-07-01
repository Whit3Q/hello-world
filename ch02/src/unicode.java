
public class unicode {
	public static void main(String[] args) 
	{
		String name = "test";
		
		System.out.println(name.charAt(3));
		
		int aaa[][];
		
		int aaaa[][] = {
				{1,2,3},
				{1},
				{2},
				{3}
		};
		System.out.print(aaaa[2][0]);
		
		/*
		 * char hex[] = {'C','A', 'F', 'Z'}; String binary[] = { "0000",
		 * "0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011",
		 * "1100","1101","1110","1111"};
		 * 
		 * String result = "";
		 * 
		 * kyuhwan : for (int i = 0; i < hex.length; i++) { if ( hex[i] >= '0' && hex[i]
		 * <= '9') { result += binary[hex[i] - '0']; System.out.println(hex[i] - '0'); }
		 * else { System.out.println('a'+'a'); result += binary[hex[i] - 'A' + 10]; } }
		 * 
		 * System.out.println("hex :" + new String(hex)); System.out.println("binary :"
		 * + result);
		 */

		
		
//		System.out.println(85/5);
//		
		
//		char ch;
//		System.out.println("test");
//		for(int i=0;i<100;i++) {
//			ch = (char)i;
//			System.out.println(i);
//			System.out.print(ch);
//		}
//		ch = '\n';
//		System.out.println(ch);
//		//int i = 0;
//		char ch;
//		for(int i = 0; i>65536; i++) {
//			ch = (char)i;
//			System.out.println(ch);
//		}
	}
}
