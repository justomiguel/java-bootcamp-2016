package topic2;

import static org.junit.Assert.*;

import org.junit.Test;

public class _BlogTester {
	@Test
	public void postNewEntry() {
		Blog blog = new Blog("My Blog");
		String title = "My first entry!";
		String body = "Hello world, this is who I'm";
		Entry entry = new Entry(title, body);
		assertEquals(true, blog.post(entry));
	}

	@Test
	public void deleteExistingEntry() {
		Blog blog = new Blog("My Blog");
		String title = "My first entry!";
		String body = "Hello world, this is who I'm";
		Entry entry = new Entry(title, body);
		assertEquals(true, blog.delete(entry));
	}

	@Test
	public void showTenMoreRecentEntries() {
		Blog blog = new Blog("My Blog");

		for (int i = 0; i < 20; i++) {
			String title = "Entry number " + String.valueOf(i);
			String body = "Another entry...";
			Entry entry = new Entry(title, body);
			blog.post(entry);
		}

		int totalEntries = blog.entries.size() - 1;
		int displayedEntries = 0;

		for (int j = totalEntries; j >= 10; j--) {
			//System.out.println(blog.entries.get(j).toString());
			displayedEntries++;
		}

		assertEquals(10, displayedEntries);
	}
}
