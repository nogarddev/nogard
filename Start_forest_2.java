public class Start_forest_2 {
    public static final String[] movement_commands = {"north"};
    public static final String up = "empty";
    public static final String down = "empty";
    public static final String north = "Start_forest_3";
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
        lw("[48;2;25;25;25m [48;2;16;16;16m [48;2;24;24;24m [48;2;23;23;23m [48;2;31;31;31m [48;2;23;23;23m [48;2;21;21;21m [48;2;33;33;33m [48;2;21;21;21m [48;2;25;25;25m [48;2;21;21;21m [48;2;20;20;20m [48;2;21;21;21m [48;2;15;15;15m [48;2;22;22;22m ", "0");
        nl();
        lw("[48;2;22;22;22m [48;2;23;23;23m [48;2;23;23;23m [48;2;20;20;20m [48;2;20;20;20m [48;2;21;21;21m [48;2;22;22;22m [48;2;14;14;14m [48;2;14;14;14m [48;2;22;22;22m [48;2;22;22;22m [48;2;31;31;31m [48;2;21;21;21m [48;2;20;20;20m [48;2;25;25;25m ", "0");
        nl();
        lw("[48;2;11;11;11m [48;2;14;14;14m [48;2;7;7;7m [48;2;20;20;20m [48;2;25;25;25m [48;2;25;25;25m [48;2;24;24;24m [48;2;12;12;12m [48;2;22;22;22m [48;2;21;21;21m [48;2;20;20;20m [48;2;21;21;21m [48;2;21;21;21m [48;2;21;21;21m [48;2;24;24;24m ", "0");
        nl();
        lw("[48;2;32;32;32m [48;2;21;21;21m [48;2;26;26;26m [48;2;23;23;23m [48;2;25;25;25m [48;2;15;15;15m [48;2;15;15;15m [48;2;25;25;25m [48;2;20;20;20m [48;2;17;17;17m [48;2;4;4;4m [48;2;21;21;21m [48;2;20;20;20m [48;2;22;22;22m [48;2;17;17;17m ", "0");
        nl();
        lw("[48;2;22;22;22m [48;2;20;20;20m [48;2;23;23;23m [48;2;20;20;20m [48;2;36;36;36m [48;2;24;24;24m [48;2;17;17;17m [48;2;21;21;21m [48;2;17;17;17m [48;2;10;10;10m [48;2;12;12;12m [48;2;21;21;21m [48;2;17;17;17m [48;2;14;14;14m [48;2;26;26;26m ", "0");
        nl();
        lw("[48;2;21;21;21m [48;2;22;22;22m [48;2;21;21;21m [48;2;26;26;26m [48;2;12;12;12m [48;2;20;20;20m [48;2;17;17;17m [48;2;15;15;15m [48;2;16;16;16m [48;2;25;25;25m [48;2;11;11;11m [48;2;24;24;24m [48;2;25;25;25m [48;2;33;33;33m [48;2;26;26;26m ", "0");
        nl();
        lw("[48;2;15;15;15m [48;2;31;31;31m [48;2;20;20;20m [48;2;16;16;16m [48;2;21;21;21m [48;2;20;20;20m [48;2;20;20;20m [48;2;22;22;22m [48;2;24;24;24m [48;2;25;25;25m [48;2;25;25;25m [48;2;21;21;21m [48;2;28;28;28m [48;2;20;20;20m [48;2;24;24;24m ", "0");
        nl();
        lw("[48;2;23;23;23m [48;2;12;12;12m [48;2;5;5;5m [48;2;22;22;22m [48;2;20;20;20m [48;2;20;20;20m [48;2;22;22;22m [48;2;23;23;23m [48;2;22;22;22m [48;2;25;25;25m [48;2;25;25;25m [48;2;16;16;16m [48;2;22;22;22m [48;2;20;20;20m [48;2;25;25;25m ", "0");
        nl();
        lw("[48;2;14;14;14m [48;2;8;8;8m [48;2;20;20;20m [48;2;26;26;26m [48;2;11;11;11m [48;2;25;25;25m [48;2;20;20;20m [48;2;21;21;21m [48;2;21;21;21m [48;2;21;21;21m [48;2;20;20;20m [48;2;20;20;20m [48;2;20;20;20m [48;2;16;16;16m [48;2;11;11;11m ", "0");
        nl();
        lw("[48;2;23;23;23m [48;2;16;16;16m [48;2;20;20;20m [48;2;20;20;20m [48;2;21;21;21m [48;2;22;22;22m [48;2;15;15;15m [48;2;4;4;4m [48;2;14;14;14m [48;2;31;31;31m [48;2;25;25;25m [48;2;20;20;20m [48;2;36;36;36m [48;2;25;25;25m [48;2;20;20;20m ", "0");
        nl();
        nl();
        nl();
    }
    public static void use(String item) {
        System.out.println("Start_forest_2 should not be called for use - is blank");
    }
    public static void lw(String text, String ms) {
        man.lw(text, ms);
    }
    public static void nl() {
        man.nl();
    }
}
