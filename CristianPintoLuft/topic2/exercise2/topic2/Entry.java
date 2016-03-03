package topic2;

public class Entry {
	String title;
	String body;

	public Entry(String title, String body) {
		this.title = title;
		this.body = body;
	}
	
	public String toString()
	{
		return String.format("Title: %s, body: %s", title, body);
	}

}
