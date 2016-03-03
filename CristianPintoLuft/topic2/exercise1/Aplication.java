import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Aplication {

	private ArrayList<String> recentFileList = new ArrayList<String>();
	private final String recentFilePath = "src/recent-file-list";

	public void run() {
		try {
			String line;
			BufferedReader br = new BufferedReader(new FileReader(recentFilePath));
			while ((line = br.readLine()) != null) {
				recentFileList.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getRecentFileList() {
		return recentFileList;
	}

	public void openFile(String file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.close();

			if (!recentFileList.contains(file))
				recentFileList.add(file);
			else {
				recentFileList.remove(file);
				recentFileList.add(0, file);
			}

			if (recentFileList.size() > 15) {
				recentFileList.remove(recentFileList.size() - 1);
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(recentFilePath));
			for (String f : recentFileList) {
				bw.append(f);
				bw.newLine();
			}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
