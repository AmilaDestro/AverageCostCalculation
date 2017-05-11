package logic;


public class FixedMonthlyCostPaidService extends PaidService {

    public FixedMonthlyCostPaidService(String id, String name, double costs) {
        super(id, name, costs);
    }

    @Override
    public int calculateAverageMonthlyCosts() {
        return (int) costs;
    }

}
