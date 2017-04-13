package logic;


public class FixedMonthlyCostPaidService extends PaidService {
    private String id;
    private String name;
    private double costs;

    public FixedMonthlyCostPaidService(String id, String name, double costs) {
        this.id = id;
        this.name = name;
        this.costs = costs;
    }

    @Override
    public int calculateAverageMonthlyCosts() {
        return (int) Math.ceil(costs);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getId() + " / " + this.getName() + " / " + this.calculateAverageMonthlyCosts();
    }
}
