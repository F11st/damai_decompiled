package com.ali.user.open.core.model;

import java.util.ArrayList;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RpcRequest {
    public String mtopInstanceName;
    public int mtopInstanceType;
    public String target;
    public String version;
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = false;
    public boolean SHOW_LOGIN_UI = true;
    public ArrayList<String> paramNames = new ArrayList<>();
    public ArrayList<Object> paramValues = new ArrayList<>();

    public void addParam(String str, Object obj) {
        this.paramNames.add(str);
        this.paramValues.add(obj);
    }

    public String toString() {
        return "RpcRequest [target=" + this.target + ", version=" + this.version + ", params=" + jn1.ARRAY_END_STR;
    }
}
