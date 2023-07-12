package tb;

import com.alibaba.android.ultron.trade.event.model.AutoJumpOpenUrlEventModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMEvent;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class r9 extends gn1 {
    public static final String KEY_STATUS_AUTO_JUMP = "AutoJumpRequest";
    public static final String KEY_STATUS_H5_ASYNC_REQUEST = "H5AsyncRequest";
    public static final String KEY_STATUS_H5_BACK = "H5Back";

    public r9() {
        this.g = 100;
        a();
    }

    @Override // tb.gn1, tb.ib
    public void h(np2 np2Var) {
        IDMEvent e = e();
        if (e == null || e.getFields() == null) {
            return;
        }
        AutoJumpOpenUrlEventModel autoJumpOpenUrlEventModel = null;
        try {
            autoJumpOpenUrlEventModel = (AutoJumpOpenUrlEventModel) JSON.parseObject(e.getFields().toJSONString(), AutoJumpOpenUrlEventModel.class);
        } catch (Exception unused) {
            vt2.b("AutoJumpOpenUrlSubscriber", "onHandleEvent JSON.parseObject failed");
        }
        if (autoJumpOpenUrlEventModel == null) {
            return;
        }
        String pageType = autoJumpOpenUrlEventModel.getPageType();
        String url = autoJumpOpenUrlEventModel.getUrl();
        JSONObject params = autoJumpOpenUrlEventModel.getParams();
        if (pageType != null && url != null) {
            if (Boolean.TRUE.toString().equals((String) np2Var.e("autoJump"))) {
                int i = this.j + 1;
                this.j = i;
                np2Var.m(fn1.KEY_REQUEST_CODE, Integer.valueOf(i));
                char c = 65535;
                switch (pageType.hashCode()) {
                    case -1968751561:
                        if (pageType.equals(gn1.TYPE_OPEN_URL_NATIVE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 2285:
                        if (pageType.equals("H5")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2692129:
                        if (pageType.equals(gn1.TYPE_OPEN_URL_WEEX)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        vt2.b("AutoJumpOpenUrlSubscriber", "跳转到native页面", url);
                        o(url, params);
                        break;
                    case 1:
                        vt2.b("AutoJumpOpenUrlSubscriber", "跳转到h5页面", url);
                        n(url, params, autoJumpOpenUrlEventModel.getMethod());
                        break;
                    case 2:
                        vt2.b("AutoJumpOpenUrlSubscriber", "跳转到weex页面", url);
                        p(url, params);
                        break;
                }
                this.c.getTradeEventHandler().n(np2Var);
                return;
            }
            autoJumpOpenUrlEventModel.setStatus(KEY_STATUS_AUTO_JUMP);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", (Object) KEY_STATUS_AUTO_JUMP);
            k(e(), jSONObject);
            this.c.getTradeEventHandler().m(this.e, this.a.g());
            this.c.getDataManager().respondToLinkage(this.e);
            return;
        }
        vt2.b("type is null or url is null", new String[0]);
    }
}
