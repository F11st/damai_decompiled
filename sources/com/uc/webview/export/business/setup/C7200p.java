package com.uc.webview.export.business.setup;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.business.C7179a;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.setup.AbstractC7282l;
import com.uc.webview.export.internal.setup.C7268b;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.utility.SetupTask;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.business.setup.p */
/* loaded from: classes11.dex */
public class C7200p extends SetupTask {
    private static final String a = C7200p.class.getSimpleName();
    private static String d = "_odex_ready";
    private C7179a c = new C7179a();

    public static boolean b(String str, String str2) {
        try {
            File file = new File(UCCore.getExtractDirPath(str, str2));
            if (file.exists()) {
                return C7349p.a(file, d, false) != null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public void run() {
        long j;
        try {
            try {
                this.c.a(C7179a.C7182c.a);
                if (C7349p.h() && C7349p.a((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
                    UCCore.setGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION, "1");
                    SDKFactory.c(getContext());
                }
                String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
                if (str != null && !"0".equals(str) && (!C7349p.h() || !"1".equals(str))) {
                    this.c.a(C7179a.C7182c.d);
                    String str2 = a;
                    Log.d(str2, ".run stat: " + this.c.a);
                    j = this.c.a;
                } else {
                    String str3 = (String) getOption(UCCore.OPTION_UCM_ZIP_FILE);
                    String str4 = (String) getOption(UCCore.OPTION_DECOMPRESS_ROOT_DIR);
                    String str5 = a;
                    Log.d(str5, ".run decFilePath: " + str3 + " decRootDirPath: " + str4);
                    if (!C7349p.a(str3) && !C7349p.a(str4)) {
                        if (b(str4, str3)) {
                            Log.d(str5, "readyDecompressAndODex");
                            this.c.a(C7179a.C7182c.f);
                            Log.d(str5, ".run stat: " + this.c.a);
                            j = this.c.a;
                        } else {
                            AbstractC7282l abstractC7282l = (AbstractC7282l) new C7268b().setParent(this);
                            ConcurrentHashMap<String, ValueCallback<CALLBACK_TYPE>> concurrentHashMap = this.mCallbacks;
                            if (concurrentHashMap != 0) {
                                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                                    abstractC7282l.onEvent((String) entry.getKey(), (ValueCallback) new C7201q(this, entry));
                                }
                            }
                            ((AbstractC7282l) ((AbstractC7282l) abstractC7282l.onEvent("exception", (ValueCallback) new C7204t(this))).onEvent(UCCore.EVENT_DIE, (ValueCallback) new C7203s(this))).onEvent(UCCore.LEGACY_EVENT_SETUP, (ValueCallback) new C7202r(this, str4, str3));
                            this.c.a(C7179a.C7182c.b);
                            Integer num = (Integer) getOption(UCCore.OPTION_VERIFY_POLICY);
                            String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_VERIFY_POLICY);
                            if (CDParamKeys.CD_VALUE_VERIFY_ALL_HASH_ASYNC.equals(param)) {
                                num = Integer.valueOf(num.intValue() | UCCore.VERIFY_POLICY_ALL_FULL_HASH);
                            } else if (CDParamKeys.CD_VALUE_VERIFY_ALL_HASH_SYNC.equals(param)) {
                                num = Integer.valueOf(Integer.valueOf(num.intValue() | UCCore.VERIFY_POLICY_ALL_FULL_HASH).intValue() & Integer.MAX_VALUE);
                            }
                            ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) ((AbstractC7282l) abstractC7282l.setOptions(this.mOptions)).setup(UCCore.OPTION_VERIFY_POLICY, (Object) num)).setup(UCCore.OPTION_DEX_FILE_PATH, (Object) null)).setup(UCCore.OPTION_SO_FILE_PATH, (Object) null)).setup(UCCore.OPTION_RES_FILE_PATH, (Object) null)).setup(UCCore.OPTION_UCM_CFG_FILE, (Object) null)).setup(UCCore.OPTION_UCM_KRL_DIR, (Object) null)).setup(UCCore.OPTION_USE_SDK_SETUP, (Object) Boolean.valueOf(!C7349p.h()))).setup(UCCore.OPTION_CHECK_MULTI_CORE, (Object) Boolean.TRUE)).setup(UCCore.OPTION_ENABLE_LOAD_CLASS, (Object) Boolean.FALSE);
                            this.mCallbacks = null;
                            abstractC7282l.start();
                            String str6 = a;
                            Log.d(str6, ".run stat: " + this.c.a);
                            j = this.c.a;
                        }
                    }
                    this.c.a(C7179a.C7182c.e);
                    Log.d(str5, ".run stat: " + this.c.a);
                    j = this.c.a;
                }
            } catch (Throwable th) {
                String str7 = a;
                Log.d(str7, ".run stat: " + this.c.a);
                IWaStat.WaStat.stat(IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, Long.toString(this.c.a));
                throw th;
            }
        } catch (Throwable unused) {
            this.c.a(C7179a.C7182c.c);
            String str8 = a;
            Log.d(str8, ".run stat: " + this.c.a);
            j = this.c.a;
        }
        IWaStat.WaStat.stat(IWaStat.BUSINESS_DECOMPRESS_AND_ODEX, Long.toString(j));
    }

    public static void a(String str, String str2) {
        try {
            String extractDirPath = UCCore.getExtractDirPath(str, str2);
            File file = new File(str2);
            String decompressSourceHash = UCCyclone.getDecompressSourceHash(str2, file.length(), file.lastModified(), false);
            new File(extractDirPath, decompressSourceHash + d).createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(C7200p c7200p, AbstractC7282l abstractC7282l) {
        ValueCallback valueCallback = (ValueCallback) c7200p.getOption(UCCore.OPTION_DECOMPRESS_AND_ODEX_CALLBACK);
        if (valueCallback != null) {
            String event = abstractC7282l.getEvent();
            Bundle bundle = new Bundle();
            bundle.putString("event", event);
            if (abstractC7282l.getException() != null) {
                bundle.putInt("errorCode", abstractC7282l.getException().errCode());
                bundle.putString("msg", abstractC7282l.getException().getMessage());
            }
            String str = a;
            Log.d(str, "decompressAndODex bundle: " + bundle);
            valueCallback.onReceiveValue(bundle);
        }
    }
}
