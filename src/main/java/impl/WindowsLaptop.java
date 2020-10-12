package impl;

public class WindowsLaptop implements Laptop {

    public String monitor() {
        System.out.println("Windows Monitor");
        return "Windows Monitor";
    }

    public int keyboard() {
        System.out.println("Windows Keyboard");
        return 5;
    }

    public boolean mouse() {
        System.out.println("Windows Mouse");
        return true;
    }

    public String taskManager() {
        System.out.println("Windows Task Manger");
        return "Windows Task Manager";
    }
}
