package cn.damai.ultron.net;

import android.content.Context;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.alibaba.android.ultron.trade.data.request.a;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.IDMRequester;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.f1;
import tb.f30;
import tb.is;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DMOrderBuildRequest extends a {
    private static transient /* synthetic */ IpChange $ipChange;

    public DMOrderBuildRequest(BaseDataManager baseDataManager, Context context, Request request) {
        super(baseDataManager, context, request);
    }

    private void useMtopData(final f1 f1Var, IDMContext iDMContext, Object obj) {
        IDMRequester e;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1588314357")) {
            ipChange.ipc$dispatch("-1588314357", new Object[]{this, f1Var, iDMContext, obj});
            return;
        }
        is F = new is(this.mContext).h(this.mRequest.getDomain()).a(this.mRequest.getApiName()).I(this.mRequest.getApiVersion()).B(this.mRequest.isNeedEcode()).C(this.mRequest.isNeedSession()).D(this.mRequest.getParams()).G(this.mRequest.getUnitStrategy()).E(this.mRequest.isPostMethod()).H(this.mRequest.isUseWua()).b(this.mRequest.getBizId()).F(this.mRequest.getHeaders());
        if (iDMContext == null) {
            e = F.c();
        } else {
            e = F.e(iDMContext);
        }
        e.execute(obj, new f1() { // from class: cn.damai.ultron.net.DMOrderBuildRequest.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onError(int i, MtopResponse mtopResponse, Object obj2, boolean z, Map<String, ? extends Object> map) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1573289998")) {
                    ipChange2.ipc$dispatch("-1573289998", new Object[]{this, Integer.valueOf(i), mtopResponse, obj2, Boolean.valueOf(z), map});
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
                if (AndroidInstantRuntime.support(ipChange2, "-929613937")) {
                    ipChange2.ipc$dispatch("-929613937", new Object[]{this, Integer.valueOf(i), mtopResponse, obj2, iDMContext2, map});
                    return;
                }
                f30.b(iDMContext2, ((a) DMOrderBuildRequest.this).mContext);
                DMOrderBuildRequest dMOrderBuildRequest = DMOrderBuildRequest.this;
                dMOrderBuildRequest.composeComponents(((a) dMOrderBuildRequest).mDataManager, iDMContext2);
                f1 f1Var2 = f1Var;
                if (f1Var2 != null) {
                    f1Var2.onSuccess(i, mtopResponse, obj2, ((a) DMOrderBuildRequest.this).mDataManager.getDataContext(), map);
                }
            }
        });
    }

    @Override // com.alibaba.android.ultron.trade.data.request.a
    public void sendRequest(f1 f1Var, IDMContext iDMContext, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "90356765")) {
            ipChange.ipc$dispatch("90356765", new Object[]{this, f1Var, iDMContext, obj});
        } else {
            useMtopData(f1Var, iDMContext, obj);
        }
    }
}
