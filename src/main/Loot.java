package main;

public abstract class Loot {

    private String name; 
    private String rarity;


    public Loot(String name, String rarity){

        this.name = name;
        this.rarity = rarity;

    }

    public String getName(){
        return this.name;
    }

    public String getRarity(){
        return this.rarity;
    }

    public abstract String getEffectDescription();

    public abstract String asCsvRow();
}


