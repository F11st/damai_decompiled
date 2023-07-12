package tb;

import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.fastjson.JSON;
import com.alibaba.pictures.bricks.selector.ScriptSelectFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class cb0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    private void m(Intent intent, IDMComponent iDMComponent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355647232")) {
            ipChange.ipc$dispatch("-1355647232", new Object[]{this, intent, iDMComponent});
            return;
        }
        HashMap hashMap = new HashMap();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(ScriptSelectFragment.EXTRA_KEY_SELECT_ID);
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put(ScriptSelectFragment.EXTRA_KEY_SELECT_ID, stringExtra);
            }
            String stringExtra2 = intent.getStringExtra(SocialConstants.PARAM_APP_DESC);
            if (!TextUtils.isEmpty(stringExtra2)) {
                hashMap.put(SocialConstants.PARAM_APP_DESC, stringExtra2);
            }
        }
        if (hashMap.size() > 0) {
            i(iDMComponent, hashMap);
        }
    }

    private void n(Intent intent, IDMComponent iDMComponent) {
        Map<String, List<IDMEvent>> eventMap;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1301970147")) {
            ipChange.ipc$dispatch("-1301970147", new Object[]{this, intent, iDMComponent});
            return;
        }
        IDMEvent iDMEvent = null;
        if (iDMComponent != null && (eventMap = iDMComponent.getEventMap()) != null && eventMap.containsKey("chooseDeliveryWays")) {
            List<IDMEvent> list = eventMap.get("chooseDeliveryWays");
            while (true) {
                if (i >= wh2.e(list)) {
                    break;
                } else if (list.get(i).getType().equals("openPopupWindow")) {
                    iDMEvent = list.get(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        HashMap hashMap = new HashMap();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("eventparams");
            if (!TextUtils.isEmpty(stringExtra)) {
                hashMap.put("params", JSON.parseObject(stringExtra));
            }
        }
        if (hashMap.size() > 0) {
            k(iDMEvent, hashMap);
        }
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        BaseDataManager dataManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1520915203")) {
            ipChange.ipc$dispatch("1520915203", new Object[]{this, np2Var});
        } else if (np2Var == null) {
        } else {
            try {
                Intent intent = (Intent) np2Var.e("data");
                IDMComponent c = fb0.c(this.c);
                np2Var.o(new d60(this.e, this.c));
                m(intent, c);
                n(intent, c);
                IPresenter iPresenter = this.c;
                if (iPresenter == null || (dataManager = iPresenter.getDataManager()) == null) {
                    return;
                }
                dataManager.respondToLinkage(c, np2Var);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
