package com.youku.appalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.TLogInitializer;
import com.taobao.tao.log.upload.FileUploadListener;
import com.taobao.tao.log.upload.LogFileUploadManager;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.HashMap;
import tb.h23;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AppAlarmManager {
    private static AppAlarmManager sAppAlarm;
    private long lastTime;
    private Context mContext;
    private boolean mHasRegistered = false;
    private boolean mHasregisterdConnectivity = false;
    private boolean isConnected = true;
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: com.youku.appalarm.AppAlarmManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo3 = (NetworkInfo) intent.getExtras().get("networkInfo");
            if (networkInfo3 != null) {
                if (networkInfo3.isConnected()) {
                    AppAlarmManager.this.isConnected = true;
                } else if (networkInfo.isConnected() || networkInfo2.isConnected()) {
                } else {
                    AppAlarmManager.this.isConnected = false;
                }
            }
        }
    };

    private AppAlarmManager() {
    }

    private void checkNetworkInfo() {
        NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo((ConnectivityManager) this.mContext.getSystemService("connectivity"));
        this.isConnected = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static AppAlarmManager getInstance() {
        if (sAppAlarm == null) {
            synchronized (AppAlarmManager.class) {
                if (sAppAlarm == null) {
                    AppAlarmManager appAlarmManager = new AppAlarmManager();
                    sAppAlarm = appAlarmManager;
                    appAlarmManager.mContext = TLogInitializer.getInstance().getContext();
                }
            }
        }
        return sAppAlarm;
    }

    private void registerConnectivity() {
        if (this.mHasregisterdConnectivity) {
            return;
        }
        this.mHasregisterdConnectivity = true;
        this.mContext.registerReceiver(this.mBroadcastReceiver, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        checkNetworkInfo();
    }

    private void registerModule() {
        if (!this.mHasRegistered) {
            this.mHasRegistered = true;
            DimensionSet create = DimensionSet.create();
            create.addDimension("bizType");
            create.addDimension("pageName");
            create.addDimension(h23.PAGE_SPM_DIMEN);
            create.addDimension("clickSpm");
            create.addDimension("reqData");
            create.addDimension("respData");
            create.addDimension("serviceCode");
            create.addDimension("serviceMsg");
            create.addDimension("clientCode");
            create.addDimension("clientMsg");
            create.addDimension("needAlarm");
            create.addDimension("bizData");
            AppMonitor.register("YoukuAppAlarm", NotificationCompat.CATEGORY_ALARM, (MeasureSet) null, create, false);
        }
        registerConnectivity();
    }

    private void vipTlogProcess() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis - this.lastTime > 900) {
            this.lastTime = currentTimeMillis;
            if (AppAlarmOrangeConfig.getInstance().isVIPMainSwitchOn()) {
                if (this.mContext == null) {
                    this.mContext = TLogInitializer.getInstance().getContext();
                }
                LogFileUploadManager logFileUploadManager = new LogFileUploadManager(this.mContext);
                HashMap hashMap = new HashMap();
                hashMap.put("title", "优酷预警体系");
                hashMap.put("content", "优酷预警体系");
                hashMap.put("feedbackID", "YoukuAppAlarm");
                logFileUploadManager.uploadWithFilePrefix("FEEDBACK", "youku_appalarm_feedback", hashMap, new FileUploadListener() { // from class: com.youku.appalarm.AppAlarmManager.2
                    @Override // com.taobao.tao.log.upload.FileUploadListener
                    public void onError(String str, String str2, String str3) {
                        Log.e("YoukuAppAlarm", "YoukuAppAlarm uploadWithFilePrefix failure! " + str2 + " msg:" + str3);
                    }

                    @Override // com.taobao.tao.log.upload.FileUploadListener
                    public void onSucessed(String str, String str2) {
                    }
                });
            }
        }
    }

    public void alarm(String str, String str2, String str3) {
        registerModule();
        if (this.isConnected && !AppAlarmOrangeConfig.getInstance().isMatchBlackListBiztype(str)) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("bizType", str);
            create.setValue("clientCode", str2);
            create.setValue("clientMsg", str3);
            create.setValue("needAlarm", "true");
            AppMonitor.Stat.commit("YoukuAppAlarm", NotificationCompat.CATEGORY_ALARM, create, (MeasureValueSet) null);
            vipTlogProcess();
        }
    }

    public void alarm(String str, String str2, String str3, String str4) {
        registerModule();
        if (this.isConnected && !AppAlarmOrangeConfig.getInstance().isMatchBlackListBiztype(str)) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("bizType", str);
            create.setValue("clientCode", str2);
            create.setValue("clientMsg", str3);
            create.setValue("needAlarm", "true");
            create.setValue("bizData", str4);
            AppMonitor.Stat.commit("YoukuAppAlarm", NotificationCompat.CATEGORY_ALARM, create, (MeasureValueSet) null);
            vipTlogProcess();
        }
    }

    public void alarm(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        registerModule();
        if (this.isConnected && !AppAlarmOrangeConfig.getInstance().isMatchBlackListBiztype(str)) {
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("bizType", str);
            create.setValue("pageName", str4);
            create.setValue(h23.PAGE_SPM_DIMEN, str5);
            create.setValue("clickSpm", str6);
            create.setValue("reqData", str7);
            create.setValue("respData", str8);
            create.setValue("serviceCode", str9);
            create.setValue("serviceMsg", str10);
            create.setValue("clientCode", str2);
            create.setValue("clientMsg", str3);
            create.setValue("needAlarm", "true");
            create.setValue("bizData", str11);
            AppMonitor.Stat.commit("YoukuAppAlarm", NotificationCompat.CATEGORY_ALARM, create, (MeasureValueSet) null);
            vipTlogProcess();
        }
    }
}
