public class Downstairs_workhouse {
    public static final String[] movement_commands = {"east"};
    public static final String up = "Hallway1_2";
    public static final String down = "empty";
    public static final String north = "empty";
    public static Boolean animation = false;
    public static final String east = "empty";
    public static String south = "Downstairs_workhouse";
    public static String west = "empty";
    public static String[] usableslist = {"hammer"};
    public static Integer animation_frames = 1;
    public static Integer first = 1;
    public static Integer breaka = 0;
    public static Integer map_height = 8;
    public static String[][] grabables = new String[1][1];
    public static String[][] usables = new String[2][2];
    public static void init() {
        usables[0][0] = "Workhouse Key";
        usables[0][1] = "1";
        usables[1][0] = "empty";
        grabables[0][0] = "empty";
    }
    public static void use(String item) {
        if (item.equalsIgnoreCase("workhouse key")) {
            usables[0][1] = "empty";
        }
    }
    public static Boolean breakconditions() {
        MainLib man = new MainLib();
        if (first == 1 && man.currentmap.equals("Downstairs_workhouse")) {
            first = 0;
            man.showmap();
            man.at("...sfr...Narrator: " + man.nlers + "You hate this room... the workroom... you slave here day and night for but scraps of food.", "30", true);
            man.nl();
//            man.at("The frontdoor is open", "30", true);
//            man.nl();
        } 
//        if (man.choice.equals("south") && man.currentmap.equals("Downstairs_workhouse")) {
//            return true;
//        } else {
//            return false;
//        }
        if (mapHandler.lastmap1.equals("Downstairs_workhouse") && mapHandler.lastcommand1.equals("south") && usables[0][1].equals("1")) {
            man.at("...sfr...Narrator: " + man.nlers + "The door locked tight, you need to break out somehow, look around the house to see what you can find.", "30", true);
            man.nl();
            hallway1_2.north = "Hallway1_2";
            hallway1_2.south = "Workhouse_upstairs_south";
        }
        if (usables[0][1].equals("empty") && mapHandler.lastmap1.equals("Downstairs_workhouse") && mapHandler.lastcommand1.equals("south")) {
            return true;
        } else {
            return false;
        }
    }
    static Hallway1_2 hallway1_2 = new Hallway1_2();
    static MapHandler mapHandler = new MapHandler();
    public static void showmap() {
        MainLib man = new MainLib();
        String tempnlers = man.nlers;
        man.nlers = "...nbba......sfga...";
        man.lw("._____________|__|", "0");
        man.nl();
        man.lw("|             |==|", "0");
        man.nl();
        man.lw("|  .--.       |==|", "0");
        man.nl();
        man.lw("|  |  |       |...su...==" + man.nlers + "|...sr..." + man.nlers, "0");
        man.nl();
        man.lw("|  |  |          |", "0");
        man.nl();
        man.lw("|  |  |          |", "0");
        man.nl();
        man.lw("|  \"--\"          |", "0");
        man.nl();
        man.lw("|_____...su...\\" + man.nlers + "______...nfc..." + man.nlers + " ___....sr..." + man.nlers, "0");
        man.nl();
        man.nl();
        man.nlers = tempnlers;
        man.lw(man.nlers, "0");
    }//changed
}
