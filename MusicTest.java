import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class MusicTest {
    private static Clip bgm;//鑳屾櫙涔�
    private static Clip hit;//闊虫晥
    private static AudioInputStream ais;

    MusicTest() {
    }

    public static void play() {
        try {
            bgm = AudioSystem.getClip();
            InputStream is = MusicTest.class.getClassLoader().getResourceAsStream("src/bgm/Memories.wav");
            //getclassLoader寰楀埌褰撳墠绫荤殑鍔犺浇鍣�.getResourceAsStream鍔犺浇璧勬簮锛屽彧鑳藉姞杞絯av鐨勯煶涔愭牸寮�
            if (is != null) {
                ais = AudioSystem.getAudioInputStream(is);//鑾峰彇杈撳叆娴�
            }
            bgm.open(ais);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        bgm.start();//寮�濮嬫挱鏀�
        bgm.loop(Clip.LOOP_CONTINUOUSLY);//寰幆鎾斁
    }

    public static void stop() {
        if (ais != null)
            bgm.close();
    }
}
