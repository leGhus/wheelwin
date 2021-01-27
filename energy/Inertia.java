package energy;

public class Inertia {
    double speed;
    double rMax;
    double raideur;

    public Inertia(double speedInitializer, double rMaxInitializer, double raideurInitialized) {
        speed = speedInitializer;
        rMax = rMaxInitializer;
        raideur = raideurInitialized;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setRaideur(double raideur) {
        this.raideur = raideur;
    }

    public void setrMax(double rMax) {
        this.rMax = rMax;
    }

    

    public double getMomentum() {
        double momentum;
        double hubMomentum = 0.025 * 0.025 * 0.25; // r * r * m
        double spokeMomentum = 0.315 * 0.315 * 0.15;
        double rimMomentum = 0.330 * 0.3 * 0.3;

        momentum = hubMomentum + spokeMomentum + rimMomentum;

        System.out.println("momentum " + momentum);
        return momentum;
    }
}
