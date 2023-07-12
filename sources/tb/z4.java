package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.pictures.piclocation.LocateQueueManager;
import com.alibaba.pictures.piclocation.LocationDataStatus;
import com.alibaba.pictures.piclocation.LocationErrorReporter;
import com.alibaba.pictures.piclocation.LocationInterface;
import com.alibaba.pictures.piclocation.listener.GetLocationInfoInterface;
import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.alibaba.pictures.piclocation.listener.LocateMapListener;
import com.alibaba.pictures.piclocation.listener.LocateRegionPicListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class z4 implements LocationInterface, GeocodeSearch.OnGeocodeSearchListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static boolean m = true;
    @Nullable
    private static z4 n;
    private final Context a;
    private LocateQueueManager b;
    private AMapLocationClient c;
    @Nullable
    private ga1 d;
    private GeocodeSearch e;
    private LocationDataStatus f;
    private LocateMapListener g;
    private long h;
    private long i;
    private AMapLocation j;
    private final AMapLocationListener k;
    @Nullable
    private GetLocationInfoInterface l;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public final boolean a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2134141015") ? ((Boolean) ipChange.ipc$dispatch("2134141015", new Object[]{this})).booleanValue() : z4.m;
        }

        @Nullable
        public final z4 b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1129794563") ? (z4) ipChange.ipc$dispatch("1129794563", new Object[]{this}) : z4.n;
        }

        @NotNull
        public final synchronized z4 c(@Nullable Context context, @Nullable LocateQueueManager locateQueueManager) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1712532737")) {
                return (z4) ipChange.ipc$dispatch("1712532737", new Object[]{this, context, locateQueueManager});
            }
            if (b() == null) {
                d(new z4(context, null));
                z4 b = b();
                if (b != null) {
                    b.b = locateQueueManager;
                }
            }
            z4 b2 = b();
            b41.f(b2);
            return b2;
        }

        public final void d(@Nullable z4 z4Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-884450273")) {
                ipChange.ipc$dispatch("-884450273", new Object[]{this, z4Var});
            } else {
                z4.n = z4Var;
            }
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements AMapLocationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "480486944")) {
                ipChange.ipc$dispatch("480486944", new Object[]{this, aMapLocation});
                return;
            }
            if (z4.Companion.a() && aMapLocation != null) {
                if (aMapLocation.getErrorCode() != 0) {
                    Log.v("Locate_AmapImpl", "onLocationChanged:" + aMapLocation.getErrorCode() + "," + aMapLocation.getErrorInfo());
                } else {
                    Log.v("Locate_AmapImpl", "onLocationChanged:" + aMapLocation);
                }
            }
            if (aMapLocation == null) {
                return;
            }
            if (z4.this.g != null) {
                z4.this.m(aMapLocation);
            }
            if (aMapLocation.getErrorCode() == 0 && aMapLocation.getLatitude() != 0.0d && aMapLocation.getLongitude() != 0.0d) {
                z4.this.j = aMapLocation;
                GetLocationInfoInterface o = z4.this.o();
                if (o != null) {
                    o.getLocationInfoSuccess(aMapLocation, System.currentTimeMillis());
                }
                LocateQueueManager locateQueueManager = z4.this.b;
                if (locateQueueManager != null) {
                    locateQueueManager.q(true);
                }
                if (TextUtils.isEmpty(aMapLocation.getAddress())) {
                    z4.this.f = LocationDataStatus.NOCACHE;
                    RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()), 500.0f, GeocodeSearch.AMAP);
                    GeocodeSearch geocodeSearch = z4.this.e;
                    if (geocodeSearch != null) {
                        geocodeSearch.getFromLocationAsyn(regeocodeQuery);
                        return;
                    }
                    return;
                }
                ga1 ga1Var = new ga1(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                ga1Var.e = aMapLocation.getAddress();
                ga1Var.g = LocationDataStatus.NOCACHE;
                ga1Var.d = aMapLocation.getCity();
                ga1Var.c = aMapLocation.getCityCode();
                z4.this.r(ga1Var);
                LocateQueueManager locateQueueManager2 = z4.this.b;
                if (locateQueueManager2 != null) {
                    locateQueueManager2.o(ga1Var);
                }
            } else if (aMapLocation.getErrorCode() != 0) {
                int errorCode = aMapLocation.getErrorCode();
                z4.this.s(errorCode);
                Log.e("Locate_AmapImpl", "errCode=" + errorCode);
                if (errorCode == 12) {
                    LocateQueueManager locateQueueManager3 = z4.this.b;
                    if (locateQueueManager3 != null) {
                        LocationDataStatus locationDataStatus = LocationDataStatus.NOPERMISSION;
                        locateQueueManager3.p(locationDataStatus.getCode(), locationDataStatus.getDes());
                    }
                } else {
                    LocateQueueManager locateQueueManager4 = z4.this.b;
                    if (locateQueueManager4 != null) {
                        LocationDataStatus locationDataStatus2 = LocationDataStatus.UNKNOW;
                        locateQueueManager4.p(locationDataStatus2.getCode(), locationDataStatus2.getDes());
                    }
                }
                if (errorCode != 0) {
                    ga1 ga1Var2 = new ga1(-1.0d, -1.0d);
                    if (errorCode != 12) {
                        LocateQueueManager locateQueueManager5 = z4.this.b;
                        if (locateQueueManager5 != null) {
                            locateQueueManager5.q(true);
                        }
                    } else {
                        ga1Var2.g = LocationDataStatus.NOPERMISSION;
                        LocateQueueManager locateQueueManager6 = z4.this.b;
                        if (locateQueueManager6 != null) {
                            locateQueueManager6.q(false);
                        }
                    }
                    LocateQueueManager locateQueueManager7 = z4.this.b;
                    if (locateQueueManager7 != null) {
                        locateQueueManager7.t(ga1Var2);
                    }
                }
            }
        }
    }

    private z4(Context context) {
        this.a = context;
        this.h = 300000L;
        this.i = 300000L;
        this.k = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(AMapLocation aMapLocation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "251847866")) {
            ipChange.ipc$dispatch("251847866", new Object[]{this, aMapLocation});
            return;
        }
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            LocateMapListener locateMapListener = this.g;
            if (locateMapListener != null) {
                locateMapListener.onMapLocationSuccess(aMapLocation);
            }
        } else {
            LocateMapListener locateMapListener2 = this.g;
            if (locateMapListener2 != null) {
                locateMapListener2.onMapLocationFailed(aMapLocation.getErrorCode(), aMapLocation.getErrorInfo());
            }
        }
        this.g = null;
        n();
    }

    private final void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-255520156")) {
            ipChange.ipc$dispatch("-255520156", new Object[]{this});
            return;
        }
        AMapLocationClient aMapLocationClient = this.c;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            aMapLocationClient.unRegisterLocationListener(this.k);
            aMapLocationClient.onDestroy();
            this.c = null;
        }
        if (m) {
            Log.v("Locate_AmapImpl", "stop location server");
        }
    }

    private final void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "7738412")) {
            ipChange.ipc$dispatch("7738412", new Object[]{this});
            return;
        }
        GeocodeSearch geocodeSearch = new GeocodeSearch(this.a);
        this.e = geocodeSearch;
        geocodeSearch.setOnGeocodeSearchListener(this);
    }

    private final void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-933231432")) {
            ipChange.ipc$dispatch("-933231432", new Object[]{this});
            return;
        }
        AMapLocationClient aMapLocationClient = new AMapLocationClient(this.a);
        this.c = aMapLocationClient;
        aMapLocationClient.setLocationListener(this.k);
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setHttpTimeOut(15000);
        aMapLocationClientOption.setOnceLocation(true);
        AMapLocationClient aMapLocationClient2 = this.c;
        if (aMapLocationClient2 != null) {
            aMapLocationClient2.setLocationOption(aMapLocationClientOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(ga1 ga1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "602278741")) {
            ipChange.ipc$dispatch("602278741", new Object[]{this, ga1Var});
            return;
        }
        if (ga1Var != null && getDangerousLocationPic() != null && TextUtils.isEmpty(ga1Var.d) && TextUtils.isEmpty(ga1Var.c)) {
            ga1 dangerousLocationPic = getDangerousLocationPic();
            String str = dangerousLocationPic != null ? dangerousLocationPic.c : null;
            ga1 dangerousLocationPic2 = getDangerousLocationPic();
            String str2 = dangerousLocationPic2 != null ? dangerousLocationPic2.d : null;
            double d = ga1Var.a;
            ga1 dangerousLocationPic3 = getDangerousLocationPic();
            if (dangerousLocationPic3 != null && d == dangerousLocationPic3.a) {
                double d2 = ga1Var.b;
                ga1 dangerousLocationPic4 = getDangerousLocationPic();
                if (dangerousLocationPic4 != null && d2 == dangerousLocationPic4.b) {
                    t(ga1Var);
                    ga1 dangerousLocationPic5 = getDangerousLocationPic();
                    if (dangerousLocationPic5 != null) {
                        dangerousLocationPic5.c = str;
                    }
                    ga1 dangerousLocationPic6 = getDangerousLocationPic();
                    if (dangerousLocationPic6 != null) {
                        dangerousLocationPic6.d = str2;
                        return;
                    }
                    return;
                }
            }
        }
        t(ga1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1882727232")) {
            ipChange.ipc$dispatch("-1882727232", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        LocationErrorReporter b2 = ia1.INSTANCE.b();
        if (b2 != null) {
            b2.reportGpsLocateFailed(i);
        }
    }

    private final boolean x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-897123476")) {
            return ((Boolean) ipChange.ipc$dispatch("-897123476", new Object[]{this})).booleanValue();
        }
        AMapLocation lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation == null || lastKnownLocation.getLatitude() == 0.0d || lastKnownLocation.getLongitude() == 0.0d || this.b == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LocateQueueManager locateQueueManager = this.b;
        b41.f(locateQueueManager);
        if (currentTimeMillis - locateQueueManager.m() > this.i) {
            this.j = null;
            this.i = this.h;
            return false;
        }
        this.i = this.h;
        if (!TextUtils.isEmpty(lastKnownLocation.getAddress())) {
            ga1 ga1Var = new ga1(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            ga1Var.e = lastKnownLocation.getAddress();
            ga1Var.g = LocationDataStatus.CACHE;
            r(ga1Var);
            LocateQueueManager locateQueueManager2 = this.b;
            if (locateQueueManager2 != null) {
                locateQueueManager2.o(ga1Var);
            }
        } else {
            this.f = LocationDataStatus.CACHE;
            RegeocodeQuery regeocodeQuery = new RegeocodeQuery(new LatLonPoint(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()), 500.0f, GeocodeSearch.AMAP);
            GeocodeSearch geocodeSearch = this.e;
            if (geocodeSearch != null) {
                geocodeSearch.getFromLocationAsyn(regeocodeQuery);
            }
        }
        return true;
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    @Nullable
    public ga1 getDangerousLocationPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-301827962") ? (ga1) ipChange.ipc$dispatch("-301827962", new Object[]{this}) : this.d;
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    @Nullable
    public AMapLocation getLastKnownLocation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594746138")) {
            return (AMapLocation) ipChange.ipc$dispatch("594746138", new Object[]{this});
        }
        AMapLocation aMapLocation = this.j;
        if (aMapLocation != null) {
            return aMapLocation;
        }
        AMapLocationClient aMapLocationClient = this.c;
        if (aMapLocationClient != null) {
            if (aMapLocationClient != null) {
                return aMapLocationClient.getLastKnownLocation();
            }
            return null;
        } else if (getDangerousLocationPic() != null) {
            AMapLocation aMapLocation2 = new AMapLocation("");
            ga1 dangerousLocationPic = getDangerousLocationPic();
            b41.f(dangerousLocationPic);
            aMapLocation2.setLatitude(dangerousLocationPic.a);
            ga1 dangerousLocationPic2 = getDangerousLocationPic();
            b41.f(dangerousLocationPic2);
            aMapLocation2.setLongitude(dangerousLocationPic2.b);
            ga1 dangerousLocationPic3 = getDangerousLocationPic();
            b41.f(dangerousLocationPic3);
            aMapLocation2.setAddress(dangerousLocationPic3.e);
            LocateQueueManager locateQueueManager = this.b;
            aMapLocation2.setTime(locateQueueManager != null ? locateQueueManager.m() : 0L);
            return aMapLocation2;
        } else {
            return null;
        }
    }

    @Nullable
    public final GetLocationInfoInterface o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1056619687") ? (GetLocationInfoInterface) ipChange.ipc$dispatch("1056619687", new Object[]{this}) : this.l;
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onGeocodeSearched(@NotNull GeocodeResult geocodeResult, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146199598")) {
            ipChange.ipc$dispatch("1146199598", new Object[]{this, geocodeResult, Integer.valueOf(i)});
        } else {
            b41.i(geocodeResult, "geocodeResult");
        }
    }

    @Override // com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener
    public void onRegeocodeSearched(@NotNull RegeocodeResult regeocodeResult, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-398816696")) {
            ipChange.ipc$dispatch("-398816696", new Object[]{this, regeocodeResult, Integer.valueOf(i)});
            return;
        }
        b41.i(regeocodeResult, "regeocodeResult");
        RegeocodeQuery regeocodeQuery = regeocodeResult.getRegeocodeQuery();
        b41.h(regeocodeQuery, "regeocodeResult.regeocodeQuery");
        LatLonPoint point = regeocodeQuery.getPoint();
        b41.h(point, "regeocodeResult.regeocodeQuery.point");
        double latitude = point.getLatitude();
        RegeocodeQuery regeocodeQuery2 = regeocodeResult.getRegeocodeQuery();
        b41.h(regeocodeQuery2, "regeocodeResult.regeocodeQuery");
        LatLonPoint point2 = regeocodeQuery2.getPoint();
        b41.h(point2, "regeocodeResult.regeocodeQuery.point");
        ga1 ga1Var = new ga1(latitude, point2.getLongitude());
        RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
        b41.h(regeocodeAddress, "regeocodeResult.regeocodeAddress");
        ga1Var.d = regeocodeAddress.getCity();
        RegeocodeAddress regeocodeAddress2 = regeocodeResult.getRegeocodeAddress();
        b41.h(regeocodeAddress2, "regeocodeResult.regeocodeAddress");
        ga1Var.e = regeocodeAddress2.getFormatAddress();
        ga1Var.g = this.f;
        r(ga1Var);
        LocateQueueManager locateQueueManager = this.b;
        if (locateQueueManager != null) {
            locateQueueManager.o(ga1Var);
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocation(@Nullable LocateGpsPicListener locateGpsPicListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450683842")) {
            ipChange.ipc$dispatch("450683842", new Object[]{this, locateGpsPicListener});
        } else {
            startLocation(locateGpsPicListener, 15000L);
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationRegion(@Nullable LocateRegionPicListener locateRegionPicListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2024430396")) {
            ipChange.ipc$dispatch("-2024430396", new Object[]{this, locateRegionPicListener});
        } else {
            startLocationRegion(locateRegionPicListener, 15000L);
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationWithCacheTime(@Nullable LocateGpsPicListener locateGpsPicListener, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086916329")) {
            ipChange.ipc$dispatch("-1086916329", new Object[]{this, locateGpsPicListener, Long.valueOf(j)});
            return;
        }
        this.i = j;
        startLocation(locateGpsPicListener, 15000L);
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationWithCacheTimeAndRequestTime(@Nullable LocateGpsPicListener locateGpsPicListener, long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1584722392")) {
            ipChange.ipc$dispatch("-1584722392", new Object[]{this, locateGpsPicListener, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        this.i = j;
        startLocation(locateGpsPicListener, j2);
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationWithNoCache(@NotNull LocateMapListener locateMapListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1316717489")) {
            ipChange.ipc$dispatch("1316717489", new Object[]{this, locateMapListener});
            return;
        }
        b41.i(locateMapListener, "locateMapListener");
        if (this.a == null) {
            LocationDataStatus locationDataStatus = LocationDataStatus.NOTINIT;
            locateMapListener.onMapLocationFailed(locationDataStatus.getCode(), locationDataStatus.getDes());
            return;
        }
        if (this.c == null) {
            try {
                q();
            } catch (Exception e) {
                locateMapListener.onMapLocationFailed(LocationDataStatus.UNKNOW.getCode(), e.getMessage());
            }
        }
        this.g = locateMapListener;
        AMapLocationClient aMapLocationClient = this.c;
        if (aMapLocationClient != null) {
            aMapLocationClient.startLocation();
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863136710")) {
            ipChange.ipc$dispatch("1863136710", new Object[]{this});
        } else {
            n();
        }
    }

    public void t(@Nullable ga1 ga1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "840908806")) {
            ipChange.ipc$dispatch("840908806", new Object[]{this, ga1Var});
        } else {
            this.d = ga1Var;
        }
    }

    public final void u(@Nullable GetLocationInfoInterface getLocationInfoInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892596771")) {
            ipChange.ipc$dispatch("-1892596771", new Object[]{this, getLocationInfoInterface});
        } else {
            this.l = getLocationInfoInterface;
        }
    }

    public final void v(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-298431353")) {
            ipChange.ipc$dispatch("-298431353", new Object[]{this, Long.valueOf(j)});
        } else {
            this.h = j;
        }
    }

    public final void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1105295442")) {
            ipChange.ipc$dispatch("-1105295442", new Object[]{this});
            return;
        }
        if (m) {
            Log.d("Locate_AmapImpl", "start location server");
        }
        if (x()) {
            return;
        }
        if (this.c == null) {
            q();
        }
        AMapLocationClient aMapLocationClient = this.c;
        if (aMapLocationClient != null) {
            aMapLocationClient.startLocation();
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocation(@Nullable LocateGpsPicListener locateGpsPicListener, long j) {
        LocateQueueManager locateQueueManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086327618")) {
            ipChange.ipc$dispatch("1086327618", new Object[]{this, locateGpsPicListener, Long.valueOf(j)});
        } else if (this.a == null) {
            if (locateGpsPicListener != null) {
                LocationDataStatus locationDataStatus = LocationDataStatus.NOTINIT;
                locateGpsPicListener.onFailed(locationDataStatus.getCode(), locationDataStatus.getDes());
            }
        } else if (vc.Companion.a(ia1.INSTANCE.a())) {
            if (locateGpsPicListener != null) {
                LocationDataStatus locationDataStatus2 = LocationDataStatus.BLACKLIST;
                locateGpsPicListener.onFailed(locationDataStatus2.getCode(), locationDataStatus2.getDes());
            }
        } else {
            if (locateGpsPicListener != null && (locateQueueManager = this.b) != null) {
                locateQueueManager.h(locateGpsPicListener, j);
            }
            if (this.e == null) {
                try {
                    p();
                } catch (AMapException unused) {
                    if (locateGpsPicListener != null) {
                        LocationDataStatus locationDataStatus3 = LocationDataStatus.NOTAGREEPRIVACY;
                        locateGpsPicListener.onFailed(locationDataStatus3.getCode(), locationDataStatus3.getDes());
                        return;
                    }
                    return;
                }
            }
            w();
        }
    }

    @Override // com.alibaba.pictures.piclocation.LocationInterface
    public void startLocationRegion(@Nullable LocateRegionPicListener locateRegionPicListener, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1667197568")) {
            ipChange.ipc$dispatch("1667197568", new Object[]{this, locateRegionPicListener, Long.valueOf(j)});
        } else if (this.a == null) {
            if (locateRegionPicListener != null) {
                LocationDataStatus locationDataStatus = LocationDataStatus.NOTINIT;
                locateRegionPicListener.onFailed(locationDataStatus.getCode(), locationDataStatus.getDes());
            }
        } else if (locateRegionPicListener == null) {
        } else {
            if (vc.Companion.a(ia1.INSTANCE.a())) {
                LocationDataStatus locationDataStatus2 = LocationDataStatus.BLACKLIST;
                locateRegionPicListener.onFailed(locationDataStatus2.getCode(), locationDataStatus2.getDes());
                return;
            }
            LocateQueueManager locateQueueManager = this.b;
            if (locateQueueManager != null) {
                locateQueueManager.i(locateRegionPicListener, j);
            }
            w();
        }
    }

    public /* synthetic */ z4(Context context, k50 k50Var) {
        this(context);
    }
}
