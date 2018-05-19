package collection;

import java.util.HashSet;

public class SetDemo {
	public static void main(String[] args) {
		
		HashSet<User> user = new HashSet<User>();
		User u1 = new User("zhansan", "12356");
		User u2 = new User("zhaoliu", "74747");
		user.add(u2);
		user.add(u1);
		System.out.println(user);
		System.out.println(user.size());
		
	}
	
}
