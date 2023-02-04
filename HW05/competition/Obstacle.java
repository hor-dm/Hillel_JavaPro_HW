package competition;

public abstract class Obstacle {

    int length = 0;
    double height = 0.0;

    public static void competition(Member[] member, Obstacle[] obstacle) {
        String obstacleName;
        String memberName;
        for (Obstacle o : obstacle) {
            obstacleName = o.getClass().getSimpleName();
            for (Member m : member) {
                memberName = m.getClass().getSimpleName();

                if (m.run(o.length) && o.height == 0 && m.igGoingOn) {
                    System.out.println(memberName +
                            " run " + o.length + " m. on " + obstacleName + ".");
                }
                if (!m.run(o.length) && m.igGoingOn) {
                    System.out.print(memberName +
                            " didn't run " + o.length + " m. on " + obstacleName + ", passed: " +
                            m.runLimit + " m. ");
                    m.igGoingOn = false;
                    System.out.println(memberName + " drop out.");
                }

                if (m.jump(o.height) && o.length == 0 && m.igGoingOn) {
                    System.out.println(memberName +
                            " jumped over " + obstacleName + " " + o.height + " m.");
                }

                if (!m.jump(o.height) && m.igGoingOn) {
                    System.out.print(memberName + " didn't jumped over " + obstacleName + " " + o.height +
                            " m., height taken: " + m.jumpLimit + " m. ");
                    m.igGoingOn = false;
                    System.out.println(memberName + " drop out.");
                }
            }
        }
    }
}