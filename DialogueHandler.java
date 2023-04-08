public class DialogueHandler {
    static Dialogues dialogues = new Dialogues();
    static MainLib mainLib = new MainLib();
    static Integer i = 0;
    static String[] nums;
    static String[] responses;
    public static String id = "empty";
    public static String lastid = "empty";
    public static String person = "empty";
    public static String last_location = "empty";
    public static void talk(String location) {
        last_location = location;
        person = mainLib.choices(false, "30", true, dialogues.grab_people(location));
        id = "start";
        while (id.equals("empty") == false) {
            lastid = id;
            mainLib.at(dialogues.grab_response(location, person, id), "30", true);
            mainLib.nl();
            responses = dialogues.grab_responses(location, person, id);
            nums = new String[responses.length];
            i = 0;
//            System.out.println("responses.length = " + responses.length);
            while (i < nums.length) {
                nums[i] = "" + (i + 1);
                i++;
            }
            i = 0;
            while (i < responses.length) {
//                System.out.println(responses.length);
                mainLib.lw((i + 1) + ": ", "0");
                mainLib.at(responses[i], "30", true);
                mainLib.nl();
                i++;
            }
            if (id.equals("empty") == false) {
                //blank
            }
            id = dialogues.response_num_to_id(location, person, id, mainLib.choices(false, "30", true, nums));
        }
    }
}