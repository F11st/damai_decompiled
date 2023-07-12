package cn.damai.homepage.ui.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class RankItemDividerDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1614530094")) {
            ipChange.ipc$dispatch("-1614530094", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.left = t60.a(recyclerView.getContext(), this.a);
        } else {
            rect.left = t60.a(recyclerView.getContext(), this.b);
        }
        if (recyclerView.getChildLayoutPosition(view) == recyclerView.getLayoutManager().getItemCount() - 1) {
            rect.right = t60.a(recyclerView.getContext(), this.a);
        } else {
            rect.right = 0;
        }
    }
}
