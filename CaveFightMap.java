public class CaveFightMap {
    public static Boolean animation = false;
    public static Integer animation_frames = 1;
    public static Integer map_height = 5;
    public static Integer optimal_distance = 4;
    public static Integer max_range = 20;
    public static Boolean canmove = false;
    public static String enemy_starter = "enemy boulder";
    public static String[][] covers = new String[100][100];
    public static String[] enemy_ranged = new String[14];
    public static void init() {
        covers[0][0] = "boulder";
        covers[0][1] = "3";
        covers[0][2] = "200";
        covers[0][3] = "50";
        covers[0][4] = "0";
        covers[1][0] = "enemy boulder";
        covers[1][1] = "-1";
        covers[1][2] = "200";
        covers[1][3] = "20";
        covers[1][4] = "0";
        covers[2][0] = "empty";
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
