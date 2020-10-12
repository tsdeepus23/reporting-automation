package impl;

public class DryRun {
    public static void main(String args[]) {
        Laptop windowsLaptop = new WindowsLaptop();
        Laptop macLaptop = new MacLaptop();

        WindowsLaptop windowsLaptop1 = new WindowsLaptop();
        MacLaptop macLaptop1 = new MacLaptop();

        windowsLaptop.monitor();
        windowsLaptop.keyboard();
        windowsLaptop.mouse();

        macLaptop.monitor();
        macLaptop.keyboard();
        macLaptop.mouse();

        windowsLaptop1.keyboard();
        macLaptop1.keyboard();

        windowsLaptop1.taskManager();
        macLaptop1.activityLog();
    }
}
