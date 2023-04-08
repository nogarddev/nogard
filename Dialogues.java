import java.util.*;
public class Dialogues {
    static String mode1;
    static MainLib mainLib = new MainLib();
    public static String[][] north_Rinlund_Town_Center = new String[][]{{"terry","0"}};
    public static String[][] north_Rinlund_Town_Center__terry = new String[][]{{"start","...nfw...Terry:...sbw......nfba... Hello! What is your name?","Hello, I am Gronkle!","1","quest_1_setup_1","bye","1","empty"},{"quest_1_setup_1","...nfw...terry:...sbw......nfba... What brings you here?","I am a looking for money, so that I can buy myself a night at the inn.","1","quest_1_setup_2","bye","1","empty"},{"quest_1_setup_2","...nfw...terry:...sbw......nfba... In that case, I think I have just the job for you, do you want to hear it?","yes","1","hear_quest_1","no","1","why_not_hear_quest_1","bye","1","empty"},{"hear_quest_1","...nfw...terry:...sbw......nfba... I need some materials for my blacksmithing, could you please find them for me?","yes","1","accept_quest_1","bye","1","empty"},{"why_not_hear_quest_1","...nfw...terry: ...sbw......nfba...Oh please wont you hear my quest?","okay then!","1","hear_quest_1","no thanks, goodbye","1","empty"},{"accept_quest_1","...nfw...terry:...sbw......nfba... Thankyou! Here is 50 gold so you can buy a map of the area!","Thankyou, Terry","1","empty"}};
    public static String[][] dialogueRouter(String type, String location, String person, String input1, String input2, String input3) {
        if (location.equals("North_Rinlund_Town_Center")) {
            if (type.equals("set_person_enabled")) {
                Integer i = 0;
                while (north_Rinlund_Town_Center[i][0].equals(person) == false) {
                    i++;
                }
                north_Rinlund_Town_Center[i][1] = input1;
                return null;
            }
            if (type.equals("grab_person_tree")) {
                if (person.equalsIgnoreCase("terry")) {
                    return north_Rinlund_Town_Center__terry;
                }
            }
            if (type.equals("grab_people")) {
                Integer i = 0;
                Integer len = 0;
                while (i < north_Rinlund_Town_Center.length) {
                    if (north_Rinlund_Town_Center[i][1].equals("1")) {
                        len++;
                    }
                    i++;
                }
                i = 0;
                String[] out = new String[len];
                while (i < len) {
                    out[i] = north_Rinlund_Town_Center[i][0];
                    i++;
                }
                return new String[][]{out};
            }
            if (type.equals("set_id_enabled")) {
                if (person.equalsIgnoreCase("terry")) {
                    Integer i = 0;
                    while (north_Rinlund_Town_Center__terry[i][0].equals(input1) == false) {
                        i++;
                    }
//                    Integer x = 0;
//                    while (north_Rinlund_Town_Center__terry[i][2 + (x * 3)].equals(input2) == false) {
//                        x++;
//                    }
                    north_Rinlund_Town_Center__terry[i][3 * Integer.parseInt(input2)] = input3;
                    return null;
                }
            }
            if (type.equals("grab_responses")) {
                if (person.equals("terry")) {
                    Integer i = 0;
                    while (north_Rinlund_Town_Center__terry[i][0].equals(input1) == false) {
                        i++;
                    }
                    Integer len = 0;
                    Integer x = 0;
                    while (x < ((north_Rinlund_Town_Center__terry[i].length - 2) / 3)) {
                        if (north_Rinlund_Town_Center__terry[i][3 + (x*3)].equals("1")) {
                            len++;
                        }
                        x++;
                    }
                    String[] out = new String[len];
                    x = 0;
                    Integer arr_pos = 0;
                    while (x < ((north_Rinlund_Town_Center__terry[i].length - 2) / 3)) {
                        if (north_Rinlund_Town_Center__terry[i][3 + (x*3)].equals("1")) {
                            out[arr_pos++] = north_Rinlund_Town_Center__terry[i][2 + (x*3)];
//                            out[arr_pos++] = north_Rinlund_Town_Center__terry[i][3 + (x*3)];
//                            out[arr_pos++] = north_Rinlund_Town_Center__terry[i][4 + (x*3)];
                        }
                        x++;
                    }
                    return new String[][]{out};
                }
            }
            if (type.equals("grab_responses_full")) {
                if (person.equals("terry")) {
                    Integer i = 0;
//                    System.out.println("input1 = " + input1);
                    while (north_Rinlund_Town_Center__terry[i][0].equals(input1) == false) {
                        i++;
                    }
                    Integer len = 0;
                    Integer x = 0;
                    while (x < ((north_Rinlund_Town_Center__terry[i].length - 2) / 3)) {
                        if (north_Rinlund_Town_Center__terry[i][3 + (x*3)].equals("1")) {
                            len++;
                        }
                        x++;
                    }
                    String[] out = new String[len * 3];
                    x = 0;
                    Integer arr_pos = 0;
                    while (x < ((north_Rinlund_Town_Center__terry[i].length - 2) / 3)) {
                        if (north_Rinlund_Town_Center__terry[i][3 + (x*3)].equals("1")) {
                            out[arr_pos++] = north_Rinlund_Town_Center__terry[i][2 + (x*3)];
                            out[arr_pos++] = north_Rinlund_Town_Center__terry[i][3 + (x*3)];
                            out[arr_pos++] = north_Rinlund_Town_Center__terry[i][4 + (x*3)];
                        }
                        x++;
                    }
                    return new String[][]{out};
                }
            }
            if (type.equals("grab_response")) {
                if (person.equals("terry")) {
                    Integer i = 0;
                    while (north_Rinlund_Town_Center__terry[i][0].equals(input1) == false) {
                        i++;
                    }
                    return new String[][]{{north_Rinlund_Town_Center__terry[i][1]}};
                }
            }
            if (type.equals("has_speakers")) {
                return new String[][]{{"true"}};
            }
        }
        if (type.equals("has_speakers")) {
            return new String[][]{{"false"}};
        } else {
            System.out.println("location not found");
            return null;
        }
    }
    public static String[] grab_people(String location) {
        return dialogueRouter("grab_people", location, "empty", "empty", "empty", "empty")[0];
    }
    public static String[][] grab_person_tree(String location, String person) {
        return dialogueRouter("grab_person_tree", location, person, "empty", "empty", "empty");
    }
    public static void set_id_enabled(String location, String person, String input1, String input2, String input3) {
        dialogueRouter("set_id_enabled", location, person, input1, input2, input3);
    }
    public static void set_person_enabled(String location, String person, String input1) {
        dialogueRouter("set_person_enabled", location, person, input1, "empty", "empty");
    }
    public static String[] grab_responses(String location, String person, String input1) {
        return dialogueRouter("grab_responses", location, person, input1, "empty", "empty")[0];
    }
    public static String[] grab_responses_full(String location, String person, String input1) {
        return dialogueRouter("grab_responses_full", location, person, input1, "empty", "empty")[0];
    }
    public static Boolean has_speakers(String location) {
        String has = dialogueRouter("has_speakers", location, "empty", "empty", "empty", "empty")[0][0];
        if (has.equals("true")) {
            if (grab_people(location).length > 0) {
                return true;
            } else {
                return false;
            }
        } else if (has.equals("false")) {
            return false;
        } else {
            System.out.println("not a valid response from has_speakers");
            return null;
        }
    }
    public static String response_num_to_id(String location, String person, String input1, String number) {
        String[] responses = grab_responses_full(location, person, input1);
//        Integer i = 0;
//        String[] ids = responses;
//        while (i < responses.length) {
//            ids[i] = responses[i];
//            i++;
//        }
//        ids = responses;
//        System.out.println("" + (Integer.parseInt(number) - 1));
//        System.out.println(responses.length);
        return responses[(Integer.parseInt(number) * 3) - 1];
    }
    public static String grab_response(String location, String person, String input1) {
//        System.out.println("location = " + location + " person = " + person + " id = " + input1);
        return dialogueRouter("grab_response", location, person, input1, "empty", "empty")[0][0];
    }
}