package cn.damai.uikit.irecycler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class HorizontalRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange;
    boolean disallowInterceptTouchEvent;
    private int lastX;
    private int lastY;
    Context mContext;

    public HorizontalRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-370676296")) {
            return ((Boolean) ipChange.ipc$dispatch("-370676296", new Object[]{this, motionEvent})).booleanValue();
        }
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            if (Math.abs(rawX - this.lastX) + 0 >= Math.abs(rawY - this.lastY) + 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            this.lastX = rawX;
            this.lastY = rawY;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250252781")) {
            ipChange.ipc$dispatch("-1250252781", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.disallowInterceptTouchEvent = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    public HorizontalRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastX = -1;
        this.lastY = -1;
        this.mContext = context;
    }
}
