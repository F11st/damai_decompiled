package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fa extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    ImageView d;
    IAMapDelegate e;
    Matrix f;

    public fa(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f = new Matrix();
        this.e = iAMapDelegate;
        try {
            Bitmap a = eq.a(context, "maps_dav_compass_needle_large.png");
            this.c = a;
            this.b = eq.a(a, m.a * 0.8f);
            Bitmap a2 = eq.a(this.c, m.a * 0.7f);
            this.c = a2;
            Bitmap bitmap = this.b;
            if (bitmap != null && a2 != null) {
                this.a = Bitmap.createBitmap(bitmap.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.c, (this.b.getWidth() - this.c.getWidth()) / 2.0f, (this.b.getHeight() - this.c.getHeight()) / 2.0f, paint);
                ImageView imageView = new ImageView(context);
                this.d = imageView;
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                this.d.setImageBitmap(this.a);
                this.d.setClickable(true);
                b();
                this.d.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.mapcore.util.fa.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        try {
                        } catch (Throwable th) {
                            hd.c(th, "CompassView", "onTouch");
                            th.printStackTrace();
                        }
                        if (fa.this.e.isMaploaded()) {
                            if (motionEvent.getAction() == 0) {
                                fa faVar = fa.this;
                                faVar.d.setImageBitmap(faVar.b);
                            } else if (motionEvent.getAction() == 1) {
                                fa faVar2 = fa.this;
                                faVar2.d.setImageBitmap(faVar2.a);
                                CameraPosition cameraPosition = fa.this.e.getCameraPosition();
                                fa.this.e.animateCamera(ah.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                            }
                            return false;
                        }
                        return false;
                    }
                });
                addView(this.d);
            }
        } catch (Throwable th) {
            hd.c(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.a;
            if (bitmap != null) {
                eq.b(bitmap);
            }
            Bitmap bitmap2 = this.b;
            if (bitmap2 != null) {
                eq.b(bitmap2);
            }
            Bitmap bitmap3 = this.c;
            if (bitmap3 != null) {
                eq.b(bitmap3);
            }
            Matrix matrix = this.f;
            if (matrix != null) {
                matrix.reset();
                this.f = null;
            }
            this.c = null;
            this.a = null;
            this.b = null;
        } catch (Throwable th) {
            hd.c(th, "CompassView", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
        }
    }

    public void b() {
        try {
            IAMapDelegate iAMapDelegate = this.e;
            if (iAMapDelegate == null || this.d == null) {
                return;
            }
            float cameraDegree = iAMapDelegate.getCameraDegree(1);
            float mapAngle = this.e.getMapAngle(1);
            if (this.f == null) {
                this.f = new Matrix();
            }
            this.f.reset();
            this.f.postRotate(-mapAngle, Rect.width(this.d.getDrawable().getBounds()) / 2.0f, Rect.height(this.d.getDrawable().getBounds()) / 2.0f);
            this.f.postScale(1.0f, (float) Math.cos((cameraDegree * 3.141592653589793d) / 180.0d), Rect.width(this.d.getDrawable().getBounds()) / 2.0f, Rect.height(this.d.getDrawable().getBounds()) / 2.0f);
            this.d.setImageMatrix(this.f);
        } catch (Throwable th) {
            hd.c(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        if (z) {
            setVisibility(0);
            b();
            return;
        }
        setVisibility(8);
    }
}
