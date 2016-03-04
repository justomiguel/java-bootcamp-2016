package bootcamp.topic2.blogtdd;

import java.util.ArrayList;

public class Blog {

	public void addNewEntry(Entry entry, EntryDAO dao) {
		dao.insert(entry);
	}
	
	public boolean exists(Entry entry, EntryDAO dao) {
		return dao.exists(entry);
	}

	public void deleteEntry(Entry entry, EntryDAO dao) {
		dao.delete(entry);
	}

	public ArrayList<Entry> getMostRecent(EntryDAO dao) {
		ArrayList<Entry> response = new ArrayList<Entry>(dao.getEntries(10));
		return response;
	}
	
}
