package tb;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class q {
    private WeakReference<Context> a;
    private JSONObject b;
    private WeakReference<h> c;

    public h a() {
        WeakReference<h> weakReference = this.c;
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

    public void d(h hVar) {
        this.c = new WeakReference<>(hVar);
    }

    public void e(Context context) {
        this.a = new WeakReference<>(context);
    }
}
