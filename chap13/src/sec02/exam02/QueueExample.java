package sec02.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "ȫ�浿"));
		messageQueue.offer(new Message("sendSMS", "�ſ��"));
		messageQueue.offer(new Message("sendKakaotalk", "ȫ�β�"));
		
		while(!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch(message.command) {
				case "sendMail":
					System.out.println(message.to + "홍길동님에게 메일을 보냅니다.");
					break;
				case "sendSMS":
					System.out.println(message.to + "신용권님에게 SMS를 보냅니다.");
					break;
				case "sendKakaotalk": 
					System.out.println(message.to + "홍두께님에게 카카오톡을 보냅니다.");
					break;
			}
		}
	}
}
