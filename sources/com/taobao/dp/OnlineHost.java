package com.taobao.dp;

import java.security.InvalidParameterException;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes11.dex */
public final class OnlineHost {
    private static final int Custrom_Imdex = 3;
    private String mHost;
    private int mIndex;
    private String mName;
    public static final OnlineHost GENERAL = new OnlineHost("GENERAL", "ynuf.aliapp.org", 0);
    public static final OnlineHost USA = new OnlineHost("USA", "us.ynuf.aliapp.org", 1);
    public static final OnlineHost JAPAN = new OnlineHost("JAPAN", "ynuf.aliapp.org", 2);

    private OnlineHost(String str, String str2, int i) {
        this.mName = str;
        this.mHost = str2;
        this.mIndex = i;
    }

    public static OnlineHost valueof(String str) {
        if (str != null && str.length() != 0) {
            return new OnlineHost("", str, 3);
        }
        throw new InvalidParameterException("Invalid Host");
    }

    public String getHost() {
        return this.mHost;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getName() {
        return this.mName;
    }
}
