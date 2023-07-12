package tb;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x7<T> {
    private ArrayList<T> a = new ArrayList<>(4);

    public void a(int i, T t) {
        this.a.add(i, t);
    }

    public T b(int i) {
        return this.a.get(i);
    }

    public List<T> c() {
        return this.a;
    }

    public boolean d() {
        return this.a.isEmpty();
    }

    public T e() {
        ArrayList<T> arrayList = this.a;
        return arrayList.get(arrayList.size() - 1);
    }

    public T f() {
        ArrayList<T> arrayList = this.a;
        return arrayList.remove(arrayList.size() - 1);
    }

    public void g(T t) {
        this.a.add(t);
    }

    public T h(int i) {
        return this.a.remove(i);
    }

    public int i() {
        return this.a.size();
    }
}
