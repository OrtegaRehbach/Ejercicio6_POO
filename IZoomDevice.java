public interface IZoomDevice {
    
    public ZoomMeeting startMeeting(User host, int id, int password, User... users);

    public ZoomMeeting startMeeting(User host, int id, int password);

    public boolean endMeeting(ZoomMeeting meeting);

    public boolean joinMeeting(User host, ZoomMeeting meeting, int password);
        
    public boolean leaveMeeting(User user);

    public boolean sendGeneralChatMessage(String message, ZoomMeeting meeting);

    public boolean sendPrivateChatMessage(ZoomUser targetUser, String message, ZoomMeeting meeting);

    public void toggleMicrophone();

    public void toggleCamera();

    public ZoomMeeting getCurrentMeeting();

    public boolean isHostOfMeeting(ZoomMeeting meeting);

    public boolean isMicrophoneOpen();

    public boolean isCameraOn();

}