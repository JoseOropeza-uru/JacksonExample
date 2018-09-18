package models;

public class OuterClass {
	private String message;
	private InnerClass inner;

	public InnerClass getInner() {
		return inner;
	}

	public void setInner(InnerClass inner) {
		this.inner = inner;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
