package com.alibaba.android.ultron.trade.data.request;

import android.content.Context;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.imp.c;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import tb.f1;
import tb.lp2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public abstract class a {
    protected Context mContext;
    protected BaseDataManager mDataManager;
    protected Request mRequest;

    public a(BaseDataManager baseDataManager, Context context, Request request) {
        Objects.requireNonNull(baseDataManager, "param dataManager can not be null");
        Objects.requireNonNull(context, "param context can not be null");
        Objects.requireNonNull(request, "param request can not be null");
        this.mDataManager = baseDataManager;
        this.mContext = context;
        this.mRequest = request;
    }

    public void appendHeaders(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mRequest.appendHeaders(map);
    }

    public void appendParams(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.mRequest.appendParams(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void composeComponents(BaseDataManager baseDataManager, IDMContext iDMContext) {
        if (baseDataManager == null) {
            return;
        }
        baseDataManager.setDataContext(iDMContext);
        if (iDMContext == null || iDMContext.getComponents() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (IDMComponent iDMComponent : iDMContext.getComponents()) {
            if (iDMComponent != null) {
                String e = c.e(iDMComponent);
                if (WXBasicComponentType.FOOTER.equals(e)) {
                    arrayList2.add(iDMComponent);
                } else if ("header".equals(e)) {
                    arrayList.add(iDMComponent);
                }
            }
            arrayList3.add(iDMComponent);
        }
        baseDataManager.setDataSource(new lp2(arrayList, arrayList3, arrayList2));
    }

    public Request getRequest() {
        return this.mRequest;
    }

    public abstract void sendRequest(f1 f1Var, IDMContext iDMContext, Object obj);
}
