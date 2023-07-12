package mtopsdk.framework.filter.after;

import android.text.TextUtils;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.HashMap;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.stat.IMtopMonitor;
import mtopsdk.mtop.stat.MtopMonitor;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExecuteCallbackAfterFilter implements IAfterFilter {
    private static final String TAG = "mtopsdk.ExecuteCallbackAfterFilter";

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        MtopStatistics mtopStatistics = mtopContext.stats;
        MtopResponse mtopResponse = mtopContext.mtopResponse;
        mtopStatistics.rspCbDispatch = System.currentTimeMillis();
        String str = mtopContext.seqNo;
        MtopFinishEvent mtopFinishEvent = new MtopFinishEvent(mtopResponse);
        mtopFinishEvent.seqNo = str;
        mtopStatistics.serverTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.SERVER_TRACE_ID);
        mtopStatistics.eagleEyeTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.EAGLE_TRACE_ID);
        mtopStatistics.retCode = mtopResponse.getRetCode();
        mtopStatistics.statusCode = mtopResponse.getResponseCode();
        mtopStatistics.mappingCode = mtopResponse.getMappingCode();
        mtopStatistics.onEndAndCommit();
        MtopListener mtopListener = mtopContext.mtopListener;
        try {
            boolean z = !(mtopContext.mtopBuilder instanceof MtopBusiness);
            if (z) {
                mtopStatistics.rspCbStart = System.currentTimeMillis();
            }
            if (mtopListener instanceof MtopCallback.MtopFinishListener) {
                ((MtopCallback.MtopFinishListener) mtopListener).onFinished(mtopFinishEvent, mtopContext.property.reqContext);
            }
            if (MtopMonitor.getInstance() != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(IMtopMonitor.DATA_RESPONSE, mtopContext.mtopResponse.getResponseLog());
                hashMap.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                MtopMonitor.getInstance().onCommit(IMtopMonitor.MtopMonitorType.TYPE_RESPONSE, hashMap);
            }
            if (MtopMonitor.getHeaderMonitor() != null) {
                String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopContext.mtopResponse.getHeaderFields(), HttpHeaderConstant.X_AB);
                if (!TextUtils.isEmpty(singleHeaderFieldByKey)) {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put(HttpHeaderConstant.X_AB, singleHeaderFieldByKey);
                    hashMap2.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                    MtopMonitor.getHeaderMonitor().onCommit(IMtopMonitor.MtopMonitorType.TYPE_RESPONSE, hashMap2);
                }
            }
            if (z) {
                mtopStatistics.rspCbEnd = System.currentTimeMillis();
                mtopStatistics.commitFullTrace();
                return "CONTINUE";
            }
            return "CONTINUE";
        } catch (Throwable th) {
            TBSdkLog.e(TAG, str, "call MtopFinishListener error,apiKey=" + mtopContext.mtopRequest.getKey(), th);
            return "CONTINUE";
        }
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
