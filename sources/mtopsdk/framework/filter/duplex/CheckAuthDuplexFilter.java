package mtopsdk.framework.filter.duplex;

import androidx.annotation.NonNull;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.RequestPoolManager;
import com.taobao.tao.remotebusiness.auth.AuthParam;
import com.taobao.tao.remotebusiness.auth.RemoteAuth;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CheckAuthDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.CheckAuthDuplexFilter";

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        MtopBuilder mtopBuilder = mtopContext.mtopBuilder;
        if (mtopBuilder instanceof MtopBusiness) {
            MtopBusiness mtopBusiness = (MtopBusiness) mtopBuilder;
            Mtop mtop = mtopContext.mtopInstance;
            MtopResponse mtopResponse = mtopContext.mtopResponse;
            String retCode = mtopResponse.getRetCode();
            try {
                if (mtopBusiness.isNeedAuth() && mtopBusiness.getRetryTime() < 3 && SwitchConfig.authErrorCodeSet.contains(retCode)) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.i(TAG, mtopContext.seqNo, " execute CheckAuthAfterFilter.");
                    }
                    AuthParam authParam = new AuthParam(mtopBusiness.mtopProp.openAppKey, mtopBusiness.authParam, mtopBusiness.showAuthUI);
                    authParam.apiInfo = mtopBusiness.request.getKey();
                    if (mtopBusiness.mtopProp.isInnerOpen) {
                        authParam.failInfo = retCode;
                    } else {
                        authParam.failInfo = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.X_ACT_HINT);
                    }
                    RequestPoolManager.getPool(RequestPoolManager.Type.AUTH).addToRequestPool(mtop, authParam.openAppKey, mtopBusiness);
                    RemoteAuth.authorize(mtop, authParam);
                    return "STOP";
                }
            } catch (Exception e) {
                TBSdkLog.e(TAG, mtopContext.seqNo, " execute CheckAuthAfterFilter error.", e);
            }
            return "CONTINUE";
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        MtopBuilder mtopBuilder = mtopContext.mtopBuilder;
        if (mtopBuilder instanceof MtopBusiness) {
            MtopBusiness mtopBusiness = (MtopBusiness) mtopBuilder;
            MtopRequest mtopRequest = mtopContext.mtopRequest;
            Mtop mtop = mtopContext.mtopInstance;
            boolean isNeedEcode = mtopRequest.isNeedEcode();
            boolean isNeedAuth = mtopBusiness.isNeedAuth();
            if (isNeedEcode && isNeedAuth) {
                try {
                    if (mtopBusiness.getRetryTime() < 3) {
                        AuthParam authParam = new AuthParam(mtopBusiness.mtopProp.openAppKey, mtopBusiness.authParam, mtopBusiness.showAuthUI);
                        if (!RemoteAuth.isAuthInfoValid(mtop, authParam)) {
                            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                TBSdkLog.i(TAG, mtopContext.seqNo, " execute CheckAuthBeforeFilter.isAuthInfoValid = false");
                            }
                            RequestPoolManager.getPool(RequestPoolManager.Type.AUTH).addToRequestPool(mtop, authParam.openAppKey, mtopBusiness);
                            RemoteAuth.authorize(mtop, authParam);
                            return "STOP";
                        }
                        String concatStr = StringUtils.concatStr(mtop.getInstanceId(), authParam.openAppKey);
                        if (StringUtils.isBlank(XState.getValue(concatStr, XStateConstants.KEY_ACCESS_TOKEN))) {
                            String authToken = RemoteAuth.getAuthToken(mtop, authParam);
                            if (StringUtils.isNotBlank(authToken)) {
                                XState.setValue(concatStr, XStateConstants.KEY_ACCESS_TOKEN, authToken);
                            } else {
                                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                                    TBSdkLog.i(TAG, mtopContext.seqNo, " execute CheckAuthBeforeFilter.isAuthInfoValid = true,getAuthToken is null.");
                                }
                                RequestPoolManager.getPool(RequestPoolManager.Type.AUTH).addToRequestPool(mtop, authParam.openAppKey, mtopBusiness);
                                RemoteAuth.authorize(mtop, authParam);
                                return "STOP";
                            }
                        }
                    }
                } catch (Exception e) {
                    TBSdkLog.e(TAG, mtopContext.seqNo, " execute CheckAuthBeforeFilter error.", e);
                }
            }
            return "CONTINUE";
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    @NonNull
    public String getName() {
        return TAG;
    }
}
