package exercise2;


public class Post{
	
	private String title;
	private String description;
	private String author;
	
	public Post(String title,String description,String author) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.description = description;
		this.author = author;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
