package cn.damai.discover.content.ui.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class StaggeredGridItemDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1070415010")) {
            ipChange.ipc$dispatch("1070415010", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getChildViewHolder(view) instanceof BaseViewHolder) {
            if (((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex() % 2 == 0) {
                rect.left = t60.a(recyclerView.getContext(), 12.0f);
                rect.right = t60.a(recyclerView.getContext(), 6.0f);
            } else {
                rect.left = t60.a(recyclerView.getContext(), 6.0f);
                rect.right = t60.a(recyclerView.getContext(), 12.0f);
            }
            rect.bottom = t60.a(recyclerView.getContext(), 12.0f);
        }
    }
}
