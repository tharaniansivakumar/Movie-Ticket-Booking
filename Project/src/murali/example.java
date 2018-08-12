package murali;
import java.util.*;
public class example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s=in.next();
		String ss="";
		char c;
		int i,sum=0,j;
		HashSet str=new HashSet();
		
		for(i=0;i<s.length();i++)
		{
			str.add(s.charAt(i));
}
		Iterator it=str.iterator();
		while(it.hasNext())
		{
			char a=(char) it.next();
			sum=sum+(int)a;
		}
		while(sum>0)
		{
			j=sum%2;
			sum=sum/2;
			ss=ss+Integer.toString(j);
		}
		StringBuffer strr=new StringBuffer(ss);
		System.out.println(strr.reverse());
	}

}
