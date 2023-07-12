package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.huawei.hms.framework.common.ExceptionCode;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ff extends View {
    private String a;
    private int b;
    private IAMapDelegate c;
    private Paint d;
    private Paint e;
    private Rect f;
    private IPoint g;
    private float h;
    private final int[] i;

    public ff(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.a = "";
        this.b = 0;
        this.h = 0.0f;
        this.i = new int[]{ExceptionCode.CRASH_EXCEPTION, 5000000, 2000000, 1000000, 500000, com.taobao.android.dinamicx.e.DX_ERROR_CODE_SLIDER_LAYOUT_ITEM_COUNT_0, 100000, VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};
        this.c = iAMapDelegate;
        this.d = new Paint();
        this.f = new Rect();
        this.d.setAntiAlias(true);
        this.d.setColor(-16777216);
        this.d.setStrokeWidth(m.a * 2.0f);
        this.d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setColor(-16777216);
        this.e.setTextSize(m.a * 20.0f);
        this.h = ek.a(context, 1.0f);
        this.g = new IPoint();
    }

    public void a() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = null;
        this.g = null;
    }

    public void b() {
        IAMapDelegate iAMapDelegate = this.c;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            float preciseLevel = iAMapDelegate.getPreciseLevel(1);
            this.c.getGeoCenter(1, this.g);
            IPoint iPoint = this.g;
            if (iPoint == null) {
                return;
            }
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(Point.getx(iPoint), Point.gety(iPoint), 20);
            float mapZoomScale = this.c.getMapZoomScale();
            int[] iArr = this.i;
            int i = (int) preciseLevel;
            String a = eq.a(iArr[i]);
            a((int) (iArr[i] / (((float) ((((Math.cos((pixelsToLatLong.y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, preciseLevel) * 256.0d))) * mapZoomScale)));
            a(a);
            pixelsToLatLong.recycle();
            invalidate();
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        android.graphics.Point waterMarkerPositon;
        String str = this.a;
        if (str == null || "".equals(str) || this.b == 0 || (waterMarkerPositon = this.c.getWaterMarkerPositon()) == null) {
            return;
        }
        Paint paint = this.e;
        String str2 = this.a;
        paint.getTextBounds(str2, 0, str2.length(), this.f);
        int xVar = Point.getx(waterMarkerPositon);
        int yVar = (Point.gety(waterMarkerPositon) - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f)) + 5;
        canvas.drawText(this.a, ((this.b - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.f)) / 2) + xVar, yVar, this.e);
        float f = xVar;
        float height = yVar + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.f) - 5);
        canvas.drawLine(f, height - (this.h * 2.0f), f, height + m.a, this.d);
        canvas.drawLine(f, height, this.b + xVar, height, this.d);
        int i = this.b;
        canvas.drawLine(xVar + i, height - (this.h * 2.0f), xVar + i, height + m.a, this.d);
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(boolean z) {
        if (z) {
            setVisibility(0);
            b();
            return;
        }
        a("");
        a(0);
        setVisibility(8);
    }
}
