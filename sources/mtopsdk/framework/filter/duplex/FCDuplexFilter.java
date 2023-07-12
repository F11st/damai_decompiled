package mtopsdk.framework.filter.duplex;

import androidx.annotation.NonNull;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.middletier.fc.FCAction;
import com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback;
import com.alibaba.wireless.security.open.middletier.fc.IFCComponent;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.tao.remotebusiness.RequestPool;
import com.taobao.tao.remotebusiness.RequestPoolManager;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.framework.filter.after.AntiAttackAfterFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.antiattack.ApiLockHelper;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.util.ErrorConstant;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.security.util.SignConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FCDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.FCDuplexFilter";
    private FlowLimitDuplexFilter flowLimitDuplexFilter = new FlowLimitDuplexFilter();
    private AntiAttackAfterFilter antiAttackAfterFilter = new AntiAttackAfterFilter();

    private String doOldFCAndAntiFilter(MtopContext mtopContext) {
        if (this.flowLimitDuplexFilter != null && this.antiAttackAfterFilter != null) {
            TBSdkLog.e(TAG, " [doOldFCAndAntiFilter] use old to do flow control, " + mtopContext.seqNo);
            String doAfter = this.antiAttackAfterFilter.doAfter(mtopContext);
            return (doAfter == null || "STOP".equals(doAfter)) ? doAfter : this.flowLimitDuplexFilter.doAfter(mtopContext);
        }
        TBSdkLog.i(TAG, " [doAfter]flowLimitDuplexFilter or antiAttackAfterFilter create fail ");
        return "STOP";
    }

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(final MtopContext mtopContext) {
        if ((SwitchConfig.getInstance().getUseSecurityAdapter() & 2) != 2) {
            return doOldFCAndAntiFilter(mtopContext);
        }
        final MtopResponse mtopResponse = mtopContext.mtopResponse;
        int responseCode = mtopResponse.getResponseCode();
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, " [doAfter]response code " + responseCode);
        }
        Map<String, List<String>> headerFields = mtopResponse.getHeaderFields();
        String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(headerFields, SignConstants.BX_USE_SG);
        if (StringUtils.isNotBlank(singleHeaderFieldByKey) && !Boolean.parseBoolean(singleHeaderFieldByKey)) {
            return doOldFCAndAntiFilter(mtopContext);
        }
        if (mtopContext.mtopBuilder instanceof MtopBusiness) {
            if (headerFields != null) {
                try {
                    HashMap hashMap = new HashMap(headerFields);
                    IFCComponent iFCComponent = (IFCComponent) SecurityGuardManager.getInstance(mtopContext.mtopInstance.getMtopConfig().context).getInterface(IFCComponent.class);
                    MtopStatistics mtopStatistics = mtopContext.stats;
                    mtopStatistics.fcProcessCheckStartTime = mtopStatistics.currentTimeMillis();
                    if (iFCComponent != null) {
                        IFCComponent.ResponseHeaderType responseHeaderType = IFCComponent.ResponseHeaderType.KVL;
                        if (iFCComponent.needFCProcessOrNot(responseCode, hashMap, responseHeaderType)) {
                            MtopStatistics mtopStatistics2 = mtopContext.stats;
                            mtopStatistics2.fcProcessCheckEndTime = mtopStatistics2.currentTimeMillis();
                            final MtopBuilder mtopBuilder = mtopContext.mtopBuilder;
                            final Mtop mtop = mtopContext.mtopInstance;
                            RequestPoolManager.getPool(RequestPoolManager.Type.ANTI).addToRequestPool(mtop, "", (MtopBusiness) mtopBuilder);
                            IFCActionCallback iFCActionCallback = new IFCActionCallback() { // from class: mtopsdk.framework.filter.duplex.FCDuplexFilter.1
                                @Override // com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback
                                public void onAction(final long j, final FCAction.FCMainAction fCMainAction, final long j2, final HashMap hashMap2) {
                                    String str = mtopContext.seqNo;
                                    MtopSDKThreadPoolExecutorFactory.submitCallbackTask(str != null ? str.hashCode() : hashCode(), new Runnable() { // from class: mtopsdk.framework.filter.duplex.FCDuplexFilter.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            TBSdkLog.e(FCDuplexFilter.TAG, " [IFCActionCallback] onAction: " + ("--->###sessionId = " + j + ", MainAction = " + fCMainAction + ", subAction = " + j2 + ", extraInfo = " + hashMap2.toString() + "### ") + mtopContext.seqNo);
                                            MtopStatistics mtopStatistics3 = mtopContext.stats;
                                            mtopStatistics3.fcProcessCallbackTime = mtopStatistics3.currentTimeMillis();
                                            mtopContext.stats.bxMainAction = fCMainAction.ordinal();
                                            MtopStatistics mtopStatistics4 = mtopContext.stats;
                                            long j3 = j2;
                                            mtopStatistics4.bxSubAction = j3;
                                            FCAction.FCMainAction fCMainAction2 = fCMainAction;
                                            if (fCMainAction2 == FCAction.FCMainAction.RETRY) {
                                                mtopStatistics4.bxRetry = 1;
                                                String str2 = (String) hashMap2.get(SignConstants.BX_RESEND);
                                                if (StringUtils.isNotBlank(str2)) {
                                                    HashMap hashMap3 = new HashMap();
                                                    try {
                                                        hashMap3.put(SignConstants.BX_RESEND, URLEncoder.encode(str2, "utf-8"));
                                                        mtopBuilder.headers(hashMap3);
                                                    } catch (UnsupportedEncodingException unused) {
                                                        TBSdkLog.e(FCDuplexFilter.TAG, "[IFCActionCallback]urlEncode x-bx-resend=" + str2 + "error");
                                                    }
                                                }
                                                if ((j2 & FCAction.FCSubAction.LOGIN.getValue()) > 0) {
                                                    RequestPool pool = RequestPoolManager.getPool(RequestPoolManager.Type.ANTI);
                                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                    pool.removeRequest(mtop, "", (MtopBusiness) mtopBuilder);
                                                    String str3 = mtopBuilder.mtopProp.userInfo;
                                                    RequestPool pool2 = RequestPoolManager.getPool(RequestPoolManager.Type.SESSION);
                                                    AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                                    pool2.addToRequestPool(mtop, str3, (MtopBusiness) mtopBuilder);
                                                    AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                                    RemoteLogin.login(mtop, str3, true, mtopBuilder);
                                                } else if ((j2 & FCAction.FCSubAction.WUA.getValue()) > 0) {
                                                    mtopContext.property.wuaRetry = true;
                                                    RequestPool pool3 = RequestPoolManager.getPool(RequestPoolManager.Type.ANTI);
                                                    AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                                                    pool3.retryRequest(mtop, "", (MtopBusiness) mtopBuilder);
                                                } else {
                                                    RequestPool pool4 = RequestPoolManager.getPool(RequestPoolManager.Type.ANTI);
                                                    AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                                                    pool4.retryRequest(mtop, "", (MtopBusiness) mtopBuilder);
                                                }
                                            } else if (fCMainAction2 == FCAction.FCMainAction.FAIL) {
                                                if ((j3 & FCAction.FCSubAction.LOGIN.getValue()) > 0) {
                                                    AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                                                    MtopBuilder mtopBuilder2 = mtopBuilder;
                                                    RemoteLogin.login(mtop, mtopBuilder2.mtopProp.userInfo, true, mtopBuilder2);
                                                    RequestPool pool5 = RequestPoolManager.getPool(RequestPoolManager.Type.ANTI);
                                                    AnonymousClass1 anonymousClass17 = AnonymousClass1.this;
                                                    pool5.removeRequest(mtop, "", (MtopBusiness) mtopBuilder);
                                                    mtopResponse.setRetCode(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK);
                                                    mtopResponse.setRetMsg(ErrorConstant.ERRMSG_API_41X_ANTI_ATTACK);
                                                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                                                        TBSdkLog.w(FCDuplexFilter.TAG, mtopContext.seqNo, "[IFCActionCallback] execute FCDuplexFilter apiKey=" + mtopContext.mtopRequest.getKey());
                                                    }
                                                    FilterUtils.handleExceptionCallBack(mtopContext);
                                                } else if ((j2 & FCAction.FCSubAction.FL.getValue()) > 0) {
                                                    RequestPool pool6 = RequestPoolManager.getPool(RequestPoolManager.Type.ANTI);
                                                    AnonymousClass1 anonymousClass18 = AnonymousClass1.this;
                                                    pool6.removeRequest(mtop, "", (MtopBusiness) mtopBuilder);
                                                    String key = mtopContext.mtopRequest.getKey();
                                                    long longValue = ((Long) hashMap2.get("bx-sleep")).longValue();
                                                    ApiLockHelper.lock(key, SDKUtils.getCorrectionTime(), longValue);
                                                    AnonymousClass1 anonymousClass19 = AnonymousClass1.this;
                                                    mtopContext.stats.bxSleep = longValue;
                                                    FilterUtils.parseRetCodeFromHeader(mtopResponse);
                                                    if (StringUtils.isBlank(mtopResponse.getRetCode())) {
                                                        mtopContext.mtopResponse.setRetCode("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
                                                        mtopContext.mtopResponse.setRetMsg(ErrorConstant.ERRMSG_API_FLOW_LIMIT_LOCKED);
                                                    }
                                                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                                                        TBSdkLog.w(FCDuplexFilter.TAG, mtopContext.seqNo, "[IFCActionCallback] doAfter execute FlowLimitDuplexFilter apiKey=" + key + " ,retCode=" + mtopResponse.getRetCode());
                                                    }
                                                    FilterUtils.handleExceptionCallBack(mtopContext);
                                                } else {
                                                    RequestPool pool7 = RequestPoolManager.getPool(RequestPoolManager.Type.ANTI);
                                                    AnonymousClass1 anonymousClass110 = AnonymousClass1.this;
                                                    pool7.removeRequest(mtop, "", (MtopBusiness) mtopBuilder);
                                                    mtopContext.mtopResponse.setRetCode(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK);
                                                    mtopContext.mtopResponse.setRetMsg(ErrorConstant.ERRMSG_API_41X_ANTI_ATTACK);
                                                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                                                        TBSdkLog.w(FCDuplexFilter.TAG, mtopContext.seqNo, "[IFCActionCallback][FAIL] execute FCDuplexFilter apiKey=" + mtopContext.mtopRequest.getKey());
                                                    }
                                                    FilterUtils.handleExceptionCallBack(mtopContext);
                                                }
                                            } else {
                                                RequestPool pool8 = RequestPoolManager.getPool(RequestPoolManager.Type.ANTI);
                                                AnonymousClass1 anonymousClass111 = AnonymousClass1.this;
                                                pool8.removeRequest(mtop, "", (MtopBusiness) mtopBuilder);
                                                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.WarnEnable)) {
                                                    TBSdkLog.w(FCDuplexFilter.TAG, mtopContext.seqNo, "[IFCActionCallback][SUCCESS/CANCEL/TIMEOUT] execute FCDuplexFilter apiKey=" + mtopContext.mtopRequest.getKey());
                                                }
                                                mtopContext.mtopResponse.setRetCode(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK);
                                                mtopContext.mtopResponse.setRetMsg(ErrorConstant.ERRMSG_API_41X_ANTI_ATTACK);
                                                FilterUtils.handleExceptionCallBack(mtopContext);
                                            }
                                        }
                                    });
                                }

                                @Override // com.alibaba.wireless.security.open.middletier.fc.IFCActionCallback
                                public void onPreAction(long j, boolean z) {
                                    mtopContext.stats.bxSessionId = String.valueOf(j);
                                    mtopContext.stats.bxUI = z;
                                }
                            };
                            MtopStatistics mtopStatistics3 = mtopContext.stats;
                            mtopStatistics3.fcProcessStartTime = mtopStatistics3.currentTimeMillis();
                            TBSdkLog.e(TAG, "[IFCActionCallback]start process fc ", mtopContext.seqNo);
                            iFCComponent.processFCContent(responseCode, hashMap, iFCActionCallback, responseHeaderType);
                            return "STOP";
                        }
                    }
                    MtopStatistics mtopStatistics4 = mtopContext.stats;
                    mtopStatistics4.fcProcessCheckEndTime = mtopStatistics4.currentTimeMillis();
                    return "CONTINUE";
                } catch (SecException e) {
                    TBSdkLog.e(TAG, "[IFCActionCallback] fc component exception , err code = " + e.getErrorCode());
                    return "CONTINUE";
                } catch (Throwable th) {
                    TBSdkLog.e(TAG, "[IFCActionCallback] fc component exception , msg = " + th.getMessage());
                    return "CONTINUE";
                }
            }
            return "CONTINUE";
        }
        return doOldFCAndAntiFilter(mtopContext);
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        FlowLimitDuplexFilter flowLimitDuplexFilter = this.flowLimitDuplexFilter;
        return flowLimitDuplexFilter != null ? flowLimitDuplexFilter.doBefore(mtopContext) : "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    @NonNull
    public String getName() {
        return TAG;
    }
}
