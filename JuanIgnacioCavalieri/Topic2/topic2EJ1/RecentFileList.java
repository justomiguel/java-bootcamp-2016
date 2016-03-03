package topic2EJ1;
import java.util.*;

public class RecentFileList {
	
	static List<File> filesNames = new ArrayList <File> ();
	static List<File> filesNamesAux = new ArrayList <File> ();
	private static int index = 0;
	
	
	//Add a new file into the array
	public static void newFileIntoArray (File fileComprobation){
		String nameComprobation = fileComprobation.GetName();
		String comprobation = FileExistIntoArray (nameComprobation);
			
		if (comprobation.equals("Does not exist") ){
			filesNames.add(fileComprobation);
			OrderArray (filesNames.size()-1);
			if (filesNames.size()>5){
				filesNames.remove(filesNames.size()-1);
			}
			
		}else{
			OrderArray (index);
		}
			
	}
	
	//Re-order the Recent file list when a new file is open
	private static void OrderArray(int index2) {
		// TODO Auto-generated method stub
		filesNamesAux = filesNames;
		filesNames.add(0, filesNamesAux.get(index2));
		filesNames.remove(index2+1);

	}

	//Control if exist the object into the array
	private static String FileExistIntoArray (String nameFile){
		String msj = "Does not exist";
		try {
			for (int i = 0; i < filesNames.size(); i++) {
				if (nameFile.equals(filesNames.get(i).GetName()) ){
					msj = "Exist";
					index = i;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			msj = "Does not exist";
		}
			
		return msj;
	}
	
	//Show list
	public static void ShowList (){
		System.out.println("Recent file list");
		
		if (filesNames.isEmpty()){
			// TODO: handle exception
			System.out.println("The recent file list is empty");
			
		}else {
			for (int i = 0; i < filesNames.size(); i++) {
				System.out.println ((i+1) + ")" + filesNames.get(i).GetName());
			}
		}
		
	}

}
