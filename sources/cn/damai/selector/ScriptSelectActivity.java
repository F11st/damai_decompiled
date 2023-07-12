package cn.damai.selector;

import android.os.Build;
import android.view.View;
import cn.damai.comment.R$color;
import cn.damai.comment.R$id;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ScriptSelectActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    private final void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451109858")) {
            ipChange.ipc$dispatch("1451109858", new Object[]{this});
            return;
        }
        hideBaseLayout();
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        findViewById.setVisibility(8);
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "913400706")) {
            return ((Integer) ipChange.ipc$dispatch("913400706", new Object[]{this})).intValue();
        }
        return 0;
    }

    @Override // cn.damai.commonbusiness.base.SimpleBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1115497035")) {
            ipChange.ipc$dispatch("1115497035", new Object[]{this});
        } else {
            super.initView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
        r6 = kotlin.text.n.i(r6);
     */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.selector.ScriptSelectActivity.$ipChange
            java.lang.String r1 = "2124393487"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            super.onCreate(r6)
            int r6 = cn.damai.comment.R$layout.activity_script_selector
            r5.setContentView(r6)
            r5.initTitle()
            androidx.fragment.app.FragmentManager r6 = r5.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r6 = r6.beginTransaction()
            java.lang.String r0 = "supportFragmentManager.beginTransaction()"
            tb.b41.h(r6, r0)
            int r0 = cn.damai.comment.R$id.fragment
            com.alibaba.pictures.bricks.selector.ScriptSelectFragment r1 = new com.alibaba.pictures.bricks.selector.ScriptSelectFragment
            r1.<init>()
            android.content.Intent r2 = r5.getIntent()
            if (r2 == 0) goto L41
            android.os.Bundle r2 = r2.getExtras()
            goto L42
        L41:
            r2 = 0
        L42:
            r1.setArguments(r2)
            tb.wt2 r2 = tb.wt2.INSTANCE
            r6.replace(r0, r1)
            r6.commitAllowingStateLoss()
            android.content.Intent r6 = r5.getIntent()
            android.os.Bundle r6 = r6.getExtras()
            if (r6 == 0) goto L69
            java.lang.String r0 = "pageType"
            java.lang.String r6 = r6.getString(r0)
            if (r6 == 0) goto L69
            java.lang.Integer r6 = kotlin.text.g.i(r6)
            if (r6 == 0) goto L69
            int r4 = r6.intValue()
        L69:
            if (r4 != r3) goto L6e
            java.lang.String r6 = "scriptkill_associate"
            goto L70
        L6e:
            java.lang.String r6 = "scriptkill_store_associate"
        L70:
            cn.damai.common.user.a$b r0 = new cn.damai.common.user.a$b
            r0.<init>()
            cn.damai.common.user.a$b r6 = r0.i(r6)
            r5.setDamaiUTKeyBuilder(r6)
            cn.damai.common.user.c r6 = cn.damai.common.user.c.e()
            r6.K(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.selector.ScriptSelectActivity.onCreate(android.os.Bundle):void");
    }

    @Override // cn.damai.common.app.base.BaseActivity
    @NotNull
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1223032438") ? (String) ipChange.ipc$dispatch("1223032438", new Object[]{this}) : "";
    }
}
