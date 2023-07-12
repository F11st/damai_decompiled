package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.DViewGenerator;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.exception.DinamicException;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import com.taobao.android.dinamic.tempate.DinamicTemplateDownloaderCallback;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.iy2;
import tb.rc0;
import tb.ry;
import tb.t00;
import tb.v0;
import tb.w0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class n extends b {
    DinamicXEngine d;
    DTemplateManager e;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements DinamicTemplateDownloaderCallback {
        a() {
        }

        @Override // com.taobao.android.dinamic.tempate.DinamicTemplateDownloaderCallback
        public void onDownloadFinish(rc0 rc0Var) {
            if (rc0Var == null) {
                return;
            }
            n nVar = n.this;
            nVar.d.l.e(nVar.r(rc0Var.a), n.this.r(rc0Var.b));
        }
    }

    public n(@NonNull DXEngineConfig dXEngineConfig) {
        super(dXEngineConfig);
        DinamicXEngine dinamicXEngine = new DinamicXEngine(dXEngineConfig);
        this.d = dinamicXEngine;
        this.c = dinamicXEngine.c;
        this.e = DTemplateManager.q(this.b);
    }

    public static Context f() {
        return DinamicXEngine.i();
    }

    private boolean i(DXTemplateItem dXTemplateItem) {
        return dXTemplateItem != null;
    }

    private e o(String str, DXTemplateItem dXTemplateItem, int i, String str2, Map<String, String> map) {
        e eVar = new e(this.b);
        eVar.b = dXTemplateItem;
        e.a aVar = new e.a("Router", str, i);
        aVar.e = str2;
        aVar.f = map;
        eVar.c.add(aVar);
        DXAppMonitor.n(eVar);
        return eVar;
    }

    public t00<DXRootView> c(Context context, ViewGroup viewGroup, @NonNull DXTemplateItem dXTemplateItem) {
        try {
            if (!i(dXTemplateItem)) {
                return new t00<>(o("Router_Create_view", dXTemplateItem, e.DXERROR_ROUTER_CREATE_VIEW_EXCEPTION_TEMPLATE_NULL, "template is null ", null));
            }
            if (h(dXTemplateItem)) {
                return this.d.f(context, dXTemplateItem);
            }
            iy2 j = DViewGenerator.o(this.b).j(context, null, p(dXTemplateItem));
            DXRootView dXRootView = new DXRootView(context);
            t00<DXRootView> t00Var = new t00<>(dXRootView);
            if (j == null) {
                t00Var.d(o("Router_Create_view", dXTemplateItem, e.DXERROR_ROUTER_CREATE_VIEW_EXCEPTION_V2_FAIL, "2.0 createView 失败 viewResult == null", null));
                t00Var.f(null);
                return t00Var;
            }
            if (!j.f()) {
                t00Var.d(o("Router_Create_view", dXTemplateItem, e.DXERROR_ROUTER_CREATE_VIEW_EXCEPTION_V2_FAIL, "2.0 createView 失败", j.b().c()));
                if (j.d() == null) {
                    t00Var.f(null);
                    return t00Var;
                }
            }
            ViewGroup.LayoutParams layoutParams = j.d().getLayoutParams();
            if (layoutParams != null) {
                dXRootView.setLayoutParams(layoutParams);
            } else {
                dXRootView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            dXRootView.setV2(true);
            dXRootView.dxTemplateItem = dXTemplateItem;
            dXRootView.addView(j.d());
            j.i(dXRootView);
            return t00Var;
        } catch (Throwable th) {
            if (DinamicXEngine.x()) {
                th.printStackTrace();
            }
            return new t00<>(o("Router_Create_view", dXTemplateItem, 20005, ry.a(th), null));
        }
    }

    public void d(List<DXTemplateItem> list) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                DXTemplateItem dXTemplateItem = list.get(i);
                if (!h(dXTemplateItem)) {
                    if (!TextUtils.isEmpty(dXTemplateItem.templateUrl) && dXTemplateItem.templateUrl.endsWith(".xml")) {
                        arrayList2.add(p(dXTemplateItem));
                    }
                } else {
                    arrayList.add(dXTemplateItem);
                }
            }
            if (this.e != null && arrayList2.size() > 0) {
                this.e.c(arrayList2, new a());
            }
            if (this.d == null || arrayList.size() <= 0) {
                return;
            }
            this.d.g(arrayList);
        } catch (Throwable th) {
            o("Router_Download", null, 20008, ry.a(th), null);
        }
    }

    public DXTemplateItem e(DXTemplateItem dXTemplateItem) {
        DinamicXEngine dinamicXEngine;
        try {
            if (i(dXTemplateItem)) {
                if (h(dXTemplateItem) && (dinamicXEngine = this.d) != null) {
                    DXTemplateItem h = dinamicXEngine.h(dXTemplateItem);
                    if (h != null) {
                        h.setFileVersion(30000);
                    }
                    return h;
                }
                DXTemplateItem q = q(this.e.e(p(dXTemplateItem)));
                if (q != null) {
                    q.setFileVersion(20000);
                }
                return q;
            }
            return null;
        } catch (Throwable th) {
            if (DinamicXEngine.x()) {
                th.printStackTrace();
            }
            o("Router_Fetch", dXTemplateItem, 20007, ry.a(th), null);
            return null;
        }
    }

    public DinamicXEngine g() {
        return this.d;
    }

    public boolean h(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return false;
        }
        if (dXTemplateItem.getFileVersion() == 30000) {
            return true;
        }
        if (dXTemplateItem.getFileVersion() == 20000) {
            return false;
        }
        if (TextUtils.isEmpty(dXTemplateItem.templateUrl) || !(dXTemplateItem.templateUrl.endsWith(".zip") || dXTemplateItem.templateUrl.contains(".zip"))) {
            return TextUtils.isEmpty(dXTemplateItem.templateUrl) && dXTemplateItem.version >= 0;
        }
        return true;
    }

    public boolean j(long j, IDXDataParser iDXDataParser) {
        DinamicXEngine dinamicXEngine = this.d;
        if (dinamicXEngine != null) {
            return dinamicXEngine.J(j, iDXDataParser);
        }
        return false;
    }

    public boolean k(long j, IDXEventHandler iDXEventHandler) {
        DinamicXEngine dinamicXEngine = this.d;
        if (dinamicXEngine != null) {
            return dinamicXEngine.K(j, iDXEventHandler);
        }
        return false;
    }

    public void l(IDXNotificationListener iDXNotificationListener) {
        DinamicXEngine dinamicXEngine = this.d;
        if (dinamicXEngine != null) {
            dinamicXEngine.L(iDXNotificationListener);
        }
    }

    public boolean m(long j, IDXBuilderWidgetNode iDXBuilderWidgetNode) {
        DinamicXEngine dinamicXEngine = this.d;
        if (dinamicXEngine != null) {
            return dinamicXEngine.N(j, iDXBuilderWidgetNode);
        }
        return false;
    }

    public t00<DXRootView> n(Context context, JSONObject jSONObject, DXRootView dXRootView, int i, int i2, Object obj) {
        DXTemplateItem dXTemplateItem;
        try {
            dXTemplateItem = dXRootView.dxTemplateItem;
            try {
                if (!i(dXTemplateItem)) {
                    return new t00<>(o("Router_Render", dXTemplateItem, 20006, "template is null ", null));
                }
                if (h(dXTemplateItem)) {
                    return this.d.O(context, jSONObject, dXRootView, i, i2, obj);
                }
                iy2 d = DViewGenerator.o(this.b).d(dXRootView, jSONObject, obj);
                if (d == null) {
                    return new t00<>(o("Router_Render", dXTemplateItem, 20006, "2.0 render 失败", null));
                }
                if (!d.e()) {
                    return new t00<>((DXRootView) d.d(), o("Router_Render", dXTemplateItem, 20006, "2.0 render 失败", d.b().c()));
                }
                return new t00<>((DXRootView) d.d());
            } catch (Throwable th) {
                th = th;
                ry.b(th);
                return new t00<>(o("Router_Render", dXTemplateItem, e.DXERROR_ROUTER_RENDER_VIEW_EXCEPTION_CATCH, ry.a(th), null));
            }
        } catch (Throwable th2) {
            th = th2;
            dXTemplateItem = null;
        }
    }

    public DinamicTemplate p(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return null;
        }
        try {
            DinamicTemplate dinamicTemplate = new DinamicTemplate();
            dinamicTemplate.name = dXTemplateItem.name;
            if (dXTemplateItem.version >= 0) {
                dinamicTemplate.version = dXTemplateItem.version + "";
            }
            dinamicTemplate.templateUrl = dXTemplateItem.templateUrl;
            return dinamicTemplate;
        } catch (Throwable th) {
            if (DinamicXEngine.x()) {
                th.printStackTrace();
            }
            o("Router_Transform_Template", null, e.DXERROR_ROUTER_TRASFORM_TEMPLATE_TOV2_EXCEPTION, "transformTemplateToV3 error:" + ry.a(th), null);
            return null;
        }
    }

    public DXTemplateItem q(DinamicTemplate dinamicTemplate) {
        if (dinamicTemplate == null) {
            return null;
        }
        try {
            DXTemplateItem dXTemplateItem = new DXTemplateItem();
            dXTemplateItem.name = dinamicTemplate.name;
            if (!TextUtils.isEmpty(dinamicTemplate.version)) {
                dXTemplateItem.version = Long.parseLong(dinamicTemplate.version);
            } else {
                dXTemplateItem.version = -1L;
            }
            dXTemplateItem.templateUrl = dinamicTemplate.templateUrl;
            return dXTemplateItem;
        } catch (Throwable th) {
            if (DinamicXEngine.x()) {
                th.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("templateName", dinamicTemplate.name);
            hashMap.put("templateVersion", dinamicTemplate.version);
            hashMap.put("templateUrl", dinamicTemplate.templateUrl);
            o("Router_Transform_Template", null, e.DXERROR_ROUTER_TRASFORM_TEMPLATE_TOV3_EXCEPTION, "transformTemplateToV3 error:" + ry.a(th), hashMap);
            return null;
        }
    }

    public List<DXTemplateItem> r(List<DinamicTemplate> list) {
        try {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (DinamicTemplate dinamicTemplate : list) {
                    DXTemplateItem q = q(dinamicTemplate);
                    if (q != null) {
                        arrayList.add(q);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (DinamicXEngine.x()) {
                th.printStackTrace();
            }
            o("Router_Transform_Template", null, e.DXERROR_ROUTER_TRASFORM_TEMPLATE_TOV3_EXCEPTION, "transformTemplateToV3 error:" + ry.a(th), null);
            return null;
        }
    }

    public void s(String str, w0 w0Var) throws DinamicException {
        com.taobao.android.dinamic.a.h().f(str, w0Var);
    }

    public void t(String str, v0 v0Var) throws DinamicException {
        com.taobao.android.dinamic.a.h().e(str, v0Var);
    }

    public void u(String str, DinamicViewAdvancedConstructor dinamicViewAdvancedConstructor) throws DinamicException {
        com.taobao.android.dinamic.a.h().g(str, dinamicViewAdvancedConstructor);
    }
}
