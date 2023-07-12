package tb;

import com.alibaba.fastjson.JSONArray;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: tb.wc */
/* loaded from: classes11.dex */
class C9850wc extends zo2 {
    private List<zo2> c;

    public C9850wc(List<zo2> list, int i) {
        super("", i);
        this.c = list;
    }

    @Override // tb.zo2
    public Object a(Object obj) {
        if (c() == 7) {
            List<zo2> list = this.c;
            if (list != null && list.size() != 0) {
                JSONArray jSONArray = new JSONArray(this.c.size());
                for (int i = 0; i < this.c.size(); i++) {
                    zo2 zo2Var = this.c.get(i);
                    if (zo2Var == null) {
                        jSONArray.add(null);
                    } else {
                        jSONArray.add(zo2Var.a(obj));
                    }
                }
                return jSONArray;
            }
            return new JSONArray(4);
        }
        List<zo2> list2 = this.c;
        if (list2 == null || list2.size() == 0) {
            return null;
        }
        return this.c.get(0).a(obj);
    }

    @Override // tb.zo2
    public String toString() {
        if (c() == 7) {
            return "" + this.c + "";
        }
        List<zo2> list = this.c;
        if (list != null && list.size() == 1) {
            return jn1.BLOCK_START_STR + this.c.get(0) + '}';
        }
        return jn1.BLOCK_START_STR + this.c + '}';
    }
}
