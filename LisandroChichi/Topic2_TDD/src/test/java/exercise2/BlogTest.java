package exercise2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BlogTest {
	Scanner sc = new Scanner(System.in);
	ArrayList<Post> listPosts = new ArrayList<Post>();
	BlogDao blogDao = new BlogDao();
	Blog mockBlog = mock(Blog.class);
	int cont = 5;

	@Before
	public void setUp() {

		Post post1 = new Post(
				"Lunes",
				"Lunes es el segundo día de la semana en el calendario gregoriano, y primero de la semana laboral",
				"Lisandro");
		Post post2 = new Post(
				"Martes",
				"El martes es el segundo o tercer día de la semana, según el país o cultura.",
				"Lisandro");
		Post post3 = new Post(
				"Miercoles",
				"El miércoles era el cuarto día de la semana en la cultura cristiana original (siendo el primero el domingo) y es el tercero en las nuevas culturas.",
				"Lisandro");
		Post post4 = new Post(
				"Jueves",
				"El jueves es el cuarto día de la semana. Sigue al miércoles y precede al viernes. El nombre de «jueves» proviene del latín Jovis díes, o «día de Júpiter».",
				"Lisandro");
		Post post5 = new Post(
				"Viernes",
				"El viernes es el quinto día de la semana. El nombre de «viernes» proviene del latín Veneris dies; 'día de Venus' (la diosa de la belleza y el amor en la mitología romana, en la mitología nórdica esa diosa se llama Freyja).",
				"Lisandro");
		Post post6 = new Post(
				"Enero",
				"Enero (del latín ianuarius--> janairo --> janero --> enero) es el primer mes del año en el calendario gregoriano y tiene 31 días. Toma su nombre del dios Jano, del latín Janus, representado con dos caras, el espíritu de las puertas y del principio y el final",
				"Lisandro");
		Post post7 = new Post(
				"Febrero",
				"Febrero es el segundo mes del año en el calendario gregoriano. Tiene 28 días y 29 en los años bisiestos. ",
				"Lisandro");
		Post post8 = new Post(
				"Marzo",
				"Marzo es el tercer mes del año en el calendario gregoriano y tiene 31 días. Su nombre deriva del latín Martius, que era el primer mes del calendario romano",
				"Lisandro");
		Post post9 = new Post(
				"Abril",
				"Abril es el cuarto mes del año juliano y gregoriano y es uno de los cuatro meses que tienen 30 días",
				"Lisandro");
		Post post10 = new Post(
				"Mayo",
				"Mayo es el quinto mes del año en el calendario gregoriano y tiene 31 días; pero era el tercer mes en el antiguo calendario romano donde enero y febrero estaban al final del año.",
				"Lisandro");
		Post post11 = new Post(
				"Junio",
				"Junio (del latín Iunius, mes de Juno) es el sexto mes del año en el Calendario Gregoriano y tiene 30 días.",
				"Lisandro");

		listPosts.add(post1);
		listPosts.add(post2);
		listPosts.add(post3);
		listPosts.add(post4);
		listPosts.add(post5);
		listPosts.add(post6);
		listPosts.add(post7);
		listPosts.add(post8);
		listPosts.add(post9);
		listPosts.add(post10);
		listPosts.add(post11);
		mockBlog.deletePost(0);

		verify(mockBlog, times(1)).deletePost(0);// It is shown that has been
													// used once the method
													// deletePost()

		// My App starts HERE

		System.out.println("Seleccione una opcion");
		System.out.println("Agregar post -- Seleccione '1'");
		System.out.println("Eliminar post -- Seleccione '2'");
		System.out
				.println("Mostrar los 10 posts mas recientes -- Seleccione '3'");
		System.out.println("Seleccione '4' para SALIR \n");
		int res = sc.nextInt();

		while (res != 4) {

			if (res == 1) {
				blogDao.addPosts(sc, listPosts, mockBlog);
				cont++;

				System.out.println("Agregar post -- Seleccione '1'");
				System.out.println("Eliminar post -- Seleccione '2'");
				System.out.println("Mostrar posts -- Seleccione '3'");
				System.out.println("Seleccione '4' para SALIR \n");
				res = sc.nextInt();
			}

			else if (res == 2) {
				if(listPosts.size()>0){
				blogDao.deletePosts(sc, listPosts, mockBlog);
				}else
				{
					System.out.println("no hay posts en el blog");
				}
				cont--;
				System.out.println("Agregar post -- Seleccione '1'");
				System.out.println("Eliminar post -- Seleccione '2'");
				System.out.println("Mostrar posts -- Seleccione '3'");
				System.out.println("Seleccione '4' para SALIR \n");
				res = sc.nextInt();

			} else if (res == 3) {

				blogDao.showPosts(listPosts, sc, mockBlog);

				System.out.println("\n");
				System.out.println("Agregar post -- Seleccione '1'");
				System.out.println("Eliminar post -- Seleccione '2'");
				System.out.println("Seleccione '4' para SALIR \n");
				res = sc.nextInt();
			}
		}

	}

	@Test
	public void ListIsNotEmpty() {
		assertFalse(listPosts.isEmpty());
		assertEquals(cont, listPosts.size());
		assertNotNull(listPosts);
		

	}

	@After
	public void tearDown() {
		listPosts = null;
		mockBlog = null;
	}

}
