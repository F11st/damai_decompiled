package tb;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import com.taobao.android.dinamicx.videoc.expose.core.IExposure;
import com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r00 implements RecyclerViewZone.OnRecyclerViewExposeCallback<Integer, WeakReference<View>> {
    private final IDXVideoController<by2, IDXVideoListener> a;
    private final boolean b;
    private final boolean c;
    private final boolean d;

    public r00(@Nullable IDXVideoController<by2, IDXVideoListener> iDXVideoController) {
        this(iDXVideoController, false, false, false);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
    public void onChildAttachExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, View view) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        WeakReference<View> weakReference = new WeakReference<>(view);
        iExposure.storeExposeData(Integer.valueOf(childAdapterPosition), weakReference);
        if (this.c) {
            return;
        }
        iExposure.expose(Integer.valueOf(childAdapterPosition), weakReference, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
    public void onChildDetachExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, View view) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            if (this.a != null) {
                for (Integer num : iExposure.removeAllExposeData().keySet()) {
                    View findViewByPosition = recyclerView.getLayoutManager().findViewByPosition(num.intValue());
                    if (findViewByPosition != null && recyclerView.getChildAdapterPosition(findViewByPosition) == num.intValue()) {
                        iExposure.storeExposeData(num, new WeakReference<>(findViewByPosition));
                    } else {
                        iExposure.cancelExpose(num, str, false);
                    }
                }
                this.a.clearVideos(str);
                iExposure.triggerExpose(str);
                return;
            }
            return;
        }
        iExposure.removeExposeData(Integer.valueOf(childAdapterPosition), str);
        if (this.c) {
            iExposure.cancelExpose(Integer.valueOf(childAdapterPosition), str, false);
            IDXVideoController<by2, IDXVideoListener> iDXVideoController = this.a;
            if (iDXVideoController != null) {
                iDXVideoController.deleteVideo(new by2(childAdapterPosition, -1L, new WeakReference(view)), str, false);
                return;
            }
            return;
        }
        iExposure.cancelExpose(Integer.valueOf(childAdapterPosition), str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
    public void onScrollExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, int i, int i2) {
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.impl.RecyclerViewZone.OnRecyclerViewExposeCallback
    public void onScrollStateChangeExpose(IExposure<Integer, WeakReference<View>> iExposure, String str, RecyclerView recyclerView, int i) {
        if (!this.b && i == 0) {
            if (this.d) {
                iExposure.triggerExposeAtOnce(str);
            } else {
                iExposure.exposeCache();
            }
        }
    }

    public r00(@Nullable IDXVideoController<by2, IDXVideoListener> iDXVideoController, boolean z, boolean z2, boolean z3) {
        this.a = iDXVideoController;
        this.b = z;
        this.c = z2;
        this.d = z3;
    }
}
