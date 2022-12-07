import java.io.*;
import java.util.*;

public class App{


    protected HashMap<String, Profile> registeredUsers;
    protected Profile currentUser;

    public App() {
        this.registeredUsers = new HashMap<String, Profile>();
        this.currentUser = null;
    }

    public App(HashMap<String, Profile> list) {
        this.registeredUsers = list;
    }

    public void DisplayRegisteredUsers() {
        if (!registeredUsers.isEmpty()) {
            int i = 0;
            for (Profile p : registeredUsers.values()) {
                System.out.print("User #"+i+++"\n");
                System.out.println(p);
            }
        } else
            System.out.println("No session recorded.");
    }

    public void friendOfFriend(Profile p,int depth, HashSet<Profile> alreadySeen, String tab){
        if(depth<0)
            return;
        else{
            int i=0;
            for(Profile friend : p.getFollowers()){
                System.out.println(tab+i+++") "+friend.getName());
                if(!alreadySeen.contains(friend)){
                    alreadySeen.add(friend);
                    friendOfFriend(friend, depth-1, alreadySeen, tab+"\t");
                }
            }
        }
    }

    public int getUsersNumbers() {
        return this.registeredUsers.size();
    }

    public void createAccount() {
        // ask the user for all the informations
        Scanner sc = new Scanner(System.in);
        System.out.println("To create a new account, enter the following informations:");
        System.out.println("enter your name");
        String name = sc.nextLine();
        System.out.println("create password");
        String password = sc.nextLine();
        System.out.println("email? ");
        String email = sc.nextLine();
        Profile newProfile = new Profile(name, password, email, true);

        // check if the person is already on the network
        if (registeredUsers.get(email) == null) {
            registeredUsers.put(email, newProfile);
            System.out.println("Account created with success!");
        } else
            System.out.println("The user is already registered");
    }

    public void openSession(String email_in, String password_in) {
        Profile tmp = registeredUsers.get(email_in);
        if (tmp == null)
            System.out.println("Incorrect email.");
        else if (!tmp.getPassword().equals(password_in))
            System.out.println("Incorrect password.");
        else if (tmp.getActivation() == false)
            System.out.println("The account has not yet been activated.");
        else {
            System.out.println("User identified.");
            System.out.println("Welcome, " + tmp.getName() + "!");
            currentUser = tmp;
        }
    }

    public void closeSession() {
        currentUser = null;
    }

    public void activateAccount(String email_in, String password_in) {
        Profile tmp = registeredUsers.get(email_in);
        if (tmp == null)
            System.out.println("Incorrect email.");
        else if (!tmp.getPassword().equals(password_in))
            System.out.println("Incorrect password.");
        else if (tmp.getActivation() == true)
            System.out.println("The account is already activated.");
        else {
            tmp.setActivation(true);
            System.out.println("Your account has been activated.");
        }
    }

    public void deactivateAccount(String email_in, String password_in) {
        Profile tmp = registeredUsers.get(email_in);
        if (tmp == null)
            System.out.println("Incorrect email.");
        else if (!tmp.getPassword().equals(password_in))
            System.out.println("Incorrect password.");
        else if (tmp.getActivation() == false)
            System.out.println("The account is already inactivated.");
        else {
            tmp.setActivation(false);
            System.out.println("Your account has been deactivated.");
        }
    }

    public Profile search(String name, String surname) {
        LinkedList<Profile> tmp = new LinkedList<Profile>();
        tmp.addAll(registeredUsers.values());
        Profile found = null;
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).getName() == name) {
                found = tmp.get(i);
            }
        }
        return found;
    }

    public Profile getCurrentUser() {
        return currentUser;
    }

    public HashMap<String, Profile> getRegisteredUsers() {
        return registeredUsers;
    }


}