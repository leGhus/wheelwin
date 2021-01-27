package energy;

import java.text.DecimalFormat;

public class Tester {
    double l1; // distance entre le centre de la roue et le poids en position de repos
    double l2; // distance entre le centre de la roue et le poids en position max
    double f1; // force appliqué par 1 poid à la vitesse de déclanchement v1
    double f2; // force appliqué par 1 poid à la vitesse ou le poids arrive en position haute
    double v1; // v1 la vitesse de déclanchement
    double v2; // v2 la vitesse ou le poids arrive en position haute
    double rTang; // le rayon allant du centre de la roue jusqu'aucontact pneu/route
    double m; // la masse d'UN SEUL poids
    double raideur; // la raideur ATTENTION, ici on a la raideur en N/m et non en N/mm
    double hubWeight = 0.250; // poids du moyeu en kg
    double spokeWeights = 0.1; // poids des rayons en kg
    double rimWeight = 0.5; // poids de la jante + pneu

    public void setHubWeight(double hubWeight) {
        this.hubWeight = hubWeight;
    }
    public void setRimWeight(double rimWeight) {
        this.rimWeight = rimWeight;
    }
    public void setSpokeWeights(double spokeWeights) {
        this.spokeWeights = spokeWeights;
    }

    public Tester(double mInitializer, double l1Initializer, double l2Initialized, double rtInitializer,
            double v1Initializer, double v2Initializer) {
        DecimalFormat df = new DecimalFormat("######.##");

        // toutes les valeurs à initialiser qui ne doivent pas changer individuellement
        // pour les changer, il faudra recréer un classe et ré initialiser avec les nouvelles valeures
        m = mInitializer;
        v1 = v1Initializer;
        v2 = v2Initializer;
        l1 = l1Initializer;
        l2 = l2Initialized;
        rTang = rtInitializer;

        // calcul de f1, f2 et de la raideur
        double speed1 = v1 * l1 / rTang; // vitesse du poids ( qui est calculée selon la vitesse tangeancielle du pneu ) en position basse
        double speed2 = v2 * l2 / rTang; // vitesse du poids ( qui est calculée selon la vitesse tangeancielle du pneu ) en position haute
        f1 = (m * speed1 * speed1) / l1;
        f2 = (m * speed2 * speed2) / l2;
        raideur = (f2 - f1) / (l2 - l1);
        System.out.println("---------------------------------------------");
        System.out.println("Iniertia calculator initialized with values :");
        System.out.println("    f1 = " + df.format(f1) + " N");
        System.out.println("    f2 = " + df.format(f2) + " N");
        System.out.println("    raideur = " + df.format(raideur) + " N/m");
        System.out.println("---------------------------------------------");
    }

    public double fc(double speed) { // calcul de la force centrifuge
        double dl = position(speed);
        double newSpeed = speed * (l1 + dl) / rTang;
        return (m * newSpeed * newSpeed) / (l1 + dl);
    }

    public double fr(double speed) { // calcul de la force du ressort
        double dl = position(speed);
        return (f1 + raideur * dl);
    }

    public double position(double speed) { // calcul de la compression du ressort à une vitesse donnée
        double dl;
        dl = (f1 - (l1 * m * (speed / rTang) * (speed / rTang))) / ((m * (speed / rTang) * (speed / rTang)) - raideur);
        if (dl <= 0) {
            dl = 0;
        }
        if(dl + l1 >= l2){
            dl = l2 - l1;
        }
        return dl;
    }

    public double getMomentum(double speed, double nbOfWeight) { // calcul du moment d'inertie de UNE roue à une vitesse donnée pour un nombre de poids donné
        // les valeurs de poids du moyeu/rayon/jante peuvent être modifiées
        double momentum;
        double hubMomentum = 0.025 * 0.025 * hubWeight; // r * r * m
        double spokeMomentum = 0.315 * 0.315 * spokeWeights;
        double rimMomentum = 0.330 * 0.3 * rimWeight; 
        double weightmomentum = nbOfWeight * (m * (l1 + position(speed)) * (l1 + position(speed)) );

        momentum = hubMomentum + spokeMomentum + rimMomentum + weightmomentum;
        return momentum;
    }
}
