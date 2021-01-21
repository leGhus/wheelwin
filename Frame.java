public class Frame {
    double weight;
    double speed;
    
    public Frame(double weightInitializer, double speedInitializer){
        weight = weightInitializer;
        speed  = speedInitializer;
    }

    public double getkineticEnergy() {
        double energy = 0.5 * weight * speed * speed;
        return energy;
    }
}