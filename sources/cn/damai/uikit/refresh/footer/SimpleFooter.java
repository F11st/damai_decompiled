package cn.damai.uikit.refresh.footer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.irecycler.widget.LoadingView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import tb.a8;
import tb.df2;
import tb.fv1;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class SimpleFooter extends InternalAbstract implements RefreshFooter {
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

    public SimpleFooter(Context context) {
        this(context, null);
        this.mSpinnerStyle = df2.Translate;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1440849617")) {
            ipChange.ipc$dispatch("-1440849617", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mArrowView.animate().cancel();
        this.mProgressView.stopLoading();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1782233258")) {
            return ((Integer) ipChange.ipc$dispatch("1782233258", new Object[]{this, refreshLayout, Boolean.valueOf(z)})).intValue();
        }
        LoadingView loadingView = this.mProgressView;
        loadingView.stopLoading();
        loadingView.setVisibility(8);
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(@NonNull RefreshKernel refreshKernel, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1841044227")) {
            ipChange.ipc$dispatch("-1841044227", new Object[]{this, refreshKernel, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mRefreshKernel = refreshKernel;
        refreshKernel.requestDrawBackgroundFor(this, this.mBackgroundColor);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1841178959")) {
            ipChange.ipc$dispatch("-1841178959", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1311422093")) {
            ipChange.ipc$dispatch("-1311422093", new Object[]{this, refreshLayout, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            onStartAnimator(refreshLayout, i, i2);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "51211643")) {
            ipChange.ipc$dispatch("51211643", new Object[]{this, refreshLayout, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        LoadingView loadingView = this.mProgressView;
        loadingView.setVisibility(0);
        loadingView.startLoading();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-234640523")) {
            ipChange.ipc$dispatch("-234640523", new Object[]{this, refreshLayout, refreshState, refreshState2});
        }
    }

    public SimpleFooter setAccentColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751027712")) {
            return (SimpleFooter) ipChange.ipc$dispatch("751027712", new Object[]{this, Integer.valueOf(i)});
        }
        this.mAccentColor = Integer.valueOf(i);
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
        if (AndroidInstantRuntime.support(ipChange, "617627621")) {
            return (SimpleFooter) ipChange.ipc$dispatch("617627621", new Object[]{this, Integer.valueOf(i)});
        }
        setAccentColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public SimpleFooter setArrowDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857324377")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-1857324377", new Object[]{this, drawable});
        }
        this.mArrowDrawable = null;
        this.mArrowView.setImageDrawable(drawable);
        return this;
    }

    public SimpleFooter setArrowResource(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1610344962")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1610344962", new Object[]{this, Integer.valueOf(i)});
        }
        this.mArrowDrawable = null;
        this.mArrowView.setImageResource(i);
        return this;
    }

    public SimpleFooter setDrawableArrowSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595172752")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1595172752", new Object[]{this, Float.valueOf(f)});
        }
        ImageView imageView = this.mArrowView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int a = q60.a(getContext(), f);
        layoutParams.width = a;
        layoutParams.height = a;
        imageView.setLayoutParams(layoutParams);
        return this;
    }

    public SimpleFooter setDrawableMarginRight(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1497247636")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-1497247636", new Object[]{this, Float.valueOf(f)});
        }
        ImageView imageView = this.mArrowView;
        LoadingView loadingView = this.mProgressView;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) loadingView.getLayoutParams();
        int a = q60.a(getContext(), f);
        marginLayoutParams2.rightMargin = a;
        marginLayoutParams.rightMargin = a;
        imageView.setLayoutParams(marginLayoutParams);
        loadingView.setLayoutParams(marginLayoutParams2);
        return this;
    }

    public SimpleFooter setDrawableProgressSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723178750")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-723178750", new Object[]{this, Float.valueOf(f)});
        }
        LoadingView loadingView = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = loadingView.getLayoutParams();
        int a = q60.a(getContext(), f);
        layoutParams.width = a;
        layoutParams.height = a;
        loadingView.setLayoutParams(layoutParams);
        return this;
    }

    public SimpleFooter setDrawableSize(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1051323759")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1051323759", new Object[]{this, Float.valueOf(f)});
        }
        ImageView imageView = this.mArrowView;
        LoadingView loadingView = this.mProgressView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = loadingView.getLayoutParams();
        int a = q60.a(getContext(), f);
        layoutParams2.width = a;
        layoutParams.width = a;
        int a2 = q60.a(getContext(), f);
        layoutParams2.height = a2;
        layoutParams.height = a2;
        imageView.setLayoutParams(layoutParams);
        loadingView.setLayoutParams(layoutParams2);
        return this;
    }

    public SimpleFooter setFinishDuration(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1266832772")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1266832772", new Object[]{this, Integer.valueOf(i)});
        }
        this.mFinishDuration = i;
        return this;
    }

    public SimpleFooter setPrimaryColor(@ColorInt int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "932869450")) {
            return (SimpleFooter) ipChange.ipc$dispatch("932869450", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-726121297")) {
            return (SimpleFooter) ipChange.ipc$dispatch("-726121297", new Object[]{this, Integer.valueOf(i)});
        }
        setPrimaryColor(ContextCompat.getColor(getContext(), i));
        return this;
    }

    public SimpleFooter setProgressDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707693881")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1707693881", new Object[]{this, drawable});
        }
        this.mProgressDrawable = null;
        this.mProgressView.setImageDrawable(drawable);
        return this;
    }

    public SimpleFooter setProgressResource(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1880219312")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1880219312", new Object[]{this, Integer.valueOf(i)});
        }
        this.mProgressDrawable = null;
        this.mProgressView.setImageResource(i);
        return this;
    }

    public SimpleFooter setSpinnerStyle(df2 df2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1068731112")) {
            return (SimpleFooter) ipChange.ipc$dispatch("1068731112", new Object[]{this, df2Var});
        }
        this.mSpinnerStyle = df2Var;
        return this;
    }

    public SimpleFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mFinishDuration = 0;
        this.mPaddingTop = 20;
        this.mPaddingBottom = 20;
        this.mSpinnerStyle = df2.Translate;
        this.mArrowView = new ImageView(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mCenterLayout = linearLayout;
        linearLayout.setGravity(1);
        this.mCenterLayout.setOrientation(1);
        View.inflate(context, R$layout.simple_refresh_footer, this);
        this.mArrowView = (ImageView) findViewById(R$id.classics_arrow);
        this.mProgressView = (LoadingView) findViewById(R$id.footer_classics_progress);
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int a = q60.a(context, this.mPaddingTop);
                this.mPaddingTop = a;
                int paddingRight = getPaddingRight();
                int a2 = q60.a(context, this.mPaddingBottom);
                this.mPaddingBottom = a2;
                setPadding(paddingLeft, a, paddingRight, a2);
                return;
            }
            int paddingLeft2 = getPaddingLeft();
            int a3 = q60.a(context, this.mPaddingTop);
            this.mPaddingTop = a3;
            int paddingRight2 = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            this.mPaddingBottom = paddingBottom;
            setPadding(paddingLeft2, a3, paddingRight2, paddingBottom);
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.mPaddingTop = paddingTop;
            int paddingRight3 = getPaddingRight();
            int a4 = q60.a(context, this.mPaddingBottom);
            this.mPaddingBottom = a4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, a4);
        } else {
            this.mPaddingTop = getPaddingTop();
            this.mPaddingBottom = getPaddingBottom();
        }
    }
}
