package net.minecraftborge.loader.event;

public abstract class Event {
	private final boolean cancelable = this.getClass().isAnnotationPresent(Cancelable.class);
	private boolean canceled = false;

	public boolean isCancelable() {
		return this.cancelable;
	}
	public boolean isCanceled() {
		return this.canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public enum Phase {
		PRE, POST
	}
}
