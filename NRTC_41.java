public class NRTC_41 {
    public static final String[] movement_commands = {"north","west"};
    public static String up = "empty";
    public static String down = "empty";
    public static String north = "NRTC_42";
    public static String east = "empty";
    public static String south = "empty";
    public static String west = "NRTC_31";
    public static Boolean animation = false;
    public static Integer animation_frames = 1;
    public static String[][] grabables = new String[1][1];
    public static Integer map_height = 10;
    public static String[][] usables = new String[1][1];
    public static Boolean breakconditions() {
        return false;
    }
    public static void init() {
        usables[0][0] = "empty";
        grabables[0][0] = "empty";
    }
    static MainLib man = new MainLib();
    public static void showmap() {
        lw("  |...su...=...sr..." + man.nlers + "| @ |...su...=...sr..." + man.nlers + "|      |", "0");
        lw("__| |  #| |______|", "0");
        lw("  |...su... ...sr..." + man.nlers + "| ; |...su... ...sr..." + man.nlers + "|      |", "0");
        lw("  |...su...=...sr..." + man.nlers + "|...nfr...@" + man.nlers + " #|...su...=...sr..." + man.nlers + "|      |", "0");
        lw("__| |   | |______|", "0");
    }
    public static void use(String item) {
        System.out.println("North_Rinlund_Town_Center should not be called for use - is blank");
    }
    public static void lw(String text, String ms) {
        man.lw(text, ms);
    }
    public static void nl() {
        man.nl();
    }
}
