package com.youku.playerservice.axp.playinfo.request.task;

import com.youku.alixplayer.opensdk.ups.request.UpsConstant;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UpsProxyInfo {
    public static final int TYPE_PRE_BIG_DRAMA = 0;
    private int type;
    private String header_host = "ups-pre.youku.com";
    private String ups_extend = "ccode=0401&censor=1";
    private String ups_host_ip = UpsConstant.YOUKU_UPS_PLAY_REQ_IP_DEFAULT;

    public String createUrlByType(String str, String str2) {
        if (this.type == 0) {
            return str + this.ups_extend;
        }
        return str;
    }

    public String getHeader_host() {
        return this.header_host;
    }

    public int getType() {
        return this.type;
    }

    public String getUps_extend() {
        return this.ups_extend;
    }

    public String getUps_host_ip() {
        return this.ups_host_ip;
    }

    public void setHeader_host(String str) {
        this.header_host = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUps_extend(String str) {
        this.ups_extend = str;
    }

    public void setUps_host_ip(String str) {
        this.ups_host_ip = str;
    }
}
