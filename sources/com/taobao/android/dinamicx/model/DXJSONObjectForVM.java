package com.taobao.android.dinamicx.model;

import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXJSONObjectForVM extends JSONObject {
    public static final String KEY = "DX_USER_DEFINED_DATA";

    public Object getData() {
        return get(KEY);
    }

    public void setData(Object obj) {
        put(KEY, obj);
    }
}
