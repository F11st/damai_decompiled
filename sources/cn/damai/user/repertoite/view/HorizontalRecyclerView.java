package cn.damai.user.repertoite.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
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
        if (AndroidInstantRuntime.support(ipChange, "2066443098")) {
            return ((Boolean) ipChange.ipc$dispatch("2066443098", new Object[]{this, motionEvent})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "660532273")) {
            ipChange.ipc$dispatch("660532273", new Object[]{this, Boolean.valueOf(z)});
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
