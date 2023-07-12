package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cn.damai.common.nav.DMNav;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class yv1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_PROJECT_ITEM = 1;
    private static final String f = "yv1";
    private Context a;
    private final List<ProjectDataHolder> b;
    private List<HtmlParserManager.a> c;
    private HashMap<Integer, Integer> d;
    private LinkedHashMap<String, Integer> e;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements HtmlParserManager.OnSpanClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager.OnSpanClickListener
        public void onSpanClick(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1714844934")) {
                ipChange.ipc$dispatch("-1714844934", new Object[]{this, Integer.valueOf(i), str});
            } else {
                yv1.this.l(str);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements HtmlParserManager.OnParseFinishedListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager.OnParseFinishedListener
        public void onParseFinished(List<HtmlParserManager.a> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1776276092")) {
                ipChange.ipc$dispatch("1776276092", new Object[]{this, list});
                return;
            }
            yv1.this.c.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            yv1.this.c.addAll(list);
            String str = yv1.f;
            Log.d(str, "converted item size = " + yv1.this.c.size());
            yv1.this.b.clear();
            List list2 = yv1.this.b;
            yv1 yv1Var = yv1.this;
            list2.addAll(yv1Var.j(yv1Var.c));
        }
    }

    private yv1(Context context) {
        new ArrayList();
        this.b = new ArrayList();
        this.a = context;
        this.c = new ArrayList();
        this.d = new HashMap<>();
        this.e = new LinkedHashMap<>();
        f();
    }

    private void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-977607945")) {
            ipChange.ipc$dispatch("-977607945", new Object[]{this});
            return;
        }
        DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics());
        t60.a(this.a, 36.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ProjectDataHolder> j(List<HtmlParserManager.a> list) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-1403538274")) {
            return (List) ipChange.ipc$dispatch("-1403538274", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        if (size > 2) {
            m(1);
        } else {
            m(size);
            i = size;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            HtmlParserManager.a aVar = list.get(i3);
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(3);
            projectDataHolder.setConvertedItem(aVar);
            projectDataHolder.setConvertedItemPosition(i3);
            projectDataHolder.setConvertedItemSize(size);
            projectDataHolder.setMorePosition(i);
            this.d.put(Integer.valueOf(i3), 0);
            if (aVar.e() == 2) {
                this.e.put(aVar.a().toString(), Integer.valueOf(i2));
                i2++;
            }
            arrayList.add(projectDataHolder);
        }
        return arrayList;
    }

    public static yv1 k(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-30084991") ? (yv1) ipChange.ipc$dispatch("-30084991", new Object[]{context}) : new yv1(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1403012537")) {
            ipChange.ipc$dispatch("-1403012537", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DMNav.from(this.a).toUri(str);
        }
    }

    public LinkedHashMap<String, Integer> g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1161959402") ? (LinkedHashMap) ipChange.ipc$dispatch("1161959402", new Object[]{this}) : this.e;
    }

    public int h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624879089")) {
            return ((Integer) ipChange.ipc$dispatch("-624879089", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        List<ProjectDataHolder> list = this.b;
        if (list == null || i <= 0 || i >= list.size()) {
            return -1;
        }
        return this.b.get(i - 1).getConvertedItem().e();
    }

    public List<ProjectDataHolder> i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1432262555")) {
            return (List) ipChange.ipc$dispatch("1432262555", new Object[]{this, str});
        }
        if (!wh2.j(str)) {
            HtmlParserManager.a(800, 1.4f, 333333, 16, 888888, 14).c(this.a, "<span>" + str.replaceAll("\r|\t|\n", "") + "</span>", new a(), new b());
        }
        return this.b;
    }

    public void m(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862076792")) {
            ipChange.ipc$dispatch("-1862076792", new Object[]{this, Integer.valueOf(i)});
        }
    }
}
