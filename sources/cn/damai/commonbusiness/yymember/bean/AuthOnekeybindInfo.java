package cn.damai.commonbusiness.yymember.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AuthOnekeybindInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String returnCode;
    public String returnMessage;
    public MemberLoginInfo returnValue;
    public long timestamp;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class MemberLoginInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public String dmHavanaId;
        public String memberId;
        public String tbUserId;
    }
}
