package tb;

import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p10 {
    private int a;
    private Map<String, Integer> b = new HashMap();

    public p10(int i) {
        this.a = i;
    }

    public DXTemplateItem a(String str, long j, DXTemplateItem dXTemplateItem) {
        if (this.a != 1) {
            Integer num = this.b.get(dXTemplateItem.name);
            if ((num == null ? 0 : num.intValue()) >= this.a) {
                return q10.f().h(str, j, dXTemplateItem);
            }
            return q10.f().e(str, j, dXTemplateItem);
        }
        return q10.f().h(str, j, dXTemplateItem);
    }

    public void b(int i) {
        this.a = i;
    }

    public void c(String str, long j, DXTemplateItem dXTemplateItem) {
        Integer num = this.b.get(dXTemplateItem.name);
        int intValue = num == null ? 0 : num.intValue();
        int a = q10.f().a(str, j, dXTemplateItem);
        if (a == 1) {
            this.b.put(dXTemplateItem.name, Integer.valueOf(intValue + 1));
        } else if (a != 2) {
        } else {
            this.b.put(dXTemplateItem.name, Integer.valueOf(this.a));
        }
    }
}
