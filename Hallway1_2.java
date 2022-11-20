public class Hallway1_2 {
    public static final String[] movement_commands = {"east"};
    public static String up = "empty";
    public static String down = "Downstairs_workhouse";
    public static String north = "empty";
    public static String east = "empty";
    public static Integer map_height = 2;
    public static String south = "empty";
    public static String west = "Room1";
    public static Boolean animation = false;
    public static String[] usableslist = {"hammer"};
    public static Integer animation_frames = 1;
    public static String[][] grabables = new String[1][1];
    public static String[][] usables = new String[2][2];
    public static Boolean first_unlocked_rooms = true;
    public static void init() {
        usables[0][0] = "rotting axe";
        usables[0][1] = "1";
        usables[1][0] = "empty";
        grabables[0][0] = "empty";
    }
    public static void use(String item) {
        if (item.equals("rotting axe")) {
            mapHandler.use("rotting axe", -1);
            man.at("You broke down the door but your axe snapped.", "30", true);
            man.nl();
            usables[0][1] = "empty";
            north = "Workhouse_upstairs_north";
        }
    }
    static MainLib man = new MainLib();
    static MapHandler mapHandler = new MapHandler();
    public static Boolean breakconditions() {
        Room1 room1 = new Room1();
        if (mapHandler.lastmap1.equals("Hallway1_2") && mapHandler.lastcommand1.equals("north") && usables[0][1].equals("1")) {
            man.at("The door is locked on the inside, I need to find a way to break it down", "30", true);
            man.nl();
        }
        if (north.equals("Workhouse_upstairs_north") && first_unlocked_rooms) {
            first_unlocked_rooms = false;
            man.at("To the north is the other workhouse owner's room, they may have a key you could use", "30", true);
            man.nl();
        }
        room1.east = "Hallway1_2";
        return false;
    }
    public static void showmap() {
        MainLib man = new MainLib();
        String tempnlers = man.nlers;
        man.nlers = "...nbba......sfga...";
        man.lw(".______________________.", "0");
        man.nl();
        man.lw("|...su... ...nfr...@" + man.nlers + "               ...nfw... " + man.nlers + "...su...    " + man.nlers + "|...sr..." + man.nlers, "0");
        man.nlers = tempnlers;
        man.lw(man.nlers, "0");
   }//changed
}
