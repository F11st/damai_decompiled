package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.android.ultron.datamodel.imp.DMComponent;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ra0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // tb.ib
    protected void h(np2 np2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017123551")) {
            ipChange.ipc$dispatch("-2017123551", new Object[]{this, np2Var});
            return;
        }
        CharSequence charSequence = (CharSequence) f(0);
        CharSequence charSequence2 = (CharSequence) f(1);
        IDMComponent a = np2Var.a();
        if (a == null) {
            return;
        }
        DMComponent dMComponent = a instanceof DMComponent ? (DMComponent) a : null;
        if (dMComponent == null || TextUtils.isEmpty(charSequence) || charSequence2 == null) {
            return;
        }
        String replaceAll = charSequence2.toString().trim().replaceAll(" ", "");
        HashMap hashMap = new HashMap();
        hashMap.put("value", replaceAll);
        i(dMComponent, hashMap);
        l(hashMap);
        IDMContext dataContext = this.c.getDataContext();
        if (dataContext instanceof com.taobao.android.ultron.datamodel.imp.a) {
            Map<String, DMComponent> c = ((com.taobao.android.ultron.datamodel.imp.a) dataContext).c();
            c.put(dMComponent.getTag() + JSMethod.NOT_SET + dMComponent.getId(), dMComponent);
        }
    }
}
