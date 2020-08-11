package broker.three.server;

import java.net.ServerSocket;
import java.net.Socket;

/*
 * Server Side의 Process class...
 * 서버소켓을 가지면서 클라이언트의 접속을 기다린다...
 * 해당 클래스는 무한 루핑을 돌면서 계속적으로 서버에 접속하는 클라이언트를 accept하게 될 것이다.
 * 리스너 쓰레드...
 */
public class ProtocolHandler extends Thread {
	ServerSocket server;
	Socket s;
	JuryThread jury;
	Database db;
	static final int MIDDLE_PORT = 60000;

	public ProtocolHandler(String serverIP) {
		//ServerSocket, Database 생성
		try {
			server = new ServerSocket(MIDDLE_PORT); // 서버소켓
			db = new Database(serverIP); 
			//데이터베이스를 생성자에게 넣는 이유? 하나 만들어놓고 시작하겠다.
			//Jury가 만들어지기 전에 먼저 만들어져 있어야 함.
			
		}catch(Exception e) {
		}
		System.out.println("start protocol Handler..... service port :: "+MIDDLE_PORT);
	}
	public void run() {
		//무한루핑 돌면서 클라이언트가 접속하면 받아서 소켓을 리턴... 그것을 Jury에게 던진다.
		while(true) {
			try {
				s = server.accept(); //Socekt이 리턴되면...Jury생성
				jury = new JuryThread(s, db);
				jury.start();
			}catch(Exception e) {
				
			}
		}
	}
	public static void main (String[] args) {
		ProtocolHandler handler = new ProtocolHandler("127.0.0.1"); //서버측 ip
		handler.start();
	}
}
