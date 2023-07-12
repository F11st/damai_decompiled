package cn.damai.ultron.net;

import android.content.Context;
import android.util.Log;
import com.alibaba.android.ultron.trade.data.request.AbstractC3246a;
import com.alibaba.android.ultron.trade.data.request.Request;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;
import tb.f1;
import tb.is;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DMOrderCreateRequester extends AbstractC3246a {
    private static transient /* synthetic */ IpChange $ipChange;
    private Class mClazz;

    public DMOrderCreateRequester(UltronDataManager ultronDataManager, Context context, Request request) {
        super(ultronDataManager, context, request);
    }

    @Override // com.alibaba.android.ultron.trade.data.request.AbstractC3246a
    public void sendRequest(final f1 f1Var, IDMContext iDMContext, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615351540")) {
            ipChange.ipc$dispatch("-1615351540", new Object[]{this, f1Var, iDMContext, obj});
            return;
        }
        if (this.mClazz == null) {
            Log.w(getClass().getName(), "we recommend you to call setResponseReflectedClass() method to reflect the network data into a high data structure");
        }
        new is(this.mContext).h(this.mRequest.getDomain()).a(this.mRequest.getApiName()).I(this.mRequest.getApiVersion()).D(this.mRequest.getParams()).B(this.mRequest.isNeedEcode()).C(this.mRequest.isNeedSession()).G(this.mRequest.getUnitStrategy()).E(this.mRequest.isPostMethod()).H(this.mRequest.isUseWua()).b(this.mRequest.getBizId()).F(this.mRequest.getHeaders()).f(this.mClazz, iDMContext).execute(obj, new f1() { // from class: cn.damai.ultron.net.DMOrderCreateRequester.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.taobao.android.ultron.datamodel.IRequestCallback
            public void onError(int i, MtopResponse mtopResponse, Object obj2, boolean z, Map<String, ? extends Object> map) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1316990947")) {
                    ipChange2.ipc$dispatch("1316990947", new Object[]{this, Integer.valueOf(i), mtopResponse, obj2, Boolean.valueOf(z), map});
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
                if (AndroidInstantRuntime.support(ipChange2, "-1354347586")) {
                    ipChange2.ipc$dispatch("-1354347586", new Object[]{this, Integer.valueOf(i), mtopResponse, obj2, iDMContext2, map});
                    return;
                }
                ((AbstractC3246a) DMOrderCreateRequester.this).mDataManager.setDataContext(iDMContext2);
                f1 f1Var2 = f1Var;
                if (f1Var2 != null) {
                    f1Var2.onSuccess(i, mtopResponse, obj2, ((AbstractC3246a) DMOrderCreateRequester.this).mDataManager.getDataContext(), map);
                }
            }
        });
    }

    public void setResponseReflectedClass(Class cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688485580")) {
            ipChange.ipc$dispatch("-688485580", new Object[]{this, cls});
        } else {
            this.mClazz = cls;
        }
    }
}
