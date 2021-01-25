package energy;

public class Crankset {
    double inertiaMomentum;
    double rpm;

    public Crankset(double inertiaMomentumInitializer, double rpmInitializer) {
        inertiaMomentum = inertiaMomentumInitializer;
        rpm = rpmInitializer;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    private double rpmToRadsec(double rpm){
        return (rpm * (2 * Math.PI / 60));
    }

    public double getkineticEnergy() {
        double energy = 0.5 * inertiaMomentum * rpmToRadsec(rpm);
        return energy;
    }
}
