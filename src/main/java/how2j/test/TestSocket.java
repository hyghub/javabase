package how2j.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class TestSocket {
	public static void main(String[] args) throws IOException {
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		String ipRange = ip.substring(0, ip.lastIndexOf('.'));
		System.out.println(ipRange);
		
		Process p = Runtime.getRuntime().exec("ping "+"192.168.2.106");
		BufferedReader red = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line=red.readLine())!=null) {
			if(line.length()!=0) {
				sb.append(line+"\r\n");
			}
		}
		System.out.println(sb.toString());
	}
}
