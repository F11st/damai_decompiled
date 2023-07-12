package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MyScrollView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean b;
    private Context context;
    private float lastX;
    private float lastY;
    public ScrollYListener mScrollListener;
    private View view;
    private float xDistance;
    private float yDistance;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ScrollYListener {
        void onScroll(View view, int i);
    }

    public MyScrollView(Context context) {
        super(context);
        this.context = context;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1801429423")) {
            ipChange.ipc$dispatch("-1801429423", new Object[]{this});
        } else {
            super.computeScroll();
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944072016")) {
            return ((Boolean) ipChange.ipc$dispatch("-1944072016", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.yDistance = 0.0f;
            this.xDistance = 0.0f;
            this.lastX = motionEvent.getX();
            this.lastY = motionEvent.getY();
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.xDistance += Math.abs(x - this.lastX);
            float abs = this.yDistance + Math.abs(y - this.lastY);
            this.yDistance = abs;
            this.lastX = x;
            this.lastY = y;
            if (this.xDistance > abs) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309545875")) {
            ipChange.ipc$dispatch("-309545875", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        if (this.view != null) {
            int a = q60.a(this.context, 176.0f);
            int a2 = q60.a(this.context, 4.0f);
            if (getScrollY() >= a) {
                this.view.setBackgroundColor(-1);
            } else if (getScrollY() <= a2) {
                this.view.setBackgroundResource(R$drawable.main_top_cover_bg);
            } else {
                String hexString = Integer.toHexString((int) ((((getScrollY() * 0.8d) / a) * 255.0d) + 51.0d));
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                try {
                    this.view.setBackgroundColor(Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + hexString + "ffffff"));
                } catch (Exception e) {
                    e.printStackTrace();
                    this.view.setBackgroundColor(Color.parseColor("#33ffffff"));
                }
            }
        }
        ScrollYListener scrollYListener = this.mScrollListener;
        if (scrollYListener != null) {
            scrollYListener.onScroll(this, getScrollY());
        }
    }

    public void setHeadAlpha(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724976793")) {
            ipChange.ipc$dispatch("1724976793", new Object[]{this, view});
        } else {
            this.view = view;
        }
    }

    public void setOnScrollYListener(ScrollYListener scrollYListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545281673")) {
            ipChange.ipc$dispatch("1545281673", new Object[]{this, scrollYListener});
        } else {
            this.mScrollListener = scrollYListener;
        }
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public MyScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }
}
