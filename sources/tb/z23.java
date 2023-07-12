package tb;

import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.connect.api.ApiConstants;
import com.heytap.msp.push.mode.BaseMode;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class z23 extends b53 {
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return b(intent, i);
        }
        return null;
    }

    protected BaseMode b(Intent intent, int i) {
        try {
            d43 d43Var = new d43();
            d43Var.b(Integer.parseInt(f43.f(intent.getStringExtra("command"))));
            d43Var.d(Integer.parseInt(f43.f(intent.getStringExtra("code"))));
            d43Var.g(f43.f(intent.getStringExtra("content")));
            d43Var.c(f43.f(intent.getStringExtra("appKey")));
            d43Var.e(f43.f(intent.getStringExtra(ApiConstants.APPSECRET)));
            d43Var.i(f43.f(intent.getStringExtra("appPackage")));
            z53.a("OnHandleIntent-message:" + d43Var.toString());
            return d43Var;
        } catch (Exception e) {
            z53.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }
}
