public class Building {
    private int cost;
    private int workersRequired;

    public Building(int cost, int workersRequired) {
        this.cost = cost;
        this.workersRequired = workersRequired;
    }
    public int getCost() {
        return cost;
    }
    public int getWorkersRequired() {
        return workersRequired;
    }
}
