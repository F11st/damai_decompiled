package cn.damai.commonbusiness.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MyListView extends ListView {
    private static transient /* synthetic */ IpChange $ipChange;
    private GestureDetector mGestureDetector;
    private float xDistance;
    private float xLast;
    private float yDistance;
    private float yLast;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(MyListView myListView) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1494870953") ? ((Boolean) ipChange.ipc$dispatch("-1494870953", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue() : Math.abs(f2) >= Math.abs(f);
        }
    }

    @SuppressLint({"NewApi"})
    public MyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = new GestureDetector(new a(this));
        setOverScrollMode(2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1335158735") ? ((Boolean) ipChange.ipc$dispatch("-1335158735", new Object[]{this, motionEvent})).booleanValue() : super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "880514296") ? ((Boolean) ipChange.ipc$dispatch("880514296", new Object[]{this, motionEvent})).booleanValue() : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1080315604") ? ((Boolean) ipChange.ipc$dispatch("-1080315604", new Object[]{this, motionEvent})).booleanValue() : super.onTouchEvent(motionEvent);
    }

    public void setOnTouch(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826541988")) {
            ipChange.ipc$dispatch("1826541988", new Object[]{this, motionEvent});
            return;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.xDistance += Math.abs(x - this.xLast);
                    float abs = this.yDistance + Math.abs(y - this.yLast);
                    this.yDistance = abs;
                    this.xLast = x;
                    this.yLast = y;
                    if (this.xDistance > abs) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        return;
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return;
                    }
                } else if (action != 3) {
                    return;
                }
            }
            getParent().requestDisallowInterceptTouchEvent(false);
            return;
        }
        this.yDistance = 0.0f;
        this.xDistance = 0.0f;
        this.xLast = motionEvent.getX();
        this.yLast = motionEvent.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    }

    @SuppressLint({"NewApi"})
    public MyListView(Context context) {
        super(context);
        setOverScrollMode(2);
        this.mGestureDetector = new GestureDetector(new a(this));
        setFadingEdgeLength(0);
    }
}
