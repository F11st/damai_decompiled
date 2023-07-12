package tb;

import android.text.TextUtils;
import com.taobao.android.dinamic.C6313b;
import com.taobao.android.dinamic.expression.parser.C6324a;
import com.taobao.android.dinamic.expression.parser.DinamicDataParser;
import com.taobao.android.dinamic.expressionv2.C6337g;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class s80 {
    public static final String currentVersion = "2.0";

    public static Object a(String str, String str2, v80 v80Var) {
        Object obj = null;
        if (v80Var != null && v80Var.d() != null && str != null) {
            if (str.startsWith(m80.DINAMIC_PREFIX_AT)) {
                return C6337g.g(str, str2, v80Var);
            }
            char[] charArray = str.toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            boolean z = false;
            boolean z2 = false;
            StringBuffer stringBuffer3 = stringBuffer;
            String str3 = null;
            for (char c : charArray) {
                if ('$' == c) {
                    stringBuffer3 = new StringBuffer();
                    stringBuffer2 = new StringBuffer();
                    z = true;
                } else {
                    if ('{' == c && z) {
                        str3 = stringBuffer3.toString();
                        if (C6324a.a(str3)) {
                            z = false;
                            z2 = true;
                        } else {
                            z = false;
                        }
                    } else if ('}' == c && z2) {
                        String stringBuffer4 = stringBuffer2.toString();
                        if (TextUtils.isEmpty(stringBuffer4)) {
                            obj = v80Var.d();
                        } else {
                            DinamicDataParser b = C6324a.b(str3);
                            if (b != null) {
                                try {
                                    obj = b.parser(stringBuffer4, v80Var);
                                } catch (Throwable th) {
                                    if (C6313b.e()) {
                                        DinamicLog.i("DinamicExpresstion", th, "parse express failed, parser=", b.getClass().getName());
                                    }
                                    v80Var.e().b().a(p80.ERROR_CODE_TEMPLATE_PARSER_EXCEPTION, str2);
                                }
                            } else {
                                v80Var.e().b().a(p80.ERROR_CODE_TEMPLATE_PARSER_NOT_FOUND, str2);
                            }
                        }
                        if (obj != null && (!(obj instanceof String) || !TextUtils.isEmpty(obj.toString()))) {
                            return obj;
                        }
                        z = false;
                    } else if (z) {
                        stringBuffer3.append(c);
                    } else if (z2) {
                        stringBuffer2.append(c);
                    }
                }
                z2 = false;
            }
        }
        return obj;
    }
}
