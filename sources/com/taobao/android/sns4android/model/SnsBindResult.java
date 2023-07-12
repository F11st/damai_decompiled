package com.taobao.android.sns4android.model;

import com.ali.user.mobile.rpc.RpcResponse;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SnsBindResult extends RpcResponse<Void> {
    public String errorCode;
    public String errorMsg;
    public JSONObject module;
    public String success;
}
