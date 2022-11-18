package bean;
import java.io.Serializable;
public class UserBean implements Serializable {
	
	private int id;
	private String name;
	private int phone;
	private int birth_date;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(int birth_date) {
		this.birth_date = birth_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
