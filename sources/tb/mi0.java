package tb;

import android.content.res.XmlResourceParser;
import android.util.Log;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mi0 extends b2 {
    private Constructor<?> a;

    public mi0() {
        b();
    }

    private void b() {
        try {
            Constructor<?> constructor = Class.forName("android.content.res.XmlBlock").getConstructor(byte[].class);
            this.a = constructor;
            constructor.setAccessible(true);
        } catch (Exception e) {
            Log.e("Home.FileParser", "Fail to get XmlBlock", e);
        }
    }

    @Override // com.taobao.android.dinamic.parser.Parser
    public XmlPullParser openXmlResourceParser(String str, DinamicTemplate dinamicTemplate, iy2 iy2Var) {
        if (this.a != null && dinamicTemplate != null) {
            DTemplateManager q = DTemplateManager.q(str);
            if (!q.g().d(q.j(dinamicTemplate))) {
                iy2Var.b().a(p80.ERROR_CODE_TEMPLATE_FILE_LOST, "downloaded file lost");
                return null;
            }
            try {
                byte[] o = q.o(dinamicTemplate);
                if (o != null && o.length != 0) {
                    try {
                        Object b = y02.b(this.a.newInstance(a(o, iy2Var)), "newParser", new Object[0]);
                        if (b instanceof XmlResourceParser) {
                            return (XmlResourceParser) b;
                        }
                        iy2Var.b().a(p80.ERROR_CODE_XML_RES_PARSER_ERROR, p80.ERROR_CODE_XML_RES_PARSER_ERROR);
                        return null;
                    } catch (Exception e) {
                        iy2Var.b().a(p80.ERROR_CODE_BYTE_TO_PARSER_ERROR, e.getMessage());
                        return null;
                    }
                }
                iy2Var.b().a(p80.ERROR_CODE_TEMPLATE_FILE_EMPTY, "downloaded file empty");
                return null;
            } catch (Exception e2) {
                iy2Var.b().a(p80.ERROR_CODE_BYTE_READ_ERROR, e2.getMessage());
                return null;
            }
        }
        iy2Var.b().a(p80.ERROR_CODE_XML_BLOCK_CONSTRUCTOR_REFLECT_ERROR, p80.ERROR_CODE_XML_BLOCK_CONSTRUCTOR_REFLECT_ERROR);
        return null;
    }
}
