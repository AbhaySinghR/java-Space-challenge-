public class Rocket implements SpaceShip{
    double cost,cargoCarried,max;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }
    public void carry(Item item) {
        cargoCarried= cargoCarried+item.weight;
    }

    public boolean canCarry(Item item) {
        if((cargoCarried+item.weight)<=max)
            return true;
        else
            return false;
    }
    int CostOfRocket()
    {
        return (int)cost;
    }

}