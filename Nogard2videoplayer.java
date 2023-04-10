public class Nogard2videoplayer {
    static MainLib mainLib = new MainLib();
    static TerminalPlayer terminalPlayer = new TerminalPlayer();
    public static void playvideo(String filename, Integer frames, Integer fps, Boolean play_audio, String name) {
        mainLib.at("Loading cutscene", "30", true);
        mainLib.at("...", "-1000", true);
        Main main = new Main();
        if (main.test) {
            mainLib.lw("(TEST MENU): SKIP?", "0");
            if (mainLib.choices(false, "0", true, new String[]{"Yes","No"}).equals("yes")) {
                return;
            }
        }
//        System.out.println("line7");
        mainLib.nl();
        terminalPlayer.playvideo(filename, frames, fps, play_audio, name);
    }
}