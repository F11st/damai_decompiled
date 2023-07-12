package cn.damai.uikit.shadowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$dimen;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMShadowLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mBackgroundColor;
    private float mCornerRadius;
    private float mDx;
    private float mDy;
    private boolean mForceInvalidateShadow;
    private boolean mInvalidateShadowOnSizeChanged;
    private int mShadowColor;
    private float mShadowRadius;
    private int padding;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a extends Drawable {
        private static transient /* synthetic */ IpChange $ipChange;
        private float a;
        private float b;
        private float c;
        private float d;
        private float e;
        private Paint f = new Paint(1);
        private RectF g = new RectF();

        public a(float f, float f2, float f3, float f4, float f5, int i, int i2) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
            this.f.setColor(i2);
            this.f.setStyle(Paint.Style.FILL);
            this.f.setShadowLayer(f3, f4, f5, i);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1811597108")) {
                ipChange.ipc$dispatch("1811597108", new Object[]{this, canvas});
                return;
            }
            try {
                canvas.drawRoundRect(this.g, this.a, this.b, this.f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-6288621")) {
                return ((Integer) ipChange.ipc$dispatch("-6288621", new Object[]{this})).intValue();
            }
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            Rect bounds;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1018042072")) {
                ipChange.ipc$dispatch("-1018042072", new Object[]{this, rect});
                return;
            }
            super.onBoundsChange(rect);
            try {
                this.g.set(getBounds());
                RectF rectF = this.g;
                float f = this.c;
                rectF.set(f, f, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds) - this.c, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds) - this.c);
                float f2 = this.e;
                float f3 = this.d;
                if (f2 > 0.0f) {
                    RectF rectF2 = this.g;
                    rectF2.top += f2;
                    rectF2.bottom -= f2;
                } else if (f2 < 0.0f) {
                    this.g.top += Math.abs(f2);
                    this.g.bottom -= Math.abs(f2);
                }
                if (f3 > 0.0f) {
                    RectF rectF3 = this.g;
                    rectF3.left += f3;
                    rectF3.right -= f3;
                } else if (f3 < 0.0f) {
                    this.g.left += Math.abs(f3);
                    this.g.right -= Math.abs(f3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2001656150")) {
                ipChange.ipc$dispatch("-2001656150", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.f.setAlpha(i);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1402152236")) {
                ipChange.ipc$dispatch("-1402152236", new Object[]{this, colorFilter});
            } else {
                this.f.setColorFilter(colorFilter);
            }
        }
    }

    public DMShadowLayout(Context context) {
        super(context);
        this.mInvalidateShadowOnSizeChanged = true;
        this.mForceInvalidateShadow = false;
        initView(context, null);
    }

    @Deprecated
    private Bitmap createShadowBitmap(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522837960")) {
            return (Bitmap) ipChange.ipc$dispatch("-522837960", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(f2, f2, i - f2, i2 - f2);
        if (f4 > 0.0f) {
            rectF.top += f4;
            rectF.bottom -= f4;
        } else if (f4 < 0.0f) {
            rectF.top += Math.abs(f4);
            rectF.bottom -= Math.abs(f4);
        }
        if (f3 > 0.0f) {
            rectF.left += f3;
            rectF.right -= f3;
        } else if (f3 < 0.0f) {
            rectF.left += Math.abs(f3);
            rectF.right -= Math.abs(f3);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i4);
        paint.setStyle(Paint.Style.FILL);
        if (!isInEditMode()) {
            paint.setShadowLayer(f2, f3, f4, i3);
        }
        canvas.drawRoundRect(rectF, f, f, paint);
        return createBitmap;
    }

    private Drawable createShadowDrawable(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "9649743") ? (Drawable) ipChange.ipc$dispatch("9649743", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i3), Integer.valueOf(i4)}) : new a(f, f, f2, f3, f4, i3, i4);
    }

    private TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] iArr) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-671296771") ? (TypedArray) ipChange.ipc$dispatch("-671296771", new Object[]{this, context, attributeSet, iArr}) : context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2130992740")) {
            ipChange.ipc$dispatch("2130992740", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray typedArray = getTypedArray(context, attributeSet, R$styleable.ShadowLayout);
        if (typedArray == null) {
            return;
        }
        try {
            this.padding = l62.a(context, 4.0f);
            int i = R$styleable.ShadowLayout_sl_cornerRadius;
            Resources resources = getResources();
            int i2 = R$dimen.margin_4dp;
            this.mCornerRadius = typedArray.getDimension(i, resources.getDimension(i2));
            this.mShadowRadius = typedArray.getDimension(R$styleable.ShadowLayout_sl_shadowRadius, getResources().getDimension(i2));
            this.mDx = typedArray.getDimension(R$styleable.ShadowLayout_sl_dx, 0.0f);
            this.mDy = typedArray.getDimension(R$styleable.ShadowLayout_sl_dy, 0.0f);
            this.mShadowColor = typedArray.getColor(R$styleable.ShadowLayout_sl_shadowColor, getResources().getColor(R$color.default_shadow_color));
            this.mBackgroundColor = typedArray.getColor(R$styleable.ShadowLayout_sl_backgroundColor, 0);
        } finally {
            typedArray.recycle();
        }
    }

    private void initView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858663766")) {
            ipChange.ipc$dispatch("1858663766", new Object[]{this, context, attributeSet});
            return;
        }
        initAttributes(context, attributeSet);
        int abs = (int) (this.mShadowRadius + Math.abs(this.mDx));
        int abs2 = (int) (this.mShadowRadius + Math.abs(this.mDy));
        setPadding(abs, abs2, abs, abs2);
    }

    private void setBackgroundCompat(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350389875")) {
            ipChange.ipc$dispatch("350389875", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        Drawable createShadowDrawable = createShadowDrawable(i, i2, this.mCornerRadius, this.mShadowRadius, this.mDx, this.mDy, this.mShadowColor, this.mBackgroundColor);
        if (Build.VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(createShadowDrawable);
        } else {
            setBackground(createShadowDrawable);
        }
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "436734576")) {
            return ((Integer) ipChange.ipc$dispatch("436734576", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1321010061")) {
            return ((Integer) ipChange.ipc$dispatch("-1321010061", new Object[]{this})).intValue();
        }
        return 0;
    }

    public void invalidateShadow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847761898")) {
            ipChange.ipc$dispatch("847761898", new Object[]{this});
            return;
        }
        this.mForceInvalidateShadow = true;
        requestLayout();
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75519896")) {
            ipChange.ipc$dispatch("75519896", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.mForceInvalidateShadow) {
            this.mForceInvalidateShadow = false;
            setBackgroundCompat(i3 - i, i4 - i2);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "424436369")) {
            ipChange.ipc$dispatch("424436369", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (getBackground() == null || this.mInvalidateShadowOnSizeChanged || this.mForceInvalidateShadow) {
            this.mForceInvalidateShadow = false;
            setBackgroundCompat(i, i2);
        }
    }

    public void reducePadding() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "672680762")) {
            ipChange.ipc$dispatch("672680762", new Object[]{this});
            return;
        }
        int i = this.padding;
        setPadding(i, 0, i, 0);
    }

    public void setInvalidateShadowOnSizeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1055985082")) {
            ipChange.ipc$dispatch("-1055985082", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mInvalidateShadowOnSizeChanged = z;
        }
    }

    public DMShadowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInvalidateShadowOnSizeChanged = true;
        this.mForceInvalidateShadow = false;
        initView(context, attributeSet);
    }

    public DMShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInvalidateShadowOnSizeChanged = true;
        this.mForceInvalidateShadow = false;
        initView(context, attributeSet);
    }
}
