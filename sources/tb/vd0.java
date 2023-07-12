package tb;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vd0 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        if (list == null || list.size() != 1) {
            return null;
        }
        return list.get(0);
    }
}
