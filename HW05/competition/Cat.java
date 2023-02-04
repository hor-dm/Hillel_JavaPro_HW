package competition;

public class Cat extends Member {
    protected int runLimit = 100;
    protected double jumpLimit = 1.0;

    public Cat() {
        super.runLimit = this.runLimit;
        super.jumpLimit = this.jumpLimit;
    }
}
