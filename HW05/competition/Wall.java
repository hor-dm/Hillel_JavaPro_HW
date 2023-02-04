package competition;

public class Wall extends Obstacle {


    public Wall(double height) {
        this.height = height;
    }

    public void overcome(Member member) {
        String obstacleName = Wall.class.getSimpleName();
        String memberName = member.getClass().getSimpleName();
        if (member.jump(height) && member.igGoingOn) {
            System.out.println(memberName +
                    " jumped over " + obstacleName + " " + height + " m.");
        }

        if (!member.jump(height) && member.igGoingOn) {
            System.out.print(memberName + " didn't jump over " + obstacleName + " " + height +
                    " m., height taken: " + member.jumpLimit + " m. ");
            member.igGoingOn = false;
            System.out.println(memberName + " dropped out.");
        }
    }
}
