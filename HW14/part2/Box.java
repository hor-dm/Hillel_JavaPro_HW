package part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<T> {
    private final List<T> fruitsBox;
    private int numOfFruits;
    boolean isEmpty;

    public Box() {
        fruitsBox = new ArrayList<>();
        isEmpty = true;
    }

    @SafeVarargs
    public Box(T... ts) {
        fruitsBox = new ArrayList<>();
        isEmpty = true;
        addFew(ts);
    }

    public List<T> getFruitsBox() {
        return fruitsBox;
    }

    // метод без аргументов просто удаляет
    // метод, хотя бы с одним, аргументом, выводит сообщение
    // когда коробка пуста
    public void removeOne(String... strings) {
        if (numOfFruits == 0) {
            isEmpty = true;
            if (strings.length >= 1) {
                System.out.println("This box is empty.");
            }
        } else {
            fruitsBox.remove(fruitsBox.size() - 1);
            numOfFruits--;
            if (numOfFruits == 0) {
                isEmpty = true;
            }
        }
    }

    public void addOne(T t) {
        if (numOfFruits == 0) {
            fruitsBox.add(t);
            numOfFruits++;
            isEmpty = false;
        } else {
            if (fruitsBox.get(0).getClass().equals(t.getClass())) {
                fruitsBox.add(t);
                numOfFruits++;
                isEmpty = false;
            }
        }
    }

    @SafeVarargs
    public final void addFew(T... ts) {
        for (T t : ts) {
            if (numOfFruits == 0) {
                fruitsBox.add(t);
                numOfFruits++;
                isEmpty = false;
            } else {
                if (fruitsBox.get(0).getClass().equals(t.getClass())) {
                    fruitsBox.add(t);
                    numOfFruits++;
                    isEmpty = false;
                }
            }
        }
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public String getBoxType() {
        if (!this.isEmpty) {
            return fruitsBox.get(0).getClass().getSimpleName();
        } else {
            return "empty box";
        }
    }

    public float getWeight() {
        float result;
        if (!isEmpty) {
            result = numOfFruits * ((Fruit) fruitsBox.get(0)).getWeight();
        } else {
            result = 0.0f;
        }
        return result;
    }

    public boolean compare(T t) {
        boolean result = false;
        Box box = (Box) t;
        if (this.getWeight() == (box.getWeight())) {
            result = true;
        }
        return result;
    }

    public void merge(T t) {
        Box box = (Box) t;
        if (!Objects.equals(this.getBoxType(), box.getBoxType())) {
            return;
        }

        while (!box.isEmpty) {
            this.addOne((T) box.getFruitsBox().get(box.fruitsBox.size() - 1));
            box.removeOne();
        }
    }

    @Override
    public String toString() {
        if (this.isEmpty) {
            return "Box is empty.";
        }
        return "Box contains " + getBoxType() +", " + numOfFruits + " pcs.";
    }
}
