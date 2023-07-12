package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.statistics.DBHelper;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import tb.x6;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TrafficsMonitor {
    private static final int CACHE_COUNT = 10;
    private static final String DIMENSION_BIZID = "bizId";
    private static final String DIMENSION_DATE = "date";
    private static final String DIMENSION_HOST = "host";
    private static final String DIMENSION_ISBACKGROUND = "isBackground";
    private static final String MEASURE_SIZE = "size";
    private static final String MODULE = "NetworkSDK";
    private static final String MONITOR_POINT = "TrafficStats";
    private static final String TAG = "TrafficsMonitor";
    private Context mContext;
    private Map<String, List<TrafficInfo>> trafficMap = new HashMap();
    private Map<String, String> bidMap = new HashMap<String, String>() { // from class: com.taobao.accs.ut.monitor.TrafficsMonitor.1
        private static final long serialVersionUID = 1;

        {
            put(IRequestConst.IM, "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", "1000");
        }
    };
    private int count = 0;
    private String lastSaveDay = "";

    /* compiled from: Taobao */
    @Monitor(module = TrafficsMonitor.MODULE, monitorPoint = TrafficsMonitor.MONITOR_POINT)
    /* loaded from: classes8.dex */
    public static class StatTrafficMonitor extends BaseMonitor {
        @Dimension
        public String bizId;
        @Dimension
        public String date;
        @Dimension
        public String host;
        @Dimension
        public boolean isBackground;
        @Dimension
        public String serviceId;
        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.mContext = context;
    }

    private void commit() {
        List<TrafficInfo> traffics = DBHelper.getInstance(this.mContext).getTraffics(false);
        if (traffics == null) {
            return;
        }
        try {
            for (TrafficInfo trafficInfo : traffics) {
                if (trafficInfo != null) {
                    StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                    statTrafficMonitor.bizId = trafficInfo.bid;
                    statTrafficMonitor.date = trafficInfo.date;
                    statTrafficMonitor.host = trafficInfo.host;
                    statTrafficMonitor.isBackground = trafficInfo.isBackground;
                    statTrafficMonitor.size = trafficInfo.trafficSize;
                    x6.b().commitStat(statTrafficMonitor);
                }
            }
            DBHelper.getInstance(this.mContext).clearTraffics();
        } catch (Throwable th) {
            ALog.e("", th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    private void saveTraffics() {
        String str;
        boolean z;
        synchronized (this.trafficMap) {
            String formatDay = UtilityImpl.formatDay(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.lastSaveDay) || this.lastSaveDay.equals(formatDay)) {
                str = formatDay;
                z = false;
            } else {
                str = this.lastSaveDay;
                z = true;
            }
            for (String str2 : this.trafficMap.keySet()) {
                for (TrafficInfo trafficInfo : this.trafficMap.get(str2)) {
                    if (trafficInfo != null) {
                        DBHelper dBHelper = DBHelper.getInstance(this.mContext);
                        String str3 = trafficInfo.host;
                        String str4 = trafficInfo.serviceId;
                        dBHelper.onTraffics(str3, str4, this.bidMap.get(str4), trafficInfo.isBackground, trafficInfo.trafficSize, str);
                    }
                }
            }
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                ALog.d(TAG, "savetoDay:" + str + " saveTraffics" + this.trafficMap.toString(), new Object[0]);
            }
            if (z) {
                this.trafficMap.clear();
                commit();
            } else if (ALog.isPrintLog(level)) {
                ALog.d(TAG, "no need commit lastsaveDay:" + this.lastSaveDay + " currday:" + formatDay, new Object[0]);
            }
            this.lastSaveDay = formatDay;
            this.count = 0;
        }
    }

    public void addTrafficInfo(TrafficInfo trafficInfo) {
        boolean z;
        String str;
        if (trafficInfo == null || trafficInfo.host == null || trafficInfo.trafficSize <= 0) {
            return;
        }
        trafficInfo.serviceId = TextUtils.isEmpty(trafficInfo.serviceId) ? "accsSelf" : trafficInfo.serviceId;
        synchronized (this.trafficMap) {
            String str2 = this.bidMap.get(trafficInfo.serviceId);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            trafficInfo.bid = str2;
            ALog.isPrintLog(ALog.Level.D);
            List<TrafficInfo> list = this.trafficMap.get(str2);
            if (list != null) {
                Iterator<TrafficInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    TrafficInfo next = it.next();
                    if (next.isBackground == trafficInfo.isBackground && (str = next.host) != null && str.equals(trafficInfo.host)) {
                        next.trafficSize += trafficInfo.trafficSize;
                        z = false;
                        break;
                    }
                }
                if (z) {
                    list.add(trafficInfo);
                }
            } else {
                list = new ArrayList<>();
                list.add(trafficInfo);
            }
            this.trafficMap.put(str2, list);
            int i = this.count + 1;
            this.count = i;
            if (i >= 10) {
                saveTraffics();
            }
        }
    }

    public void restoreTraffics() {
        try {
            synchronized (this.trafficMap) {
                this.trafficMap.clear();
            }
            List<TrafficInfo> traffics = DBHelper.getInstance(this.mContext).getTraffics(true);
            if (traffics == null) {
                return;
            }
            for (TrafficInfo trafficInfo : traffics) {
                addTrafficInfo(trafficInfo);
            }
        } catch (Exception e) {
            ALog.w(TAG, e.toString(), new Object[0]);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class TrafficInfo {
        String bid;
        String date;
        String host;
        boolean isBackground;
        String serviceId;
        long trafficSize;

        public TrafficInfo(String str, boolean z, String str2, long j) {
            this.serviceId = str;
            this.isBackground = z;
            this.host = str2;
            this.trafficSize = j;
        }

        public String toString() {
            return "date:" + this.date + " bizId:" + this.bid + " serviceId:" + this.serviceId + " host:" + this.host + " isBackground:" + this.isBackground + " size:" + this.trafficSize;
        }

        public TrafficInfo(String str, String str2, String str3, boolean z, String str4, long j) {
            this.date = str;
            this.bid = str2;
            this.serviceId = str3;
            this.isBackground = z;
            this.host = str4;
            this.trafficSize = j;
        }
    }
}
