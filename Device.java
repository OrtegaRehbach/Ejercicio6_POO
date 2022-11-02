public abstract class Device implements IZoomDevice {
    private String name;
    private boolean powered;
    private ZoomMeeting currentMeeting;
    
    public Device(String name) {
        this.name = name;
        this.powered = true;
        this.currentMeeting = null;
    }

    public String getName() {
        return this.name;
    }

    public ZoomMeeting getCurrentMeeting() {
        return this.currentMeeting;
    }

    public void setCurrentMeeting(ZoomMeeting currentMeeting) {
        this.currentMeeting = currentMeeting;
    }

    public boolean isInMeeting() {
        return currentMeeting != null;
    }

    public boolean isPowered() {
        return this.powered;
    }

    public abstract String turnOn();

    public abstract String turnOff();

    // IZoomDevice Implementation
    @Override
    public ZoomMeeting startMeeting(User host, int id, int password, User... users) {
        return new ZoomMeeting(host, id, password, users);
    }

    @Override
    public ZoomMeeting startMeeting(User host, int id, int password) {
        return new ZoomMeeting(host, id, password);
    }

    @Override
    public boolean endMeeting(ZoomMeeting meeting) {
        return meeting.endMeeting();
    }

    @Override
    public boolean joinMeeting(User user, ZoomMeeting meeting, int password) {
        if (meeting.checkValidPassword(password)) {
            return meeting.addUser(user);
        } else {
            return false;
        }
    }

    @Override
    public boolean leaveMeeting(User user) {
        return this.currentMeeting.removeUser(user);
    }

}
