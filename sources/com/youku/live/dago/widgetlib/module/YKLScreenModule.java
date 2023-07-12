package com.youku.live.dago.widgetlib.module;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLScreenModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String FULL_CL0SE = "0";
    private static final String FULL_KEY = "full";
    private static final String FULL_OPEN = "1";
    private static final String ORIENTATION_AUTO = "auto";
    private static final String ORIENTATION_KEY = "orientation";
    private static final String ORIENTATION_LANDSCAPE = "landscape";
    private static final String ORIENTATION_LANDSCAPE_LEFT = "landscapeLeft";
    private static final String ORIENTATION_LANDSCAPE_RIGHT = "landscapeRight";
    private static final String ORIENTATION_PORTRAIT = "portrait";
    private static final String ORIENTATION_PORTRAIT_UPSIDE_DOWN = "portraitUpsideDown";
    private static final String TAG = "YKLScreenModule";
    JSCallback mOriFailCallback;
    JSCallback mOriSucdCallback;

    private void setNotFullScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861303053")) {
            ipChange.ipc$dispatch("-861303053", new Object[]{this, activity});
        } else {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    public void lockScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-926007384")) {
            ipChange.ipc$dispatch("-926007384", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            if (activity.getResources().getConfiguration().orientation != 2) {
                activity.setRequestedOrientation(5);
            } else if (Build.VERSION.SDK_INT < 8) {
                activity.setRequestedOrientation(0);
            } else {
                int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                if (rotation != 0 && rotation != 1) {
                    activity.setRequestedOrientation(8);
                } else {
                    activity.setRequestedOrientation(0);
                }
            }
        }
    }

    @JSMethod
    public void setAutoRotate(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1521989996")) {
            ipChange.ipc$dispatch("-1521989996", new Object[]{this, map, jSCallback, jSCallback2});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || map == null) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
            }
        } else if (!(wXSDKInstance.getContext() instanceof Activity)) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
            }
        } else {
            if ("0".equalsIgnoreCase(map.get("auto"))) {
                lockScreen((Activity) this.mWXSDKInstance.getContext());
            }
            if (jSCallback != null) {
                jSCallback.invoke(null);
            }
        }
    }

    @JSMethod
    public void setFullScreen(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "479312773")) {
            ipChange.ipc$dispatch("479312773", new Object[]{this, map, jSCallback, jSCallback2});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || map == null) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
            }
        } else if (!(wXSDKInstance.getContext() instanceof Activity)) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(null);
            }
        } else {
            String str = map.get(FULL_KEY);
            if (TextUtils.isEmpty(str)) {
                if (jSCallback2 != null) {
                    jSCallback2.invoke(null);
                    return;
                }
                return;
            }
            Activity activity = (Activity) this.mWXSDKInstance.getContext();
            if ("1".equals(str)) {
                setFullScreen(activity);
                if (jSCallback != null) {
                    jSCallback.invoke(null);
                }
            } else if (!"0".equals(str)) {
                if (jSCallback2 != null) {
                    jSCallback2.invoke(null);
                }
            } else {
                setNotFullScreen(activity);
                if (jSCallback != null) {
                    jSCallback.invoke(null);
                }
            }
        }
    }

    @JSMethod
    public void setOrientation(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1308806470")) {
            ipChange.ipc$dispatch("1308806470", new Object[]{this, map, jSCallback, jSCallback2});
            return;
        }
        this.mOriSucdCallback = jSCallback;
        this.mOriFailCallback = jSCallback2;
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || map == null) {
            if (jSCallback2 != null) {
                jSCallback2.invokeAndKeepAlive(new Object());
            }
        } else if (!(wXSDKInstance.getContext() instanceof Activity)) {
            JSCallback jSCallback3 = this.mOriFailCallback;
            if (jSCallback3 != null) {
                jSCallback3.invokeAndKeepAlive(new Object());
            }
        } else {
            String str = map.get("orientation");
            if (TextUtils.isEmpty(str)) {
                JSCallback jSCallback4 = this.mOriFailCallback;
                if (jSCallback4 != null) {
                    jSCallback4.invokeAndKeepAlive(new Object());
                    return;
                }
                return;
            }
            setOrientation(str);
            JSCallback jSCallback5 = this.mOriSucdCallback;
            if (jSCallback5 != null) {
                jSCallback5.invokeAndKeepAlive(new Object());
            }
        }
    }

    public void unlockScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1769212817")) {
            ipChange.ipc$dispatch("-1769212817", new Object[]{this, activity});
        } else if (activity == null) {
        } else {
            activity.setRequestedOrientation(4);
        }
    }

    private void setOrientation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967574807")) {
            ipChange.ipc$dispatch("-967574807", new Object[]{this, str});
            return;
        }
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || wXSDKInstance.getContext() == null) {
            return;
        }
        Activity activity = (Activity) this.mWXSDKInstance.getContext();
        if (!"portrait".equalsIgnoreCase(str) && !"portraitUpsideDown".equalsIgnoreCase(str)) {
            if ("landscapeRight".equalsIgnoreCase(str) || "landscapeLeft".equalsIgnoreCase(str)) {
                activity.setRequestedOrientation(0);
                return;
            }
            return;
        }
        activity.setRequestedOrientation(1);
    }

    private void setFullScreen(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1244660370")) {
            ipChange.ipc$dispatch("1244660370", new Object[]{this, activity});
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
