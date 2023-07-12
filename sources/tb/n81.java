package tb;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild;
import cn.damai.homepage.nestedscroll.overscroll.IOverScroll;
import cn.damai.homepage.nestedscroll.recyclerview.ParentRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class n81 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(RecyclerView recyclerView) {
        NestedScrollChild nestedScrollChild;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2120488562")) {
            return ((Boolean) ipChange.ipc$dispatch("2120488562", new Object[]{recyclerView})).booleanValue();
        }
        if ((recyclerView instanceof ParentRecyclerView) && (nestedScrollChild = ((ParentRecyclerView) recyclerView).getNestedScrollChild()) != null) {
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt == nestedScrollChild && (childAt.getTop() > 0 || childAt.getBottom() < recyclerView.getHeight())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean b(RecyclerView recyclerView, int i, int i2, boolean z) {
        NestedScrollChild nestedScrollChild;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3581769")) {
            return ((Boolean) ipChange.ipc$dispatch("3581769", new Object[]{recyclerView, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        }
        if ((recyclerView instanceof ParentRecyclerView) && (nestedScrollChild = ((ParentRecyclerView) recyclerView).getNestedScrollChild()) != null && i - i2 == 0) {
            int childCount = recyclerView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                if (childAt == nestedScrollChild) {
                    if (childAt.getTop() > 0 || childAt.getBottom() < recyclerView.getHeight() || (z && childAt.getTop() <= 0 && childAt.getBottom() >= recyclerView.getHeight()) || ((ParentRecyclerView) recyclerView).acceptNestedScroll(i)) {
                        nestedScrollChild.onScrolledByNestedParent((ParentRecyclerView) recyclerView);
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static int c(RecyclerView recyclerView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "3672326")) {
            return ((Integer) ipChange.ipc$dispatch("3672326", new Object[]{recyclerView, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        if (i2 != 0 && (recyclerView instanceof IOverScroll)) {
            ((IOverScroll) recyclerView).onDisabledDirection(0);
        }
        int i3 = i - i2;
        if (i3 != 0 && (recyclerView instanceof IOverScroll)) {
            IOverScroll iOverScroll = (IOverScroll) recyclerView;
            iOverScroll.onDisabledDirection(i);
            iOverScroll.onReachedEdge(i3, 0);
        }
        return i3;
    }
}
