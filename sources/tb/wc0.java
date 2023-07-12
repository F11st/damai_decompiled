package tb;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import cn.damai.issue.bean.DraftExtra;
import cn.damai.issue.listener.OnDialogListener;
import cn.damai.issue.tool.IssueConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class wc0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static long a;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnDialogListener a;

        a(OnDialogListener onDialogListener) {
            this.a = onDialogListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "796307639")) {
                ipChange.ipc$dispatch("796307639", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            this.a.onDialogClick(dialogInterface, false);
            wc0.b(false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnDialogListener a;

        b(OnDialogListener onDialogListener) {
            this.a = onDialogListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1765888662")) {
                ipChange.ipc$dispatch("1765888662", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            this.a.onDialogClick(dialogInterface, true);
            wc0.b(false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnDialogListener a;

        c(OnDialogListener onDialogListener) {
            this.a = onDialogListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1559497611")) {
                ipChange.ipc$dispatch("-1559497611", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            this.a.onDialogClick(dialogInterface, false);
            wc0.b(true);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class d implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnDialogListener a;

        d(OnDialogListener onDialogListener) {
            this.a = onDialogListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-589916588")) {
                ipChange.ipc$dispatch("-589916588", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            this.a.onDialogClick(dialogInterface, true);
            wc0.b(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330110090")) {
            ipChange.ipc$dispatch("1330110090", new Object[]{Boolean.valueOf(z)});
        } else {
            i41.g(z, System.currentTimeMillis() - a);
        }
    }

    public static boolean c(DraftExtra draftExtra, DraftExtra draftExtra2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215263432")) {
            return ((Boolean) ipChange.ipc$dispatch("-215263432", new Object[]{draftExtra, draftExtra2})).booleanValue();
        }
        if (draftExtra == draftExtra2) {
            return true;
        }
        return draftExtra != null && draftExtra2 != null && d(draftExtra.targetId, draftExtra2.targetId) && d(draftExtra.projectName, draftExtra2.projectName) && d(draftExtra.imageUrl, draftExtra2.imageUrl) && d(draftExtra.timeAddress, draftExtra2.timeAddress) && d(draftExtra.privilegeType, draftExtra2.privilegeType);
    }

    public static boolean d(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1446738308") ? ((Boolean) ipChange.ipc$dispatch("-1446738308", new Object[]{str, str2})).booleanValue() : TextUtils.equals(str, str2);
    }

    public static void e(Activity activity, OnDialogListener onDialogListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1106722249")) {
            ipChange.ipc$dispatch("1106722249", new Object[]{activity, onDialogListener});
            return;
        }
        new h4(activity).e("发现未完成的草稿\n是否加载？").h("加载", new b(onDialogListener)).f("新增", new a(onDialogListener)).c(false).j();
        a = System.currentTimeMillis();
    }

    public static void f(Activity activity, OnDialogListener onDialogListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472271628")) {
            ipChange.ipc$dispatch("-1472271628", new Object[]{activity, onDialogListener});
            return;
        }
        new h4(activity).e("将此次编辑保留？").h("保留", new d(onDialogListener)).f("不保留", new c(onDialogListener)).c(false).j();
        a = System.currentTimeMillis();
    }

    public static Intent g(DraftExtra draftExtra) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "864551388")) {
            return (Intent) ipChange.ipc$dispatch("864551388", new Object[]{draftExtra});
        }
        Intent intent = new Intent();
        intent.putExtra(IssueConstants.ProjectID, draftExtra.targetId);
        intent.putExtra("projectName", draftExtra.projectName);
        intent.putExtra("projectImage", draftExtra.imageUrl);
        intent.putExtra("timeAddress", draftExtra.timeAddress);
        intent.putExtra(IssueConstants.privilegeType, draftExtra.privilegeType);
        return intent;
    }
}
