package com.example.hackathon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class TTSWatson {
	
	public void playSound(String text)
	{		
		
		
		
		TextToSpeech service = new TextToSpeech();
        service.setUsernameAndPassword("442da2fe-0fbb-44af-9c54-efed37f92bec","3NDWxGJXudeB");
			try {
				   InputStream stream = service.synthesize(text, Voice.EN_ALLISON,
				    AudioFormat.WAV).execute();
				  InputStream in = WaveUtils.reWriteWaveHeader(stream);
		
				 OutputStream out = new FileOutputStream("hello_world.wav");
				  byte[] buffer = new byte[1024];
				  int length;
				  while ((length = in.read(buffer)) > 0) {
				    out.write(buffer, 0, length);
				  }
				  
				  out.close();
				  in.close();
				  stream.close();
				
				  File audioFile=new File("hello_world.wav");
				  AudioInputStream audioStream=AudioSystem.getAudioInputStream(audioFile);
				  javax.sound.sampled.AudioFormat format=audioStream.getFormat();
				  DataLine.Info info=new DataLine.Info(Clip.class,format);
				  Clip audioClip=(Clip)AudioSystem.getLine(info);
				  audioClip.open(audioStream);
				  audioClip.start();
				  boolean playCompleted=false;
				  while(!playCompleted)
				  {try
				  {Thread.sleep(6000);
				  playCompleted=true;
				  }
				  catch(InterruptedException ex)
				  {}
				  }
				 audioClip.close();
				  
			} catch (Exception e) {
				
				e.printStackTrace();
				// Log something and return an error message
				
			} 
	
}

}
