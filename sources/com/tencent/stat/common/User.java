package com.tencent.stat.common;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class User {
    private String mac;
    private int type;
    private String uid;

    public User(String str, String str2, int i) {
        this.uid = null;
        this.mac = null;
        this.uid = str;
        this.mac = str2;
        this.type = i;
    }

    public String getMac() {
        return this.mac;
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public void setType(int i) {
        this.type = i;
    }
}
