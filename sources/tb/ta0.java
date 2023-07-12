package tb;

import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.address.ui.AddAddressActivity;
import cn.damai.ultron.secondpage.phonecode.bean.DmPhoneCodeBean;
import cn.damai.ultron.view.activity.DMUltronPayDetailBean;
import cn.damai.ultron.view.activity.DmOrderActivity;
import cn.damai.ultron.view.bean.DmDeliveryWayBean;
import com.alibaba.aliweex.adapter.component.WXTabbar;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import com.taobao.weex.annotation.JSMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ta0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;
    private int j = -1;

    private void m(IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065653323")) {
            ipChange.ipc$dispatch("-2065653323", new Object[]{this, iDMComponent});
        } else if (iDMComponent == null) {
        } else {
            boolean u = u(iDMComponent);
            try {
                cn.damai.common.user.c.e().x(kb0.u().x(this.b));
            } catch (Exception e) {
                e.printStackTrace();
            }
            IPresenter iPresenter = this.c;
            if (iPresenter == null || iPresenter.getContext() == null) {
                return;
            }
            try {
                ((DmOrderActivity) this.c.getContext()).updateTicketDetailVis(u);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1535720669")) {
            ipChange.ipc$dispatch("-1535720669", new Object[]{this});
            return;
        }
        cn.damai.common.user.c.e().x(kb0.u().g(this.b));
        Bundle bundle = new Bundle();
        bundle.putInt(AddAddressActivity.KEY_OPERATION_ADDRESS, 1);
        DMNav.from(this.b).withExtras(bundle).forResult(37).toUri(NavUri.b("addaddress"));
    }

    private void o(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "277935630")) {
            ipChange.ipc$dispatch("277935630", new Object[]{this, str});
            return;
        }
        cn.damai.common.user.c.e().x(kb0.u().D(this.b));
        Bundle bundle = new Bundle();
        bundle.putString("dm_bundle_address_id", str);
        DMNav.from(this.b).withExtras(bundle).forResult(37).toUri(NavUri.b(hb0.e));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p(com.taobao.android.ultron.common.model.IDMComponent r5) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.ta0.$ipChange
            java.lang.String r1 = "1106910142"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            r2[r3] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            if (r5 != 0) goto L1a
            return
        L1a:
            java.lang.String r0 = ""
            com.alibaba.fastjson.JSONObject r5 = r5.getFields()
            java.lang.String r1 = "0"
            if (r5 == 0) goto L3d
            java.lang.String r2 = "addressId"
            boolean r3 = r5.containsKey(r2)
            if (r3 == 0) goto L30
            java.lang.String r0 = r5.getString(r2)
        L30:
            java.lang.String r2 = "addressStatus"
            boolean r3 = r5.containsKey(r2)
            if (r3 == 0) goto L3d
            java.lang.String r5 = r5.getString(r2)
            goto L3e
        L3d:
            r5 = r1
        L3e:
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L48
            r4.o(r0)
            goto L57
        L48:
            java.lang.String r1 = "1"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L54
            r4.n()
            goto L57
        L54:
            r4.o(r0)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ta0.p(com.taobao.android.ultron.common.model.IDMComponent):void");
    }

    private void q(IDMEvent iDMEvent, DMComponent dMComponent) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "529837031")) {
            ipChange.ipc$dispatch("529837031", new Object[]{this, iDMEvent, dMComponent});
            return;
        }
        String string = (dMComponent == null || dMComponent.getFields() == null) ? "" : dMComponent.getFields().getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
        List list = null;
        if (iDMEvent != null) {
            JSONObject fields = iDMEvent.getFields();
            if (fields != null && (jSONObject = fields.getJSONObject("params")) != null && jSONObject.containsKey("deliveryWayEntries")) {
                list = JSON.parseArray(jSONObject.getString("deliveryWayEntries"), DmDeliveryWayBean.class);
            }
            if (wh2.e(list) > 0) {
                cn.damai.common.user.c.e().x(kb0.u().i(this.b));
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("param", (ArrayList) list);
                bundle.putString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, string);
                DMNav.from(this.b).withExtras(bundle).forResult(41).toUri(NavUri.b(hb0.b));
            }
        }
    }

    private void r(IDMEvent iDMEvent, IDMComponent iDMComponent) {
        JSONObject jSONObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840032996")) {
            ipChange.ipc$dispatch("-840032996", new Object[]{this, iDMEvent, iDMComponent});
        } else if (iDMEvent != null) {
            JSONObject fields = iDMEvent.getFields();
            String string = (fields == null || (jSONObject = fields.getJSONObject("params")) == null || !jSONObject.containsKey("ticketAddressEntries")) ? "" : jSONObject.getString("ticketAddressEntries");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            cn.damai.common.user.c.e().x(kb0.u().A(this.b));
            Bundle bundle = new Bundle();
            bundle.putString("fields", string);
            DMNav.from(this.b).withExtras(bundle).toUri(NavUri.b(hb0.d));
        }
    }

    private void s(IDMEvent iDMEvent, IDMComponent iDMComponent) {
        String str;
        String str2;
        JSONObject fields;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434420459")) {
            ipChange.ipc$dispatch("434420459", new Object[]{this, iDMEvent, iDMComponent});
            return;
        }
        if (iDMComponent == null || iDMComponent.getFields() == null) {
            str = "";
            str2 = str;
        } else {
            str2 = iDMComponent.getFields().getString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
            str = iDMComponent.getTag() + JSMethod.NOT_SET + iDMComponent.getId();
        }
        if (iDMEvent == null || (fields = iDMEvent.getFields()) == null) {
            return;
        }
        JSONObject jSONObject = fields.getJSONObject("params");
        if (jSONObject != null && (jSONObject.containsKey("usablePromotionOptions") || jSONObject.containsKey("unusablePromotionOptions"))) {
            String string = jSONObject.getString("usablePromotionOptions");
            String string2 = jSONObject.getString("unusablePromotionOptions");
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return;
            }
            cn.damai.common.user.c.e().x(kb0.u().B(this.b));
            Bundle bundle = new Bundle();
            bundle.putString("paramvalue", string);
            bundle.putString("paramvalue_unuse", string2);
            bundle.putString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, str2);
            bundle.putString("tag_id", str);
            IPresenter iPresenter = this.c;
            if (iPresenter == null || iPresenter.getContext() == null) {
                return;
            }
            try {
                ((DmOrderActivity) this.c.getContext()).showProFragment(bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (jSONObject == null || !jSONObject.containsKey("promotionOptions")) {
        } else {
            String string3 = jSONObject.getString("promotionOptions");
            if (TextUtils.isEmpty(string3) && TextUtils.isEmpty("")) {
                return;
            }
            cn.damai.common.user.c.e().x(kb0.u().B(this.b));
            Bundle bundle2 = new Bundle();
            bundle2.putString("paramvalue", string3);
            bundle2.putString(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, str2);
            bundle2.putString("tag_id", str);
            DMNav.from(this.b).withExtras(bundle2).forResult(49).toUri(NavUri.b(hb0.c));
        }
    }

    private void t(DMComponent dMComponent) {
        JSONObject fields;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "664801615")) {
            ipChange.ipc$dispatch("664801615", new Object[]{this, dMComponent});
            return;
        }
        if (dMComponent == null || (fields = dMComponent.getFields()) == null) {
            return;
        }
        String string = fields.containsKey(WXTabbar.SELECT_INDEX) ? fields.getString(WXTabbar.SELECT_INDEX) : "0";
        List parseArray = fields.containsKey("list") ? JSON.parseArray(fields.getString("list"), DmPhoneCodeBean.class) : null;
        Bundle bundle = new Bundle();
        bundle.putString("selectCode", string);
        bundle.putParcelableArrayList("code", (ArrayList) parseArray);
        DMNav.from(this.b).withExtras(bundle).forResult(48).toUri(NavUri.b(hb0.a));
    }

    private boolean u(IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1456584060")) {
            return ((Boolean) ipChange.ipc$dispatch("1456584060", new Object[]{this, iDMComponent})).booleanValue();
        }
        HashMap hashMap = new HashMap();
        JSONObject fields = iDMComponent.getFields();
        if (fields != null) {
            String string = fields.getString("payDetail");
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            DMUltronPayDetailBean dMUltronPayDetailBean = (DMUltronPayDetailBean) JSON.parseObject(string, DMUltronPayDetailBean.class);
            String str = dMUltronPayDetailBean.status;
            z = (str == null || str.equals("false")) ? false : false;
            StringBuilder sb = new StringBuilder();
            sb.append(!z);
            sb.append("");
            dMUltronPayDetailBean.status = sb.toString();
            hashMap.put("payDetail", JSON.toJSON(dMUltronPayDetailBean));
            j(hashMap);
            this.c.getDataManager().respondToLinkage(iDMComponent);
            return z;
        }
        return false;
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        DMComponent dMComponent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "212886745")) {
            ipChange.ipc$dispatch("212886745", new Object[]{this, np2Var});
            return;
        }
        String str = null;
        if (np2Var != null) {
            DMComponent dMComponent2 = (DMComponent) np2Var.a();
            dMComponent = dMComponent2;
            str = dMComponent2.getTag();
        } else {
            dMComponent = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("dmDeliverySelectCard")) {
                this.j = 1;
            } else if (str.equals("dmContactPhone")) {
                this.j = 2;
            } else if (str.equals("dmDeliveryAddress")) {
                this.j = 3;
            } else if (str.equals("dmSubmit")) {
                this.j = 4;
            } else if (!str.equals("dmPromotion") && !str.equals("dmPromotionNew")) {
                if (str.equals("dmDeliveryTicketAddress")) {
                    this.j = 6;
                }
            } else {
                this.j = 5;
            }
        }
        switch (this.j) {
            case 1:
                q(e(), dMComponent);
                return;
            case 2:
                t(dMComponent);
                return;
            case 3:
                p(dMComponent);
                return;
            case 4:
                m(np2Var.a());
                return;
            case 5:
                s(e(), dMComponent);
                return;
            case 6:
                r(e(), dMComponent);
                return;
            default:
                return;
        }
    }
}
