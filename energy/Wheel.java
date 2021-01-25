package energy;

public class Wheel {
    double inertiaMomentum;
    double speed;
    double radius;

    public Wheel(double inertiaMomentumInitializer, double speedInitializer, double radiusInitializer) {
        inertiaMomentum = inertiaMomentumInitializer;
        speed = speedInitializer;
        radius = radiusInitializer;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setInertiaMomentum(double inertiaMomentum) {
        this.inertiaMomentum = inertiaMomentum;
    }

    public double getkineticEnergy() {
        double energy = 0.5 * inertiaMomentum*((speed*speed)/(radius*radius));
        return energy;
    }
}
