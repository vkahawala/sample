package user.mgt.core.util;

public enum SavableStatus {
	INSERT(1), UPDATE(2), DELETE(3);

	private int status;

	SavableStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int stat) {
		status = stat;
	}

}
