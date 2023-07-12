package com.uc.webview.export.cyclone.service;

import android.content.Context;
import com.taobao.weex.ui.component.WXComponent;
import com.uc.webview.export.cyclone.Constant;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCKnownException;
import com.uc.webview.export.cyclone.UCLibrary;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.cyclone.UCService;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class UCVmsizeImpl implements UCVmsize {
    private static final String LOG_TAG = "UCVmsizeImpl";
    private static boolean mSoIsLoaded;
    private static UCKnownException mSoIsLoadedException;

    static {
        try {
            UCService.registerImpl(UCVmsize.class, new UCVmsizeImpl());
        } catch (Throwable th) {
            UCLogger create = UCLogger.create(WXComponent.PROP_FS_WRAP_CONTENT, LOG_TAG);
            if (create != null) {
                create.print("UCVmsizeImpl register exception:" + th, new Throwable[0]);
            }
        }
    }

    private static synchronized void loadSo(Context context) {
        synchronized (UCVmsizeImpl.class) {
            if (mSoIsLoaded) {
                return;
            }
            UCKnownException uCKnownException = mSoIsLoadedException;
            if (uCKnownException == null) {
                UCLibrary.load(context, UCCyclone.genFile(context, null, "libvmsize", ".so", 24713491L, "e3d7b7107d5f402c1dde1a3930f7d7da", UCVmsizeImplConstant.genCodes(), new Object[0]).getAbsolutePath(), null);
                mSoIsLoaded = true;
                return;
            }
            throw uCKnownException;
        }
    }

    private static native int nativeSaveChromiumReservedSpace(long j);

    @Override // com.uc.webview.export.cyclone.service.UCServiceInterface
    public int getServiceVersion() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.uc.webview.export.cyclone.service.UCVmsize
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long saveChromiumReservedSpace(android.content.Context r10) throws java.lang.Exception {
        /*
            r9 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r3 = 21
            if (r0 < r3) goto Lcf
            r3 = 27
            if (r0 <= r3) goto Le
            goto Lcf
        Le:
            java.lang.String r0 = "android.webkit.WebViewFactory"
            java.lang.Class r0 = java.lang.Class.forName(r0)
            java.lang.String r3 = "sAddressSpaceReserved"
            java.lang.reflect.Field r3 = r0.getDeclaredField(r3)
            if (r3 == 0) goto Lcf
            boolean r4 = r3.isAccessible()
            r5 = 1
            if (r4 != 0) goto L26
            r3.setAccessible(r5)
        L26:
            r4 = 0
            boolean r6 = r3.getBoolean(r4)
            if (r6 == 0) goto Lcf
            java.lang.String r1 = "sProviderLock"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch: java.lang.Throwable -> L44
            if (r0 != 0) goto L36
            goto L44
        L36:
            boolean r1 = r0.isAccessible()     // Catch: java.lang.Throwable -> L44
            if (r1 != 0) goto L3f
            r0.setAccessible(r5)     // Catch: java.lang.Throwable -> L44
        L3f:
            java.lang.Object r0 = r0.get(r4)     // Catch: java.lang.Throwable -> L44
            goto L45
        L44:
            r0 = r9
        L45:
            boolean r1 = com.uc.webview.export.cyclone.service.UCVmsizeImpl.mSoIsLoaded
            if (r1 != 0) goto L4c
            loadSo(r10)
        L4c:
            monitor-enter(r0)
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> Lcc
            r3.set(r4, r10)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r10 = "android.os.SystemProperties"
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.String r1 = "getLong"
            r2 = 2
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r8 = 0
            r6[r8] = r7     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            r6[r5] = r7     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.reflect.Method r10 = r10.getDeclaredMethod(r1, r6)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            if (r10 == 0) goto Lbd
            boolean r1 = r10.isAccessible()     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            if (r1 != 0) goto L75
            r10.setAccessible(r5)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
        L75:
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.String r2 = "persist.sys.webview.vmsize"
            r1[r8] = r2     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            r6 = 104857600(0x6400000, double:5.1806538E-316)
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            r1[r5] = r2     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.Object r10 = r10.invoke(r4, r1)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.Long r10 = (java.lang.Long) r10     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            if (r10 == 0) goto Lb5
            long r1 = r10.longValue()     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            int r1 = nativeSaveChromiumReservedSpace(r1)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            if (r1 != 0) goto L9c
            long r1 = r10.longValue()     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lcc
            goto Lcf
        L9c:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.String r5 = "Error:"
            r2.<init>(r5)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            r2.append(r1)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.String r1 = " on nativeSaveChromiumReservedSpace"
            r2.append(r1)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            r10.<init>(r1)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            throw r10     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
        Lb5:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.String r1 = "SystemProperties.getLong invoke return null."
            r10.<init>(r1)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            throw r10     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
        Lbd:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            java.lang.String r1 = "SystemProperties.getLong not found."
            r10.<init>(r1)     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
            throw r10     // Catch: java.lang.Exception -> Lc5 java.lang.Throwable -> Lcc
        Lc5:
            r10 = move-exception
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Lcc
            r3.set(r4, r1)     // Catch: java.lang.Throwable -> Lcc
            throw r10     // Catch: java.lang.Throwable -> Lcc
        Lcc:
            r10 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lcc
            throw r10
        Lcf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.cyclone.service.UCVmsizeImpl.saveChromiumReservedSpace(android.content.Context):long");
    }

    @Override // com.uc.webview.export.cyclone.service.UCServiceInterface
    public String toString() {
        return "UCVmsizeImpl." + getServiceVersion();
    }
}
