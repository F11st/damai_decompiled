package cn.damai.h5container.action;

import android.content.Context;
import android.os.Bundle;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.h5container.DMBridge;
import cn.damai.h5container.DamaiWebView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public abstract class DMBridgeAction {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Context contextReference;
    protected JSONObject jsonObject;
    protected DamaiWebView webView;

    public DMBridgeAction(Context context) {
        this.contextReference = context;
        DMBridge.registerAction(getAction(), this);
    }

    public abstract boolean doAction(String str, String str2, WVCallBackContext wVCallBackContext);

    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776610838")) {
            return ((Boolean) ipChange.ipc$dispatch("-776610838", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        if (this.contextReference == null) {
            wVCallBackContext.error("context error");
            return false;
        }
        try {
            this.jsonObject = JSON.parseObject(str2);
            Log.d("DMBridgeAction", "action: " + str + " , params :" + str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doAction(str, str2, wVCallBackContext);
    }

    public abstract String getAction();

    public String getParam(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "358011981")) {
            return (String) ipChange.ipc$dispatch("358011981", new Object[]{this, str});
        }
        JSONObject jSONObject = this.jsonObject;
        return (jSONObject == null || jSONObject.get(str) == null) ? "" : this.jsonObject.get(str).toString();
    }

    public Bundle paramToBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119290268")) {
            return (Bundle) ipChange.ipc$dispatch("-2119290268", new Object[]{this});
        }
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            return null;
        }
        Set<String> keySet = jSONObject.keySet();
        Bundle bundle = new Bundle();
        if (keySet != null && keySet.size() > 0) {
            for (String str : keySet) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(getParam(str))) {
                    bundle.putString(str, getParam(str));
                }
            }
        }
        return bundle;
    }

    public void setWebView(DamaiWebView damaiWebView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229097023")) {
            ipChange.ipc$dispatch("-229097023", new Object[]{this, damaiWebView});
        } else {
            this.webView = damaiWebView;
        }
    }
}
