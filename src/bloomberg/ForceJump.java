package bloomberg;

import java.util.Random;


/*
 * ��һ�ֵڶ��⣺ ��¥���⣬   һ������¥�ݣ���һ����֪function�� jump()  �����return true false;    ���jump return true�� �������һ̨�ס� ��֮ ��һ��̨�ס�����Ҫimplement һ��function ����enforcejump();  �������functionҪȷ������˱�������һ��̨�ס�  Ҫ�õ� jump����   ���¥�������Թ���������Ŀ�� ����֮��ʼ���� �������ˡ�
 * http://www.1point3acres.com/bbs/thread-193782-1-1.html
 */
public class ForceJump {
	public boolean jump() {
		Random random = new Random();
		return random.nextBoolean();
	}
	public void enforeJump() {
		if (jump()) return;
		enforeJump();
		enforeJump();
	}
}
