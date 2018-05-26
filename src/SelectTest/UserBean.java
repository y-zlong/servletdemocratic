package SelectTest;

public class UserBean {
	private Integer uid;
	private String name;
	private int number;
	private String dress;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer u_id) {
		this.uid =uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDress() {
		return dress;
	}
	public void setDress(String dress) {
		this.dress = dress;
	}
	public UserBean(Integer uid, String name, int number, String dress) {
		super();
		this.uid = uid;
		this.name = name;
		this.number = number;
		this.dress = dress;
	}
	public UserBean() {
		
	}
}

