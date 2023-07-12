package com.alibaba.pictures.bricks.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.bricks.bean.ScrollTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.n91;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class EqualLinearView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private float mAnimatedValue;
    private Context mContext;
    private int mDaSize;
    private int mHeight;
    private boolean mIsShowLine;
    private float mLastStartX;
    private float mLastStopX;
    private float mLineWidth;
    private View.OnClickListener mOnClickListener;
    private Paint mPaint;
    public int mSelectIndex;
    private int mSelectedFontColor;
    private boolean mSrcollStart;
    private float mStartX;
    private int mStartY;
    private float mStopX;
    private List<ScrollTitleBean> mTitleList;
    private TextView mTv;
    private int mUnSelectedFontColor;
    private int mXiaoSize;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.EqualLinearView$a */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC3578a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TextView a;

        View$OnClickListenerC3578a(TextView textView) {
            this.a = textView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "742320683")) {
                ipChange.ipc$dispatch("742320683", new Object[]{this, view});
            } else {
                EqualLinearView.this.mOnClickListener.onClick(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.EqualLinearView$b */
    /* loaded from: classes7.dex */
    public class C3579b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;

        C3579b(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1009778100")) {
                ipChange.ipc$dispatch("1009778100", new Object[]{this, valueAnimator});
                return;
            }
            EqualLinearView.this.mAnimatedValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            EqualLinearView.this.mTv.setTextSize(1, EqualLinearView.this.mXiaoSize + (((EqualLinearView.this.mDaSize - EqualLinearView.this.mXiaoSize) * EqualLinearView.this.mAnimatedValue) / 100.0f));
            EqualLinearView.this.mTv.setGravity(17);
            float f = EqualLinearView.this.mAnimatedValue / 100.0f;
            float f2 = this.a;
            float f3 = this.b;
            if (f2 < f3) {
                EqualLinearView.this.mStartX = f2 + ((f3 - f2) * f);
                EqualLinearView equalLinearView = EqualLinearView.this;
                equalLinearView.mStopX = equalLinearView.mStartX + EqualLinearView.this.mLineWidth;
            } else {
                EqualLinearView.this.mStartX = f2 - ((f2 - f3) * f);
                EqualLinearView equalLinearView2 = EqualLinearView.this;
                equalLinearView2.mStopX = equalLinearView2.mStartX + EqualLinearView.this.mLineWidth;
            }
            if (EqualLinearView.this.mAnimatedValue == 100.0f) {
                EqualLinearView.this.mLastStartX = this.b;
                EqualLinearView.this.mLastStopX = this.c;
                EqualLinearView.this.mSrcollStart = false;
            }
            EqualLinearView.this.invalidate();
        }
    }

    public EqualLinearView(Context context) {
        super(context);
        this.mDaSize = 16;
        this.mXiaoSize = 16;
        this.mHeight = 45;
        this.mIsShowLine = true;
        this.mSelectedFontColor = R$color.bricks_000000;
        this.mUnSelectedFontColor = R$color.bricks_999999;
        this.mPaint = new Paint();
        this.mLastStartX = 0.0f;
        this.mLastStopX = 0.0f;
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.mContext = context;
        initView();
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "61871733") ? ((Integer) ipChange.ipc$dispatch("61871733", new Object[]{this, Float.valueOf(f)})).intValue() : (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692341944")) {
            ipChange.ipc$dispatch("1692341944", new Object[]{this});
            return;
        }
        setWillNotDraw(false);
        setOrientation(0);
        setGravity(16);
        this.mPaint.setStrokeWidth(dip2px(4.0f));
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setColor(this.mContext.getResources().getColor(R$color.bricks_FF2869));
        this.mPaint.setAntiAlias(true);
        this.mLineWidth = dip2px(18.0f);
    }

    public void commit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1598565354")) {
            ipChange.ipc$dispatch("-1598565354", new Object[]{this});
        } else if (!n91.b(this.mTitleList) && this.mTitleList.size() <= 5) {
            removeAllViews();
            for (int i = 0; i < this.mTitleList.size(); i++) {
                ScrollTitleBean scrollTitleBean = this.mTitleList.get(i);
                if (scrollTitleBean != null) {
                    TextView textView = new TextView(this.mContext);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextSize(this.mXiaoSize);
                    textView.setGravity(17);
                    textView.setTag(scrollTitleBean);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.gravity = 16;
                    layoutParams.weight = 1.0f;
                    textView.setLayoutParams(layoutParams);
                    textView.setOnClickListener(new View$OnClickListenerC3578a(textView));
                    addView(textView);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "338820763")) {
            ipChange.ipc$dispatch("338820763", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.mIsShowLine) {
            this.mStartY = dip2px(this.mHeight - 2);
            float f = this.mStartX;
            int i = this.mStartY;
            this.mPaint.setShader(new LinearGradient(f, i, this.mStopX, i, Color.parseColor("#FFFF70B8"), Color.parseColor("#FFFFBEED"), Shader.TileMode.CLAMP));
            Paint paint = this.mPaint;
            if (paint != null) {
                float f2 = this.mStartX;
                int i2 = this.mStartY;
                canvas.drawLine(f2, i2, this.mStopX, i2, paint);
            }
        }
    }

    public void selectTitle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1226212830")) {
            ipChange.ipc$dispatch("-1226212830", new Object[]{this, Integer.valueOf(i)});
        } else if (!n91.b(this.mTitleList) && this.mSelectIndex != i && !this.mSrcollStart) {
            this.mSrcollStart = true;
            this.mSelectIndex = i;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                TextView textView = (TextView) getChildAt(i2);
                if (i == i2) {
                    textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                } else {
                    textView.setTextSize(1, this.mXiaoSize);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                }
            }
            this.mTv = (TextView) getChildAt(i);
            post(new Runnable() { // from class: com.alibaba.pictures.bricks.view.EqualLinearView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1788731140")) {
                        ipChange2.ipc$dispatch("1788731140", new Object[]{this});
                    } else if (EqualLinearView.this.mTv == null) {
                    } else {
                        EqualLinearView equalLinearView = EqualLinearView.this;
                        equalLinearView.mStartX = equalLinearView.mTv.getLeft() + ((EqualLinearView.this.mTv.getWidth() - EqualLinearView.this.mLineWidth) / 2.0f);
                        EqualLinearView equalLinearView2 = EqualLinearView.this;
                        equalLinearView2.mStopX = equalLinearView2.mStartX + EqualLinearView.this.mLineWidth;
                        if (EqualLinearView.this.mLastStartX == 0.0f && EqualLinearView.this.mLastStopX == 0.0f) {
                            EqualLinearView equalLinearView3 = EqualLinearView.this;
                            equalLinearView3.mLastStartX = equalLinearView3.mStartX;
                            EqualLinearView equalLinearView4 = EqualLinearView.this;
                            equalLinearView4.mLastStopX = equalLinearView4.mStopX;
                        }
                        EqualLinearView equalLinearView5 = EqualLinearView.this;
                        equalLinearView5.startAnim(equalLinearView5.mLastStartX, EqualLinearView.this.mLastStopX, EqualLinearView.this.mStartX, EqualLinearView.this.mStopX);
                    }
                }
            });
        }
    }

    public EqualLinearView setFontColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983724389")) {
            return (EqualLinearView) ipChange.ipc$dispatch("1983724389", new Object[]{this, Integer.valueOf(i)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i;
        return this;
    }

    public EqualLinearView setFontSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2145514146")) {
            return (EqualLinearView) ipChange.ipc$dispatch("2145514146", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mXiaoSize = i;
        this.mDaSize = i2;
        return this;
    }

    public EqualLinearView setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306129858")) {
            return (EqualLinearView) ipChange.ipc$dispatch("-1306129858", new Object[]{this, Integer.valueOf(i)});
        }
        this.mHeight = i;
        return this;
    }

    public EqualLinearView setLineShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-6182045")) {
            return (EqualLinearView) ipChange.ipc$dispatch("-6182045", new Object[]{this, Boolean.valueOf(z)});
        }
        this.mIsShowLine = z;
        return this;
    }

    public EqualLinearView setOnTitleClickListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912149300")) {
            return (EqualLinearView) ipChange.ipc$dispatch("-1912149300", new Object[]{this, onClickListener});
        }
        this.mOnClickListener = onClickListener;
        return this;
    }

    public EqualLinearView setTitle(List<ScrollTitleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529109595")) {
            return (EqualLinearView) ipChange.ipc$dispatch("-1529109595", new Object[]{this, list});
        }
        this.mTitleList = list;
        return this;
    }

    public void startAnim(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667376074")) {
            ipChange.ipc$dispatch("1667376074", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
        } else if (f == f3) {
            this.mStartX = f3;
            this.mStopX = f4;
            this.mTv.setTextSize(1, this.mDaSize);
            this.mSrcollStart = false;
            invalidate();
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new C3579b(f, f3, f4));
            ofInt.start();
        }
    }

    public EqualLinearView setFontColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "313552338")) {
            return (EqualLinearView) ipChange.ipc$dispatch("313552338", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i2;
        return this;
    }

    public EqualLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDaSize = 16;
        this.mXiaoSize = 16;
        this.mHeight = 45;
        this.mIsShowLine = true;
        this.mSelectedFontColor = R$color.bricks_000000;
        this.mUnSelectedFontColor = R$color.bricks_999999;
        this.mPaint = new Paint();
        this.mLastStartX = 0.0f;
        this.mLastStopX = 0.0f;
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.mContext = context;
        initView();
    }
}