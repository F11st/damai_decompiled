package tb;

import android.text.TextUtils;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class t80 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        return parser((String) list.get(0), v80Var.d());
    }

    @Override // tb.v0, com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return obj;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, " .[]", false);
        while (stringTokenizer.hasMoreTokens()) {
            obj = com.taobao.android.dinamic.expression.parser.resolver.e.a(obj, stringTokenizer.nextToken());
        }
        return obj;
    }

    @Override // tb.v0, com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, String str2, Object obj, Object obj2) {
        return parser(str2, obj);
    }
}
