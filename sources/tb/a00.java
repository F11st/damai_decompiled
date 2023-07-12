package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.android.dinamicx.template.loader.ILoader;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a00 {
    private Map<String, ILoader> b = new HashMap();
    private it a = new it();

    private DXWidgetNode b(DXTemplateItem dXTemplateItem, String str, Map<String, String> map, DXRuntimeContext dXRuntimeContext, Context context) {
        List<C6368e.C6369a> list;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] e = dz.c().e(str, dXRuntimeContext);
        if (e != null && e.length != 0) {
            DXWidgetNode c = this.a.c(e, dXRuntimeContext, context, true);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (this.b.containsKey(entry.getKey())) {
                        this.b.get(entry.getKey()).load(dXTemplateItem, dz.c(), entry.getValue());
                    }
                }
            }
            return c;
        }
        if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null && (list = dXRuntimeContext.getDxError().c) != null) {
            C6368e.C6369a c6369a = new C6368e.C6369a("Template", "Template_Read", C6368e.DX_TEMPLATE_LOAD_ERROR);
            if (e == null) {
                c6369a.e = "DXPackageManager load  bytes == null";
            } else {
                c6369a.e = "DXPackageManager load  bytes.len == 0";
            }
            list.add(c6369a);
        }
        q10.f().n(dXRuntimeContext.getBizType(), dXTemplateItem);
        return null;
    }

    public DXWidgetNode a(DXTemplateItem dXTemplateItem, DXRuntimeContext dXRuntimeContext, Context context) {
        DXTemplatePackageInfo dXTemplatePackageInfo = dXTemplateItem.packageInfo;
        return b(dXTemplateItem, dXTemplatePackageInfo.mainFilePath, dXTemplatePackageInfo.subFilePathDict, dXRuntimeContext, context);
    }
}
