package energy;

public class Friction {
    double speed;
    double cx1 = 0.22;
    double cx2 = 0.19;
    double cx3 = 5;

    public Friction(double speedInitializer){
        speed = speedInitializer; // en m/s
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public double getFriction(){
        double energy = cx1 * speed * speed + cx2 * speed + cx3;
        return energy; // energie consomée par mètre
    }

}
