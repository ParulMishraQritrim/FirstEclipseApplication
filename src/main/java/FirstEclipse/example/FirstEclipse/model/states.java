package FirstEclipse.example.FirstEclipse.model;
import javax.persistence.*;


@Entity
@Table(name="Country")
public class states 
{
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private int id;
     @Column(name="State")
	 private String State;
     @Column(name="Capital")
	 private String Capital;
	 
	 public states() 
	 {
			super();
	}
	
	 public states(int id, String state, String capital)
	 {
			super();
			this.id = id;
			State = state;
			Capital = capital;
	}
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return State;
	}
	
	public void setState(String state) {
		State = state;
	}
	public String getCapital() {
		return Capital;
	}
	public void setCapital(String capital) {
		Capital = capital;
	}
	 
  
  
}
