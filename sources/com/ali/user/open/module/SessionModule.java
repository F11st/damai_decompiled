package com.ali.user.open.module;

import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.service.impl.SessionManager;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SessionModule {
    public static void init() {
        KernelContext.registerService(new Class[]{SessionService.class}, SessionManager.INSTANCE, null);
    }
}
