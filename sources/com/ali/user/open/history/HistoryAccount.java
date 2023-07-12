package com.ali.user.open.history;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class HistoryAccount {
    public String email;
    public String mobile;
    public String nick;
    public String t;
    public String tokenKey;
    public String userId;

    public HistoryAccount() {
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString() {
        return "" + this.nick;
    }

    public HistoryAccount(String str, String str2, String str3, String str4, String str5) {
        this.userId = str;
        this.tokenKey = str2;
        this.nick = str3;
        this.mobile = str4;
        this.email = str5;
    }
}
