package sonok.user;

import java.util.ArrayList;

public class Group {
	private ArrayList<User> users = new ArrayList<User>();

	///
	public boolean add(User e) {
		return users.add(e);
	}

	public void clear() {
		users.clear();
	}

	public boolean contains(Object o) {
		return users.contains(o);
	}

	public User get(int index) {
		return users.get(index);
	}

	public int indexOf(Object o) {
		return users.indexOf(o);
	}

	public User remove(int index) {
		return users.remove(index);
	}

	public boolean remove(Object o) {
		return users.remove(o);
	}

	public int count() {
		return users.size();
	}
	
	
}
