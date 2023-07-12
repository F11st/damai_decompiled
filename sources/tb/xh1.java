package tb;

import com.alibaba.android.ultron.trade.event.rollback.RollbackHandler;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class xh1 implements RollbackHandler {
    List<IDMComponent> a;

    public xh1(List<IDMComponent> list) {
        this.a = list;
    }

    private void b(List<IDMComponent> list) {
        if (list == null) {
            return;
        }
        for (IDMComponent iDMComponent : list) {
            if (iDMComponent != null) {
                iDMComponent.rollBack();
            }
        }
    }

    public void a() {
        List<IDMComponent> list = this.a;
        if (list == null) {
            return;
        }
        for (IDMComponent iDMComponent : list) {
            if (iDMComponent != null) {
                iDMComponent.record();
            }
        }
    }

    @Override // com.alibaba.android.ultron.trade.event.rollback.RollbackHandler
    public void rollback() {
        b(this.a);
    }
}
