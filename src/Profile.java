import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

import java.io.*;
import java.util.*;
public class Profile {

	protected String name, password, email;
	protected MyPage myWall;
	protected MyArrayList<Profile> followers;
	protected MyArrayList<Profile> followings;
	protected MyArrayList<Profile> blockedPeople;
	protected boolean activation;
	public Profile(String name, String password, String email, boolean activation){
		this.name = name;
		this.password = password;
		this.email = email;
		this.myWall = new MyPage();
		this.activation = activation;
		this.followings = new MyArrayList<>();
		this.followers = new MyArrayList<>();
		this.blockedPeople = new MyArrayList<>();
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

	public void unfollow(Profile me, Profile receiver){
		if(this.followings.contains(receiver)){
			this.getFollowings().remove(receiver);
			receiver.getFollowers().remove(me);
			System.out.println("You successfully unfollowed");
		}else
			System.out.println("Already your unfollow");
	}

	public void follow(Profile me, Profile receiver){
		if(!getFollowings().contains(receiver) && !getBlockedPeople().contains(receiver)){
			getFollowings().add(receiver);
			receiver.getFollowers().add(me);
			System.out.println("You successfully followed");
		}else
			System.out.println("Already your follow");
	}
	public void block(Profile receiver){
		if(!this.blockedPeople.contains(receiver)){
			this.getBlockedPeople().add(receiver);
			System.out.println(receiver.getName()+" is successfully blocked!");
		}else
			System.out.println(receiver.getName() + " is already blocked!");
	}
	public void unblock(Profile receiver){
		if(this.blockedPeople.contains(receiver)){
			this.getBlockedPeople().remove(receiver);
			System.out.println(receiver.getName()+" is successfully unblocked!");
		}else
			System.out.println(receiver.getName() + " is already unblocked!");
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
	public MyArrayList<Profile> getFollowers(){return this.followers;}
	public MyArrayList<Profile> getBlockedPeople(){return this.blockedPeople;}
	public void setFollowers(MyArrayList<Profile> followers){this.followers = followers;}
	public MyArrayList<Profile> getFollowings(){
		return this.followings;
	}
//	public void setBlockedPeople(MyArrayList<Profile> BlockedPeople){this.BlockedPeople = BlockedPeople;}

	public String getFollowingsToString(){
		String followersTostring = "";
		for (int i = 0; i < getFollowings().size(); i++) {
			followersTostring += (i+1) + ". " + followings.get(i)+";\n";
		}
		return followersTostring;
	}
	public String getBlockedUsersToString(){
		String blockedUsersTostring = "";
		for (int i = 0; i < getBlockedPeople().size(); i++) {
			blockedUsersTostring += (i+1) + ". " + getBlockedPeople().get(i)+";\n";
		}
		return blockedUsersTostring;
	}
	public void getUnBlockedUsersToString(HashMap<String, Profile> allRegisteredUsers){
		var ref = new Object() {
			int i = 1;
		};
		allRegisteredUsers.forEach((key, value) -> {
			if(!getBlockedPeople().contains(value) && !getName().equals(value.getName())) {
				System.out.println(ref.i + ". Username: " + value.getName() + "; \n   E-mail: " + key + ";");
				ref.i++;
			}
		});
	}
	public int getNumOfUnBlockedUsers(HashMap<String, Profile> allRegisteredUsers){
		var ref = new Object() {
			int i = 1;
		};
		allRegisteredUsers.forEach((key, value) -> {
			if(!getBlockedPeople().contains(value) && getName() != value.getName()) {
				System.out.println(ref.i + ". Username: " + value.getName() + "; \n   E-mail: " + key + ";");
				ref.i++;
			}
		});
		return ref.i;
	}
	public void setFollowings(MyArrayList<Profile> followings){this.followings = followings;}


}