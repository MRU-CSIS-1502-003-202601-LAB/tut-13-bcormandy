package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Manages the inventory of RPG Loot.
 */
public class LootManager {
    private ArrayList<Loot> inventory;

    private LootManager() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Polymorphically displays all items in the inventory.
     */
    public void displayInventory() {
        System.out.println();
        System.out.println("--- Current Inventory ---");
        for (Loot item : inventory) {
            System.out.println(item.getName() + " [" + item.getRarity() + "] - " +
            item.getEffectDescription());
        }
        System.out.println("-------------------------");
        System.out.println();
    }


    public static LootManager load(String filePath) throws FileNotFoundException {

        LootManager lootManager = new LootManager();

        Scanner fileScanner = new Scanner(new File(filePath));

        fileScanner.nextLine(); // eating header .. if there is one .. 

         while (fileScanner.hasNextLine()) {
            String[] lootParts = fileScanner.nextLine().split(",");

            Loot loot = LootFactory.create(lootParts);
            lootManager.add(loot);
        }

        fileScanner.close();

        return lootManager;

    }

     public void add(Loot loot) {
        if (loot != null) {
            inventory.add(loot);
        }
    }

     public void save(String filePath) throws FileNotFoundException {

        PrintWriter fileWriter = new PrintWriter(new File(filePath));

        // 2. Remember to write the header.
        fileWriter.println("TYPE,NAME,RARITY,SPECIAL_1");

        for (Loot currLoot : inventory) {
            fileWriter.println(currLoot.asCsvRow());
        }
        fileWriter.close();

    }
}