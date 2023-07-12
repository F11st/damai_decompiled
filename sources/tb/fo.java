package tb;

import android.os.Bundle;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class fo {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Bundle a(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666358667")) {
            return (Bundle) ipChange.ipc$dispatch("-1666358667", new Object[]{map});
        }
        if (map == null || map.isEmpty()) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                bundle.putSerializable(key, null);
            } else if (value instanceof int[]) {
                bundle.putIntArray(key, (int[]) value);
            } else if (value instanceof Short) {
                bundle.putShort(key, ((Short) value).shortValue());
            } else if (value instanceof Serializable) {
                bundle.putSerializable(key, (Serializable) value);
            } else {
                Log.w("ALiFlutter", "ConvertUtils -> unSupport Serializable for key" + key);
            }
        }
        return bundle;
    }
}
