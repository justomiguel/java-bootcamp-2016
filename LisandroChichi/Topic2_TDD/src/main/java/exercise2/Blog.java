package exercise2;

import java.util.ArrayList;

public interface Blog {

	public boolean addPost(Post post);

	public String deletePost(int a);

	public ArrayList<Post> showRecentPosts();
}
