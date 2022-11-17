public class Room1 {
    public static final String[] movement_commands = {"east"};
    public static final String up = "empty";
    public static final String down = "empty";
    public static final String north = "empty";
    public static String east = "empty";
    public static final String south = "empty";
    public static final String west = "empty";
    public static Boolean animation = false;
    public static String[] usableslist = {"chisel","hammer"};
    public static Integer animation_frames = 1;
    public static String[][] grabables = new String[4][14];
    public static Integer map_height = 5;
    public static String[][] usables = new String[2][2];
    public static void init() {
        grabables[2][0] = "gun";
        grabables[2][1] = "1";
        grabables[2][2] = "100";
        grabables[2][3] = "1";
        grabables[2][4] = "2";
        grabables[2][5] = "70";
        grabables[2][6] = "100";
        grabables[2][7] = "3";
        grabables[2][8] = "5";
        grabables[2][9] = "30";
        grabables[2][10] = "empty";
        grabables[2][11] = "bio";
        grabables[2][12] = "10";
        grabables[2][13] = "empty";
        usables[0][0] = "chisel";
        usables[0][1] = "1";
        usables[1][0] = "hammer";
        usables[1][1] = "1";
        grabables[0][0] = "hammer";
        grabables[0][1] = "1";
        grabables[0][2] = "empty";
        grabables[0][3] = "empty";
        grabables[0][4] = "empty";
        grabables[0][5] = "empty";
        grabables[0][6] = "empty";
        grabables[0][7] = "empty";
        grabables[0][8] = "empty";
        grabables[0][9] = "empty";
        grabables[0][10] = "empty";
        grabables[0][11] = "empty";
        grabables[0][12] = "empty";
        grabables[0][13] = "empty";
        grabables[1][0] = "chisel";
        grabables[1][1] = "1";
        grabables[1][2] = "empty";
        grabables[1][3] = "empty";
        grabables[1][4] = "empty";
        grabables[1][5] = "empty";
        grabables[1][6] = "empty";
        grabables[1][7] = "empty";
        grabables[1][8] = "empty";
        grabables[1][9] = "empty";
        grabables[1][10] = "empty";
        grabables[1][11] = "empty";
        grabables[1][12] = "empty";
        grabables[1][13] = "empty";
        grabables[3][0] = "pocket knife";
        grabables[3][1] = "1";
        grabables[3][2] = "empty";
        grabables[3][3] = "empty";
        grabables[3][4] = "empty";
        grabables[3][5] = "empty";
        grabables[3][6] = "empty";
        grabables[3][7] = "empty";
        grabables[3][8] = "empty";
        grabables[3][9] = "empty";
        grabables[3][10] = "30";
        grabables[3][11] = "omni";
        grabables[3][12] = "0.1";
        grabables[3][13] = "empty";
    }
    public static void use(String item) {
        MainLib man = new MainLib();
        MapHandler mapHandler = new MapHandler();
        if (usables[0][1].equals("empty") && item.equals("hammer") && mapHandler.exists(true, "hammer")) {
            if (grabables[3][1].equals("1") || grabables[2][1].equals("1")) {
                if (grabables[3][1].equals("1")) {
                    if (grabables[2][1].equals("1")) {
                        man.at("I should pick up my gun and pocket knife first", "30", true);
                    } else {
                        man.at("I should pick up my pocket knife first", "30", true);
                    }
                } else {
                    man.at("I should pick up my gun first", "30", true);
                }
                man.nl();
            } else {
                usables[1][1] = "empty";
                mapHandler.reduceinv("chisel", -1);
                System.out.println(man.inventory[0][0] + "," + man.inventory[0][1]);
                System.out.println(man.inventory[1][0] + "," + man.inventory[1][1]);
                man.at("...sfr...Narrator: " + man.nlers + "your chisel broke.", "30", true);
                east = "Hallway1";
            }
        } else if (usables[0][1].equals("1") && item.equals("hammer") && mapHandler.exists(true, "hammer")) {
            man.lw("I need to put the chisel there first", "0");
            man.nl();
        }
        if (item.equals("chisel") && mapHandler.exists(true, "chisel")) {
            usables[0][1] = "empty";
            mapHandler.use("chisel", 0);
        }
    }
    public static Boolean breakconditions() {
        MainLib man = new MainLib();
//        if (usables[0][1].equals("empty") && usables[1][1].equals("empty")) {
        if (grabables[2][1].equals("empty")) {
            return false;//enable to begin fight as soon as gun is picked up
        } else {
            return false;
        }
    }
    public static void showmap() {
    MainLib man = new MainLib();
    String tempnlers = man.nlers;
    man.nlers = "...nbba......sfga...";
    System.out.print(man.colour(man.nlers));
    man.lw("._____.  ", "0");
    man.nl();
    man.lw("|=|   |  ", "0");
    man.nl();
    man.lw("|#|   |__", "0");
    man.nl();
    man.lw("|  ...nfr...@" + man.nlers + "  |__", "0");
    man.nl();
    man.lw("|_____|  ", "0");
    man.nl();
    man.nlers = tempnlers;//for some reason has strong white background unless commented
    man.lw(man.nlers, "0");
    man.nl();
   }//changed
}
