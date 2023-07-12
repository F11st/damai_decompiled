package tb;

import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamic.tempate.DinamicTemplate;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class j22 extends b2 {
    @Override // com.taobao.android.dinamic.parser.Parser
    public XmlPullParser openXmlResourceParser(String str, DinamicTemplate dinamicTemplate, iy2 iy2Var) {
        return DTemplateManager.q(str).h(dinamicTemplate);
    }
}
