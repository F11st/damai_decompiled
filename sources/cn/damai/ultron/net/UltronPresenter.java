package cn.damai.ultron.net;

import android.app.Activity;
import cn.damai.common.AppConfig;
import cn.damai.common.net.mtop.Util;
import cn.damai.common.user.c;
import cn.damai.common.util.ToastUtil;
import cn.damai.message.observer.Action;
import cn.damai.ultron.utils.DmBuildRequestCallBackImp;
import cn.damai.ultron.utils.DmUltronConstants;
import cn.damai.ultron.utils.DmUltronRequestErrorUtils;
import cn.damai.ultron.view.activity.DmOrderActivity;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.presenter.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.ay1;
import tb.f1;
import tb.gb0;
import tb.kb0;
import tb.mb0;
import tb.nb0;
import tb.pp2;
import tb.sa0;
import tb.su;
import tb.ua0;
import tb.wa0;
import tb.xr;
import tb.xw2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UltronPresenter extends a {
    private static transient /* synthetic */ IpChange $ipChange;
    private DmBuildRequestCallBackImp mBuildRequestCallBackImp;
    private UltronDataManager mDataManager;
    private UltronViewManager mViewManager;

    public UltronPresenter(Activity activity, DmBuildRequestCallBackImp dmBuildRequestCallBackImp) {
        super(activity);
        this.mViewManager = new UltronViewManager(this);
        UltronDataManager ultronDataManager = new UltronDataManager(this);
        this.mDataManager = ultronDataManager;
        init(ultronDataManager, this.mViewManager);
        registerHolderCreator();
        registCustonView();
        setMarkType();
        this.mBuildRequestCallBackImp = dmBuildRequestCallBackImp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void utCustom(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575595353")) {
            ipChange.ipc$dispatch("1575595353", new Object[]{this, str});
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("titlelabel", "false");
            hashMap.put("contentlabel", str);
            hashMap.put("discount_type", ua0.c(getContext()));
            hashMap.put("discount_type_id", ua0.d(getContext()));
            hashMap.put("item_id", ua0.b(getContext()) + "");
            hashMap.put("usercode", z20.E());
            c.e().A(hashMap, pp2.CUSTOM_ORDER, pp2.PROJRCT_CONFIRM_PAY);
        } catch (Exception unused) {
        }
    }

    public void buildPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1527499090")) {
            ipChange.ipc$dispatch("-1527499090", new Object[]{this});
            return;
        }
        showLoading();
        this.mDataManager.buildPage(new f1() { // from class: cn.damai.ultron.net.UltronPresenter.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1244708485")) {
                    ipChange2.ipc$dispatch("1244708485", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, Boolean.valueOf(z), map});
                    return;
                }
                UltronPresenter.this.dismissLoading();
                if (mtopResponse == null) {
                    return;
                }
                String retCode = mtopResponse.getRetCode();
                String errorMsg = Util.getErrorMsg(mtopResponse);
                String api = mtopResponse.getApi();
                int responseCode = mtopResponse.getResponseCode();
                if (UltronPresenter.this.mBuildRequestCallBackImp != null) {
                    UltronPresenter.this.mBuildRequestCallBackImp.onError(retCode, errorMsg, responseCode, api);
                }
                mb0.i(mtopResponse);
            }

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ? extends Object> map) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "606477660")) {
                    ipChange2.ipc$dispatch("606477660", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, iDMContext, map});
                    return;
                }
                UltronPresenter.this.dismissLoading();
                if (UltronPresenter.this.mBuildRequestCallBackImp != null) {
                    UltronPresenter.this.mBuildRequestCallBackImp.onSuccess();
                }
                UltronPresenter ultronPresenter = UltronPresenter.this;
                ultronPresenter.rebuild(ultronPresenter.mDataManager.getDataSource());
                UltronPresenter.this.mDataManager.setDataContext(iDMContext);
                mb0.j(((a) UltronPresenter.this).mContext, mtopResponse);
            }
        });
    }

    public void createOrder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847679353")) {
            ipChange.ipc$dispatch("847679353", new Object[]{this});
            return;
        }
        c.e().x(kb0.u().n(this.mContext));
        xw2 xw2Var = null;
        UltronDataManager ultronDataManager = this.mDataManager;
        if (ultronDataManager != null && ultronDataManager.getDataContext() != null) {
            xw2Var = this.mDataManager.getDataContext().validate();
        }
        if (xw2Var == null) {
            return;
        }
        if (xw2Var.c()) {
            this.mTradeEventHandler.h(this.mTradeEventHandler.d().l(gb0.requestSubmitEvent).i(xw2Var.a()));
        } else {
            ToastUtil.i(xw2Var.b());
        }
    }

    public void createOrderValidateSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "513444324")) {
            ipChange.ipc$dispatch("513444324", new Object[]{this});
            return;
        }
        com.alibaba.android.ultron.trade.data.request.a createRequester = this.mDataManager.getCreateRequester();
        showLoading();
        createRequester.sendRequest(new f1() { // from class: cn.damai.ultron.net.UltronPresenter.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onError(int i, MtopResponse mtopResponse, Object obj, boolean z, Map<String, ? extends Object> map) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-240347066")) {
                    ipChange2.ipc$dispatch("-240347066", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, Boolean.valueOf(z), map});
                    return;
                }
                UltronPresenter.this.dismissLoading();
                if (mtopResponse == null) {
                    return;
                }
                String retCode = mtopResponse.getRetCode();
                String retMsg = mtopResponse.getRetMsg();
                String api = mtopResponse.getApi();
                if (mtopResponse.getResponseCode() == 420) {
                    retMsg = "前方拥挤，亲稍等再试试";
                }
                if (UltronPresenter.this.getContext() != null) {
                    DmUltronRequestErrorUtils.d().h(DmUltronRequestErrorUtils.NetError.NO_NETWORK_TOAST).g(DmUltronRequestErrorUtils.DefaultError.DIALOG).f(DmUltronRequestErrorUtils.BizType.CREATE).a((DmOrderActivity) UltronPresenter.this.getContext(), retCode, retMsg, api);
                }
                UltronPresenter.this.utCustom(retMsg);
                mb0.i(mtopResponse);
            }

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onSuccess(int i, MtopResponse mtopResponse, Object obj, IDMContext iDMContext, Map<String, ? extends Object> map) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "750887355")) {
                    ipChange2.ipc$dispatch("750887355", new Object[]{this, Integer.valueOf(i), mtopResponse, obj, iDMContext, map});
                    return;
                }
                UltronPresenter.this.dismissLoading();
                ((a) UltronPresenter.this).mTradeEventHandler.h(((a) UltronPresenter.this).mTradeEventHandler.d().l(gb0.submitSuccessEvent).k(mtopResponse));
                mb0.j(((a) UltronPresenter.this).mContext, mtopResponse);
            }
        }, this.mDataManager.getDataContext(), null);
    }

    public void dismissLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1026751955")) {
            ipChange.ipc$dispatch("-1026751955", new Object[]{this});
        } else {
            this.mViewManager.dismissLoading();
        }
    }

    @Override // com.alibaba.android.ultron.trade.presenter.IPresenter
    public String getModuleName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1655743394") ? (String) ipChange.ipc$dispatch("1655743394", new Object[]{this}) : ay1.KEY_MODULE_NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.android.ultron.trade.presenter.a
    public void initEventSubscriber() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1554472519")) {
            ipChange.ipc$dispatch("-1554472519", new Object[]{this});
            return;
        }
        super.initEventSubscriber();
        Map<String, Class<? extends ISubscriber>> b = gb0.b();
        if (b != null && !b.isEmpty()) {
            try {
                for (Map.Entry<String, Class<? extends ISubscriber>> entry : b.entrySet()) {
                    this.mTradeEventHandler.a(entry.getKey(), entry.getValue().newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Map<String, Class<? extends ISubscriber>> a = gb0.a();
        if (a == null || a.isEmpty()) {
            return;
        }
        try {
            for (Map.Entry<String, Class<? extends ISubscriber>> entry2 : a.entrySet()) {
                this.mTradeEventHandler.l(entry2.getKey(), entry2.getValue().newInstance());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void listenerNotify(xr xrVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1139063082")) {
            ipChange.ipc$dispatch("-1139063082", new Object[]{this, xrVar});
        } else if (xrVar != null) {
            xrVar.b(DmUltronConstants.REFRESH_CONTACT_COMPONENT_DATA, new Action<DMComponent>() { // from class: cn.damai.ultron.net.UltronPresenter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.message.observer.Action
                public void call(DMComponent dMComponent) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "999852954")) {
                        ipChange2.ipc$dispatch("999852954", new Object[]{this, dMComponent});
                    } else {
                        UltronPresenter.this.getTradeEventHandler().h(UltronPresenter.this.getTradeEventHandler().d().l(gb0.selectContactEvent).m("data", dMComponent));
                    }
                }
            });
            xrVar.b(DmUltronConstants.UPDATE_CONTACT_COMPONENT_DATA, new Action<DMComponent>() { // from class: cn.damai.ultron.net.UltronPresenter.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.message.observer.Action
                public void call(DMComponent dMComponent) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1174827143")) {
                        ipChange2.ipc$dispatch("-1174827143", new Object[]{this, dMComponent});
                        return;
                    }
                    com.taobao.android.ultron.datamodel.imp.a aVar = (com.taobao.android.ultron.datamodel.imp.a) UltronPresenter.this.mDataManager.getDataContext();
                    if (aVar != null) {
                        Map<String, DMComponent> c = aVar.c();
                        c.put(dMComponent.getTag() + JSMethod.NOT_SET + dMComponent.getId(), dMComponent);
                    }
                }
            });
            xrVar.b(DmUltronConstants.REFRESH_PAYTYPE_COMPONENT_DATA, new Action<DMComponent>() { // from class: cn.damai.ultron.net.UltronPresenter.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.message.observer.Action
                public void call(DMComponent dMComponent) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "945460056")) {
                        ipChange2.ipc$dispatch("945460056", new Object[]{this, dMComponent});
                    } else {
                        UltronPresenter.this.mDataManager.respondToLinkage(dMComponent);
                    }
                }
            });
            xrVar.b(DmUltronConstants.SHOW_LOADING_STATE, new Action<Boolean>() { // from class: cn.damai.ultron.net.UltronPresenter.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.message.observer.Action
                public void call(Boolean bool) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1786651772")) {
                        ipChange2.ipc$dispatch("1786651772", new Object[]{this, bool});
                    } else if (bool.booleanValue()) {
                        UltronPresenter.this.showLoading();
                    } else {
                        UltronPresenter.this.dismissLoading();
                    }
                }
            });
            xrVar.b(DmUltronConstants.TRUST_YOUKU_LOGIN, new Action<DMComponent>() { // from class: cn.damai.ultron.net.UltronPresenter.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.message.observer.Action
                public void call(DMComponent dMComponent) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "891067158")) {
                        ipChange2.ipc$dispatch("891067158", new Object[]{this, dMComponent});
                    } else {
                        UltronPresenter.this.mDataManager.respondToLinkage(dMComponent);
                    }
                }
            });
        }
    }

    public void registCustonView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-161304622")) {
            ipChange.ipc$dispatch("-161304622", new Object[]{this});
            return;
        }
        UltronViewManager ultronViewManager = this.mViewManager;
        if (ultronViewManager != null) {
            ultronViewManager.v3RegisterDinamicXView(su.DXDMINPUT_DMINPUT, new su.a());
        }
    }

    public void registerHolderCreator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806374606")) {
            ipChange.ipc$dispatch("806374606", new Object[]{this});
            return;
        }
        registerViewHolderCreator("bundleLine", sa0.CREATOR);
        registerViewHolderCreator(UltronConstants.COMPONENT_VIEWER_TYPE, nb0.CREATOR);
        registerViewHolderCreator(UltronConstants.COMPONENT_PAYTYPE_TYPE, wa0.CREATOR);
    }

    public void setMarkType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1185046110")) {
            ipChange.ipc$dispatch("-1185046110", new Object[]{this});
        } else if (AppConfig.v()) {
            this.mViewManager.setMarkType(1001);
        }
    }

    public void showLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "693066892")) {
            ipChange.ipc$dispatch("693066892", new Object[]{this});
        } else {
            this.mViewManager.showLoading();
        }
    }

    @Override // com.alibaba.android.ultron.trade.presenter.a, com.alibaba.android.ultron.trade.presenter.IPresenter
    public UltronDataManager getDataManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-83729722") ? (UltronDataManager) ipChange.ipc$dispatch("-83729722", new Object[]{this}) : this.mDataManager;
    }

    @Override // com.alibaba.android.ultron.trade.presenter.a, com.alibaba.android.ultron.trade.presenter.IPresenter
    public UltronViewManager getViewManager() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1129329732") ? (UltronViewManager) ipChange.ipc$dispatch("-1129329732", new Object[]{this}) : this.mViewManager;
    }
}
