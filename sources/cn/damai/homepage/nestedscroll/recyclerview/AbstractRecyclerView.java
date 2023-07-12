package cn.damai.homepage.nestedscroll.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild;
import cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent;
import cn.damai.homepage.nestedscroll.overscroll.IOverScroll;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class AbstractRecyclerView extends RecyclerView implements NestedScrollChild, NestedScrollParent, IOverScroll {
    private static transient /* synthetic */ IpChange $ipChange = null;
    protected static final float EPSILON = 2.0E-5f;
    protected int mDisabledDirection;
    protected boolean mEatInterceptTouch;
    protected boolean mEatTouchEvent;
    protected boolean mInterceptTouch;
    protected float mLastMotionX;
    protected float mLastMotionY;
    protected int mVelocityY;

    public AbstractRecyclerView(Context context) {
        super(context);
        this.mInterceptTouch = true;
        this.mEatInterceptTouch = true;
        this.mEatTouchEvent = true;
    }

    private Field getFieldRecursively(String str) {
        Field declaredField;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "201377333")) {
            return (Field) ipChange.ipc$dispatch("201377333", new Object[]{this, str});
        }
        for (Class<? super Object> superclass = getClass().getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (Throwable unused) {
            }
            if (declaredField != null) {
                return declaredField;
            }
        }
        return null;
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent
    public boolean acceptNestedFling(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-510133509") ? ((Boolean) ipChange.ipc$dispatch("-510133509", new Object[]{this, Integer.valueOf(i)})).booleanValue() : isAccepted(i);
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent
    public boolean acceptNestedScroll(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1791162034") ? ((Boolean) ipChange.ipc$dispatch("1791162034", new Object[]{this, Integer.valueOf(i)})).booleanValue() : isAccepted(i);
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent
    public boolean dispatchNestedFling(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1428608585")) {
            return ((Boolean) ipChange.ipc$dispatch("1428608585", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        if (isAttachedToWindow()) {
            this.mInterceptTouch = true;
            fling(0, i);
            return acceptNestedFling(i);
        }
        return false;
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild, cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent
    public boolean dispatchNestedScroll(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762624804")) {
            return ((Boolean) ipChange.ipc$dispatch("1762624804", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        if (isAttachedToWindow()) {
            this.mInterceptTouch = true;
            scrollBy(0, i);
            return acceptNestedScroll(i);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66738319")) {
            return ((Boolean) ipChange.ipc$dispatch("-66738319", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        boolean fling = super.fling(i, i2);
        this.mVelocityY = i2;
        return fling;
    }

    public int getDisabledDirection() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1812683879") ? ((Integer) ipChange.ipc$dispatch("1812683879", new Object[]{this})).intValue() : this.mDisabledDirection;
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public int getNestedScrollChildHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2064320939")) {
            return ((Integer) ipChange.ipc$dispatch("2064320939", new Object[]{this})).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float invokeCurrentVelocity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "666344059")) {
            return ((Float) ipChange.ipc$dispatch("666344059", new Object[]{this})).floatValue();
        }
        try {
            Field fieldRecursively = getFieldRecursively("mViewFlinger");
            if (fieldRecursively == null) {
                return 0.0f;
            }
            fieldRecursively.setAccessible(true);
            Object obj = fieldRecursively.get(this);
            Field declaredField = obj.getClass().getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            Field declaredField2 = obj2.getClass().getDeclaredField("mScrollerY");
            declaredField2.setAccessible(true);
            Object obj3 = declaredField2.get(obj2);
            Field declaredField3 = obj3.getClass().getDeclaredField("mCurrVelocity");
            declaredField3.setAccessible(true);
            return ((Float) declaredField3.get(obj3)).floatValue();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAccepted(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-623838377") ? ((Boolean) ipChange.ipc$dispatch("-623838377", new Object[]{this, Integer.valueOf(i)})).booleanValue() : isAttachedToWindow() && ((i2 = this.mDisabledDirection) == 0 || i2 * i < 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-236980365")) {
            ipChange.ipc$dispatch("-236980365", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        resetScroll();
    }

    @Override // cn.damai.homepage.nestedscroll.overscroll.IOverScroll
    public void onDisabledDirection(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "941114430")) {
            ipChange.ipc$dispatch("941114430", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mDisabledDirection = i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView.$ipChange
            java.lang.String r1 = "1762480676"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r6
            r2[r5] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            return r7
        L1e:
            int r0 = r7.getAction()
            if (r0 == 0) goto L67
            if (r0 == r5) goto L64
            if (r0 == r3) goto L2c
            r1 = 3
            if (r0 == r1) goto L64
            goto L75
        L2c:
            float r0 = r6.mLastMotionY
            float r1 = r7.getRawY()
            float r0 = r0 - r1
            float r1 = r6.mLastMotionX
            float r2 = r7.getRawX()
            float r1 = r1 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r7.getRawY()
            r6.mLastMotionY = r2
            float r2 = r7.getRawX()
            r6.mLastMotionX = r2
            r2 = 933741996(0x37a7c5ac, float:2.0E-5)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L75
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L75
            boolean r0 = r6.mInterceptTouch
            if (r0 != 0) goto L75
            int r0 = r6.mDisabledDirection
            if (r0 == 0) goto L75
            r6.mEatInterceptTouch = r4
            goto L75
        L64:
            r6.mEatInterceptTouch = r5
            goto L75
        L67:
            r6.mEatInterceptTouch = r5
            float r0 = r7.getRawY()
            r6.mLastMotionY = r0
            float r0 = r7.getRawX()
            r6.mLastMotionX = r0
        L75:
            boolean r0 = r6.mEatInterceptTouch
            if (r0 != 0) goto L7a
            return r4
        L7a:
            boolean r7 = super.onInterceptTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public void onScrolledByNestedParent(NestedScrollParent nestedScrollParent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-294297757")) {
            ipChange.ipc$dispatch("-294297757", new Object[]{this, nestedScrollParent});
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView.$ipChange
            java.lang.String r1 = "-1910230400"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L1e
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r7
            r2[r5] = r8
            java.lang.Object r8 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            return r8
        L1e:
            int r0 = r8.getAction()
            if (r0 == 0) goto L8a
            if (r0 == r5) goto L87
            if (r0 == r3) goto L2c
            r1 = 3
            if (r0 == r1) goto L87
            goto L98
        L2c:
            float r0 = r7.mLastMotionY
            float r1 = r8.getRawY()
            float r0 = r0 - r1
            float r1 = r7.mLastMotionX
            float r2 = r8.getRawX()
            float r1 = r1 - r2
            float r2 = java.lang.Math.abs(r0)
            float r3 = r8.getRawY()
            r7.mLastMotionY = r3
            float r3 = r8.getRawX()
            r7.mLastMotionX = r3
            r3 = 933741996(0x37a7c5ac, float:2.0E-5)
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 <= 0) goto L98
            float r1 = java.lang.Math.abs(r1)
            float r2 = r2 - r1
            int r1 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r1 <= 0) goto L98
            boolean r1 = r7.mInterceptTouch
            if (r1 != 0) goto L7b
            int r1 = r7.mDisabledDirection
            if (r1 == 0) goto L7b
            boolean r2 = r7.mEatTouchEvent
            if (r2 == 0) goto L6f
            float r1 = (float) r1
            float r1 = r1 * r0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L6f
            r7.mEatTouchEvent = r4
        L6f:
            boolean r1 = r7.mEatTouchEvent
            if (r1 != 0) goto L98
            int r0 = java.lang.Math.round(r0)
            r7.onReachedEdge(r0, r4)
            goto L98
        L7b:
            boolean r1 = r7.mEatTouchEvent
            if (r1 != 0) goto L98
            int r0 = java.lang.Math.round(r0)
            r7.dispatchNestedScroll(r0)
            goto L98
        L87:
            r7.mEatTouchEvent = r5
            goto L98
        L8a:
            r7.mEatTouchEvent = r5
            float r0 = r8.getRawY()
            r7.mLastMotionY = r0
            float r0 = r8.getRawX()
            r7.mLastMotionX = r0
        L98:
            boolean r0 = r7.mEatTouchEvent
            if (r0 != 0) goto L9d
            return r5
        L9d:
            boolean r8 = super.onTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.nestedscroll.recyclerview.AbstractRecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void resetScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1738342483")) {
            ipChange.ipc$dispatch("-1738342483", new Object[]{this});
            return;
        }
        this.mInterceptTouch = true;
        this.mDisabledDirection = 0;
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollParent
    public void setNestedScrollChild(NestedScrollChild nestedScrollChild) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "399739348")) {
            ipChange.ipc$dispatch("399739348", new Object[]{this, nestedScrollChild});
        }
    }

    @Override // cn.damai.homepage.nestedscroll.nestedinterface.NestedScrollChild
    public void setNestedScrollParent(NestedScrollParent nestedScrollParent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934178984")) {
            ipChange.ipc$dispatch("1934178984", new Object[]{this, nestedScrollParent});
        }
    }

    public AbstractRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterceptTouch = true;
        this.mEatInterceptTouch = true;
        this.mEatTouchEvent = true;
    }

    public AbstractRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInterceptTouch = true;
        this.mEatInterceptTouch = true;
        this.mEatTouchEvent = true;
    }
}
