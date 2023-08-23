public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;
    private  String addition1Name;
    private double addition1Price;
    private  String addition2Name;
    private  double addition2Price;
    private  String addition3Name;
    private  double addition3Price;
    private  String addition4Name;
    private  double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String additionName, double additionPrice){
        addition1Name = additionName;
        addition1Price = additionPrice;
    }
    public void addHamburgerAddition2(String additionName, double additionPrice){
        addition2Name = additionName;
        addition2Price = additionPrice;
    }
    public void addHamburgerAddition3(String additionName, double additionPrice){
        addition3Name = additionName;
        addition3Price = additionPrice;
    }
    public void addHamburgerAddition4(String additionName, double additionPrice){
        addition4Name = additionName;
        addition4Price = additionPrice;
    }
    public double itemizedHamburger(){
        return price + addition1Price + addition2Price + addition3Price + addition4Price;
    }
}
