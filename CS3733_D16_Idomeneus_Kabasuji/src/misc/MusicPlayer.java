package misc;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {
	public MusicPlayer(String fn) {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "music"
				+ File.separator + fn;
		System.out.println(path);
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Music not playing");
		}
	}
}
