import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class _RecentFileListTester {

	@Test
	public void firstTimeRun() {
		Aplication app = new Aplication();
		app.run();
		ArrayList<String> nullList = new ArrayList<String>();
		assertEquals(nullList, app.getRecentFileList());
	}

	@Test
	public void openFile() {
		Aplication app = new Aplication();
		app.run();
		app.openFile("src/hello.txt");
		ArrayList<String> oneItemList = new ArrayList<String>();
		oneItemList.add("src/hello.txt");
		assertEquals(oneItemList, app.getRecentFileList());
	}

	@Test
	public void openFile2() {
		Aplication app = new Aplication();
		app.run();
		app.openFile("src/hello2.demo");
		ArrayList<String> twoItemList = new ArrayList<String>();
		twoItemList.add("src/hello.txt");
		twoItemList.add("src/hello2.demo");
		assertEquals(twoItemList, app.getRecentFileList());
	}

	@Test
	public void fileAlreadyExists() {
		Aplication app = new Aplication();
		app.run();
		app.openFile("src/hello2.demo");
		ArrayList<String> twoItemList = new ArrayList<String>();
		twoItemList.add("src/hello2.demo");
		twoItemList.add("src/hello.txt");
		assertEquals(twoItemList, app.getRecentFileList());
	}

	@Test
	public void maxLengthFileList() {
		Aplication app = new Aplication();
		app.run();
		for (int i = 0; i < 20; i++) {
			app.openFile("files/hello" + String.valueOf(i));
		}
		ArrayList<String> fullItemList = new ArrayList<String>();
		for (int i = 0; i < 15; i++) {
			fullItemList.add("files/hello" + String.valueOf(i));
		}
		assertEquals(fullItemList.size(), app.getRecentFileList().size());
	}
}
