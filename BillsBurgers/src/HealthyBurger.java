public class HealthyBurger extends Hamburger{
    private  String healthyExtra1Name;
    private  double healthyExtra1Price;
    private  String healthyExtra2Name;
    private  double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy Burger", meat, price, "Whole Grain Roll");
    }

    public void addHealthyAddition1(String healhyExtraName, double healthyExtraPrice){
        healthyExtra1Name = healhyExtraName;
        healthyExtra1Price = healthyExtraPrice;
        System.out.println("Added " + healhyExtraName + " for " + healthyExtraPrice + "$.");
    }
    public void addHealthyAddition2(String healhyExtraName, double healthyExtraPrice){
        healthyExtra2Name = healhyExtraName;
        healthyExtra2Price = healthyExtraPrice;
        System.out.println("Added " + healhyExtraName + " for " + healthyExtraPrice + "$.");
    }
    @Override
    public double itemizedHamburger() {
        return super.itemizedHamburger() + healthyExtra1Price + healthyExtra2Price;
    }
}
