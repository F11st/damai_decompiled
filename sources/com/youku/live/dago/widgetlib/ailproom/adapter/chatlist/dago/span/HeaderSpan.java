package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.util.UIUtil;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HeaderSpan extends ReplacementSpan {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final int srcSize = UIUtil.dip2px(18);
    private BitmapDrawable mIconDrawable;
    private BitmapDrawable mSrcDrawable;

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1242758332")) {
            ipChange.ipc$dispatch("-1242758332", new Object[]{this, canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint});
            return;
        }
        BitmapDrawable bitmapDrawable = this.mSrcDrawable;
        if (bitmapDrawable == null || bitmapDrawable.getBitmap() == null || this.mSrcDrawable.getBitmap().isRecycled()) {
            this.mSrcDrawable = (BitmapDrawable) AppContextUtils.getApp().getResources().getDrawable(R.drawable.dago_pgc_header_default);
        }
        BitmapDrawable bitmapDrawable2 = this.mSrcDrawable;
        int i6 = (int) f;
        int i7 = srcSize;
        bitmapDrawable2.setBounds(i6, i3, (int) (i7 + f), i3 + i7);
        this.mSrcDrawable.draw(canvas);
        BitmapDrawable bitmapDrawable3 = this.mIconDrawable;
        if (bitmapDrawable3 == null || bitmapDrawable3.getBitmap() == null || this.mIconDrawable.getBitmap().isRecycled()) {
            return;
        }
        this.mIconDrawable.setBounds(i6, i3, (int) (f + i7), i7 + i3);
        this.mIconDrawable.draw(canvas);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1317733252") ? ((Integer) ipChange.ipc$dispatch("1317733252", new Object[]{this, paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})).intValue() : srcSize;
    }

    public BitmapDrawable getSrcDrawable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1985608854") ? (BitmapDrawable) ipChange.ipc$dispatch("1985608854", new Object[]{this}) : this.mSrcDrawable;
    }

    public void setIconDrawable(BitmapDrawable bitmapDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806662533")) {
            ipChange.ipc$dispatch("1806662533", new Object[]{this, bitmapDrawable});
        } else {
            this.mIconDrawable = bitmapDrawable;
        }
    }

    public void setSrcDrawable(BitmapDrawable bitmapDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-250747818")) {
            ipChange.ipc$dispatch("-250747818", new Object[]{this, bitmapDrawable});
        } else {
            this.mSrcDrawable = bitmapDrawable;
        }
    }
}
