import java.util.ArrayList;

public class ZoomUser extends User {
    private ArrayList<String> privateMessages;

    public ZoomUser(String name, Device device) {
        super(name, device);
        this.privateMessages = new ArrayList<String>();
    }

    public ZoomUser(User user) {
        super(user.getName(), user.getDevice());
        this.privateMessages = new ArrayList<String>();
    }

    public ArrayList<String> getPrivateMessages() {
        return this.privateMessages;
    }

    public boolean leaveCurrentMeeting() {
        Device device = getDevice();
        return device.leaveMeeting(this.toUser());
    }

    public User toUser() {
        return new User(getName(), getDevice());
    }
}