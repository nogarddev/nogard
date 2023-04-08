public class North_Rinlund_Town_Center {
    static MapHandler mapHandler = new MapHandler();
    public static final String[] movement_commands = {""};
    public static final String up = "empty";
    public static final String down = "empty";
    public static String north = "North_Rinlund_Town_Center";
    public static String east = "empty";
    public static final String south = "empty";
    public static final String west = "empty";
    public static Boolean animation = false;
    public static Integer animation_frames = 1;
    public static String[][] grabables = new String[1][1];
    public static Integer map_height = 9;
    static Boolean first = true;
    public static String[][] usables = new String[1][1];
    static DialogueHandler dialogueHandler = new DialogueHandler();
    static MainLib mainLib = new MainLib();
    static Boolean second = true;
    static Maputils maputils = new Maputils();
    static Boolean hasbeenpaidformap = false;
    public static Boolean breakconditions() {
        Dialogues dialogues = new Dialogues();
        if (dialogues.has_speakers("North_Rinlund_Town_Center") && dialogueHandler.last_location.equals("North_Rinlund_Town_Center") && dialogueHandler.person.equals("terry")) {
            north = "NRTC_21";
        }
        if (dialogueHandler.lastid.equals("accept_quest_1") && hasbeenpaidformap == false) {
            maputils.increase(Float.parseFloat("50"));
            hasbeenpaidformap = true;
        }
        if (mapHandler.lastmap1.equals("North_Rinlund_Town_Center") && mapHandler.lastcommand1.equals("north") && second) {
            if (first) {
                first = false;
                return true;
            } else {
                mainLib.at("...nfw...Terry: " + mainLib.nlers + "HEY! Come back here!", "30", true);
                mainLib.nl();
                second = false;
                return false;
            }
        } else {
            return false;
        }
    }
    public static void init() {
        usables[0][0] = "empty";
        grabables[0][0] = "empty";
    }
    static MainLib man = new MainLib();
    public static void showmap() {
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;153;147;149m[48;2;173;167;169m...su...||||||||||||||||||||[38;2;0;0;0m[48;2;126;86;68m[24m|    |","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;153;147;149m[48;2;173;167;169m...su...||||||||||||||||||||[38;2;0;0;0m[48;2;126;86;68m[24m|____|","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|____|[38;2;153;147;149m[48;2;173;167;169m...su...||||||[48;2;205;170;109m||||||||[48;2;173;167;169m||||||[38;2;0;0;0m[48;2;126;86;68m[24m|    |","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;153;147;149m[48;2;173;167;169m...su...|||||[48;2;205;170;109m||[24m[48;2;0;150;255m[38;2;0;120;215m  @ # ...su...[38;2;153;147;149m[48;2;173;167;169m[48;2;205;170;109m||[48;2;173;167;169m|||||[38;2;0;0;0m[48;2;126;86;68m[24m|    |","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;153;147;149m[48;2;173;167;169m...su...||||[48;2;205;170;109m||[24m[48;2;0;150;255m[38;2;0;120;215m @    @ ...su...[38;2;153;147;149m[48;2;173;167;169m[48;2;205;170;109m||[48;2;173;167;169m||||[38;2;0;0;0m[48;2;126;86;68m[24m|____|","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|____|[38;2;153;147;149m[48;2;173;167;169m...su...||||[48;2;205;170;109m||[24m[48;2;0;150;255m[38;2;0;120;215m@  # #  ...su...[38;2;153;147;149m[48;2;173;167;169m[48;2;205;170;109m||[48;2;173;167;169m||||[38;2;0;0;0m[48;2;126;86;68m[24m|    |","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;153;147;149m[48;2;173;167;169m...su...|||||[48;2;205;170;109m||[24m[48;2;0;150;255m[38;2;0;120;215m ~   #...su...[38;2;153;147;149m[48;2;173;167;169m[48;2;205;170;109m||[48;2;173;167;169m|||||[38;2;0;0;0m[48;2;126;86;68m[24m|    |","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;153;147;149m[48;2;173;167;169m...su...||||||[48;2;205;170;109m||||||||[48;2;173;167;169m||||||[38;2;0;0;0m[48;2;126;86;68m[24m|____|","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|____|[38;2;153;147;149m[48;2;173;167;169m...su...||||[38;2;255;0;0m@[38;2;153;147;149m|||||||||||||||[38;2;0;0;0m[48;2;126;86;68m[24m|    |","0");
        nl();
        lw("[38;2;0;0;0m[48;2;126;86;68m|    |[38;2;153;147;149m[48;2;173;167;169m...su...||||||||||||||||||||[38;2;0;0;0m[48;2;126;86;68m[24m|    |","0");
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
