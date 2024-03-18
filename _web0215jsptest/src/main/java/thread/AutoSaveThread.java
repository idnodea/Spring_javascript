package thread;

public class AutoSaveThread extends Thread{
	
	
	public void save() {
		System.out.println("작업내용저장");
	}

	@Override
	public void run() {
		while(true) {
			save();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			
		}
		
	}
	
}
