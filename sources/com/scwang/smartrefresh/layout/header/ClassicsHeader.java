package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.motu.crashreporter.Constants;
import com.scwang.smartrefresh.layout.R$id;
import com.scwang.smartrefresh.layout.R$layout;
import com.scwang.smartrefresh.layout.R$string;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import tb.a8;
import tb.df2;
import tb.fv1;
import tb.zd2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ClassicsHeader extends InternalClassics<ClassicsHeader> implements RefreshHeader {
    protected String KEY_LAST_UPDATE_TIME;
    protected boolean mEnableLastTime;
    protected Date mLastTime;
    protected DateFormat mLastUpdateFormat;
    protected TextView mLastUpdateText;
    protected SharedPreferences mShared;
    protected String mTextFailed;
    protected String mTextFinish;
    protected String mTextLoading;
    protected String mTextPulling;
    protected String mTextRefreshing;
    protected String mTextRelease;
    protected String mTextSecondary;
    protected String mTextUpdate;
    public static final int ID_TEXT_UPDATE = R$id.srl_classics_update;
    public static String REFRESH_HEADER_PULLING = null;
    public static String REFRESH_HEADER_REFRESHING = null;
    public static String REFRESH_HEADER_LOADING = null;
    public static String REFRESH_HEADER_RELEASE = null;
    public static String REFRESH_HEADER_FINISH = null;
    public static String REFRESH_HEADER_FAILED = null;
    public static String REFRESH_HEADER_UPDATE = null;
    public static String REFRESH_HEADER_SECONDARY = null;

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
                a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RefreshState.RefreshReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RefreshState.ReleaseToRefresh.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RefreshState.ReleaseToTwoLevel.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RefreshState.Loading.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ClassicsHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        if (z) {
            this.mTitleText.setText(this.mTextFinish);
            if (this.mLastTime != null) {
                setLastUpdateTime(new Date());
            }
        } else {
            this.mTitleText.setText(this.mTextFailed);
        }
        return super.onFinish(refreshLayout, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        ImageView imageView = this.mArrowView;
        TextView textView = this.mLastUpdateText;
        switch (a.a[refreshState2.ordinal()]) {
            case 1:
                textView.setVisibility(this.mEnableLastTime ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.mTitleText.setText(this.mTextRefreshing);
                imageView.setVisibility(8);
                return;
            case 5:
                this.mTitleText.setText(this.mTextRelease);
                imageView.animate().rotation(180.0f);
                return;
            case 6:
                this.mTitleText.setText(this.mTextSecondary);
                imageView.animate().rotation(0.0f);
                return;
            case 7:
                imageView.setVisibility(8);
                textView.setVisibility(this.mEnableLastTime ? 4 : 8);
                this.mTitleText.setText(this.mTextLoading);
                return;
            default:
                return;
        }
        this.mTitleText.setText(this.mTextPulling);
        imageView.setVisibility(0);
        imageView.animate().rotation(0.0f);
    }

    public ClassicsHeader setEnableLastTime(boolean z) {
        TextView textView = this.mLastUpdateText;
        this.mEnableLastTime = z;
        textView.setVisibility(z ? 0 : 8);
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestRemeasureHeightFor(this);
        }
        return this;
    }

    public ClassicsHeader setLastUpdateText(CharSequence charSequence) {
        this.mLastTime = null;
        this.mLastUpdateText.setText(charSequence);
        return this;
    }

    public ClassicsHeader setLastUpdateTime(Date date) {
        this.mLastTime = date;
        this.mLastUpdateText.setText(this.mLastUpdateFormat.format(date));
        if (this.mShared != null && !isInEditMode()) {
            this.mShared.edit().putLong(this.KEY_LAST_UPDATE_TIME, date.getTime()).apply();
        }
        return this;
    }

    public ClassicsHeader setTextSizeTime(float f) {
        this.mLastUpdateText.setTextSize(f);
        RefreshKernel refreshKernel = this.mRefreshKernel;
        if (refreshKernel != null) {
            refreshKernel.requestRemeasureHeightFor(this);
        }
        return this;
    }

    public ClassicsHeader setTextTimeMarginTop(float f) {
        TextView textView = this.mLastUpdateText;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = zd2.dp2px(f);
        textView.setLayoutParams(marginLayoutParams);
        return this;
    }

    public ClassicsHeader setTimeFormat(DateFormat dateFormat) {
        this.mLastUpdateFormat = dateFormat;
        Date date = this.mLastTime;
        if (date != null) {
            this.mLastUpdateText.setText(dateFormat.format(date));
        }
        return this;
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        int i;
        int i2;
        FragmentManager supportFragmentManager;
        List<Fragment> fragments;
        this.KEY_LAST_UPDATE_TIME = Constants.LAST_UPDATE_TIME;
        this.mEnableLastTime = true;
        View.inflate(context, R$layout.srl_classics_header, this);
        ImageView imageView = (ImageView) findViewById(R$id.srl_classics_arrow);
        this.mArrowView = imageView;
        TextView textView = (TextView) findViewById(R$id.srl_classics_update);
        this.mLastUpdateText = textView;
        ImageView imageView2 = (ImageView) findViewById(R$id.srl_classics_progress);
        this.mProgressView = imageView2;
        this.mTitleText = (TextView) findViewById(R$id.srl_classics_title);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsHeader);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
        new LinearLayout.LayoutParams(-2, -2).topMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClassicsHeader_srlTextTimeMarginTop, zd2.dp2px(0.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClassicsFooter_srlDrawableMarginRight, zd2.dp2px(20.0f));
        layoutParams2.rightMargin = dimensionPixelSize;
        layoutParams.rightMargin = dimensionPixelSize;
        int i3 = R$styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i3, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i3, layoutParams.height);
        int i4 = R$styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i4, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i4, layoutParams2.height);
        int i5 = R$styleable.ClassicsHeader_srlDrawableSize;
        layoutParams.width = obtainStyledAttributes.getLayoutDimension(i5, layoutParams.width);
        layoutParams.height = obtainStyledAttributes.getLayoutDimension(i5, layoutParams.height);
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i5, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i5, layoutParams2.height);
        this.mFinishDuration = obtainStyledAttributes.getInt(R$styleable.ClassicsHeader_srlFinishDuration, this.mFinishDuration);
        this.mEnableLastTime = obtainStyledAttributes.getBoolean(R$styleable.ClassicsHeader_srlEnableLastTime, this.mEnableLastTime);
        this.mSpinnerStyle = df2.values[obtainStyledAttributes.getInt(R$styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.mSpinnerStyle.a)];
        int i6 = R$styleable.ClassicsHeader_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.mArrowView.setImageDrawable(obtainStyledAttributes.getDrawable(i6));
        } else if (this.mArrowView.getDrawable() == null) {
            a8 a8Var = new a8();
            this.mArrowDrawable = a8Var;
            a8Var.a(-10066330);
            this.mArrowView.setImageDrawable(this.mArrowDrawable);
        }
        int i7 = R$styleable.ClassicsHeader_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i7)) {
            this.mProgressView.setImageDrawable(obtainStyledAttributes.getDrawable(i7));
        } else if (this.mProgressView.getDrawable() == null) {
            fv1 fv1Var = new fv1();
            this.mProgressDrawable = fv1Var;
            fv1Var.a(-10066330);
            this.mProgressView.setImageDrawable(this.mProgressDrawable);
        }
        if (obtainStyledAttributes.hasValue(R$styleable.ClassicsHeader_srlTextSizeTitle)) {
            this.mTitleText.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i, zd2.dp2px(16.0f)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.ClassicsHeader_srlTextSizeTime)) {
            this.mLastUpdateText.setTextSize(0, obtainStyledAttributes.getDimensionPixelSize(i2, zd2.dp2px(12.0f)));
        }
        int i8 = R$styleable.ClassicsHeader_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i8)) {
            super.setPrimaryColor(obtainStyledAttributes.getColor(i8, 0));
        }
        int i9 = R$styleable.ClassicsHeader_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i9)) {
            setAccentColor(obtainStyledAttributes.getColor(i9, 0));
        }
        int i10 = R$styleable.ClassicsHeader_srlTextPulling;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.mTextPulling = obtainStyledAttributes.getString(i10);
        } else {
            String str = REFRESH_HEADER_PULLING;
            if (str != null) {
                this.mTextPulling = str;
            } else {
                this.mTextPulling = context.getString(R$string.srl_header_pulling);
            }
        }
        int i11 = R$styleable.ClassicsHeader_srlTextLoading;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.mTextLoading = obtainStyledAttributes.getString(i11);
        } else {
            String str2 = REFRESH_HEADER_LOADING;
            if (str2 != null) {
                this.mTextLoading = str2;
            } else {
                this.mTextLoading = context.getString(R$string.srl_header_loading);
            }
        }
        int i12 = R$styleable.ClassicsHeader_srlTextRelease;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.mTextRelease = obtainStyledAttributes.getString(i12);
        } else {
            String str3 = REFRESH_HEADER_RELEASE;
            if (str3 != null) {
                this.mTextRelease = str3;
            } else {
                this.mTextRelease = context.getString(R$string.srl_header_release);
            }
        }
        int i13 = R$styleable.ClassicsHeader_srlTextFinish;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.mTextFinish = obtainStyledAttributes.getString(i13);
        } else {
            String str4 = REFRESH_HEADER_FINISH;
            if (str4 != null) {
                this.mTextFinish = str4;
            } else {
                this.mTextFinish = context.getString(R$string.srl_header_finish);
            }
        }
        int i14 = R$styleable.ClassicsHeader_srlTextFailed;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.mTextFailed = obtainStyledAttributes.getString(i14);
        } else {
            String str5 = REFRESH_HEADER_FAILED;
            if (str5 != null) {
                this.mTextFailed = str5;
            } else {
                this.mTextFailed = context.getString(R$string.srl_header_failed);
            }
        }
        int i15 = R$styleable.ClassicsHeader_srlTextSecondary;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.mTextSecondary = obtainStyledAttributes.getString(i15);
        } else {
            String str6 = REFRESH_HEADER_SECONDARY;
            if (str6 != null) {
                this.mTextSecondary = str6;
            } else {
                this.mTextSecondary = context.getString(R$string.srl_header_secondary);
            }
        }
        int i16 = R$styleable.ClassicsHeader_srlTextRefreshing;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.mTextRefreshing = obtainStyledAttributes.getString(i16);
        } else {
            String str7 = REFRESH_HEADER_REFRESHING;
            if (str7 != null) {
                this.mTextRefreshing = str7;
            } else {
                this.mTextRefreshing = context.getString(R$string.srl_header_refreshing);
            }
        }
        int i17 = R$styleable.ClassicsHeader_srlTextUpdate;
        if (obtainStyledAttributes.hasValue(i17)) {
            this.mTextUpdate = obtainStyledAttributes.getString(i17);
        } else {
            String str8 = REFRESH_HEADER_UPDATE;
            if (str8 != null) {
                this.mTextUpdate = str8;
            } else {
                this.mTextUpdate = context.getString(R$string.srl_header_update);
            }
        }
        this.mLastUpdateFormat = new SimpleDateFormat(this.mTextUpdate, Locale.getDefault());
        obtainStyledAttributes.recycle();
        imageView2.animate().setInterpolator(null);
        textView.setVisibility(this.mEnableLastTime ? 0 : 8);
        this.mTitleText.setText(isInEditMode() ? this.mTextRefreshing : this.mTextPulling);
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
                setLastUpdateTime(new Date());
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.KEY_LAST_UPDATE_TIME += context.getClass().getName();
        this.mShared = context.getSharedPreferences("ClassicsHeader", 0);
        setLastUpdateTime(new Date(this.mShared.getLong(this.KEY_LAST_UPDATE_TIME, System.currentTimeMillis())));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.scwang.smartrefresh.layout.internal.InternalClassics
    public ClassicsHeader setAccentColor(@ColorInt int i) {
        this.mLastUpdateText.setTextColor((16777215 & i) | (-872415232));
        return (ClassicsHeader) super.setAccentColor(i);
    }
}
