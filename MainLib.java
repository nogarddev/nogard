import java.io.*;
import javax.sound.sampled.*;
import java.util.*;
public class MainLib  {
//    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static String start = "0";
    public static String started = "0";
    public static String startFx = "0";
    public static String startedFx = "0";
    public static Boolean pause_typing = false;
    static Integer i = 0;
    static AudioPlayer audioPlayer = new AudioPlayer();
    static AudioPlayerFx audioPlayerFx = new AudioPlayerFx();
    public static String killyou = "0";
    public static String killyouFx = "0";
    public static String choice;
    public static String array[];
    public static String startyouscan = "0";
    public static String startedscan = "0";
    public static String skip = "0";
    public static String currentmap = "0";
    public static String up;
    public static String down;
    public static String north;//ea
    public static String east;
    public static String south;
    public static Integer xy = 0;
    public static String west;
    public static String[][] usables = {};
    public static String[][] grabables = {};
    public static String[] movement_commands = {""};
    public static String[] all_maps = {"Ship_Up", "Ship_down"};
    public static String[][] inventory = new String[100][100];
    public static void init() {
        Anim anim = new Anim();
//        anim.start();
        inventory[0][0] = "empty";
    }
//saveables:
//Inventory
    public static String gunpowder = "0";
    public static String cannonball = "0";
//Ship_up
    public static String cannonball_left = "1";
    public static String gunpowder_left = "1";
//Ship_down
    public static String cannonball_loaded = "0";
    public static String gunpowder_loaded = "0";
    public static Boolean getbreakconditions() {
        if (currentmap.equals("Ship_Down")) {
            Ship_Down ship_Down = new Ship_Down();
            return ship_Down.breakconditions();
        } else if (currentmap.equals("Ship_Up")) {
            Ship_Up ship_Up = new Ship_Up();
            return ship_Up.breakconditions();
        } else if (currentmap.equals("Hallway1")) {
            Hallway1 hallway1 = new Hallway1();
            return hallway1.breakconditions();
        } else if (currentmap.equals("Room1")) {
                Room1 room1 = new Room1();
                return room1.breakconditions();
        } else if (currentmap.equals("Hallway1_2")) {
            Hallway1_2 hallway1_2 = new Hallway1_2();
            return hallway1_2.breakconditions();
        } else if (currentmap.equals("Downstairs_workhouse")) {
                Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
                return downstairs_workhouse.breakconditions();
        } else {
            System.out.println("no breakconditions found, going with false");
            return false;
        }
    }
    public static void update_variables() {
        if (currentmap.equals("Ship_Down")) {
            Ship_Down ship_Down = new Ship_Down();
            movement_commands = ship_Down.movement_commands;
            usables = ship_Down.usables;
            grabables = ship_Down.grabables;
//            if (Arrays.asList(movement_commands).contains("up")) {
            up = ship_Down.up;
//            }
//            if (Arrays.asList(movement_commands).contains("down")) {
            down = ship_Down.down;
//            }
//            if (Arrays.asList(movement_commands).contains("north")) {
            north = ship_Down.north;
//            }
//            if (Arrays.asList(movement_commands).contains("east")) {
            east = ship_Down.east;
//            }
//            if (Arrays.asList(movement_commands).contains("south")) {
            south = ship_Down.south;
//            }
//            if (Arrays.asList(movement_commands).contains("west")) {
            west = ship_Down.west;
//            }
        }
        if (currentmap.equals("Ship_Up")) {
//            System.out.println("eaa");
            Ship_Up ship_Up = new Ship_Up();
            movement_commands = ship_Up.movement_commands;
            usables = ship_Up.usables;
            grabables = ship_Up.grabables;
//            System.out.println(ship_Up.grabables.length);
//            System.out.println(grabables.length);
//            if (Arrays.asList(movement_commands).contains("up")) {
            up = ship_Up.up;
//            }
//            if (Arrays.asList(movement_commands).contains("down")) {
            down = ship_Up.down;
//            }
//            if (Arrays.asList(movement_commands).contains("north")) {
            north = ship_Up.north;
//            }
//            if (Arrays.asList(movement_commands).contains("east")) {
            east = ship_Up.east;
//            }
//            if (Arrays.asList(movement_commands).contains("south")) {
            south = ship_Up.south;
//            }
//            if (Arrays.asList(movement_commands).contains("west")) {
            west = ship_Up.west;
//            }
        }
        if (currentmap.equals("Room1")) {
//            System.out.println("eaa");
            Room1 room1 = new Room1();
            movement_commands = room1.movement_commands;
            usables = room1.usables;
            grabables = room1.grabables;
//            System.out.println(room1.grabables.length);
//            System.out.println(grabables.length);
//            if (Arrays.asList(movement_commands).contains("up")) {
            up = room1.up;
//            }
//            if (Arrays.asList(movement_commands).contains("down")) {
            down = room1.down;
//            }
//            if (Arrays.asList(movement_commands).contains("north")) {
            north = room1.north;
//            }
//            if (Arrays.asList(movement_commands).contains("east")) {
            east = room1.east;
//            }
//            if (Arrays.asList(movement_commands).contains("south")) {
            south = room1.south;
//            }
//            if (Arrays.asList(movement_commands).contains("west")) {
            west = room1.west;
//            }
        }
        if (currentmap.equals("Hallway1")) {
            Hallway1 hallway1 = new Hallway1();
            movement_commands = hallway1.movement_commands;
            usables = hallway1.usables;
            grabables = hallway1.grabables;
            up = hallway1.up;
            down = hallway1.down;
            north = hallway1.north;
            east = hallway1.east;
            south = hallway1.south;
            west = hallway1.west;
        }
        if (currentmap.equals("Hallway1_2")) {
            Hallway1_2 hallway1_2 = new Hallway1_2();
            movement_commands = hallway1_2.movement_commands;
            usables = hallway1_2.usables;
            grabables = hallway1_2.grabables;
            up = hallway1_2.up;
            down = hallway1_2.down;
            north = hallway1_2.north;
            east = hallway1_2.east;
            south = hallway1_2.south;
            west = hallway1_2.west;
        }
        if (currentmap.equals("Downstairs_workhouse")) {
            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
            movement_commands = downstairs_workhouse.movement_commands;
            usables = downstairs_workhouse.usables;
            grabables = downstairs_workhouse.grabables;
            up = downstairs_workhouse.up;
            down = downstairs_workhouse.down;
            north = downstairs_workhouse.north;
            east = downstairs_workhouse.east;
            south = downstairs_workhouse.south();
            west = downstairs_workhouse.west;
        }
    }
    public static Integer frame = 0;
    public static Integer animation_frames = 0;
    public static Integer map_height = 0;
    public static Boolean animation = true;
    public static void animupdate() {

        if (currentmap.equals("Ship_Up")) {
            Ship_Up ship_Up = new Ship_Up();
            animation_frames = ship_Up.animation_frames;
            map_height = ship_Up.map_height;
//            animation = ship_Up.animation;
        } else if (currentmap.equals("Hallway1")) {
            Hallway1 hallway1 = new Hallway1();
            animation_frames = hallway1.animation_frames;
            map_height = hallway1.map_height;
//            animation = hallway1.animation;
        } else if (currentmap.equals("Ship_Down")) {
            Ship_Down ship_Down = new Ship_Down();
            animation_frames = ship_Down.animation_frames;
            map_height = ship_Down.map_height;
//            animation = ship_Down.animation;
        } else if (currentmap.equals("Room1")) {
            Room1 room1 = new Room1();
            animation_frames = room1.animation_frames;
            map_height = room1.map_height;
//            animation = room1.animation;
        } else if (currentmap.equals("Hallway1_2")) {
            Hallway1_2 hallway1_2 = new Hallway1_2();
            animation_frames = hallway1_2.animation_frames;
            map_height = hallway1_2.map_height;
//            animation = hallway1_2.animation;
        } else if (currentmap.equals("Downstairs_workhouse")) {
            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
            animation_frames = downstairs_workhouse.animation_frames;
            map_height = downstairs_workhouse.map_height;
//            animation = downstairs_workhouse.animation;
        } else {
            animation_frames = 0;
            map_height = 0;
//            animation = false;
        }

    }
//    public static void anim(Integer frame) {
//        if (currentmap.equals("Ship_Up")) {
//            Ship_Up ship_Up = new Ship_Up();
//            ship_Up.anim(frame);
//        }
//        if (currentmap.equals("Ship_Down")) {
//            Ship_Down ship_Down = new Ship_Down();
//            ship_Down.anim(frame);
//        }
//    }
    public static Integer skipa = 0;
    public static String choices(Boolean threaded, String ms, Boolean skip_spaces, String args[]) {
        //         String[] array = array.fill(myArray, null);
        System.out.println("Mainlib:245 passed");
        if (threaded == true) {
            ThreadedScanner threadedScanner = new ThreadedScanner();
            System.out.println("Mainlib:248 passed");
            if (startedscan.equals("0")) {
                System.out.println("Mainlib:250 passed");
                startyouscan = "0";
                threadedScanner.start();
            }
            System.out.println("Mainlib:253 passed");
            threadedScanner.outputed = "0";
            threadedScanner.ms = ms;
            System.out.println("Mainlib:257 passed");
            threadedScanner.skip_spaces = skip_spaces;
            System.out.println("Mainlib:259 passed");
            threadedScanner.args = args;
            System.out.println("Mainlib:261 passed");
            startyouscan = "1";
            startedscan = "1";
//            frame = 1;
            System.out.println("Mainlib:265 passed");
            while (threadedScanner.outputed.equals("0")) {
                skipa = 1;
                timeout("1000");
                System.out.println(threadedScanner.outputed);
//                skip = "0";
//                //api for animation
//                animupdate();
//                if (frame == animation_frames) {
//                    frame = 1;
//                }
//                if (animation) {
//                    System.out.print("[s");
//                    System.out.print("[?25h");
//                    System.out.print("[1G");
//                    System.out.print("[" + map_height.toString() + "A");
//                    anim(frame);
//                    System.out.print("[u");
//
//                }
//
//
//
//
//
//
//
////                if (frame == 0) {
////                    System.out.print("[s");
////                    System.out.print("[?25h");
////                    System.out.print("[h");
////                    System.out.print("[a");
////                    System.out.print("[6B");
////                    System.out.print("[12C");
////                    System.out.print("a");
////                    System.out.print("[u");
////                    frame = 1;
////                }
////                timeout("1000");
////                if (frame == 1) {
////                    System.out.print("[s");
////                    System.out.print("[?25h");
////                    System.out.print("[h");
////                    System.out.print("[a");
////                    System.out.print("[6B");
////                    System.out.print("[12C");
////                    System.out.print("b");
////                    System.out.print("[u");
////                    frame = 0;
////                }
//                timeout("1000");
            }
            System.out.println("Mainlib:316 passed");
            MapHandler mapHandler = new MapHandler();
            if (mapHandler.dofakeanim) {
                System.out.println("Mainlib:319 passed");
                mapHandler.fakeanim();
            }
            System.out.println("Mainlib:322 passed");
            return threadedScanner.output.toString();
        } else {
            System.out.println("Mainlib:325 passed");
            String prompt = "";
            at("(" +  String.join(",", args)  + ")", ms, skip_spaces);
            //            nl();
            //            lw(" > ", "0");
            //            prompt = getinput();
            prompt = "";
            String failx = "0";

            while (Arrays.asList(args).contains(prompt) == false) {
                if (failx.equals("1")) {
                    System.out.print("[1A");
                    System.out.print("[2K");
                    System.out.print("[1A");
                    //                    System.out.print("[2K");
                }
                failx = "1";
                //                at("(" +  String.join(",", args)  + ")", ms, skip_spaces);
                nl();
                lw(" > ", "0");
                MapHandler mapHandler = new MapHandler();
                if (mapHandler.dofakeanim) {
                    mapHandler.fakeanim();
                }
                prompt = getinput();
            }
            MapHandler mapHandler = new MapHandler();
            if (mapHandler.dofakeanim) {
                mapHandler.fakeanim();
            }
            System.out.println("Mainlib:357 passed");
            return prompt.toString();        
        }
    }
    public static Boolean comingfromcorelib = false;
    public static String startyouanim = "0";
    public static void startanim() {
        startyouanim = "1";
    }
    public static void stopanim() {
        startyouanim = "0";
    }
    public static void stopFx() {
        while (killyouFx == "0") {
            killyouFx = "1";
        }
        timeout("200");
        killyouFx = "0";
    }
    public static void stop() {
        while (killyou == "0") {
            killyou = "1";
        }
        timeout("200");
        killyou = "0";
    }
    static Integer x = 0;
    static Integer y = 0;
    static String word = "";
    public static void at(String string, String ms, boolean skip_spaces) {
        string = colour(string);
        at1(string + "\\", ms, skip_spaces);
    }
    static Integer z = 0;
    static Integer w = 0;
    static Integer justlettered = 0;
    public static void at1(String string, String ms, boolean skip_spaces) {
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
                    while (pause_typing == true) {
                        skip = "1";
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
                    while (pause_typing == true) {
                        skip = "1";
                        timeout("20");
                    }
                    System.out.print(word);
                }
                if (totype[x] == '\\' || totype[y] == '\\') {
                    break;
                }
                if ((totype[x] == '' || (totype[x] == ' ' && skip_spaces == true)) == false) {
                    while (pause_typing == true) {
                        skip = "1";
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
                    while (pause_typing == true) {
                        skip = "1";
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
    public static void enter_break() {
        lw("Press enter to continue...", "0");
        nl();
        Scanner a = new Scanner(System.in);
        a.nextLine();
        System.out.print("[1A");
        System.out.print("[2K");
        System.out.print("[1A");
        System.out.print("[2K");
    }
    public static void intro_screen_wall() {
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
    }
    public static String input;
    public static String getinput() {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
//        sc.close();
        while (pause_typing == true) {
            skip = "1";
            timeout("20");
        }
        return input;
    }
//    public static String threadedscanner() {
//        
//    }
    public static void playsongFx(String name) {
        stopFx();
        timeout("1000");
        AudioPlayerFx playerFx = new AudioPlayerFx();
        playerFx.Seturl(name);
        timeout("100");
        try
        {
            if (startedFx == "0") {
                audioPlayerFx.start();
                startedFx = "1";
                startFx = "1";
                timeout("200");
                startFx = "0";
            } else {
                startFx = "1";
                timeout("200");
                startFx = "0";
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    public static void playsong(String name) {
        stop();
        timeout("1000");
        AudioPlayer player = new AudioPlayer();
        player.Seturl(name);
        timeout("100");
        try
        {
            if (started == "0") {
                audioPlayer.start();
                started = "1";
                start = "1";
                timeout("200");
                start = "0";
            } else {
                start = "1";
                timeout("200");
                start = "0";
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
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
    //https://stackoverflow.com/questions/683427/launch-application-in-a-minimized-state-from-java
    public static void startmin(String name) {
        try
        {
            startmin1(name);
        }
        catch (Exception x) {
            //blank
        }
    }
    public static void startmin1(String name) throws IOException {
        String cmd = "cmd /c start /min C:/Users/aaron/Desktop/java/dofe/nogard/fx/" + name;
        Runtime.getRuntime().exec(cmd);
    }
    static String nlers = "";
    public static void nl() {
        MapHandler mapHandler = new MapHandler();
        System.out.println(colour("...sr..." + nlers));
        if (mapHandler.dofakeanim && comingfromcorelib == false) {
            mapHandler.fakeanim();
            lw(nlers, "0");
        }
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
    private static final char ESC = 27; // Escape character used to start an ANSI code
    public static void showmap() {
        comingfromcorelib = true;
        String tempnlers = nlers;
//        nlers = "...sbw......nfba...";
        if (currentmap.equals("Ship_Up")) {
            Ship_Up ship_Up = new Ship_Up();
            ship_Up.showmap();
        }
        if (currentmap.equals("Ship_Down")) {
            Ship_Down ship_Down = new Ship_Down();
            ship_Down.showmap();
        }
        if (currentmap.equals("Room1")) {
            Room1 room1 = new Room1();
            room1.showmap();
        }
        if (currentmap.equals("Hallway1")) {
            Hallway1 hallway1 = new Hallway1();
            hallway1.showmap();
        }
        if (currentmap.equals("Downstairs_workhouse")) {
            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
            downstairs_workhouse.showmap();
        }
        if (currentmap.equals("Hallway1_2")) {
            Hallway1_2 hallway1_2 = new Hallway1_2();
            hallway1_2.showmap();
        }
        nlers = tempnlers;
        //        nlers = "...sbw......nfba...";
//        lw("  ################################################################################################################################################################################################################################################################################################  ", "0");
//        nl();
//        lw("####################################################################################################################################################################################################################################################################################################", "0");
//        nl();
//        lw("#####                                                                                                                                                                                                                                                                                          #####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                      _________________                                     ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                    _/                 \\_                       ____________####", "0");
//        nl();
//        lw("####                                                ________________________                                                                                                                                                          _/                     \\_                   _/            ####", "0");
//        nl();
//        lw("####                                              _/                        \\_                                               _____________________                                                                                  _/      __________         \\_               _/              ####", "0");
//        nl();
//        lw("####         ___________________                 /      ...nfr...River Damp...nfba...            \\_                                           _/                     \\__                                                          ____________________/      _/          \\_         \\_           _/                ####", "0");
//        nl();
//        lw("####       _/                   \\_               |      ________________        \\_                                       _/                          \\_                                                      _/                         _/              \\_         \\_________/      ____________####", "0");
//        nl();
//        lw("####     _/                       \\_             |    _/                \\_        \\_                                   _/      _________________       \\_                                                  _/                         _/                  \\_                      _/            ####", "0");
//        nl();
//        lw("####   _/     _______________       \\_           |   /                    \\_        \\_                               _/      _/                 \\_       \\_                                              _/      ____________________/                      \\_                  _/              ####", "0");
//        nl();
//        lw("#### _/     _/               \\_       \\_         |   |                      \\_        \\_                           _/      _/                     \\_       \\_                  _________________________/      _/                                             \\_              _/                ####", "0");
//        nl();
//        lw("####/     _/                   \\_       \\_       |   |                        \\_        \\_                       _/      _/                         \\_       \\_               /                              _/                                                 \\____________/                  ####", "0");
//        nl();
//        lw("####    _/                       \\_       \\_____/    |                          \\_        \\_                  __/      _/                             \\_       \\__.  ._______/                             _/                                                                                   ####", "0");
//        nl();
//        lw("####  _/                           \\_               _/                            \\_        \\_              _/       _/                                 \\_        |##|                        ____________/                                                                                     ####", "0");
//        nl();
//        lw("####_/                               \\_____________/                                \\_        \\_____.______/       _/                                     \\_      |##|          _____________/                                                                                                  ####", "0");
//        nl();
//        lw("####                                                                                  \\_            | ...nfr...Ragmatical...nfba... _/                                         \\_____|##|_________/                                                                                                                ####", "0");
//        nl();
//        lw("####                                                                                    \\_          | ...nfr...Rope...nfba...     _/                                                                                                                                                                               ####", "0");
//        nl();
//        lw("####                                                                                      \\_________|_________/                                                                                                                                                                                 ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                                                                                                           /\\                                                                                                                                               ####", "0");
//        nl();
//        lw("####                                                                                                                                          /  \\                                                                                                                                              ####", "0");
//        nl();
//        lw("####                                                                                                                                         /    \\                                                                                                                                             ####", "0");
//        nl();
//        lw("####  __                                                                                                                                    /      \\                                                                                                                                            ####", "0");
//        nl();
//        lw("#### /  \\                                                                                                                                  /        \\                                                                                                                                           ####", "0");
//        nl();
//        lw("#### |   \\                                                                                                                                 |         \\                                                                                                                                          ####", "0");
//        nl();
//        lw("#### |    \\                                                                                                        .   .                   |       ___\\                                                                                                                                         ####", "0");
//        nl();
//        lw("#### /    |                                                                                                       /_\\ /_\\                  |       \\                                                                                                                                            ####", "0");
//        nl();
//        lw("####/     |                                                                                                       /_\\ /_\\.                 |        \\                                                                                                                                           ####", "0");
//        nl();
//        lw("####      |                                                                                                       /_\\./_\\_\\                |__    ___\\                                                                                                                                          ####", "0");
//        nl();
//        lw("####      |                                                .  <|   .                                               |/_\\|/_\\                   |  |                                                                                                                                              ####", "0");
//        nl();
//        lw("####      |                                               /^\\ /^\\ /^\\                                             . /_\\ /_\\                   |  |   ...nfr...Ol' Mike...nfba...                                                                                                                                   ####", "0");
//        nl();
//        lw("####      |                                 ___________   |O|_|O|_|O|                                            /_\\/_\\. |                    |  |                                                                                                                                              ####", "0");
//        nl();
//        lw("####      |                                /           \\  |    _    |                                            /_\\\\|/_\\ .                   |__|                                                                                                                                              ####", "0");
//        nl();
//        lw("####      |             __________        /             \\ |___|_|___| ...nfr...Rinlund...nfba...                                    /_\\| ._\\/_\\                                                                                                                                                                    ####", "0");
//        nl();
//        lw("####      |            /          \\      /               \\     |      ...nfr...Castle...nfba...                                      |. /_\\\\/_\\                                                                                                                                                                    ####", "0");
//        nl();
//        lw("####       \\           |           |    /                 |    V                                                  /_\\/_|\\/_\\                                                                                                                                                                    ####", "0");
//        nl();
//        lw("####        \\         /            |   /                  |                                                       /_\\/_\\\\ |.                                                                                                                                                                    ####", "0");
//        nl();
//        lw("####         \\_       |            \\  /                   \\###                                                    /_\\ |\\ //_\\  ...nfr...Ferrous...nfba...                                                                                                                                                          ####", "0");
//        nl();
//        lw("####           \\_    /              \\/                     |##  ...nfr...Rinlund...nfba...                                           .| /_\\ ./_\\  ...nfr...Forrest...nfba...                                                                                                                                                          ####", "0");
//        nl();
//        lw("####             \\_  |                                     |##                                                   /_\\ /_\\/_\\_\\                                                                                                                                                                   ####", "0");
//        nl();
//        lw("####               \\_/                                     \\###                                                  /_\\  . /_\\|                                                                                                                                                                    ####", "0");
//        nl();
//        lw("####                                                        |###                                                 /_\\ /_\\/_\\                                                                                                                                                                     ####", "0");
//        nl();
//        lw("####                                                        |###                                                  |. /_\\/|\\ .                                                                                                                                                                   ####", "0");
//        nl();
//        lw("####                                                        \\##                                                   /_\\/_\\/_\\/_\\                                                                                                                                                                  ####", "0");
//        nl();
//        lw("####                                                         |#                                                   /_\\ | /_\\/_\\                                                                                                                                                                  ####", "0");
//        nl();
//        lw("####                                                         \\#                                                   /_\\ . .| ._\\                                                                                                                                                                  ####", "0");
//        nl();
//        lw("####                                                          |#                                                  /|\\/_\\_\\/_\\                                                                                                                                                                   ####", "0");
//        nl();
//        lw("####                                                          \\                                                   /_\\/_\\_\\/_\\                                                                                                                                                                   ####", "0");
//        nl();
//        lw("####                                                           |         _________                                /_\\/_\\_\\/_\\                                                                                                                                                                   ####", "0");
//        nl();
//        lw("####                                                           \\        /         \\                                |  | |  |                                                                                                                                                                    ####", "0");
//        nl();
//        lw("####                                                            \\      /           \\                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                             \\    /            |                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                              \\  /             |                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("####                                                               \\/              \\                                                                                                                                                                                                            ####", "0");
//        nl();
//        lw("#####                                                                               \\                                                                                                                                                                                                          #####", "0");
//        nl();
//        lw("####################################################################################################################################################################################################################################################################################################", "0");
//        nl();
//        lw("  ################################################################################################################################################################################################################################################################################################  ", "0");
//        nl();
//        nlers = tempnlers;
        comingfromcorelib = false;
    }
    public static Integer[] excludeintarr(Integer[] arr, Integer start_pos, Integer exclude) {
        Integer arr_len = arr.length;
        Integer arr_process_temp1 = 0;
        Integer arr_current_pos = 0;
        Integer[] out = new Integer[arr_len - exclude];
        while ((arr_process_temp1 == arr_len) == false) {
            if (arr_process_temp1 == start_pos) {
                arr_process_temp1 = arr_process_temp1 + exclude;
            }
            out[arr_current_pos] = arr[arr_process_temp1];
            arr_process_temp1++;
            arr_current_pos++;
        }
        return out;
    }
    public static String[][] exclude2dstrarr(String[][] arr, Integer height, Integer start_pos, Integer exclude) {
        Integer arr_len = arr.length;
        Integer arr_process_temp1 = 0;
        Integer arr_current_pos = 0;
        String[][] out = new String[arr_len - exclude][height];
        while ((arr_process_temp1 == arr_len) == false) {
            if (arr_process_temp1 == start_pos) {
                arr_process_temp1 = arr_process_temp1 + exclude;
            }
            out[arr_current_pos] = arr[arr_process_temp1];
            arr_process_temp1++;
            arr_current_pos++;
        }
        return out;
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
    public static String[] concat(String one[], String two[])
    {
        int i;
        int n = one.length + two.length;
        // create a new array of size n+1
        String newarr[] = new String[n];
    
        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
//        for (i = 0; i < n; i++)
//            newarr[i] = arr[i];
//    
//        newarr[n] = x;
        i = 0;
        while ((i >= one.length) == false) {
            newarr[i] = one[i];
            i++;
        }
        i = 0;
        while ((i >= two.length) == false) {
            newarr[i + one.length] = two[i];
            i++;
        }
        return newarr;
    }
}
