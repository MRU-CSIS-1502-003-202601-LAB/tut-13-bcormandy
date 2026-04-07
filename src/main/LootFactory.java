package main;

public class LootFactory {

    private static final int EXPECTED_NUM_FIELDS = 4;


    public static Loot create(String[] csvRecord){

        // If the csvRecord is null, or doesn't have exactly (i stole this code from you)
        if (csvRecord == null || csvRecord.length != EXPECTED_NUM_FIELDS) {
            return null;
        }

        String typeField = csvRecord[0]; // just in case

        // Every Loot has these attributes.
        String type = csvRecord[0];
        String name = csvRecord[1];
        String rarity =csvRecord[2];

        switch (typeField) {
            case "Consumable":
                int restoreAmount = Integer.parseInt(csvRecord[3]);
                return new Consumable(name, rarity, restoreAmount);
            case "Weapon":
                int damage = Integer.parseInt(csvRecord[3]);
                return new Weapon(name, rarity, damage);
            default:
                // If we get here, we found an unexpected entity type!
                System.out.printf("Skipping unknown Looooot type %s.", typeField);
                return null;

    }
    
}}
