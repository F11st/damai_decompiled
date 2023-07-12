package tb;

import android.util.Pair;
import com.alibaba.android.ultron.trade.event.model.OpenPopupWindowEventModel;
import com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager;
import com.alibaba.fastjson.JSON;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class dn1 extends ib {

    /* compiled from: Taobao */
    /* renamed from: tb.dn1$a */
    /* loaded from: classes6.dex */
    class C9050a implements PopupWindowManager.OnCancelListener {
        final /* synthetic */ np2 a;

        C9050a(dn1 dn1Var, np2 np2Var) {
            this.a = np2Var;
        }

        @Override // com.alibaba.android.ultron.vfw.popupwindow.PopupWindowManager.OnCancelListener
        public void onCancel() {
            this.a.h();
        }
    }

    public dn1() {
        a();
    }

    @Override // tb.ib
    public void h(np2 np2Var) {
        IDMEvent e = e();
        if (e == null || e.getFields() == null) {
            return;
        }
        OpenPopupWindowEventModel openPopupWindowEventModel = null;
        try {
            openPopupWindowEventModel = (OpenPopupWindowEventModel) JSON.parseObject(e.getFields().toJSONString(), OpenPopupWindowEventModel.class);
        } catch (Exception unused) {
        }
        List<IDMComponent> components = e.getComponents();
        xh1 xh1Var = new xh1(components);
        xh1Var.a();
        np2Var.o(xh1Var);
        this.c.getViewManager().showPopup(components, openPopupWindowEventModel, new C9050a(this, np2Var));
        this.c.getViewManager().setPopupWindowTrigger(new Pair<>(this.e, e));
        this.c.getTradeEventHandler().n(np2Var);
    }
}
