package tb;

import com.alibaba.android.ultron.vfw.template.ITemplateProvider;
import com.alibaba.android.ultron.vfw.template.TemplateDownloadListener;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class vl2 {
    private HashMap<String, ITemplateProvider> a = new HashMap<>();

    public vl2(ay2 ay2Var) {
        c(r10.DB_NAME, new l90(ay2Var));
    }

    public void a(String str, List<kd0> list, TemplateDownloadListener templateDownloadListener) {
        ITemplateProvider iTemplateProvider = this.a.get(str);
        if (iTemplateProvider != null) {
            iTemplateProvider.downloadTemplates(list, templateDownloadListener);
        }
    }

    public ITemplateProvider b(String str) {
        return this.a.get(str);
    }

    public void c(String str, ITemplateProvider iTemplateProvider) {
        this.a.put(str, iTemplateProvider);
    }
}
