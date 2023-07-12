package com.ali.user.mobile.info;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.DataCallback;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.utils.FileUtil;
import com.ali.user.mobile.utils.NetworkUtil;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.taobao.weex.annotation.JSMethod;
import com.ut.device.UTDevice;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AppInfo {
    public static final String INITED_ACTION = "com.ali.user.sdk.biz.inited.action";
    private static AppInfo INSTANCE = null;
    public static final String SDCARD_UTDID = "deviceId";
    private static final String TAG = "login.AppInfo";
    private boolean isRoot = false;
    private String mAppVersion;
    private String mUmidToken;
    private String mUtdid;

    private AppInfo() {
    }

    private void generateUmidToken(final DataCallback<String> dataCallback) {
        int i = 0;
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ali.user.mobile.info.AppInfo.1
            @Override // java.lang.Runnable
            public void run() {
                DataCallback dataCallback2;
                if (!atomicBoolean.compareAndSet(false, true) || (dataCallback2 = dataCallback) == null) {
                    return;
                }
                dataCallback2.result(AppInfo.this.mUmidToken);
            }
        }, 2000L);
        int envType = DataProviderFactory.getDataProvider().getEnvType();
        if (envType == 0 || envType == 1 || (envType != 2 && envType != 3 && envType == 4)) {
            i = 2;
        }
        SecurityGuardManager securityGuardManager = SecurityGuardManagerWraper.getSecurityGuardManager();
        if (securityGuardManager != null) {
            IUMIDComponent uMIDComp = securityGuardManager.getUMIDComp();
            if (uMIDComp != null) {
                try {
                    uMIDComp.initUMID(i, new IUMIDInitListenerEx() { // from class: com.ali.user.mobile.info.AppInfo.2
                        @Override // com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx
                        public void onUMIDInitFinishedEx(String str, int i2) {
                            DataCallback dataCallback2;
                            if (i2 == 200) {
                                AppInfo.this.mUmidToken = str;
                            } else {
                                UserTrackAdapter.sendUT("initUMID_failure", i2 + "");
                            }
                            TLogAdapter.e(AppInfo.TAG, "resultCode=" + i2 + " onInitFinished umidToken = " + str);
                            if (!atomicBoolean.compareAndSet(false, true) || (dataCallback2 = dataCallback) == null) {
                                return;
                            }
                            dataCallback2.result(AppInfo.this.mUmidToken);
                        }
                    });
                } catch (SecException e) {
                    UserTrackAdapter.sendUT("initUMID_failure", e.getErrorCode() + "");
                    if (dataCallback != null) {
                        dataCallback.result(this.mUmidToken);
                    }
                }
            } else if (dataCallback != null) {
                dataCallback.result(this.mUmidToken);
            }
        } else if (dataCallback != null) {
            dataCallback.result(this.mUmidToken);
        }
        TLogAdapter.d(TAG, "get mUmidToken=" + this.mUmidToken);
    }

    public static synchronized AppInfo getInstance() {
        AppInfo appInfo;
        synchronized (AppInfo.class) {
            if (INSTANCE == null) {
                INSTANCE = new AppInfo();
            }
            appInfo = INSTANCE;
        }
        return appInfo;
    }

    public String getAndroidAppVersion() {
        return "android_" + getAppVersion();
    }

    public String getAppVersion() {
        if (this.mAppVersion == null) {
            try {
                PackageInfo packageInfo = DataProviderFactory.getApplicationContext().getPackageManager().getPackageInfo(DataProviderFactory.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    this.mAppVersion = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.mAppVersion;
    }

    public String getLocale() {
        return Locale.getDefault().getCountry();
    }

    public String getSdkVersion() {
        String str = "5.3.1.60";
        if (!TextUtils.isEmpty("5.3.1.60")) {
            String[] split = "5.3.1.60".split("-");
            if (split != null && split.length > 0) {
                str = split[0];
                if (!TextUtils.isEmpty(str)) {
                    String[] split2 = str.split(JSMethod.NOT_SET);
                    if (split2 != null && split2.length > 0) {
                        str = split2[0];
                    }
                }
            }
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "5.3.0.60";
        }
        return "android_" + str;
    }

    public String getUmidToken() {
        if (TextUtils.isEmpty(this.mUmidToken)) {
            generateUmidToken(null);
        }
        return this.mUmidToken;
    }

    public String getUtdid() {
        if (!TextUtils.isEmpty(DataProviderFactory.getDataProvider().getUtdid())) {
            return DataProviderFactory.getDataProvider().getUtdid();
        }
        String str = this.mUtdid;
        return str == null ? "" : str;
    }

    public void init() {
        init(false);
    }

    public boolean isRoot() {
        return this.isRoot;
    }

    public void init(boolean z) {
        generateUmidToken(null);
        TLogAdapter.d(TAG, "init mUmidToken=" + this.mUmidToken);
        SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences("onesdk_device", 0);
        try {
            if (DataProviderFactory.getDataProvider().getSite() == 21) {
                this.mUtdid = sharedPreferences.getString("deviceId", null);
                TLogAdapter.e(TAG, "recover utdid from sp，mUtdid=" + this.mUtdid);
                if (TextUtils.isEmpty(this.mUtdid)) {
                    this.mUtdid = FileUtil.getSdcardFile("deviceId");
                    TLogAdapter.e(TAG, "recover utdid from sdcard，mUtdid=" + this.mUtdid);
                }
            }
            if (TextUtils.isEmpty(this.mUtdid)) {
                this.mUtdid = UTDevice.getUtdid(DataProviderFactory.getApplicationContext());
                if (DataProviderFactory.getDataProvider().getSite() == 21) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceId", this.mUtdid);
                    edit.apply();
                    FileUtil.writeSdcardFile("deviceId", this.mUtdid);
                }
            }
            TLogAdapter.d(TAG, "init mUtdid=" + this.mUtdid);
            this.isRoot = NetworkUtil.isSuEnable();
            Properties properties = new Properties();
            properties.setProperty("isRoot", String.valueOf(this.isRoot));
            UserTrackAdapter.sendUT("isRoot", properties);
        }
    }

    public void getUmidToken(DataCallback<String> dataCallback) {
        if (TextUtils.isEmpty(this.mUmidToken)) {
            generateUmidToken(dataCallback);
            UserTrackAdapter.sendUT("Event_InitApdidToken");
            return;
        }
        dataCallback.result(this.mUmidToken);
    }
}
