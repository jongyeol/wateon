package wateon.entity;

import java.util.LinkedList;
import java.util.List;

import kfmes.natelib.SwitchBoardSession;

public class ChatRoom {
	private String targetId;
	private List<Message> receivedMessageQ;
	private SwitchBoardSession session;

	public ChatRoom(String targetId, SwitchBoardSession session) {
		receivedMessageQ = new LinkedList<Message>();
		this.targetId = targetId;
		this.session = session;
	}

	public String getTargetId() {
		return targetId;
	}

	public List<Message> getReceivedMessageQ() {
		return receivedMessageQ;
	}

	/**
	 * 채팅방을 닫는다. (반드시, WateOnUser 를 통해서 호출되야 함.)
	 */
	public synchronized void close() {
		receivedMessageQ.clear();
		session.close();
	}

	/**
	 * 한 개의 새 메시지를 추가한다.
	 * @param msg 새 메시지
	 */
	public synchronized void addNewMessage(Message msg) {
		receivedMessageQ.add(msg);
	}

	/**
	 * 모든 메시지를 가져오고나서, 저장되어있던 메시지를 비운다.
	 * @return 그동안 쌓인 모든 메시지
	 */
	public synchronized List<Message> getAllMessages() {
		List<Message> queue = receivedMessageQ;
		receivedMessageQ = new LinkedList<Message>();
		return queue;
	}

	public boolean sendMessage(String message) {
		return session.sendMessage(message);
	}
}