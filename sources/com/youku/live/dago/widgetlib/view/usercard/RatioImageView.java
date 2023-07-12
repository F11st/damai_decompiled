package com.youku.live.dago.widgetlib.view.usercard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RatioImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int HEIGHT = 2;
    private static final int WIDTH = 1;
    private float mScaleRadio;
    private int mScaleType;

    /* compiled from: Taobao */
    /* renamed from: com.youku.live.dago.widgetlib.view.usercard.RatioImageView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$widgetlib$view$usercard$RatioImageView$ImageScaleType;

        static {
            int[] iArr = new int[ImageScaleType.values().length];
            $SwitchMap$com$youku$live$dago$widgetlib$view$usercard$RatioImageView$ImageScaleType = iArr;
            try {
                iArr[ImageScaleType.WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$view$usercard$RatioImageView$ImageScaleType[ImageScaleType.HEIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum ImageScaleType {
        WIDTH,
        HEIGHT
    }

    public RatioImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1031643694")) {
            ipChange.ipc$dispatch("1031643694", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.mScaleType != 0 && this.mScaleRadio != 0.0f) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824 && size != 0 && size2 != 0) {
                setMeasuredDimension(size, size2);
                return;
            }
            int i3 = this.mScaleType;
            if (i3 == 1 && mode == 1073741824 && size != 0) {
                setMeasuredDimension(size, (int) (size / this.mScaleRadio));
            } else if (i3 == 2 && mode2 == 1073741824 && size2 != 0) {
                setMeasuredDimension((int) (size2 / this.mScaleRadio), size2);
            } else {
                super.onMeasure(i, i2);
            }
        } else {
            super.onMeasure(i, i2);
        }
    }

    public void setScaleRadio(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2146680454")) {
            ipChange.ipc$dispatch("2146680454", new Object[]{this, Float.valueOf(f)});
            return;
        }
        this.mScaleRadio = f;
        invalidate();
    }

    public void setScaleType(ImageScaleType imageScaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994548801")) {
            ipChange.ipc$dispatch("994548801", new Object[]{this, imageScaleType});
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$youku$live$dago$widgetlib$view$usercard$RatioImageView$ImageScaleType[imageScaleType.ordinal()];
        if (i == 1) {
            this.mScaleType = 1;
        } else if (i != 2) {
        } else {
            this.mScaleType = 2;
        }
    }

    public RatioImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScaleType = 0;
    }
}
