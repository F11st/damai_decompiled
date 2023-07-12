package tb;

import anetwork.channel.Param;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class mh2 implements Param {
    private String a;
    private String b;

    public mh2(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // anetwork.channel.Param
    public String getKey() {
        return this.a;
    }

    @Override // anetwork.channel.Param
    public String getValue() {
        return this.b;
    }
}
