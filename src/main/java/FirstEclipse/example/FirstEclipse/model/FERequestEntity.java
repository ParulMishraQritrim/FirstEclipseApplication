 package FirstEclipse.example.FirstEclipse.model;

 
public class FERequestEntity<T> implements Cloneable{
	
	private T body;
	
	//private User loggedUser;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
	
}
