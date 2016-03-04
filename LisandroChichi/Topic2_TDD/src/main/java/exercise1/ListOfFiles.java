package exercise1;

import java.util.ArrayList;

public class ListOfFiles {

	public void addNoDumplicates(ArrayList<String> actualList, String element) {
		int cont = 0;
		if(actualList.size()>0){
		for (int i = 1; i < actualList.size()+1; i++) {
			
			
			if (actualList.get(i-1).equals(element)) {
				cont = cont +1;
			}
		}
		if (cont == 0) {
			actualList.add(element);
		}
		}else{
		actualList.add(element);
		}

	}

	public void OutOfRange(ArrayList<String> actualList, int var) {
		
		
		
			
			actualList.set(var, actualList.get(actualList.size()-1));
			actualList.remove(actualList.size()-1);

		
	}

	public void Show(ArrayList<String> actualList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < actualList.size(); i++) {

			System.out.println("{" + actualList.get(i).toLowerCase() + "}");

		}
	}

	public void ReplaceOlderFile(ArrayList<String> actualList, ListOfFiles lof,int var) {
		if (actualList.size() > 3) {
			lof.OutOfRange(actualList, var);
			var++;
		}
		if (var == actualList.size()) {
			var = 0;
		}
		
	}

}
