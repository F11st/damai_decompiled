package com.youku.d.a;

import com.youku.core.context.YoukuContext;
import com.youku.phone.ruleswitcher.RuleSwitcher;

/* compiled from: Taobao */
/* renamed from: com.youku.d.a.a */
/* loaded from: classes2.dex */
public class C7899a {
    private static int a = 1048575;

    public static boolean a(String str, double d) {
        return RuleSwitcher.switchHit(YoukuContext.getApplicationContext(), str, d);
    }
}
