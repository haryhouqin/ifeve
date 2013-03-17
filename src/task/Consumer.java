package task;

public class Consumer implements Runnable{
	
	private TaskQueue<String> taskManager;
	
	public Consumer(TaskQueue<String> taskManager)
	{
		this.taskManager=taskManager;
	}

	@Override
	public void run() {
		String s = taskManager.take();
		System.out.println("Íê³É£º"+s);
	}

}
