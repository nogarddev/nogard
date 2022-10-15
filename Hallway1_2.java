public class Hallway1_2 {
    public static final String[] movement_commands = {"east"};
    public static final String up = "empty";
    public static final String down = "Downstairs_workhouse";
    public static final String north = "empty";
    public static final String east = "empty";
    public static Integer map_height = 2;
    public static final String south = "empty";
    public static final String west = "Room1";
    public static Boolean animation = false;
    public static String[] usableslist = {"hammer"};
    public static Integer animation_frames = 1;
    public static String[][] grabables = new String[1][1];
    public static String[][] usables = new String[1][1];
    public static void init() {
        usables[0][0] = "empty";
//        usables[1][0] = "hammer";
//        usables[1][1] = "1";
        grabables[0][0] = "empty";
//        grabables[0][1] = "1";
//        grabables[1][0] = "chisel";
//        grabables[1][1] = "1";
    }
    public static void use(String item) {
//blank
    }
    public static Boolean breakconditions() {
        MainLib man = new MainLib();
        Room1 room1 = new Room1();
        room1.east = "Hallway1_2";
        return false;
    }
    public static void showmap() {
        MainLib man = new MainLib();
        String tempnlers = man.nlers;
        man.nlers = "...nbba......sfga...";
        man.lw(".______________________.", "0");
        man.nl();
        man.lw("|...su... ...nfr...@" + man.nlers + "               ...nfw... " + man.nlers + "...su...    " + man.nlers + "|", "0");
        man.nlers = tempnlers;
        man.lw(man.nlers, "0");
   }//changed
}
