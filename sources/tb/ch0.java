package tb;

import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.extplugin.ExtPlugInfo;
import com.alibaba.android.ultron.trade.extplugin.IExtInfoGetter;
import com.alibaba.android.ultron.trade.extplugin.IPurchaseInitiatorPlugin;
import com.alibaba.android.ultron.trade.presenter.AbstractC3258a;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ch0 implements IExtInfoGetter {
    private ah0 a = new ah0();

    private IPurchaseInitiatorPlugin b(String str, AbstractC3258a abstractC3258a) {
        try {
            IPurchaseInitiatorPlugin iPurchaseInitiatorPlugin = (IPurchaseInitiatorPlugin) xb.a(Class.forName(str), new Object[0]);
            iPurchaseInitiatorPlugin.init(this.a, abstractC3258a);
            return iPurchaseInitiatorPlugin;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(List<ExtPlugInfo> list, AbstractC3258a abstractC3258a) {
        if (list == null) {
            return;
        }
        for (ExtPlugInfo extPlugInfo : list) {
            b(extPlugInfo.initiatorCls, abstractC3258a);
        }
    }

    @Override // com.alibaba.android.ultron.trade.extplugin.IExtInfoGetter
    public Map<String, ISubscriber> getSubscribers() {
        return this.a.a();
    }
}
