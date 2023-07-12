package cn.damai.commonbusiness.seatbiz.sku.qilin.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SkuSaveInfo implements Serializable {
    private static final long serialVersionUID = 1431738919356697887L;
    public String dataId;
    public long performId;
    public long priceId;

    public SkuSaveInfo() {
    }

    public SkuSaveInfo(String str, long j, long j2) {
        this.dataId = str;
        this.performId = j;
        this.priceId = j2;
    }
}
