package cn.damai.common.app.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BubbleLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mArrowDownLeftRadius;
    private int mArrowDownRightRadius;
    private int mArrowTopLeftRadius;
    private int mArrowTopRightRadius;
    private int mBottom;
    private int mBubbleColor;
    private int mBubblePadding;
    private int mBubbleRadius;
    private int mHeight;
    private int mLeft;
    private OnClickEdgeListener mListener;
    private Look mLook;
    private int mLookLength;
    private int mLookPosition;
    private int mLookWidth;
    private Paint mPaint;
    private Path mPath;
    private Region mRegion;
    private int mRight;
    private int mTop;
    private int mWidth;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum Look {
        LEFT(1),
        TOP(2),
        RIGHT(3),
        BOTTOM(4);
        
        int value;

        Look(int i) {
            this.value = i;
        }

        public static Look getType(int i) {
            Look look = BOTTOM;
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? look : RIGHT;
                }
                return TOP;
            }
            return LEFT;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface OnClickEdgeListener {
        void edge();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.app.widget.BubbleLayout$a */
    /* loaded from: classes13.dex */
    public static /* synthetic */ class C0475a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Look.values().length];
            a = iArr;
            try {
                iArr[Look.BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Look.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Look.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Look.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleLayout(Context context) {
        this(context, null);
    }

    private void initAttr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931425254")) {
            ipChange.ipc$dispatch("931425254", new Object[]{this});
            return;
        }
        this.mLook = Look.BOTTOM;
        this.mLookPosition = 0;
        this.mLookWidth = q60.a(getContext(), 10.0f);
        this.mLookLength = q60.a(getContext(), 8.0f);
        this.mBubbleRadius = q60.a(getContext(), 8.0f);
        this.mArrowTopLeftRadius = q60.a(getContext(), 0.5f);
        this.mArrowTopRightRadius = q60.a(getContext(), 0.5f);
        this.mArrowDownLeftRadius = q60.a(getContext(), 0.0f);
        this.mArrowDownRightRadius = q60.a(getContext(), 0.0f);
        this.mBubblePadding = q60.a(getContext(), 3.0f);
        this.mBubbleColor = Color.parseColor("#CC000000");
    }

    private void initData() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1245491315")) {
            ipChange.ipc$dispatch("-1245491315", new Object[]{this});
            return;
        }
        Look look = this.mLook;
        this.mLeft = look == Look.LEFT ? this.mLookLength : 0;
        this.mTop = look == Look.TOP ? this.mLookLength : 0;
        this.mRight = this.mWidth - (look == Look.RIGHT ? this.mLookLength : 0);
        this.mBottom = this.mHeight - (look == Look.BOTTOM ? this.mLookLength : 0);
        this.mPaint.setColor(this.mBubbleColor);
        this.mPath.reset();
        int i21 = this.mLookPosition;
        int i22 = this.mLookLength;
        int i23 = i21 + i22;
        int i24 = this.mBottom;
        int i25 = i23 > i24 ? i24 - this.mLookWidth : i21;
        int i26 = i22 + i21;
        int i27 = this.mRight;
        if (i26 > i27) {
            i21 = i27 - this.mLookWidth;
        }
        int i28 = C0475a.a[this.mLook.ordinal()];
        if (i28 == 1) {
            if (i21 >= this.mBubbleRadius + this.mArrowDownRightRadius) {
                this.mPath.moveTo(i21 - i, this.mBottom);
                Path path = this.mPath;
                int i29 = this.mArrowDownRightRadius;
                int i30 = this.mLookWidth;
                int i31 = this.mLookLength;
                path.rCubicTo(i29, 0.0f, i29 + ((i30 / 2.0f) - this.mArrowTopRightRadius), i31, (i30 / 2.0f) + i29, i31);
            } else {
                this.mPath.moveTo(i21 + (this.mLookWidth / 2.0f), this.mBottom + this.mLookLength);
            }
            int i32 = this.mLookWidth;
            int i33 = i21 + i32;
            int i34 = this.mRight - this.mBubbleRadius;
            int i35 = this.mArrowDownLeftRadius;
            if (i33 < i34 - i35) {
                int i36 = this.mLookLength;
                this.mPath.rCubicTo(this.mArrowTopLeftRadius, 0.0f, i32 / 2.0f, -i36, (i32 / 2.0f) + i35, -i36);
                this.mPath.lineTo(this.mRight - this.mBubbleRadius, this.mBottom);
            }
            Path path2 = this.mPath;
            int i37 = this.mRight;
            path2.quadTo(i37, this.mBottom, i37, i2 - this.mBubbleRadius);
            this.mPath.lineTo(this.mRight, this.mTop + this.mBubbleRadius);
            Path path3 = this.mPath;
            int i38 = this.mRight;
            int i39 = this.mTop;
            path3.quadTo(i38, i39, i38 - this.mBubbleRadius, i39);
            this.mPath.lineTo(this.mLeft + this.mBubbleRadius, this.mTop);
            Path path4 = this.mPath;
            int i40 = this.mLeft;
            path4.quadTo(i40, this.mTop, i40, i3 + this.mBubbleRadius);
            this.mPath.lineTo(this.mLeft, this.mBottom - this.mBubbleRadius);
            if (i21 >= this.mArrowDownRightRadius + this.mBubbleRadius) {
                Path path5 = this.mPath;
                int i41 = this.mLeft;
                int i42 = this.mBottom;
                path5.quadTo(i41, i42, i41 + i4, i42);
            } else {
                this.mPath.quadTo(this.mLeft, this.mBottom, i21 + (this.mLookWidth / 2.0f), i5 + this.mLookLength);
            }
        } else if (i28 == 2) {
            if (i21 >= this.mBubbleRadius + this.mArrowDownLeftRadius) {
                this.mPath.moveTo(i21 - i6, this.mTop);
                Path path6 = this.mPath;
                int i43 = this.mArrowDownLeftRadius;
                int i44 = this.mLookWidth;
                int i45 = this.mLookLength;
                path6.rCubicTo(i43, 0.0f, i43 + ((i44 / 2.0f) - this.mArrowTopLeftRadius), -i45, (i44 / 2.0f) + i43, -i45);
            } else {
                this.mPath.moveTo(i21 + (this.mLookWidth / 2.0f), this.mTop - this.mLookLength);
            }
            int i46 = this.mLookWidth;
            int i47 = i21 + i46;
            int i48 = this.mRight - this.mBubbleRadius;
            int i49 = this.mArrowDownRightRadius;
            if (i47 < i48 - i49) {
                int i50 = this.mLookLength;
                this.mPath.rCubicTo(this.mArrowTopRightRadius, 0.0f, i46 / 2.0f, i50, (i46 / 2.0f) + i49, i50);
                this.mPath.lineTo(this.mRight - this.mBubbleRadius, this.mTop);
            }
            Path path7 = this.mPath;
            int i51 = this.mRight;
            path7.quadTo(i51, this.mTop, i51, i7 + this.mBubbleRadius);
            this.mPath.lineTo(this.mRight, this.mBottom - this.mBubbleRadius);
            Path path8 = this.mPath;
            int i52 = this.mRight;
            int i53 = this.mBottom;
            path8.quadTo(i52, i53, i52 - this.mBubbleRadius, i53);
            this.mPath.lineTo(this.mLeft + this.mBubbleRadius, this.mBottom);
            Path path9 = this.mPath;
            int i54 = this.mLeft;
            path9.quadTo(i54, this.mBottom, i54, i8 - this.mBubbleRadius);
            this.mPath.lineTo(this.mLeft, this.mTop + this.mBubbleRadius);
            if (i21 >= this.mArrowDownLeftRadius + this.mBubbleRadius) {
                Path path10 = this.mPath;
                int i55 = this.mLeft;
                int i56 = this.mTop;
                path10.quadTo(i55, i56, i55 + i9, i56);
            } else {
                this.mPath.quadTo(this.mLeft, this.mTop, i21 + (this.mLookWidth / 2.0f), i10 - this.mLookLength);
            }
        } else if (i28 == 3) {
            if (i25 >= this.mBubbleRadius + this.mArrowDownRightRadius) {
                this.mPath.moveTo(this.mLeft, i25 - i11);
                Path path11 = this.mPath;
                int i57 = this.mArrowDownRightRadius;
                int i58 = this.mLookLength;
                int i59 = this.mLookWidth;
                path11.rCubicTo(0.0f, i57, -i58, ((i59 / 2.0f) - this.mArrowTopRightRadius) + i57, -i58, (i59 / 2.0f) + i57);
            } else {
                this.mPath.moveTo(this.mLeft - this.mLookLength, i25 + (this.mLookWidth / 2.0f));
            }
            int i60 = this.mLookWidth;
            int i61 = i25 + i60;
            int i62 = this.mBottom - this.mBubbleRadius;
            int i63 = this.mArrowDownLeftRadius;
            if (i61 < i62 - i63) {
                Path path12 = this.mPath;
                float f = this.mArrowTopLeftRadius;
                int i64 = this.mLookLength;
                path12.rCubicTo(0.0f, f, i64, i60 / 2.0f, i64, (i60 / 2.0f) + i63);
                this.mPath.lineTo(this.mLeft, this.mBottom - this.mBubbleRadius);
            }
            Path path13 = this.mPath;
            int i65 = this.mLeft;
            int i66 = this.mBottom;
            path13.quadTo(i65, i66, i65 + this.mBubbleRadius, i66);
            this.mPath.lineTo(this.mRight - this.mBubbleRadius, this.mBottom);
            Path path14 = this.mPath;
            int i67 = this.mRight;
            path14.quadTo(i67, this.mBottom, i67, i12 - this.mBubbleRadius);
            this.mPath.lineTo(this.mRight, this.mTop + this.mBubbleRadius);
            Path path15 = this.mPath;
            int i68 = this.mRight;
            int i69 = this.mTop;
            path15.quadTo(i68, i69, i68 - this.mBubbleRadius, i69);
            this.mPath.lineTo(this.mLeft + this.mBubbleRadius, this.mTop);
            if (i25 >= this.mArrowDownRightRadius + this.mBubbleRadius) {
                Path path16 = this.mPath;
                int i70 = this.mLeft;
                path16.quadTo(i70, this.mTop, i70, i15 + i13);
            } else {
                this.mPath.quadTo(this.mLeft, this.mTop, i14 - this.mLookLength, i25 + (this.mLookWidth / 2.0f));
            }
        } else if (i28 == 4) {
            if (i25 >= this.mBubbleRadius + this.mArrowDownLeftRadius) {
                this.mPath.moveTo(this.mRight, i25 - i16);
                Path path17 = this.mPath;
                int i71 = this.mArrowDownLeftRadius;
                int i72 = this.mLookLength;
                int i73 = this.mLookWidth;
                path17.rCubicTo(0.0f, i71, i72, ((i73 / 2.0f) - this.mArrowTopLeftRadius) + i71, i72, (i73 / 2.0f) + i71);
            } else {
                this.mPath.moveTo(this.mRight + this.mLookLength, i25 + (this.mLookWidth / 2.0f));
            }
            int i74 = this.mLookWidth;
            int i75 = i25 + i74;
            int i76 = this.mBottom - this.mBubbleRadius;
            int i77 = this.mArrowDownRightRadius;
            if (i75 < i76 - i77) {
                Path path18 = this.mPath;
                float f2 = this.mArrowTopRightRadius;
                int i78 = this.mLookLength;
                path18.rCubicTo(0.0f, f2, -i78, i74 / 2.0f, -i78, (i74 / 2.0f) + i77);
                this.mPath.lineTo(this.mRight, this.mBottom - this.mBubbleRadius);
            }
            Path path19 = this.mPath;
            int i79 = this.mRight;
            int i80 = this.mBottom;
            path19.quadTo(i79, i80, i79 - this.mBubbleRadius, i80);
            this.mPath.lineTo(this.mLeft + this.mBubbleRadius, this.mBottom);
            Path path20 = this.mPath;
            int i81 = this.mLeft;
            path20.quadTo(i81, this.mBottom, i81, i17 - this.mBubbleRadius);
            this.mPath.lineTo(this.mLeft, this.mTop + this.mBubbleRadius);
            Path path21 = this.mPath;
            int i82 = this.mLeft;
            int i83 = this.mTop;
            path21.quadTo(i82, i83, i82 + this.mBubbleRadius, i83);
            this.mPath.lineTo(this.mRight - this.mBubbleRadius, this.mTop);
            if (i25 >= this.mArrowDownLeftRadius + this.mBubbleRadius) {
                Path path22 = this.mPath;
                int i84 = this.mRight;
                path22.quadTo(i84, this.mTop, i84, i20 + i18);
            } else {
                this.mPath.quadTo(this.mRight, this.mTop, i19 + this.mLookLength, i25 + (this.mLookWidth / 2.0f));
            }
        }
        this.mPath.close();
    }

    public int getArrowDownLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1511283052") ? ((Integer) ipChange.ipc$dispatch("1511283052", new Object[]{this})).intValue() : this.mArrowDownLeftRadius;
    }

    public int getArrowDownRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1745803869") ? ((Integer) ipChange.ipc$dispatch("1745803869", new Object[]{this})).intValue() : this.mArrowDownRightRadius;
    }

    public int getArrowTopLeftRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1243604091") ? ((Integer) ipChange.ipc$dispatch("1243604091", new Object[]{this})).intValue() : this.mArrowTopLeftRadius;
    }

    public int getArrowTopRightRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2037690670") ? ((Integer) ipChange.ipc$dispatch("2037690670", new Object[]{this})).intValue() : this.mArrowTopRightRadius;
    }

    public int getBubbleColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-161459079") ? ((Integer) ipChange.ipc$dispatch("-161459079", new Object[]{this})).intValue() : this.mBubbleColor;
    }

    public int getBubbleRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "641315010") ? ((Integer) ipChange.ipc$dispatch("641315010", new Object[]{this})).intValue() : this.mBubbleRadius;
    }

    public Look getLook() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "690100254") ? (Look) ipChange.ipc$dispatch("690100254", new Object[]{this}) : this.mLook;
    }

    public int getLookLength() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2060018885") ? ((Integer) ipChange.ipc$dispatch("-2060018885", new Object[]{this})).intValue() : this.mLookLength;
    }

    public int getLookPosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1421690920") ? ((Integer) ipChange.ipc$dispatch("-1421690920", new Object[]{this})).intValue() : this.mLookPosition;
    }

    public int getLookWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-757632951") ? ((Integer) ipChange.ipc$dispatch("-757632951", new Object[]{this})).intValue() : this.mLookWidth;
    }

    public Paint getPaint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "230264204") ? (Paint) ipChange.ipc$dispatch("230264204", new Object[]{this}) : this.mPaint;
    }

    public Path getPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "627733680") ? (Path) ipChange.ipc$dispatch("627733680", new Object[]{this}) : this.mPath;
    }

    public void initPadding() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94943614")) {
            ipChange.ipc$dispatch("-94943614", new Object[]{this});
            return;
        }
        int i = this.mBubblePadding;
        int i2 = C0475a.a[this.mLook.ordinal()];
        if (i2 == 1) {
            setPadding(i, i, i, this.mLookLength + i);
        } else if (i2 == 2) {
            setPadding(i, this.mLookLength + i, i, i);
        } else if (i2 == 3) {
            setPadding(this.mLookLength + i, i, i, i);
        } else if (i2 != 4) {
        } else {
            setPadding(i, i, this.mLookLength + i, i);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-537398516")) {
            ipChange.ipc$dispatch("-537398516", new Object[]{this});
            return;
        }
        initData();
        super.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "783670625")) {
            ipChange.ipc$dispatch("783670625", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724971545")) {
            ipChange.ipc$dispatch("1724971545", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mLookPosition = bundle.getInt("mLookPosition");
            this.mLookWidth = bundle.getInt("mLookWidth");
            this.mLookLength = bundle.getInt("mLookLength");
            this.mBubbleRadius = bundle.getInt("mBubbleRadius");
            this.mBubblePadding = bundle.getInt("mBubblePadding");
            this.mArrowTopLeftRadius = bundle.getInt("mArrowTopLeftRadius");
            this.mArrowTopRightRadius = bundle.getInt("mArrowTopRightRadius");
            this.mArrowDownLeftRadius = bundle.getInt("mArrowDownLeftRadius");
            this.mArrowDownRightRadius = bundle.getInt("mArrowDownRightRadius");
            this.mWidth = bundle.getInt("mWidth");
            this.mHeight = bundle.getInt("mHeight");
            this.mLeft = bundle.getInt("mLeft");
            this.mTop = bundle.getInt("mTop");
            this.mRight = bundle.getInt("mRight");
            this.mBottom = bundle.getInt("mBottom");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814047386")) {
            return (Parcelable) ipChange.ipc$dispatch("-1814047386", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mLookPosition", this.mLookPosition);
        bundle.putInt("mLookWidth", this.mLookWidth);
        bundle.putInt("mLookLength", this.mLookLength);
        bundle.putInt("mBubbleRadius", this.mBubbleRadius);
        bundle.putInt("mBubblePadding", this.mBubblePadding);
        bundle.putInt("mArrowTopLeftRadius", this.mArrowTopLeftRadius);
        bundle.putInt("mArrowTopRightRadius", this.mArrowTopRightRadius);
        bundle.putInt("mArrowDownLeftRadius", this.mArrowDownLeftRadius);
        bundle.putInt("mArrowDownRightRadius", this.mArrowDownRightRadius);
        bundle.putInt("mWidth", this.mWidth);
        bundle.putInt("mHeight", this.mHeight);
        bundle.putInt("mLeft", this.mLeft);
        bundle.putInt("mTop", this.mTop);
        bundle.putInt("mRight", this.mRight);
        bundle.putInt("mBottom", this.mBottom);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1929654225")) {
            ipChange.ipc$dispatch("-1929654225", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.mWidth = i;
        this.mHeight = i2;
        initData();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnClickEdgeListener onClickEdgeListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-978826906")) {
            return ((Boolean) ipChange.ipc$dispatch("-978826906", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            RectF rectF = new RectF();
            this.mPath.computeBounds(rectF, true);
            this.mRegion.setPath(this.mPath, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            if (!this.mRegion.contains((int) motionEvent.getX(), (int) motionEvent.getY()) && (onClickEdgeListener = this.mListener) != null) {
                onClickEdgeListener.edge();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void postInvalidate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15263052")) {
            ipChange.ipc$dispatch("15263052", new Object[]{this});
            return;
        }
        initData();
        super.postInvalidate();
    }

    public void setArrowDownLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-22598114")) {
            ipChange.ipc$dispatch("-22598114", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mArrowDownLeftRadius = i;
        }
    }

    public void setArrowDownRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1234808549")) {
            ipChange.ipc$dispatch("1234808549", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mArrowDownRightRadius = i;
        }
    }

    public void setArrowTopLeftRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "740342663")) {
            ipChange.ipc$dispatch("740342663", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mArrowTopLeftRadius = i;
        }
    }

    public void setArrowTopRightRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883831140")) {
            ipChange.ipc$dispatch("-883831140", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mArrowTopRightRadius = i;
        }
    }

    public void setBubbleColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209799345")) {
            ipChange.ipc$dispatch("209799345", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mBubbleColor = i;
        }
    }

    public void setBubblePadding(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457805729")) {
            ipChange.ipc$dispatch("-1457805729", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mBubblePadding = i;
        }
    }

    public void setBubbleRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157198112")) {
            ipChange.ipc$dispatch("1157198112", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mBubbleRadius = i;
        }
    }

    public void setLook(Look look) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299888024")) {
            ipChange.ipc$dispatch("299888024", new Object[]{this, look});
            return;
        }
        this.mLook = look;
        initPadding();
    }

    public void setLookLength(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-376198969")) {
            ipChange.ipc$dispatch("-376198969", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mLookLength = i;
        initPadding();
    }

    public void setLookPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1628523722")) {
            ipChange.ipc$dispatch("1628523722", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mLookPosition = i;
        }
    }

    public void setLookWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "451769313")) {
            ipChange.ipc$dispatch("451769313", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mLookWidth = i;
        }
    }

    public void setOnClickEdgeListener(OnClickEdgeListener onClickEdgeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1314958930")) {
            ipChange.ipc$dispatch("1314958930", new Object[]{this, onClickEdgeListener});
        } else {
            this.mListener = onClickEdgeListener;
        }
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRegion = new Region();
        setLayerType(1, null);
        setWillNotDraw(false);
        initAttr();
        Paint paint = new Paint(5);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mPath = new Path();
        initPadding();
    }
}
