package bootcamp.topic2.tdd;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import bootcamp.topic2.tdd.RecentFileList;

public class RecentFileListTest {
	
	private RecentFileList listFile; 
	
	@Before
	public void SetUp(){
		listFile = new RecentFileList();
	}
	
	@Test
	public void whenFirstRunListEmpty() {
		assertEquals(0, listFile.size());
	}
	
	
	@Test
	public void whenAFileIsOpenedItIsAdded() {
		listFile.addFile("New File");
		assertTrue(listFile.exists("New File"));
	}
	
	@Test
	public void whenAFileAlreadyExistGotoTheTop() {
		
		listFile.addFile("New File");
		final int size = listFile.size();
		listFile.addFile("New File");
		assertEquals("New File", listFile.getTopFile());
		assertEquals(size, listFile.size());
		
	}
	
	@Test
	public void whenTheListIsFullTheOlderIsRemoved() {
		for (int i = 0; i < 15; i++) {
			listFile.addFile("New File " + i);
		}
		final int size = listFile.size();
		listFile.removeLast();
		listFile.addFile("NewNew File");
		assertEquals(size, listFile.size());
		assertEquals("NewNew File", listFile.getTopFile());
	}
	
}


