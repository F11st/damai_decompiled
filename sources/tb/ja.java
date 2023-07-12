package tb;

import android.app.Activity;
import cn.damai.tetris.core.IContext;
import cn.damai.tetris.v2.structure.container.IContainer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXEngineConfig;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.List;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ja implements IContext {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private String b;
    private String c;
    private DinamicXEngine d;
    private IContainer e;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements IDXNotificationListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(ja jaVar) {
        }

        @Override // com.taobao.android.dinamicx.notification.IDXNotificationListener
        public void onNotificationListener(rz rzVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1761767225")) {
                ipChange.ipc$dispatch("-1761767225", new Object[]{this, rzVar});
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onNotificationListener : failedTemplateItems(");
            List<DXTemplateItem> list = rzVar.b;
            sb.append(list == null ? 0 : list.size());
            sb.append(" finishedTemplateItems(");
            List<DXTemplateItem> list2 = rzVar.a;
            sb.append(list2 == null ? 0 : list2.size());
            sb.append(" templateUpdateRequestList(");
            List<s10> list3 = rzVar.c;
            sb.append(list3 != null ? list3.size() : 0);
            jb1.a("Tetris.dinamicX", sb.toString());
            List<DXTemplateItem> list4 = rzVar.a;
            if (list4 == null || list4.isEmpty()) {
                return;
            }
            for (DXTemplateItem dXTemplateItem : rzVar.a) {
                m90.i(dXTemplateItem);
            }
        }
    }

    public ja() {
        int nextInt = new Random().nextInt();
        this.c = xl2.a(nextInt + "");
    }

    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1993215287") ? (String) ipChange.ipc$dispatch("1993215287", new Object[]{this}) : this.c;
    }

    public void b(IContainer iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-45995096")) {
            ipChange.ipc$dispatch("-45995096", new Object[]{this, iContainer});
        } else {
            this.e = iContainer;
        }
    }

    @Override // cn.damai.tetris.core.IContext
    public Activity getActivity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2021924353") ? (Activity) ipChange.ipc$dispatch("2021924353", new Object[]{this}) : this.a;
    }

    @Override // cn.damai.tetris.core.IContext
    public IContainer getContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "931713002") ? (IContainer) ipChange.ipc$dispatch("931713002", new Object[]{this}) : this.e;
    }

    @Override // cn.damai.tetris.core.IContext
    public DinamicXEngine getDXEngine() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1110483161")) {
            return (DinamicXEngine) ipChange.ipc$dispatch("-1110483161", new Object[]{this});
        }
        if (this.d == null) {
            DinamicXEngine dinamicXEngine = new DinamicXEngine(new DXEngineConfig("bizTypeHome"));
            this.d = dinamicXEngine;
            dinamicXEngine.L(new a(this));
        }
        return this.d;
    }

    @Override // cn.damai.tetris.core.IContext
    public String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1572620196") ? (String) ipChange.ipc$dispatch("1572620196", new Object[]{this}) : this.b;
    }

    @Override // cn.damai.tetris.core.IContext
    public void setActivity(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109790093")) {
            ipChange.ipc$dispatch("109790093", new Object[]{this, activity});
        } else {
            this.a = activity;
        }
    }

    @Override // cn.damai.tetris.core.IContext
    public void setPageName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624257978")) {
            ipChange.ipc$dispatch("1624257978", new Object[]{this, str});
        } else {
            this.b = str;
        }
    }
}
