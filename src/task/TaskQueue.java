package task;

import java.util.concurrent.BlockingQueue;

public class TaskQueue<T> {

	private BlockingQueue<T> queue;

	public TaskQueue(BlockingQueue<T> queue) {
		this.queue = queue;
	}

	public void put(T task) {
		try {
			queue.put(task);
		} catch (InterruptedException e) {
		}
	}

	public T take() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
