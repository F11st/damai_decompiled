package cn.damai.uikit.switchbutton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import cn.damai.uikit.R$attr;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.sk;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SwitchButton extends CompoundButton {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int DEFAULT_ANIMATION_DURATION = 250;
    public static final int DEFAULT_THUMB_MARGIN_DP = 2;
    public static final float DEFAULT_THUMB_RANGE_RATIO = 1.8f;
    public static final int DEFAULT_THUMB_SIZE_DP = 20;
    public static final int DEFAULT_TINT_COLOR = 3309506;
    private long mAnimationDuration;
    private ColorStateList mBackColor;
    private Drawable mBackDrawable;
    private int mBackHeight;
    private float mBackRadius;
    private RectF mBackRectF;
    private int mBackWidth;
    private boolean mCatch;
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private int mClickTimeout;
    private int mCurrBackColor;
    private int mCurrThumbColor;
    private Drawable mCurrentBackDrawable;
    private boolean mDrawDebugRect;
    private boolean mFadeBack;
    private boolean mIsBackUseDrawable;
    private boolean mIsThumbUseDrawable;
    private float mLastX;
    private int mNextBackColor;
    private Drawable mNextBackDrawable;
    private Layout mOffLayout;
    private int mOffTextColor;
    private Layout mOnLayout;
    private int mOnTextColor;
    private Paint mPaint;
    private RectF mPresentThumbRectF;
    private float mProgress;
    private ObjectAnimator mProgressAnimator;
    private boolean mReady;
    private Paint mRectPaint;
    private boolean mRestoring;
    private RectF mSafeRectF;
    private float mStartX;
    private float mStartY;
    private int mTextAdjust;
    private int mTextExtra;
    private float mTextHeight;
    private CharSequence mTextOff;
    private RectF mTextOffRectF;
    private CharSequence mTextOn;
    private RectF mTextOnRectF;
    private TextPaint mTextPaint;
    private int mTextThumbInset;
    private float mTextWidth;
    private ColorStateList mThumbColor;
    private Drawable mThumbDrawable;
    private int mThumbHeight;
    private RectF mThumbMargin;
    private float mThumbRadius;
    private float mThumbRangeRatio;
    private RectF mThumbRectF;
    private int mThumbWidth;
    private int mTintColor;
    private int mTouchSlop;
    private static int[] CHECKED_PRESSED_STATE = {16842912, 16842910, 16842919};
    private static int[] UNCHECKED_PRESSED_STATE = {-16842912, 16842910, 16842919};

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class SavedState extends View.BaseSavedState {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<SavedState> CREATOR = new C2557a();
        CharSequence offText;
        CharSequence onText;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.uikit.switchbutton.SwitchButton$SavedState$a */
        /* loaded from: classes8.dex */
        public static final class C2557a implements Parcelable.Creator<SavedState> {
            private static transient /* synthetic */ IpChange $ipChange;

            C2557a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-906444235") ? (SavedState) ipChange.ipc$dispatch("-906444235", new Object[]{this, parcel}) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-266198800") ? (SavedState[]) ipChange.ipc$dispatch("-266198800", new Object[]{this, Integer.valueOf(i)}) : new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1912314631")) {
                ipChange.ipc$dispatch("-1912314631", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.onText, parcel, i);
            TextUtils.writeToParcel(this.offText, parcel, i);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.onText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.offText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawDebugRect = false;
        this.mRestoring = false;
        this.mReady = false;
        this.mCatch = false;
        init(attributeSet);
    }

    private void catchView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "362057038")) {
            ipChange.ipc$dispatch("362057038", new Object[]{this});
            return;
        }
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.mCatch = true;
    }

    private int ceil(double d) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-513589190") ? ((Integer) ipChange.ipc$dispatch("-513589190", new Object[]{this, Double.valueOf(d)})).intValue() : (int) Math.ceil(d);
    }

    private float getProgress() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "37158011") ? ((Float) ipChange.ipc$dispatch("37158011", new Object[]{this})).floatValue() : this.mProgress;
    }

    private boolean getStatusBasedOnPos() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-767969080") ? ((Boolean) ipChange.ipc$dispatch("-767969080", new Object[]{this})).booleanValue() : getProgress() > 0.5f;
    }

    private void init(AttributeSet attributeSet) {
        String str;
        float f;
        float f2;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Drawable drawable;
        float f3;
        float f4;
        Drawable drawable2;
        boolean z;
        int i5;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        TypedArray obtainStyledAttributes;
        ColorStateList colorStateList3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334381662")) {
            ipChange.ipc$dispatch("-334381662", new Object[]{this, attributeSet});
            return;
        }
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mClickTimeout = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.mPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mRectPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mRectPaint.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.mTextPaint = getPaint();
        this.mThumbRectF = new RectF();
        this.mBackRectF = new RectF();
        this.mSafeRectF = new RectF();
        this.mThumbMargin = new RectF();
        this.mTextOnRectF = new RectF();
        this.mTextOffRectF = new RectF();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.mProgressAnimator = duration;
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mPresentThumbRectF = new RectF();
        float f11 = getResources().getDisplayMetrics().density * 2.0f;
        TypedArray obtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, R$styleable.SwitchButton);
        if (obtainStyledAttributes2 != null) {
            drawable = obtainStyledAttributes2.getDrawable(R$styleable.SwitchButton_kswThumbDrawable);
            ColorStateList colorStateList4 = obtainStyledAttributes2.getColorStateList(R$styleable.SwitchButton_kswThumbColor);
            float dimension = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswThumbMargin, f11);
            float dimension2 = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswThumbMarginLeft, dimension);
            float dimension3 = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswThumbMarginRight, dimension);
            float dimension4 = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswThumbMarginTop, dimension);
            float dimension5 = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswThumbMarginBottom, dimension);
            float dimension6 = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswThumbWidth, 0.0f);
            float dimension7 = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswThumbHeight, 0.0f);
            float dimension8 = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswThumbRadius, -1.0f);
            float dimension9 = obtainStyledAttributes2.getDimension(R$styleable.SwitchButton_kswBackRadius, -1.0f);
            Drawable drawable3 = obtainStyledAttributes2.getDrawable(R$styleable.SwitchButton_kswBackDrawable);
            ColorStateList colorStateList5 = obtainStyledAttributes2.getColorStateList(R$styleable.SwitchButton_kswBackColor);
            float f12 = obtainStyledAttributes2.getFloat(R$styleable.SwitchButton_kswThumbRangeRatio, 1.8f);
            int integer = obtainStyledAttributes2.getInteger(R$styleable.SwitchButton_kswAnimationDuration, 250);
            boolean z2 = obtainStyledAttributes2.getBoolean(R$styleable.SwitchButton_kswFadeBack, true);
            int color = obtainStyledAttributes2.getColor(R$styleable.SwitchButton_kswTintColor, 0);
            String string = obtainStyledAttributes2.getString(R$styleable.SwitchButton_kswTextOn);
            String string2 = obtainStyledAttributes2.getString(R$styleable.SwitchButton_kswTextOff);
            int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.SwitchButton_kswTextThumbInset, 0);
            int dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.SwitchButton_kswTextExtra, 0);
            int dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.SwitchButton_kswTextAdjust, 0);
            obtainStyledAttributes2.recycle();
            f9 = dimension9;
            colorStateList = colorStateList4;
            f = dimension3;
            i4 = color;
            f3 = dimension6;
            drawable2 = drawable3;
            f7 = dimension5;
            str2 = string;
            i2 = dimensionPixelSize2;
            i5 = integer;
            z = z2;
            f6 = f12;
            f5 = dimension8;
            colorStateList2 = colorStateList5;
            f2 = dimension4;
            i3 = dimensionPixelSize3;
            str = string2;
            f8 = dimension2;
            f4 = dimension7;
            i = dimensionPixelSize;
        } else {
            str = null;
            f = 0.0f;
            f2 = 0.0f;
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            colorStateList = null;
            colorStateList2 = null;
            drawable = null;
            f3 = 0.0f;
            f4 = 0.0f;
            drawable2 = null;
            z = true;
            i5 = 250;
            f5 = -1.0f;
            f6 = 1.8f;
            f7 = 0.0f;
            f8 = 0.0f;
            f9 = -1.0f;
        }
        float f13 = f;
        if (attributeSet == null) {
            f10 = f2;
            obtainStyledAttributes = null;
        } else {
            f10 = f2;
            obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{16842970, 16842981});
        }
        if (obtainStyledAttributes != null) {
            colorStateList3 = colorStateList2;
            boolean z3 = obtainStyledAttributes.getBoolean(0, true);
            boolean z4 = obtainStyledAttributes.getBoolean(1, z3);
            setFocusable(z3);
            setClickable(z4);
            obtainStyledAttributes.recycle();
        } else {
            colorStateList3 = colorStateList2;
            setFocusable(true);
            setClickable(true);
        }
        this.mTextOn = str2;
        this.mTextOff = str;
        this.mTextThumbInset = i;
        this.mTextExtra = i2;
        this.mTextAdjust = i3;
        this.mThumbDrawable = drawable;
        this.mThumbColor = colorStateList;
        this.mIsThumbUseDrawable = drawable != null;
        this.mTintColor = i4;
        if (i4 == 0) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R$attr.colorAccent, typedValue, true)) {
                this.mTintColor = typedValue.data;
            } else {
                this.mTintColor = DEFAULT_TINT_COLOR;
            }
        }
        if (!this.mIsThumbUseDrawable && this.mThumbColor == null) {
            ColorStateList b = sk.b(this.mTintColor);
            this.mThumbColor = b;
            this.mCurrThumbColor = b.getDefaultColor();
        }
        this.mThumbWidth = ceil(f3);
        this.mThumbHeight = ceil(f4);
        this.mBackDrawable = drawable2;
        ColorStateList colorStateList6 = colorStateList3;
        this.mBackColor = colorStateList6;
        boolean z5 = drawable2 != null;
        this.mIsBackUseDrawable = z5;
        if (!z5 && colorStateList6 == null) {
            ColorStateList a = sk.a(this.mTintColor);
            this.mBackColor = a;
            int defaultColor = a.getDefaultColor();
            this.mCurrBackColor = defaultColor;
            this.mNextBackColor = this.mBackColor.getColorForState(CHECKED_PRESSED_STATE, defaultColor);
        }
        this.mThumbMargin.set(f8, f10, f13, f7);
        this.mThumbRangeRatio = this.mThumbMargin.width() >= 0.0f ? Math.max(f6, 1.0f) : f6;
        this.mThumbRadius = f5;
        this.mBackRadius = f9;
        long j = i5;
        this.mAnimationDuration = j;
        this.mFadeBack = z;
        this.mProgressAnimator.setDuration(j);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private Layout makeLayout(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-239694963")) {
            return (Layout) ipChange.ipc$dispatch("-239694963", new Object[]{this, charSequence});
        }
        TextPaint textPaint = this.mTextPaint;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    private int measureHeight(int i) {
        int i2;
        int ceil;
        int ceil2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1666209165")) {
            return ((Integer) ipChange.ipc$dispatch("1666209165", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.mThumbHeight == 0 && this.mIsThumbUseDrawable) {
            this.mThumbHeight = this.mThumbDrawable.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.mThumbHeight != 0) {
                RectF rectF = this.mThumbMargin;
                this.mBackHeight = ceil(i2 + rectF.top + rectF.bottom);
                this.mBackHeight = ceil(Math.max(ceil, this.mTextHeight));
                if ((((ceil2 + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.mThumbMargin.top)) - Math.min(0.0f, this.mThumbMargin.bottom) > size) {
                    this.mThumbHeight = 0;
                }
            }
            if (this.mThumbHeight == 0) {
                int ceil3 = ceil(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.mThumbMargin.top) + Math.min(0.0f, this.mThumbMargin.bottom));
                this.mBackHeight = ceil3;
                if (ceil3 < 0) {
                    this.mBackHeight = 0;
                    this.mThumbHeight = 0;
                    return size;
                }
                RectF rectF2 = this.mThumbMargin;
                this.mThumbHeight = ceil((ceil3 - rectF2.top) - rectF2.bottom);
            }
            if (this.mThumbHeight < 0) {
                this.mBackHeight = 0;
                this.mThumbHeight = 0;
                return size;
            }
            return size;
        }
        if (this.mThumbHeight == 0) {
            this.mThumbHeight = ceil(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.mThumbMargin;
        int ceil4 = ceil(this.mThumbHeight + rectF3.top + rectF3.bottom);
        this.mBackHeight = ceil4;
        if (ceil4 < 0) {
            this.mBackHeight = 0;
            this.mThumbHeight = 0;
            return size;
        }
        int ceil5 = ceil(this.mTextHeight - ceil4);
        if (ceil5 > 0) {
            this.mBackHeight += ceil5;
            this.mThumbHeight += ceil5;
        }
        int max = Math.max(this.mThumbHeight, this.mBackHeight);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private int measureWidth(int i) {
        int i2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199762050")) {
            return ((Integer) ipChange.ipc$dispatch("1199762050", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.mThumbWidth == 0 && this.mIsThumbUseDrawable) {
            this.mThumbWidth = this.mThumbDrawable.getIntrinsicWidth();
        }
        int ceil = ceil(this.mTextWidth);
        if (this.mThumbRangeRatio == 0.0f) {
            this.mThumbRangeRatio = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.mThumbWidth != 0) {
                int ceil2 = ceil(i2 * this.mThumbRangeRatio);
                RectF rectF = this.mThumbMargin;
                int ceil3 = (this.mTextExtra + ceil) - ((ceil2 - this.mThumbWidth) + ceil(Math.max(rectF.left, rectF.right)));
                float f = ceil2;
                RectF rectF2 = this.mThumbMargin;
                int ceil4 = ceil(rectF2.left + f + rectF2.right + Math.max(ceil3, 0));
                this.mBackWidth = ceil4;
                if (ceil4 < 0) {
                    this.mThumbWidth = 0;
                }
                if (f + Math.max(this.mThumbMargin.left, 0.0f) + Math.max(this.mThumbMargin.right, 0.0f) + Math.max(ceil3, 0) > paddingLeft) {
                    this.mThumbWidth = 0;
                }
            }
            if (this.mThumbWidth == 0) {
                int ceil5 = ceil((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.mThumbMargin.left, 0.0f)) - Math.max(this.mThumbMargin.right, 0.0f));
                if (ceil5 < 0) {
                    this.mThumbWidth = 0;
                    this.mBackWidth = 0;
                    return size;
                }
                float f2 = ceil5;
                this.mThumbWidth = ceil(f2 / this.mThumbRangeRatio);
                RectF rectF3 = this.mThumbMargin;
                int ceil6 = ceil(f2 + rectF3.left + rectF3.right);
                this.mBackWidth = ceil6;
                if (ceil6 < 0) {
                    this.mThumbWidth = 0;
                    this.mBackWidth = 0;
                    return size;
                }
                int i3 = ceil + this.mTextExtra;
                int i4 = ceil5 - this.mThumbWidth;
                RectF rectF4 = this.mThumbMargin;
                int ceil7 = i3 - (i4 + ceil(Math.max(rectF4.left, rectF4.right)));
                if (ceil7 > 0) {
                    this.mThumbWidth -= ceil7;
                }
                if (this.mThumbWidth < 0) {
                    this.mThumbWidth = 0;
                    this.mBackWidth = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.mThumbWidth == 0) {
            this.mThumbWidth = ceil(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.mThumbRangeRatio == 0.0f) {
            this.mThumbRangeRatio = 1.8f;
        }
        int ceil8 = ceil(this.mThumbWidth * this.mThumbRangeRatio);
        RectF rectF5 = this.mThumbMargin;
        int ceil9 = ceil((ceil + this.mTextExtra) - (((ceil8 - this.mThumbWidth) + Math.max(rectF5.left, rectF5.right)) + this.mTextThumbInset));
        float f3 = ceil8;
        RectF rectF6 = this.mThumbMargin;
        int ceil10 = ceil(rectF6.left + f3 + rectF6.right + Math.max(0, ceil9));
        this.mBackWidth = ceil10;
        if (ceil10 < 0) {
            this.mThumbWidth = 0;
            this.mBackWidth = 0;
            return size;
        }
        int ceil11 = ceil(f3 + Math.max(0.0f, this.mThumbMargin.left) + Math.max(0.0f, this.mThumbMargin.right) + Math.max(0, ceil9));
        return Math.max(ceil11, getPaddingLeft() + ceil11 + getPaddingRight());
    }

    private void setDrawableState(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "562351663")) {
            ipChange.ipc$dispatch("562351663", new Object[]{this, drawable});
        } else if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    private void setProgress(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062677921")) {
            ipChange.ipc$dispatch("2062677921", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mProgress = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1926922801")) {
            ipChange.ipc$dispatch("1926922801", new Object[]{this});
            return;
        }
        int i2 = this.mThumbWidth;
        if (i2 == 0 || (i = this.mThumbHeight) == 0 || this.mBackWidth == 0 || this.mBackHeight == 0) {
            return;
        }
        if (this.mThumbRadius == -1.0f) {
            this.mThumbRadius = Math.min(i2, i) / 2;
        }
        if (this.mBackRadius == -1.0f) {
            this.mBackRadius = Math.min(this.mBackWidth, this.mBackHeight) / 2;
        }
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int ceil = ceil((this.mBackWidth - Math.min(0.0f, this.mThumbMargin.left)) - Math.min(0.0f, this.mThumbMargin.right));
        int ceil2 = ceil((this.mBackHeight - Math.min(0.0f, this.mThumbMargin.top)) - Math.min(0.0f, this.mThumbMargin.bottom));
        if (measuredHeight <= ceil2) {
            paddingTop = getPaddingTop() + Math.max(0.0f, this.mThumbMargin.top);
        } else {
            paddingTop = (((measuredHeight - ceil2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.mThumbMargin.top);
        }
        if (measuredWidth <= this.mBackWidth) {
            paddingLeft = getPaddingLeft() + Math.max(0.0f, this.mThumbMargin.left);
        } else {
            paddingLeft = (((measuredWidth - ceil) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.mThumbMargin.left);
        }
        this.mThumbRectF.set(paddingLeft, paddingTop, this.mThumbWidth + paddingLeft, this.mThumbHeight + paddingTop);
        RectF rectF = this.mThumbRectF;
        float f = rectF.left;
        RectF rectF2 = this.mThumbMargin;
        float f2 = f - rectF2.left;
        RectF rectF3 = this.mBackRectF;
        float f3 = rectF.top;
        float f4 = rectF2.top;
        rectF3.set(f2, f3 - f4, this.mBackWidth + f2, (f3 - f4) + this.mBackHeight);
        RectF rectF4 = this.mSafeRectF;
        RectF rectF5 = this.mThumbRectF;
        rectF4.set(rectF5.left, 0.0f, (this.mBackRectF.right - this.mThumbMargin.right) - rectF5.width(), 0.0f);
        this.mBackRadius = Math.min(Math.min(this.mBackRectF.width(), this.mBackRectF.height()) / 2.0f, this.mBackRadius);
        Drawable drawable = this.mBackDrawable;
        if (drawable != null) {
            RectF rectF6 = this.mBackRectF;
            drawable.setBounds((int) rectF6.left, (int) rectF6.top, ceil(rectF6.right), ceil(this.mBackRectF.bottom));
        }
        if (this.mOnLayout != null) {
            RectF rectF7 = this.mBackRectF;
            float width = (rectF7.left + (((((rectF7.width() + this.mTextThumbInset) - this.mThumbWidth) - this.mThumbMargin.right) - this.mOnLayout.getWidth()) / 2.0f)) - this.mTextAdjust;
            RectF rectF8 = this.mBackRectF;
            float height = rectF8.top + ((rectF8.height() - this.mOnLayout.getHeight()) / 2.0f);
            this.mTextOnRectF.set(width, height, this.mOnLayout.getWidth() + width, this.mOnLayout.getHeight() + height);
        }
        if (this.mOffLayout != null) {
            RectF rectF9 = this.mBackRectF;
            float width2 = ((rectF9.right - (((((rectF9.width() + this.mTextThumbInset) - this.mThumbWidth) - this.mThumbMargin.left) - this.mOffLayout.getWidth()) / 2.0f)) - this.mOffLayout.getWidth()) + this.mTextAdjust;
            RectF rectF10 = this.mBackRectF;
            float height2 = rectF10.top + ((rectF10.height() - this.mOffLayout.getHeight()) / 2.0f);
            this.mTextOffRectF.set(width2, height2, this.mOffLayout.getWidth() + width2, this.mOffLayout.getHeight() + height2);
        }
        this.mReady = true;
    }

    protected void animateToState(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1847560013")) {
            ipChange.ipc$dispatch("1847560013", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ObjectAnimator objectAnimator = this.mProgressAnimator;
        if (objectAnimator == null) {
            return;
        }
        if (objectAnimator.isRunning()) {
            this.mProgressAnimator.cancel();
        }
        this.mProgressAnimator.setDuration(this.mAnimationDuration);
        if (z) {
            this.mProgressAnimator.setFloatValues(this.mProgress, 1.0f);
        } else {
            this.mProgressAnimator.setFloatValues(this.mProgress, 0.0f);
        }
        this.mProgressAnimator.start();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239242821")) {
            ipChange.ipc$dispatch("-1239242821", new Object[]{this});
            return;
        }
        super.drawableStateChanged();
        if (!this.mIsThumbUseDrawable && (colorStateList2 = this.mThumbColor) != null) {
            this.mCurrThumbColor = colorStateList2.getColorForState(getDrawableState(), this.mCurrThumbColor);
        } else {
            setDrawableState(this.mThumbDrawable);
        }
        int[] iArr = isChecked() ? UNCHECKED_PRESSED_STATE : CHECKED_PRESSED_STATE;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.mOnTextColor = textColors.getColorForState(CHECKED_PRESSED_STATE, defaultColor);
            this.mOffTextColor = textColors.getColorForState(UNCHECKED_PRESSED_STATE, defaultColor);
        }
        if (!this.mIsBackUseDrawable && (colorStateList = this.mBackColor) != null) {
            int colorForState = colorStateList.getColorForState(getDrawableState(), this.mCurrBackColor);
            this.mCurrBackColor = colorForState;
            this.mNextBackColor = this.mBackColor.getColorForState(iArr, colorForState);
            return;
        }
        Drawable drawable = this.mBackDrawable;
        if ((drawable instanceof StateListDrawable) && this.mFadeBack) {
            drawable.setState(iArr);
            this.mNextBackDrawable = this.mBackDrawable.getCurrent().mutate();
        } else {
            this.mNextBackDrawable = null;
        }
        setDrawableState(this.mBackDrawable);
        Drawable drawable2 = this.mBackDrawable;
        if (drawable2 != null) {
            this.mCurrentBackDrawable = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1110050770") ? ((Long) ipChange.ipc$dispatch("-1110050770", new Object[]{this})).longValue() : this.mAnimationDuration;
    }

    public ColorStateList getBackColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "986483358") ? (ColorStateList) ipChange.ipc$dispatch("986483358", new Object[]{this}) : this.mBackColor;
    }

    public Drawable getBackDrawable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1754650951") ? (Drawable) ipChange.ipc$dispatch("1754650951", new Object[]{this}) : this.mBackDrawable;
    }

    public float getBackRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1251909135") ? ((Float) ipChange.ipc$dispatch("1251909135", new Object[]{this})).floatValue() : this.mBackRadius;
    }

    public PointF getBackSizeF() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1625591083") ? (PointF) ipChange.ipc$dispatch("1625591083", new Object[]{this}) : new PointF(this.mBackRectF.width(), this.mBackRectF.height());
    }

    public CharSequence getTextOff() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1425977014") ? (CharSequence) ipChange.ipc$dispatch("-1425977014", new Object[]{this}) : this.mTextOff;
    }

    public CharSequence getTextOn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "850452238") ? (CharSequence) ipChange.ipc$dispatch("850452238", new Object[]{this}) : this.mTextOn;
    }

    public ColorStateList getThumbColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1327142679") ? (ColorStateList) ipChange.ipc$dispatch("-1327142679", new Object[]{this}) : this.mThumbColor;
    }

    public Drawable getThumbDrawable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2138418404") ? (Drawable) ipChange.ipc$dispatch("-2138418404", new Object[]{this}) : this.mThumbDrawable;
    }

    public float getThumbHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1041667685") ? ((Float) ipChange.ipc$dispatch("1041667685", new Object[]{this})).floatValue() : this.mThumbHeight;
    }

    public RectF getThumbMargin() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1581442791") ? (RectF) ipChange.ipc$dispatch("-1581442791", new Object[]{this}) : this.mThumbMargin;
    }

    public float getThumbRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1692368666") ? ((Float) ipChange.ipc$dispatch("1692368666", new Object[]{this})).floatValue() : this.mThumbRadius;
    }

    public float getThumbRangeRatio() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1709421022") ? ((Float) ipChange.ipc$dispatch("1709421022", new Object[]{this})).floatValue() : this.mThumbRangeRatio;
    }

    public float getThumbWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-608759432") ? ((Float) ipChange.ipc$dispatch("-608759432", new Object[]{this})).floatValue() : this.mThumbWidth;
    }

    public int getTintColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1389136067") ? ((Integer) ipChange.ipc$dispatch("-1389136067", new Object[]{this})).intValue() : this.mTintColor;
    }

    public boolean isDrawDebugRect() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-840777463") ? ((Boolean) ipChange.ipc$dispatch("-840777463", new Object[]{this})).booleanValue() : this.mDrawDebugRect;
    }

    public boolean isFadeBack() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1021315885") ? ((Boolean) ipChange.ipc$dispatch("-1021315885", new Object[]{this})).booleanValue() : this.mFadeBack;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0148  */
    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r14) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.uikit.switchbutton.SwitchButton.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086401295")) {
            ipChange.ipc$dispatch("1086401295", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (this.mOnLayout == null && !TextUtils.isEmpty(this.mTextOn)) {
            this.mOnLayout = makeLayout(this.mTextOn);
        }
        if (this.mOffLayout == null && !TextUtils.isEmpty(this.mTextOff)) {
            this.mOffLayout = makeLayout(this.mTextOff);
        }
        Layout layout = this.mOnLayout;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.mOffLayout;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.mTextWidth = 0.0f;
        } else {
            this.mTextWidth = Math.max(width, width2);
        }
        Layout layout3 = this.mOnLayout;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.mOffLayout;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.mTextHeight = 0.0f;
        } else {
            this.mTextHeight = Math.max(height, height2);
        }
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944215396")) {
            ipChange.ipc$dispatch("1944215396", new Object[]{this, parcelable});
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        setText(savedState.onText, savedState.offText);
        this.mRestoring = true;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mRestoring = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980785201")) {
            return (Parcelable) ipChange.ipc$dispatch("980785201", new Object[]{this});
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.onText = this.mTextOn;
        savedState.offText = this.mTextOff;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1636989958")) {
            ipChange.ipc$dispatch("-1636989958", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        setup();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        if (r0 != 3) goto L20;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.uikit.switchbutton.SwitchButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "528953081") ? ((Boolean) ipChange.ipc$dispatch("528953081", new Object[]{this})).booleanValue() : super.performClick();
    }

    public void setAnimationDuration(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855885762")) {
            ipChange.ipc$dispatch("-855885762", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mAnimationDuration = j;
        }
    }

    public void setBackColor(ColorStateList colorStateList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1799630272")) {
            ipChange.ipc$dispatch("1799630272", new Object[]{this, colorStateList});
            return;
        }
        this.mBackColor = colorStateList;
        if (colorStateList != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1682175227")) {
            ipChange.ipc$dispatch("1682175227", new Object[]{this, Integer.valueOf(i)});
        } else {
            setBackColor(ContextCompat.getColorStateList(getContext(), i));
        }
    }

    public void setBackDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "264721579")) {
            ipChange.ipc$dispatch("264721579", new Object[]{this, drawable});
            return;
        }
        this.mBackDrawable = drawable;
        this.mIsBackUseDrawable = drawable != null;
        refreshDrawableState();
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1608746176")) {
            ipChange.ipc$dispatch("-1608746176", new Object[]{this, Integer.valueOf(i)});
        } else {
            setBackDrawable(ContextCompat.getDrawable(getContext(), i));
        }
    }

    public void setBackRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-785648243")) {
            ipChange.ipc$dispatch("-785648243", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mBackRadius = f;
        if (this.mIsBackUseDrawable) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599108099")) {
            ipChange.ipc$dispatch("-1599108099", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (isChecked() != z) {
            animateToState(z);
        }
        if (this.mRestoring) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611706081")) {
            ipChange.ipc$dispatch("-611706081", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.mProgressAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mProgressAnimator.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104225688")) {
            ipChange.ipc$dispatch("1104225688", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mChildOnCheckedChangeListener == null) {
            setCheckedImmediately(z);
        } else {
            super.setOnCheckedChangeListener(null);
            setCheckedImmediately(z);
            super.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        }
    }

    public void setCheckedNoEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235757830")) {
            ipChange.ipc$dispatch("-235757830", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mChildOnCheckedChangeListener == null) {
            setChecked(z);
        } else {
            super.setOnCheckedChangeListener(null);
            setChecked(z);
            super.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        }
    }

    public void setDrawDebugRect(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221895415")) {
            ipChange.ipc$dispatch("-1221895415", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.mDrawDebugRect = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965842699")) {
            ipChange.ipc$dispatch("965842699", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mFadeBack = z;
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105027617")) {
            ipChange.ipc$dispatch("-105027617", new Object[]{this, onCheckedChangeListener});
            return;
        }
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mChildOnCheckedChangeListener = onCheckedChangeListener;
    }

    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858713145")) {
            ipChange.ipc$dispatch("-858713145", new Object[]{this, charSequence, charSequence2});
            return;
        }
        this.mTextOn = charSequence;
        this.mTextOff = charSequence2;
        this.mOnLayout = null;
        this.mOffLayout = null;
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setTextAdjust(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257232877")) {
            ipChange.ipc$dispatch("-1257232877", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTextAdjust = i;
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1190201432")) {
            ipChange.ipc$dispatch("-1190201432", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTextExtra = i;
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303190635")) {
            ipChange.ipc$dispatch("1303190635", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTextThumbInset = i;
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276579779")) {
            ipChange.ipc$dispatch("-1276579779", new Object[]{this, colorStateList});
            return;
        }
        this.mThumbColor = colorStateList;
        if (colorStateList != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075188872")) {
            ipChange.ipc$dispatch("-1075188872", new Object[]{this, Integer.valueOf(i)});
        } else {
            setThumbColor(ContextCompat.getColorStateList(getContext(), i));
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391713010")) {
            ipChange.ipc$dispatch("-1391713010", new Object[]{this, drawable});
            return;
        }
        this.mThumbDrawable = drawable;
        this.mIsThumbUseDrawable = drawable != null;
        refreshDrawableState();
        this.mReady = false;
        requestLayout();
        invalidate();
    }

    public void setThumbDrawableRes(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-698116189")) {
            ipChange.ipc$dispatch("-698116189", new Object[]{this, Integer.valueOf(i)});
        } else {
            setThumbDrawable(ContextCompat.getDrawable(getContext(), i));
        }
    }

    public void setThumbMargin(RectF rectF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281241173")) {
            ipChange.ipc$dispatch("-281241173", new Object[]{this, rectF});
        } else if (rectF == null) {
            setThumbMargin(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            setThumbMargin(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void setThumbRadius(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1843881802")) {
            ipChange.ipc$dispatch("1843881802", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mThumbRadius = f;
        if (this.mIsThumbUseDrawable) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1529367802")) {
            ipChange.ipc$dispatch("-1529367802", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mThumbRangeRatio = f;
        this.mReady = false;
        requestLayout();
    }

    public void setThumbSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2134260537")) {
            ipChange.ipc$dispatch("-2134260537", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mThumbWidth = i;
        this.mThumbHeight = i2;
        this.mReady = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944958099")) {
            ipChange.ipc$dispatch("-1944958099", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mTintColor = i;
        this.mThumbColor = sk.b(i);
        this.mBackColor = sk.a(this.mTintColor);
        this.mIsBackUseDrawable = false;
        this.mIsThumbUseDrawable = false;
        refreshDrawableState();
        invalidate();
    }

    public void toggleImmediately() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1927681276")) {
            ipChange.ipc$dispatch("-1927681276", new Object[]{this});
        } else {
            setCheckedImmediately(!isChecked());
        }
    }

    public void toggleImmediatelyNoEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065577683")) {
            ipChange.ipc$dispatch("-2065577683", new Object[]{this});
        } else if (this.mChildOnCheckedChangeListener == null) {
            toggleImmediately();
        } else {
            super.setOnCheckedChangeListener(null);
            toggleImmediately();
            super.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        }
    }

    public void toggleNoEvent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "880389961")) {
            ipChange.ipc$dispatch("880389961", new Object[]{this});
        } else if (this.mChildOnCheckedChangeListener == null) {
            toggle();
        } else {
            super.setOnCheckedChangeListener(null);
            toggle();
            super.setOnCheckedChangeListener(this.mChildOnCheckedChangeListener);
        }
    }

    public void setThumbMargin(float f, float f2, float f3, float f4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1040448410")) {
            ipChange.ipc$dispatch("1040448410", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
            return;
        }
        this.mThumbMargin.set(f, f2, f3, f4);
        this.mReady = false;
        requestLayout();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawDebugRect = false;
        this.mRestoring = false;
        this.mReady = false;
        this.mCatch = false;
        init(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.mDrawDebugRect = false;
        this.mRestoring = false;
        this.mReady = false;
        this.mCatch = false;
        init(null);
    }
}
