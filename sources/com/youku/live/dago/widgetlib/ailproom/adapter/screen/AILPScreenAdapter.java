package com.youku.live.dago.widgetlib.ailproom.adapter.screen;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.OrientationEventListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.callback.AILPScreenCallback;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPScreenProtocol;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPScreenAdapter implements AILPScreenProtocol {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ORIENTATION_LANDSCAPE_LEFT = "landscapeLeft";
    private static final String ORIENTATION_LANDSCAPE_RIGHT = "landscapeRight";
    private static final String ORIENTATION_PORTRAIT = "portrait";
    private static final String ORIENTATION_PORTRAIT_UPSIDE_DOWN = "portraitUpsideDown";
    private Context mContext;
    private MyOrientationListener mOrientationListener;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class MyOrientationListener extends OrientationEventListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context mContext;
        private String mCurrentOrientation;
        private String mPreOrientation;
        private AILPScreenCallback mScreenCallback;

        MyOrientationListener(Context context) {
            super(context);
            this.mContext = context;
            this.mCurrentOrientation = "portrait";
            this.mPreOrientation = "portrait";
        }

        private String getOrientationName(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1306456380")) {
                return (String) ipChange.ipc$dispatch("1306456380", new Object[]{this, Integer.valueOf(i)});
            }
            int i2 = i % 360;
            if ((i2 < 0 || i2 >= 45) && i2 <= 315) {
                if (i2 <= 45 || i2 >= 135) {
                    if (i2 <= 135 || i2 >= 225) {
                        if (i2 <= 225 || i2 >= 315) {
                            return null;
                        }
                        return "landscapeRight";
                    }
                    return "portraitUpsideDown";
                }
                return "landscapeLeft";
            }
            return "portrait";
        }

        private void sendOrientationEvent(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "399530332")) {
                ipChange.ipc$dispatch("399530332", new Object[]{this, str});
                return;
            }
            AILPScreenCallback aILPScreenCallback = this.mScreenCallback;
            if (aILPScreenCallback != null) {
                aILPScreenCallback.onOrientationChange(str);
            }
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1206533474")) {
                ipChange.ipc$dispatch("1206533474", new Object[]{this, Integer.valueOf(i)});
            } else if (this.mContext instanceof Activity) {
                String orientationName = getOrientationName(i);
                if (TextUtils.isEmpty(orientationName) || orientationName.equalsIgnoreCase(this.mPreOrientation)) {
                    return;
                }
                sendOrientationEvent(orientationName);
                this.mPreOrientation = orientationName;
            }
        }

        void setOrientation(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1663092832")) {
                ipChange.ipc$dispatch("1663092832", new Object[]{this, str});
            } else if (str.equalsIgnoreCase(this.mCurrentOrientation)) {
            } else {
                Activity activity = (Activity) this.mContext;
                if ("portrait".equalsIgnoreCase(str)) {
                    activity.setRequestedOrientation(1);
                    this.mCurrentOrientation = "portrait";
                } else if ("landscapeRight".equalsIgnoreCase(str)) {
                    activity.setRequestedOrientation(0);
                    this.mCurrentOrientation = "landscapeRight";
                } else if ("portraitUpsideDown".equalsIgnoreCase(str)) {
                    activity.setRequestedOrientation(9);
                    this.mCurrentOrientation = "portraitUpsideDown";
                } else if ("landscapeLeft".equalsIgnoreCase(str)) {
                    activity.setRequestedOrientation(8);
                    this.mCurrentOrientation = "landscapeLeft";
                }
            }
        }

        void setScreenCallback(AILPScreenCallback aILPScreenCallback) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1625229978")) {
                ipChange.ipc$dispatch("1625229978", new Object[]{this, aILPScreenCallback});
            } else {
                this.mScreenCallback = aILPScreenCallback;
            }
        }
    }

    private void setNotFullScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1952492330")) {
            ipChange.ipc$dispatch("-1952492330", new Object[]{this, activity});
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPScreenProtocol
    public void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1169923960")) {
            ipChange.ipc$dispatch("-1169923960", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        if (this.mOrientationListener == null) {
            MyOrientationListener myOrientationListener = new MyOrientationListener(context);
            this.mOrientationListener = myOrientationListener;
            myOrientationListener.enable();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPScreenProtocol
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-506414465")) {
            ipChange.ipc$dispatch("-506414465", new Object[]{this});
            return;
        }
        MyOrientationListener myOrientationListener = this.mOrientationListener;
        if (myOrientationListener != null) {
            myOrientationListener.disable();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPScreenProtocol
    public boolean setFullScreen(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185867899")) {
            return ((Boolean) ipChange.ipc$dispatch("185867899", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        Context context = this.mContext;
        if (context != null && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (z) {
                setFullScreen(activity);
            } else {
                setNotFullScreen(activity);
            }
            return true;
        }
        return false;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPScreenProtocol
    public boolean setOrientation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-889149680")) {
            return ((Boolean) ipChange.ipc$dispatch("-889149680", new Object[]{this, str})).booleanValue();
        }
        MyOrientationListener myOrientationListener = this.mOrientationListener;
        if (myOrientationListener != null) {
            myOrientationListener.setOrientation(str);
            return true;
        }
        return false;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPScreenProtocol
    public void setScreenCallback(AILPScreenCallback aILPScreenCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145162094")) {
            ipChange.ipc$dispatch("145162094", new Object[]{this, aILPScreenCallback});
            return;
        }
        MyOrientationListener myOrientationListener = this.mOrientationListener;
        if (myOrientationListener != null) {
            myOrientationListener.setScreenCallback(aILPScreenCallback);
        }
    }

    private void setFullScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1145290639")) {
            ipChange.ipc$dispatch("1145290639", new Object[]{this, activity});
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && i < 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(6);
        } else if (i >= 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(4102);
        }
    }
}
