package energy;

public class Wheel {
    Inertia inertia = new Inertia(0, 0.35, 0.06);
    double speed;
    double radius = 0.35;

    public Wheel(double speedInitializer) {
        speed = speedInitializer;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getkineticEnergy() {
        inertia.setSpeed(speed);
        double energy = 0.5 * inertia.getMomentum() * ((speed*speed)/(radius*radius));
        return energy;
    }
}
