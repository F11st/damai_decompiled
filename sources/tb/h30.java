package tb;

import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class h30 {
    private List<IDMComponent> a = new ArrayList();
    private List<IDMComponent> b = new ArrayList();
    private List<IDMComponent> c = new ArrayList();
    private List<kd0> d = new ArrayList();

    public List<IDMComponent> a() {
        return this.b;
    }

    public List<kd0> b() {
        return this.d;
    }

    public List<IDMComponent> c() {
        return this.c;
    }

    public List<IDMComponent> d() {
        return this.a;
    }

    public void e(List<IDMComponent> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.b.clear();
        this.b.addAll(list);
    }

    public void f(List<kd0> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.d.clear();
        this.d.addAll(list);
    }

    public void g(List<IDMComponent> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.c.clear();
        this.c.addAll(list);
    }

    public void h(List<IDMComponent> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
    }
}
