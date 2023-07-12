package mtopsdk.framework.filter.after;

import android.content.Context;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.RequestPoolManager;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.antiattack.AntiAttackHandler;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AntiAttackAfterFilter implements IAfterFilter {
    private static final String TAG = "mtopsdk.AntiAttackAfterFilter";

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        MtopResponse mtopResponse = mtopContext.mtopResponse;
        if (419 == mtopResponse.getResponseCode()) {
            Map<String, List<String>> headerFields = mtopResponse.getHeaderFields();
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(headerFields, HttpHeaderConstant.BX_ACTION);
            MtopBuilder mtopBuilder = mtopContext.mtopBuilder;
            Mtop mtop = mtopContext.mtopInstance;
            String str = mtopBuilder.mtopProp.userInfo;
            if ("login".equals(singleHeaderFieldByKey) && (mtopBuilder instanceof MtopBusiness)) {
                RequestPoolManager.getPool(RequestPoolManager.Type.SESSION).addToRequestPool(mtop, str, (MtopBusiness) mtopBuilder);
                RemoteLogin.login(mtop, str, true, mtopBuilder);
                return "STOP";
            }
            String singleHeaderFieldByKey2 = HeaderHandlerUtil.getSingleHeaderFieldByKey(headerFields, "location");
            String singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(headerFields, HttpHeaderConstant.X_LOCATION_EXT);
            AntiAttackHandler antiAttackHandler = mtopContext.mtopInstance.getMtopConfig().antiAttackHandler;
            Context context = mtopContext.mtopInstance.getMtopConfig() != null ? mtopContext.mtopInstance.getMtopConfig().context : MtopUtils.getContext();
            if (antiAttackHandler != null && StringUtils.isNotBlank(singleHeaderFieldByKey2) && !MtopUtils.isCurrentProcessBackground(context)) {
                antiAttackHandler.handle(singleHeaderFieldByKey2, singleHeaderFieldByKey3);
                if (mtopBuilder instanceof MtopBusiness) {
                    RequestPoolManager.getPool(RequestPoolManager.Type.ANTI).addToRequestPool(mtop, "", (MtopBusiness) mtopBuilder);
                    return "STOP";
                }
            } else {
                TBSdkLog.e(TAG, mtopContext.seqNo, "didn't register AntiAttackHandler.");
            }
            mtopResponse.setRetCode(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK);
            mtopResponse.setRetMsg(ErrorConstant.ERRMSG_API_41X_ANTI_ATTACK);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                String str2 = mtopContext.seqNo;
                TBSdkLog.w(TAG, str2, "[doAfter] execute AntiAttackAfterFilter apiKey=" + mtopContext.mtopRequest.getKey());
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
