package task;

import java.util.concurrent.BlockingDeque;

public class TaskDeque<T> {

	private BlockingDeque<T> blockingDeque;

	public TaskDeque(BlockingDeque<T> blockingDeque) {
		this.blockingDeque = blockingDeque;
	}

	public void put(T task) {
		try {
			blockingDeque.putFirst(task);
		} catch (InterruptedException e) {
		}
	}

	public T take() {
		try {
			return blockingDeque.takeLast();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
