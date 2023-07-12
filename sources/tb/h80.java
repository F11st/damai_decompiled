package tb;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import cn.damai.common.app.base.BaseActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class h80 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static h80 d;
    private Dialog a;
    private final List<Dialog> b = new ArrayList();
    private final DialogInterface.OnDismissListener c = new a();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1129761278")) {
                ipChange.ipc$dispatch("-1129761278", new Object[]{this, dialogInterface});
                return;
            }
            h80.this.b.remove(h80.this.a);
            h80.this.e();
        }
    }

    public static h80 d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1121380015")) {
            return (h80) ipChange.ipc$dispatch("-1121380015", new Object[0]);
        }
        if (d == null) {
            d = new h80();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1761799081")) {
            ipChange.ipc$dispatch("1761799081", new Object[]{this});
        } else if (this.b.size() > 0) {
            Dialog dialog = this.b.get(0);
            this.a = dialog;
            if (dialog == null || dialog.isShowing()) {
                return;
            }
            this.a.show();
            this.a.setOnDismissListener(this.c);
        } else {
            this.a = null;
        }
    }

    public void f(BaseActivity baseActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276995249")) {
            ipChange.ipc$dispatch("1276995249", new Object[]{this, baseActivity});
        } else if (baseActivity.isFinishing()) {
        } else {
            if ((Build.VERSION.SDK_INT < 17 || !baseActivity.isDestroyed()) && baseActivity.isActivityForeground()) {
                try {
                    e();
                } catch (Exception e) {
                    cb1.c("DialogHelper", e.getMessage());
                }
            }
        }
    }
}
