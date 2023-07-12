package tb;

import android.content.Context;
import com.taobao.weex.WXSDKInstance;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class tz2 {
    private Map<String, WXSDKInstance> a;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    private static class b {
        private static final tz2 a = new tz2();
    }

    public static tz2 a() {
        return b.a;
    }

    public WXSDKInstance b(String str, Context context) {
        WXSDKInstance remove = this.a.remove(str);
        if (remove != null) {
            remove.init(context);
        }
        return remove;
    }

    private tz2() {
        this.a = new ConcurrentHashMap();
    }
}
