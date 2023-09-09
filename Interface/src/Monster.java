import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name  +
                "', hitPoints=" + hitPoints +
                ", strength=" + strength +
                "}";
    }

    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        return List.of(getName(), String.valueOf(getHitPoints()),String.valueOf(getStrength()));
    }

    @Override
    public void read(List<String> list) {
        if(list != null && !list.isEmpty()){
            name = list.get(0);
            hitPoints = Integer.parseInt(list.get(1));
            strength = Integer.parseInt(list.get(2));
        }
    }
}
