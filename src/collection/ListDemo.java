package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListDemo {
	public static void main(String[] args) {
		/*ArrayList<User> list = new ArrayList<User>();
		User user1 =  new User("ÕÅÈı", "123456");
		User user2 = new User("lisi","45678");
		list.add(user1);
		list.add(user2);
		
		System.out.println(list.size());
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("-------------------------------");
		Iterator<User> user  = list.iterator();
		while (user.hasNext()) {
			User user3 = (User) user.next();
			System.out.println(user3);
		}
		System.out.println("-----------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("--------------------------");*/
		LinkedList<User> list = new LinkedList<User>();
		User user1 = new User("zhangsan", "123456");
		User user2 = new User("wangwu", "58656");
		list.add(user2);
		list.add(user1);
		System.out.println(list.size());
		Iterator<User> list1 = list.iterator();
		while(list1.hasNext()) {
			User user = list1.next();
			System.out.println(user);
		}
		System.out.println("---------------------");
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("-----------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
}