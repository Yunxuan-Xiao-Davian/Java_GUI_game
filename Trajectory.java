import java.util.ArrayList;

public class Trajectory {
    private ArrayList<Dot> dots = new ArrayList<>();
    private double gravity = -0.5;
    private double speedX;
    private double speedY;

    Trajectory(GameArena panel, GamePlayer gamePlayer, double strength, double angle) {
        if (strength * angle > 0) {
            int x = gamePlayer.getX();
            int y = gamePlayer.getY();
            speedX = strength * Math.cos(angle);
            speedY = -strength * Math.sin(angle);
            int time = (int) (2 * speedY / gravity);
            //System.out.println("speedX: "+speedX + " speedY: "+ speedY+ " time: "+ time);
            for (int i = 0; i <= time; i++) {
                Dot newDot = new Dot(panel,(int) (x + speedX * i), (int) (gravity * i * i / 2 - speedY * i)-gamePlayer.getY()+panel.getHeight());
                newDot.setSize(3);
                newDot.setY(650 - newDot.getY());
                dots.add(newDot);
            }
        }
    }

    public ArrayList<Dot> getDots() {
        return dots;
    }
}

