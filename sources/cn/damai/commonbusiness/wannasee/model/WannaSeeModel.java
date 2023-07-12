package cn.damai.commonbusiness.wannasee.model;

import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.commonbusiness.search.request.FollowRequest;
import cn.damai.commonbusiness.wannasee.Wanna2SeeRequest;
import cn.damai.commonbusiness.wannasee.bean.PageData;
import cn.damai.commonbusiness.wannasee.bean.PageType;
import cn.damai.commonbusiness.wannasee.bean.WannaBean;
import cn.damai.commonbusiness.wannasee.listener.OnBizListener;
import cn.damai.commonbusiness.wannasee.listener.OnWannaBeanListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.List;
import tb.iv2;
import tb.vf1;
import tb.z20;
import tb.zr;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WannaSeeModel extends AbsModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isNeedLogin;
    private WannaBean mFirstPageWannaBean;
    private OnWannaBeanListener mListener;
    private final PageType mType;
    private String mUserId;
    private int pageNo = 1;
    private String utPageName;

    public WannaSeeModel(PageType pageType, String str, OnWannaBeanListener onWannaBeanListener, boolean z) {
        this.mType = pageType;
        this.mUserId = str;
        this.mListener = onWannaBeanListener;
        this.isNeedLogin = z;
    }

    static /* synthetic */ int access$208(WannaSeeModel wannaSeeModel) {
        int i = wannaSeeModel.pageNo;
        wannaSeeModel.pageNo = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alarm(Wanna2SeeRequest wanna2SeeRequest, String str, String str2, boolean z) {
        String str3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1019974809")) {
            ipChange.ipc$dispatch("-1019974809", new Object[]{this, wanna2SeeRequest, str, str2, Boolean.valueOf(z)});
        } else if (wanna2SeeRequest != null) {
            if ("live".equals(this.utPageName)) {
                str3 = "现场主页想看";
            } else if (vf1.MY_PAGE.equals(this.utPageName)) {
                str3 = "我的页面想看";
            } else {
                str3 = iv2.USER_HOME_PAGE.equals(this.utPageName) ? "个人主页想看" : this.utPageName;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", this.mType.requestType);
            hashMap.put("tabName", this.mType.tabName);
            hashMap.put("subType", this.mType.subType + "");
            hashMap.put("targetHavanaId", this.mUserId);
            hashMap.put("usercode", z20.i());
            zr.INSTANCE.a().a(wanna2SeeRequest.getApiName()).c(str).d(str2).e(hashMap).g(str3).j(this.utPageName).f(z).b();
        }
    }

    public void cancelFollowData(String str, String str2, final DMMtopRequestListener<FollowDataBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148002643")) {
            ipChange.ipc$dispatch("-148002643", new Object[]{this, str, str2, dMMtopRequestListener});
            return;
        }
        FollowRequest followRequest = new FollowRequest();
        followRequest.operateType = "0";
        followRequest.targetId = str;
        followRequest.targetType = str2;
        followRequest.request(new DMMtopRequestListener<FollowDataBean>(FollowDataBean.class) { // from class: cn.damai.commonbusiness.wannasee.model.WannaSeeModel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1191131831")) {
                    ipChange2.ipc$dispatch("1191131831", new Object[]{this, str3, str4});
                    return;
                }
                DMMtopRequestListener dMMtopRequestListener2 = dMMtopRequestListener;
                if (dMMtopRequestListener2 != null) {
                    dMMtopRequestListener2.onFail(str3, str4);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(FollowDataBean followDataBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1743457993")) {
                    ipChange2.ipc$dispatch("1743457993", new Object[]{this, followDataBean});
                    return;
                }
                if (WannaSeeModel.this.mFirstPageWannaBean != null) {
                    if (WannaSeeModel.this.mType == PageType.SHOW) {
                        WannaBean wannaBean = WannaSeeModel.this.mFirstPageWannaBean;
                        WannaSeeModel wannaSeeModel = WannaSeeModel.this;
                        wannaBean.totalItem = wannaSeeModel.setTotalSub(wannaSeeModel.mFirstPageWannaBean.totalItem);
                    } else if (WannaSeeModel.this.mType == PageType.RECORD) {
                        WannaBean wannaBean2 = WannaSeeModel.this.mFirstPageWannaBean;
                        WannaSeeModel wannaSeeModel2 = WannaSeeModel.this;
                        wannaBean2.totalCard = wannaSeeModel2.setTotalSub(wannaSeeModel2.mFirstPageWannaBean.totalCard);
                    } else if (WannaSeeModel.this.mType == PageType.COMPILATION) {
                        WannaBean wannaBean3 = WannaSeeModel.this.mFirstPageWannaBean;
                        WannaSeeModel wannaSeeModel3 = WannaSeeModel.this;
                        wannaBean3.totalRanking = wannaSeeModel3.setTotalSub(wannaSeeModel3.mFirstPageWannaBean.totalRanking);
                    }
                    if (WannaSeeModel.this.mListener != null) {
                        WannaSeeModel.this.mListener.onWannaBean(WannaSeeModel.this.mFirstPageWannaBean);
                    }
                }
                DMMtopRequestListener dMMtopRequestListener2 = dMMtopRequestListener;
                if (dMMtopRequestListener2 != null) {
                    dMMtopRequestListener2.onSuccess(followDataBean);
                }
            }
        });
    }

    public void load(final boolean z, final OnBizListener<PageData<List>> onBizListener) {
        Wanna2SeeRequest wanna2SeeRequest;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2034250526")) {
            ipChange.ipc$dispatch("-2034250526", new Object[]{this, Boolean.valueOf(z), onBizListener});
            return;
        }
        if (z) {
            this.pageNo = 1;
        }
        PageType pageType = this.mType;
        int i = pageType.subType;
        if (i >= 0) {
            wanna2SeeRequest = new Wanna2SeeRequest(pageType.requestType, this.pageNo, this.isNeedLogin, i);
        } else {
            wanna2SeeRequest = new Wanna2SeeRequest(pageType.requestType, this.pageNo, this.isNeedLogin);
        }
        if (!TextUtils.isEmpty(this.mUserId)) {
            wanna2SeeRequest.targetHavanaId = this.mUserId;
        } else {
            wanna2SeeRequest.targetHavanaId = null;
        }
        final Wanna2SeeRequest wanna2SeeRequest2 = wanna2SeeRequest;
        this.mHolder.a(wanna2SeeRequest.request(new DMMtopRequestListener<WannaBean>(WannaBean.class) { // from class: cn.damai.commonbusiness.wannasee.model.WannaSeeModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1198891190")) {
                    ipChange2.ipc$dispatch("1198891190", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onBizFail(str, str2);
                if (z) {
                    WannaSeeModel.this.alarm(wanna2SeeRequest2, str, str2, false);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(WannaBean wannaBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1483462520")) {
                    ipChange2.ipc$dispatch("-1483462520", new Object[]{this, wannaBean});
                } else if (wannaBean != null) {
                    if (z && WannaSeeModel.this.mListener != null) {
                        WannaSeeModel.this.mFirstPageWannaBean = wannaBean;
                        WannaSeeModel.this.mListener.onWannaBean(wannaBean);
                    }
                    WannaSeeModel.access$208(WannaSeeModel.this);
                    onBizListener.onBizSuccess(PageData.success(z, wannaBean.hasNext, WannaSeeModel.this.mType.getListByType(wannaBean)));
                    if (z) {
                        WannaSeeModel.this.alarm(wanna2SeeRequest2, "2000", JSMethod.NOT_SET, true);
                    }
                } else {
                    onFail("", "");
                }
            }
        }));
    }

    public String setTotalSub(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1722678524")) {
            return (String) ipChange.ipc$dispatch("1722678524", new Object[]{this, str});
        }
        try {
            return String.valueOf(Long.parseLong(str) - 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public void setUtPageName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528061721")) {
            ipChange.ipc$dispatch("-528061721", new Object[]{this, str});
        } else {
            this.utPageName = str;
        }
    }
}
