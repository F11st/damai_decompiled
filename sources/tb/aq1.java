package tb;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.taobao.monitor.procedure.IPage;
import com.taobao.monitor.procedure.IPageManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class aq1 implements IPageManager {
    public static aq1 a = new aq1();
    private static IPageManager b;

    public void a(IPageManager iPageManager) {
        b = iPageManager;
    }

    @Override // com.taobao.monitor.procedure.IPageManager
    public IPage getActivityPage(Activity activity) {
        IPageManager iPageManager = b;
        if (iPageManager == null) {
            return IPage.DEFAULT_PAGE;
        }
        return iPageManager.getActivityPage(activity);
    }

    @Override // com.taobao.monitor.procedure.IPageManager
    public IPage getFragmentPage(Fragment fragment) {
        IPageManager iPageManager = b;
        if (iPageManager == null) {
            return IPage.DEFAULT_PAGE;
        }
        return iPageManager.getFragmentPage(fragment);
    }

    @Override // com.taobao.monitor.procedure.IPageManager
    public IPage getPage(View view) {
        IPageManager iPageManager = b;
        if (iPageManager == null) {
            return IPage.DEFAULT_PAGE;
        }
        return iPageManager.getPage(view);
    }

    @Override // com.taobao.monitor.procedure.IPageManager
    public IPage getPageGroup(View view) {
        IPageManager iPageManager = b;
        if (iPageManager == null) {
            return IPage.DEFAULT_PAGE;
        }
        return iPageManager.getPageGroup(view);
    }
}
