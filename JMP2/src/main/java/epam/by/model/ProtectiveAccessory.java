package epam.by.model;

public class ProtectiveAccessory extends AbstractAccessory {

	private String material;
	private String diagonal;

	public ProtectiveAccessory() {
		super();
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDiagonal() {
		return diagonal;
	}

	public void setDiagonal(String diagonal) {
		this.diagonal = diagonal;
	}

}
