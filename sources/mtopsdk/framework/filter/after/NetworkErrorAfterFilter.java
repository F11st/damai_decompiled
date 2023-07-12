package mtopsdk.framework.filter.after;

import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.common.ApiID;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.network.AbstractCallImpl;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkErrorAfterFilter implements IAfterFilter {
    private static final String TAG = "mtopsdk.NetworkErrorAfterFilter";

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        MtopResponse mtopResponse = mtopContext.mtopResponse;
        if (mtopResponse.getResponseCode() < 0) {
            ApiID apiID = mtopContext.apiId;
            if (apiID != null && apiID.getCall() != null && (mtopContext.apiId.getCall() instanceof AbstractCallImpl) && ((AbstractCallImpl) mtopContext.apiId.getCall()).isNoNetworkError(mtopResponse.getResponseCode())) {
                mtopResponse.setRetCode("ANDROID_SYS_NO_NETWORK");
                mtopResponse.setRetMsg(ErrorConstant.ERRMSG_NO_NETWORK);
            } else {
                mtopResponse.setRetCode("ANDROID_SYS_NETWORK_ERROR");
                mtopResponse.setRetMsg(ErrorConstant.ERRMSG_NETWORK_ERROR);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("api=");
                sb.append(mtopResponse.getApi());
                sb.append(",v=");
                sb.append(mtopResponse.getV());
                sb.append(",retCode =");
                sb.append(mtopResponse.getRetCode());
                sb.append(",responseCode =");
                sb.append(mtopResponse.getResponseCode());
                sb.append(",responseHeader=");
                sb.append(mtopResponse.getHeaderFields());
                TBSdkLog.e(TAG, mtopContext.seqNo, sb.toString());
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
