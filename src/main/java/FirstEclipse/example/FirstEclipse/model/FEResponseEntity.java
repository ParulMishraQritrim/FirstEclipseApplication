 package FirstEclipse.example.FirstEclipse.model;

public class FEResponseEntity <T> implements Cloneable
{
	private String uri;
	private int executionTime;
	private ResponseStatus status;
	
	private T body;

	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(int executionTime) {
		this.executionTime = executionTime;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
