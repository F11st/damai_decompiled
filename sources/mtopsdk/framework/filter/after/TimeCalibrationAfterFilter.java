package mtopsdk.framework.filter.after;

import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.before.ProtocolParamBuilderBeforeFilter;
import mtopsdk.framework.manager.FilterManager;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TimeCalibrationAfterFilter implements IAfterFilter {
    private static final String TAG = "mtopsdk.TimeCalibrationAfterFilter";

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        MtopResponse mtopResponse = mtopContext.mtopResponse;
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        if (!mtopResponse.isExpiredRequest() || mtopNetworkProp.timeCalibrated) {
            return "CONTINUE";
        }
        mtopNetworkProp.timeCalibrated = true;
        mtopNetworkProp.skipCacheCallback = true;
        try {
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.X_SYSTIME);
            if (StringUtils.isNotBlank(singleHeaderFieldByKey)) {
                XState.setValue(XStateConstants.KEY_TIME_OFFSET, String.valueOf(Long.parseLong(singleHeaderFieldByKey) - (System.currentTimeMillis() / 1000)));
                FilterManager filterManager = mtopContext.mtopInstance.getMtopConfig().filterManager;
                if (filterManager != null) {
                    filterManager.start(new ProtocolParamBuilderBeforeFilter(null).getName(), mtopContext);
                    return "STOP";
                }
                return "CONTINUE";
            }
            return "CONTINUE";
        } catch (Exception e) {
            TBSdkLog.e(TAG, mtopContext.seqNo, "parse x-systime from mtop response header error", e);
            return "CONTINUE";
        }
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
