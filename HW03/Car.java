public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
        System.out.println("Engine is started.");
    }

    private void startElectricity() {
        System.out.println("Electric system is working.");
    }

    private void startCommand() {
        System.out.println("Command system is working.");
    }

    private void startFuelSystem() {
        System.out.println("Fuel system is working.");
    }
}