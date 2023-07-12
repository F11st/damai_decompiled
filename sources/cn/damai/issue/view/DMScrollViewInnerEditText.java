package cn.damai.issue.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMScrollViewInnerEditText extends AppCompatEditText {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean mBottomFlag;
    private int mOffsetHeight;

    public DMScrollViewInnerEditText(Context context) {
        super(context);
        this.mBottomFlag = false;
        init();
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2131928602")) {
            ipChange.ipc$dispatch("-2131928602", new Object[]{this});
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-590701766")) {
            return ((Boolean) ipChange.ipc$dispatch("-590701766", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            this.mBottomFlag = false;
        }
        if (this.mBottomFlag) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934983893")) {
            ipChange.ipc$dispatch("1934983893", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        this.mOffsetHeight = ((getLayout().getHeight() + getTotalPaddingTop()) + getTotalPaddingBottom()) - getHeight();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "290652556")) {
            ipChange.ipc$dispatch("290652556", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        if (i2 == this.mOffsetHeight || i2 == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.mBottomFlag = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25661707")) {
            return ((Boolean) ipChange.ipc$dispatch("-25661707", new Object[]{this, motionEvent})).booleanValue();
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (!this.mBottomFlag) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return onTouchEvent;
    }

    public DMScrollViewInnerEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBottomFlag = false;
        init();
    }

    public DMScrollViewInnerEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBottomFlag = false;
        init();
    }
}
