package tb;

import cn.damai.ultron.net.UltronPresenter;
import com.alibaba.android.ultron.trade.presenter.BaseDataManager;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.datamodel.IDMContext;
import com.taobao.weex.annotation.JSMethod;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class fb0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String VIEWER_TITLE = "dmViewerTitle";

    public static IDMComponent a(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1096064030")) {
            return (IDMComponent) ipChange.ipc$dispatch("1096064030", new Object[]{iPresenter});
        }
        lp2 k = k(iPresenter);
        if (k != null) {
            List<IDMComponent> a = k.a();
            for (int i = 0; i < wh2.e(a); i++) {
                IDMComponent iDMComponent = a.get(i);
                if (iDMComponent.getTag().equalsIgnoreCase(VIEWER_TITLE)) {
                    return iDMComponent;
                }
            }
            return null;
        }
        return null;
    }

    public static IDMComponent b(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1576533348") ? (IDMComponent) ipChange.ipc$dispatch("-1576533348", new Object[]{iPresenter}) : j(iPresenter, "dmDeliveryAddress");
    }

    public static IDMComponent c(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1197850445") ? (IDMComponent) ipChange.ipc$dispatch("-1197850445", new Object[]{iPresenter}) : j(iPresenter, "dmDeliverySelectCard");
    }

    public static IDMComponent d(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1505518434") ? (IDMComponent) ipChange.ipc$dispatch("1505518434", new Object[]{iPresenter}) : j(iPresenter, "dmContactPhone");
    }

    public static IDMComponent e(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-511095735") ? (IDMComponent) ipChange.ipc$dispatch("-511095735", new Object[]{iPresenter}) : j(iPresenter, "dmEttributesHiddenBlock");
    }

    public static IDMComponent f(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1531163480") ? (IDMComponent) ipChange.ipc$dispatch("-1531163480", new Object[]{iPresenter}) : j(iPresenter, "dmItemInfo");
    }

    public static IDMComponent g(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1102400321") ? (IDMComponent) ipChange.ipc$dispatch("1102400321", new Object[]{iPresenter}) : j(iPresenter, "dmPayType");
    }

    public static IDMComponent h(IPresenter iPresenter) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "414609503") ? (IDMComponent) ipChange.ipc$dispatch("414609503", new Object[]{iPresenter}) : j(iPresenter, "dmSubmit");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String i(com.alibaba.android.ultron.trade.presenter.IPresenter r4) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.fb0.$ipChange
            java.lang.String r1 = "-2060149500"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r4
            java.lang.Object r4 = r0.ipc$dispatch(r1, r2)
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L17:
            com.taobao.android.ultron.common.model.IDMComponent r4 = h(r4)
            r0 = 0
            if (r4 != 0) goto L1f
            return r0
        L1f:
            java.util.Map r1 = r4.getEventMap()
            int r1 = r1.size()
            if (r1 <= 0) goto L42
            java.util.Map r4 = r4.getEventMap()
            java.lang.String r1 = "detailClick"
            java.lang.Object r4 = r4.get(r1)
            java.util.List r4 = (java.util.List) r4
            int r1 = tb.wh2.e(r4)
            if (r1 <= 0) goto L42
            java.lang.Object r4 = r4.get(r3)
            com.taobao.android.ultron.common.model.IDMEvent r4 = (com.taobao.android.ultron.common.model.IDMEvent) r4
            goto L43
        L42:
            r4 = r0
        L43:
            if (r4 != 0) goto L46
            return r0
        L46:
            java.util.List r4 = r4.getComponents()
            java.lang.Object r4 = r4.get(r3)
            com.taobao.android.ultron.common.model.IDMComponent r4 = (com.taobao.android.ultron.common.model.IDMComponent) r4
            if (r4 != 0) goto L59
            com.alibaba.fastjson.JSONObject r1 = r4.getFields()
            if (r1 != 0) goto L59
            return r0
        L59:
            com.alibaba.fastjson.JSONObject r4 = r4.getFields()
            java.lang.String r4 = r4.toJSONString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.fb0.i(com.alibaba.android.ultron.trade.presenter.IPresenter):java.lang.String");
    }

    private static IDMComponent j(IPresenter iPresenter, String str) {
        IDMContext dataContext;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1609335469")) {
            return (IDMComponent) ipChange.ipc$dispatch("-1609335469", new Object[]{iPresenter, str});
        }
        BaseDataManager dataManager = iPresenter instanceof UltronPresenter ? iPresenter.getDataManager() : null;
        if (dataManager == null || (dataContext = dataManager.getDataContext()) == null) {
            return null;
        }
        List<IDMComponent> components = dataContext.getComponents();
        for (int i = 0; i < wh2.e(components); i++) {
            IDMComponent iDMComponent = components.get(i);
            if (iDMComponent.getTag().equalsIgnoreCase(str)) {
                return iDMComponent;
            }
        }
        return null;
    }

    private static lp2 k(IPresenter iPresenter) {
        BaseDataManager dataManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1213253683")) {
            return (lp2) ipChange.ipc$dispatch("-1213253683", new Object[]{iPresenter});
        }
        if (!(iPresenter instanceof UltronPresenter) || (dataManager = iPresenter.getDataManager()) == null) {
            return null;
        }
        return dataManager.getDataSource();
    }

    public static IDMComponent l(IPresenter iPresenter, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "696642784")) {
            return (IDMComponent) ipChange.ipc$dispatch("696642784", new Object[]{iPresenter, str});
        }
        lp2 k = k(iPresenter);
        if (k != null) {
            List<IDMComponent> a = k.a();
            for (int i = 0; i < wh2.e(a); i++) {
                IDMComponent iDMComponent = a.get(i);
                if ((iDMComponent.getTag() + JSMethod.NOT_SET + iDMComponent.getId()).equalsIgnoreCase(str)) {
                    return iDMComponent;
                }
            }
            return null;
        }
        return null;
    }
}
