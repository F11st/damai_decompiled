package com.youku.live.dago.widgetlib.doodle.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import tb.nh0;
import tb.ui2;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TUrlDrawable extends Drawable {
    private static transient /* synthetic */ IpChange $ipChange;
    private BitmapDrawable mInnerDrawable;
    private Drawable mPlaceholderDrawable;
    private String mUrl;

    public TUrlDrawable(String str, Drawable drawable) {
        this.mUrl = str;
        this.mPlaceholderDrawable = drawable;
        ur1.o().s(this.mUrl).Q(new IPhenixListener<ui2>() { // from class: com.youku.live.dago.widgetlib.doodle.drawable.TUrlDrawable.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(ui2 ui2Var) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1085315861")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1085315861", new Object[]{this, ui2Var})).booleanValue();
                }
                TUrlDrawable.this.mInnerDrawable = ui2Var.f();
                return false;
            }
        }).m(new IPhenixListener<nh0>() { // from class: com.youku.live.dago.widgetlib.doodle.drawable.TUrlDrawable.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(nh0 nh0Var) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "776855622")) {
                    return ((Boolean) ipChange.ipc$dispatch("776855622", new Object[]{this, nh0Var})).booleanValue();
                }
                return false;
            }
        }).n();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1896136855")) {
            ipChange.ipc$dispatch("1896136855", new Object[]{this, canvas});
            return;
        }
        BitmapDrawable bitmapDrawable = this.mInnerDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.draw(canvas);
            return;
        }
        Drawable drawable = this.mPlaceholderDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-643264145")) {
            return ((Integer) ipChange.ipc$dispatch("-643264145", new Object[]{this})).intValue();
        }
        BitmapDrawable bitmapDrawable = this.mInnerDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getIntrinsicHeight();
        }
        Drawable drawable = this.mPlaceholderDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "168171924")) {
            return ((Integer) ipChange.ipc$dispatch("168171924", new Object[]{this})).intValue();
        }
        BitmapDrawable bitmapDrawable = this.mInnerDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getIntrinsicWidth();
        }
        Drawable drawable = this.mPlaceholderDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1328750960")) {
            return ((Integer) ipChange.ipc$dispatch("-1328750960", new Object[]{this})).intValue();
        }
        BitmapDrawable bitmapDrawable = this.mInnerDrawable;
        if (bitmapDrawable != null) {
            return bitmapDrawable.getOpacity();
        }
        Drawable drawable = this.mPlaceholderDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588083085")) {
            ipChange.ipc$dispatch("588083085", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        BitmapDrawable bitmapDrawable = this.mInnerDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setAlpha(i);
        }
        Drawable drawable = this.mPlaceholderDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "812053473")) {
            ipChange.ipc$dispatch("812053473", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.setBounds(i, i2, i3, i4);
        BitmapDrawable bitmapDrawable = this.mInnerDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(i, i2, i3, i4);
        }
        Drawable drawable = this.mPlaceholderDrawable;
        if (drawable != null) {
            drawable.setBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-260403439")) {
            ipChange.ipc$dispatch("-260403439", new Object[]{this, colorFilter});
            return;
        }
        BitmapDrawable bitmapDrawable = this.mInnerDrawable;
        if (bitmapDrawable != null) {
            bitmapDrawable.setColorFilter(colorFilter);
        }
        Drawable drawable = this.mPlaceholderDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }
}
