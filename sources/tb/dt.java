package tb;

import android.view.View;
import android.view.ViewGroup;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class dt {
    public abstract void a(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(WeakReference<View> weakReference) {
        if (weakReference == null) {
            return;
        }
        View view = weakReference.get();
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(WeakReference<View> weakReference) {
        View view;
        if (weakReference == null || (view = weakReference.get()) == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
