package cn.damai.tetris.core.mtop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class GlobalConfig implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_EXTRA_BUZUTMAP = "KEY_EXTRA_BUZUTMAP";
    public JSONArray abBuckets;
    public String comboDegrade;
    public JSONObject extraInfo;
    public String pabBucket;
    public String pageName;

    public JSONObject fixDxGlobalCon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-175610890")) {
            return (JSONObject) ipChange.ipc$dispatch("-175610890", new Object[]{this});
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageName", (Object) this.pageName);
        return jSONObject;
    }

    public Map getBuzUTMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1936417273")) {
            return (Map) ipChange.ipc$dispatch("-1936417273", new Object[]{this});
        }
        JSONObject jSONObject = this.extraInfo;
        if (jSONObject == null) {
            return null;
        }
        return (Map) jSONObject.get(KEY_EXTRA_BUZUTMAP);
    }

    public void putBuzUTMap(Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124433516")) {
            ipChange.ipc$dispatch("2124433516", new Object[]{this, map});
            return;
        }
        if (this.extraInfo == null) {
            this.extraInfo = new JSONObject();
        }
        this.extraInfo.put(KEY_EXTRA_BUZUTMAP, (Object) map);
    }
}
