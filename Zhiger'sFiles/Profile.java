import java.util.*;
public class Profile {
    protected String name, password, email;
    protected MyPage myWall;
    protected ArrayList<Profile> followers;
    protected ArrayList<Profile> followings;
    protected boolean activation;
    public Profile(String name, String password, String email, boolean activation){
        this.name = name;
        this.password = password;
        this.email = email;
        this.myWall = new MyPage();
        this.activation = activation;
        this.followings = new ArrayList<>();
        this.followers = new ArrayList<>();

    }
    public String toString() {
        return "user: " + this.name;
    }
    public void writePost() {
        Scanner sc = new Scanner(System.in);
        Date d = new Date();
        System.out.println("Your post : ");
        Post post = new Post(this, d, sc.nextLine());
        this.getMyWall().getMyPosts().add(post);
    }
    public void writeComment(){
        Scanner sc = new Scanner(System.in);
        Date d = new Date();
        System.out.println("Your comment : ");
        String comm = sc.nextLine();

    }
    public void displayFriends() {
        for (int i = 0; i < this.followings.size(); i++)
            System.out.println(i + ". " + this.followings.get(i).getName());
    }
    public MyPage displayFriendWall() {
        Scanner sc = new Scanner(System.in);
        int choice;
        if (!this.followings.isEmpty()) {
            displayFriends();
            System.out.println("Choose a friend: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }
            if (choice > -1 && choice < this.followings.size()) {
                return this.followings.get(choice).getMyWall();
            } else
                System.out.println("Invalid input.");
        } else
            System.out.println("You have no friend.");
        return null;

    }


    public void follow(Profile me, Profile receiver){
        if(!this.followings.contains(receiver)){
            this.getFollowings().add(receiver);
            receiver.getFollowers().add(me);
            System.out.println("You successfully followed");
        }else
            System.out.println("Already your follow");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public MyPage getMyWall() {
        return myWall;
    }
    public void setMyWall(MyPage post){
        this.myWall = myWall;
    }
    public boolean getActivation() {
        return activation;
    }
    public void setActivation(boolean activation) {
        this.activation = activation;
    }
    public ArrayList<Profile> getFollowers(){return this.followers;}
    public void setFollowers(ArrayList<Profile> followers){this.followers = followers;}
    public ArrayList<Profile> getFollowings(){return this.followings;}
    public void setFollowings(ArrayList<Profile> followings){this.followings = followings;}
}