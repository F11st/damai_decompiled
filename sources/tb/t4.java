package tb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import cn.damai.common.app.widget.DMDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class t4 extends ll {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, DialogInterface dialogInterface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1276719133")) {
            ipChange.ipc$dispatch("-1276719133", new Object[]{context, dialogInterface, Integer.valueOf(i)});
            return;
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://d.alipay.com")));
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(DialogInterface dialogInterface, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1644334974")) {
            ipChange.ipc$dispatch("1644334974", new Object[]{dialogInterface, Integer.valueOf(i)});
        } else {
            dialogInterface.dismiss();
        }
    }

    @Override // cn.damai.common.nav.DMNav.NavPreprocessor
    public boolean beforeNavTo(Intent intent, final Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1893962540")) {
            return ((Boolean) ipChange.ipc$dispatch("-1893962540", new Object[]{this, intent, context})).booleanValue();
        }
        if (intent == null || TextUtils.isEmpty(intent.getDataString())) {
            return false;
        }
        String dataString = intent.getDataString();
        cb1.b("DMNav", "AliPayProcessor url : " + dataString);
        if (!dataString.startsWith("alipays:") && !dataString.startsWith("alipay")) {
            cb1.b("DMNav", "AliPayProcessor return false : " + dataString);
            return false;
        }
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(dataString)));
        } catch (Exception unused) {
            new DMDialog(context).q("未检测到支付宝客户端，请安装后重试。").n("立即安装", new DialogInterface.OnClickListener() { // from class: tb.r4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    t4.c(context, dialogInterface, i);
                }
            }).i("取消", new DialogInterface.OnClickListener() { // from class: tb.s4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    t4.d(dialogInterface, i);
                }
            }).t(3).o(true).show();
        }
        return true;
    }
}
