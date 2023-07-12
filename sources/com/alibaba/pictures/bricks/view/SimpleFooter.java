package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import tb.a8;
import tb.df2;
import tb.fv1;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SimpleFooter extends InternalAbstract {
    private static transient /* synthetic */ IpChange $ipChange;
    protected Integer mAccentColor;
    protected a8 mArrowDrawable;
    protected ImageView mArrowView;
    protected int mBackgroundColor;
    protected LinearLayout mCenterLayout;
    protected int mFinishDuration;
    protected int mPaddingBottom;
    protected int mPaddingTop;
    protected Integer mPrimaryColor;
    protected fv1 mProgressDrawable;
    protected LoadingView mProgressView;
    protected RefreshKernel mRefreshKernel;
    protected TextView mTitleText;

    public SimpleFooter(Context context) {
        this(context, null);
        this.mSpinnerStyle = df2.Translate;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1661495515")) {
            ipChange.ipc$dispatch("-1661495515", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mArrowView.animate().cancel();
        this.mProgressView.stopLoading();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1323653620")) {
            return ((Integer) ipChange.ipc$dispatch("1323653620", new Object[]{this, refreshLayout, Boolean.valueOf(z)})).intValue();
        }
        LoadingView loadingView = this.mProgressView;
        loadingView.stopLoading();
        loadingView.setVisibility(8);
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448862521")) {
            ipChange.ipc$dispatch("-448862521", new Object[]{this, refreshKernel, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRefreshKernel = refreshKernel;
        refreshKernel.requestDrawBackgroundFor(this, this.mBackgroundColor);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1857287163")) {
            ipChange.ipc$dispatch("1857287163", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.mPaddingTop, getPaddingRight(), this.mPaddingBottom);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566449175")) {
            ipChange.ipc$dispatch("-566449175", new Object[]{this, refreshLayout, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            onStartAnimator(refreshLayout, i, i2);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091965243")) {
            ipChange.ipc$dispatch("-2091965243", new Object[]{this, refreshLayout, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        LoadingView loadingView = this.mProgressView;
        loadingView.setVisibility(0);
        loadingView.startLoading();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746422421")) {
            ipChange.ipc$dispatch("-746422421", new Object[]{this, refreshLayout, refreshState, refreshState2});
        }
    }

    public SimpleFooter setAccentColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-947718936")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-947718936", new Object[]{this, Integer.valueOf(i)});
        }
        this.mAccentColor = Integer.valueOf(i);
        this.mTitleText.setTextColor(i);
        a8 a8Var = this.mArrowDrawable;
        if (a8Var != null) {
            a8Var.a(i);
        }
        fv1 fv1Var = this.mProgressDrawable;
        if (fv1Var != null) {
            fv1Var.a(i);
        }
        return this;
    }

    public SimpleFooter setAccentColorId(@ColorRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002610787")) {
            return (SimpleFooter) ipChange.ipc$dispatch("2002610787", new Object[]{this, Integer.valueOf(i)});
        }
        setAccentColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public SimpleFooter setArrowDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033038963")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-1033038963", new Object[]{this, drawable});
        }
        this.mArrowDrawable = null;
        this.mArrowView.setImageDrawable(drawable);
        return this;
    }

    public SimpleFooter setArrowResource(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "900116262")) {
            return (SimpleFooter) ipChange.ipc$dispatch("900116262", new Object[]{this, Integer.valueOf(i)});
        }
        this.mArrowDrawable = null;
        this.mArrowView.setImageResource(i);
        return this;
    }

    public SimpleFooter setDrawableArrowSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408840664")) {
            return (SimpleFooter) ipChange.ipc$dispatch("408840664", new Object[]{this, Float.valueOf(f)});
        }
        ImageView imageView = this.mArrowView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int a = s60.INSTANCE.a(getContext(), f);
        layoutParams.width = a;
        layoutParams.height = a;
        imageView.setLayoutParams(layoutParams);
        return this;
    }

    public SimpleFooter setDrawableMarginRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1001085180")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1001085180", new Object[]{this, Float.valueOf(f)});
        }
        ImageView imageView = this.mArrowView;
        LoadingView loadingView = this.mProgressView;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) loadingView.getLayoutParams();
        int a = s60.INSTANCE.a(getContext(), f);
        marginLayoutParams2.rightMargin = a;
        marginLayoutParams.rightMargin = a;
        imageView.setLayoutParams(marginLayoutParams);
        loadingView.setLayoutParams(marginLayoutParams2);
        return this;
    }

    public SimpleFooter setDrawableProgressSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217752658")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1217752658", new Object[]{this, Float.valueOf(f)});
        }
        LoadingView loadingView = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = loadingView.getLayoutParams();
        int a = s60.INSTANCE.a(getContext(), f);
        layoutParams.width = a;
        layoutParams.height = a;
        loadingView.setLayoutParams(layoutParams);
        return this;
    }

    public SimpleFooter setDrawableSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108280517")) {
            return (SimpleFooter) ipChange.ipc$dispatch("2108280517", new Object[]{this, Float.valueOf(f)});
        }
        ImageView imageView = this.mArrowView;
        LoadingView loadingView = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = loadingView.getLayoutParams();
        s60 s60Var = s60.INSTANCE;
        int a = s60Var.a(getContext(), f);
        layoutParams2.width = a;
        layoutParams.width = a;
        int a2 = s60Var.a(getContext(), f);
        layoutParams2.height = a2;
        layoutParams.height = a2;
        imageView.setLayoutParams(layoutParams);
        loadingView.setLayoutParams(layoutParams2);
        return this;
    }

    public SimpleFooter setFinishDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724357872")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-724357872", new Object[]{this, Integer.valueOf(i)});
        }
        this.mFinishDuration = i;
        return this;
    }

    public SimpleFooter setPrimaryColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595888886")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-595888886", new Object[]{this, Integer.valueOf(i)});
        }
        Integer valueOf = Integer.valueOf(i);
        this.mPrimaryColor = valueOf;
        this.mBackgroundColor = valueOf.intValue();
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestDrawBackgroundFor(this, this.mPrimaryColor.intValue());
        }
        return this;
    }

    public SimpleFooter setPrimaryColorId(@ColorRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "808872453")) {
            return (SimpleFooter) ipChange.ipc$dispatch("808872453", new Object[]{this, Integer.valueOf(i)});
        }
        setPrimaryColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public SimpleFooter setProgressDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308962545")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-308962545", new Object[]{this, drawable});
        }
        this.mProgressDrawable = null;
        this.mProgressView.setImageDrawable(drawable);
        return this;
    }

    public SimpleFooter setProgressResource(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-863265052")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-863265052", new Object[]{this, Integer.valueOf(i)});
        }
        this.mProgressDrawable = null;
        this.mProgressView.setImageResource(i);
        return this;
    }

    public SimpleFooter setSpinnerStyle(df2 df2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-464721024")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-464721024", new Object[]{this, df2Var});
        }
        this.mSpinnerStyle = df2Var;
        return this;
    }

    public SimpleFooter setTextSizeTitle(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239014570")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-1239014570", new Object[]{this, Float.valueOf(f)});
        }
        this.mTitleText.setTextSize(f);
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestRemeasureHeightFor(this);
        }
        return this;
    }

    public SimpleFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mFinishDuration = 0;
        this.mPaddingTop = 20;
        this.mPaddingBottom = 20;
        this.mSpinnerStyle = df2.Translate;
        this.mArrowView = new ImageView(context);
        TextView textView = new TextView(context);
        this.mTitleText = textView;
        textView.setTextColor(-10066330);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mCenterLayout = linearLayout;
        linearLayout.setGravity(1);
        this.mCenterLayout.setOrientation(1);
        View.inflate(context, R$layout.bricks_refresh_footer, this);
        this.mArrowView = (ImageView) findViewById(R$id.classics_arrow);
        this.mProgressView = (LoadingView) findViewById(R$id.footer_classics_progress);
        this.mTitleText = (TextView) findViewById(R$id.srl_classics_title);
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                s60 s60Var = s60.INSTANCE;
                int b = s60Var.b(context, this.mPaddingTop);
                this.mPaddingTop = b;
                int paddingRight = getPaddingRight();
                int b2 = s60Var.b(context, this.mPaddingBottom);
                this.mPaddingBottom = b2;
                setPadding(paddingLeft, b, paddingRight, b2);
                return;
            }
            int paddingLeft2 = getPaddingLeft();
            int b3 = s60.INSTANCE.b(context, this.mPaddingTop);
            this.mPaddingTop = b3;
            int paddingRight2 = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            this.mPaddingBottom = paddingBottom;
            setPadding(paddingLeft2, b3, paddingRight2, paddingBottom);
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mPaddingTop = paddingTop;
            int paddingRight3 = getPaddingRight();
            int b4 = s60.INSTANCE.b(context, this.mPaddingBottom);
            this.mPaddingBottom = b4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, b4);
        } else {
            this.mPaddingTop = getPaddingTop();
            this.mPaddingBottom = getPaddingBottom();
        }
    }
}
