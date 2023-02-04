package competition;

public class RunningTrack extends Obstacle {

    public RunningTrack(int length) {
        super.length = length;
    }

    public void overcome(Member member) {

        String obstacleName = RunningTrack.class.getSimpleName();
        String memberName = member.getClass().getSimpleName();
        if (member.run(length)  && member.igGoingOn) {
            System.out.println(memberName +
                    " run " + length + " m. on " + obstacleName + ".");
        }

        if (!member.run(length) && member.igGoingOn) {
            System.out.print(memberName +
                    " didn't run " + length + " m. on " + obstacleName + ", passed: " +
                    member.runLimit + " m. ");
            member.igGoingOn = false;
            System.out.println(memberName + " drop out.");
        }
    }
}
