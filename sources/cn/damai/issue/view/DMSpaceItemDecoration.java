package cn.damai.issue.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int SPAN_COUNT = 3;
    private int a;

    public DMSpaceItemDecoration(int i) {
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1542984231")) {
            ipChange.ipc$dispatch("-1542984231", new Object[]{this, rect, view, recyclerView, state});
            return;
        }
        int i = this.a;
        rect.left = i;
        rect.right = i;
        rect.top = i;
        rect.bottom = i;
    }
}
