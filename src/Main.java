class Main {

    public static void main(String[] args) throws Exception {
        Simulation Sim = new Simulation();
        int costphase1U1=Sim.runSimulation(Sim.loadU1(Sim.loadItems(1)));
        int costphase2U1=Sim.runSimulation(Sim.loadU1(Sim.loadItems(2)));
        int costphase1U2=Sim.runSimulation(Sim.loadU2(Sim.loadItems(1)));
        int costphase2U2=Sim.runSimulation(Sim.loadU2(Sim.loadItems(2)));
        System.out.println("Total budget for U1 fleet:");
        System.out.println("Phase-1: $"+costphase1U1);
        System.out.println("Phase-2: $"+costphase2U1);
        System.out.println("Total budget for U2 fleet:");
        System.out.println("Phase-1: $"+costphase1U2);
        System.out.println("Phase-2: $"+costphase2U2);
    }
}