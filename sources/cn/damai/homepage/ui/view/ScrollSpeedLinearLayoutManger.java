package cn.damai.homepage.ui.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ScrollSpeedLinearLayoutManger extends LinearLayoutManager {
    private static transient /* synthetic */ IpChange $ipChange;

    public ScrollSpeedLinearLayoutManger(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "183063332")) {
            ipChange.ipc$dispatch("183063332", new Object[]{this, recyclerView, state, Integer.valueOf(i)});
            return;
        }
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: cn.damai.homepage.ui.view.ScrollSpeedLinearLayoutManger.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-724492939")) {
                    return ((Float) ipChange2.ipc$dispatch("-724492939", new Object[]{this, displayMetrics})).floatValue();
                }
                return 2.0f;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i2) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1184432691") ? (PointF) ipChange2.ipc$dispatch("-1184432691", new Object[]{this, Integer.valueOf(i2)}) : ScrollSpeedLinearLayoutManger.this.computeScrollVectorForPosition(i2);
            }
        };
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }
}
