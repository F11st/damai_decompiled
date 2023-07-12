package cn.damai.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RawRes;
import cn.damai.common.R$id;
import cn.damai.common.R$layout;
import cn.damai.common.R$string;
import cn.damai.common.util.toastutil.C0537a;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.cb1;
import tb.cm2;
import tb.mu0;
import tb.xj1;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ToastUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public enum ToastLottieType {
        TYPE_SUCCESS(0, "成功");
        
        String name;
        int type;

        ToastLottieType(int i, String str) {
            this.type = i;
            this.name = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.util.ToastUtil$b */
    /* loaded from: classes13.dex */
    public static class C0534b {
        private static final ToastUtil a = new ToastUtil();
    }

    public static final ToastUtil a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-456941317") ? (ToastUtil) ipChange.ipc$dispatch("-456941317", new Object[0]) : C0534b.a;
    }

    public static void b(CharSequence charSequence, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1347967486")) {
            ipChange.ipc$dispatch("-1347967486", new Object[]{charSequence, Integer.valueOf(i)});
        } else {
            d(mu0.a().getApplicationContext(), null, charSequence);
        }
    }

    public static void c(Context context, int i, int i2) {
        String b;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-789824819")) {
            ipChange.ipc$dispatch("-789824819", new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (i != 0) {
            try {
                b = cm2.b(context, i);
            } catch (Exception e) {
                cb1.c("ToastUtil", e.getMessage());
                return;
            }
        } else {
            b = "";
        }
        d(context, b, i2 != 0 ? cm2.b(context, i2) : "");
    }

    public static void d(Context context, CharSequence charSequence, CharSequence charSequence2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1246216437")) {
            ipChange.ipc$dispatch("1246216437", new Object[]{context, charSequence, charSequence2});
        } else {
            C0537a.j(mu0.a().getApplicationContext(), C0537a.b(context, charSequence, charSequence2), 0, 17, 0, 0);
        }
    }

    public static void f(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1139781893")) {
            ipChange.ipc$dispatch("1139781893", new Object[]{charSequence});
        } else {
            d(mu0.a().getApplicationContext(), null, charSequence);
        }
    }

    public static void h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202506606")) {
            ipChange.ipc$dispatch("-202506606", new Object[]{Integer.valueOf(i)});
        } else {
            c(mu0.a().getApplicationContext(), 0, i);
        }
    }

    public static void i(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559021621")) {
            ipChange.ipc$dispatch("1559021621", new Object[]{charSequence});
        } else {
            d(mu0.a().getApplicationContext(), null, charSequence);
        }
    }

    public static void k(String str, String str2, @RawRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "659926185")) {
            ipChange.ipc$dispatch("659926185", new Object[]{str, str2, Integer.valueOf(i)});
            return;
        }
        View inflate = LayoutInflater.from(mu0.a().getApplicationContext()).inflate(R$layout.toast_custom_lottie_v2, (ViewGroup) null);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R$id.toast_lottie_view_v2);
        if (i != 0) {
            lottieAnimationView.setAnimation(i);
            lottieAnimationView.setVisibility(0);
        }
        TextView textView = (TextView) inflate.findViewById(R$id.toast_title_v2);
        TextView textView2 = (TextView) inflate.findViewById(R$id.toast_sub_title_v2);
        textView.setText(str);
        textView.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        textView2.setText(str2);
        textView2.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
        C0537a.j(mu0.a().getApplicationContext(), inflate, 0, 17, 0, 0);
    }

    public void e(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117274057")) {
            ipChange.ipc$dispatch("-117274057", new Object[]{this, context, str});
        } else {
            d(context, null, str);
        }
    }

    public void g(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1003863798")) {
            ipChange.ipc$dispatch("1003863798", new Object[]{this, context});
        } else if (xj1.b(context)) {
        } else {
            j(context, context.getResources().getString(R$string.damai_base_net_toast));
        }
    }

    public void j(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745691956")) {
            ipChange.ipc$dispatch("-1745691956", new Object[]{this, context, str});
            return;
        }
        if (context == null) {
            context = mu0.a();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d(context, null, str);
    }

    private ToastUtil() {
    }
}
