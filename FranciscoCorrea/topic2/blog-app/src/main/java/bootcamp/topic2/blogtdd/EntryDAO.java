package bootcamp.topic2.blogtdd;

import java.util.List;

public interface EntryDAO {
	public void insert(Entry entry);
	public void delete(Entry entry);
	public Entry getById(int id);
	public List<Entry> getEntries(int numberOfEntries);
	public boolean exists(Entry entry);
}
