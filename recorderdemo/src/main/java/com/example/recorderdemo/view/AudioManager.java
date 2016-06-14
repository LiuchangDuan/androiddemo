package com.example.recorderdemo.view;

import android.media.MediaRecorder;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/6/14.
 */
public class AudioManager {

    private MediaRecorder mMediaRdcorder;
    private String mDir;
    private String mCurrentFilePath;

    private static AudioManager mInstance;

    private boolean isPrepared;

    private AudioManager() {

    }

    /**
     * 回调准备完毕
     */
    public interface AudioStateListener {
        void wellPrepared();
    }

    public AudioStateListener mListener;

    public void setOnAudioStateListener(AudioStateListener listener) {
        mListener = listener;
    }

    public static AudioManager getInstance() {
        if (mInstance == null) {
            synchronized (AudioManager.class) {
                if (mInstance == null) {
                    mInstance = new AudioManager();
                }
            }
        }
        return mInstance;
    }

    // 准备
    public void prepareAudio() {

        /*
        try / catch 快捷键 Ctrl + Shift + T
         */

        try {
            isPrepared = false;
            File dir = new File(mDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = generateFileName();
            File file = new File(dir, fileName);

            mCurrentFilePath = file.getAbsolutePath();

            mMediaRdcorder = new MediaRecorder();
            // 设置输出文件
            mMediaRdcorder.setOutputFile(file.getAbsolutePath());
            // 设置MediaRecorder的音频源为麦克风
            mMediaRdcorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            // 设置音频的格式
            mMediaRdcorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB); // API 10+
//        mMediaRdcorder.setOutputFormat(MediaRecorder.OutputFormat.RAW_AMR);
            // 设置音频的编码为amr
            mMediaRdcorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

            mMediaRdcorder.prepare();

            mMediaRdcorder.start();

            // 准备结束
            isPrepared = true;

            if (mListener != null) {
                mListener.wellPrepared();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 随机生成文件的名称
     * @return
     */
    private String generateFileName() {
        return UUID.randomUUID().toString() + ".amr";
    }

    // 音量等级
    public int getVoiceLevel(int maxLevel) {
        if (isPrepared) {
            try {
                // mMediaRdcorder.getMaxAmplitude() 1-32767
                return maxLevel * mMediaRdcorder.getMaxAmplitude() / 32768 + 1; // 1-7
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    public void release() {
        mMediaRdcorder.stop();
        mMediaRdcorder.release();
    }

    public void cancel() {
        release();
        if (mCurrentFilePath != null) {
            File file = new File(mCurrentFilePath);
            file.delete();
            mCurrentFilePath = null;
        }
    }

}
