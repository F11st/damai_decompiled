package cn.damai.ticklet.ui.activity;

import android.os.Bundle;
import cn.damai.common.app.base.AbstractC0470a;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.askpermission.OnGrantListener;
import com.alibaba.pictures.piclocation.listener.LocateMapListener;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ia1;
import tb.ir1;
import tb.mr1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class DamaiMapBaseActivity<T extends AbstractC0470a, E extends BaseModel> extends TickletBaseActivity<T, E> implements LocationSource, LocateMapListener, AMap.OnMarkerClickListener, AMap.OnMapClickListener, AMap.OnCameraChangeListener {
    private static transient /* synthetic */ IpChange $ipChange;
    public AMap aMap;
    public LocationSource.OnLocationChangedListener mListener = null;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.activity.DamaiMapBaseActivity$a */
    /* loaded from: classes7.dex */
    public class C2014a implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2014a() {
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1702037327")) {
                ipChange.ipc$dispatch("1702037327", new Object[]{this});
            } else {
                ia1.INSTANCE.c().startLocationWithNoCache(DamaiMapBaseActivity.this);
            }
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164201967")) {
            ipChange.ipc$dispatch("-164201967", new Object[]{this, onLocationChangedListener});
            return;
        }
        this.mListener = onLocationChangedListener;
        ia1.INSTANCE.c().startLocationWithNoCache(this);
    }

    @Override // com.amap.api.maps.LocationSource
    public void deactivate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-307808322")) {
            ipChange.ipc$dispatch("-307808322", new Object[]{this});
            return;
        }
        this.mListener = null;
        ia1.INSTANCE.c().stop();
    }

    public void initLoc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101266194")) {
            ipChange.ipc$dispatch("1101266194", new Object[]{this, str});
        } else {
            ir1.b(this, false, mr1.LOCATION, str, new C2014a());
        }
    }

    public abstract void initMap(Bundle bundle);

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChange(CameraPosition cameraPosition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471973508")) {
            ipChange.ipc$dispatch("-471973508", new Object[]{this, cameraPosition});
        }
    }

    @Override // com.amap.api.maps.AMap.OnCameraChangeListener
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465996247")) {
            ipChange.ipc$dispatch("-1465996247", new Object[]{this, cameraPosition});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1702059293")) {
            ipChange.ipc$dispatch("1702059293", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        initMap(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019587683")) {
            ipChange.ipc$dispatch("-1019587683", new Object[]{this});
            return;
        }
        super.onDestroy();
        AMap aMap = this.aMap;
        if (aMap != null) {
            aMap.clear();
            this.aMap.setOnMapLoadedListener(null);
            this.aMap.setOnMapLongClickListener(null);
            this.aMap.setOnMarkerClickListener(null);
            this.aMap.setInfoWindowAdapter(null);
            this.aMap.setOnInfoWindowClickListener(null);
            this.aMap.setOnMapClickListener(null);
            this.aMap = null;
        }
        ia1.INSTANCE.c().stop();
    }

    @Override // com.amap.api.maps.AMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246672851")) {
            ipChange.ipc$dispatch("-1246672851", new Object[]{this, latLng});
        }
    }

    @Override // com.alibaba.pictures.piclocation.listener.LocateMapListener
    public void onMapLocationFailed(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-172271708")) {
            ipChange.ipc$dispatch("-172271708", new Object[]{this, Integer.valueOf(i), str});
        }
    }

    @Override // com.alibaba.pictures.piclocation.listener.LocateMapListener
    public void onMapLocationSuccess(AMapLocation aMapLocation) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595127969")) {
            ipChange.ipc$dispatch("595127969", new Object[]{this, aMapLocation});
        } else if (this.mListener == null || aMapLocation == null || aMapLocation.getErrorCode() != 0) {
        } else {
            this.mListener.onLocationChanged(aMapLocation);
            this.aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude()), 13.0f));
        }
    }

    @Override // com.amap.api.maps.AMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101886175")) {
            return ((Boolean) ipChange.ipc$dispatch("101886175", new Object[]{this, marker})).booleanValue();
        }
        return false;
    }
}
