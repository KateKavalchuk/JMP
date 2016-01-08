package epam.by.model;

public class HeadSetAccessory extends AbstractAccessory {

	private boolean wireless;

	public HeadSetAccessory() {
		super();
	}

	public boolean isWireless() {
		return wireless;
	}

	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}

}
