package tb;

import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.taobao.update.adapter.UserAction;
import com.taobao.update.framework.UpdateRuntime;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d31 implements UserAction {
    private boolean a = false;
    private CountDownLatch b = new CountDownLatch(1);

    public static boolean waitForConfirmAction(String str) {
        d31 d31Var = new d31();
        UpdateRuntime.doUIAlertForConfirm(str, d31Var);
        try {
            d31Var.b.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return d31Var.a;
    }

    @Override // com.taobao.update.adapter.UserAction
    public String getCancelText() {
        return "取消";
    }

    @Override // com.taobao.update.adapter.UserAction
    public String getConfirmText() {
        return "确定";
    }

    @Override // com.taobao.update.adapter.UserAction
    public String getTitleText() {
        return PurchaseConstants.NORMAL_WARNING_TITLE;
    }

    @Override // com.taobao.update.adapter.UserAction
    public void onCancel() {
        this.a = false;
        this.b.countDown();
    }

    @Override // com.taobao.update.adapter.UserAction
    public void onConfirm() {
        this.a = true;
        this.b.countDown();
    }
}
