import java.util.*;
import java.io.*;
public class ThreadedScanner extends Thread {
    public static String input;
    public static Integer skip;
    public void run() {

        waitx();
    }
    public static Integer xy = 0;
    public static void Scan(String ms, Boolean skip_spaces, String args[]) {
        MainLib man = new MainLib();
        String prompt = "";
//        at("(" +  String.join(",", args)  + ")", ms, skip_spaces);
//        nl();
//            lw(" > ", "0");
//            prompt = getinput();
        prompt = "";
        String failx = "0";
        System.out.println("ThreadedScanner:20 passed");
        while (Arrays.asList(args).contains(prompt) == false) {
            System.out.println("ThreadedScanner:22 passed");

            if (failx.equals("0")) {
                at("(" +  String.join(",", args)  + ")", ms, skip_spaces);
                System.out.println("ThreadedScanner:26 passed");
            }
            System.out.println("ThreadedScanner:28 passed");

            if (failx.equals("1")) {
                System.out.println("ThreadedScanner:31 passed");
                System.out.print("[1A");
                System.out.print("[2K");
                System.out.print("[1A");
//                System.out.print("[2K");
            }
            System.out.println("ThreadedScanner:37 passed");
            nl();
            lw(" > ", "0");
            System.out.println("ThreadedScanner:40 passed");
            MapHandler mapHandler = new MapHandler();
            if (mapHandler.dofakeanim) {
                mapHandler.fakeanim();
            }
            System.out.println("ThreadedScanner:45 passed");
            prompt = getinput();
            failx = "1";
            System.out.println("ThreadedScanner:48 passed");
        }
        System.out.println("ThreadedScanner:50 passed");
        output = prompt.toString();
        outputed = "1";
        System.out.println("ThreadedScanner:53 passed");
        man.startyouscan = "0";
        args = new String[] {};
        System.out.println("ThreadedScanner:56 passed");
        waitx();
    }
    public static String start;
    public static void waitx() {
        MainLib man = new MainLib();
        while (man.startyouscan.equals("0")) {
            timeout("1000");
            System.out.println("im alive!");
            skip = 0;
        }
        Scan(ms, skip_spaces, args);
    }
    public static String outputed;
    public static String output;
    public static String ms;
    public static Boolean skip_spaces;
    public static String args[];
    public static String getinput() {
        Main man = new Main();
        System.out.println("Threadedscanner:62 passed");
        Scanner sc = new Scanner(System.in);
        System.out.println("Threadedscanner:64 passed");

        System.out.println("Threadedscanner:66 passed");
        input = sc.nextLine();
        System.out.println("Threadedscanner:68 passed");
//        sc.close();
        if (man.ssh) {
            System.out.println("\"" + input + "\"");
        }
        System.out.println(man.ssh);
        System.out.println("Threadedscanner:69 passed");
        return input;
    }
    public static void at(String string, String ms, boolean skip_spaces) {
        MainLib man = new MainLib();
        man.at(string, ms, skip_spaces);
//        string = colour(string);
//        at1(string + "\\", ms, skip_spaces);
    }
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
    public static void at1(String string, String ms, boolean skip_spaces) {
        MainLib man = new MainLib();
        word = "";
        x = 0;
        y = 0;
        z = 0;
        w = 0;
        justlettered = 0;
        char totype[] = string.toCharArray();
        while ((x >= string.length()) == false) {
            if (totype[x] == '\\' || totype[y] == '\\') {
                break;
            }

            if (Integer.parseInt(ms) < 0) {
                timeout(ms);
            }
            z = 1;
            w = 0;
            justlettered = 0;
//            System.out.print("x");
            while (((totype[x] == ' ' && skip_spaces == true) && justlettered == 1) || (totype[x] == '' && justlettered == 1) || z == 1 && (justlettered == 1 || z == 1)) {
//                System.out.print((justlettered == ' ' || justlettered == ''));
//                justlettered = totype[x];
//                System.out.print(justlettered + "," + z);
                justlettered = 0;
                if (totype[x] == '') {
                    justlettered = 1;
                    w = 1;
                    y = x;
                    word = "";
                    while ((totype[y] == 'm') == false) {
                        word = word + totype[y++];
                    }
                    word = word + totype[y++];
//                    if ((totype[y] == ' ' || totype[y] == '') == false) {
//                        word = word + totype[y++];
//                    }
                    while (man.pause_typing == true) {
                        skip = 1;
                        timeout("20");
                    }
                    System.out.print(word);
                }
                if (totype[x] == ' ' && skip_spaces == true) {
                    justlettered = 1;
                    w = 1;
                    y = x;
                    word = "";
                    while (totype[y] == ' ' && skip_spaces == true) {
                        word = word + totype[y++];
                    }
                    if (totype[y] == '' || (totype[y] == ' ' && skip_spaces == true)) {
//                        while ((totype[y] == 'm') == false) {
//                            word = word + totype[y++];
//                        }
//                        word = word + totype[y++];
                    }
//                    word = word + totype[y++];
                    while (man.pause_typing == true) {
                        skip = 1;
                        timeout("20");
                    }
                    System.out.print(word);
                }
                if (totype[x] == '\\' || totype[y] == '\\') {
                    break;
                }
                if ((totype[x] == '' || (totype[x] == ' ' && skip_spaces == true)) == false) {
                    while (man.pause_typing == true) {
                        skip = 1;
                        timeout("20");
                    }
                    System.out.print(totype[x]);
                    x++;
                } else {
                    x = y;
                }
                z = 0;
                if (totype[x] == '\\' || totype[y] == '\\') {
                    break;
                }
                if (((totype[x] == ' ' && skip_spaces == true) || totype[x] == '') == false && w == 1 ) {
                    while (man.pause_typing == true) {
                        skip = 1;
                        timeout("20");
                    }
                    System.out.print(totype[x++]);
                }
            }
//            --x;
            if (Integer.parseInt(ms) > 0) {
                timeout(ms);
            }
        }
    }
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
        man.nl();
    }
}
