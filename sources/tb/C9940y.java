package tb;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* renamed from: tb.y */
/* loaded from: classes8.dex */
public class C9940y extends C9586q {
    private WeakReference<View> d;

    public View f() {
        WeakReference<View> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.d.get();
    }

    public void g(View view) {
        this.d = new WeakReference<>(view);
    }
}
