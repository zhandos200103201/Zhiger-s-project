
public class Follow{

    protected Profile sender, receiver;

    public Follow(Profile sender, Profile receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public Profile getSender() {
        return sender;
    }

    public Profile getReceiver() {
        return receiver;
    }

    public String toString() {
        return this.getSender().getName() + " has followed to " + this.getReceiver().getName();
    }

}
