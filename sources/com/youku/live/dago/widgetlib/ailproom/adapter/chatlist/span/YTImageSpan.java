package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YTImageSpan extends ImageSpan implements YTBaseSpan {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ALIGN_CENTER = 4;
    public static final int ALIGN_TOP = 3;
    public int h;
    public ImageBean imageBean;
    public int length;
    private Drawable mDrawable;
    private WeakReference<Drawable> mDrawableRef;
    public int start;
    public TextView textView;
    public int w;
    public float x;
    public float y;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Alignment {
    }

    public YTImageSpan(Drawable drawable, ImageBean imageBean, TextView textView) {
        super(drawable, imageBean.alignment.intValue());
        this.length = 1;
        this.mDrawable = drawable;
        this.imageBean = imageBean;
        this.textView = textView;
        this.w = (int) (imageBean.width + 0.5f);
        this.h = (int) (imageBean.height + 0.5f);
    }

    private Drawable getCachedDrawable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041496486")) {
            return (Drawable) ipChange.ipc$dispatch("-1041496486", new Object[]{this});
        }
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.mDrawableRef = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public static Drawable getDrawable(Integer num, Integer num2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202274616")) {
            return (Drawable) ipChange.ipc$dispatch("202274616", new Object[]{num, num2});
        }
        LazyDrawable lazyDrawable = new LazyDrawable();
        lazyDrawable.setBounds(0, 0, num.intValue(), num2.intValue());
        return lazyDrawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2;
        int i6 = i3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477581295")) {
            ipChange.ipc$dispatch("-477581295", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        Drawable drawable = getDrawable();
        Rect bounds = drawable.getBounds();
        int i7 = ((ImageSpan) this).mVerticalAlignment;
        if (i7 == 1) {
            i6 = i4 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
        } else if (i7 != 3) {
            if (i7 != 4) {
                i6 = i5 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
            } else {
                f2 = (((i5 - i6) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds)) / 2) + i6;
                canvas.save();
                canvas.translate(f, f2);
                drawable.draw(canvas);
                canvas.restore();
            }
        }
        f2 = i6;
        canvas.save();
        canvas.translate(f, f2);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span.YTBaseSpan
    public YTBaseSpan fetch(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "844962652")) {
            return (YTBaseSpan) ipChange.ipc$dispatch("844962652", new Object[]{this, context});
        }
        DagoImageLoader.getInstance().load(context, this.imageBean.src, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span.YTImageSpan.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onFail() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "649325860")) {
                    ipChange2.ipc$dispatch("649325860", new Object[]{this});
                }
            }

            @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
            public void onSuccess(BitmapDrawable bitmapDrawable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "244187290")) {
                    ipChange2.ipc$dispatch("244187290", new Object[]{this, bitmapDrawable});
                    return;
                }
                YTImageSpan yTImageSpan = YTImageSpan.this;
                bitmapDrawable.setBounds(0, 0, yTImageSpan.w, yTImageSpan.h);
                ((LazyDrawable) YTImageSpan.this.mDrawable).drawable = bitmapDrawable;
                YTImageSpan.this.textView.postInvalidate();
            }
        });
        return this;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span.YTBaseSpan
    public YTBaseSpan format(SpannableStringBuilder spannableStringBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356481062")) {
            return (YTBaseSpan) ipChange.ipc$dispatch("1356481062", new Object[]{this, spannableStringBuilder});
        }
        int i = this.start;
        spannableStringBuilder.setSpan(this, i, this.length + i, 33);
        return this;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "920734679")) {
            return ((Integer) ipChange.ipc$dispatch("920734679", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue();
        }
        Rect bounds = getCachedDrawable().getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f = fontMetrics.top - fontMetrics.ascent;
            float f2 = fontMetrics.bottom - fontMetrics.descent;
            int height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
            int i3 = ((ImageSpan) this).mVerticalAlignment;
            if (i3 == 1) {
                int i4 = -height;
                fontMetricsInt.ascent = i4;
                fontMetricsInt.top = (int) (i4 + f);
            } else if (i3 == 3) {
                float f3 = height + fontMetrics.ascent;
                fontMetricsInt.descent = (int) f3;
                fontMetricsInt.bottom = (int) (f3 + f2);
            } else if (i3 != 4) {
                float f4 = fontMetrics.descent - height;
                fontMetricsInt.ascent = (int) f4;
                fontMetricsInt.top = (int) (f4 + f);
            } else {
                float f5 = fontMetrics.descent;
                float f6 = f5 - ((f5 - fontMetrics.ascent) / 2.0f);
                float f7 = height / 2;
                float f8 = f6 - f7;
                float f9 = f6 + f7;
                fontMetricsInt.ascent = (int) f8;
                fontMetricsInt.top = (int) (f8 + f);
                fontMetricsInt.descent = (int) f9;
                fontMetricsInt.bottom = (int) (f9 + f2);
            }
        }
        return bounds.right;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span.YTBaseSpan
    public YTBaseSpan into(SpannableStringBuilder spannableStringBuilder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592957745")) {
            return (YTBaseSpan) ipChange.ipc$dispatch("-592957745", new Object[]{this, spannableStringBuilder});
        }
        this.start = spannableStringBuilder.length();
        spannableStringBuilder.append(" ");
        return this;
    }
}
