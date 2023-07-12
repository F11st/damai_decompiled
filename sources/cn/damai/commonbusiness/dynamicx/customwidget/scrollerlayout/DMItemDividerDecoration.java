package cn.damai.commonbusiness.dynamicx.customwidget.scrollerlayout;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMItemDividerDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;

    public DMItemDividerDecoration(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648231367")) {
            ipChange.ipc$dispatch("-648231367", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildLayoutPosition(view) == 0) {
            rect.left = this.a;
        } else {
            rect.left = this.c;
        }
        if (recyclerView.getChildLayoutPosition(view) == recyclerView.getLayoutManager().getItemCount() - 1) {
            rect.right = this.b;
        } else {
            rect.right = 0;
        }
    }
}
