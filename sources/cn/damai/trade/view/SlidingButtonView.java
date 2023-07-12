package cn.damai.trade.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import cn.damai.trade.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class SlidingButtonView extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Boolean isOpen;
    private IonSlidingButtonListener mIonSlidingButtonListener;
    private int mScrollWidth;
    private TextView mTextView_Delete;
    private Boolean once;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface IonSlidingButtonListener {
        void onDownOrMove(SlidingButtonView slidingButtonView);

        void onMenuIsClosed(SlidingButtonView slidingButtonView);

        void onMenuIsOpen(View view);
    }

    public SlidingButtonView(Context context) {
        this(context, null);
    }

    public void changeScrollx() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1801429265")) {
            ipChange.ipc$dispatch("1801429265", new Object[]{this});
            return;
        }
        int scrollX = getScrollX();
        int i = this.mScrollWidth;
        if (scrollX >= i / 2) {
            smoothScrollTo(i, 0);
            this.isOpen = Boolean.TRUE;
            this.mIonSlidingButtonListener.onMenuIsOpen(this);
            return;
        }
        smoothScrollTo(0, 0);
        this.isOpen = Boolean.FALSE;
        this.mIonSlidingButtonListener.onMenuIsClosed(this);
    }

    public void closeMenu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1749030635")) {
            ipChange.ipc$dispatch("-1749030635", new Object[]{this});
        } else if (this.isOpen.booleanValue()) {
            smoothScrollTo(0, 0);
            this.isOpen = Boolean.FALSE;
        }
    }

    public void closeMenuNoAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885793874")) {
            ipChange.ipc$dispatch("885793874", new Object[]{this});
        } else if (this.isOpen.booleanValue()) {
            scrollTo(0, 0);
            this.isOpen = Boolean.FALSE;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2139430175")) {
            ipChange.ipc$dispatch("2139430175", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            scrollTo(0, 0);
            this.mScrollWidth = this.mTextView_Delete.getWidth();
            Log.i("asd", "mScrollWidth:" + this.mScrollWidth);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1479213613")) {
            ipChange.ipc$dispatch("1479213613", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        if (this.once.booleanValue()) {
            return;
        }
        this.mTextView_Delete = (TextView) findViewById(R$id.tv_delete);
        this.once = Boolean.TRUE;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002416356")) {
            ipChange.ipc$dispatch("1002416356", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        this.mTextView_Delete.setTranslationX(i - this.mScrollWidth);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.widget.HorizontalScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.trade.view.SlidingButtonView.$ipChange
            java.lang.String r1 = "923146397"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r3 = 0
            r2[r3] = r5
            r2[r4] = r6
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L1e:
            int r0 = r6.getAction()
            if (r0 == 0) goto L30
            if (r0 == r4) goto L2c
            if (r0 == r3) goto L30
            r1 = 3
            if (r0 == r1) goto L2c
            goto L35
        L2c:
            r5.changeScrollx()
            return r4
        L30:
            cn.damai.trade.view.SlidingButtonView$IonSlidingButtonListener r0 = r5.mIonSlidingButtonListener
            r0.onDownOrMove(r5)
        L35:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.trade.view.SlidingButtonView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void openMenu() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537127755")) {
            ipChange.ipc$dispatch("-537127755", new Object[]{this});
        } else if (this.isOpen.booleanValue()) {
        } else {
            smoothScrollTo(this.mScrollWidth, 0);
            this.isOpen = Boolean.TRUE;
            this.mIonSlidingButtonListener.onMenuIsOpen(this);
        }
    }

    public void setSlidingButtonListener(IonSlidingButtonListener ionSlidingButtonListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2070291092")) {
            ipChange.ipc$dispatch("-2070291092", new Object[]{this, ionSlidingButtonListener});
        } else {
            this.mIonSlidingButtonListener = ionSlidingButtonListener;
        }
    }

    public SlidingButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Boolean bool = Boolean.FALSE;
        this.isOpen = bool;
        this.once = bool;
        setOverScrollMode(2);
    }
}
