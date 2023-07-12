package com.amap.api.col.s;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.wireless.security.SecExceptionCode;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class t extends Handler {
    private static t a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        public BusLineResult a;
        public BusLineSearch.OnBusLineSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        public BusStationResult a;
        public BusStationSearch.OnBusStationSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c {
        public CloudItemDetail a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class d {
        public CloudResult a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class e {
        public GeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class f {
        public List<NearbySearch.NearbyListener> a;
        public NearbySearchResult b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class g {
        public PoiItem a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class h {
        public PoiResult a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class i {
        public RegeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class j {
        public RoutePOISearchResult a;
        public RoutePOISearch.OnRoutePOISearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class k {
        public LocalWeatherForecastResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class l {
        public LocalWeatherLiveResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    t() {
    }

    public static synchronized t a() {
        t tVar;
        synchronized (t.class) {
            if (a == null) {
                if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                    a = new t();
                }
                a = new t(Looper.getMainLooper());
            }
            tVar = a;
        }
        return tVar;
    }

    private static void b(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onNearbyInfoUploaded(message.what);
        }
    }

    private static void c(Message message) {
        List<NearbySearch.NearbyListener> list;
        f fVar = (f) message.obj;
        if (fVar == null || (list = fVar.a) == null || list.size() == 0) {
            return;
        }
        NearbySearchResult nearbySearchResult = message.what == 1000 ? fVar.b : null;
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onNearbyInfoSearched(nearbySearchResult, message.what);
        }
    }

    private static void d(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onUserInfoCleared(message.what);
        }
    }

    private static void e(Message message) {
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        b bVar = (b) message.obj;
        if (bVar == null || (onBusStationSearchListener = bVar.b) == null) {
            return;
        }
        int i2 = message.what;
        onBusStationSearchListener.onBusStationSearched(i2 == 1000 ? bVar.a : null, i2);
    }

    private static void f(Message message) {
        g gVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i2 = message.what;
        if (i2 == 600) {
            h hVar = (h) message.obj;
            if (hVar == null || (onPoiSearchListener = hVar.b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(hVar.a, data.getInt("errorCode"));
        } else if (i2 != 602 || (gVar = (g) message.obj) == null) {
        } else {
            PoiSearch.OnPoiSearchListener onPoiSearchListener2 = gVar.b;
            Bundle data2 = message.getData();
            if (data2 != null) {
                onPoiSearchListener2.onPoiItemSearched(gVar.a, data2.getInt("errorCode"));
            }
        }
    }

    private static void g(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener == null) {
            return;
        }
        inputtipsListener.onGetInputtips(message.what == 1000 ? message.getData().getParcelableArrayList("result") : null, message.what);
    }

    private static void h(Message message) {
        e eVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        int i2 = message.what;
        if (i2 == 201) {
            i iVar = (i) message.obj;
            if (iVar == null || (onGeocodeSearchListener2 = iVar.b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(iVar.a, message.arg2);
        } else if (i2 != 200 || (eVar = (e) message.obj) == null || (onGeocodeSearchListener = eVar.b) == null) {
        } else {
            onGeocodeSearchListener.onGeocodeSearched(eVar.a, message.arg2);
        }
    }

    private static void i(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener == null) {
            return;
        }
        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable("result"));
    }

    private static void j(Message message) {
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        a aVar = (a) message.obj;
        if (aVar == null || (onBusLineSearchListener = aVar.b) == null) {
            return;
        }
        int i2 = message.what;
        onBusLineSearchListener.onBusLineSearched(i2 == 1000 ? aVar.a : null, i2);
    }

    private static void k(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i2 = message.what;
        if (i2 == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
            }
        } else if (i2 == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
            }
        } else if (i2 == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
            }
        } else if (i2 == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
            }
        } else if (i2 != 104 || (data = message.getData()) == null) {
        } else {
            onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
        }
    }

    private static void l(Message message) {
        Bundle data;
        RouteSearchV2.OnRouteSearchListener onRouteSearchListener = (RouteSearchV2.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null || message.what != 101 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onDriveRouteSearched((DriveRouteResultV2) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void m(Message message) {
        Bundle data;
        RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
        if (onTruckRouteSearchListener == null || message.what != 104 || (data = message.getData()) == null) {
            return;
        }
        onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void n(Message message) {
        Bundle data;
        RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
        if (onRoutePlanSearchListener == null || message.what != 105 || (data = message.getData()) == null) {
            return;
        }
        onRoutePlanSearchListener.onDriveRoutePlanSearched((DriveRoutePlanResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    private static void o(Message message) {
        c cVar;
        int i2 = message.what;
        if (i2 == 700) {
            d dVar = (d) message.obj;
            if (dVar == null) {
                return;
            }
            dVar.b.onCloudSearched(dVar.a, message.arg2);
        } else if (i2 != 701 || (cVar = (c) message.obj) == null) {
        } else {
            cVar.b.onCloudItemDetailSearched(cVar.a, message.arg2);
        }
    }

    private static void p(Message message) {
        k kVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        int i2 = message.what;
        if (i2 == 1301) {
            l lVar = (l) message.obj;
            if (lVar == null || (onWeatherSearchListener2 = lVar.b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(lVar.a, data2.getInt("errorCode"));
        } else if (i2 != 1302 || (kVar = (k) message.obj) == null || (onWeatherSearchListener = kVar.b) == null || (data = message.getData()) == null) {
        } else {
            onWeatherSearchListener.onWeatherForecastSearched(kVar.a, data.getInt("errorCode"));
        }
    }

    private static void q(Message message) {
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        j jVar = (j) message.obj;
        if (jVar == null || (onRoutePOISearchListener = jVar.b) == null || (data = message.getData()) == null) {
            return;
        }
        onRoutePOISearchListener.onRoutePoiSearched(jVar.a, data.getInt("errorCode"));
    }

    private static void r(Message message) {
        Bundle data;
        DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
        if (onDistanceSearchListener == null || message.what != 400 || (data = message.getData()) == null) {
            return;
        }
        onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable("result"), data.getInt("errorCode"));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            int i2 = message.arg1;
            if (i2 != 101) {
                switch (i2) {
                    case 1:
                        k(message);
                        return;
                    case 2:
                        h(message);
                        return;
                    case 3:
                        j(message);
                        return;
                    case 4:
                        i(message);
                        return;
                    case 5:
                        g(message);
                        return;
                    case 6:
                        f(message);
                        return;
                    case 7:
                        e(message);
                        return;
                    case 8:
                        d(message);
                        return;
                    case 9:
                        c(message);
                        return;
                    case 10:
                        b(message);
                        return;
                    case 11:
                        a(message);
                        return;
                    case 12:
                        o(message);
                        return;
                    case 13:
                        p(message);
                        return;
                    case 14:
                        q(message);
                        return;
                    default:
                        switch (i2) {
                            case 16:
                                r(message);
                                return;
                            case 17:
                                m(message);
                                return;
                            case 18:
                                n(message);
                                return;
                            default:
                                return;
                        }
                }
            }
            l(message);
        } catch (Throwable th) {
            com.amap.api.col.s.i.a(th, "MessageHandler", "handleMessage");
        }
    }

    private t(Looper looper) {
        super(looper);
    }

    private static void a(Message message) {
        int i2 = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener == null) {
            return;
        }
        switch (message.what) {
            case 1100:
                onShareSearchListener.onPoiShareUrlSearched(string, i2);
                return;
            case 1101:
                onShareSearchListener.onLocationShareUrlSearched(string, i2);
                return;
            case 1102:
                onShareSearchListener.onNaviShareUrlSearched(string, i2);
                return;
            case 1103:
                onShareSearchListener.onBusRouteShareUrlSearched(string, i2);
                return;
            case SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION /* 1104 */:
                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i2);
                return;
            case 1105:
                onShareSearchListener.onWalkRouteShareUrlSearched(string, i2);
                return;
            default:
                return;
        }
    }
}
