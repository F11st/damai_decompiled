package android.taobao.windvane.jsbridge.api;

import android.media.AudioRecord;
import android.os.Handler;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BlowSensor {
    public static final int BLOW_HANDLER_BLOWING = 4101;
    public static final int BLOW_HANDLER_FAIL = 4102;
    private AudioRecord ar;
    private int bs;
    private byte[] buffer;
    private Handler mHandler;
    private Timer mTimer;
    private int SAMPLE_RATE_IN_HZ = JosStatusCodes.RTN_CODE_COMMON_ERROR;
    private int number = 1;
    private long time = 1;
    private int BLOW_ACTIVI = 3000;

    public BlowSensor(Handler handler) {
        this.bs = 100;
        this.mHandler = handler;
        this.bs = AudioRecord.getMinBufferSize(JosStatusCodes.RTN_CODE_COMMON_ERROR, 16, 2);
        this.ar = new AudioRecord(1, this.SAMPLE_RATE_IN_HZ, 16, 2, this.bs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordBlow() {
        try {
            this.number++;
            Thread.sleep(8L);
            long currentTimeMillis = System.currentTimeMillis();
            int i = 0;
            int read = this.ar.read(this.buffer, 0, this.bs) + 1;
            int i2 = 0;
            while (true) {
                byte[] bArr = this.buffer;
                if (i >= bArr.length) {
                    break;
                }
                i2 += bArr[i] * bArr[i];
                i++;
            }
            int i3 = i2 / read;
            long currentTimeMillis2 = this.time + (System.currentTimeMillis() - currentTimeMillis);
            this.time = currentTimeMillis2;
            if ((currentTimeMillis2 >= 500 || this.number > 5) && i3 > this.BLOW_ACTIVI) {
                this.mHandler.sendEmptyMessage(4101);
                this.number = 1;
                this.time = 1L;
            }
        } catch (Exception unused) {
            this.mHandler.sendEmptyMessage(4102);
            stop();
        }
    }

    public void start() {
        try {
            this.ar.startRecording();
            this.buffer = new byte[this.bs];
            Timer timer = new Timer("WVBlowTimer");
            this.mTimer = timer;
            timer.scheduleAtFixedRate(new TimerTask() { // from class: android.taobao.windvane.jsbridge.api.BlowSensor.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    BlowSensor.this.recordBlow();
                }
            }, 0L, 100L);
        } catch (Exception unused) {
            stop();
        }
    }

    public void stop() {
        try {
            AudioRecord audioRecord = this.ar;
            if (audioRecord != null) {
                audioRecord.stop();
                this.ar.release();
                this.bs = 100;
            }
        } catch (Exception unused) {
        }
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
    }
}
