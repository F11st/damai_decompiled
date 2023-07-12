package com.ali.user.mobile.rpc.login.model;

import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SessionModel extends AliUserResponseData implements Comparator {
    public String showLoginId;
    public int site;

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        long j = ((SessionModel) obj).loginTime;
        long j2 = ((SessionModel) obj2).loginTime;
        if (j > j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }
}
