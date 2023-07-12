package anet.channel.detect;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.statist.MtuDetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.C0213a;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.ali.user.open.tbauth.TbAuthConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import mtopsdk.mtop.intf.MtopUnitStrategy;
import org.android.netutil.C8874a;
import org.android.netutil.C8875b;
import org.android.netutil.PingTask;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import tb.C9708t9;
import tb.h23;
import tb.hu0;
import tb.x6;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MTUDetector {
    private static HashMap<String, Long> a = new HashMap<>();
    private static Map<String, Integer> b = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        C8875b c8875b;
        if (!C9708t9.H()) {
            ALog.f("anet.MTUDetector", "mtu detect closed.", null, new Object[0]);
            return;
        }
        ALog.e("anet.MTUDetector", "mtuDetectTask start", null, new Object[0]);
        SpdyAgent.getInstance(hu0.c(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Long l = a.get(str);
        if (l == null || currentTimeMillis >= l.longValue()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(hu0.c());
            long j = defaultSharedPreferences.getLong("sp_mtu_" + str, 0L);
            if (currentTimeMillis < j) {
                a.put(str, Long.valueOf(j));
                ALog.e("anet.MTUDetector", "mtuDetectTask in period of validity", null, new Object[0]);
                return;
            }
            List<IConnStrategy> connStrategyListByHost = C0213a.a().getConnStrategyListByHost(MtopUnitStrategy.GUIDE_ONLINE_DOMAIN);
            String ip = (connStrategyListByHost == null || connStrategyListByHost.isEmpty()) ? null : connStrategyListByHost.get(0).getIp();
            if (TextUtils.isEmpty(ip)) {
                return;
            }
            ALog.e("anet.MTUDetector", "[mtuDetectTask]", null, TbAuthConstants.IP, ip);
            String str2 = ip;
            Future<C8875b> launch = new PingTask(str2, 1000, 3, 0, 0).launch();
            Future<C8875b> launch2 = new PingTask(str2, 1000, 3, 972, 0).launch();
            Future<C8875b> launch3 = new PingTask(str2, 1000, 3, 1172, 0).launch();
            Future<C8875b> launch4 = new PingTask(str2, 1000, 3, 1272, 0).launch();
            Future<C8875b> launch5 = new PingTask(str2, 1000, 3, 1372, 0).launch();
            Future<C8875b> launch6 = new PingTask(str2, 1000, 3, 1432, 0).launch();
            try {
                c8875b = launch.get();
            } catch (Exception unused) {
                c8875b = null;
            }
            if (c8875b == null) {
                return;
            }
            if (c8875b.f() < 2) {
                ALog.e("anet.MTUDetector", "MTU detect preTask error", null, "errCode", Integer.valueOf(c8875b.b()), h23.POINT_SUCCESS_COUNT_MEASURE, Integer.valueOf(c8875b.f()));
                return;
            }
            int i = e(ip, 1000, launch2) ? 1000 : 0;
            if (e(ip, 1200, launch3)) {
                i = 1200;
            }
            if (e(ip, 1300, launch4)) {
                i = 1300;
            }
            if (e(ip, 1400, launch5)) {
                i = 1400;
            }
            if (e(ip, 1460, launch6)) {
                i = 1460;
            }
            ALog.e("anet.MTUDetector", "MTU detect.", null, "uniqueId", str, "maxAvailableMTU", Integer.valueOf(i));
            long j2 = currentTimeMillis + 432000000;
            a.put(str, Long.valueOf(j2));
            b.put(str, Integer.valueOf(i));
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putLong("sp_mtu_" + str, j2).apply();
        }
    }

    private boolean e(String str, int i, Future<C8875b> future) {
        C8875b c8875b;
        try {
            c8875b = future.get();
        } catch (Exception unused) {
            c8875b = null;
        }
        if (c8875b == null) {
            return false;
        }
        int f = c8875b.f();
        int i2 = 3 - f;
        StringBuilder sb = new StringBuilder();
        C8874a[] e = c8875b.e();
        int length = e.length;
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(e[i3].a);
            if (i3 != length - 1) {
                sb.append(",");
            }
        }
        ALog.e("anet.MTUDetector", "MTU detect result", null, "mtu", Integer.valueOf(i), h23.POINT_SUCCESS_COUNT_MEASURE, Integer.valueOf(f), "timeoutCount", Integer.valueOf(i2));
        MtuDetectStat mtuDetectStat = new MtuDetectStat();
        mtuDetectStat.mtu = i;
        mtuDetectStat.ip = str;
        mtuDetectStat.pingSuccessCount = f;
        mtuDetectStat.pingTimeoutCount = i2;
        mtuDetectStat.rtt = sb.toString();
        mtuDetectStat.errCode = c8875b.b();
        x6.b().commitStat(mtuDetectStat);
        return f > i2;
    }

    public int b() {
        Integer num = b.get(NetworkStatusHelper.j(NetworkStatusHelper.i()));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void d() {
        NetworkStatusHelper.a(new NetworkStatusHelper.INetworkStatusChangeListener() { // from class: anet.channel.detect.MTUDetector.1
            @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
            public void onNetworkStatusChanged(final NetworkStatusHelper.NetworkStatus networkStatus) {
                ThreadPoolExecutorFactory.e(new Runnable() { // from class: anet.channel.detect.MTUDetector.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            NetworkStatusHelper.NetworkStatus networkStatus2 = networkStatus;
                            if (networkStatus2 != NetworkStatusHelper.NetworkStatus.NO && networkStatus2 != NetworkStatusHelper.NetworkStatus.NONE) {
                                MTUDetector.this.c(NetworkStatusHelper.j(networkStatus2));
                            }
                        } catch (Throwable th) {
                            ALog.d("anet.MTUDetector", "MTU detecet fail.", null, th, new Object[0]);
                        }
                    }
                });
            }
        });
    }
}
