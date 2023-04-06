import java.io.*;
import javax.sound.sampled.*;
import java.util.*;
import java.lang.*;
public class Main {
    public static Boolean test = false;
    public static final GunLib gunLib = new GunLib();
    public static Boolean ssh = false;
    public static Boolean help = false;
    public static Boolean mini = false;
    public static Boolean mute = false;
    public static Integer xy = 0;
    static Nogard2videoplayer nogard2videoplayer = new Nogard2videoplayer();
    public static void main(String[] args) {
        if ((args.length == 0) == false) {
            Integer loop1 = 0;
            while ((args.length == loop1) == false) {
                if (args[loop1].equals("test")) {
                    test = true;
                    System.out.println("test enabled");
                }
                loop1++;
            }
            loop1 = 0;
            while ((args.length == loop1) == false) {
                if (args[loop1].equals("ssh")) {
                    ssh = true;
                    System.out.println("ssh enabled");
                }
                loop1++;
            }
            loop1 = 0;
            while ((args.length == loop1) == false) {
                if (args[loop1].equals("help")) {
                    help = true;
                }
                loop1++;
            }
            loop1 = 0;
            while ((args.length == loop1) == false) {
                if (args[loop1].equals("mini")) {
                    mini = true;
                    System.out.println("mini enabled");
                }
                loop1++;
            }            
            loop1 = 0;
            while ((args.length == loop1) == false) {
                if (args[loop1].equals("mute")) {
                    mute = true;
                    System.out.println("mute enabled");
                }
                loop1++;
            }            
        }
        FightMapRouter fightMapRouter = new FightMapRouter();
        fightMapRouter.init();
        North_Rinlund_Town_Center north_Rinlund_Town_Center = new North_Rinlund_Town_Center();
        north_Rinlund_Town_Center.init();
        Start_forest_1 start_forest_1 = new Start_forest_1();
        start_forest_1.init();
        Start_forest_2 start_forest_2 = new Start_forest_2();
        start_forest_2.init();
        Start_forest_3 start_forest_3 = new Start_forest_3();
        start_forest_3.init();
        Start_forest_4 start_forest_4 = new Start_forest_4();
        start_forest_4.init();
        TestFightMap testFightMap = new TestFightMap();
        testFightMap.init();
        CaveFightMap caveFightMap = new CaveFightMap();
        caveFightMap.init();
        Ship_Up ship_Up = new Ship_Up();
        ship_Up.init();
        Hallway1 hallway1 = new Hallway1();
        hallway1.init();
        Ship_Down ship_Down = new Ship_Down();
        ship_Down.init();
        MainLib mainLib = new MainLib();
        mainLib.init();
        Room1 room1 = new Room1();
        room1.init();
        NRTC_11 nRTC_11 = new NRTC_11();
        nRTC_11.init();
        NRTC_12 nRTC_12 = new NRTC_12();
        nRTC_12.init();
        NRTC_13 nRTC_13 = new NRTC_13();
        nRTC_13.init();
        NRTC_14 nRTC_14 = new NRTC_14();
        nRTC_14.init();
        NRTC_21 nRTC_21 = new NRTC_21();
        nRTC_21.init();
        NRTC_22 nRTC_22 = new NRTC_22();
        nRTC_22.init();
        NRTC_23 nRTC_23 = new NRTC_23();
        nRTC_23.init();
        NRTC_24 nRTC_24 = new NRTC_24();
        nRTC_24.init();
        NRTC_31 nRTC_31 = new NRTC_31();
        nRTC_31.init();
        NRTC_32 nRTC_32 = new NRTC_32();
        nRTC_32.init();
        NRTC_33 nRTC_33 = new NRTC_33();
        nRTC_33.init();
        NRTC_34 nRTC_34 = new NRTC_34();
        nRTC_34.init();
        NRTC_41 nRTC_41 = new NRTC_41();
        nRTC_41.init();
        NRTC_42 nRTC_42 = new NRTC_42();
        nRTC_42.init();
        NRTC_43 nRTC_43 = new NRTC_43();
        nRTC_43.init();
        NRTC_44 nRTC_44 = new NRTC_44();
        nRTC_44.init();
        Workhouse_upstairs_north workhouse_upstairs_north = new Workhouse_upstairs_north();
        workhouse_upstairs_north.init();
        Workhouse_upstairs_south workhouse_upstairs_south = new Workhouse_upstairs_south();
        workhouse_upstairs_south.init();
        Hallway1_2 hallway1_2 = new Hallway1_2();
        hallway1_2.init();
        Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
        downstairs_workhouse.init();
        AudioPlayer player = new AudioPlayer();
        AudioPlayerFx playerFx = new AudioPlayerFx();
        if (help) {
            at("Current options:", "30", true);
            nl();
            nl();
            nl();
            at("test: enables a debug option when playing the game", "30", true);
            nl();
            at("help: displays this message", "30", true);
            nl();
            at("mini: used to not interrupt displays that cannot be resized by removing certain elements", "30", true);
            nl();
            at("ssh: used to allow compatability with ssh clients and similar, this should be tried as a potential fix when typing into inputs doesn't work", "30", true);
            nl();
            at("mute: stops audio from playing so that no error messages pop up", "30", true);
            nl();
            at("press enter to close", "30", true);
            nl();
            enter_break();
            nl();
            System.exit(0);
        }
        mainlib.nlers = "...sbw......nfba...";
        nl();
        at("Watch intro?", "30", true);
        nl();
        mainlib.choice = mainlib.choices(true, "30", true, new String[]{"yes", "no"});
        //        System.out.println((xy++).toString());
        if (mainlib.choice.equals("yes")) {
            playsong("title.wav");
            intro_screen_wall();
            at("WELCOME TO NOGARD!", "1125", true);
            mainlib.i =  0;
            nl();
            while ((++mainlib.i == 75) == false) {
                lw("." + mainlib.nlers, "400");
                nl();
            }
        }
        mainlib.nlers = "...sbba......sfw...";
        nl();
        cls();
        stop();
        at("Hello! Before we begin, should we do a little tutorial?", "30", true);
        nl();
        mainlib.choice = mainlib.choices(true, "30", true, new String[]{"yes", "no"});
        if (mainlib.choice.equals("yes")) {
            nl();
            mainlib.nlers = "...nby......nfr...";
            nl();
            at("Okay!", "30", true);
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
//        if (mainlib.choice.equals("no")) {
//            showmap();
//        }
//        if (test == false) {
//            mainlib.nlers = "...nbba......sfw...";
//            nl();
//            cls();
//            System.out.print("[1;1H");
//            mainlib.nlers = "...nbba......sfw...";
//            mainlib.currentmap = "Ship_Up";
//            mainlib.update_variables();
//            at("...sfr...Narrator: " + mainlib.nlers + "Your story begins in the town on Rinlund", "30", true);
//            nl();
//            playsong("town.wav");
//            at("        ...sfr...:" + mainlib.nlers + " at the young age of around 18, you lived in poverty, and had to pick pockets and beg to be able to afford to eat.", "30", true);
//            timeout("1000");
//            nl();
//            at("        ...sfr...:" + mainlib.nlers + " As a child you had been told of stories of great pirates and their spectacular downfalls, adventurers and their quests.", "30", true);
//            nl();
//            enter_break();
//            at("        ...sfr...:" + mainlib.nlers + " But that was a long world off from@where you were. You were hoping through all these years that you would live with security and comfort.", "30", true);
//            timeout("1000");
//            nl();
//            at("        ...sfr...:" + mainlib.nlers + " To see the faces of the horrible men at the workhouse who worked you day and night, and fed you but scraps of food.", "30", true);
//            timeout("1000");
//            nl();
//            at("        ...sfr...:" + mainlib.nlers + " They made you feel trapped, saying that you would never survive outside and that you would surely perish from@starvation.", "30", true);
//            nl();
//            enter_break();
//            at("        ...sfr...:" + mainlib.nlers + " They were very close to the truth, you were a withered husk. They locked you in your quarters as you slept, to stop you from@escaping", "30", true);
//            timeout("1000");
//            nl();
//            at("        ...sfr...:" + mainlib.nlers + " You escaped through a broken window", "30", true);
//            at("...", "1000", true);
//            nl();
//            at("        ...sfr...:" + mainlib.nlers + " You were a street rat, but not by choice,", "30", true);
//            nl();
//            enter_break();
//            at("        ...sfr...:" + mainlib.nlers + " you decided, that despite the danger of execution by the empire, you had to join a pirate crew, at least then you wouldn't wither to death", "30", true);
//            at("...", "1000", true);
//            timeout("1000");
//            nl();
//            playsong("Call_to_Adventure.wav");
//            at("        ...sfr...:" + mainlib.nlers + " You decided to join ...nfr...Capt'n Corkscrew's" + mainlib.nlers + " crew.", "30", true);
//            timeout("1000");
//            at("...", "1000", true);
//            nl();
//            at("        ...sfr...:" + mainlib.nlers + " Begrudgingly, they accepted you onboard as a powder boy, and thats where the story begins.", "30", true);
//            nl();
//            at("...nfr...Capt'n Corkscrew:", "30", true);
//            at(mainlib.nlers + " Oi! What do you think you are doing? Get down there and shoot the enemy on my mark!", "75", true);
//            nl();
//            at("...nfbu...Crewmate Cory: ", "30", true);
//            at(mainlib.nlers + "READY WHEN YOU ARE CAPT'N!", "150", true);
//            nl();
//            at("Objective: get ...sb......su......nfc...gunpowder...sr... and ...sb......su......nfc...cannonballs...sr... and load them@into a cannon below deck", "30", true);
//            nl();
//            showmap();
//            MapHandler mapHandler = new MapHandler();
//            mapHandler.game_prompt();
//        }
        mainlib.nlers = "...nbba......sfw...";
        mainlib.playsong("Spooky.wav");
        nl();
        cls();
        if (test == false) {
            at("...sfr...Narrator: " + mainlib.nlers + "Your story begins in an old workhouse, during industrial revolution era Britain.", "30", true);
            nl();
            at("        ...sfr...: " + mainlib.nlers + "This workhouse takes advantage of the poor and weak like any other.", "30", true);
            nl();
            at("        ...sfr...: " + mainlib.nlers + "You are the said poor.", "30", true);
            nl();
            enter_break();
            at("        ...sfr...: " + mainlib.nlers + "You need to get out of your room.", "30", true);
            nl();
            at("        ...sfr...: " + mainlib.nlers + "But the owners do not want you to leave, you are locked in your quarters.", "30", true);
            nl();
            at("        ...sfr...: " + mainlib.nlers + "You must break the lock.", "30", true);//LOCK ON INSIDE?!?!?
            nl();
            enter_break();
        }
        mainlib.nlers = "...nbba......sfw...";
        cls();
        at("Objective: ...sb......su......nfc...Find a way to break the lock....nbba......sfge...", "30", true);
        nl();
        mainlib.nlers = "...nbba......sfga...";
        mainlib.currentmap = "Room1";
        mainlib.update_variables();
//        showmap();
        MapHandler mapHandler = new MapHandler();
        mainlib.startanim();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        mapHandler.game_prompt();
        mainlib.stopanim();
//        fightMapRouter.currentmap = "TestFightMap";
        mainlib.currentmap = "Hallway1_2";
        mainlib.update_variables();
        showmap();
        mapHandler.game_prompt();
        cls();
        stop();
        if (test == false) {
            at("...sfr...Narrator: " + mainlib.nlers + "So you have now escaped the workhouse sucessfully, but that is only the beginning of the story,", "30", true);
            nl();
            at("        ...sfr...: " + mainlib.nlers + "of course the legal system is against you, for you are poor", "30", true);
            nl();
            at("        ...sfr...: " + mainlib.nlers + "you have just committed murder, and even in self defence you will almost certainly get the death penalty for this", "30", true);
            nl();
            enter_break();
            at("...nfw...You: " + mainlib.nlers + " I must escape, but who will take me in?", "30", true);
            nl();
            at("...", "30", true);
            nl();
            lw("[1A[2K", "0");
            at("   ...nfw...:" + mainlib.nlers + " No! That's the wrong attitude, I relied on someone else last time and look where that got me, I must find a way to survive on my own.", "30", true);
            nl();
            at("   ...nfw...:" + mainlib.nlers + " I still must escape, but where?", "30", true);
            nl();
            enter_break();
            at("   ...nfw...:" + mainlib.nlers + " The forest! When I first entered this workhouse I remember seeing a massive forest just a few hundred meters away.", "30", true);
            nl();
            at("   ...nfw...:" + mainlib.nlers + " I must haste, I dont want to get caught.", "30", true);
            nl();
            enter_break();
        }
        cls();
        playsongFx("running_footsteps_long.wav");
        mainLib.nlers = "...sfga......nbba...";
        at("...sfr...Narrator:" + mainlib.nlers + " You enter the dark and damp forest, it is now midnight and sounds can be heard around you randomly, like footsteps, but with an inhuman quality to them.", "30", true);
        nl();
        at("        ...sfr...: " + mainlib.nlers + "It is so dark you can barely make out anything, everything looks like static.", "30", true);
        nl();
        enter_break();
        playsong("spooky.wav");
        mainlib.currentmap = "Start_forest_1";
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        mapHandler.game_prompt();
        cls();
        stop();
        nogard2videoplayer.playvideo("to_open-12161.png", 12161, 60, true, "to_open-12161.wav");
        playsongFx("falling_cave.wav");
        at("...nfw...You: " + mainlib.nlers + "DAMNIT!", "30", true);
        nl();
        at("...sfr...Narrator: " + mainlib.nlers + "You fall into a cave about 5 metres deep, too smooth to climb out of but you can clearly see a light in the distance, which you could try to exit.", "30", true);
        nl();
        playsongFx("Skeleton.wav");
        at("        ...sfr...: " + mainlib.nlers + "A skeleton approaches", "30", true);
        at("...", "500", true);
        nl();
        at("        ...sfr...: " + mainlib.nlers + "You must kill it.", "30", true);
        nl();
        enter_break();
        cls();
        fightMapRouter.currentmap = "CaveFightMap";
        fightMapRouter.enemy_ranged = gunLib.gun;
        fightMapRouter.enemy_melee = gunLib.knife;
        fightMapRouter.init();
        FightHandler fightHandler = new FightHandler();
        fightHandler.FightStarter();
        cls();
        playsongFx("running_footsteps_long.wav");
        at("...sfr...Narrator: " + mainlib.nlers + "You run to the exit", "30", true);
        at("...", "1", true);
        nl();
        at("        ...sfr...: " + mainlib.nlers + "You sleep the night under a beautiful sprawling willow tree.", "30", true);
        nl();
        at("        ...sfr...: " + mainlib.nlers + "You walk for a few more days and end up at the North Rinlund Village.", "30", true);
        nl();
        at("        ...sfr...: " + mainlib.nlers + "You decide to visit the village center.", "30", true);
        nl();
        at("        ...sfr...: " + mainlib.nlers + "You should look around and try to earn some money, you may be able to sleep the night in the inn if you can afford it!", "30", true);
        nl();
        at("Objective: ...sb......su......nfc...Find some ways to find money around the town and buy a place at the inn for tonight....nbba......sfge...", "30", true);
        nl();
        enter_break();
        cls();
        nl();
        nl();
        nl();
        nl();
        nl();
        nl();
        mainlib.currentmap = "North_Rinlund_Town_Center";
        playsong("Town.wav");
        mapHandler.game_prompt();
//        at("        ...sfr...: " + mainlib.nlers + "Who would risk their life for a poor fugitive?", "30", true);
//        nl();
//        at("        ...sfr...: " + mainlib.nlers + "Only a fellow fugitive with a reason would do that.", "30", true);
//        nl();
//        at("...", "500", true);
//        enter_break();
//        playsongFx("idea.wav");
//        at("        ...sfr...: " + mainlib.nlers + "Surely a pirate crew would take you in, so long as you could prove your worth, then you at least wouldnt starve to death, you do have nothing to you name after all.", "30", true);
//        nl();
//        playsong("Call_to_Adventure.wav");
//        at("        ...sfr...: " + mainlib.nlers + " You decided to join ...nfr...Capt'n Corkscrew's" + mainlib.nlers + " crew.", "30", true);
//        timeout("1000");
//        at("...", "1000", true);
//        nl();
//        at("        ...sfr...: " + mainlib.nlers + " Begrudgingly, they accepted you onboard as a powder boy, and thats where the story begins.", "30", true);
//        nl();
//        at("...nfr...Capt'n Corkscrew:", "30", true);
//        at(mainlib.nlers + " Oi! What do you think you are doing? Get down there and shoot the enemy on my mark!", "75", true);
//        nl();
//        at("...nfbu...Crewmate Cory: ", "30", true);
//        at(mainlib.nlers + "READY WHEN YOU ARE CAPT'N!", "150", true);
//        nl();
//        mainlib.nlers = "...nbba......sfw...";
//        at("Objective: get ...sb......su......nfc...gunpowder...sr... and ...sb......su......nfc...cannonballs...sr... and load them@into a cannon below deck", "30", true);
//        nl();
//        mainlib.nlers = "...nbba......sfw...";
//        mainlib.currentmap = "Ship_Up";
//        mainlib.update_variables();
//        mainlib.nlers = "...nbba......sfw...";
//        cls();
//        mainlib.startanim();
//        mainlib.update_variables();
//        mainlib.animupdate();
//        timeout("200");
//        if (mainlib.animation) {
//            System.out.print("[" + (mainlib.map_height + 4) + "B");
//        }
//        mapHandler.game_prompt();
//        while (mainlib.cannonball_loaded.equals("0") || mainlib.gunpowder_loaded.equals("0")) {
//            mainlib.update_variables();
//            //            String[] all = mainlib.concat(mainlib.movement_commands, new String[] {"use", "map"});
//            mainlib.choice = mainlib.choices(true, "30", true, mainlib.concat(mainlib.movement_commands, new String[] {"use", "map"}));
//            if (mainlib.choice.equals("map")) {
//                showmap();
//            }
//            if (mainlib.choice.equals("use")) {
//                if (mainlib.currentmap.equals("Ship_Up")) {
//                    mainlib.choice = mainlib.choices(true, "30", true, mainlib.usables);
//                    if (mainlib.choice.equals("cannonball")) {
//                        if (mainlib.cannonball_left.equals("1")) {
//                            mainlib.cannonball = "1";
//                            mainlib.cannonball_left = "0";
//                            at("You pick up the cannonball", "30", true);
//                            nl();
//                        } else {
//                            at("There are no more cannonballs...", "30", true);
//                            nl();
//                        }
//                    }
//                    if (mainlib.choice.equals("gunpowder")) {
//                        if (mainlib.gunpowder_left.equals("1")) {
//                            mainlib.gunpowder = "1";
//                            mainlib.gunpowder_left = "0";
//                            at("You pick up the gunpowder", "30", true);
//                            nl();
//                        } else {
//                            at("There is no more gunpowder...", "30", true);
//                            nl();
//                        }
//                    }
//                }
//                if (mainlib.currentmap.equals("Ship_Down")) {
//                    mainlib.choice = mainlib.choices(true, "30", true, mainlib.usables);
//                    if (mainlib.choice.equals("cannonball")) {
//                        if (mainlib.cannonball.equals("1")) {
//                            if (mainlib.gunpowder_loaded.equals("1")) {
//                                mainlib.cannonball_loaded = "1";
//                                mainlib.cannonball = "0";
//                                at("You load the cannonball", "30", true);
//                                nl();
//                            } else {
//                                at("You need to load the gunpowder first!", "30", true);
//                                nl();
//                            }
//                        } else {
//                            at("You have no cannonballs!", "30", true);
//                            nl();
//                        }
//                    }
//                    if (mainlib.choice.equals("gunpowder")) {
//                        if (mainlib.gunpowder.equals("1")) {
//                            mainlib.gunpowder = "0";
//                            mainlib.gunpowder_loaded = "1";
//                            at("You load the gunpowder...", "30", true);
//                            nl();
//                        } else {
//                            at("You have no gunpowder...", "30", true);
//                            nl();
//                        }
//                    }
//                }
//            }
//            if (mainlib.choice.equals("down")) {
//                mainlib.currentmap = "Ship_Down";
//                mainlib.update_variables();
//                playsongFx("footsteps.wav");
//            }
//            if (mainlib.choice.equals("up")) {
//                mainlib.currentmap = "Ship_Up";
//                mainlib.update_variables();
//                playsongFx("footsteps.wav");
//            }            
//        }
//        lw("add map system, grab cannonball and aiming and graphics here", "0");
        at("Old test code:", "30", true);
        nl();
        at("...nfr...Capt'n Corkscrew:" + mainlib.nlers, "50", true);
        stop();
        at(" 3, 2, 1,", "500", true);
        lw(" ...sb......sfr...FFIRREE!!...sr...", "0");
        nl();
        mainlib.choice = mainlib.choices(true, "30", true, new String[]{"use"});
        playsongFx("cannonss.wav");
        timeout("4500");
        at("...nfbu...Crewmate Cory:...sr... " + mainlib.nlers + "TAKE COVER! RETURN FIRE INCOMING!", "50", true);
        nl();
        mainlib.choice = mainlib.choices(true, "30", true, new String[]{"cover"});
        timeout("2000");
        playsongFx("cannonss.wav");
        playsongFx("thud.wav");
        timeout("500");
        playsongFx("thud.wav");
        timeout("1500");
        playsongFx("thud.wav");
        timeout("2000");
        playsongFx("war_horn.wav");
        timeout("1000");
        at("...sfge...Crewmate Cribbage: ...sfw...ALL HANDS ON DECK THEY ARE BOARDING THE BOAT!", "30", true);
        timeout("5000");
        playsongFx("pirate_ship_boarded.wav");














//        timeout("4000");
//        //        startmin("cave.exe");
//        timeout("2000");
//        timeout("4000");
//        stop();
//        timeout("16000");
        


//        timeout("4000");
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
        mainlib.nl();
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
