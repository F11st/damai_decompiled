package tb;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* renamed from: tb.q */
/* loaded from: classes8.dex */
public class C9586q {
    private WeakReference<Context> a;
    private JSONObject b;
    private WeakReference<C9192h> c;

    public C9192h a() {
        WeakReference<C9192h> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public JSONObject b() {
        if (this.b == null) {
            this.b = new JSONObject();
        }
        return this.b;
    }

    public Context c() {
        WeakReference<Context> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void d(C9192h c9192h) {
        this.c = new WeakReference<>(c9192h);
    }

    public void e(Context context) {
        this.a = new WeakReference<>(context);
    }
}
