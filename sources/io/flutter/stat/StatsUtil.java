package io.flutter.stat;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.taobao.weex.annotation.JSMethod;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class StatsUtil {
    public static final int MSG_SAVE_STATS_HEARTBEAT = 9990;
    public static final int MSG_SAVE_STATS_TO_WA = 9991;
    public static final int MSG_STARTUP_PERF = 2;
    public static final int MSG_STATS = 1;
    public static final String TAG = "CoreStatsUtil";
    private static final boolean UC_BUILD_STATISTICS_FRAMEWORK = true;
    private static final boolean UC_BUILD_STATISTICS_LOG_TO_FILE = false;
    private static final SimpleDateFormat dateFormater;
    private static final String thisTimeStamp;
    static final ArrayList<stats> stats_stats = new ArrayList<>();
    static final ArrayList<startup_perf> stats_startup_perf = new ArrayList<>();
    private static long saveToWaTimeStamp = System.currentTimeMillis();
    static final HashMap<String, Long> sCounts = new HashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class StatsHandler extends Handler {
        private static final long SAVE_STATS_HEARTBEAT_PERIOD = 300000;
        private static volatile StatsHandler sStatsHandler;

        private StatsHandler(Looper looper) {
            super(looper);
        }

        public static StatsHandler getInstance() {
            if (sStatsHandler == null) {
                synchronized (StatsHandler.class) {
                    if (sStatsHandler == null) {
                        HandlerThread handlerThread = new HandlerThread("UcCoreStats");
                        handlerThread.start();
                        sStatsHandler = new StatsHandler(handlerThread.getLooper());
                        sStatsHandler.sendMessageDelayed(sStatsHandler.obtainMessage(StatsUtil.MSG_SAVE_STATS_HEARTBEAT), 300000L);
                    }
                }
            }
            return sStatsHandler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((stats) message.obj).appendToCachePool();
            } else if (i == 2) {
                ((startup_perf) message.obj).appendToCachePool();
            } else if (i != 9990) {
                if (i != 9991) {
                    return;
                }
                StatsUtil.saveToWa();
            } else {
                sendMessageDelayed(obtainMessage(StatsUtil.MSG_SAVE_STATS_HEARTBEAT), 300000L);
                if (System.currentTimeMillis() - StatsUtil.saveToWaTimeStamp > 1200000) {
                    StatsUtil.saveToWa();
                }
            }
        }
    }

    static {
        Locale locale = Locale.US;
        thisTimeStamp = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, locale).format(new Date(System.currentTimeMillis()));
        dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", locale);
    }

    public static void SLog(String str, String str2) {
    }

    public static void WaStat(String str, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (entry.getKey().startsWith(JSMethod.NOT_SET)) {
                hashMap2.put(entry.getKey(), entry.getValue());
            } else {
                hashMap2.put(JSMethod.NOT_SET + entry.getKey(), entry.getValue());
            }
        }
        StatServices.getInstance();
        StatServices.WaStat(str, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveToWa() {
        startup_perf next;
        stats next2;
        saveToWaTimeStamp = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Long> entry : sCounts.entrySet()) {
            if (entry.getKey() != null) {
                if (entry.getKey().startsWith(JSMethod.NOT_SET)) {
                    hashMap.put(entry.getKey(), entry.getValue().toString());
                } else {
                    hashMap.put(JSMethod.NOT_SET + entry.getKey(), entry.getValue().toString());
                }
            }
        }
        StatServices.WaStat("counts", hashMap);
        hashMap.clear();
        Iterator<stats> it = stats_stats.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += next2.length();
            StatServices.WaStat("stats", it.next().toHashMap());
        }
        if (stats.__cn > 0) {
            if (j == 0) {
                j = stats.__cl;
            }
            StatServices.WaStat("stats", stats.getStats(j).toHashMap());
        }
        stats_stats.clear();
        Iterator<startup_perf> it2 = stats_startup_perf.iterator();
        long j2 = 0;
        while (it2.hasNext()) {
            j2 += next.length();
            StatServices.WaStat("startup_perf", it2.next().toHashMap());
        }
        if (startup_perf.__cn > 0) {
            if (j2 == 0) {
                j2 = startup_perf.__cl;
            }
            StatServices.WaStat("stats", startup_perf.getStats(j2).toHashMap());
        }
        stats_startup_perf.clear();
    }

    private static void writeToFile() {
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class stats {
        static int __cl = 0;
        static int __cn = 0;
        static int __dl = 0;
        static int __dn = 0;
        public static final boolean supportMerge = true;
        int __len;
        public long cl;

        /* renamed from: cn  reason: collision with root package name */
        public long f1040cn;
        public long dl;
        public long dn;
        public String key;
        public long len;

        public stats(String str, long j, long j2, long j3, long j4, long j5) {
            this.key = "";
            this.f1040cn = 0L;
            this.cl = 0L;
            this.dn = 0L;
            this.dl = 0L;
            this.len = 0L;
            this.__len = 0;
            this.key = str;
            this.f1040cn = j;
            this.cl = j2;
            this.dn = j3;
            this.dl = j4;
            this.len = j5;
        }

        static stats getStats(long j) {
            stats statsVar = new stats();
            statsVar.key = "stats";
            statsVar.f1040cn = __cn;
            statsVar.dn = __dn;
            statsVar.cl = __cl;
            statsVar.dl = __dl;
            statsVar.len = j;
            __cn = 0;
            __dn = 0;
            __cl = 0;
            __dl = 0;
            return statsVar;
        }

        public static void nativeCreate(String str, long j, long j2, long j3, long j4, long j5) {
            new stats(str, j, j2, j3, j4, j5).commit();
        }

        void appendToCachePool() {
            boolean z = true;
            __cn++;
            __cl += length();
            ArrayList<stats> arrayList = StatsUtil.stats_stats;
            if (arrayList.size() > 50) {
                __dn++;
                __dl += length();
            } else if (arrayList.size() * 20 > 10000) {
                __dn++;
                __dl += length();
            } else {
                if (arrayList.size() > 7) {
                    Iterator<stats> it = arrayList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        i += it.next().length();
                    }
                    if (i > 50000) {
                        __dn++;
                        __dl += length();
                        return;
                    }
                }
                ArrayList<stats> arrayList2 = StatsUtil.stats_stats;
                if (arrayList2.isEmpty()) {
                    arrayList2.add(this);
                    return;
                }
                Iterator<stats> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    stats next = it2.next();
                    if (next.isMergeable(this)) {
                        next.merge(this);
                        break;
                    }
                }
                if (z) {
                    return;
                }
                StatsUtil.stats_stats.add(this);
            }
        }

        public void commit() {
            if (this.key == null) {
                this.key = "";
            }
            if (this.key.length() > 16) {
                this.key = this.key.substring(0, 16);
            }
            stats statsVar = new stats();
            statsVar.key = this.key;
            statsVar.f1040cn = this.f1040cn;
            statsVar.cl = this.cl;
            statsVar.dn = this.dn;
            statsVar.dl = this.dl;
            statsVar.len = this.len;
            Log.d(StatsUtil.TAG, "commit: " + toString());
            reset();
            Message obtainMessage = StatsHandler.getInstance().obtainMessage(1);
            obtainMessage.obj = statsVar;
            StatsHandler.getInstance().sendMessage(obtainMessage);
        }

        boolean isMergeable(stats statsVar) {
            return this.key.equals(statsVar.key);
        }

        public boolean isValidity() {
            return true;
        }

        int length() {
            if (this.__len == 0) {
                this.__len = this.key.length() + 20 + StatServices.getNumberLength(this.f1040cn) + StatServices.getNumberLength(this.cl) + StatServices.getNumberLength(this.dn) + StatServices.getNumberLength(this.dl) + StatServices.getNumberLength(this.len);
            }
            return this.__len;
        }

        public void merge(stats statsVar) {
            if (isMergeable(statsVar)) {
                this.f1040cn += statsVar.f1040cn;
                this.cl += statsVar.cl;
                this.dn += statsVar.dn;
                this.dl += statsVar.dl;
                this.len += statsVar.len;
                this.__len = 0;
            }
        }

        public void reset() {
            this.key = "";
            this.f1040cn = 0L;
            this.cl = 0L;
            this.dn = 0L;
            this.dl = 0L;
            this.len = 0L;
            this.__len = 0;
        }

        public HashMap<String, String> toHashMap() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("_key", this.key);
            hashMap.put("_cn", String.valueOf(this.f1040cn));
            hashMap.put("_cl", String.valueOf(this.cl));
            hashMap.put("_dn", String.valueOf(this.dn));
            hashMap.put("_dl", String.valueOf(this.dl));
            hashMap.put("_len", String.valueOf(this.len));
            return hashMap;
        }

        public String toString() {
            return "stats:{key:" + this.key + ", cn:" + String.valueOf(this.f1040cn) + ", cl:" + String.valueOf(this.cl) + ", dn:" + String.valueOf(this.dn) + ", dl:" + String.valueOf(this.dl) + ", len:" + String.valueOf(this.len) + "}";
        }

        public stats() {
            this.key = "";
            this.f1040cn = 0L;
            this.cl = 0L;
            this.dn = 0L;
            this.dl = 0L;
            this.len = 0L;
            this.__len = 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class startup_perf {
        static int __cl;
        static int __cn;
        static int __dl;
        static int __dn;
        public static final boolean supportMerge = false;
        int __len;
        public long ede;
        public long fec;
        public long ff;
        public long ftede;
        public long ftfec;
        public long ftff;
        public long ftsr;
        public String route;
        public long sr;

        public startup_perf(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, String str) {
            this.fec = 0L;
            this.ftfec = 0L;
            this.ede = 0L;
            this.ftede = 0L;
            this.sr = 0L;
            this.ftsr = 0L;
            this.ff = 0L;
            this.ftff = 0L;
            this.route = "";
            this.__len = 0;
            this.fec = j;
            this.ftfec = j2;
            this.ede = j3;
            this.ftede = j4;
            this.sr = j5;
            this.ftsr = j6;
            this.ff = j7;
            this.ftff = j8;
            this.route = str;
        }

        static stats getStats(long j) {
            stats statsVar = new stats();
            statsVar.key = "startup_perf";
            statsVar.f1040cn = __cn;
            statsVar.dn = __dn;
            statsVar.cl = __cl;
            statsVar.dl = __dl;
            statsVar.len = j;
            __cn = 0;
            __dn = 0;
            __cl = 0;
            __dl = 0;
            return statsVar;
        }

        public static void nativeCreate(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, String str) {
            new startup_perf(j, j2, j3, j4, j5, j6, j7, j8, str).commit();
        }

        void appendToCachePool() {
            boolean z = true;
            __cn++;
            __cl += length();
            ArrayList<startup_perf> arrayList = StatsUtil.stats_startup_perf;
            if (arrayList.size() > 50) {
                __dn++;
                __dl += length();
            } else if (arrayList.size() * 42 > 10000) {
                __dn++;
                __dl += length();
            } else {
                if (arrayList.size() > 7) {
                    Iterator<startup_perf> it = arrayList.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        i += it.next().length();
                    }
                    if (i > 50000) {
                        __dn++;
                        __dl += length();
                        return;
                    }
                }
                ArrayList<startup_perf> arrayList2 = StatsUtil.stats_startup_perf;
                if (arrayList2.isEmpty()) {
                    arrayList2.add(this);
                    return;
                }
                Iterator<startup_perf> it2 = arrayList2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    }
                    startup_perf next = it2.next();
                    if (next.isMergeable(this)) {
                        next.merge(this);
                        break;
                    }
                }
                if (z) {
                    return;
                }
                StatsUtil.stats_startup_perf.add(this);
            }
        }

        public void commit() {
            if (this.route == null) {
                this.route = "";
            }
            if (this.route.length() > 128) {
                this.route = this.route.substring(0, 128);
            }
            startup_perf startup_perfVar = new startup_perf();
            startup_perfVar.fec = this.fec;
            startup_perfVar.ftfec = this.ftfec;
            startup_perfVar.ede = this.ede;
            startup_perfVar.ftede = this.ftede;
            startup_perfVar.sr = this.sr;
            startup_perfVar.ftsr = this.ftsr;
            startup_perfVar.ff = this.ff;
            startup_perfVar.ftff = this.ftff;
            startup_perfVar.route = this.route;
            Log.d(StatsUtil.TAG, "commit: " + toString());
            reset();
            Message obtainMessage = StatsHandler.getInstance().obtainMessage(2);
            obtainMessage.obj = startup_perfVar;
            StatsHandler.getInstance().sendMessage(obtainMessage);
        }

        boolean isMergeable(startup_perf startup_perfVar) {
            return false;
        }

        public boolean isValidity() {
            return true;
        }

        int length() {
            if (this.__len == 0) {
                this.__len = StatServices.getNumberLength(this.fec) + 42 + StatServices.getNumberLength(this.ftfec) + StatServices.getNumberLength(this.ede) + StatServices.getNumberLength(this.ftede) + StatServices.getNumberLength(this.sr) + StatServices.getNumberLength(this.ftsr) + StatServices.getNumberLength(this.ff) + StatServices.getNumberLength(this.ftff) + this.route.length();
            }
            return this.__len;
        }

        public void merge(startup_perf startup_perfVar) {
            if (isMergeable(startup_perfVar)) {
                this.fec += startup_perfVar.fec;
                this.ftfec += startup_perfVar.ftfec;
                this.ede += startup_perfVar.ede;
                this.ftede += startup_perfVar.ftede;
                this.sr += startup_perfVar.sr;
                this.ftsr += startup_perfVar.ftsr;
                this.ff += startup_perfVar.ff;
                this.ftff += startup_perfVar.ftff;
                this.route += startup_perfVar.route;
                this.__len = 0;
            }
        }

        public void reset() {
            this.fec = 0L;
            this.ftfec = 0L;
            this.ede = 0L;
            this.ftede = 0L;
            this.sr = 0L;
            this.ftsr = 0L;
            this.ff = 0L;
            this.ftff = 0L;
            this.route = "";
            this.__len = 0;
        }

        public HashMap<String, String> toHashMap() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("_fec", String.valueOf(this.fec));
            hashMap.put("_ftfec", String.valueOf(this.ftfec));
            hashMap.put("_ede", String.valueOf(this.ede));
            hashMap.put("_ftede", String.valueOf(this.ftede));
            hashMap.put("_sr", String.valueOf(this.sr));
            hashMap.put("_ftsr", String.valueOf(this.ftsr));
            hashMap.put("_ff", String.valueOf(this.ff));
            hashMap.put("_ftff", String.valueOf(this.ftff));
            hashMap.put("_route", this.route);
            return hashMap;
        }

        public String toString() {
            return "startup_perf:{fec:" + String.valueOf(this.fec) + ", ftfec:" + String.valueOf(this.ftfec) + ", ede:" + String.valueOf(this.ede) + ", ftede:" + String.valueOf(this.ftede) + ", sr:" + String.valueOf(this.sr) + ", ftsr:" + String.valueOf(this.ftsr) + ", ff:" + String.valueOf(this.ff) + ", ftff:" + String.valueOf(this.ftff) + ", route:" + this.route + "}";
        }

        public startup_perf() {
            this.fec = 0L;
            this.ftfec = 0L;
            this.ede = 0L;
            this.ftede = 0L;
            this.sr = 0L;
            this.ftsr = 0L;
            this.ff = 0L;
            this.ftff = 0L;
            this.route = "";
            this.__len = 0;
        }
    }
}
