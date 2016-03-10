package topic2EJ1;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RecentFileListTest {

	File Test1 = new File ("Test1", "Testing the creation of a first file");
	File Test2 = new File ("Test2","Testing the creation of a second file");
	File Test3 = new File ("Test3","Testing the creation of a third file");
	
	static List<File> filesNames = new ArrayList <File> ();
	static List<File> filesNamesAux = new ArrayList <File> ();
	
	@Test
	public void WhenANewFileThenInsertIntoTheArrayList (){
		String comprobation = "Does not exist";
		
		if (comprobation.equals("Does not exist") ){
			filesNames.add(Test1);
			filesNames.add(Test2);
			filesNames.add(Test3);
			WhenANewFileOpenThenOrderIt();
			if (filesNames.size()>5){
				WhenListIsFullThenRemoveTheLast ();
			}
		}else{
			WhenANewFileOpenThenOrderIt();
		}

	}
	
	@Test
	public void WhenListIsFullThenRemoveTheLast() {
		// TODO Auto-generated method stub
		filesNames.remove(filesNames.size()-1);
	}

	@Test
	public void WhenANewFileOpenThenOrderIt(){
		int index2 = 0;
		filesNamesAux = filesNames;
		filesNames.add(0, filesNamesAux.get(index2));
		filesNames.remove(index2+1);
	}
	
	
	@Test
	public void WhenAddANewFileInTheArrayThenVerifyIfItExist (){
		String msj = "Does not exist";
		
		for (int i = 0; i < filesNames.size(); i++) {
		      if (Test1.equals(filesNames.get(i).getName()) ){
		    	  msj = "Exist";
		      }
		}
		
		if (msj.equals("Exist")){
			Error ExistIntoArray = new Error ("The file exist into the array list");
			throw ExistIntoArray;
		}
		
		
	}
	
	@Test
	public void WhenNeedToShowListThenShowArrayList () {
		if (filesNames.isEmpty()){
			//System.out.println("The recent file list is empty");
			
		}else {
			for (int i = 0; i < filesNames.size(); i++) {
				//System.out.println ((i+1) + ")" + filesNames.get(i).GetName());
			}
		}
	}
}
