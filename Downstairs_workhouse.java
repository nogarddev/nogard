public class Downstairs_workhouse {
    public static final String[] movement_commands = {"east"};
    public static final String up = "Hallway1_2";
    public static final String down = "empty";
    public static final String north = "empty";
    public static Boolean animation = false;
    public static final String east = "empty";
    public static String south() {
        return "Downstairs_workhouse";
    }
    public static String west = "empty";
    public static String[] usableslist = {"hammer"};
    public static Integer animation_frames = 1;
    public static Integer first = 1;
    public static Integer breaka = 0;
    public static Integer map_height = 8;
    public static String[][] grabables = new String[1][1];
    public static String[][] usables = new String[1][1];
    public static void init() {
        usables[0][0] = "empty";
        grabables[0][0] = "empty";
    }
    public static void use(String item) {
        //blank
    }
    public static Boolean breakconditions() {
        MainLib man = new MainLib();
        if (first == 1 && man.currentmap.equals("Downstairs_workhouse")) {
            first = 0;
            man.showmap();
            man.at("You hate this room... the workroom... you slave here day and night for but scraps of food.", "30", true);
            man.nl();
            man.at("The frontdoor is open", "30", true);
            man.nl();
        } 
        if (man.choice.equals("south") && man.currentmap.equals("Downstairs_workhouse")) {
            return true;
        } else {
            return false;
        }
    }
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
        man.lw("|  |  |       |...su...==" + man.nlers + "|", "0");
        man.nl();
        man.lw("|  |  |          |", "0");
        man.nl();
        man.lw("|  |  |          |", "0");
        man.nl();
        man.lw("|  \"--\"          |", "0");
        man.nl();
        man.lw("|_____...su...\\" + man.nlers + "______...nfc..." + man.nlers + " ___.", "0");
        man.nl();
        man.nl();
        man.nlers = tempnlers;
        man.lw(man.nlers, "0");
    }//changed
}
