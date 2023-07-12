package cn.damai.baseview.scrollable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.i50;
import tb.o72;
import tb.wt0;
import tb.y31;
import tb.yc2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ScrollableLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_CONSIDER_IDLE_MILLIS = 100;
    private static final long DEFAULT_IDLE_CLOSE_UP_ANIMATION = 200;
    private CanScrollVerticallyDelegate mCanScrollVerticallyDelegate;
    private CloseUpAnimatorConfigurator mCloseAnimatorConfigurator;
    private CloseUpAlgorithm mCloseUpAlgorithm;
    private final Property<ScrollableLayout, Integer> mCloseUpAnimationProperty;
    private ObjectAnimator mCloseUpAnimator;
    private CloseUpIdleAnimationTime mCloseUpIdleAnimationTime;
    private long mConsiderIdleMillis;
    private final Rect mDraggableRect;
    private View mDraggableView;
    private GestureDetector mFlingDetector;
    private final Runnable mIdleRunnable;
    private boolean mIsDraggingDraggable;
    private boolean mIsFlinging;
    private boolean mIsScrolling;
    private boolean mIsTouchOngoing;
    private int mMaxScrollY;
    private d mMotionEventHook;
    private OnScrollChangedListener mOnScrollChangedListener;
    private GestureDetector mScrollDetector;
    private final Runnable mScrollRunnable;
    private o72 mScroller;
    private boolean mSelfUpdateFling;
    private boolean mSelfUpdateScroll;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface MotionEventHookCallback {
        void apply(MotionEvent motionEvent);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements MotionEventHookCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.baseview.scrollable.ScrollableLayout.MotionEventHookCallback
        public void apply(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "937640076")) {
                ipChange.ipc$dispatch("937640076", new Object[]{this, motionEvent});
            } else {
                ScrollableLayout.super.dispatchTouchEvent(motionEvent);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b extends Property<ScrollableLayout, Integer> {
        private static transient /* synthetic */ IpChange $ipChange;

        b(ScrollableLayout scrollableLayout, Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(ScrollableLayout scrollableLayout) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1219933215") ? (Integer) ipChange.ipc$dispatch("-1219933215", new Object[]{this, scrollableLayout}) : Integer.valueOf(scrollableLayout.getScrollY());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(ScrollableLayout scrollableLayout, Integer num) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "63569777")) {
                ipChange.ipc$dispatch("63569777", new Object[]{this, scrollableLayout, num});
            } else {
                scrollableLayout.setScrollY(num.intValue());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c extends wt0 {
        private static transient /* synthetic */ IpChange $ipChange;
        private final int a;
        private final float b;

        c(Context context) {
            this.a = cn.damai.baseview.scrollable.a.a(context, 12);
            this.b = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
        }

        @Override // tb.wt0, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            int scrollY;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1875533212")) {
                return ((Boolean) ipChange.ipc$dispatch("1875533212", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            if (Math.abs(f2) >= this.b && Math.abs(f) <= Math.abs(f2) && (scrollY = ScrollableLayout.this.getScrollY()) >= 0 && scrollY <= ScrollableLayout.this.mMaxScrollY) {
                ScrollableLayout.this.mScroller.d(0, scrollY, 0, -((int) (f2 + 0.5f)), 0, 0, 0, ScrollableLayout.this.mMaxScrollY);
                if (ScrollableLayout.this.mScroller.c()) {
                    int g = ScrollableLayout.this.mScroller.g();
                    if (Math.abs(scrollY - g) < this.a) {
                        ScrollableLayout.this.mScroller.a();
                        return false;
                    }
                    if (g != scrollY && ScrollableLayout.this.mCloseUpAlgorithm != null) {
                        CloseUpAlgorithm closeUpAlgorithm = ScrollableLayout.this.mCloseUpAlgorithm;
                        ScrollableLayout scrollableLayout = ScrollableLayout.this;
                        g = closeUpAlgorithm.getFlingFinalY(scrollableLayout, g - scrollY < 0, scrollY, g, scrollableLayout.mMaxScrollY);
                        ScrollableLayout.this.mScroller.k(g);
                    }
                    return g != scrollY && ScrollableLayout.this.getNewY(g) >= 0;
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class d {
        private static transient /* synthetic */ IpChange $ipChange;
        final MotionEventHookCallback a;

        d(MotionEventHookCallback motionEventHookCallback) {
            this.a = motionEventHookCallback;
        }

        void a(MotionEvent motionEvent, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2075651498")) {
                ipChange.ipc$dispatch("-2075651498", new Object[]{this, motionEvent, Integer.valueOf(i)});
                return;
            }
            int action = motionEvent.getAction();
            motionEvent.setAction(i);
            this.a.apply(motionEvent);
            motionEvent.setAction(action);
        }
    }

    public ScrollableLayout(Context context) {
        super(context);
        this.mDraggableRect = new Rect();
        this.mScrollRunnable = new Runnable() { // from class: cn.damai.baseview.scrollable.ScrollableLayout.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-595021287")) {
                    ipChange.ipc$dispatch("-595021287", new Object[]{this});
                    return;
                }
                boolean c2 = ScrollableLayout.this.mScroller.c();
                ScrollableLayout.this.mSelfUpdateFling = c2;
                if (c2) {
                    int f = ScrollableLayout.this.mScroller.f() - ScrollableLayout.this.getScrollY();
                    if (f != 0) {
                        ScrollableLayout.this.scrollBy(0, f);
                    }
                    ScrollableLayout.this.post(this);
                }
            }
        };
        this.mIdleRunnable = new Runnable() { // from class: cn.damai.baseview.scrollable.ScrollableLayout.3
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.baseview.scrollable.ScrollableLayout$3$a */
            /* loaded from: classes.dex */
            public class a extends AnimatorListenerAdapter {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "666469748")) {
                        ipChange.ipc$dispatch("666469748", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2049362491")) {
                        ipChange.ipc$dispatch("2049362491", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "897930452")) {
                        ipChange.ipc$dispatch("897930452", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = true;
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int scrollY;
                long j;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-791534792")) {
                    ipChange.ipc$dispatch("-791534792", new Object[]{this});
                    return;
                }
                ScrollableLayout.this.cancelIdleAnimationIfRunning(false);
                if (ScrollableLayout.this.mSelfUpdateScroll || ScrollableLayout.this.mSelfUpdateFling || (scrollY = ScrollableLayout.this.getScrollY()) == 0 || scrollY == ScrollableLayout.this.mMaxScrollY) {
                    return;
                }
                CloseUpAlgorithm closeUpAlgorithm = ScrollableLayout.this.mCloseUpAlgorithm;
                ScrollableLayout scrollableLayout = ScrollableLayout.this;
                int idleFinalY = closeUpAlgorithm.getIdleFinalY(scrollableLayout, scrollY, scrollableLayout.mMaxScrollY);
                if (scrollY == idleFinalY) {
                    return;
                }
                ScrollableLayout scrollableLayout2 = ScrollableLayout.this;
                scrollableLayout2.mCloseUpAnimator = ObjectAnimator.ofInt(scrollableLayout2, scrollableLayout2.mCloseUpAnimationProperty, scrollY, idleFinalY);
                if (ScrollableLayout.this.mCloseUpIdleAnimationTime != null) {
                    CloseUpIdleAnimationTime closeUpIdleAnimationTime = ScrollableLayout.this.mCloseUpIdleAnimationTime;
                    ScrollableLayout scrollableLayout3 = ScrollableLayout.this;
                    j = closeUpIdleAnimationTime.compute(scrollableLayout3, scrollY, idleFinalY, scrollableLayout3.mMaxScrollY);
                } else {
                    j = ScrollableLayout.DEFAULT_IDLE_CLOSE_UP_ANIMATION;
                }
                ScrollableLayout.this.mCloseUpAnimator.setDuration(j);
                ScrollableLayout.this.mCloseUpAnimator.addListener(new a());
                if (ScrollableLayout.this.mCloseAnimatorConfigurator != null) {
                    ScrollableLayout.this.mCloseAnimatorConfigurator.configure(ScrollableLayout.this.mCloseUpAnimator);
                }
                ScrollableLayout.this.mCloseUpAnimator.start();
            }
        };
        this.mCloseUpAnimationProperty = new b(this, Integer.class, "scrollY");
        init(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelIdleAnimationIfRunning(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "775087272")) {
            ipChange.ipc$dispatch("775087272", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            removeCallbacks(this.mIdleRunnable);
        }
        ObjectAnimator objectAnimator = this.mCloseUpAnimator;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.mCloseUpAnimator.cancel();
    }

    private void init(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "126010670")) {
            ipChange.ipc$dispatch("126010670", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollableLayout);
        try {
            this.mScroller = initScroller(context, null, obtainStyledAttributes.getBoolean(R$styleable.ScrollableLayout_scrollable_scrollerFlywheel, false));
            float f = obtainStyledAttributes.getFloat(R$styleable.ScrollableLayout_scrollable_friction, Float.NaN);
            if (f == f) {
                setFriction(f);
            }
            this.mMaxScrollY = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollableLayout_scrollable_maxScroll, 0);
            setConsiderIdleMillis(obtainStyledAttributes.getInteger(R$styleable.ScrollableLayout_scrollable_considerIdleMillis, 100));
            if (obtainStyledAttributes.getBoolean(R$styleable.ScrollableLayout_scrollable_defaultCloseUp, false)) {
                setCloseUpAlgorithm(new i50());
            }
            int integer = obtainStyledAttributes.getInteger(R$styleable.ScrollableLayout_scrollable_closeUpAnimationMillis, -1);
            if (integer != -1) {
                setCloseUpIdleAnimationTime(new yc2(integer));
            }
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.ScrollableLayout_scrollable_closeUpAnimatorInterpolator, 0);
            if (resourceId != 0) {
                setCloseAnimatorConfigurator(new y31(AnimationUtils.loadInterpolator(context, resourceId)));
            }
            obtainStyledAttributes.recycle();
            setVerticalScrollBarEnabled(true);
            this.mScrollDetector = new GestureDetector(context, new e(this, null));
            this.mFlingDetector = new GestureDetector(context, new c(context));
            this.mMotionEventHook = new d(new a());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677022994")) {
            ipChange.ipc$dispatch("-1677022994", new Object[]{this});
        } else if (this.mScroller.c()) {
            int scrollY = getScrollY();
            int f = this.mScroller.f();
            scrollTo(0, f);
            if (scrollY != f) {
                onScrollChanged(0, getScrollY(), 0, scrollY);
            }
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-635090328") ? ((Integer) ipChange.ipc$dispatch("-635090328", new Object[]{this})).intValue() : this.mMaxScrollY;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042097860")) {
            return ((Boolean) ipChange.ipc$dispatch("-1042097860", new Object[]{this, motionEvent})).booleanValue();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mIsTouchOngoing = true;
            this.mScroller.a();
            View view = this.mDraggableView;
            if (view != null && view.getGlobalVisibleRect(this.mDraggableRect)) {
                this.mIsDraggingDraggable = this.mDraggableRect.contains((int) (motionEvent.getRawX() + 0.5f), (int) (motionEvent.getRawY() + 0.5f));
            } else {
                this.mIsDraggingDraggable = false;
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.mIsTouchOngoing = false;
            if (this.mCloseUpAlgorithm != null) {
                removeCallbacks(this.mIdleRunnable);
                postDelayed(this.mIdleRunnable, this.mConsiderIdleMillis);
            }
        }
        boolean z = this.mIsScrolling;
        boolean z2 = this.mIsFlinging;
        this.mIsFlinging = this.mFlingDetector.onTouchEvent(motionEvent);
        this.mIsScrolling = this.mScrollDetector.onTouchEvent(motionEvent);
        removeCallbacks(this.mScrollRunnable);
        post(this.mScrollRunnable);
        boolean z3 = this.mIsScrolling || this.mIsFlinging;
        boolean z4 = z || z2;
        boolean z5 = actionMasked == 2 && !z3 && z4 && getScrollY() == this.mMaxScrollY;
        if (z3 || z4) {
            this.mMotionEventHook.a(motionEvent, 3);
            if (!z4) {
                return true;
            }
        }
        if (z5) {
            this.mMotionEventHook.a(motionEvent, 0);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public long getConsiderIdleMillis() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "34167773") ? ((Long) ipChange.ipc$dispatch("34167773", new Object[]{this})).longValue() : this.mConsiderIdleMillis;
    }

    public int getMaxScrollY() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1947023207") ? ((Integer) ipChange.ipc$dispatch("1947023207", new Object[]{this})).intValue() : this.mMaxScrollY;
    }

    protected int getNewY(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986229715")) {
            return ((Integer) ipChange.ipc$dispatch("1986229715", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int scrollY = getScrollY();
        if (scrollY == i) {
            return -1;
        }
        int i2 = i - scrollY;
        boolean z = i2 < 0;
        CanScrollVerticallyDelegate canScrollVerticallyDelegate = this.mCanScrollVerticallyDelegate;
        if (canScrollVerticallyDelegate != null) {
            if (z) {
                if (!this.mIsDraggingDraggable && !this.mSelfUpdateScroll && canScrollVerticallyDelegate.canScrollVertically(i2)) {
                    return -1;
                }
            } else if (scrollY == this.mMaxScrollY && !canScrollVerticallyDelegate.canScrollVertically(i2)) {
                return -1;
            }
        }
        if (i < 0) {
            return 0;
        }
        int i3 = this.mMaxScrollY;
        return i > i3 ? i3 : i;
    }

    protected o72 initScroller(Context context, Interpolator interpolator, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "572019471") ? (o72) ipChange.ipc$dispatch("572019471", new Object[]{this, context, interpolator, Boolean.valueOf(z)}) : new o72(context, interpolator, z);
    }

    protected boolean isSelfUpdateScroll() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1649873040") ? ((Boolean) ipChange.ipc$dispatch("1649873040", new Object[]{this})).booleanValue() : this.mSelfUpdateScroll;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "740953605")) {
            ipChange.ipc$dispatch("740953605", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            childAt.layout(i, i5, i3, childAt.getMeasuredHeight() + i5);
            i5 += childAt.getMeasuredHeight();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-197867544")) {
            ipChange.ipc$dispatch("-197867544", new Object[]{this, parcelable});
        } else if (!(parcelable instanceof ScrollableLayoutSavedState)) {
            super.onRestoreInstanceState(parcelable);
        } else {
            ScrollableLayoutSavedState scrollableLayoutSavedState = (ScrollableLayoutSavedState) parcelable;
            super.onRestoreInstanceState(scrollableLayoutSavedState.getSuperState());
            setScrollY(scrollableLayoutSavedState.scrollY);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "976806581")) {
            return (Parcelable) ipChange.ipc$dispatch("976806581", new Object[]{this});
        }
        ScrollableLayoutSavedState scrollableLayoutSavedState = new ScrollableLayoutSavedState(super.onSaveInstanceState());
        scrollableLayoutSavedState.scrollY = getScrollY();
        return scrollableLayoutSavedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        OnScrollChangedListener onScrollChangedListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1003083082")) {
            ipChange.ipc$dispatch("1003083082", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        boolean z = i2 != i4;
        if (z && (onScrollChangedListener = this.mOnScrollChangedListener) != null) {
            onScrollChangedListener.onScrollChanged(i2, i4, this.mMaxScrollY);
        }
        if (this.mCloseUpAlgorithm != null) {
            removeCallbacks(this.mIdleRunnable);
            if (this.mSelfUpdateScroll || !z || this.mIsTouchOngoing) {
                return;
            }
            postDelayed(this.mIdleRunnable, this.mConsiderIdleMillis);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471527248")) {
            ipChange.ipc$dispatch("-471527248", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int newY = getNewY(i2);
        if (newY < 0) {
            return;
        }
        super.scrollTo(0, newY);
    }

    public void setCanScrollVerticallyDelegate(CanScrollVerticallyDelegate canScrollVerticallyDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1426283689")) {
            ipChange.ipc$dispatch("1426283689", new Object[]{this, canScrollVerticallyDelegate});
        } else {
            this.mCanScrollVerticallyDelegate = canScrollVerticallyDelegate;
        }
    }

    public void setCloseAnimatorConfigurator(CloseUpAnimatorConfigurator closeUpAnimatorConfigurator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549238960")) {
            ipChange.ipc$dispatch("1549238960", new Object[]{this, closeUpAnimatorConfigurator});
        } else {
            this.mCloseAnimatorConfigurator = closeUpAnimatorConfigurator;
        }
    }

    public void setCloseUpAlgorithm(CloseUpAlgorithm closeUpAlgorithm) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "442266471")) {
            ipChange.ipc$dispatch("442266471", new Object[]{this, closeUpAlgorithm});
        } else {
            this.mCloseUpAlgorithm = closeUpAlgorithm;
        }
    }

    public void setCloseUpIdleAnimationTime(CloseUpIdleAnimationTime closeUpIdleAnimationTime) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685904679")) {
            ipChange.ipc$dispatch("685904679", new Object[]{this, closeUpIdleAnimationTime});
        } else {
            this.mCloseUpIdleAnimationTime = closeUpIdleAnimationTime;
        }
    }

    public void setConsiderIdleMillis(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902523399")) {
            ipChange.ipc$dispatch("1902523399", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mConsiderIdleMillis = j;
        }
    }

    public void setDraggableView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1716770282")) {
            ipChange.ipc$dispatch("1716770282", new Object[]{this, view});
        } else {
            this.mDraggableView = view;
        }
    }

    public void setFriction(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-311429910")) {
            ipChange.ipc$dispatch("-311429910", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mScroller.l(f);
        }
    }

    public void setMaxScrollY(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-711945701")) {
            ipChange.ipc$dispatch("-711945701", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mMaxScrollY = i;
        }
    }

    public void setOnScrollChangedListener(OnScrollChangedListener onScrollChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76638587")) {
            ipChange.ipc$dispatch("76638587", new Object[]{this, onScrollChangedListener});
        } else {
            this.mOnScrollChangedListener = onScrollChangedListener;
        }
    }

    protected void setSelfUpdateScroll(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1886121370")) {
            ipChange.ipc$dispatch("-1886121370", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mSelfUpdateScroll = z;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ScrollableLayoutSavedState extends View.BaseSavedState {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ScrollableLayoutSavedState> CREATOR = new a();
        int scrollY;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public static final class a implements Parcelable.Creator<ScrollableLayoutSavedState> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ScrollableLayoutSavedState createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "451894475") ? (ScrollableLayoutSavedState) ipChange.ipc$dispatch("451894475", new Object[]{this, parcel}) : new ScrollableLayoutSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ScrollableLayoutSavedState[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-520664538") ? (ScrollableLayoutSavedState[]) ipChange.ipc$dispatch("-520664538", new Object[]{this, Integer.valueOf(i)}) : new ScrollableLayoutSavedState[i];
            }
        }

        public ScrollableLayoutSavedState(Parcel parcel) {
            super(parcel);
            this.scrollY = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "597460548")) {
                ipChange.ipc$dispatch("597460548", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scrollY);
        }

        public ScrollableLayoutSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e extends wt0 {
        private static transient /* synthetic */ IpChange $ipChange;
        private final int a;

        private e() {
            this.a = ViewConfiguration.get(ScrollableLayout.this.getContext()).getScaledTouchSlop();
        }

        @Override // tb.wt0, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-282835866")) {
                return ((Boolean) ipChange.ipc$dispatch("-282835866", new Object[]{this, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
            }
            float abs = Math.abs(f);
            if (abs > Math.abs(f2) || abs > this.a) {
                return false;
            }
            int scrollY = ScrollableLayout.this.getScrollY();
            ScrollableLayout.this.scrollBy(0, (int) (f2 + 0.5f));
            return scrollY != ScrollableLayout.this.getScrollY();
        }

        /* synthetic */ e(ScrollableLayout scrollableLayout, a aVar) {
            this();
        }
    }

    public ScrollableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDraggableRect = new Rect();
        this.mScrollRunnable = new Runnable() { // from class: cn.damai.baseview.scrollable.ScrollableLayout.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-595021287")) {
                    ipChange.ipc$dispatch("-595021287", new Object[]{this});
                    return;
                }
                boolean c2 = ScrollableLayout.this.mScroller.c();
                ScrollableLayout.this.mSelfUpdateFling = c2;
                if (c2) {
                    int f = ScrollableLayout.this.mScroller.f() - ScrollableLayout.this.getScrollY();
                    if (f != 0) {
                        ScrollableLayout.this.scrollBy(0, f);
                    }
                    ScrollableLayout.this.post(this);
                }
            }
        };
        this.mIdleRunnable = new Runnable() { // from class: cn.damai.baseview.scrollable.ScrollableLayout.3
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.baseview.scrollable.ScrollableLayout$3$a */
            /* loaded from: classes.dex */
            public class a extends AnimatorListenerAdapter {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "666469748")) {
                        ipChange.ipc$dispatch("666469748", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2049362491")) {
                        ipChange.ipc$dispatch("2049362491", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "897930452")) {
                        ipChange.ipc$dispatch("897930452", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = true;
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int scrollY;
                long j;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-791534792")) {
                    ipChange.ipc$dispatch("-791534792", new Object[]{this});
                    return;
                }
                ScrollableLayout.this.cancelIdleAnimationIfRunning(false);
                if (ScrollableLayout.this.mSelfUpdateScroll || ScrollableLayout.this.mSelfUpdateFling || (scrollY = ScrollableLayout.this.getScrollY()) == 0 || scrollY == ScrollableLayout.this.mMaxScrollY) {
                    return;
                }
                CloseUpAlgorithm closeUpAlgorithm = ScrollableLayout.this.mCloseUpAlgorithm;
                ScrollableLayout scrollableLayout = ScrollableLayout.this;
                int idleFinalY = closeUpAlgorithm.getIdleFinalY(scrollableLayout, scrollY, scrollableLayout.mMaxScrollY);
                if (scrollY == idleFinalY) {
                    return;
                }
                ScrollableLayout scrollableLayout2 = ScrollableLayout.this;
                scrollableLayout2.mCloseUpAnimator = ObjectAnimator.ofInt(scrollableLayout2, scrollableLayout2.mCloseUpAnimationProperty, scrollY, idleFinalY);
                if (ScrollableLayout.this.mCloseUpIdleAnimationTime != null) {
                    CloseUpIdleAnimationTime closeUpIdleAnimationTime = ScrollableLayout.this.mCloseUpIdleAnimationTime;
                    ScrollableLayout scrollableLayout3 = ScrollableLayout.this;
                    j = closeUpIdleAnimationTime.compute(scrollableLayout3, scrollY, idleFinalY, scrollableLayout3.mMaxScrollY);
                } else {
                    j = ScrollableLayout.DEFAULT_IDLE_CLOSE_UP_ANIMATION;
                }
                ScrollableLayout.this.mCloseUpAnimator.setDuration(j);
                ScrollableLayout.this.mCloseUpAnimator.addListener(new a());
                if (ScrollableLayout.this.mCloseAnimatorConfigurator != null) {
                    ScrollableLayout.this.mCloseAnimatorConfigurator.configure(ScrollableLayout.this.mCloseUpAnimator);
                }
                ScrollableLayout.this.mCloseUpAnimator.start();
            }
        };
        this.mCloseUpAnimationProperty = new b(this, Integer.class, "scrollY");
        init(context, attributeSet);
    }

    public ScrollableLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDraggableRect = new Rect();
        this.mScrollRunnable = new Runnable() { // from class: cn.damai.baseview.scrollable.ScrollableLayout.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-595021287")) {
                    ipChange.ipc$dispatch("-595021287", new Object[]{this});
                    return;
                }
                boolean c2 = ScrollableLayout.this.mScroller.c();
                ScrollableLayout.this.mSelfUpdateFling = c2;
                if (c2) {
                    int f = ScrollableLayout.this.mScroller.f() - ScrollableLayout.this.getScrollY();
                    if (f != 0) {
                        ScrollableLayout.this.scrollBy(0, f);
                    }
                    ScrollableLayout.this.post(this);
                }
            }
        };
        this.mIdleRunnable = new Runnable() { // from class: cn.damai.baseview.scrollable.ScrollableLayout.3
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.baseview.scrollable.ScrollableLayout$3$a */
            /* loaded from: classes.dex */
            public class a extends AnimatorListenerAdapter {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "666469748")) {
                        ipChange.ipc$dispatch("666469748", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "2049362491")) {
                        ipChange.ipc$dispatch("2049362491", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = false;
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "897930452")) {
                        ipChange.ipc$dispatch("897930452", new Object[]{this, animator});
                    } else {
                        ScrollableLayout.this.mSelfUpdateScroll = true;
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int scrollY;
                long j;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-791534792")) {
                    ipChange.ipc$dispatch("-791534792", new Object[]{this});
                    return;
                }
                ScrollableLayout.this.cancelIdleAnimationIfRunning(false);
                if (ScrollableLayout.this.mSelfUpdateScroll || ScrollableLayout.this.mSelfUpdateFling || (scrollY = ScrollableLayout.this.getScrollY()) == 0 || scrollY == ScrollableLayout.this.mMaxScrollY) {
                    return;
                }
                CloseUpAlgorithm closeUpAlgorithm = ScrollableLayout.this.mCloseUpAlgorithm;
                ScrollableLayout scrollableLayout = ScrollableLayout.this;
                int idleFinalY = closeUpAlgorithm.getIdleFinalY(scrollableLayout, scrollY, scrollableLayout.mMaxScrollY);
                if (scrollY == idleFinalY) {
                    return;
                }
                ScrollableLayout scrollableLayout2 = ScrollableLayout.this;
                scrollableLayout2.mCloseUpAnimator = ObjectAnimator.ofInt(scrollableLayout2, scrollableLayout2.mCloseUpAnimationProperty, scrollY, idleFinalY);
                if (ScrollableLayout.this.mCloseUpIdleAnimationTime != null) {
                    CloseUpIdleAnimationTime closeUpIdleAnimationTime = ScrollableLayout.this.mCloseUpIdleAnimationTime;
                    ScrollableLayout scrollableLayout3 = ScrollableLayout.this;
                    j = closeUpIdleAnimationTime.compute(scrollableLayout3, scrollY, idleFinalY, scrollableLayout3.mMaxScrollY);
                } else {
                    j = ScrollableLayout.DEFAULT_IDLE_CLOSE_UP_ANIMATION;
                }
                ScrollableLayout.this.mCloseUpAnimator.setDuration(j);
                ScrollableLayout.this.mCloseUpAnimator.addListener(new a());
                if (ScrollableLayout.this.mCloseAnimatorConfigurator != null) {
                    ScrollableLayout.this.mCloseAnimatorConfigurator.configure(ScrollableLayout.this.mCloseUpAnimator);
                }
                ScrollableLayout.this.mCloseUpAnimator.start();
            }
        };
        this.mCloseUpAnimationProperty = new b(this, Integer.class, "scrollY");
        init(context, attributeSet);
    }
}
