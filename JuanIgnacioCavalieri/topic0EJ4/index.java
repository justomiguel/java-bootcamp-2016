package topic0EJ4;

import topic2EJ2.Blog;

public class Index {
	public static void main(String[] args) {

		//HEADING
		System.out.println("Exercise number four from Topic 0 of Java-bootcamp ");
		System.out.println("");
				
		//Show a database with all attributes
		System.out.println("TEST: A database with all attributes");
		
		BD1Builder DB1 = new BD1Builder();
		DB db1 = new BDBuilder(DB1.getURL(), DB1.getUser(), DB1.getPass())
				.setDescription(DB1.setDescription())
				.build();
		
		System.out.println(db1);
		
		
		
		
		//Show a database with no description
		System.out.println("");
		System.out.println("TEST: A database with no description");
		BD2Builder DB2 = new BD2Builder();
		DB db2 = new BDBuilder(DB2.getURL(), DB2.getUser(), DB2.getPass())
				//.setDescription(DB2.setDescription())
				.build();
		
		System.out.println(db2);
	}
}
