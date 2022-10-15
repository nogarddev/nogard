public class Hallway1 {
    public static final String[] movement_commands = {"east"};
    public static final String up = "empty";
    public static Integer map_height = 2;
    public static final String down = "empty";
    public static final String north = "empty";
    public static final String east = "empty";
    public static final String south = "empty";
    public static final String west = "Room1";
    public static Boolean animation = false;
    public static Integer first = 1;
    public static String[] usableslist = {"hammer"};
    public static Integer animation_frames = 1;
    public static String[][] grabables = new String[1][1];
    public static String[][] usables = new String[1][2];
    public static void init() {
        usables[0][0] = "hammer";
        usables[0][1] = "1";
//        usables[1][0] = "hammer";
//        usables[1][1] = "1";
        grabables[0][0] = "empty";
//        grabables[0][1] = "1";
//        grabables[1][0] = "chisel";
//        grabables[1][1] = "1";
    }
    public static void use(String item) {
        MainLib man = new MainLib();
        MapHandler mapHandler = new MapHandler();
//        if (usables[0][1].equals("empty") && item.equals("hammer") && mapHandler.exists(true, "hammer")) {
//            usables[1][1] = "empty";
//            mapHandler.reduceinv("chisel", -1);
//            man.at("...sfr...Narrator: " + man.nlers + "your chisel broke.", "30", true);
//            east = "Hallway1";
//        } else if (usables[0][1].equals("1") && item.equals("hammer") && mapHandler.exists(true, "hammer")) {
//            man.lw("I need to put the chisel there first", "0");
//        }
        if (item.equals("hammer") && mapHandler.exists(true, "hammer")) {
            usables[0][1] = "empty";
            man.at("Are you sure you want to brutally kill this captor with a hammer?", "30", true);
            man.choice = man.choices(true, "30", true, new String[] {"yes","no"});
            if (man.choice.equals("yes")) {
                mapHandler.use("hammer", 0);
            }
            if (man.choice.equals("no")) {
//                man.at("You are caught scheming to murder and are hung by the state...", "30", true);
//                man.at("Press enter to restart", "30", true);
                man.at("You are caught scheming to murder and are hung by the state...", "30", true);
                usables[0][1] = "1";
                man.nl();
                man.at("Press enter to try again...", "30", true);
                man.nl();
                man.enter_break();
                mapHandler.dead = 1;
                //                man.enter_break();
            }
        }
    }
    public static Boolean breakconditions() {
        MainLib man1 = new MainLib();
        if (first == 1) {
            first = 0;
            man1.showmap();
            man1.nl();
            man1.at("You see a man dressed in green at the east side of the corridor.", "30", true);
            man1.nl();
        }
        MainLib man = new MainLib();
        if (usables[0][1].equals("empty")) {
            return true;
        } else {
            return false;
        }
    }
    public static void showmap() {
        MainLib man = new MainLib();
        String tempnlers = man.nlers;
        man.nlers = "...nbba......sfga...";
        man.lw(".______________________.", "0");
        man.nl();
        man.lw("|...su... ...nfr...@" + man.nlers + "               ...nfw...O" + man.nlers + "...su...    ...sr..." + man.nlers + "|", "0");
        man.nlers = tempnlers;
        man.lw(man.nlers, "0");
   }//changed
}
