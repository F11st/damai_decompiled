package mtopsdk.mtop.stat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.MtopPrefetch;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PrefetchStatistics {
    private static final String MTOP_PREFETCH = "mtopPrefetch";
    private static final String MTOP_STATS_MODULE = "mtopsdk";
    private static final String TAG = "mtopsdk.PrefetchStatistics";
    private static volatile AtomicBoolean isRegistered = new AtomicBoolean(false);
    private String seqNo = "";
    private IUploadStats uploadStats;

    public PrefetchStatistics(IUploadStats iUploadStats) {
        this.uploadStats = iUploadStats;
    }

    private void registerPrefetchStats() {
        try {
            if (this.uploadStats == null) {
                TBSdkLog.e(TAG, this.seqNo, "[registerPrefetchStats]register MtopStats error, uploadStats=null");
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("api");
            hashSet.add("version");
            hashSet.add("key");
            HashSet hashSet2 = new HashSet();
            hashSet2.add("time");
            hashSet2.add("type");
            IUploadStats iUploadStats = this.uploadStats;
            if (iUploadStats != null) {
                iUploadStats.onRegister(MTOP_STATS_MODULE, MTOP_PREFETCH, hashSet, hashSet2, false);
            }
        } catch (Throwable th) {
            String str = this.seqNo;
            TBSdkLog.e(TAG, str, "[registerPrefetchStats] register MtopStats error ---" + th.toString());
        }
    }

    public void doPrefetchCommit(String str, HashMap<String, String> hashMap) {
        int i;
        if (hashMap == null) {
            return;
        }
        String str2 = hashMap.get(MtopPrefetch.IPrefetchCallback.DATA_SEQ);
        this.seqNo = str2;
        if (this.uploadStats == null) {
            TBSdkLog.e(TAG, str2, "[doPrefetchCommit]register MtopStats error, uploadStats=null");
            return;
        }
        if (MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_HIT.equals(str)) {
            i = 1;
        } else if (MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_MISS.equals(str)) {
            i = 2;
        } else if (MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_EXPIRE.equals(str)) {
            i = 3;
        } else {
            i = MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_CLEAR.equals(str) ? 4 : 0;
        }
        if (isRegistered.compareAndSet(false, true)) {
            registerPrefetchStats();
        }
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("api", hashMap.get(MtopPrefetch.IPrefetchCallback.DATA_API));
            hashMap2.put("version", hashMap.get(MtopPrefetch.IPrefetchCallback.DATA_VERSION));
            hashMap2.put("key", hashMap.get(MtopPrefetch.IPrefetchCallback.DATA_KEY));
            HashMap hashMap3 = new HashMap();
            hashMap3.put("time", Double.valueOf(Double.parseDouble(hashMap.get(MtopPrefetch.IPrefetchCallback.DATA_COST_TIME))));
            hashMap3.put("type", Double.valueOf(i));
            this.uploadStats.onCommit(MTOP_STATS_MODULE, MTOP_PREFETCH, hashMap2, hashMap3);
        } catch (Throwable th) {
            String str3 = this.seqNo;
            TBSdkLog.e(TAG, str3, "[doPrefetchCommit] commit mtopStats error ---" + th.toString());
        }
    }
}
