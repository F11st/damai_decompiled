package cn.damai.uikit.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class PagerIndicator extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean allowWidthFull;
    private int bottomLineColor;
    private int bottomLineHeight;
    private Paint bottomLinePaint;
    private int currentPosition;
    private float currentPositionOffset;
    private boolean disableTensileSlidingBlock;
    private boolean disableViewPager;
    private int lastOffset;
    private int lastScrollX;
    private OnClickTabListener onClickTabListener;
    private OnDoubleClickTabListener onDoubleClickTabListener;
    private ViewPager.OnPageChangeListener onPageChangeListener;
    private final PageChangedListener pageChangedListener;
    private final ViewTreeObserver$OnGlobalLayoutListenerC2501c setSelectedTabListener;
    private Drawable slidingBlockDrawable;
    private boolean start;
    private final View$OnClickListenerC2502d tabViewClickListener;
    private final View$OnTouchListenerC2500b tabViewDoubleClickGestureDetector;
    private TabViewFactory tabViewFactory;
    private List<View> tabViews;
    private ViewGroup tabsLayout;
    private ViewPager viewPager;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnClickTabListener {
        void onClickTab(View view, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnDoubleClickTabListener {
        void onDoubleClickTab(View view, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class PageChangedListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private PageChangedListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1317003931")) {
                ipChange.ipc$dispatch("1317003931", new Object[]{this, Integer.valueOf(i)});
            } else if (PagerIndicator.this.onPageChangeListener != null) {
                PagerIndicator.this.onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            View childAt;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1384397370")) {
                ipChange.ipc$dispatch("1384397370", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                return;
            }
            ViewGroup tabsLayout = PagerIndicator.this.getTabsLayout();
            if (i < tabsLayout.getChildCount() && (childAt = tabsLayout.getChildAt(i)) != null) {
                PagerIndicator.this.currentPosition = i;
                PagerIndicator.this.currentPositionOffset = f;
                PagerIndicator.this.scrollToChild(i, (int) ((childAt.getWidth() + PagerIndicator.this.getLeftMargin(childAt) + PagerIndicator.this.getRightMargin(childAt)) * f));
                PagerIndicator.this.invalidate();
            }
            if (PagerIndicator.this.onPageChangeListener != null) {
                PagerIndicator.this.onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1683867738")) {
                ipChange.ipc$dispatch("-1683867738", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            PagerIndicator.this.selectedTab(i);
            if (PagerIndicator.this.onPageChangeListener != null) {
                PagerIndicator.this.onPageChangeListener.onPageSelected(i);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface TabViewFactory {
        void addTabs(ViewGroup viewGroup, int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.indicator.PagerIndicator$b */
    /* loaded from: classes17.dex */
    public class View$OnTouchListenerC2500b extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private GestureDetector a;
        private View b;

        public View$OnTouchListenerC2500b(Context context) {
            GestureDetector gestureDetector = new GestureDetector(context, this);
            this.a = gestureDetector;
            gestureDetector.setOnDoubleTapListener(this);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2079525229")) {
                return ((Boolean) ipChange.ipc$dispatch("-2079525229", new Object[]{this, motionEvent})).booleanValue();
            }
            if (PagerIndicator.this.onDoubleClickTabListener != null) {
                OnDoubleClickTabListener onDoubleClickTabListener = PagerIndicator.this.onDoubleClickTabListener;
                View view = this.b;
                onDoubleClickTabListener.onDoubleClickTab(view, ((Integer) view.getTag()).intValue());
                return true;
            }
            return false;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834168994")) {
                return ((Boolean) ipChange.ipc$dispatch("-1834168994", new Object[]{this, view, motionEvent})).booleanValue();
            }
            this.b = view;
            return this.a.onTouchEvent(motionEvent);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.indicator.PagerIndicator$c */
    /* loaded from: classes17.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC2501c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private ViewTreeObserver$OnGlobalLayoutListenerC2501c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-960416123")) {
                ipChange.ipc$dispatch("-960416123", new Object[]{this});
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                PagerIndicator.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                PagerIndicator.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (PagerIndicator.this.getTabsLayout() != null) {
                PagerIndicator pagerIndicator = PagerIndicator.this;
                pagerIndicator.currentPosition = pagerIndicator.viewPager != null ? PagerIndicator.this.viewPager.getCurrentItem() : 0;
                if (PagerIndicator.this.disableViewPager) {
                    return;
                }
                PagerIndicator pagerIndicator2 = PagerIndicator.this;
                pagerIndicator2.scrollToChild(pagerIndicator2.currentPosition, 0);
                PagerIndicator pagerIndicator3 = PagerIndicator.this;
                pagerIndicator3.selectedTab(pagerIndicator3.currentPosition);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.indicator.PagerIndicator$d */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2502d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private View$OnClickListenerC2502d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1520272312")) {
                ipChange.ipc$dispatch("1520272312", new Object[]{this, view});
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (PagerIndicator.this.onClickTabListener != null) {
                PagerIndicator.this.onClickTabListener.onClickTab(view, intValue);
            }
            if (PagerIndicator.this.viewPager != null) {
                PagerIndicator.this.viewPager.setCurrentItem(intValue, true);
            }
        }
    }

    public PagerIndicator(Context context) {
        this(context, null);
    }

    private void adjustChildWidthWithParent(List<View> list, int i, int i2, int i3) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1856479510")) {
            ipChange.ipc$dispatch("-1856479510", new Object[]{this, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        for (View view : list) {
            if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                i -= layoutParams.leftMargin + layoutParams.rightMargin;
            }
        }
        int size = i / list.size();
        int size2 = list.size();
        do {
            Iterator<View> it = list.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next.getMeasuredWidth() > size) {
                    i -= next.getMeasuredWidth();
                    size2--;
                    it.remove();
                }
            }
            if (size2 <= 0) {
                break;
            }
            size = i / size2;
            z = true;
            for (View view2 : list) {
                if (view2.getMeasuredWidth() > size) {
                    z = false;
                }
            }
        } while (!z);
        for (View view3 : list) {
            if (view3.getMeasuredWidth() < size) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                layoutParams2.width = size;
                view3.setLayoutParams(layoutParams2);
                measureChildWithMargins(view3, i2, 0, i3, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftMargin(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816226487")) {
            return ((Integer) ipChange.ipc$dispatch("1816226487", new Object[]{this, view})).intValue();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        }
        return 0;
    }

    private int getOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1126435686")) {
            return ((Integer) ipChange.ipc$dispatch("1126435686", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int i2 = this.lastOffset;
        if (i2 < i) {
            if (this.start) {
                int i3 = i2 + 1;
                this.lastOffset = i3;
                return i3;
            }
            this.start = true;
            int i4 = i2 + 1;
            this.lastOffset = i4;
            return i4;
        } else if (i2 > i) {
            if (this.start) {
                int i5 = i2 - 1;
                this.lastOffset = i5;
                return i5;
            }
            this.start = true;
            int i6 = i2 - 1;
            this.lastOffset = i6;
            return i6;
        } else {
            this.start = true;
            this.lastOffset = i;
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightMargin(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "18530344")) {
            return ((Integer) ipChange.ipc$dispatch("18530344", new Object[]{this, view})).intValue();
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup getTabsLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "478399738")) {
            return (ViewGroup) ipChange.ipc$dispatch("478399738", new Object[]{this});
        }
        if (this.tabsLayout == null) {
            if (getChildCount() > 0) {
                this.tabsLayout = (ViewGroup) getChildAt(0);
            } else {
                removeAllViews();
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setGravity(16);
                this.tabsLayout = linearLayout;
                addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 16));
            }
        }
        return this.tabsLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToChild(int i, int i2) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391237499")) {
            ipChange.ipc$dispatch("-1391237499", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ViewGroup tabsLayout = getTabsLayout();
        if (tabsLayout == null || tabsLayout.getChildCount() <= 0 || i >= tabsLayout.getChildCount() || (childAt = tabsLayout.getChildAt(i)) == null) {
            return;
        }
        int left = (childAt.getLeft() + i2) - getLeftMargin(childAt);
        if (i > 0 || i2 > 0) {
            left -= (getWidth() / 2) - (getOffset(childAt.getWidth()) / 2);
        }
        if (left != this.lastScrollX) {
            this.lastScrollX = left;
            scrollTo(left, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectedTab(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431785316")) {
            ipChange.ipc$dispatch("1431785316", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ViewGroup tabsLayout = getTabsLayout();
        if (i <= -1 || tabsLayout == null || i >= tabsLayout.getChildCount()) {
            return;
        }
        int childCount = tabsLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            tabsLayout.getChildAt(i2).setSelected(i2 == i);
            i2++;
        }
    }

    private void setTabClickEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068725652")) {
            ipChange.ipc$dispatch("-2068725652", new Object[]{this});
            return;
        }
        ViewGroup tabsLayout = getTabsLayout();
        if (tabsLayout == null || tabsLayout.getChildCount() <= 0) {
            return;
        }
        for (int i = 0; i < tabsLayout.getChildCount(); i++) {
            View childAt = tabsLayout.getChildAt(i);
            childAt.setTag(Integer.valueOf(i));
            childAt.setOnClickListener(this.tabViewClickListener);
            childAt.setOnTouchListener(this.tabViewDoubleClickGestureDetector);
        }
    }

    public Drawable getSlidingBlockDrawable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1221085356") ? (Drawable) ipChange.ipc$dispatch("-1221085356", new Object[]{this}) : this.slidingBlockDrawable;
    }

    public View getTab(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-527838125")) {
            return (View) ipChange.ipc$dispatch("-527838125", new Object[]{this, Integer.valueOf(i)});
        }
        ViewGroup viewGroup = this.tabsLayout;
        if (viewGroup == null || viewGroup.getChildCount() <= i) {
            return null;
        }
        return this.tabsLayout.getChildAt(i);
    }

    public int getTabCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1883464004")) {
            return ((Integer) ipChange.ipc$dispatch("-1883464004", new Object[]{this})).intValue();
        }
        ViewGroup tabsLayout = getTabsLayout();
        if (tabsLayout != null) {
            return tabsLayout.getChildCount();
        }
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ViewGroup tabsLayout;
        View childAt;
        View childAt2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1504805911")) {
            ipChange.ipc$dispatch("1504805911", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.bottomLineColor != -1 && this.bottomLineHeight != -1) {
            if (this.bottomLinePaint == null) {
                Paint paint = new Paint();
                this.bottomLinePaint = paint;
                paint.setColor(this.bottomLineColor);
            }
            canvas.drawRect(0.0f, getBottom() - this.bottomLineHeight, getRight(), getBottom(), this.bottomLinePaint);
        }
        if (this.disableViewPager || (tabsLayout = getTabsLayout()) == null || tabsLayout.getChildCount() <= 0 || this.slidingBlockDrawable == null || (childAt = tabsLayout.getChildAt(this.currentPosition)) == null) {
            return;
        }
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.currentPositionOffset > 0.0f && this.currentPosition < tabsLayout.getChildCount() - 1 && (childAt2 = tabsLayout.getChildAt(this.currentPosition + 1)) != null) {
            float f = this.currentPositionOffset;
            left = (childAt2.getLeft() * f) + ((1.0f - f) * left);
            right = (childAt2.getRight() * f) + ((1.0f - f) * right);
        }
        if (this.disableTensileSlidingBlock) {
            int i = (int) (left + ((right - left) / 2.0f));
            left = i - (this.slidingBlockDrawable.getIntrinsicWidth() / 2);
            right = i + (this.slidingBlockDrawable.getIntrinsicWidth() / 2);
        }
        this.slidingBlockDrawable.setBounds((int) left, getHeight() - this.slidingBlockDrawable.getIntrinsicHeight(), (int) right, getHeight());
        this.slidingBlockDrawable.draw(canvas);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ViewGroup tabsLayout;
        ViewGroup viewGroup;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516478650")) {
            ipChange.ipc$dispatch("1516478650", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (this.allowWidthFull && (viewGroup = this.tabsLayout) != null) {
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.tabsLayout.getChildAt(i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.width = -2;
                childAt.setLayoutParams(layoutParams);
            }
        }
        super.onMeasure(i, i2);
        if (this.allowWidthFull && (tabsLayout = getTabsLayout()) != null && tabsLayout.getChildCount() > 0) {
            List<View> list = this.tabViews;
            if (list == null) {
                this.tabViews = new ArrayList();
            } else {
                list.clear();
            }
            for (int i4 = 0; i4 < tabsLayout.getChildCount(); i4++) {
                this.tabViews.add(tabsLayout.getChildAt(i4));
            }
            adjustChildWidthWithParent(this.tabViews, (getMeasuredWidth() - tabsLayout.getPaddingLeft()) - tabsLayout.getPaddingRight(), i, i2);
            super.onMeasure(i, i2);
        }
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406117898")) {
            ipChange.ipc$dispatch("1406117898", new Object[]{this});
        } else if (this.tabViewFactory != null) {
            ViewGroup tabsLayout = getTabsLayout();
            TabViewFactory tabViewFactory = this.tabViewFactory;
            ViewPager viewPager = this.viewPager;
            tabViewFactory.addTabs(tabsLayout, viewPager != null ? viewPager.getCurrentItem() : 0);
            setTabClickEvent();
        }
    }

    public void setAllowWidthFull(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566545815")) {
            ipChange.ipc$dispatch("-566545815", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.allowWidthFull = z;
        requestLayout();
    }

    public void setBottomLineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "810948500")) {
            ipChange.ipc$dispatch("810948500", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.bottomLineColor = i;
        Paint paint = this.bottomLinePaint;
        if (paint != null) {
            paint.setColor(i);
        }
        postInvalidate();
    }

    public void setBottomLineHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378908494")) {
            ipChange.ipc$dispatch("-378908494", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.bottomLineHeight = i;
        postInvalidate();
    }

    public void setDisableTensileSlidingBlock(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-146340160")) {
            ipChange.ipc$dispatch("-146340160", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.disableTensileSlidingBlock = z;
        invalidate();
    }

    public void setDisableViewPager(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-145724461")) {
            ipChange.ipc$dispatch("-145724461", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.disableViewPager = z;
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this.onPageChangeListener);
            this.viewPager = null;
        }
        requestLayout();
    }

    public void setOnClickTabListener(OnClickTabListener onClickTabListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019510378")) {
            ipChange.ipc$dispatch("-2019510378", new Object[]{this, onClickTabListener});
        } else {
            this.onClickTabListener = onClickTabListener;
        }
    }

    public void setOnDoubleClickTabListener(OnDoubleClickTabListener onDoubleClickTabListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-175920332")) {
            ipChange.ipc$dispatch("-175920332", new Object[]{this, onDoubleClickTabListener});
        } else {
            this.onDoubleClickTabListener = onDoubleClickTabListener;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1576961416")) {
            ipChange.ipc$dispatch("1576961416", new Object[]{this, onPageChangeListener});
        } else {
            this.onPageChangeListener = onPageChangeListener;
        }
    }

    public void setSlidingBlockDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1325696062")) {
            ipChange.ipc$dispatch("1325696062", new Object[]{this, drawable});
            return;
        }
        this.slidingBlockDrawable = drawable;
        requestLayout();
    }

    public void setTabViewFactory(TabViewFactory tabViewFactory) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1917493898")) {
            ipChange.ipc$dispatch("-1917493898", new Object[]{this, tabViewFactory});
            return;
        }
        this.tabViewFactory = tabViewFactory;
        reset();
        getViewTreeObserver().addOnGlobalLayoutListener(this.setSelectedTabListener);
    }

    public void setViewPager(ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891897022")) {
            ipChange.ipc$dispatch("-891897022", new Object[]{this, viewPager});
        } else if (this.disableViewPager) {
        } else {
            this.viewPager = viewPager;
            viewPager.addOnPageChangeListener(this.pageChangedListener);
            setTabClickEvent();
            requestLayout();
        }
    }

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes;
        this.lastScrollX = 0;
        this.bottomLineColor = -1;
        this.bottomLineHeight = -1;
        this.pageChangedListener = new PageChangedListener();
        this.tabViewClickListener = new View$OnClickListenerC2502d();
        ViewTreeObserver$OnGlobalLayoutListenerC2501c viewTreeObserver$OnGlobalLayoutListenerC2501c = new ViewTreeObserver$OnGlobalLayoutListenerC2501c();
        this.setSelectedTabListener = viewTreeObserver$OnGlobalLayoutListenerC2501c;
        setHorizontalScrollBarEnabled(false);
        removeAllViews();
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PagerIndicator)) != null) {
            this.allowWidthFull = obtainStyledAttributes.getBoolean(R$styleable.PagerIndicator_pi_allowWidthFull, false);
            this.slidingBlockDrawable = obtainStyledAttributes.getDrawable(R$styleable.PagerIndicator_pi_slidingBlock);
            this.disableViewPager = obtainStyledAttributes.getBoolean(R$styleable.PagerIndicator_pi_disableViewPager, false);
            this.disableTensileSlidingBlock = obtainStyledAttributes.getBoolean(R$styleable.PagerIndicator_pi_disableTensileSlidingBlock, false);
            this.bottomLineColor = obtainStyledAttributes.getColor(R$styleable.PagerIndicator_pi_bottomLineColor, -1);
            this.bottomLineHeight = (int) obtainStyledAttributes.getDimension(R$styleable.PagerIndicator_pi_bottomLineHeight, -1.0f);
            obtainStyledAttributes.recycle();
        }
        this.tabViewDoubleClickGestureDetector = new View$OnTouchListenerC2500b(context);
        getViewTreeObserver().addOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListenerC2501c);
    }
}
