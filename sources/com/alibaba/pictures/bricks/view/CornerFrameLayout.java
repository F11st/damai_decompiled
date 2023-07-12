package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CornerFrameLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mCornerPx;
    @Nullable
    private Integer mLastH;
    @Nullable
    private Integer mLastW;
    @Nullable
    private Path mPath;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CornerFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CornerFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ CornerFrameLayout(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 != r1.intValue()) goto L12;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void dispatchDraw(@org.jetbrains.annotations.Nullable android.graphics.Canvas r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.view.CornerFrameLayout.$ipChange
            java.lang.String r1 = "1194549906"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r3 = 1
            r2[r3] = r6
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            int r0 = r5.mCornerPx     // Catch: java.lang.Exception -> L8c
            if (r0 <= 0) goto L5a
            int r0 = r5.getWidth()     // Catch: java.lang.Exception -> L8c
            java.lang.Integer r1 = r5.mLastW     // Catch: java.lang.Exception -> L8c
            if (r1 != 0) goto L24
            goto L39
        L24:
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L8c
            if (r0 != r1) goto L39
            int r0 = r5.getHeight()     // Catch: java.lang.Exception -> L8c
            java.lang.Integer r1 = r5.mLastH     // Catch: java.lang.Exception -> L8c
            if (r1 != 0) goto L33
            goto L39
        L33:
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L8c
            if (r0 == r1) goto L5d
        L39:
            android.graphics.Path r0 = new android.graphics.Path     // Catch: java.lang.Exception -> L8c
            r0.<init>()     // Catch: java.lang.Exception -> L8c
            android.graphics.RectF r1 = new android.graphics.RectF     // Catch: java.lang.Exception -> L8c
            int r2 = r5.getWidth()     // Catch: java.lang.Exception -> L8c
            float r2 = (float) r2     // Catch: java.lang.Exception -> L8c
            int r3 = r5.getHeight()     // Catch: java.lang.Exception -> L8c
            float r3 = (float) r3     // Catch: java.lang.Exception -> L8c
            r4 = 0
            r1.<init>(r4, r4, r2, r3)     // Catch: java.lang.Exception -> L8c
            int r2 = r5.mCornerPx     // Catch: java.lang.Exception -> L8c
            float r3 = (float) r2     // Catch: java.lang.Exception -> L8c
            float r2 = (float) r2     // Catch: java.lang.Exception -> L8c
            android.graphics.Path$Direction r4 = android.graphics.Path.Direction.CW     // Catch: java.lang.Exception -> L8c
            r0.addRoundRect(r1, r3, r2, r4)     // Catch: java.lang.Exception -> L8c
            r5.mPath = r0     // Catch: java.lang.Exception -> L8c
            goto L5d
        L5a:
            r0 = 0
            r5.mPath = r0     // Catch: java.lang.Exception -> L8c
        L5d:
            int r0 = r5.getWidth()     // Catch: java.lang.Exception -> L8c
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L8c
            r5.mLastW = r0     // Catch: java.lang.Exception -> L8c
            int r0 = r5.getHeight()     // Catch: java.lang.Exception -> L8c
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L8c
            r5.mLastH = r0     // Catch: java.lang.Exception -> L8c
            android.graphics.Path r0 = r5.mPath     // Catch: java.lang.Exception -> L8c
            if (r0 == 0) goto L7f
            if (r6 == 0) goto L7a
            r6.save()     // Catch: java.lang.Exception -> L8c
        L7a:
            if (r6 == 0) goto L7f
            r6.clipPath(r0)     // Catch: java.lang.Exception -> L8c
        L7f:
            super.dispatchDraw(r6)     // Catch: java.lang.Exception -> L8c
            android.graphics.Path r0 = r5.mPath     // Catch: java.lang.Exception -> L8c
            if (r0 == 0) goto L90
            if (r6 == 0) goto L90
            r6.restore()     // Catch: java.lang.Exception -> L8c
            goto L90
        L8c:
            r6 = move-exception
            r6.printStackTrace()
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.view.CornerFrameLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    public final void setRoundCornerPx(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507790725")) {
            ipChange.ipc$dispatch("-1507790725", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mCornerPx != i) {
            this.mCornerPx = i;
            this.mLastW = null;
            this.mLastH = null;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CornerFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CornerFrameLayout);
        b41.h(obtainStyledAttributes, "context.obtainStyledAttr…leable.CornerFrameLayout)");
        this.mCornerPx = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CornerFrameLayout_clip_corner_radius, 0);
        obtainStyledAttributes.recycle();
    }
}
