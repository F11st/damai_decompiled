package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.autonavi.amap.mapcore.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore.Inner_3dMap_locationOption;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class as implements LocationSource, Inner_3dMap_locationListener {
    private LocationSource.OnLocationChangedListener d;
    private fi e;
    private Inner_3dMap_locationOption f;
    private Context g;
    private Bundle c = null;
    boolean a = false;
    long b = 2000;

    public as(Context context) {
        this.g = context;
    }

    public void a(long j) {
        Inner_3dMap_locationOption inner_3dMap_locationOption = this.f;
        if (inner_3dMap_locationOption != null && this.e != null && inner_3dMap_locationOption.getInterval() != j) {
            this.f.setInterval(j);
            this.e.a(this.f);
        }
        this.b = j;
    }

    @Override // com.amap.api.maps.LocationSource
    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.d = onLocationChangedListener;
        if (this.e == null) {
            this.e = new fi(this.g);
            this.f = new Inner_3dMap_locationOption();
            this.e.a(this);
            this.f.setInterval(this.b);
            this.f.setOnceLocation(this.a);
            this.f.setLocationMode(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy);
            this.e.a(this.f);
            this.e.a();
        }
    }

    @Override // com.amap.api.maps.LocationSource
    public void deactivate() {
        this.d = null;
        fi fiVar = this.e;
        if (fiVar != null) {
            fiVar.b();
            this.e.c();
        }
        this.e = null;
    }

    @Override // com.autonavi.amap.mapcore.Inner_3dMap_locationListener
    public void onLocationChanged(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (this.d == null || inner_3dMap_location == null) {
                return;
            }
            Bundle extras = inner_3dMap_location.getExtras();
            this.c = extras;
            if (extras == null) {
                this.c = new Bundle();
            }
            this.c.putInt("errorCode", inner_3dMap_location.getErrorCode());
            this.c.putString(MyLocationStyle.ERROR_INFO, inner_3dMap_location.getErrorInfo());
            this.c.putInt(MyLocationStyle.LOCATION_TYPE, inner_3dMap_location.getLocationType());
            this.c.putFloat("Accuracy", inner_3dMap_location.getAccuracy());
            this.c.putString("AdCode", inner_3dMap_location.getAdCode());
            this.c.putString("Address", inner_3dMap_location.getAddress());
            this.c.putString("AoiName", inner_3dMap_location.getAoiName());
            this.c.putString("City", inner_3dMap_location.getCity());
            this.c.putString("CityCode", inner_3dMap_location.getCityCode());
            this.c.putString("Country", inner_3dMap_location.getCountry());
            this.c.putString("District", inner_3dMap_location.getDistrict());
            this.c.putString("Street", inner_3dMap_location.getStreet());
            this.c.putString("StreetNum", inner_3dMap_location.getStreetNum());
            this.c.putString("PoiName", inner_3dMap_location.getPoiName());
            this.c.putString("Province", inner_3dMap_location.getProvince());
            this.c.putFloat("Speed", inner_3dMap_location.getSpeed());
            this.c.putString("Floor", inner_3dMap_location.getFloor());
            this.c.putFloat("Bearing", inner_3dMap_location.getBearing());
            this.c.putString("BuildingId", inner_3dMap_location.getBuildingId());
            this.c.putDouble("Altitude", inner_3dMap_location.getAltitude());
            inner_3dMap_location.setExtras(this.c);
            this.d.onLocationChanged(inner_3dMap_location);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i) {
        if (i != 1 && i != 0) {
            a(false);
        } else {
            a(true);
        }
    }

    private void a(boolean z) {
        fi fiVar;
        if (this.f != null && (fiVar = this.e) != null) {
            fiVar.c();
            fi fiVar2 = new fi(this.g);
            this.e = fiVar2;
            fiVar2.a(this);
            this.f.setOnceLocation(z);
            if (!z) {
                this.f.setInterval(this.b);
            }
            this.e.a(this.f);
            this.e.a();
        }
        this.a = z;
    }
}
