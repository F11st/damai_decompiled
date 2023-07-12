package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SmoothScrollLayoutManager extends LinearLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private float MILLISECONDS_PER_INCH;

    public SmoothScrollLayoutManager(Context context) {
        super(context);
        this.MILLISECONDS_PER_INCH = 1.0f;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1196895134")) {
            ipChange.ipc$dispatch("-1196895134", new Object[]{this, recyclerView, state, Integer.valueOf(i)});
            return;
        }
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.SmoothScrollLayoutManager.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1310574797") ? ((Float) ipChange2.ipc$dispatch("-1310574797", new Object[]{this, displayMetrics})).floatValue() : SmoothScrollLayoutManager.this.MILLISECONDS_PER_INCH / displayMetrics.density;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i2) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "280561803") ? (PointF) ipChange2.ipc$dispatch("280561803", new Object[]{this, Integer.valueOf(i2)}) : SmoothScrollLayoutManager.this.computeScrollVectorForPosition(i2);
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }
}
