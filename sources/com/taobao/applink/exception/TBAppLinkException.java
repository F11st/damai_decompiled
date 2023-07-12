package com.taobao.applink.exception;

import com.taobao.applink.c.C6680b;
import tb.uj2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TBAppLinkException extends Exception {
    public TBAppLinkException(EnumC6682a enumC6682a) {
        super(getErrorMsg(enumC6682a));
        C6680b.a().c(uj2.b(), String.valueOf(enumC6682a.f), null);
    }

    public TBAppLinkException(String str) {
        super(str);
        C6680b.a().c(uj2.b(), str, null);
    }

    private static String getErrorMsg(EnumC6682a enumC6682a) {
        if (enumC6682a == null) {
            return "AppLinkSDK error!";
        }
        return "AppLinkSDK error! code: " + enumC6682a.f;
    }
}
