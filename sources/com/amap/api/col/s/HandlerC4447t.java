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
/* renamed from: com.amap.api.col.s.t */
/* loaded from: classes10.dex */
public final class HandlerC4447t extends Handler {
    private static HandlerC4447t a;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$a */
    /* loaded from: classes10.dex */
    public static class C4448a {
        public BusLineResult a;
        public BusLineSearch.OnBusLineSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$b */
    /* loaded from: classes10.dex */
    public static class C4449b {
        public BusStationResult a;
        public BusStationSearch.OnBusStationSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$c */
    /* loaded from: classes10.dex */
    public static class C4450c {
        public CloudItemDetail a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$d */
    /* loaded from: classes10.dex */
    public static class C4451d {
        public CloudResult a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$e */
    /* loaded from: classes10.dex */
    public static class C4452e {
        public GeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$f */
    /* loaded from: classes10.dex */
    public static class C4453f {
        public List<NearbySearch.NearbyListener> a;
        public NearbySearchResult b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$g */
    /* loaded from: classes10.dex */
    public static class C4454g {
        public PoiItem a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$h */
    /* loaded from: classes10.dex */
    public static class C4455h {
        public PoiResult a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$i */
    /* loaded from: classes10.dex */
    public static class C4456i {
        public RegeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$j */
    /* loaded from: classes10.dex */
    public static class C4457j {
        public RoutePOISearchResult a;
        public RoutePOISearch.OnRoutePOISearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$k */
    /* loaded from: classes10.dex */
    public static class C4458k {
        public LocalWeatherForecastResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.t$l */
    /* loaded from: classes10.dex */
    public static class C4459l {
        public LocalWeatherLiveResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    HandlerC4447t() {
    }

    public static synchronized HandlerC4447t a() {
        HandlerC4447t handlerC4447t;
        synchronized (HandlerC4447t.class) {
            if (a == null) {
                if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                    a = new HandlerC4447t();
                }
                a = new HandlerC4447t(Looper.getMainLooper());
            }
            handlerC4447t = a;
        }
        return handlerC4447t;
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
        C4453f c4453f = (C4453f) message.obj;
        if (c4453f == null || (list = c4453f.a) == null || list.size() == 0) {
            return;
        }
        NearbySearchResult nearbySearchResult = message.what == 1000 ? c4453f.b : null;
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
        C4449b c4449b = (C4449b) message.obj;
        if (c4449b == null || (onBusStationSearchListener = c4449b.b) == null) {
            return;
        }
        int i = message.what;
        onBusStationSearchListener.onBusStationSearched(i == 1000 ? c4449b.a : null, i);
    }

    private static void f(Message message) {
        C4454g c4454g;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        int i = message.what;
        if (i == 600) {
            C4455h c4455h = (C4455h) message.obj;
            if (c4455h == null || (onPoiSearchListener = c4455h.b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(c4455h.a, data.getInt("errorCode"));
        } else if (i != 602 || (c4454g = (C4454g) message.obj) == null) {
        } else {
            PoiSearch.OnPoiSearchListener onPoiSearchListener2 = c4454g.b;
            Bundle data2 = message.getData();
            if (data2 != null) {
                onPoiSearchListener2.onPoiItemSearched(c4454g.a, data2.getInt("errorCode"));
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
        C4452e c4452e;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        int i = message.what;
        if (i == 201) {
            C4456i c4456i = (C4456i) message.obj;
            if (c4456i == null || (onGeocodeSearchListener2 = c4456i.b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(c4456i.a, message.arg2);
        } else if (i != 200 || (c4452e = (C4452e) message.obj) == null || (onGeocodeSearchListener = c4452e.b) == null) {
        } else {
            onGeocodeSearchListener.onGeocodeSearched(c4452e.a, message.arg2);
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
        C4448a c4448a = (C4448a) message.obj;
        if (c4448a == null || (onBusLineSearchListener = c4448a.b) == null) {
            return;
        }
        int i = message.what;
        onBusLineSearchListener.onBusLineSearched(i == 1000 ? c4448a.a : null, i);
    }

    private static void k(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        int i = message.what;
        if (i == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable("result"), data2.getInt("errorCode"));
            }
        } else if (i == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable("result"), data3.getInt("errorCode"));
            }
        } else if (i == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable("result"), data4.getInt("errorCode"));
            }
        } else if (i == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable("result"), data5.getInt("errorCode"));
            }
        } else if (i != 104 || (data = message.getData()) == null) {
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
        C4450c c4450c;
        int i = message.what;
        if (i == 700) {
            C4451d c4451d = (C4451d) message.obj;
            if (c4451d == null) {
                return;
            }
            c4451d.b.onCloudSearched(c4451d.a, message.arg2);
        } else if (i != 701 || (c4450c = (C4450c) message.obj) == null) {
        } else {
            c4450c.b.onCloudItemDetailSearched(c4450c.a, message.arg2);
        }
    }

    private static void p(Message message) {
        C4458k c4458k;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        int i = message.what;
        if (i == 1301) {
            C4459l c4459l = (C4459l) message.obj;
            if (c4459l == null || (onWeatherSearchListener2 = c4459l.b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(c4459l.a, data2.getInt("errorCode"));
        } else if (i != 1302 || (c4458k = (C4458k) message.obj) == null || (onWeatherSearchListener = c4458k.b) == null || (data = message.getData()) == null) {
        } else {
            onWeatherSearchListener.onWeatherForecastSearched(c4458k.a, data.getInt("errorCode"));
        }
    }

    private static void q(Message message) {
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        C4457j c4457j = (C4457j) message.obj;
        if (c4457j == null || (onRoutePOISearchListener = c4457j.b) == null || (data = message.getData()) == null) {
            return;
        }
        onRoutePOISearchListener.onRoutePoiSearched(c4457j.a, data.getInt("errorCode"));
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
            int i = message.arg1;
            if (i != 101) {
                switch (i) {
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
                        switch (i) {
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
            C4435i.a(th, "MessageHandler", "handleMessage");
        }
    }

    private HandlerC4447t(Looper looper) {
        super(looper);
    }

    private static void a(Message message) {
        int i = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener == null) {
            return;
        }
        switch (message.what) {
            case 1100:
                onShareSearchListener.onPoiShareUrlSearched(string, i);
                return;
            case 1101:
                onShareSearchListener.onLocationShareUrlSearched(string, i);
                return;
            case 1102:
                onShareSearchListener.onNaviShareUrlSearched(string, i);
                return;
            case 1103:
                onShareSearchListener.onBusRouteShareUrlSearched(string, i);
                return;
            case SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION /* 1104 */:
                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i);
                return;
            case 1105:
                onShareSearchListener.onWalkRouteShareUrlSearched(string, i);
                return;
            default:
                return;
        }
    }
}
