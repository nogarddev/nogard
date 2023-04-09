import java.util.Scanner;

public class Menu {
    static Saver saver = new Saver();
    public static String choice = "empty";
    public static void start_menu() {
//        at("Welcome to nogard!", "30", true);
        playsongFx("startup.wav");
        cls();
        at("LOADING NOGARD", "300", true);
        at("...", "1000", true);
        timeout("10100");
        playsong("background_startup.wav");
        while ((choice.equals("1") || choice.equals("2")) == false) {
            start_draw();
            choice = mainlib.choices(false, "30", true, new String[]{"1","2","3","4","5"});
            if (choice.equals("1")) {
                saver.loader();
//                return;
            }
            if (choice.equals("2")) {
                saver.save();
//                return;
            }
            if (choice.equals("3")) {
                playsong("title.wav");
                intro_screen_wall();
                at("WELCOME TO NOGARD!", "1125", true);
                Integer i =  0;
                nl();
                while ((++i == 75) == false) {
                    lw("." + mainlib.nlers, "1000");
                    nl();
                }
                stop();
            }
            if (choice.equals("4")) {
                nl();
                mainlib.nlers = "...nby......nfr...";
//                nl();
//                at("Okay!", "30", true);
                nl();
                at("When you are playing this game, you will be prompted for instructions, like you were to do the tutorial. In the game there are some base commands, like use, north, south, east, west, up, down and map.", "30", true);
                nl();
                at("Try opening the map using the command \"map\"", "30", true);
                nl();
                mainlib.choice = mainlib.choices(true, "30", true, new String[]{"USe", "NOrth", "SOuth", "EAst", "WEst", "MAp"});
                while (mainlib.choice.equals("map") == false) {
                    at("Try \"map\"!", "30", true);
                    System.out.print("[1A");
                    System.out.print("[2K");
                    System.out.print("[1A");
                    System.out.print("[2K");
                    System.out.print("[1A");
                    
                    nl();
                    mainlib.choice = mainlib.choices(true, "30", true, new String[]{"USe", "NOrth", "SOuth", "EAst", "WEst", "MAp"});
                }
                if (mainlib.choice.equals("map")) {
    //                showmap();
                    Integer skip = 1;
                }
                at("Well done!", "30", true);
                mainlib.nlers = "...nbba......sfw...";
                nl();
                at("...sr...When you are prompted for an input, some letters may be in inverted colours (switched background and foreground colours) you can type just these letters as an abbreviation if you wish, but this in non-essential.", "30", true);
                nl();
                at("For example, if you had the prompt \"([7my[27mes,[7mn[27mo)\" and you wanted the yes option, you could type \"y\" or \"yes\"", "30", true);
                nl();
                at("...sr...One other note, you will be represented with a red ...nfr...@...sr... symbol, use this to tell where you are.", "30", true);
                nl();
                mainlib.enter_break();
            }
            if (choice.equals("5")) {
                if (main.mini == false) {
                    cls();



                    System.out.println("First off, lets check that you terminal supports ANSI codes, do the lines below appear different to you? Answer with a \"yes\" or a \"no\"");
                    System.out.println("[97mNo[97mw, [97mi[97ms t[97mhis te[97mxt[97m [97mdiff[97merent?");
                    System.out.println("[97mNow, is this text different?");
                    Scanner sc = new Scanner(System.in);
                    String answer = "null";
                    while ((answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) == false) {
                        answer = sc.nextLine();
                    }
                    if (answer.equals("yes")) {
                        System.out.println("Are you on windows? Answer with a \"yes\" or a \"no\"");
                        answer = "null";
                        while ((answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) == false) {
                            answer = sc.nextLine();
                        }
                        if (answer.equals("yes")) {
//                            ProcessBuilder processBuilder = new ProcessBuilder();
//                            processBuilder.command("cmd.exe", "/c", "echo", "reg", "add", "HKEY_CURRENT_USER\\Console", "/v", "VirtualTerminalLevel", "/t", "REG_DWORD", "/d", "1", "|", "clip");
                            try {
                                Process p = Runtime.getRuntime().exec("cmd.exe /k reg add HKEY_CURRENT_USER\\Console /v VirtualTerminalLevel /t REG_DWORD /d 1 | clip");
//                                System.out.println("adsasdf");
                                System.out.println("Fix applied, please press alt+f4 and re-run the game to apply changes");
                                while (true) {
                                    if (false) {
                                        return;
                                    }
                                }
                            } catch (Exception ex) {
                                System.out.println("Failed to run command! Menu.java:94");
                                ex.printStackTrace();
                            }
                        }
                        if (answer.equals("no")) {
                            System.out.println("Could not automatically enable ANSI escape codes!");
                        }
                    }
                    at("Now lets adujust your screen size!", "30", true);
                    nl();
                    at("Zoom in/out your screen to get the smallest screen size that allows all of these hashtags to be on one line, the last hashtag is green, choose finish when you are done, or if you need more hastags, choose redraw: ", "30", true);
                    nl();
                    at("(To do do this you may have to press left control and use your scroll wheel or open your console settings)", "30", true);
                    nl();
                    while (choice.equals("finished") == false) {
                        lw("###################################################################################################################################################################################################################################################################################################...nfg...#...sfw...", "0");
                        nl();
                        choice = choices(false, "30", true, new String[]{"Redraw","Finished"});
                    }
                    at("Awesome!","30",true);
                    nl();
                    enter_break();
                }
            }
        }
        playsongFx("end_startup.wav");
        stop();
    }
    static Main main = new Main();
    //{"Ship_Down","Ship_Up","Hallway1","Room1","North_Rinlund_Town_Center","Start_forest_1","Workhouse_upstairs_north","Workhouse_upstairs_south","Start_forest_2","Start_forest_3","Start_forest_4","Hallway1_2","Downstairs_workhouse","NRTC_11","NRTC_12","NRTC_13","NRTC_14","NRTC_21","NRTC_22","NRTC_23","NRTC_24","NRTC_31","NRTC_32","NRTC_33","NRTC_34","NRTC_41","NRTC_42","NRTC_43","NRTC_44"}
    public static void start_draw() {
        cls();
        lw("._____     .___.    _________       ________         ________      ._________      .________   ","0");
        nl();
        lw("|     \\    |   |   /         \\     /  ____  \\       /        \\     |  .____  \\     |   ___  \\  ","0");
        nl();
        lw("|      \\   |   |   |  .___.  |    /  /    \\__\\     /   ____   \\    |  |    \\  \\    |  |   \\  \\ ","0");
        nl();
        lw("|       \\  |   |   |  |   |  |   |   |            |   /    \\   |   |  |     |  |   |  |    \\  \\","0");
        nl();
        lw("|        \\ |   |   |  |   |  |   |   |            |  |      |  |   |  |____/  /    |  |    |  |","0");
        nl();
        lw("|   |\\    \\|   |   |  |   |  |   |   |  .______   |  |______|  |   |   __    /     |  |    |  |","0");
        nl();
        lw("|   | \\        |   |  |   |  |   |   |  |__.  |   |   ______   |   |  |  \\   \\     |  |    |  |","0");
        nl();
        lw("|   |  \\_      |   |  |___|  |   |   |     |  |   |  |      |  |   |  |   \\   \\    |  |    /  /","0");
        nl();
        lw("|   |    \\     |   |         |    \\   \\____/  /   |  |      |  |   |  |    \\   \\   |  |___/  / ","0");
        nl();
        lw("|___|     \\____|   \\_________/     \\_________/    |__|      |__|   |__|     \\__|   |________/  ","0");
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        lw("1: load game", "0");
        nl();
        lw("2: new game", "0");
        nl();
        lw("3: intro", "0");
        nl();
        lw("4: tutorial", "0");
        nl();
        lw("5: setup", "0");
        nl();
        nl();
        lw("Release 09/04/2023 #2","0");
        nl();
        nl();
        nl();
        if (main.test) {
            System.out.println("test enabled");
        }
        if (main.ssh) {
            System.out.println("ssh enabled");
        }
        if (main.mini) {
            System.out.println("mini enabled");
        }
        if (main.mute) {
            System.out.println("mute enabled");
        }

    }
    final static MainLib mainlib = new MainLib();
    public static String choices(Boolean threaded, String ms, Boolean skip_spaces, String args[]) {
        return mainlib.choices(threaded, ms, skip_spaces, args);
    }
    public static void stopFx() {
        mainlib.stopFx();
    }
    public static void stop() {
        mainlib.stop();
    }
    public static void at(String string, String ms, boolean skip_spaces) {
        mainlib.at(string, ms, skip_spaces);
    }
    public static void at1(String string, String ms, boolean skip_spaces) {
        mainlib.at1(string, ms, skip_spaces);
    }
    public static void intro_screen_wall() {
        mainlib.intro_screen_wall();
    }
    public static String getinput() {
        return mainlib.getinput();
    }
    public static void playsongFx(String name) {
        mainlib.playsongFx(name);
    }
    public static void playsong(String name) {
        mainlib.playsong(name);
    }
    public static void timeout(String ms) {
        mainlib.timeout(ms);
    }
    public static void enter_break() {
        mainlib.enter_break();
    }
    public static void timeout1(String ms) {
        try {
            mainlib.timeout1(ms);
        } catch (Exception x) {
            //blank
        }
    }
    public static String[] concat(String one[], String two[]) {
        return mainlib.concat(one, two);
    }
    public static void nl() {
//        mainlib.nl();
        System.out.println("");
    }
    public static void lw(String text, String ms) {
        mainlib.lw(text, ms);
    }
    public static void cls() {
        mainlib.cls();
    }
    public static void showmap() {
        mainlib.showmap();
    }
    public static String colour(String string) {
        return mainlib.colour(string);
    }
}