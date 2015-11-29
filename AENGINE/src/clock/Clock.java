package clock;

import java.util.ArrayList;

public class Clock implements Runnable{

	private boolean running = true;
	private ArrayList<CallInterface> calls = new ArrayList<CallInterface>();
	private long current;
	private long last;
	private long difference = 1000;
	private long delay = 10;
	
	@Override
	public void run() {
		while(running){
			current = System.currentTimeMillis();
			if(current-last > difference){
				last = current;
				for(CallInterface call: calls){
					call.call();
				}
			}else{
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void removeCall(CallInterface call){
		this.calls.remove(call);
	}
	
	public void addCall(CallInterface call) {
		this.calls.add(call);
	}

	public long getCurrent() {
		return current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}

	public long getLast() {
		return last;
	}

	public void setLast(long last) {
		this.last = last;
	}

	public long getDifference() {
		return difference;
	}

	public void setDifference(long difference) {
		this.difference = difference;
	}

	public long getDelay() {
		return delay;
	}

	public void setDelay(long delay) {
		this.delay = delay;
	}

}
