package com.xiaomi.push.service;

import android.os.Process;
import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.C7594ab;
import com.xiaomi.push.dw;
import com.xiaomi.push.fh;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ap {

    /* renamed from: a  reason: collision with other field name */
    private static final Pattern f897a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f896a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String sb2 = sb.toString();
                    C7594ab.a(bufferedReader);
                    return sb2;
                }
                sb.append(StringUtils.LF);
                sb.append(readLine);
            }
        } catch (Exception unused2) {
            C7594ab.a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            C7594ab.a(bufferedReader);
            throw th;
        }
    }

    public static void a() {
        dw.C7634a m1210a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f896a.getActiveCount() <= 0 || currentTimeMillis - a >= ConfigStorage.DEFAULT_SMALL_MAX_AGE) && fh.m881a().m886a() && (m1210a = bv.a().m1210a()) != null && m1210a.e() > 0) {
            a = currentTimeMillis;
            a(m1210a.m775a(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        f896a.execute(new aq(list, z));
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            AbstractC7535b.m586a("dump tcp for uid = " + Process.myUid());
            AbstractC7535b.m586a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        AbstractC7535b.m586a("dump tcp6 for uid = " + Process.myUid());
        AbstractC7535b.m586a(a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            AbstractC7535b.m586a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(com.xiaomi.push.ct.m748a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            AbstractC7535b.m586a("ConnectivityTest: connect to " + str + " in " + currentTimeMillis2);
            socket.close();
            return true;
        } catch (Throwable th) {
            AbstractC7535b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
