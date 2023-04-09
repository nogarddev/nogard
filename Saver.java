import java.util.*;
import java.io.*;
public class Saver {
    public static Integer id;
    static MapRouter mapRouter = new MapRouter();
    public static String[] maps_list = new String[]{"Ship_Down","Ship_Up","Hallway1","Room1","North_Rinlund_Town_Center","Start_forest_1","Workhouse_upstairs_north","Workhouse_upstairs_south","Start_forest_2","Start_forest_3","Start_forest_4","Hallway1_2","Downstairs_workhouse","NRTC_11","NRTC_12","NRTC_13","NRTC_14","NRTC_21","NRTC_22","NRTC_23","NRTC_24","NRTC_31","NRTC_32","NRTC_33","NRTC_34","NRTC_41","NRTC_42","NRTC_43","NRTC_44"};
    public static String[][][] get_all_grabables() {
        Integer i = 0;
        String[][][] out = new String[maps_list.length][][];
        while (i < maps_list.length) { 
            out[i] = mapRouter.grabables(maps_list[i]);
            i++;
        }
        return out;
    }
    public static String[][][] get_all_usables() {
        Integer i = 0;
        String[][][] out = new String[maps_list.length][][];
        while (i < maps_list.length) { 
            out[i] = mapRouter.usables(maps_list[i]);
            i++;
        }
        return out;
    }
    public static String[] a0darrto1darr(String input) {
//        System.out.println("input = " + input + "-saver.java:26");
        Integer i = 0;
        Integer len = 1;
        char[] chararr = input.toCharArray();
        while (i < chararr.length) {
            if (Character.toString(chararr[i]).equals("{") || Character.toString(chararr[i]).equals("}")) {
                Integer skip = 0;
            } else if (Character.toString(chararr[i]).equals(",")) {
                len++;
            }
            i++;
        }
        String[] out = new String[len];
        i = 0;
        Integer x = 0;
        while (i < chararr.length) {
            if (Character.toString(chararr[i]).equals("{") || Character.toString(chararr[i]).equals("}")) {
                Integer skip = 0;
            } else if ((Character.toString(chararr[i]).equals(",") || Character.toString(chararr[i]).equals("\"")) == false) {
                if (out[x] == null) {
                    out[x] = Character.toString(chararr[i]);
                } else {
                    out[x] = out[x] + Character.toString(chararr[i]);
                }
            } else if (Character.toString(chararr[i]).equals(",")) {
                x++;
            }
            i++;
        }
//        System.out.println("converted back your array in 0d is: " + a1dto0darr(out));
        i = 0;
//        while (i < out.length) {
//            if (out[i].equals("null")) {
//                out[i] = null;
//            }
//            i++;
//        }
        return out;
    }
    public static String[][] a0darrto2darr(String input) {
        Integer i = 0;
        Integer len = 0;
//        System.out.println("input = " + input + "-saver.java:60");
        char[] chararr = input.toCharArray();
        while (i < chararr.length) {
            if (Character.toString(chararr[i]).equals("{")) {
                len++;
            }
            i++;
        }
        String[][] out = new String[len][1];
        Integer x = 0;
        i = 1;
        while (i < (chararr.length - 1)) {// -2 so it clips the last } but also stops it from goint to x = out.len as the 2nd to last "}" ----------this cut off the last "}" (i believe unless it was a ")") o i changed it back to -1 and it solved the problem, i think!
            if (Character.toString(chararr[i]).equals("}")) {
                x++;
                i++;
                if (Character.toString(chararr[i]).equals(",")) {
                    i++;
                }
            }
//            System.out.println("out.length = " + out.length + " x = " + x);
            if (out[x][0] == null) {
                out[x][0] = Character.toString(chararr[i]);
            } else {
                out[x][0] = out[x][0] + Character.toString(chararr[i]);
            }
            i++;
        }
        i = 0;
        while (i < out.length) {
            out[i] = a0darrto1darr(out[i++][0]);
        }
//        System.out.println("converted back your array in 0d is: " + a2dto0darr(out));
        return out;
    }
    public static String a1dto0darr(String[] arr) {
        Integer i = 0;
        String out = "{";
        while (i < arr.length - 1) {
            out = out + "\"" + arr[i++] + "\",";
        }
        out = out + "\"" + arr[i] + "\"}";
        return out;
    }
    public static String a2dto0darr(String[][] arr) {
        Integer i = 0;
        String[] a1darr = new String[arr.length];
        while (i < arr.length) {
            a1darr[i] = a1dto0darr(arr[i++]);
        }
        i = 0;
        String out = "{";
        while (i < a1darr.length - 1) {
            out = out + a1darr[i++] + ",";
        }
        out = out + a1darr[i] + "}";
        return out;
    }
    public static String[] readfile(String url) {
        try {
            Scanner sc = new Scanner(new File(url));
            String[] out = new String[]{sc.nextLine()};
            while (sc.hasNextLine()) {
                out = concat1darr(out, new String[]{sc.nextLine()});
            }
            sc.close();
            return out;
        } catch (Exception ex) {
            System.out.println("Failed to read file!");
        }
        return null;
    }
    public static void loader() {
        String[] id_names = id_names();
        System.out.println("id: name");
        Integer i = 0;
        String[] choices = new String[id_names.length];
        while (i < id_names.length) {
            System.out.println(" " + i + ": " + id_names[i]);
            choices[i] = "" + i++;
        }
        mainLib.at("Enter wanted id: ", "30", true);
        String wanted_id = mainLib.choices(false, "30", true, choices);
        load(Integer.parseInt(wanted_id));
    }
    public static void load(Integer id) {
        String[] data = readfile("./saves/" + id + ".save");
        //do variables here (can be elsewhere)
        String[][] inventory = a0darrto2darr(data[13]);
        Integer x = 0;
        Integer y =0;
        while (x < inventory.length) {
            y = 0;
            while (y < inventory[x].length) {
                if ((inventory[x][y] == null) == false) {
                    if (inventory[x][y].equals("null")) {
                        inventory[x][y] = null;
                    }
                }
                y++;
            }
            x++;
        }
        mainLib.inventory = inventory;
        String[] grabables_data = a0d3darrto1d2darr(data[14]);
        String[] usables_data = a0d3darrto1d2darr(data[15]);
        set_grabables(grabables_data);
        set_usables(usables_data);
        
    }
    static MainLib mainLib = new MainLib();
    public static String[] id_names() {
        String[] out = new String[10];
        Integer i = 0;
        while (i < out.length) {
            out[i] = readfile("./saves/" + i + ".save")[0];
            i++;
        }
        return out;
    }
    public static String[][][] getallusables() {
        Integer i = 0;
        String[][][] out = new String[maps_list.length][][];
        while (i < maps_list.length) {
            out[i] = mapRouter.usables(maps_list[i]);
            i++;
        }
        return out;
    }
    public static String[][][] getallgrabables() {
        Integer i = 0;
        String[][][] out = new String[maps_list.length][][];
        while (i < maps_list.length) {
            out[i] = mapRouter.grabables(maps_list[i]);
            i++;
        }
        return out;
    }
    public static void save() {
        Scanner sc = new Scanner(System.in);
        String[] id_names = id_names();
        System.out.println("id: name");
        Integer i = 0;
        String[] choices = new String[id_names.length];
        while (i < id_names.length) {
            System.out.println(" " + i + ": " + id_names[i]);
            choices[i] = "" + i++;
        }
        mainLib.at("Enter wanted id: ", "30", true);
        String wanted_id = mainLib.choices(false, "30", true, choices);
        mainLib.at("Enter save name: ", "30", true);
        System.out.println("");
        String savename = sc.nextLine();
        writetosavefile(Integer.parseInt(wanted_id), savename, new String[]{"empty for now"}, mainLib.inventory, get_all_grabables(), get_all_usables(), maps_list);
    }
    public static void writetosavefile(Integer id, String savename, String[] variables, String[][] inventory, String[][][] grabables, String[][][] usables, String[] ids) {
        String url = "./saves/" + id + ".save";
        if (createfile(url) == null) {
            System.out.println("An error ocurred when attempting to run the save script");
            return;
        }
        String[] newfile_contents = new String[]{savename,"","","","","","","","","","","",a1dto0darr(variables),a2dto0darr(inventory),a3dto0darrwithids(grabables, ids),a3dto0darrwithids(usables, ids)};
//        String[] newfile_contents = new String[]{savename,"","","","","","","","","","","",a1dto0darr(variables),"a",a3dto0darrwithids(grabables, ids),a3dto0darrwithids(usables, ids)};
        try {
//            FileWriter fileWriter = new FileWriter(url);
//            fileWriter.write(newfile_contents[0]);
            Integer i = 0;
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(new File(url));
            while (i < newfile_contents.length) {
                printWriter.println(newfile_contents[i]);
//                bufferedWriter.write(newfile_contents[i] + System.getProperty("line.separator"));
//                System.out.println("writing: " + newfile_contents[i]);
                i++;
            }
//            printWriter.println("oofus");
            printWriter.close();
        } catch (Exception ex) {
            System.out.println("error with writing file Saver.java:135");
            ex.printStackTrace();
        }
    }
    public static Boolean createfile(String url) {
        try {
            File filetomake = new File(url);
            if (filetomake.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Failed to create file Saver.java:128");
            ex.printStackTrace();
            return null;
        }
    }
    public static String a3dto0darr(String[][][] arr) {
        String[] a1darr = new String[arr.length];
        Integer i = 0;
        while (i < arr.length) {
            a1darr[i] = a2dto0darr(arr[i]);
            i++;
        }
        return a1dto0darr(a1darr);
    }
    public static String a3dto0darrwithids(String[][][] arr, String[] ids) {
//        System.out.println("arr.length = " + arr.length);
//        System.out.println("ids.length = " + ids.length);
        String[] a1darr = new String[arr.length];
        Integer i = 0;
        while (i < arr.length) {
            a1darr[i] = a2dto0darr(arr[i]);
            i++;
        }
        i = 0;
        while (i < a1darr.length) {
            a1darr[i] = "(" + ids[i] + ")" + a1darr[i];
            i++;
        }
        i = 0;
        String out = "{";
        while (i < a1darr.length - 1) {
            out = out + a1darr[i++] + ",";
        }
        out = out + a1darr[i] + "}";
        return out;
    }
//    public static
    public static String[] a0d3darrto1d2darr(String arr) {
        Integer dimension = 3;
        char[] chararr = arr.toCharArray();
        Integer i = 1;
        String temp = null;
        Boolean firstin3d = false;
        Boolean inid = false;
        String[] out = null;
//        System.out.println("arr = " + arr + " -saver.java:280");
        while (i < chararr.length) {// no - 1 so that it saves the last 2d array
            if (Character.toString(chararr[i]).equals("{")) {
                dimension--;
            }
            if (Character.toString(chararr[i]).equals("(")) {
                inid = true;
            }
            if (dimension < 3 || inid) {
                if (dimension < 3) {
                    inid = false;
                }
                firstin3d = true;
                if (temp == null) {
                    temp = "" + chararr[i];
                } else {
                    temp = temp + chararr[i];
                }
            }
//            if (Character.toString(chararr[i]).equals(")")) {
//                inid = false;
//            }
            if (dimension == 3 && firstin3d && inid == false) {
                if (out == null) {
                    out = new String[]{temp};
                } else {
                    out = concat1darr(out, new String[]{temp});
                }
                temp = null;
                firstin3d = false;
            }
            if (Character.toString(chararr[i]).equals("}")) {
                dimension++;
            }
            i++;
        }
        return out;
    }
    public static void set_grabables(String[] arr) {
        Integer i = 0;
        String[] ids = pull_idsfrom1d2darr(arr);
        while (i < arr.length) {
//            System.out.println("arr[" + i + "] = " + arr[i]);
//            System.out.println("arr.length = " + arr.length);
            mapRouter.updategrabables(ids[i], a0darrto2darr(strip_id(arr[i])));
            i++;
        }
    }
    public static void set_usables(String[] arr) {
        Integer i = 0;
        String[] ids = pull_idsfrom1d2darr(arr);
        while (i < arr.length) {
            mapRouter.setusables(ids[i], a0darrto2darr(strip_id(arr[i])));
            i++;
        }
    }
    public static String[] pull_idsfrom1d2darr(String[] arr) {
        Integer i = 0;
        String[] out = new String[arr.length];
        while (i < arr.length) {
            out[i] = pull_id(arr[i]);
            i++;
        }
        return out;
    }
    public static String[][] pull2darrwithidfrom1d2darr(String[] arr, String wanted_id) {
        Integer i = 0;
        while (pull_id(arr[i]).equals(wanted_id) == false) {
            i++;
        }
        return a0darrto2darr(arr[i]);
    }
    public static String strip_id(String input) {
        char[] chararr = input.toCharArray();
        Integer i = 0;
//        System.out.println("input = " + input + " -saver.java:351");
        while (Character.toString(chararr[i]).equals(")") == false) {
            i++;
        }
        i++;
        String out = null;
        while (i < chararr.length) {
            if (out == null) {
                out = "" + chararr[i];
            } else {
                out = out + chararr[i];
            }
            i++;
        }
        return out;
    }
    public static String pull_id(String input) {
        char[] chararr = input.toCharArray();
        Integer i = 0;
        while (Character.toString(chararr[i]).equals("(") == false && i < chararr.length - 1) {
            i++;
        }
        i++;
        String out = null;
        if (i < chararr.length) {
            while (Character.toString(chararr[i]).equals(")") == false && i < chararr.length - 1) {
                if (out == null) {
                    out = "" + chararr[i];
                } else {
                    out = out + chararr[i];
                }
                i++;
            }
        }
        return out;
    }
    public static String[] concat1darr(String[] arr1, String[] arr2) {
        Integer combined_len = arr1.length + arr2.length;
        String[] out = new String[combined_len];
        Integer i = 0;
        while (i < arr1.length) {
            out[i] = arr1[i];
            i++;
        }
        while (i < combined_len) {
            out[i] = arr2[i - arr1.length];
            i++;
        }
        return out;
    }
}