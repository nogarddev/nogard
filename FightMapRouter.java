import java.lang.*;
import java.util.*;
import java.io.*;
import java.math.*;;
public class FightMapRouter {
    public static String currentmap = "empty";
    public static String[][] covers = new String[100][100];
    public static void init() {
        covers[0][0] = "empty";
        if (currentmap.equals("TestFightMap")) {
            covers = testFightMap.covers;
            enemy_currentcover = testFightMap.enemy_starter;
            optimal_distance = testFightMap.optimal_distance;
            max_range = testFightMap.max_range;
            canmove = testFightMap.canmove;
        }
    }
    public static Integer optimal_distance;
    public static Integer max_range;
    public static Boolean canmove;
    public static String[] enemy_ranged = new String[]{};
    public static String[] enemy_melee = new String[]{};
    public static String[] covers_list = new String[]{};
    public static void update_distance() {
        String[] update_distance_temp1 = extractcover(covers, player_currentcover);
//        System.out.println(update_distance_temp1[1]);
        String[] update_distance_temp2 = extractcover(covers, enemy_currentcover);
        Float update_distance_temp11 = Float.parseFloat(update_distance_temp1[1]);
        Float update_distance_temp21 = Float.parseFloat(update_distance_temp2[1]);
        distance = Math.abs(update_distance_temp11 - update_distance_temp21);
    }
    public static void update_distance_setenemy(Integer enemy_y) {
        String[] update_distance_temp1 = extractcover(covers, player_currentcover);
//        System.out.println(update_distance_temp1[1]);
        Float update_distance_temp11 = Float.parseFloat(update_distance_temp1[1]);
        Float update_distance_temp21 = enemy_y * (float) 1;
        distance = Math.abs(update_distance_temp11 - update_distance_temp21);
    }
    public static void update_distance_setplayer(Integer player_y) {
//        System.out.println(update_distance_temp1[1]);
        String[] update_distance_temp2 = extractcover(covers, enemy_currentcover);
        Float update_distance_temp11 = player_y * (float) 1;
        Float update_distance_temp21 = Float.parseFloat(update_distance_temp2[1]);
        distance = Math.abs(update_distance_temp11 - update_distance_temp21);
    }
    public static Integer w = 0;
    public static void update_covers_list() {
        w = 0;
        covers_list = new String[]{};
//        System.out.println(covers[w][0]);
        while (covers[w][0].equals("empty") == false) {
            covers_list = concat(covers_list, new String[]{covers[w][0]});
//            System.out.println(covers[w][0]);
            w++;
        }
    }
    public static Integer enemy_y() {
        String[] update_distance_temp2 = extractcover(covers, enemy_currentcover);
        return Integer.parseInt(update_distance_temp2[1]);
    }
    public static Integer player_y() {
        String[] update_distance_temp2 = extractcover(covers, player_currentcover);
        return Integer.parseInt(update_distance_temp2[1]);
    }
    public static String player_currentcover;
    public static String enemy_currentcover;
    static final FightHandler fightHandler = new FightHandler();
    static final TestFightMap testFightMap = new TestFightMap();
    public static void update_variables() {
        if (currentmap.equals("empty") == false) {
            extractnames(covers);
            update_distance();//added this in without looking at consequences so try commenting this is any errors
            update_covers_list();
        }
    }
    public static String[] cover_names;
    public static void extractnames(String[][] arr) {
        Integer i = 0;
        Integer y = 0;
        cover_names = new String[]{};
        while (i < arr.length && (arr[i][0].equals("empty") == false)) {
            cover_names = mainlib.concat(cover_names, new String[]{arr[i][0]});
            i++;
        }
    }
    public static String[] extractcover(String[][] arr, String name) {
        Integer i = 0;
        Integer y = 0;
        String[] out = new String[]{};
        while (i < arr.length && arr[i][0].equals("empty") == false && (arr[i][0].equals(name)) == false) {
            i++;
        }
        out = arr[i];
        return out;
    }
    public static Boolean checkforamountinrange(Integer[] arr, Integer min, Integer max) {
        Integer lengthofarr = arr.length;
        Integer amount = amountinrange(arr, min, max);
        if (amount > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static Integer amountinrange(Integer[] arr, Integer min, Integer max) {
        Integer lengthofarr = arr.length;
        Integer out = 0;
        Integer loop = 0;
        while ((loop == lengthofarr) == false) {
//            System.out.println("amount: arr[loop] (" + arr[loop] + ") > min (" + min + ") = " + (arr[loop] > min));
//            System.out.println("amount: arr[loop] (" + arr[loop] + ") < max (" + max + ") = " + (arr[loop] < max));
            if (arr[loop] > min && arr[loop] < max) {
                out++;
            }
            loop++;
        }
        return out;
    }
    public static Integer[] grabinrange(Integer[] arr, Integer min, Integer max) {
//        Integer lengthofarr = amountinrange(arr, min, max);
        Integer lengthofarr = arr.length;
        Integer posofarr = 0;
        Integer[] out = new Integer[arr.length];
        Integer loop = 0;
        while ((loop == lengthofarr) == false) {
//            System.out.println("arr[loop] (" + arr[loop] + ") > min (" + min + ") = " + (arr[loop] > min));
//            System.out.println("arr[loop] (" + arr[loop] + ") < max (" + max + ") = " + (arr[loop] < max));
            if (arr[loop] > min && arr[loop] < max) {
                out[posofarr] = arr[loop];
                posofarr++;
//                System.out.println("entered: \"" + arr[loop] + "\"");
            }
//            System.out.println("passed: \"" + arr[loop] + "\"");
            loop++;
        }
        loop = 0;
        Integer amount = 0;
        while ((loop == out.length) == false) {
            if ((out[loop] == null) == false) {
                amount++;
            }
        loop++;
        }
        Integer[] out1 = new Integer[amountinrange(arr, min, max)];
        loop = 0;
        while ((loop == amount) == false){
//            System.out.println("out[" + loop + "] = " + out[loop]);
            out1[loop] = out[loop];
            loop++;
        }
//        System.out.println("out1.length = " + out1.length );
        return out1;
    }
    public static String convertytoname(Integer y) {
        Integer pos = 0;
        Integer lengthofarr = 0;
//        System.out.println("the wanted y for a conversion is :" + y);
        while (covers[lengthofarr][0].equals("empty") == false) {
            lengthofarr++;
        }
//        Integer cover_int = Integer.parseInt(covers[pos][1]);
//        while (cover_int == y && pos <= lengthofarr) {
//            cover_int = Integer.parseInt(covers[pos][1]);
//            pos++;
//        }
        while (covers[pos][1].equals(y.toString()) == false && pos <= lengthofarr) {
            pos++;
        }
        return covers[pos][0];
    }
    public static Float distance;
    public static String[] damage_covers_temp = new String[]{}; 
    public static void damage_cover(String name, Integer damage) {
        damage_covers_temp = extractcover(covers, name);
        damage_covers_temp[2] = String.valueOf(Integer.parseInt(damage_covers_temp[2]) - damage);
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
