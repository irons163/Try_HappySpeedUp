package com.example.try_happyspeedup.utils;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.try_happyspeedup.R;

public class AudioUtil {
    private static MediaPlayer music;
    private static SoundPool soundPool;
     
    private static boolean musicSt = true; //音樂開關
    private static boolean soundSt = true; //音效開關
    private static Context context;
     
    private static final int[] musicId = {R.raw.apple};
    private static Map<Integer,Integer> soundMap; //音效資源id與載入過後的音源id的映射關係表
     
    /**
     * 初始化方法
     * @param c
     */
    public static void init(Context c)
    {
        context = c;
 
        initMusic();
         
        initSound();
    }
     
    //初始化音效播放機
    private static void initSound()
    {
        soundPool = new SoundPool(10,AudioManager.STREAM_MUSIC,100);
         
        soundMap = new HashMap<Integer,Integer>();
        soundMap.put(R.raw.jump_from_platform, soundPool.load(context, R.raw.jump_from_platform, 1));
        soundMap.put(R.raw.lose, soundPool.load(context, R.raw.lose, 1));
        soundMap.put(R.raw.hit_platform, soundPool.load(context, R.raw.hit_platform, 1));
        soundMap.put(R.raw.hit, soundPool.load(context, R.raw.hit, 1));
    }
     
    //初始化音樂播放機
    private static void initMusic()
    {
//        int r = new Random().nextInt(musicId.length);
//        music = MediaPlayer.create(context,musicId[r]);
    	music = MediaPlayer.create(context,musicId[0]);
        music.setLooping(true);
    }
    
    /**
     * 播放音效
     * @param resId 音效資源id
     */
    public static void playMusic(int resId)
    {
        if(musicSt == false)
            return;
         
    	music = MediaPlayer.create(context, resId);
        music.setLooping(true);
        startMusic();
    }
     
    /**
     * 播放音效
     * @param resId 音效資源id
     */
    public static void playSound(int resId)
    {
        if(soundSt == false)
            return;
         
        Integer soundId = soundMap.get(resId);
        if(soundId != null)
            soundPool.play(soundId, 1, 1, 1, 0, 1);
    }
 
    /**
     * 暫停音樂
     */
    public static void pauseMusic()
    {
        if(music.isPlaying())
            music.pause();
    }
     
    /**
     * 播放音樂
     */
    public static void startMusic()
    {
        if(musicSt)
            music.start();
    }
     
    /**
     * 切換一首音樂並播放
     */
    public static void changeAndPlayMusic()
    {
        if(music != null)
            music.release();
        initMusic();
        startMusic();
    }
     
    /**
     * 獲得音樂開關狀態
     * @return
     */
    public static boolean isMusicSt() {
        return musicSt;
    }
     
    /**
     * 設置音樂開關
     * @param musicSt
     */
    public static void setMusicSt(boolean musicSt) {
    	AudioUtil.musicSt = musicSt;
        if(musicSt)
            music.start();
        else
            music.stop();
    }
 
    /**
     * 獲得音效開關狀態
     * @return
     */
    public static boolean isSoundSt() {
        return soundSt;
    }
 
    /**
     * 設置音效開關
     * @param soundSt
     */
    public static void setSoundSt(boolean soundSt) {
    	AudioUtil.soundSt = soundSt;
    }
    
//    static AudioManager mgr;
//    //播放音效
//    public static void PlaySoundPool(int resid){
//     if(soundSt==false){
//      return;
//     }
//     Integer soundId = soundMap.get(resid);
//     if(soundId!=null && soundSt){
//    	 mgr = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
//      soundPool.play(soundId, 
//        mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 
//        mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 1, 0, 1f);
//      System.out.println("1--->"+resid);
//     }
//    }
     
    /**
     * 發出爆炸的聲音
     */
    public static void playDead()
    {
        playSound(R.raw.lose);
    }
    
    /**
     * 發出丁的聲音
     */
    public static void playJump()
    {
        playSound(R.raw.jump_from_platform);
    }
    
    public static void playRoll()
    {
        playSound(R.raw.hit_platform);
    }
    
    public static void playEat()
    {
        playSound(R.raw.hit);
    }
    
    public static void playBackgroundMusic(){
    	if(musicSt == false)
            return;
         
    	music = MediaPlayer.create(context, R.raw.apple);
        music.setLooping(true);
        startMusic();
    }
    
    public static void stopBackgroundMusic(){
        pauseMusic();
    }

    public static boolean isBackgroundMusicPlaying(){
    	return music.isPlaying();
    }
}

