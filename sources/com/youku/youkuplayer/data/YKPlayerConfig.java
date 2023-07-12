package com.youku.youkuplayer.data;

import android.content.Context;
import com.youku.playerservice.axp.PlayerConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKPlayerConfig extends PlayerConfig {
    private Map<String, String> extConfig;
    private String mClient_id;
    private boolean mDisableAd;
    private String mPid;
    private boolean mReusedPlayer;
    private boolean mShowWalterPlugin;
    private boolean showLog;

    public YKPlayerConfig(Context context) {
        super(context);
        this.mShowWalterPlugin = true;
        this.extConfig = new HashMap();
    }

    public String getClient_id() {
        return this.mClient_id;
    }

    public Map<String, String> getExtConfig() {
        return this.extConfig;
    }

    public String getPid() {
        return this.mPid;
    }

    public boolean isDisableAd() {
        return this.mDisableAd;
    }

    public boolean isReusedPlayer() {
        return this.mReusedPlayer;
    }

    public boolean isShowLog() {
        return this.showLog;
    }

    public boolean isShowWalterPlugin() {
        return this.mShowWalterPlugin;
    }

    public void putExtConfig(String str, String str2) {
        this.extConfig.put(str, str2);
    }

    public void setClient_id(String str) {
        this.mClient_id = str;
    }

    public void setDisableAd(boolean z) {
        this.mDisableAd = z;
    }

    public void setPid(String str) {
        this.mPid = str;
    }

    public void setReusedPlayer(boolean z) {
        this.mReusedPlayer = z;
    }

    public void setShowLog(boolean z) {
        this.showLog = z;
    }

    public void setShowWalterPlugin(boolean z) {
        this.mShowWalterPlugin = z;
    }
}
