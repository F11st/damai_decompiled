package com.taobao.orange.model;

import anet.channel.statist.Dimension;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import com.taobao.orange.OConstant;

/* compiled from: Taobao */
@Monitor(module = OConstant.MONITOR_PRIVATE_MODULE, monitorPoint = OConstant.POINT_INDEX_ACK)
/* loaded from: classes11.dex */
public class IndexAckDO extends StatObject {
    @Dimension
    public String indexId;
    @Dimension
    public String md5;
    @Dimension
    public String updateTime;

    public IndexAckDO() {
    }

    public String toString() {
        return "IndexAckDO{indexId='" + this.indexId + "', updateTime='" + this.updateTime + "', md5='" + this.md5 + "'}";
    }

    public IndexAckDO(String str, String str2, String str3) {
        this.indexId = str;
        this.updateTime = str2;
        this.md5 = str3;
    }
}
