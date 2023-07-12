package com.ali.user.open.tbauth;

import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.tbauth.handler.TbAuthActivityResultHandler;
import com.ali.user.open.tbauth.ui.support.ActivityResultHandler;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class TbAuthLifecycleAdapter {
    public static final String TAG = "Member.TbAuthLifecycleAdapter";

    public static void init() {
        CommonUtils.sendUT("init_step_ucc_init_tbauth_module");
        SDKLogger.d(TAG, "LoginLifecycle init ");
        KernelContext.registerService(new Class[]{ActivityResultHandler.class}, new TbAuthActivityResultHandler(), null);
        KernelContext.registerService(new Class[]{TbAuthService.class}, new TbAuthServiceImpl(), null);
    }
}
