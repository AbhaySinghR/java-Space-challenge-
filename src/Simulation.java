import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

class Simulation {
    ArrayList<Item> loadItems(int phase) throws Exception
    {

        ArrayList<Item> loader = new ArrayList();
        String name="";
        if(phase==1)
        {
            name=name+"phase-1.txt";
        }
        else
        {
            name=name+"phase-2.txt";
        }
        try{
            File file=new File(name);
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()) {

                String[] tokenizer= sc.nextLine().split("=");
                Item newItem = new Item(tokenizer[0],Integer.parseInt(tokenizer[1]));
                loader.add(newItem);
            }
        }catch(FileNotFoundException ex)
        {
            if(phase==1)
                System.out.println("Error! phase-1.txt missing");
            else
                System.out.println("Error! phase-2.txt missing");
            System.exit(1);
        }
        return loader;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> ItemList) {

        ArrayList<Rocket> rocketlist = new ArrayList();
        Rocket rocket = new U1();

        for (Item item : ItemList) {

            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketlist.add(rocket);
                rocket = new U1();

                rocket.carry(item);
            }
        }
        rocketlist.add(rocket);
        return rocketlist;
    }
    ArrayList<Rocket> loadU2(ArrayList<Item> ItemList) {

        ArrayList<Rocket> rocketlist2 = new ArrayList();
        Rocket rocket = new U2();
        for (Item item : ItemList) {

            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketlist2.add(rocket);
                rocket = new U2();

                rocket.carry(item);
            }
        }
        rocketlist2.add(rocket);
        return rocketlist2;
    }
    int runSimulation(ArrayList<Rocket> rockets) {

        int total=0;
        for (Rocket currentRocket : rockets) {
            total=total+currentRocket.CostOfRocket();

            while (!currentRocket.launch() || !currentRocket.land())
            {
                total=total+currentRocket.CostOfRocket();
            }
        }
        return total;
    }
}