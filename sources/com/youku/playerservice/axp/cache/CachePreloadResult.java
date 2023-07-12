package com.youku.playerservice.axp.cache;

import com.youku.playerservice.axp.playinfo.PlayInfoError;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CachePreloadResult {
    private PlayInfoError mError;
    private String mPlayerId;
    private String mUrlOfPreload;
    private String mVidOfPreload;
    private Map<String, Map<String, String>> mVidToUrls;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum AXPCachePreloadStatus {
        AXPCACHEPRELOADSTATUS_FAIL_PARAMS(100),
        AXPCACHEPRELOADSTATUS_FAIL_EXISTS_TASK(101),
        AXPCACHEPRELOADSTATUS_SUCCESS_MEDIASOURCE(201),
        AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE(202),
        AXPCACHEPRELOADSTATUS_MEDIASOURCE_UPDATEVIDTOURL(203),
        AXPCACHEPRELOADSTATUS_SUCCESS_PLAYINFO(3),
        AXPCACHEPRELOADSTATUS_SUCCESS_PLAYER(4),
        AXPCACHEPRELOADSTATUS_FAIL_PLAYER(401),
        AXPCACHEPRELOADSTATUS_FAIL_EXISTS_PLAYER(402),
        AXPCACHEPRELOADSTATUS_FAIL_CANCEL_PLAYER(403),
        AXPCACHEPRELOADSTATUS_FAIL_STOP_PLAYER(404),
        AXPCACHEPRELOADSTATUS_FAIL_DEINIT_PLAYER(405),
        AXPCACHEPRELOADSTATUS_FAIL_NOPLAYID_PLAYER(406),
        AXPCACHEPRELOADSTATUS_CREATE_PLAYER(407);
        
        int value;

        AXPCachePreloadStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public PlayInfoError getError() {
        return this.mError;
    }

    public String getPlayerId() {
        return this.mPlayerId;
    }

    public String getUrlOfPreload() {
        return this.mUrlOfPreload;
    }

    public String getVidOfPreload() {
        return this.mVidOfPreload;
    }

    public Map<String, Map<String, String>> getVidToUrls() {
        return this.mVidToUrls;
    }

    public void setError(PlayInfoError playInfoError) {
        this.mError = playInfoError;
    }

    public void setPlayerId(String str) {
        this.mPlayerId = str;
    }

    public void setUrlOfPreload(String str) {
        this.mUrlOfPreload = str;
    }

    public void setVidOfPreload(String str) {
        this.mVidOfPreload = str;
    }

    public void setVidToUrls(Map<String, Map<String, String>> map) {
        this.mVidToUrls = map;
    }
}
