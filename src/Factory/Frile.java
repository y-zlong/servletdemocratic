package Factory;

public interface Frile {
	public void eat();
}
class Apple implements Frile{

	@Override
	public void eat() {
		System.out.println("³ÔÆ»¹û");
	}
	
}
class Orange implements Frile{

	@Override
	public void eat() {
		
	}
	
}
 class Test{
	public Frile get(String className) {
		if("Apple".equals(className)) {
			return new Apple();
		}
		if("Orange".equals(className)) {
			return new Orange();
		}
		return null;
		
	}
}
