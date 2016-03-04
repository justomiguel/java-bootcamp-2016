package bootcamp.topic2.blogtdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import bootcamp.topic2.blogtdd.Blog;

public class BlogTest {
	
	Blog blog;
	Entry entry, entry1, entry2, entry3, entry4;
	Entry entry5, entry6, entry7, entry8, entry9;
	static EntryDAO entryDAO;
	
	@BeforeClass
	public static void setUpClass() {
		entryDAO = new EntryDAOFakeImplementation();
	}
	
	@Before
	public void setUp() {
		blog = new Blog();
		entry = new Entry("Primer titulo", "lala.jpg", "0 Text");
		entry1 = new Entry("Segundo titulo", "lala.jpg", "1 text");
		entry2 = new Entry("Tercer titulo", "lala.jpg", "2 text");
		entry3 = new Entry("Cuarto titulo", "lala.jpg", "3 text");
		entry4 = new Entry("Quinto titulo", "lala.jpg", "4 text");
		entry5 = new Entry("Sexto titulo", "lala.jpg", "5 text");
		entry6 = new Entry("Septimo titulo ", "lala.jpg", "6 text");
		entry7 = new Entry("Octavo titulo", "lala.jpg", "7 text");
		entry8 = new Entry("Noveno titulo", "lala.jpg", "8 text");
		entry9 = new Entry("Decimo titulo", "lala.jpg", "9 text");
	}
	
	@Test
	public void postNewEntry() {
		blog.addNewEntry(entry, entryDAO);
		assertTrue(blog.exists(entry, entryDAO));
	}
	
	@Test
	public void deleteExistingEntry() {
		blog.deleteEntry(entry, entryDAO);
		assertFalse(blog.exists(entry, entryDAO));
	}
	
	@Test
	public void showTenMostRecentEntries() {
		List<Entry> list = new ArrayList<Entry>();
		list.add(0, entry);
		list.add(0, entry1);
		list.add(0, entry2);
		list.add(0, entry3);
		list.add(0, entry4);
		list.add(0, entry5);
		list.add(0, entry6);
		list.add(0, entry7);
		list.add(0, entry8);
		list.add(0, entry9);
		
		blog.addNewEntry(entry, entryDAO);
		blog.addNewEntry(entry1, entryDAO);
		blog.addNewEntry(entry2, entryDAO);
		blog.addNewEntry(entry3, entryDAO);
		blog.addNewEntry(entry4, entryDAO);
		blog.addNewEntry(entry5, entryDAO);
		blog.addNewEntry(entry6, entryDAO);
		blog.addNewEntry(entry7, entryDAO);
		blog.addNewEntry(entry8, entryDAO);
		blog.addNewEntry(entry9, entryDAO);
				
		assertArrayEquals(list.toArray(), blog.getMostRecent(entryDAO).toArray());
		
		
	}

}
