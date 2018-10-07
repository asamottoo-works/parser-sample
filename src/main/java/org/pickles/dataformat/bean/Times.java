package org.pickles.dataformat.bean;

public class Times {

	public Times(int times) {
		this.times = times;
	}

	private int times;

	public void forEach(Task task){
		for (int i = 0; i < times; i++){
			task.execute();
		}
	}

	public interface Task {
		public void execute();
	}
}
