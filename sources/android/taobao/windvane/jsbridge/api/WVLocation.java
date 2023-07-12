package android.taobao.windvane.jsbridge.api;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.youku.live.dago.liveplayback.widget.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVLocation extends WVApiPlugin implements LocationListener, Handler.Callback {
    private static final int GPS_TIMEOUT = 15000;
    private static final String TAG = "WVLocation";
    private Handler mHandler;
    private int MIN_TIME = 20000;
    private int MIN_DISTANCE = 30;
    private ArrayList<WVCallBackContext> mCallbacks = new ArrayList<>();
    private boolean getLocationSuccess = false;
    private boolean enableAddress = false;
    private LocationManager locationManager = null;

    public WVLocation() {
        this.mHandler = null;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Address getAddress(double d, double d2) {
        try {
            List<Address> fromLocation = new Geocoder(this.mContext).getFromLocation(d, d2, 1);
            if (fromLocation == null || fromLocation.size() <= 0) {
                return null;
            }
            return fromLocation.get(0);
        } catch (Exception e) {
            TaoLog.e("WVLocation", "getAddress: getFromLocation error. " + e.getMessage());
            return null;
        }
    }

    private void registerLocation(boolean z) {
        if (this.locationManager == null) {
            this.locationManager = (LocationManager) this.mContext.getSystemService("location");
        }
        try {
            this.getLocationSuccess = false;
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.locationManager, "network", this.MIN_TIME, this.MIN_DISTANCE, this);
            com.alibaba.wireless.security.aopsdk.replace.android.location.LocationManager.requestLocationUpdates(this.locationManager, GeocodeSearch.GPS, this.MIN_TIME, this.MIN_DISTANCE, this);
            if (TaoLog.getLogStatus()) {
                TaoLog.d("WVLocation", " registerLocation start provider GPS and NETWORK");
            }
        } catch (Exception e) {
            TaoLog.e("WVLocation", "registerLocation error: " + e.getMessage());
        }
    }

    private void wrapResult(final Location location) {
        ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
        if (arrayList == null || arrayList.isEmpty()) {
            TaoLog.d("WVLocation", "GetLocation wrapResult callbackContext is null");
        } else if (location == null) {
            TaoLog.w("WVLocation", "getLocation: location is null");
            Iterator<WVCallBackContext> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().error(new WVResult());
            }
            this.mCallbacks.clear();
        } else {
            AsyncTask.execute(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVLocation.4
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    JSONObject jSONObject = new JSONObject();
                    double longitude = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location);
                    double latitude = com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location);
                    try {
                        jSONObject.put("longitude", longitude);
                        jSONObject.put("latitude", latitude);
                        jSONObject.put("altitude", com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getAltitude(location));
                        jSONObject.put("accuracy", location.getAccuracy());
                        jSONObject.put("heading", location.getBearing());
                        jSONObject.put("speed", location.getSpeed());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    wVResult.addData(ILocatable.COORDS, jSONObject);
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d("WVLocation", " getLocation success. latitude: " + latitude + "; longitude: " + longitude);
                    }
                    if (WVLocation.this.enableAddress) {
                        Address address = WVLocation.this.getAddress(latitude, longitude);
                        JSONObject jSONObject2 = new JSONObject();
                        if (address != null) {
                            try {
                                jSONObject2.put(DistrictSearchQuery.KEYWORDS_COUNTRY, address.getCountryName());
                                jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, address.getAdminArea());
                                jSONObject2.put("city", address.getLocality());
                                jSONObject2.put("cityCode", address.getPostalCode());
                                jSONObject2.put(Constants.ACTION_PARAMS_AREA, address.getSubLocality());
                                jSONObject2.put("road", address.getThoroughfare());
                                StringBuilder sb = new StringBuilder();
                                for (int i = 1; i <= 2; i++) {
                                    if (!TextUtils.isEmpty(address.getAddressLine(i))) {
                                        sb.append(address.getAddressLine(i));
                                    }
                                }
                                jSONObject2.put("addressLine", sb.toString());
                                if (TaoLog.getLogStatus()) {
                                    TaoLog.d("WVLocation", " getAddress success. " + address.getAddressLine(0));
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        } else if (TaoLog.getLogStatus()) {
                            TaoLog.w("WVLocation", " getAddress fail. ");
                        }
                        wVResult.addData(ILocatable.ADDRESS, jSONObject2);
                    }
                    try {
                        Iterator it2 = WVLocation.this.mCallbacks.iterator();
                        while (it2.hasNext()) {
                            ((WVCallBackContext) it2.next()).success(wVResult);
                        }
                        WVLocation.this.mCallbacks.clear();
                        if (TaoLog.getLogStatus()) {
                            TaoLog.d("WVLocation", "callback success. retString: " + wVResult.toJsonString());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("getLocation".equals(str)) {
            getLocation(wVCallBackContext, str2);
            return true;
        }
        return false;
    }

    public synchronized void getLocation(final WVCallBackContext wVCallBackContext, final String str) {
        try {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVLocation.2
                @Override // java.lang.Runnable
                public void run() {
                    WVLocation.this.requestLocation(wVCallBackContext, str);
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVLocation.1
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("msg", "no permission");
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
        } catch (Exception unused) {
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this);
                ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
                if (arrayList != null && !arrayList.isEmpty()) {
                    if (!this.getLocationSuccess) {
                        Iterator<WVCallBackContext> it = this.mCallbacks.iterator();
                        while (it.hasNext()) {
                            it.next().error(new WVResult());
                        }
                        this.mCallbacks.clear();
                    }
                }
                TaoLog.d("WVLocation", "GetLocation wrapResult callbackContext is null");
                return false;
            } catch (Exception e) {
                TaoLog.e("WVLocation", "GetLocation timeout" + e.getMessage());
                Iterator<WVCallBackContext> it2 = this.mCallbacks.iterator();
                while (it2.hasNext()) {
                    it2.next().error(new WVResult());
                }
                this.mCallbacks.clear();
            }
        }
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            if (!this.getLocationSuccess) {
                try {
                    locationManager.removeUpdates(this);
                } catch (Exception unused) {
                }
            }
            this.locationManager = null;
        }
        ArrayList<WVCallBackContext> arrayList = this.mCallbacks;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onLocationChanged. ");
        }
        if (this.locationManager == null) {
            return;
        }
        wrapResult(location);
        this.locationManager.removeUpdates(this);
        this.getLocationSuccess = true;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onProviderDisabled. provider: " + str);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onProviderEnabled. provider: " + str);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVLocation", " onStatusChanged. provider: " + str + ";status: " + i);
        }
    }

    public void requestLocation(WVCallBackContext wVCallBackContext, String str) {
        boolean optBoolean;
        if (TextUtils.isEmpty(str)) {
            optBoolean = false;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                optBoolean = jSONObject.optBoolean("enableHighAcuracy");
                this.enableAddress = jSONObject.optBoolean(ILocatable.ADDRESS);
            } catch (JSONException unused) {
                TaoLog.e("WVLocation", "getLocation: param parse to JSON error, param=" + str);
                WVResult wVResult = new WVResult();
                wVResult.setResult("HY_PARAM_ERR");
                wVCallBackContext.error(wVResult);
                return;
            }
        }
        if (this.mCallbacks == null) {
            this.mCallbacks = new ArrayList<>();
        }
        this.mCallbacks.add(wVCallBackContext);
        registerLocation(optBoolean);
        WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVLocation.3
            @Override // java.lang.Runnable
            public void run() {
                WVLocation.this.mHandler.sendEmptyMessageDelayed(1, 15000L);
            }
        });
    }
}
