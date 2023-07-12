package tb;

import cn.damai.tetris.gaiax.GaiaXTemplateInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ht0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Map<Integer, GaiaXTemplateInfo> a = new HashMap();
    private static final Map<GaiaXTemplateInfo, Integer> b = new HashMap();
    private static final AtomicInteger c = new AtomicInteger(100000);

    public static GaiaXTemplateInfo a(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1793336362") ? (GaiaXTemplateInfo) ipChange.ipc$dispatch("-1793336362", new Object[]{Integer.valueOf(i)}) : a.get(Integer.valueOf(i));
    }

    public static int b(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244791742")) {
            return ((Integer) ipChange.ipc$dispatch("244791742", new Object[]{jSONObject})).intValue();
        }
        GaiaXTemplateInfo gaiaXTemplateInfo = (GaiaXTemplateInfo) JSON.parseObject(jSONObject.toJSONString(), GaiaXTemplateInfo.class);
        if (gaiaXTemplateInfo == null || gaiaXTemplateInfo.componentId == null) {
            return 0;
        }
        Map<GaiaXTemplateInfo, Integer> map = b;
        if (map.containsKey(gaiaXTemplateInfo)) {
            return map.get(gaiaXTemplateInfo).intValue();
        }
        int andIncrement = c.getAndIncrement();
        a.put(Integer.valueOf(andIncrement), gaiaXTemplateInfo);
        map.put(gaiaXTemplateInfo, Integer.valueOf(andIncrement));
        return andIncrement;
    }
}
