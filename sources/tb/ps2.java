package tb;

import com.alibaba.analytics.core.Variables;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ps2 extends zs2 {
    @Override // tb.zs2
    public String[] a() {
        return new String[]{"ut_bussiness"};
    }

    @Override // tb.zs2
    public void b(String str) {
        super.b(str);
    }

    @Override // tb.zs2
    public void c(String str, Map<String, String> map) {
        String str2;
        if (!map.containsKey("tpk") || (str2 = map.get("tpk")) == null) {
            return;
        }
        Variables.n().e0(str2);
        qs2.b("tpk_md5", Variables.n().z());
    }
}
