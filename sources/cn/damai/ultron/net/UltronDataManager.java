package cn.damai.ultron.net;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.ultron.utils.DmUltronRequestErrorUtils;
import cn.damai.ultron.view.activity.DmOrderActivity;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.f1;
import tb.mb0;
import tb.np2;
import tb.pa0;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UltronDataManager extends BaseDataManager {
    private static transient /* synthetic */ IpChange $ipChange;
    protected DmLinkageNotification linkageNotification;
    protected DMQueryKey queryKey;

    public UltronDataManager(UltronPresenter ultronPresenter) {
        super(ultronPresenter);
    }

    private void createAdjustRequest(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812943673")) {
            ipChange.ipc$dispatch("-1812943673", new Object[]{this, hashMap});
            return;
        }
        if (this.queryKey == null) {
            this.queryKey = new DMQueryKey();
        }
        Request bizId = new Request().setDomain(this.queryKey.getDomain()).setApiName(this.queryKey.getAdjustApiName()).setApiVersion(this.queryKey.getAdjustVersion()).setPostMethod(true).setNeedEcode(true).setNeedSession(true).setHeaders(getHeaderMap()).setBizId(24);
        if (hashMap != null && hashMap.size() > 0) {
            bizId.setHeaders(hashMap);
        }
        this.mAdjustRequester = new DMOrderAdjustRequester(this, this.mContext, bizId);
    }

    private void createBuildRequest(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869351978")) {
            ipChange.ipc$dispatch("-1869351978", new Object[]{this, hashMap});
            return;
        }
        Context context = this.mContext;
        Activity activity = (Activity) context;
        if (activity == null) {
            return;
        }
        Map<String, String> makeBuildOrderParams = UltronParamsMaker.makeBuildOrderParams(context, activity.getIntent());
        if (this.queryKey == null) {
            this.queryKey = new DMQueryKey(makeBuildOrderParams);
        }
        Request bizId = new Request().setDomain(this.queryKey.getDomain()).setApiName(this.queryKey.getBuildApiName()).setApiVersion(this.queryKey.getBuildVersion()).setParams(makeBuildOrderParams).setPostMethod(true).setNeedEcode(true).setNeedSession(true).setUseWua(true).setBizId(24);
        if (hashMap != null && hashMap.size() > 0) {
            bizId.setHeaders(hashMap);
        }
        this.mBuildRequester = new DMOrderBuildRequest(this, this.mContext, bizId);
    }

    private void createSubmitRequest(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-588088098")) {
            ipChange.ipc$dispatch("-588088098", new Object[]{this, hashMap});
            return;
        }
        if (this.queryKey == null) {
            this.queryKey = new DMQueryKey();
        }
        Request bizId = new Request().setDomain(this.queryKey.getDomain()).setApiName(this.queryKey.getCreateApiName()).setApiVersion(this.queryKey.getCreateVersion()).setPostMethod(true).setNeedEcode(true).setNeedSession(true).setUseWua(true).setHeaders(getHeaderMap()).setBizId(24);
        if (hashMap != null && hashMap.size() > 0) {
            bizId.setHeaders(hashMap);
        }
        this.mCreateRequester = new DMOrderCreateRequester(this, this.mContext, bizId);
    }

    private HashMap<String, String> getHeaderMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1923800412")) {
            return (HashMap) ipChange.ipc$dispatch("-1923800412", new Object[]{this});
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (AppConfig.v() && !TextUtils.isEmpty(z20.s())) {
            hashMap.put("EagleEye-UserData", "scm_project=" + z20.s());
        }
        return hashMap;
    }

    public void buildPage(final f1 f1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072341208")) {
            ipChange.ipc$dispatch("-2072341208", new Object[]{this, f1Var});
        } else {
            getBuildRequester().sendRequest(new f1() { // from class: cn.damai.ultron.net.UltronDataManager.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.android.ultron.datamodel.IRequestCallback
                public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-851746629")) {
                        ipChange2.ipc$dispatch("-851746629", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, Boolean.valueOf(z), map});
                        return;
                    }
                    f1 f1Var2 = f1Var;
                    if (f1Var2 == null) {
                        return;
                    }
                    f1Var2.onError(i, mtopResponse, obj, z, map);
                }

                @Override // com.taobao.android.ultron.datamodel.IRequestCallback
                public void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ? extends Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-750467610")) {
                        ipChange2.ipc$dispatch("-750467610", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, iDMContext, map});
                        return;
                    }
                    f1 f1Var2 = f1Var;
                    if (f1Var2 == null) {
                        return;
                    }
                    f1Var2.onSuccess(i, mtopResponse, obj, iDMContext, map);
                }
            }, null, null);
        }
    }

    @Override // com.alibaba.android.ultron.trade.presenter.BaseDataManager
    protected void initRequester() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2123846852")) {
            ipChange.ipc$dispatch("2123846852", new Object[]{this});
            return;
        }
        HashMap<String, String> headerMap = getHeaderMap();
        createBuildRequest(headerMap);
        createAdjustRequest(headerMap);
        createSubmitRequest(headerMap);
    }

    public void respondToLinkage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459927461")) {
            ipChange.ipc$dispatch("1459927461", new Object[]{this});
            return;
        }
        DmLinkageNotification dmLinkageNotification = this.linkageNotification;
        if (dmLinkageNotification == null) {
            return;
        }
        respondToLinkage(dmLinkageNotification.getTrigger(), this.linkageNotification.getEvent());
    }

    @Override // com.alibaba.android.ultron.trade.presenter.BaseDataManager
    public void sendRespondRequest(IDMComponent iDMComponent, final np2 np2Var, boolean z, f1 f1Var, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-914973900")) {
            ipChange.ipc$dispatch("-914973900", new Object[]{this, iDMComponent, np2Var, Boolean.valueOf(z), f1Var, obj});
            return;
        }
        ((UltronPresenter) this.mPresenter).showLoading();
        DmLinkageNotification dmLinkageNotification = this.linkageNotification;
        if (dmLinkageNotification == null) {
            this.linkageNotification = new DmLinkageNotification(iDMComponent, np2Var);
        } else {
            dmLinkageNotification.setTradeEventAndTrigger(np2Var, iDMComponent);
        }
        DMOrderAdjustRequester dMOrderAdjustRequester = (DMOrderAdjustRequester) getAdjustRequester();
        dMOrderAdjustRequester.setTrigger(iDMComponent);
        dMOrderAdjustRequester.sendRequest(new f1() { // from class: cn.damai.ultron.net.UltronDataManager.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onError(int i, MtopResponse mtopResponse, Object obj2, boolean z2, Map<String, ? extends Object> map) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1958165116")) {
                    ipChange2.ipc$dispatch("1958165116", new Object[]{this, Integer.valueOf(i), mtopResponse, obj2, Boolean.valueOf(z2), map});
                    return;
                }
                ((UltronPresenter) ((BaseDataManager) UltronDataManager.this).mPresenter).dismissLoading();
                np2 np2Var2 = np2Var;
                if (np2Var2 != null) {
                    np2Var2.h();
                }
                if (mtopResponse == null) {
                    return;
                }
                String retCode = mtopResponse.getRetCode();
                String errorMsg = Util.getErrorMsg(mtopResponse);
                String api = mtopResponse.getApi();
                if (mtopResponse.getResponseCode() == 420) {
                    errorMsg = "前方拥挤，亲稍等再试试";
                }
                if (((BaseDataManager) UltronDataManager.this).mPresenter != null && ((BaseDataManager) UltronDataManager.this).mPresenter.getContext() != null) {
                    DmUltronRequestErrorUtils.d().f(DmUltronRequestErrorUtils.BizType.ADJUEST).g(DmUltronRequestErrorUtils.DefaultError.ERROR_LAYOUT).h(DmUltronRequestErrorUtils.NetError.NO_NETWORK).a((DmOrderActivity) ((BaseDataManager) UltronDataManager.this).mPresenter.getContext(), retCode, errorMsg, api);
                }
                mb0.i(mtopResponse);
            }

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onSuccess(int i, MtopResponse mtopResponse, Object obj2, IDMContext iDMContext, Map<String, ? extends Object> map) {
                DmOrderActivity dmOrderActivity;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-606057915")) {
                    ipChange2.ipc$dispatch("-606057915", new Object[]{this, Integer.valueOf(i), mtopResponse, obj2, iDMContext, map});
                    return;
                }
                ((UltronPresenter) ((BaseDataManager) UltronDataManager.this).mPresenter).dismissLoading();
                if (((BaseDataManager) UltronDataManager.this).mPresenter != null && ((BaseDataManager) UltronDataManager.this).mPresenter.getContext() != null && (dmOrderActivity = (DmOrderActivity) ((BaseDataManager) UltronDataManager.this).mPresenter.getContext()) != null) {
                    pa0 pa0Var = dmOrderActivity.dmErrorViewHolder;
                    if (pa0Var != null) {
                        pa0Var.d();
                    }
                    dmOrderActivity.updateTicketDetailData();
                }
                ((UltronPresenter) ((BaseDataManager) UltronDataManager.this).mPresenter).rebuild(UltronDataManager.this.getDataSource());
                UltronDataManager.this.setDataContext(iDMContext);
                mb0.j(((BaseDataManager) UltronDataManager.this).mContext, mtopResponse);
            }
        }, this.mDataContext, null);
    }
}
