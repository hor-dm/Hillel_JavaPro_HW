package part2;

public class Main {
    public static void main(String[] args) {
        Fruit apple1 = new Apple();
        Fruit orange1 = new Orange();

        System.out.println("apple weight: " + apple1.getWeight());
        System.out.println("orange weight: " + orange1.getWeight());
        System.out.println();

        Box box1 = new Box<>();
        Box box2 = new Box<>();
        System.out.println("empty box weight: " + box1.getWeight());
        System.out.println();


        box1.addOne(apple1);
        box1.addOne(orange1);


        System.out.println("fruits in box1: " + box1.getNumOfFruits());
        System.out.println(box1);
        System.out.println();


        Fruit apple2 = new Apple();
        Fruit apple3 = new Apple();
        Fruit apple4 = new Apple();
        Fruit orange2 = new Orange();


        box1.addFew(apple2, apple3, apple4, orange2);
        System.out.println(box1);
        Fruit[] apples = {new Apple(), new Orange()};
        box1.addFew(apples);
        System.out.println(box1);
        System.out.println();


        System.out.println("fruits in box1: " + box1.getBoxType());
        System.out.println();


        box2.addFew(orange1, orange2, apple1);
        System.out.println(box2);
        System.out.println();


        System.out.println("fruits weight in box1: " + box1.getWeight());
        System.out.println("fruits weight in box2: " + box2.getWeight());
        System.out.println();


        System.out.println("create 2 new boxes box3: 3 apples, box4: 2 oranges");
        Box box3 = new Box<>(new Apple(), new Apple(), new Apple());
        Box box4 = new Box<>(new Orange(), new Orange());
        System.out.println("compare() : " + box3.compare(box4));
        System.out.println();


        System.out.println("create 2 new boxes box5: 2 apples, box6: 3 oranges");
        Box box5 = new Box<>(new Apple(), new Apple());
        Box box6 = new Box<>(new Orange(), new Orange(), new Orange());
        System.out.println("compare(): " + box5.compare(box6));
        System.out.println();


        System.out.println("box1: " + box1);
        System.out.println("box3: " + box3);
        System.out.println("merge(): add to box1 (5 aples) from box3 (3 apples)");
        box1.merge(box3);
        System.out.println("box1: " + box1);
        System.out.println("box3: " + box3);
        System.out.println();


        System.out.println("2 oranges from box2 -> box5 apples");
        System.out.println("box2: " + box2);
        System.out.println("box5: " + box5);
        System.out.println("merge(): add to box5 (5 aples) from box2 (2 oranges)");
        box5.merge(box2);
        System.out.println("box2: " + box2);
        System.out.println("box5: " + box5);
        System.out.println();


        System.out.println("box1: " + box1);
        box1.removeOne("print");
        box1.removeOne("print");
        box1.removeOne("print");
        box1.removeOne("print");
        box1.removeOne("print");
        box1.removeOne("print");
        box1.removeOne("print");
        box1.removeOne("print");
        box1.removeOne("print");
        System.out.println("box1: " + box1);
        System.out.println(box1.getFruitsBox());
    }
}
