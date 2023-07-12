package com.alibaba.security.realidentity.track;

import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.bean.ClientInfo;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class RPTrackHttpModel implements Serializable {
    private ClientInfo clientInfo;
    private String verifyToken;
    private List<TrackLog> wirelessLogs;

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public String getVerifyToken() {
        return this.verifyToken;
    }

    public List<TrackLog> getWirelessLogs() {
        return this.wirelessLogs;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void setVerifyToken(String str) {
        this.verifyToken = str;
    }

    public void setWirelessLogs(List<TrackLog> list) {
        this.wirelessLogs = list;
    }
}
