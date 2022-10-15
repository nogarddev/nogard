import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;
public class FightHandler {
    final static FightMapRouter fightMapRouter = new FightMapRouter();
    static final Random rng = new Random();
    public static String[] extractranged(boolean non_empty, String[][] arr) {
        MainLib mainLib = new MainLib();
        Integer i = 0;
        Integer y = 0;
        String[] out = new String[]{};
        if (non_empty) {
            while (i < arr.length && (arr[i][0].equals("empty") == false)) {
//                System.out.println((arr[i][1].equals("empty") == false));
//                System.out.println((arr[i][3].equals("empty") == false));
//                System.out.println(arr[i][1]);
//                System.out.println(arr[i][2]);
//                System.out.println(arr[i][3]);
//                System.out.println((arr[i][1].equals("empty")) == false && (arr[i][3].equals("empty") == false));
                if ((arr[i][1].equals("empty") == false) && (arr[i][3].equals("empty") == false)) {
//                    System.out.println("a");
                    out = mainLib.concat(out, new String[] {arr[i][0]});
                }
                i++;
            }
            return out;
        } else {
            while (i < arr.length) {
                out = mainLib.concat(out, new String[] {arr[i++][0]});
            }
            return out;
        }
    }
    public static Integer player_health = 100;
    public static Integer enemy_health = 100;
    String[] outranged = new String[]{};
    public static String[] grabranged(String item, String[][] arr) {
        player_health = 100;
        enemy_health = 100;
        MainLib mainLib = new MainLib();
        Integer i = 0;
        Integer y = 0;
        String[] outranged = new String[]{};
        while (i < arr.length && (arr[i][0].equals("empty") == false)) {
            if (arr[i][0].equals(item)) {
                outranged = arr[i];
            }
            i++;
        }
        return outranged;
    }
    public static String[] player_ranged = {""};
    public static String[] options = {""};
    public static Float player_ranged_base_accuracy;
    public static Float player_ranged_accuracy_threshold;
    public static Float player_ranged_accuracy_dropoff;
    public static Float player_ranged_accuracy_minimum;
    public static Float player_ranged_base_damage;
    public static Float player_ranged_damage_threshold;
    public static Float player_ranged_damage_dropoff;
    public static Float player_ranged_damage_minimum;
    public static String player_ranged_element;
    public static Float player_ranged_weight;
    public static String player_ranged_durability;
    public static String[] enemy_ranged = new String[14];
    public static Float enemy_ranged_base_accuracy;
    public static Float enemy_ranged_accuracy_threshold;
    public static Float enemy_ranged_accuracy_dropoff;
    public static Float enemy_ranged_accuracy_minimum;
    public static Float enemy_ranged_base_damage;
    public static Float enemy_ranged_damage_threshold;
    public static Float enemy_ranged_damage_dropoff;
    public static Float enemy_ranged_damage_minimum;
    public static String enemy_ranged_element;
    public static Float enemy_ranged_weight;
    public static String enemy_ranged_durability;

