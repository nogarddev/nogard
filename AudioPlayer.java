import javax.sound.sampled.*;
import java.io.*;
import java.lang.*;
public class AudioPlayer extends Thread {
    Integer i = 0;
    public static String start = "0";
    public String b = "test";
    public static String name = "";
    public String skip = "";
    Clip clip;
    public String kill = "0";
    AudioInputStream audioInputStream;
    public String AudioPlayera() {
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
        MainLib man = new MainLib();
        while (man.start == "0") {
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
    final static Main main = new Main();
    public void Setup() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (main.mute == false) {
            kill = "0";
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File("fx/" + name).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            MainLib man = new MainLib();
            while (man.killyou == "0") {
                skip = "1";
            }
            clip.stop();
            clip.close();
            man.start = "0";
            setupstarter();
        }
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
