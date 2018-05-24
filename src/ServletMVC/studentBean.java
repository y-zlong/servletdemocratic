package ServletMVC;

public class studentBean {
	private Integer id;
	private String name;
	private int number;
	private String dress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public studentBean(Integer id, String name, int number, String dress) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.dress = dress;
	}
	public studentBean() {
		
	}
}
