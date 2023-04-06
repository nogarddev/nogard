public class Nogard2videoplayer {
    static MainLib mainLib = new MainLib();
    static TerminalPlayer terminalPlayer = new TerminalPlayer();
    public static void playvideo(String filename, Integer frames, Integer fps, Boolean play_audio, String name) {
        mainLib.at("Loading cutscene", "30", true);
        mainLib.at("...", "-1000", true);
//        System.out.println("line7");
        mainLib.nl();
        terminalPlayer.playvideo(filename, frames, fps, play_audio, name);
    }
}