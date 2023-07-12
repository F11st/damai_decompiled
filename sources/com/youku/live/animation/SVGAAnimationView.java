package com.youku.live.animation;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.opensource.svgaplayer.SVGAImageView;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SVGAAnimationView extends SVGAImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int realHeight;
    private int realWidth;
    private int resHeight;
    private int resWidth;

    public SVGAAnimationView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1592291905")) {
            ipChange.ipc$dispatch("1592291905", new Object[]{this, canvas});
            return;
        }
        int i = this.realWidth;
        if (i > 0 && this.realHeight > 0) {
            canvas.scale(i / canvas.getWidth(), this.realHeight / canvas.getHeight());
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "995840278")) {
            ipChange.ipc$dispatch("995840278", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public void setResSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159440200")) {
            ipChange.ipc$dispatch("159440200", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.resHeight = i2;
        this.resWidth = i;
    }

    public void setSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "143566048")) {
            ipChange.ipc$dispatch("143566048", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.realHeight = i2;
        this.realWidth = i;
    }

    public SVGAAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SVGAAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
