package main;

public class Weapon extends Loot {

    private int damage;


    public Weapon(String name, String rarity, int damage){
        super(name, rarity);
        this.damage = damage;
    }

    @Override
    public String getEffectDescription() {

        return String.format("A %s %s that deals %d points of damage", getRarity(), getName(), this.damage);

    }

    @Override
    public String asCsvRow() {

        return String.format("%s,%s,%s,%d","Weapon",getName(),getRarity(),this.damage);

    }
    
    

    
}
