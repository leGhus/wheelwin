package energy;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class SystemEnergy {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");

        df.setRoundingMode(RoundingMode.HALF_UP);
        double[][] data = {{0,0},{10,2.7},{20,5.5},{30,8.3},{40,10},{50,10}};
        double energy;
        double oneSecondDistance;
        double oneSecondPower;
        double energyConsumed;
        double totalConsumed;
        double distance = 0;
        double speed;
        double energyWithWeights;
        User usr = new User(70, 0);
        Frame frame = new Frame(10, 0);
        Wheel wheel = new Wheel(0);
        Friction extFriction = new Friction(0);
        
        for (int i = 0; i < data.length; i++) {
            if (i < data.length -1) {
                speed = data[i][1];
                usr.setSpeed(speed);
                frame.setSpeed(speed);
                wheel.setSpeed(speed);
                extFriction.setSpeed(speed);
                energy = frame.getkineticEnergy() + wheel.getkineticEnergy(0) + wheel.getkineticEnergy(0);
                energyWithWeights = frame.getkineticEnergy() + wheel.getkineticEnergy(24) + wheel.getkineticEnergy(24);
                energyConsumed = extFriction.getFriction();
                distance = (data[i+1][0] - data[i][0]) * speed;
                System.out.println("---------------------------------------------");
                System.out.println("    at ( "+speed+" m/s - "+df.format(speed*3.6)+" km/h )" );
                System.out.println("    energy : " + df.format(energy));
                System.out.println("    wheel inertia" + df.format(wheel.getMomentum(0)));
                System.out.println("    energy with system: " + df.format(energyWithWeights));
                System.out.println("    wheel inertia  with weights" + df.format(wheel.getMomentum(24)));
                System.out.println(energyConsumed);
            }
        }
    }
}