package mtopsdk.framework.filter.duplex;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.RequestPoolManager;
import com.taobao.tao.remotebusiness.login.LoginContext;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CheckSessionDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.CheckSessionDuplexFilter";

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        MtopBuilder mtopBuilder = mtopContext.mtopBuilder;
        if (mtopBuilder instanceof MtopBusiness) {
            MtopBusiness mtopBusiness = (MtopBusiness) mtopBuilder;
            MtopRequest mtopRequest = mtopContext.mtopRequest;
            Mtop mtop = mtopContext.mtopInstance;
            MtopResponse mtopResponse = mtopContext.mtopResponse;
            if (mtop.getMtopConfig().notifySessionResult) {
                String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.X_SESSION_RET);
                if (StringUtils.isNotBlank(singleHeaderFieldByKey)) {
                    Bundle bundle = new Bundle();
                    bundle.putString(HttpHeaderConstant.X_SESSION_RET, singleHeaderFieldByKey);
                    bundle.putString(HttpHeaderConstant.DATE, HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.DATE));
                    RemoteLogin.setSessionInvalid(mtop, bundle);
                }
            }
            if (mtopResponse.isSessionInvalid() && mtopRequest.isNeedEcode() && mtopBusiness.getRetryTime() == 0) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    TBSdkLog.e(TAG, mtopContext.seqNo, "execute CheckSessionAfterFilter.");
                }
                String str = mtopBusiness.mtopProp.userInfo;
                RequestPoolManager.getPool(RequestPoolManager.Type.SESSION).addToRequestPool(mtop, str, mtopBusiness);
                RemoteLogin.login(mtop, str, mtopBusiness.isShowLoginUI(), mtopResponse);
                return "STOP";
            }
            return "CONTINUE";
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        String str;
        MtopBuilder mtopBuilder = mtopContext.mtopBuilder;
        if (mtopBuilder instanceof MtopBusiness) {
            MtopBusiness mtopBusiness = (MtopBusiness) mtopBuilder;
            MtopRequest mtopRequest = mtopContext.mtopRequest;
            Mtop mtop = mtopContext.mtopInstance;
            boolean isNeedEcode = mtopRequest.isNeedEcode();
            try {
                str = mtopBusiness.mtopProp.userInfo;
            } catch (Exception e) {
                TBSdkLog.e(TAG, mtopContext.seqNo, " execute CheckSessionBeforeFilter error.", e);
            }
            if (isNeedEcode && !RemoteLogin.isSessionValid(mtop, str)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                    TBSdkLog.e(TAG, mtopContext.seqNo, "execute CheckSessionBeforeFilter.isSessionInvalid = false");
                }
                RequestPoolManager.getPool(RequestPoolManager.Type.SESSION).addToRequestPool(mtop, str, mtopBusiness);
                RemoteLogin.login(mtop, str, mtopBusiness.isShowLoginUI(), mtopRequest);
                return "STOP";
            }
            if (isNeedEcode && StringUtils.isBlank(mtop.getMultiAccountSid(str))) {
                LoginContext loginContext = RemoteLogin.getLoginContext(mtop, str);
                if (loginContext != null && !StringUtils.isBlank(loginContext.sid)) {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e(TAG, mtopContext.seqNo, "session in loginContext is valid but mtopInstance's sid is null");
                    }
                    mtop.registerMultiAccountSession(str, loginContext.sid, loginContext.userId);
                } else {
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                        TBSdkLog.e(TAG, mtopContext.seqNo, "execute CheckSessionBeforeFilter.isSessionInvalid = true,getLoginContext = null");
                    }
                    RequestPoolManager.getPool(RequestPoolManager.Type.SESSION).addToRequestPool(mtop, str, mtopBusiness);
                    RemoteLogin.login(mtop, str, mtopBusiness.isShowLoginUI(), mtopRequest);
                    return "STOP";
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
