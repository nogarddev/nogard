public class NRTC_42 {
    public static final String[] movement_commands = {"north","south","west"};
    public static String up = "empty";
    public static String down = "empty";
    public static String north = "NRTC_43";
    public static String east = "empty";
    public static String south = "NRTC_41";
    public static String west = "NRTC_32";
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
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;96;170;50m[48;2;126;200;80m[38;2;153;147;149m=|[48;2;173;167;169m[38;2;153;147;149m @ [48;2;126;200;80m|[38;2;153;147;149m=[48;2;126;86;68m[38;2;0;0;0m|    |", "0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|____|[38;2;96;170;50m[48;2;126;200;80m@[38;2;153;147;149m|[48;2;173;167;169m[38;2;153;147;149m  #[48;2;126;200;80m|[38;2;96;170;50m#[48;2;126;86;68m[38;2;0;0;0m|    |", "0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;96;170;50m[48;2;126;200;80m@[38;2;153;147;149m|[48;2;173;167;169m[38;2;153;147;149m ; [48;2;126;200;80m|[38;2;96;170;50m@[48;2;126;86;68m[38;2;0;0;0m|    |", "0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;96;170;50m[48;2;126;200;80m[38;2;153;147;149m=|[48;2;173;167;169m[38;2;255;0;0m@[38;2;153;147;149m #[48;2;126;200;80m|[38;2;153;147;149m=[48;2;126;86;68m[38;2;0;0;0m|____|", "0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|____|[38;2;96;170;50m[48;2;126;200;80m#[38;2;153;147;149m|[48;2;173;167;169m[38;2;153;147;149m   [48;2;126;200;80m|[38;2;96;170;50m@[48;2;126;86;68m[38;2;0;0;0m|____|", "0");
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
