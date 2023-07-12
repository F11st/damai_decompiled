package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class RoundRadiusImageView extends AppCompatImageView {
    private static transient /* synthetic */ IpChange $ipChange;
    private Path mClipPath;
    private int mLastHeight;
    private int mLastWidth;
    private Paint mPaint;
    private int mRoundRadius;
    private int mStrokeColor;
    private int mStrokeWidth;

    public RoundRadiusImageView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:6:0x0017, B:8:0x0023, B:13:0x002b, B:15:0x002f, B:18:0x004d, B:23:0x0059, B:24:0x0061, B:26:0x0066, B:27:0x0069, B:29:0x006d, B:31:0x0071, B:17:0x0035), top: B:36:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:6:0x0017, B:8:0x0023, B:13:0x002b, B:15:0x002f, B:18:0x004d, B:23:0x0059, B:24:0x0061, B:26:0x0066, B:27:0x0069, B:29:0x006d, B:31:0x0071, B:17:0x0035), top: B:36:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[Catch: Exception -> 0x0086, TryCatch #0 {Exception -> 0x0086, blocks: (B:6:0x0017, B:8:0x0023, B:13:0x002b, B:15:0x002f, B:18:0x004d, B:23:0x0059, B:24:0x0061, B:26:0x0066, B:27:0x0069, B:29:0x006d, B:31:0x0071, B:17:0x0035), top: B:36:0x0017 }] */
    @Override // android.widget.ImageView, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r10) {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.view.RoundRadiusImageView.$ipChange
            java.lang.String r1 = "-1934188059"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r9
            r2[r3] = r10
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            int r0 = r9.getWidth()     // Catch: java.lang.Exception -> L86
            int r1 = r9.getHeight()     // Catch: java.lang.Exception -> L86
            int r2 = r9.mLastWidth     // Catch: java.lang.Exception -> L86
            if (r0 != r2) goto L2a
            int r2 = r9.mLastHeight     // Catch: java.lang.Exception -> L86
            if (r1 == r2) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            int r5 = r9.mRoundRadius     // Catch: java.lang.Exception -> L86
            if (r5 > 0) goto L33
            r2 = 0
            r9.mClipPath = r2     // Catch: java.lang.Exception -> L86
            goto L4d
        L33:
            if (r2 == 0) goto L4d
            android.graphics.Path r2 = new android.graphics.Path     // Catch: java.lang.Exception -> L86
            r2.<init>()     // Catch: java.lang.Exception -> L86
            r9.mClipPath = r2     // Catch: java.lang.Exception -> L86
            android.graphics.RectF r5 = new android.graphics.RectF     // Catch: java.lang.Exception -> L86
            float r6 = (float) r0     // Catch: java.lang.Exception -> L86
            float r7 = (float) r1     // Catch: java.lang.Exception -> L86
            r8 = 0
            r5.<init>(r8, r8, r6, r7)     // Catch: java.lang.Exception -> L86
            int r6 = r9.mRoundRadius     // Catch: java.lang.Exception -> L86
            float r7 = (float) r6     // Catch: java.lang.Exception -> L86
            float r6 = (float) r6     // Catch: java.lang.Exception -> L86
            android.graphics.Path$Direction r8 = android.graphics.Path.Direction.CW     // Catch: java.lang.Exception -> L86
            r2.addRoundRect(r5, r7, r6, r8)     // Catch: java.lang.Exception -> L86
        L4d:
            r9.mLastWidth = r0     // Catch: java.lang.Exception -> L86
            r9.mLastHeight = r1     // Catch: java.lang.Exception -> L86
            android.graphics.Path r0 = r9.mClipPath     // Catch: java.lang.Exception -> L86
            if (r0 == 0) goto L56
            goto L57
        L56:
            r3 = 0
        L57:
            if (r3 == 0) goto L61
            r10.save()     // Catch: java.lang.Exception -> L86
            android.graphics.Path r0 = r9.mClipPath     // Catch: java.lang.Exception -> L86
            r10.clipPath(r0)     // Catch: java.lang.Exception -> L86
        L61:
            super.onDraw(r10)     // Catch: java.lang.Exception -> L86
            if (r3 == 0) goto L69
            r10.restore()     // Catch: java.lang.Exception -> L86
        L69:
            android.graphics.Path r0 = r9.mClipPath     // Catch: java.lang.Exception -> L86
            if (r0 == 0) goto L8a
            int r0 = r9.mStrokeWidth     // Catch: java.lang.Exception -> L86
            if (r0 <= 0) goto L8a
            android.graphics.Paint r1 = r9.mPaint     // Catch: java.lang.Exception -> L86
            float r0 = (float) r0     // Catch: java.lang.Exception -> L86
            r1.setStrokeWidth(r0)     // Catch: java.lang.Exception -> L86
            android.graphics.Paint r0 = r9.mPaint     // Catch: java.lang.Exception -> L86
            int r1 = r9.mStrokeColor     // Catch: java.lang.Exception -> L86
            r0.setColor(r1)     // Catch: java.lang.Exception -> L86
            android.graphics.Path r0 = r9.mClipPath     // Catch: java.lang.Exception -> L86
            android.graphics.Paint r1 = r9.mPaint     // Catch: java.lang.Exception -> L86
            r10.drawPath(r0, r1)     // Catch: java.lang.Exception -> L86
            goto L8a
        L86:
            r10 = move-exception
            r10.printStackTrace()
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.view.RoundRadiusImageView.onDraw(android.graphics.Canvas):void");
    }

    public void setRoundRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1746121154")) {
            ipChange.ipc$dispatch("-1746121154", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.mLastHeight = -1;
        this.mLastWidth = -1;
        this.mRoundRadius = i;
        invalidate();
    }

    public RoundRadiusImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundRadiusImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint(1);
        this.mLastWidth = -1;
        this.mLastHeight = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BricksRoundRadiusImageView);
        this.mRoundRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BricksRoundRadiusImageView_r_round_radius, 0);
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.BricksRoundRadiusImageView_r_stroke_width, 0);
        this.mStrokeColor = obtainStyledAttributes.getColor(R$styleable.BricksRoundRadiusImageView_r_stroke_color, 0);
        obtainStyledAttributes.recycle();
        this.mPaint.setStyle(Paint.Style.STROKE);
    }
}
