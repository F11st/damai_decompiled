package tb;

import android.text.TextUtils;
import cn.damai.ultron.view.bean.DmRemindBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ma0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    private void m(IDMComponent iDMComponent) {
        JSONObject fields;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1545895435")) {
            ipChange.ipc$dispatch("-1545895435", new Object[]{this, iDMComponent});
        } else if (iDMComponent != null && (fields = iDMComponent.getFields()) != null) {
            String string = fields.getString("dmRemindList");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            List parseArray = JSON.parseArray(string, DmRemindBean.class);
            for (int i = 0; i < wh2.e(parseArray); i++) {
                ((DmRemindBean) parseArray.get(i)).tip = "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("dmRemindList", JSON.toJSON(parseArray));
            i(iDMComponent, hashMap);
            this.c.getDataManager().respondToLinkage(iDMComponent);
        }
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278704562")) {
            ipChange.ipc$dispatch("278704562", new Object[]{this, np2Var});
        } else {
            m(fb0.f(this.c));
        }
    }
}
