import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =2%5;
		
		System.out.print(a);
		System.out.print("/////////////////\n");
		String s = "dog cat cat dog";
		
		String[] s1 = s.split(" ");
		
		for(int i =0; i< s1.length;i++) {
			System.out.println(s1[i]);
		}
				
		String si =  "1111" + 9 +8;
		int i = Integer.valueOf(si);
		System.out.println(si);
		
		
		double d = 0.1+0.1+0.1;
		System.out.println(d);
		
		List<String> list = new ArrayList<>();
		
		
		String s2 = "Hello";
		String s3 = "Hello";
		
		System.out.println(s2 == s3);
		
		
		String stest = "lee(t(c)o)de)";
		String sub = stest.substring(0, 12);
		System.out.println(sub);
	}

}
