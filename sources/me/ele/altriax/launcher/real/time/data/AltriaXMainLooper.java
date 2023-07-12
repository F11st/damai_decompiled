package me.ele.altriax.launcher.real.time.data;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class AltriaXMainLooper {
    private static final String MESSAGE_END = "<<<<< Finished to";
    private static final String MESSAGE_START = ">>>>> Dispatching to";
    private static final String TAG = "AltriaXMainLooper";
    private String endName;
    private MainLooperMessageListener mainLooperMessageListener;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class IoDHHolder {
        private static final AltriaXMainLooper instance = new AltriaXMainLooper();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface MainLooperMessageListener {
        void onMainLooperMessage(@NonNull String str, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class MainLooperPrinter implements Printer {
        @NonNull
        private final MainLooperMessageListener mainLooperMessageListener;
        private long startTime;

        public MainLooperPrinter(@NonNull MainLooperMessageListener mainLooperMessageListener) {
            this.mainLooperMessageListener = mainLooperMessageListener;
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (str.startsWith(AltriaXMainLooper.MESSAGE_START)) {
                this.startTime = SystemClock.uptimeMillis();
            } else if (!str.startsWith(AltriaXMainLooper.MESSAGE_END) || this.startTime <= 0) {
            } else {
                this.mainLooperMessageListener.onMainLooperMessage(str, SystemClock.uptimeMillis() - this.startTime);
                if (str.contains(AltriaXMainLooper.this.endName)) {
                    Looper.getMainLooper().setMessageLogging(null);
                }
            }
        }
    }

    public static AltriaXMainLooper getInstance() {
        return IoDHHolder.instance;
    }

    public void setEndName(@NonNull String str) {
        this.endName = str;
    }

    public void setMainLooperMessageListener(@NonNull MainLooperMessageListener mainLooperMessageListener) {
        this.mainLooperMessageListener = mainLooperMessageListener;
    }

    public void start() {
        if (this.mainLooperMessageListener == null || !Log.isLoggable(TAG, 2)) {
            return;
        }
        Looper.getMainLooper().setMessageLogging(new MainLooperPrinter(this.mainLooperMessageListener));
    }

    private AltriaXMainLooper() {
        this.endName = "DistributedTasks";
    }
}
