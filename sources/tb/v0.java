package tb;

import com.taobao.android.dinamic.expression.parser.DinamicDataParser;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class v0 implements DinamicDataParser {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, Object obj) {
        return null;
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, String str2, Object obj, Object obj2) {
        return parser(str2, obj);
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object parser(String str, v80 v80Var) {
        return parser(v80Var.c(), str, v80Var.d(), v80Var.b());
    }
}
