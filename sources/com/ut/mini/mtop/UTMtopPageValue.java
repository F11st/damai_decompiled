package com.ut.mini.mtop;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class UTMtopPageValue implements Serializable {
    @JSONField(name = "pg")
    public String page;
    @JSONField(name = "v")
    public List<String> valueList;

    UTMtopPageValue() {
    }
}
