package mtopsdk.framework.filter.duplex;

import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.antiattack.ApiLockHelper;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FlowLimitDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.FlowLimitDuplexFilter";

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        MtopResponse mtopResponse = mtopContext.mtopResponse;
        if (420 == mtopResponse.getResponseCode()) {
            String key = mtopContext.mtopRequest.getKey();
            ApiLockHelper.lock(key, SDKUtils.getCorrectionTime(), 0L);
            FilterUtils.parseRetCodeFromHeader(mtopResponse);
            if (StringUtils.isBlank(mtopResponse.getRetCode())) {
                mtopContext.mtopResponse.setRetCode("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
                mtopContext.mtopResponse.setRetMsg(ErrorConstant.ERRMSG_API_FLOW_LIMIT_LOCKED);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                String str = mtopContext.seqNo;
                TBSdkLog.w(TAG, str, "[doAfter] execute FlowLimitDuplexFilter apiKey=" + key + " ,retCode=" + mtopResponse.getRetCode());
            }
            FilterUtils.handleExceptionCallBack(mtopContext);
            return "STOP";
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        if (mtopNetworkProp == null || !mtopNetworkProp.priorityFlag) {
            MtopRequest mtopRequest = mtopContext.mtopRequest;
            String key = mtopRequest.getKey();
            if (MtopUtils.apiWhiteList.contains(key) || !ApiLockHelper.iSApiLocked(key, SDKUtils.getCorrectionTime())) {
                return "CONTINUE";
            }
            mtopContext.mtopResponse = new MtopResponse(mtopRequest.getApiName(), mtopRequest.getVersion(), "ANDROID_SYS_API_FLOW_LIMIT_LOCKED", ErrorConstant.ERRMSG_API_FLOW_LIMIT_LOCKED);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                String str = mtopContext.seqNo;
                TBSdkLog.w(TAG, str, "[doBefore] execute FlowLimitDuplexFilter apiKey=" + key);
            }
            FilterUtils.handleExceptionCallBack(mtopContext);
            return "STOP";
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