    public static void view(String[] weapon) {
        nl();
        nl();
        lw("--------------------------------", "0");
        nl();
        lw("Statistics of " + weapon[0], "0");
        nl();
        nl();
        lw("Base accuracy: " + weapon[2] + "% chance of a hit", "0");
        nl();
        lw("Accuracy threshold: " + weapon[3] + " metres before accuracy dropoff", "0");
        nl();
        lw("Accuracy dropoff: -" + weapon[4] + "% chance of a successful hit per metre", "0");
        nl();
        lw("Accuracy minimum: " + weapon[5] + "% chance of a successful hit", "0");
        nl();
        lw("Base damage: " + weapon[6] + " health per successful successful hit", "0");
        nl();
        lw("Damage threshold: " + weapon[7] + " metres before damage dropoff", "0");
        nl();
        lw("Damage dropoff: -" + weapon[8] + " damage per successful hit per metre", "0");
        nl();
        lw("Damage minimum: " + weapon[9] + " damage per successful hit per metre", "0");
        nl();
        lw("Element: " + weapon[11], "0");
        nl();
        lw("Weight: " + weapon[12] + " kg", "0");
        nl();
        if (weapon[13].equals("empty")) {
            lw("Durability: infinite", "0");
        } else{
            lw("Durability: " + weapon[13], "0");
        }
        nl();
        lw("--------------------------------", "0");
        nl();
        nl();
    }
    public static void viewcover(String[] cover) {
        nl();
        nl();
        lw("--------------------------------", "0");
        nl();
        lw("Statistics of " + cover[0], "0");
        nl();
        nl();
        lw("Distance from middle: " + cover[1] + " metres", "0");
        nl();
        lw("Health: " + cover[2] + " hp", "0");
        nl();
        lw("Coverage: " + Integer.parseInt(cover[3]) + "% chance decrease of a successful hit", "0");
        nl();
        lw("Chance of missing and hitting a civillian: " + cover[4] + "% chance of hitting a civillian", "0");
        nl();
        lw("--------------------------------", "0");
        nl();
        nl();
    }
    public static void view_at_start(String[] options) {
        mainlib.choice = mainlib.choices(true, "30", false, mainlib.concat(options, new String[]{"cancel"}));
        if (mainlib.choice.equals("cancel") == false) {
            view(grabranged(mainlib.choice, mainlib.inventory));
        }
    }
    public static void FightStarter() {
        mainlib.choice = "no";
        cls();
        while (mainlib.choice.equals("no")) {
            options = extractranged(true, mainlib.inventory);
            at("Choose your weapon or type view to view a weapons statistics:", "30", true);
            nl();
            mainlib.choice = mainlib.choices(true, "30", false, mainlib.concat(options, new String[]{"view"}));
            player_ranged = grabranged(mainlib.choice, mainlib.inventory);
            if (mainlib.choice.equals("view")) {
                view_at_start(options);
                mainlib.choice = "no";
            } else {
                at("You have selected: " + mainlib.choice, "30", true);
                nl();
                at("Is this correct?", "30", true);
                nl();
                mainlib.choice = mainlib.choices(true, "30", true, new String[]{"yes", "no"});
            }
        }
        enemy_ranged = fightMapRouter.enemy_ranged;
        player_ranged_base_accuracy = Float.parseFloat(player_ranged[2]);
        player_ranged_accuracy_threshold = Float.parseFloat(player_ranged[3]);
        player_ranged_accuracy_dropoff = Float.parseFloat(player_ranged[4]);
        player_ranged_accuracy_minimum = Float.parseFloat(player_ranged[5]);
        player_ranged_base_damage = Float.parseFloat(player_ranged[6]);
        player_ranged_damage_threshold = Float.parseFloat(player_ranged[7]);
        player_ranged_damage_dropoff = Float.parseFloat(player_ranged[8]);
        player_ranged_damage_minimum = Float.parseFloat(player_ranged[9]);
        player_ranged_element = player_ranged[11];
        player_ranged_weight = Float.parseFloat(player_ranged[12]);
        player_ranged_durability = player_ranged[13];
        enemy_ranged_base_accuracy = Float.parseFloat(enemy_ranged[2]);
        enemy_ranged_accuracy_threshold = Float.parseFloat(enemy_ranged[3]);
        enemy_ranged_accuracy_dropoff = Float.parseFloat(enemy_ranged[4]);
        enemy_ranged_accuracy_minimum = Float.parseFloat(enemy_ranged[5]);
        enemy_ranged_base_damage = Float.parseFloat(enemy_ranged[6]);
        enemy_ranged_damage_threshold = Float.parseFloat(enemy_ranged[7]);
        enemy_ranged_damage_dropoff = Float.parseFloat(enemy_ranged[8]);
        enemy_ranged_damage_minimum = Float.parseFloat(enemy_ranged[9]);
        enemy_ranged_element = enemy_ranged[11];
        enemy_ranged_weight = Float.parseFloat(enemy_ranged[12]);
        enemy_ranged_durability = enemy_ranged[13];
        FightHandler();
    }
    public static void FightHandler() {
        at("Move to where?", "30", true);
        nl();
        fightMapRouter.update_covers_list();
        mainlib.choice = mainlib.choices(true, "30", true, fightMapRouter.covers_list);
        fightMapRouter.player_currentcover = mainlib.choice;
        while ((player_health <= 0 || enemy_health <= 0) == false) {
            cancelled = false;
            if (skip_health_declare) {
                skip_health_declare = false;
            } else {
                at("Enemy health: " + enemy_health, "30", true);
                nl();
                at("Player health: " + player_health, "30", true);
                nl();
            }
            mainlib.choice = mainlib.choices(true, "30", true, new String[]{"move", "shoot", "view"});
            if (mainlib.choice.equals("move")) {
                move();
//                at("Move to where?", "30", true);
//                nl();
//                fightMapRouter.update_variables();
//                mainlib.choice = mainlib.choices(true, "30", true, mainlib.concat(fightMapRouter.covers_list, new String[]{"cancel"}));
//                fightMapRouter.player_currentcover = mainlib.choice;
            }
            if (mainlib.choice.equals("shoot")) {
                shoot();
            }
            if (mainlib.choice.equals("view")) {
                at("View what?", "30", true);
                nl();
                choice1 = mainlib.choices(true, "30", true, new String[]{"covers","gun","positions","cancel"});
                if (choice1.equals("positions")) {
                    nl();
                    nl();
                    lw("--------------------------------", "0");
                    nl();
                    lw("Statistics of positions", "0");
                    nl();
                    nl();
                    lw("Player's cover: " + fightMapRouter.player_currentcover, "0");
                    nl();
                    lw("Enemy's cover: " + fightMapRouter.enemy_currentcover, "0");
                    nl();
                    lw("Distance between player and enemy: " + fightMapRouter.distance, "0");
                    nl();
                    lw("--------------------------------", "0");
                    nl();
                    nl();
                }
                if (choice1.equals("covers")) {
                    fightMapRouter.update_variables();
                    mainlib.choice = mainlib.choices(true, "30", true, fightMapRouter.covers_list);
                    Integer i = 0;
                    while (fightMapRouter.covers[i][0].equals(mainlib.choice) == false) {
                        i++;
                    }
                    viewcover(fightMapRouter.covers[i]);
                }
                if (choice1.equals("gun")) {
                    view(player_ranged);
                }
                cancelled = true;
            }
            fightMapRouter.update_variables();
            if (cancelled == false && enemy_health > 0) {
                enemy_ai();
            }
        }
        if (player_health <= 0) {
            at("Player died!", "30", true);
        }
        if (enemy_health <= 0) {
            at("Enemy died!", "30", true);
        }
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
    }
    public static String choice1;
    public static Integer amount_of_covers;
    public static Integer amount_of_covers1;
    public static Integer ai_loop_temp2;
    public static Integer ai_loop_temp1;
    public static Integer ai_loop_temp;
    public static Integer ai_range;
    public static Integer player_y;
    public static Integer ai_highest_temp;
    public static Integer[] ai_highest_arr;
    public static Integer[] ai_highest_arr_distance;
    public static String[] ai_highest_arr_str;
    public static String ai_highest_temp_name;
    public static String[] ai_temp;
    public static Integer[] ai_options;
    public static Integer ai_options_amount;
    public static Integer ai_rng_temp;
    public static String ai_current_y;
    public static Integer ai_current_y_int;
    public static String chosen;
    public static String[] ai_current_y_temp;
    public static Integer ai_highest_pos;
    public static String[][] ai_covers_temp;
    public static void enemy_ai() {
        ai_covers_temp = fightMapRouter.covers;
        amount_of_covers = 0;
        ai_loop_temp = 0;
        ai_loop_temp1 = 0;
        while (ai_covers_temp[amount_of_covers][0].equals("empty") == false) {
            amount_of_covers++;
        }
        ai_highest_temp = Integer.parseInt(ai_covers_temp[ai_loop_temp][1]);
        ai_highest_pos = ai_loop_temp;
        ai_highest_temp_name = ai_covers_temp[ai_loop_temp][1];
        ai_loop_temp++;
        ai_highest_arr = new Integer[amount_of_covers];
        ai_highest_arr_str = new String[amount_of_covers];
        amount_of_covers--;
        amount_of_covers1 = amount_of_covers;
        Integer testi = 0;
        while (testi < ai_highest_arr.length) {
//            System.out.println("ai_covers_temp[" + testi + "] = " + ai_covers_temp[testi][1]);
            testi++;
        }
        while ((ai_loop_temp1 > amount_of_covers) == false) {
            ai_loop_temp = 0;
            while ((ai_loop_temp > amount_of_covers1) == false) {
                while (testi < ai_highest_arr.length) {
//                    System.out.println("ai_covers_temp[" + testi + "] = " + ai_covers_temp[testi][1]);
                    testi++;
                }
                if (Integer.parseInt(ai_covers_temp[ai_loop_temp][1]) > ai_highest_temp) {
                    ai_highest_temp = Integer.parseInt(ai_covers_temp[ai_loop_temp][1]); // it will just keep on reselecting the highest one as it does not get removed, logic error causes the array to be just 3 as it isnt told to not do 3, just exclude the last number added and it will be fine
                    ai_highest_temp_name = ai_covers_temp[ai_loop_temp][0];
                    ai_highest_pos = ai_loop_temp;
                }
//                System.out.println(ai_highest_pos);
//                System.out.println("ai_loop_temp = " + ai_loop_temp + " and ai_covers_temp[ai_loop_temp][1] = " + ai_covers_temp[ai_loop_temp][1]);
                ai_loop_temp++;
            }
            ai_highest_arr[ai_loop_temp1] = ai_highest_temp;
            ai_highest_arr_str[ai_loop_temp1] = ai_highest_temp_name;
            ai_loop_temp1++;
            ai_highest_temp = -2147483648;
            ai_covers_temp = mainlib.exclude2dstrarr(ai_covers_temp, 5, ai_highest_pos, 1);
            amount_of_covers1--;
            ai_highest_pos = 0;
        }
        testi = 0;
        while (testi < ai_highest_arr.length) {
//            System.out.println("ai_highest_arr[" + testi + "] = " + ai_highest_arr[testi]);
            testi++;
        }
        fightMapRouter.update_variables();
//        System.out.println("I have reached line 201");
        player_y = Math.round(fightMapRouter.distance);
        ai_loop_temp2 = 0;
        ai_highest_arr_distance = ai_highest_arr;
        while ((ai_loop_temp2 > amount_of_covers) == false) {
            ai_highest_arr_distance[ai_loop_temp2] = (ai_highest_arr[ai_loop_temp2] - fightMapRouter.player_y());//used to have Math.abs(ai_highest_arr[ai_loop_temp2] - fightMapRouter.player_y())
            ai_loop_temp2++;
        }
//        System.out.println("I have reached line 212");
        ai_range = 1;
        if (fightMapRouter.enemy_y() > fightMapRouter.player_y()) {
//            while (fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) + ai_range) < 3 && ai_range < fightMapRouter.max_range && fightMapRouter.canmove) {
//                ai_range++;
//            }
//            ai_options_amount = fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) + ai_range);
//            ai_temp = fightMapRouter.extractcover(fightMapRouter.covers, fightMapRouter.enemy_currentcover);
//            ai_options = fightMapRouter.grabinrange(ai_highest_arr_distance, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) + ai_range);




            while ((fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) + ai_range) < 3 && ai_range < fightMapRouter.max_range && fightMapRouter.canmove) || (fightMapRouter.canmove && (ai_range < fightMapRouter.max_range == false) && fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) + ai_range) < 1)) {
                ai_range++;
                System.out.println(((fightMapRouter.player_y() + fightMapRouter.optimal_distance) - ai_range) + "min");
                System.out.println(((fightMapRouter.player_y() + fightMapRouter.optimal_distance) + ai_range) + "max");
                System.out.println(fightMapRouter.player_y());
            }
            ai_options_amount = fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) + ai_range);
            ai_temp = fightMapRouter.extractcover(fightMapRouter.covers, fightMapRouter.enemy_currentcover);
            ai_options = fightMapRouter.grabinrange(ai_highest_arr_distance, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() + fightMapRouter.optimal_distance) + ai_range);
            System.out.println("min" + ((fightMapRouter.player_y() + fightMapRouter.optimal_distance) - ai_range));
            System.out.println("max" + ((fightMapRouter.player_y() + fightMapRouter.optimal_distance) + ai_range));
            i = 0;
            while (i < ai_options.length) {
                ai_options[i] = ai_options[i] + fightMapRouter.player_y();
                i++;
            }













        } else {
//            while (fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) + ai_range) < 3 && ai_range < fightMapRouter.max_range && fightMapRouter.canmove) {
            while ((fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) + ai_range) < 3 && ai_range < fightMapRouter.max_range && fightMapRouter.canmove) || (fightMapRouter.canmove && (ai_range < fightMapRouter.max_range == false) && fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) + ai_range) < 1)) {
                ai_range++;
                System.out.println(((fightMapRouter.player_y() - fightMapRouter.optimal_distance) - ai_range) + "min");
                System.out.println(((fightMapRouter.player_y() - fightMapRouter.optimal_distance) + ai_range) + "max");
                System.out.println(fightMapRouter.player_y());
            }
            ai_options_amount = fightMapRouter.amountinrange(ai_highest_arr_distance, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) + ai_range);
            ai_temp = fightMapRouter.extractcover(fightMapRouter.covers, fightMapRouter.enemy_currentcover);
            ai_options = fightMapRouter.grabinrange(ai_highest_arr_distance, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) - ai_range, (fightMapRouter.player_y() - fightMapRouter.optimal_distance) + ai_range);
            System.out.println("min" + ((fightMapRouter.player_y() - fightMapRouter.optimal_distance) - ai_range));
            System.out.println("max" + ((fightMapRouter.player_y() - fightMapRouter.optimal_distance) + ai_range));
            i = 0;
            while (i < ai_options.length) {
                ai_options[i] = ai_options[i] + fightMapRouter.player_y();
                i++;
            }
        }
