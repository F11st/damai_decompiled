package com.youku.playerservice.axp.playinfo;

import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.base.model.AdInfo;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.QualityStream;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class PlayInfoResponse {
    protected String cachePlayID;
    protected AdInfo mAdInfo;
    protected CacheUpsInfo mCacheInfo;
    private String mCookieParams;
    private long mDurationOfRequest;
    protected PlayInfoError mError;
    protected PlayDefinition.PlayInfoType mInfoType;
    private long mInvalidTime;
    protected LiveInfo mLiveInfo;
    protected PlayParams mPlayParams;
    protected Map<String, Object> mProperties = new HashMap();
    private RequestMode mRequestMode;
    private long mTimeOfRequestEnd;
    private long mTimeOfRequestStart;
    protected NetUpsInfo mUpsInfo;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum RequestMode {
        NORMAL,
        MULTIGET,
        QGET
    }

    public PlayInfoResponse(PlayParams playParams) {
        this.mPlayParams = playParams;
    }

    public JSONObject constructLocalExtraInfo() {
        JSONObject jSONObject = new JSONObject();
        NetUpsInfo netUpsInfo = this.mUpsInfo;
        if (netUpsInfo != null) {
            jSONObject.put("drmR1", (Object) netUpsInfo.getDrmR1());
            jSONObject.put("cacheKey", (Object) this.mUpsInfo.getCacheKey());
            jSONObject.put("langCode", (Object) this.mUpsInfo.getLangCode());
            jSONObject.put("QGetErrorCode", (Object) this.mUpsInfo.getQGetErrorCode());
            jSONObject.put("QGetErrorMsg", (Object) this.mUpsInfo.getQGetErrorMsg());
        }
        jSONObject.put("cachePlayID", (Object) this.cachePlayID);
        jSONObject.put("cookieParams", (Object) this.mCookieParams);
        jSONObject.put("timeOfRequestEnd", (Object) Long.valueOf(this.mTimeOfRequestEnd));
        jSONObject.put("invalidTime", (Object) Long.valueOf(this.mInvalidTime));
        return jSONObject;
    }

    public AdInfo getAdInfo() {
        return this.mAdInfo;
    }

    public CacheUpsInfo getCacheInfo() {
        return this.mCacheInfo;
    }

    public String getCachePlayID() {
        return this.cachePlayID;
    }

    public String getCookieParams() {
        return this.mCookieParams;
    }

    public long getDurationOfRequest() {
        return this.mDurationOfRequest;
    }

    public PlayInfoError getError() {
        return this.mError;
    }

    public PlayDefinition.PlayInfoType getInfoType() {
        return this.mInfoType;
    }

    public long getInvalidTime() {
        return this.mInvalidTime;
    }

    public LiveInfo getLiveInfo() {
        return this.mLiveInfo;
    }

    public String getPlayId() {
        if (this.mPlayParams.getPlayIdParams() != null) {
            return this.mPlayParams.getPlayIdParams().getPlayId();
        }
        return null;
    }

    public <T extends PlayItem> T getPlayItem(PlayParams playParams, Quality quality, String str) {
        return null;
    }

    public <T extends PlayItem> List<T> getPlayItem(PlayParams playParams) {
        return null;
    }

    public PlayParams getPlayParams() {
        return this.mPlayParams;
    }

    public int getProperties(String str, int i) {
        Object obj = this.mProperties.get(str);
        if (obj == null) {
            return i;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }

    public <T> T getProperties(String str) {
        return (T) this.mProperties.get(str);
    }

    public String getProperties(String str, String str2) {
        Object obj = this.mProperties.get(str);
        return obj == null ? str2 : (String) obj;
    }

    public Map<String, List<QualityStream>> getQualityList(String str) {
        return null;
    }

    public RequestMode getRequestMode() {
        return this.mRequestMode;
    }

    public long getTimeOfRequestEnd() {
        return this.mTimeOfRequestEnd;
    }

    public long getTimeOfRequestStart() {
        return this.mTimeOfRequestStart;
    }

    public NetUpsInfo getUpsInfo() {
        return this.mUpsInfo;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.mAdInfo = adInfo;
    }

    public void setCacheInfo(CacheUpsInfo cacheUpsInfo) {
        this.mCacheInfo = cacheUpsInfo;
    }

    public void setCachePlayID(String str) {
        this.cachePlayID = str;
    }

    public void setCookieParams(String str) {
        this.mCookieParams = str;
    }

    public void setDurationOfRequest(long j) {
        this.mDurationOfRequest = j;
    }

    public void setError(PlayInfoError playInfoError) {
        this.mError = playInfoError;
    }

    public void setInfoType(PlayDefinition.PlayInfoType playInfoType) {
        this.mInfoType = playInfoType;
    }

    public void setInvalidTime(long j) {
        this.mInvalidTime = j;
    }

    public void setLiveInfo(LiveInfo liveInfo) {
        this.mLiveInfo = liveInfo;
    }

    public void setProperties(String str, Object obj) {
        if (obj != null) {
            this.mProperties.put(str, obj);
        } else {
            this.mProperties.remove(str);
        }
    }

    public void setRequestMode(RequestMode requestMode) {
        this.mRequestMode = requestMode;
    }

    public void setTimeOfRequestEnd(long j) {
        this.mTimeOfRequestEnd = j;
    }

    public void setTimeOfRequestStart(long j) {
        this.mTimeOfRequestStart = j;
    }

    public void setUpsInfo(NetUpsInfo netUpsInfo) {
        this.mUpsInfo = netUpsInfo;
    }

    public String toString() {
        return "PlayInfoResponse{mInfoType=" + this.mInfoType + '}';
    }

    public void updateLocalExtraInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        NetUpsInfo netUpsInfo = this.mUpsInfo;
        if (netUpsInfo != null) {
            netUpsInfo.setDrmR1(jSONObject.getString("drmR1"));
            this.mUpsInfo.setCacheKey(jSONObject.getString("cacheKey"));
            this.mUpsInfo.setLangCode(jSONObject.getString("langCode"));
            this.mUpsInfo.setQGetErrorCode(jSONObject.getString("QGetErrorCode"));
            this.mUpsInfo.setQGetErrorMsg(jSONObject.getString("QGetErrorMsg"));
        }
        this.cachePlayID = jSONObject.getString("cachePlayID");
        this.mCookieParams = jSONObject.getString("cookieParams");
        this.mTimeOfRequestEnd = jSONObject.getLongValue("timeOfRequestEnd");
        this.mInvalidTime = jSONObject.getLongValue("invalidTime");
    }
}
