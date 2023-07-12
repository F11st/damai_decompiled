package cn.damai.category.category.ui;

import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CategoryProxyActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1641080922") ? ((Integer) ipChange.ipc$dispatch("-1641080922", new Object[]{this})).intValue() : R$layout.activity_category_proxy;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003f, code lost:
        if (r0.equals("1") != false) goto L14;
     */
    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initView() {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.category.category.ui.CategoryProxyActivity.$ipChange
            java.lang.String r1 = "-599490393"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L14
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L14:
            super.initView()
            android.content.Intent r0 = r5.getIntent()
            java.lang.String r1 = "option"
            java.lang.String r0 = r0.getStringExtra(r1)
            if (r0 != 0) goto L26
            java.lang.String r0 = ""
        L26:
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case 48: goto L42;
                case 49: goto L39;
                case 50: goto L2f;
                default: goto L2e;
            }
        L2e:
            goto L4c
        L2f:
            java.lang.String r2 = "2"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4c
            r3 = 1
            goto L4d
        L39:
            java.lang.String r2 = "1"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4c
            goto L4d
        L42:
            java.lang.String r2 = "0"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L4c
            r3 = 2
            goto L4d
        L4c:
            r3 = -1
        L4d:
            if (r3 == 0) goto L5c
            if (r3 == r4) goto L52
            goto L65
        L52:
            cn.damai.common.nav.DMNav r0 = cn.damai.common.nav.DMNav.from(r5)
            java.lang.String r1 = tb.cs.s
            r0.toHost(r1)
            goto L65
        L5c:
            cn.damai.common.nav.DMNav r0 = cn.damai.common.nav.DMNav.from(r5)
            java.lang.String r1 = tb.cs.r
            r0.toHost(r1)
        L65:
            r5.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.category.category.ui.CategoryProxyActivity.initView():void");
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-881613926")) {
            return (String) ipChange.ipc$dispatch("-881613926", new Object[]{this});
        }
        return null;
    }
}
