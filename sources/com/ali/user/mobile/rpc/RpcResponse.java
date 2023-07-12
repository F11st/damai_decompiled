package com.ali.user.mobile.rpc;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RpcResponse<T> implements Serializable {
    public String actionType;
    public int code;
    public String codeGroup;
    public String message;
    public String msgCode;
    public String msgInfo;
    public T returnValue;

    public String toString() {
        return "RpcResponse{code=" + this.code + ", message='" + this.message + "', msgCode='" + this.msgCode + "', msgInfo='" + this.msgInfo + "', codeGroup='" + this.codeGroup + "', actionType='" + this.actionType + "', returnValue=" + this.returnValue + '}';
    }
}
