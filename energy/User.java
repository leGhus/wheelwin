package energy;

public class User {
    double weight;
    double speed;
    
    public User(double weightInitializer, double speedInitializer){
        weight = weightInitializer;
        speed  = speedInitializer;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getkineticEnergy() {
        double energy = 0.5 * weight * speed * speed;
        return energy;
    }
}