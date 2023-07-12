package tb;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.taobao.tao.update.common.R$id;
import com.taobao.tao.update.common.R$layout;
import com.taobao.update.adapter.UINotify;
import com.taobao.update.adapter.UIToast;
import com.taobao.update.dialog.Dialog;
import com.taobao.update.framework.UpdateRuntime;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class sr2 implements UINotify {
    private Dialog a;
    private UIToast b = (UIToast) wb.getInstance(UIToast.class);

    private void a() {
        this.a = null;
    }

    @Override // com.taobao.update.adapter.UINotify
    public void notifyDownloadError(String str) {
        Dialog dialog = this.a;
        if (dialog != null) {
            dialog.dismiss();
        }
        a();
        UIToast uIToast = this.b;
        if (uIToast == null) {
            Toast.makeText(UpdateRuntime.getContext(), str, 0).show();
        } else {
            uIToast.toast(str);
        }
    }

    @Override // com.taobao.update.adapter.UINotify
    public void notifyDownloadFinish(String str) {
        try {
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Throwable unused) {
        }
        a();
    }

    @Override // com.taobao.update.adapter.UINotify
    public void notifyDownloadProgress(int i) {
        try {
            if (this.a == null) {
                Activity peekTopActivity = l3.getInstance().peekTopActivity();
                if (peekTopActivity != null && !peekTopActivity.isFinishing()) {
                    LayoutInflater from = LayoutInflater.from(peekTopActivity);
                    Dialog dialog = new Dialog(peekTopActivity, "正在更新", "", false);
                    this.a = dialog;
                    dialog.setContentView(from.inflate(R$layout.update_coerce, (ViewGroup) null));
                    this.a.show();
                }
                return;
            }
            ((ProgressBar) this.a.getContentView().findViewById(R$id.pb1)).setProgress(i);
            ((TextView) this.a.getContentView().findViewById(R$id.tvUpdatePercent)).setText(i + "%");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
