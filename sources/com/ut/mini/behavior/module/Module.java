package com.ut.mini.behavior.module;

import com.alibaba.fastjson.annotation.JSONField;
import com.ut.mini.behavior.data.Data;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Module implements Serializable {
    @JSONField(name = "ds")
    public Data data;
    @JSONField(name = "n")
    public String name;
}
