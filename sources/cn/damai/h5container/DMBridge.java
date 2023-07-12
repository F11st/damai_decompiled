package cn.damai.h5container;

import android.content.Context;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.webview.IWVWebView;
import android.util.Log;
import cn.damai.h5container.action.DMBridgeAction;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMBridge extends WVApiPlugin {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String TAG = "DMBridge";
    private static Map<String, DMBridgeAction> actionMap = new HashMap();

    public static void destory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285945201")) {
            ipChange.ipc$dispatch("1285945201", new Object[0]);
            return;
        }
        Map<String, DMBridgeAction> map = actionMap;
        if (map != null) {
            map.clear();
        }
    }

    public static void registerAction(String str, DMBridgeAction dMBridgeAction) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807673626")) {
            ipChange.ipc$dispatch("1807673626", new Object[]{str, dMBridgeAction});
        } else {
            actionMap.put(str, dMBridgeAction);
        }
    }

    public static void registerPlugin(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-331432391")) {
            ipChange.ipc$dispatch("-331432391", new Object[]{context});
        } else {
            new ActionConfig(context).addActions();
        }
    }

    public static void resume(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1470723536")) {
            ipChange.ipc$dispatch("-1470723536", new Object[]{context});
            return;
        }
        Map<String, DMBridgeAction> map = actionMap;
        if (map != null) {
            map.clear();
        } else {
            actionMap = new HashMap();
        }
        new ActionConfig(context).addActions();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        DMBridgeAction dMBridgeAction;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "505976773")) {
            return ((Boolean) ipChange.ipc$dispatch("505976773", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        String str3 = TAG;
        Log.d(str3, "action22 : " + str + " , params : " + str2);
        Map<String, DMBridgeAction> map = actionMap;
        if (map == null || map.size() == 0) {
            Log.d("wpf", "execute action map empty resume!!!!!!!!!!!");
            resume(this.mContext);
        }
        if (!actionMap.containsKey(str) || (dMBridgeAction = actionMap.get(str)) == null) {
            return false;
        }
        IWVWebView iWVWebView = this.mWebView;
        if (iWVWebView instanceof DamaiWebView) {
            dMBridgeAction.setWebView((DamaiWebView) iWVWebView);
        }
        dMBridgeAction.execute(str, str2, wVCallBackContext);
        return true;
    }
}
