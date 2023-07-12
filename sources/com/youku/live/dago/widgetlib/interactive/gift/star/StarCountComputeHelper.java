package com.youku.live.dago.widgetlib.interactive.gift.star;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.interactive.gift.star.IMSendUpStreamRequest;
import com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimer;
import com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerListener;
import com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class StarCountComputeHelper implements Handler.Callback, SYTimerListener, SYTimerTask.SYTimerStepListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final int MSG_STAR_LOCAL_RECYCLE = 0;
    private WeakReference<Activity> mActivityRef;
    private IEventCallback mCallback;
    private long mDuration;
    private IMSendUpStreamRequest mIMSendUpStreamRequest;
    private long mRoomId;
    private StarModelNew mStarModel;
    private long mStep;
    private long mStarGet = 0;
    private long mStarGetMax = 0;
    private boolean mStarCycleRunning = false;
    private int mSendStarCount = 1;
    private Runnable mSendStarRunnable = new Runnable() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.StarCountComputeHelper.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1608969343")) {
                ipChange.ipc$dispatch("-1608969343", new Object[]{this});
            } else if (StarCountComputeHelper.this.mIMSendUpStreamRequest != null) {
                IMSendUpStreamRequest iMSendUpStreamRequest = StarCountComputeHelper.this.mIMSendUpStreamRequest;
                int i = StarCountComputeHelper.this.mSendStarCount;
                iMSendUpStreamRequest.sendStar(i, StarCountComputeHelper.this.mRoomId + "");
            }
        }
    };
    private IMSendUpStreamRequest.ICallback mSendStarCallback = new IMSendUpStreamRequest.ICallback() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.StarCountComputeHelper.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.dago.widgetlib.interactive.gift.star.IMSendUpStreamRequest.ICallback
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "405772579")) {
                ipChange.ipc$dispatch("405772579", new Object[]{this});
            }
        }

        @Override // com.youku.live.dago.widgetlib.interactive.gift.star.IMSendUpStreamRequest.ICallback
        public void onSuccess(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1832619260")) {
                ipChange.ipc$dispatch("1832619260", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            if (StarCountComputeHelper.this.mStarModel.starAvail == StarCountComputeHelper.this.mStarModel.starTotalMax) {
                StarCountComputeHelper.this.mStarModel.leftSeconds = StarCountComputeHelper.this.mStarModel.starGap;
                StarCountComputeHelper starCountComputeHelper = StarCountComputeHelper.this;
                starCountComputeHelper.activateCounter(starCountComputeHelper.mStarModel);
            }
            StarCountComputeHelper.this.mStarModel.starAvail = i;
            if (StarCountComputeHelper.this.mCallback == null || StarCountComputeHelper.this.mStarModel == null) {
                return;
            }
            StarCountComputeHelper.this.mCallback.onActorStarCountAquiredEvent(StarCountComputeHelper.this.mStarModel.starAvail);
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper(), this);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface IEventCallback {
        void onActorStarCountAquiredEvent(long j);

        void onFullStarEvent();

        void onPlayStarEffect(int i);

        void onTimerStepForStarEvent(long j, long j2);
    }

    public StarCountComputeHelper(Activity activity) {
        this.mActivityRef = new WeakReference<>(activity);
    }

    private long getStarAquiredTimeLeft() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1502920940")) {
            return ((Long) ipChange.ipc$dispatch("1502920940", new Object[]{this})).longValue();
        }
        long j = this.mDuration;
        long j2 = this.mStep;
        if (j > j2) {
            return j - j2;
        }
        return 0L;
    }

    public void activateCounter(StarModelNew starModelNew) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2113783102")) {
            ipChange.ipc$dispatch("-2113783102", new Object[]{this, starModelNew});
            return;
        }
        this.mStarModel = starModelNew;
        this.mStarCycleRunning = false;
        this.mStarGet = starModelNew.starTodayGain;
        this.mStarGetMax = starModelNew.starTodayMax;
        SYTimer.getInstance().cancelNotify(this);
        if (this.mStarModel.leftSeconds > 0) {
            if (this.mStarCycleRunning) {
                return;
            }
            this.mStarCycleRunning = true;
            SYTimer.getInstance().addNotify(this, this.mStarModel.leftSeconds * 1000, this, 1000L);
            return;
        }
        IEventCallback iEventCallback = this.mCallback;
        if (iEventCallback != null) {
            iEventCallback.onFullStarEvent();
        }
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1541281183")) {
            ipChange.ipc$dispatch("1541281183", new Object[]{this});
            return;
        }
        stopCounter();
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        StarModelNew starModelNew;
        IEventCallback iEventCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1229059055")) {
            return ((Boolean) ipChange.ipc$dispatch("-1229059055", new Object[]{this, message})).booleanValue();
        }
        if (message.what != 0 || (starModelNew = this.mStarModel) == null) {
            return false;
        }
        long j = starModelNew.starAvail;
        if (j > 0 && (iEventCallback = this.mCallback) != null) {
            iEventCallback.onActorStarCountAquiredEvent(j);
        }
        if (this.mStarGetMax - this.mStarGet > 0) {
            StarModelNew starModelNew2 = this.mStarModel;
            if (starModelNew2.starAvail - starModelNew2.starExt < starModelNew2.starTotalMax) {
                if (!this.mStarCycleRunning) {
                    this.mStarCycleRunning = true;
                    SYTimer.getInstance().addNotify(this, this.mStarModel.starGap * 1000, new SYTimerTask.SYTimerStepListener() { // from class: com.youku.live.dago.widgetlib.interactive.gift.star.StarCountComputeHelper.3
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask.SYTimerStepListener
                        public void onStepError(long j2, long j3) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-1987731507")) {
                                ipChange2.ipc$dispatch("-1987731507", new Object[]{this, Long.valueOf(j2), Long.valueOf(j3)});
                            }
                        }

                        @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask.SYTimerStepListener
                        public void onStepNotify(long j2, long j3) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-852673812")) {
                                ipChange2.ipc$dispatch("-852673812", new Object[]{this, Long.valueOf(j2), Long.valueOf(j3)});
                            } else if (StarCountComputeHelper.this.mCallback != null) {
                                StarCountComputeHelper.this.mCallback.onTimerStepForStarEvent(j3, j2);
                            }
                        }
                    }, 1000L);
                }
            } else {
                IEventCallback iEventCallback2 = this.mCallback;
                if (iEventCallback2 != null) {
                    iEventCallback2.onFullStarEvent();
                }
            }
        } else {
            IEventCallback iEventCallback3 = this.mCallback;
            if (iEventCallback3 != null) {
                iEventCallback3.onFullStarEvent();
            }
        }
        return true;
    }

    public boolean hasLeftStar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1255562934")) {
            return ((Boolean) ipChange.ipc$dispatch("-1255562934", new Object[]{this})).booleanValue();
        }
        StarModelNew starModelNew = this.mStarModel;
        return starModelNew != null && starModelNew.starAvail > 0;
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerListener
    public void onNotify() {
        StarModelNew starModelNew;
        IEventCallback iEventCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95144073")) {
            ipChange.ipc$dispatch("95144073", new Object[]{this});
            return;
        }
        StarModelNew starModelNew2 = this.mStarModel;
        if (starModelNew2 == null) {
            return;
        }
        long j = this.mStarGet + 1;
        this.mStarGet = j;
        starModelNew2.starTodayGain = j;
        starModelNew2.starAvail++;
        this.mStarCycleRunning = false;
        this.mHandler.sendEmptyMessage(0);
        if (this.mStep + 1000 >= this.mDuration) {
            this.mStep = 0L;
        }
        StarModelNew starModelNew3 = this.mStarModel;
        if (starModelNew3.starAvail == starModelNew3.starTotalMax && (iEventCallback = this.mCallback) != null) {
            iEventCallback.onFullStarEvent();
        }
        if (this.mStarModel == null) {
            return;
        }
        IEventCallback iEventCallback2 = this.mCallback;
        if (iEventCallback2 != null) {
            iEventCallback2.onTimerStepForStarEvent(this.mDuration, this.mStep);
        }
        try {
            IEventCallback iEventCallback3 = this.mCallback;
            if (iEventCallback3 == null || (starModelNew = this.mStarModel) == null) {
                return;
            }
            iEventCallback3.onActorStarCountAquiredEvent(starModelNew.starAvail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask.SYTimerStepListener
    public void onStepError(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708308292")) {
            ipChange.ipc$dispatch("-708308292", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
        }
    }

    @Override // com.youku.live.dago.widgetlib.interactive.gift.star.timer.SYTimerTask.SYTimerStepListener
    public void onStepNotify(long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "154740189")) {
            ipChange.ipc$dispatch("154740189", new Object[]{this, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        StarModelNew starModelNew = this.mStarModel;
        if (starModelNew == null) {
            return;
        }
        long j3 = starModelNew.starGap;
        long j4 = j3 * 1000;
        this.mDuration = j4;
        long j5 = j + ((j3 - starModelNew.leftSeconds) * 1000);
        this.mStep = j5;
        IEventCallback iEventCallback = this.mCallback;
        if (iEventCallback != null) {
            iEventCallback.onTimerStepForStarEvent(j4, j5);
        }
    }

    public void sendStar(int i, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "563051960")) {
            ipChange.ipc$dispatch("563051960", new Object[]{this, Integer.valueOf(i), Long.valueOf(j)});
            return;
        }
        StarModelNew starModelNew = this.mStarModel;
        if (starModelNew == null) {
            return;
        }
        if (starModelNew.starAvail > 0) {
            if (this.mIMSendUpStreamRequest == null) {
                IMSendUpStreamRequest iMSendUpStreamRequest = new IMSendUpStreamRequest();
                this.mIMSendUpStreamRequest = iMSendUpStreamRequest;
                iMSendUpStreamRequest.setCallback(this.mSendStarCallback);
            }
            this.mRoomId = j;
            this.mSendStarCount = i;
            IMSendUpStreamRequest iMSendUpStreamRequest2 = this.mIMSendUpStreamRequest;
            iMSendUpStreamRequest2.sendStar(i, j + "");
            return;
        }
        toastNoStar();
    }

    public void setEventCallback(IEventCallback iEventCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308333871")) {
            ipChange.ipc$dispatch("308333871", new Object[]{this, iEventCallback});
        } else {
            this.mCallback = iEventCallback;
        }
    }

    public synchronized void stopCounter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1344929793")) {
            ipChange.ipc$dispatch("-1344929793", new Object[]{this});
            return;
        }
        SYTimer.getInstance().cancelNotify(this);
        this.mStarModel = null;
        this.mStarCycleRunning = false;
    }

    public void toastNoStar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577740065")) {
            ipChange.ipc$dispatch("-577740065", new Object[]{this});
        } else if (this.mActivityRef.get() != null) {
            if (this.mStarCycleRunning) {
                if (getStarAquiredTimeLeft() > 0) {
                    ToastUtil.showCenter(this.mActivityRef.get(), String.format("%1$s秒后获得下一颗星星", "" + (getStarAquiredTimeLeft() / 1000)));
                    return;
                }
                return;
            }
            ToastUtil.showCenter(this.mActivityRef.get(), "今天的小星星已经用光啦");
        }
    }
}
