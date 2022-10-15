import java.util.*;
import java.io.*;
public class Anim extends Thread {
    public static String input;
    public static Integer skip;
    public static Integer frame = 1;
    public static Integer i;
    public static String skipa;
    public static String historic_map;
    public static Integer historic_map_height;
    public static void runanim() {
        MainLib man = new MainLib();
//        System.out.println("a" + historic_map + "map");
//        System.out.println("a" + historic_map_height + "map_height");
//        System.out.println("a" + man.currentmap + "map");
//        System.out.println("a" + man.map_height + "map_height");
        while (man.startyouanim.equals("1")) {
//            System.out.println("Anim ln 19 running");
            historic_map = man.currentmap;
            historic_map_height = man.map_height;
//            System.out.println("a" + historic_map + "map");
//            System.out.println("a" + historic_map_height + "map_height");
//            System.out.println("a" + man.currentmap + "map");
//            System.out.println("a" + man.map_height + "map_height");    
            skipa = "0";
            //api for animation
            man.animupdate();
            if (man.animation) {
                System.out.print("[s");
                System.out.print("[H");
                System.out.print("[?25h");
                if (++frame > man.animation_frames) {
                    frame = 1;
                }
//                System.out.print(frame + "a" + man.animation_frames);
//                System.out.print("[1G");
//                System.out.print("[Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString() + man.map_height.toString());
                anim(frame);
            }
            timeout("1000");
            historic_map = man.currentmap;
            historic_map_height = man.map_height;
//            if (historic_map.equals(man.currentmap) == false) {
//                System.out.print("[s");
//                System.out.print("[?25h");
//                i = 0;
//                while (i < historic_map_height) {
//                    System.out.print("[A");
//                    System.out.print("[2K");
//                }
//                System.out.print("[u");        
//            }
        }
//        System.out.print("[s");
//        System.out.print("[?25h");
//        while (i < man.map_height) {
//            System.out.print("[A");
//            System.out.print("[2K");
//        }
//        System.out.print("[u");
        waitx();
    }
    public static void anim(Integer frame) {
        MainLib man = new MainLib();
        historic_map = man.currentmap;
        historic_map_height = man.map_height;
        man.pause_typing = true;
//        man.timeout("20");//makes typing risky
        if (man.currentmap.equals("Ship_Up")) {
            Ship_Up ship_Up = new Ship_Up();
            ship_Up.anim(frame);
        }
        if (man.currentmap.equals("Ship_Down")) {
            Ship_Down ship_Down = new Ship_Down();
            ship_Down.anim(frame);
        }
        System.out.print("...nbba......sfw...[2K");
        man.nlers = "...nbba......sfw...";
        System.out.print("[2K");
        System.out.print("[1G");
        System.out.print("####################################################################################################################################################################################################################################################################################################");
        System.out.print("[1");
        System.out.print("[u");
        man.pause_typing = false;
    }
    public static String tempnlers = "0";
    public void run() {
        waitx();
    }
    public static String start;
    public static void waitx() {
        MainLib man = new MainLib();
        while (man.startyouanim.equals("0")) {
            skip = 0;
        }
        historic_map = man.currentmap;
        historic_map_height = man.map_height;
        runanim();
    }
    public static String outputed;
    public static String output;
    public static String ms;
    public static Boolean skip_spaces;
    public static String args[];
//    public static String getinput() {
//        Scanner sc = new Scanner(System.in);
//        input = sc.nextLine();
////        sc.close();
//        return input;
//    }
//    public static void at(String string, String ms, boolean skip_spaces) {
//        string = colour(string);
//        at1(string + "\\", ms, skip_spaces);
//    }
    public static void lw(String text, String ms) {
        if (Integer.parseInt(ms) < 0) {
            timeout(ms);
        }
        text = colour(text);
        System.out.print(text);
        if (Integer.parseInt(ms) > 0) {
            timeout(ms);
        }
    }
    public static void cls() {
        System.out.print("[H");
        System.out.print("[2J");
    }
    public static String colour(String string) {
        string = string.replace("...sr...", ESC + "[0m");//Style reset
        string = string.replace("...sb...", ESC + "[1m");//Style bold
        string = string.replace("...su...", ESC + "[4m");//Style underline
        string = string.replace("...si...", ESC + "[7m");//Style italics
        string = string.replace("...nfba...", ESC + "[30m");//Normal Foreground black
        string = string.replace("...nfr...", ESC + "[31m");//Normal Foreground red
        string = string.replace("...nfg...", ESC + "[32m");//Normal Foreground green
        string = string.replace("...nfy...", ESC + "[33m");//Normal Foreground yellow
        string = string.replace("...nfbu...", ESC + "[34m");//Normal Foreground blue
        string = string.replace("...nfm...", ESC + "[35m");//Normal Foreground magenta
        string = string.replace("...nfc...", ESC + "[36m");//Normal Foreground cyan
        string = string.replace("...nfw...", ESC + "[37m");//Normal Foreground dark white
        string = string.replace("...nbba...", ESC + "[40m");//Normal Background black
        string = string.replace("...nbr...", ESC + "[41m");//Normal Background red
        string = string.replace("...nbg...", ESC + "[42m");//Normal Background green
        string = string.replace("...nby...", ESC + "[43m");//Normal Background yellow
        string = string.replace("...nbbu...", ESC + "[44m");//Normal Background blue
        string = string.replace("...nbm...", ESC + "[45m");//Normal Background magenta
        string = string.replace("...nbc...", ESC + "[46m");//Normal Background cyan
        string = string.replace("...nbw...", ESC + "[47m");//Normal Background dark white
        string = string.replace("...sfga...", ESC + "[90m");//Strong Foreground bright black
        string = string.replace("...sfr...", ESC + "[91m");//Strong Foreground red
        string = string.replace("...sfge...", ESC + "[92m");//Strong Foreground green
        string = string.replace("...sfy...", ESC + "[93m");//Strong Foreground yellow
        string = string.replace("...sfb...", ESC + "[94m");//Strong Foreground blue
        string = string.replace("...sfm...", ESC + "[95m");//Strong Foreground magenta
        string = string.replace("...sfc...", ESC + "[96m");//Strong Foreground cyan
        string = string.replace("...sfw...", ESC + "[97m");//Strong Foreground white
        string = string.replace("...sbba...", ESC + "[100m");//Strong Background bright black
        string = string.replace("...sbr...", ESC + "[101m");//Strong Background red
        string = string.replace("...sbg...", ESC + "[102m");//Strong Background green
        string = string.replace("...sby...", ESC + "[103m");//Strong Background yellow
        string = string.replace("...sbbu...", ESC + "[104m");//Strong Background blue
        string = string.replace("...sbm...", ESC + "[105m");//Strong Background magenta
        string = string.replace("...sbc...", ESC + "[106m");//Strong Background cyan
        string = string.replace("...sbw...", ESC + "[107m");//Strong Background white
        return string;
    }
//    public static void at1(String string, String ms, boolean skip_spaces) {
//        word = "";
//        x = 0;
//        y = 0;
//        z = 0;
//        w = 0;
//        justlettered = 0;
//        char totype[] = string.toCharArray();
//        while ((x >= string.length()) == false) {
//            if (totype[x] == '\\' || totype[y] == '\\') {
//                break;
//            }
//
//            if (Integer.parseInt(ms) < 0) {
//                timeout(ms);
//            }
//            z = 1;
//            w = 0;
//            justlettered = 0;
////            System.out.print("x");
//            while (((totype[x] == ' ' && skip_spaces == true) && justlettered == 1) || (totype[x] == '' && justlettered == 1) || z == 1 && (justlettered == 1 || z == 1)) {
////                System.out.print((justlettered == ' ' || justlettered == ''));
////                justlettered = totype[x];
////                System.out.print(justlettered + "," + z);
//                justlettered = 0;
//                if (totype[x] == '') {
//                    justlettered = 1;
//                    w = 1;
//                    y = x;
//                    word = "";
//                    while ((totype[y] == 'm') == false) {
//                        word = word + totype[y++];
//                    }
//                    word = word + totype[y++];
////                    if ((totype[y] == ' ' || totype[y] == '') == false) {
////                        word = word + totype[y++];
////                    }
//                    System.out.print(word);
//                }
//                if (totype[x] == ' ' && skip_spaces == true) {
//                    justlettered = 1;
//                    w = 1;
//                    y = x;
//                    word = "";
//                    while (totype[y] == ' ' && skip_spaces == true) {
//                        word = word + totype[y++];
//                    }
//                    if (totype[y] == '' || (totype[y] == ' ' && skip_spaces == true)) {
////                        while ((totype[y] == 'm') == false) {
////                            word = word + totype[y++];
////                        }
////                        word = word + totype[y++];
//                    }
////                    word = word + totype[y++];
//                    System.out.print(word);
//                }
//                if (totype[x] == '\\' || totype[y] == '\\') {
//                    break;
//                }
//                if ((totype[x] == '' || (totype[x] == ' ' && skip_spaces == true)) == false) {
//                    System.out.print(totype[x]);
//                    x++;
//                } else {
//                    x = y;
//                }
//                z = 0;
//                if (totype[x] == '\\' || totype[y] == '\\') {
//                    break;
//                }
//                if (((totype[x] == ' ' && skip_spaces == true) || totype[x] == '') == false && w == 1 ) {
//                    System.out.print(totype[x++]);
//                }
//            }
////            --x;
//            if (Integer.parseInt(ms) > 0) {
//                timeout(ms);
//            }
//        }
//    }
    static Integer x = 0;
    static Integer y = 0;
    static String word = "";
    static Integer z = 0;
    static Integer w = 0;
    static Integer justlettered = 0;
    public static void timeout (String ms) {
        try {
            timeout1(ms);
        } catch (Exception x) {
            //blank
        }
    }
    public static void timeout1(String ms)
    throws InterruptedException {
        long ms_long = Long.parseLong(ms);
        Thread.sleep(ms_long);
    }

    public static String ESC = "";
    public static void nl() {
        MainLib man = new MainLib();
        System.out.println(colour("...sr..." + man.nlers));
    }
}
