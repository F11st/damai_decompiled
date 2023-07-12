package mtopsdk.framework.util;

import android.os.Handler;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.after.ErrorCodeMappingAfterFilter;
import mtopsdk.framework.manager.FilterManager;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class FilterUtils {
    public static final ErrorCodeMappingAfterFilter errorCodeMappingAfterFilter = new ErrorCodeMappingAfterFilter();

    public static void checkFilterManager(FilterManager filterManager, MtopContext mtopContext) {
        if (filterManager == null) {
            MtopResponse mtopResponse = new MtopResponse(ErrorConstant.ERRCODE_MTOPSDK_INIT_ERROR, ErrorConstant.ERRMSG_MTOPSDK_INIT_ERROR);
            MtopRequest mtopRequest = mtopContext.mtopRequest;
            if (mtopRequest != null) {
                mtopResponse.setApi(mtopRequest.getApiName());
                mtopResponse.setV(mtopContext.mtopRequest.getVersion());
            }
            mtopContext.mtopResponse = mtopResponse;
            handleExceptionCallBack(mtopContext);
        }
    }

    public static void handleExceptionCallBack(final MtopContext mtopContext) {
        final MtopResponse mtopResponse = mtopContext.mtopResponse;
        if (mtopResponse == null || !(mtopContext.mtopListener instanceof MtopCallback.MtopFinishListener)) {
            return;
        }
        mtopResponse.setMtopStat(mtopContext.stats);
        final MtopFinishEvent mtopFinishEvent = new MtopFinishEvent(mtopResponse);
        mtopFinishEvent.seqNo = mtopContext.seqNo;
        mtopContext.stats.rspCbDispatch = System.currentTimeMillis();
        errorCodeMappingAfterFilter.doAfter(mtopContext);
        submitCallbackTask(mtopContext.property.handler, new Runnable() { // from class: mtopsdk.framework.util.FilterUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MtopContext.this.stats.serverTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.SERVER_TRACE_ID);
                    MtopContext.this.stats.eagleEyeTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.EAGLE_TRACE_ID);
                    MtopContext.this.stats.statusCode = mtopResponse.getResponseCode();
                    MtopContext.this.stats.retCode = mtopResponse.getRetCode();
                    MtopContext.this.stats.mappingCode = mtopResponse.getMappingCode();
                    if (mtopResponse.isApiSuccess()) {
                        MtopStatistics mtopStatistics = MtopContext.this.stats;
                        if (3 == mtopStatistics.cacheHitType) {
                            mtopStatistics.statusCode = 304;
                        }
                    }
                    MtopContext mtopContext2 = MtopContext.this;
                    boolean z = !(mtopContext2.mtopBuilder instanceof MtopBusiness);
                    if (z) {
                        mtopContext2.stats.rspCbStart = System.currentTimeMillis();
                    }
                    MtopContext mtopContext3 = MtopContext.this;
                    ((MtopCallback.MtopFinishListener) mtopContext3.mtopListener).onFinished(mtopFinishEvent, mtopContext3.property.reqContext);
                    MtopContext.this.stats.onEndAndCommit();
                    if (z) {
                        MtopContext.this.stats.rspCbEnd = System.currentTimeMillis();
                        MtopContext.this.stats.commitFullTrace();
                    }
                } catch (Exception unused) {
                }
            }
        }, mtopContext.seqNo.hashCode());
    }

    public static void parseRetCodeFromHeader(MtopResponse mtopResponse) {
        if (mtopResponse == null) {
            return;
        }
        String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.X_RETCODE);
        mtopResponse.mappingCodeSuffix = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.X_MAPPING_CODE);
        if (StringUtils.isNotBlank(singleHeaderFieldByKey)) {
            mtopResponse.setRetCode(singleHeaderFieldByKey);
        } else {
            mtopResponse.parseJsonByte();
        }
    }

    public static void submitCallbackTask(Handler handler, Runnable runnable, int i) {
        if (handler != null) {
            handler.post(runnable);
        } else {
            MtopSDKThreadPoolExecutorFactory.submitCallbackTask(i, runnable);
        }
    }
}
