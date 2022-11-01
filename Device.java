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
    public ZoomMeeting startMeeting(int meetingPassword, User... users) {
        return new ZoomMeeting()
    }

}
