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
        User usr = new User(70, 0);
        Frame frame = new Frame(10, 0);
        Wheel wheel = new Wheel(0);
        Friction extFriction = new Friction(0);
        
        for (int i = 0; i < data.length; i++) {
            if (i < data.length -1) {
                usr.setSpeed(data[i][1]);
                frame.setSpeed(data[i][1]);
                wheel.setSpeed(data[i][1]);
                extFriction.setSpeed(data[i][1]);
                energy = frame.getkineticEnergy() + wheel.getkineticEnergy();
                energyConsumed = extFriction.getFriction(); // energy per meter
                distance = (data[i+1][0] - data[i][0]) * data[i][1];
                oneSecondDistance = data[i][1];
                oneSecondPower = energyConsumed / oneSecondDistance;
                totalConsumed = energyConsumed * distance;
                //System.out.print("energy at "+ data[i][0] + " sec :" + df.format(energy) + " J with speed " + data[i][1] + " consuming " +  df.format(energyConsumed) + " J per meter for " + distance+" meter = "+ totalConsumed+" power needed : "+oneSecondPower+" W\n");
                //System.out.println(wheel.getkineticEnergy());
            }
        }
    }
}