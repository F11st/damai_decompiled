package com.youku.resource.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.youku.resource.R;
import com.youku.resource.utils.AtmosphereColorConst;
import com.youku.resource.utils.SkinUtils;
import java.util.ArrayList;
import java.util.List;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKTitleTabIndicatorRv extends RecyclerView {
    private static final int LAST_ITEM = 65536;
    public static final float PARSE_FIRST = 0.3f;
    public static final float PARSE_SECOND = 0.7f;
    public static final int POSITION_ORIGIN = 0;
    public static final String TAG = "YKTitleTabIndicator";
    protected boolean ableTextAnim;
    protected int currentPosition;
    protected float currentPositionOffset;
    protected int currentX;
    private int dataSize;
    protected boolean enableSmoothScroll;
    protected boolean isDefaultColor;
    protected int itemViewLayout;
    protected int leftEndPadding;
    protected YKTitleTabIndicatorAdapter mAdapter;
    protected int mClickedPosition;
    protected Context mContext;
    protected List mDataList;
    protected Handler mHandler;
    protected int mIndicatorColor;
    protected boolean mIsClicked;
    protected YKTitleLayoutManager mLayoutManager;
    protected OnTabClickListener mOnTabClickListener;
    protected int mScreenWidth;
    protected ScrollViewListener mScrollViewListener;
    private Scroller mScroller;
    protected int mSliderBottomMargin;
    protected float mSliderCompat;
    protected int mSliderHeightMoving;
    protected int mSliderHeightStill;
    protected float mSliderWidthMax;
    protected float mSliderWidthMin;
    protected int mTextColorDef;
    protected int mTextColorSelected;
    protected int mTextSelectedBottomPadding;
    protected int mTextSizeDef;
    protected int mTextSizeSelected;
    protected ViewPager mViewPager;
    private OverScroller myScroller;
    protected int rightEndPadding;
    protected int sIndicatorColor;
    protected int sTextColorDef;
    protected int sTextColorSelected;
    protected int scrollAnimDuring;
    public Runnable scrollRunnable;
    protected ScrollType scrollType;
    protected YKTitleTabItemViewRv selectedItemView;
    protected int textAnimDuring;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class CenterSmoothScroller extends LinearSmoothScroller {
        CenterSmoothScroller(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i) {
            return (int) Math.ceil(Math.abs(i) * (100.0f / YKTitleTabIndicatorRv.this.getResources().getDisplayMetrics().densityDpi));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface ItemSelectListener {
        void onSelected();

        void onUnSelected();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnTabClickListener {
        void onTabClick(View view, int i);
    }

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

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class TabClick implements View.OnClickListener {
        private YKTitleTabItemViewRv itemView;
        private int position;

        public TabClick(int i, YKTitleTabItemViewRv yKTitleTabItemViewRv) {
            this.position = i;
            this.itemView = yKTitleTabItemViewRv;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv = YKTitleTabIndicatorRv.this;
            int i = yKTitleTabIndicatorRv.mClickedPosition;
            int i2 = this.position;
            if (i2 == i) {
                return;
            }
            yKTitleTabIndicatorRv.mIsClicked = true;
            yKTitleTabIndicatorRv.mClickedPosition = i2;
            ViewPager viewPager = yKTitleTabIndicatorRv.mViewPager;
            if (viewPager != null) {
                int currentItem = viewPager.getCurrentItem();
                YKTitleTabIndicatorRv yKTitleTabIndicatorRv2 = YKTitleTabIndicatorRv.this;
                if (currentItem != yKTitleTabIndicatorRv2.mClickedPosition) {
                    this.itemView.sendClickTracker(yKTitleTabIndicatorRv2.mViewPager.getCurrentItem(), YKTitleTabIndicatorRv.this.mClickedPosition);
                    YKTitleTabIndicatorRv yKTitleTabIndicatorRv3 = YKTitleTabIndicatorRv.this;
                    yKTitleTabIndicatorRv3.mViewPager.setCurrentItem(yKTitleTabIndicatorRv3.mClickedPosition, false);
                }
            }
            YKTitleTabIndicatorRv.this.mAdapter.notifyItemChanged(i);
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv4 = YKTitleTabIndicatorRv.this;
            yKTitleTabIndicatorRv4.mAdapter.notifyItemChanged(yKTitleTabIndicatorRv4.mClickedPosition);
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv5 = YKTitleTabIndicatorRv.this;
            OnTabClickListener onTabClickListener = yKTitleTabIndicatorRv5.mOnTabClickListener;
            if (onTabClickListener != null) {
                onTabClickListener.onTabClick(view, yKTitleTabIndicatorRv5.mClickedPosition);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class YKTitleTabIndicatorAdapter extends RecyclerView.Adapter<YKTitleTabIndicatorHolder> {
        public YKTitleTabIndicatorAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List list = YKTitleTabIndicatorRv.this.mDataList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == getItemCount() - 1) {
                return 65536;
            }
            return super.getItemViewType(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull YKTitleTabIndicatorHolder yKTitleTabIndicatorHolder, int i) {
            Object obj = YKTitleTabIndicatorRv.this.mDataList.get(i);
            View view = yKTitleTabIndicatorHolder.itemView;
            ((YKTitleTabItemViewRv) view).mPosition = i;
            if (((YKTitleTabItemViewRv) view).needUpdate(obj)) {
                ((YKTitleTabItemViewRv) yKTitleTabIndicatorHolder.itemView).bindData(obj);
                yKTitleTabIndicatorHolder.itemView.setTag(obj);
                View view2 = yKTitleTabIndicatorHolder.itemView;
                view2.setOnClickListener(new TabClick(i, (YKTitleTabItemViewRv) view2));
            }
            TextView textView = ((YKTitleTabItemViewRv) yKTitleTabIndicatorHolder.itemView).getTextView();
            if (textView == null) {
                return;
            }
            YKTitleTabIndicatorRv yKTitleTabIndicatorRv = YKTitleTabIndicatorRv.this;
            if (yKTitleTabIndicatorRv.currentPosition == i) {
                yKTitleTabIndicatorRv.setTextViewClicked(textView, true);
                ((YKTitleTabItemViewRv) yKTitleTabIndicatorHolder.itemView).onSelected();
                YKTitleTabIndicatorRv.this.selectedItemView = (YKTitleTabItemViewRv) yKTitleTabIndicatorHolder.itemView;
            } else {
                yKTitleTabIndicatorRv.setTextViewClicked(textView, false);
                ((YKTitleTabItemViewRv) yKTitleTabIndicatorHolder.itemView).onUnSelected();
            }
            if (65536 == getItemViewType(i)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(yKTitleTabIndicatorHolder.itemView.getLayoutParams());
                marginLayoutParams.setMargins(0, 0, YKTitleTabIndicatorRv.this.rightEndPadding, 0);
                yKTitleTabIndicatorHolder.itemView.setLayoutParams(marginLayoutParams);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public YKTitleTabIndicatorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            YKTitleTabItemViewRv yKTitleTabItemViewRv = (YKTitleTabItemViewRv) LayoutInflater.from(YKTitleTabIndicatorRv.this.mContext).inflate(YKTitleTabIndicatorRv.this.itemViewLayout, viewGroup, false);
            yKTitleTabItemViewRv.initView(YKTitleTabIndicatorRv.this);
            yKTitleTabItemViewRv.indicator = YKTitleTabIndicatorRv.this;
            return new YKTitleTabIndicatorHolder(yKTitleTabItemViewRv);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class YKTitleTabIndicatorHolder extends RecyclerView.ViewHolder {
        public YKTitleTabIndicatorHolder(YKTitleTabItemViewRv yKTitleTabItemViewRv) {
            super(yKTitleTabItemViewRv);
        }
    }

    public YKTitleTabIndicatorRv(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int blend(float f) {
        return ColorUtils.blendARGB(this.mTextColorDef, this.mTextColorSelected, f);
    }

    private int dp2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mScroller = new Scroller(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.YKTitleTabIndicator, i, 0);
        try {
            this.mSliderWidthMax = obtainStyledAttributes.getDimension(R.styleable.YKTitleTabIndicator_slider_max_width, dp2px(60.0f));
            this.mSliderWidthMin = obtainStyledAttributes.getDimension(R.styleable.YKTitleTabIndicator_slider_min_width, dp2px(5.0f));
            this.mSliderHeightStill = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_slider_still_height, dp2px(5.0f));
            this.mSliderHeightMoving = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_slider_moving_height, dp2px(3.0f));
            this.mSliderBottomMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_slider_bottom_margin, dp2px(4.0f));
            boolean z = obtainStyledAttributes.getBoolean(R.styleable.YKTitleTabIndicator_able_text_anim, false);
            this.ableTextAnim = z;
            if (z) {
                this.mTextSizeDef = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YKTitleTabIndicator_text_default_size, SkinUtils.getTextDefaultSizeInPx(context));
                this.mTextSizeSelected = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YKTitleTabIndicator_text_selected_size, SkinUtils.getTextSelectedSizeInPx(context));
            } else {
                this.mTextSizeDef = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YKTitleTabIndicator_text_default_size, SkinUtils.getTextDefaultSizeInPx(context));
                this.mTextSizeSelected = obtainStyledAttributes.getDimensionPixelSize(R.styleable.YKTitleTabIndicator_text_selected_size, SkinUtils.getTextDefaultSizeInPx(context));
            }
            int color = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_slider_color, Color.parseColor(AtmosphereColorConst.navIndicatorColor));
            this.mIndicatorColor = color;
            this.sIndicatorColor = color;
            int color2 = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_text_selected_color, Color.parseColor(AtmosphereColorConst.navColor));
            this.mTextColorSelected = color2;
            this.sTextColorSelected = color2;
            int color3 = obtainStyledAttributes.getColor(R.styleable.YKTitleTabIndicator_text_default_color, Color.parseColor(AtmosphereColorConst.navSubColor));
            this.mTextColorDef = color3;
            this.sTextColorDef = color3;
            this.rightEndPadding = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_right_end_padding, dp2px(100.0f));
            this.leftEndPadding = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_left_end_padding, 0);
            this.itemViewLayout = obtainStyledAttributes.getResourceId(R.styleable.YKTitleTabIndicator_item_view_layout, 0);
            this.mScreenWidth = DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics());
            this.textAnimDuring = obtainStyledAttributes.getInteger(R.styleable.YKTitleTabIndicator_text_anim_during, 200);
            this.scrollAnimDuring = obtainStyledAttributes.getInteger(R.styleable.YKTitleTabIndicator_scroll_anim_during, 500);
            this.mTextSelectedBottomPadding = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.YKTitleTabIndicator_text_selected_bottom_padding, dp2px(11.0f));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextViewClicked(TextView textView, boolean z) {
        textView.getPaint().setFakeBoldText(z);
        if (z) {
            textView.setTextColor(this.mTextColorSelected);
            if (!this.ableTextAnim) {
                textView.setTextSize(0, this.mTextSizeSelected);
            }
        } else {
            textView.setTextColor(this.mTextColorDef);
            if (!this.ableTextAnim) {
                textView.setTextSize(0, this.mTextSizeDef);
            }
        }
        textView.invalidate();
    }

    public void adjustCenterPosition() {
        adjustTitleColor();
        adjustPosition();
    }

    public void adjustPosition() {
        YKTitleLayoutManager yKTitleLayoutManager = this.mLayoutManager;
        if (yKTitleLayoutManager != null) {
            yKTitleLayoutManager.smoothScrollToPosition(this, null, this.currentPosition);
        }
    }

    public void adjustTitleColor() {
        YKTitleTabIndicatorAdapter yKTitleTabIndicatorAdapter = this.mAdapter;
        if (yKTitleTabIndicatorAdapter != null) {
            yKTitleTabIndicatorAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public int getClickedPosition() {
        return this.mClickedPosition;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public float getCurrentPositionOffset() {
        return this.currentPositionOffset;
    }

    public int getCurrentX() {
        return this.currentX;
    }

    public List getDataList() {
        return this.mDataList;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.mHandler;
    }

    @Deprecated
    public int getIndecatorColor() {
        return this.mIndicatorColor;
    }

    public int getIndicatorColor() {
        return this.mIndicatorColor;
    }

    public int getItemViewLayout() {
        return this.itemViewLayout;
    }

    public int getLeftEndPadding() {
        return this.leftEndPadding;
    }

    public OnTabClickListener getOnTabClickListener() {
        return this.mOnTabClickListener;
    }

    public int getRightEndPadding() {
        return this.rightEndPadding;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public int getScrollAnimDuring() {
        return this.scrollAnimDuring;
    }

    public YKTitleTabItemViewRv getSelectedItemView() {
        return this.selectedItemView;
    }

    public int getSliderBottomMargin() {
        return this.mSliderBottomMargin;
    }

    public float getSliderCompat() {
        return this.mSliderCompat;
    }

    public int getSliderHeightMoving() {
        return this.mSliderHeightMoving;
    }

    public int getSliderHeightStill() {
        return this.mSliderHeightStill;
    }

    public float getSliderWidthMax() {
        return this.mSliderWidthMax;
    }

    public float getSliderWidthMin() {
        return this.mSliderWidthMin;
    }

    public int getTextAnimDuring() {
        return this.textAnimDuring;
    }

    public int getTextColorDef() {
        return this.mTextColorDef;
    }

    public int getTextColorSelected() {
        return this.mTextColorSelected;
    }

    public int getTextSelectedBottomPadding() {
        return this.mTextSelectedBottomPadding;
    }

    public int getTextSizeDef() {
        return this.mTextSizeDef;
    }

    public int getTextSizeSelected() {
        return this.mTextSizeSelected;
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public boolean isAbleTextAnim() {
        return this.ableTextAnim;
    }

    public boolean isDefaultColor() {
        return this.isDefaultColor;
    }

    public boolean isEnableSmoothScroll() {
        return this.enableSmoothScroll;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
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

    public void setAbleTextAnim(boolean z) {
        this.ableTextAnim = z;
    }

    public void setClickedPosition(int i) {
        this.mClickedPosition = i;
    }

    public void setCurrentPosition(int i) {
        this.currentPosition = i;
    }

    public void setCurrentPositionOffset(float f) {
        this.currentPositionOffset = f;
    }

    public void setCurrentX(int i) {
        this.currentX = i;
    }

    public void setCustomClor(int i, int i2, int i3) {
        this.mTextColorDef = i;
        this.mTextColorSelected = i2;
        this.mIndicatorColor = i3;
        if (i == this.sTextColorDef && i2 == this.sTextColorSelected && i3 == this.sIndicatorColor) {
            this.isDefaultColor = true;
        } else {
            this.isDefaultColor = false;
        }
        adjustCenterPosition();
        invalidate();
    }

    public void setDefaultColor(boolean z) {
        this.isDefaultColor = z;
    }

    public void setEnableSmoothScroll(boolean z) {
        this.enableSmoothScroll = z;
    }

    public void setIsClicked(boolean z) {
        this.mIsClicked = z;
    }

    public void setItemViewLayout(int i) {
        this.itemViewLayout = i;
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }

    public void setRightEndPadding(int i) {
        this.rightEndPadding = i;
    }

    public void setScrollAnimDuring(int i) {
        this.scrollAnimDuring = i;
    }

    public void setScrollRunnable(Runnable runnable) {
        this.scrollRunnable = runnable;
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.mScrollViewListener = scrollViewListener;
    }

    public void setSliderWidthMax(float f) {
        this.mSliderWidthMax = f;
    }

    public void setTextAnimDuring(int i) {
        this.textAnimDuring = i;
    }

    public void setTextSelectedBottomPadding(int i) {
        this.mTextSelectedBottomPadding = i;
    }

    public void setTextSizeSelected(int i) {
        this.mTextSizeSelected = i;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.youku.resource.widget.YKTitleTabIndicatorRv.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 0) {
                    YKTitleTabIndicatorRv yKTitleTabIndicatorRv = YKTitleTabIndicatorRv.this;
                    yKTitleTabIndicatorRv.mIsClicked = false;
                    yKTitleTabIndicatorRv.adjustTitleColor();
                }
                qb1.a("YKTitleTabIndicator", " page state = " + i, new Object[0]);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                YKTitleTabIndicatorRv yKTitleTabIndicatorRv = YKTitleTabIndicatorRv.this;
                yKTitleTabIndicatorRv.currentPositionOffset = f;
                double d = f;
                if (d > 0.05d && d < 0.95d) {
                    yKTitleTabIndicatorRv.mIsClicked = false;
                }
                qb1.a("YKTitleTabIndicator", "position = " + i + " offset = " + f + " pxoff = " + i2, new Object[0]);
                YKTitleTabIndicatorRv yKTitleTabIndicatorRv2 = YKTitleTabIndicatorRv.this;
                yKTitleTabIndicatorRv2.mHandler.postDelayed(yKTitleTabIndicatorRv2.scrollRunnable, 50L);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(final int i) {
                qb1.a("YKTitleTabIndicator", "onPageSelected position:" + i + "  mClickedPosition:" + YKTitleTabIndicatorRv.this.mClickedPosition, new Object[0]);
                YKTitleTabIndicatorRv yKTitleTabIndicatorRv = YKTitleTabIndicatorRv.this;
                yKTitleTabIndicatorRv.mClickedPosition = i;
                yKTitleTabIndicatorRv.postDelayed(new Runnable() { // from class: com.youku.resource.widget.YKTitleTabIndicatorRv.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YKTitleTabIndicatorRv yKTitleTabIndicatorRv2 = YKTitleTabIndicatorRv.this;
                        yKTitleTabIndicatorRv2.currentPosition = i;
                        yKTitleTabIndicatorRv2.adjustCenterPosition();
                    }
                }, 100L);
            }
        });
    }

    public void smoothScrollBySlow(int i, int i2, int i3) {
        this.mScroller.startScroll(getScrollX(), getScrollY(), i, i2, i3);
        invalidate();
    }

    public void smoothScrollToSlow(int i, int i2, int i3) {
        smoothScrollBySlow(i - getScrollX(), i2 - getScrollY(), i3);
    }

    public void updateTabs(List list) {
        this.mDataList = list;
        try {
            this.dataSize = list.size();
            if (this.mAdapter == null) {
                this.mAdapter = new YKTitleTabIndicatorAdapter();
                YKTitleLayoutManager yKTitleLayoutManager = new YKTitleLayoutManager(this.mContext);
                this.mLayoutManager = yKTitleLayoutManager;
                yKTitleLayoutManager.setOrientation(0);
                setLayoutManager(this.mLayoutManager);
                setAdapter(this.mAdapter);
            }
            this.mAdapter.notifyDataSetChanged();
            adjustTitleColor();
        } catch (Exception e) {
            qb1.b("YKTitleTabIndicator", e.getLocalizedMessage(), new Object[0]);
        }
    }

    public YKTitleTabIndicatorRv(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDataList = new ArrayList();
        this.enableSmoothScroll = false;
        this.dataSize = 0;
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
        this.mScreenWidth = 800;
        this.mSliderBottomMargin = 4;
        this.mTextColorDef = Color.parseColor(AtmosphereColorConst.navSubColor);
        this.mTextColorSelected = Color.parseColor(AtmosphereColorConst.navColor);
        this.mIndicatorColor = Color.parseColor(AtmosphereColorConst.navIndicatorColor);
        this.mTextSizeDef = 40;
        this.mTextSizeSelected = 40;
        this.rightEndPadding = 100;
        this.leftEndPadding = 0;
        this.itemViewLayout = 0;
        this.ableTextAnim = false;
        this.textAnimDuring = 200;
        this.scrollAnimDuring = 500;
        this.mTextSelectedBottomPadding = 11;
        this.scrollRunnable = new Runnable() { // from class: com.youku.resource.widget.YKTitleTabIndicatorRv.1
            @Override // java.lang.Runnable
            public void run() {
                int scrollX = YKTitleTabIndicatorRv.this.getScrollX();
                YKTitleTabIndicatorRv yKTitleTabIndicatorRv = YKTitleTabIndicatorRv.this;
                if (scrollX == yKTitleTabIndicatorRv.currentX) {
                    ScrollType scrollType = ScrollType.IDLE;
                    yKTitleTabIndicatorRv.scrollType = scrollType;
                    ScrollViewListener scrollViewListener = yKTitleTabIndicatorRv.mScrollViewListener;
                    if (scrollViewListener != null) {
                        scrollViewListener.onScrollChanged(scrollType);
                    }
                    YKTitleTabIndicatorRv.this.mHandler.removeCallbacks(this);
                    return;
                }
                ScrollType scrollType2 = ScrollType.FLING;
                yKTitleTabIndicatorRv.scrollType = scrollType2;
                ScrollViewListener scrollViewListener2 = yKTitleTabIndicatorRv.mScrollViewListener;
                if (scrollViewListener2 != null) {
                    scrollViewListener2.onScrollChanged(scrollType2);
                }
                YKTitleTabIndicatorRv yKTitleTabIndicatorRv2 = YKTitleTabIndicatorRv.this;
                yKTitleTabIndicatorRv2.currentX = yKTitleTabIndicatorRv2.getScrollX();
                YKTitleTabIndicatorRv.this.mHandler.postDelayed(this, 50L);
            }
        };
        this.isDefaultColor = true;
        this.mHandler = new Handler();
        setWillNotDraw(false);
        this.mContext = context;
        init(context, attributeSet, i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class YKTitleLayoutManager extends LinearLayoutManager {
        private RecyclerView.SmoothScroller smoothScroller;

        public YKTitleLayoutManager(Context context) {
            super(context);
            if (this.smoothScroller == null) {
                this.smoothScroller = new CenterSmoothScroller(YKTitleTabIndicatorRv.this.getContext());
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            this.smoothScroller.setTargetPosition(i);
            startSmoothScroll(this.smoothScroller);
        }

        public YKTitleLayoutManager(Context context, int i, boolean z) {
            super(context, i, z);
        }

        public YKTitleLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
            super(context, attributeSet, i, i2);
        }
    }
}
