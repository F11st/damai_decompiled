package com.taomai.android.h5container.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class H5Progress extends ProgressBar {
    public static final int DEFAULT_DURATION = 1200;
    public static final int MIN_DURATION = 300;
    public static final String TAG = "H5Progress";
    private long curDuration;
    private boolean isRunnableWorking;
    private int lastProgress;
    private int lastTarget;
    private Handler mHandler;
    private UpdateRunnable mUpdateRunnable;
    private long minDuration;
    private int nextVisibility;
    private ProgressNotifier notifier;
    private long originTime;
    private long startTime;
    private int targetProgress;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ProgressNotifier {
        void onProgressBegin();

        void onProgressEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class UpdateRunnable implements Runnable {
        private int deltaProgress;
        private int period;

        UpdateRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            H5Progress.this.isRunnableWorking = true;
            int max = H5Progress.this.getMax();
            if (max == 0) {
                H5Progress.this.mHandler.removeCallbacks(this);
                H5Progress.this.isRunnableWorking = false;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - H5Progress.this.startTime;
            if ((H5Progress.this.curDuration * this.deltaProgress) / max == 0) {
                H5Progress.this.mHandler.removeCallbacks(this);
                H5Progress.this.isRunnableWorking = false;
                return;
            }
            int i = H5Progress.this.lastTarget + ((int) ((currentTimeMillis * this.deltaProgress) / H5Progress.this.curDuration));
            if (i <= H5Progress.this.targetProgress) {
                if (H5Progress.this.lastProgress == 0 && H5Progress.this.notifier != null) {
                    H5Progress.this.notifier.onProgressBegin();
                }
                H5Progress.this.setProgress(i);
                H5Progress.this.lastProgress = i;
            } else {
                if (i > H5Progress.this.getMax() && H5Progress.this.notifier != null) {
                    H5Progress.this.notifier.onProgressEnd();
                }
                if (H5Progress.this.nextVisibility != -1) {
                    H5Progress h5Progress = H5Progress.this;
                    H5Progress.super.setVisibility(h5Progress.nextVisibility);
                    H5Progress.this.nextVisibility = -1;
                }
            }
            if (i <= H5Progress.this.targetProgress) {
                H5Progress.this.mHandler.postDelayed(this, this.period);
                return;
            }
            if (i > H5Progress.this.getMax()) {
                H5Progress.this.reset();
            }
            H5Progress.this.mHandler.removeCallbacks(this);
            H5Progress.this.isRunnableWorking = false;
        }

        public void setPeriodValue(int i) {
            this.period = i;
        }

        public void setdeltaProgressValue(int i) {
            this.deltaProgress = i;
        }
    }

    public H5Progress(Context context) {
        super(context);
        this.isRunnableWorking = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mUpdateRunnable = new UpdateRunnable();
        init();
    }

    private void init() {
        this.minDuration = 1200L;
        setMax(100);
        this.nextVisibility = -1;
        reset();
    }

    private void linearProgress() {
        if (isIndeterminate()) {
            Log.d(TAG, "isIndeterminate");
            return;
        }
        this.curDuration = this.minDuration;
        if (this.targetProgress == getMax() && this.lastTarget > getMax() / 2) {
            this.curDuration = 300L;
        }
        int i = this.targetProgress - this.lastTarget;
        if (i > 0) {
            long j = this.curDuration;
            if (j > 0) {
                int i2 = (int) (j / i);
                this.mHandler.removeCallbacks(this.mUpdateRunnable);
                this.mUpdateRunnable.setPeriodValue(i2);
                this.mUpdateRunnable.setdeltaProgressValue(i);
                this.mHandler.postDelayed(this.mUpdateRunnable, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.originTime = 0L;
        this.targetProgress = 0;
        this.lastTarget = 0;
        this.lastProgress = 0;
    }

    public void hideAndResetProgress() {
        hideProgress();
        reset();
    }

    public void hideProgress() {
        Log.d(TAG, "hideProgress");
        super.setVisibility(8);
    }

    public void setMinDuration(long j) {
        this.minDuration = j;
    }

    public void setNotifier(ProgressNotifier progressNotifier) {
        this.notifier = progressNotifier;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Log.d(TAG, "setVisibility:" + i);
        if (this.isRunnableWorking && i != 0) {
            this.nextVisibility = i;
        } else {
            super.setVisibility(i);
        }
    }

    public void showProgress() {
        super.setVisibility(0);
    }

    public void updateProgress(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.originTime == 0) {
            this.originTime = currentTimeMillis;
        }
        int max = getMax();
        int i2 = (int) ((i * 0.25d) + (max * 0.75d));
        int i3 = this.lastProgress;
        if (i2 < i3 || i2 > max) {
            return;
        }
        this.lastTarget = i3;
        this.startTime = currentTimeMillis;
        this.targetProgress = i2;
        linearProgress();
    }

    public H5Progress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isRunnableWorking = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mUpdateRunnable = new UpdateRunnable();
        init();
    }

    public H5Progress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isRunnableWorking = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mUpdateRunnable = new UpdateRunnable();
        init();
    }
}
