package cn.damai.ticklet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CustomRecView extends IRecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;

    public CustomRecView(Context context) {
        super(context);
        this.context = context;
    }

    @Override // cn.damai.uikit.irecycler.IRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-545245982") ? ((Boolean) ipChange.ipc$dispatch("-545245982", new Object[]{this, motionEvent})).booleanValue() : super.onInterceptTouchEvent(motionEvent);
    }

    public CustomRecView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomRecView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }
}
