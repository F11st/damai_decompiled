package tb;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class t41 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Bundle a(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1566196818")) {
            return (Bundle) ipChange.ipc$dispatch("-1566196818", new Object[]{jSONArray});
        }
        Bundle bundle = new Bundle();
        int b = b(jSONArray);
        for (int i = 0; i < b; i += 2) {
            String string = jSONArray.getString(i);
            int i2 = i + 1;
            String string2 = i2 < b ? jSONArray.getString(i2) : "";
            if (!TextUtils.isEmpty(string)) {
                bundle.putString(string, string2 != null ? string2 : "");
            }
        }
        return bundle;
    }

    public static int b(JSONArray jSONArray) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-861936322")) {
            return ((Integer) ipChange.ipc$dispatch("-861936322", new Object[]{jSONArray})).intValue();
        }
        if (jSONArray == null) {
            return 0;
        }
        return jSONArray.size();
    }
}
