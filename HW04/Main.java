    public class Main {
    public static void main(String[] args) {
        Dog dog01 = new Dog();
        dog01.run(500);
        dog01.swim(10);

        Dog dog02 = new Dog();
        dog02.run(501);
        dog02.swim(11);

        Cat cat01 = new Cat();
        cat01.run(200);
        cat01.swim(1);

        Cat cat02 = new Cat();
        cat02.run(201);
        cat02.swim(2);

        System.out.println("Total dogs: " + AnimalCounter.numberOfDogs);
        System.out.println("Total cats: " + AnimalCounter.numberOfCats);
        System.out.println("Total animals: "+ AnimalCounter.totalNumbersOfAnimals);
    }
}
