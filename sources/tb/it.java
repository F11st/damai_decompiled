package tb;

import android.content.Context;
import android.util.Log;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.C6493f;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.annotation.JSMethod;
import java.util.List;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class it {
    public static final int EVENTCHAIN_MINOR_VERSION = 7;
    public static final int MAJOR_VERSION = 3;
    public static final int MINOR_VERSION_0 = 0;
    public static final int MINOR_VERSION_1 = 1;
    public static final int MINOR_VERSION_8 = 8;
    public static final int MINOR_VERSION_9 = 9;
    public static final int STATE_continue = 0;
    public static final int STATE_failed = 2;
    public static final int STATE_successful = 1;
    public static final short TYPE_ADAPTIVE_UNIT = 32;
    public static final short TYPE_COLOR = 16;
    public static final short TYPE_DOUBLE = 4;
    public static final short TYPE_ENUM = 512;
    public static final short TYPE_INT = 1;
    public static final short TYPE_LIST = 128;
    public static final short TYPE_LONG = 2;
    public static final short TYPE_MAP = 256;
    public static final short TYPE_NATIVE_UNIT = 64;
    public static final short TYPE_OBJECT = 1024;
    public static final short TYPE_STRING = 8;
    private int a;
    private k10 c;
    private a20 d;
    private ty e;
    private gy f;
    private st g;
    private ny h;
    private yy i;
    private a10 j;
    private Stack<DXWidgetNode> k = new Stack<>();
    private int l = 1000;
    private k10 b = new k10();

    public it() {
        k10 k10Var = new k10();
        this.c = k10Var;
        this.e = new ty(k10Var);
        this.d = new a20();
        this.f = new gy(this.c);
        this.h = new ny();
        this.i = new yy();
        this.j = new a10();
        this.g = new st();
        new j10();
    }

    private py a(C9787ut c9787ut, DXRuntimeContext dXRuntimeContext, Context context) {
        if (c9787ut == null) {
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EMPTY));
            return null;
        }
        try {
            return this.h.a(c9787ut, dXRuntimeContext);
        } catch (Exception e) {
            if (DinamicXEngine.x()) {
                e.printStackTrace();
            }
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_CREATE_EVENT_CHAIN_ERROR, ry.a(e)));
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:217:0x02f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf A[Catch: Exception -> 0x0479, TryCatch #2 {Exception -> 0x0479, blocks: (B:5:0x000c, B:9:0x0022, B:180:0x0434, B:185:0x0446, B:193:0x046f, B:10:0x003f, B:12:0x0047, B:14:0x0058, B:17:0x0063, B:35:0x00bf, B:37:0x00c6, B:39:0x00ce, B:41:0x00f1, B:42:0x0113, B:46:0x011e, B:124:0x02e9, B:67:0x014d, B:69:0x0159, B:71:0x0165, B:80:0x0189, B:84:0x01c4, B:75:0x017d, B:77:0x0183, B:86:0x01cd, B:95:0x01f4, B:98:0x0218, B:90:0x01e8, B:92:0x01ee, B:99:0x021d, B:101:0x0232, B:102:0x0237, B:104:0x024c, B:105:0x0251, B:107:0x0261, B:108:0x0266, B:110:0x0276, B:112:0x0282, B:114:0x02aa, B:115:0x02ae, B:117:0x02be, B:118:0x02c2, B:120:0x02d2, B:121:0x02d6, B:123:0x02e6, B:125:0x02f6, B:128:0x0302, B:130:0x0308, B:133:0x0312, B:135:0x031d, B:137:0x0328, B:140:0x0331, B:142:0x0338, B:144:0x0342, B:146:0x036e, B:148:0x0380, B:150:0x0388, B:152:0x0394, B:154:0x039a, B:155:0x039d, B:157:0x03b5, B:158:0x03c4, B:161:0x03d1, B:163:0x03d7, B:166:0x03dd, B:168:0x03e7, B:170:0x03ef, B:172:0x041f, B:173:0x0426, B:30:0x008d, B:32:0x0093, B:33:0x0097, B:72:0x0171, B:87:0x01dc), top: B:202:0x000c, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c6 A[Catch: Exception -> 0x0479, TryCatch #2 {Exception -> 0x0479, blocks: (B:5:0x000c, B:9:0x0022, B:180:0x0434, B:185:0x0446, B:193:0x046f, B:10:0x003f, B:12:0x0047, B:14:0x0058, B:17:0x0063, B:35:0x00bf, B:37:0x00c6, B:39:0x00ce, B:41:0x00f1, B:42:0x0113, B:46:0x011e, B:124:0x02e9, B:67:0x014d, B:69:0x0159, B:71:0x0165, B:80:0x0189, B:84:0x01c4, B:75:0x017d, B:77:0x0183, B:86:0x01cd, B:95:0x01f4, B:98:0x0218, B:90:0x01e8, B:92:0x01ee, B:99:0x021d, B:101:0x0232, B:102:0x0237, B:104:0x024c, B:105:0x0251, B:107:0x0261, B:108:0x0266, B:110:0x0276, B:112:0x0282, B:114:0x02aa, B:115:0x02ae, B:117:0x02be, B:118:0x02c2, B:120:0x02d2, B:121:0x02d6, B:123:0x02e6, B:125:0x02f6, B:128:0x0302, B:130:0x0308, B:133:0x0312, B:135:0x031d, B:137:0x0328, B:140:0x0331, B:142:0x0338, B:144:0x0342, B:146:0x036e, B:148:0x0380, B:150:0x0388, B:152:0x0394, B:154:0x039a, B:155:0x039d, B:157:0x03b5, B:158:0x03c4, B:161:0x03d1, B:163:0x03d7, B:166:0x03dd, B:168:0x03e7, B:170:0x03ef, B:172:0x041f, B:173:0x0426, B:30:0x008d, B:32:0x0093, B:33:0x0097, B:72:0x0171, B:87:0x01dc), top: B:202:0x000c, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e A[Catch: Exception -> 0x0479, TRY_ENTER, TryCatch #2 {Exception -> 0x0479, blocks: (B:5:0x000c, B:9:0x0022, B:180:0x0434, B:185:0x0446, B:193:0x046f, B:10:0x003f, B:12:0x0047, B:14:0x0058, B:17:0x0063, B:35:0x00bf, B:37:0x00c6, B:39:0x00ce, B:41:0x00f1, B:42:0x0113, B:46:0x011e, B:124:0x02e9, B:67:0x014d, B:69:0x0159, B:71:0x0165, B:80:0x0189, B:84:0x01c4, B:75:0x017d, B:77:0x0183, B:86:0x01cd, B:95:0x01f4, B:98:0x0218, B:90:0x01e8, B:92:0x01ee, B:99:0x021d, B:101:0x0232, B:102:0x0237, B:104:0x024c, B:105:0x0251, B:107:0x0261, B:108:0x0266, B:110:0x0276, B:112:0x0282, B:114:0x02aa, B:115:0x02ae, B:117:0x02be, B:118:0x02c2, B:120:0x02d2, B:121:0x02d6, B:123:0x02e6, B:125:0x02f6, B:128:0x0302, B:130:0x0308, B:133:0x0312, B:135:0x031d, B:137:0x0328, B:140:0x0331, B:142:0x0338, B:144:0x0342, B:146:0x036e, B:148:0x0380, B:150:0x0388, B:152:0x0394, B:154:0x039a, B:155:0x039d, B:157:0x03b5, B:158:0x03c4, B:161:0x03d1, B:163:0x03d7, B:166:0x03dd, B:168:0x03e7, B:170:0x03ef, B:172:0x041f, B:173:0x0426, B:30:0x008d, B:32:0x0093, B:33:0x0097, B:72:0x0171, B:87:0x01dc), top: B:202:0x000c, inners: #0, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.taobao.android.dinamicx.widget.DXWidgetNode b(tb.C9787ut r26, com.taobao.android.dinamicx.DXRuntimeContext r27, android.content.Context r28) {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.it.b(tb.ut, com.taobao.android.dinamicx.DXRuntimeContext, android.content.Context):com.taobao.android.dinamicx.widget.DXWidgetNode");
    }

    private C9787ut d(byte[] bArr, DXRuntimeContext dXRuntimeContext, boolean z, Context context) {
        C9787ut c9787ut = new C9787ut();
        String str = new String(bArr, 0, 5);
        if (!"ALIDX".equals(str)) {
            Log.e("BinaryLoader_TMTEST", "loadFromBuffer failed tag is invalidate:" + str);
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_TAG_ERROR));
            return null;
        }
        c9787ut.k(bArr);
        c9787ut.j(5);
        if (c9787ut.d() != 3) {
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_MAJOR_VERSION_ERROR));
            return null;
        }
        this.a = c9787ut.h();
        short h = c9787ut.h();
        String str2 = new String(c9787ut.a(), c9787ut.c(), (int) h);
        c9787ut.j(h);
        c9787ut.l(c9787ut.h());
        int f = c9787ut.f();
        int f2 = c9787ut.f();
        int f3 = c9787ut.f();
        int f4 = c9787ut.f();
        int f5 = c9787ut.f();
        int f6 = c9787ut.f();
        int f7 = c9787ut.f();
        int f8 = c9787ut.f();
        int f9 = c9787ut.f();
        int f10 = c9787ut.f();
        if (this.a >= 7) {
            this.h.f(c9787ut.f());
            this.h.e(c9787ut.f());
            this.h.j(c9787ut.f());
            this.h.i(c9787ut.f());
            this.h.h(c9787ut.f());
            this.h.g(c9787ut.f());
        }
        if (this.a >= 8) {
            this.i.d(c9787ut.f());
            this.i.c(c9787ut.f());
            if (z) {
                this.g.d(c9787ut.f());
                this.g.c(c9787ut.f());
            }
        }
        if (this.a >= 8 && z) {
            this.g.b(c9787ut, dXRuntimeContext, context);
        }
        if (c9787ut.i(f)) {
            this.d.b(str2, f2, c9787ut);
            if (c9787ut.c() == f3) {
                if (!this.b.a(f4, c9787ut, dXRuntimeContext)) {
                    s00.b("string loadFromBuffer error!");
                }
            } else {
                List<C6368e.C6369a> list = dXRuntimeContext.getDxError().c;
                list.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_STRING_LOADER_POSITION_ERROR, "string pos error:" + f3 + "  read pos:" + c9787ut.c()));
            }
            if (c9787ut.c() == f5) {
                if (!this.c.a(f6, c9787ut, dXRuntimeContext)) {
                    s00.b("var string loadFromBuffer error!");
                }
            } else {
                List<C6368e.C6369a> list2 = dXRuntimeContext.getDxError().c;
                list2.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_VARSTRING_LOADER_POSITION_ERROR, "var string pos error:" + f3 + "  read pos:" + c9787ut.c()));
            }
            if (c9787ut.c() == f7) {
                if (!this.e.c(f8, c9787ut, dXRuntimeContext)) {
                    s00.b("expr loadFromBuffer error!");
                }
            } else {
                List<C6368e.C6369a> list3 = dXRuntimeContext.getDxError().c;
                list3.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EXPR_LOADER_POSITION_ERROR, "expr pos error:" + f7 + "  read pos:" + c9787ut.c()));
            }
            if (c9787ut.c() == f9) {
                if (!this.f.b(f10, c9787ut, dXRuntimeContext)) {
                    s00.b("enum loadFromBuffer error!");
                }
            } else {
                dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_ENUM_LOADER_POSITION_ERROR, "enum pos error:" + f7 + "  read pos:" + c9787ut.c()));
            }
        } else {
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_UI_LOADER_POSITION_ERROR));
        }
        try {
            if (this.a >= 7 && !this.h.d(c9787ut, dXRuntimeContext)) {
                s00.b("event chain loadFromBuffer error!");
            }
        } catch (Exception e) {
            ry.b(e);
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_EVENTCHIAN, ry.a(e)));
        }
        try {
            if (this.a >= 8 && !this.i.b(c9787ut, dXRuntimeContext)) {
                s00.b("Expr Script loadFromBuffer error!");
            }
        } catch (Throwable th) {
            ry.b(th);
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_CREATE_LOAD_DX_EXPR_SCRIPT, ry.a(th)));
        }
        c9787ut.i(f);
        return c9787ut;
    }

    private void e(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2) {
        if (dXWidgetNode2 == null) {
            return;
        }
        if (dXWidgetNode2 instanceof DXTemplateWidgetNode) {
            DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) dXWidgetNode2;
            if (dXTemplateWidgetNode.get__StorageType() == 2) {
                String str = dXTemplateWidgetNode.getName() + JSMethod.NOT_SET + dXTemplateWidgetNode.getVersion();
                DXWidgetNode a = this.g.a(str);
                if (a != null) {
                    nz.a("取到childTemplate:" + str);
                    dXTemplateWidgetNode.addChild(a, false);
                }
                dXWidgetNode = a;
            } else if (dXTemplateWidgetNode.get__StorageType() == 1) {
                if (dXTemplateWidgetNode.getChildrenCount() != 1) {
                    nz.g(nz.TAG, "内联的子模版有问题，其getChildrenCount() != 1");
                } else {
                    DXWidgetNode childAt = dXTemplateWidgetNode.getChildAt(0);
                    childAt.setDxEventChains(dXWidgetNode.getDxEventChains());
                    childAt.setAnimation(dXWidgetNode.getAnimation());
                    childAt.setDxExprBytes(dXWidgetNode.getDxExprBytes());
                    dXWidgetNode = childAt;
                }
            } else {
                dXTemplateWidgetNode.isRemote();
            }
        }
        if ((dXWidgetNode2 instanceof C6493f) || dXWidgetNode2.getChildrenCount() > 0) {
            for (int i = 0; i < dXWidgetNode2.getChildrenCount(); i++) {
                e(dXWidgetNode, dXWidgetNode2.getChildAt(i));
            }
        }
    }

    public DXWidgetNode c(byte[] bArr, DXRuntimeContext dXRuntimeContext, Context context, boolean z) {
        if (bArr == null) {
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EMPTY));
            return null;
        }
        C9787ut d = d(bArr, dXRuntimeContext, z, context);
        DXWidgetNode b = b(d, dXRuntimeContext, context);
        if (b == null) {
            s00.b("DXBinaryLoader loadFromBuffer null!");
        }
        if (this.a >= 7) {
            py a = a(d, dXRuntimeContext, context);
            if (b != null && a != null) {
                b.setDxEventChains(a);
            }
        }
        if (this.a >= 8 && b != null) {
            b.setDxExprBytes(this.i.a());
            if (this.i.a() != null && this.i.a().length > 0 && dXRuntimeContext.getEngineContext().c() != null) {
                dXRuntimeContext.getEngineContext().c().b(dXRuntimeContext.getDxTemplateItem().getIdentifier(), this.i.a(), 0);
            }
            this.j.a(dXRuntimeContext, z);
        }
        if (this.a >= 8 && z && b != null) {
            e(b, b);
        }
        if (this.a >= 9) {
            b.setCodeMap(this.e.b());
        }
        return b;
    }
}
