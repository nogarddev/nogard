public class Ship_Down {
    public static final String[] movement_commands = {"up"};
    public static final String up = "Ship_Up";
    public static final String down = "empty";
    public static final String north = "empty";
    public static final String east = "empty";
    public static final String south = "empty";
    public static final String west = "empty";
    public static Integer map_height = 13;
    public static Boolean animation = true;
    public static String[] usableslist = {"cannonball,gunpowder"};
    public static Integer animation_frames = 2;
    public static String[][] grabables = new String[1][1];
    public static String[][] usables = new String[2][2];
    public static void anim(Integer frame) {
        MainLib man = new MainLib();
        String tempnlers = man.nlers;
        man.nlers = "...sbc......nfba...";
        if (frame == 1) {
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "           0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "1          0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "    .      0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  _/ \\_    0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + " /     \\   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "<=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "<=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "<=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "<=    _=>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + man.colour("   | __|...su...=|...sr......sbc......nfba...") + "   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + " |_____|   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "           0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "           0" + man.colour(tempnlers));
        }
        if (frame == 2) {
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "             0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "2          0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "    .      0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "  _/ \\_    0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + " /     \\   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "<=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "<=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "<=     =>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "<=    _=>  0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + man.colour("   | __|...su...=|...sr......sbc......nfba...") + "   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + " |_____|   0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "           0");
            System.out.println(man.colour("...nbba......sfw...") + "[2K" + man.colour("...sbc......nfba...") + "           0" + man.colour(tempnlers));
        }
        man.nlers = tempnlers;
        System.out.print(man.colour(man.nlers) + "[2K");
    }
    public static void init() {
        usables[0][0] = "cannonball";
        usables[0][1] = "1";
        usables[1][0] = "gunpowder";
        usables[1][1] = "1";
        grabables[0][0] = "empty";
    }
    public static void use(String item) {
        MapHandler mapHandler = new MapHandler();
        if (usables[1][1].equals("empty") && item.equals("cannonball") && mapHandler.exists(true, "cannonball")) {
            usables[0][1] = "empty";
            mapHandler.use("cannonball", -1);
        }
        if (item.equals("gunpowder") && mapHandler.exists(true, "gunpowder")) {
            usables[1][1] = "empty";
            mapHandler.use("gunpowder", -1);
        }
    }
    public static Boolean breakconditions() {
        MainLib man = new MainLib();
        if (usables[0][1].equals("empty") && usables[1][1].equals("empty")) {
            return true;
        } else {
            return false;
        }
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
    man.lw("...nbba......sfw...[2K...sbc......nfba...   |     |   ", "0");
    man.nl();
    man.lw("...nbba......sfw...[2K...sbc......nfba...  <=     =>  ", "0");
    man.nl();
    man.lw("...nbba......sfw...[2K...sbc......nfba...   |     |   ", "0");
    man.nl();
    man.lw("...nbba......sfw...[2K...sbc......nfba...  <=     =>  ", "0");
    man.nl();
    man.lw("...nbba......sfw...[2K...sbc......nfba...   |   |...su...=|...sr..." + man.nlers + "   ", "0");
    man.nl();
    man.lw("...nbba......sfw...[2K...sbc......nfba...   |_____|   ", "0");
    man.nl();
    man.lw("...nbba......sfw...[2K...sbc......nfba...             ", "0");
    man.nl();
    man.lw("...nbba......sfw...[2K...sbc......nfba...             " + man.colour(tempnlers), "0");
    man.nlers = tempnlers;
    man.nl();
//    man.timeout("20");
//    System.out.print(man.colour(man.nlers) + "[2K");
}//changed
}
