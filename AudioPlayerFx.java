import javax.sound.sampled.*;
import java.io.*;
import java.lang.*;
public class AudioPlayerFx extends Thread {
    Integer i = 0;
    public static String start = "0";
    public String b = "test";
    public static String name = "";
    public String skip = "";
    Clip clip;
    public String kill = "0";
    AudioInputStream audioInputStream;
    public String AudioPlayerFxa() {
        return this.name;
    }
    public void Setkill(String kill) {
        this.kill = kill;
    }
    public void Seturl(String name) {
        this.name =  name;
    }
    public void Setup123() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void setupstarter() {
        MainLib manFx = new MainLib();
        while (manFx.startFx == "0") {
            //blank
            skip = "1";
        }
        try {
        Setup();
        } catch (Exception x) {
            //blank
        }
    }
    public void run() {
        try
        {
            Setup();
        }
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    public void Setup() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        kill = "0";
        audioInputStream =
                AudioSystem.getAudioInputStream(new File("fx/" + name).getAbsoluteFile());


        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        MainLib manFx = new MainLib();
//        while (manFx.killyouFx == "0") {
//            skip = "1";
//        }
//        clip.stop(); //removed for multi-audio but unstoppable
//        clip.close();
        manFx.startFx = "0";
        setupstarter();
    }
    public void Setupfx() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }
    public void Play() {
    }
    public void Stop() {
    ResetAudioStream();
    }
    public void Killme() {
        kill = "1";
    }
    public void ResetAudioStream() {

    }
    public void ResetAudioStream1() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

    }
}
