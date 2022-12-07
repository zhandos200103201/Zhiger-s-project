import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String []args) {
        int choice,choice2,choice3;
        String email_in, password_in;
        Scanner sc = new Scanner(System.in);
        App app = new App();
        System.out.println("Welcome");
        do {
            System.out.println("What do you want to do?");
            System.out.println("1 Create account");
            System.out.println("2 Open session");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }
            switch (choice) {
                case (1):
                    app.createAccount();
                    break;
                case (2):
                    System.out.println("Please enter your email and your password:");
                    System.out.println("Email? ");
                    email_in = sc.nextLine();
                    System.out.println("Password?");
                    password_in = sc.nextLine();
                    app.openSession(email_in, password_in);
                    if (app.getCurrentUser() != null) {
                        do {
                            System.out.println("1 Publish Post");
                            System.out.println("2 See the list of your followers");
                            System.out.println("3 See the list of your followings");
                            System.out.println("5 start following");
//                            System.out.println("6 Cancel an invitation sended");
//                            System.out.println("7 View your invitation list");
                            System.out.println("8 See your wall");
                            System.out.println("9 See a friend's wall");
                            System.out.println("10 See the friend of yours friends");
                            System.out.println("11 Log out");
                            try {
                                choice2 = Integer.parseInt(sc.nextLine());
                            } catch (Exception e) {
                                choice2 = -1;
                            }
                            switch (choice2) {
                                case 1:
                                    app.getCurrentUser().writePost();
                                    break;

                                case 2:
                                    System.out.println(app.getCurrentUser().getFollowers());
                                case 3:
                                    System.out.println(app.getCurrentUser().getFollowings());
                                    break;
//                                case 4:
//                                    app.getCurrentUser().displayFriendProfile();
//                                    break;
                                case 5:
                                    System.out.println("Enter the email for follow");
                                    Profile p = app.getRegisteredUsers().get(sc.nextLine());
                                    if (p != null) {
                                        app.getCurrentUser().follow(app.getCurrentUser(), p);
                                    } else
                                        System.out.println("Doesn't exist");
                                    break;
//                                case 6:
//                                    app.getCurrentUser().cancelInvitation();
//                                    break;
//                                case 7:
//                                    app.getCurrentUser().acceptInvitation();
//                                    break;
                                case 8:
                                    MyPage mypage = app.getCurrentUser().getMyWall();
                                    int currentIndex = 0;
                                    boolean exit = true;
                                    while (exit){
                                        if(currentIndex == 0) {
                                            System.out.println(mypage.getMyPostsWithId(currentIndex));
                                            System.out.println("L = Like \t C = Comment \t N = next \t E = Exit");
                                            char choiceOfAction = sc.nextLine().toLowerCase().charAt(0);
                                            switch (choiceOfAction){
                                                case 'l': mypage.getMyPosts().get(currentIndex).putLike(); break;
                                                case 'c': mypage.getMyPosts().get(currentIndex).addComment(sc.nextLine()); break;
                                                case 'n': currentIndex++; break;
                                                case 'e': exit = false; break;
                                            }
                                        } else if(currentIndex > 0 && currentIndex < mypage.getMyPosts().size()-1){
                                            System.out.println(mypage.getMyPostsWithId(currentIndex));
                                            System.out.println("L = Like \t C = Comment \t P = previous \t N = next \t E = Exit");
                                            char choiceOfAction = sc.nextLine().toLowerCase().charAt(0);
                                            switch (choiceOfAction){
                                                case 'l': mypage.getMyPosts().get(currentIndex).putLike(); break;
                                                case 'c': mypage.getMyPosts().get(currentIndex).addComment(sc.nextLine()); break;
                                                case 'p': currentIndex--; break;
                                                case 'n': currentIndex++; break;
                                                case 'e': exit = false; break;
                                            }
                                        } else {
                                            System.out.println(mypage.getMyPostsWithId(currentIndex));
                                            System.out.println("L = Like \t C = Comment \t P = previous \t E = Exit");
                                            char choiceOfAction = sc.nextLine().toLowerCase().charAt(0);
                                            switch (choiceOfAction){
                                                case 'l': mypage.getMyPosts().get(currentIndex).putLike(); break;
                                                case 'c': mypage.getMyPosts().get(currentIndex).addComment(sc.nextLine()); break;
                                                case 'p': currentIndex--; break;
                                                case 'e': exit = false; break;
                                            }
                                        }
                                    }
                                    break;
                              case 9:
                                  MyPage friendspage = app.getCurrentUser().displayFriendWall();
                                  int currentIdx = 0;
                                  boolean exit_ = true;
                                  while (exit_){
                                      if(currentIdx == 0) {
                                          System.out.println(friendspage.getMyPostsWithId(currentIdx));
                                          System.out.println("L = Like \t C = Comment \t N = next \t E = Exit");
                                          char choiceOfAction = sc.nextLine().toLowerCase().charAt(0);
                                          switch (choiceOfAction){
                                              case 'l': friendspage.getMyPosts().get(currentIdx).putLike(); break;
                                              case 'c': friendspage.getMyPosts().get(currentIdx).addComment(sc.nextLine()); break;
                                              case 'n': currentIdx++; break;
                                              case 'e': exit_ = false; break;
                                          }
                                      } else if(currentIdx > 0 && currentIdx < friendspage.getMyPosts().size()-1){
                                          System.out.println(friendspage.getMyPostsWithId(currentIdx));
                                          System.out.println("L = Like \t C = Comment \t P = previous \t N = next \t E = Exit");
                                          char choiceOfAction = sc.nextLine().toLowerCase().charAt(0);
                                          switch (choiceOfAction){
                                              case 'l': friendspage.getMyPosts().get(currentIdx).putLike(); break;
                                              case 'c': friendspage.getMyPosts().get(currentIdx).addComment(sc.nextLine()); break;
                                              case 'p': currentIdx--; break;
                                              case 'n': currentIdx++; break;
                                              case 'e': exit_ = false; break;
                                          }
                                      } else {
                                          System.out.println(friendspage.getMyPostsWithId(currentIdx));
                                          System.out.println("L = Like \t C = Comment \t P = previous \t E = Exit");
                                          char choiceOfAction = sc.nextLine().toLowerCase().charAt(0);
                                          switch (choiceOfAction){
                                              case 'l': friendspage.getMyPosts().get(currentIdx).putLike(); break;
                                              case 'c': friendspage.getMyPosts().get(currentIdx).addComment(sc.nextLine()); break;
                                              case 'p': currentIdx--; break;
                                              case 'e': exit_ = false; break;
                                          }
                                      }
                                  }
                                    break;
                                case 10:
                                    System.out.println("Enter max depth:");
                                    try {
                                        choice3 = Integer.parseInt(sc.nextLine());
                                    } catch (Exception e) {
                                        choice3 = -1;
                                    }
                                    app.friendOfFriend(app.getCurrentUser(), choice3, new HashSet<Profile>(), "");
                                    break;
                                default:
                                    break;
                            }
                        } while (choice2 != 11);
                    }
                    break;
            }
        }while(choice!=3);
    }

}
