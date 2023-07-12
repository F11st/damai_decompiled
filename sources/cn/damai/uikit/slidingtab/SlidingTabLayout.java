package cn.damai.uikit.slidingtab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.q60;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SlidingTabLayout extends HorizontalScrollView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_HEIGHT_INDICATOR = 4;
    private static final int DEFAULT_TAB_INDICATOR_OVER_TEXT = 12;
    private static final int DEFAULT_TAB_LEFT_RIGHT_PADDING = 9;
    private static final int DEFAULT_TAB_PADDING = 24;
    private static final int DEFAULT_TAB_SCROLL_OFFSET = 80;
    private static final int DEFAULT_TAB_SELECTED_TEXT_COLOR = -60824;
    private static final int DEFAULT_TAB_TEXT_COLOR = -13355980;
    private static final int DEFAULT_TAB_TEXT_SIZE = 12;
    private static final int DEFAULT_TAB_UNDERLINE_WIDTH = 30;
    private boolean mCheckedTabWidths;
    private int mCurrentPosition;
    private LinearLayout.LayoutParams mDefaultTabLayoutParams;
    private LinearLayout.LayoutParams mExpandedTabLayoutParams;
    private Drawable mIndicatorDrawable;
    private int mIndicatorHeight;
    private boolean mIsAverage;
    private boolean mIsBoldStyle;
    private int mLastPosition;
    private OnTabItemClickListener mOnTabItemClickListener;
    private Paint mRectPaint;
    private Paint mRectPaintL;
    private int mScreenWidth;
    private int mScrolledX;
    private LinearGradient mShader;
    private boolean mShouldExpand;
    private int mTabBackgroundResId;
    private int mTabCount;
    private int mTabIndicatorOverText;
    private int mTabItemLeftAndRightPadding;
    private int mTabPaddingLeft;
    private int mTabPaddingRight;
    private int mTabScrollOffset;
    private int mTabSelectedTextColor;
    private int mTabTextColor;
    private int mTabTextSize;
    private LinearLayout mTabsContainer;
    private int mUnderLineWidth;
    private int tabTypefaceStyle;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnTabItemClickListener {
        void onTabItemClick(View view, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @SuppressLint({"NewApi"})
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-301277241")) {
                ipChange.ipc$dispatch("-301277241", new Object[]{this});
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                SlidingTabLayout.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
                SlidingTabLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            SlidingTabLayout slidingTabLayout = SlidingTabLayout.this;
            slidingTabLayout.scrollToSelectedChild(slidingTabLayout.mCurrentPosition, 0);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        b(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1057574811")) {
                ipChange.ipc$dispatch("-1057574811", new Object[]{this, view});
                return;
            }
            if (SlidingTabLayout.this.mOnTabItemClickListener != null) {
                SlidingTabLayout.this.mOnTabItemClickListener.onTabItemClick(view, this.a);
            }
            SlidingTabLayout.this.scrollToSelectedChild(this.a);
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    private void addTab(int i, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1779491161")) {
            ipChange.ipc$dispatch("1779491161", new Object[]{this, Integer.valueOf(i), str, Boolean.valueOf(z)});
            return;
        }
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextSize(0, this.mTabTextSize);
        textView.setBackgroundResource(this.mTabBackgroundResId);
        if (!z) {
            textView.setLayoutParams(this.mDefaultTabLayoutParams);
        } else {
            textView.setLayoutParams(this.mDefaultTabLayoutParams);
            int round = Math.round(textView.getPaint().measureText(str));
            if (this.mIsAverage) {
                int i2 = ((this.mScreenWidth / this.mTabCount) - round) / 2;
                this.mTabPaddingRight = i2;
                this.mTabPaddingLeft = i2;
            } else {
                int i3 = this.mTabItemLeftAndRightPadding;
                this.mTabPaddingRight = i3;
                this.mTabPaddingLeft = i3;
            }
        }
        textView.setPadding(this.mTabPaddingLeft, 0, this.mTabPaddingRight, 0);
        textView.setOnClickListener(new b(i));
        this.mTabsContainer.addView(textView);
    }

    private void initAttributes(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1993306607")) {
            ipChange.ipc$dispatch("1993306607", new Object[]{this, attributeSet});
            return;
        }
        this.mScreenWidth = ((WindowManager) getContext().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getWidth();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mIndicatorHeight = (int) TypedValue.applyDimension(1, this.mIndicatorHeight, displayMetrics);
        this.mTabPaddingLeft = (int) TypedValue.applyDimension(1, this.mTabPaddingLeft, displayMetrics);
        this.mTabPaddingRight = (int) TypedValue.applyDimension(1, this.mTabPaddingRight, displayMetrics);
        this.mTabTextSize = (int) TypedValue.applyDimension(1, this.mTabTextSize, displayMetrics);
        this.mTabItemLeftAndRightPadding = (int) TypedValue.applyDimension(1, this.mTabItemLeftAndRightPadding, displayMetrics);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.SlidingTabLayout);
        this.mTabTextSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SlidingTabLayout_tabTextSize, 12);
        this.mTabTextColor = obtainStyledAttributes.getColor(R$styleable.SlidingTabLayout_tabTextColor, DEFAULT_TAB_TEXT_COLOR);
        this.mTabSelectedTextColor = obtainStyledAttributes.getColor(R$styleable.SlidingTabLayout_tabSelectedTextColor, DEFAULT_TAB_SELECTED_TEXT_COLOR);
        this.mTabPaddingLeft = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SlidingTabLayout_tabPaddingLeft, 24);
        this.mTabPaddingRight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SlidingTabLayout_tabPaddingRight, 24);
        this.mTabScrollOffset = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SlidingTabLayout_tabScrollOffset, 80);
        this.mIndicatorDrawable = obtainStyledAttributes.getDrawable(R$styleable.SlidingTabLayout_tabHIndicatorColor);
        this.mTabIndicatorOverText = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SlidingTabLayout_tabIndicatorOverText, 12);
        this.mIndicatorHeight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SlidingTabLayout_tabIndicatorHeight, 4);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mRectPaint = paint;
        paint.setAntiAlias(true);
        this.mRectPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.mRectPaintL = paint2;
        paint2.setAntiAlias(true);
        this.mRectPaintL.setStyle(Paint.Style.FILL);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.mTabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.mTabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.mTabsContainer);
        this.mDefaultTabLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.mExpandedTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
    }

    private boolean isResetTabItems(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "322935497")) {
            return ((Boolean) ipChange.ipc$dispatch("322935497", new Object[]{this, list})).booleanValue();
        }
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setPadding(this.mTabPaddingLeft, 0, this.mTabPaddingRight, 0);
        textView.setTextSize(0, this.mTabTextSize);
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += Math.round(textView.getPaint().measureText(list.get(i2))) + this.mTabPaddingLeft + this.mTabPaddingRight;
        }
        return i <= this.mScreenWidth;
    }

    private int offsetFromCurToDestTab(int i) {
        int i2;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "944618309")) {
            return ((Integer) ipChange.ipc$dispatch("944618309", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        this.mTabsContainer.getChildAt(this.mCurrentPosition).getWidth();
        this.mTabsContainer.getChildAt(this.mCurrentPosition).getLeft();
        this.mTabsContainer.getChildAt(this.mCurrentPosition).getWidth();
        int left = this.mTabsContainer.getChildAt(i).getLeft();
        int left2 = this.mTabsContainer.getChildAt(i).getLeft() - this.mScrolledX;
        int width = this.mTabsContainer.getChildAt(i).getWidth() + left2;
        int left3 = (this.mTabsContainer.getChildAt(this.mTabCount - 1).getLeft() - this.mScrolledX) + this.mTabsContainer.getChildAt(this.mTabCount - 1).getWidth();
        if (i > this.mCurrentPosition) {
            int i5 = left3 - this.mScreenWidth;
            if (i5 > 0) {
                int i6 = this.mTabScrollOffset;
                if (left2 <= i6) {
                    i4 = this.mScrolledX;
                } else if (left2 - i6 > i5) {
                    i4 = this.mScrolledX + i5;
                } else {
                    left = this.mScrolledX + (left2 - i6);
                }
                return i4;
            }
            return left;
        }
        int i7 = this.mScrolledX;
        if (i7 > 0) {
            int i8 = this.mScreenWidth;
            if (i8 - width <= i8 / 2) {
                if (left < 0) {
                    i7 -= left;
                    i2 = this.mTabScrollOffset;
                } else {
                    i2 = this.mTabScrollOffset;
                }
                return i7 - i2;
            } else if (i7 > i8 / 2 && i7 > (i3 = this.mTabScrollOffset)) {
                if (left2 < 0) {
                    i7 -= left;
                }
                return i7 - i3;
            } else {
                return 0;
            }
        }
        return 0;
    }

    private void resetTabItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "453142602")) {
            ipChange.ipc$dispatch("453142602", new Object[]{this});
            return;
        }
        for (int i = 0; i < this.mTabCount; i++) {
            TextView textView = (TextView) this.mTabsContainer.getChildAt(i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.weight = 1.0f;
            layoutParams.weight = -1.0f;
            textView.setLayoutParams(layoutParams);
        }
    }

    private void setTabTextColor(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951920686")) {
            ipChange.ipc$dispatch("-951920686", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        TextView textView = (TextView) this.mTabsContainer.getChildAt(i);
        if (z) {
            if (textView != null) {
                textView.setTextColor(this.mTabSelectedTextColor);
                if (this.mIsBoldStyle) {
                    textView.setTypeface(Typeface.defaultFromStyle(1));
                }
            }
        } else if (textView != null) {
            textView.setTextColor(this.mTabTextColor);
            if (this.mIsBoldStyle) {
                textView.setTypeface(Typeface.defaultFromStyle(0));
            }
        }
    }

    private void setTextStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553388640")) {
            ipChange.ipc$dispatch("553388640", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.mLastPosition;
        if (i != i2) {
            if (i2 != -1) {
                setTabTextColor(i2, false);
            }
            setTabTextColor(i, true);
            this.mLastPosition = i;
            return;
        }
        setTabTextColor(i, true);
    }

    public void addTabItems(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-48192919")) {
            ipChange.ipc$dispatch("-48192919", new Object[]{this, list});
            return;
        }
        this.mTabsContainer.removeAllViews();
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mTabCount = list.size();
        boolean isResetTabItems = isResetTabItems(list);
        for (int i = 0; i < this.mTabCount; i++) {
            addTab(i, list.get(i), isResetTabItems);
        }
        setTextStatus(this.mCurrentPosition);
        if (this.mTabsContainer.getMeasuredWidth() < this.mScreenWidth) {
            resetTabItems();
        }
        this.mCheckedTabWidths = false;
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368549314")) {
            ipChange.ipc$dispatch("368549314", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (isInEditMode() || this.mTabCount == 0) {
            return;
        }
        int height = getHeight();
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentPosition);
        float left = childAt.getLeft() + getPaddingLeft() + this.mTabPaddingLeft;
        float right = (childAt.getRight() + getPaddingRight()) - this.mTabPaddingLeft;
        int i = this.mIndicatorHeight;
        if (i <= 0 || i >= height) {
            i = (int) ((getContext().getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
        }
        int i2 = this.mTabIndicatorOverText;
        float f3 = left - i2;
        float f4 = i2 + right;
        int i3 = this.mUnderLineWidth;
        if (i3 > 0) {
            f2 = left + (((right - left) - i3) / 2.0f);
            f = i3 + f2;
        } else {
            f = f4;
            f2 = f3;
        }
        float f5 = height - i;
        float f6 = height;
        float f7 = f2;
        float f8 = f;
        LinearGradient linearGradient = new LinearGradient(f7, f5, f8, f6, -46418, (int) DEFAULT_TAB_SELECTED_TEXT_COLOR, Shader.TileMode.MIRROR);
        this.mShader = linearGradient;
        this.mRectPaintL.setShader(linearGradient);
        canvas.drawRect(f7, f5, f8, f6, this.mRectPaintL);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279852005")) {
            ipChange.ipc$dispatch("1279852005", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        if (!this.mShouldExpand || View.MeasureSpec.getMode(i) == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.mTabCount; i4++) {
            i3 += this.mTabsContainer.getChildAt(i4).getMeasuredWidth();
        }
        if (this.mCheckedTabWidths || i3 <= 0 || measuredWidth <= 0) {
            return;
        }
        if (i3 <= measuredWidth) {
            for (int i5 = 0; i5 < this.mTabCount; i5++) {
                this.mTabsContainer.getChildAt(i5).setLayoutParams(this.mExpandedTabLayoutParams);
            }
        }
        this.mCheckedTabWidths = true;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826778268")) {
            ipChange.ipc$dispatch("1826778268", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        this.mScrolledX = i;
    }

    public void scrollToSelectedChild(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1657574872")) {
            ipChange.ipc$dispatch("1657574872", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mTabCount == 0 || i == this.mCurrentPosition) {
        } else {
            scrollToSelectedChild(i, offsetFromCurToDestTab(i));
        }
    }

    public void setOnTabItemClickListener(OnTabItemClickListener onTabItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212857652")) {
            ipChange.ipc$dispatch("-1212857652", new Object[]{this, onTabItemClickListener});
        } else {
            this.mOnTabItemClickListener = onTabItemClickListener;
        }
    }

    public void setSelectedTextBoldStyle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-946584944")) {
            ipChange.ipc$dispatch("-946584944", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsBoldStyle = z;
        }
    }

    public void setSplitAverage(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579483029")) {
            ipChange.ipc$dispatch("579483029", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mIsAverage = z;
        }
    }

    public void setTabItemLeftAndRightPadding(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1623837691")) {
            ipChange.ipc$dispatch("1623837691", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mTabItemLeftAndRightPadding = q60.a(getContext(), f);
        }
    }

    public void setUnderLineWidth(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534796504")) {
            ipChange.ipc$dispatch("1534796504", new Object[]{this, Float.valueOf(f)});
        } else {
            this.mUnderLineWidth = q60.a(getContext(), f);
        }
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mShouldExpand = false;
        this.mCheckedTabWidths = false;
        this.mCurrentPosition = 0;
        this.mTabBackgroundResId = 17170445;
        this.tabTypefaceStyle = 0;
        this.mIsAverage = true;
        this.mTabItemLeftAndRightPadding = q60.a(getContext(), 9.0f);
        setFillViewport(true);
        initAttributes(attributeSet);
    }

    public void scrollToSelectedChild(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154757077")) {
            ipChange.ipc$dispatch("-154757077", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mTabCount == 0) {
        } else {
            setTabTextColor(this.mCurrentPosition, false);
            setTabTextColor(i, true);
            this.mCurrentPosition = i;
            smoothScrollTo(i2, 0);
            invalidate();
        }
    }
}
