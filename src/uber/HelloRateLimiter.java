package uber;

/*
 * һ��hello function���һ��֮�ڱ������������������hello���� �������������error��
 * Ȼ�������۴����ݶ��������δ�������2million�η������������������������error��
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192484&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * ������ǵ���hello function�����Լ�дhello function
 ���� 1��֮�ڵ���4��
 hello().
 # print hello
 hello() 
 # print hello. 
 hello(). 
 # print hello
 hello()
 # print error
 */
public class HelloRateLimiter {
	private int RPS = 3;
	private int tokens = 3;
	private long timestamp = System.currentTimeMillis();
	private int capacity = 3;
	private int count = 0;

	private boolean makeRequest() {
		long now = System.currentTimeMillis();
		tokens += (now - timestamp)*RPS / 1000 ;
		if (tokens > capacity)
			tokens = capacity;
		if (tokens <= 0)
			return false;
		tokens--;
		timestamp = now;
		return true;
	}

	public void hello() {
		count++;
		System.out.print(count+":"+System.currentTimeMillis()+"-");
		if (makeRequest()) {
			System.out.println("Hello!");
		} else {
			System.out.println("wait for 1 seconds");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		HelloRateLimiter q = new HelloRateLimiter();
		q.hello();
		Thread.sleep(333);
		q.hello();
		Thread.sleep(333);
		q.hello();
		Thread.sleep(333);
		q.hello();
		Thread.sleep(333);
		q.hello();
		Thread.sleep(333);
		q.hello();
		Thread.sleep(333);
		q.hello();
		q.hello();
	}

}
