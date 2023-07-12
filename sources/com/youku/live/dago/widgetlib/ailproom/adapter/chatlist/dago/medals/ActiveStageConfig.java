package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.medals;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ActiveStageConfig {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ActiveStageConfig";
    private static volatile ActiveStageConfig mInstance;
    private Map<Integer, String> mActiveStageMap = new HashMap();

    public static ActiveStageConfig getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884920763")) {
            return (ActiveStageConfig) ipChange.ipc$dispatch("-1884920763", new Object[0]);
        }
        if (mInstance == null) {
            synchronized (ActiveStageConfig.class) {
                if (mInstance == null) {
                    mInstance = new ActiveStageConfig();
                }
            }
        }
        return mInstance;
    }

    public String getActiveStage(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1061991247") ? (String) ipChange.ipc$dispatch("1061991247", new Object[]{this, Integer.valueOf(i)}) : this.mActiveStageMap.get(Integer.valueOf(i));
    }

    public String getActiveStateByFirstIndex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1016097146")) {
            return (String) ipChange.ipc$dispatch("1016097146", new Object[]{this});
        }
        Iterator<Map.Entry<Integer, String>> it = this.mActiveStageMap.entrySet().iterator();
        return it.hasNext() ? it.next().getValue() : "";
    }

    public void setActiveStageResponse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859985767")) {
            ipChange.ipc$dispatch("859985767", new Object[]{this, str});
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).getJSONArray("args").getJSONObject(0).optJSONObject("body");
            if (optJSONObject.optInt("cd", -1) == 0) {
                JSONArray optJSONArray = optJSONObject.optJSONObject("rs").optJSONArray("sgs");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.mActiveStageMap.put(Integer.valueOf(optJSONArray.optJSONObject(i).optInt("sg")), optJSONArray.optJSONObject(i).optString("sgn"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateActiveStage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "680531377")) {
            ipChange.ipc$dispatch("680531377", new Object[]{this, str});
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).getJSONArray("args").getJSONObject(0).optJSONObject("body");
            if (optJSONObject.optInt("cd", -1) == 0) {
                this.mActiveStageMap.put(Integer.valueOf(optJSONObject.optInt("sg")), optJSONObject.optString("sgn"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
