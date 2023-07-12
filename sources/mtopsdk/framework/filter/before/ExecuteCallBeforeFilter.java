package mtopsdk.framework.filter.before;

import java.util.HashMap;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.network.NetworkCallbackAdapter;
import mtopsdk.mtop.stat.IMtopMonitor;
import mtopsdk.mtop.stat.MtopMonitor;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.network.Call;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExecuteCallBeforeFilter implements IBeforeFilter {
    private static final String TAG = "mtopsdk.ExecuteCallBeforeFilter";

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        try {
            if (MtopMonitor.getInstance() != null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(IMtopMonitor.DATA_REQUEST, mtopContext.mtopRequest.getRequestLog());
                hashMap.put(IMtopMonitor.DATA_SEQ, mtopContext.seqNo);
                MtopMonitor.getInstance().onCommit(IMtopMonitor.MtopMonitorType.TYPE_REQUEST, hashMap);
            }
            MtopStatistics mtopStatistics = mtopContext.stats;
            mtopStatistics.netSendStartTime = mtopStatistics.currentTimeMillis();
            Call.Factory factory = mtopContext.mtopInstance.getMtopConfig().callFactory;
            if (factory == null) {
                String str = mtopContext.seqNo;
                TBSdkLog.e(TAG, str, "call Factory of mtopInstance is null.instanceId=" + mtopContext.mtopInstance.getInstanceId());
                MtopResponse mtopResponse = new MtopResponse(ErrorConstant.ERRCODE_MTOP_MISS_CALL_FACTORY, ErrorConstant.ERRMSG_MTOP_MISS_CALL_FACTORY);
                mtopResponse.setApi(mtopContext.mtopRequest.getApiName());
                mtopResponse.setV(mtopContext.mtopRequest.getVersion());
                mtopContext.mtopResponse = mtopResponse;
                FilterUtils.handleExceptionCallBack(mtopContext);
                return "STOP";
            }
            Call newCall = factory.newCall(mtopContext.networkRequest);
            newCall.enqueue(new NetworkCallbackAdapter(mtopContext));
            ApiID apiID = mtopContext.apiId;
            if (apiID != null) {
                apiID.setCall(newCall);
                return "CONTINUE";
            }
            return "CONTINUE";
        } catch (Exception e) {
            TBSdkLog.e(TAG, mtopContext.seqNo, "invoke call.enqueue of mtopInstance error,apiKey=" + mtopContext.mtopRequest.getKey(), e);
            return "STOP";
        }
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
