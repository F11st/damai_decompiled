package cn.damai.uikit.snake;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ScrollThickLinearView extends ScrollLinearView {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mAnimatedValue;
    private float mLastStartX;
    private float mLastStopX;
    private Bitmap mLineBitmap;
    private RectF mLineDstRect;
    private Rect mLineSrcRect;
    private Paint mPaint;
    public int mSelectIndex;
    private Bitmap mShadleBitmap;
    private RectF mShadleDstRect;
    private Rect mShadleSrcRect;
    private float mStartX;
    private int mStartY;
    private float mStopX;
    private TextView mTv;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        a(ScrollThickLinearView scrollThickLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "365880694")) {
                ipChange.ipc$dispatch("365880694", new Object[]{this, view});
            } else {
                this.a.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;

        b(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1046841343")) {
                ipChange.ipc$dispatch("1046841343", new Object[]{this, valueAnimator});
                return;
            }
            ScrollThickLinearView.this.mAnimatedValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ScrollThickLinearView scrollThickLinearView = ScrollThickLinearView.this;
            int i = scrollThickLinearView.mXiaoSize;
            ScrollThickLinearView.this.mTv.setTextSize(1, i + (((scrollThickLinearView.mDaSize - i) * scrollThickLinearView.mAnimatedValue) / 100.0f));
            if (this.a < this.b) {
                if (ScrollThickLinearView.this.mAnimatedValue <= 50.0f) {
                    ScrollThickLinearView.this.mStartX = this.a;
                    ScrollThickLinearView scrollThickLinearView2 = ScrollThickLinearView.this;
                    float f = this.c;
                    scrollThickLinearView2.mStopX = f + (((this.b - f) * scrollThickLinearView2.mAnimatedValue) / 75.0f);
                } else if (ScrollThickLinearView.this.mAnimatedValue <= 50.0f || ScrollThickLinearView.this.mAnimatedValue > 75.0f) {
                    if (ScrollThickLinearView.this.mAnimatedValue > 75.0f) {
                        ScrollThickLinearView scrollThickLinearView3 = ScrollThickLinearView.this;
                        float f2 = this.a;
                        scrollThickLinearView3.mStartX = f2 + (((this.d - f2) * (scrollThickLinearView3.mAnimatedValue - 50.0f)) / 50.0f);
                        ScrollThickLinearView.this.mStopX = this.b;
                    }
                } else {
                    ScrollThickLinearView scrollThickLinearView4 = ScrollThickLinearView.this;
                    float f3 = this.a;
                    scrollThickLinearView4.mStartX = f3 + (((this.d - f3) * (scrollThickLinearView4.mAnimatedValue - 50.0f)) / 50.0f);
                    ScrollThickLinearView scrollThickLinearView5 = ScrollThickLinearView.this;
                    float f4 = this.c;
                    scrollThickLinearView5.mStopX = f4 + (((this.b - f4) * scrollThickLinearView5.mAnimatedValue) / 75.0f);
                }
            } else if (ScrollThickLinearView.this.mAnimatedValue > 50.0f) {
                if (ScrollThickLinearView.this.mAnimatedValue <= 50.0f || ScrollThickLinearView.this.mAnimatedValue > 75.0f) {
                    if (ScrollThickLinearView.this.mAnimatedValue > 75.0f) {
                        ScrollThickLinearView.this.mStartX = this.d;
                        ScrollThickLinearView scrollThickLinearView6 = ScrollThickLinearView.this;
                        float f5 = this.c;
                        scrollThickLinearView6.mStopX = f5 + (((this.b - f5) * (scrollThickLinearView6.mAnimatedValue - 50.0f)) / 50.0f);
                    }
                } else {
                    ScrollThickLinearView scrollThickLinearView7 = ScrollThickLinearView.this;
                    float f6 = this.a;
                    scrollThickLinearView7.mStartX = f6 + (((this.d - f6) * scrollThickLinearView7.mAnimatedValue) / 75.0f);
                    ScrollThickLinearView scrollThickLinearView8 = ScrollThickLinearView.this;
                    float f7 = this.c;
                    scrollThickLinearView8.mStopX = f7 + (((this.b - f7) * (scrollThickLinearView8.mAnimatedValue - 50.0f)) / 50.0f);
                }
            } else {
                ScrollThickLinearView scrollThickLinearView9 = ScrollThickLinearView.this;
                float f8 = this.a;
                scrollThickLinearView9.mStartX = f8 + (((this.d - f8) * scrollThickLinearView9.mAnimatedValue) / 75.0f);
                ScrollThickLinearView.this.mStopX = this.c;
            }
            if (ScrollThickLinearView.this.mAnimatedValue == 100.0f) {
                ScrollThickLinearView scrollThickLinearView10 = ScrollThickLinearView.this;
                scrollThickLinearView10.mIsMove = false;
                scrollThickLinearView10.mLastStartX = this.d;
                ScrollThickLinearView.this.mLastStopX = this.b;
                ScrollThickLinearView.this.mSrcollStart = false;
            }
            ScrollThickLinearView.this.invalidate();
        }
    }

    public ScrollThickLinearView(Context context) {
        super(context);
        this.mLastStartX = 0.0f;
        this.mLastStopX = 0.0f;
        this.mStartY = 0;
        this.mLineDstRect = new RectF();
        this.mShadleDstRect = new RectF();
        this.mSelectIndex = -1;
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int selectTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1320643424")) {
            return ((Integer) ipChange.ipc$dispatch("1320643424", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        TextView textView = (TextView) getChildAt(i);
        if (textView == null) {
            return i;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        textView.measure(makeMeasureSpec, makeMeasureSpec);
        this.mStartX = textView.getLeft() + dip2px(this.mSpace / 2);
        float f = this.mStartX;
        float measuredWidth = f + (((textView.getMeasuredWidth() - dip2px(this.mSpace)) * this.mDaSize) / this.mXiaoSize);
        this.mStopX = measuredWidth;
        this.mTv = textView;
        if (this.mLastStartX == 0.0f && this.mLastStopX == 0.0f) {
            this.mLastStartX = f;
            this.mLastStopX = measuredWidth;
        }
        startAnim(i, this.mLastStartX, this.mLastStopX, f, measuredWidth);
        return i;
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576152963")) {
            ipChange.ipc$dispatch("576152963", new Object[]{this});
            return;
        }
        setWillNotDraw(false);
        setOrientation(0);
        setGravity(16);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStrokeWidth(1.0f);
        this.mPaint.setAntiAlias(true);
        this.mLineBitmap = BitmapFactory.decodeResource(getResources(), R$drawable.snake_line_rectangle);
        this.mShadleBitmap = BitmapFactory.decodeResource(getResources(), R$drawable.snake_line_shadle);
        this.mLineSrcRect = new Rect(0, 0, this.mLineBitmap.getWidth(), this.mLineBitmap.getHeight());
        this.mShadleSrcRect = new Rect(0, 0, this.mShadleBitmap.getWidth(), this.mShadleBitmap.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.uikit.snake.ScrollLinearView, android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-25281680")) {
            ipChange.ipc$dispatch("-25281680", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (!this.mIsShowLine || this.mPaint == null) {
            return;
        }
        int dip2px = dip2px(this.mHeight / 2);
        this.mStartY = dip2px;
        RectF rectF = this.mLineDstRect;
        rectF.left = this.mStartX;
        rectF.right = this.mStopX;
        if (this.mDaSize == this.mXiaoSize) {
            rectF.top = dip2px + dip2px(5.0f);
            this.mLineDstRect.bottom = this.mStartY + dip2px(15.0f);
        } else {
            rectF.top = dip2px + dip2px(7.0f);
            this.mLineDstRect.bottom = this.mStartY + dip2px(17.0f);
        }
        canvas.drawBitmap(this.mLineBitmap, this.mLineSrcRect, this.mLineDstRect, this.mPaint);
        if (this.mIsMove) {
            return;
        }
        float f = this.mStartX;
        if (f <= 0.0f) {
            return;
        }
        this.mShadleDstRect.left = f - dip2px(5.0f);
        this.mShadleDstRect.right = this.mStopX + dip2px(5.0f);
        if (this.mDaSize == this.mXiaoSize) {
            this.mShadleDstRect.top = this.mStartY - dip2px(3.0f);
            this.mShadleDstRect.bottom = this.mStartY + dip2px(18.0f);
        } else {
            this.mShadleDstRect.top = this.mStartY - dip2px(1.0f);
            this.mShadleDstRect.bottom = this.mStartY + dip2px(20.0f);
        }
        canvas.drawBitmap(this.mShadleBitmap, this.mShadleSrcRect, this.mShadleDstRect, this.mPaint);
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setFontSize(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105563869")) {
            ipChange.ipc$dispatch("-2105563869", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mSelectIndex != i) {
            this.mSrcollStart = true;
            this.mSelectIndex = i;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                TextView textView = (TextView) getChildAt(i2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.gravity = 16;
                textView.setLayoutParams(layoutParams);
                if (i == i2) {
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
            postDelayed(new Runnable() { // from class: cn.damai.uikit.snake.ScrollThickLinearView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1570898919")) {
                        ipChange2.ipc$dispatch("-1570898919", new Object[]{this});
                    } else {
                        ScrollThickLinearView.this.selectTitle(i);
                    }
                }
            }, 50L);
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "194608070")) {
            ipChange.ipc$dispatch("194608070", new Object[]{this, list, onClickListener});
        } else if (list != null) {
            this.mTitleList = list;
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    TextView textView = new TextView(this.mContext);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextSize(1, this.mXiaoSize);
                    textView.setGravity(17);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    textView.setTag(scrollTitleBean);
                    textView.setPadding(dip2px(this.mSpace / 2), 0, dip2px(this.mSpace / 2), 0);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams.gravity = 16;
                    textView.setLayoutParams(layoutParams);
                    textView.setOnClickListener(new a(this, onClickListener));
                    addView(textView);
                }
            }
        }
    }

    @Override // cn.damai.uikit.snake.ScrollLinearView
    public void startAnim(int i, float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2085865084")) {
            ipChange.ipc$dispatch("-2085865084", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
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
            ofInt.addUpdateListener(new b(f, f4, f2, f3));
            ofInt.start();
            this.mIsMove = true;
        }
    }

    public ScrollThickLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastStartX = 0.0f;
        this.mLastStopX = 0.0f;
        this.mStartY = 0;
        this.mLineDstRect = new RectF();
        this.mShadleDstRect = new RectF();
        this.mSelectIndex = -1;
        this.mContext = context;
        initView();
    }
}
