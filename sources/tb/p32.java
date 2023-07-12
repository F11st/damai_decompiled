package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.RichTextModule;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class p32 implements IRichTextManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int RICH_TYPE_ARTIST = 4;
    public static final int RICH_TYPE_DETAIL_INTRO = 3;
    public static final int RICH_TYPE_IMPORTANT = 1;
    public static final int RICH_TYPE_OTHER = 5;
    public static final int RICH_TYPE_OUTLINE = 2;
    private Context a;
    private ProjectDataHolder b;
    private List<HtmlParserManager.a> c;
    private ProjectDataHolder d;
    private List<HtmlParserManager.a> g;
    private ProjectDataHolder h;
    private boolean j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;
    private boolean o;
    private List<ProjectDataHolder> f = new ArrayList();
    private List<ProjectDataHolder> e = new ArrayList();
    private LinkedHashMap<String, Integer> i = new LinkedHashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements HtmlParserManager.OnSpanClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager.OnSpanClickListener
        public void onSpanClick(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "257546158")) {
                ipChange.ipc$dispatch("257546158", new Object[]{this, Integer.valueOf(i), str});
            } else {
                p32.this.m(str);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements HtmlParserManager.OnParseFinishedListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager.OnParseFinishedListener
        public void onParseFinished(List<HtmlParserManager.a> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1504109496")) {
                ipChange.ipc$dispatch("-1504109496", new Object[]{this, list});
            } else if (!m91.a(list)) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    HtmlParserManager.a aVar = list.get(i);
                    if (aVar != null && aVar.a() != null && !"".equals(aVar.a().toString().trim())) {
                        arrayList.add(aVar);
                    }
                }
                if (m91.a(arrayList)) {
                    return;
                }
                if (!TextUtils.isEmpty(this.a)) {
                    p32 p32Var = p32.this;
                    p32Var.b = p32Var.k(8, this.a);
                }
                p32.this.g = arrayList;
                List h = p32.this.h(arrayList);
                if (h == null || h.isEmpty()) {
                    return;
                }
                p32.this.f.clear();
                p32.this.f.addAll(h);
                p32.this.o();
            }
        }
    }

    private p32(Context context, boolean z) {
        this.a = context;
        this.j = z;
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ProjectDataHolder> h(List<HtmlParserManager.a> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1602742255")) {
            return (List) ipChange.ipc$dispatch("1602742255", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        int e = wh2.e(list);
        if (e > 0) {
            if (e > 2) {
                this.l = true;
                this.c = list.subList(0, 2);
                p(1);
            } else {
                this.l = false;
                p(e);
                this.c = list;
            }
            int i = 0;
            for (int i2 = 0; i2 < e; i2++) {
                HtmlParserManager.a aVar = list.get(i2);
                ProjectDataHolder projectDataHolder = new ProjectDataHolder(3);
                projectDataHolder.setConvertedItem(aVar);
                projectDataHolder.setConvertedItemPosition(i2);
                projectDataHolder.setConvertedItemSize(e);
                projectDataHolder.setRichType(this.m);
                if (aVar.e() == 2) {
                    this.i.put(aVar.a().toString(), Integer.valueOf(i));
                    i++;
                }
                arrayList.add(projectDataHolder);
            }
            return arrayList;
        }
        return null;
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454428252")) {
            ipChange.ipc$dispatch("454428252", new Object[]{this});
            return;
        }
        this.k = true;
        o();
    }

    public static IRichTextManager j(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-246654680") ? (IRichTextManager) ipChange.ipc$dispatch("-246654680", new Object[]{context, Boolean.valueOf(z)}) : new p32(context, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ProjectDataHolder k(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420957083")) {
            return (ProjectDataHolder) ipChange.ipc$dispatch("1420957083", new Object[]{this, Integer.valueOf(i), str});
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(6);
        projectDataHolder.setSectionTitleType(i);
        projectDataHolder.setSectionTitleContent(str);
        return projectDataHolder;
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755259620")) {
            ipChange.ipc$dispatch("1755259620", new Object[]{this});
            return;
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(7);
        this.h = projectDataHolder;
        if (!this.j) {
            projectDataHolder.setMoreType(0);
        } else {
            projectDataHolder.setMoreType(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1575592657")) {
            ipChange.ipc$dispatch("1575592657", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DMNav.from(this.a).toUri(str);
        }
    }

    private void n(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978393844")) {
            ipChange.ipc$dispatch("-1978393844", new Object[]{this, str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            HtmlParserManager.a(800, 1.4f, 16, 0, 12, 666666).c(this.a, "<span>" + str2.replaceAll("\r|\t|\n", "").replaceAll("\u2028", "").replaceAll("\u2029", "") + "</span>", new a(), new b(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209776537")) {
            ipChange.ipc$dispatch("-1209776537", new Object[]{this});
            return;
        }
        List<ProjectDataHolder> list = this.f;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.e.clear();
        if (this.j) {
            this.e.addAll(this.f);
            this.h.setMoreContent("");
            this.h.setMoreType(-1);
            this.e.add(this.h);
            return;
        }
        this.e.addAll(this.f);
        if (this.l) {
            this.h.setMoreContent(this.k ? "收起" : "展开更多");
            this.h.setMoreType(0);
        } else {
            this.h.setMoreContent("");
            this.h.setMoreType(-1);
        }
        this.e.add(this.h);
    }

    private void p(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011706744")) {
            ipChange.ipc$dispatch("1011706744", new Object[]{this, Integer.valueOf(i)});
        }
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1673720717")) {
            ipChange.ipc$dispatch("1673720717", new Object[]{this});
            return;
        }
        this.k = false;
        o();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445525474")) {
            ipChange.ipc$dispatch("-1445525474", new Object[]{this});
            return;
        }
        this.b = null;
        this.d = null;
        this.e.clear();
        this.f.clear();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public String combineRichText(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-896434772")) {
            return (String) ipChange.ipc$dispatch("-896434772", new Object[]{this, list});
        }
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                sb.append("<p>");
                sb.append(str);
                sb.append("</p>");
            }
        }
        return sb.toString();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextMoreListener
    public void expandShrinkRichText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1015876461")) {
            ipChange.ipc$dispatch("-1015876461", new Object[]{this});
        } else if (!this.k) {
            i();
        } else {
            q();
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public ProjectDataHolder geTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1317852407") ? (ProjectDataHolder) ipChange.ipc$dispatch("1317852407", new Object[]{this}) : this.b;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public List<ProjectDataHolder> getDisplayRichItems() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-56678668") ? (List) ipChange.ipc$dispatch("-56678668", new Object[]{this}) : this.e;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1626661836")) {
            return ((Integer) ipChange.ipc$dispatch("1626661836", new Object[]{this})).intValue();
        }
        List<HtmlParserManager.a> list = this.g;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public LinkedHashMap<String, Integer> getItemImages() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2051532634") ? (LinkedHashMap) ipChange.ipc$dispatch("-2051532634", new Object[]{this}) : this.i;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public int getItemTypePrevious(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1389915845")) {
            return ((Integer) ipChange.ipc$dispatch("1389915845", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        List<ProjectDataHolder> list = this.f;
        if (list == null || i <= 0 || i >= list.size()) {
            return -1;
        }
        return this.f.get(i - 1).getConvertedItem().e();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public ProjectDataHolder getShrinkRichItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "281337995")) {
            return (ProjectDataHolder) ipChange.ipc$dispatch("281337995", new Object[]{this});
        }
        List<HtmlParserManager.a> list = this.c;
        if (list != null && list.size() > 0 && this.d == null) {
            ProjectDataHolder projectDataHolder = new ProjectDataHolder(11);
            this.d = projectDataHolder;
            projectDataHolder.setShrinkConvertedItem(this.c);
            this.d.setShrinkRichType(this.m);
        }
        return this.d;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public int getStartIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-230442952") ? ((Integer) ipChange.ipc$dispatch("-230442952", new Object[]{this})).intValue() : this.n;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public boolean hasExpanded() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "704926396") ? ((Boolean) ipChange.ipc$dispatch("704926396", new Object[]{this})).booleanValue() : this.k;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public boolean hasMoreRichItems() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2118810510") ? ((Boolean) ipChange.ipc$dispatch("2118810510", new Object[]{this})).booleanValue() : this.l;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public boolean overLimitedHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1329764734") ? ((Boolean) ipChange.ipc$dispatch("-1329764734", new Object[]{this})).booleanValue() : this.o;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void parseRichText(RichTextModule richTextModule) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1420592069")) {
            ipChange.ipc$dispatch("1420592069", new Object[]{this, richTextModule});
        } else if (richTextModule != null) {
            n(richTextModule.getTitle(), richTextModule.getContent());
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void setHasMore(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1480851298")) {
            ipChange.ipc$dispatch("1480851298", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.l = z;
        o();
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void setOverLimitedHeight(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1641093824")) {
            ipChange.ipc$dispatch("-1641093824", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.o = z;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void setRichType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1769398256")) {
            ipChange.ipc$dispatch("-1769398256", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.m = i;
        ProjectDataHolder projectDataHolder = this.h;
        if (projectDataHolder != null) {
            projectDataHolder.setRichType(i);
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void setStartIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "506080106")) {
            ipChange.ipc$dispatch("506080106", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.n = i;
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public boolean showAllRichText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1250550082") ? ((Boolean) ipChange.ipc$dispatch("1250550082", new Object[]{this})).booleanValue() : this.j;
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager
    public void parseRichText(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086969437")) {
            ipChange.ipc$dispatch("-2086969437", new Object[]{this, str, str2});
        } else {
            n(str, str2);
        }
    }
}
