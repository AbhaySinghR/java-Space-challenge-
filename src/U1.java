import java.util.Random;
public class U1 extends Rocket {

    public U1() {
        cost = 100000000;
        cargoCarried=0;
        max=8000;
    }
    @Override
    public boolean launch() {

        double randno = Math.random();
        return (0.05 * (cargoCarried /max)) < randno;
    }
    @Override
    public boolean land() {
        double randno =Math.random();
        return (0.01*cargoCarried/max)<randno;
    }
}