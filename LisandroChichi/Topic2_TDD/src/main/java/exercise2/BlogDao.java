package exercise2;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Scanner;

public class BlogDao {

	public void addPosts(Scanner sc, ArrayList<Post> listPosts,Blog mockBlog) {
		
		System.out.println("Ingrese titulo \n");
		
		String title = sc.next();
		System.out.println("Ingrese descripcion \n");
		
		String description = sc.next();
		
		System.out.println("Ingrese author \n");
		String author = sc.next();
		
		Post post = new Post(title, description, author);
		when(mockBlog.addPost(post)).thenReturn(listPosts.add(post));
	}

	public void deletePosts(Scanner sc, ArrayList<Post> listPosts,Blog mockBlog) {
		// TODO Auto-generated method stub
		System.out.println("Selecciona el lugar del post que deseas eliminar");
		for (int i = 0; i < listPosts.size(); i++) {

			String out ="Lugar "+i+"- "+ listPosts.get(i).getTitle()+ ": "+listPosts.get(i).getDescription();
			System.out.println(out);
			
		}
		int pos = sc.nextInt();
		while(pos > listPosts.size()-1){
			System.out.println("numero muy grande, ingrese uno mas chico");
			pos = sc.nextInt();
		}
		when(mockBlog.deletePost(pos)).thenReturn(listPosts.remove(pos).getTitle());
		System.out.println("Elemento de la posicion "+ pos +" eliminado");
	}

	public void showPosts(ArrayList<Post> listPosts,Scanner sc,Blog mockBlog) {
		// TODO Auto-generated method stub
		if (listPosts.size() < 11) {
			for (int i = 0; i < listPosts.size(); i++) {

				String out = listPosts.get(i).getTitle()+ ": "+listPosts.get(i).getDescription();
				System.out.println(out);
				
			}

		} else {
			for (int i = listPosts.size() - 10; i < listPosts.size(); i++) {
				String out = listPosts.get(i).getTitle()+ ": "+listPosts.get(i).getDescription();
				System.out.println(out);
			}

			
		}
	}
	

	
}
