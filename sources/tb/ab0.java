package tb;

import android.text.TextUtils;
import cn.damai.ultron.net.UltronPresenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.ut.mini.UTAnalytics;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ab0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    public ab0() {
        a();
    }

    @Override // tb.ib
    public void h(np2 np2Var) {
        JSONObject parseObject;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "628738099")) {
            ipChange.ipc$dispatch("628738099", new Object[]{this, np2Var});
            return;
        }
        IDMComponent e = fb0.e(this.c);
        if (e == null) {
            return;
        }
        JSONObject fields = e.getFields();
        if (fields != null) {
            String string = fields.getString("extraAttributes");
            if (!TextUtils.isEmpty(string) && (parseObject = JSON.parseObject(string)) != null) {
                try {
                    String globalProperty = UTAnalytics.getInstance().getDefaultTracker().getGlobalProperty("utm");
                    if (globalProperty != null) {
                        parseObject.put("utm", (Object) globalProperty);
                        HashMap hashMap = new HashMap();
                        hashMap.put("extraAttributes", parseObject);
                        i(e, hashMap);
                        this.c.getDataManager().respondToLinkage(e);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        ((UltronPresenter) this.c).createOrder();
    }
}
