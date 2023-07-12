package mtopsdk.mtop.intf;

import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.stat.PrefetchStatistics;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopPrefetch {
    public static final int MAX_PREFETCH_EXPIRE_TIME = 15000;
    private static final String TAG = "mtopsdk.MtopPrefetch";
    public long prefetchStartTime;
    public PrefetchStatistics stat;
    private long prefetchExpireTime = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
    public volatile long prefetchResponseTime = 0;
    public long prefetchHitTime = 0;
    public AtomicBoolean response = new AtomicBoolean(false);
    public MtopContext mergeContext = null;
    public ReentrantLock lock = new ReentrantLock();
    public List<String> whiteListParams = new ArrayList();
    private IPrefetchCallback callback = null;
    private IPrefetchComparator comparator = null;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CompareResult {
        boolean same = false;
        HashMap<String, String> data = new HashMap<>();

        public HashMap<String, String> getData() {
            return this.data;
        }

        public boolean isSame() {
            return this.same;
        }

        public void setData(HashMap<String, String> hashMap) {
            this.data = hashMap;
        }

        public void setSame(boolean z) {
            this.same = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DefaultPrefetchComparator implements IPrefetchComparator {
        private boolean compareJsonStr(String str, String str2, List<String> list) {
            if (StringUtils.isBlank(str) || StringUtils.isBlank(str2)) {
                return false;
            }
            if (str.equals(str2)) {
                return true;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = new JSONObject(str2);
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (StringUtils.isNotBlank(next) && (list == null || !list.contains(next))) {
                        hashMap.put(next, jSONObject.getString(next));
                    }
                }
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    if (StringUtils.isNotBlank(next2) && (list == null || !list.contains(next2))) {
                        hashMap2.put(next2, jSONObject2.getString(next2));
                    }
                }
                if (hashMap.size() != hashMap2.size()) {
                    return false;
                }
                for (String str3 : hashMap.keySet()) {
                    if (StringUtils.isNotBlank(str3) && !compareJsonStr((String) hashMap.get(str3), (String) hashMap2.get(str3), list)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }

        private boolean isSameRequest(MtopRequest mtopRequest, MtopRequest mtopRequest2, List<String> list) {
            if (!StringUtils.isBlank(mtopRequest.getKey()) && mtopRequest.getKey().equals(mtopRequest2.getKey()) && mtopRequest.isNeedEcode() == mtopRequest2.isNeedEcode() && mtopRequest.isNeedSession() == mtopRequest2.isNeedSession()) {
                return compareJsonStr(mtopRequest.getData(), mtopRequest2.getData(), list);
            }
            return false;
        }

        @Override // mtopsdk.mtop.intf.MtopPrefetch.IPrefetchComparator
        public CompareResult compare(MtopBuilder mtopBuilder, MtopBuilder mtopBuilder2) {
            CompareResult compareResult = new CompareResult();
            compareResult.setSame(isSameRequest(mtopBuilder.getMtopContext().mtopRequest, mtopBuilder2.getMtopContext().mtopRequest, mtopBuilder2.getMtopPrefetch().whiteListParams));
            return compareResult;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IPrefetchCallback {
        public static final String DATA_API = "data_api";
        public static final String DATA_COST_TIME = "data_cost_time";
        public static final String DATA_KEY = "data_key";
        public static final String DATA_REQ_PARAM = "data_req_param";
        public static final String DATA_SEQ = "data_seq";
        public static final String DATA_VERSION = "data_version";

        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public interface PrefetchCallbackType {
            public static final String TYPE_CLEAR = "TYPE_CLEAR";
            public static final String TYPE_EXPIRE = "TYPE_EXPIRE";
            public static final String TYPE_FULL = "TYPE_FULL";
            public static final String TYPE_HIT = "TYPE_HIT";
            public static final String TYPE_MISS = "TYPE_MISS";

            /* compiled from: Taobao */
            @Retention(RetentionPolicy.SOURCE)
            /* loaded from: classes11.dex */
            public @interface Definition {
            }
        }

        void onPrefetch(String str, HashMap<String, String> hashMap);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IPrefetchComparator {
        CompareResult compare(MtopBuilder mtopBuilder, MtopBuilder mtopBuilder2);
    }

    public MtopPrefetch(PrefetchStatistics prefetchStatistics) {
        this.prefetchStartTime = 0L;
        this.stat = null;
        this.stat = prefetchStatistics;
        this.prefetchStartTime = System.currentTimeMillis();
    }

    private static HashMap<String, String> buildCallbackData(String str, MtopContext mtopContext, MtopPrefetch mtopPrefetch, HashMap<String, String> hashMap) {
        if (mtopPrefetch == null || mtopContext == null) {
            return null;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put(IPrefetchCallback.DATA_SEQ, mtopContext.seqNo);
        hashMap2.put(IPrefetchCallback.DATA_KEY, mtopContext.mtopRequest.getKey());
        hashMap2.put(IPrefetchCallback.DATA_API, mtopContext.mtopRequest.getApiName());
        hashMap2.put(IPrefetchCallback.DATA_VERSION, mtopContext.mtopRequest.getVersion());
        long j = mtopPrefetch.prefetchHitTime;
        hashMap2.put(IPrefetchCallback.DATA_COST_TIME, String.valueOf(j != 0 ? j - mtopPrefetch.prefetchResponseTime : -1L));
        if (IPrefetchCallback.PrefetchCallbackType.TYPE_MISS.equals(str)) {
            hashMap2.put(IPrefetchCallback.DATA_REQ_PARAM, mtopContext.mtopRequest.getData());
        }
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        return hashMap2;
    }

    public static void cleanPrefetchCache(Mtop mtop) {
        if (mtop == null || mtop.getPrefetchBuilderMap().isEmpty() || 15000 >= System.currentTimeMillis() - mtop.lastPrefetchResponseTime) {
            return;
        }
        synchronized (MtopPrefetch.class) {
            try {
                if (!mtop.getPrefetchBuilderMap().isEmpty()) {
                    Iterator<String> it = mtop.getPrefetchBuilderMap().keySet().iterator();
                    while (it.hasNext()) {
                        MtopBuilder mtopBuilder = mtop.getPrefetchBuilderMap().get(it.next());
                        if (mtopBuilder != null && System.currentTimeMillis() - mtopBuilder.getMtopPrefetch().prefetchResponseTime > mtopBuilder.getMtopPrefetch().getPrefetchExpireTime()) {
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                                TBSdkLog.d(TAG, "clean prefetch cache " + mtopBuilder.request.getKey());
                            }
                            onPrefetchAndCommit(IPrefetchCallback.PrefetchCallbackType.TYPE_CLEAR, mtopBuilder.getMtopPrefetch(), mtopBuilder.mtopContext, null);
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    public static void onPrefetchAndCommit(final String str, MtopPrefetch mtopPrefetch, MtopContext mtopContext, HashMap<String, String> hashMap) {
        if (mtopPrefetch != null) {
            try {
                final HashMap<String, String> buildCallbackData = buildCallbackData(str, mtopContext, mtopPrefetch, hashMap);
                MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.mtop.intf.MtopPrefetch.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MtopPrefetch.this.getCallback().onPrefetch(str, buildCallbackData);
                    }
                });
                PrefetchStatistics prefetchStatistics = mtopPrefetch.stat;
                if (prefetchStatistics != null) {
                    prefetchStatistics.doPrefetchCommit(str, buildCallbackData);
                }
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "onPrefetch Error" + th.toString());
            }
        }
    }

    public IPrefetchCallback getCallback() {
        return this.callback;
    }

    public IPrefetchComparator getComparator() {
        return this.comparator;
    }

    public long getPrefetchExpireTime() {
        return this.prefetchExpireTime;
    }

    public void setCallback(IPrefetchCallback iPrefetchCallback) {
        this.callback = iPrefetchCallback;
    }

    public void setComparator(IPrefetchComparator iPrefetchComparator) {
        this.comparator = iPrefetchComparator;
    }

    public void setPrefetchExpireTime(long j) {
        this.prefetchExpireTime = j;
    }
}
