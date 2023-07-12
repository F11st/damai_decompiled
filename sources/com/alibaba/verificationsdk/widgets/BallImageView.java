package com.alibaba.verificationsdk.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import tb.ra1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BallImageView extends ImageView {
    public static int mScreenHeight;
    public static int mScreenWidth;
    public float currentX;
    public float currentY;
    public float radius;

    public BallImageView(Context context) {
        super(context);
        this.radius = 0.0f;
        this.currentX = 40.0f;
        this.currentY = 50.0f;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        mScreenWidth = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        ra1.b("TEST", "displayMetrics.widthPixels: " + mScreenWidth + " displayMetrics.heightPixels: " + mScreenHeight);
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        mScreenHeight = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
        ra1.b("TEST", "getWindowVisibleDisplayFrame.width: " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) + " getWindowVisibleDisplayFrame.height: " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (r0 != 3) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean autoMouse(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r6.getHeight()
            float r0 = (float) r0
            r6.radius = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "x: "
            r0.append(r1)
            float r1 = r7.getX()
            r0.append(r1)
            java.lang.String r1 = " y: "
            r0.append(r1)
            float r1 = r7.getY()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TEST"
            tb.ra1.b(r1, r0)
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == r1) goto L7f
            r2 = 2
            if (r0 == r2) goto L3b
            r7 = 3
            if (r0 == r7) goto L7f
            goto L92
        L3b:
            float r0 = r7.getX()
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7e
            float r0 = r7.getX()
            int r4 = com.alibaba.verificationsdk.widgets.BallImageView.mScreenWidth
            int r5 = r6.getWidth()
            int r4 = r4 - r5
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L55
            goto L7e
        L55:
            float r0 = r7.getY()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7e
            float r0 = r7.getY()
            int r3 = com.alibaba.verificationsdk.widgets.BallImageView.mScreenHeight
            int r4 = r6.getHeight()
            int r4 = r4 * 2
            int r3 = r3 - r4
            float r2 = (float) r3
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L70
            goto L7e
        L70:
            float r0 = r7.getX()
            int r0 = (int) r0
            float r7 = r7.getY()
            int r7 = (int) r7
            r6.setLocation(r0, r7)
            goto L93
        L7e:
            return r1
        L7f:
            float r7 = r6.radius
            r6.currentX = r7
            int r0 = com.alibaba.verificationsdk.widgets.BallImageView.mScreenHeight
            float r0 = (float) r0
            r1 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 * r7
            float r0 = r0 - r1
            r6.currentY = r0
            int r7 = (int) r7
            int r0 = (int) r0
            r6.setLocation(r7, r0)
        L92:
            r1 = 0
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.widgets.BallImageView.autoMouse(android.view.MotionEvent):boolean");
    }

    public void setLocation(int i, int i2) {
        setFrame(i, i2 - (getHeight() / 2), getWidth() + i, i2 + (getHeight() / 2));
    }
}
