package tb;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.taobao.monitor.procedure.IPage;
import com.taobao.monitor.procedure.IPageFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wp1 implements IPageFactory {
    private static final wp1 b = new wp1();
    private IPageFactory a;

    public static wp1 a() {
        return b;
    }

    public void b(IPageFactory iPageFactory) {
        this.a = iPageFactory;
    }

    @Override // com.taobao.monitor.procedure.IPageFactory
    @NonNull
    public IPage createPage(View view, boolean z) {
        IPageFactory iPageFactory = this.a;
        if (iPageFactory == null) {
            return IPage.DEFAULT_PAGE;
        }
        return iPageFactory.createPage(view, z);
    }

    @Override // com.taobao.monitor.procedure.IPageFactory
    @NonNull
    public IPage createStartedPage(@NonNull Fragment fragment, String str, String str2, @NonNull View view, boolean z) {
        IPageFactory iPageFactory = this.a;
        if (iPageFactory == null) {
            return IPage.DEFAULT_PAGE;
        }
        return iPageFactory.createStartedPage(fragment, str, str2, view, z);
    }
}
