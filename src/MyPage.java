import java.io.Serializable;
import java.util.ArrayList;

public class MyPage {

	private MyArrayList<Post> myPosts;

	public MyPage() {
		this.myPosts=new MyArrayList<Post>();
	}

	public MyPage(MyArrayList<Post> list) {
		this.myPosts=list;
	}

	public void addPost(Post post){
		myPosts.add(post);
	}

	public String toString() {
		String toReturn="";
		if(myPosts.isEmpty()) {
			toReturn+="no posts yet";
		}else
			for(int i=0; i<myPosts.size(); i++)
				toReturn+="\nCreated at: "+ myPosts.get(i).getDate()+"\nCreated By: "+ myPosts.get(i).getSender().getName()+
						"\nPost: "+myPosts.get(i).getContent()+"\n"  + "Likes: " + myPosts.get(i).getLikes() + "\t" + myPosts.get(i).getAllComments();


		return toReturn;
	}

	public void deletePost(Post post) {
		for(int i=0; i<myPosts.size(); i++) {
			if(myPosts.get(i)==post) {
				myPosts.remove(i);
			}
		}
	}

	public MyArrayList<Post> getMyPosts() {
		return myPosts;
	}
	public String getMyPostsWithId(int i) {
		return "\nCreated at: "+ myPosts.get(i).getDate()+"\nCreated By: "+ myPosts.get(i).getSender().getName()+
				"\nPost: "+myPosts.get(i).getContent()+"\n"  + "Likes: " + myPosts.get(i).getLikes() + "\t" + myPosts.get(i).getAllComments();
	}



	public void setMyPosts(MyArrayList<Post> myPosts) {
		this.myPosts = myPosts;
	}

}
