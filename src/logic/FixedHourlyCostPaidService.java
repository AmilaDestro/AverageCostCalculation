package logic;


public class FixedHourlyCostPaidService extends PaidService {

    public FixedHourlyCostPaidService(String id, String name, double costs) {
        super(id, name, costs);
    }

    @Override
    public int calculateAverageMonthlyCosts() {
        return (int) Math.round(30 * 24 * costs);
    }

}
