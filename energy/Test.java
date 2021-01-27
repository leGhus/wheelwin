package energy;

public class Test {  
    public static void main(String[] args) {
        Tester tester = new Tester(0.05, 0.15, 0.225, 0.3, 4.1, 7);
        System.out.println(tester.position(5.5));
        System.out.println(tester.fr(5.5));
        System.out.println(tester.fc(5.5));
        System.out.println(tester.getMomentum(5.5, 5));
        
    }
}
