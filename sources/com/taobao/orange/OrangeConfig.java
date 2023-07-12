package com.taobao.orange;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.orange.OConfig;
import com.taobao.orange.OConstant;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class OrangeConfig {
    public static OrangeConfig getInstance() {
        return OrangeConfigImpl.mInstance;
    }

    public abstract void addCandidate(@NonNull OCandidate oCandidate);

    @Deprecated
    public abstract void enterBackground();

    @Deprecated
    public abstract void enterForeground();

    public abstract void forceCheckUpdate();

    public abstract String getConfig(@NonNull String str, @NonNull String str2, @Nullable String str3);

    public abstract Map<String, String> getConfigs(@NonNull String str);

    public abstract String getCustomConfig(@NonNull String str, @Nullable String str2);

    @Deprecated
    public void init(@NonNull Context context) {
        init(context, null, null);
    }

    public abstract void init(@NonNull Context context, @NonNull OConfig oConfig);

    public abstract void registerListener(@NonNull String[] strArr, @NonNull OConfigListener oConfigListener, boolean z);

    @Deprecated
    public abstract void registerListener(@NonNull String[] strArr, @NonNull OrangeConfigListener orangeConfigListener);

    @Deprecated
    public abstract void registerListener(@NonNull String[] strArr, @NonNull OrangeConfigListenerV1 orangeConfigListenerV1);

    @Deprecated
    public abstract void setAppSecret(String str);

    @Deprecated
    public abstract void setEnableDiffIndex(boolean z);

    @Deprecated
    public abstract void setHosts(List<String> list);

    @Deprecated
    public abstract void setIndexUpdateMode(int i);

    public abstract void setUserId(@Nullable String str);

    public abstract void unregisterListener(@NonNull String[] strArr);

    public abstract void unregisterListener(@NonNull String[] strArr, @NonNull OConfigListener oConfigListener);

    @Deprecated
    public abstract void unregisterListener(@NonNull String[] strArr, @NonNull OrangeConfigListenerV1 orangeConfigListenerV1);

    @Deprecated
    public void init(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        init(context, str, str2, OConstant.ENV.ONLINE.getEnvMode());
    }

    @Deprecated
    public void init(@NonNull Context context, @NonNull String str, @NonNull String str2, int i) {
        init(context, str, str2, i, OConstant.SERVER.TAOBAO.ordinal());
    }

    @Deprecated
    public void init(@NonNull Context context, @NonNull String str, @NonNull String str2, int i, int i2) {
        init(context, str, str2, i, i2, null, null);
    }

    @Deprecated
    public void init(@NonNull Context context, @NonNull String str, @NonNull String str2, int i, int i2, @Nullable String str3, @Nullable String str4) {
        init(context, str, str2, i, i2, null, null, null);
    }

    @Deprecated
    public void init(@NonNull Context context, @NonNull String str, @NonNull String str2, int i, int i2, @Nullable String str3, @Nullable String str4, @Nullable String[] strArr) {
        init(context, str, str2, i, i2, str3, str4, strArr, false);
    }

    @Deprecated
    public void init(@NonNull Context context, @NonNull String str, @NonNull String str2, int i, int i2, @Nullable String str3, @Nullable String str4, @Nullable String[] strArr, boolean z) {
        init(context, new OConfig.Builder().setAppKey(str).setAppVersion(str2).setEnv(i).setServerType(i2).setIndexUpdateMode(OConstant.UPDMODE.O_XMD.ordinal()).setDcHost(str3).setAckHost(str4).setProbeHosts(strArr).setEnableDiffIndex(z).build());
    }
}
