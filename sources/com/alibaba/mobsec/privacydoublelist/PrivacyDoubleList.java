package com.alibaba.mobsec.privacydoublelist;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.config.ConfigCenter;
import com.alibaba.mobsec.privacydoublelist.e.C3438e;
import com.alibaba.mobsec.privacydoublelist.report.PrivacyDoubleListReporter;
import com.alibaba.wireless.security.aopsdk.AopEntry;
import com.alibaba.wireless.security.aopsdk.AopManager;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class PrivacyDoubleList {
    public static PrivacyDoubleList b;
    public static ScheduledFuture<?> c;
    public final ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryC3418a(this));

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class Fields {
        public static final String Build_VERSION_getRELEASE = "android.os.Build$VERSION.getRELEASE";
        public static final String Build_VERSION_getRELEASE_OR_CODENAME = "android.os.Build$VERSION.getRELEASE_OR_CODENAME";
        public static final String Build_getBRAND = "android.os.Build.getBRAND";
        public static final String Build_getCPU_ABI = "android.os.Build.getCPU_ABI";
        public static final String Build_getMANUFACTURER = "android.os.Build.getMANUFACTURER";
        public static final String Build_getMODEL = "android.os.Build.getMODEL";
        public static final String Build_getPRODUCT = "android.os.Build.getPRODUCT";
        public static final String Build_getSERIAL = "android.os.Build.getSERIAL";
        public static final String DisplayMetrics_getheightPixels = "android.util.DisplayMetrics.getheightPixels";
        public static final String DisplayMetrics_getwidthPixels = "android.util.DisplayMetrics.getwidthPixels";
        public static final String Point_getx = "android.graphics.Point.getx";
        public static final String Point_gety = "android.graphics.Point.gety";
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class InitConfig {
        public boolean a = true;
        public boolean b = false;
        public boolean c = true;

        /* compiled from: Taobao */
        /* loaded from: classes6.dex */
        public static class Builder {
            public InitConfig a;

            public Builder() {
                InitConfig initConfig = new InitConfig();
                this.a = initConfig;
                initConfig.a = true;
                this.a.c = true;
                this.a.b = false;
            }

            public InitConfig build() {
                return this.a;
            }

            public void initAop(boolean z) {
                this.a.c = z;
            }

            public void setDebug(boolean z) {
                this.a.b = z;
            }

            public void setFetchConfig(boolean z) {
                this.a.a = z;
            }
        }

        public boolean fetchConfig() {
            return this.a;
        }

        public boolean initAop() {
            return this.c;
        }

        public boolean isDebug() {
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class Methods {
        public static final String ASUS_GetOAID = "com.asus.msa.SupplementaryDID.IDidAidlInterface.getOAID()";
        public static final String AdvertisingIdClient_getAdvertisingIdInfo_Context = "com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(android.content.Context)";
        public static final String ApplicationPackageManager_getInstalledApplications_int = "android.app.ApplicationPackageManager.getInstalledApplications(int)";
        public static final String ApplicationPackageManager_getInstalledPackages_int = "android.app.ApplicationPackageManager.getInstalledPackages(int)";
        public static final String BluetoothAdapter_getAddress = "android.bluetooth.BluetoothAdapter.getAddress()";
        public static final String Build_getSerial = "android.os.Build.getSerial()";
        public static final String ClipboardManager_getPrimaryClip = "android.content.ClipboardManager.getPrimaryClip()";
        public static final String CoolPad_GetOAID = "com.coolpad.deviceidsupport.IDeviceIdManager.getOAID(java.lang.String)";
        public static final String Display_getMetrics_DisplayMetrics = "android.view.Display.getMetrics(android.util.DisplayMetrics)";
        public static final String Display_getRealMetrics_DisplayMetrics = "android.view.Display.getRealMetrics(android.util.DisplayMetrics)";
        public static final String Display_getRealSize_Point = "android.view.Display.getRealSize(android.graphics.Point)";
        public static final String Display_getSize_Point = "android.view.Display.getSize(android.graphics.Point)";
        public static final String HEYTAP_GetOAID = "com.heytap.openid.sdk.OpenIDSDK.getOAID(android.content.Context)";
        public static final String HUAWEI_GetOAID = "com.huawei.hms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(android.content.Context)";
        public static final String IdSupplier_GetOAID = "com.bun.miitmdid.interfaces.IdSupplier.getOAID()";
        public static final String LocationManager_getCurrentLocation_String_CancellationSignal_Executor_Consumer = "android.location.LocationManager.getCurrentLocation(java.lang.String,android.os.CancellationSignal,java.util.concurrent.Executor,java.util.function.Consumer)";
        public static final String LocationManager_getCurrentLocation_String_LocationRequest_CancellationSignal_Executor_Consumer = "android.location.LocationManager.getCurrentLocation(java.lang.String,android.location.LocationRequest,android.os.CancellationSignal,java.util.concurrent.Executor,java.util.function.Consumer)";
        public static final String LocationManager_getLastKnownLocation_String = "android.location.LocationManager.getLastKnownLocation(java.lang.String)";
        public static final String LocationManager_requestLocationUpdates_String_LocationRequest_Executor_LocationListener = "android.location.LocationManager.requestLocationUpdates(java.lang.String,android.location.LocationRequest,java.util.concurrent.Executor,android.location.LocationListener)";
        public static final String LocationManager_requestLocationUpdates_String_LocationRequest_PendingIntent = "android.location.LocationManager.requestLocationUpdates(java.lang.String,android.location.LocationRequest,android.app.PendingIntent)";
        public static final String LocationManager_requestLocationUpdates_String_long_float_Executor_LocationListener = "android.location.LocationManager.requestLocationUpdates(java.lang.String,long,float,java.util.concurrent.Executor,android.location.LocationListener)";
        public static final String LocationManager_requestLocationUpdates_String_long_float_LocationListener = "android.location.LocationManager.requestLocationUpdates(java.lang.String,long,float,android.location.LocationListener)";
        public static final String LocationManager_requestLocationUpdates_String_long_float_LocationListener_Looper = "android.location.LocationManager.requestLocationUpdates(java.lang.String,long,float,android.location.LocationListener,android.os.Looper)";
        public static final String LocationManager_requestLocationUpdates_String_long_float_PendingIntent = "android.location.LocationManager.requestLocationUpdates(java.lang.String,long,float,android.app.PendingIntent)";
        public static final String LocationManager_requestLocationUpdates_long_float_Criteria_Executor_LocationListener = "android.location.LocationManager.requestLocationUpdates(long,float,android.location.Criteria,java.util.concurrent.Executor,android.location.LocationListener)";
        public static final String LocationManager_requestLocationUpdates_long_float_Criteria_LocationListener_Looper = "android.location.LocationManager.requestLocationUpdates(long,float,android.location.Criteria,android.location.LocationListener,android.os.Looper)";
        public static final String LocationManager_requestLocationUpdates_long_float_Criteria_PendingIntent = "android.location.LocationManager.requestLocationUpdates(long,float,android.location.Criteria,android.app.PendingIntent)";
        public static final String LocationManager_requestSingleUpdate_Criteria_LocationListener_Looper = "android.location.LocationManager.requestSingleUpdate(android.location.Criteria,android.location.LocationListener,android.os.Looper)";
        public static final String LocationManager_requestSingleUpdate_Criteria_PendingIntent = "android.location.LocationManager.requestSingleUpdate(android.location.Criteria,android.app.PendingIntent)";
        public static final String LocationManager_requestSingleUpdate_String_LocationListener_Looper = "android.location.LocationManager.requestSingleUpdate(java.lang.String,android.location.LocationListener,android.os.Looper)";
        public static final String LocationManager_requestSingleUpdate_String_PendingIntent = "android.location.LocationManager.requestSingleUpdate(java.lang.String,android.app.PendingIntent)";
        public static final String Location_getAltitude = "android.location.Location.getAltitude()";
        public static final String Location_getLatitude = "android.location.Location.getLatitude()";
        public static final String Location_getLongitude = "android.location.Location.getLongitude()";
        public static final String MEIZU_GetOAID = "com.meizu.flyme.openidsdk.OpenIdHelper.getOAID(android.content.Context)";
        public static final String NUBIA_GetOAID = "com.bun.miitmdid.provider.nubia.NubiaIdentityImpl.getOAID(android.content.Context)";
        public static final String NetworkInterface_getHardwareAddress = "java.net.NetworkInterface.getHardwareAddress()";
        public static final String PackageManager_getInstalledApplications_int = "android.content.pm.PackageManager.getInstalledApplications(int)";
        public static final String PackageManager_getInstalledPackages_int = "android.content.pm.PackageManager.getInstalledPackages(int)";
        public static final String SAMSUNG_GetOAID = "com.samsung.android.deviceidservice.IDeviceIdService.getOAID(java.lang.String)";
        public static final String SensorManager_getDefaultSensor_int = "android.hardware.SensorManager.getDefaultSensor(int)";
        public static final String SensorManager_getDefaultSensor_int_boolean = "android.hardware.SensorManager.getDefaultSensor(int,boolean)";
        public static final String Settings_Secure_getString_ContentResolver_String = "android.provider.Settings$Secure.getString(android.content.ContentResolver,java.lang.String)";
        public static final String SystemProperties_get_String = "android.os.SystemProperties.get(java.lang.String)";
        public static final String TelephonyManager_getAllCellInfo = "android.telephony.TelephonyManager.getAllCellInfo()";
        public static final String TelephonyManager_getCellLocation = "android.telephony.TelephonyManager.getCellLocation()";
        public static final String TelephonyManager_getDataNetworkType = "android.telephony.TelephonyManager.getDataNetworkType()";
        public static final String TelephonyManager_getDeviceId = "android.telephony.TelephonyManager.getDeviceId()";
        public static final String TelephonyManager_getDeviceId_int = "android.telephony.TelephonyManager.getDeviceId(int)";
        public static final String TelephonyManager_getImei = "android.telephony.TelephonyManager.getImei()";
        public static final String TelephonyManager_getImei_int = "android.telephony.TelephonyManager.getImei(int)";
        public static final String TelephonyManager_getMeid = "android.telephony.TelephonyManager.getMeid()";
        public static final String TelephonyManager_getMeid_int = "android.telephony.TelephonyManager.getMeid(int)";
        public static final String TelephonyManager_getNetworkType = "android.telephony.TelephonyManager.getNetworkType()";
        public static final String TelephonyManager_getSimOperator = "android.telephony.TelephonyManager.getSimOperator()";
        public static final String TelephonyManager_getSimOperatorName = "android.telephony.TelephonyManager.getSimOperatorName()";
        public static final String TelephonyManager_getSubscriberId = "android.telephony.TelephonyManager.getSubscriberId()";
        public static final String VIVO_GetOAID = "com.vivo.identifier.IdentifierIdClient.getOAID()";
        public static final String WifiInfo_getMacAddress = "android.net.wifi.WifiInfo.getMacAddress()";
        public static final String XIAOMI_GetOAID = "com.bun.miitmdid.provider.xiaomi.IdentifierManager.getOAID(android.content.Context)";
        public static final String ZUI_GetOAID = "com.zui.deviceidservice.IDeviceidInterface.getOAID()";
        public static final String content_ClipboardManager_getText = "android.content.ClipboardManager.getText()";
        public static final String text_ClipboardManager_getText = "android.text.ClipboardManager.getText()";
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList$a */
    /* loaded from: classes6.dex */
    public class ThreadFactoryC3418a implements ThreadFactory {
        public ThreadFactoryC3418a(PrivacyDoubleList privacyDoubleList) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("AliPrivacyReport");
            return thread;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList$b */
    /* loaded from: classes6.dex */
    public class RunnableC3419b implements Runnable {
        public RunnableC3419b(PrivacyDoubleList privacyDoubleList) {
        }

        @Override // java.lang.Runnable
        public void run() {
            PrivacyDoubleListReporter.getInstance().report();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.mobsec.privacydoublelist.PrivacyDoubleList$c */
    /* loaded from: classes6.dex */
    public class C3420c implements Application.ActivityLifecycleCallbacks {
        public C3420c(PrivacyDoubleList privacyDoubleList) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (PdlEnvUtils.a) {
                Log.d("DL-ACT", "onActivityDestroyed called");
            }
            PrivacyDoubleListReporter.getInstance().report();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static synchronized PrivacyDoubleList getInstance() {
        PrivacyDoubleList privacyDoubleList;
        synchronized (PrivacyDoubleList.class) {
            if (b == null) {
                b = new PrivacyDoubleList();
            }
            privacyDoubleList = b;
        }
        return privacyDoubleList;
    }

    public void cancelReportTimer() {
        if (PdlEnvUtils.a) {
            Log.d("PDL-CORE", "Cancel report timer");
        }
        if (c.isCancelled()) {
            return;
        }
        c.cancel(true);
    }

    public void disableAll() {
        cancelReportTimer();
        AopManager.getInstance().removeChainDelegate(C3421a.a());
    }

    public void enableAll() {
        startReportTimer();
        AopManager.getInstance().addChainDelegate(C3421a.a());
    }

    public void init(Context context) {
        InitConfig.Builder builder = new InitConfig.Builder();
        builder.initAop(false);
        builder.setDebug(false);
        builder.setFetchConfig(true);
        init(context, builder.build());
    }

    public void startReportTimer() {
        ScheduledFuture<?> scheduledFuture = c;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            if (PdlEnvUtils.a) {
                Log.d("PDL-CORE", "Start report timer with delay: " + PrivacyDoubleListReporter.getInstance().getReportDelay());
            }
            c = this.a.scheduleWithFixedDelay(new RunnableC3419b(this), PrivacyDoubleListReporter.getInstance().getReportInitDelay(), PrivacyDoubleListReporter.getInstance().getReportDelay(), TimeUnit.SECONDS);
        }
    }

    public void track(String str, Object obj) {
        C3438e.b().a(str, obj);
    }

    public void init(Context context, InitConfig initConfig) {
        Application application;
        if (initConfig.isDebug()) {
            PdlEnvUtils.a = true;
        }
        if (initConfig.initAop()) {
            AopEntry.init(context);
        }
        AopManager.getInstance().addChainDelegate(C3421a.a());
        if (initConfig.a) {
            ConfigCenter.getInstance().initConfig(context);
        }
        startReportTimer();
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            application = (Application) context.getApplicationContext();
        }
        if (application != null) {
            context = application;
        }
        PdlEnvUtils.e = context;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new C3420c(this));
        }
    }
}
