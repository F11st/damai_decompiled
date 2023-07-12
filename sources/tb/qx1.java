package tb;

import android.os.Build;
import android.view.View;
import android.widget.AbsListView;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class qx1 implements PtrHandler {
    public static boolean a(View view) {
        if (Build.VERSION.SDK_INT < 14) {
            if (!(view instanceof AbsListView)) {
                return view.getScrollY() > 0;
            }
            AbsListView absListView = (AbsListView) view;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        return view.canScrollVertically(-1);
    }

    public static boolean b(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        return !a(view);
    }

    @Override // in.srain.cube.views.ptr.PtrHandler
    public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
        return b(ptrFrameLayout, view, view2);
    }
}
