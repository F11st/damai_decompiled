package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.scwang.smartrefresh.layout.R$id;
import com.scwang.smartrefresh.layout.R$layout;
import com.scwang.smartrefresh.layout.R$string;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import tb.a8;
import tb.df2;
import tb.fv1;
import tb.zd2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ClassicsFooter extends InternalClassics<ClassicsFooter> implements RefreshFooter {
    public static String REFRESH_FOOTER_FAILED;
    public static String REFRESH_FOOTER_FINISH;
    public static String REFRESH_FOOTER_LOADING;
    public static String REFRESH_FOOTER_NOTHING;
    public static String REFRESH_FOOTER_PULLING;
    public static String REFRESH_FOOTER_REFRESHING;
    public static String REFRESH_FOOTER_RELEASE;
    protected boolean mNoMoreData;
    protected String mTextFailed;
    protected String mTextFinish;
    protected String mTextLoading;
    protected String mTextNothing;
    protected String mTextPulling;
    protected String mTextRefreshing;
    protected String mTextRelease;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RefreshState.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RefreshState.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RefreshState.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ClassicsFooter(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        if (this.mNoMoreData) {
            return 0;
        }
        this.mTitleText.setText(z ? this.mTextFinish : this.mTextFailed);
        return super.onFinish(refreshLayout, z);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        if (this.mNoMoreData) {
            return;
        }
        super.onStartAnimator(refreshLayout, i, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        ImageView imageView = this.mArrowView;
        if (this.mNoMoreData) {
            return;
        }
        switch (a.a[refreshState2.ordinal()]) {
            case 1:
                imageView.setVisibility(0);
                break;
            case 2:
                break;
            case 3:
            case 4:
                imageView.setVisibility(8);
                this.mTitleText.setText(this.mTextLoading);
                return;
            case 5:
                this.mTitleText.setText(this.mTextRelease);
                imageView.animate().rotation(0.0f);
                return;
            case 6:
                this.mTitleText.setText(this.mTextRefreshing);
                imageView.setVisibility(8);
                return;
            default:
                return;
        }
        this.mTitleText.setText(this.mTextPulling);
        imageView.animate().rotation(180.0f);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean setNoMoreData(boolean z) {
        if (this.mNoMoreData != z) {
            this.mNoMoreData = z;
            ImageView imageView = this.mArrowView;
            if (z) {
                this.mTitleText.setText(this.mTextNothing);
                imageView.setVisibility(8);
                return true;
            }
            this.mTitleText.setText(this.mTextPulling);
            imageView.setVisibility(0);
            return true;
        }
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (this.mSpinnerStyle == df2.FixedBehind) {
            super.setPrimaryColors(iArr);
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mNoMoreData = false;
        View.inflate(context, R$layout.srl_classics_footer, this);
        ImageView imageView = (ImageView) findViewById(R$id.srl_classics_arrow);
        this.mArrowView = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.srl_classics_progress);
        this.mProgressView = imageView2;
        this.mTitleText = (TextView) findViewById(R$id.srl_classics_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsFooter);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClassicsFooter_srlDrawableMarginRight, zd2.dp2px(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i = R$styleable.ClassicsFooter_srlDrawableArrowSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i, layoutParams.height);
        int i2 = R$styleable.ClassicsFooter_srlDrawableProgressSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i2, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i2, layoutParams2.height);
        int i3 = R$styleable.ClassicsFooter_srlDrawableSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i3, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i3, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i3, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i3, layoutParams2.height);
        this.mFinishDuration = obtainStyledAttributes.getInt(R$styleable.ClassicsFooter_srlFinishDuration, this.mFinishDuration);
        this.mSpinnerStyle = df2.values[obtainStyledAttributes.getInt(R$styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.mSpinnerStyle.a)];
        int i4 = R$styleable.ClassicsFooter_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i4)) {
            this.mArrowView.setImageDrawable(obtainStyledAttributes.getDrawable(i4));
        } else if (this.mArrowView.getDrawable() == null) {
            a8 a8Var = new a8();
            this.mArrowDrawable = a8Var;
            a8Var.a(-10066330);
            this.mArrowView.setImageDrawable(this.mArrowDrawable);
        }
        int i5 = R$styleable.ClassicsFooter_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.mProgressView.setImageDrawable(obtainStyledAttributes.getDrawable(i5));
        } else if (this.mProgressView.getDrawable() == null) {
            fv1 fv1Var = new fv1();
            this.mProgressDrawable = fv1Var;
            fv1Var.a(-10066330);
            this.mProgressView.setImageDrawable(this.mProgressDrawable);
        }
        int i6 = R$styleable.ClassicsFooter_srlTextSizeTitle;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.mTitleText.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i6, zd2.dp2px(16.0f)));
        }
        int i7 = R$styleable.ClassicsFooter_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i7)) {
            super.setPrimaryColor(obtainStyledAttributes.getColor(i7, 0));
        }
        int i8 = R$styleable.ClassicsFooter_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i8)) {
            super.setAccentColor(obtainStyledAttributes.getColor(i8, 0));
        }
        int i9 = R$styleable.ClassicsFooter_srlTextPulling;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.mTextPulling = obtainStyledAttributes.getString(i9);
        } else {
            String str = REFRESH_FOOTER_PULLING;
            if (str != null) {
                this.mTextPulling = str;
            } else {
                this.mTextPulling = context.getString(R$string.srl_footer_pulling);
            }
        }
        int i10 = R$styleable.ClassicsFooter_srlTextRelease;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.mTextRelease = obtainStyledAttributes.getString(i10);
        } else {
            String str2 = REFRESH_FOOTER_RELEASE;
            if (str2 != null) {
                this.mTextRelease = str2;
            } else {
                this.mTextRelease = context.getString(R$string.srl_footer_release);
            }
        }
        int i11 = R$styleable.ClassicsFooter_srlTextLoading;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.mTextLoading = obtainStyledAttributes.getString(i11);
        } else {
            String str3 = REFRESH_FOOTER_LOADING;
            if (str3 != null) {
                this.mTextLoading = str3;
            } else {
                this.mTextLoading = context.getString(R$string.srl_footer_loading);
            }
        }
        int i12 = R$styleable.ClassicsFooter_srlTextRefreshing;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.mTextRefreshing = obtainStyledAttributes.getString(i12);
        } else {
            String str4 = REFRESH_FOOTER_REFRESHING;
            if (str4 != null) {
                this.mTextRefreshing = str4;
            } else {
                this.mTextRefreshing = context.getString(R$string.srl_footer_refreshing);
            }
        }
        int i13 = R$styleable.ClassicsFooter_srlTextFinish;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.mTextFinish = obtainStyledAttributes.getString(i13);
        } else {
            String str5 = REFRESH_FOOTER_FINISH;
            if (str5 != null) {
                this.mTextFinish = str5;
            } else {
                this.mTextFinish = context.getString(R$string.srl_footer_finish);
            }
        }
        int i14 = R$styleable.ClassicsFooter_srlTextFailed;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.mTextFailed = obtainStyledAttributes.getString(i14);
        } else {
            String str6 = REFRESH_FOOTER_FAILED;
            if (str6 != null) {
                this.mTextFailed = str6;
            } else {
                this.mTextFailed = context.getString(R$string.srl_footer_failed);
            }
        }
        int i15 = R$styleable.ClassicsFooter_srlTextNothing;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.mTextNothing = obtainStyledAttributes.getString(i15);
        } else {
            String str7 = REFRESH_FOOTER_NOTHING;
            if (str7 != null) {
                this.mTextNothing = str7;
            } else {
                this.mTextNothing = context.getString(R$string.srl_footer_nothing);
            }
        }
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        this.mTitleText.setText(isInEditMode() ? this.mTextLoading : this.mTextPulling);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }
}
