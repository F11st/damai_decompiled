package org.android.spdy;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class SessionInfo {
    private static int INVALID_PUBLIC_SEQNUM = -1;
    private String domain;
    private String host;
    private int mode;
    private int port;
    private String proxyHost;
    private int proxyPort;
    private SessionCb sessionCb;
    private Object sessionUserData;
    private boolean xqcLossDetect;
    private String certHost = null;
    private int pubkey_seqnum = INVALID_PUBLIC_SEQNUM;
    private int connTimeoutMs = -1;
    private int cong_control = 0;
    private int xqc_pacing = 0;

    public SessionInfo(String str, int i, String str2, String str3, int i2, Object obj, SessionCb sessionCb, int i3) {
        this.xqcLossDetect = false;
        this.host = str;
        this.port = i;
        this.domain = str2;
        this.proxyHost = str3;
        this.proxyPort = i2;
        this.sessionUserData = obj;
        this.sessionCb = sessionCb;
        this.mode = i3;
        this.xqcLossDetect = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getAuthority() {
        if (this.proxyHost != null && this.proxyPort != 0) {
            return this.host + ":" + this.port + "/" + this.proxyHost + ":" + this.proxyPort;
        }
        return this.host + ":" + this.port;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCertHost() {
        if (this.pubkey_seqnum != INVALID_PUBLIC_SEQNUM) {
            return null;
        }
        return this.certHost;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getConnectionTimeoutMs() {
        return this.connTimeoutMs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDomain() {
        return this.domain;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMode() {
        return this.mode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPubKeySeqNum() {
        return this.pubkey_seqnum;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionCb getSessionCb() {
        return this.sessionCb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getSessonUserData() {
        return this.sessionUserData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getXquicCongControl() {
        return this.cong_control;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getXquicLossDetect() {
        return this.xqcLossDetect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getXquicPacing() {
        return this.xqc_pacing;
    }

    public void setCertHost(String str) {
        this.certHost = str;
    }

    public void setConnectionTimeoutMs(int i) {
        this.connTimeoutMs = i;
    }

    public void setPubKeySeqNum(int i) {
        this.pubkey_seqnum = i;
    }

    public void setXquicCongControl(int i) {
        this.cong_control = i;
    }

    public void setXquicLossDetect(boolean z) {
        this.xqcLossDetect = z;
    }

    public void setXquicPacing(int i) {
        this.xqc_pacing = i;
    }
}
