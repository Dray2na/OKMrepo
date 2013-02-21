package sonok.user;

import java.util.ArrayList;

public class Group {
	private ArrayList<User> users = new ArrayList<User>();
	//

	public boolean addUser(User e) {
		return users.add(e);
	}

	public void clearUser() {
		users.clear();
	}

	public boolean containsUser(Object o) {
		return users.contains(o);
	}

	public User getUser(int index) {
		return users.get(index);
	}

	public int indexOfUser(Object o) {
		return users.indexOf(o);
	}

	public User removeUser(int index) {
		return users.remove(index);
	}

	public boolean removeUser(Object o) {
		return users.remove(o);
	}

	public int sizeUser() {
		return users.size();
	}
	
	
}
