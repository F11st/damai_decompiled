package com.uc.webview.export.business;

import android.content.Context;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.business.setup.C7184a;
import com.uc.webview.export.business.setup.C7200p;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.setup.UCSetupException;
import com.uc.webview.export.internal.setup.af;
import com.uc.webview.export.utility.SetupTask;

/* compiled from: Taobao */
@Api
/* loaded from: classes11.dex */
public class BusinessWrapper {
    private static final String a = "BusinessWrapper";
    private static C7184a b;

    private static synchronized C7184a a() {
        C7184a c7184a;
        synchronized (BusinessWrapper.class) {
            if (b == null) {
                C7184a c7184a2 = new C7184a();
                b = c7184a2;
                c7184a2.setup(UCCore.OPTION_ROOT_TASK_KEY, (Object) "BusinessSetupTask");
            }
            c7184a = b;
        }
        return c7184a;
    }

    public static void decompressAndODex(Context context, String str, String str2, String str3, boolean z, boolean z2, long j, ValueCallback<Bundle> valueCallback) throws UCSetupException {
        ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) decompressAndODex("CONTEXT", context).setup(UCCore.OPTION_UCM_ZIP_FILE, (Object) str)).setup(UCCore.OPTION_DECOMPRESS_ROOT_DIR, (Object) str3)).setup(UCCore.OPTION_ZIP_FILE_TYPE, (Object) str2)).setup(UCCore.OPTION_DELETE_AFTER_EXTRACT, (Object) Boolean.valueOf(z))).setup("o_flag_odex_done", (Object) Boolean.valueOf(z2))).setup(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK, (Object) valueCallback)).start(j);
    }

    public static SetupTask setup(String str, Object obj) {
        af.EnumC7264a enumC7264a = af.EnumC7264a.INIT_START;
        Object[] objArr = new Object[1];
        objArr[0] = obj instanceof Context ? obj : null;
        af.a(enumC7264a, objArr);
        return (C7184a) a().setup(str, obj);
    }

    public static SetupTask decompressAndODex(String str, Object obj) throws UCSetupException {
        return (SetupTask) ((SetupTask) ((SetupTask) ((SetupTask) new C7200p().setup(UCCore.OPTION_SETUP_THREAD_PRIORITY, (Object) (-20))).setup(UCCore.OPTION_ROOT_TASK_KEY, (Object) "decompressAndODex")).setup(UCCore.OPTION_CONTINUE_ODEX_ON_DECOMPRESSED, (Object) Boolean.TRUE)).setup(str, obj);
    }
}
