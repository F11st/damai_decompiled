package com.youku.playerservice.axp.playparams;

import android.text.TextUtils;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.Quality;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayIdParams {
    private String mAToken;
    private String mAuthCode;
    private String mCCode;
    private String mClientId;
    private boolean mDisableAd;
    private boolean mDisableBfAd;
    private boolean mDisableH265;
    private boolean mIsLocalPlay;
    private boolean mIsSkipHeadTail;
    private String mLanguageCode;
    private String mPlayId;
    private IPlayInfoRequest mPlayInfoRequest;
    private String mPlayJson;
    private String mPlayUrl;
    private int mRequestLiveQuality;
    private int mVideoStage;
    private String playExtraJson;
    private List<String> vids;
    private PlayDefinition.PlayFormat mPlayFormat = PlayDefinition.PlayFormat.UNKNOWN;
    private Quality mRequestQuality = Quality.UNKNOWN;
    private Map<String, String> mExtraInfo = new ConcurrentHashMap();
    private Map<String, String> mExtraParams = new HashMap();
    private Map<String, String> mDlnaParams = new HashMap();

    public PlayIdParams(String str, String str2) {
        this.mPlayId = str;
        this.mCCode = str2;
    }

    public static PlayIdParams createPlayIdParams(String str, String str2) {
        return new PlayIdParams(str, str2);
    }

    public String getAToken() {
        return this.mAToken;
    }

    public String getCCode() {
        return this.mCCode;
    }

    public String getClientId() {
        return this.mClientId;
    }

    public Map<String, String> getDlnaParams() {
        return this.mDlnaParams;
    }

    public Map<String, String> getExtraParams() {
        return this.mExtraParams;
    }

    public String getLanguageCode() {
        return this.mLanguageCode;
    }

    public String getPlayExtraJson() {
        return this.playExtraJson;
    }

    public PlayDefinition.PlayFormat getPlayFormat() {
        return this.mPlayFormat;
    }

    public String getPlayId() {
        return this.mPlayId;
    }

    public IPlayInfoRequest getPlayInfoRequest() {
        return this.mPlayInfoRequest;
    }

    public String getPlayJson() {
        return this.mPlayJson;
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public int getRequestLiveQuality() {
        return this.mRequestLiveQuality;
    }

    public Quality getRequestQuality() {
        return this.mRequestQuality;
    }

    public String getString(String str) {
        return this.mExtraInfo.get(str);
    }

    public int getVideoStage() {
        return this.mVideoStage;
    }

    public List<String> getVids() {
        return this.vids;
    }

    public boolean isDisableAd() {
        return this.mDisableAd;
    }

    public boolean isDisableBfAd() {
        return this.mDisableBfAd;
    }

    public boolean isDisableH265() {
        return this.mDisableH265;
    }

    public boolean isLocalPlay() {
        return this.mIsLocalPlay;
    }

    public boolean isSkipHeadTail() {
        return this.mIsSkipHeadTail;
    }

    public void putAllExtraParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.mExtraParams.putAll(map);
    }

    public void putDlnaMap(Map<String, String> map) {
        if (map != null) {
            this.mDlnaParams.putAll(map);
        }
    }

    public void putDlnaParam(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mDlnaParams.put(str, str2);
    }

    public void putExtMap(Map<String, String> map) {
        if (map != null) {
            this.mExtraInfo.putAll(map);
        }
    }

    public void putExtraParam(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mExtraParams.put(str, str2);
    }

    public void putString(String str, String str2) {
        if (str2 != null) {
            this.mExtraInfo.put(str, str2);
        } else {
            this.mExtraInfo.remove(str);
        }
    }

    public void setAToken(String str) {
        this.mAToken = str;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public void setDisableAd(boolean z) {
        this.mDisableAd = z;
    }

    public void setDisableBfAd(boolean z) {
        this.mDisableBfAd = z;
    }

    public void setDisableH265(boolean z) {
        this.mDisableH265 = z;
    }

    public void setLanguageCode(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.mLanguageCode = str;
    }

    public void setLocalPlay(boolean z) {
        this.mIsLocalPlay = z;
    }

    public PlayIdParams setPlayExtraJson(String str) {
        this.playExtraJson = str;
        return this;
    }

    public void setPlayFormat(PlayDefinition.PlayFormat playFormat) {
        this.mPlayFormat = playFormat;
    }

    public void setPlayId(String str) {
        this.mPlayId = str;
    }

    public void setPlayInfoRequest(IPlayInfoRequest iPlayInfoRequest) {
        this.mPlayInfoRequest = iPlayInfoRequest;
    }

    public void setPlayJson(String str) {
        this.mPlayJson = str;
    }

    public void setPlayUrl(String str) {
        this.mPlayUrl = str;
    }

    public void setRequestLiveQuality(int i) {
        this.mRequestLiveQuality = i;
    }

    public void setRequestQuality(Quality quality) {
        this.mRequestQuality = quality;
    }

    public void setSkipHeadTail(boolean z) {
        this.mIsSkipHeadTail = z;
    }

    public void setVideoStage(int i) {
        this.mVideoStage = i;
    }

    public void setVids(List<String> list) {
        this.vids = list;
    }
}
