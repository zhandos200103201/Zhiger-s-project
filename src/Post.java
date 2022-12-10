import java.io.Serializable;
import java.util.Date;

public class Post {
	protected Profile sender;
	protected Date date;
	protected String content;
	protected MyArrayList<String> comments;
	protected int likes;


	public Post(Profile sender, Date date, String content) {
		this.sender=sender;
		this.date=date;
		this.content=content;
		this.comments = new MyArrayList<>();
		this.likes = 0;
	}


	public Profile getSender() {
		return sender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date=date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content=content;
	}

	public MyArrayList<String> getComment(){return comments;}

	public String getAllComments(){
		String allComments  = "";
		int i = 1;
		for (String comment : comments){
			allComments += "Comment " + i+ ": " + comment + ";\t";
			i++;
		}
		return  allComments;
	}

	public void setComment(MyArrayList<String> comment){this.comments=comment;}
	public void putLike(){this.likes = likes+1;}
	public void addComment(String a){
		this.comments.add(a);
	}
	public  int getLikes(){return likes;}

	public  void setLikes(int likes){this.likes = likes;}

}
