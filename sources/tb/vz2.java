package tb;

import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.bridge.WXReactorPage;
import com.taobao.weex.bridge.WXReactorPlugin;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vz2 {
    private static vz2 b;
    private volatile WXReactorPlugin a;

    private vz2() {
    }

    public static vz2 b() {
        if (b == null) {
            synchronized (vz2.class) {
                if (b == null) {
                    b = new vz2();
                }
            }
        }
        return b;
    }

    public WXReactorPage a(long j, String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.createPage(j, str);
    }

    public void c(int i, IWXUserTrackAdapter iWXUserTrackAdapter) {
    }
}
