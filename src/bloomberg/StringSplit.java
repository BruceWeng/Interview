package bloomberg;

import java.math.BigInteger;
import java.util.ArrayList;




/*
 * ��һ�� technical interview�� ���Թ� һ��������һ�����ˡ�  ������������design ��implement object��  user input string ,  
 * objectҪ�ܷ�����return �� string��   between  0x02 �� 0x03 �м��string�� ����� tricky�Ĳ����� �����һ�ε�input û��0x03, 
 * ��Ҫ����read ��һ�� input ֱ�� ��⵽ 0x03.   ��� ͬһ��input�У� ��������  0x02 ABCD 0x03 0x02 DDBCD 0x03  
 * ��ô ��Ҫreturn arrayList < ABCD , DDBCD>   
 * http://www.1point3acres.com/bbs/thread-193782-1-1.html
 */
public class StringSplit {
	public ArrayList<String> getSubStr(String[] strs) {
		ArrayList<String> res = new ArrayList<String>();
		String substring = "";
		boolean isStart = false;
		for (int i = 0; i < strs.length; i++) {
			String[] words = strs[i].split(" ");
			for (String word : words) {
				if (isStart == false && word.equals("0x02")) {
					isStart = true;
					substring = "";
				} else if (isStart && word.equals("0x03")) {
					isStart = false;
					res.add(substring.substring(1));
				} else if (isStart && !word.equals("\n")) {
					substring += " " + word;
				}
			}
		}
		return res;
	}
	public static void main(String[] args)  {
		BigInteger a = new BigInteger("123154564564");
		BigInteger b = new BigInteger("-123154564565");
		System.out.println(a.add(b));
		
		
	}
}
