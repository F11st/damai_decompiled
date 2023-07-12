package tb;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class n80 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        return parser((String) list.get(0), v80Var.d());
    }

    @Override // tb.v0, com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, Object obj) {
        return str;
    }

    @Override // tb.v0, com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, String str2, Object obj, Object obj2) {
        return parser(str2, obj);
    }
}
