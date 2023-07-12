package cn.damai.common.util;

import android.content.Context;
import android.os.Process;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ACache {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static Map<String, ACache> b = new HashMap();
    private ACacheManager a;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class ACacheManager {
        private static transient /* synthetic */ IpChange $ipChange;
        private final AtomicLong a;
        private final AtomicInteger b;
        private final Map<File, Long> c;
        protected File d;

        private void f() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "513469753")) {
                ipChange.ipc$dispatch("513469753", new Object[]{this});
            } else {
                new Thread(new Runnable() { // from class: cn.damai.common.util.ACache.ACacheManager.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1194705400")) {
                            ipChange2.ipc$dispatch("-1194705400", new Object[]{this});
                            return;
                        }
                        File[] listFiles = ACacheManager.this.d.listFiles();
                        if (listFiles != null) {
                            int i = 0;
                            int i2 = 0;
                            for (File file : listFiles) {
                                i = (int) (i + ACacheManager.this.g(file));
                                i2++;
                                ACacheManager.this.c.put(file, Long.valueOf(file.lastModified()));
                            }
                            ACacheManager.this.a.set(i);
                            ACacheManager.this.b.set(i2);
                        }
                    }
                }).start();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long g(File file) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2058767324") ? ((Long) ipChange.ipc$dispatch("-2058767324", new Object[]{this, file})).longValue() : file.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1486155251")) {
                ipChange.ipc$dispatch("1486155251", new Object[]{this});
                return;
            }
            this.c.clear();
            this.a.set(0L);
            File[] listFiles = this.d.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
        }

        private ACacheManager(ACache aCache, File file, long j, int i) {
            this.c = Collections.synchronizedMap(new HashMap());
            this.d = file;
            this.a = new AtomicLong();
            this.b = new AtomicInteger();
            f();
        }
    }

    private ACache(File file, long j, int i) {
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("can't make dirs in " + file.getAbsolutePath());
        }
        this.a = new ACacheManager(file, j, i);
    }

    public static ACache b(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "268639330") ? (ACache) ipChange.ipc$dispatch("268639330", new Object[]{context}) : c(context, "ACache");
    }

    public static ACache c(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1296519596") ? (ACache) ipChange.ipc$dispatch("1296519596", new Object[]{context, str}) : d(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    public static ACache d(File file, long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1324393356")) {
            return (ACache) ipChange.ipc$dispatch("-1324393356", new Object[]{file, Long.valueOf(j), Integer.valueOf(i)});
        }
        Map<String, ACache> map = b;
        ACache aCache = map.get(file.getAbsoluteFile() + e());
        if (aCache == null) {
            ACache aCache2 = new ACache(file, j, i);
            Map<String, ACache> map2 = b;
            map2.put(file.getAbsolutePath() + e(), aCache2);
            return aCache2;
        }
        return aCache;
    }

    private static String e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-836159305")) {
            return (String) ipChange.ipc$dispatch("-836159305", new Object[0]);
        }
        return JSMethod.NOT_SET + Process.myPid();
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1552953915")) {
            ipChange.ipc$dispatch("1552953915", new Object[]{this});
        } else {
            this.a.h();
        }
    }
}
