package bootcamp.topic2.blogtdd;

import java.util.ArrayList;
import java.util.List;

public class EntryDAOFakeImplementation implements EntryDAO {
	
	private List<Entry> entries;
	
	public EntryDAOFakeImplementation() {
		entries = new ArrayList<Entry>();
	}
	
	@Override
	public void insert(Entry entry) {
		entries.add(0, entry);
	}

	@Override
	public void delete(Entry entry) {
		entries.remove(entry);		
	}

	@Override
	public Entry getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entry> getEntries(int numberOfEntries) {
		return entries.subList(0, 10);
	}

	@Override
	public boolean exists(Entry entry) {
		return this.entries.contains(entry);
	}

	

}
