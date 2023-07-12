package android.taobao.windvane.config;

import android.taobao.windvane.config.UCHASettings;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVAppParams {
    public String appKey;
    public String appSecret;
    public String appTag;
    public String appVersion;
    public UCHASettings.ConfigRate configRates;
    public String deviceId;
    public String imei;
    public String imsi;
    public String ttid;
    public Callable<Boolean> ucDownloadChecker;
    public UCHASettings ucHASettings;
    public String[] ucsdkappkeySec = null;
    public String ucLibDir = null;
    public String uc7ZPath = null;
    public boolean ucSdkInternationalEnv = false;
    public boolean needSpeed = true;
    public boolean zcacheSpeed = false;
    public boolean openUCDebug = true;
    public boolean zcacheOldConfig = false;
    public boolean zcacheType3 = true;
    public boolean open4GDownload = false;
    public boolean open5GDownload = false;
    public boolean ucCoreOuterControl = false;
    public int ucCoreWaitMills = 4000;
    public int deleteCorePolicy = 0;
    public boolean disableMultiUnknownCrash = false;
    public boolean useGlobalUrlConfig = false;
    public boolean reducePermission = false;
}
