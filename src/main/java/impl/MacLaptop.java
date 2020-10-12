package impl;

public class MacLaptop implements Laptop {
    public String monitor() {
        System.out.println("Mac Monitor");
        return "Mac Pro";
    }

    public int keyboard() {
        System.out.println("Mac Keyboard");
        return 11;
    }

    public boolean mouse() {
        System.out.println("Mac Mouse");
        return false;
    }

    public String activityLog() {
        System.out.println("Mac Activity Log");
        return "Activity Log";
    }
}
