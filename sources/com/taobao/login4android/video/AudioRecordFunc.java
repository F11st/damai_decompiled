package com.taobao.login4android.video;

import android.media.AudioRecord;
import android.os.CountDownTimer;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.coordinator.CoordinatorWrapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AudioRecordFunc {
    public static final int FRAME_SIZE = 640;
    public static final int MAX_DB = 70;
    public static final String TAG = "login.AudioRecordFunc";
    private static AudioRecordFunc mInstance;
    private String audioName;
    private AudioRecord audioRecord;
    private long mStartRecordTime;
    private long mStopRecordTime;
    private int bufferSizeInBytes = 0;
    private boolean isRecord = false;
    private double maxVolume = 0.0d;
    private Object mLock = new Object();
    private boolean closedForLimit = false;
    private int mMaxRecordSeconds = 15;
    private int mMinRecordSeconds = 1;
    private CountDownTimer countDownTimer = new CountDownTimerC6736a(this, 15000, 500);
    private String folderPath = DataProviderFactory.getApplicationContext().getCacheDir().getPath() + "/records/";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class AudioRecordThread implements Runnable {
        AudioRecordThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AudioRecordFunc.this.writeOpusDateTOFile();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class CheckAudioRecordNoise implements Runnable {
        CheckAudioRecordNoise() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AudioRecordFunc.this.calculateMaxVolume();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.video.AudioRecordFunc$a */
    /* loaded from: classes11.dex */
    class CountDownTimerC6736a extends CountDownTimer {
        CountDownTimerC6736a(AudioRecordFunc audioRecordFunc, long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AudioRecordFunc.getInstance().closeForLimit();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    private AudioRecordFunc() {
        File file = new File(this.folderPath);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateMaxVolume() {
        int i = this.bufferSizeInBytes;
        if (i <= 0) {
            i = 640;
        }
        short[] sArr = new short[i];
        while (this.isRecord) {
            int read = this.audioRecord.read(sArr, 0, i);
            if (-3 != read) {
                long j = 0;
                for (int i2 = 0; i2 < read; i2++) {
                    j += Math.abs((int) sArr[i2]);
                }
                if (read != 0) {
                    double log10 = Math.log10(j / read) * 20.0d;
                    if (log10 > this.maxVolume) {
                        this.maxVolume = log10;
                    }
                    synchronized (this.mLock) {
                        try {
                            this.mLock.wait(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private void close() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            this.isRecord = false;
            try {
                audioRecord.stop();
                this.audioRecord.release();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            this.audioRecord = null;
        }
        this.countDownTimer.cancel();
    }

    private void creatAudioRecord() {
        this.bufferSizeInBytes = AudioRecord.getMinBufferSize(AudioFileFunc.AUDIO_SAMPLE_RATE, 16, 2);
        this.audioRecord = new AudioRecord(1, AudioFileFunc.AUDIO_SAMPLE_RATE, 16, 2, this.bufferSizeInBytes);
    }

    public static synchronized AudioRecordFunc getInstance() {
        AudioRecordFunc audioRecordFunc;
        synchronized (AudioRecordFunc.class) {
            if (mInstance == null) {
                mInstance = new AudioRecordFunc();
            }
            audioRecordFunc = mInstance;
        }
        return audioRecordFunc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeOpusDateTOFile() {
        FileOutputStream fileOutputStream;
        this.mStartRecordTime = System.currentTimeMillis();
        short[] sArr = new short[320];
        try {
            this.audioName = this.folderPath + TimeUtil.getCurrentTime();
            File file = new File(this.audioName);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
            fileOutputStream = null;
        }
        VoiceCodecs voiceCodecs = new VoiceCodecs();
        voiceCodecs.open(true);
        while (this.isRecord) {
            if (-3 != this.audioRecord.read(sArr, 0, 320) && fileOutputStream != null) {
                try {
                    byte[] bArr = new byte[640];
                    int bufferFrame = voiceCodecs.bufferFrame(sArr, bArr);
                    byte[] bArr2 = new byte[bufferFrame];
                    System.arraycopy(bArr, 0, bArr2, 0, bufferFrame);
                    fileOutputStream.write(bArr2);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } finally {
            voiceCodecs.close();
        }
    }

    public void closeForLimit() {
        close();
        this.closedForLimit = true;
    }

    public String getAudioName() {
        return this.audioName;
    }

    public int getMaxRecordSeconds() {
        return this.mMaxRecordSeconds;
    }

    public double getMaxVolume() {
        return this.maxVolume;
    }

    public int getMinRecordSeconds() {
        return this.mMinRecordSeconds;
    }

    public long getRecordTime() {
        return (this.mStopRecordTime - this.mStartRecordTime) / 1000;
    }

    public boolean isClosedForLimit() {
        return this.closedForLimit;
    }

    public void setMaxRecordSeconds(int i) {
        this.mMaxRecordSeconds = i;
    }

    public void setmMinRecordSeconds(int i) {
        this.mMinRecordSeconds = i;
    }

    public int startRecordAndCheckNoise() {
        this.maxVolume = 0.0d;
        this.closedForLimit = false;
        if (this.isRecord) {
            return 1002;
        }
        try {
            if (this.audioRecord == null) {
                creatAudioRecord();
            }
            this.audioRecord.startRecording();
            this.isRecord = true;
            new CoordinatorWrapper().execute(new CheckAudioRecordNoise());
            return 1000;
        } catch (Throwable th) {
            th.printStackTrace();
            return RecordErrorCode.E_UNKOWN;
        }
    }

    public int startRecordAndFile() {
        this.closedForLimit = false;
        this.countDownTimer.start();
        if (this.isRecord) {
            return 1002;
        }
        try {
            if (this.audioRecord == null) {
                creatAudioRecord();
            }
            this.audioRecord.startRecording();
            this.isRecord = true;
            new CoordinatorWrapper().execute(new AudioRecordThread());
            return 1000;
        } catch (Throwable th) {
            th.printStackTrace();
            return RecordErrorCode.E_UNKOWN;
        }
    }

    public void stopRecordAndFile() {
        this.mStopRecordTime = System.currentTimeMillis();
        close();
        this.closedForLimit = false;
    }
}
