package tb;

import android.content.Context;
import cn.damai.tetris.R$styleable;
import cn.damai.tetris.v2.adpater.VBaseAdapter;
import cn.damai.tetris.v2.adpater.VDefaultAdapter;
import cn.damai.tetris.v2.creator.ICreator;
import cn.damai.tetris.v2.helper.StaggeredLayoutHelper;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.C3299b;
import com.alibaba.android.vlayout.layout.C3302c;
import com.alibaba.android.vlayout.layout.C3308h;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import com.youku.arch.v3.data.Constants;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class o3 implements ICreator<VBaseAdapter, Map<String, Object>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;

    public o3(Context context) {
        this.a = context;
    }

    private VBaseAdapter b(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        int i = 2;
        if (AndroidInstantRuntime.support(ipChange, "-1360091678")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1360091678", new Object[]{this, map});
        }
        if (map.get("span") != null && (map.get("span") instanceof Integer)) {
            i = ((Integer) map.get("span")).intValue();
        }
        List list = (List) map.get("data");
        C3299b c3299b = new C3299b(i);
        h(c3299b, map);
        i(c3299b, map);
        g(c3299b, map);
        c3299b.setAutoExpand(false);
        return new VDefaultAdapter(this.a).h(c3299b).f(list).g(list.size());
    }

    private VBaseAdapter c(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318378019")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("318378019", new Object[]{this, map});
        }
        List list = (List) map.get("data");
        C3302c c3302c = new C3302c();
        i(c3302c, map);
        g(c3302c, map);
        return new VDefaultAdapter(this.a).h(c3302c).f(list).g(list.size());
    }

    private VBaseAdapter d(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027159456")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1027159456", new Object[]{this, map});
        }
        C3308h c3308h = new C3308h();
        i(c3308h, map);
        g(c3308h, map);
        return new VDefaultAdapter(this.a).h(c3308h).f((List) map.get("data")).g(1);
    }

    private VBaseAdapter e(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        int i = 2;
        if (AndroidInstantRuntime.support(ipChange, "1655868756")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1655868756", new Object[]{this, map});
        }
        if (map.get("span") != null && (map.get("span") instanceof Integer)) {
            i = ((Integer) map.get("span")).intValue();
        }
        StaggeredLayoutHelper staggeredLayoutHelper = new StaggeredLayoutHelper(i);
        i(staggeredLayoutHelper, map);
        g(staggeredLayoutHelper, map);
        h(staggeredLayoutHelper, map);
        staggeredLayoutHelper.g(f(this.a, map, "marginGap"));
        List list = (List) map.get("data");
        return new VDefaultAdapter(this.a).h(staggeredLayoutHelper).f(list).g(list.size());
    }

    private void g(BaseLayoutHelper baseLayoutHelper, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1812706090")) {
            ipChange.ipc$dispatch("1812706090", new Object[]{this, baseLayoutHelper, map});
        } else if (map.containsKey("bgColor")) {
            baseLayoutHelper.setBgColor(((Integer) map.get("bgColor")).intValue());
        }
    }

    private void h(BaseLayoutHelper baseLayoutHelper, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1297370627")) {
            ipChange.ipc$dispatch("1297370627", new Object[]{this, baseLayoutHelper, map});
            return;
        }
        Context context = this.a;
        if (context != null) {
            int f = f(context, map, Constants.H_GAP);
            if (f == 0) {
                f = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_gapH, 0);
            }
            boolean z = baseLayoutHelper instanceof C3299b;
            if (z) {
                ((C3299b) baseLayoutHelper).setHGap(f);
            } else if (baseLayoutHelper instanceof StaggeredLayoutHelper) {
                ((StaggeredLayoutHelper) baseLayoutHelper).setHGap(f);
            }
            int f2 = f(this.a, map, Constants.V_GAP);
            if (f2 == 0) {
                f2 = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_gapV, 0);
            }
            if (z) {
                ((C3299b) baseLayoutHelper).setVGap(f2);
            } else if (baseLayoutHelper instanceof StaggeredLayoutHelper) {
                ((StaggeredLayoutHelper) baseLayoutHelper).setVGap(f2);
            }
        }
    }

    private void i(BaseLayoutHelper baseLayoutHelper, Map map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-677991333")) {
            ipChange.ipc$dispatch("-677991333", new Object[]{this, baseLayoutHelper, map});
            return;
        }
        Context context = this.a;
        if (context != null) {
            int f = f(context, map, Constants.Name.MARGIN_LEFT);
            if (f == 0) {
                f = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_marginLeft, 0);
            }
            baseLayoutHelper.setMarginLeft(f);
            int f2 = f(this.a, map, Constants.Name.MARGIN_RIGHT);
            if (f2 == 0) {
                f2 = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_marginRight, 0);
            }
            baseLayoutHelper.setMarginRight(f2);
            int f3 = f(this.a, map, Constants.Name.MARGIN_TOP);
            if (f3 == 0) {
                f3 = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_marginTop, 0);
            }
            baseLayoutHelper.setMarginTop(f3);
            int f4 = f(this.a, map, Constants.Name.MARGIN_BOTTOM);
            if (f4 == 0) {
                f4 = this.a.getTheme().obtainStyledAttributes(R$styleable.DMComponentLayout).getDimensionPixelOffset(R$styleable.DMComponentLayout_marginBottom, 0);
            }
            baseLayoutHelper.setMarginBottom(f4);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
        if (r0.equals("grid") == false) goto L8;
     */
    @Override // cn.damai.tetris.v2.creator.ICreator
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.damai.tetris.v2.adpater.VBaseAdapter create(tb.nm<java.util.Map<java.lang.String, java.lang.Object>> r7) {
        /*
            r6 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.o3.$ipChange
            java.lang.String r1 = "-1188206935"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L1a
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r5] = r6
            r2[r4] = r7
            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
            cn.damai.tetris.v2.adpater.VBaseAdapter r7 = (cn.damai.tetris.v2.adpater.VBaseAdapter) r7
            return r7
        L1a:
            java.lang.String r0 = r7.c()
            r0.hashCode()
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case -1102672091: goto L4a;
                case -892259863: goto L3f;
                case 3181382: goto L36;
                case 1839260940: goto L2b;
                default: goto L29;
            }
        L29:
            r3 = -1
            goto L54
        L2b:
            java.lang.String r2 = "staggered"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L34
            goto L29
        L34:
            r3 = 3
            goto L54
        L36:
            java.lang.String r2 = "grid"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L54
            goto L29
        L3f:
            java.lang.String r2 = "sticky"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L48
            goto L29
        L48:
            r3 = 1
            goto L54
        L4a:
            java.lang.String r2 = "linear"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L53
            goto L29
        L53:
            r3 = 0
        L54:
            switch(r3) {
                case 0: goto Lb5;
                case 1: goto L78;
                case 2: goto L6d;
                case 3: goto L62;
                default: goto L57;
            }
        L57:
            java.lang.Object r0 = r7.b()
            java.util.Map r0 = (java.util.Map) r0
            cn.damai.tetris.v2.adpater.VBaseAdapter r0 = r6.d(r0)
            goto Lbf
        L62:
            java.lang.Object r0 = r7.b()
            java.util.Map r0 = (java.util.Map) r0
            cn.damai.tetris.v2.adpater.VBaseAdapter r0 = r6.e(r0)
            goto Lbf
        L6d:
            java.lang.Object r0 = r7.b()
            java.util.Map r0 = (java.util.Map) r0
            cn.damai.tetris.v2.adpater.VBaseAdapter r0 = r6.b(r0)
            goto Lbf
        L78:
            java.lang.Object r0 = r7.b()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "data"
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            com.alibaba.android.vlayout.layout.StickyLayoutHelper r1 = new com.alibaba.android.vlayout.layout.StickyLayoutHelper
            r1.<init>()
            java.lang.Object r2 = r7.b()
            java.util.Map r2 = (java.util.Map) r2
            r6.i(r1, r2)
            java.lang.Object r2 = r7.b()
            java.util.Map r2 = (java.util.Map) r2
            r6.g(r1, r2)
            cn.damai.tetris.v2.adpater.VDefaultAdapter r2 = new cn.damai.tetris.v2.adpater.VDefaultAdapter
            android.content.Context r3 = r6.a
            r2.<init>(r3)
            cn.damai.tetris.v2.adpater.VBaseAdapter r1 = r2.h(r1)
            cn.damai.tetris.v2.adpater.VBaseAdapter r1 = r1.f(r0)
            int r0 = r0.size()
            cn.damai.tetris.v2.adpater.VBaseAdapter r0 = r1.g(r0)
            goto Lbf
        Lb5:
            java.lang.Object r0 = r7.b()
            java.util.Map r0 = (java.util.Map) r0
            cn.damai.tetris.v2.adpater.VBaseAdapter r0 = r6.c(r0)
        Lbf:
            cn.damai.tetris.core.IContext r7 = r7.a()
            r0.i(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o3.create(tb.nm):cn.damai.tetris.v2.adpater.VBaseAdapter");
    }

    public int f(Context context, Map map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1483664520")) {
            return ((Integer) ipChange.ipc$dispatch("-1483664520", new Object[]{this, context, map, str})).intValue();
        }
        if (map.containsKey(str)) {
            return zl2.a(context, ((Integer) map.get(str)).intValue());
        }
        return 0;
    }
}
