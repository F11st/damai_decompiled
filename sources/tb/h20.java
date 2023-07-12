package tb;

import android.view.View;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import com.taobao.android.dinamicx.videoc.expose.core.listener.ExposureLifecycle;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class h20 implements ExposureLifecycle<Integer, WeakReference<View>> {
    private final IDXVideoController<by2, IDXVideoListener> a;
    private final float b;
    private final boolean c;

    public h20(IDXVideoController<by2, IDXVideoListener> iDXVideoController, float f, boolean z) {
        this.a = iDXVideoController;
        this.b = Math.min(f, 1.0f);
        this.c = z;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.listener.OnAfterCancelDataExposeListener
    /* renamed from: a */
    public void onAfterCancelDataExpose(Integer num, WeakReference<View> weakReference, String str) {
        this.a.deleteVideo(new by2(num.intValue(), -1L, weakReference), str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.listener.OnBeforeDataExposeListener
    /* renamed from: b */
    public boolean onBeforeExposeData(Integer num, WeakReference<View> weakReference, String str) {
        return false;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.listener.OnDataExposeListener
    /* renamed from: c */
    public void onDataExpose(Integer num, WeakReference<View> weakReference, String str) {
        this.a.appendVideo(new by2(num.intValue(), System.currentTimeMillis(), weakReference), str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.listener.OnValidateExposeDataListener
    /* renamed from: d */
    public boolean onValidateExposeData(Integer num, WeakReference<View> weakReference, String str, Map<Integer, WeakReference<View>> map) {
        IDXVideoController<by2, IDXVideoListener> iDXVideoController;
        View view = weakReference.get();
        if (view == null) {
            return false;
        }
        boolean a = qy2.a(view, this.b);
        if (this.c && !a && (iDXVideoController = this.a) != null) {
            iDXVideoController.deleteVideo(new by2(num.intValue(), -1L, weakReference), str);
        }
        return a;
    }
}
