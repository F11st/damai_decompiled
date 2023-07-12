package cn.damai.ultron.net;

import android.content.Context;
import com.alibaba.android.ultron.trade.data.request.AbstractC3246a;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.f1;
import tb.f30;
import tb.is;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DMOrderAdjustRequester extends AbstractC3246a {
    private static transient /* synthetic */ IpChange $ipChange;
    protected UltronDataManager mDataManager;
    private IDMComponent mTrigger;

    public DMOrderAdjustRequester(UltronDataManager ultronDataManager, Context context, Request request) {
        super(ultronDataManager, context, request);
        this.mDataManager = ultronDataManager;
    }

    @Override // com.alibaba.android.ultron.trade.data.request.AbstractC3246a
    public void sendRequest(final f1 f1Var, IDMContext iDMContext, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-822800353")) {
            ipChange.ipc$dispatch("-822800353", new Object[]{this, f1Var, iDMContext, obj});
        } else if (this.mTrigger != null) {
            new is(this.mContext).h(this.mRequest.getDomain()).a(this.mRequest.getApiName()).I(this.mRequest.getApiVersion()).B(this.mRequest.isNeedEcode()).C(this.mRequest.isNeedSession()).G(this.mRequest.getUnitStrategy()).E(this.mRequest.isPostMethod()).H(this.mRequest.isUseWua()).b(this.mRequest.getBizId()).F(this.mRequest.getHeaders()).d(this.mTrigger, iDMContext).execute(obj, new f1() { // from class: cn.damai.ultron.net.DMOrderAdjustRequester.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.android.ultron.datamodel.IRequestCallback
                public void onError(int i, MtopResponse mtopResponse, Object obj2, boolean z, Map<String, ? extends Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1456898512")) {
                        ipChange2.ipc$dispatch("-1456898512", new Object[]{this, Integer.valueOf(i), mtopResponse, obj2, Boolean.valueOf(z), map});
                        return;
                    }
                    f1 f1Var2 = f1Var;
                    if (f1Var2 != null) {
                        f1Var2.onError(i, mtopResponse, obj2, z, map);
                    }
                }

                @Override // com.taobao.android.ultron.datamodel.IRequestCallback
                public void onSuccess(int i, MtopResponse mtopResponse, Object obj2, IDMContext iDMContext2, Map<String, ? extends Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1936798993")) {
                        ipChange2.ipc$dispatch("1936798993", new Object[]{this, Integer.valueOf(i), mtopResponse, obj2, iDMContext2, map});
                        return;
                    }
                    if (map != null && (map.get("reload") instanceof Boolean) && ((Boolean) map.get("reload")).booleanValue()) {
                        f30.b(iDMContext2, ((AbstractC3246a) DMOrderAdjustRequester.this).mContext);
                    }
                    DMOrderAdjustRequester dMOrderAdjustRequester = DMOrderAdjustRequester.this;
                    dMOrderAdjustRequester.composeComponents(dMOrderAdjustRequester.mDataManager, iDMContext2);
                    f1 f1Var2 = f1Var;
                    if (f1Var2 != null) {
                        f1Var2.onSuccess(i, mtopResponse, obj2, DMOrderAdjustRequester.this.mDataManager.getDataContext(), map);
                    }
                }
            });
        } else {
            throw new IllegalStateException("we find you not call setTrigger() method first before you call AdjustOrderRequester's sendRequest() method");
        }
    }

    public void setTrigger(IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1835558779")) {
            ipChange.ipc$dispatch("1835558779", new Object[]{this, iDMComponent});
        } else {
            this.mTrigger = iDMComponent;
        }
    }
}
