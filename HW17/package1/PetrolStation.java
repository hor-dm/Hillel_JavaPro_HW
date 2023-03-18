package package1;

public class PetrolStation {

    private volatile double amount;

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public void doRefuel(String carName) {
        try {
            System.out.println(carName + " refueling");
            Thread.sleep((long) ((Math.random() * 8) + 3) * 1000);

            double carTankCapacity = Main.CAR_TANK_CAPACITY;
            if (amount >= carTankCapacity) {
                amount -= carTankCapacity;
                System.out.println(carName + " refueled, l " + amount + " left");
            } else {
                System.out.println(carName + " is not refueled, l " + amount + " left");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
