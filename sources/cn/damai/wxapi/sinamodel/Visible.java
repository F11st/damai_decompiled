package cn.damai.wxapi.sinamodel;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Visible {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int VISIBLE_FRIEND = 3;
    public static final int VISIBLE_GROUPED = 2;
    public static final int VISIBLE_NORMAL = 0;
    public static final int VISIBLE_PRIVACY = 1;
    public int list_id;
    public int type;

    public static Visible parse(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788447707")) {
            return (Visible) ipChange.ipc$dispatch("-788447707", new Object[]{jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        Visible visible = new Visible();
        visible.type = jSONObject.optInt("type", 0);
        visible.list_id = jSONObject.optInt("list_id", 0);
        return visible;
    }
}
