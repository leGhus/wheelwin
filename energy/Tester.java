package energy;

public class Tester {
    public double fc(double speed, double weight, double l0, double dl){
        double speed2 = speed * (l0 + dl) / 0.350;
        return (weight * (l0 + dl) * (speed/0.350) * (speed/0.350)) ;
    }
    public double fr(double dl, double r){
        return (1.3 + ((r/1000) * dl));
    }
    public double position(double speed, double weight, double raideur, double f0, double l0, double lmax) {
        double dl = 0;

        return 0;
    }
}
