public class Dog extends Animal {

    public Dog() {
        AnimalCounter.numberOfDogs +=  1;
        AnimalCounter.totalNumbersOfAnimals += 1;
    }

    @Override
    public void run(int actionLength) {
        if (actionLength > 500) {
            System.out.println("Dog can't run " + actionLength + " m.");
        } else System.out.println("Dog run " + actionLength + " m.");
    }

    @Override
    public void swim(int actionLength) {
        if (actionLength > 10) {
            System.out.println("Dog can't swim "+ actionLength + " m.");
        } else System.out.println("Dog swim " + actionLength + " m.");
    }
}
