package thread;

public class DaemonEx {

	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
//		autoSaveThread.setDaemon(true); 메인이 끝나면 끝
		autoSaveThread.setDaemon(false); //메인이 끝나도 끝이 아님
		autoSaveThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("메인 스레드 종료");
	}

}
