package task;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

public class TaskQueueTest {

	@Test
	public void testTaskQueue() {
		
		BlockingQueue<String> queue=new LinkedBlockingQueue<String>();
		TaskQueue taskManager=new TaskQueue<String>(queue);
		new Producer(taskManager).run();
		new Consumer(taskManager).run();
		Executors.newFixedThreadPool(0);
		
		BlockingQueue<String> queue2=new SynchronousQueue<String>();
		taskManager=new TaskQueue<String>(queue2);
		
	}

}
