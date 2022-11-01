public interface IZoomDevice {
    
    public ZoomMeeting startMeeting(int meetingPassword, User... users);

    public ZoomMeeting startMeeting(int meetingPassword);

    public boolean endMeeting(ZoomMeeting meeting);

    public boolean joinMeeting(ZoomMeeting meeting, int meetingPassword);
        
    public boolean leaveMeeting(ZoomMeeting meeting);

    public boolean sendGeneralChatMessage(String message, ZoomMeeting meeting);

    public boolean sendPrivateChatMessage(ZoomUser targetUser, String message, ZoomMeeting meeting);

    public void toggleMicrophone();

    public void toggleCamera();

    public ZoomMeeting getCurrentMeeting();

    public boolean isHostOfMeeting(ZoomMeeting meeting);

    public boolean isMicrophoneOpen();

    public boolean isCameraOn();
    
}