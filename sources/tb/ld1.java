package tb;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ld1 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        if (list == null || list.size() != 2) {
            return null;
        }
        Boolean valueOf = Boolean.valueOf(im1.b(list.get(0).toString()));
        if ((valueOf instanceof Boolean) && valueOf.booleanValue()) {
            return list.get(1);
        }
        return null;
    }
}
