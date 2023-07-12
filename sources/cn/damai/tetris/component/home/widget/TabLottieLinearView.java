package cn.damai.tetris.component.home.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.uikit.snake.ScrollTitleBean;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.ali.user.mobile.utils.MD5Util;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TabLottieLinearView extends TabLinearView {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean colorMode;
    public OnBindListener listener;
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
    private TextView mTv;
    private PageListener pageListener;
    private ViewPager pager;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnBindListener {
        void onBind(View view, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class PageListener implements ViewPager.OnPageChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        private PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-18928645")) {
                ipChange.ipc$dispatch("-18928645", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1980570726")) {
                ipChange.ipc$dispatch("-1980570726", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                return;
            }
            if (i2 > 0) {
                TabLottieLinearView tabLottieLinearView = TabLottieLinearView.this;
                tabLottieLinearView.mStartX = tabLottieLinearView.mLastStartX + ((TabLottieLinearView.this.mStartX - TabLottieLinearView.this.mLastStartX) * f);
            } else {
                TabLottieLinearView tabLottieLinearView2 = TabLottieLinearView.this;
                tabLottieLinearView2.mStartX = tabLottieLinearView2.mLastStartX - ((TabLottieLinearView.this.mLastStartX - TabLottieLinearView.this.mStartX) * f);
            }
            TabLottieLinearView.this.invalidate();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1620330234")) {
                ipChange.ipc$dispatch("-1620330234", new Object[]{this, Integer.valueOf(i)});
            }
        }

        /* synthetic */ PageListener(TabLottieLinearView tabLottieLinearView, a aVar) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        a(TabLottieLinearView tabLottieLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-149696691")) {
                ipChange.ipc$dispatch("-149696691", new Object[]{this, aVar});
                return;
            }
            this.a.setComposition(aVar);
            this.a.playAnimation();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements LottieListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        b(TabLottieLinearView tabLottieLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // com.airbnb.lottie.LottieListener
        public void onResult(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-970335935")) {
                ipChange.ipc$dispatch("-970335935", new Object[]{this, obj});
            } else {
                this.a.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        c(TabLottieLinearView tabLottieLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1805006171")) {
                ipChange.ipc$dispatch("-1805006171", new Object[]{this, dVar});
            } else {
                this.a.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottieAnimationView a;

        d(TabLottieLinearView tabLottieLinearView, LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1259180934")) {
                ipChange.ipc$dispatch("-1259180934", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
            } else {
                this.a.setImageDrawable(drawable);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View.OnClickListener a;

        e(TabLottieLinearView tabLottieLinearView, View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "910680053")) {
                ipChange.ipc$dispatch("910680053", new Object[]{this, view});
            } else {
                this.a.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;

        f(float f, float f2, float f3) {
            this.a = f;
            this.b = f2;
            this.c = f3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "906409342")) {
                ipChange.ipc$dispatch("906409342", new Object[]{this, valueAnimator});
                return;
            }
            TabLottieLinearView.this.mAnimatedValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            float f = TabLottieLinearView.this.mAnimatedValue / 100.0f;
            float f2 = this.a;
            float f3 = this.b;
            if (f2 < f3) {
                TabLottieLinearView.this.mStartX = f2 + ((f3 - f2) * f);
                TabLottieLinearView tabLottieLinearView = TabLottieLinearView.this;
                tabLottieLinearView.mStopX = tabLottieLinearView.mStartX + TabLottieLinearView.this.mLineWidth;
            } else {
                TabLottieLinearView.this.mStartX = f2 - ((f2 - f3) * f);
                TabLottieLinearView tabLottieLinearView2 = TabLottieLinearView.this;
                tabLottieLinearView2.mStopX = tabLottieLinearView2.mStartX + TabLottieLinearView.this.mLineWidth;
            }
            if (TabLottieLinearView.this.mAnimatedValue == 100.0f) {
                TabLottieLinearView.this.mLastStartX = this.b;
                TabLottieLinearView.this.mLastStopX = this.c;
                TabLottieLinearView.this.mSrcollStart = false;
            }
            TabLottieLinearView.this.invalidate();
        }
    }

    public TabLottieLinearView(Context context) {
        super(context);
        this.mLastStartX = 0.0f;
        this.mLastStopX = 0.0f;
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.pageListener = new PageListener(this, null);
        this.mPaddingLeftRight = 0;
        this.colorMode = true;
        this.mContext = context;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int selectTitle(int i) {
        View childAt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-84685861")) {
            return ((Integer) ipChange.ipc$dispatch("-84685861", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (this.mPaddingLeftRight > 0) {
            childAt = getChildAt(i + 1);
        } else {
            childAt = getChildAt(i);
        }
        if (childAt != null) {
            float right = childAt.getRight() - childAt.getLeft();
            float f2 = this.mLineWidth;
            float left = childAt.getLeft() + ((right - f2) / 2.0f);
            this.mStartX = left;
            this.mStopX = left + f2;
        }
        if (this.mLastStartX == 0.0f && this.mLastStopX == 0.0f) {
            this.mLastStartX = this.mStartX;
            this.mLastStopX = this.mStopX;
        }
        startAnim(i, this.mLastStartX, this.mLastStopX, this.mStartX, this.mStopX);
        return i;
    }

    public void enableColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171078377")) {
            ipChange.ipc$dispatch("-1171078377", new Object[]{this});
            return;
        }
        this.colorMode = true;
        invalidate();
    }

    public void enableWhite() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621141649")) {
            ipChange.ipc$dispatch("1621141649", new Object[]{this});
            return;
        }
        this.colorMode = false;
        invalidate();
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38454402")) {
            ipChange.ipc$dispatch("-38454402", new Object[]{this});
            return;
        }
        setWillNotDraw(false);
        setOrientation(0);
        setGravity(16);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStrokeWidth(dip2px(4.0f));
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mLineWidth = dip2px(18.0f);
        float f2 = this.mStartX;
        int i = this.mStartY;
        this.mPaint.setShader(new LinearGradient(f2, i, this.mStopX, i, Color.parseColor("#FF70B8"), Color.parseColor("#FFBEED"), Shader.TileMode.CLAMP));
        this.mPaint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.tetris.component.home.widget.TabLinearView, android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199744277")) {
            ipChange.ipc$dispatch("199744277", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        if (this.mIsShowLine) {
            this.mStartY = dip2px(this.mHeight / 2) + dip2px((this.mDaSize / 2) + 8);
            Paint paint = this.mPaint;
            if (paint != null) {
                if (this.colorMode) {
                    float f2 = this.mStartX;
                    int i = this.mStartY;
                    this.mPaint.setShader(new LinearGradient(f2, i, this.mStopX, i, Color.parseColor("#FF70B8"), Color.parseColor("#FFBEED"), Shader.TileMode.CLAMP));
                } else {
                    paint.setShader(null);
                    this.mPaint.setColor(this.mContext.getResources().getColor(R$color.white));
                }
                float f3 = this.mStartX;
                int i2 = this.mStartY;
                canvas.drawLine(f3, i2, this.mStopX, i2, this.mPaint);
            }
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView
    public void setDefaultPadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-59680962")) {
            ipChange.ipc$dispatch("-59680962", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mPaddingLeftRight = i;
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView
    public void setFontSize(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784074142")) {
            ipChange.ipc$dispatch("784074142", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mSrcollStart = true;
        this.mSelectIndex = i;
        if (this.mPaddingLeftRight > 0) {
            for (int i2 = 1; i2 < getChildCount() - 1; i2++) {
                TextView textView = (TextView) ((ViewGroup) getChildAt(i2)).getChildAt(0);
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
                TextView textView2 = (TextView) ((ViewGroup) getChildAt(i5)).getChildAt(0);
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
        TextView textView3 = null;
        if (this.mPaddingLeftRight > 0) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i + 1);
            if (viewGroup != null) {
                textView3 = (TextView) viewGroup.getChildAt(0);
            }
        } else {
            ViewGroup viewGroup2 = (ViewGroup) getChildAt(i);
            if (viewGroup2 != null) {
                textView3 = (TextView) viewGroup2.getChildAt(0);
            }
        }
        if (textView3 != null) {
            this.mTv = textView3;
            textView3.setTextSize(1, this.mDaSize);
            postDelayed(new Runnable() { // from class: cn.damai.tetris.component.home.widget.TabLottieLinearView.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1850792838")) {
                        ipChange2.ipc$dispatch("-1850792838", new Object[]{this});
                    } else {
                        TabLottieLinearView.this.selectTitle(i);
                    }
                }
            }, 50L);
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView
    public void setLineColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "484239357")) {
            ipChange.ipc$dispatch("484239357", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mPaint.setColor(i);
        invalidate();
    }

    public void setOnBindListener(OnBindListener onBindListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736936138")) {
            ipChange.ipc$dispatch("-736936138", new Object[]{this, onBindListener});
        } else {
            this.listener = onBindListener;
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView
    public void setTitle(List<ScrollTitleBean> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863523861")) {
            ipChange.ipc$dispatch("-1863523861", new Object[]{this, list, onClickListener});
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
                    View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.common_scroll_title, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R$id.tv_title);
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R$id.lottie_view);
                    inflate.setTag(scrollTitleBean);
                    textView.setText(scrollTitleBean.name);
                    textView.setTextSize(1, this.mXiaoSize);
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    layoutParams.gravity = 16;
                    inflate.setPadding(dip2px(this.mSpace / 2), 0, dip2px(this.mSpace / 2), 0);
                    inflate.setLayoutParams(layoutParams);
                    if (TextUtils.isEmpty(scrollTitleBean.picUrl) && TextUtils.isEmpty(scrollTitleBean.picJson)) {
                        lottieAnimationView.setVisibility(8);
                    } else {
                        lottieAnimationView.setVisibility(0);
                        if (!TextUtils.isEmpty(scrollTitleBean.picJson)) {
                            String str = scrollTitleBean.picJson;
                            LottieTask<com.airbnb.lottie.a> m = com.airbnb.lottie.b.m(str, MD5Util.getMD5(str));
                            m.f(new a(this, lottieAnimationView));
                            m.e(new b(this, lottieAnimationView));
                        } else if (!TextUtils.isEmpty(scrollTitleBean.picUrl)) {
                            cn.damai.common.image.a.b().h(this.mContext).c(scrollTitleBean.picUrl).n(new d(this, lottieAnimationView)).e(new c(this, lottieAnimationView)).f();
                        }
                    }
                    inflate.setOnClickListener(new e(this, onClickListener));
                    addView(inflate);
                    OnBindListener onBindListener = this.listener;
                    if (onBindListener != null) {
                        onBindListener.onBind(inflate, i);
                    }
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
        if (AndroidInstantRuntime.support(ipChange, "-412053824")) {
            ipChange.ipc$dispatch("-412053824", new Object[]{this, viewPager});
            return;
        }
        this.pager = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        viewPager.addOnPageChangeListener(this.pageListener);
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView
    public void startAnim(int i, float f2, float f3, float f4, float f5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307390271")) {
            ipChange.ipc$dispatch("307390271", new Object[]{this, Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)});
        } else if (f2 == f4) {
            this.mStartX = f4;
            this.mStopX = f5;
            TextView textView = this.mTv;
            if (textView != null) {
                textView.setTextSize(1, this.mDaSize);
                this.mTv.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
            }
            invalidate();
            this.mSrcollStart = false;
        } else {
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new f(f2, f4, f5));
            ofInt.start();
        }
    }

    @Override // cn.damai.tetris.component.home.widget.TabLinearView
    public void updateFontColor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157780556")) {
            ipChange.ipc$dispatch("1157780556", new Object[]{this});
        } else if (this.mPaddingLeftRight > 0) {
            for (int i = 1; i < getChildCount() - 1; i++) {
                TextView textView = (TextView) ((ViewGroup) getChildAt(i)).getChildAt(0);
                if (this.mSelectIndex == i - 1) {
                    textView.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                } else {
                    textView.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                }
            }
        } else {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                TextView textView2 = (TextView) ((ViewGroup) getChildAt(i2)).getChildAt(0);
                if (this.mSelectIndex == i2) {
                    textView2.setTextColor(this.mContext.getResources().getColor(this.mSelectedFontColor));
                } else {
                    textView2.setTextColor(this.mContext.getResources().getColor(this.mUnSelectedFontColor));
                }
            }
        }
    }

    public TabLottieLinearView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastStartX = 0.0f;
        this.mLastStopX = 0.0f;
        this.mStartY = 0;
        this.mSelectIndex = -1;
        this.mLineWidth = 0.0f;
        this.pageListener = new PageListener(this, null);
        this.mPaddingLeftRight = 0;
        this.colorMode = true;
        this.mContext = context;
        initView();
    }
}
