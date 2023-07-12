package com.youku.live.dago.widgetlib.doodle.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.TextureView;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.doodle.SketchBoard;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HardwareSketchBoard extends TextureView implements SketchBoard {
    private static transient /* synthetic */ IpChange $ipChange;

    public HardwareSketchBoard(Context context) {
        this(context, null);
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796052688")) {
            ipChange.ipc$dispatch("1796052688", new Object[]{this});
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void draw(@NonNull Drawable drawable, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1788315382")) {
            ipChange.ipc$dispatch("1788315382", new Object[]{this, drawable, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void draw(@NonNull Drawable drawable, int i, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585105878")) {
            ipChange.ipc$dispatch("585105878", new Object[]{this, drawable, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public int getBoardHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212301257")) {
            return ((Integer) ipChange.ipc$dispatch("212301257", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public int getBoardWidth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1882439174")) {
            return ((Integer) ipChange.ipc$dispatch("-1882439174", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void setDrawLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530327307")) {
            ipChange.ipc$dispatch("530327307", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // com.youku.live.dago.widgetlib.doodle.SketchBoard
    public void setOnDrawListener(SketchBoard.OnDrawListener onDrawListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1098978543")) {
            ipChange.ipc$dispatch("1098978543", new Object[]{this, onDrawListener});
        }
    }

    public HardwareSketchBoard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HardwareSketchBoard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
