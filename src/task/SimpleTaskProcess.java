package task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SimpleTaskProcess<T> implements Runnable {
	
	
	private ThreadPoolExecutor threadsPool;

	private BlockingQueue<Runnable> runnableTaskQueue;

	public SimpleTaskProcess(int consumerThreadCount,
			BlockingQueue<Runnable> runnableTaskQueue) {
		this.runnableTaskQueue = runnableTaskQueue;
		threadsPool = new ThreadPoolExecutor(consumerThreadCount,
				consumerThreadCount, 3L, TimeUnit.SECONDS, runnableTaskQueue);
	}

	public void addTask(Runnable task) {
		runnableTaskQueue.add(task);
	}

	@Override
	public void run() {
		threadsPool.prestartAllCoreThreads();
	}

	public void shutdown() {
		threadsPool.shutdown();
	}

	public static void main(String[] args) {
		BlockingQueue<Runnable> runnableTaskQueue = new LinkedBlockingQueue<Runnable>(
				5000);
		SimpleTaskProcess pro = new SimpleTaskProcess(5, runnableTaskQueue);
		pro.run();
		int taskNum = 100;
		Runnable consumerTask = new Runnable() {
			@Override
			public void run() {
				int i = 18 * 20;
			}
		};

		for (int i = 0; i < taskNum; i++) {
			pro.addTask(consumerTask);
		}

		pro.shutdown();
	}

}
