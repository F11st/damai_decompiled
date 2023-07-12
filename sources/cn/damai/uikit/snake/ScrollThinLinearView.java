package cn.damai.uikit.snake;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.uikit.R$color;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScrollThinLinearView extends ScrollLinearView {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mAnimatedValue;
    private float mLastStartX;
    private float mLastStopX;
    private float mLineWidth;
    private int mPaddingLeftRight;
    private Paint mPaint;
    public int mSelectIndex;
    public boolean mSrcollStart;
    private float mStartX;
    private int mStartY;
    private float mStopX;
    private float mTempStartX;
    private float mTempStopX;
    private TextView mTv;
    private PageListener pageListener;
    private ViewPager pager;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class PageListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-645045204")) {
                ipChange.ipc$dispatch("-645045204", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1620106443")) {
                ipChange.ipc$dispatch("1620106443", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                return;
            }
            if (i2 > 0) {
                ScrollThinLinearView scrollThinLinearView = ScrollThinLinearView.this;
                scrollThinLinearView.mStartX = scrollThinLinearView.mLastStartX + ((ScrollThinLinearView.this.mStartX - ScrollThinLinearView.this.mLastStartX) * f);
            } else {
                ScrollThinLinearView scrollThinLinearView2 = ScrollThinLinearView.this;
                scrollThinLinearView2.mStartX = scrollThinLinearView2.mLastStartX - ((ScrollThinLinearView.this.mLastStartX - ScrollThinLinearView.this.mStartX) * f);
            }
            ScrollThinLinearView.this.invalidate();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1659390583")) {
                ipChange.ipc$dispatch("1659390583", new Object[]{this, Integer.valueOf(i)});
            }
        }

        /* synthetic */ PageListener(ScrollThinLinearView scrollThinLinearView, View$OnClickListenerC2555a view$OnClickListenerC2555a) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.snake.ScrollThinLinearView$a */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC2555a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        View$OnClickListenerC2555a(ScrollThinLinearView scrollThinLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "40206690")) {
                ipChange.ipc$dispatch("40206690", new Object[]{this, view});
            } else {
                this.a.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.snake.ScrollThinLinearView$b */
    /* loaded from: classes8.dex */
    public class C2556b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;

        C2556b(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1679957995")) {
                ipChange.ipc$dispatch("1679957995", new Object[]{this, valueAnimator});
                return;
            }
            ScrollThinLinearView.this.mAnimatedValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ScrollThinLinearView scrollThinLinearView = ScrollThinLinearView.this;
            int i = scrollThinLinearView.mXiaoSize;
            ScrollThinLinearView.this.mTv.setTextSize(1, i + (((scrollThinLinearView.mDaSize - i) * scrollThinLinearView.mAnimatedValue) / 100.0f));
            float f = ScrollThinLinearView.this.mAnimatedValue / 100.0f;
            float f2 = this.a;
            float f3 = this.b;
            if (f2 < f3) {
                ScrollThinLinearView.this.mStartX = f2 + ((f3 - f2) * f);
                ScrollThinLinearView scrollThinLinearView2 = ScrollThinLinearView.this;
                scrollThinLinearView2.mStopX = scrollThinLinearView2.mStartX + ScrollThinLinearView.this.mLineWidth;
            } else {
                ScrollThinLinearView.this.mStartX = f2 - ((f2 - f3) * f);
                ScrollThinLinearView scrollThinLinearView3 = ScrollThinLinearView.this;
                scrollThinLinearView3.mStopX = scrollThinLinearView3.mStartX + ScrollThinLinearView.this.mLineWidth;
            }
            if (ScrollThinLinearView.this.mAnimatedValue == 100.0f) {
                ScrollThinLinearView.this.mLastStartX = this.b;
                ScrollThinLinearView.this.mLastStopX = this.c;
                ScrollThinLinearView.this.mSrcollStart = false;
            }
            ScrollThinLinearView.this.invalidate();
        }
    }

    public ScrollThinLinearView(Context context) {
        super(context);
        this.mLastStartX = 0.0f;
        this.mLastStopX = 0.0f;
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.pageListener = new PageListener(this, null);
        this.mPaddingLeftRight = 0;
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int selectTitle(int i) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030346420")) {
            return ((Integer) ipChange.ipc$dispatch("-2030346420", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (this.mPaddingLeftRight > 0) {
            textView = (TextView) getChildAt(i + 1);
        } else {
            textView = (TextView) getChildAt(i);
        }
        if (textView == null) {
            return i;
        }
        if (textView.getText() != null) {
            float f = this.mLineWidth;
            float left = textView.getLeft() + dip2px(this.mSpace / 2) + (((((textView.getMeasuredWidth() - dip2px(this.mSpace)) * this.mDaSize) / this.mXiaoSize) - f) / 2.0f);
            this.mStartX = left;
            this.mStopX = left + f;
        }
        float f2 = this.mStartX;
        this.mTempStartX = f2;
        float f3 = this.mStopX;
        this.mTempStopX = f3;
        this.mTv = textView;
        if (this.mLastStartX == 0.0f && this.mLastStopX == 0.0f) {
            this.mLastStartX = f2;
            this.mLastStopX = f3;
        }
        startAnim(i, this.mLastStartX, this.mLastStopX, f2, f3);
        return i;
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1982476143")) {
            ipChange.ipc$dispatch("1982476143", new Object[]{this});
            return;
        }
        setWillNotDraw(false);
        setOrientation(0);
        setGravity(16);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStrokeWidth(dip2px(4.0f));
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setColor(this.mContext.getResources().getColor(R$color.color_FF2869));
        this.mPaint.setAntiAlias(true);
        this.mLineWidth = dip2px(18.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.snake.ScrollLinearView, android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "151586820")) {
            ipChange.ipc$dispatch("151586820", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.mIsShowLine) {
            int dip2px = dip2px(this.mHeight / 2) + dip2px((this.mDaSize / 2) + 8);
            this.mStartY = dip2px;
            Paint paint = this.mPaint;
            if (paint != null) {
                canvas.drawLine(this.mStartX, dip2px, this.mStopX, dip2px, paint);
            }
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setDefaultPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260465681")) {
            ipChange.ipc$dispatch("-1260465681", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mPaddingLeftRight = i;
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setFontSize(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161586417")) {
            ipChange.ipc$dispatch("-1161586417", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSrcollStart = true;
        this.mSelectIndex = i;
        if (this.mPaddingLeftRight > 0) {
            for (int i2 = 1; i2 < getChildCount() - 1; i2++) {
                TextView textView = (TextView) getChildAt(i2);
                if (i == i2 - 1) {
                    int i3 = this.mDaSize;
                    int i4 = this.mXiaoSize;
                    if (i3 == i4) {
                        textView.setTextSize(1, i4);
                    }
                    textView.getPaint().setFakeBoldText(this.mFakeBoldText);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                } else {
                    textView.setTextSize(1, this.mXiaoSize);
                    textView.getPaint().setFakeBoldText(false);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                }
            }
        } else {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                TextView textView2 = (TextView) getChildAt(i5);
                if (i == i5) {
                    int i6 = this.mDaSize;
                    int i7 = this.mXiaoSize;
                    if (i6 == i7) {
                        textView2.setTextSize(1, i7);
                    }
                    textView2.getPaint().setFakeBoldText(this.mFakeBoldText);
                    textView2.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                } else {
                    textView2.setTextSize(1, this.mXiaoSize);
                    textView2.getPaint().setFakeBoldText(false);
                    textView2.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                }
            }
        }
        postDelayed(new Runnable() { // from class: cn.damai.uikit.snake.ScrollThinLinearView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "632641965")) {
                    ipChange2.ipc$dispatch("632641965", new Object[]{this});
                } else {
                    ScrollThinLinearView.this.selectTitle(i);
                }
            }
        }, 50L);
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setLineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "298304172")) {
            ipChange.ipc$dispatch("298304172", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mPaint.setColor(i);
        invalidate();
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        LinearLayout.LayoutParams layoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815111590")) {
            ipChange.ipc$dispatch("-815111590", new Object[]{this, list, onClickListener});
        } else if (list != null) {
            this.mTitleList = list;
            removeAllViews();
            if (this.mPaddingLeftRight > 0) {
                View view = new View(this.mContext);
                view.setLayoutParams(new LinearLayout.LayoutParams(this.mPaddingLeftRight, -1));
                addView(view);
            }
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    TextView textView = new TextView(this.mContext);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextSize(1, this.mXiaoSize);
                    textView.setGravity(17);
                    textView.setSingleLine();
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    textView.setTag(scrollTitleBean);
                    if (this.mIsEqual) {
                        layoutParams = new LinearLayout.LayoutParams(0, -1);
                        layoutParams.gravity = 16;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams = new LinearLayout.LayoutParams(-2, -1);
                        layoutParams.gravity = 16;
                        textView.setPadding(dip2px(this.mSpace / 2), 0, dip2px(this.mSpace / 2), 0);
                    }
                    textView.setLayoutParams(layoutParams);
                    textView.setOnClickListener(new View$OnClickListenerC2555a(this, onClickListener));
                    addView(textView);
                }
            }
            if (this.mPaddingLeftRight > 0) {
                View view2 = new View(this.mContext);
                view2.setLayoutParams(new LinearLayout.LayoutParams(this.mPaddingLeftRight, -1));
                addView(view2);
            }
        }
    }

    public void setViewPager(ViewPager viewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1993343505")) {
            ipChange.ipc$dispatch("-1993343505", new Object[]{this, viewPager});
            return;
        }
        this.pager = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        viewPager.addOnPageChangeListener(this.pageListener);
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void startAnim(int i, float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161633168")) {
            ipChange.ipc$dispatch("-1161633168", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        } else if (f == f3) {
            this.mStartX = f3;
            this.mStopX = f4;
            this.mTv.setTextSize(1, this.mDaSize);
            this.mTv.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
            invalidate();
            this.mSrcollStart = false;
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new C2556b(f, f3, f4));
            ofInt.start();
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void updateFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1432273093")) {
            ipChange.ipc$dispatch("-1432273093", new Object[]{this});
        } else if (this.mPaddingLeftRight > 0) {
            for (int i = 1; i < getChildCount() - 1; i++) {
                TextView textView = (TextView) getChildAt(i);
                if (this.mSelectIndex == i - 1) {
                    textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                } else {
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                }
            }
        } else {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                TextView textView2 = (TextView) getChildAt(i2);
                if (this.mSelectIndex == i2) {
                    textView2.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                } else {
                    textView2.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                }
            }
        }
    }

    public ScrollThinLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastStartX = 0.0f;
        this.mLastStopX = 0.0f;
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.pageListener = new PageListener(this, null);
        this.mPaddingLeftRight = 0;
        this.mContext = context;
        initView();
    }
}
