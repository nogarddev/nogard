public class North_Rinlund_Town_Center {
    public static final String[] movement_commands = {""};
    public static final String up = "empty";
    public static final String down = "empty";
    public static final String north = "empty";
    public static String east = "empty";
    public static final String south = "empty";
    public static final String west = "empty";
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
        lw("imagine a lovely North RInlund Town center (placeholder)", "0");
        nl();
        nl();
        nl();
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
