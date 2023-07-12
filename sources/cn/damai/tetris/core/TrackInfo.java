package cn.damai.tetris.core;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TrackInfo extends JSONObject {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TRACKINFO_AB_BUCKET = "ABTrackInfo";
    public static final String TRACKINFO_AB_PREAB = "PreABTrackInfo";
    public String trackA;
    public String trackB;
    public String trackC;
    public String trackD;

    public TrackInfo(JSONObject jSONObject) {
        super(jSONObject.getInnerMap());
    }

    public Map<String, String> getArgsMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489213349")) {
            return (Map) ipChange.ipc$dispatch("1489213349", new Object[]{this});
        }
        Map<String, Object> innerMap = getInnerMap();
        if (innerMap == null || innerMap.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Set<String> keySet = innerMap.keySet();
        if (keySet != null) {
            for (String str : keySet) {
                if (innerMap.get(str) != null) {
                    hashMap.put(str, innerMap.get(str).toString());
                }
            }
        }
        return hashMap;
    }

    public TrackInfo() {
    }
}
