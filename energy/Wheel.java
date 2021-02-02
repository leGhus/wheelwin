package energy;

public class Wheel {
    Inertia inertia = new Inertia(0.05, 0.161, 0.236, 0.350, 4, 7);
    double speed;
    double radius = 0.35;

    public Wheel(double speedInitializer) {
        speed = speedInitializer;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getkineticEnergy() {
        double energy = 0.5 * inertia.getMomentum(speed, 24) * ((speed*speed)/(radius*radius));
        return energy;
    }
}
