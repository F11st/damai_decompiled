package com.youku.upsplayer.module;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MinVideoInfo {
    private String copyrightKey;
    private long duration;
    private String encryptR_server;
    private int errCode;
    private FirstSlice firstSlicesInfo;
    private boolean hasHead;
    private boolean hasZreal;
    private boolean hdrFeature;
    private boolean isSubTitle;
    private Sei sei;
    private String showId;
    private String title;
    private String vid;
    private String videoStr;

    public String getCopyrightKey() {
        return this.copyrightKey;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getEncryptR_server() {
        return this.encryptR_server;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public FirstSlice getFirstSlicesInfo() {
        return this.firstSlicesInfo;
    }

    public Sei getSei() {
        return this.sei;
    }

    public String getShowId() {
        return this.showId;
    }

    public boolean getSubTitle() {
        return this.isSubTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVid() {
        return this.vid;
    }

    public String getVideoStr() {
        return this.videoStr;
    }

    public boolean isHasHead() {
        return this.hasHead;
    }

    public boolean isHasZreal() {
        return this.hasZreal;
    }

    public boolean isHdrFeature() {
        return this.hdrFeature;
    }

    public void setCopyrightKey(String str) {
        this.copyrightKey = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setEncryptR_server(String str) {
        this.encryptR_server = str;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public void setFirstSlicesInfo(FirstSlice firstSlice) {
        this.firstSlicesInfo = firstSlice;
    }

    public void setHasHead(boolean z) {
        this.hasHead = z;
    }

    public void setHasZreal(boolean z) {
        this.hasZreal = z;
    }

    public void setHdrFeature(boolean z) {
        this.hdrFeature = z;
    }

    public void setSei(Sei sei) {
        this.sei = sei;
    }

    public void setShowId(String str) {
        this.showId = str;
    }

    public void setSubTitle(boolean z) {
        this.isSubTitle = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public void setVideoStr(String str) {
        this.videoStr = str;
    }
}
