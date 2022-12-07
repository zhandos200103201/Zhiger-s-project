import java.util.*;
public class Post {
    protected Profile sender;
    protected Date date;
    protected String content;
    protected ArrayList<String> comments;
    protected int likes;


    public Post(Profile sender, Date date, String content) {
        this.sender=sender;
        this.date=date;
        this.content=content;
        this.comments = new ArrayList<>();
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

    public ArrayList<String> getComment(){return comments;}

    public String getAllComments(){
        String allComments  = "";
        int i = 1;
        for (String comment : comments){
            allComments += "Comment " + i+ ": " + comment + ";\t";
            i++;
        }
        return  allComments;
    }

    public void setComment(ArrayList<String> comment){this.comments=comment;}
    public void putLike(){this.likes = likes+1;}
    public void addComment(String a){
        this.comments.add(a);
    }
    public  int getLikes(){return likes;}

    public  void setLikes(int likes){this.likes = likes;}

// you should adding toSortByLike and toSortByNumberOfComments

}


