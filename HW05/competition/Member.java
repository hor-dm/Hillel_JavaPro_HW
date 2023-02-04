package competition;

public abstract class Member {
    protected int runLimit;
    protected double jumpLimit;
    protected boolean igGoingOn = true;

    boolean run(int distance) {
        if (distance <= runLimit) {
            return true;
        } else {
            return false;
        }
    }

    boolean jump(double height) {
        if (height <= jumpLimit) {
            return true;
        }
        else {
            return false;
        }
    }
}
