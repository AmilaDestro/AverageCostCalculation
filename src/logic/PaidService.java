package logic;


public abstract class PaidService {
    protected String id;
    protected String name;
    protected double costs;

    PaidService(String id, String name, double costs) {
        this.id = id;
        this.name = name;
        this.costs = costs;
    }

    public abstract int calculateAverageMonthlyCosts();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getId() + " / " + getName() + " / " + calculateAverageMonthlyCosts();
    }
}
