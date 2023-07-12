package tb;

import anetwork.channel.Header;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class sb implements Header {
    private final String a;
    private final String b;

    public sb(String str, String str2) {
        if (str != null) {
            this.a = str;
            this.b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    @Override // anetwork.channel.Header
    public String getName() {
        return this.a;
    }

    @Override // anetwork.channel.Header
    public String getValue() {
        return this.b;
    }
}
