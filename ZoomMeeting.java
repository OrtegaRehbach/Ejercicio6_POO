import java.util.ArrayList;

public class ZoomMeeting {
    private int id;
    private int password;
    private ZoomUser host;
    private ArrayList<ZoomUser> guestUsers;
    private ArrayList<String> generalMessages;

    public ZoomMeeting(User host, int id, int password) {
        this.host = new ZoomUser(host);
        this.id = id;
        this.password = password;
        this.guestUsers = new ArrayList<ZoomUser>();
        this.generalMessages = new ArrayList<String>();
    }

    public ZoomMeeting(User host, int id, int password, User... guests) {
        this.host = new ZoomUser(host);
        this.id = id;
        this.password = password;
        this.guestUsers = new ArrayList<ZoomUser>();
        for (ZoomUser user : convertToZoomUsers(guests)) {
            guestUsers.add(user);
        }
        this.generalMessages = new ArrayList<String>();
    }

    public ZoomMeeting(ZoomUser host, int id, int password) {
        this.host = host;
        this.id = id;
        this.password = password;
        this.guestUsers = new ArrayList<ZoomUser>();
        this.generalMessages = new ArrayList<String>();
    }

    public ZoomMeeting(ZoomUser host, int id, int password, ZoomUser... guests) {
        this.host = host;
        this.id = id;
        this.password = password;
        this.guestUsers = new ArrayList<ZoomUser>();
        for (ZoomUser user : guests) {
            this.guestUsers.add(user);
        }
        this.generalMessages = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public ZoomUser getHost() {
        return host;
    }

    public ArrayList<ZoomUser> getGuestUsers() {
        return guestUsers;
    }

    public ArrayList<String> getGeneralMessages() {
        return generalMessages;
    }

    public boolean checkValidPassword(int inputedPassword) {
        return inputedPassword == this.password;
    }

    public boolean userInMeeting(User user) {
        return (this.guestUsers.contains(new ZoomUser(user)) || this.host.equals(new ZoomUser(user)));
    }

    public boolean addUser(User user) {
        return this.guestUsers.add(new ZoomUser(user));
    }

    public boolean removeUser(User user) {
        if (userInMeeting(user)) {
            if (this.host.toUser().equals(user)) {
                endMeeting();
                return true;
            } else {
                user.getDevice().setCurrentMeeting(null);
                return this.guestUsers.remove(new ZoomUser(user));
            }
        } else {
            return false;
        }
    }

    public boolean endMeeting() {
        for (ZoomUser guest : guestUsers) {
            if (!guest.leaveCurrentMeeting()) {
                return false;
            }
        }
        if (!this.host.leaveCurrentMeeting()) {
            return false;
        }
        return true;
    }

    private ZoomUser[] convertToZoomUsers(User... users) {
        ZoomUser[] zoomUsers = new ZoomUser[users.length];
        for (int i = 0; i < zoomUsers.length; i++) {
            zoomUsers[i] = new ZoomUser(users[i]);
        }
        return zoomUsers;
    }
    
}
