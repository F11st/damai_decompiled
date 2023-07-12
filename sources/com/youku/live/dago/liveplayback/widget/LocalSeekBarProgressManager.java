package com.youku.live.dago.liveplayback.widget;

import android.os.Handler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.HorizontalFullscreenPlugin;
import com.youku.live.dago.liveplayback.widget.plugins.verticalsmall.VerticalSmallscreenPlugin;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LocalSeekBarProgressManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "LocalSeekBarProgressManager";
    private boolean isChangeStatus;
    private long mEndTime;
    private HorizontalFullscreenPlugin mHFullScreen;
    private boolean mIsTimeShift;
    private int mLiveState;
    private long mLiveTime;
    private String mLiveType;
    private long mNowTime;
    private long mStartTime;
    private long mSumTime;
    private VerticalSmallscreenPlugin mVSmallScreen;
    private Handler mHandler = new Handler();
    private boolean mTimeFlag = false;
    private boolean mHasStartTime = false;
    private Runnable mRunnable = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.LocalSeekBarProgressManager.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1332510557")) {
                ipChange.ipc$dispatch("-1332510557", new Object[]{this});
            } else if (LocalSeekBarProgressManager.this.mTimeFlag) {
                if (LocalSeekBarProgressManager.this.mIsTimeShift) {
                    LocalSeekBarProgressManager.this.mLiveTime += 1000;
                    LocalSeekBarProgressManager.this.mNowTime += 1000;
                    Logger.d(LocalSeekBarProgressManager.TAG, "rum mLiveTime = " + LocalSeekBarProgressManager.this.mLiveTime + " mNowTime = " + LocalSeekBarProgressManager.this.mNowTime + " mSumTime = " + LocalSeekBarProgressManager.this.mSumTime);
                    if (LocalSeekBarProgressManager.this.mLiveTime > LocalSeekBarProgressManager.this.mSumTime) {
                        LocalSeekBarProgressManager localSeekBarProgressManager = LocalSeekBarProgressManager.this;
                        localSeekBarProgressManager.mLiveTime = localSeekBarProgressManager.mSumTime;
                    }
                    if (LocalSeekBarProgressManager.this.mNowTime > LocalSeekBarProgressManager.this.mLiveTime) {
                        LocalSeekBarProgressManager localSeekBarProgressManager2 = LocalSeekBarProgressManager.this;
                        localSeekBarProgressManager2.mNowTime = localSeekBarProgressManager2.mLiveTime;
                    }
                    LocalSeekBarProgressManager localSeekBarProgressManager3 = LocalSeekBarProgressManager.this;
                    localSeekBarProgressManager3.setLiveTime(localSeekBarProgressManager3.mLiveTime);
                    LocalSeekBarProgressManager localSeekBarProgressManager4 = LocalSeekBarProgressManager.this;
                    localSeekBarProgressManager4.setNowTime(localSeekBarProgressManager4.mNowTime);
                }
                LocalSeekBarProgressManager.this.mHandler.postDelayed(this, 1000L);
            }
        }
    };

    private void initTimeShiftForSeekBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "198253380")) {
            ipChange.ipc$dispatch("198253380", new Object[]{this});
            return;
        }
        setStartTime(this.mStartTime);
        setSumTime(this.mSumTime);
        setNowTime(this.mNowTime);
        setLiveTime(this.mLiveTime);
        this.mIsTimeShift = true;
        startTimeTask();
    }

    private void setStartTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1051763710")) {
            ipChange.ipc$dispatch("-1051763710", new Object[]{this, Long.valueOf(j)});
            return;
        }
        VerticalSmallscreenPlugin verticalSmallscreenPlugin = this.mVSmallScreen;
        if (verticalSmallscreenPlugin != null) {
            verticalSmallscreenPlugin.setStartTime(j);
        }
        HorizontalFullscreenPlugin horizontalFullscreenPlugin = this.mHFullScreen;
        if (horizontalFullscreenPlugin != null) {
            horizontalFullscreenPlugin.setStartTime(j);
        }
    }

    private void setSumTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1857510891")) {
            ipChange.ipc$dispatch("1857510891", new Object[]{this, Long.valueOf(j)});
            return;
        }
        VerticalSmallscreenPlugin verticalSmallscreenPlugin = this.mVSmallScreen;
        if (verticalSmallscreenPlugin != null) {
            verticalSmallscreenPlugin.setSumTime(j);
        }
        HorizontalFullscreenPlugin horizontalFullscreenPlugin = this.mHFullScreen;
        if (horizontalFullscreenPlugin != null) {
            horizontalFullscreenPlugin.setSumTime(j);
        }
    }

    public void deinit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643098878")) {
            ipChange.ipc$dispatch("1643098878", new Object[]{this});
            return;
        }
        Logger.d(TAG, "deinit");
        stopTimeTask();
        this.mNowTime = 0L;
        this.mLiveTime = 0L;
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mSumTime = 0L;
    }

    public long getNowTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1939227914") ? ((Long) ipChange.ipc$dispatch("-1939227914", new Object[]{this})).longValue() : this.mNowTime;
    }

    public void initTimeShift(long j, long j2, long j3, long j4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "484318550")) {
            ipChange.ipc$dispatch("484318550", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)});
            return;
        }
        this.mNowTime = j3 - j;
        this.mLiveTime = j4 - j;
        this.mStartTime = j;
        this.mEndTime = j2;
        this.mSumTime = j2 - j;
        initTimeShiftForSeekBar();
    }

    public void setHFullScreen(HorizontalFullscreenPlugin horizontalFullscreenPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1755676910")) {
            ipChange.ipc$dispatch("-1755676910", new Object[]{this, horizontalFullscreenPlugin});
        } else {
            this.mHFullScreen = horizontalFullscreenPlugin;
        }
    }

    public void setLiveTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587713924")) {
            ipChange.ipc$dispatch("1587713924", new Object[]{this, Long.valueOf(j)});
            return;
        }
        Logger.d(TAG, "setLiveTime liveTime = " + j);
        this.mLiveTime = j;
        VerticalSmallscreenPlugin verticalSmallscreenPlugin = this.mVSmallScreen;
        if (verticalSmallscreenPlugin != null) {
            verticalSmallscreenPlugin.setLiveTime(j);
        }
        HorizontalFullscreenPlugin horizontalFullscreenPlugin = this.mHFullScreen;
        if (horizontalFullscreenPlugin != null) {
            horizontalFullscreenPlugin.setLiveTime(j);
        }
    }

    public void setNowTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758228618")) {
            ipChange.ipc$dispatch("-1758228618", new Object[]{this, Long.valueOf(j)});
            return;
        }
        if (j == -1) {
            j = this.mLiveTime;
        }
        Logger.d(TAG, "setNowTime nowTime = " + j);
        this.mNowTime = j;
        VerticalSmallscreenPlugin verticalSmallscreenPlugin = this.mVSmallScreen;
        if (verticalSmallscreenPlugin != null) {
            verticalSmallscreenPlugin.setNowTime(j);
        }
        HorizontalFullscreenPlugin horizontalFullscreenPlugin = this.mHFullScreen;
        if (horizontalFullscreenPlugin != null) {
            horizontalFullscreenPlugin.setNowTime(j);
        }
    }

    public void setVSmallScreen(VerticalSmallscreenPlugin verticalSmallscreenPlugin) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "484690464")) {
            ipChange.ipc$dispatch("484690464", new Object[]{this, verticalSmallscreenPlugin});
        } else {
            this.mVSmallScreen = verticalSmallscreenPlugin;
        }
    }

    public void startTimeTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794868999")) {
            ipChange.ipc$dispatch("1794868999", new Object[]{this});
        } else if (this.mHasStartTime) {
        } else {
            this.mTimeFlag = true;
            this.mHandler.post(this.mRunnable);
            this.mHasStartTime = true;
        }
    }

    public void stopTimeTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2043818597")) {
            ipChange.ipc$dispatch("-2043818597", new Object[]{this});
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRunnable);
            this.mHandler.removeCallbacksAndMessages(null);
        }
        this.mTimeFlag = false;
        this.mHasStartTime = false;
    }
}
