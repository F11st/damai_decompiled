package com.alibaba.emas.datalab.controller;

import android.content.Context;
import android.util.Log;
import com.alibaba.emas.datalab.C3318a;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.emas.datalab.stage.Stage;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.Map;
import tb.p30;
import tb.ve2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.emas.datalab.controller.a */
/* loaded from: classes15.dex */
public class C3322a {
    public static final String DATALAB_ALGO_UPDATE = "datalab_algo_update";
    public static final String DATALAB_ALGO_ZCACHE = "datalab_algo_zcache";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.emas.datalab.controller.a$a */
    /* loaded from: classes6.dex */
    class C3323a implements OConfigListener {
        final /* synthetic */ Context a;

        C3323a(C3322a c3322a, Context context) {
            this.a = context;
        }

        @Override // com.taobao.orange.OConfigListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            if (str.equals(C3322a.DATALAB_ALGO_UPDATE)) {
                String config = OrangeConfig.getInstance().getConfig(str, "algo_update_open", null);
                Log.e("Datalab.Orange", "orange algo update open value is " + config);
                if (config.equals("true")) {
                    C3318a.b().b.b = Boolean.TRUE;
                } else {
                    C3318a.b().b.b = Boolean.FALSE;
                }
            }
            if (str.equals(C3322a.DATALAB_ALGO_ZCACHE)) {
                p30 p30Var = new p30();
                p30Var.a = "orange";
                Stage stage = Stage.NOTIFY;
                String config2 = OrangeConfig.getInstance().getConfig(str, "config_biz", null);
                Log.e("Datalab.Orange", "orange biz value is " + config2);
                if (config2 == null) {
                    Log.w("Datalab.Orange", "biz value is null");
                    return;
                }
                try {
                    p30Var.b = DatalabBizType.valueOf(config2);
                } catch (Exception e) {
                    Log.e("Datalab.Orange", "biz type not support ", e);
                }
                String config3 = OrangeConfig.getInstance().getConfig(str, "config_start", "[]");
                Log.e("Datalab.Orange", "orange start value is " + config3);
                if (config3 != null && !config3.equals("[]")) {
                    p30Var.c = "app.start";
                    p30Var.d = config3;
                    try {
                        if (ve2.b().a(this.a, p30Var.b, p30Var.c) == null) {
                            Log.e("Datalab.Orange", "first cache to sp " + p30Var.b + " " + p30Var.c);
                            ve2.b().c(this.a, p30Var, p30Var.b, p30Var.c);
                            C3318a.b().b.e(p30Var);
                        }
                    } catch (Exception e2) {
                        Log.e("Datalab.Orange", "app start event error", e2);
                    }
                }
                String config4 = OrangeConfig.getInstance().getConfig(str, "algo_open", "false");
                Log.e("Datalab.Orange", "orange algo open value is " + config4);
                p30Var.c = "algo.open";
                p30Var.d = config4;
                ve2.b().c(this.a, p30Var, p30Var.b, p30Var.c);
            }
        }
    }

    public void a(Context context) throws Exception {
        OrangeConfig.getInstance().registerListener(new String[]{DATALAB_ALGO_UPDATE, DATALAB_ALGO_ZCACHE}, new C3323a(this, context), true);
    }
}
