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
    public static Boolean forcebreak = false;
    public static Boolean getbreakconditions() {
        if (forcebreak) {
            forcebreak = false;
            return true;
        }
        return mapRouter.getbreakconditions(currentmap);
//        if (currentmap.equals("Ship_Down")) {
//            Ship_Down ship_Down = new Ship_Down();
//            return ship_Down.breakconditions();
//        } else if (currentmap.equals("Ship_Up")) {
//            Ship_Up ship_Up = new Ship_Up();
//            return ship_Up.breakconditions();
//        } else if (currentmap.equals("Hallway1")) {
//            Hallway1 hallway1 = new Hallway1();
//            return hallway1.breakconditions();
//        } else if (currentmap.equals("Room1")) {
//            Room1 room1 = new Room1();
//            return room1.breakconditions();
//        } else if (currentmap.equals("North_Rinlund_Town_Center")) {
//            North_Rinlund_Town_Center north_Rinlund_Town_Center = new North_Rinlund_Town_Center();
//            return north_Rinlund_Town_Center.breakconditions();
//        } else if (currentmap.equals("Start_forest_1")) {
//            Start_forest_1 start_forest_1 = new Start_forest_1();
//            return start_forest_1.breakconditions();
//        } else if (currentmap.equals("Workhouse_upstairs_north")) {
//            Workhouse_upstairs_north workhouse_upstairs_north = new Workhouse_upstairs_north();
//            return workhouse_upstairs_north.breakconditions();
//        } else if (currentmap.equals("Workhouse_upstairs_south")) {
//            Workhouse_upstairs_south workhouse_upstairs_south = new Workhouse_upstairs_south();
//            return workhouse_upstairs_south.breakconditions();
//        } else if (currentmap.equals("Start_forest_2")) {
//            Start_forest_2 start_forest_2 = new Start_forest_2();
//            return start_forest_2.breakconditions();
//        } else if (currentmap.equals("Start_forest_3")) {
//            Start_forest_3 start_forest_3 = new Start_forest_3();
//            return start_forest_3.breakconditions();
//        } else if (currentmap.equals("Start_forest_4")) {
//            Start_forest_4 start_forest_4 = new Start_forest_4();
//            return start_forest_4.breakconditions();
//        } else if (currentmap.equals("Hallway1_2")) {
//            Hallway1_2 hallway1_2 = new Hallway1_2();
//            return hallway1_2.breakconditions();
//        } else if (currentmap.equals("Downstairs_workhouse")) {
//                Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
//                return downstairs_workhouse.breakconditions();
//        } else {
//            System.out.println("no breakconditions found, going with false");
//            return false;
//        }
    }
    public static MapRouter mapRouter = new MapRouter();
    public static void update_variables() {
            movement_commands = mapRouter.movement_commands(currentmap);
            usables = mapRouter.usables(currentmap);
            grabables = mapRouter.grabables(currentmap);
            up = mapRouter.up(currentmap);
            down = mapRouter.down(currentmap);
            north = mapRouter.north(currentmap);
            east = mapRouter.east(currentmap);
            south = mapRouter.south(currentmap);
            west = mapRouter.west(currentmap);
//        if (currentmap.equals("Ship_Down")) {
//            Ship_Down ship_Down = new Ship_Down();
//            movement_commands = ship_Down.movement_commands;
//            usables = ship_Down.usables;
//            grabables = ship_Down.grabables;
////            if (Arrays.asList(movement_commands).contains("up")) {
//            up = ship_Down.up;
////            }
////            if (Arrays.asList(movement_commands).contains("down")) {
//            down = ship_Down.down;
////            }
////            if (Arrays.asList(movement_commands).contains("north")) {
//            north = ship_Down.north;
////            }
////            if (Arrays.asList(movement_commands).contains("east")) {
//            east = ship_Down.east;
////            }
////            if (Arrays.asList(movement_commands).contains("south")) {
//            south = ship_Down.south;
////            }
////            if (Arrays.asList(movement_commands).contains("west")) {
//            west = ship_Down.west;
////            }
//        }
//        if (currentmap.equals("Ship_Up")) {
////            System.out.println("eaa");
//            Ship_Up ship_Up = new Ship_Up();
//            movement_commands = ship_Up.movement_commands;
//            usables = ship_Up.usables;
//            grabables = ship_Up.grabables;
////            System.out.println(ship_Up.grabables.length);
////            System.out.println(grabables.length);
////            if (Arrays.asList(movement_commands).contains("up")) {
//            up = ship_Up.up;
////            }
////            if (Arrays.asList(movement_commands).contains("down")) {
//            down = ship_Up.down;
////            }
////            if (Arrays.asList(movement_commands).contains("north")) {
//            north = ship_Up.north;
////            }
////            if (Arrays.asList(movement_commands).contains("east")) {
//            east = ship_Up.east;
////            }
////            if (Arrays.asList(movement_commands).contains("south")) {
//            south = ship_Up.south;
////            }
////            if (Arrays.asList(movement_commands).contains("west")) {
//            west = ship_Up.west;
////            }
//        }
//        if (currentmap.equals("Room1")) {
////            System.out.println("eaa");
//            Room1 room1 = new Room1();
//            movement_commands = room1.movement_commands;
//            usables = room1.usables;
//            grabables = room1.grabables;
////            System.out.println(room1.grabables.length);
////            System.out.println(grabables.length);
////            if (Arrays.asList(movement_commands).contains("up")) {
//            up = room1.up;
////            }
////            if (Arrays.asList(movement_commands).contains("down")) {
//            down = room1.down;
////            }
////            if (Arrays.asList(movement_commands).contains("north")) {
//            north = room1.north;
////            }
////            if (Arrays.asList(movement_commands).contains("east")) {
//            east = room1.east;
////            }
////            if (Arrays.asList(movement_commands).contains("south")) {
//            south = room1.south;
////            }
////            if (Arrays.asList(movement_commands).contains("west")) {
//            west = room1.west;
////            }
//        }
//        if (currentmap.equals("Hallway1")) {
//            Hallway1 hallway1 = new Hallway1();
//            movement_commands = hallway1.movement_commands;
//            usables = hallway1.usables;
//            grabables = hallway1.grabables;
//            up = hallway1.up;
//            down = hallway1.down;
//            north = hallway1.north;
//            east = hallway1.east;
//            south = hallway1.south;
//            west = hallway1.west;
//        }
//        if (currentmap.equals("Workhouse_upstairs_north")) {
//            Workhouse_upstairs_north workhouse_upstairs_north = new Workhouse_upstairs_north();
//            movement_commands = workhouse_upstairs_north.movement_commands;
//            usables = workhouse_upstairs_north.usables;
//            grabables = workhouse_upstairs_north.grabables;
//            up = workhouse_upstairs_north.up;
//            down = workhouse_upstairs_north.down;
//            north = workhouse_upstairs_north.north;
//            east = workhouse_upstairs_north.east;
//            south = workhouse_upstairs_north.south;
//            west = workhouse_upstairs_north.west;
//        }
//        if (currentmap.equals("Workhouse_upstairs_south")) {
//            Workhouse_upstairs_south workhouse_upstairs_south = new Workhouse_upstairs_south();
//            movement_commands = workhouse_upstairs_south.movement_commands;
//            usables = workhouse_upstairs_south.usables;
//            grabables = workhouse_upstairs_south.grabables;
//            up = workhouse_upstairs_south.up;
//            down = workhouse_upstairs_south.down;
//            north = workhouse_upstairs_south.north;
//            east = workhouse_upstairs_south.east;
//            south = workhouse_upstairs_south.south;
//            west = workhouse_upstairs_south.west;
//        }
//        if (currentmap.equals("North_Rinlund_Town_Center")) {
//            North_Rinlund_Town_Center north_Rinlund_Town_Center = new North_Rinlund_Town_Center();
//            movement_commands = north_Rinlund_Town_Center.movement_commands;
//            usables = north_Rinlund_Town_Center.usables;
//            grabables = north_Rinlund_Town_Center.grabables;
//            up = north_Rinlund_Town_Center.up;
//            down = north_Rinlund_Town_Center.down;
//            north = north_Rinlund_Town_Center.north;
//            east = north_Rinlund_Town_Center.east;
//            south = north_Rinlund_Town_Center.south;
//            west = north_Rinlund_Town_Center.west;
//        }
//        if (currentmap.equals("Start_forest_1")) {
//            Start_forest_1 start_forest_1 = new Start_forest_1();
//            movement_commands = start_forest_1.movement_commands;
//            usables = start_forest_1.usables;
//            grabables = start_forest_1.grabables;
//            up = start_forest_1.up;
//            down = start_forest_1.down;
//            north = start_forest_1.north;
//            east = start_forest_1.east;
//            south = start_forest_1.south;
//            west = start_forest_1.west;
//        }
//        if (currentmap.equals("Start_forest_2")) {
//            Start_forest_2 start_forest_2 = new Start_forest_2();
//            movement_commands = start_forest_2.movement_commands;
//            usables = start_forest_2.usables;
//            grabables = start_forest_2.grabables;
//            up = start_forest_2.up;
//            down = start_forest_2.down;
//            north = start_forest_2.north;
//            east = start_forest_2.east;
//            south = start_forest_2.south;
//            west = start_forest_2.west;
//        }
//        if (currentmap.equals("Start_forest_3")) {
//            Start_forest_3 start_forest_3 = new Start_forest_3();
//            movement_commands = start_forest_3.movement_commands;
//            usables = start_forest_3.usables;
//            grabables = start_forest_3.grabables;
//            up = start_forest_3.up;
//            down = start_forest_3.down;
//            north = start_forest_3.north;
//            east = start_forest_3.east;
//            south = start_forest_3.south;
//            west = start_forest_3.west;
//        }
//        if (currentmap.equals("Start_forest_4")) {
//            Start_forest_4 start_forest_4 = new Start_forest_4();
//            movement_commands = start_forest_4.movement_commands;
//            usables = start_forest_4.usables;
//            grabables = start_forest_4.grabables;
//            up = start_forest_4.up;
//            down = start_forest_4.down;
//            north = start_forest_4.north;
//            east = start_forest_4.east;
//            south = start_forest_4.south;
//            west = start_forest_4.west;
//        }
//        if (currentmap.equals("Hallway1_2")) {
//            Hallway1_2 hallway1_2 = new Hallway1_2();
//            movement_commands = hallway1_2.movement_commands;
//            usables = hallway1_2.usables;
//            grabables = hallway1_2.grabables;
//            up = hallway1_2.up;
//            down = hallway1_2.down;
//            north = hallway1_2.north;
//            east = hallway1_2.east;
//            south = hallway1_2.south;
//            west = hallway1_2.west;
//        }
//        if (currentmap.equals("Downstairs_workhouse")) {
//            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
//            movement_commands = downstairs_workhouse.movement_commands;
//            usables = downstairs_workhouse.usables;
//            grabables = downstairs_workhouse.grabables;
//            up = downstairs_workhouse.up;
//            down = downstairs_workhouse.down;
//            north = downstairs_workhouse.north;
//            east = downstairs_workhouse.east;
//            south = downstairs_workhouse.south;
//            west = downstairs_workhouse.west;
//        }
    }
    public static Integer frame = 0;
    public static Integer animation_frames = 0;
    public static Integer map_height = 0;
    public static Boolean animation = true;
    public static void animupdate() {
        animation_frames = mapRouter.animation_frames(currentmap);
        map_height = mapRouter.animation_frames(currentmap);
//        if (currentmap.equals("Ship_Up")) {
//            Ship_Up ship_Up = new Ship_Up();
//            animation_frames = ship_Up.animation_frames;
//            map_height = ship_Up.map_height;
////            animation = ship_Up.animation;
//        } else if (currentmap.equals("Hallway1")) {
//            Hallway1 hallway1 = new Hallway1();
//            animation_frames = hallway1.animation_frames;
//            map_height = hallway1.map_height;
////            animation = hallway1.animation;
//        } else if (currentmap.equals("Ship_Down")) {
//            Ship_Down ship_Down = new Ship_Down();
//            animation_frames = ship_Down.animation_frames;
//            map_height = ship_Down.map_height;
////            animation = ship_Down.animation;
//        } else if (currentmap.equals("Room1")) {
//            Room1 room1 = new Room1();
//            animation_frames = room1.animation_frames;
//            map_height = room1.map_height;
////            animation = room1.animation;
//        } else if (currentmap.equals("North_Rinlund_Town_Center")) {
//            North_Rinlund_Town_Center north_Rinlund_Town_Center = new North_Rinlund_Town_Center();
//            animation_frames = north_Rinlund_Town_Center.animation_frames;
//            map_height = north_Rinlund_Town_Center.map_height;
//        } else if (currentmap.equals("Start_forest_1")) {
//            Start_forest_1 start_forest_1 = new Start_forest_1();
//            animation_frames = start_forest_1.animation_frames;
//            map_height = start_forest_1.map_height;
//        } else if (currentmap.equals("Start_forest_2")) {
//            Start_forest_2 start_forest_2 = new Start_forest_2();
//            animation_frames = start_forest_2.animation_frames;
//            map_height = start_forest_2.map_height;
//        } else if (currentmap.equals("Start_forest_3")) {
//            Start_forest_3 start_forest_3 = new Start_forest_3();
//            animation_frames = start_forest_3.animation_frames;
//            map_height = start_forest_3.map_height;
//        } else if (currentmap.equals("Start_forest_4")) {
//            Start_forest_4 start_forest_4 = new Start_forest_4();
//            animation_frames = start_forest_4.animation_frames;
//            map_height = start_forest_4.map_height;
//        } else if (currentmap.equals("Workhouse_upstairs_north")) {
//            Workhouse_upstairs_north workhouse_upstairs_north = new Workhouse_upstairs_north();
//            animation_frames = workhouse_upstairs_north.animation_frames;
//            map_height = workhouse_upstairs_north.map_height;
//        } else if (currentmap.equals("Workhouse_upstairs_south")) {
//            Workhouse_upstairs_south workhouse_upstairs_south = new Workhouse_upstairs_south();
//            animation_frames = workhouse_upstairs_south.animation_frames;
//            map_height = workhouse_upstairs_south.map_height;
//        } else if (currentmap.equals("Hallway1_2")) {
//            Hallway1_2 hallway1_2 = new Hallway1_2();
//            animation_frames = hallway1_2.animation_frames;
//            map_height = hallway1_2.map_height;
////            animation = hallway1_2.animation;
//        } else if (currentmap.equals("Downstairs_workhouse")) {
//            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
//            animation_frames = downstairs_workhouse.animation_frames;
//            map_height = downstairs_workhouse.map_height;
////            animation = downstairs_workhouse.animation;
//        } else {
//            animation_frames = 0;
//            map_height = 0;
////            animation = false;
//        }

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
    static Main main = new Main(); 
    public static String choices(Boolean threaded, String ms, Boolean skip_spaces, String args[]) {
        //         String[] array = array.fill(myArray, null);
        if (threaded == true) {
            ThreadedScanner threadedScanner = new ThreadedScanner();
            if (startedscan.equals("0")) {
                startyouscan = "0";
                threadedScanner.start();
            }
            threadedScanner.outputed = "0";
            threadedScanner.ms = ms;
            threadedScanner.skip_spaces = skip_spaces;
            threadedScanner.args = args;
            startyouscan = "1";
            startedscan = "1";
//            frame = 1;
            while (threadedScanner.outputed.equals("0")) {
                skipa = 1;
                if (main.ssh) {
                    timeout("1");
                }
//                System.out.println(threadedScanner.outputed);
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
            MapHandler mapHandler = new MapHandler();
            if (mapHandler.dofakeanim) {
                mapHandler.fakeanim();
            }
            return abbreivationtoword(threadedScanner.output.toString(), args);
        } else {
            String prompt = "";
            at("(" +  capstounderline(String.join(",", args))  + ")", ms, skip_spaces);
            //            nl();
            //            lw(" > ", "0");
            //            prompt = getinput();
            prompt = "";
            String failx = "0";
            String[] optionswithabbreviation = arrtoarrwithabbreviations(args);//
            while (Arrays.asList(optionswithabbreviation).contains(prompt) == false) {
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
            return abbreivationtoword(prompt.toString(), args);
        }
    }
    static String[] temporiginalandabbreviation;
    public static String abbreivationtoword(String input, String[] options) {
        Integer i = 0;
        while (i < options.length) {
            temporiginalandabbreviation = capstolowercaseandabbreviationtwinned(options[i]);
            if (input.equals(temporiginalandabbreviation[1])) {
                return temporiginalandabbreviation[0];
            } else if (input.equals(temporiginalandabbreviation[0])) {
                return temporiginalandabbreviation[0];
            }
            i++;
        }
        System.out.println("Could not convert abbreviation to option, returning original input");
        return input;
    }
    public static String[] arrtoarrwithabbreviations(String[] input) {
        String[] out = capstolowercaseandabbreviation(input[0]);
        Integer i = 1;
        while (i < input.length) {
            out = concat(out, capstolowercaseandabbreviation(input[i]));
            i++;
        }
        return out;
    }
    static String inputb;
    public static String[] capstolowercaseandabbreviationtwinned(String input) {
        String[] out = capstolowercaseandabbreviation(input);
        if (out.length == 1) {
            out = new String[]{out[0],null};
        }
        return out;
    }
    public static String[] capstolowercaseandabbreviation(String input) {
        String inputa = input;
        inputa = inputa.replace("A", "a");
        inputa = inputa.replace("B", "b");
        inputa = inputa.replace("C", "c");
        inputa = inputa.replace("D", "d");
        inputa = inputa.replace("E", "e");
        inputa = inputa.replace("F", "f");
        inputa = inputa.replace("G", "g");
        inputa = inputa.replace("H", "h");
        inputa = inputa.replace("I", "i");
        inputa = inputa.replace("J", "j");
        inputa = inputa.replace("K", "k");
        inputa = inputa.replace("L", "l");
        inputa = inputa.replace("M", "m");
        inputa = inputa.replace("N", "n");
        inputa = inputa.replace("O", "o");
        inputa = inputa.replace("P", "p");
        inputa = inputa.replace("Q", "q");
        inputa = inputa.replace("R", "r");
        inputa = inputa.replace("S", "s");
        inputa = inputa.replace("T", "t");
        inputa = inputa.replace("U", "u");
        inputa = inputa.replace("V", "v");
        inputa = inputa.replace("W", "w");
        inputa = inputa.replace("X", "x");
        inputa = inputa.replace("Y", "y");
        inputa = inputa.replace("Z", "z");
        char[] inputbchararr = input.toCharArray();
        Integer i = 0;
        inputb = null;
        while (i < inputbchararr.length) {
            if (Character.toString(inputbchararr[i]).equals(("A"))) {
                if (inputb == null) {
                    inputb = "a";
                } else {
                    inputb = inputb + "a";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("B"))) {
                if (inputb == null) {
                    inputb = "b";
                } else {
                    inputb = inputb + "b";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("C"))) {
                if (inputb == null) {
                    inputb = "c";
                } else {
                    inputb = inputb + "c";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("D"))) {
                if (inputb == null) {
                    inputb = "d";
                } else {
                    inputb = inputb + "d";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("E"))) {
                if (inputb == null) {
                    inputb = "e";
                } else {
                    inputb = inputb + "e";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("F"))) {
                if (inputb == null) {
                    inputb = "f";
                } else {
                    inputb = inputb + "f";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("G"))) {
                if (inputb == null) {
                    inputb = "g";
                } else {
                    inputb = inputb + "g";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("H"))) {
                if (inputb == null) {
                    inputb = "h";
                } else {
                    inputb = inputb + "h";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("I"))) {
                if (inputb == null) {
                    inputb = "i";
                } else {
                    inputb = inputb + "i";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("J"))) {
                if (inputb == null) {
                    inputb = "j";
                } else {
                    inputb = inputb + "j";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("K"))) {
                if (inputb == null) {
                    inputb = "k";
                } else {
                    inputb = inputb + "k";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("L"))) {
                if (inputb == null) {
                    inputb = "l";
                } else {
                    inputb = inputb + "l";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("M"))) {
                if (inputb == null) {
                    inputb = "m";
                } else {
                    inputb = inputb + "m";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("N"))) {
                if (inputb == null) {
                    inputb = "n";
                } else {
                    inputb = inputb + "n";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("O"))) {
                if (inputb == null) {
                    inputb = "o";
                } else {
                    inputb = inputb + "o";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("P"))) {
                if (inputb == null) {
                    inputb = "p";
                } else {
                    inputb = inputb + "p";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("Q"))) {
                if (inputb == null) {
                    inputb = "q";
                } else {
                    inputb = inputb + "q";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("R"))) {
                if (inputb == null) {
                    inputb = "r";
                } else {
                    inputb = inputb + "r";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("S"))) {
                if (inputb == null) {
                    inputb = "s";
                } else {
                    inputb = inputb + "s";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("T"))) {
                if (inputb == null) {
                    inputb = "t";
                } else {
                    inputb = inputb + "t";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("U"))) {
                if (inputb == null) {
                    inputb = "u";
                } else {
                    inputb = inputb + "u";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("V"))) {
                if (inputb == null) {
                    inputb = "v";
                } else {
                    inputb = inputb + "v";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("W"))) {
                if (inputb == null) {
                    inputb = "w";
                } else {
                    inputb = inputb + "w";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("X"))) {
                if (inputb == null) {
                    inputb = "x";
                } else {
                    inputb = inputb + "x";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("Y"))) {
                if (inputb == null) {
                    inputb = "y";
                } else {
                    inputb = inputb + "y";
                }
            }
            if (Character.toString(inputbchararr[i]).equals(("Z"))) {
                if (inputb == null) {
                    inputb = "z";
                } else {
                    inputb = inputb + "z";
                }
            }
            i++;
        }
        if ((inputb == null) == false) {
            return concat(new String[]{inputa},new String[]{inputb});
        } else {
            return new String[]{inputa};
        }
    }
    public static String capstounderline(String input) {
        input = input.replace("A", "...su...a...sr......nlers...");
        input = input.replace("B", "...su...b...sr......nlers...");
        input = input.replace("C", "...su...c...sr......nlers...");
        input = input.replace("D", "...su...d...sr......nlers...");
        input = input.replace("E", "...su...e...sr......nlers...");
        input = input.replace("F", "...su...f...sr......nlers...");
        input = input.replace("G", "...su...g...sr......nlers...");
        input = input.replace("H", "...su...h...sr......nlers...");
        input = input.replace("I", "...su...i...sr......nlers...");
        input = input.replace("J", "...su...j...sr......nlers...");
        input = input.replace("K", "...su...k...sr......nlers...");
        input = input.replace("L", "...su...l...sr......nlers...");
        input = input.replace("M", "...su...m...sr......nlers...");
        input = input.replace("N", "...su...n...sr......nlers...");
        input = input.replace("O", "...su...o...sr......nlers...");
        input = input.replace("P", "...su...p...sr......nlers...");
        input = input.replace("Q", "...su...q...sr......nlers...");
        input = input.replace("R", "...su...r...sr......nlers...");
        input = input.replace("S", "...su...s...sr......nlers...");
        input = input.replace("T", "...su...t...sr......nlers...");
        input = input.replace("U", "...su...u...sr......nlers...");
        input = input.replace("V", "...su...v...sr......nlers...");
        input = input.replace("W", "...su...w...sr......nlers...");
        input = input.replace("X", "...su...x...sr......nlers...");
        input = input.replace("Y", "...su...y...sr......nlers...");
        input = input.replace("Z", "...su...z...sr......nlers...");
        input = input.replace("...sr......nlers......sb...","");
        input = input.replace("...nlers...", "");
        input = input.replace("...su...","[7m");
        input = input.replace("...sr...","[27m");
        return input;         
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
        mapRouter.showmap(currentmap);
//        if (currentmap.equals("Ship_Up")) {
//            Ship_Up ship_Up = new Ship_Up();
//            ship_Up.showmap();
//        }
//        if (currentmap.equals("Ship_Down")) {
//            Ship_Down ship_Down = new Ship_Down();
//            ship_Down.showmap();
//        }
//        if (currentmap.equals("Room1")) {
//            Room1 room1 = new Room1();
//            room1.showmap();
//        }
//        if (currentmap.equals("North_Rinlund_Town_Center")) {
//            North_Rinlund_Town_Center north_Rinlund_Town_Center = new North_Rinlund_Town_Center();
//            north_Rinlund_Town_Center.showmap();
//        }
//        if (currentmap.equals("Start_forest_1")) {
//            Start_forest_1 start_forest_1 = new Start_forest_1();
//            start_forest_1.showmap();
//        }
//        if (currentmap.equals("Workhouse_upstairs_north")) {
//            Workhouse_upstairs_north workhouse_upstairs_north = new Workhouse_upstairs_north();
//            workhouse_upstairs_north.showmap();
//        }
//        if (currentmap.equals("Workhouse_upstairs_south")) {
//            Workhouse_upstairs_south workhouse_upstairs_south = new Workhouse_upstairs_south();
//            workhouse_upstairs_south.showmap();
//        }
//        if (currentmap.equals("Start_forest_2")) {
//            Start_forest_2 start_forest_2 = new Start_forest_2();
//            start_forest_2.showmap();
//        }
//        if (currentmap.equals("Start_forest_3")) {
//            Start_forest_3 start_forest_3 = new Start_forest_3();
//            start_forest_3.showmap();
//        }
//        if (currentmap.equals("Start_forest_4")) {
//            Start_forest_4 start_forest_4 = new Start_forest_4();
//            start_forest_4.showmap();
//        }
//        if (currentmap.equals("Hallway1")) {
//            Hallway1 hallway1 = new Hallway1();
//            hallway1.showmap();
//        }
//        if (currentmap.equals("Downstairs_workhouse")) {
//            Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
//            downstairs_workhouse.showmap();
//        }
//        if (currentmap.equals("Hallway1_2")) {
//            Hallway1_2 hallway1_2 = new Hallway1_2();
//            hallway1_2.showmap();
//        }
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
        String newarr[] = new String[n];
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
