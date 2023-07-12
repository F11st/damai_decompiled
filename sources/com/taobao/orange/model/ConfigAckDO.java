package com.taobao.orange.model;

import anet.channel.statist.Dimension;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import com.taobao.orange.OConstant;

/* compiled from: Taobao */
@Monitor(module = OConstant.MONITOR_PRIVATE_MODULE, monitorPoint = OConstant.POINT_CONFIG_ACK)
/* loaded from: classes11.dex */
public class ConfigAckDO extends StatObject {
    @Dimension
    public String name;
    @Dimension
    public String namespaceId;
    @Dimension
    public String updateTime;
    @Dimension
    public String version;

    public ConfigAckDO() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConfigAckDO configAckDO = (ConfigAckDO) obj;
        if (this.name.equals(configAckDO.name) && this.namespaceId.equals(configAckDO.namespaceId) && this.updateTime.equals(configAckDO.updateTime)) {
            return this.version.equals(configAckDO.version);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.namespaceId.hashCode()) * 31) + this.updateTime.hashCode()) * 31) + this.version.hashCode();
    }

    public ConfigAckDO(String str, String str2, String str3, String str4) {
        this.name = str;
        this.namespaceId = str2;
        this.updateTime = str3;
        this.version = str4;
    }
}
