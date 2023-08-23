public class DeluxBurger extends Hamburger{

    public DeluxBurger() {
        super("Delux Burger","Sausage & Bacon", 15.10,"White Roll");
    }

    @Override
    public void addHamburgerAddition1(String additionName, double additionPrice) {
        System.out.println("You can't add anything to a Delux Burger");
    }

    @Override
    public void addHamburgerAddition2(String additionName, double additionPrice) {
        System.out.println("You can't add anything to a Delux Burger");
    }

    @Override
    public void addHamburgerAddition3(String additionName, double additionPrice) {
        System.out.println("You can't add anything to a Delux Burger");
    }

    @Override
    public void addHamburgerAddition4(String additionName, double additionPrice) {
        System.out.println("You can't add anything to a Delux Burger");
    }

    @Override
    public double itemizedHamburger() {
        double chipsPrice = 1.3;
        System.out.println("Added chips for an extra " + chipsPrice + "$" );
        double drinkPrice = 3.7;
        System.out.println("Added drink for an extra " + drinkPrice + "$" );

        return super.itemizedHamburger() + chipsPrice + drinkPrice;
    }
}
