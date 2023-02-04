package competition;

public class Human extends Member{
    protected int runLimit = 200;
    protected double jumpLimit = 1.5;

    public Human() {
        super.runLimit = this.runLimit;
        super.jumpLimit = this.jumpLimit;
    }
}
