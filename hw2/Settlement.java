public class Settlement {
    private Building[] buildings = new Building[2];
    private String name;
    private int size;

    public Settlement(String n) {
        name = n;
        size = buildings.length;
    }

    public void addBuilding(Building b) {
        if (buildings.length > size) {
            buildings[size] = b;
            size++;
        } else {
            expandSettlement();
            buildings[size] = b;
            size++;
        }
    }

    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

    public boolean build(int allottedMoney, Population population,
        int cost, int workersRequired) {
        if (cost < allottedMoney
            && population.getCivilians() > workersRequired) {
            if (buildings.length > size) {
                population.canWork(workersRequired);
                buildings[size] = new Building(cost, workersRequired);
                size++;
            } else {
                expandSettlement();
                buildings[size] = new Building(cost, workersRequired);
                population.canWork(workersRequired);
                size++;
            }
            return true;
        }
        return false;
    }

    public void expandSettlement() {
        Building[] tempBuildings = new Building[buildings.length * 2];
        for (int i = 0; i < buildings.length; i++) {
            tempBuildings[i] = buildings[i];
        }
        buildings = tempBuildings;
    }

}
