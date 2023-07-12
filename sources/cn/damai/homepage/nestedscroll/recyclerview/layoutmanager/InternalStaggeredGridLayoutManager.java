package cn.damai.homepage.nestedscroll.recyclerview.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.n81;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class InternalStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private RecyclerView a;

    public InternalStaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794746638")) {
            return ((Integer) ipChange.ipc$dispatch("-1794746638", new Object[]{this, Integer.valueOf(i), recycler, state})).intValue();
        }
        try {
            boolean a = n81.a(this.a);
            int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
            n81.b(this.a, i, scrollVerticallyBy, a);
            if (n81.c(this.a, i, scrollVerticallyBy) != 0) {
                return 0;
            }
            return scrollVerticallyBy;
        } catch (Exception unused) {
            return 0;
        }
    }
}
