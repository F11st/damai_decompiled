package tb;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class s70 {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    static class a implements AppBarLayout.OnOffsetChangedListener {
        final /* synthetic */ CoordinatorLayoutListener a;

        a(CoordinatorLayoutListener coordinatorLayoutListener) {
            this.a = coordinatorLayoutListener;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            this.a.onCoordinatorUpdate(i >= 0, appBarLayout.getTotalScrollRange() + i <= 0);
        }
    }

    public static void a(View view, RefreshKernel refreshKernel, CoordinatorLayoutListener coordinatorLayoutListener) {
        try {
            if (view instanceof CoordinatorLayout) {
                refreshKernel.getRefreshLayout().setEnableNestedScroll(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(coordinatorLayoutListener));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
