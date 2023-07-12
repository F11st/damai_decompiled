package com.alibaba.ha.bizerrorreporter;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.alibaba.ha.bizerrorreporter.module.BizErrorModule;
import com.alibaba.ha.bizerrorreporter.module.SendModule;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.utils.AppUtils;
import com.alibaba.motu.tbrest.utils.Base64;
import com.alibaba.motu.tbrest.utils.GzipUtils;
import com.alibaba.motu.tbrest.utils.StringUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class BizErrorBuilder {
    public static final String _JAVA_VERSION = "";
    public static final String _MAGIC = "BizErrorReporterSDK";
    public static final String _NATIVE_VERSION = "160509105620";
    public static final String _TARGET = "beta";
    public static final String _VERSION = "1.0.0.0";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class JavaExceptionReportBuilder extends SimpleJavaExceptionReportBuilder {
        JavaExceptionReportBuilder(BizErrorModule bizErrorModule, Context context, String str, long j, String str2) {
            super(bizErrorModule, context, str, j, str2);
        }

        @Override // com.alibaba.ha.bizerrorreporter.BizErrorBuilder.SimpleJavaExceptionReportBuilder, com.alibaba.ha.bizerrorreporter.BizErrorBuilder.ReportBuilder
        protected String buildContent() {
            StringBuilder sb = new StringBuilder();
            sb.append(buildThrowable());
            sb.append(buildExtraInfo());
            sb.append(buildStatus());
            sb.append(buildStorageinfo());
            sb.append(buildFileDescriptor());
            if (this.mThrowable instanceof OutOfMemoryError) {
                sb.append(buildApplictionMeminfo());
            }
            sb.append(buildLogcat());
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    class SimpleJavaExceptionReportBuilder extends ReportBuilder {
        String mExceptionContent;
        BizErrorModule mExceptionModule;
        Thread mThread;
        Throwable mThrowable;

        SimpleJavaExceptionReportBuilder(BizErrorModule bizErrorModule, Context context, String str, long j, String str2) {
            super();
            String str3;
            this.mExceptionModule = bizErrorModule;
            this.mThrowable = bizErrorModule.throwable;
            this.mThread = bizErrorModule.thread;
            this.mExceptionContent = bizErrorModule.exceptionDetail;
            if (this.mExtraInfo == null) {
                this.mExtraInfo = new HashMap();
            }
            String str4 = bizErrorModule.exceptionId;
            if (str4 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionId, str4);
            }
            String str5 = bizErrorModule.exceptionCode;
            if (str5 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionCode, str5);
            }
            String str6 = bizErrorModule.exceptionVersion;
            if (str6 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionVersion, str6);
            }
            String str7 = bizErrorModule.exceptionArg1;
            if (str7 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionArg1, str7);
            }
            String str8 = bizErrorModule.exceptionArg2;
            if (str8 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionArg2, str8);
            }
            String str9 = bizErrorModule.exceptionArg3;
            if (str9 != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionArg3, str9);
            }
            if (this.mThrowable != null && (str3 = this.mExceptionContent) != null) {
                this.mExtraInfo.put(BizErrorConstants.exceptionDetail, str3);
            }
            Map<String, Object> map = bizErrorModule.exceptionArgs;
            if (map != null && map.size() > 0) {
                this.mExtraInfo.putAll(map);
            }
            this.mContext = context;
            this.mReportName = str;
            this.mTimestamp = j;
            this.mReportType = str2;
        }

        @Override // com.alibaba.ha.bizerrorreporter.BizErrorBuilder.ReportBuilder
        protected String buildContent() {
            return buildThrowable() + buildExtraInfo();
        }

        protected String buildThread(Thread thread) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(String.format("Thread Name: '%s'\n", thread.getName()));
                sb.append(String.format("\"%s\" prio=%d tid=%d %s\n", thread.getName(), Integer.valueOf(thread.getPriority()), Long.valueOf(thread.getId()), thread.getState()));
                StackTraceElement[] stackTrace = thread.getStackTrace();
                int length = stackTrace.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("\tat %s\n", stackTrace[i].toString()));
                }
            } catch (Exception e) {
                Log.e(BizErrorConstants.LOGTAG, "dumpThread", e);
            }
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v9, types: [java.io.Closeable] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        protected java.lang.String buildThrowable() {
            /*
                r8 = this;
                java.lang.String r0 = "MotuCrashAdapter"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                com.alibaba.ha.bizerrorreporter.BizErrorReporter r2 = com.alibaba.ha.bizerrorreporter.BizErrorReporter.getInstance()     // Catch: java.lang.Exception -> La0
                android.content.Context r3 = r8.mContext     // Catch: java.lang.Exception -> La0
                java.lang.String r2 = r2.getProcessName(r3)     // Catch: java.lang.Exception -> La0
                java.lang.String r3 = "Process Name: '%s' \n"
                r4 = 1
                java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> La0
                r6 = 0
                r5[r6] = r2     // Catch: java.lang.Exception -> La0
                java.lang.String r2 = java.lang.String.format(r3, r5)     // Catch: java.lang.Exception -> La0
                r1.append(r2)     // Catch: java.lang.Exception -> La0
                java.lang.Thread r2 = r8.mThread     // Catch: java.lang.Exception -> La0
                java.lang.String r3 = "Thread Name: '%s' \n"
                if (r2 == 0) goto L36
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> La0
                java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> La0
                r4[r6] = r2     // Catch: java.lang.Exception -> La0
                java.lang.String r2 = java.lang.String.format(r3, r4)     // Catch: java.lang.Exception -> La0
                r1.append(r2)     // Catch: java.lang.Exception -> La0
                goto L43
            L36:
                java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> La0
                java.lang.String r4 = "adapter no thread name"
                r2[r6] = r4     // Catch: java.lang.Exception -> La0
                java.lang.String r2 = java.lang.String.format(r3, r2)     // Catch: java.lang.Exception -> La0
                r1.append(r2)     // Catch: java.lang.Exception -> La0
            L43:
                java.lang.String r2 = "Back traces starts.\n"
                r1.append(r2)     // Catch: java.lang.Exception -> La0
                r2 = 0
                java.lang.Throwable r3 = r8.mThrowable     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
                if (r3 == 0) goto L67
                java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
                r3.<init>()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
                java.lang.Throwable r2 = r8.mThrowable     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L9b
                java.io.PrintStream r4 = new java.io.PrintStream     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L9b
                r4.<init>(r3)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L9b
                r2.printStackTrace(r4)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L9b
                java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L9b
                r1.append(r2)     // Catch: java.lang.Exception -> L65 java.lang.Throwable -> L9b
                r2 = r3
                goto L79
            L65:
                r2 = move-exception
                goto L86
            L67:
                java.lang.String r3 = r8.mExceptionContent     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
                if (r3 == 0) goto L74
                r1.append(r3)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
                java.lang.String r3 = "\n"
                r1.append(r3)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
                goto L79
            L74:
                java.lang.String r3 = "无内容"
                r1.append(r3)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            L79:
                com.alibaba.motu.tbrest.utils.AppUtils.closeQuietly(r2)     // Catch: java.lang.Exception -> La0
                goto L8e
            L7d:
                r3 = move-exception
                r7 = r3
                r3 = r2
                r2 = r7
                goto L9c
            L82:
                r3 = move-exception
                r7 = r3
                r3 = r2
                r2 = r7
            L86:
                java.lang.String r4 = "print throwable"
                android.util.Log.e(r0, r4, r2)     // Catch: java.lang.Throwable -> L9b
                com.alibaba.motu.tbrest.utils.AppUtils.closeQuietly(r3)     // Catch: java.lang.Exception -> La0
            L8e:
                java.lang.String r2 = "Back traces end.\n"
                r1.append(r2)     // Catch: java.lang.Exception -> La0
                java.lang.String r2 = r8.buildEnd()     // Catch: java.lang.Exception -> La0
                r1.append(r2)     // Catch: java.lang.Exception -> La0
                goto La6
            L9b:
                r2 = move-exception
            L9c:
                com.alibaba.motu.tbrest.utils.AppUtils.closeQuietly(r3)     // Catch: java.lang.Exception -> La0
                throw r2     // Catch: java.lang.Exception -> La0
            La0:
                r2 = move-exception
                java.lang.String r3 = "write throwable"
                android.util.Log.e(r0, r3, r2)
            La6:
                java.lang.Thread r2 = r8.mThread
                if (r2 == 0) goto Lb8
                java.lang.String r2 = r8.buildThread(r2)     // Catch: java.lang.Exception -> Lb2
                r1.append(r2)     // Catch: java.lang.Exception -> Lb2
                goto Lb8
            Lb2:
                r2 = move-exception
                java.lang.String r3 = "write thread"
                android.util.Log.e(r0, r3, r2)
            Lb8:
                java.lang.String r0 = r8.buildEnd()
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ha.bizerrorreporter.BizErrorBuilder.SimpleJavaExceptionReportBuilder.buildThrowable():java.lang.String");
        }
    }

    public static String buildReportName(String str, String str2, long j, String str3, String str4) {
        String replaceUnderscore = replaceUnderscore(str2);
        String replaceUnderscore2 = replaceUnderscore(str3);
        return "BizErrorReporterSDK_1.0.0.0_df_df_df_df_" + str + JSMethod.NOT_SET + replaceUnderscore + JSMethod.NOT_SET + String.valueOf(j) + JSMethod.NOT_SET + getGMT8Time(j) + JSMethod.NOT_SET + StringUtils.defaultString(replaceUnderscore2, "df") + JSMethod.NOT_SET + str4 + ".log";
    }

    public static String getGMT8Time(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(new Date(j));
        } catch (Exception e) {
            Log.e(BizErrorConstants.LOGTAG, "getGMT8Time", e);
            return "";
        }
    }

    public static String replaceUnderscore(String str) {
        return str != null ? str.replace(JSMethod.NOT_SET, "&#95;") : "";
    }

    public SendModule build(Context context, BizErrorModule bizErrorModule) {
        SendModule sendModule = new SendModule();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            sendModule.sendContent = Base64.encodeBase64String(GzipUtils.gzip(new JavaExceptionReportBuilder(bizErrorModule, context, buildReportName(SendService.getInstance().appKey, SendService.getInstance().appVersion, currentTimeMillis, "catch", "BUSINESS"), currentTimeMillis, "BUSINESS").builder().getBytes()));
            sendModule.aggregationType = String.valueOf(bizErrorModule.aggregationType);
            sendModule.businessType = bizErrorModule.businessType;
            sendModule.eventId = BizErrorConstants.EVENTID_61005;
            sendModule.sendFlag = BizErrorConstants.SEND_FLAG;
            return sendModule;
        } catch (Exception e) {
            Log.e(BizErrorConstants.LOGTAG, "base64 and gzip err", e);
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public abstract class ReportBuilder {
        Context mContext;
        Map<String, Object> mExtraInfo;
        long mFull;
        long mLimit;
        long mReject;
        String mReportName;
        String mReportType;
        long mTimestamp;
        long mWrite;

        public ReportBuilder() {
        }

        protected String buildApplictionMeminfo() {
            return "appliction meminfo:\n" + AppUtils.dumpMeminfo(this.mContext) + buildEnd();
        }

        protected String buildBanner() {
            StringBuilder sb = new StringBuilder();
            sb.append("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n");
            sb.append(String.format("Basic Information: 'pid: %d/tid: %d/logver: 2/time: %s/cpu: %s/cpu hardware: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), Long.valueOf(this.mTimestamp), Build.getCPU_ABI(), android.os.Build.HARDWARE));
            sb.append(String.format("Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.getMODEL(), Build.VERSION.getRELEASE(), Integer.valueOf(Build.VERSION.SDK_INT)));
            sb.append(String.format("Build fingerprint: '" + android.os.Build.FINGERPRINT + "'\n", new Object[0]));
            sb.append(String.format("Runtime Information: 'start: %s/maxheap: %s'\n", BizErrorReporter.getInstance().reporterStartTime, Long.valueOf(Runtime.getRuntime().maxMemory())));
            sb.append(String.format("Application Information: 'version: %s/subversion: %s/buildseq: %s'\n", SendService.getInstance().appVersion, SendService.getInstance().appVersion, android.os.Build.ID));
            sb.append(String.format("%s Information: 'version: %s/nativeseq: %s/javaseq: %s/target: %s'\n", BizErrorBuilder._MAGIC, BizErrorBuilder._VERSION, "160509105620", "", "beta"));
            sb.append("Report Name: " + this.mReportName + org.apache.commons.lang3.StringUtils.LF);
            sb.append("UUID: " + UUID.randomUUID().toString().toLowerCase() + org.apache.commons.lang3.StringUtils.LF);
            sb.append("Log Type: " + this.mReportType + org.apache.commons.lang3.StringUtils.LF);
            sb.append(buildEnd());
            return sb.toString();
        }

        protected abstract String buildContent();

        protected String buildDone() {
            return String.format("Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Long.valueOf(this.mFull), Long.valueOf(this.mWrite), Long.valueOf(this.mLimit), Long.valueOf(this.mReject)) + String.format("log end: %s\n", BizErrorBuilder.getGMT8Time(System.currentTimeMillis()));
        }

        protected String buildEnd() {
            return "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n";
        }

        protected String buildExtraInfo() {
            StringBuilder sb = new StringBuilder();
            Map<String, Object> map = this.mExtraInfo;
            if (map != null && !map.isEmpty()) {
                try {
                    sb.append("extrainfo:\n");
                    for (String str : this.mExtraInfo.keySet()) {
                        sb.append(String.format("%s: %s\n", str, this.mExtraInfo.get(str)));
                    }
                } catch (Exception e) {
                    Log.e(BizErrorConstants.LOGTAG, "write extral info", e);
                }
                sb.append(buildEnd());
            }
            return sb.toString();
        }

        protected String buildFileDescriptor() {
            StringBuilder sb = new StringBuilder();
            File[] fileArr = null;
            try {
                fileArr = new File("/proc/self/fd").listFiles();
                if (fileArr != null) {
                    sb.append(String.format("opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), 1024));
                } else {
                    sb.append("[DEBUG] listFiles failed!\n");
                }
            } catch (Exception e) {
                Log.e(BizErrorConstants.LOGTAG, "print file descriptor.", e);
            }
            if (fileArr != null) {
                try {
                    if (fileArr.length >= 1024) {
                        sb.append("opened files:\n");
                        StringBuilder sb2 = new StringBuilder();
                        try {
                            for (File file : fileArr) {
                                sb2.append(file.getName());
                                sb2.append(" -> ");
                                sb2.append(file.getCanonicalPath());
                                sb2.append(org.apache.commons.lang3.StringUtils.LF);
                            }
                        } catch (Exception e2) {
                            Log.e(BizErrorConstants.LOGTAG, "print file descriptor.", e2);
                        }
                        sb.append(sb2.toString());
                    }
                } catch (Exception e3) {
                    Log.e(BizErrorConstants.LOGTAG, "print file descriptor.", e3);
                }
            }
            sb.append(buildEnd());
            return sb.toString();
        }

        protected String buildLogcat() {
            return buildLogcat(null, 100) + buildLogcat("events", 100);
        }

        protected String buildStatus() {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("meminfo:\n");
                sb.append(StringUtils.defaultString(AppUtils.getMeminfo(), "") + org.apache.commons.lang3.StringUtils.LF);
                sb.append(buildEnd());
            } catch (Exception e) {
                Log.e(BizErrorConstants.LOGTAG, "write meminfo.", e);
            }
            try {
                sb.append("status:\n");
                sb.append(StringUtils.defaultString(AppUtils.getMyStatus(), "") + org.apache.commons.lang3.StringUtils.LF);
                sb.append(buildEnd());
            } catch (Exception e2) {
                Log.e(BizErrorConstants.LOGTAG, "adapter write status.", e2);
            }
            try {
                sb.append("virtual machine:\nMaxMemory: " + Runtime.getRuntime().maxMemory() + " TotalMemory: " + Runtime.getRuntime().totalMemory() + " FreeMemory: " + Runtime.getRuntime().freeMemory() + org.apache.commons.lang3.StringUtils.LF);
            } catch (Exception e3) {
                Log.e(BizErrorConstants.LOGTAG, "adapter write virtual machine info.", e3);
            }
            sb.append(buildEnd());
            return sb.toString();
        }

        protected String buildStorageinfo() {
            return "storageinfo:\n" + AppUtils.dumpStorage(this.mContext) + buildEnd();
        }

        public String builder() {
            return buildBanner() + buildContent() + buildDone();
        }

        private String buildLogcat(String str, int i) {
            Process process;
            BufferedReader bufferedReader;
            Throwable th;
            Exception exc;
            int i2;
            int i3;
            int i4;
            int i5;
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            arrayList.add("logcat");
            arrayList.add("-d");
            if (StringUtils.isBlank(str)) {
                sb.append("logcat main: \n");
            } else {
                sb.append("logcat " + str + ": \n");
                arrayList.add("-b");
                arrayList.add(str);
            }
            arrayList.add("-v");
            arrayList.add("threadtime");
            if (i < 0) {
                sb.append("[DEBUG] custom java logcat lines count is 0!\n");
            } else {
                arrayList.add("-t");
                arrayList.add(String.valueOf(i));
                BufferedReader bufferedReader2 = null;
                try {
                    process = new ProcessBuilder(new String[0]).command(arrayList).redirectErrorStream(true).start();
                } catch (Exception e) {
                    Log.e(BizErrorConstants.LOGTAG, "exec logcat", e);
                    process = null;
                }
                if (process == null) {
                    sb.append("[DEBUG] exec logcat failed!\n");
                } else {
                    try {
                        try {
                            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 8192);
                            i4 = 0;
                            i5 = 0;
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    i4++;
                                    if (i5 < i) {
                                        sb.append(readLine + org.apache.commons.lang3.StringUtils.LF);
                                        i5++;
                                    }
                                } catch (Exception e2) {
                                    i2 = i4;
                                    bufferedReader2 = bufferedReader;
                                    i3 = i5;
                                    exc = e2;
                                    Log.e(BizErrorConstants.LOGTAG, "print log.", exc);
                                    AppUtils.closeQuietly(bufferedReader2);
                                    i4 = i2;
                                    i5 = i3;
                                    sb.append(String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i4), Integer.valueOf(i5)));
                                    sb.append(buildEnd());
                                    return sb.toString();
                                } catch (Throwable th2) {
                                    th = th2;
                                    AppUtils.closeQuietly(bufferedReader);
                                    throw th;
                                }
                            }
                            AppUtils.closeQuietly(bufferedReader);
                        } catch (Throwable th3) {
                            bufferedReader = bufferedReader2;
                            th = th3;
                        }
                    } catch (Exception e3) {
                        exc = e3;
                        i2 = 0;
                        i3 = 0;
                    }
                    sb.append(String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i4), Integer.valueOf(i5)));
                }
            }
            sb.append(buildEnd());
            return sb.toString();
        }
    }
}
