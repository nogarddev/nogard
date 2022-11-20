import java.lang.*;
public class Maputils {
    static MainLib mainLib = new MainLib();
    static MapHandler mapHandler = new MapHandler();
    static FightHandler fightHandler = new FightHandler();
    static Shops shops = new Shops();
    static String option1;
    static String[] item;
    public static String currentshop;
    public static Float money = (float) 0;
    public static void reduce(Float amount) {
        money = money - amount;
    }
    public static void increase(Float amount) {
        money = money + amount;
    }
    public static void view_non_weapon(String[] item) {
        mainLib.nl();
        mainLib.nl();
        mainLib.lw("--------------------------------", "0");
        mainLib.nl();
        mainLib.lw("Statistics of " + item[0], "0");
        mainLib.nl();
        mainLib.nl();
        if (item[11].equals("empty")) {
            mainLib.lw("Element: none", "0");            
        } else {
            mainLib.lw("Weight: " + item[11] + " kg", "0");
        }
        mainLib.nl();
        if (item[12].equals("empty")) {
            mainLib.lw("Weight: 0kg", "0");            
        } else {
            mainLib.lw("Weight: " + item[12] + " kg", "0");
        }
        mainLib.nl();
        if (item[13].equals("empty")) {
            mainLib.lw("Durability: infinite", "0");
        } else{
            mainLib.lw("Durability: " + item[13], "0");
        }
        mainLib.nl();
        mainLib.lw("Price: " + item[14], "0");
        mainLib.nl();
        mainLib.lw("--------------------------------", "0");
        mainLib.nl();
        mainLib.nl();
    }
    public static void view(String[] weapon) {
        mainLib.nl();
        mainLib.nl();
        mainLib.lw("--------------------------------", "0");
        mainLib.nl();
        mainLib.lw("Statistics of " + weapon[0], "0");
        mainLib.nl();
        mainLib.nl();
        mainLib.lw("Base accuracy: " + weapon[2] + "% chance of a hit", "0");
        mainLib.nl();
        mainLib.lw("Accuracy threshold: " + weapon[3] + " metres before accuracy dropoff", "0");
        mainLib.nl();
        mainLib.lw("Accuracy dropoff: -" + weapon[4] + "% chance of a successful hit per metre", "0");
        mainLib.nl();
        mainLib.lw("Accuracy minimum: " + weapon[5] + "% chance of a successful hit", "0");
        mainLib.nl();
        mainLib.lw("Base damage: " + weapon[6] + " health per successful successful hit", "0");
        mainLib.nl();
        mainLib.lw("Damage threshold: " + weapon[7] + " metres before damage dropoff", "0");
        mainLib.nl();
        mainLib.lw("Damage dropoff: -" + weapon[8] + " damage per successful hit per metre", "0");
        mainLib.nl();
        mainLib.lw("Damage minimum: " + weapon[9] + " damage per successful hit per metre", "0");
        mainLib.nl();
        mainLib.lw("Element: " + weapon[11], "0");
        mainLib.nl();
        mainLib.lw("Weight: " + weapon[12] + " kg", "0");
        mainLib.nl();
        if (weapon[13].equals("empty")) {
            mainLib.lw("Durability: infinite", "0");
        } else{
            mainLib.lw("Durability: " + weapon[13], "0");
        }
        mainLib.nl();
        mainLib.lw("Price: " + weapon[14], "0");
        mainLib.nl();
        mainLib.lw("--------------------------------", "0");
        mainLib.nl();
        mainLib.nl();
    }
    public static void viewmelee(String[] weapon) {
        mainLib.nl();
        mainLib.nl();
        mainLib.lw("--------------------------------", "0");
        mainLib.nl();
        mainLib.lw("Statistics of " + weapon[0], "0");
        mainLib.nl();
        mainLib.nl();
        mainLib.lw("Base damage: " + weapon[10] + " health per hit", "0");
        mainLib.nl();
        mainLib.lw("Element: " + weapon[11], "0");
        mainLib.nl();
        mainLib.lw("Weight: " + weapon[12] + " kg", "0");
        mainLib.nl();
        if (weapon[13].equals("empty")) {
            mainLib.lw("Durability: infinite", "0");
        } else{
            mainLib.lw("Durability: " + weapon[13], "0");
        }
        mainLib.nl();
        mainLib.lw("Price: " + weapon[14], "0");
        mainLib.nl();
        mainLib.lw("--------------------------------", "0");
        mainLib.nl();
        mainLib.nl();
    }
    public static void shop(String name) {
        while (mainLib.choice.equals("exit") == false) {
            option1 = "no";
            mainLib.choice = "-1";
            while ((option1.equals("yes") || mainLib.choice.equals("exit")) == false) {
                String[] options = shops.getshopitemnames(shops.locationtoshop(name));
                mainLib.choice = mainLib.choices(false, "30", true, mainLib.concat(options, new String[]{"view","exit"}));
                if (mainLib.choice.equals("view")) {
                    mainLib.at("Enter item you want to view: ", "30", true);
                    mainLib.nl();
                    mainLib.choice = mainLib.choices(false, "30", true, mainLib.concat(options, new String[]{"cancel"}));
                    if (mainLib.choice.equals("cancel") == false) {
                        String[] itemtoview = shops.getitem(shops.locationtoshop(name), mainLib.choice);
                        if (itemtoview[2].equals("empty") == false) {
                            view(itemtoview);
                        } else if (itemtoview[10].equals("empty") == false) {
                            viewmelee(itemtoview);
                        } else {
                            view_non_weapon(itemtoview);
                        }
                    }
                } else  if (mainLib.choice.equals("exit") == false) {
                    item = shops.getitem(shops.locationtoshop(name), mainLib.choice);
                    mainLib.at("Are you sure you want to buy \"" + item[0] + "\" for " + String.valueOf(Float.parseFloat(item[14])) + " money? You have: " + money + " money.", "30", true);
                    mainLib.nl();
                    option1 = mainLib.choices(false, "30", true, new String[]{"yes","no"});
                    if (option1.equals("yes")) {
                        if (money < Float.parseFloat(item[14])) {
                            mainLib.at("You dont have enough money!", "30", true);
                            mainLib.nl();
                        } else {
                            shops.buy(shops.locationtoshop(name), mainLib.choice);
                            mapHandler.give_item(new String[]{item[0],item[1],item[2],item[3],item[4],item[5],item[6],item[7],item[8],item[9],item[10],item[11],item[12],item[13]});
                            reduce(Float.parseFloat(item[14]));
                            mainLib.at("pleasure doing business with you!", "30", true);
                            mainLib.nl();
                        }
                    }
                }
            }
        }
    }
}
