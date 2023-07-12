package cn.damai.ticklet.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CustomScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    PointF curP;
    PointF downP;
    Boolean isOneTouch;
    Boolean isScrolledToBottom;
    Boolean isScrolledToTop;

    public CustomScrollView(Context context) {
        super(context);
        Boolean bool = Boolean.TRUE;
        this.isOneTouch = bool;
        this.isScrolledToTop = bool;
        this.isScrolledToBottom = Boolean.FALSE;
        this.downP = new PointF();
        this.curP = new PointF();
        this.context = context;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099897882")) {
            return ((Boolean) ipChange.ipc$dispatch("1099897882", new Object[]{this, motionEvent})).booleanValue();
        }
        this.curP.x = motionEvent.getX();
        this.curP.y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downP.x = motionEvent.getX();
            this.downP.y = motionEvent.getY();
            cb1.b("dispatchTouchEvent m", "CustomScrollView ACTION_DOWN scroll");
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 1) {
            this.isOneTouch = Boolean.TRUE;
            cb1.b("dispatchTouchEvent m", "CustomScrollView ACTION_UP scroll");
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            PointF pointF = this.curP;
            float f = pointF.x;
            PointF pointF2 = this.downP;
            float f2 = f - pointF2.x;
            float f3 = pointF.y - pointF2.y;
            cb1.b("dispatchTouchEvent m", "CustomScrollView ACTION_MOVE scroll 水平=" + Math.abs(f2) + " 垂直=" + Math.abs(f3));
            if (Math.abs(f2) < Math.abs(f3) && (!this.isScrolledToTop.booleanValue() || !this.isScrolledToBottom.booleanValue())) {
                cb1.b("dispatchTouchEvent m", "CustomScrollView ACTION_MOVE scroll 垂直 true");
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                cb1.b("dispatchTouchEvent m", "CustomScrollView ACTION_MOVE scroll 水平 父布局");
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654561903")) {
            return ((Boolean) ipChange.ipc$dispatch("1654561903", new Object[]{this, motionEvent})).booleanValue();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2112450295")) {
            ipChange.ipc$dispatch("2112450295", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        super.onOverScrolled(i, i2, z, z2);
        if (getScrollY() == 0) {
            cb1.b("dispatchTouchEvent m", "CustomScrollView onOverScrolled getScrollY() == 0");
            this.isScrolledToTop = Boolean.TRUE;
            this.isScrolledToBottom = Boolean.FALSE;
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (((getScrollY() + getHeight()) - getPaddingTop()) - getPaddingBottom() == getChildAt(0).getHeight()) {
            cb1.b("dispatchTouchEvent m ", "CustomScrollView onOverScrolled scroll getScrollY() = " + getScrollY() + " getHeight()= " + getHeight() + " 总=" + (((getScrollY() + getHeight()) - getPaddingTop()) - getPaddingBottom()) + " getChildAt(0).getHeight()=" + getChildAt(0).getHeight() + " Deputils = " + t60.a(this.context, 402.0f));
            this.isScrolledToBottom = Boolean.TRUE;
            this.isScrolledToTop = Boolean.FALSE;
            getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            Boolean bool = Boolean.FALSE;
            this.isScrolledToTop = bool;
            this.isScrolledToBottom = bool;
        }
    }

    public CustomScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Boolean bool = Boolean.TRUE;
        this.isOneTouch = bool;
        this.isScrolledToTop = bool;
        this.isScrolledToBottom = Boolean.FALSE;
        this.downP = new PointF();
        this.curP = new PointF();
        this.context = context;
    }
}
