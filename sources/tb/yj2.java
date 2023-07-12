package tb;

import android.text.TextUtils;
import anet.channel.appmonitor.IAppMonitor;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.StatObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.monitor.adapter.logger.LoggerAdapter;
import com.taobao.monitor.logger.IDataLogger;
import com.taobao.network.lifecycle.Subject;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yj2 {
    private static IDataLogger a = new LoggerAdapter();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.yj2$a */
    /* loaded from: classes11.dex */
    public static class C9991a implements IAppMonitor {
        C9991a() {
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitAlarm(g4 g4Var) {
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitCount(wo woVar) {
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void commitStat(StatObject statObject) {
            if (statObject instanceof RequestStatistic) {
                yj2.b((RequestStatistic) statObject);
                Subject.instance().notify(statObject);
            }
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void register() {
        }

        @Override // anet.channel.appmonitor.IAppMonitor
        public void register(Class<?> cls) {
        }
    }

    public static void a() {
        x6.c(new C9991a());
    }

    public static void b(RequestStatistic requestStatistic) {
        if (requestStatistic == null) {
            return;
        }
        try {
            if (jd0.e) {
                String jSONString = JSON.toJSONString(requestStatistic);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("procedureName", (Object) "NetworkLib");
                jSONObject.put(TLogEventConst.PARAM_UPLOAD_STAGE, (Object) "procedureSuccess");
                jSONObject.put("content", (Object) jSONString);
                a.log("network", jSONObject.toJSONString());
            }
        } catch (Exception unused) {
        }
        String str = requestStatistic.url;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((str + System.currentTimeMillis()).hashCode());
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("timestamp", Long.valueOf(requestStatistic.start - requestStatistic.retryCostTime));
        uj1.a().onRequest(sb2, str, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("timestamp", Long.valueOf(requestStatistic.start));
        uj1.a().onValidRequest(sb2, str, hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("timestamp", Long.valueOf(requestStatistic.reqStart));
        uj1.a().onEvent(sb2, "data_request", hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("timestamp", Long.valueOf(requestStatistic.rspStart));
        uj1.a().onEvent(sb2, "first_package_response", hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put("timestamp", Long.valueOf(requestStatistic.rspEnd));
        hashMap5.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, Integer.valueOf(requestStatistic.statusCode));
        hashMap5.put("tnetErrorCode", Integer.valueOf(requestStatistic.tnetErrorCode));
        uj1.a().onFinished(sb2, hashMap5);
    }
}
