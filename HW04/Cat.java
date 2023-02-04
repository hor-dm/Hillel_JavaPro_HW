public class Cat extends Animal {

    public Cat() {
        AnimalCounter.numberOfCats = AnimalCounter.numberOfCats + 1;
        AnimalCounter.totalNumbersOfAnimals += 1;
    }

    @Override
    void run(int actionLength) {
        if (actionLength > 200) {
            System.out.println("Cat can't run " + actionLength + " m.");
        } else System.out.println("Cat run " + actionLength + " m.");
    }

    @Override
    void swim(int actionLength) {
        System.out.println("Cat can't swim.");
    }
}
