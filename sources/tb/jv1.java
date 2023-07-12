package tb;

import android.content.Context;
import android.text.TextUtils;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.bean.StaticData;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class jv1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectDataHolder> b = new ArrayList();
    private List<ProjectDataHolder> c = new ArrayList();
    private boolean d;
    private yv1 e;

    public jv1(Context context) {
        this.a = context;
        this.e = yv1.k(this.a);
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1883611148")) {
            ipChange.ipc$dispatch("1883611148", new Object[]{this});
        } else {
            this.c.clear();
        }
    }

    private ProjectDataHolder b(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683389303")) {
            return (ProjectDataHolder) ipChange.ipc$dispatch("1683389303", new Object[]{this, Integer.valueOf(i), str});
        }
        if (i != 0) {
            str = "";
        } else if (TextUtils.isEmpty(str)) {
            str = f(R$string.project_title_introduce);
        }
        ProjectDataHolder projectDataHolder = new ProjectDataHolder(6);
        projectDataHolder.setSectionTitleType(i);
        projectDataHolder.setSectionTitleContent(str);
        return projectDataHolder;
    }

    private String f(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "760231075") ? (String) ipChange.ipc$dispatch("760231075", new Object[]{this, Integer.valueOf(i)}) : this.a.getResources().getString(i);
    }

    private void g(StaticData staticData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "993471047")) {
            ipChange.ipc$dispatch("993471047", new Object[]{this, staticData});
        } else if (staticData != null) {
            StaticData.ItemExtendInfo itemExtendInfo = staticData.getItemExtendInfo();
            if (itemExtendInfo != null && !TextUtils.isEmpty(itemExtendInfo.getItemExtend())) {
                List<ProjectDataHolder> i = this.e.i(itemExtendInfo.getItemExtend());
                if (i == null || i.isEmpty()) {
                    return;
                }
                this.c.add(b(0, itemExtendInfo.getItemDescTitle()));
                this.c.addAll(i);
                return;
            }
            this.c.clear();
        } else {
            this.c.clear();
        }
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1908217908")) {
            ipChange.ipc$dispatch("-1908217908", new Object[]{this});
            return;
        }
        this.b.clear();
        if (wh2.e(this.c) > 0) {
            this.b.addAll(this.c);
        }
    }

    public ProjectDataHolder c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-714595008") ? (ProjectDataHolder) ipChange.ipc$dispatch("-714595008", new Object[]{this}) : new ProjectDataHolder(15);
    }

    public List<ProjectDataHolder> d(StaticData staticData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1456028281")) {
            return (List) ipChange.ipc$dispatch("1456028281", new Object[]{this, staticData});
        }
        if (!this.d) {
            a();
            if (staticData != null) {
                g(staticData);
                this.d = true;
            }
        }
        h();
        return this.b;
    }

    public yv1 e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1155074190") ? (yv1) ipChange.ipc$dispatch("-1155074190", new Object[]{this}) : this.e;
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "287228297")) {
            ipChange.ipc$dispatch("287228297", new Object[]{this});
        } else {
            this.d = false;
        }
    }
}
