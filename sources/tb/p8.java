package tb;

import android.content.res.XmlResourceParser;
import android.util.Log;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p8 extends b2 {
    private Constructor<?> a;

    public p8() {
        b();
    }

    private void b() {
        try {
            Constructor<?> constructor = Class.forName("android.content.res.XmlBlock").getConstructor(byte[].class);
            this.a = constructor;
            constructor.setAccessible(true);
        } catch (Exception e) {
            Log.e("Home.AssetParser", "Fail to get XmlBlock", e);
        }
    }

    @Override // com.taobao.android.dinamic.parser.Parser
    public XmlPullParser openXmlResourceParser(String str, DinamicTemplate dinamicTemplate, iy2 iy2Var) {
        if (this.a != null && dinamicTemplate != null) {
            byte[] a = a(DTemplateManager.q(str).n(dinamicTemplate), iy2Var);
            if (a != null && a.length != 0) {
                Log.d("Home.AssetParser", "File parser is applied: " + dinamicTemplate.name);
                try {
                    Object b = y02.b(this.a.newInstance(a), "newParser", new Object[0]);
                    if (b instanceof XmlResourceParser) {
                        return (XmlResourceParser) b;
                    }
                } catch (Exception e) {
                    iy2Var.b().a(p80.ERROR_CODE_BYTE_TO_PARSER_ERROR, e.getMessage());
                }
                return null;
            }
            iy2Var.b().a(p80.ERROR_CODE_TEMPLATE_FILE_EMPTY, "assert error");
        }
        return null;
    }
}
