package com.ali.user.open.ucc.module;

import android.text.TextUtils;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.UccServiceImpl;
import com.ali.user.open.ucc.remote.RemoteUccServiceDelegate;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccModule {
    private static boolean handleWebviewDir() {
        try {
            return TextUtils.equals("true", OrangeConfig.getInstance().getConfig("login4android", "handleWebviewDir", "true"));
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void init() {
        CommonUtils.sendUT("init_step_ucc_init_ucc_module");
        if (ConfigManager.getInstance().isMultiProcessEnable) {
            KernelContext.registerService(new Class[]{UccService.class}, RemoteUccServiceDelegate.getInstance(), null);
        } else {
            KernelContext.registerService(new Class[]{UccService.class}, UccServiceImpl.getInstance(), null);
        }
        ConfigManager.getInstance().handleWebviewDir = handleWebviewDir();
    }
}
