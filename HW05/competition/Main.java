package competition;

public class Main {
    public static void main(String[] args) {

        Member member1 = new Cat();
        Member member2 = new Human();
        Member member3 = new Robot();
        RunningTrack runningTrack1 = new RunningTrack(50);
        RunningTrack runningTrack2 = new RunningTrack(150);
        RunningTrack runningTrack3 = new RunningTrack(250);
        Wall wall1 = new Wall(0.5);
        Wall wall2 = new Wall(1.5);
        Wall wall3 = new Wall(2.0);

        runningTrack1.overcome(member1);
        runningTrack2.overcome(member1);
        wall1.overcome(member1);
        wall2.overcome(member1);

        runningTrack1.overcome(member2);
        runningTrack2.overcome(member2);
        runningTrack3.overcome(member2);
        wall1.overcome(member2);
        wall2.overcome(member2);
        wall3.overcome(member2);

        runningTrack1.overcome(member3);
        runningTrack2.overcome(member3);
        runningTrack3.overcome(member3);
        wall1.overcome(member3);
        wall2.overcome(member3);
        wall3.overcome(member3);

        System.out.println("\nCompetition: \n");

        Member[] members = new Member[]{new Cat(), new Human(), new Robot()};
        Obstacle[] obstacles = new Obstacle[]{new RunningTrack(200), new Wall(1.6)};

        Obstacle.competition(members, obstacles);
    }
}
