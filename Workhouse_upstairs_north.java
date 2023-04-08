public class Workhouse_upstairs_north {
    public static String[] movement_commands = {"south"};
    public static String up = "empty";
    public static String down = "empty";
    public static String north = "empty";
    public static String east = "empty";
    public static String south = "Hallway1_2";
    public static String west = "empty";
    public static boolean first = true;
    public static Boolean animation = false;
    public static String[] usableslist = {""};
    public static Integer animation_frames = 1;
    public static String[][] grabables = new String[2][14];
    public static Integer map_height = 5;
    public static String[][] usables = new String[1][1];
    public static void init() {
        grabables[0][0] = "Workhouse Key";
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
        grabables[1][0] = "empty";
        usables[0][0] = "empty";
    }
    public static void use(String item) {
        Integer skip = 1;
    }
    public static Boolean breakconditions() {
        if (first) {
            first = false;
            man.at("You enter the room of the other workhouse owner, he has passed out from some affliction, potentially alchohol, hopefully he dies for what he has done to you.", "30", true);
            man.nl();
            man.at("The key to the front door is attatched to his waist", "30", true);
            man.nl();
        }
        if (grabables[0][1].equals("1") == false) {
            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
            downstairs_workhouse.south = "Downstairs_workhouse";
        }
        return false;
    }
    static MainLib man = new MainLib();
    public static void showmap() {
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
