package mtopsdk.framework.filter.after;

import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ResponseSource;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BusinessErrorAfterFilter implements IAfterFilter {
    private static final String TAG = "mtopsdk.BusinessErrorAfterFilter";

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        ResponseSource responseSource;
        MtopResponse mtopResponse;
        MtopResponse mtopResponse2 = mtopContext.mtopResponse;
        if (304 == mtopResponse2.getResponseCode() && (responseSource = mtopContext.responseSource) != null && (mtopResponse = responseSource.cacheResponse) != null) {
            mtopContext.mtopResponse = mtopResponse;
            FilterUtils.handleExceptionCallBack(mtopContext);
            return "STOP";
        } else if (mtopResponse2.getBytedata() == null) {
            mtopResponse2.setRetCode(ErrorConstant.ERRCODE_JSONDATA_BLANK);
            mtopResponse2.setRetMsg(ErrorConstant.ERRMSG_JSONDATA_BLANK);
            FilterUtils.handleExceptionCallBack(mtopContext);
            return "STOP";
        } else {
            FilterUtils.parseRetCodeFromHeader(mtopResponse2);
            return "CONTINUE";
        }
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
