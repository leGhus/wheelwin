package energy;

public class Wheel {
    Inertia inertia = new Inertia(0.05, 0.15, 0.225, 0.3, 4.1, 7);
    double speed;
    double radius = 0.35;

    public Wheel(double speedInitializer) {
        speed = speedInitializer;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getkineticEnergy(double nbOfWeights) {
        double energy = 0.5 * inertia.getMomentum(speed,nbOfWeights) * ((speed*speed)/(radius*radius));
        return energy;
    }
    public double getMomentum(double nbOfWeights) {
        return inertia.getMomentum(speed,nbOfWeights);
    }
}
