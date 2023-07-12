package tb;

import android.content.Context;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.DXTemplatePackageInfo;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class st {
    private int a;
    private int b;
    private int c = 1;
    private int d = 2;
    private Map<String, DXWidgetNode> e = new HashMap();

    public DXWidgetNode a(String str) {
        if (str == null) {
            return null;
        }
        return this.e.get(str);
    }

    public Map<String, DXWidgetNode> b(C9787ut c9787ut, DXRuntimeContext dXRuntimeContext, Context context) {
        int i = this.a;
        if (i <= 0 || this.b <= 0) {
            return null;
        }
        if (!c9787ut.i(i)) {
            nz.g(null, "DXChildTemplateLoader 解析子模版区失败 !codeReader.seek(childTemplateStartPos)");
        }
        int f = c9787ut.f();
        if (f <= 0) {
            return null;
        }
        DXTemplateItem dxTemplateItem = dXRuntimeContext.getDxTemplateItem();
        for (int i2 = 0; i2 < f; i2++) {
            if (c9787ut.d() != this.c) {
                nz.g(null, "DXChildTemplateLoader 解析子模版区失败 startTag != START_TAG)");
                return null;
            }
            short h = c9787ut.h();
            String str = new String(c9787ut.a(), c9787ut.c(), (int) h);
            c9787ut.j(h);
            short h2 = c9787ut.h();
            int f2 = c9787ut.f();
            byte[] bArr = new byte[f2];
            System.arraycopy(c9787ut.a(), c9787ut.c(), bArr, 0, f2);
            c9787ut.j(f2);
            if (c9787ut.d() != this.d) {
                nz.g(null, "DXChildTemplateLoader 解析子模版区失败 endTag != END_TAG)");
                return null;
            }
            it itVar = new it();
            DXTemplateItem dXTemplateItem = new DXTemplateItem();
            dXTemplateItem.name = str;
            dXTemplateItem.version = h2;
            DXTemplatePackageInfo dXTemplatePackageInfo = new DXTemplatePackageInfo();
            DXTemplatePackageInfo dXTemplatePackageInfo2 = dxTemplateItem.packageInfo;
            dXTemplatePackageInfo.mainFilePath = dXTemplatePackageInfo2.mainFilePath;
            dXTemplatePackageInfo.subFilePathDict = dXTemplatePackageInfo2.subFilePathDict;
            dXTemplateItem.packageInfo = dXTemplatePackageInfo;
            DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(null);
            cloneWithWidgetNode.setDxTemplateItem(dXTemplateItem);
            DXWidgetNode c = itVar.c(bArr, cloneWithWidgetNode, context, false);
            Map<String, DXWidgetNode> map = this.e;
            map.put(str + JSMethod.NOT_SET + ((int) h2), c);
        }
        return this.e;
    }

    public void c(int i) {
        this.b = i;
    }

    public void d(int i) {
        this.a = i;
    }
}
