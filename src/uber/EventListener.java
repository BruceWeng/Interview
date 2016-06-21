package uber;

import utils.Observer;
import utils.Subject;
/*
 * 
 * @author runrain
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=191998&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D22%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * ��һ�֣�����ӡ���ˣ���Ŀ�����һ��EventListenerҪ��ʵ��register unregister �� post ��������hackerrankд������û��compile��
 *
 */
public class EventListener implements Observer {
	Subject event;
	public EventListener(Subject event) {
		this.event = event;
		register();
	}
	
	private void register() {
		event.registerObservers(this);
	}
	
	private void unregister() {
		event.unregisterObservers(this);
	}
	
	@Override
	public void update() {
		System.out.println("Event is coming");
	}

}
