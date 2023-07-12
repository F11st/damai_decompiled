package com.uc.webview.export.internal.setup;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.uc.webview.export.CDParamKeys;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.C7337j;
import com.uc.webview.export.internal.utility.C7349p;
import com.uc.webview.export.internal.utility.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class aw extends UCSubSetupTask<aw, aw> {
    private static final String a = aw.class.getSimpleName();
    private static Object b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.setup.aw$a */
    /* loaded from: classes11.dex */
    public static class C7267a {
        private static long A = 0;
        private static long B = 0;
        private static long C = 0;
        private static long D = 0;
        private static long E = 0;
        private static long F = 0;
        private static long G = 0;
        private static long H = 0;
        private static long I = 0;
        private static long J = 0;
        private static long a = 1;
        private static long b = 2;
        private static long c = 4;
        private static long d = 8;
        private static long e = 16;
        private static long f = 32;
        private static long g = 64;
        private static long h = 128;
        private static long i = 256;
        private static long j = 512;
        private static long k = 1024;
        private static long l = 2048;
        private static long m = 4096;
        private static long n = 8192;
        private static long o = 16384;
        private static long p = 32768;
        private static long q;
        private static long r;
        private static long s;
        private static long t;
        private static long u;
        private static long v;
        private static long w;
        private static long x;
        private static long y;
        private static long z;

        static {
            long j2 = 1 << 1;
            q = j2;
            long j3 = j2 << 1;
            r = j3;
            long j4 = j3 << 1;
            s = j4;
            long j5 = j4 << 1;
            t = j5;
            u = j5 << 1;
            long j6 = 1 << 1;
            v = j6;
            long j7 = j6 << 1;
            w = j7;
            long j8 = j7 << 1;
            x = j8;
            long j9 = j8 << 1;
            y = j9;
            z = j9 << 1;
            long j10 = 1 << 1;
            A = j10;
            long j11 = j10 << 1;
            B = j11;
            long j12 = j11 << 1;
            C = j12;
            long j13 = j12 << 1;
            D = j13;
            long j14 = j13 << 1;
            E = j14;
            long j15 = j14 << 1;
            F = j15;
            long j16 = j15 << 1;
            G = j16;
            long j17 = j16 << 1;
            H = j17;
            long j18 = j17 << 1;
            I = j18;
            J = j18 << 1;
        }

        private C7267a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:157:0x07e6, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_TIMECOST, java.lang.Long.toString(r18));
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x07ef, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_PROCESS, java.lang.Long.toString(r5));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_EXCEPIION, java.lang.Long.toString(r3));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_AUTHORITY, java.lang.Long.toString(r7));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r22, java.lang.Long.toString(r9));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r24, java.lang.Long.toString(r25));
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(com.uc.webview.export.internal.interfaces.IWaStat.SHARE_CORE_COPY_TO_SDCARD_TASK_RESULT_COPY, java.lang.Long.toString(r12));
         */
        /* JADX WARN: Code restructure failed: missing block: B:159:0x0823, code lost:
            if (r12 != com.uc.webview.export.internal.setup.aw.C7267a.B) goto L187;
         */
        /* JADX WARN: Code restructure failed: missing block: B:160:0x0825, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r16);
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x082d, code lost:
            if (r12 != com.uc.webview.export.internal.setup.aw.C7267a.G) goto L190;
         */
        /* JADX WARN: Code restructure failed: missing block: B:163:0x082f, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r17);
         */
        /* JADX WARN: Code restructure failed: missing block: B:164:0x0833, code lost:
            com.uc.webview.export.internal.interfaces.IWaStat.WaStat.stat(r23);
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x0836, code lost:
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, ".shareCoreDecFile fProcessStat: " + r5);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, r1 + r3);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, ".shareCoreDecFile fSdcardAuthoryStat: " + r7);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, ".shareCoreDecFile fDeleteStat: " + r9);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            com.uc.webview.export.internal.utility.Log.d(r0, ".shareCoreDecFile fPreconditionStat: " + r25);
            r0 = com.uc.webview.export.internal.setup.aw.a;
            r1 = new java.lang.StringBuilder(r29);
         */
        /* JADX WARN: Removed duplicated region for block: B:232:0x0b85  */
        /* JADX WARN: Removed duplicated region for block: B:233:0x0b89  */
        /* JADX WARN: Removed duplicated region for block: B:269:0x0d2b  */
        /* JADX WARN: Removed duplicated region for block: B:270:0x0d2f  */
        /* JADX WARN: Removed duplicated region for block: B:284:0x0e08  */
        /* JADX WARN: Removed duplicated region for block: B:288:0x0e16  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void a(android.content.Context r57, java.lang.String r58, int r59) {
            /*
                Method dump skipped, instructions count: 3734
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.aw.C7267a.a(android.content.Context, java.lang.String, int):void");
        }

        /* synthetic */ C7267a(byte b2) {
            this();
        }

        private static long a(int i2) {
            long j2 = q;
            try {
                if (UCCyclone.DecFileOrign.Update != i2) {
                    if (C7349p.f()) {
                        j2 = r;
                    } else {
                        UCMRunningInfo totalLoadedUCM = UCSetupTask.getTotalLoadedUCM();
                        if (totalLoadedUCM == null) {
                            j2 = s;
                        } else if (totalLoadedUCM.isShareCore) {
                            j2 = u;
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d(aw.a, ".checkPrecondition", th);
            }
            return j2;
        }

        private static boolean a(Context context, File file, C7337j.C7338a c7338a) {
            if (c7338a != null) {
                IWaStat.WaStat.stat(IWaStat.SHARE_CORE_SDK_VERSION_CONFIG, UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_PUSH_UCM_VERSIONS));
            }
            return !C7349p.a(C7337j.a(context, file, UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_PUSH_UCM_VERSIONS), c7338a));
        }

        private static long a(Context context, File file) {
            Log.d(aw.a, ".deleteHistoryCoreFiles hostSubFolder:" + file.getAbsolutePath());
            long j2 = v;
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (UCCyclone.detectZipByFileType(file2.getAbsolutePath()) && !C7337j.a(file2) && !C7337j.a(context, file2, (C7337j.C7338a) null)) {
                            file2.delete();
                            j2 = x;
                            Log.d(aw.a, ".deleteHistoryCoreFiles verifySignature failure! file: " + file2.getAbsolutePath());
                        } else if (!a(context, file2, (C7337j.C7338a) null)) {
                            file2.delete();
                            j2 = y;
                            Log.d(aw.a, ".deleteHistoryCoreFiles verifyCoreCompressFileVersion failure! file: " + file2.getAbsolutePath());
                        }
                    }
                    return j2;
                }
                return z;
            } catch (Throwable th) {
                try {
                    j2 = w;
                    Log.d(aw.a, ".deleteHistoryCoreFiles", th);
                    return j2;
                } catch (Throwable unused) {
                    return j2;
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:67:0x0225
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        private static long a(android.content.Context r19, java.io.File r20, java.lang.String r21) {
            /*
                Method dump skipped, instructions count: 664
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.setup.aw.C7267a.a(android.content.Context, java.io.File, java.lang.String):long");
        }

        public static void a(Context context, boolean z2, boolean z3, Callable<Boolean> callable) {
            String[] split;
            Log.d(aw.a, ".statDevicesHasShareCore isUCCore: " + z2 + ", hasUpdSource: " + z3 + ", wifiChecker: " + callable);
            try {
                if ("0".equals((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_SC_HIS", 4);
                    int i2 = (callable == null || !callable.call().booleanValue()) ? sharedPreferences.getInt("NO_WIFI_HISTORY", 0) + 1 : 0;
                    int i3 = (z3 && z2) ? 0 : sharedPreferences.getInt("INVALID_UPD_HISTORY", 0) + 1;
                    Log.d(aw.a, ".statDevicesHasShareCore noWifiTimes: " + i2 + ", invalidUpdateTimes: " + i3);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putInt("NO_WIFI_HISTORY", i2);
                    edit.putInt("INVALID_UPD_HISTORY", i3);
                    edit.apply();
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_NO_WIFI_TIMES, Integer.toString(i2));
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_INVALID_UPDATE_TIMES, Integer.toString(i3));
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_CURRENT_IS_UC_CORE, z2 ? "1" : "0");
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_HAS_UPD_SOURCE, z3 ? "1" : "0");
                    if (!C7337j.b(context)) {
                        Log.d(aw.a, ".statDevicesHasShareCore Sdcard配置及权限校验失败");
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList();
                    arrayList.add(context.getPackageName());
                    String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_CLIENT_SPECIAL_HOST_PKG_NAME_LIST);
                    if (!C7349p.a(param)) {
                        for (String str : param.split(CDParamKeys.CD_VALUE_STRING_SPLITER)) {
                            if (!C7349p.a(str) && !str.equals(context.getPackageName())) {
                                arrayList.add(str);
                            }
                        }
                    }
                    for (String str2 : arrayList) {
                        File c2 = C7337j.c(str2);
                        if (!c2.exists()) {
                            Log.d(aw.a, ".statDevicesHasShareCore " + c2.getAbsolutePath() + " not exists.");
                        } else {
                            File[] listFiles = c2.listFiles();
                            if (listFiles != null && listFiles.length != 0) {
                                Log.d(aw.a, ".statDevicesHasShareCore " + str2 + "," + str2.hashCode() + AVFSCacheConstants.COMMA_SEP + listFiles.length);
                                StringBuilder sb = new StringBuilder("csc_dhsc_");
                                sb.append(str2.hashCode());
                                IWaStat.WaStat.stat(sb.toString(), Integer.toString(listFiles.length));
                            }
                            Log.d(aw.a, ".statDevicesHasShareCore " + c2.getAbsolutePath() + " empty.");
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d(aw.a, ".statDevicesHasShareCore", th);
            }
        }
    }

    static /* synthetic */ String a() {
        return a;
    }

    @Override // com.uc.webview.export.internal.setup.UCAsyncTask, java.lang.Runnable
    public void run() {
        Log.d(a, ".run");
        try {
            Context applicationContext = getContext().getApplicationContext();
            if (C7349p.a((Boolean) getOption(UCCore.OPTION_ONLY_STAT_DEVICES_HAS_CORE_SHARE))) {
                synchronized (b) {
                    new C7267a((byte) 0);
                    C7267a.a(applicationContext, C7349p.a((Boolean) getOption(UCCore.OPTION_CURRENT_IS_UC_CORE)), C7349p.a((Boolean) getOption(UCCore.OPTION_HAS_UPDATE_SOURCE)), (Callable) getOption(UCCore.OPTION_DOWNLOAD_CHECKER));
                }
                return;
            }
            String param = UCCore.getParam(CDParamKeys.CD_KEY_SHARE_CORE_HOST_COMPRESSED_CORE_FILE_PATH);
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_RUN_PV);
            synchronized (b) {
                if (!C7349p.a(param)) {
                    IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_RUN_CALL_PV);
                    new C7267a((byte) 0);
                    C7267a.a(applicationContext, param, UCCyclone.DecFileOrign.Other);
                }
                new C7267a((byte) 0);
                C7267a.a(applicationContext, C7349p.a((Boolean) getOption(UCCore.OPTION_CURRENT_IS_UC_CORE)), C7349p.a((Boolean) getOption(UCCore.OPTION_HAS_UPDATE_SOURCE)), (Callable) getOption(UCCore.OPTION_DOWNLOAD_CHECKER));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        String str3 = a;
        Log.d(str3, ".shareDownloadFile(" + str + AVFSCacheConstants.COMMA_SEP + str2 + jn1.BRACKET_END_STR);
        IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_UPD_PV);
        if (C7349p.a(str2)) {
            return;
        }
        synchronized (b) {
            IWaStat.WaStat.stat(IWaStat.SHARE_CORE_COPY_TASK_UPD_CALL_PV);
            new C7267a((byte) 0);
            C7267a.a(context, str2, UCCyclone.DecFileOrign.Update);
        }
    }
}
