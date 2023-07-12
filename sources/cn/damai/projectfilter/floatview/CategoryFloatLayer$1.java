package cn.damai.projectfilter.floatview;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CategoryFloatLayer$1 extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ b a;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247399687")) {
            ipChange.ipc$dispatch("-1247399687", new Object[]{this, rect, view, recyclerView, state});
        } else if (recyclerView.getChildAdapterPosition(view) % 2 == 0) {
            i2 = this.a.g;
            rect.right = i2;
        } else {
            i = this.a.g;
            rect.left = i;
        }
    }
}
