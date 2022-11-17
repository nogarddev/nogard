public class TestFightMap {
    public static Boolean animation = false;
    public static Integer animation_frames = 1;
    public static Integer map_height = 5;
    public static Integer optimal_distance = 15;
    public static Integer max_range = 20;
    public static Boolean canmove = true;
    public static String enemy_starter = "barrel-6";
    public static String[][] covers = new String[100][100];
    public static String[] enemy_ranged = new String[14];
    public static void init() {
        covers[0][0] = "barrel3";
        covers[0][1] = "3";
        covers[0][2] = "200";
        covers[0][3] = "40";
        covers[0][4] = "0";
        covers[1][0] = "barrel6";
        covers[1][1] = "6";
        covers[1][2] = "200";
        covers[1][3] = "40";
        covers[1][4] = "0";
        covers[2][0] = "barrel9";
        covers[2][1] = "9";
        covers[2][2] = "200";
        covers[2][3] = "40";
        covers[2][4] = "0";
        covers[3][0] = "barrel-3";
        covers[3][1] = "-3";
        covers[3][2] = "200";
        covers[3][3] = "40";
        covers[3][4] = "0";
        covers[4][0] = "barrel-6";
        covers[4][1] = "-6";
        covers[4][2] = "200";
        covers[4][3] = "40";
        covers[4][4] = "0";
        covers[5][0] = "barrel-9";
        covers[5][1] = "-9";
        covers[5][2] = "200";
        covers[5][3] = "40";
        covers[5][4] = "0";
        covers[6][0] = "empty";
    }
    public static void showmap() {
//    MainLib man = new MainLib();
//    String tempnlers = man.nlers;
//    man.nlers = "...nbba......sfga...";
//    System.out.print(man.colour(man.nlers));
//    man.lw("._____.  ", "0");
//    man.nl();
//    man.lw("|=|   |  ", "0");
//    man.nl();
//    man.lw("|#|   |__", "0");
//    man.nl();
//    man.lw("|  ...nfr...@" + man.nlers + "  |__", "0");
//    man.nl();
//    man.lw("|_____|  ", "0");
//    man.nl();
//    man.nlers = tempnlers;//for some reason has strong white background unless commented
//    man.lw(man.nlers, "0");
//    man.nl();
   }//changed
}
