import java.lang.*;
import java.util.*;
import java.io.*;
public class MapHandler {
    public static String[] options = new String[]{};
    public static String[] optionsa = new String[]{};
    public static Integer cancelled = 0;
    public static Integer dead = 0;
    public static String historicmap = "";
    public static Boolean dofakeanim = false;
    public static String skip = "0";
    final static Main main = new Main();
    final static Debugger debugger = new Debugger();
    final static Shops shops = new Shops();
    final static Maputils mapUtils = new Maputils();
    public static String lastmap;
    public static String lastcommand;
    public static String lastmap1;
    public static String lastcommand1;
    public static void game_prompt() {
        System.out.println("[s");
        Integer map_clear = 0;
        while (map_clear == mainlib.map_height) {
            System.out.println("[2K");
            map_clear++;
        }
        System.out.println("[2K");
        System.out.println("[2K");
        System.out.println("[2K");
        System.out.println("[2K");
        System.out.println("[2K");
        System.out.println("[u");
        historicmap = mainlib.currentmap;
        dofakeanim = true;
        mainlib.update_variables();
        if (lastcommand == null) {
            lastcommand = "empty";
        }
        if (lastmap == null) {
            lastmap = mainlib.currentmap;
        }
        if (lastcommand1 == null) {
            lastcommand1 = "empty";
        }
        if (lastmap1 == null) {
            lastmap1 = mainlib.currentmap;
        }
        while (mainlib.getbreakconditions() == false) {
            mainlib.update_variables();
//            at("test", "30", true);
            fakeanim();
//            mainlib.animupdate();
////            mainlib.stopanim();
//            timeout("200");
//            if (mainlib.animation) {
//                System.out.print("[" + mainlib.map_height + "B");
////                System.out.print("oofus");
//
//            } else {
////                System.out.print("oofusfalse");
//            }
//            System.out.println("a" + mainlib.animation + "animation");
//            System.out.println("a" + mainlib.map_height + "height");
            Integer i = 0;
            options = new String[]{};
            optionsa = new String[]{};
            if (mainlib.usables[0][0].equals("empty") == false) {
                options = mainlib.concat(options, new String[] {"use"});
                i++;
            }
            if (mainlib.grabables[0][0].equals("empty") == false) {
                options = mainlib.concat(options, new String[] {"grab"});
                i++;
            }
            if (mainlib.up.equals("empty") == false) {
                options = mainlib.concat(options, new String[] {"up"});
                i++;
            }
            if (mainlib.down.equals("empty") == false) {
                options = mainlib.concat(options, new String[] {"down"});
                i++;
            }
            if (mainlib.north.equals("empty") == false) {
                options = mainlib.concat(options, new String[] {"north"});
                i++;
            }
            if (mainlib.east.equals("empty") == false) {
                options = mainlib.concat(options, new String[] {"east"});
                i++;
            }
            if (mainlib.south.equals("empty") == false) {
                options = mainlib.concat(options, new String[] {"south"});
                i++;
            }
            if (mainlib.west.equals("empty") == false) {
                options = mainlib.concat(options, new String[] {"west"});
                i++;
            }
            options = mainlib.concat(options, new String[] {"map"});
            if (shops.hasShop(mainlib.currentmap)) {
                options = mainlib.concat(options, new String[]{"shop"});
            }
            if (main.test) {
                mainlib.choice = mainlib.choices(true, "30", true, mainlib.concat(options, new String[]{"test"}));
            } else {
                mainlib.choice = mainlib.choices(true, "30", true, options);
            }
            lastcommand = lastcommand1;
            lastmap = lastmap1;
            lastcommand1 = mainlib.choice;
            lastmap1 = mainlib.currentmap;
            if (mainlib.choice.equals("test")) {
                debugger.run();
            }
            if (mainlib.choice.equals("map")) {
                showmap();
            }
            if (mainlib.choice.equals("up")) {
                mainlib.currentmap = mainlib.up;
            }
            if (mainlib.choice.equals("down")) {
                mainlib.currentmap = mainlib.down;
            }
            if (mainlib.choice.equals("north")) {
                mainlib.currentmap = mainlib.north;
            }
            if (mainlib.choice.equals("east")) {
                mainlib.currentmap = mainlib.east;
            }
            if (mainlib.choice.equals("south")) {
                mainlib.currentmap = mainlib.south;
            }
            if (mainlib.choice.equals("west")) {
                mainlib.currentmap = mainlib.west;
            }
            if ((mainlib.choice.equals("up")) || (mainlib.choice.equals("down")) || (mainlib.choice.equals("north")) || (mainlib.choice.equals("east")) || (mainlib.choice.equals("south")) || (mainlib.choice.equals("west"))) {
                playsongFx("footsteps.wav");
                mainlib.at("...", "500", true);
                System.out.print("[2K");
                System.out.print("[3D");
            }
            if (mainlib.choice.equals("use")) {
                cancelled = 0;
                options = new String[]{};
                optionsa = new String[]{};
                options = extract(true, mainlib.usables);
                i = 0;
                while (i < options.length) {
                    if (Arrays.asList(extract(true, mainlib.inventory)).contains(options[i])) {
                        optionsa = mainlib.concat(optionsa, new String[]{options[i]});
                    }
                    i++;
                } 
                mainlib.choice = mainlib.choices(true, "30", true, mainlib.concat(optionsa, new String[]{"cancel"}));
                if (mainlib.choice.equals("cancel")) {
                    cancelled = 1;
                }
                if (cancelled == 0) {
                    reduceuse(mainlib.choice);
                }
            }
            if (mainlib.choice.equals("grab")) {
                cancelled = 0;
                options = new String[]{};
                options = extract(true, mainlib.grabables);
                mainlib.choice = mainlib.choices(true, "30", true, mainlib.concat(options, new String[]{"cancel"}));
                if (mainlib.choice.equals("cancel")) {
                    cancelled = 1;
                }
                if (cancelled == 0) {
                    reducegrab(mainlib.choice);
                }
            }
            if (mainlib.choice.equals("shop")) {
                mapUtils.shop(mainlib.currentmap);
            }
        }
        lastmap = null;
        lastcommand = null;
        lastmap1 = null;
        lastcommand1 = null;
        if (dead == 1) {
            dead = 0;
            mainlib.currentmap = historicmap;
            game_prompt();
        }
        dofakeanim = false;
    }
    public static void reducegrab(String item) {
        Integer i = 0;
        String[] itemarray = {""};
        while (mainlib.grabables[i][0].equals(item) == false) {
            i++;
        }
        itemarray = mainlib.grabables[i];
        mainlib.grabables[i][1] = String.valueOf(Integer.parseInt(mainlib.grabables[i][1]) - 1);
        if (mainlib.grabables[i][1].equals("0")) {
            mainlib.grabables[i][1] = "empty";
        }
        if (mainlib.currentmap.equals("Ship_Up")) {
            Ship_Up ship_Up = new Ship_Up();
            ship_Up.grabables = mainlib.grabables;
        } else if (mainlib.currentmap.equals("Ship_Down")) {
            Ship_Down ship_Down = new Ship_Down();
            ship_Down.grabables = mainlib.grabables;
        } else if (mainlib.currentmap.equals("Hallway1")) {
            Hallway1 hallway1 = new Hallway1();
            hallway1.grabables = hallway1.grabables;
        } else if (mainlib.currentmap.equals("Hallway1_2")) {
            Hallway1_2 hallway1_2 = new Hallway1_2();
            hallway1_2.grabables = hallway1_2.grabables;
        } else if (mainlib.currentmap.equals("Downstairs_workhouse")) {
            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
            downstairs_workhouse.grabables = downstairs_workhouse.grabables;
        } else if (mainlib.currentmap.equals("North_Rinlund_Town_Center")) {
            North_Rinlund_Town_Center north_Rinlund_Town_Center = new North_Rinlund_Town_Center();
            north_Rinlund_Town_Center.grabables = north_Rinlund_Town_Center.grabables;
        } else if (mainlib.currentmap.equals("Start_forest_1")) {
            Start_forest_1 start_forest_1 = new Start_forest_1();
            start_forest_1.grabables = start_forest_1.grabables;
        } else if (mainlib.currentmap.equals("Room1")) {
            Room1 room1 = new Room1();
            room1.grabables = mainlib.grabables;
        } else if (mainlib.currentmap.equals("Workhouse_upstairs_north")) {
            Workhouse_upstairs_north workhouse_upstairs_north = new Workhouse_upstairs_north();
            workhouse_upstairs_north.grabables = mainlib.grabables;
        } else if (mainlib.currentmap.equals("Workhouse_upstairs_south")) {
            Workhouse_upstairs_south workhouse_upstairs_south = new Workhouse_upstairs_south();
            workhouse_upstairs_south.grabables = mainlib.grabables;
        }
        i = 0;
        Integer exist = 0;
//        while ((mainlib.inventory[i][0].equals(item) == false) && ((mainlib.inventory[i][0].equals("empty")) == false)) {
//            if (mainlib.inventory[i][0].equals(item)) {
//                exist = 1;
//                System.out.println("exist");
//            }
//            i++;
//        }
        while ((mainlib.inventory[i][0].equals("empty") == false && exist == 0)) {
            if (mainlib.inventory[i][0].equals(item)) {
                exist = 1;
//                System.out.println("exist");
            } else {
                i++;
            }
        }
        if (exist == 1) {
            if (mainlib.inventory[i][1].equals("empty") == false) {
                mainlib.inventory[i][1] = String.valueOf(Integer.parseInt(mainlib.inventory[i][1]) + 1);
            } else {
                mainlib.inventory[i][1] = "1";
            }
        } else {
            i = 0;
            while (mainlib.inventory[i][0].equals("empty") == false) {
                i++;
            }
            y = 0;
            while (y < itemarray.length) {
                mainlib.inventory[i][y] = itemarray[y];
                y++;
            }
            mainlib.inventory[i][1] = "1";
            mainlib.inventory[i + 1][0] = "empty";
//            mainlib.inventory[i] = itemarray;
//            mainlib.inventory[i][1] = "1";
//            System.out.println(mainlib.inventory[0][1]);
//            mainlib.inventory[0][1] = "1";
//            System.out.println(mainlib.inventory[0][1]);
//            mainlib.inventory[2][0] = "empty";
//            System.out.println(mainlib.inventory);
        }
    }
    public static void give_item(String[] item) {
        Integer exist = 0;
        while ((mainlib.inventory[i][0].equals("empty") == false && exist == 0)) {
            if (mainlib.inventory[i][0].equals(item[0])) {
                exist = 1;
//                System.out.println("exist");
            } else {
                i++;
            }
        }
        if (exist == 1) {
            if (mainlib.inventory[i][1].equals("empty") == false) {
                mainlib.inventory[i][1] = String.valueOf(Integer.parseInt(mainlib.inventory[i][1]) + 1);
            } else {
                mainlib.inventory[i][1] = "1";
            }
        } else {
            i = 0;
            while (mainlib.inventory[i][0].equals("empty") == false) {
                i++;
            }
            y = 0;
            mainlib.inventory[i] = item;
            mainlib.inventory[++i][0] = "empty";
        }
    }
    public static Integer y = 0;
    public static void reduceuse(String item) {
        if (mainlib.currentmap.equals("Ship_Up")) {
            Ship_Up ship_Up = new Ship_Up();
            ship_Up.use(item);
        }
        if (mainlib.currentmap.equals("Ship_Down")) {
            Ship_Down ship_Down = new Ship_Down();
            ship_Down.use(item);
        }
        if (mainlib.currentmap.equals("Room1")) {
            Room1 room1 = new Room1();
            room1.use(item);
        }
        if (mainlib.currentmap.equals("Workhouse_upstairs_north")) {
            Workhouse_upstairs_north workhouse_upstairs_north = new Workhouse_upstairs_north();
            workhouse_upstairs_north.use(item);
        }
        if (mainlib.currentmap.equals("Workhouse_upstairs_south")) {
            Workhouse_upstairs_south workhouse_upstairs_south = new Workhouse_upstairs_south();
            workhouse_upstairs_south.use(item);
        }
        if (mainlib.currentmap.equals("Hallway1")) {
            Hallway1 hallway1 = new Hallway1();
            hallway1.use(item);
        }
        if (mainlib.currentmap.equals("Hallway1_2")) {
            Hallway1_2 hallway1_2 = new Hallway1_2();
            hallway1_2.use(item);
        }
        if (mainlib.currentmap.equals("North_Rinlund_Town_Center")) {
            North_Rinlund_Town_Center north_Rinlund_Town_Center = new North_Rinlund_Town_Center();
            north_Rinlund_Town_Center.use(item);
        }
        if (mainlib.currentmap.equals("Start_forest_1")) {
            Start_forest_1 start_forest_1 = new Start_forest_1();
            start_forest_1.use(item);
        }
        if (mainlib.currentmap.equals("Start_forest_2")) {
            Start_forest_2 start_forest_2 = new Start_forest_2();
            start_forest_2.use(item);
        }
        if (mainlib.currentmap.equals("Start_forest_3")) {
            Start_forest_3 start_forest_3 = new Start_forest_3();
            start_forest_3.use(item);
        }
        if (mainlib.currentmap.equals("Start_forest_4")) {
            Start_forest_4 start_forest_4 = new Start_forest_4();
            start_forest_4.use(item);
        }
        if (mainlib.currentmap.equals("Downstairs_workhouse")) {
            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
            downstairs_workhouse.use(item);
        }
    }
    String[] itemarray;
    public static void use(String item, Integer change) {
        if (exists(true, item)) {
            reduceinv(item, change);
        }
        //wip
    }
    public static Boolean exists(boolean non_empty, String item) {
        MainLib mainLib = new MainLib();
        String[][] arr = mainlib.inventory;
        Integer i = 0;
        Integer y = 0;
        Boolean empty = false; 
        if (non_empty) {
            while (i < arr.length && (arr[i][0].equals("empty") == false)) {
                if ((arr[i][1].equals("empty")) == false && arr[i][0].equals(item)) {
                    empty = true;
                }
                i++;
            }
            return empty;
        } else {
            while (i < arr.length) {
                if (arr[i][0].equals(item)) {
                    empty = true;
                }
            }
            return empty;//empty is the goddamn inverse and is not inverted in other scripts so it is the opposite of what the variable's name is
        }
    }
    public static void reduceinv(String item, Integer change) {
        MainLib mainLib = new MainLib();
        String[][] arr = mainlib.inventory;
        Integer i = 0;
        Integer y = 0;
        Boolean emptya = true; 
        while (i < arr.length && (arr[i][0].equals("empty") == false)) {
            if ((arr[i][0].equals(item))) {
                arr[i][1] = String.valueOf((Integer.parseInt(arr[i][1]) + change));
            } else if (arr[i][1].equals("empty") == false) {
            }
            i++;
        }
    }
    public static String[] extract(boolean non_empty, String[][] arr) {
        MainLib mainLib = new MainLib();
        Integer i = 0;
        Integer y = 0;
        String[] out = new String[]{};
        if (non_empty) {
            while (i < arr.length && (arr[i][0].equals("empty") == false)) {
                if ((arr[i][1].equals("empty")) == false) {
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
    public static Integer i;
    public static void fakeanim() {
        if ((main.mini && main.test) == false) {
    //        mainlib.pause_typing = true;
    //        mainlib.timeout("20");//makes typing risky
            System.out.print("[s");
            System.out.print("[H");
            i = 0;
            while (i < mainlib.map_height) {
                System.out.print("[2K");
                System.out.print(mainlib.colour("...nbba......sfw..."));
                System.out.print("[1B");
                i++;
            }
            System.out.print("[2K");
            System.out.print("[H");
            showmap();
            System.out.println(mainlib.colour(mainlib.nlers));
            System.out.print("[2K");
    //        System.out.print("[2K" + mainlib.colour("...nbba......sfw..."));
            if (main.mini == false) {
                System.out.println("####################################################################################################################################################################################################################################################################################################");
            }
    //        System.out.print("[1B");
            System.out.print("[u");
    //        mainlib.pause_typing = false;
        }
    }
}
