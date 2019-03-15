package how2j.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			System.out.println(s);
			InputStream is =s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			OutputStream os =s.getOutputStream();
			DataOutputStream ois = new DataOutputStream(os);
			while(true) {
				Scanner str = new Scanner(System.in);
				ois.writeUTF(str.next());
				String msg = dis.readUTF();
                System.out.println("收到服务端消息:"+msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
