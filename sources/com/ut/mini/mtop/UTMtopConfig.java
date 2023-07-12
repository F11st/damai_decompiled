package com.ut.mini.mtop;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.huawei.hms.opendevice.c;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class UTMtopConfig implements Serializable {
    @JSONField(name = "k")
    public String key;
    @JSONField(name = AdUtConstants.XAD_UT_ARG_MD)
    public String method;
    @JSONField(name = "n")
    public String name;
    @JSONField(name = c.a)
    public List<UTMtopPageValue> pageValueList;
    @JSONField(name = "sp")
    public String separator;
    @JSONField(name = "t")
    public List<Integer> targetList;

    UTMtopConfig() {
    }
}
