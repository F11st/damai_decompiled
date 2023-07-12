package com.xiaomi.clientreport.processor;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.clientreport.data.C7537a;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.C7594ab;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.clientreport.processor.e */
/* loaded from: classes11.dex */
public class C7552e {
    private static PerfClientReport a(PerfClientReport perfClientReport, String str) {
        long[] m597a;
        if (perfClientReport == null || (m597a = m597a(str)) == null) {
            return null;
        }
        perfClientReport.perfCounts = m597a[0];
        perfClientReport.perfLatencies = m597a[1];
        return perfClientReport;
    }

    private static PerfClientReport a(String str) {
        PerfClientReport perfClientReport = null;
        try {
            String[] m598a = m598a(str);
            if (m598a == null || m598a.length < 4 || TextUtils.isEmpty(m598a[0]) || TextUtils.isEmpty(m598a[1]) || TextUtils.isEmpty(m598a[2]) || TextUtils.isEmpty(m598a[3])) {
                return null;
            }
            perfClientReport = PerfClientReport.getBlankInstance();
            perfClientReport.production = Integer.parseInt(m598a[0]);
            perfClientReport.clientInterfaceId = m598a[1];
            perfClientReport.reportType = Integer.parseInt(m598a[2]);
            perfClientReport.code = Integer.parseInt(m598a[3]);
            return perfClientReport;
        } catch (Exception unused) {
            AbstractC7535b.c("parse per key error");
            return perfClientReport;
        }
    }

    public static String a(PerfClientReport perfClientReport) {
        return perfClientReport.production + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + perfClientReport.clientInterfaceId + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + perfClientReport.reportType + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + perfClientReport.code;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* renamed from: a  reason: collision with other method in class */
    private static HashMap<String, String> m596a(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return hashMap;
        }
        BufferedReader bufferedReader = 0;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("%%%");
                        bufferedReader = split.length;
                        if (bufferedReader >= 2) {
                            bufferedReader = 0;
                            bufferedReader = 0;
                            if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                                bufferedReader = split[0];
                                hashMap.put(bufferedReader, split[1]);
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        AbstractC7535b.a(e);
                        C7594ab.a(bufferedReader);
                        return hashMap;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        C7594ab.a(bufferedReader);
                        throw th;
                    }
                }
                C7594ab.a(bufferedReader2);
            } catch (Exception e2) {
                e = e2;
            }
            return hashMap;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f4  */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.Closeable, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.C7552e.a(android.content.Context, java.lang.String):java.util.List");
    }

    private static void a(String str, HashMap<String, String> hashMap) {
        BufferedWriter bufferedWriter;
        Throwable th;
        Exception e;
        if (TextUtils.isEmpty(str) || hashMap == null || hashMap.size() == 0) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception e2) {
            bufferedWriter = null;
            e = e2;
        } catch (Throwable th2) {
            bufferedWriter = null;
            th = th2;
            C7594ab.a(bufferedWriter);
            throw th;
        }
        try {
            try {
                for (String str2 : hashMap.keySet()) {
                    bufferedWriter.write(str2 + "%%%" + hashMap.get(str2));
                    bufferedWriter.newLine();
                }
            } catch (Throwable th3) {
                th = th3;
                C7594ab.a(bufferedWriter);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            AbstractC7535b.a(e);
            C7594ab.a(bufferedWriter);
        }
        C7594ab.a(bufferedWriter);
    }

    public static void a(String str, C7537a[] c7537aArr) {
        RandomAccessFile randomAccessFile;
        if (c7537aArr == null || c7537aArr.length <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        FileLock fileLock = null;
        try {
            File file = new File(str + ".lock");
            C7594ab.m659a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                HashMap<String, String> m596a = m596a(str);
                for (C7537a c7537a : c7537aArr) {
                    if (c7537a != null) {
                        String a = a((PerfClientReport) c7537a);
                        long j = ((PerfClientReport) c7537a).perfCounts;
                        long j2 = ((PerfClientReport) c7537a).perfLatencies;
                        if (!TextUtils.isEmpty(a) && j > 0 && j2 >= 0) {
                            a(m596a, a, j, j2);
                        }
                    }
                }
                a(str, m596a);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e) {
                        e = e;
                        AbstractC7535b.a(e);
                        C7594ab.a(randomAccessFile);
                    }
                }
            } catch (Throwable unused) {
                try {
                    AbstractC7535b.c("failed to write perf to file ");
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e2) {
                            e = e2;
                            AbstractC7535b.a(e);
                            C7594ab.a(randomAccessFile);
                        }
                    }
                    C7594ab.a(randomAccessFile);
                } catch (Throwable th) {
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            AbstractC7535b.a(e3);
                        }
                    }
                    C7594ab.a(randomAccessFile);
                    throw th;
                }
            }
        } catch (Throwable unused2) {
            randomAccessFile = null;
        }
        C7594ab.a(randomAccessFile);
    }

    private static void a(HashMap<String, String> hashMap, String str, long j, long j2) {
        StringBuilder sb;
        String str2 = hashMap.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb = new StringBuilder();
        } else {
            long[] m597a = m597a(str2);
            if (m597a == null || m597a[0] <= 0 || m597a[1] < 0) {
                sb = new StringBuilder();
            } else {
                j += m597a[0];
                j2 += m597a[1];
                sb = new StringBuilder();
            }
        }
        sb.append(j);
        sb.append(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
        sb.append(j2);
        hashMap.put(str, sb.toString());
    }

    /* renamed from: a  reason: collision with other method in class */
    protected static long[] m597a(String str) {
        long[] jArr = new long[2];
        try {
            String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            if (split.length >= 2) {
                jArr[0] = Long.parseLong(split[0].trim());
                jArr[1] = Long.parseLong(split[1].trim());
            }
            return jArr;
        } catch (Exception e) {
            AbstractC7535b.a(e);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String[] m598a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
    }
}
