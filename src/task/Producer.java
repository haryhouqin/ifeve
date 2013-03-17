package task;

public class Producer implements Runnable{
	
	private TaskQueue<String> taskManager;
	
	public Producer(TaskQueue<String> taskManager)
	{
		this.taskManager=taskManager;
	}

	@Override
	public void run() {
		String taskName = "1";
		taskManager.put(taskName);
		System.out.println("Ìí¼ÓÈÎÎñ:"+taskName);
	}

}
