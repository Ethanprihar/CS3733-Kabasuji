package misc;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class MusicPlayer {
	Clip clip;

	public MusicPlayer(String fn) {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "music"
				+ File.separator + fn;
		System.out.println(path);
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Music not playing");
		}
	}

	public void setVolume(float db){
	FloatControl gainControl = 
		    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(db); // Reduce volume by 10 decibels.
	}
	/**
	 * Getter for clip.
	 * @return
	 */
	public Clip getClip(){
		return clip;
	}
}
