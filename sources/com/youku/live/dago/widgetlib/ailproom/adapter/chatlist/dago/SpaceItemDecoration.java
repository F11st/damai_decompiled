package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.util.UIUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mSpace;

    public SpaceItemDecoration(int i) {
        this.mSpace = UIUtil.dip2px(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605947677")) {
            ipChange.ipc$dispatch("-1605947677", new Object[]{this, rect, view, recyclerView, state});
        } else if (recyclerView.getChildAdapterPosition(view) > 0) {
            rect.top = this.mSpace;
        }
    }
}
