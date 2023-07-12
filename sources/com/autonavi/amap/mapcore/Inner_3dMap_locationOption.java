package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.jy;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Inner_3dMap_locationOption implements Cloneable {
    private static Inner_3dMap_Enum_LocationProtocol locationProtocol = Inner_3dMap_Enum_LocationProtocol.HTTP;
    static String APIKEY = "";
    private long interval = 2000;
    private long httpTimeOut = jy.g;
    private boolean isOnceLocation = false;
    private boolean isMockEnable = false;
    private boolean isNeedAddress = true;
    private boolean isWifiActiveScan = true;
    private boolean lastWifiActiveScan = true;
    private Inner_3dMap_Enum_LocationMode locationMode = Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    private boolean isKillProcess = false;
    private boolean isGpsFirst = false;
    private boolean isOffset = true;
    private boolean isLocationCacheEnable = true;
    private boolean isOnceLocationLatest = false;
    private boolean sensorEnable = false;
    private boolean isWifiScan = true;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Inner_3dMap_Enum_LocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum Inner_3dMap_Enum_LocationProtocol {
        HTTP(0),
        HTTPS(1);
        
        private int value;

        Inner_3dMap_Enum_LocationProtocol(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private Inner_3dMap_locationOption clone(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.interval = inner_3dMap_locationOption.interval;
        this.isOnceLocation = inner_3dMap_locationOption.isOnceLocation;
        this.locationMode = inner_3dMap_locationOption.locationMode;
        this.isMockEnable = inner_3dMap_locationOption.isMockEnable;
        this.isKillProcess = inner_3dMap_locationOption.isKillProcess;
        this.isGpsFirst = inner_3dMap_locationOption.isGpsFirst;
        this.isNeedAddress = inner_3dMap_locationOption.isNeedAddress;
        this.isWifiActiveScan = inner_3dMap_locationOption.isWifiActiveScan;
        this.httpTimeOut = inner_3dMap_locationOption.httpTimeOut;
        this.isOffset = inner_3dMap_locationOption.isOffset;
        this.isLocationCacheEnable = inner_3dMap_locationOption.isLocationCacheEnable;
        this.isOnceLocationLatest = inner_3dMap_locationOption.isOnceLocationLatest;
        this.sensorEnable = inner_3dMap_locationOption.isSensorEnable();
        this.isWifiScan = inner_3dMap_locationOption.isWifiScan();
        return this;
    }

    public static String getAPIKEY() {
        return APIKEY;
    }

    public static void setLocationProtocol(Inner_3dMap_Enum_LocationProtocol inner_3dMap_Enum_LocationProtocol) {
        locationProtocol = inner_3dMap_Enum_LocationProtocol;
    }

    /* renamed from: clone */
    public Inner_3dMap_locationOption m241clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new Inner_3dMap_locationOption().clone(this);
    }

    public long getHttpTimeOut() {
        return this.httpTimeOut;
    }

    public long getInterval() {
        return this.interval;
    }

    public Inner_3dMap_Enum_LocationMode getLocationMode() {
        return this.locationMode;
    }

    public Inner_3dMap_Enum_LocationProtocol getLocationProtocol() {
        return locationProtocol;
    }

    public boolean isGpsFirst() {
        return this.isGpsFirst;
    }

    public boolean isKillProcess() {
        return this.isKillProcess;
    }

    public boolean isLocationCacheEnable() {
        return this.isLocationCacheEnable;
    }

    public boolean isMockEnable() {
        return this.isMockEnable;
    }

    public boolean isNeedAddress() {
        return this.isNeedAddress;
    }

    public boolean isOffset() {
        return this.isOffset;
    }

    public boolean isOnceLocation() {
        if (this.isOnceLocationLatest) {
            return true;
        }
        return this.isOnceLocation;
    }

    public boolean isOnceLocationLatest() {
        return this.isOnceLocationLatest;
    }

    public boolean isSensorEnable() {
        return this.sensorEnable;
    }

    public boolean isWifiActiveScan() {
        return this.isWifiActiveScan;
    }

    public boolean isWifiScan() {
        return this.isWifiScan;
    }

    public Inner_3dMap_locationOption setGpsFirst(boolean z) {
        this.isGpsFirst = z;
        return this;
    }

    public void setHttpTimeOut(long j) {
        this.httpTimeOut = j;
    }

    public Inner_3dMap_locationOption setInterval(long j) {
        if (j <= 800) {
            j = 800;
        }
        this.interval = j;
        return this;
    }

    public Inner_3dMap_locationOption setKillProcess(boolean z) {
        this.isKillProcess = z;
        return this;
    }

    public void setLocationCacheEnable(boolean z) {
        this.isLocationCacheEnable = z;
    }

    public Inner_3dMap_locationOption setLocationMode(Inner_3dMap_Enum_LocationMode inner_3dMap_Enum_LocationMode) {
        this.locationMode = inner_3dMap_Enum_LocationMode;
        return this;
    }

    public void setMockEnable(boolean z) {
        this.isMockEnable = z;
    }

    public Inner_3dMap_locationOption setNeedAddress(boolean z) {
        this.isNeedAddress = z;
        return this;
    }

    public Inner_3dMap_locationOption setOffset(boolean z) {
        this.isOffset = z;
        return this;
    }

    public Inner_3dMap_locationOption setOnceLocation(boolean z) {
        this.isOnceLocation = z;
        return this;
    }

    public void setOnceLocationLatest(boolean z) {
        this.isOnceLocationLatest = z;
    }

    public void setSensorEnable(boolean z) {
        this.sensorEnable = z;
    }

    public void setWifiActiveScan(boolean z) {
        this.isWifiActiveScan = z;
        this.lastWifiActiveScan = z;
    }

    public void setWifiScan(boolean z) {
        this.isWifiScan = z;
        this.isWifiActiveScan = z ? this.lastWifiActiveScan : false;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.interval) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isOnceLocation:" + String.valueOf(this.isOnceLocation) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "locationMode:" + String.valueOf(this.locationMode) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isMockEnable:" + String.valueOf(this.isMockEnable) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isKillProcess:" + String.valueOf(this.isKillProcess) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isGpsFirst:" + String.valueOf(this.isGpsFirst) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isNeedAddress:" + String.valueOf(this.isNeedAddress) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isWifiActiveScan:" + String.valueOf(this.isWifiActiveScan) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "httpTimeOut:" + String.valueOf(this.httpTimeOut) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isOffset:" + String.valueOf(this.isOffset) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isLocationCacheEnable:" + String.valueOf(this.isLocationCacheEnable) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isLocationCacheEnable:" + String.valueOf(this.isLocationCacheEnable) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "isOnceLocationLatest:" + String.valueOf(this.isOnceLocationLatest) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + "sensorEnable:" + String.valueOf(this.sensorEnable) + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
    }
}
