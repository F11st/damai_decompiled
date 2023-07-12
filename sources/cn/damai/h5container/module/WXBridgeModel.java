package cn.damai.h5container.module;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.WXModule;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class WXBridgeModel extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Context contextReference;
    protected JSONObject jsonObject;

    public String getParam(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-991044546")) {
            return (String) ipChange.ipc$dispatch("-991044546", new Object[]{this, str});
        }
        JSONObject jSONObject = this.jsonObject;
        return (jSONObject == null || jSONObject.get(str) == null) ? "" : this.jsonObject.get(str).toString();
    }

    public Bundle paramToBundle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-349905963")) {
            return (Bundle) ipChange.ipc$dispatch("-349905963", new Object[]{this});
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
}
