package com.youku.kubus;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes2.dex */
public class Request {
    public long id;
    public String mode;
    public Object params;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request(long j) {
        this(j, null);
    }

    public Request(long j, Object obj) {
        this.id = j;
        this.mode = "sync";
        this.params = obj;
    }

    public Request(long j, Object obj, String str) {
        this.id = j;
        this.mode = str;
        this.params = obj;
    }
}
