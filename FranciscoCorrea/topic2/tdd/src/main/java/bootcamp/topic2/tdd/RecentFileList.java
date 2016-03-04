package bootcamp.topic2.tdd;

import java.util.ArrayList;
import java.util.List;

public class RecentFileList {
	private List<String> listFile;


	public RecentFileList() {
		this.listFile = new ArrayList<String>();
	}
	
	public int size() {
		return this.listFile.size();
	}
	
	public void addFile(String file) {
		if(this.size() == 15) {
			this.removeLast();
		}
		if(this.exists(file)) {
			final int indexOf = this.listFile.indexOf(file);
			this.listFile.remove(indexOf);
		}
		this.listFile.add(0, file);
	}
	
	public boolean exists(String file) {
		return this.listFile.contains(file);
	}
	
	public String getTopFile() {
		return this.listFile.get(0);
	}
	
	public void removeLast() {
		this.listFile.remove(14);
	}
	
	
	
	
	
	
	
	
}
