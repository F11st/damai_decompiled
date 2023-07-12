package com.youku.live.dago.liveplayback.widget.plugins.resize;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.opensdk.IPlayer;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.PlayerView;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.live.dago.liveplayback.ConfigUtils;
import com.youku.live.dsl.log.PerfLogUtils;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerViewResizer extends PlayerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int FILTER_PICK = 13;
    public static final String TAG = "PlayerViewResizer";
    private float halfScreenOffset;
    private int lastPickMask;
    private float lastPickOffsetLeft;
    private float lastPickOffsetRight;
    private int lastPickViewHeight;
    private int lastPickViewWidth;
    private float lastPickWindowBottom;
    private float lastPickWindowLeft;
    private float lastPickWindowRight;
    private float lastPickWindowTop;
    private Activity mActivity;
    AntiShakeOrientationEventListener mAntiShakeOrientationEventListener;
    private float mCenter;
    private boolean mIsPickMode;
    private float mManualCenter;
    private OnRotateListener mOnRotateListener;
    private OnStateChangeListener mOnStateChangeListener;
    private float mOrientation;
    private IAlixPlayer mPlayer;
    int orientationMode;
    private boolean usingManual;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnRotateListener {
        void onRotateFinished(int i);

        void onRotateStarted();
    }

    public PlayerViewResizer(@NonNull Context context, Activity activity, IPlayer iPlayer, PlayerConfig playerConfig) {
        super(context, iPlayer, playerConfig);
        this.mOnStateChangeListener = new OnStateChangeListener() { // from class: com.youku.live.dago.liveplayback.widget.plugins.resize.PlayerViewResizer.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "206015960")) {
                    ipChange.ipc$dispatch("206015960", new Object[]{this, state, state2});
                } else if (state == IAlixPlayer.State.STATE_VIDEO_PAUSED || state2 != IAlixPlayer.State.STATE_VIDEO_STARTED) {
                } else {
                    if (PlayerViewResizer.this.mIsPickMode) {
                        PlayerViewResizer.this.mAntiShakeOrientationEventListener.enable();
                    } else {
                        PlayerViewResizer.this.mAntiShakeOrientationEventListener.disable();
                    }
                }
            }
        };
        this.mManualCenter = 0.5f;
        this.usingManual = false;
        this.halfScreenOffset = 0.0f;
        this.lastPickWindowLeft = 0.0f;
        this.lastPickWindowTop = 0.0f;
        this.lastPickWindowBottom = 0.0f;
        this.lastPickWindowRight = 0.0f;
        this.lastPickOffsetLeft = 0.0f;
        this.lastPickOffsetRight = 0.0f;
        this.lastPickMask = 0;
        this.lastPickViewHeight = 0;
        this.lastPickViewWidth = 0;
        this.mCenter = 0.5f;
        this.mAntiShakeOrientationEventListener = new AntiShakeOrientationEventListener(getContext()) { // from class: com.youku.live.dago.liveplayback.widget.plugins.resize.PlayerViewResizer.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener
            public void onAntiShakeOrientationChanged(float f) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "612526828")) {
                    ipChange.ipc$dispatch("612526828", new Object[]{this, Float.valueOf(f)});
                } else if (ConfigUtils.enablePickModeRotate() && f != -1.0f) {
                    PlayerViewResizer.this.mOrientation = f;
                    PlayerViewResizer.this.triggerScreenOrientation(f);
                    IAlixPlayer.State currentState = PlayerViewResizer.this.mPlayer.getCurrentState();
                    if (currentState == IAlixPlayer.State.STATE_VIDEO_STARTED || currentState == IAlixPlayer.State.STATE_VIDEO_PAUSED) {
                        PlayerViewResizer playerViewResizer = PlayerViewResizer.this;
                        playerViewResizer.setPickRotate(playerViewResizer.mOrientation);
                    }
                }
            }
        };
        this.orientationMode = -1;
        PerfLogUtils.log("PlayerViewResizer.init start ... ");
        this.mActivity = activity;
        this.mPlayer = (IAlixPlayer) iPlayer;
        iPlayer.addOnPlayerStateListener(this.mOnStateChangeListener);
        getVideoView().setAlpha(0.0f);
    }

    public static int getScreenHeight(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "546852921")) {
            return ((Integer) ipChange.ipc$dispatch("546852921", new Object[]{context})).intValue();
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        return i > i2 ? i : i2;
    }

    public static int getScreenWidth(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590317184")) {
            return ((Integer) ipChange.ipc$dispatch("-1590317184", new Object[]{context})).intValue();
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        return i > i2 ? i2 : i;
    }

    private boolean isPickMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "960272437") ? ((Boolean) ipChange.ipc$dispatch("960272437", new Object[]{this})).booleanValue() : this.mIsPickMode;
    }

    private void sendScreenModeChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1037250997")) {
            ipChange.ipc$dispatch("1037250997", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (Logger.DEBUG) {
            Logger.d(TAG, "sendScreenModeChanged " + i);
        }
        OnRotateListener onRotateListener = this.mOnRotateListener;
        if (onRotateListener != null) {
            if (i == 0) {
                onRotateListener.onRotateStarted();
            } else {
                onRotateListener.onRotateFinished(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPickRotate(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-570054157")) {
            ipChange.ipc$dispatch("-570054157", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (0.0f == this.halfScreenOffset && Logger.DEBUG) {
            Logger.e(TAG, "setPickRotate return, halfScreenOffset not init");
        }
        float f2 = 360.0f - f;
        boolean z = this.mPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED;
        if (Logger.DEBUG) {
            Logger.e(TAG, "setPickRotate degree=" + f2 + " refresh=" + z);
        }
        this.mPlayer.setPickRotate(f2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerScreenOrientation(float f) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-185418131")) {
            ipChange.ipc$dispatch("-185418131", new Object[]{this, Float.valueOf(f)});
            return;
        }
        int i2 = (int) f;
        if (i2 != 0) {
            if (i2 == 90) {
                if (Logger.DEBUG) {
                    Logger.d(TAG, "反横全屏");
                }
                i = 3;
            } else if (i2 != 270) {
                if (Logger.DEBUG) {
                    Logger.d(TAG, "旋转状态");
                }
                i = 0;
            } else {
                if (Logger.DEBUG) {
                    Logger.d(TAG, "横全屏");
                }
                i = 2;
            }
        } else if (Logger.DEBUG) {
            Logger.d(TAG, "竖全屏");
        }
        if (this.orientationMode != i) {
            this.orientationMode = i;
            if (i == 0) {
                setPickCenterWithOffset(0.5f);
            }
            sendScreenModeChanged(this.orientationMode);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1653062514")) {
            ipChange.ipc$dispatch("-1653062514", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        resize();
    }

    @Override // com.youku.alixplayer.opensdk.PlayerView, com.youku.alixplayer.OnVideoSizeChangedListener
    public void onVideoSizeChange(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "53593022")) {
            ipChange.ipc$dispatch("53593022", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onVideoSizeChange(i, i2);
        post(new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.resize.PlayerViewResizer.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "560276977")) {
                    ipChange2.ipc$dispatch("560276977", new Object[]{this});
                } else {
                    PlayerViewResizer.this.getVideoView().setAlpha(1.0f);
                }
            }
        });
    }

    @Override // com.youku.alixplayer.opensdk.PlayerView
    protected boolean onVideoViewResize(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133799503")) {
            return ((Boolean) ipChange.ipc$dispatch("-133799503", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        }
        getVideoView().setRotation(0.0f);
        if (this.mIsPickMode) {
            float targetAspectRatio = getTargetAspectRatio();
            float f = i;
            float f2 = i2;
            float f3 = (1.0f * f) / f2;
            if (getResources().getConfiguration().orientation == 2) {
                if (this.mActivity.getRequestedOrientation() != 8) {
                    getVideoView().setRotation(-90.0f);
                } else {
                    getVideoView().setRotation(90.0f);
                }
                i2 = (int) (f2 * targetAspectRatio);
                i = (int) (i2 * targetAspectRatio);
            } else {
                getVideoView().setRotation(0.0f);
                if (targetAspectRatio != 0.0f) {
                    if (i3 == 0) {
                        if (f3 > targetAspectRatio) {
                            i = Math.round(f2 * targetAspectRatio);
                        } else {
                            i2 = Math.round(f / targetAspectRatio);
                        }
                        if (i % 2 == 1) {
                            i--;
                        }
                        if (i2 % 2 == 1) {
                            i2--;
                        }
                    } else if (i3 == 2) {
                        i2 = (int) (f / targetAspectRatio);
                    } else if (i3 == 3) {
                        i = Math.round(f2 * targetAspectRatio);
                    } else if (i3 == 4) {
                        if (f3 > targetAspectRatio) {
                            i2 = Math.round(f / targetAspectRatio);
                        } else {
                            i = Math.round(f2 * targetAspectRatio);
                        }
                    }
                }
            }
            getVideoView().getLayoutParams().width = i;
            getVideoView().getLayoutParams().height = i2;
            getVideoView().measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
            updatePickWindow(0, 0, 500);
            return true;
        }
        return false;
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801448100")) {
            ipChange.ipc$dispatch("-1801448100", new Object[]{this});
            return;
        }
        this.halfScreenOffset = 0.0f;
        this.mCenter = 0.5f;
        this.orientationMode = 0;
        HashMap hashMap = new HashMap();
        hashMap.put("enable", "0");
        this.mPlayer.setFilter(13, hashMap);
    }

    public void setOnRotateListener(OnRotateListener onRotateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432817310")) {
            ipChange.ipc$dispatch("1432817310", new Object[]{this, onRotateListener});
        } else {
            this.mOnRotateListener = onRotateListener;
        }
    }

    public void setPickCenterWithOffset(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1713712646")) {
            ipChange.ipc$dispatch("1713712646", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (0.0f == this.halfScreenOffset && Logger.DEBUG) {
            Logger.e(TAG, "setPickCenterWithOffset return, halfScreenOffset not init");
        }
        float f2 = this.halfScreenOffset;
        float f3 = f - f2;
        float f4 = 1.0f - (f2 * 2.0f);
        float f5 = f3 >= 0.0f ? f3 : 0.0f;
        if (f5 <= f4) {
            f4 = f5;
        }
        boolean z = this.mPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_PAUSED;
        if (Logger.DEBUG) {
            Logger.e(TAG, "setPickCenterWithOffset center=" + f + " offset=" + f4 + " refresh=" + z);
        }
        this.mPlayer.setPickCenter(f4, z);
    }

    public void setPickMode(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051746673")) {
            ipChange.ipc$dispatch("-2051746673", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mIsPickMode = z;
        if (z) {
            this.mAntiShakeOrientationEventListener.enable();
            return;
        }
        this.mAntiShakeOrientationEventListener.disable();
        reset();
    }

    public void updatePickWindow(Object obj, Object obj2, Object obj3) {
        int intValue;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1094277529")) {
            ipChange.ipc$dispatch("1094277529", new Object[]{this, obj, obj2, obj3});
            return;
        }
        HashMap hashMap = new HashMap();
        Integer num = 1;
        if (num instanceof Integer) {
            num.intValue();
        }
        float f = 0.5f;
        if ((obj instanceof Integer) && (obj2 instanceof Integer) && (obj3 instanceof Integer)) {
            View videoView = getVideoView();
            if (videoView == null) {
                return;
            }
            int measuredHeight = videoView.getMeasuredHeight();
            int measuredWidth = videoView.getMeasuredWidth();
            int screenHeight = getScreenHeight(getContext());
            int screenWidth = getScreenWidth(getContext());
            this.lastPickViewHeight = measuredHeight;
            this.lastPickViewWidth = screenWidth;
            float f2 = measuredWidth;
            this.halfScreenOffset = (screenWidth * 0.5f) / f2;
            float f3 = (measuredWidth - screenWidth) / 2.0f;
            this.lastPickOffsetLeft = f3 / f2;
            this.lastPickOffsetRight = ((measuredWidth + screenWidth) / 2.0f) / f2;
            float intValue2 = ((Integer) obj).intValue();
            this.lastPickWindowLeft = ((intValue2 + f3) * 1.0f) / f2;
            this.lastPickWindowTop = ((((Integer) obj2).intValue() - ((screenHeight - measuredHeight) / 2)) * 1.0f) / this.lastPickViewHeight;
            int intValue3 = ((Integer) obj3).intValue();
            int i = this.lastPickViewHeight;
            this.lastPickWindowRight = (((intValue2 + (((intValue3 * 1.0f) * f2) / i)) + f3) * 1.0f) / f2;
            this.lastPickWindowBottom = ((intValue + intValue3) * 1.0f) / i;
        }
        if (0.0f == this.halfScreenOffset) {
            if (Logger.DEBUG) {
                Logger.e(TAG, "updatePickWindow skip,not init halfScreenOffset");
                return;
            }
            return;
        }
        hashMap.put("enable", "1");
        hashMap.put("hidden", "1");
        hashMap.put("left", String.valueOf(this.lastPickWindowLeft));
        hashMap.put("top", String.valueOf(this.lastPickWindowTop));
        hashMap.put("right", String.valueOf(this.lastPickWindowRight));
        hashMap.put("bottom", String.valueOf(this.lastPickWindowBottom));
        hashMap.put("offset_left", String.valueOf(this.lastPickOffsetLeft));
        hashMap.put("offset_right", String.valueOf(this.lastPickOffsetRight));
        hashMap.put("visible_width", String.valueOf(this.lastPickViewWidth));
        hashMap.put("visible_height", String.valueOf(this.lastPickViewHeight));
        hashMap.put("refresh", "0");
        hashMap.put("mask", String.valueOf(this.lastPickMask));
        if (Logger.DEBUG) {
            Logger.e(TAG, "mPlayer.setFilter Player.FILTER_PICK, " + hashMap);
        }
        this.mPlayer.setFilter(13, hashMap);
        if (1 == this.orientationMode) {
            f = this.usingManual ? this.mManualCenter : this.mCenter;
        }
        setPickCenterWithOffset(f);
    }
}
