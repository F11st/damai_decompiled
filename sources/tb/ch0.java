package tb;

import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.extplugin.ExtPlugInfo;
import com.alibaba.android.ultron.trade.extplugin.IExtInfoGetter;
import com.alibaba.android.ultron.trade.extplugin.IPurchaseInitiatorPlugin;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ch0 implements IExtInfoGetter {
    private ah0 a = new ah0();

    private IPurchaseInitiatorPlugin b(String str, com.alibaba.android.ultron.trade.presenter.a aVar) {
        try {
            IPurchaseInitiatorPlugin iPurchaseInitiatorPlugin = (IPurchaseInitiatorPlugin) xb.a(Class.forName(str), new Object[0]);
            iPurchaseInitiatorPlugin.init(this.a, aVar);
            return iPurchaseInitiatorPlugin;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(List<ExtPlugInfo> list, com.alibaba.android.ultron.trade.presenter.a aVar) {
        if (list == null) {
            return;
        }
        for (ExtPlugInfo extPlugInfo : list) {
            b(extPlugInfo.initiatorCls, aVar);
        }
    }

    @Override // com.alibaba.android.ultron.trade.extplugin.IExtInfoGetter
    public Map<String, ISubscriber> getSubscribers() {
        return this.a.a();
    }
}
