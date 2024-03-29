import javax.imageio.*;
import java.awt.image.*;
import java.awt.Color;
import java.lang.*;
import java.io.*;
import javax.sound.sampled.*;
import java.util.*;
import java.io.*;
import java.util.*;
class TerminalPlayer {
    static Boolean done = true;//inverse of name
    static Integer currentframe;
    static String filename;
    static Integer image_width;
    static Integer image_height;
    static Integer x;
    public static Integer start1 = 0;
    static Integer y;
    static Integer i;
    static Color current_pixel;
    static String[] frame;
    public static BufferedImage[] image;
    static long waittime;
    public static void playvideo(String foldername, Integer frames, Integer fps, Boolean play_audio, String name) {//foldername=filename of long image
//        System.out.println("line25a");
        waittime = Math.round((float) 1 / ((float) 1 *  fps) * 1000000000);
        currentframe = 0;
//        System.out.println("line28");
        String[][] frametimes =  new String[frames][2];
        i = 0;
//        System.out.println("line30");
        while (i.equals((frametimes.length - 1)) == false) {
            frametimes[i++][1] = "0";
        }
//        System.out.println("line33");
        i = 0;
//        System.out.println("line37");
        while (i.equals((frametimes.length - 1)) == false) {
//            frametimes[i++][0] = String.valueOf(current + (waittime * i));
            frametimes[i++][0] = String.valueOf(waittime * i);
//            System.out.println("line41 i = " + i + " (frametimes.length - 1) = " + (frametimes.length - 1));
        }
//        System.out.println("line42");
        i = 0;
        //        while (i.equals(frametimes.length) == false) {
            ////            System.out.println(frametimes[i++][0]);
            //        }
        image = new BufferedImage[(int) Math.ceil((float) frames / (float) 2000)];
//        System.out.println(image.length);
        Integer i = 0;
        while (i < image.length) {
            try {
                image[i] = ImageIO.read(new File("./" + foldername + "-" + frames + "-" + i + ".png"));
//                System.out.println("./" + foldername + "-" + frames + "-" + i);
            } catch (Exception ex) {
                System.out.println("Image import failed");
                System.out.println("./" + foldername + "-" + frames + "-" + i);
            }
            i++;
        }
//        System.out.println("line51");
        if (play_audio) {
            playsong(name);
            while (start1.equals(0)) {
                skip = 1;
            }
        }
        long current = System.nanoTime();
//        System.out.println("line55");
        Integer filenum = -1;
        while ((currentframe >= frames - 1) == false && done) {
//            if ((currentframe % 2000) == 0) {
//                filenum++;
//            }
            currentframe++;
            filenum = (int) Math.floor((currentframe - 1)/2000);
//            filename = String.valueOf(currentframe);
//            if (currentframe < 10000) {
//                if (currentframe < 1000) {
//                    if (currentframe < 100) {
//                        if (currentframe < 10) {
//                            filename = "0" + filename;
//                        }
//                        filename = "0" + filename;
//                    }
//                    filename = "0" + filename;
//                }
//                filename = "0" + filename;
//            }
//            File frame = new File("./" + foldername + "/" + filename + ".png");
////            System.out.println("./" + foldername + "/" + filename + ".png");
            if (frames < 2000) {
                image_width = (int) (image[0].getWidth() / frames);
            } else {
                image_width = (int) (image[0].getWidth() / 2000);
            }
////            System.out.println("frames = " + frames + "image.getwidth = " + image.getWidth() + "imagewidth = " + image_width);
            image_height = image[0].getHeight();
            String[] frame = new String[image_height];
            y = 0;
            x = (currentframe - 1) * image_width;
            i = 0;
            while (y.equals(image_height) == false && done) {
                x = (currentframe - 1) * image_width;
//                System.out.println("x - (2000 * filenum * image_width) = " + (x - (2000 * filenum * image_width)));
//                System.out.println("filenum = " + filenum);
                current_pixel = new Color(image[filenum].getRGB(x - (2000 * filenum * image_width), y));
                frame[y] = "[48;2;" + current_pixel.getRed() + ";" + current_pixel.getGreen() + ";" + current_pixel.getBlue() + "m ";
                x++;
                while (x.equals(((currentframe) * image_width) - 1) == false && done) {
//                    System.out.println("x = " + x + " y = " + y);
                    current_pixel = new Color(image[filenum].getRGB(x - (2000 * filenum * image_width), y));
                    frame[y] = frame[y] + "[48;2;" + current_pixel.getRed() + ";" + current_pixel.getGreen() + ";" + current_pixel.getBlue() + "m ";
                    x++;
                }
                y++;
            }


//            while (System.nanoTime() < currenttime) {
            System.out.print("[H");
//            System.out.print("[2J");
            while (i.equals(frame.length) == false && done) {
                System.out.println(frame[i++]);
            }
////            System.out.println(currentframe);
            currentframe++;
//            Sleep("57");//60fps
//            Sleep("114");//30fps
            currenttime = System.nanoTime() + waittime;
            if (true) {
////                System.out.println(System.nanoTime());
//////                System.out.println((waittime * (long) 1000000000));
////                System.out.println("waittime = " + (waittime));
////                System.out.println("currenttime = " + (currenttime));
//                Sleep("1");
//                skip = 1;
                i = 0;
                long a = Long.parseLong("" + (current + Long.parseLong(frametimes[i + 1][0])));
                Long b = System.nanoTime();
                while (done && (a < b) || frametimes[i][1].equals("1") && (i >= frames - 3) == false) {
                    frametimes[i][1] = "1";
////                    System.out.println("110" + done);
                    if (i.equals(frames - 3) == false) {
                        i++;
////                        System.out.println("frames = " + (frames + 5));
////                        System.out.println("i = " + i);
////                        System.out.println(i == (frames - 5));
                    } else {
                        done = false;
                    }
//                    System.out.println("frames = " + frames + "i = " + i);
////                    System.out.println("i = " + i);
//                    System.out.println("line 135");
                    a = Long.parseLong("" + (current + Long.parseLong(frametimes[i + 1][0])));
                    b = System.nanoTime();
                }
//                System.out.println("line 138");
                if (i.equals(frames - 3) || i > frames - 4) {
                    done = false;
                }
                if (currentframe.equals(frames - 1)) {
                    done = false;
                }
                if (currentframe >= frames - 1) {
                    done = false;
                }
                currentframe = i;
                //                i = 0;
                //                while (i.equals(frametimes.length) == false) {
////                    System.out.println(frametimes[i][1]);
//                }
                a = Long.parseLong("" + (current + Long.parseLong(frametimes[i + 1][0])));
                b = System.nanoTime();
//                i = 0;
//                System.out.println("line 155");
                while (a > System.nanoTime() && done) {
                    b = System.nanoTime();
//                    skip = 1;
////                    System.out.println("iterating");
//                    while (skip == 1) {
////                    System.out.println(i++);
//                    while ((float) 1 == Float.parseFloat("1")) {
////                        System.out.println("waiting");
//                    }
//                    }
                }
                frametimes[i][1] = "1";
                i = 0;
//                while (false) {
//                    ///blank
//                }
//                System.out.println("line 171");
            }
//            System.out.println("line 172");
//            if (inited) {
//                nowfps++;
//                if (System.nanoTime() > lasttime + 1000000000) {
//                    pastnowfps = nowfps;
//                    nowfps = 0;
//                    lasttime = System.nanoTime();
//                }
////                System.out.println("[0mfps: \"" + pastnowfps + "\"");
////                System.out.println("Wait time: " + (float) waittime / 1000000000 + "s");
//            } else {
//                lasttime = System.nanoTime();
//                inited = true;
//            }
        }
//        System.out.println("line 187");
        stop();
        mainLib.nl();
        mainLib.cls();
//        System.out.println("line 189");
    }
    static MainLib mainLib = new MainLib();
    static String[][] framestimes;
    static Long lasttime;
    static Integer nowfps = 0;
    static Integer pastnowfps = 0;
    static Boolean inited = false;
    static Integer skip;
    static long currenttime;
    public static void Sleep(String ms) {
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
    static AudioPlayer_video AudioPlayer_video = new AudioPlayer_video();
    public static String start = "0";
    public static String started = "0";
    public static String killyou = "0";
    public static void playsong(String name) {
        stop();
        Sleep("100");
        AudioPlayer_video player = new AudioPlayer_video();
        player.Seturl(name);
        Sleep("100");
        try
        {
            if (started == "0") {
                AudioPlayer_video.start();
                started = "1";
                start = "1";
                Sleep("200");
                start = "0";
            } else {
                start = "1";
                Sleep("200");
                start = "0";
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
//    static AudioPlayer_video AudioPlayer_video = new AudioPlayer_video();
    public static void stop() {
//        while (killyou == "0") {
//            killyou = "1";
//        }
//        Sleep("200");
//        killyou = "0";
        AudioPlayer_video.stop = false;
        while (AudioPlayer_video.stop) {
            AudioPlayer_video.stop = false;
            while (1 == 1) {
////                System.out.println("a" + AudioPlayer_video.stop);
                AudioPlayer_video.stop = false;
            }
        }
        Sleep("2000");
        AudioPlayer_video.stop = true;
    }
}
