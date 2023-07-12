package com.youku.d;

import android.content.Context;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import com.youku.config.YoukuConfig;
import com.youku.core.context.YoukuContext;
import com.youku.service.util.YoukuUtil;
import com.youku.usercenter.passport.api.TaobaoLoginImpl;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopSetting;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    private static Mtop a;
    private static Mtop b;
    private static volatile boolean c;
    private static String d;

    public static synchronized Mtop a() {
        Mtop mtop;
        synchronized (a.class) {
            if (!c) {
                a(YoukuContext.getApplicationContext(), YoukuContext.getVersionName(), YoukuUtil.getTTID(), null);
            }
            a(a);
            mtop = a;
        }
        return mtop;
    }

    private static void a(Context context, String str, String str2) {
        EnvModeEnum envModeEnum;
        MtopSetting.setAppKeyIndex("havana-instance-taobao", 0, 2);
        MtopSetting.setAppVersion("havana-instance-taobao", str);
        MtopConfig mtopConfig = new MtopConfig("havana-instance-taobao");
        try {
            if (YoukuConfig.getEnvType() != 0) {
                if (YoukuConfig.getEnvType() == 1) {
                    envModeEnum = EnvModeEnum.PREPARE;
                } else if (YoukuConfig.getEnvType() == 2) {
                    envModeEnum = EnvModeEnum.TEST;
                }
                mtopConfig.envMode = envModeEnum;
                Mtop registerTtid = Mtop.instance("havana-instance-taobao", context, str2, 0, mtopConfig).registerTtid(str2);
                b = registerTtid;
                RemoteLogin.setLoginImpl(registerTtid, new TaobaoLoginImpl());
                return;
            }
            RemoteLogin.setLoginImpl(registerTtid, new TaobaoLoginImpl());
            return;
        } catch (Throwable th) {
            com.youku.httpcommunication.a.a("MTopManager", th);
            return;
        }
        envModeEnum = EnvModeEnum.ONLINE;
        mtopConfig.envMode = envModeEnum;
        Mtop registerTtid2 = Mtop.instance("havana-instance-taobao", context, str2, 0, mtopConfig).registerTtid(str2);
        b = registerTtid2;
    }

    private static void a(Context context, String str, String str2, String str3) {
        b(context, str, str2, str3);
        a(context, str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r1 != r3) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r1 != r3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(mtopsdk.mtop.intf.Mtop r4) {
        /*
            int r0 = com.youku.config.YoukuConfig.getEnvType()
            if (r0 != 0) goto L7
            return
        L7:
            if (r4 == 0) goto L49
            r0 = 0
            int r1 = com.youku.config.YoukuConfig.getEnvType()
            r2 = 1
            if (r1 != r2) goto L1d
            mtopsdk.mtop.global.MtopConfig r1 = r4.getMtopConfig()
            mtopsdk.mtop.domain.EnvModeEnum r1 = r1.envMode
            mtopsdk.mtop.domain.EnvModeEnum r3 = mtopsdk.mtop.domain.EnvModeEnum.PREPARE
            if (r1 == r3) goto L1d
        L1b:
            r0 = r3
            goto L2f
        L1d:
            int r1 = com.youku.config.YoukuConfig.getEnvType()
            r3 = 2
            if (r1 != r3) goto L2f
            mtopsdk.mtop.global.MtopConfig r1 = r4.getMtopConfig()
            mtopsdk.mtop.domain.EnvModeEnum r1 = r1.envMode
            mtopsdk.mtop.domain.EnvModeEnum r3 = mtopsdk.mtop.domain.EnvModeEnum.TEST
            if (r1 == r3) goto L2f
            goto L1b
        L2f:
            if (r0 == 0) goto L49
            java.lang.Class<mtopsdk.mtop.intf.Mtop> r1 = mtopsdk.mtop.intf.Mtop.class
            java.lang.String r3 = "mtopConfig"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r3)     // Catch: java.lang.Exception -> L45
            r1.setAccessible(r2)     // Catch: java.lang.Exception -> L45
            java.lang.Object r4 = r1.get(r4)     // Catch: java.lang.Exception -> L45
            mtopsdk.mtop.global.MtopConfig r4 = (mtopsdk.mtop.global.MtopConfig) r4     // Catch: java.lang.Exception -> L45
            r4.envMode = r0     // Catch: java.lang.Exception -> L45
            goto L49
        L45:
            r4 = move-exception
            r4.printStackTrace()
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.d.a.a(mtopsdk.mtop.intf.Mtop):void");
    }

    public static synchronized String b() {
        String str;
        synchronized (a.class) {
            str = d;
        }
        return str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(8:14|(1:16)(2:17|(1:19))|4|5|6|7|8|9)|3|4|5|6|7|8|9) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
        com.youku.httpcommunication.a.a("MTopManager", r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            mtopsdk.common.log.TLogAdapterImpl r8 = new mtopsdk.common.log.TLogAdapterImpl
            r8.<init>()
            mtopsdk.common.util.TBSdkLog.setLogAdapter(r8)
            java.lang.String r8 = "INNER"
            java.lang.String r0 = "ENABLE_NEW_DEVICE_ID"
            r1 = 0
            mtopsdk.mtop.intf.MtopSetting.setEnableProperty(r8, r0, r1)
            java.lang.String r0 = "ENABLE_NOTIFY_SESSION_RET"
            r2 = 1
            mtopsdk.mtop.intf.MtopSetting.setEnableProperty(r8, r0, r2)
            r0 = 2
            mtopsdk.mtop.intf.MtopSetting.setAppKeyIndex(r8, r1, r0)
            mtopsdk.mtop.intf.MtopSetting.setAppVersion(r8, r6)
            java.lang.String r6 = "acs.youku.com"
            java.lang.String r3 = "pre-acs.youku.com"
            java.lang.String r4 = "daily-acs.youku.com"
            mtopsdk.mtop.intf.MtopSetting.setMtopDomain(r8, r6, r3, r4)
            com.youku.d.a.d = r7
            mtopsdk.mtop.global.MtopConfig r6 = new mtopsdk.mtop.global.MtopConfig
            r6.<init>(r8)
            int r3 = com.youku.config.YoukuConfig.getEnvType()
            if (r3 != 0) goto L38
        L33:
            mtopsdk.mtop.domain.EnvModeEnum r0 = mtopsdk.mtop.domain.EnvModeEnum.ONLINE
        L35:
            r6.envMode = r0
            goto L4a
        L38:
            int r3 = com.youku.config.YoukuConfig.getEnvType()
            if (r3 != r2) goto L41
            mtopsdk.mtop.domain.EnvModeEnum r0 = mtopsdk.mtop.domain.EnvModeEnum.PREPARE
            goto L35
        L41:
            int r3 = com.youku.config.YoukuConfig.getEnvType()
            if (r3 != r0) goto L33
            mtopsdk.mtop.domain.EnvModeEnum r0 = mtopsdk.mtop.domain.EnvModeEnum.TEST
            goto L35
        L4a:
            mtopsdk.mtop.intf.Mtop r5 = mtopsdk.mtop.intf.Mtop.instance(r8, r5, r7, r1, r6)
            mtopsdk.mtop.intf.Mtop r5 = r5.registerTtid(r7)
            com.youku.d.a.a = r5
            com.youku.usercenter.passport.api.LoginImpl r6 = new com.youku.usercenter.passport.api.LoginImpl     // Catch: java.lang.Throwable -> L5d
            r6.<init>()     // Catch: java.lang.Throwable -> L5d
            com.taobao.tao.remotebusiness.login.RemoteLogin.setLoginImpl(r5, r6)     // Catch: java.lang.Throwable -> L5d
            goto L63
        L5d:
            r5 = move-exception
            java.lang.String r6 = "MTopManager"
            com.youku.httpcommunication.a.a(r6, r5)
        L63:
            com.youku.d.a.c = r2
            com.youku.httpcommunication.c.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.d.a.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
