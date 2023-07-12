package com.youku.resource.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.viewpager.widget.ViewPager;
import com.youku.resource.R;
import com.youku.resource.utils.ColorConfigureManager;
import com.youku.resource.utils.DynamicColorDefine;
import com.youku.resource.utils.StaticColorDefine;
import com.youku.resource.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKTabLayout extends HorizontalScrollView {
    public static final float PARSE_FIRST = 0.3f;
    public static final float PARSE_SECOND = 0.7f;
    public static final int POSITION_ORIGIN = 0;
    public static final String TAG = "TabLayout";
    protected int currentPosition;
    protected float currentPositionOffset;
    protected int currentX;
    protected boolean enableScroll;
    protected int mClickedPosition;
    protected LinearLayout mContainer;
    protected List mDataList;
    protected int mDividerHeight;
    protected Paint mDividerPaint;
    protected Handler mHandler;
    protected int mIndicatorColor;
    protected boolean mIsClicked;
    private int mItemWidth;
    private boolean mLightMode;
    private float mRatio;
    protected int mScreenWidth;
    private ScrollViewListener mScrollViewListener;
    protected int mSlidePadding;
    protected int mSliderBottomMargin;
    protected float mSliderCompat;
    protected int mSliderHeightMoving;
    protected int mSliderHeightStill;
    protected float mSliderWidthMax;
    protected float mSliderWidthMin;
    private List<String> mSpmList;
    private View.OnClickListener mTabClickListener;
    protected int mTextColorDef;
    protected int mTextColorSelected;
    protected int mTextSizeDef;
    protected int mTextSizeSelected;
    protected ViewPager mViewPager;
    private boolean needDrawDivider;
    protected Paint rectPaint;
    public Runnable scrollRunnable;
    protected ScrollType scrollType;
    private StringBuilder spmSb;
    private StringBuilder trackSb;
    public static final int DEFAULT_TEXT_COLOR = ColorConfigureManager.getInstance().getColorIntWithAlpha(DynamicColorDefine.YKN_SECONDARY_INFO, 0);
    public static final int LIGHT_TEXT_COLOR = ColorConfigureManager.getInstance().getColorIntWithAlpha(DynamicColorDefine.YKN_PRIMARY_INFO, 0);
    public static final int DEFAULT_BACKGROUND = ColorConfigureManager.getInstance().getColorIntWithAlpha(DynamicColorDefine.YKN_PRIMARY_BACKGROUND, 0);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum ScrollType {
        IDLE,
        TOUCH_SCROLL,
        FLING
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface ScrollViewListener {
        void onScrollChanged(ScrollType scrollType);
    }

    public YKTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int blend(float f) {
        return ColorUtils.blendARGB(this.mTextColorDef, this.mTextColorSelected, f);
    }

    private void drawDivider(Canvas canvas) {
        if (this.mLightMode && this.needDrawDivider) {
            if (this.mDividerPaint == null) {
                Paint paint = new Paint(1);
                this.mDividerPaint = paint;
                paint.setColor(Color.parseColor("#f5f5f5"));
            }
            canvas.drawRect(0.0f, getHeight() - this.mDividerHeight, this.mContainer.getMeasuredWidth(), getHeight(), this.mDividerPaint);
        }
    }

    private void drawLine(Canvas canvas) {
        View childAt;
        if (this.mContainer.getChildCount() == 0) {
            return;
        }
        int height = getHeight();
        View childAt2 = this.mContainer.getChildAt(this.currentPosition);
        if (childAt2 != null) {
            float right = (childAt2.getRight() - (childAt2.getWidth() / 2)) + getPaddingLeft();
            float f = this.mSliderWidthMin;
            float f2 = right - (f / 2.0f);
            float f3 = (f / 2.0f) + right;
            if (this.currentPositionOffset > 0.0f && this.currentPosition < this.mContainer.getChildCount() - 1 && (childAt = this.mContainer.getChildAt(this.currentPosition + 1)) != null) {
                float right2 = (childAt.getRight() - (childAt.getWidth() / 2)) + getPaddingLeft();
                float f4 = this.currentPositionOffset;
                if (f4 < 0.3f) {
                    f3 += (this.mSliderWidthMax - this.mSliderWidthMin) * (f4 / 0.3f);
                } else if (f4 >= 0.3f && f4 < 0.7f) {
                    float f5 = right2 - right;
                    float f6 = this.mSliderWidthMax;
                    f2 += ((f5 - f6) + this.mSliderWidthMin) * ((f4 - 0.3f) / 0.39999998f);
                    f3 = f6 + f2;
                } else {
                    float f7 = this.mSliderWidthMax;
                    float f8 = this.mSliderWidthMin;
                    f2 = (right2 - f7) + (f8 / 2.0f) + ((f7 - f8) * ((f4 - 0.7f) / 0.3f));
                    f3 = right2 + (f8 / 2.0f);
                }
                if (!this.mIsClicked) {
                    int blend = blend(1.0f - f4);
                    int blend2 = blend(this.currentPositionOffset);
                    TextView textView = (TextView) this.mContainer.getChildAt(this.currentPosition);
                    TextView textView2 = (TextView) this.mContainer.getChildAt(this.currentPosition + 1);
                    if (textView != null) {
                        textView.setTextColor(blend);
                    }
                    if (textView2 != null) {
                        textView2.setTextColor(blend2);
                    }
                }
            }
            if (f3 - f2 <= this.mSliderWidthMin + this.mSliderCompat) {
                this.rectPaint.setShader(null);
                int i = this.mSliderBottomMargin;
                RectF rectF = new RectF(f2, (height - i) - this.mSliderHeightStill, f3, height - i);
                int i2 = this.mSliderBottomMargin;
                canvas.drawRoundRect(rectF, i2, i2, this.rectPaint);
                return;
            }
            this.rectPaint.setShader(new LinearGradient(0.0f, 0.0f, this.mSliderWidthMax, this.mSliderHeightMoving, Color.parseColor("#ff37e8ff"), Color.parseColor("#fff586ff"), Shader.TileMode.MIRROR));
            int i3 = this.mSliderBottomMargin;
            int i4 = this.mSliderHeightStill;
            int i5 = this.mSliderHeightMoving;
            RectF rectF2 = new RectF(f2, (height - i3) - ((i4 + i5) / 2), f3, (height - i3) - ((i4 - i5) / 2));
            int i6 = this.mSliderBottomMargin;
            canvas.drawRoundRect(rectF2, i6, i6, this.rectPaint);
        }
    }

    private void init() {
        try {
            this.mSliderWidthMax = getResources().getDimensionPixelSize(R.dimen.resource_size_60);
            Resources resources = getResources();
            int i = R.dimen.resource_size_5;
            this.mSliderWidthMin = resources.getDimensionPixelSize(i);
            this.mSliderHeightStill = getResources().getDimensionPixelSize(i);
            this.mSliderHeightMoving = getResources().getDimensionPixelSize(R.dimen.resource_size_4);
            this.mSliderBottomMargin = getResources().getDimensionPixelSize(R.dimen.resource_size_3);
            Resources resources2 = getResources();
            int i2 = R.dimen.top_tabbar_text;
            this.mTextSizeDef = resources2.getDimensionPixelSize(i2);
            this.mTextSizeSelected = getResources().getDimensionPixelSize(i2);
            this.mIndicatorColor = ColorConfigureManager.getInstance().getColorIntWithAlpha(StaticColorDefine.CB_1, 0);
            this.mTextColorSelected = ColorConfigureManager.getInstance().getColorIntWithAlpha(StaticColorDefine.CB_1, 0);
            this.mTextColorDef = DEFAULT_TEXT_COLOR;
            this.mSlidePadding = getResources().getDimensionPixelSize(R.dimen.resource_size_2);
            this.mScreenWidth = Utils.getWidth(getContext());
            this.mDividerHeight = getResources().getDimensionPixelSize(R.dimen.resource_size_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void measureChildWidth(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        boolean z = true;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(this.mTextSizeDef);
        float f = 0.0f;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.resource_size_10);
        int size = list.size();
        float f2 = this.mScreenWidth - (this.mSlidePadding * 2);
        float f3 = (1.0f * f2) / size;
        int i = 0;
        while (true) {
            if (i >= size) {
                z = false;
                break;
            }
            String str = list.get(i);
            if (str != null && !TextUtils.isEmpty(str)) {
                float measureText = textPaint.measureText(str);
                if (measureText > f3) {
                    break;
                }
                f += measureText + (dimensionPixelSize * 2);
                if (f > f2) {
                    break;
                }
            }
            i++;
        }
        this.enableScroll = z;
        if (z) {
            return;
        }
        this.mItemWidth = (int) f3;
    }

    private void setTextViewClicked(TextView textView, boolean z) {
        textView.setTypeface(Typeface.DEFAULT, z ? 1 : 0);
        textView.setTextColor(z ? this.mTextColorSelected : this.mTextColorDef);
        textView.invalidate();
    }

    public void adjustPosition() {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout == null || this.mClickedPosition >= linearLayout.getChildCount()) {
            return;
        }
        scrollToPosition(this.mClickedPosition);
    }

    public void adjustTitleColor() {
        int i = 0;
        while (i < this.mContainer.getChildCount()) {
            TextView textView = (TextView) this.mContainer.getChildAt(i);
            if (textView != null) {
                setTextViewClicked(textView, i == this.mClickedPosition);
            }
            i++;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawLine(canvas);
        drawDivider(canvas);
    }

    public void onPause() {
        List<String> list = this.mSpmList;
        if (list != null) {
            list.clear();
        }
    }

    public void onResume() {
        sendUtExposeStatics();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            this.mHandler.post(this.scrollRunnable);
        } else if (action == 2) {
            ScrollType scrollType = ScrollType.TOUCH_SCROLL;
            this.scrollType = scrollType;
            ScrollViewListener scrollViewListener = this.mScrollViewListener;
            if (scrollViewListener != null) {
                scrollViewListener.onScrollChanged(scrollType);
            }
            this.mHandler.removeCallbacks(this.scrollRunnable);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollToPosition(int i) {
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout == null || i >= linearLayout.getChildCount()) {
            return;
        }
        final View childAt = this.mContainer.getChildAt(i);
        if (childAt.getWidth() > 0) {
            smoothScrollTo(childAt.getLeft() - ((this.mScreenWidth - childAt.getWidth()) / 2), 0);
            this.mHandler.postDelayed(this.scrollRunnable, 50L);
            return;
        }
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.youku.resource.widget.YKTabLayout.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                YKTabLayout.this.smoothScrollTo(childAt.getLeft() - ((YKTabLayout.this.mScreenWidth - childAt.getWidth()) / 2), 0);
                YKTabLayout yKTabLayout = YKTabLayout.this;
                yKTabLayout.mHandler.postDelayed(yKTabLayout.scrollRunnable, 50L);
                ViewTreeObserver viewTreeObserver = childAt.getViewTreeObserver();
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    public void sendUtClickStatics(int i) {
    }

    protected void sendUtExposeStatics() {
    }

    public void setClickedPosition(int i) {
        this.mClickedPosition = i;
    }

    public void setCurrentPosition(int i) {
        this.currentPosition = i;
    }

    public void setLightMode(boolean z) {
        this.mLightMode = z;
        if (z) {
            this.mTextColorDef = LIGHT_TEXT_COLOR;
            setBackgroundColor(-1);
            return;
        }
        this.mTextColorDef = DEFAULT_TEXT_COLOR;
        setBackgroundColor(DEFAULT_BACKGROUND);
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.youku.resource.widget.YKTabLayout.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    YKTabLayout yKTabLayout = YKTabLayout.this;
                    yKTabLayout.mIsClicked = false;
                    yKTabLayout.adjustTitleColor();
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                YKTabLayout yKTabLayout = YKTabLayout.this;
                yKTabLayout.currentPosition = i;
                yKTabLayout.currentPositionOffset = f;
                double d = f;
                if (d > 0.05d && d < 0.95d) {
                    yKTabLayout.mIsClicked = false;
                }
                yKTabLayout.invalidate();
                YKTabLayout yKTabLayout2 = YKTabLayout.this;
                yKTabLayout2.mHandler.postDelayed(yKTabLayout2.scrollRunnable, 50L);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                YKTabLayout.this.sendUtClickStatics(i);
                YKTabLayout yKTabLayout = YKTabLayout.this;
                yKTabLayout.mClickedPosition = i;
                yKTabLayout.scrollToPosition(i);
            }
        });
    }

    public void updateTabs(List<String> list, int i) {
        ViewGroup.LayoutParams layoutParams;
        this.mContainer.removeAllViews();
        this.mDataList = list;
        if (list != null && list.size() != 0) {
            setVisibility(0);
            setCurrentPosition(i);
            setClickedPosition(i);
            measureChildWidth(list);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    TextView textView = new TextView(getContext());
                    if (this.enableScroll) {
                        layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.resource_size_10);
                        textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    } else {
                        layoutParams = new ViewGroup.LayoutParams(this.mItemWidth, -1);
                        textView.setPadding(0, 0, 0, 0);
                    }
                    textView.setText(list.get(i2));
                    textView.setGravity(17);
                    textView.setTextSize(0, this.mTextSizeDef);
                    textView.setTextColor(this.mTextColorDef);
                    textView.setTag(list.get(i2));
                    textView.setOnClickListener(this.mTabClickListener);
                    this.mContainer.addView(textView, layoutParams);
                } catch (Exception unused) {
                    return;
                }
            }
            adjustTitleColor();
            return;
        }
        setVisibility(8);
    }

    public YKTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContainer = null;
        this.mSpmList = new ArrayList();
        this.spmSb = new StringBuilder();
        this.trackSb = new StringBuilder();
        this.enableScroll = false;
        this.currentX = -99;
        this.scrollType = ScrollType.IDLE;
        this.currentPositionOffset = 0.0f;
        this.mIsClicked = false;
        this.mClickedPosition = 0;
        this.mSliderCompat = 1.0f;
        this.mSliderWidthMin = 50.0f;
        this.mSliderWidthMax = 120.0f;
        this.mSliderHeightStill = 10;
        this.mSliderHeightMoving = 5;
        this.mSliderBottomMargin = 0;
        this.mTextColorDef = -855638017;
        this.mTextColorSelected = 2467327;
        this.mIndicatorColor = 2527999;
        this.mTextSizeDef = 40;
        this.mTextSizeSelected = 40;
        this.mSlidePadding = 0;
        this.mLightMode = false;
        this.scrollRunnable = new Runnable() { // from class: com.youku.resource.widget.YKTabLayout.1
            @Override // java.lang.Runnable
            public void run() {
                int scrollX = YKTabLayout.this.getScrollX();
                YKTabLayout yKTabLayout = YKTabLayout.this;
                if (scrollX == yKTabLayout.currentX) {
                    yKTabLayout.scrollType = ScrollType.IDLE;
                    if (yKTabLayout.mScrollViewListener != null) {
                        YKTabLayout.this.mScrollViewListener.onScrollChanged(YKTabLayout.this.scrollType);
                    }
                    YKTabLayout.this.mHandler.removeCallbacks(this);
                    return;
                }
                yKTabLayout.scrollType = ScrollType.FLING;
                if (yKTabLayout.mScrollViewListener != null) {
                    YKTabLayout.this.mScrollViewListener.onScrollChanged(YKTabLayout.this.scrollType);
                }
                YKTabLayout yKTabLayout2 = YKTabLayout.this;
                yKTabLayout2.currentX = yKTabLayout2.getScrollX();
                YKTabLayout.this.mHandler.postDelayed(this, 50L);
            }
        };
        this.mScrollViewListener = new ScrollViewListener() { // from class: com.youku.resource.widget.YKTabLayout.2
            @Override // com.youku.resource.widget.YKTabLayout.ScrollViewListener
            public void onScrollChanged(ScrollType scrollType) {
                if (scrollType == ScrollType.IDLE) {
                    YKTabLayout.this.sendUtExposeStatics();
                }
            }
        };
        this.mTabClickListener = new View.OnClickListener() { // from class: com.youku.resource.widget.YKTabLayout.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int indexOfChild = YKTabLayout.this.mContainer.indexOfChild(view);
                YKTabLayout yKTabLayout = YKTabLayout.this;
                if (indexOfChild == yKTabLayout.mClickedPosition) {
                    return;
                }
                yKTabLayout.mIsClicked = true;
                yKTabLayout.mClickedPosition = indexOfChild;
                ViewPager viewPager = yKTabLayout.mViewPager;
                if (viewPager != null) {
                    int currentItem = viewPager.getCurrentItem();
                    YKTabLayout yKTabLayout2 = YKTabLayout.this;
                    int i2 = yKTabLayout2.mClickedPosition;
                    if (currentItem != i2) {
                        yKTabLayout2.mViewPager.setCurrentItem(i2, false);
                    }
                }
                YKTabLayout.this.adjustTitleColor();
            }
        };
        this.mHandler = new Handler();
        setWillNotDraw(false);
        setBackgroundColor(DEFAULT_BACKGROUND);
        init();
        this.mContainer = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.mContainer.setPadding(this.mSlidePadding, getResources().getDimensionPixelSize(R.dimen.resource_size_2), this.mSlidePadding, 0);
        addView(this.mContainer, layoutParams);
        setHorizontalScrollBarEnabled(false);
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        this.rectPaint.setColor(this.mIndicatorColor);
    }
}
