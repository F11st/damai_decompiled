package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import com.amap.api.mapcore.util.b;
import com.amap.api.mapcore.util.di;
import com.amap.api.mapcore.util.fb;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate;
import com.autonavi.amap.api.mapcore.overlays.IParticleLatyer;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glinterface.MapLabelItem;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ICircleDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.INavigateArrowDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.taobao.weex.common.Constants;
import com.uc.crashsdk.export.LogType;
import com.youku.live.livesdk.wkit.component.Constants;
import com.youku.uplayer.AliMediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c implements b.a, di.a, IAMapDelegate, IAMapListener {
    private AMap.OnMapTouchListener A;
    private AMap.OnPOIClickListener B;
    private AMap.OnMapLongClickListener C;
    private AMap.OnInfoWindowClickListener D;
    private AMap.OnIndoorBuildingActiveListener E;
    private AMap.OnMyLocationChangeListener F;
    private h G;
    private AMapWidgetListener H;
    private List<AMap.OnMarkerClickListener> I;
    private List<AMap.OnPolylineClickListener> J;
    private List<AMap.OnMarkerDragListener> K;
    private List<AMap.OnMapLoadedListener> L;
    private List<AMap.OnCameraChangeListener> M;
    private List<AMap.OnMapClickListener> N;
    private List<AMap.OnMapTouchListener> O;
    private List<AMap.OnPOIClickListener> P;
    private List<AMap.OnMapLongClickListener> Q;
    private List<AMap.OnInfoWindowClickListener> R;
    private List<AMap.OnIndoorBuildingActiveListener> S;
    private List<AMap.OnMyLocationChangeListener> T;
    private List<AMap.onMapPrintScreenListener> U;
    private List<AMap.OnMapScreenShotListener> V;
    private AMapGestureListener W;
    private ar X;
    private da Y;
    private UiSettings Z;
    protected boolean a;
    private boolean aA;
    private Rect aB;
    private int aC;
    private MyTrafficStyle aD;
    private Thread aE;
    private Thread aF;
    private boolean aG;
    private boolean aH;
    private boolean aI;
    private int aJ;
    private CustomRenderer aK;
    private final v aL;
    private int aM;
    private int aN;
    private List<x> aO;
    private dg aP;
    private di aQ;
    private g aR;
    private GLMapRender aS;
    private p aT;
    private boolean aU;
    private float aV;
    private float aW;
    private float aX;
    private boolean aY;
    private boolean aZ;
    private IProjectionDelegate aa;
    private final ac ab;
    private boolean ac;
    private final IGLSurfaceView ad;
    private fd ae;
    private ab af;
    private Object ag;
    private final r ah;
    private boolean ai;
    private int aj;
    private boolean ak;
    private o al;
    private List<AMapWidgetListener> am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private cv aq;
    private LocationSource ar;
    private boolean as;
    private Marker at;
    private BaseOverlayImp au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private boolean az;
    protected final u b;
    private Runnable bA;
    private a bB;
    private a bC;
    private jp bD;
    private String bE;
    private String bF;
    private EAMapPlatformGestureInfo bG;
    private long bH;
    private aq bI;
    private IPoint[] bJ;
    private boolean ba;
    private int bb;
    private volatile boolean bc;
    private volatile boolean bd;
    private boolean be;
    private boolean bf;
    private Lock bg;
    private int bh;
    private int bi;
    private int bj;
    private b bk;
    private de bl;
    private s bm;
    private ax bn;
    private com.amap.api.mapcore.util.b bo;
    private long bp;
    private a bq;
    private a br;
    private a bs;
    private a bt;
    private a bu;
    private a bv;
    private a bw;
    private a bx;
    private a by;
    private a bz;
    protected MapConfig c;
    protected aq d;
    eh e;
    protected Context f;
    protected GLMapEngine g;
    public int h;
    public int i;
    protected final Handler j;
    Point k;
    Rect l;
    protected String m;
    float[] n;
    float[] o;
    float[] p;
    float[] q;
    String r;
    String s;
    int t;
    private AMap.OnMarkerClickListener u;
    private AMap.OnPolylineClickListener v;
    private AMap.OnMarkerDragListener w;
    private AMap.OnMapLoadedListener x;
    private AMap.OnCameraChangeListener y;
    private AMap.OnMapClickListener z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static abstract class a implements Runnable {
        boolean b;
        boolean c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;

        private a() {
            this.b = false;
            this.c = false;
            this.h = 0;
            this.i = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b = false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class b {
        b() {
        }

        public void a(aq aqVar) {
            aq aqVar2;
            aq aqVar3;
            int[] iArr;
            String[] strArr;
            MapConfig mapConfig = c.this.c;
            if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                return;
            }
            final fb e = c.this.ae.e();
            if (aqVar == null) {
                try {
                    if (c.this.S != null && c.this.S.size() > 0) {
                        for (int i = 0; i < c.this.S.size(); i++) {
                            ((AMap.OnIndoorBuildingActiveListener) c.this.S.get(i)).OnIndoorBuilding(aqVar);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                aq aqVar4 = c.this.d;
                if (aqVar4 != null) {
                    aqVar4.g = null;
                }
                if (e.d()) {
                    c.this.j.post(new Runnable() { // from class: com.amap.api.mapcore.util.c.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.a(false);
                        }
                    });
                }
                MapConfig mapConfig2 = c.this.c;
                mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? c.this.c.getMaxZoomLevel() : 20.0f;
                try {
                    if (!c.this.ab.isZoomControlsEnabled() || c.this.am == null || c.this.am.size() <= 0) {
                        return;
                    }
                    for (int i2 = 0; i2 < c.this.am.size(); i2++) {
                        ((AMapWidgetListener) c.this.am.get(i2)).invalidateZoomController(c.this.c.getSZ());
                    }
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (aqVar != null && (iArr = aqVar.floor_indexs) != null && (strArr = aqVar.floor_names) != null && iArr.length == strArr.length) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = aqVar.floor_indexs;
                    if (i3 >= iArr2.length) {
                        break;
                    } else if (aqVar.activeFloorIndex == iArr2[i3]) {
                        aqVar.activeFloorName = aqVar.floor_names[i3];
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            if (aqVar == null || (aqVar3 = c.this.d) == null || aqVar3.activeFloorIndex == aqVar.activeFloorIndex || !e.d()) {
                if (aqVar != null && ((aqVar2 = c.this.d) == null || !aqVar2.poiid.equals(aqVar.poiid) || c.this.d.g == null)) {
                    c cVar = c.this;
                    cVar.d = aqVar;
                    if (cVar.c != null) {
                        if (aqVar.g == null) {
                            aqVar.g = new Point();
                        }
                        DPoint mapGeoCenter = c.this.c.getMapGeoCenter();
                        if (mapGeoCenter != null) {
                            Point point = c.this.d.g;
                            point.x = (int) mapGeoCenter.x;
                            point.y = (int) mapGeoCenter.y;
                        }
                    }
                }
                try {
                    if (c.this.S != null && c.this.S.size() > 0) {
                        for (int i4 = 0; i4 < c.this.S.size(); i4++) {
                            ((AMap.OnIndoorBuildingActiveListener) c.this.S.get(i4)).OnIndoorBuilding(aqVar);
                        }
                    }
                    MapConfig mapConfig3 = c.this.c;
                    mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? c.this.c.getMaxZoomLevel() : 20.0f;
                    if (c.this.ab.isZoomControlsEnabled() && c.this.am != null && c.this.am.size() > 0) {
                        for (int i5 = 0; i5 < c.this.am.size(); i5++) {
                            ((AMapWidgetListener) c.this.am.get(i5)).invalidateZoomController(c.this.c.getSZ());
                        }
                    }
                    if (!c.this.ab.isIndoorSwitchEnabled()) {
                        if (c.this.ab.isIndoorSwitchEnabled() || !e.d()) {
                            return;
                        }
                        c.this.ab.setIndoorSwitchEnabled(false);
                        return;
                    }
                    if (!e.d()) {
                        c.this.ab.setIndoorSwitchEnabled(true);
                    }
                    c.this.j.post(new Runnable() { // from class: com.amap.api.mapcore.util.c.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                e.a(c.this.d.floor_names);
                                e.a(c.this.d.activeFloorName);
                                if (e.d()) {
                                    return;
                                }
                                e.a(true);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    });
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0212c implements fb.a {
        private C0212c() {
        }

        @Override // com.amap.api.mapcore.util.fb.a
        public void a(int i) {
            c cVar = c.this;
            aq aqVar = cVar.d;
            if (aqVar != null) {
                aqVar.activeFloorIndex = aqVar.floor_indexs[i];
                aqVar.activeFloorName = aqVar.floor_names[i];
                try {
                    cVar.setIndoorBuildingInfo(aqVar);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class d implements Runnable {
        private Context b;
        private AMap.OnCacheRemoveListener c;

        public d(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        public boolean equals(Object obj) {
            return obj instanceof d;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
            if (com.amap.api.mapcore.util.eq.e(r2) != false) goto L14;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #1 {all -> 0x0034, blocks: (B:11:0x0027, B:18:0x003a), top: B:54:0x0027 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x004a A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #0 {all -> 0x0061, blocks: (B:3:0x0002, B:5:0x001b, B:22:0x0042, B:24:0x004a), top: B:52:0x0002 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x007b -> B:41:0x007e). Please submit an issue!!! */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                android.content.Context r2 = r6.b     // Catch: java.lang.Throwable -> L61
                android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L61
                java.lang.String r3 = com.amap.api.mapcore.util.eq.c(r2)     // Catch: java.lang.Throwable -> L61
                java.lang.String r4 = com.amap.api.mapcore.util.eq.a(r2)     // Catch: java.lang.Throwable -> L61
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L61
                r5.<init>(r3)     // Catch: java.lang.Throwable -> L61
                boolean r3 = r5.exists()     // Catch: java.lang.Throwable -> L61
                if (r3 == 0) goto L24
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L61
                if (r3 == 0) goto L22
                goto L24
            L22:
                r3 = 0
                goto L25
            L24:
                r3 = 1
            L25:
                if (r3 == 0) goto L37
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L34
                r5.<init>(r4)     // Catch: java.lang.Throwable -> L34
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L34
                if (r3 == 0) goto L37
                r3 = 1
                goto L38
            L34:
                r2 = move-exception
                r1 = r3
                goto L62
            L37:
                r3 = 0
            L38:
                if (r3 == 0) goto L41
                boolean r2 = com.amap.api.mapcore.util.eq.e(r2)     // Catch: java.lang.Throwable -> L34
                if (r2 == 0) goto L41
                goto L42
            L41:
                r1 = 0
            L42:
                com.amap.api.mapcore.util.c r2 = com.amap.api.mapcore.util.c.this     // Catch: java.lang.Throwable -> L61
                com.amap.api.mapcore.util.ab r2 = com.amap.api.mapcore.util.c.i(r2)     // Catch: java.lang.Throwable -> L61
                if (r2 == 0) goto L53
                com.amap.api.mapcore.util.c r2 = com.amap.api.mapcore.util.c.this     // Catch: java.lang.Throwable -> L61
                com.amap.api.mapcore.util.ab r2 = com.amap.api.mapcore.util.c.i(r2)     // Catch: java.lang.Throwable -> L61
                r2.i()     // Catch: java.lang.Throwable -> L61
            L53:
                com.amap.api.mapcore.util.c r0 = com.amap.api.mapcore.util.c.this     // Catch: java.lang.Throwable -> L7a
                com.autonavi.base.ae.gmap.GLMapEngine r0 = r0.g     // Catch: java.lang.Throwable -> L7a
                if (r0 == 0) goto L7e
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r6.c     // Catch: java.lang.Throwable -> L7a
                if (r0 == 0) goto L7e
                r0.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L7a
                goto L7e
            L61:
                r2 = move-exception
            L62:
                com.amap.api.mapcore.util.eq.a(r2)     // Catch: java.lang.Throwable -> L7f
                java.lang.String r3 = "AMapDelegateImp"
                java.lang.String r4 = "RemoveCacheRunnable"
                com.amap.api.mapcore.util.hd.c(r2, r3, r4)     // Catch: java.lang.Throwable -> L7f
                com.amap.api.mapcore.util.c r1 = com.amap.api.mapcore.util.c.this     // Catch: java.lang.Throwable -> L7a
                com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.g     // Catch: java.lang.Throwable -> L7a
                if (r1 == 0) goto L7e
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r6.c     // Catch: java.lang.Throwable -> L7a
                if (r1 == 0) goto L7e
                r1.onRemoveCacheFinish(r0)     // Catch: java.lang.Throwable -> L7a
                goto L7e
            L7a:
                r0 = move-exception
                r0.printStackTrace()
            L7e:
                return
            L7f:
                r0 = move-exception
                com.amap.api.mapcore.util.c r2 = com.amap.api.mapcore.util.c.this     // Catch: java.lang.Throwable -> L8e
                com.autonavi.base.ae.gmap.GLMapEngine r2 = r2.g     // Catch: java.lang.Throwable -> L8e
                if (r2 == 0) goto L92
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r6.c     // Catch: java.lang.Throwable -> L8e
                if (r2 == 0) goto L92
                r2.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L8e
                goto L92
            L8e:
                r1 = move-exception
                r1.printStackTrace()
            L92:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.c.d.run():void");
        }
    }

    public c(IGLSurfaceView iGLSurfaceView, Context context, AttributeSet attributeSet) {
        this(iGLSurfaceView, context, attributeSet, false);
    }

    private void j(int i) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void accelerateNetworkInChinese(boolean z) {
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a("accelerateNetworkInChinese", Boolean.valueOf(z));
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Arc addArc(ArcOptions arcOptions) throws RemoteException {
        try {
            resetRenderTime();
            IArcDelegate a2 = this.ah.a(arcOptions);
            if (a2 != null) {
                return new Arc(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public BuildingOverlay addBuildingOverlay() {
        try {
            IBuildingDelegate a2 = this.ah.a();
            eo.g(this.f);
            if (a2 != null) {
                return new BuildingOverlay(a2);
            }
            return null;
        } catch (RemoteException e) {
            eq.a(e);
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        try {
            resetRenderTime();
            ICircleDelegate a2 = this.ah.a(circleOptions);
            if (a2 != null) {
                return new Circle(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(1, getContext(), this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.getOverlayBundle(1).addOverlay(crossVectorOverlay);
            crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        }
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        return this.al.a(gL3DModelOptions);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void addGestureMapMessage(int i, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.bc || this.g == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.ao;
            abstractGestureMapMessage.anchorX = this.c.getAnchorX();
            abstractGestureMapMessage.anchorY = this.c.getAnchorY();
            this.g.addGestureMessage(i, abstractGestureMapMessage, this.ab.isGestureScaleByMapCenter(), this.c.getAnchorX(), this.c.getAnchorY());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            IGroundOverlayDelegate a2 = this.ah.a(groundOverlayOptions);
            if (a2 != null) {
                return new GroundOverlay(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            IHeatMapLayer a2 = this.ah.a(heatMapLayerOptions);
            if (a2 != null) {
                return new HeatMapLayer(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            return this.b.a(markerOptions);
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        try {
            resetRenderTime();
            return this.b.a(arrayList, z);
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            IMultiPointOverlay a2 = this.bn.a(multiPointOverlayOptions);
            if (a2 != null) {
                return new MultiPointOverlay(a2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public RouteOverlay addNaviRouteOverlay() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        try {
            resetRenderTime();
            INavigateArrowDelegate a2 = this.ah.a(navigateArrowOptions);
            if (a2 != null) {
                return new NavigateArrow(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        a((List<List<AMap.OnCameraChangeListener>>) this.M, (List<AMap.OnCameraChangeListener>) onCameraChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        a((List<List<AMap.OnIndoorBuildingActiveListener>>) this.S, (List<AMap.OnIndoorBuildingActiveListener>) onIndoorBuildingActiveListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        a((List<List<AMap.OnInfoWindowClickListener>>) this.R, (List<AMap.OnInfoWindowClickListener>) onInfoWindowClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        a((List<List<AMap.OnMapClickListener>>) this.N, (List<AMap.OnMapClickListener>) onMapClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        a((List<List<AMap.OnMapLoadedListener>>) this.L, (List<AMap.OnMapLoadedListener>) onMapLoadedListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        a((List<List<AMap.OnMapLongClickListener>>) this.Q, (List<AMap.OnMapLongClickListener>) onMapLongClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        a((List<List<AMap.OnMapTouchListener>>) this.O, (List<AMap.OnMapTouchListener>) onMapTouchListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        a((List<List<AMap.OnMarkerClickListener>>) this.I, (List<AMap.OnMarkerClickListener>) onMarkerClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        a((List<List<AMap.OnMarkerDragListener>>) this.K, (List<AMap.OnMarkerDragListener>) onMarkerDragListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        a((List<List<AMap.OnMyLocationChangeListener>>) this.T, (List<AMap.OnMyLocationChangeListener>) onMyLocationChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        a((List<List<AMap.OnPOIClickListener>>) this.P, (List<AMap.OnPOIClickListener>) onPOIClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        a((List<List<AMap.OnPolylineClickListener>>) this.J, (List<AMap.OnPolylineClickListener>) onPolylineClickListener);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void addOverlayTexture(int i, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.g;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i)) != null && gLTextureProperty != null && gLTextureProperty.mBitmap != null) {
                this.g.addOverlayTexture(i, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        try {
            IParticleLatyer a2 = this.ah.a(particleOverlayOptions);
            if (a2 != null) {
                eo.c(this.f);
                return new ParticleOverlay(a2);
            }
            return null;
        } catch (RemoteException e) {
            eq.a(e);
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        try {
            resetRenderTime();
            IPolygonDelegate a2 = this.ah.a(polygonOptions);
            if (a2 != null) {
                return new Polygon(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        try {
            resetRenderTime();
            IPolylineDelegate a2 = this.ah.a(polylineOptions);
            if (a2 != null) {
                return new Polyline(a2);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            return this.b.a(textOptions);
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void addTextureItem(x xVar) {
        if (xVar == null || xVar.k() == 0) {
            return;
        }
        synchronized (this.aO) {
            this.aO.add(xVar);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            synchronized (this.ag) {
                if (this.af == null) {
                    this.af = new ab(this.f, this);
                }
            }
            if (this.af != null) {
                TileProvider tileProvider = tileOverlayOptions.getTileProvider();
                if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                    eo.a(this.f);
                }
                return this.af.a(tileOverlayOptions);
            }
            return null;
        } catch (Throwable th) {
            eq.a(th);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterDrawFrame(int i, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.g;
        if (!(gLMapEngine != null && (gLMapEngine.isInMapAction(i) || this.g.isInMapAnimation(i)))) {
            int i2 = this.aN;
            if (i2 != -1) {
                this.aS.setRenderFps(i2);
            } else {
                this.aS.setRenderFps(15.0f);
            }
            if (this.bb == 1) {
                this.bb = 0;
            }
            if (this.aV != mapZoomer) {
                this.aV = mapZoomer;
            }
        }
        if (this.bf) {
            return;
        }
        this.bf = true;
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterDrawLabel(int i, GLMapState gLMapState) {
        a();
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a(gLMapState, this.c);
        }
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        ab abVar = this.af;
        if (abVar != null) {
            abVar.b();
        }
        this.ah.a(false, this.aJ);
        ax axVar = this.bn;
        if (axVar != null) {
            axVar.a(this.c, getViewMatrix(), getProjectionMatrix());
        }
        o oVar = this.al;
        if (oVar != null) {
            oVar.a();
        }
        u uVar = this.b;
        if (uVar != null) {
            uVar.a(false);
        }
        da daVar = this.Y;
        if (daVar != null) {
            daVar.b(getMapWidth(), getMapHeight());
        }
        GLMapEngine gLMapEngine2 = this.g;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterRendererOver(int i, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        u uVar = this.b;
        if (uVar != null) {
            uVar.a(true);
        }
        GLMapEngine gLMapEngine2 = this.g;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate, 250L, cancelableCallback);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j, cancelableCallback);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void beforeDrawLabel(int i, GLMapState gLMapState) {
        a();
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.ah.a(true, this.aJ);
        GLMapEngine gLMapEngine2 = this.g;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Pair<Float, LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i == i2 && i2 == i3 && i3 == i4 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng != null && latLng2 != null && this.bc && !this.ak) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(latLng);
            builder.include(latLng2);
            GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
            Pair<Float, IPoint> a2 = eq.a(mapConfig, i, i2, i3, i4, builder.build(), getMapWidth(), getMapHeight());
            gLMapState.recycle();
            if (a2 != null) {
                DPoint obtain = DPoint.obtain();
                Object obj = a2.second;
                GLMapState.geo2LonLat(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx((IPoint) obj), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety((IPoint) obj), obtain);
                Pair<Float, LatLng> pair = new Pair<>(a2.first, new LatLng(obtain.y, obtain.x));
                obtain.recycle();
                return pair;
            }
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain2.y, obtain2.x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean canShowIndoorSwitch() {
        aq aqVar;
        if (getZoomLevel() < 17 || (aqVar = this.d) == null || aqVar.g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        Point point = this.d.g;
        a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), obtain);
        return this.aB.contains((int) ((PointF) obtain).x, (int) ((PointF) obtain).y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.canStopMapRender(1);
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeGLOverlayIndex() {
        this.ah.e();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeLogoIconStyle(String str, boolean z, int i) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.a(str, Boolean.valueOf(z), Integer.valueOf(i));
        }
        ac acVar = this.ab;
        if (acVar != null) {
            acVar.requestRefreshLogo();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeMapLogo(int i, boolean z) {
        if (this.ak) {
            return;
        }
        try {
            List<AMapWidgetListener> list = this.am;
            if (list == null || list.size() <= 0) {
                return;
            }
            this.ae.g(Boolean.valueOf(!z));
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeSize(int i, int i2) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            this.h = i;
            this.i = i2;
            mapConfig.setMapWidth(i);
            this.c.setMapHeight(i2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeSurface(int i, GL10 gl10, int i2, int i3) {
        WindowManager windowManager;
        this.bf = false;
        if (!this.bc) {
            createSurface(i, gl10, null);
        }
        p pVar = this.aT;
        if (pVar != null && this.f != null && ((this.h != pVar.b() || this.i != this.aT.c()) && (windowManager = (WindowManager) this.f.getSystemService(tb.v.ATTACH_MODE_WINDOW)) != null)) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealMetrics(defaultDisplay, displayMetrics);
                this.aT.a(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
            }
        }
        this.h = i2;
        this.i = i3;
        this.aI = true;
        this.aB = new Rect(0, 0, i2, i3);
        this.aj = a(i, new Rect(0, 0, this.h, this.i), this.h, this.i);
        if (!this.bd) {
            MapConfig mapConfig = this.c;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.aW);
                this.c.setMapWidth(i2);
                this.c.setMapHeight(i3);
            }
            this.g.setIndoorEnable(this.aj, false);
            this.g.setSimple3DEnable(this.aj, false);
            this.g.initNativeTexture(this.aj);
            this.g.setMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com//ws/mps/lyrdata/ugc/\"}");
        }
        g gVar = this.aR;
        if (gVar != null) {
            gVar.a(new w(AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX));
        }
        synchronized (this) {
            this.bd = true;
        }
        if (!this.ao) {
            this.c.setAnchorX(i2 >> 1);
            this.c.setAnchorY(i3 >> 1);
        } else {
            this.c.setAnchorX(Math.max(1, Math.min(this.bi, i2 - 1)));
            this.c.setAnchorY(Math.max(1, Math.min(this.bj, i3 - 1)));
        }
        this.g.setProjectionCenter(this.aj, this.c.getAnchorX(), this.c.getAnchorY());
        this.a = true;
        a aVar = this.by;
        if (aVar.b) {
            aVar.run();
        }
        a aVar2 = this.bs;
        if (aVar2.b) {
            aVar2.run();
        }
        a aVar3 = this.bt;
        if (aVar3.b) {
            aVar3.run();
        }
        a aVar4 = this.bq;
        if (aVar4.b) {
            aVar4.run();
        }
        a aVar5 = this.bu;
        if (aVar5.b) {
            aVar5.run();
        }
        a aVar6 = this.bB;
        if (aVar6.b) {
            aVar6.run();
        }
        a aVar7 = this.bv;
        if (aVar7.b) {
            aVar7.run();
        }
        a aVar8 = this.bw;
        if (aVar8.b) {
            aVar8.run();
        }
        a aVar9 = this.bx;
        if (aVar9.b) {
            aVar9.run();
        }
        a aVar10 = this.bz;
        if (aVar10.b) {
            aVar10.run();
        }
        a aVar11 = this.br;
        if (aVar11.b) {
            aVar11.run();
        }
        a aVar12 = this.bC;
        if (aVar12.b) {
            aVar12.run();
        }
        CustomRenderer customRenderer = this.aK;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i2, i3);
        }
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a(gl10, i2, i3);
        }
        Handler handler = this.j;
        if (handler != null) {
            handler.post(this.bA);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void checkMapState(IGLMapState iGLMapState) {
        MapConfig mapConfig = this.c;
        if (mapConfig == null || this.ak) {
            return;
        }
        LatLngBounds limitLatLngBounds = mapConfig.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds != null) {
                IPoint[] limitIPoints = this.c.getLimitIPoints();
                if (limitIPoints == null) {
                    IPoint obtain = IPoint.obtain();
                    LatLng latLng = limitLatLngBounds.northeast;
                    GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                    IPoint obtain2 = IPoint.obtain();
                    LatLng latLng2 = limitLatLngBounds.southwest;
                    GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                    IPoint[] iPointArr = {obtain, obtain2};
                    this.c.setLimitIPoints(iPointArr);
                    limitIPoints = iPointArr;
                }
                float b2 = eq.b(this.c, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(limitIPoints[0]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(limitIPoints[0]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(limitIPoints[1]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(limitIPoints[1]), getMapWidth(), getMapHeight());
                float mapZoomer = iGLMapState.getMapZoomer();
                if (this.c.isSetLimitZoomLevel()) {
                    float maxZoomLevel = this.c.getMaxZoomLevel();
                    float minZoomLevel = this.c.getMinZoomLevel();
                    float max = Math.max(b2, Math.min(mapZoomer, maxZoomLevel));
                    if (b2 <= maxZoomLevel) {
                        maxZoomLevel = max;
                    }
                    b2 = maxZoomLevel < minZoomLevel ? minZoomLevel : maxZoomLevel;
                } else if (b2 <= 0.0f || mapZoomer >= b2) {
                    b2 = mapZoomer;
                }
                iGLMapState.setMapZoomer(b2);
                IPoint obtain3 = IPoint.obtain();
                iGLMapState.getMapGeoCenter(obtain3);
                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain3);
                int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain3);
                int[] a2 = eq.a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(limitIPoints[0]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(limitIPoints[0]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(limitIPoints[1]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(limitIPoints[1]), this.c, iGLMapState, xVar, yVar);
                if (a2 != null && a2.length == 2) {
                    xVar = a2[0];
                    yVar = a2[1];
                }
                iGLMapState.setMapGeoCenter(xVar, yVar);
                obtain3.recycle();
            } else if (this.c.isSetLimitZoomLevel()) {
                iGLMapState.setMapZoomer(Math.max(this.c.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.c.getMaxZoomLevel())));
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int checkMarkerInRect(IMarkerAction iMarkerAction, Rect rect) {
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float checkZoomLevel(float f) throws RemoteException {
        return eq.a(this.c, f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", Constants.TAG_CLEAR_STRING);
            eq.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void clearTileCache() {
        ab abVar = this.af;
        if (abVar != null) {
            abVar.i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long createGLOverlay(int i) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(1, i);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public String createId(String str) {
        r rVar = this.ah;
        if (rVar != null) {
            return rVar.a(str);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public synchronized void createSurface(int i, GL10 gl10, EGLConfig eGLConfig) {
        this.bp = System.currentTimeMillis();
        if (this.aC == 3) {
            this.ae.d().a(ez.b);
        } else {
            this.ae.d().a(ez.a);
        }
        this.bd = false;
        this.h = this.ad.getWidth();
        this.i = this.ad.getHeight();
        this.bf = false;
        AeUtil.initCrashHandle(this.f, AeUtil.loadLib(this.f));
        this.g.createAMapInstance(AeUtil.initResource(this.f));
        j(i);
        synchronized (this.ag) {
            if (this.af == null) {
                this.af = new ab(this.f, this);
            }
        }
        de deVar = new de();
        this.bl = deVar;
        this.ah.a(deVar);
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a("setGLShaderManager", this.bl);
        }
        this.bc = true;
        this.m = gl10.glGetString(7937);
        GLMapState mapState = this.g.getMapState(1);
        if (mapState != null && mapState.getNativeInstance() != 0) {
            mapState.setMapGeoCenter((int) this.c.getSX(), (int) this.c.getSY());
            mapState.setMapAngle(this.c.getSR());
            mapState.setMapZoomer(this.c.getSZ());
            mapState.setCameraDegree(this.c.getSC());
        }
        this.bm.a(this.f);
        j();
        CustomRenderer customRenderer = this.aK;
        if (customRenderer != null) {
            customRenderer.onSurfaceCreated(gl10, eGLConfig);
        }
        jp jpVar2 = this.bD;
        if (jpVar2 != null) {
            jpVar2.a(gl10, eGLConfig);
        }
        d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void destroy() {
        this.ak = true;
        try {
            g gVar = this.aR;
            if (gVar != null) {
                gVar.a();
            }
            ax axVar = this.bn;
            if (axVar != null) {
                axVar.b();
            }
            LocationSource locationSource = this.ar;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.ar = null;
            this.bk = null;
            GLMapRender gLMapRender = this.aS;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            s sVar = this.bm;
            if (sVar != null) {
                sVar.e();
            }
            p pVar = this.aT;
            if (pVar != null) {
                pVar.a((AMapGestureListener) null);
                this.aT.d();
                this.aT = null;
            }
            r rVar = this.ah;
            if (rVar != null) {
                rVar.d();
            }
            u uVar = this.b;
            if (uVar != null) {
                uVar.i();
            }
            ab abVar = this.af;
            if (abVar != null) {
                abVar.g();
            }
            g();
            Thread thread = this.aE;
            if (thread != null) {
                thread.interrupt();
                this.aE = null;
            }
            Thread thread2 = this.aF;
            if (thread2 != null) {
                thread2.interrupt();
                this.aF = null;
            }
            dg dgVar = this.aP;
            if (dgVar != null) {
                dgVar.a();
                this.aP = null;
            }
            di diVar = this.aQ;
            if (diVar != null) {
                diVar.a((di.a) null);
                this.aQ.a();
                this.aQ = null;
            }
            ea.b();
            GLMapEngine gLMapEngine = this.g;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                this.g.releaseNetworkState();
                queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.33
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c cVar = c.this;
                            cVar.destroySurface(cVar.aj);
                        } catch (Throwable th) {
                            th.printStackTrace();
                            eq.a(th);
                        }
                    }
                });
                int i = 0;
                while (this.g != null) {
                    int i2 = i + 1;
                    if (i >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e) {
                        eq.a(e);
                    }
                    i = i2;
                }
            }
            o oVar = this.al;
            if (oVar != null) {
                oVar.c();
            }
            ar arVar = this.X;
            if (arVar != null) {
                arVar.b();
            }
            IGLSurfaceView iGLSurfaceView = this.ad;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    eq.a(e2);
                }
            }
            fd fdVar = this.ae;
            if (fdVar != null) {
                fdVar.i();
                this.ae = null;
            }
            cv cvVar = this.aq;
            if (cvVar != null) {
                cvVar.c();
                this.aq = null;
            }
            this.ar = null;
            m();
            this.aD = null;
            hd.b();
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            eq.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void destroySurface(int i) {
        this.bg.lock();
        try {
            if (this.bc) {
                if (EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT) {
                    s sVar = this.bm;
                    if (sVar != null) {
                        sVar.d();
                    }
                    de deVar = this.bl;
                    if (deVar != null) {
                        deVar.b();
                        this.bl = null;
                    }
                }
                GLMapEngine gLMapEngine = this.g;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.aj) != null) {
                        this.g.getOverlayBundle(this.aj).removeAll(true);
                    }
                    this.g.destroyAMapEngine();
                    this.g = null;
                }
                if (EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT) {
                    this.al.d();
                }
                jp jpVar = this.bD;
                if (jpVar != null) {
                    jpVar.a();
                }
            }
            this.bc = false;
            this.bd = false;
            this.bf = false;
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void drawFrame(GL10 gl10) {
        if (this.ak || this.g == null || EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            return;
        }
        MapConfig mapConfig = this.c;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            GLES20.glClear(LogType.UNEXP_RESTART);
            return;
        }
        a(1, gl10);
        this.g.renderAMap();
        this.g.pushRendererState();
        CustomRenderer customRenderer = this.aK;
        if (customRenderer != null) {
            customRenderer.onDrawFrame(gl10);
        }
        com.amap.api.mapcore.util.b bVar = this.bo;
        if (bVar != null) {
            bVar.a();
        }
        a(gl10);
        i();
        if (!this.be) {
            this.be = true;
        }
        this.g.popRendererState();
        g gVar = this.aR;
        if (gVar != null) {
            gVar.a(new w(AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX));
        }
        if (eh.a()) {
            try {
                if (this.ad instanceof f) {
                    if (this.e == null) {
                        this.e = new eh();
                    }
                    this.e.e();
                    if (!this.e.f() || this.e.d()) {
                        return;
                    }
                    if (this.e.a(((f) this.ad).getBitmap())) {
                        if (eh.b()) {
                            removecache();
                        }
                        if (eh.c()) {
                            this.e.g();
                        }
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void geo2Latlng(int i, int i2, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i, i2, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void geo2Map(int i, int i2, FPoint fPoint) {
        ((PointF) fPoint).x = (int) (i - this.c.getSX());
        ((PointF) fPoint).y = (int) (i2 - this.c.getSY());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public jp getAMapExtraInterfaceManager() {
        return this.bD;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Projection getAMapProjection() throws RemoteException {
        return new Projection(this.aa);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public UiSettings getAMapUiSettings() throws RemoteException {
        if (this.Z == null) {
            this.Z = new UiSettings(this.ab);
        }
        return this.Z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getBaseOverlayTextureID() {
        s sVar = this.bm;
        if (sVar != null) {
            return sVar.c();
        }
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getCameraAngle() {
        return getCameraDegree(this.aj);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getCameraDegree(int i) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public CameraPosition getCameraPosition() throws RemoteException {
        return getCameraPositionPrj(this.ao);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public CameraPosition getCameraPositionPrj(boolean z) {
        LatLng f;
        try {
            if (this.c == null) {
                return null;
            }
            if (this.bc && !this.an && this.g != null) {
                if (z) {
                    DPoint obtain = DPoint.obtain();
                    getPixel2LatLng(this.c.getAnchorX(), this.c.getAnchorY(), obtain);
                    f = new LatLng(obtain.y, obtain.x, false);
                    obtain.recycle();
                } else {
                    f = f();
                }
                return CameraPosition.builder().target(f).bearing(this.c.getSR()).tilt(this.c.getSC()).zoom(this.c.getSZ()).build();
            }
            DPoint obtain2 = DPoint.obtain();
            geo2Latlng((int) this.c.getSX(), (int) this.c.getSY(), obtain2);
            LatLng latLng = new LatLng(obtain2.y, obtain2.x);
            obtain2.recycle();
            return CameraPosition.builder().target(latLng).bearing(this.c.getSR()).tilt(this.c.getSC()).zoom(this.c.getSZ()).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Context getContext() {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getCurrentWorldVectorMapStyle() {
        try {
            jp jpVar = this.bD;
            if (jpVar != null) {
                Object a2 = jpVar.a("getCurMapStyleKey");
                return a2 instanceof String ? (String) a2 : "";
            }
            return "";
        } catch (Throwable th) {
            eq.a(th);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getDottedLineTextureID(int i) {
        s sVar = this.bm;
        if (sVar != null) {
            return sVar.a(i);
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo);
        }
        return 1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float[] getFinalMatrix() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getMvpMatrix();
        }
        return this.n;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public GLMapEngine getGLMapEngine() {
        return this.g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public View getGLMapView() {
        IGLSurfaceView iGLSurfaceView = this.ad;
        if (iGLSurfaceView instanceof View) {
            return (View) iGLSurfaceView;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public dd getGLShader(int i) {
        de deVar = this.bl;
        if (deVar == null) {
            return null;
        }
        return deVar.a(i);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public de getGLShaderManager() {
        return this.bl;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getGeoCenter(int i, IPoint iPoint) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            ((Point) iPoint).x = (int) mapConfig.getSX();
            ((Point) iPoint).y = (int) this.c.getSY();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(1);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return new InfoWindowAnimationManager(this.Y);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getLatLng2Map(double d2, double d3, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d2, d3, obtain);
        geo2Map(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain), fPoint);
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getLatLng2Pixel(double d2, double d3, IPoint iPoint) {
        if (!this.bc || this.g == null) {
            return;
        }
        try {
            Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
            FPoint obtain = FPoint.obtain();
            a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(latLongToPixels), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(latLongToPixels), obtain);
            float f = -10000;
            if (((PointF) obtain).x == f && ((PointF) obtain).y == f) {
                GLMapState gLMapState = (GLMapState) this.g.getNewMapState(1);
                gLMapState.setCameraDegree(0.0f);
                gLMapState.recalculate();
                gLMapState.p20ToScreenPoint(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(latLongToPixels), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(latLongToPixels), obtain);
                gLMapState.recycle();
            }
            ((Point) iPoint).x = (int) ((PointF) obtain).x;
            ((Point) iPoint).y = (int) ((PointF) obtain).y;
            obtain.recycle();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.c.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i = 0; i < 4; i++) {
                    GLMapState.geo2LonLat(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(clipRect[i]), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(clipRect[i]), dPointArr[i]);
                }
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getLineTextureID() {
        s sVar = this.bm;
        if (sVar != null) {
            return sVar.a();
        }
        return 0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getLineTextureRatio() {
        s sVar = this.bm;
        if (sVar != null) {
            return sVar.b();
        }
        return 1.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getLogoMarginRate(int i) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            return fdVar.a(i);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getLogoPosition() {
        try {
            return this.ab.getLogoPosition();
        } catch (RemoteException e) {
            hd.c(e, "AMapDelegateImp", "getLogoPosition");
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Handler getMainHandler() {
        return this.j;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getMapAngle(int i) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public LatLngBounds getMapBounds(LatLng latLng, float f, float f2, float f3) {
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.ak) {
            return null;
        }
        float a2 = eq.a(this.c, f);
        GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
        if (latLng != null) {
            IPoint obtain = IPoint.obtain();
            latlon2Geo(latLng.latitude, latLng.longitude, obtain);
            gLMapState.setCameraDegree(f3);
            gLMapState.setMapAngle(f2);
            gLMapState.setMapGeoCenter(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
            gLMapState.setMapZoomer(a2);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.y, obtain2.x, false);
        a(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng3 = new LatLng(obtain2.y, obtain2.x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public MapConfig getMapConfig() {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.c;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        eo.d(this.f);
        String a2 = eg.a(this.f, "approval_number", "mc", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS（2017）3426号 | GS（2017）2550号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapHeight() {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            a((List<List<AMap.onMapPrintScreenListener>>) this.U, (List<AMap.onMapPrintScreenListener>) onmapprintscreenlistener);
            this.az = true;
            resetRenderTime();
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(1);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public FPoint[] getMapRect() {
        if (this.c.getMapRect() == null) {
            this.c.setMapRect(eq.a((IAMapDelegate) this, true));
        }
        return this.c.getMapRect();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public List<Marker> getMapScreenMarkers() throws RemoteException {
        if (!eq.b(getMapWidth(), getMapHeight())) {
            return new ArrayList();
        }
        return this.b.e();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener) {
        try {
            a((List<List<AMap.OnMapScreenShotListener>>) this.V, (List<AMap.OnMapScreenShotListener>) onMapScreenShotListener);
            this.az = true;
            resetRenderTime();
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapTextZIndex() throws RemoteException {
        return this.aJ;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapType() throws RemoteException {
        return this.aC;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapWidth() {
        return this.h;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getMapZoomScale() {
        return this.aW;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getMaskLayerType() {
        return this.aM;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.c;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th) {
            eq.a(th);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.c;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th) {
            eq.a(th);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Location getMyLocation() throws RemoteException {
        if (this.ar != null) {
            return this.G.a;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public MyLocationStyle getMyLocationStyle() throws RemoteException {
        cv cvVar = this.aq;
        if (cvVar != null) {
            return cvVar.a();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long getNativeMapController() {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(1);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List<AMap.OnCameraChangeListener> list = this.M;
            if (list == null && list.size() != 0) {
                return this.M.get(0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getPixel2Geo(int i, int i2, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (!this.bc || (gLMapEngine = this.g) == null || (mapState = gLMapEngine.getMapState(1)) == null) {
            return;
        }
        mapState.screenToP20Point(i, i2, iPoint);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getPixel2LatLng(int i, int i2, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (!this.bc || (gLMapEngine = this.g) == null || (mapState = gLMapEngine.getMapState(1)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        mapState.screenToP20Point(i, i2, obtain);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain), 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        obtain.recycle();
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getPreciseLevel(int i) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public IProjectionDelegate getProjection() throws RemoteException {
        return this.aa;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float[] getProjectionMatrix() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getProjectionMatrix();
        }
        return this.p;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Rect getRect() {
        return this.aB;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getRenderMode() {
        return this.ad.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getSX() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getSY() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getSatelliteImageApprovalNumber() {
        eo.e(this.f);
        String a2 = eg.a(this.f, "approval_number", "si", "");
        return !TextUtils.isEmpty(a2) ? a2 : "GS（2018）984号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, getZoomLevel()) * 256.0d))) * getMapZoomScale();
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "getScalePerPixel");
            eq.a(th);
            th.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getSkyHeight() {
        return this.c.getSkyHeight();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public x getTextureItem(BitmapDescriptor bitmapDescriptor) {
        return getTextureItem(bitmapDescriptor, false);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public IUiSettingsDelegate getUiSettings() {
        return this.ab;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getUnitLengthByZoom(int i) {
        GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
        gLMapState.setMapZoomer(i);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public View getView() throws RemoteException {
        return this.ae;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float[] getViewMatrix() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.getViewMatrix();
        }
        return this.o;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Point getWaterMarkerPositon() {
        fd fdVar = this.ae;
        if (fdVar != null) {
            return fdVar.a();
        }
        return new Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getWorldVectorMapLanguage() {
        return this.bE;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getWorldVectorMapStyle() {
        return this.bF;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getZoomLevel() {
        return a(this.aj);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = getMapConfig();
            if (latLng != null && latLng2 != null && this.bc && !this.ak) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                builder.include(latLng);
                builder.include(latLng2);
                GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
                Pair<Float, IPoint> a2 = eq.a(mapConfig, 0, 0, 0, 0, builder.build(), getMapWidth(), getMapHeight());
                gLMapState.recycle();
                if (a2 != null) {
                    return ((Float) a2.first).floatValue();
                }
                return gLMapState.getMapZoomer();
            }
            return mapConfig.getSZ();
        } catch (Throwable th) {
            eq.a(th);
            return 0.0f;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void hideInfoWindow() {
        ar arVar = this.X;
        if (arVar != null) {
            arVar.e();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isIndoorEnabled() throws RemoteException {
        return this.c.isIndoorEnable();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isInfoWindowShown(IMarkerDelegate iMarkerDelegate) throws RemoteException {
        ar arVar = this.X;
        if (arVar != null) {
            return arVar.f();
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isLockMapAngle(int i) {
        return a(i, 7);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isLockMapCameraDegree(int i) {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isMaploaded() {
        return this.ap;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isMyLocationEnabled() throws RemoteException {
        return this.ai;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isTrafficEnabled() throws RemoteException {
        return this.c.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isUseAnchor() {
        return this.ao;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void latlon2Geo(double d2, double d3, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d2, d3, 20);
        ((Point) iPoint).x = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(latLongToPixels);
        ((Point) iPoint).y = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(latLongToPixels);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void loadWorldVectorMap(boolean z) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void map2Geo(float f, float f2, IPoint iPoint) {
        ((Point) iPoint).x = (int) (f + this.c.getSX());
        ((Point) iPoint).y = (int) (f2 + this.c.getSY());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onActivityPause() {
        this.an = true;
        c(this.aj);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onActivityResume() {
        this.an = false;
        int i = this.aj;
        if (i == 0) {
            i = this.g.getEngineIDWithType(0);
        }
        d(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onChangeFinish() {
        Message obtainMessage = this.j.obtainMessage();
        obtainMessage.what = 11;
        this.j.sendMessage(obtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean onDoubleTap(int i, MotionEvent motionEvent) {
        if (this.bc) {
            a(i, (int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onFling() {
        ab abVar = this.af;
        if (abVar != null) {
            abVar.b(true);
        }
        this.ay = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onIndoorBuildingActivity(int i, byte[] bArr) {
        aq aqVar;
        if (bArr != null) {
            try {
                aqVar = new aq();
                byte b2 = bArr[0];
                aqVar.a = new String(bArr, 1, b2, "utf-8");
                int i2 = 1 + b2;
                int i3 = i2 + 1;
                byte b3 = bArr[i2];
                aqVar.b = new String(bArr, i3, b3, "utf-8");
                int i4 = i3 + b3;
                int i5 = i4 + 1;
                byte b4 = bArr[i4];
                aqVar.activeFloorName = new String(bArr, i5, b4, "utf-8");
                int i6 = i5 + b4;
                aqVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i6);
                int i7 = i6 + 4;
                int i8 = i7 + 1;
                byte b5 = bArr[i7];
                aqVar.poiid = new String(bArr, i8, b5, "utf-8");
                int i9 = i8 + b5;
                int i10 = i9 + 1;
                byte b6 = bArr[i9];
                aqVar.h = new String(bArr, i10, b6, "utf-8");
                int i11 = i10 + b6;
                int i12 = GLConvertUtil.getInt(bArr, i11);
                aqVar.c = i12;
                int i13 = i11 + 4;
                aqVar.floor_indexs = new int[i12];
                aqVar.floor_names = new String[i12];
                aqVar.d = new String[i12];
                for (int i14 = 0; i14 < aqVar.c; i14++) {
                    aqVar.floor_indexs[i14] = GLConvertUtil.getInt(bArr, i13);
                    int i15 = i13 + 4;
                    int i16 = i15 + 1;
                    byte b7 = bArr[i15];
                    if (b7 > 0) {
                        aqVar.floor_names[i14] = new String(bArr, i16, b7, "utf-8");
                        i16 += b7;
                    }
                    i13 = i16 + 1;
                    byte b8 = bArr[i16];
                    if (b8 > 0) {
                        aqVar.d[i14] = new String(bArr, i13, b8, "utf-8");
                        i13 += b8;
                    }
                }
                int i17 = GLConvertUtil.getInt(bArr, i13);
                aqVar.e = i17;
                int i18 = i13 + 4;
                if (i17 > 0) {
                    aqVar.f = new int[i17];
                    for (int i19 = 0; i19 < aqVar.e; i19++) {
                        aqVar.f[i19] = GLConvertUtil.getInt(bArr, i18);
                        i18 += 4;
                    }
                }
            } catch (Throwable th) {
                eq.a(th);
                th.printStackTrace();
                return;
            }
        } else {
            aqVar = null;
        }
        this.bI = aqVar;
        post(new Runnable() { // from class: com.amap.api.mapcore.util.c.31
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.bk != null) {
                    c.this.bk.a(c.this.bI);
                }
            }
        });
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onLongPress(int i, MotionEvent motionEvent) {
        int i2 = 0;
        try {
            this.av = false;
            b(i);
            BaseOverlayImp a2 = this.b.a(motionEvent);
            this.au = a2;
            if (a2 != null && a2.isDraggable()) {
                Marker marker = new Marker((cu) this.au);
                this.at = marker;
                LatLng position = marker.getPosition();
                LatLng realPosition = this.au.getRealPosition();
                if (position != null && realPosition != null) {
                    IPoint obtain = IPoint.obtain();
                    getLatLng2Pixel(realPosition.latitude, realPosition.longitude, obtain);
                    ((Point) obtain).y = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain) - 60;
                    DPoint obtain2 = DPoint.obtain();
                    getPixel2LatLng(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain), obtain2);
                    this.at.setPosition(new LatLng((position.latitude + obtain2.y) - realPosition.latitude, (position.longitude + obtain2.x) - realPosition.longitude));
                    this.b.a((IMarkerDelegate) ((cu) this.au));
                    List<AMap.OnMarkerDragListener> list = this.K;
                    if (list != null && list.size() > 0) {
                        while (i2 < this.K.size()) {
                            this.K.get(i2).onMarkerDragStart(this.at);
                            i2++;
                        }
                    }
                    this.as = true;
                    obtain.recycle();
                    obtain2.recycle();
                }
            } else {
                List<AMap.OnMapLongClickListener> list2 = this.Q;
                if (list2 != null && list2.size() > 0) {
                    DPoint obtain3 = DPoint.obtain();
                    getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain3);
                    while (i2 < this.Q.size()) {
                        this.Q.get(i2).onMapLongClick(new LatLng(obtain3.y, obtain3.x));
                        i2++;
                    }
                    this.aw = true;
                    obtain3.recycle();
                }
            }
            this.aS.resetTickCount(30);
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "onLongPress");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onPause() {
        e();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onResume() {
        try {
            this.aS.setRenderFps(15.0f);
            this.ad.setRenderMode(0);
            ab abVar = this.af;
            if (abVar != null) {
                abVar.e();
            }
            cv cvVar = this.aq;
            if (cvVar != null) {
                cvVar.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean onSingleTapConfirmed(int i, MotionEvent motionEvent) {
        if (this.bc) {
            try {
                b(i);
                if (g(motionEvent) || e(motionEvent) || f(motionEvent) || d(motionEvent)) {
                    return true;
                }
                b(motionEvent);
                return true;
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "onSingleTapUp");
                th.printStackTrace();
                return true;
            }
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.an && this.bc && this.aY) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.bG;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo = getEngineIDWithGestureInfo(this.bG);
            b();
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                c();
                h(engineIDWithGestureInfo);
            } else if (action == 1) {
                i(engineIDWithGestureInfo);
            }
            if (motionEvent.getAction() == 2 && this.as) {
                try {
                    a(motionEvent);
                } catch (Throwable th) {
                    hd.c(th, "AMapDelegateImp", "onDragMarker");
                    th.printStackTrace();
                }
                return true;
            }
            if (this.aU) {
                try {
                    this.aT.a(motionEvent);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                List<AMap.OnMapTouchListener> list = this.O;
                if (list != null && list.size() > 0) {
                    this.j.removeMessages(14);
                    Message obtainMessage = this.j.obtainMessage();
                    obtainMessage.what = 14;
                    obtainMessage.obj = MotionEvent.obtain(motionEvent);
                    obtainMessage.sendToTarget();
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void pixel2Map(int i, int i2, PointF pointF) {
        if (!this.bc || this.an || this.g == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        getPixel2Geo(i, i2, obtain);
        pointF.x = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain) - ((float) this.c.getSX());
        pointF.y = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain) - ((float) this.c.getSY());
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.ad;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void queueEvent(Runnable runnable) {
        try {
            if (this.g != null) {
                this.ad.queueEvent(runnable);
            }
        } catch (Throwable th) {
            eq.a(th);
            hd.c(th, "AMapdelegateImp", "queueEvent");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void redrawInfoWindow() {
        if (this.bc) {
            this.j.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void refreshLogo() {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void reloadMap() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void reloadMapCustomStyle() {
        com.amap.api.mapcore.util.b bVar = this.bo;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.getOverlayBundle(1).removeOverlay(baseMapOverlay);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean removeGLModel(String str) {
        try {
            this.al.a(str);
            return false;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "removeGLModel");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        return this.ah.removeOverlay(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean removeMarker(String str) {
        try {
            IOverlayImageDelegate a2 = this.b.a(str);
            if (a2 != null) {
                resetRenderTime();
                return this.b.a(a2);
            }
            return false;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "removeMarker");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        b((List<List<AMap.OnCameraChangeListener>>) this.M, (List<AMap.OnCameraChangeListener>) onCameraChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        b((List<List<AMap.OnIndoorBuildingActiveListener>>) this.S, (List<AMap.OnIndoorBuildingActiveListener>) onIndoorBuildingActiveListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        b((List<List<AMap.OnInfoWindowClickListener>>) this.R, (List<AMap.OnInfoWindowClickListener>) onInfoWindowClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        b((List<List<AMap.OnMapClickListener>>) this.N, (List<AMap.OnMapClickListener>) onMapClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        b((List<List<AMap.OnMapLoadedListener>>) this.L, (List<AMap.OnMapLoadedListener>) onMapLoadedListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        b((List<List<AMap.OnMapLongClickListener>>) this.Q, (List<AMap.OnMapLongClickListener>) onMapLongClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        b((List<List<AMap.OnMapTouchListener>>) this.O, (List<AMap.OnMapTouchListener>) onMapTouchListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        b((List<List<AMap.OnMarkerClickListener>>) this.I, (List<AMap.OnMarkerClickListener>) onMarkerClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        b((List<List<AMap.OnMarkerDragListener>>) this.K, (List<AMap.OnMarkerDragListener>) onMarkerDragListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        b((List<List<AMap.OnMyLocationChangeListener>>) this.T, (List<AMap.OnMyLocationChangeListener>) onMyLocationChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        b((List<List<AMap.OnPOIClickListener>>) this.P, (List<AMap.OnPOIClickListener>) onPOIClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        b((List<List<AMap.OnPolylineClickListener>>) this.J, (List<AMap.OnPolylineClickListener>) onPolylineClickListener);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void removeTextureItem(String str) {
        synchronized (this.aO) {
            int size = this.aO.size();
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.aO.get(i2).p().equals(str)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i >= 0) {
                this.aO.remove(i);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removecache() throws RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void requestRender() {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.ad.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void resetMinMaxZoomPreference() {
        List<AMapWidgetListener> list;
        this.c.resetMinMaxZoomPreference();
        try {
            if (!this.ab.isZoomControlsEnabled() || !this.c.isNeedUpdateZoomControllerState() || (list = this.am) == null || list.size() <= 0) {
                return;
            }
            for (int i = 0; i < this.am.size(); i++) {
                this.am.get(i).invalidateZoomController(this.c.getSZ());
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void resetRenderTime() {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void set3DBuildingEnabled(boolean z) throws RemoteException {
        try {
            c(1);
            a(1, z);
            d(1);
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        p pVar = this.aT;
        if (pVar != null) {
            this.W = aMapGestureListener;
            pVar.a(aMapGestureListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCenterToPixel(int i, int i2) throws RemoteException {
        this.ao = true;
        this.bi = i;
        this.bj = i2;
        if (this.bd && this.bc) {
            if (this.c.getAnchorX() == this.bi && this.c.getAnchorY() == this.bj) {
                return;
            }
            this.c.setAnchorX(this.bi);
            this.c.setAnchorY(this.bj);
            queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.28
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c cVar = c.this;
                        cVar.c.setAnchorX(Math.max(0, Math.min(cVar.bi, c.this.h)));
                        c cVar2 = c.this;
                        cVar2.c.setAnchorY(Math.max(0, Math.min(cVar2.bj, c.this.i)));
                        c cVar3 = c.this;
                        cVar3.g.setProjectionCenter(1, cVar3.c.getAnchorX(), c.this.c.getAnchorY());
                        c.this.aI = true;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        if (customMapStyleOptions != null) {
            try {
                if (customMapStyleOptions.isEnable() && (customMapStyleOptions.getStyleId() != null || customMapStyleOptions.getStyleTexturePath() != null || customMapStyleOptions.getStyleTextureData() != null)) {
                    k();
                }
                this.bo.c();
                this.bo.a(customMapStyleOptions);
                jp jpVar = this.bD;
                if (jpVar != null) {
                    jpVar.a("setCustomMapStyle", customMapStyleOptions);
                }
            } catch (Throwable th) {
                eq.a(th);
                return;
            }
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStyleID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.c.getCustomStyleID())) {
            return;
        }
        this.c.setCustomStyleID(str);
        this.ac = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStylePath(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.c.getCustomStylePath())) {
            return;
        }
        this.c.setCustomStylePath(str);
        this.ac = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.aK = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomTextureResourcePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setCustomTextureResourcePath(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setGestureStatus(int i, int i2) {
        if (this.bh == 0 || i2 != 5) {
            this.bh = i2;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setHideLogoEnble(boolean z) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z);
            if (this.c.isCustomStyleEnable()) {
                this.ab.setLogoEnable(!z);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (this.ak || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.d = (aq) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.29
            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                GLMapEngine gLMapEngine = cVar.g;
                if (gLMapEngine != null) {
                    aq aqVar = cVar.d;
                    gLMapEngine.setIndoorBuildingToBeActive(1, aqVar.activeFloorName, aqVar.activeFloorIndex, aqVar.poiid);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setIndoorEnabled(final boolean z) throws RemoteException {
        List<AMapWidgetListener> list;
        try {
            if (this.bc && !this.ak) {
                this.c.setIndoorEnable(z);
                resetRenderTime();
                if (z) {
                    GLMapEngine gLMapEngine = this.g;
                    if (gLMapEngine != null) {
                        gLMapEngine.setIndoorEnable(1, true);
                    }
                } else {
                    GLMapEngine gLMapEngine2 = this.g;
                    if (gLMapEngine2 != null) {
                        gLMapEngine2.setIndoorEnable(1, false);
                    }
                    MapConfig mapConfig = this.c;
                    mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.c.getMaxZoomLevel() : 20.0f;
                    try {
                        if (this.ab.isZoomControlsEnabled() && (list = this.am) != null && list.size() > 0) {
                            for (int i = 0; i < this.am.size(); i++) {
                                this.am.get(i).invalidateZoomController(this.c.getSZ());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                eo.c(this.f, z);
                if (this.ab.isIndoorSwitchEnabled()) {
                    this.j.post(new Runnable() { // from class: com.amap.api.mapcore.util.c.22
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!z) {
                                if (c.this.ae != null) {
                                    c.this.ae.i(Boolean.FALSE);
                                    return;
                                }
                                return;
                            }
                            c.this.showIndoorSwitchControlsEnabled(true);
                        }
                    });
                    return;
                }
                return;
            }
            a aVar = this.bz;
            aVar.c = z;
            aVar.b = true;
            aVar.g = 1;
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        ar arVar;
        if (this.ak || (arVar = this.X) == null) {
            return;
        }
        arVar.a(infoWindowAdapter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setLoadOfflineData(final boolean z) throws RemoteException {
        queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.23
            @Override // java.lang.Runnable
            public void run() {
                GLMapEngine gLMapEngine = c.this.g;
                if (gLMapEngine != null) {
                    gLMapEngine.setOfflineDataEnable(1, z);
                }
            }
        });
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (this.ak) {
                return;
            }
            LocationSource locationSource2 = this.ar;
            if (locationSource2 != null && (locationSource2 instanceof as)) {
                locationSource2.deactivate();
            }
            this.ar = locationSource;
            if (locationSource != null) {
                this.ae.h(Boolean.TRUE);
            } else {
                this.ae.h(Boolean.FALSE);
            }
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoBottomMargin(int i) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.c(Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoLeftMargin(int i) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.d(Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoMarginRate(int i, float f) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.a(Integer.valueOf(i), Float.valueOf(f));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoPosition(int i) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            fdVar.b(Integer.valueOf(i));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapCustomEnable(boolean z, boolean z2) {
        dg dgVar;
        if (this.bc && !this.ak) {
            boolean z3 = z2 ? z2 : false;
            if (TextUtils.isEmpty(this.c.getCustomStylePath()) && TextUtils.isEmpty(this.c.getCustomStyleID())) {
                return;
            }
            if (z) {
                try {
                    if (this.c.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.c.getCustomStyleID()) && (dgVar = this.aP) != null) {
                        dgVar.a(this.c.getCustomStyleID());
                        this.aP.b();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    eq.a(th);
                    return;
                }
            }
            if (z2 || this.ac || (this.c.isCustomStyleEnable() ^ z)) {
                a(z, (byte[]) null, z3);
            }
            this.ac = false;
            return;
        }
        a aVar = this.bt;
        aVar.b = true;
        aVar.c = z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapEnable(boolean z) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (TextUtils.isEmpty(str) || (mapConfig = this.c) == null || mapConfig.isCustomStyleEnable() || this.c.getMapLanguage().equals(str)) {
            return;
        }
        if (!str.equals("en")) {
            this.c.setMapLanguage("zh_cn");
            this.aJ = 0;
        } else {
            if (this.aC != 1) {
                try {
                    setMapType(1);
                } catch (Throwable th) {
                    eq.a(th);
                    th.printStackTrace();
                }
            }
            this.c.setMapLanguage("en");
            this.aJ = -10000;
        }
        try {
            a(getCameraPosition());
            synchronized (this.ag) {
                if (this.af == null) {
                    this.af = new ab(this.f, this);
                }
            }
            ab abVar = this.af;
            if (abVar != null) {
                abVar.a(this.c.getMapLanguage());
            }
        } catch (Throwable th2) {
            eq.a(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.c.setLimitLatLngBounds(latLngBounds);
            l();
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapTextEnable(final boolean z) throws RemoteException {
        try {
            if (this.bc && this.bd) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.24
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c.this.g.setLabelEnable(1, z);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                a aVar = this.bv;
                aVar.c = z;
                aVar.b = true;
                aVar.g = 1;
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapTextZIndex(int i) throws RemoteException {
        this.aJ = i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapType(int i) throws RemoteException {
        MapConfig mapConfig;
        if (i != this.aC || ((mapConfig = this.c) != null && mapConfig.isCustomStyleEnable())) {
            g gVar = this.aR;
            if (gVar != null) {
                gVar.a(new w(1, Integer.valueOf(i)));
            }
            this.aC = i;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            AMapWidgetListener aMapWidgetListener2 = this.H;
            if (aMapWidgetListener2 != null) {
                b(aMapWidgetListener2);
            }
            this.H = aMapWidgetListener;
            a(aMapWidgetListener);
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMaskLayerParams(int i, int i2, int i3, int i4, final int i5, long j) {
        GLAlphaAnimation gLAlphaAnimation;
        try {
            if (this.aL != null) {
                float f = i4 / 255.0f;
                if (i5 == -1) {
                    gLAlphaAnimation = new GLAlphaAnimation(f, 0.0f);
                    gLAlphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.amap.api.mapcore.util.c.30
                        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                        public void onAnimationEnd() {
                            c.this.j.post(new Runnable() { // from class: com.amap.api.mapcore.util.c.30.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass30 anonymousClass30 = AnonymousClass30.this;
                                    c.this.aM = i5;
                                    if (c.this.ae != null) {
                                        c.this.ae.j(Boolean.TRUE);
                                    }
                                }
                            });
                        }

                        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                        public void onAnimationStart() {
                        }
                    });
                } else {
                    this.aM = i5;
                    gLAlphaAnimation = new GLAlphaAnimation(0.0f, f);
                    if (f > 0.2f) {
                        fd fdVar = this.ae;
                        if (fdVar != null) {
                            fdVar.j(Boolean.FALSE);
                        }
                    } else {
                        fd fdVar2 = this.ae;
                        if (fdVar2 != null) {
                            fdVar2.j(Boolean.TRUE);
                        }
                    }
                }
                gLAlphaAnimation.setInterpolator(new LinearInterpolator());
                gLAlphaAnimation.setDuration(j);
                this.aL.a(i, i2, i3, i4);
                this.aL.a(gLAlphaAnimation);
            }
        } catch (Throwable th) {
            eq.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMaxZoomLevel(float f) {
        this.c.setMaxZoomLevel(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMinZoomLevel(float f) {
        this.c.setMinZoomLevel(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationEnabled(boolean z) throws RemoteException {
        if (this.ak) {
            return;
        }
        try {
            fd fdVar = this.ae;
            if (fdVar != null) {
                fdVar.f();
                LocationSource locationSource = this.ar;
                if (locationSource == null) {
                    this.ae.h(Boolean.FALSE);
                } else if (z) {
                    locationSource.activate(this.G);
                    this.ae.h(Boolean.TRUE);
                    if (this.aq == null) {
                        this.aq = new cv(this, this.f);
                    }
                } else {
                    cv cvVar = this.aq;
                    if (cvVar != null) {
                        cvVar.c();
                        this.aq = null;
                    }
                    this.ar.deactivate();
                }
            }
            if (!z) {
                this.ab.setMyLocationButtonEnabled(z);
            }
            this.ai = z;
            resetRenderTime();
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "setMyLocationEnabled");
            th.printStackTrace();
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationRotateAngle(float f) throws RemoteException {
        try {
            cv cvVar = this.aq;
            if (cvVar != null) {
                cvVar.a(f);
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.ak) {
            return;
        }
        try {
            if (this.aq == null) {
                this.aq = new cv(this, this.f);
            }
            if (this.aq != null) {
                long j = 1000;
                if (myLocationStyle.getInterval() < j) {
                    myLocationStyle.interval(j);
                }
                LocationSource locationSource = this.ar;
                if (locationSource != null && (locationSource instanceof as)) {
                    ((as) locationSource).a(myLocationStyle.getInterval());
                    ((as) this.ar).a(myLocationStyle.getMyLocationType());
                }
                this.aq.a(myLocationStyle);
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationType(int i) throws RemoteException {
        try {
            cv cvVar = this.aq;
            if (cvVar == null || cvVar.a() == null) {
                return;
            }
            this.aq.a().myLocationType(i);
            setMyLocationStyle(this.aq.a());
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) throws RemoteException {
        if (this.ak) {
            return;
        }
        try {
            this.aD = myTrafficStyle;
            if (this.bc && this.bd && myTrafficStyle != null) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.27
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c cVar = c.this;
                            cVar.g.setTrafficStyle(1, cVar.aD.getSmoothColor(), c.this.aD.getSlowColor(), c.this.aD.getCongestedColor(), c.this.aD.getSeriousCongestedColor());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                a aVar = this.bC;
                aVar.c = false;
                aVar.b = true;
                aVar.g = 1;
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setNaviLabelEnable(final boolean z, final int i, final int i2) throws RemoteException {
        try {
            if (this.bc && this.bd) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.26
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c.this.g.setNaviLabelEnable(1, z, i, i2);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                a aVar = this.bx;
                aVar.c = z;
                aVar.h = i;
                aVar.i = i2;
                aVar.b = true;
                aVar.g = 1;
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        AMap.OnCameraChangeListener onCameraChangeListener2 = this.y;
        if (onCameraChangeListener2 != null) {
            removeOnCameraChangeListener(onCameraChangeListener2);
        }
        this.y = onCameraChangeListener;
        addOnCameraChangeListener(onCameraChangeListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener2 = this.E;
        if (onIndoorBuildingActiveListener2 != null) {
            removeOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener2);
        }
        this.E = onIndoorBuildingActiveListener;
        addOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        AMap.OnInfoWindowClickListener onInfoWindowClickListener2 = this.D;
        if (onInfoWindowClickListener2 != null) {
            removeOnInfoWindowClickListener(onInfoWindowClickListener2);
        }
        this.D = onInfoWindowClickListener;
        addOnInfoWindowClickListener(onInfoWindowClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        AMap.OnMapClickListener onMapClickListener2 = this.z;
        if (onMapClickListener2 != null) {
            removeOnMapClickListener(onMapClickListener2);
        }
        this.z = onMapClickListener;
        addOnMapClickListener(onMapClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        AMap.OnMapLongClickListener onMapLongClickListener2 = this.C;
        if (onMapLongClickListener2 != null) {
            removeOnMapLongClickListener(onMapLongClickListener2);
        }
        this.C = onMapLongClickListener;
        addOnMapLongClickListener(onMapLongClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        AMap.OnMapTouchListener onMapTouchListener2 = this.A;
        if (onMapTouchListener2 != null) {
            removeOnMapTouchListener(onMapTouchListener2);
        }
        this.A = onMapTouchListener;
        addOnMapTouchListener(onMapTouchListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        AMap.OnMapLoadedListener onMapLoadedListener2 = this.x;
        if (onMapLoadedListener2 != null) {
            removeOnMapLoadedListener(onMapLoadedListener2);
        }
        this.x = onMapLoadedListener;
        addOnMapLoadedListener(onMapLoadedListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        AMap.OnMarkerClickListener onMarkerClickListener2 = this.u;
        if (onMarkerClickListener2 != null) {
            removeOnMarkerClickListener(onMarkerClickListener2);
        }
        this.u = onMarkerClickListener;
        addOnMarkerClickListener(onMarkerClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        AMap.OnMarkerDragListener onMarkerDragListener2 = this.w;
        if (onMarkerDragListener2 != null) {
            removeOnMarkerDragListener(onMarkerDragListener2);
        }
        this.w = onMarkerDragListener;
        addOnMarkerDragListener(onMarkerDragListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        ax axVar = this.bn;
        if (axVar != null) {
            axVar.a(onMultiPointClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            AMap.OnMyLocationChangeListener onMyLocationChangeListener2 = this.F;
            if (onMyLocationChangeListener2 != null) {
                removeOnMyLocationChangeListener(onMyLocationChangeListener2);
            }
            this.F = onMyLocationChangeListener;
            addOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        AMap.OnPOIClickListener onPOIClickListener2 = this.B;
        if (onPOIClickListener2 != null) {
            removeOnPOIClickListener(onPOIClickListener2);
        }
        this.B = onPOIClickListener;
        addOnPOIClickListener(onPOIClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        AMap.OnPolylineClickListener onPolylineClickListener2 = this.v;
        if (onPolylineClickListener2 != null) {
            removeOnPolylineClickListener(onPolylineClickListener2);
        }
        this.v = onPolylineClickListener;
        addOnPolylineClickListener(onPolylineClickListener);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRenderFps(int i) {
        try {
            if (i == -1) {
                this.aN = i;
            } else {
                this.aN = Math.max(10, Math.min(i, 40));
            }
            eo.f(this.f);
        } catch (Throwable th) {
            eq.a(th);
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRenderMode(int i) {
        try {
            IGLSurfaceView iGLSurfaceView = this.ad;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRoadArrowEnable(final boolean z) throws RemoteException {
        try {
            if (this.bc && this.bd) {
                resetRenderTime();
                queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.25
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            c.this.g.setRoadArrowEnable(1, z);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                a aVar = this.bw;
                aVar.c = z;
                aVar.b = true;
                aVar.g = 1;
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRunLowFrame(boolean z) {
        if (z) {
            return;
        }
        try {
            if (this.aN != -1) {
                return;
            }
            c();
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTouchPoiEnable(boolean z) {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTrafficEnabled(final boolean z) throws RemoteException {
        try {
            if (this.bc && !this.ak) {
                queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.20
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (c.this.c.isTrafficEnabled() != z) {
                                c.this.c.setTrafficEnabled(z);
                                c.this.aS.setTrafficMode(z);
                                c.this.g.setTrafficEnable(1, z);
                                c.this.resetRenderTime();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            eq.a(th);
                        }
                    }
                });
            } else {
                a aVar = this.bq;
                aVar.c = z;
                aVar.b = true;
                aVar.g = 1;
            }
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setVisibilityEx(int i) {
        IGLSurfaceView iGLSurfaceView = this.ad;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setWorldVectorMapStyle(String str) {
        if (TextUtils.isEmpty(str) || this.c == null || this.bF.equals(str)) {
            return;
        }
        this.bF = str;
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a("setWorldVectorMapStyle", str);
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setZOrderOnTop(boolean z) throws RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setZoomPosition(int i) {
        fd fdVar;
        if (this.ak || (fdVar = this.ae) == null) {
            return;
        }
        fdVar.a(Integer.valueOf(i));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setZoomScaleParam(float f) {
        this.aW = f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showCompassEnabled(boolean z) {
        fd fdVar;
        if (this.ak || (fdVar = this.ae) == null) {
            return;
        }
        fdVar.d(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showIndoorSwitchControlsEnabled(boolean z) {
        fd fdVar;
        if (this.ak || (fdVar = this.ae) == null) {
            return;
        }
        fdVar.a(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        ar arVar;
        if (baseOverlayImp == null || (arVar = this.X) == null) {
            return;
        }
        try {
            arVar.a(baseOverlayImp);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showLogoEnabled(boolean z) {
        if (this.ak) {
            return;
        }
        this.ae.f(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showMyLocationButtonEnabled(boolean z) {
        fd fdVar;
        if (this.ak || (fdVar = this.ae) == null) {
            return;
        }
        fdVar.c(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showMyLocationOverlay(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.ai && this.ar != null) {
                if (this.aq == null) {
                    this.aq = new cv(this, this.f);
                }
                if (com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location) != 0.0d && com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location) != 0.0d) {
                    this.aq.a(location);
                }
                List<AMap.OnMyLocationChangeListener> list = this.T;
                if (list != null && list.size() > 0) {
                    for (int i = 0; i < this.T.size(); i++) {
                        this.T.get(i).onMyLocationChange(location);
                    }
                }
                resetRenderTime();
                return;
            }
            cv cvVar = this.aq;
            if (cvVar != null) {
                cvVar.c();
            }
            this.aq = null;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showScaleEnabled(boolean z) {
        fd fdVar;
        if (this.ak || (fdVar = this.ae) == null) {
            return;
        }
        fdVar.e(Boolean.valueOf(z));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showZoomControlsEnabled(boolean z) {
        fd fdVar;
        if (this.ak || (fdVar = this.ae) == null) {
            return;
        }
        fdVar.b(Boolean.valueOf(z));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.g;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float toMapLenWithWin(int i) {
        GLMapEngine gLMapEngine;
        if (!this.bc || this.an || (gLMapEngine = this.g) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(1).getGLUnitWithWin(i);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void zoomOut(int i) {
        if (this.bc && ((int) a(i)) > this.c.getMinZoomLevel()) {
            try {
                animateCamera(ah.b());
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
        }
    }

    public c(IGLSurfaceView iGLSurfaceView, Context context, AttributeSet attributeSet, boolean z) {
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = new ArrayList();
        this.N = new ArrayList();
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.Q = new ArrayList();
        this.R = new ArrayList();
        this.S = new ArrayList();
        this.T = new ArrayList();
        this.U = new ArrayList();
        this.V = new ArrayList();
        this.Y = null;
        this.a = false;
        this.ac = false;
        this.af = null;
        this.ag = new Object();
        this.ai = false;
        this.ak = false;
        this.am = new ArrayList();
        this.an = false;
        this.c = new MapConfig(true);
        this.ao = false;
        this.ap = false;
        this.as = false;
        this.at = null;
        this.au = null;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.ay = false;
        this.az = false;
        this.aA = true;
        this.aB = new Rect();
        this.aC = 1;
        this.aD = null;
        this.aG = false;
        this.aH = false;
        this.aI = false;
        this.aJ = 0;
        this.aM = -1;
        this.aN = -1;
        this.aO = new ArrayList();
        this.e = null;
        this.aU = false;
        this.aV = 0.0f;
        this.aW = 1.0f;
        this.aX = 1.0f;
        this.aY = true;
        this.aZ = false;
        this.ba = false;
        this.bb = 0;
        this.bc = false;
        this.bd = false;
        this.be = false;
        this.bf = false;
        this.bg = new ReentrantLock();
        this.bh = 0;
        this.j = new Handler(Looper.getMainLooper()) { // from class: com.amap.api.mapcore.util.c.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message == null || c.this.ak) {
                    return;
                }
                try {
                    int i = message.what;
                    if (i != 2) {
                        boolean z2 = true;
                        int i2 = 0;
                        switch (i) {
                            case 10:
                                CameraPosition cameraPosition = (CameraPosition) message.obj;
                                if (cameraPosition != null && c.this.M != null && c.this.M.size() > 0) {
                                    for (AMap.OnCameraChangeListener onCameraChangeListener : c.this.M) {
                                        onCameraChangeListener.onCameraChange(cameraPosition);
                                    }
                                }
                                c.this.c.addChangedCounter();
                                return;
                            case 11:
                                CameraPosition cameraPosition2 = c.this.getCameraPosition();
                                if (cameraPosition2 != null && c.this.ae != null) {
                                    c.this.ae.a(cameraPosition2);
                                }
                                c.this.a(cameraPosition2);
                                if (c.this.ba) {
                                    c.this.ba = false;
                                    if (c.this.af != null) {
                                        c.this.af.b(false);
                                    }
                                    c.this.a(true);
                                }
                                if (c.this.ay) {
                                    c.this.redrawInfoWindow();
                                    c.this.ay = false;
                                }
                                c.this.a(true, cameraPosition2);
                                return;
                            case 12:
                                if (c.this.ae != null) {
                                    c.this.ae.a(Float.valueOf(c.this.getZoomLevel()));
                                    return;
                                }
                                return;
                            case 13:
                                if (c.this.ae != null) {
                                    c.this.ae.k();
                                    return;
                                }
                                return;
                            case 14:
                                if (c.this.O == null || c.this.O.size() <= 0) {
                                    return;
                                }
                                for (AMap.OnMapTouchListener onMapTouchListener : c.this.O) {
                                    onMapTouchListener.onTouch((MotionEvent) message.obj);
                                }
                                return;
                            case 15:
                                Bitmap bitmap = (Bitmap) message.obj;
                                int i3 = message.arg1;
                                try {
                                    if (bitmap == null || c.this.ae == null) {
                                        if (c.this.U != null && c.this.U.size() > 0) {
                                            for (int i4 = 0; i4 < c.this.U.size(); i4++) {
                                                ((AMap.onMapPrintScreenListener) c.this.U.get(i4)).onMapPrint(null);
                                            }
                                        }
                                        if (c.this.V != null && c.this.V.size() > 0) {
                                            while (i2 < c.this.V.size()) {
                                                ((AMap.OnMapScreenShotListener) c.this.V.get(i2)).onMapScreenShot(null);
                                                ((AMap.OnMapScreenShotListener) c.this.V.get(i2)).onMapScreenShot(null, i3);
                                                i2++;
                                            }
                                        }
                                    } else {
                                        Canvas canvas = new Canvas(bitmap);
                                        fg g = c.this.ae.g();
                                        if (g != null) {
                                            g.onDraw(canvas);
                                        }
                                        c.this.ae.a(canvas);
                                        if (c.this.U != null && c.this.U.size() > 0) {
                                            for (int i5 = 0; i5 < c.this.U.size(); i5++) {
                                                ((AMap.onMapPrintScreenListener) c.this.U.get(i5)).onMapPrint(new BitmapDrawable(c.this.f.getResources(), bitmap));
                                            }
                                        }
                                        if (c.this.V != null && c.this.V.size() > 0) {
                                            while (i2 < c.this.V.size()) {
                                                ((AMap.OnMapScreenShotListener) c.this.V.get(i2)).onMapScreenShot(bitmap);
                                                ((AMap.OnMapScreenShotListener) c.this.V.get(i2)).onMapScreenShot(bitmap, i3);
                                                i2++;
                                            }
                                        }
                                    }
                                } catch (Throwable unused) {
                                }
                                c cVar = c.this;
                                cVar.a(cVar.U);
                                c cVar2 = c.this;
                                cVar2.a(cVar2.V);
                                return;
                            case 16:
                                if (c.this.L != null) {
                                    while (i2 < c.this.L.size()) {
                                        ((AMap.OnMapLoadedListener) c.this.L.get(i2)).onMapLoaded();
                                        i2++;
                                    }
                                }
                                if (c.this.ae != null) {
                                    c.this.ae.l();
                                    return;
                                }
                                return;
                            case 17:
                                if (c.this.g.isInMapAnimation(1) && c.this.af != null) {
                                    c.this.af.b(false);
                                }
                                if (c.this.af != null) {
                                    ab abVar = c.this.af;
                                    if (message.arg1 == 0) {
                                        z2 = false;
                                    }
                                    abVar.a(z2);
                                    return;
                                }
                                return;
                            case 18:
                                if (c.this.X == null || !c.this.ap) {
                                    return;
                                }
                                c.this.X.c();
                                return;
                            case 19:
                                if (c.this.N != null) {
                                    DPoint obtain = DPoint.obtain();
                                    c.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                                    for (AMap.OnMapClickListener onMapClickListener : c.this.N) {
                                        onMapClickListener.onMapClick(new LatLng(obtain.y, obtain.x));
                                    }
                                    obtain.recycle();
                                    return;
                                }
                                return;
                            case 20:
                                if (c.this.P == null || c.this.P.size() <= 0) {
                                    return;
                                }
                                while (i2 < c.this.P.size()) {
                                    ((AMap.OnPOIClickListener) c.this.P.get(i2)).onPOIClick((Poi) message.obj);
                                    i2++;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Key验证失败：[");
                    Object obj = message.obj;
                    if (obj != null) {
                        sb.append(obj);
                    } else {
                        sb.append(gd.b);
                    }
                    sb.append(jn1.ARRAY_END_STR);
                    Log.w("amapsdk", sb.toString());
                } catch (Throwable th) {
                    hd.c(th, "AMapDelegateImp", "handleMessage");
                    th.printStackTrace();
                }
            }
        };
        this.bq = new a() { // from class: com.amap.api.mapcore.util.c.11
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    c.this.setTrafficEnabled(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.br = new a() { // from class: com.amap.api.mapcore.util.c.21
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    c cVar = c.this;
                    cVar.setCenterToPixel(cVar.bi, c.this.bj);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bs = new a() { // from class: com.amap.api.mapcore.util.c.32
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                c.this.b(this.g, this.d, this.e, this.f);
            }
        };
        this.bt = new a() { // from class: com.amap.api.mapcore.util.c.34
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                c.this.setMapCustomEnable(this.c);
            }
        };
        this.bu = new a() { // from class: com.amap.api.mapcore.util.c.35
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                c.this.a(this.g, this.c);
            }
        };
        this.bv = new a() { // from class: com.amap.api.mapcore.util.c.36
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    c.this.setMapTextEnable(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bw = new a() { // from class: com.amap.api.mapcore.util.c.37
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    c.this.setRoadArrowEnable(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bx = new a() { // from class: com.amap.api.mapcore.util.c.38
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    c.this.setNaviLabelEnable(this.c, this.h, this.i);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.by = new a() { // from class: com.amap.api.mapcore.util.c.2
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                c.this.b(this.g, this.c);
            }
        };
        this.bz = new a() { // from class: com.amap.api.mapcore.util.c.3
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    c.this.setIndoorEnabled(this.c);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bA = new Runnable() { // from class: com.amap.api.mapcore.util.c.4
            @Override // java.lang.Runnable
            public void run() {
                fg g;
                if (c.this.ae == null || (g = c.this.ae.g()) == null) {
                    return;
                }
                g.d();
            }
        };
        this.bB = new a() { // from class: com.amap.api.mapcore.util.c.5
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                c.this.c(this.g, this.c);
            }
        };
        this.bC = new a() { // from class: com.amap.api.mapcore.util.c.6
            @Override // com.amap.api.mapcore.util.c.a, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    c cVar = c.this;
                    cVar.setMyTrafficStyle(cVar.aD);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.bE = "";
        this.bF = "";
        this.bG = new EAMapPlatformGestureInfo();
        this.k = new Point();
        this.l = new Rect();
        this.bH = 0L;
        this.m = null;
        this.bI = null;
        this.n = new float[16];
        this.o = new float[16];
        this.p = new float[16];
        this.bJ = null;
        this.q = new float[12];
        this.r = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";
        this.s = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
        this.t = -1;
        this.f = context;
        jm.a();
        this.bD = new jp(this.f, this, z);
        this.aR = new g(context, this, iGLSurfaceView);
        hd.a(this.f);
        ea.a().a(this.f);
        m.b = gc.c(context);
        dr.a(this.f);
        this.aT = new p(this);
        this.g = new GLMapEngine(this.f, this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.aS = gLMapRender;
        this.ad = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        this.ab = new ac(this);
        fd fdVar = new fd(this.f, this);
        this.ae = fdVar;
        fdVar.a(new C0212c());
        this.bk = new b();
        this.ah = new r(this);
        this.b = new u(this.f, this);
        this.al = new o(this.f, this);
        iGLSurfaceView.setRenderMode(0);
        this.aS.setRenderFps(15.0f);
        this.g.setMapListener(this);
        this.aa = new z(this);
        this.G = new h(this);
        this.Y = new da(this, context);
        ar arVar = new ar(this.f);
        this.X = arVar;
        arVar.a(this.ae);
        this.X.b(this.Y);
        this.aL = new v();
        this.aE = new k(this.f, this);
        this.ar = new as(this.f);
        this.bn = new ax(this);
        this.bm = new s();
        this.aP = new dg(this.f, this);
        di diVar = new di(this.f);
        this.aQ = diVar;
        diVar.a(this);
        b(z);
        MapConfig mapConfig = this.c;
        com.amap.api.mapcore.util.b bVar = new com.amap.api.mapcore.util.b(this, this.f, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.bo = bVar;
        bVar.a(this);
    }

    private boolean d(MotionEvent motionEvent) {
        try {
            List<AMap.OnPolylineClickListener> list = this.J;
            if (list != null && list.size() > 0) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                LatLng latLng = new LatLng(obtain.y, obtain.x);
                obtain.recycle();
                IOverlayDelegate a2 = this.ah.a(latLng);
                if (a2 != null) {
                    for (AMap.OnPolylineClickListener onPolylineClickListener : this.J) {
                        onPolylineClickListener.onPolylineClick(new Polyline((IPolylineDelegate) a2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void e() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine == null || (gLMapState = (GLMapState) gLMapEngine.getNewMapState(1)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        gLMapState.recalculate();
        gLMapState.getMapGeoCenter(obtain);
        this.c.setSX(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain));
        this.c.setSY(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
        this.c.setSZ(gLMapState.getMapZoomer());
        this.c.setSC(gLMapState.getCameraDegree());
        this.c.setSR(gLMapState.getMapAngle());
        gLMapState.recycle();
        obtain.recycle();
    }

    private LatLng f() {
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.c.getSY(), 20);
            LatLng latLng = new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false);
            pixelsToLatLong.recycle();
            return latLng;
        }
        return null;
    }

    private synchronized void g() {
        synchronized (this.aO) {
            int size = this.aO.size();
            for (int i = 0; i < size; i++) {
                this.aO.get(i).j().recycle();
            }
            this.aO.clear();
        }
    }

    private void h(final int i) {
        if (this.bc) {
            this.aT.a();
            this.aU = true;
            this.aZ = true;
            try {
                stopAnimation();
            } catch (RemoteException unused) {
            }
            queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.this.g.clearAllMessages(i);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void i(int i) {
        this.aU = true;
        this.aZ = false;
        if (this.aw) {
            this.aw = false;
        }
        if (this.av) {
            this.av = false;
        }
        if (this.ax) {
            this.ax = false;
        }
        this.as = false;
        List<AMap.OnMarkerDragListener> list = this.K;
        if (list != null && list.size() > 0 && this.at != null) {
            for (int i2 = 0; i2 < this.K.size(); i2++) {
                try {
                    this.K.get(i2).onMarkerDragEnd(this.at);
                } catch (Throwable th) {
                    hd.c(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
                    th.printStackTrace();
                }
            }
            this.at = null;
        }
        this.ad.postDelayed(new Runnable() { // from class: com.amap.api.mapcore.util.c.8
            @Override // java.lang.Runnable
            public void run() {
                c.this.bb = 1;
            }
        }, 300L);
    }

    private void j() {
        if (this.aG) {
            return;
        }
        try {
            this.aE.setName("AuthThread");
            this.aE.start();
            this.aG = true;
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    private void k() {
        if (this.aH) {
            return;
        }
        try {
            if (this.aF == null) {
                this.aF = new i(this.f, this);
            }
            this.aF.setName("AuthProThread");
            this.aF.start();
            this.aH = true;
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    private void l() {
        try {
            LatLngBounds limitLatLngBounds = this.c.getLimitLatLngBounds();
            if (this.g != null && a(limitLatLngBounds)) {
                GLMapState gLMapState = new GLMapState(1, this.g.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                this.c.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c.setLimitIPoints(null);
    }

    private void m() {
        a(this.T);
        a(this.I);
        a(this.J);
        a(this.K);
        a(this.L);
        a(this.M);
        a(this.N);
        a(this.O);
        a(this.P);
        a(this.Q);
        a(this.R);
        a(this.S);
        a(this.U);
        a(this.V);
        a(this.am);
        this.G = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j, AMap.CancelableCallback cancelableCallback) {
        if (abstractCameraUpdateMessage == null || this.ak || this.g == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j;
        if (!this.an && getMapHeight() != 0 && getMapWidth() != 0) {
            try {
                this.g.interruptAnimation();
                resetRenderTime();
                a(abstractCameraUpdateMessage);
                this.g.addMessage(abstractCameraUpdateMessage, true);
                return;
            } catch (Throwable th) {
                eq.a(th);
                th.printStackTrace();
                return;
            }
        }
        try {
            moveCamera(abstractCameraUpdateMessage);
            AMap.CancelableCallback cancelableCallback2 = abstractCameraUpdateMessage.mCallback;
            if (cancelableCallback2 != null) {
                cancelableCallback2.onFinish();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            eq.a(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public x getTextureItem(BitmapDescriptor bitmapDescriptor, boolean z) {
        if (bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled()) {
            return null;
        }
        synchronized (this.aO) {
            for (int i = 0; i < this.aO.size(); i++) {
                x xVar = this.aO.get(i);
                if ((!z || xVar.k() != getBaseOverlayTextureID()) && xVar.j().equals(bitmapDescriptor)) {
                    return xVar;
                }
            }
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.j == null || this.g == null) {
            return;
        }
        try {
            d dVar = new d(this.f, onCacheRemoveListener);
            this.j.removeCallbacks(dVar);
            this.j.post(dVar);
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImp", "removecache");
            th.printStackTrace();
            eq.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final MotionEvent motionEvent) {
        this.j.post(new Runnable() { // from class: com.amap.api.mapcore.util.c.10
            @Override // java.lang.Runnable
            public void run() {
                Message obtain = Message.obtain();
                obtain.what = 19;
                obtain.arg1 = (int) motionEvent.getX();
                obtain.arg2 = (int) motionEvent.getY();
                c.this.j.sendMessage(obtain);
            }
        });
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine == null || this.ak) {
            return;
        }
        try {
            if (this.an && gLMapEngine.getStateMessageCount() > 0) {
                AbstractCameraUpdateMessage c = ah.c();
                c.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                c.geoPoint = new DPoint(this.c.getSX(), this.c.getSY());
                c.zoom = this.c.getSZ();
                c.bearing = this.c.getSR();
                c.tilt = this.c.getSC();
                this.g.addMessage(abstractCameraUpdateMessage, false);
                while (this.g.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage stateMessage = this.g.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(c);
                    }
                }
                abstractCameraUpdateMessage = c;
            }
        } catch (Throwable th) {
            eq.a(th);
        }
        resetRenderTime();
        this.g.clearAnimations(1, false);
        abstractCameraUpdateMessage.isChangeFinished = true;
        a(abstractCameraUpdateMessage);
        this.g.addMessage(abstractCameraUpdateMessage, false);
    }

    private boolean b(CameraPosition cameraPosition) {
        if (cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        MapConfig mapConfig = this.c;
        if (mapConfig != null) {
            try {
                return !ej.a(mapConfig.getGeoRectangle().getClipRect());
            } catch (Throwable th) {
                th.printStackTrace();
                eq.a(th);
                return false;
            }
        }
        return false;
    }

    public void c(int i) {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        f(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        ar arVar;
        if (this.ak || (arVar = this.X) == null) {
            return;
        }
        arVar.a(commonInfoWindowAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025 A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:2:0x0000, B:5:0x000a, B:8:0x001c, B:10:0x0025, B:11:0x0028, B:13:0x0036, B:14:0x0039, B:16:0x003d, B:17:0x0040, B:6:0x0018), top: B:22:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036 A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:2:0x0000, B:5:0x000a, B:8:0x001c, B:10:0x0025, B:11:0x0028, B:13:0x0036, B:14:0x0039, B:16:0x003d, B:17:0x0040, B:6:0x0018), top: B:22:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[Catch: all -> 0x004c, TryCatch #0 {all -> 0x004c, blocks: (B:2:0x0000, B:5:0x000a, B:8:0x001c, B:10:0x0025, B:11:0x0028, B:13:0x0036, B:14:0x0039, B:16:0x003d, B:17:0x0040, B:6:0x0018), top: B:22:0x0000 }] */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void clear(boolean r4) throws android.os.RemoteException {
        /*
            r3 = this;
            r3.hideInfoWindow()     // Catch: java.lang.Throwable -> L4c
            com.amap.api.mapcore.util.cv r0 = r3.aq     // Catch: java.lang.Throwable -> L4c
            r1 = 0
            if (r0 == 0) goto L1b
            if (r4 == 0) goto L18
            java.lang.String r1 = r0.d()     // Catch: java.lang.Throwable -> L4c
            com.amap.api.mapcore.util.cv r4 = r3.aq     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = r4.e()     // Catch: java.lang.Throwable -> L4c
            r2 = r1
            r1 = r4
            r4 = r2
            goto L1c
        L18:
            r0.f()     // Catch: java.lang.Throwable -> L4c
        L1b:
            r4 = r1
        L1c:
            com.amap.api.mapcore.util.r r0 = r3.ah     // Catch: java.lang.Throwable -> L4c
            r0.b(r1)     // Catch: java.lang.Throwable -> L4c
            com.amap.api.mapcore.util.ab r0 = r3.af     // Catch: java.lang.Throwable -> L4c
            if (r0 == 0) goto L28
            r0.c()     // Catch: java.lang.Throwable -> L4c
        L28:
            com.amap.api.mapcore.util.u r0 = r3.b     // Catch: java.lang.Throwable -> L4c
            r0.b(r4)     // Catch: java.lang.Throwable -> L4c
            com.amap.api.mapcore.util.o r4 = r3.al     // Catch: java.lang.Throwable -> L4c
            r4.b()     // Catch: java.lang.Throwable -> L4c
            com.amap.api.mapcore.util.fd r4 = r3.ae     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L39
            r4.j()     // Catch: java.lang.Throwable -> L4c
        L39:
            com.amap.api.mapcore.util.ax r4 = r3.bn     // Catch: java.lang.Throwable -> L4c
            if (r4 == 0) goto L40
            r4.c()     // Catch: java.lang.Throwable -> L4c
        L40:
            com.amap.api.mapcore.util.c$19 r4 = new com.amap.api.mapcore.util.c$19     // Catch: java.lang.Throwable -> L4c
            r4.<init>()     // Catch: java.lang.Throwable -> L4c
            r3.queueEvent(r4)     // Catch: java.lang.Throwable -> L4c
            r3.resetRenderTime()     // Catch: java.lang.Throwable -> L4c
            goto L5a
        L4c:
            r4 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "clear"
            com.amap.api.mapcore.util.hd.c(r4, r0, r1)
            com.amap.api.mapcore.util.eq.a(r4)
            r4.printStackTrace()
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.c.clear(boolean):void");
    }

    private boolean f(MotionEvent motionEvent) {
        if (this.bn != null) {
            IPoint obtain = IPoint.obtain();
            if (this.g != null) {
                getPixel2Geo((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
            }
            boolean a2 = this.bn.a(obtain);
            obtain.recycle();
            return a2;
        }
        return false;
    }

    public void c() {
        GLMapRender gLMapRender;
        if (!this.bc || (gLMapRender = this.aS) == null || gLMapRender.isRenderPause()) {
            return;
        }
        requestRender();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CameraPosition cameraPosition) {
        if (this.c.getMapLanguage().equals("en")) {
            boolean b2 = b(cameraPosition);
            if (b2 != this.aA) {
                this.aA = b2;
                b(1, b2);
            }
        } else if (this.aA) {
        } else {
            this.aA = true;
            b(1, true);
        }
    }

    private void h() {
        try {
            this.c.setMapRect(eq.a((IAMapDelegate) this, true));
            GLMapState gLMapState = (GLMapState) this.g.getNewMapState(1);
            if (gLMapState != null) {
                gLMapState.recalculate();
                gLMapState.getPixel20Bound(this.l, getMapWidth(), getMapHeight());
                this.c.getGeoRectangle().updateRect(this.l, (int) this.c.getSX(), (int) this.c.getSY());
                this.c.setMapPerPixelUnitLength(gLMapState.getGLUnitWithWin(1));
                gLMapState.recycle();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean g(MotionEvent motionEvent) throws RemoteException {
        try {
            ar arVar = this.X;
            if (arVar != null && arVar.a(motionEvent)) {
                List<AMap.OnInfoWindowClickListener> list = this.R;
                if (list != null && list.size() > 0) {
                    BaseOverlayImp d2 = this.b.d();
                    if (!d2.isVisible() && d2.isInfoWindowEnable()) {
                        return true;
                    }
                    Marker marker = new Marker((cu) d2);
                    for (int i = 0; i < this.R.size(); i++) {
                        this.R.get(i).onInfoWindowClick(marker);
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void c(final int i, final boolean z) {
        if (this.bc && this.bd) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.18
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (z) {
                            c.this.g.setBuildingTextureEnable(i, true);
                        } else {
                            c.this.g.setBuildingTextureEnable(i, false);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        a aVar = this.bB;
        aVar.c = z;
        aVar.b = true;
        aVar.g = i;
    }

    private void b(boolean z) {
        jp jpVar = this.bD;
        if (jpVar != null) {
            Object a2 = jpVar.a("getAbroadEnable");
            if (a2 != null && (a2 instanceof Boolean)) {
                MapConfig mapConfig = this.c;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z && ((Boolean) a2).booleanValue());
                }
                if (z && ((Boolean) a2).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object a3 = this.bD.a("getLogoEnable");
            if (a3 != null && (a3 instanceof Boolean)) {
                this.ae.a(((Boolean) a3).booleanValue());
            }
            Object a4 = this.bD.a("getMapZindex");
            if (a3 == null || !(a3 instanceof Integer)) {
                return;
            }
            this.aJ = ((Integer) a4).intValue();
        }
    }

    public void d(int i) {
        f(i);
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
    }

    public void f(final int i) {
        queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.15
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.g.clearAllMessages(i);
                    c.this.g.clearAnimations(i, true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setCustomMapStyle(boolean z, byte[] bArr) {
        a(z, bArr, false);
    }

    private boolean e(MotionEvent motionEvent) throws RemoteException {
        LatLng realPosition;
        if (this.b.b(motionEvent)) {
            BaseOverlayImp d2 = this.b.d();
            boolean z = true;
            if (d2 == null) {
                return true;
            }
            try {
                Marker marker = new Marker((cu) d2);
                this.b.a((IMarkerDelegate) ((cu) d2));
                List<AMap.OnMarkerClickListener> list = this.I;
                if (list != null && list.size() > 0) {
                    if (this.I.size() == 1) {
                        boolean onMarkerClick = this.I.get(0).onMarkerClick(marker);
                        if (!onMarkerClick && this.b.g() > 0) {
                            z = onMarkerClick;
                        }
                        return true;
                    }
                    boolean z2 = false;
                    for (AMap.OnMarkerClickListener onMarkerClickListener : this.I) {
                        z2 |= onMarkerClickListener.onMarkerClick(marker);
                    }
                    if (!z2 && this.b.g() > 0) {
                        z = z2;
                    }
                    return true;
                }
                showInfoWindow((cu) d2);
                if (!d2.isViewMode() && (realPosition = d2.getRealPosition()) != null) {
                    IPoint obtain = IPoint.obtain();
                    latlon2Geo(realPosition.latitude, realPosition.longitude, obtain);
                    moveCamera(ah.a(obtain));
                }
                return z;
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "onMarkerTap");
                th.printStackTrace();
            }
        }
        return false;
    }

    protected void d() {
        AMapNativeRenderer.nativeDrawLineInit();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapCustomEnable(boolean z) {
        if (z) {
            k();
        }
        setMapCustomEnable(z, false);
    }

    public float a(int i) {
        if (this.c != null) {
            return getMapConfig().getSZ();
        }
        return 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:17:0x0026, B:19:0x003d, B:21:0x0041, B:23:0x0047, B:25:0x005a, B:30:0x0076, B:24:0x004d, B:26:0x0060, B:28:0x006e, B:29:0x0073, B:16:0x0023), top: B:35:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:17:0x0026, B:19:0x003d, B:21:0x0041, B:23:0x0047, B:25:0x005a, B:30:0x0076, B:24:0x004d, B:26:0x0060, B:28:0x006e, B:29:0x0073, B:16:0x0023), top: B:35:0x0023 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(int r15) {
        /*
            r14 = this;
            r14.aC = r15
            r0 = 5
            r1 = 2
            r2 = 4
            r3 = 1
            r4 = 0
            if (r15 != r3) goto Ld
        L9:
            r8 = 0
        La:
            r9 = 0
            r10 = 0
            goto L26
        Ld:
            if (r15 != r1) goto L11
            r8 = 1
            goto La
        L11:
            r5 = 3
            if (r15 != r5) goto L18
            r8 = 0
            r9 = 1
        L16:
            r10 = 4
            goto L26
        L18:
            if (r15 != r2) goto L1d
            r8 = 0
            r9 = 0
            goto L16
        L1d:
            if (r15 != r0) goto L23
            r8 = 2
            r9 = 0
            r10 = 5
            goto L26
        L23:
            r14.aC = r3     // Catch: java.lang.Throwable -> L7a
            goto L9
        L26:
            com.autonavi.base.amap.mapcore.MapConfig r15 = r14.c     // Catch: java.lang.Throwable -> L7a
            r15.setMapStyleMode(r8)     // Catch: java.lang.Throwable -> L7a
            com.autonavi.base.amap.mapcore.MapConfig r15 = r14.c     // Catch: java.lang.Throwable -> L7a
            r15.setMapStyleTime(r9)     // Catch: java.lang.Throwable -> L7a
            com.autonavi.base.amap.mapcore.MapConfig r15 = r14.c     // Catch: java.lang.Throwable -> L7a
            r15.setMapStyleState(r10)     // Catch: java.lang.Throwable -> L7a
            com.autonavi.base.amap.mapcore.MapConfig r15 = r14.c     // Catch: java.lang.Throwable -> L7a
            boolean r15 = r15.isCustomStyleEnable()     // Catch: java.lang.Throwable -> L7a
            if (r15 == 0) goto L60
            com.amap.api.mapcore.util.b r15 = r14.bo     // Catch: java.lang.Throwable -> L7a
            if (r15 == 0) goto L4d
            boolean r15 = r15.d()     // Catch: java.lang.Throwable -> L7a
            if (r15 == 0) goto L4d
            com.amap.api.mapcore.util.b r15 = r14.bo     // Catch: java.lang.Throwable -> L7a
            r15.e()     // Catch: java.lang.Throwable -> L7a
            goto L5a
        L4d:
            r7 = 1
            r11 = 1
            r12 = 0
            r13 = 0
            r6 = r14
            r6.a(r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L7a
            com.autonavi.base.amap.mapcore.MapConfig r15 = r14.c     // Catch: java.lang.Throwable -> L7a
            r15.setCustomStyleEnable(r4)     // Catch: java.lang.Throwable -> L7a
        L5a:
            com.amap.api.mapcore.util.ac r15 = r14.ab     // Catch: java.lang.Throwable -> L7a
            r15.setLogoEnable(r3)     // Catch: java.lang.Throwable -> L7a
            goto L76
        L60:
            com.autonavi.base.amap.mapcore.MapConfig r15 = r14.c     // Catch: java.lang.Throwable -> L7a
            java.lang.String r15 = r15.getMapLanguage()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r0 = "en"
            boolean r15 = r15.equals(r0)     // Catch: java.lang.Throwable -> L7a
            if (r15 == 0) goto L73
            java.lang.String r15 = "zh_cn"
            r14.setMapLanguage(r15)     // Catch: java.lang.Throwable -> L7a
        L73:
            r14.b(r3, r8, r9, r10)     // Catch: java.lang.Throwable -> L7a
        L76:
            r14.resetRenderTime()     // Catch: java.lang.Throwable -> L7a
            goto L88
        L7a:
            r15 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "setMaptype"
            com.amap.api.mapcore.util.hd.c(r15, r0, r1)
            r15.printStackTrace()
            com.amap.api.mapcore.util.eq.a(r15)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.c.g(int):void");
    }

    private void i() {
        if (!this.ap) {
            this.j.sendEmptyMessage(16);
            this.ap = true;
            a(true);
        }
        long j = this.bH;
        if (j < 2) {
            this.bH = j + 1;
            return;
        }
        final ez d2 = this.ae.d();
        if (d2 == null || d2.getVisibility() == 8) {
            return;
        }
        eo.a(this.f, System.currentTimeMillis() - this.bp);
        this.j.post(new Runnable() { // from class: com.amap.api.mapcore.util.c.12
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.an) {
                    return;
                }
                try {
                    c cVar = c.this;
                    aq aqVar = cVar.d;
                    if (aqVar != null) {
                        cVar.setIndoorBuildingInfo(aqVar);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                d2.a(false);
            }
        });
    }

    public boolean a(int i, int i2, int i3) {
        AbstractCameraUpdateMessage a2;
        if (this.bc && ((int) a(i)) < this.c.getMaxZoomLevel()) {
            try {
                if (this.ao) {
                    a2 = ah.a(1.0f, (Point) null);
                } else if (!this.ab.isZoomInByScreenCenter()) {
                    Point point = this.k;
                    point.x = i2;
                    point.y = i3;
                    a2 = ah.a(1.0f, point);
                } else {
                    a2 = ah.a(1.0f, (Point) null);
                }
                animateCamera(a2);
            } catch (Throwable th) {
                hd.c(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            resetRenderTime();
            return true;
        }
        return false;
    }

    private void b(final MotionEvent motionEvent) {
        queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Message obtain = Message.obtain();
                    Poi poi = null;
                    MapConfig mapConfig = c.this.c;
                    if (mapConfig != null && mapConfig.isTouchPoiEnable()) {
                        poi = c.this.b((int) motionEvent.getX(), (int) motionEvent.getY(), 25);
                    }
                    if (c.this.P == null || c.this.P.size() <= 0 || poi == null) {
                        c.this.c(motionEvent);
                        return;
                    }
                    obtain.what = 20;
                    obtain.obj = poi;
                    c.this.j.sendMessage(obtain);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public void b(final int i) {
        queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.13
            @Override // java.lang.Runnable
            public void run() {
                GLMapEngine gLMapEngine;
                if (!c.this.bc || (gLMapEngine = c.this.g) == null) {
                    return;
                }
                gLMapEngine.setHighlightSubwayEnable(i, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Poi b(int i, int i2, int i3) {
        if (this.bc) {
            try {
                ArrayList<MapLabelItem> a2 = a(1, i, i2, i3);
                MapLabelItem mapLabelItem = (a2 == null || a2.size() <= 0) ? null : a2.get(0);
                if (mapLabelItem != null) {
                    DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapLabelItem.pixel20X, mapLabelItem.pixel20Y, 20);
                    Poi poi = new Poi(mapLabelItem.name, new LatLng(pixelsToLatLong.y, pixelsToLatLong.x, false), mapLabelItem.poiid);
                    pixelsToLatLong.recycle();
                    return poi;
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return null;
    }

    private void a(MotionEvent motionEvent) throws RemoteException {
        if (!this.as || this.at == null || this.au == null) {
            return;
        }
        int x = (int) motionEvent.getX();
        int y = (int) (motionEvent.getY() - 60.0f);
        LatLng realPosition = this.au.getRealPosition();
        if (realPosition != null) {
            LatLng position = this.au.getPosition();
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x, y, obtain);
            LatLng latLng = new LatLng((position.latitude + obtain.y) - realPosition.latitude, (position.longitude + obtain.x) - realPosition.longitude);
            obtain.recycle();
            this.at.setPosition(latLng);
            try {
                List<AMap.OnMarkerDragListener> list = this.K;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (int i = 0; i < this.K.size(); i++) {
                    this.K.get(i).onMarkerDrag(this.at);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b() {
        GLMapRender gLMapRender = this.aS;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    protected void e(int i) {
        fd fdVar = this.ae;
        if (fdVar != null) {
            if (i == 0) {
                if (fdVar.b()) {
                    this.ae.g(Boolean.FALSE);
                    this.ae.c();
                }
            } else if (fdVar.b()) {
            } else {
                this.ae.g(Boolean.TRUE);
                this.ae.c();
            }
        }
    }

    public synchronized void b(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4, false, false, (StyleItem[]) null);
    }

    public void b(final int i, final boolean z) {
        if (this.bc && this.bd) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.17
                @Override // java.lang.Runnable
                public void run() {
                    GLMapEngine gLMapEngine = c.this.g;
                    if (gLMapEngine != null) {
                        if (z) {
                            gLMapEngine.setAllContentEnable(i, true);
                        } else {
                            gLMapEngine.setAllContentEnable(i, false);
                        }
                        c.this.g.setSimple3DEnable(i, false);
                    }
                }
            });
            return;
        }
        a aVar = this.by;
        aVar.c = z;
        aVar.b = true;
        aVar.g = i;
    }

    public void b(AMapWidgetListener aMapWidgetListener) throws RemoteException {
        b((List<List<AMapWidgetListener>>) this.am, (List<AMapWidgetListener>) aMapWidgetListener);
    }

    private <T> void b(List<T> list, T t) {
        if (list != null && t != null) {
            try {
                if (!list.contains(t)) {
                    return;
                }
                list.remove(t);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    protected void a(GLMapState gLMapState, int i, int i2, DPoint dPoint) {
        if (!this.bc || this.g == null) {
            return;
        }
        Point point = new Point();
        gLMapState.screenToP20Point(i, i2, point);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    public void a(int i, int i2, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (!this.bc || (gLMapEngine = this.g) == null || (mapState = gLMapEngine.getMapState(1)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i, i2, fPoint);
    }

    private void a(int i, GL10 gl10) {
        int i2 = this.aN;
        if (i2 != -1) {
            this.aS.setRenderFps(i2);
            resetRenderTime();
        } else if (!this.g.isInMapAction(i) && !this.aZ) {
            if (this.g.isInMapAnimation(i)) {
                this.aS.setRenderFps(30.0f);
                this.aS.resetTickCount(15);
            } else {
                this.aS.setRenderFps(15.0f);
            }
        } else {
            this.aS.setRenderFps(40.0f);
        }
        if (this.c.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            a(true);
            this.c.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
    }

    private void a(GL10 gl10) {
        if (this.az) {
            boolean canStopMapRender = this.g.canStopMapRender(1);
            Message obtainMessage = this.j.obtainMessage(15, eq.a(0, 0, getMapWidth(), getMapHeight()));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
            this.az = false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void changeSurface(GL10 gl10, int i, int i2) {
        try {
            changeSurface(1, gl10, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0125, code lost:
        r0 = r11.am;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0127, code lost:
        if (r0 == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012d, code lost:
        if (r0.size() <= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x012f, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0136, code lost:
        if (r0 >= r11.am.size()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0138, code lost:
        r11.am.get(r0).invalidateCompassView();
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a() {
        /*
            Method dump skipped, instructions count: 395
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.c.a():void");
    }

    void a(boolean z) {
        this.j.obtainMessage(17, z ? 1 : 0, 0).sendToTarget();
    }

    public ArrayList<MapLabelItem> a(int i, int i2, int i3, int i4) {
        int i5;
        if (this.bc) {
            ArrayList<MapLabelItem> arrayList = new ArrayList<>();
            byte[] labelBuffer = this.g.getLabelBuffer(i, i2, i3, i4);
            if (labelBuffer == null) {
                return null;
            }
            int i6 = GLConvertUtil.getInt(labelBuffer, 0) >= 1 ? 1 : 0;
            int i7 = 0;
            int i8 = 4;
            while (i7 < i6) {
                MapLabelItem mapLabelItem = new MapLabelItem();
                int i9 = GLConvertUtil.getInt(labelBuffer, i8);
                int i10 = i8 + 4;
                int i11 = GLConvertUtil.getInt(labelBuffer, i10);
                int i12 = i10 + 4;
                mapLabelItem.x = i9;
                mapLabelItem.y = this.ad.getHeight() - i11;
                mapLabelItem.pixel20X = GLConvertUtil.getInt(labelBuffer, i12);
                int i13 = i12 + 4;
                mapLabelItem.pixel20Y = GLConvertUtil.getInt(labelBuffer, i13);
                int i14 = i13 + 4;
                mapLabelItem.pixel20Z = GLConvertUtil.getInt(labelBuffer, i14);
                int i15 = i14 + 4;
                mapLabelItem.type = GLConvertUtil.getInt(labelBuffer, i15);
                int i16 = i15 + 4;
                mapLabelItem.mSublayerId = GLConvertUtil.getInt(labelBuffer, i16);
                int i17 = i16 + 4;
                mapLabelItem.timeStamp = GLConvertUtil.getInt(labelBuffer, i17);
                int i18 = i17 + 4;
                mapLabelItem.mIsFouces = labelBuffer[i18] != 0;
                int i19 = i18 + 1;
                if (labelBuffer[i19] == 0) {
                    mapLabelItem.poiid = null;
                } else {
                    String str = "";
                    for (int i20 = 0; i20 < 20; i20++) {
                        if (labelBuffer[i20 + i19] == 0) {
                            break;
                        }
                        str = str + ((char) labelBuffer[i5]);
                    }
                    mapLabelItem.poiid = str;
                }
                int i21 = i19 + 20;
                int i22 = i21 + 1;
                byte b2 = labelBuffer[i21];
                StringBuffer stringBuffer = new StringBuffer();
                for (int i23 = 0; i23 < b2; i23++) {
                    stringBuffer.append((char) GLConvertUtil.getShort(labelBuffer, i22));
                    i22 += 2;
                }
                mapLabelItem.name = stringBuffer.toString();
                arrayList.add(mapLabelItem);
                i7++;
                i8 = i22;
            }
            return arrayList;
        }
        return null;
    }

    public synchronized void a(final int i, final int i2, final int i3, final int i4, final boolean z, final boolean z2, final StyleItem[] styleItemArr) {
        if (this.bd && this.bc && this.a) {
            e(i3);
            queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.14
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.this.g.setMapModeAndStyle(i, i2, i3, i4, z, z2, styleItemArr);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } else {
            a aVar = this.bs;
            aVar.g = i;
            aVar.d = i2;
            aVar.e = i3;
            aVar.f = i4;
            aVar.b = true;
        }
    }

    public void a(final int i, final boolean z) {
        if (this.bc && this.bd) {
            resetRenderTime();
            queueEvent(new Runnable() { // from class: com.amap.api.mapcore.util.c.16
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.this.g.setBuildingEnable(i, z);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return;
        }
        a aVar = this.bu;
        aVar.c = z;
        aVar.b = true;
        aVar.g = i;
    }

    public int a(int i, Rect rect, int i2, int i3) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine == null || i < 0 || rect == null) {
            return 0;
        }
        int engineIDWithType = gLMapEngine.getEngineIDWithType(i);
        if (!this.g.isEngineCreated(engineIDWithType)) {
            int i4 = this.f.getResources().getDisplayMetrics().densityDpi;
            float f = this.f.getResources().getDisplayMetrics().density;
            this.aW = GLMapState.calMapZoomScalefactor(i2, i3, i4);
            GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
            mapViewInitParam.engineId = engineIDWithType;
            mapViewInitParam.x = rect.left;
            mapViewInitParam.y = rect.top;
            mapViewInitParam.width = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect);
            mapViewInitParam.height = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
            mapViewInitParam.screenWidth = i2;
            mapViewInitParam.screenHeight = i3;
            mapViewInitParam.screenScale = f;
            mapViewInitParam.textScale = this.aX * f;
            mapViewInitParam.mapZoomScale = this.aW;
            this.g.createAMapEngineWithFrame(mapViewInitParam);
            GLMapState mapState = this.g.getMapState(engineIDWithType);
            mapState.setMapZoomer(this.c.getSZ());
            mapState.setCameraDegree(this.c.getSC());
            mapState.setMapAngle(this.c.getSR());
            mapState.setMapGeoCenter(this.c.getSX(), this.c.getSY());
            this.g.setMapState(engineIDWithType, mapState);
            this.g.setOvelayBundle(engineIDWithType, new GLOverlayBundle<>(engineIDWithType, this));
            return engineIDWithType;
        }
        a(engineIDWithType, rect.left, rect.top, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect), i2, i3);
        return engineIDWithType;
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i, i2, i3, i4, i5, i6, i7);
        }
    }

    private boolean a(int i, int i2) {
        GLMapEngine gLMapEngine = this.g;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i, i2);
        }
        return false;
    }

    private void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z = this.ao;
        abstractCameraUpdateMessage.isUseAnchor = z;
        if (z) {
            abstractCameraUpdateMessage.anchorX = this.c.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.c.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = getMapWidth();
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = getMapHeight();
        }
        abstractCameraUpdateMessage.mapConfig = this.c;
    }

    private boolean a(LatLngBounds latLngBounds) {
        return (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null) ? false : true;
    }

    protected void a(boolean z, CameraPosition cameraPosition) {
        MapConfig mapConfig = this.c;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.aZ && this.g.getAnimateionsCount() == 0 && this.g.getStateMessageCount() == 0) {
                AMapGestureListener aMapGestureListener = this.W;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onMapStable();
                }
                List<AMap.OnCameraChangeListener> list = this.M;
                if (list == null || list.size() == 0 || !this.ad.isEnabled()) {
                    return;
                }
                if (cameraPosition == null) {
                    cameraPosition = getCameraPosition();
                }
                try {
                    for (AMap.OnCameraChangeListener onCameraChangeListener : this.M) {
                        onCameraChangeListener.onCameraChangeFinish(cameraPosition);
                    }
                } catch (Throwable unused) {
                }
                this.c.resetChangedCounter();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    @Override // com.amap.api.mapcore.util.b.a
    public void a(byte[] bArr) {
        jp jpVar = this.bD;
        if (jpVar != null) {
            jpVar.a("onAbroadStyleComplete", bArr);
        }
    }

    public void a(boolean z, byte[] bArr, boolean z2) {
        Cdo cdo;
        try {
            this.c.setCustomStyleEnable(z);
            boolean z3 = false;
            if (this.c.isHideLogoEnable()) {
                this.ab.setLogoEnable(!z);
            }
            if (z) {
                c(1, true);
                dn dnVar = new dn(this.f);
                MyTrafficStyle myTrafficStyle = this.aD;
                if (myTrafficStyle != null && myTrafficStyle.getTrafficRoadBackgroundColor() != -1) {
                    dnVar.a(this.aD.getTrafficRoadBackgroundColor());
                }
                if (this.c.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.c.getCustomTextureResourcePath())) {
                    z3 = true;
                }
                StyleItem[] styleItemArr = null;
                if (bArr != null) {
                    cdo = dnVar.a(bArr, z3);
                    if (cdo != null && (styleItemArr = cdo.c()) != null) {
                        this.c.setUseProFunction(true);
                    }
                } else {
                    cdo = null;
                }
                if (styleItemArr == null && (cdo = dnVar.a(this.c.getCustomStylePath(), z3)) != null) {
                    styleItemArr = cdo.c();
                }
                if (dnVar.a() != 0) {
                    this.c.setCustomBackgroundColor(dnVar.a());
                }
                if (cdo != null && cdo.d() != null) {
                    if (this.aQ != null) {
                        this.aQ.a((String) cdo.d());
                        this.aQ.a(cdo);
                        this.aQ.b();
                        return;
                    }
                    return;
                }
                a(styleItemArr, z2);
                return;
            }
            c(1, false);
            a(1, this.c.getMapStyleMode(), this.c.getMapStyleTime(), this.c.getMapStyleState(), true, false, (StyleItem[]) null);
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // com.amap.api.mapcore.util.di.a
    public void a(String str, Cdo cdo) {
        setCustomTextureResourcePath(str);
        if (!this.c.isCustomStyleEnable() || cdo == null) {
            return;
        }
        a(cdo.c(), false);
    }

    protected void a(StyleItem[] styleItemArr, boolean z) {
        if (z || (styleItemArr != null && styleItemArr.length > 0)) {
            a(1, 0, 0, 0, true, true, styleItemArr);
            eo.a(this.f, true);
            return;
        }
        eo.a(this.f, false);
    }

    public void a(AMapWidgetListener aMapWidgetListener) throws RemoteException {
        a((List<List<AMapWidgetListener>>) this.am, (List<AMapWidgetListener>) aMapWidgetListener);
    }

    private <T> void a(List<T> list, T t) {
        if (list != null && t != null) {
            try {
                if (list.contains(t)) {
                    return;
                }
                list.add(t);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void a(List<T> list) {
        if (list != null) {
            try {
                list.clear();
            } catch (Throwable unused) {
            }
        }
    }
}
