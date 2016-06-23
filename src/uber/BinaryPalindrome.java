package uber;

/*
 * 
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=189228&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * ��һ���Ǹ�һ��32λ��int�������ж�����2���Ʊ�ʾ�Ƿ���palindrome,���Լ��Ǹ�λ�͵�λ����һ���ƶ�����β�ַ��Ƿ�����ͬ�ģ����������д�ţ˵��������ѯ����߰ѵ�16λ��ת������16λ��Ȼ���ø�16λ����16λ����������orһ�£�����ԭ�������Ƿ�һ����
 */

public class BinaryPalindrome {

	public boolean checkPalindrome(int num) {
		String s = Integer.toBinaryString(num);
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		BinaryPalindrome q = new BinaryPalindrome();
		System.out.println(q.checkPalindrome(4));
		System.out.println(q.checkPalindrome(7));
		System.out.println(q.checkPalindrome(3));
	}

}
