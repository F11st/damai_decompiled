package com.taobao.weex.ui.module;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.bridge.WXHashMap;
import com.taobao.weex.bridge.WXJSObject;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.performance.WXInstanceApm;
import com.taobao.weex.utils.WXJsonUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXTimerModule extends WXModule implements Handler.Callback, Destroyable {
    private static final String TAG = "timer";
    private Handler handler = new Handler(WXBridgeManager.getInstance().getJSLooper(), this);
    private SparseArray<Integer> antiIntAutoBoxing = new SparseArray<>();

    private void checkIfTimerInBack(int i) {
        WXSDKInstance y = WXSDKManager.v().y(String.valueOf(i));
        if (y != null && y.isViewDisAppear()) {
            y.getApmForInstance().B(WXInstanceApm.KEY_PAGE_TIMER_BACK_NUM, 1.0d);
        }
    }

    private WXJSObject[] createTimerArgs(int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i2));
        arrayList.add(new HashMap());
        arrayList.add(Boolean.valueOf(z));
        WXHashMap wXHashMap = new WXHashMap();
        wXHashMap.put("method", WXBridgeManager.METHOD_CALLBACK);
        wXHashMap.put("args", arrayList);
        return new WXJSObject[]{new WXJSObject(2, String.valueOf(i)), new WXJSObject(3, WXJsonUtils.fromObjectToJSONString(new Object[]{wXHashMap}))};
    }

    private void postMessage(int i, @IntRange(from = 1) int i2, @IntRange(from = 0) int i3, int i4) {
        if (i3 >= 0 && i2 > 0) {
            if (this.antiIntAutoBoxing.get(i2) == null) {
                this.antiIntAutoBoxing.put(i2, Integer.valueOf(i2));
            }
            this.handler.sendMessageDelayed(this.handler.obtainMessage(i, i4, i3, this.antiIntAutoBoxing.get(i2)), i3);
            return;
        }
        WXLogUtils.e("timer", "interval < 0 or funcId <=0");
    }

    private void postOrHoldMessage(int i, int i2, int i3, int i4) {
        if (this.mWXSDKInstance.isPreRenderMode()) {
            postMessage(i, i2, i3, i4);
        } else {
            postMessage(i, i2, i3, i4);
        }
    }

    private void removeOrHoldMessage(int i, int i2) {
        if (this.mWXSDKInstance.isPreRenderMode()) {
            this.handler.removeMessages(i, this.antiIntAutoBoxing.get(i2, Integer.valueOf(i2)));
        } else {
            this.handler.removeMessages(i, this.antiIntAutoBoxing.get(i2, Integer.valueOf(i2)));
        }
    }

    @JSMethod(uiThread = false)
    public void clearInterval(@IntRange(from = 1) int i) {
        if (i <= 0) {
            return;
        }
        removeOrHoldMessage(12, i);
    }

    @JSMethod(uiThread = false)
    public void clearTimeout(@IntRange(from = 1) int i) {
        if (i <= 0) {
            return;
        }
        removeOrHoldMessage(11, i);
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        if (this.handler != null) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("timer", "Timer Module removeAllMessages: ");
            }
            this.handler.removeCallbacksAndMessages(null);
            this.antiIntAutoBoxing.clear();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message != null) {
            int i = message.what;
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.d("timer", "Timer Module handleMessage : " + message.what);
            }
            if (i != 11) {
                if (i != 12 || message.obj == null) {
                    return false;
                }
                checkIfTimerInBack(message.arg1);
                postMessage(12, ((Integer) message.obj).intValue(), message.arg2, message.arg1);
                WXBridgeManager.getInstance().invokeExecJS(String.valueOf(message.arg1), null, WXBridgeManager.METHOD_CALL_JS, createTimerArgs(message.arg1, ((Integer) message.obj).intValue(), true), true);
            } else if (message.obj == null) {
                return false;
            } else {
                checkIfTimerInBack(message.arg1);
                WXBridgeManager.getInstance().invokeExecJS(String.valueOf(message.arg1), null, WXBridgeManager.METHOD_CALL_JS, createTimerArgs(message.arg1, ((Integer) message.obj).intValue(), false), true);
            }
            return true;
        }
        return false;
    }

    @VisibleForTesting
    void setHandler(Handler handler) {
        this.handler = handler;
    }

    @JSMethod(uiThread = false)
    public void setInterval(@IntRange(from = 1) int i, @FloatRange(from = 0.0d) float f) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            postOrHoldMessage(12, i, (int) f, WXUtils.parseInt(wXSDKInstance.getInstanceId()));
            if (this.mWXSDKInstance.getWXPerformance() != null) {
                this.mWXSDKInstance.getWXPerformance().timerInvokeCount++;
            }
            this.mWXSDKInstance.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_TIMER_NUM, 1.0d);
        }
    }

    @JSMethod(uiThread = false)
    public void setTimeout(@IntRange(from = 1) int i, @FloatRange(from = 0.0d) float f) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            postOrHoldMessage(11, i, (int) f, WXUtils.parseInt(wXSDKInstance.getInstanceId()));
            if (this.mWXSDKInstance.getWXPerformance() != null) {
                this.mWXSDKInstance.getWXPerformance().timerInvokeCount++;
            }
            this.mWXSDKInstance.getApmForInstance().C(WXInstanceApm.KEY_PAGE_STATS_FS_TIMER_NUM, 1.0d);
        }
    }
}
