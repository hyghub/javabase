package how2j.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serve {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("监听8888端口");
			Socket s=ss.accept();
			System.out.println("连接"+s);
			InputStream is =s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			OutputStream os =s.getOutputStream();
			DataOutputStream ois = new DataOutputStream(os);
			while(true) {
				String mess = dis.readUTF();
				System.out.println("收到客户端消息:"+mess);
				Scanner str = new Scanner(System.in);
				ois.writeUTF(str.next());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}