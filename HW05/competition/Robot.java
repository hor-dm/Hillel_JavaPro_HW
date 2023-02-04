package competition;

public class Robot extends Member {
    protected int runLimit = 300;
    protected double jumpLimit = 2.0;

    public Robot() {
        super.runLimit = this.runLimit;
        super.jumpLimit = this.jumpLimit;
    }
}
