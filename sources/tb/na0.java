package tb;

import android.text.TextUtils;
import cn.damai.ultron.view.activity.DMUltronPayDetailBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class na0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    private void m(IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1104989263")) {
            ipChange.ipc$dispatch("1104989263", new Object[]{this, iDMComponent});
            return;
        }
        JSONObject fields = iDMComponent != null ? iDMComponent.getFields() : null;
        if (fields != null) {
            String string = fields.getString("payDetail");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            DMUltronPayDetailBean dMUltronPayDetailBean = (DMUltronPayDetailBean) JSON.parseObject(string, DMUltronPayDetailBean.class);
            dMUltronPayDetailBean.status = "false";
            HashMap hashMap = new HashMap();
            hashMap.put("payDetail", JSON.toJSON(dMUltronPayDetailBean));
            i(iDMComponent, hashMap);
            this.c.getDataManager().respondToLinkage(iDMComponent);
        }
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1144050078")) {
            ipChange.ipc$dispatch("-1144050078", new Object[]{this, np2Var});
        } else {
            m(fb0.h(this.c));
        }
    }
}
