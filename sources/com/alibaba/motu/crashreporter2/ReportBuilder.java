package com.alibaba.motu.crashreporter2;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.alibaba.motu.crashreporter.Configuration;
import com.alibaba.motu.crashreporter.Constants;
import com.alibaba.motu.crashreporter.CrashReport;
import com.alibaba.motu.crashreporter.LogUtil;
import com.alibaba.motu.crashreporter.ReporterContext;
import com.alibaba.motu.crashreporter2.CatcherManager;
import com.alibaba.motu.tbrest.utils.AppUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import tb.fy1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ReportBuilder {
    Configuration mConfiguration;
    Context mContext;
    ReporterContext mReporterContext;
    StorageManager mStorageManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class ANRReportPrintWrite extends FileReportPrintWrite {
        CatcherManager.ANRCatcher.TracesFinder mTracesFinder;

        ANRReportPrintWrite(Context context, ReporterContext reporterContext, Configuration configuration, String str, long j, File file, CatcherManager.ANRCatcher.TracesFinder tracesFinder) {
            super(context, reporterContext, configuration, str, "anr", j, file, null);
            this.mTracesFinder = tracesFinder;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        private void printTraces() {
            BufferedReader bufferedReader;
            try {
                if (this.needBanner) {
                    write("traces starts.\n");
                }
                bufferedReader = null;
            } catch (Exception e) {
                LogUtil.e("write traces.", e);
            }
            try {
                try {
                    File file = this.mTracesFinder.mSystemTraceFile;
                    boolean endsWith = file.getName().endsWith("anr.log");
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    bufferedReader = 1;
                    int i = 0;
                    boolean z = false;
                    boolean z2 = true;
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            i++;
                            if (!this.mTracesFinder.strStartFlag.equals(readLine)) {
                                z = true;
                            }
                            if (!z) {
                                if (i > 5) {
                                    break;
                                }
                            } else {
                                write(readLine + StringUtils.LF);
                                if (z2 && !this.needBanner && readLine.startsWith("--- --- --- --- --- --- --- --- --- ")) {
                                    write("isForegroundANR:" + this.isForegroundANR + StringUtils.LF);
                                    z2 = false;
                                }
                            }
                            if (this.mTracesFinder.strEndFlag.equals(readLine) && !endsWith) {
                                break;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            LogUtil.e("read anr file.", e);
                            AppUtils.closeQuietly(bufferedReader);
                            bufferedReader = bufferedReader;
                            write("traces end.\n");
                            printEnd();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            AppUtils.closeQuietly(bufferedReader);
                            throw th;
                        }
                    }
                    AppUtils.closeQuietly(bufferedReader2);
                } catch (IOException e3) {
                    e = e3;
                }
                write("traces end.\n");
                printEnd();
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.alibaba.motu.crashreporter2.ReportBuilder.ReportPrintWrite
        protected void printContent() {
            printTraces();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public abstract class FileReportPrintWrite extends ReportPrintWrite {
        File mReportFile;

        public FileReportPrintWrite(Context context, ReporterContext reporterContext, Configuration configuration, String str, String str2, long j, File file, Map<String, Object> map) {
            super();
            this.mContext = context;
            this.mReporterContext = reporterContext;
            this.mConfiguration = configuration;
            this.mReportName = str;
            this.mReportType = str2;
            this.mTimestamp = j;
            this.mReportFile = file;
            this.mExtraInfo = map;
            if (file.exists()) {
                file.delete();
            }
            try {
                this.mOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                LogUtil.e("create fileOutputStream.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public final class UncaughtExceptionReportPrintWrite extends FileReportPrintWrite {
        Thread mThread;
        Throwable mThrowable;

        UncaughtExceptionReportPrintWrite(Context context, ReporterContext reporterContext, Configuration configuration, String str, long j, File file, Throwable th, Thread thread, Map<String, Object> map) {
            super(context, reporterContext, configuration, str, "java", j, file, map);
            this.mThrowable = th;
            this.mThread = thread;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:4|5|(2:6|7)|8|9|10|11|12|13) */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
            com.alibaba.motu.crashreporter.LogUtil.e("write thread", r0);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void printThrowable() {
            /*
                r6 = this;
                java.lang.String r0 = "Process Name: '%s' \n"
                r1 = 1
                java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L69
                com.alibaba.motu.crashreporter.ReporterContext r3 = r6.mReporterContext     // Catch: java.lang.Exception -> L69
                java.lang.String r4 = "PROCESS_NAME"
                java.lang.String r3 = r3.getProperty(r4)     // Catch: java.lang.Exception -> L69
                r4 = 0
                r2[r4] = r3     // Catch: java.lang.Exception -> L69
                java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch: java.lang.Exception -> L69
                r6.write(r0)     // Catch: java.lang.Exception -> L69
                java.lang.String r0 = "Thread Name: '%s' \n"
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L69
                java.lang.Thread r2 = r6.mThread     // Catch: java.lang.Exception -> L69
                java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L69
                r1[r4] = r2     // Catch: java.lang.Exception -> L69
                java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch: java.lang.Exception -> L69
                r6.write(r0)     // Catch: java.lang.Exception -> L69
                java.lang.String r0 = "Back traces starts.\n"
                r6.write(r0)     // Catch: java.lang.Exception -> L69
                r0 = 0
                java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L51
                r1.<init>()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L51
                java.lang.Throwable r0 = r6.mThrowable     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L64
                java.io.PrintStream r2 = new java.io.PrintStream     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L64
                r2.<init>(r1)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L64
                r0.printStackTrace(r2)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L64
                java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L64
                r6.write(r0)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L64
            L46:
                com.alibaba.motu.tbrest.utils.AppUtils.closeQuietly(r1)     // Catch: java.lang.Exception -> L69
                goto L5b
            L4a:
                r0 = move-exception
                goto L55
            L4c:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
                goto L65
            L51:
                r1 = move-exception
                r5 = r1
                r1 = r0
                r0 = r5
            L55:
                java.lang.String r2 = "print throwable"
                com.alibaba.motu.crashreporter.LogUtil.e(r2, r0)     // Catch: java.lang.Throwable -> L64
                goto L46
            L5b:
                java.lang.String r0 = "Back traces end.\n"
                r6.write(r0)     // Catch: java.lang.Exception -> L69
                r6.printEnd()     // Catch: java.lang.Exception -> L69
                goto L6f
            L64:
                r0 = move-exception
            L65:
                com.alibaba.motu.tbrest.utils.AppUtils.closeQuietly(r1)     // Catch: java.lang.Exception -> L69
                throw r0     // Catch: java.lang.Exception -> L69
            L69:
                r0 = move-exception
                java.lang.String r1 = "write throwable"
                com.alibaba.motu.crashreporter.LogUtil.e(r1, r0)
            L6f:
                java.lang.Thread r0 = r6.mThread     // Catch: java.lang.Exception -> L79
                java.lang.String r0 = com.alibaba.motu.tbrest.utils.AppUtils.dumpThread(r0)     // Catch: java.lang.Exception -> L79
                r6.write(r0)     // Catch: java.lang.Exception -> L79
                goto L7f
            L79:
                r0 = move-exception
                java.lang.String r1 = "write thread"
                com.alibaba.motu.crashreporter.LogUtil.e(r1, r0)
            L7f:
                r6.printEnd()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.motu.crashreporter2.ReportBuilder.UncaughtExceptionReportPrintWrite.printThrowable():void");
        }

        @Override // com.alibaba.motu.crashreporter2.ReportBuilder.ReportPrintWrite
        protected void printContent() {
            printThrowable();
            printExtraInfo();
            printStatus();
            printStorageinfo();
            printFileDescriptor();
            if (this.mThrowable instanceof OutOfMemoryError) {
                printApplictionMeminfo();
            }
            printLogcat();
        }
    }

    public ReportBuilder(Context context, ReporterContext reporterContext, Configuration configuration, StorageManager storageManager) {
        this.mContext = context;
        this.mReporterContext = reporterContext;
        this.mConfiguration = configuration;
        this.mStorageManager = storageManager;
    }

    private File[] listProcessCrashReportFile() {
        FileFilter fileFilter;
        if ("true".equals(SwitcherUtils.valueOf("delDupAnr", "false"))) {
            fileFilter = new FileFilter() { // from class: com.alibaba.motu.crashreporter2.ReportBuilder.1
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.getName().endsWith("java.log") || file.getName().endsWith("native.log");
                }
            };
        } else {
            fileFilter = new FileFilter() { // from class: com.alibaba.motu.crashreporter2.ReportBuilder.2
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return file.getName().endsWith("java.log") || file.getName().endsWith("native.log") || file.getName().endsWith("anr.log");
                }
            };
        }
        return this.mStorageManager.listProcessTombstoneFiles(fileFilter);
    }

    public CrashReport buildANRReport(CatcherManager.ANRCatcher.TracesFinder tracesFinder, Map<String, String> map) {
        clearCrashRepoterFile();
        long currentTimeMillis = System.currentTimeMillis();
        String buildReportName = CrashReport.buildReportName(this.mReporterContext.getPropertyAndSet(Constants.UTDID), this.mReporterContext.getProperty(Constants.APP_KEY), this.mReporterContext.getProperty(Constants.APP_VERSION), currentTimeMillis, fy1.HOME_SCAN_PAGE, "anr");
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile(buildReportName);
        new ANRReportPrintWrite(this.mContext, this.mReporterContext, this.mConfiguration, buildReportName, currentTimeMillis, processTombstoneFile, tracesFinder).print();
        return CrashReport.buildCrashReport(this.mContext, processTombstoneFile, this.mReporterContext, false);
    }

    public CrashReport buildNativeExceptionReport(File file, Map<String, String> map) {
        clearCrashRepoterFile();
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile(CrashReport.buildReportName(this.mReporterContext.getPropertyAndSet(Constants.UTDID), this.mReporterContext.getProperty(Constants.APP_KEY), this.mReporterContext.getProperty(Constants.APP_VERSION), System.currentTimeMillis(), fy1.HOME_SCAN_PAGE, "native"));
        file.renameTo(processTombstoneFile);
        return CrashReport.buildCrashReport(this.mContext, processTombstoneFile, this.mReporterContext, false);
    }

    public CrashReport buildSigQuitANRReport(CatcherManager.ANRCatcher.TracesFinder tracesFinder, boolean z) {
        clearCrashRepoterFile();
        long currentTimeMillis = System.currentTimeMillis();
        String buildReportName = CrashReport.buildReportName(this.mReporterContext.getPropertyAndSet(Constants.UTDID), this.mReporterContext.getProperty(Constants.APP_KEY), this.mReporterContext.getProperty(Constants.APP_VERSION), currentTimeMillis, fy1.HOME_SCAN_PAGE, "anr");
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile(buildReportName);
        ANRReportPrintWrite aNRReportPrintWrite = new ANRReportPrintWrite(this.mContext, this.mReporterContext, this.mConfiguration, buildReportName, currentTimeMillis, processTombstoneFile, tracesFinder);
        aNRReportPrintWrite.needBanner = false;
        aNRReportPrintWrite.isForegroundANR = z;
        aNRReportPrintWrite.print();
        return CrashReport.buildCrashReport(this.mContext, processTombstoneFile, this.mReporterContext, false);
    }

    public CrashReport buildUncaughtExceptionReport(Throwable th, Thread thread, Map<String, Object> map) {
        clearCrashRepoterFile();
        long currentTimeMillis = System.currentTimeMillis();
        String buildReportName = CrashReport.buildReportName(this.mReporterContext.getPropertyAndSet(Constants.UTDID), this.mReporterContext.getProperty(Constants.APP_KEY), this.mReporterContext.getProperty(Constants.APP_VERSION), currentTimeMillis, "true".equals(map.get(Constants.REPORT_IGNORE)) ? "ignore" : "catch", "java");
        File processTombstoneFile = this.mStorageManager.getProcessTombstoneFile(buildReportName);
        new UncaughtExceptionReportPrintWrite(this.mContext, this.mReporterContext, this.mConfiguration, buildReportName, currentTimeMillis, processTombstoneFile, th, thread, map).print();
        return CrashReport.buildCrashReport(this.mContext, processTombstoneFile, this.mReporterContext, true);
    }

    public void clearCrashRepoterFile() {
        try {
            File[] listProcessCrashReportFile = listProcessCrashReportFile();
            if (listProcessCrashReportFile == null || listProcessCrashReportFile.length <= 20) {
                return;
            }
            List<File> asList = Arrays.asList(listProcessCrashReportFile);
            Collections.sort(asList, new Comparator<File>() { // from class: com.alibaba.motu.crashreporter2.ReportBuilder.3
                @Override // java.util.Comparator
                public int compare(File file, File file2) {
                    if (file.lastModified() > file2.lastModified()) {
                        return -1;
                    }
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
            });
            for (File file : asList) {
            }
        } catch (Exception e) {
            LogUtil.e("clear crashReport file", e);
        }
    }

    public CrashReport[] listProcessCrashReport() {
        File[] listProcessCrashReportFile = listProcessCrashReportFile();
        if (listProcessCrashReportFile == null || listProcessCrashReportFile.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listProcessCrashReportFile) {
            arrayList.add(CrashReport.buildCrashReport(this.mContext, file, this.mReporterContext, false));
        }
        return (CrashReport[]) arrayList.toArray(new CrashReport[0]);
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public abstract class ReportPrintWrite {
        Configuration mConfiguration;
        Context mContext;
        Map<String, Object> mExtraInfo;
        long mFull;
        long mLimit;
        OutputStream mOutputStream;
        long mReject;
        String mReportName;
        String mReportType;
        ReporterContext mReporterContext;
        long mTimestamp;
        long mWrite;
        boolean needBanner = true;
        boolean isForegroundANR = false;

        public ReportPrintWrite() {
        }

        protected void close() {
            AppUtils.closeQuietly(this.mOutputStream);
        }

        public void print() {
            if (this.needBanner) {
                printBanner();
            }
            printContent();
            printDone();
        }

        protected void printApplictionMeminfo() {
            write("appliction meminfo:\n");
            write(AppUtils.dumpMeminfo(this.mContext));
            printEnd();
        }

        protected void printBanner() {
            write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n");
            write(String.format("Basic Information: 'pid: %d/tid: %d/logver: 2/time: %s/cpu: %s/cpu hardware: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), Long.valueOf(this.mTimestamp), Build.getCPU_ABI(), android.os.Build.HARDWARE));
            write(String.format("Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.getMODEL(), Build.VERSION.getRELEASE(), Integer.valueOf(Build.VERSION.SDK_INT)));
            write(String.format("Build fingerprint: '" + android.os.Build.FINGERPRINT + "'\n", new Object[0]));
            write(String.format("Runtime Information: 'start: %s/maxheap: %s'\n", this.mReporterContext.getProperty(Constants.STARTUP_TIME), Long.valueOf(Runtime.getRuntime().maxMemory())));
            write(String.format("Application Information: 'version: %s/subversion: %s/buildseq: %s'\n", this.mReporterContext.getProperty(Constants.APP_VERSION), this.mReporterContext.getProperty(Constants.APP_SUBVERSION), this.mReporterContext.getProperty(Constants.APP_BUILD)));
            write(String.format("%s Information: 'version: %s/nativeseq: %s/javaseq: %s/target: %s'\n", CrashReporter._MAGIC, CrashReporter._VERSION, "160509105620", "", "beta"));
            write("Report Name: " + this.mReportName + StringUtils.LF);
            write("UUID: " + UUID.randomUUID().toString().toLowerCase() + StringUtils.LF);
            write("Log Type: " + this.mReportType + StringUtils.LF);
            printEnd();
        }

        protected abstract void printContent();

        protected void printDone() {
            write(String.format("Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Long.valueOf(this.mFull), Long.valueOf(this.mWrite), Long.valueOf(this.mLimit), Long.valueOf(this.mReject)));
            write(String.format("log end: %s\n", AppUtils.getGMT8Time(System.currentTimeMillis())));
        }

        protected void printEnd() {
            write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
        }

        protected void printExtraInfo() {
            Map<String, Object> map = this.mExtraInfo;
            if (map == null || map.isEmpty()) {
                return;
            }
            try {
                write("extrainfo:\n");
                for (String str : this.mExtraInfo.keySet()) {
                    write(String.format("%s: %s\n", str, this.mExtraInfo.get(str)));
                }
            } catch (Exception e) {
                LogUtil.e("write extral info", e);
            }
            printEnd();
        }

        protected void printFileDescriptor() {
            int i = this.mConfiguration.getInt(Configuration.fileDescriptorLimit, 900);
            File[] fileArr = null;
            try {
                fileArr = new File("/proc/self/fd").listFiles();
                if (fileArr != null) {
                    write(String.format("opened file count: %d, write limit: %d.\n", Integer.valueOf(fileArr.length), Integer.valueOf(i)));
                } else {
                    write("[DEBUG] listFiles failed!\n");
                }
            } catch (Exception e) {
                LogUtil.e("print file descriptor.", e);
            }
            if (fileArr != null) {
                try {
                    if (fileArr.length >= i) {
                        write("opened files:\n");
                        StringBuilder sb = new StringBuilder();
                        try {
                            for (File file : fileArr) {
                                sb.append(file.getName());
                                sb.append(" -> ");
                                sb.append(file.getCanonicalPath());
                                sb.append(StringUtils.LF);
                            }
                        } catch (Exception e2) {
                            LogUtil.e("print file descriptor.", e2);
                        }
                        write(sb.toString());
                    }
                } catch (Exception e3) {
                    LogUtil.e("print file descriptor.", e3);
                }
            }
            printEnd();
        }

        protected void printLogcat() {
            int i = this.mConfiguration.getInt(Configuration.mainLogLineLimit, 2000);
            int i2 = this.mConfiguration.getInt(Configuration.eventsLogLineLimit, 200);
            printLogcat(null, i);
            printLogcat("events", i2);
        }

        protected void printStatus() {
            try {
                write("meminfo:\n");
                write(com.alibaba.motu.tbrest.utils.StringUtils.defaultString(AppUtils.getMeminfo(), "") + StringUtils.LF);
                printEnd();
            } catch (Exception e) {
                LogUtil.e("write meminfo.", e);
            }
            try {
                write("status:\n");
                write(com.alibaba.motu.tbrest.utils.StringUtils.defaultString(AppUtils.getMyStatus(), "") + StringUtils.LF);
                printEnd();
            } catch (Exception e2) {
                LogUtil.e("write status.", e2);
            }
            try {
                write("virtual machine:\nMaxMemory: " + Runtime.getRuntime().maxMemory() + " TotalMemory: " + Runtime.getRuntime().totalMemory() + " FreeMemory: " + Runtime.getRuntime().freeMemory() + StringUtils.LF);
            } catch (Exception e3) {
                LogUtil.e("write virtual machine info.", e3);
            }
            printEnd();
        }

        protected void printStorageinfo() {
            write("storageinfo:\n");
            write(AppUtils.dumpStorage(this.mContext));
            printEnd();
        }

        protected void write(String str) {
            byte[] bArr = new byte[0];
            try {
                bArr = str.getBytes("UTF-8");
            } catch (Exception e) {
                LogUtil.e("write.", e);
            }
            this.mFull += bArr.length;
            try {
                LogUtil.i(str);
            } catch (Exception unused) {
            }
            try {
                this.mOutputStream.write(str.getBytes("UTF-8"));
                this.mWrite += bArr.length;
                this.mOutputStream.flush();
            } catch (Exception e2) {
                LogUtil.e("write.", e2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable, java.io.BufferedReader] */
        private void printLogcat(String str, int i) {
            Process process;
            ?? r3;
            Throwable th;
            Exception exc;
            int i2;
            int i3;
            int i4;
            int i5;
            ArrayList arrayList = new ArrayList();
            arrayList.add("logcat");
            arrayList.add("-d");
            if (com.alibaba.motu.tbrest.utils.StringUtils.isBlank(str)) {
                write("logcat main: \n");
            } else {
                write("logcat " + str + ": \n");
                arrayList.add("-b");
                arrayList.add(str);
            }
            arrayList.add("-v");
            arrayList.add("threadtime");
            if (i < 0) {
                write("[DEBUG] custom java logcat lines count is 0!\n");
            } else {
                arrayList.add("-t");
                arrayList.add(String.valueOf(i));
                String str2 = null;
                Closeable closeable = null;
                try {
                    process = new ProcessBuilder(new String[0]).command(arrayList).redirectErrorStream(true).start();
                } catch (Exception e) {
                    LogUtil.e("exec logcat", e);
                    process = null;
                }
                try {
                    if (process == null) {
                        write("[DEBUG] exec logcat failed!\n");
                    } else {
                        try {
                            r3 = new BufferedReader(new InputStreamReader(process.getInputStream()), 8192);
                            i4 = 0;
                            i5 = 0;
                            while (true) {
                                try {
                                    String readLine = r3.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    i4++;
                                    if (i5 < i) {
                                        write(readLine + StringUtils.LF);
                                        i5++;
                                    }
                                } catch (Exception e2) {
                                    i2 = i4;
                                    closeable = r3;
                                    i3 = i5;
                                    exc = e2;
                                    LogUtil.e("print log.", exc);
                                    AppUtils.closeQuietly(closeable);
                                    i4 = i2;
                                    i5 = i3;
                                    str2 = String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i4), Integer.valueOf(i5));
                                    write(str2);
                                    printEnd();
                                } catch (Throwable th2) {
                                    th = th2;
                                    AppUtils.closeQuietly(r3);
                                    throw th;
                                }
                            }
                            AppUtils.closeQuietly(r3);
                        } catch (Exception e3) {
                            exc = e3;
                            i2 = 0;
                            i3 = 0;
                        }
                        str2 = String.format("[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i4), Integer.valueOf(i5));
                        write(str2);
                    }
                } catch (Throwable th3) {
                    r3 = str2;
                    th = th3;
                }
            }
            printEnd();
        }
    }
}
