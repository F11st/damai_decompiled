package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ar {
    Context c;
    private View e;
    private TextView f;
    private TextView g;
    private IInfoWindowAction i;
    private IInfoWindowAction j;
    AMap.InfoWindowAdapter a = null;
    AMap.CommonInfoWindowAdapter b = null;
    private boolean d = true;
    private Drawable h = null;
    private AMap.InfoWindowAdapter k = new AMap.InfoWindowAdapter() { // from class: com.amap.api.mapcore.util.ar.1
        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoContents(Marker marker) {
            return null;
        }

        @Override // com.amap.api.maps.AMap.InfoWindowAdapter
        public View getInfoWindow(Marker marker) {
            try {
                if (ar.this.h == null) {
                    ar arVar = ar.this;
                    arVar.h = ef.a(arVar.c, "infowindow_bg.9.png");
                }
                if (ar.this.e == null) {
                    ar.this.e = new LinearLayout(ar.this.c);
                    ar.this.e.setBackground(ar.this.h);
                    ar.this.f = new TextView(ar.this.c);
                    ar.this.f.setText(marker.getTitle());
                    ar.this.f.setTextColor(-16777216);
                    ar.this.g = new TextView(ar.this.c);
                    ar.this.g.setTextColor(-16777216);
                    ar.this.g.setText(marker.getSnippet());
                    ((LinearLayout) ar.this.e).setOrientation(1);
                    ((LinearLayout) ar.this.e).addView(ar.this.f);
                    ((LinearLayout) ar.this.e).addView(ar.this.g);
                }
            } catch (Throwable th) {
                hd.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return ar.this.e;
        }
    };
    private AMap.CommonInfoWindowAdapter l = new AMap.CommonInfoWindowAdapter() { // from class: com.amap.api.mapcore.util.ar.2
        private InfoWindowParams b = null;

        @Override // com.amap.api.maps.AMap.CommonInfoWindowAdapter
        public InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.b == null) {
                    this.b = new InfoWindowParams();
                    if (ar.this.h == null) {
                        ar arVar = ar.this;
                        arVar.h = ef.a(arVar.c, "infowindow_bg.9.png");
                    }
                    ar.this.e = new LinearLayout(ar.this.c);
                    ar.this.e.setBackground(ar.this.h);
                    ar.this.f = new TextView(ar.this.c);
                    ar.this.f.setText("标题");
                    ar.this.f.setTextColor(-16777216);
                    ar.this.g = new TextView(ar.this.c);
                    ar.this.g.setTextColor(-16777216);
                    ar.this.g.setText("内容");
                    ((LinearLayout) ar.this.e).setOrientation(1);
                    ((LinearLayout) ar.this.e).addView(ar.this.f);
                    ((LinearLayout) ar.this.e).addView(ar.this.g);
                    this.b.setInfoWindowType(2);
                    this.b.setInfoWindow(ar.this.e);
                }
                return this.b;
            } catch (Throwable th) {
                hd.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    };

    public ar(Context context) {
        this.c = context;
    }

    public void e() {
        IInfoWindowAction d = d();
        if (d != null) {
            d.hideInfoWindow();
        }
    }

    public boolean f() {
        IInfoWindowAction d = d();
        if (d != null) {
            return d.isInfoWindowShown();
        }
        return false;
    }

    public Drawable g() {
        if (this.h == null) {
            try {
                this.h = ef.a(this.c, "infowindow_bg.9.png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.h;
    }

    public View c(Marker marker) {
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter == null || !(infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) infoWindowAdapter).getOverturnInfoWindowClick(marker);
    }

    public synchronized IInfoWindowAction d() {
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter) {
                return this.j;
            } else if (infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.j;
            }
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && commonInfoWindowAdapter.getInfoWindowParams(null).getInfoWindowType() == 1) {
            return this.j;
        }
        return this.i;
    }

    public void b(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.j = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public long c(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0L;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public void a(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.i = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public void b() {
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        synchronized (this) {
            eq.a(this.h);
            this.h = null;
            this.k = null;
            this.a = null;
        }
        this.b = null;
        this.i = null;
        this.j = null;
    }

    public synchronized boolean a() {
        return this.d;
    }

    public void c() {
        IInfoWindowAction d = d();
        if (d != null) {
            d.redrawInfoWindow();
        }
    }

    public void a(String str, String str2) {
        TextView textView = this.f;
        if (textView != null) {
            textView.requestLayout();
            this.f.setText(str);
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.requestLayout();
            this.g.setText(str2);
        }
        View view = this.e;
        if (view != null) {
            view.requestLayout();
        }
    }

    public synchronized void a(AMap.InfoWindowAdapter infoWindowAdapter) {
        this.a = infoWindowAdapter;
        this.b = null;
        if (infoWindowAdapter == null) {
            this.a = this.k;
            this.d = true;
        } else {
            this.d = false;
        }
        IInfoWindowAction iInfoWindowAction = this.j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public View b(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            return infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            return infoWindowParams.getInfoContents();
        }
        InfoWindowParams infoWindowParams2 = this.l.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoContents();
        }
        return null;
    }

    public synchronized void a(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.b = commonInfoWindowAdapter;
        this.a = null;
        if (commonInfoWindowAdapter == null) {
            this.b = this.l;
            this.d = true;
        } else {
            this.d = false;
        }
        IInfoWindowAction iInfoWindowAction = this.j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public View b(Marker marker) {
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter == null || !(infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) infoWindowAdapter).getOverturnInfoWindow(marker);
    }

    public View a(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter != null) {
            return infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.b;
        if (commonInfoWindowAdapter != null && (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) != null) {
            return infoWindowParams.getInfoWindow();
        }
        InfoWindowParams infoWindowParams2 = this.l.getInfoWindowParams(basePointOverlay);
        if (infoWindowParams2 != null) {
            return infoWindowParams2.getInfoWindow();
        }
        return null;
    }

    public View a(Marker marker) {
        AMap.InfoWindowAdapter infoWindowAdapter = this.a;
        if (infoWindowAdapter == null || !(infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) infoWindowAdapter).getInfoWindowClick(marker);
    }

    public boolean a(MotionEvent motionEvent) {
        IInfoWindowAction d = d();
        if (d != null) {
            return d.onInfoWindowTap(motionEvent);
        }
        return false;
    }

    public void a(BaseOverlayImp baseOverlayImp) throws RemoteException {
        IInfoWindowAction d = d();
        if (d != null) {
            d.showInfoWindow(baseOverlayImp);
        }
    }
}
