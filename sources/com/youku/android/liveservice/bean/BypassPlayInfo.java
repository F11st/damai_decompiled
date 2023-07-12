package com.youku.android.liveservice.bean;

import java.io.Serializable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BypassPlayInfo implements Serializable {
    public String adJsonStr;
    public String bitStream;
    public String ccode;
    public String copyrightKey;
    public String definition;
    public boolean dlnaList;
    public int drmType;
    public String duration;
    public String encryptRServer;
    public int error;
    public String gravity;
    public int h265;
    @Deprecated
    public String h265PlayUrl;
    public boolean isMd;
    public boolean isP2p;
    public String liveAdFlag;
    public String liveId;
    public LivePlayControl livePlayControl;
    public String livePlayControlContent;
    public int liveState;
    public boolean muted;
    public boolean panorama;
    public String playType;
    public boolean ptsPursue;
    public long ptsUpdateInterval;
    public int quality;
    public int qualityCode;
    public String r1;
    public boolean smooth;
    public String startPos;
    public String startTime;
    @Deprecated
    public String subtitleUrl;
    public boolean timeShift;
    public String title;
    @Deprecated
    public String url;
    public Map<String, Object> utParams;
    public String vid;

    public BypassPlayInfo() {
        this.isMd = false;
    }

    public String toString() {
        return "BypassPlayInfo{liveState=" + this.liveState + ", ccode='" + this.ccode + "', url='" + this.url + "', isP2p=" + this.isP2p + ", subtitleUrl='" + this.subtitleUrl + "', h265PlayUrl='" + this.h265PlayUrl + "', h265=" + this.h265 + ", utParams=" + this.utParams + ", vid='" + this.vid + "', liveId='" + this.liveId + "', panorama=" + this.panorama + ", smooth=" + this.smooth + ", timeShift=" + this.timeShift + ", ptsUpdateInterval=" + this.ptsUpdateInterval + ", ptsPursue=" + this.ptsPursue + ", gravity='" + this.gravity + "', muted=" + this.muted + ", dlnaList=" + this.dlnaList + ", r1='" + this.r1 + "', encryptRServer='" + this.encryptRServer + "', copyrightKey='" + this.copyrightKey + "', adJsonStr='" + this.adJsonStr + "', startTime='" + this.startTime + "', liveAdFlag='" + this.liveAdFlag + "', error=" + this.error + ", startPos='" + this.startPos + "', duration='" + this.duration + "', title='" + this.title + "', definition='" + this.definition + "', drmType=" + this.drmType + ", quality=" + this.quality + ", qualityCode=" + this.qualityCode + ", isMd=" + this.isMd + ", livePlayControl=" + this.livePlayControl + ", livePlayControlContent=" + this.livePlayControlContent + ", playType=" + this.playType + ", bitStream=" + this.bitStream + '}';
    }

    private BypassPlayInfo(BypassPlayInfo bypassPlayInfo) {
        this.isMd = false;
        this.liveState = bypassPlayInfo.liveState;
        this.ccode = bypassPlayInfo.ccode;
        this.url = bypassPlayInfo.url;
        this.isP2p = bypassPlayInfo.isP2p;
        this.subtitleUrl = bypassPlayInfo.subtitleUrl;
        this.h265 = bypassPlayInfo.h265;
        this.h265PlayUrl = bypassPlayInfo.h265PlayUrl;
        this.utParams = bypassPlayInfo.utParams;
        this.vid = bypassPlayInfo.vid;
        this.liveId = bypassPlayInfo.liveId;
        this.panorama = bypassPlayInfo.panorama;
        this.smooth = bypassPlayInfo.smooth;
        this.timeShift = bypassPlayInfo.timeShift;
        this.ptsUpdateInterval = bypassPlayInfo.ptsUpdateInterval;
        this.ptsPursue = bypassPlayInfo.ptsPursue;
        this.gravity = bypassPlayInfo.gravity;
        this.muted = bypassPlayInfo.muted;
        this.dlnaList = bypassPlayInfo.dlnaList;
        this.r1 = bypassPlayInfo.r1;
        this.encryptRServer = bypassPlayInfo.encryptRServer;
        this.copyrightKey = bypassPlayInfo.copyrightKey;
        this.adJsonStr = bypassPlayInfo.adJsonStr;
        this.startTime = bypassPlayInfo.startTime;
        this.liveAdFlag = bypassPlayInfo.liveAdFlag;
        this.error = bypassPlayInfo.error;
        this.startPos = bypassPlayInfo.startPos;
        this.duration = bypassPlayInfo.duration;
        this.title = bypassPlayInfo.title;
        this.definition = bypassPlayInfo.definition;
        this.drmType = bypassPlayInfo.drmType;
        this.quality = bypassPlayInfo.quality;
        this.qualityCode = bypassPlayInfo.qualityCode;
        this.isMd = bypassPlayInfo.isMd;
        this.livePlayControl = bypassPlayInfo.livePlayControl;
        this.livePlayControlContent = bypassPlayInfo.livePlayControlContent;
        this.playType = bypassPlayInfo.playType;
        this.bitStream = bypassPlayInfo.bitStream;
    }
}
