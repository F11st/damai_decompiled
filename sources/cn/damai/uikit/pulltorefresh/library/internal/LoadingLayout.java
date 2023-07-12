package cn.damai.uikit.pulltorefresh.library.internal;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$string;
import cn.damai.uikit.R$styleable;
import cn.damai.uikit.pulltorefresh.library.ILoadingLayout;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ew2;
import tb.kg2;
import tb.wx2;

/* compiled from: Taobao */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    static final Interpolator ANIMATION_INTERPOLATOR = new LinearInterpolator();
    private static int mStatusBarHeight = 0;
    protected final ImageView mHeaderImage;
    protected final ProgressBar mHeaderProgress;
    private final TextView mHeaderText;
    private RelativeLayout mInnerLayout;
    private boolean mIsImmersion;
    protected final PullToRefreshBase.Mode mMode;
    private CharSequence mPullLabel;
    private CharSequence mRefreshingLabel;
    private CharSequence mReleaseLabel;
    protected final PullToRefreshBase.Orientation mScrollDirection;
    private final TextView mSubHeaderText;
    private boolean mUseIntrinsicAnimation;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.pulltorefresh.library.internal.LoadingLayout$a */
    /* loaded from: classes8.dex */
    static /* synthetic */ class C2540a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[PullToRefreshBase.Mode.values().length];
            b = iArr;
            try {
                iArr[PullToRefreshBase.Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[PullToRefreshBase.Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[PullToRefreshBase.Orientation.values().length];
            a = iArr2;
            try {
                iArr2[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray, boolean z) {
        super(context);
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        this.mMode = mode;
        this.mScrollDirection = orientation;
        if (!z) {
            if (C2540a.a[orientation.ordinal()] != 1) {
                LayoutInflater.from(context).inflate(R$layout.pull_to_refresh_header_vertical, this);
            } else {
                LayoutInflater.from(context).inflate(R$layout.pull_to_refresh_header_horizontal, this);
            }
        } else {
            LayoutInflater.from(context).inflate(R$layout.pull_to_refresh_head_vertical_damai, this);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.fl_inner);
        this.mInnerLayout = relativeLayout;
        this.mHeaderText = (TextView) relativeLayout.findViewById(R$id.pull_to_refresh_text);
        this.mHeaderProgress = (ProgressBar) this.mInnerLayout.findViewById(R$id.pull_to_refresh_progress);
        this.mSubHeaderText = (TextView) this.mInnerLayout.findViewById(R$id.pull_to_refresh_sub_text);
        this.mHeaderImage = (ImageView) this.mInnerLayout.findViewById(R$id.pull_to_refresh_image);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mInnerLayout.getLayoutParams();
        int[] iArr = C2540a.b;
        if (iArr[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 80 : 5;
            this.mPullLabel = context.getString(R$string.pull_to_refresh_pull_label);
            this.mRefreshingLabel = context.getString(R$string.pull_to_refresh_refreshing_label);
            this.mReleaseLabel = context.getString(R$string.pull_to_refresh_release_label);
        } else {
            layoutParams.gravity = orientation == PullToRefreshBase.Orientation.VERTICAL ? 48 : 3;
            this.mPullLabel = context.getString(R$string.pull_to_refresh_from_bottom_pull_label);
            this.mRefreshingLabel = context.getString(R$string.pull_to_refresh_from_bottom_refreshing_label);
            this.mReleaseLabel = context.getString(R$string.pull_to_refresh_from_bottom_release_label);
        }
        int i = R$styleable.PullToRefresh_ptrIsImmersion;
        if (typedArray.hasValue(i)) {
            this.mIsImmersion = typedArray.getBoolean(i, false);
        }
        int i2 = R$styleable.PullToRefresh_ptrHeaderBackground;
        if (typedArray.hasValue(i2) && (drawable = typedArray.getDrawable(i2)) != null) {
            wx2.b(this, drawable);
        }
        int i3 = R$styleable.PullToRefresh_ptrHeaderTextAppearance;
        if (typedArray.hasValue(i3)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i3, typedValue);
            setTextAppearance(typedValue.data);
        }
        int i4 = R$styleable.PullToRefresh_ptrSubHeaderTextAppearance;
        if (typedArray.hasValue(i4)) {
            TypedValue typedValue2 = new TypedValue();
            typedArray.getValue(i4, typedValue2);
            setSubTextAppearance(typedValue2.data);
        }
        int i5 = R$styleable.PullToRefresh_ptrHeaderTextColor;
        if (typedArray.hasValue(i5) && (colorStateList2 = typedArray.getColorStateList(i5)) != null) {
            setTextColor(colorStateList2);
        }
        int i6 = R$styleable.PullToRefresh_ptrHeaderSubTextColor;
        if (typedArray.hasValue(i6) && (colorStateList = typedArray.getColorStateList(i6)) != null) {
            setSubTextColor(colorStateList);
        }
        int i7 = R$styleable.PullToRefresh_ptrDrawable;
        Drawable drawable2 = typedArray.hasValue(i7) ? typedArray.getDrawable(i7) : null;
        if (iArr[mode.ordinal()] != 1) {
            int i8 = R$styleable.PullToRefresh_ptrDrawableStart;
            if (typedArray.hasValue(i8)) {
                drawable2 = typedArray.getDrawable(i8);
            } else {
                int i9 = R$styleable.PullToRefresh_ptrDrawableTop;
                if (typedArray.hasValue(i9)) {
                    ew2.a("ptrDrawableTop", "ptrDrawableStart");
                    drawable2 = typedArray.getDrawable(i9);
                }
            }
        } else {
            int i10 = R$styleable.PullToRefresh_ptrDrawableEnd;
            if (typedArray.hasValue(i10)) {
                drawable2 = typedArray.getDrawable(i10);
            } else {
                int i11 = R$styleable.PullToRefresh_ptrDrawableBottom;
                if (typedArray.hasValue(i11)) {
                    ew2.a("ptrDrawableBottom", "ptrDrawableEnd");
                    drawable2 = typedArray.getDrawable(i11);
                }
            }
        }
        setLoadingDrawable(drawable2 == null ? context.getResources().getDrawable(getDefaultDrawableResId()) : drawable2);
        initStatuBar((Activity) context);
        reset();
    }

    private void initStatuBar(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096170095")) {
            ipChange.ipc$dispatch("-1096170095", new Object[]{this, activity});
        } else if (!this.mIsImmersion || activity == null) {
        } else {
            View findViewById = findViewById(R$id.loadingLayout_status_bar_space);
            if (Build.VERSION.SDK_INT < 23) {
                if (findViewById != null) {
                    mStatusBarHeight = 0;
                    findViewById.setVisibility(8);
                }
            } else if (findViewById != null) {
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                int a = kg2.a(activity);
                layoutParams.height = a;
                mStatusBarHeight = a;
                findViewById.setVisibility(0);
            }
        }
    }

    private void setSubHeaderText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "968853965")) {
            ipChange.ipc$dispatch("968853965", new Object[]{this, charSequence});
        } else if (this.mSubHeaderText != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.mSubHeaderText.setVisibility(8);
                return;
            }
            this.mSubHeaderText.setText(charSequence);
            if (8 == this.mSubHeaderText.getVisibility()) {
                this.mSubHeaderText.setVisibility(0);
            }
        }
    }

    private void setSubTextAppearance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-547506287")) {
            ipChange.ipc$dispatch("-547506287", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.mSubHeaderText;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
    }

    private void setSubTextColor(ColorStateList colorStateList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1048868497")) {
            ipChange.ipc$dispatch("-1048868497", new Object[]{this, colorStateList});
            return;
        }
        TextView textView = this.mSubHeaderText;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    private void setTextAppearance(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767250509")) {
            ipChange.ipc$dispatch("1767250509", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i);
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setTextAppearance(getContext(), i);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "17791787")) {
            ipChange.ipc$dispatch("17791787", new Object[]{this, colorStateList});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setTextColor(colorStateList);
        }
    }

    public final int getContentSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131637968")) {
            return ((Integer) ipChange.ipc$dispatch("-1131637968", new Object[]{this})).intValue();
        }
        if (C2540a.a[this.mScrollDirection.ordinal()] != 1) {
            return this.mInnerLayout.getHeight();
        }
        return this.mInnerLayout.getWidth();
    }

    protected abstract int getDefaultDrawableResId();

    public final void hideAllViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445456750")) {
            ipChange.ipc$dispatch("-1445456750", new Object[]{this});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null && textView.getVisibility() == 0) {
            this.mHeaderText.setVisibility(4);
        }
        ProgressBar progressBar = this.mHeaderProgress;
        if (progressBar != null && progressBar.getVisibility() == 0) {
            this.mHeaderProgress.setVisibility(4);
        }
        ImageView imageView = this.mHeaderImage;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.mHeaderImage.setVisibility(4);
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 == null || textView2.getVisibility() != 0) {
            return;
        }
        this.mSubHeaderText.setVisibility(4);
    }

    protected abstract void onLoadingDrawableSet(Drawable drawable);

    public final void onPull(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151642621")) {
            ipChange.ipc$dispatch("-151642621", new Object[]{this, Float.valueOf(f)});
        } else if (this.mUseIntrinsicAnimation) {
        } else {
            onPullImpl(f);
        }
    }

    protected abstract void onPullImpl(float f);

    public final void pullToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211577906")) {
            ipChange.ipc$dispatch("-211577906", new Object[]{this});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setText(this.mPullLabel);
        }
        pullToRefreshImpl();
    }

    protected abstract void pullToRefreshImpl();

    public final void refreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496364006")) {
            ipChange.ipc$dispatch("-496364006", new Object[]{this});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setText(this.mRefreshingLabel);
        }
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    protected abstract void refreshingImpl();

    public final void releaseToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900845720")) {
            ipChange.ipc$dispatch("-900845720", new Object[]{this});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setText(this.mReleaseLabel);
        }
        releaseToRefreshImpl();
    }

    protected abstract void releaseToRefreshImpl();

    public final void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967374566")) {
            ipChange.ipc$dispatch("-967374566", new Object[]{this});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setText(this.mPullLabel);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.mUseIntrinsicAnimation) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 != null) {
            if (TextUtils.isEmpty(textView2.getText())) {
                this.mSubHeaderText.setVisibility(8);
            } else {
                this.mSubHeaderText.setVisibility(0);
            }
        }
    }

    protected abstract void resetImpl();

    public final void setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674320637")) {
            ipChange.ipc$dispatch("-1674320637", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        getLayoutParams().height = i;
        requestLayout();
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1640726428")) {
            ipChange.ipc$dispatch("1640726428", new Object[]{this, charSequence});
        } else {
            setSubHeaderText(charSequence);
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public final void setLoadingDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "76719373")) {
            ipChange.ipc$dispatch("76719373", new Object[]{this, drawable});
            return;
        }
        this.mHeaderImage.setImageDrawable(drawable);
        this.mUseIntrinsicAnimation = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738159688")) {
            ipChange.ipc$dispatch("-738159688", new Object[]{this, charSequence});
        } else {
            this.mPullLabel = charSequence;
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322619878")) {
            ipChange.ipc$dispatch("-322619878", new Object[]{this, charSequence});
        } else {
            this.mRefreshingLabel = charSequence;
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "924403550")) {
            ipChange.ipc$dispatch("924403550", new Object[]{this, charSequence});
        } else {
            this.mReleaseLabel = charSequence;
        }
    }

    @Override // cn.damai.uikit.pulltorefresh.library.ILoadingLayout
    public void setTextTypeface(Typeface typeface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202519299")) {
            ipChange.ipc$dispatch("202519299", new Object[]{this, typeface});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public final void setWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1817490938")) {
            ipChange.ipc$dispatch("-1817490938", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        getLayoutParams().width = i;
        requestLayout();
    }

    public final void showInvisibleViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1409577277")) {
            ipChange.ipc$dispatch("-1409577277", new Object[]{this});
            return;
        }
        TextView textView = this.mHeaderText;
        if (textView != null && 4 == textView.getVisibility()) {
            this.mHeaderText.setVisibility(0);
        }
        ProgressBar progressBar = this.mHeaderProgress;
        if (progressBar != null && 4 == progressBar.getVisibility()) {
            this.mHeaderProgress.setVisibility(0);
        }
        ImageView imageView = this.mHeaderImage;
        if (imageView != null && 4 == imageView.getVisibility()) {
            this.mHeaderImage.setVisibility(0);
        }
        TextView textView2 = this.mSubHeaderText;
        if (textView2 == null || 4 != textView2.getVisibility()) {
            return;
        }
        this.mSubHeaderText.setVisibility(0);
    }
}
