package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.ultron.vfw.template.ITemplateProvider;
import com.alibaba.android.ultron.vfw.template.TemplateDownloadListener;
import com.taobao.android.dinamicx.C6387n;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.ultron.common.model.IDMComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class l90 implements ITemplateProvider {
    private Map<String, DXTemplateItem> a = new HashMap();
    private C6387n b;

    public l90(ay2 ay2Var) {
        this.b = ay2Var.n().d();
    }

    @Nullable
    public DXTemplateItem a(@NonNull String str) {
        return this.a.get(str);
    }

    @Override // com.alibaba.android.ultron.vfw.template.ITemplateProvider
    public boolean checkTemplate(IDMComponent iDMComponent) {
        return true;
    }

    @Override // com.alibaba.android.ultron.vfw.template.ITemplateProvider
    public void downloadTemplates(List<kd0> list, TemplateDownloadListener templateDownloadListener) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (kd0 kd0Var : list) {
            DXTemplateItem a = tl2.a(kd0Var);
            if (a.version > 0) {
                DXTemplateItem e = this.b.e(a);
                if (e == null) {
                    arrayList.add(a);
                } else {
                    if (a.version != e.version) {
                        arrayList.add(a);
                    }
                    if (!this.a.containsKey(e.name)) {
                        this.a.put(e.name, e);
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.b.d(arrayList);
        }
    }
}
