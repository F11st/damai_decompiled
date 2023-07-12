package com.taobao.update.datasource.local;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateInfo implements Serializable {
    public String appVersion;
    public long lastUpdateTime;
    public Map<String, UpdateData> updateList = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class UpdateData implements Serializable {
        public String from;
        public long handleTime;
        public String name;
        public String subFrom;
        public boolean valid = true;
        public JSONObject value;
    }
}
