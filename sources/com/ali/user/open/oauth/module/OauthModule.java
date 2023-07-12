package com.ali.user.open.oauth.module;

import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.oauth.OauthServiceImpl;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OauthModule {
    public static void init() {
        CommonUtils.sendUT("init_step_ucc_init_oauth_module");
        KernelContext.registerService(new Class[]{OauthService.class}, new OauthServiceImpl(), null);
    }
}
