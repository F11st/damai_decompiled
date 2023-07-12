package tb;

import android.content.Context;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.alibaba.android.ultron.trade.presenter.IPresenter;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.android.ultron.common.model.IDMEvent;
import com.taobao.android.ultron.datamodel.IDMContext;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class ib implements ISubscriber {
    protected np2 a;
    protected Context b;
    protected IPresenter c;
    protected IDMContext d;
    protected IDMComponent e;
    protected boolean f = false;
    protected int g = 200;
    private long h = 0;
    private String i = "";

    private <T> T d(String str, int i) {
        List list;
        np2 np2Var = this.a;
        if (np2Var == null) {
            return null;
        }
        Object e = np2Var.e(str);
        if (e instanceof Object[]) {
            list = Arrays.asList((Object[]) e);
        } else {
            list = e instanceof List ? (List) e : null;
        }
        if (list == null || i >= list.size()) {
            return null;
        }
        return (T) list.get(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.f = true;
    }

    protected JSONObject b() {
        JSONObject fields;
        IDMEvent e = e();
        if (e == null || (fields = e.getFields()) == null) {
            return null;
        }
        return fields;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T c(String str) {
        np2 np2Var = this.a;
        if (np2Var == null) {
            return null;
        }
        return (T) np2Var.e(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IDMEvent e() {
        np2 np2Var = this.a;
        if (np2Var == null) {
            return null;
        }
        Object c = np2Var.c();
        if (c instanceof IDMEvent) {
            return (IDMEvent) c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T f(int i) {
        return (T) d(op2.KEY_VIEW_PARAMS, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        JSONObject b = b();
        return b != null && b.getBooleanValue("request");
    }

    protected abstract void h(np2 np2Var);

    @Override // com.alibaba.android.ultron.trade.event.base.ISubscriber
    public final void handleEvent(np2 np2Var) {
        if (np2Var == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.h < this.g && this.f && this.i.equals(np2Var.d())) {
            return;
        }
        this.h = currentTimeMillis;
        this.i = np2Var.d();
        this.a = np2Var;
        this.b = np2Var.b();
        IPresenter f = np2Var.f();
        this.c = f;
        if (this.b == null || f == null) {
            return;
        }
        this.d = f.getDataContext();
        IDMComponent a = np2Var.a();
        this.e = a;
        if (a != null) {
            a.updateModifiedCount();
        }
        h(np2Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i(IDMComponent iDMComponent, Map<String, ? extends Object> map) {
        if (map != null && !map.isEmpty() && iDMComponent != null) {
            try {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    iDMComponent.getFields().put(entry.getKey(), entry.getValue());
                    vt2.b("BaseSubscriber", "writeDataBackToComponent:", entry.getKey(), String.valueOf(entry.getValue()));
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(Map<String, ? extends Object> map) {
        return i(this.e, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k(IDMEvent iDMEvent, Map<String, ? extends Object> map) {
        JSONObject fields;
        if (map == null || map.isEmpty() || iDMEvent == null || (fields = iDMEvent.getFields()) == null) {
            return false;
        }
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            fields.put(entry.getKey(), entry.getValue());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(Map<String, ? extends Object> map) {
        return k(e(), map);
    }
}
