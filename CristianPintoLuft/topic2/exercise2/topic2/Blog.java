package topic2;

import java.util.ArrayList;

public class Blog {
	String name;
	ArrayList<Entry> entries = new ArrayList<Entry>();

	public Blog(String name) {
		this.name = name;
	}

	public boolean post(Entry entry) {
		try {
			entries.add(entry);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean delete(Entry entry) {
		try
		{
			entries.remove(entry);
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

}
