package bootcamp.topic2.blogtdd;

public class Entry {
	private String title;
	private String image;
	private String text;
	
	public Entry(String t, String i, String txt) {
		this.title = t;
		this.image = i;
		this.text = txt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
