package how2j.test;

import java.text.DecimalFormat;

public class Test {
	public static void main(String[] args) {
		 double d = 114.145;
		 DecimalFormat df = new DecimalFormat("#.00");
		 String str = df.format(d);
		 System.out.println(str);
		 System.out.println(String.format("%.2f",d ));
	}
	
}
