package com.youku.android.liveservice.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.youku.live.dago.liveplayback.widget.PluginName;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;
import tb.kh1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LivePlayControl implements Serializable {
    @JSONField(name = PluginName.AD)
    public boolean ad;
    public String adInfo;
    public String adJsonStr;
    public String areaCode;
    public int audioDq;
    public List<AudioInfo> audioInfo;
    public String bizData;
    public String bizExtra;
    @Deprecated
    public BizSwitch bizSwitch;
    public String bizType;
    @Deprecated
    public String cRk;
    public String clientIp;
    public String countryCode;
    public String dmaCode;
    public int dq;
    @Deprecated
    public boolean drm;
    @Deprecated
    public String eRs;
    public long endTimestamp;
    public String ext;
    public int hasAudio;
    public int hasPostAd;
    @JSONField(name = "hbrHit")
    public int hbrHit;
    public int isLookBack;
    public JSONObject jsonObject;
    @Deprecated
    public boolean landscape;
    public String liveId;
    public int liveStatus;
    public String loginYtid;
    public int mcu;
    public String md;
    public MicInfo micInfo;
    public String micMode;
    public long now;
    public boolean paid;
    public String payScenes;
    public int playMode;
    @Deprecated
    public String playType;
    public PlayerWidget playerWidget;
    public String psid;
    public String pushStreamType;
    public List<Quality> qualities;
    public String rawData;
    public String sceneId;
    public String sceneName;
    @JSONField(name = "sceneType")
    public int sceneType;
    public String screenId;
    public long startTimestamp;
    public String streamMode;
    @JSONField(name = kh1.RESOURCE_STREAM)
    public List<Stream> streams;
    @Deprecated
    public String subtitleUrl;
    @Deprecated
    public int timeShiftOffset;
    public String token;
    public String userId;
    public boolean userPaid;
    @JSONField(name = "waterMark")
    public List<WaterMarkV2> waterMarkV2;
    public String tryPlayTime = "";
    public String tryPlayNotice = "";

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class AuthType implements Serializable {
        public String authType;
        public String desAuthTypeKey;
        public String rand;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Drm implements Serializable {
        public String desUseDrmKey;
        public String useDrm;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class DrmSubFix implements Serializable {
        public String copyright_key;
        public String encryptR_server;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Ext implements Serializable {
        public AuthType authType;
        public String commonsubfix;
        public Drm drm;
        public DrmSubFix drmsubfix;
        public IdDelay idDelay;
        public String mdsubfix;
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class IdDelay implements Serializable {
        public String desDelayKey;
        public String idDelay;
    }

    public Quality getDefaultQuality() {
        if (this.qualities == null) {
            return null;
        }
        for (int i = 0; i < this.qualities.size(); i++) {
            if (this.qualities.get(i).quality == this.dq) {
                return this.qualities.get(i);
            }
        }
        return null;
    }

    public Quality getRequiredQuality(int i) {
        if (this.qualities == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.qualities.size(); i2++) {
            if (this.qualities.get(i2).quality == i) {
                return this.qualities.get(i2);
            }
        }
        return null;
    }

    public String toString() {
        return "LivePlayControl{dmaCode='" + this.dmaCode + "', countryCode='" + this.countryCode + "', tryPlayTime=" + this.tryPlayTime + ", token='" + this.token + "', isLookBack=" + this.isLookBack + ", ext='" + this.ext + "', md='" + this.md + "', userId='" + this.userId + "', areaCode='" + this.areaCode + "', clientIp='" + this.clientIp + "', liveId='" + this.liveId + "', screenId='" + this.screenId + "', sceneId='" + this.sceneId + "', sceneName='" + this.sceneName + "', qualities=" + this.qualities + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", dq=" + this.dq + ", adInfo='" + this.adInfo + "', psid='" + this.psid + "', paid=" + this.paid + ", userPaid=" + this.userPaid + ", payScenes='" + this.payScenes + "', hasPostAd=" + this.hasPostAd + ", drm=" + this.drm + ", eRs='" + this.eRs + "', cRk='" + this.cRk + "', subtitleUrl='" + this.subtitleUrl + "', timeShiftOffset=" + this.timeShiftOffset + ", bizSwitch=" + this.bizSwitch + '}';
    }
}
