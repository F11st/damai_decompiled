package tb;

import com.alibaba.android.bindingx.core.BindingXEventType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class b31 extends z21 {
    public b31() {
        this.a.put("headers", this.b);
    }

    @Override // tb.z21
    public Map<String, Object> f() {
        return this.a;
    }

    public void k(boolean z) {
        this.a.put("fromDiskCache", Boolean.valueOf(z));
    }

    public void l(String str) {
        this.a.put("reasonPhrase", str);
    }

    public void m(int i) {
        this.a.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(i));
    }

    public void n(Map<String, Object> map) {
        this.a.put(BindingXEventType.TYPE_TIMING, map);
    }
}
