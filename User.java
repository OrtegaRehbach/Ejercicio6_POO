public class User {
    private String name;
    private Device device;

    public User(String name, Device device) {
        this.name = name;
        this.device = device;
    }

    public String getName() {
        return name;
    }

    public Device getDevice() {
        return device;
    }

    public String getDeviceName() {
        return this.device.getName();
    }
    
}
