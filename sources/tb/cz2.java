package tb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import cn.wh.auth.AuthService;
import cn.wh.auth.OnCallBack;
import cn.wh.auth.server.ResultRequestService;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class cz2 implements AuthService {
    OnCallBack a;
    Activity b;
    ez2 c;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    class a implements ResultRequestService.Callback {
        final /* synthetic */ h32 a;

        a(h32 h32Var) {
            this.a = h32Var;
        }

        @Override // cn.wh.auth.server.ResultRequestService.Callback
        public void onActivityResult(int i, int i2, Intent intent) {
            if (i2 != -1 || i != 111) {
                this.a.d(com.alibaba.security.realidentity.a.y);
                this.a.e("数据处理异常");
            } else if (intent != null) {
                this.a.d(intent.getStringExtra("resultCode"));
                this.a.e(intent.getStringExtra("resultDesc"));
                this.a.b().d(intent.getStringExtra("idCardAuthData"));
                this.a.b().c(intent.getStringExtra("certPwdData"));
                this.a.b().e(intent.getStringExtra("verifyData"));
            } else {
                this.a.d(com.alibaba.security.realidentity.a.s);
                this.a.e("用户已取消");
            }
            cz2.this.a.onResult(this.a);
        }
    }

    public cz2(Activity activity, ez2 ez2Var) {
        this.b = activity;
        this.c = ez2Var;
    }

    @Override // cn.wh.auth.AuthService
    public void getAuthResult(OnCallBack onCallBack) {
        this.a = onCallBack;
        h32 h32Var = new h32();
        if (TextUtils.isEmpty(this.c.a())) {
            h32Var.e("应用ID异常");
            h32Var.d(com.alibaba.security.realidentity.a.A);
            onCallBack.onResult(h32Var);
        } else if (TextUtils.isEmpty(this.c.c())) {
            h32Var.e("机构ID异常");
            h32Var.d(com.alibaba.security.realidentity.a.z);
            onCallBack.onResult(h32Var);
        } else if (!ji.a(this.b)) {
            h32Var.e("APP尚未安装");
            h32Var.d(com.alibaba.security.realidentity.a.r);
            onCallBack.onResult(h32Var);
        } else {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("cn.cyberIdentity.certification", "cn.wh.project.view.v.authorization.WAuthActivity"));
            intent.setFlags(8388608);
            intent.putExtra("orgID", this.c.c());
            intent.putExtra("appID", this.c.a());
            intent.putExtra("bizSeq", this.c.b());
            StringBuilder sb = new StringBuilder();
            sb.append(this.c.d());
            intent.putExtra("type", sb.toString());
            intent.putExtra("packageName", this.b.getApplication().getPackageName());
            try {
                new ResultRequestService(this.b).c(intent, new a(h32Var));
            } catch (Exception unused) {
                h32Var.e("APP尚未安装");
                h32Var.d(com.alibaba.security.realidentity.a.r);
                this.a.onResult(h32Var);
            }
        }
    }
}
