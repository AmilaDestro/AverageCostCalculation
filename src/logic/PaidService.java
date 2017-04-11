package logic;


public abstract class PaidService {
    private String id;
    private String name;
    private double costs;

    public abstract int calculateAverageMonthlyCosts();

    public abstract String getId();

    public abstract String getName();
}
