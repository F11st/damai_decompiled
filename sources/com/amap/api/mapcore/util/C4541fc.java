package com.amap.api.mapcore.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.fc */
/* loaded from: classes10.dex */
public class C4541fc extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    Bitmap d;
    Bitmap e;
    Bitmap f;
    ImageView g;
    IAMapDelegate h;
    boolean i;

    @SuppressLint({"ClickableViewAccessibility"})
    public C4541fc(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.i = false;
        this.h = iAMapDelegate;
        try {
            Bitmap a = eq.a(context, "location_selected.png");
            this.d = a;
            this.a = eq.a(a, C4614m.a);
            Bitmap a2 = eq.a(context, "location_pressed.png");
            this.e = a2;
            this.b = eq.a(a2, C4614m.a);
            Bitmap a3 = eq.a(context, "location_unselected.png");
            this.f = a3;
            this.c = eq.a(a3, C4614m.a);
            ImageView imageView = new ImageView(context);
            this.g = imageView;
            imageView.setImageBitmap(this.a);
            this.g.setClickable(true);
            this.g.setPadding(0, 20, 20, 0);
            this.g.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.mapcore.util.fc.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (C4541fc.this.i) {
                        if (motionEvent.getAction() == 0) {
                            C4541fc c4541fc = C4541fc.this;
                            c4541fc.g.setImageBitmap(c4541fc.b);
                        } else if (motionEvent.getAction() == 1) {
                            try {
                                C4541fc c4541fc2 = C4541fc.this;
                                c4541fc2.g.setImageBitmap(c4541fc2.a);
                                C4541fc.this.h.setMyLocationEnabled(true);
                                Location myLocation = C4541fc.this.h.getMyLocation();
                                if (myLocation == null) {
                                    return false;
                                }
                                LatLng latLng = new LatLng(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(myLocation), com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(myLocation));
                                C4541fc.this.h.showMyLocationOverlay(myLocation);
                                IAMapDelegate iAMapDelegate2 = C4541fc.this.h;
                                iAMapDelegate2.moveCamera(ah.a(latLng, iAMapDelegate2.getZoomLevel()));
                            } catch (Throwable th) {
                                hd.c(th, "LocationView", "onTouch");
                                th.printStackTrace();
                            }
                        }
                        return false;
                    }
                    return false;
                }
            });
            addView(this.g);
        } catch (Throwable th) {
            hd.c(th, "LocationView", "create");
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
            if (this.b != null) {
                eq.b(this.c);
            }
            this.a = null;
            this.b = null;
            this.c = null;
            Bitmap bitmap3 = this.d;
            if (bitmap3 != null) {
                eq.b(bitmap3);
                this.d = null;
            }
            Bitmap bitmap4 = this.e;
            if (bitmap4 != null) {
                eq.b(bitmap4);
                this.e = null;
            }
            Bitmap bitmap5 = this.f;
            if (bitmap5 != null) {
                eq.b(bitmap5);
                this.f = null;
            }
        } catch (Throwable th) {
            hd.c(th, "LocationView", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.i = z;
        try {
            if (z) {
                this.g.setImageBitmap(this.a);
            } else {
                this.g.setImageBitmap(this.c);
            }
            this.g.invalidate();
        } catch (Throwable th) {
            hd.c(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }
}