//        System.out.println("I have reached line 217");
        ai_current_y_temp = fightMapRouter.extractcover(fightMapRouter.covers, fightMapRouter.enemy_currentcover);
        ai_current_y = ai_current_y_temp[1];
        testi = 0;
        while ((testi == ai_options.length) == false) {
            System.out.println("ai_options [" + testi + "] = " + ai_options[testi]);
            testi++;
        }
        testi = 0;
        while ((testi == ai_current_y_temp.length) == false) {
            System.out.println("ai_current_y_temp[" + testi + "] = " + ai_current_y_temp[testi]);
            testi++;
        }
        System.out.println("ai_current_y = " + ai_options_amount);
        System.out.println("ai_options_amount = " + ai_options_amount);
        System.out.println("fightMapRouter.canmove = " + fightMapRouter.canmove);
        System.out.println("ai_temp[2] = " + ai_temp[2]);
        System.out.println("Integer.parseInt(ai_temp[2]) = " + Integer.parseInt(ai_temp[2]));
        System.out.println("parseint(ai_current_y) = ");
        System.out.println(Integer.parseInt(ai_current_y));
        ai_current_y_int = Integer.parseInt(ai_current_y);
        
        if (((Integer.parseInt(ai_temp[2]) == 0 && rng.nextInt(101) < 99) || rng.nextInt(101) < 80) && fightMapRouter.canmove && ai_options_amount > 0) {
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            ai_rng_temp = rng.nextInt(ai_options_amount);
            System.out.println("ai_options[" + ai_rng_temp + "] = " + ai_options[ai_rng_temp]);
            testi = 0;
            while (testi < ai_options.length) {
                System.out.println("ai_options[" + testi + "] = " + ai_options[testi]);
                testi++;
            }
            System.out.println("ai_options.length = " + ai_options.length);
            System.out.println("ai_rng_temp = " + ai_rng_temp);
            System.out.println("ai_options[ai_rng_temp] == ai_current_y_int = " + (ai_options[ai_rng_temp] == ai_current_y_int));
            System.out.println("ai_options.length > 1 = " + (ai_options.length > 1));
            System.out.println("ai_rng_temp == 2 = " + (ai_rng_temp == 2));
//            ai_rng_temp
            while (ai_options[ai_rng_temp] == ai_current_y_int && ai_options.length > 1 || (false && ai_rng_temp == 2)) {
                //                System.out.println("ai_options_amount = " + ai_options_amount);
                //                System.out.println("ai_options.length = " + ai_options.length);
                //                System.out.println("ai_options[ai_rng_temp] = " + ai_options[ai_rng_temp]);
                //                System.out.println("ai_options = " + ai_options);
                //                System.out.println("Integer.parseInt(ai_current_y) = " + Integer.parseInt(ai_current_y));
                ai_rng_temp = rng.nextInt(ai_options_amount);
                //                System.out.println("ai_rng_temp = " + ai_rng_temp);
                testi = 0;
                while (testi < ai_options.length) {
                    System.out.println("ai_options[" + testi + "] = " + ai_options[testi]);
                    testi++;
                }
                System.out.println("ai_rng_temp = " + ai_rng_temp);
                System.out.println("ai_options[ai_rng_temp] = " + ai_options[ai_rng_temp]);
            }

            //            System.out.println("I have reached line 228");
            chosen = fightMapRouter.convertytoname(ai_options[ai_rng_temp]);
            System.out.println("chosen = " + chosen);
            //            fightMapRouter.enemy_currentcover = chosen;
            enemy_move(chosen);
        } else {
            //            System.out.println("I have reached line 233");
            enemyshoot();
            //            System.out.println("enemy has shot");
        }
        //        System.out.println("I have reached line 236");
    }
    static Integer i = 0;
    static Integer attack_chance;
    static Integer potential_damage;
    public static void shoot() {
        fightMapRouter.update_variables();
        fightMapRouter.update_distance();
        if (moving) {
            tempdistance = Math.round(fightMapRouter.distance);
            fightMapRouter.distance = tempdistance * (float) 1;
        }
        Integer distance_int = Math.round(fightMapRouter.distance);
        String[] enemy_cover = fightMapRouter.extractcover(fightMapRouter.covers, fightMapRouter.enemy_currentcover);
        if (distance_int < player_ranged_damage_threshold) {
            potential_damage = Math.round(player_ranged_base_damage);
        } else {
            potential_damage = Math.round(player_ranged_base_damage - (player_ranged_damage_dropoff * (distance_int - player_ranged_damage_threshold)));
            if (potential_damage < player_ranged_damage_minimum) {
                potential_damage = Math.round(player_ranged_damage_minimum);
            }
        }
        if (distance_int < player_ranged_damage_threshold) {
            attack_chance = Math.round(player_ranged_base_accuracy);
        } else {
            attack_chance = Math.round(player_ranged_base_accuracy  - (player_ranged_accuracy_dropoff * (distance_int - player_ranged_accuracy_threshold)));
            if (attack_chance < player_ranged_accuracy_minimum) {
                attack_chance = Math.round(player_ranged_accuracy_minimum);
            }
        }
        attack_chance = Math.round(((attack_chance) * (Float.valueOf(enemy_cover[3]) / 100) / (float) 1));
        at("You aim down your sights with a " + attack_chance + "% chance to hit your target", "30", true);
        nl();
        at("At this angle, if this bullet hits them it would deal " + potential_damage + " damage", "30", true);
        at("...", "500", true);
        nl();
        mainlib.playsongFx("gunshot_1.wav");
//        System.out.println("potential_damage: " + potential_damage);
//        System.out.println("attack_chance: " + attack_chance);
//        System.out.println(rng.nextInt(101));
        if (attack_chance < rng.nextInt(101)) {
            at("Hit!", "30", true);
            enemy_health = enemy_health - potential_damage;
//            System.out.println("attacked!");
        } else {
            at("Miss!", "30", true);
        }
        if (moving) {
            fightMapRouter.distance = tempdistance * (float) 1;
        }
    }
    public static Integer player_distance1;
    public static Boolean cancelled = false;
    public static Integer player_distance2;
    public static String[] player_distance1arr;
    public static String[] player_distance2arr;
    public static Integer player_movement_distance;
    public static Integer player_movement_distance_loop;
    public static void move() {
        at("Move to where?", "30", true);
        nl();
        fightMapRouter.update_covers_list();
        mainlib.choice = mainlib.choices(true, "30", true, mainlib.concat(fightMapRouter.covers_list, new String[]{"cancel"}));
        if (mainlib.choice.equals("cancel") == false) {
            player_distance1arr = fightMapRouter.extractcover(fightMapRouter.covers, fightMapRouter.player_currentcover);
            player_distance1 = Integer.valueOf(player_distance1arr[1]);
            player_distance2arr = fightMapRouter.extractcover(fightMapRouter.covers, mainlib.choice);
            player_distance2 = Integer.valueOf(player_distance2arr[1]);
            player_movement_distance = Math.abs(player_distance1 - player_distance2);
            player_movement_distance_loop = 0;
            while (player_movement_distance_loop < player_movement_distance) {
                at("You have moved " + player_movement_distance_loop.toString() + " metres out of " + player_movement_distance.toString() + " metres.", "30", true);
                nl();
                mainlib.playsongFx("footsteps.wav");
                at("...", "500", true);
                nl();
                if (20 > rng.nextInt(101)) {
                    moving = true;
                    if (player_distance1 < player_distance2) {
                        tempdistance = player_distance1 + player_movement_distance_loop;
                    } else {
                        tempdistance = player_distance1 - player_movement_distance_loop;
                    }
                    enemyshoot();
//                    mainlib.playsongFx("gunshot_1.wav");
//                    timeout("300");
//                    at("You have been shot...", "30", true);
                    moving = false;
                }
                at("Enemy health: " + enemy_health.toString(), "30", true);
                nl();
                at("Player health: " + player_health.toString(), "30", true);
                nl();
                player_movement_distance_loop++;
            }
            fightMapRouter.player_currentcover = mainlib.choice;
        } else {
            cancelled = true;
        }
        skip_health_declare = true;
    }
    public static Boolean moving = false;
    public static Integer tempdistance = 0;
    public static Boolean skip_health_declare = false;
    public static Integer enemy_distance1;
    public static Integer enemy_distance2;
    public static String[] enemy_distance1arr;
    public static String[] enemy_distance2arr;
    public static Integer enemy_movement_distance;
    public static Integer enemy_movement_distance_loop;
    public static void enemy_move(String moveto) {
        fightMapRouter.update_covers_list();
        enemy_distance1arr = fightMapRouter.extractcover(fightMapRouter.covers, fightMapRouter.enemy_currentcover);
        enemy_distance1 = Integer.valueOf(enemy_distance1arr[1]);
        enemy_distance2arr = fightMapRouter.extractcover(fightMapRouter.covers, moveto);
        enemy_distance2 = Integer.valueOf(enemy_distance2arr[1]);
        enemy_movement_distance = Math.abs(enemy_distance1 - enemy_distance2);
        enemy_movement_distance_loop = 0;
        while (enemy_movement_distance_loop < enemy_movement_distance) {
            at("Enemy has moved " + enemy_movement_distance_loop.toString() + " metres out of " + enemy_movement_distance.toString() + " metres.", "30", true);
            nl();
            mainlib.playsongFx("footsteps.wav");
            at("...", "500", true);
            nl();
            if (20 > rng.nextInt(101)) {
                moving = true;
                    moving = true;
                    if (enemy_distance1 < enemy_distance2) {
                        tempdistance = enemy_distance1 + enemy_movement_distance_loop;
                    } else {
                        tempdistance = enemy_distance1 - enemy_movement_distance_loop;
                    }
                    shoot();
//                    mainlib.playsongFx("gunshot_1.wav");
//                    timeout("300");
//                    at("You have been shot...", "30", true);
                    moving = false;
            }
            at("Enemy health: " + enemy_health.toString(), "30", true);
            nl();
            at("Player health: " + player_health.toString(), "30", true);
            nl();
            enemy_movement_distance_loop++;
        }
        fightMapRouter.enemy_currentcover = moveto;
        fightMapRouter.update_variables();
        skip_health_declare = true;
    }
    public static void enemyshoot() {
        fightMapRouter.update_variables();
        fightMapRouter.update_distance();
        if (moving) {
            Integer temp_distance = Math.round(fightMapRouter.distance);
            fightMapRouter.distance = tempdistance * (float) 1;
        }
        Integer distance_int = Math.round(fightMapRouter.distance);
        String[] player_cover = fightMapRouter.extractcover(fightMapRouter.covers, fightMapRouter.player_currentcover);
        if (distance_int < enemy_ranged_damage_threshold) {
            potential_damage = Math.round(enemy_ranged_base_damage);
        } else {
            potential_damage = Math.round(enemy_ranged_base_damage - (enemy_ranged_damage_dropoff * (distance_int - enemy_ranged_damage_threshold)));
            if (potential_damage < enemy_ranged_damage_minimum) {
                potential_damage = Math.round(enemy_ranged_damage_minimum);
            }
        }
        if (distance_int < enemy_ranged_damage_threshold) {
            attack_chance = Math.round(enemy_ranged_base_accuracy);
        } else {
            attack_chance = Math.round(enemy_ranged_base_accuracy  - (enemy_ranged_accuracy_dropoff * (distance_int - enemy_ranged_accuracy_threshold)));
            if (attack_chance < enemy_ranged_accuracy_minimum) {
                attack_chance = Math.round(enemy_ranged_accuracy_minimum);
            }
        }
        attack_chance = Math.round(((attack_chance) * (Float.valueOf(player_cover[3]) / 100) / (float) 1));
        at("Your enemy aims down their sights with a " + attack_chance + "% chance to hit you.", "30", true);
        nl();
        at("At this angle, if this bullet hits you it would deal " + potential_damage + " damage", "30", true);
        at("...", "500", true);
        nl();
        mainlib.playsongFx("gunshot_1.wav");
//        System.out.println("potential_damage: " + potential_damage);
//        System.out.println("attack_chance: " + attack_chance);
//        System.out.println(rng.nextInt(101));
        if (attack_chance < rng.nextInt(101)) {
            at("Hit!", "30", true);
            nl();
            player_health = player_health - potential_damage;
//            System.out.println("attacked!");
        } else {
            at("Miss!", "30", true);
            nl();
        }
        if (moving) {
            fightMapRouter.distance = tempdistance * (float) 1;
        }
    }
    final static MainLib mainlib = new MainLib();
    public static String choices(Boolean threaded, String ms, Boolean skip_spaces, String args[]) {
        return mainlib.choices(threaded, ms, skip_spaces, args);
    }
    public static void stopFx() {
        mainlib.stopFx();
    }
    public static void stop() {
        mainlib.stop();
    }
    public static void at(String string, String ms, boolean skip_spaces) {
        mainlib.at(string, ms, skip_spaces);
    }
    public static void at1(String string, String ms, boolean skip_spaces) {
        mainlib.at1(string, ms, skip_spaces);
    }
    public static void intro_screen_wall() {
        mainlib.intro_screen_wall();
    }
    public static String getinput() {
        return mainlib.getinput();
    }
    public static void playsongFx(String name) {
        mainlib.playsongFx(name);
    }
    public static void playsong(String name) {
        mainlib.playsong(name);
    }
    public static void timeout(String ms) {
        mainlib.timeout(ms);
    }
    public static void enter_break() {
        mainlib.enter_break();
    }
    public static void timeout1(String ms) {
        try {
            mainlib.timeout1(ms);
        } catch (Exception x) {
            //blank
        }
    }
    public static String[] concat(String one[], String two[]) {
        return mainlib.concat(one, two);
    }
    public static void startmin(String name) {
        mainlib.startmin(name);
    }
    public static void startmin1(String name) throws IOException {
        mainlib.startmin1(name);
    }
    public static void nl() {
        mainlib.nl();
    }
    public static void lw(String text, String ms) {
        mainlib.lw(text, ms);
    }
    public static void cls() {
        mainlib.cls();
    }
    public static void showmap() {
        mainlib.showmap();
    }
    public static String colour(String string) {
        return mainlib.colour(string);
    }

}
