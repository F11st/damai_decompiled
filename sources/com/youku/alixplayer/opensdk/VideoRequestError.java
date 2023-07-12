package com.youku.alixplayer.opensdk;

import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.upsplayer.data.ConnectStat;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class VideoRequestError {
    private LivePlayControl livePlayControl;
    private ConnectStat mConnectStat;
    private int mErrorCode = -1;
    private String mErrorMsg;
    private String mException;
    private int mHttpStatus;
    private PlayVideoInfo mPlayVideoInfo;

    public VideoRequestError(PlayVideoInfo playVideoInfo) {
        this.mPlayVideoInfo = playVideoInfo;
    }

    public ConnectStat getConnectStat() {
        return this.mConnectStat;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public String getException() {
        return this.mException;
    }

    public int getHttpStatus() {
        return this.mHttpStatus;
    }

    public LivePlayControl getLivePlayControl() {
        return this.livePlayControl;
    }

    public PlayVideoInfo getPlayVideoInfo() {
        return this.mPlayVideoInfo;
    }

    public void setConnectStat(ConnectStat connectStat) {
        this.mConnectStat = connectStat;
    }

    public void setErrorCode(int i) {
        if (i < 0) {
            this.mErrorCode = 20000 - i;
        } else if (i < 20000) {
            this.mErrorCode = i + 20000;
        } else {
            this.mErrorCode = i;
        }
    }

    public void setErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public void setException(String str) {
        this.mException = str;
    }

    public void setHttpStatus(int i) {
        this.mHttpStatus = i;
    }

    public void setLivePlayControl(LivePlayControl livePlayControl) {
        this.livePlayControl = livePlayControl;
    }
}
