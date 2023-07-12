package tb;

import android.content.Context;
import cn.damai.ultron.view.component.DmLineComponent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class f30 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(IDMComponent iDMComponent, List<IDMComponent> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-660530771")) {
            ipChange.ipc$dispatch("-660530771", new Object[]{iDMComponent, list});
        } else if (iDMComponent == null || list == null) {
        } else {
            String string = iDMComponent.getFields().getString("cornerType");
            String tag = iDMComponent.getTag();
            if (!"both".equals(string) && !"top".equals(string)) {
                list.add(iDMComponent);
            } else if (!tag.equals("dmItemInfo") && !tag.equals("dmTopNotification")) {
                list.add(new DmLineComponent());
                list.add(iDMComponent);
            } else {
                list.add(iDMComponent);
            }
        }
    }

    public static void b(IDMContext iDMContext, Context context) {
        List<IDMComponent> components;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1901422818")) {
            ipChange.ipc$dispatch("-1901422818", new Object[]{iDMContext, context});
        } else if (iDMContext != null && context != null && (components = iDMContext.getComponents()) != null) {
            ArrayList arrayList = new ArrayList();
            for (IDMComponent iDMComponent : components) {
                if (iDMComponent != null && iDMComponent.getFields() != null) {
                    try {
                        if (iDMComponent.getTag().equals("dmItemInfo")) {
                            ua0.g(context, Long.parseLong(iDMComponent.getFields().getString("itemId")));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    a(iDMComponent, arrayList);
                }
            }
            iDMContext.setComponents(arrayList);
        }
    }
}
