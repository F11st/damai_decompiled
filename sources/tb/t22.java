package tb;

import android.content.res.Configuration;
import com.alibaba.responsive.page.IResponsivePage;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class t22 {
    private IResponsivePage a;
    private int b;
    private int c;

    public t22(IResponsivePage iResponsivePage) {
        this.a = iResponsivePage;
        this.c = w22.d().e(this.a.getPageActivity());
    }

    public void a(Configuration configuration) {
        if (d32.i(this.a.getPageActivity())) {
            this.b = this.c;
            this.c = w22.d().e(this.a.getPageActivity());
        }
    }

    public void b(Configuration configuration) {
        if (d32.i(this.a.getPageActivity())) {
            IResponsivePage iResponsivePage = this.a;
            int i = this.c;
            iResponsivePage.onResponsiveLayout(configuration, i, this.b != i);
        }
    }
}
