package tb;

import android.util.LruCache;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class t20 {
    private final Map<String, LruCache<String, DXWidgetNode>> a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.t20$b */
    /* loaded from: classes11.dex */
    public static class C9706b {
        private static final t20 a = new t20();
    }

    private String a(String str, DXTemplateItem dXTemplateItem) {
        return str + dXTemplateItem.getIdentifier() + JSMethod.NOT_SET + z00.k(DinamicXEngine.i());
    }

    private String c(@NonNull String str) {
        return this.a.get(str) != null ? str : "public_cache";
    }

    public static t20 d() {
        return C9706b.a;
    }

    private void e() {
        this.a.put("public_cache", new LruCache<>(100));
    }

    private void f() {
    }

    public DXWidgetNode b(String str, DXTemplateItem dXTemplateItem) {
        if (r10.c(str, dXTemplateItem)) {
            synchronized (this.a) {
                LruCache<String, DXWidgetNode> lruCache = this.a.get(c(str));
                if (lruCache != null) {
                    return lruCache.get(a(str, dXTemplateItem));
                }
                return null;
            }
        }
        return null;
    }

    public void g(String str, DXTemplateItem dXTemplateItem, DXWidgetNode dXWidgetNode) {
        if (!r10.c(str, dXTemplateItem) || dXWidgetNode == null) {
            return;
        }
        synchronized (this.a) {
            LruCache<String, DXWidgetNode> lruCache = this.a.get(c(str));
            if (lruCache != null) {
                lruCache.put(a(str, dXTemplateItem), dXWidgetNode);
            }
        }
    }

    private t20() {
        this.a = new HashMap();
        e();
        f();
    }
}
