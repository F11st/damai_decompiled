package tb;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.DamaiConstants;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.ticklet.listener.TickletPopListener;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DMThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class wn2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private TickletPopListener b;
    private DialogInterface.OnDismissListener c;
    DMThemeDialog d;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ DMIconFontTextView b;

        a(String str, DMIconFontTextView dMIconFontTextView) {
            this.a = str;
            this.b = dMIconFontTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "158019373")) {
                ipChange.ipc$dispatch("158019373", new Object[]{this, view});
            } else if (z20.B(this.a).equals("true")) {
                this.b.setText(R$string.iconfont_duoxuan_weixuan_);
                this.b.setTextColor(wn2.this.a.getResources().getColor(R$color.color_999999));
                z20.T(this.a, "false");
                cn.damai.common.user.c.e().x(pl.j().o("0"));
            } else {
                this.b.setText(R$string.iconfont_duihaomian_);
                this.b.setTextColor(wn2.this.a.getResources().getColor(R$color.color_ff2d79));
                z20.T(this.a, "true");
                cn.damai.common.user.c.e().x(pl.j().o("1"));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(wn2 wn2Var) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2025657554")) {
                ipChange.ipc$dispatch("-2025657554", new Object[]{this, view});
            } else {
                cn.damai.common.user.c.e().x(pl.j().n());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1745245536")) {
                ipChange.ipc$dispatch("1745245536", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            if (wn2.this.b != null) {
                wn2.this.b.popWindowClickListener(this.a);
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            wn2.this.e(this.a, this.b);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1094613593")) {
                ipChange.ipc$dispatch("1094613593", new Object[]{this, message});
                return;
            }
            super.dispatchMessage(message);
            int i = message.what;
            if (i != 2) {
                if (i != 5 || wn2.this.b == null) {
                    return;
                }
                wn2.this.b.doNotShowTickletPopWindow();
                return;
            }
            Bundle data = message.getData();
            if (data == null) {
                if (wn2.this.b != null) {
                    wn2.this.b.showPopFailed();
                    return;
                }
                return;
            }
            HashMap hashMap = (HashMap) data.getSerializable("data");
            if (hashMap == null) {
                if (wn2.this.b != null) {
                    wn2.this.b.showPopFailed();
                    return;
                }
                return;
            }
            try {
                String str = (String) hashMap.get("projectBeginTime");
                String str2 = (String) hashMap.get("projectType");
                String str3 = (String) hashMap.get("projectName");
                String str4 = (String) hashMap.get(TicketDetailExtFragment.PERFORM_ID);
                String str5 = (String) hashMap.get(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !str2.equals("4")) {
                    if (wn2.this.b != null) {
                        wn2.this.b.showPopWindow(str4);
                    }
                    wn2.this.j(str, str3, str4, str5);
                    return;
                }
                if (wn2.this.b != null) {
                    wn2.this.b.showPopFailed();
                }
            } catch (Exception e) {
                if (wn2.this.b != null) {
                    wn2.this.b.showPopFailed();
                }
                e.printStackTrace();
            }
        }
    }

    public wn2(Activity activity) {
        this.a = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1606799956")) {
            ipChange.ipc$dispatch("1606799956", new Object[]{this, str, str2});
            return;
        }
        cn.damai.common.user.c.e().x(pl.j().p(str));
        Bundle bundle = new Bundle();
        bundle.putString(TicketDetailExtFragment.PERFORM_ID, str);
        bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str2);
        bundle.putString("from", "homeAlert");
        DMNav.from(this.a).withExtras(bundle).toUri(NavUri.b(cs.Z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190857719")) {
            ipChange.ipc$dispatch("190857719", new Object[]{this, str, str2, str3, str4});
        } else if (!this.a.isFinishing() && (Build.VERSION.SDK_INT < 17 || !this.a.isDestroyed())) {
            String str5 = str4 + str3;
            View inflate = LayoutInflater.from(this.a).inflate(R$layout.ticklet_perform_alert, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.ticklet_alert_layout);
            DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) inflate.findViewById(R$id.ticklet_alert_text);
            TextView textView = (TextView) inflate.findViewById(R$id.ticklet_project_name);
            if (z20.B(str5).equals("true")) {
                dMIconFontTextView.setText(R$string.iconfont_duihaomian_);
            } else {
                dMIconFontTextView.setText(R$string.iconfont_duoxuan_weixuan_);
            }
            DMThemeDialog dMThemeDialog = new DMThemeDialog(this.a);
            this.d = dMThemeDialog;
            dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_NOTIFICATION);
            this.d.m(inflate);
            DialogInterface.OnDismissListener onDismissListener = this.c;
            if (onDismissListener != null) {
                this.d.setOnDismissListener(onDismissListener);
            }
            if (!TextUtils.isEmpty(str)) {
                this.d.o("开场提醒：" + k(str));
            }
            if (!TextUtils.isEmpty(str2)) {
                textView.setText(str2);
            }
            linearLayout.setOnClickListener(new a(str5, dMIconFontTextView));
            this.d.g(true, new b(this));
            this.d.i("查看电子票", new c(str3, str4));
            this.d.f(false);
            this.d.show();
        } else {
            TickletPopListener tickletPopListener = this.b;
            if (tickletPopListener != null) {
                tickletPopListener.showPopFailed();
            }
        }
    }

    public static String k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1221698187")) {
            return (String) ipChange.ipc$dispatch("1221698187", new Object[]{str});
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return simpleDateFormat.format(new Date(Long.parseLong(str)));
        } catch (Exception unused) {
            return "";
        }
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965264297")) {
            ipChange.ipc$dispatch("965264297", new Object[]{this});
            return;
        }
        DMThemeDialog dMThemeDialog = this.d;
        if (dMThemeDialog == null || !dMThemeDialog.isShowing()) {
            return;
        }
        this.d.dismiss();
    }

    public void g(FrameLayout frameLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505393613")) {
            ipChange.ipc$dispatch("-1505393613", new Object[]{this, frameLayout});
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(DamaiConstants.TICKLET_EXTERNAL_CALL_BRODCAST_ACTION);
            intent.setPackage("cn.damai");
            intent.putExtra("type", 2);
            intent.putExtra("messenger", new Messenger(new d()));
            this.a.sendBroadcast(intent);
        } catch (Exception e) {
            Log.e("TickletpopHelper", e.getMessage());
            p3.a("damai_member", "member_service_start", "homepage_nouse_perfrom", "errorMsg = " + e.getMessage());
        }
    }

    public void h(DialogInterface.OnDismissListener onDismissListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-379401543")) {
            ipChange.ipc$dispatch("-379401543", new Object[]{this, onDismissListener});
        } else {
            this.c = onDismissListener;
        }
    }

    public void i(TickletPopListener tickletPopListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2020072697")) {
            ipChange.ipc$dispatch("-2020072697", new Object[]{this, tickletPopListener});
        } else {
            this.b = tickletPopListener;
        }
    }
}
