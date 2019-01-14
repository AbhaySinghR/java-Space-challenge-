public class U2 extends Rocket {

    public U2() {
        cost=12000000;
        cargoCarried=0;
        max=11000;
    }
    @Override
    public boolean launch() {
        double randomNumber=Math.random();
        return (0.04 * (cargoCarried/max) <randomNumber);
    }
    @Override
    public boolean land() {

        double randomNumber=Math.random();
        return (0.08 * (cargoCarried/max)<randomNumber);
    }
}