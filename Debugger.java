import java.io.*;
import java.util.*;
import java.lang.*;
public class Debugger {
    final static Anim anim = new Anim();
    final static AudioPlayer audioPlayer = new AudioPlayer();
    final static AudioPlayerFx audioPlayerFx = new AudioPlayerFx();
    final static Downstairs_workhouse downstairs_workhouse = new Downstairs_workhouse();
    final static FightHandler fightHandler = new FightHandler();
    final static FightMapRouter fightMapRouter = new FightMapRouter();
    final static Hallway1_2 hallway1_2 = new Hallway1_2();
    final static Hallway1 hallway1 = new Hallway1();
    final static Main main = new Main();
    final static MainLib mainLib = new MainLib();
    final static MapHandler mapHandler = new MapHandler();
    final static Room1 room1 = new Room1();
    final static Ship_Down ship_Down = new Ship_Down();
    final static Ship_Up ship_Up = new Ship_Up();
    final static TestFightMap testFightMap = new TestFightMap();
    final static ThreadedScanner threadedScanner = new ThreadedScanner();
    final static Maputils maputils = new Maputils();
    public static String choice;
    public static String choice1;
    static String name;
    static String amount;
    static String ranged_base_accuracy;
    static String ranged_accuracy_threshold;
    static String ranged_accuracy_dropoff;
    static String ranged_accuracy_minimum;
    static String ranged_base_damage;
    static String ranged_damage_threshold;
    static String ranged_damage_dropoff;
    static String ranged_damage_minimum;
    static String melee_base_damage;
    static String element;
    static String weight;
    static String durability;
    static String[] arr_mod;
    static String[] items;
    static Integer i;
    static Scanner sc;
    public static void run() {
        choice = mainLib.choices(false, "0", true, new String[]{"Set","View","Run","Cancel"});
        if (choice.equals("run")) {
            choice = mainLib.choices(false, "0", true, new String[]{"Maputils","Break","Cancel"});
            if (choice.equals("break")) {
                mainLib.forcebreak = true;
            } else if (choice.equals("maputils")) {
                choice = mainLib.choices(false, "0", true, new String[]{"Trymap","Mapviewer","Cancel"});
                if (choice.equals("trymap")) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter location: ");
                    maputils.trymap(sc.nextLine());
                } else if (choice.equals("mapviewer")) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("loop?");
                    String choice2 = mainLib.choices(false, "0", true, new String[]{"Yes","No","Cancel"});
                    if (choice2.equalsIgnoreCase("cancel") == false) {
                        System.out.println("Enter url: ");
                        String url = sc.nextLine();
                        if (choice2.equals("yes")) {
                            System.out.println("Enter ms delay: ");
                            String ms = sc.nextLine();
                            while ("1".equals("1")) {
                                maputils.mapviewer(url);
                                mainLib.timeout(ms);
                            }
                        } else {
                            maputils.mapviewer(url);
                        }
                    }
                }
            }
        }
        if (choice.equals("set")) {
            choice = mainLib.choices(false, "0", true, new String[]{"Variable","Inventory","Cancel"});
            if (choice.equals("inventory")) {
                choice = mainLib.choices(false, "0", true, new String[]{"MAke","MOdify","Cancel"});
                if (choice.equals("modify")) {
                    i = 0;
                    arr_mod = new String[]{};
                    while ((mainLib.inventory[i + 1][0] ==null) == false) {
                        arr_mod = mainLib.concat(arr_mod, new String[]{mainLib.inventory[i][0]});
                        i++;
                    }
                    System.out.println("modify what?");
                    choice = mainLib.choices(false, "0", true, mainLib.concat(arr_mod, new String[]{"Cancel"}));
                    if (choice.equals("cancel") == false) {
                        i = 0;
                        while (mainLib.inventory[i][0].equals(choice) == false) {
                            i++;
                        }
                        view(mainLib.inventory[i]);
                        System.out.println("inventory[x][y]");
                        System.out.println("");
                        System.out.println("0: name of item, last non-blank 1 should be \"empty\" for script accelleration and to prevent over-referencing");
                        System.out.println("1: amount of item");
                        System.out.println("{should always be applicable}");
                        System.out.println("IF A WEAPON (RANGED):");
                        System.out.println("2: base accuracy {1-100}");
                        System.out.println("3: accuracy threshold before dropoff{meters}");
                        System.out.println("4: accuracy dropoff/meter{1-100}");
                        System.out.println("5: accuracy minimum{1-100}");
                        System.out.println("6: base damage{1-100}");
                        System.out.println("7: damage threshold before dropoff{meters}");
                        System.out.println("8: damage dropoff/meter{1-100}");
                        System.out.println("9: damage minimum{1-100}");
                        System.out.println("{if not applicable should be \"empty\" not \"\"}");
                        System.out.println("IF A WEAPON (MELEE):");
                        System.out.println("10: base damage");
                        System.out.println("{if not applicable should be \"empty\" not \"\"}");
                        System.out.println("IF A WEAPON:");
                        System.out.println("11: element (bio/tech/cancer/soul/omni)");
                        System.out.println("12: weight");
                        System.out.println("{if not applicable should be \"empty\" not \"\"}");
                        System.out.println("IF HAS DURABILITY:");
                        System.out.println("13: durability (\"empty\" for infinite)");
                        System.out.println("{if not applicable should be \"empty\" not \"\"}");
    //                    i = 0;
    //                    System.out.println("0: ");
    //                    sc = new Scanner(System.in);
    //                    name = sc.nextLine();
                        name = mainLib.inventory[i][0];
    ////                    sc.close();
    //                    System.out.println("1: ");
    //                    sc = new Scanner(System.in);
    //                    amount = sc.nextLine();
                        amount = mainLib.inventory[i][1];
    ////                    sc.close();
    //                    System.out.println("2: ");
    //                    sc = new Scanner(System.in);
    //                    ranged_base_accuracy = sc.nextLine();
                        ranged_base_accuracy = mainLib.inventory[i][2];
    ////                    sc.close();
    //                    System.out.println("3: ");
    //                    sc = new Scanner(System.in);
    //                    ranged_accuracy_threshold = sc.nextLine();
                        ranged_accuracy_threshold = mainLib.inventory[i][3];
    ////                    sc.close();
    //                    System.out.println("4: ");
    //                    sc = new Scanner(System.in);
    //                    ranged_accuracy_dropoff = sc.nextLine();
                        ranged_accuracy_dropoff = mainLib.inventory[i][4];
    ////                    sc.close();
    //                    System.out.println("5: ");
    //                    sc = new Scanner(System.in);
    //                    ranged_accuracy_minimum = sc.nextLine();
                        ranged_accuracy_minimum = mainLib.inventory[i][5];
    ////                    sc.close();
    //                    System.out.println("6: ");
    //                    sc = new Scanner(System.in);
    //                    ranged_base_damage = sc.nextLine();
                        ranged_base_damage = mainLib.inventory[i][6];
    ////                    sc.close();
    //                    System.out.println("7: ");
    //                    sc = new Scanner(System.in);
    //                    ranged_damage_threshold = sc.nextLine();
                        ranged_damage_threshold = mainLib.inventory[i][7];
    ////                    sc.close();
    //                    System.out.println("8: ");
    //                    sc = new Scanner(System.in);
    //                    ranged_damage_dropoff = sc.nextLine();
                        ranged_damage_dropoff = mainLib.inventory[i][8];
    ////                    sc.close();
    //                    System.out.println("9: ");
    //                    sc = new Scanner(System.in);
    //                    ranged_damage_minimum = sc.nextLine();
                        ranged_damage_minimum = mainLib.inventory[i][9];
    ////                    sc.close();
    //                    System.out.println("10: ");
    //                    sc = new Scanner(System.in);
    //                    melee_base_damage = sc.nextLine();
                        melee_base_damage = mainLib.inventory[i][10];
    ////                    sc.close();
    //                    System.out.println("11: ");
    //                    sc = new Scanner(System.in);
    //                    element = sc.nextLine();
                        element = mainLib.inventory[i][11];
    ////                    sc.close();
    //                    System.out.println("12: ");
    //                    sc = new Scanner(System.in);
    //                    weight = sc.nextLine();
                        weight = mainLib.inventory[i][12];
    ////                    sc.close();
    //                    System.out.println("13: ");
    //                    sc = new Scanner(System.in);
    //                    durability = sc.nextLine();
                        durability = mainLib.inventory[i][13];
    ////                    sc.close();
                        System.out.println("Do you want to edit any of these?");
                        choice1 = mainLib.choices(false, "0", true, new String[]{"Yes", "No"});
                        while (choice1.equals("yes") && choice.equals("done") == false) {
                            if (choice1.equals("yes")) {
                                System.out.println("Change which number?");
                                choice = mainLib.choices(false, "0", true, new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","Done"});
                                if (choice.equals("0")) {
                                    System.out.println("0: ");
                                    sc = new Scanner(System.in);
                                    name = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("1")) {
                                    System.out.println("1: ");
                                    sc = new Scanner(System.in);
                                    amount = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("2")) {
                                    System.out.println("2: ");
                                    sc = new Scanner(System.in);
                                    ranged_base_accuracy = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("3")) {
                                    System.out.println("3: ");
                                    sc = new Scanner(System.in);
                                    ranged_accuracy_threshold = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("4")) {
                                    System.out.println("4: ");
                                    sc = new Scanner(System.in);
                                    ranged_accuracy_dropoff = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("5")) {
                                    System.out.println("5: ");
                                    sc = new Scanner(System.in);
                                    ranged_accuracy_minimum = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("6")) {
                                    System.out.println("6: ");
                                    sc = new Scanner(System.in);
                                    ranged_base_damage = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("7")) {
                                    System.out.println("7: ");
                                    sc = new Scanner(System.in);
                                    ranged_damage_threshold = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("8")) {
                                    System.out.println("8: ");
                                    sc = new Scanner(System.in);
                                    ranged_damage_dropoff = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("9")) {
                                    System.out.println("9: ");
                                    sc = new Scanner(System.in);
                                    ranged_damage_minimum = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("10")) {
                                    System.out.println("10: ");
                                    sc = new Scanner(System.in);
                                    melee_base_damage = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("11")) {
                                    System.out.println("11: ");
                                    sc = new Scanner(System.in);
                                    element = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("12")) {
                                    System.out.println("12: ");
                                    sc = new Scanner(System.in);
                                    weight = sc.nextLine();
    //                            sc.close();
                                }
                                if (choice.equals("13")) {
                                    System.out.println("13: ");
                                    Scanner sc = new Scanner(System.in);
                                    durability = sc.nextLine();
    //                            sc.close();
                                }
                                if ((name == null || amount == null || ranged_base_accuracy == null || ranged_accuracy_threshold == null || ranged_accuracy_dropoff == null || ranged_accuracy_minimum == null || ranged_base_damage == null || ranged_damage_threshold == null || ranged_damage_dropoff == null || ranged_damage_minimum == null || melee_base_damage == null || element == null || weight == null) == false) {
                                    mainLib.inventory[i] = new String[]{name,amount,ranged_base_accuracy,ranged_accuracy_threshold,ranged_accuracy_dropoff,ranged_accuracy_minimum,ranged_base_damage,ranged_damage_threshold,ranged_damage_dropoff,ranged_damage_minimum,melee_base_damage,element,weight,durability};
                                }
                            }
                        }
                    }
                }
                if (choice.equals("make")) {
                    System.out.println("inventory[x][y]");
                    System.out.println("");
                    System.out.println("0: name of item, last non-blank 1 should be \"empty\" for script accelleration and to prevent over-referencing");
                    System.out.println("1: amount of item");
                    System.out.println("{should always be applicable}");
                    System.out.println("IF A WEAPON (RANGED):");
                    System.out.println("2: base accuracy {1-100}");
                    System.out.println("3: accuracy threshold before dropoff{meters}");
                    System.out.println("4: accuracy dropoff/meter{1-100}");
                    System.out.println("5: accuracy minimum{1-100}");
                    System.out.println("6: base damage{1-100}");
                    System.out.println("7: damage threshold before dropoff{meters}");
                    System.out.println("8: damage dropoff/meter{1-100}");
                    System.out.println("9: damage minimum{1-100}");
                    System.out.println("{if not applicable should be \"empty\" not \"\"}");
                    System.out.println("IF A WEAPON (MELEE):");
                    System.out.println("10: base damage");
                    System.out.println("{if not applicable should be \"empty\" not \"\"}");
                    System.out.println("IF A WEAPON:");
                    System.out.println("11: element (bio/tech/cancer/soul/omni)");
                    System.out.println("12: weight");
                    System.out.println("{if not applicable should be \"empty\" not \"\"}");
                    System.out.println("IF HAS DURABILITY:");
                    System.out.println("13: durability (\"empty\" for infinite)");
                    System.out.println("{if not applicable should be \"empty\" not \"\"}");
                    i = 0;
                    System.out.println("0: ");
                    sc = new Scanner(System.in);
                    name = sc.nextLine();
//                    sc.close();
                    if ((name == null) == false) {
                        System.out.println("1: ");
                        sc = new Scanner(System.in);
                        amount = sc.nextLine();
//                    sc.close();
                    }
                    if ((amount == null) == false) {
                        System.out.println("2: ");
                        sc = new Scanner(System.in);
                        ranged_base_accuracy = sc.nextLine();
//                    sc.close();
                    }
                    if ((ranged_base_accuracy == null) == false) {
                        System.out.println("3: ");
                        sc = new Scanner(System.in);
                        ranged_accuracy_threshold = sc.nextLine();
//                    sc.close();
                    }
                    if ((ranged_accuracy_threshold == null) == false) {
                        System.out.println("4: ");
                        sc = new Scanner(System.in);
                        ranged_accuracy_dropoff = sc.nextLine();
//                    sc.close();
                    }
                    if ((ranged_accuracy_dropoff == null) == false) {
                        System.out.println("5: ");
                        sc = new Scanner(System.in);
                        ranged_accuracy_minimum = sc.nextLine();
//                    sc.close();
                    }
                    if ((ranged_accuracy_minimum == null) == false) {
                        System.out.println("6: ");
                        sc = new Scanner(System.in);
                        ranged_base_damage = sc.nextLine();
//                    sc.close();
                    }
                    if ((ranged_base_damage == null) == false) {
                        System.out.println("7: ");
                        sc = new Scanner(System.in);
                        ranged_damage_threshold = sc.nextLine();
//                    sc.close();
                    }
                    if ((ranged_damage_threshold == null) == false) {
                        System.out.println("8: ");
                        sc = new Scanner(System.in);
                        ranged_damage_dropoff = sc.nextLine();
//                    sc.close();
                    }
                    if ((ranged_damage_dropoff == null) == false) {
                        System.out.println("9: ");
                        sc = new Scanner(System.in);
                        ranged_damage_minimum = sc.nextLine();
//                    sc.close();
                    }
                    if ((ranged_damage_minimum == null) == false) {
                        System.out.println("10: ");
                        sc = new Scanner(System.in);
                        melee_base_damage = sc.nextLine();
//                    sc.close();
                    }
                    if ((melee_base_damage == null) == false) {
                        System.out.println("11: ");
                        sc = new Scanner(System.in);
                        element = sc.nextLine();
//                    sc.close();
                    }
                    if ((element == null) == false) {
                        System.out.println("12: ");
                        sc = new Scanner(System.in);
                        weight = sc.nextLine();
//                    sc.close();
                    }
                    if ((weight == null) == false) {
                        System.out.println("13: ");
                        sc = new Scanner(System.in);
                        durability = sc.nextLine();
//                    sc.close();
                    }
                    choice1 = "yes";
                    while (choice1.equals("yes")) {
                        System.out.println("Do you want to edit any of these?");
                        choice1 = mainLib.choices(false, "0", true, new String[]{"Yes", "No"});
                        if (choice1.equals("yes")) {
                            System.out.println("Change which number?");
                            choice = mainLib.choices(false, "0", true, new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","Cancel"});
                            if (choice.equals("0")) {
                                System.out.println("0: ");
                                sc = new Scanner(System.in);
                                name = sc.nextLine();
//                            sc.close();
                            }
                            if (choice.equals("1")) {
                                System.out.println("1: ");
                                sc = new Scanner(System.in);
                                amount = sc.nextLine();
//                            sc.close();
                            }
                            if (choice.equals("2")) {
                                System.out.println("2: ");
                                sc = new Scanner(System.in);
                                ranged_base_accuracy = sc.nextLine();
//                            sc.close();
                            }
                            if (choice.equals("3")) {
                                System.out.println("3: ");
                                sc = new Scanner(System.in);
                                ranged_accuracy_threshold = sc.nextLine();
//                            sc.close();
                            }
                            if (choice.equals("4")) {
                                System.out.println("4: ");
                                sc = new Scanner(System.in);
                                ranged_accuracy_dropoff = sc.nextLine();
//                            sc.close();
                            }
                            if (choice.equals("5")) {
                                System.out.println("5: ");
                                sc = new Scanner(System.in);
                                ranged_accuracy_minimum = sc.nextLine();
//                            sc.close();
                            }
                            if (choice.equals("6")) {
                                System.out.println("6: ");
                                sc = new Scanner(System.in);
                                ranged_base_damage = sc.nextLine();
//                            sc.close();
                            }
                            if (choice.equals("7")) {
                                System.out.println("7: ");
                                sc = new Scanner(System.in);
                                ranged_damage_threshold = sc.nextLine();
//                            sc.close();
                            }
                            if (choice.equals("8")) {
                                System.out.println("8: ");
                                sc = new Scanner(System.in);
                                ranged_damage_dropoff = sc.nextLine();
                            //                            sc.close();
                            }
                            if (choice.equals("9")) {
                                System.out.println("9: ");
                                sc = new Scanner(System.in);
                                ranged_damage_minimum = sc.nextLine();
                                //                            sc.close();
                            }
                            if (choice.equals("10")) {
                                System.out.println("10: ");
                                sc = new Scanner(System.in);
                                melee_base_damage = sc.nextLine();
                                //                            sc.close();
                            }
                            if (choice.equals("11")) {
                                System.out.println("11: ");
                                sc = new Scanner(System.in);
                                element = sc.nextLine();
                                //                            sc.close();
                            }
                            if (choice.equals("12")) {
                                System.out.println("12: ");
                                sc = new Scanner(System.in);
                                weight = sc.nextLine();
                                //                            sc.close();
                            }
                            if (choice.equals("13")) {
                                System.out.println("13: ");
                                Scanner sc = new Scanner(System.in);
                                durability = sc.nextLine();
                                //                            sc.close();
                            }
                        }
                    }                        
                    if ((name == null || amount == null || ranged_base_accuracy == null || ranged_accuracy_threshold == null || ranged_accuracy_dropoff == null || ranged_accuracy_minimum == null || ranged_base_damage == null || ranged_damage_threshold == null || ranged_damage_dropoff == null || ranged_damage_minimum == null || melee_base_damage == null || element == null || weight == null) == false) {
                        i = 0;
                        while (mainLib.inventory[i][0].equals("empty") == false) {
                            i++;
                        }
                        mainLib.inventory[i] = new String[]{name,amount,ranged_base_accuracy,ranged_accuracy_threshold,ranged_accuracy_dropoff,ranged_accuracy_minimum,ranged_base_damage,ranged_damage_threshold,ranged_damage_dropoff,ranged_damage_minimum,melee_base_damage,element,weight,durability};
                        mainLib.inventory[i + 1][0] = "empty";
                        System.out.println(mainLib.inventory[i][0]);
                    }
                }
            } else if (choice.equals("variable")) {
                choice = mainLib.choices(false, "0", true, new String[]{"MainLib","MapUtils","Cancel"});
                if (choice.equals("mainlib")) {
                    choice = mainLib.choices(false, "0", true, new String[]{"CUrrentmap","CAncel"});
                    if (choice.equals("currentmap")) {
                        sc = new Scanner(System.in);
                        mainLib.currentmap = sc.nextLine();
                        System.out.println("update variables?");
                        choice = mainLib.choices(false, "0", true, new String[]{"Yes","No"});
                        if (choice.equals("yes")) {
                            mainLib.update_variables();
                        }
                    }
                } else if (choice.equals("maputils")) {
                    choice = mainLib.choices(false, "0", true, new String[]{"Money","Cancel"});
                    if (choice.equals("money")) {
                        sc = new Scanner(System.in);
                        System.out.println("Enter amount of money: ");
                        maputils.money = Integer.parseInt(sc.nextLine()) / (float) 1;
                    }
                }
            }
        }
        if (choice.equals("view")) {
            choice = mainLib.choices(false, "0", true, new String[]{"Inventory","Cancel"});
            if (choice.equals("inventory")) {
                choice = mainLib.choices(false, "0", true, new String[]{"Full","Item","Cancel"});
                if (choice.equals("full")) {
                    System.out.println("");
                    System.out.println("");
                    i = 0;
                    Integer y = 0;
                    Boolean breaka = false;
                    while ((mainLib.inventory[i + 1][0] == null) == false) {
                        System.out.println("");
                        System.out.println("--------\"" + mainLib.inventory[i][0] + "\"--------");
                        System.out.println("");
                        breaka = false;
                        while ((mainLib.inventory[i][y] == null) == false && y < mainLib.inventory[i].length && breaka == false) {
                            System.out.println("[" + i + "][" + y + "] = " + mainLib.inventory[i][y]);
                            if ((y + 1 == mainLib.inventory[i].length) == false) {
                                y++;
                            } else {
                                breaka = true;
                            }
                        }
                        System.out.println("");
                        System.out.println("");
                        i++;
                        y = 0;
                    }
                }
                if (choice.equals("item")) {
                    i = 0;
                    items = new String[]{};
                    while (mainLib.inventory[i][0].equals("empty") == false) {
                        items = mainLib.concat(items, new String[]{mainLib.inventory[i][0]});
                        i++;
                    }
                    choice = mainLib.choices(false, "0", true, mainLib.concat(items, new String[]{"Cancel"}));
                    if (choice.equals("cancel") == false) {
                        i = 0;
                        while (mainLib.inventory[i][0].equals(choice) == false) {
                            i++;
                        }
                        Integer y = 0;
                        System.out.println("");
                        System.out.println("--------\"" + mainLib.inventory[i][0] + "\"--------");
                        System.out.println("");
                        Boolean breaka = false;
                        while ((mainLib.inventory[i][y] == null) == false && y < mainLib.inventory[i].length && breaka == false) {
                            System.out.println("[" + i + "][" + y + "] = " + mainLib.inventory[i][y]);
                            if ((y + 1 == mainLib.inventory[i].length) == false) {
                                y++;
                            } else{
                                breaka = true;
                            }
                        }
                        System.out.println("");
                        System.out.println("");
                    }
                }
            }
        } 
    }
    public static void view(String[] weapon) {
        mainLib.nl();
        mainLib.nl();
        mainLib.lw("--------------------------------", "0");
        mainLib.nl();
        mainLib.lw("Statistics of " + weapon[0], "0");
        mainLib.nl();
        mainLib.nl();
        Integer i = 0;
        while ((weapon[i] == null) == false) {
            System.out.println(i + ": \"" + weapon[i] + "\"");
            i++;
        }
        mainLib.nl();
        mainLib.lw("--------------------------------", "0");
        mainLib.nl();
        mainLib.nl();
    }
}
