package com.ut.mini.behavior.data;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Data implements Serializable {
    @JSONField(name = "d")
    public List<Data> dataList;
    @JSONField(name = "k")
    public String key;
    @JSONField(name = "op")
    public String operator;
    @JSONField(name = "v")
    public Object value;
}
