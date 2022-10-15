public class Ship_Up {
    public static final String[] movement_commands = {"down"};
    public static final String up = "empty";
    public static final String down = "Ship_Down";
    public static final String north = "empty";
    public static final String east = "empty";
    public static final String south = "empty";
    public static final String west = "empty";
    public static Boolean animation = true;
    public static Integer map_height = 13;
    public static Integer animation_frames = 2;
    public static String[][] usables = new String[1][1];
    public static String[][] grabables = new String[2][14];
    public static void init() {
        grabables[0][0] = "cannonball";
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
        grabables[1][0] = "gunpowder";
        grabables[1][1] = "1";
        grabables[1][2] = "empty";
        grabables[1][3] = "empty";
        grabables[1][4] = "empty";
        grabables[1][5] = "empty";
        grabables[1][6] = "empty";
        grabables[1][7] = "empty";
        grabables[1][8] = "empty";
        grabables[1][9] = "empty";
        grabables[1][10] = "empty";
        grabables[1][11] = "empty";
        grabables[1][12] = "empty";
        grabables[1][13] = "empty";
        usables[0][0] = "empty";
    }
    public static Boolean breakconditions() {
        MainLib man = new MainLib();
        return false;
    }
    public static void anim(Integer frame) {
        MainLib man = new MainLib();
        String tempnlers = man.nlers;
//        man.nlers = "...sbc......nfba...";
        if (frame == 1) {
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "             0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "   @         0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + " @    .  ~   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "    _/ \\_    0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "   /     \\ ~ 0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  <=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  <=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  <=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  <=    _=>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + man.colour("   | __|...su...=|...sr......sbc......nfba...") + "   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "   |_____|   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "             0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "       @     0" + man.colour(tempnlers));
        }
        if (frame == 2) {
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "             0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  2     @    0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "   ~  .      0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "    _/ \\_  ~ 0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "   /     \\   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  <=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  <=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  <=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  <=    _=>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + man.colour("   | __|...su...=|...sr......sbc......nfba...") + "   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "   |_____|   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "     @       0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "        @    0" + man.colour(tempnlers));
        }
        man.nlers = tempnlers;
        System.out.print(man.colour(man.nlers) + "[2K");
        System.out.println("");
    }
    public static void use(String blank) {
        //blank
    }
    public static void showmap() {
        MainLib man = new MainLib();
        String tempnlers = man.nlers;
        man.nlers = "...sbc......nfba...";
        man.lw("...nbba......sfw...[2K...sbc......nfba...             ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...             ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...      .      ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...    _/ \\_    ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...   /     \\   ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...  <=     =>  ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...  <=     =>  ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...  <=     =>  ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...  <=    _=>  ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...   | __|...su...=|...sr..." + man.nlers + "   ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...   |_____|   ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...             ", "0");
        man.nl();
        man.lw("...nbba......sfw...[2K...sbc......nfba...             " + man.colour(tempnlers), "0");
        man.nlers = tempnlers;
        man.nl();
//        man.timeout("20");
//        System.out.print(man.colour(man.nlers) + "[2K");
    }//changed

}
