package mtopsdk.mtop.global;

import android.content.Context;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public class SDKConfig {
    private static final String TAG = "mtopsdk.SDKConfig";
    private static final SDKConfig config = new SDKConfig();

    private SDKConfig() {
    }

    public static SDKConfig getInstance() {
        return config;
    }

    @Deprecated
    public String getGlobalAppKey() {
        return Mtop.instance(null).getMtopConfig().appKey;
    }

    @Deprecated
    public String getGlobalAppVersion() {
        return Mtop.instance(null).getMtopConfig().appVersion;
    }

    @Deprecated
    public String getGlobalAuthCode() {
        return Mtop.instance(null).getMtopConfig().authCode;
    }

    @Deprecated
    public Context getGlobalContext() {
        return Mtop.instance(null).getMtopConfig().context;
    }

    @Deprecated
    public int getGlobalDailyAppKeyIndex() {
        return Mtop.instance(null).getMtopConfig().dailyAppkeyIndex;
    }

    @Deprecated
    public String getGlobalDeviceId() {
        return Mtop.instance(null).getMtopConfig().deviceId;
    }

    @Deprecated
    public EnvModeEnum getGlobalEnvMode() {
        return Mtop.instance(null).getMtopConfig().envMode;
    }

    @Deprecated
    public int getGlobalOnlineAppKeyIndex() {
        return Mtop.instance(null).getMtopConfig().onlineAppKeyIndex;
    }

    @Deprecated
    public String getGlobalTtid() {
        return Mtop.instance(null).getMtopConfig().ttid;
    }

    @Deprecated
    public String getGlobalUtdid() {
        return Mtop.instance(null).getMtopConfig().utdid;
    }
}
