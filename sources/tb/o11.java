package tb;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.member.R$drawable;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.zxing.DecodeQRImage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class o11 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.o11$a */
    /* loaded from: classes7.dex */
    public class C9493a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C9493a(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1427224189")) {
                ipChange.ipc$dispatch("1427224189", new Object[]{this, c0502e});
                return;
            }
            Drawable drawable = c0502e.a;
            if (drawable != null) {
                this.a.setImageBitmap(((BitmapDrawable) drawable).getBitmap());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.o11$b */
    /* loaded from: classes7.dex */
    public class C9494b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserTicketTable a;
        final /* synthetic */ ImageView b;
        final /* synthetic */ Context c;
        final /* synthetic */ String d;

        /* compiled from: Taobao */
        /* renamed from: tb.o11$b$a */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC9495a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC9495a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1361961925")) {
                    ipChange.ipc$dispatch("1361961925", new Object[]{this, view});
                    return;
                }
                C9494b c9494b = C9494b.this;
                o11.c(c9494b.c, c9494b.a, c9494b.b, c9494b.d);
            }
        }

        C9494b(UserTicketTable userTicketTable, ImageView imageView, Context context, String str) {
            this.a = userTicketTable;
            this.b = imageView;
            this.c = context;
            this.d = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1562956778")) {
                ipChange.ipc$dispatch("1562956778", new Object[]{this, c0501d});
            } else if (this.a.hasAvailableTicket()) {
                this.b.setImageResource(R$drawable.detail_static_zxing_fail_icon);
                this.b.setOnClickListener(new View$OnClickListenerC9495a());
                String valueOf = c0501d != null ? String.valueOf(c0501d.a) : "";
                if (in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(this.d)) {
                    String performId = this.a.getPerformId();
                    UserTicketTable userTicketTable = this.a;
                    o11.e(valueOf, performId, userTicketTable.voucherUniqueKey, userTicketTable.getStaticUrl());
                    return;
                }
                String performId2 = this.a.getPerformId();
                UserTicketTable userTicketTable2 = this.a;
                o11.d(valueOf, performId2, userTicketTable2.voucherUniqueKey, userTicketTable2.getStaticUrl());
            }
        }
    }

    public static void c(Context context, UserTicketTable userTicketTable, ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1373162896")) {
            ipChange.ipc$dispatch("-1373162896", new Object[]{context, userTicketTable, imageView, str});
        } else if (userTicketTable == null) {
        } else {
            if (!userTicketTable.hasAvailableTicket()) {
                imageView.setImageResource(R$drawable.detail_zing_userd);
            } else if (xh2.c(userTicketTable.getVerifyCode()) && userTicketTable.isStaticQrcode()) {
                qa0.a(imageView);
                imageView.setTag(C0504a.b().c(userTicketTable.getStaticUrl()).e(new C9494b(userTicketTable, imageView, context, str)).n(new C9493a(imageView)).f());
            } else {
                new DecodeQRImage(context, userTicketTable, imageView, str).start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1582636999")) {
            ipChange.ipc$dispatch("-1582636999", new Object[]{str, str2, str3, str4});
            return;
        }
        xn2.c(xn2.f("静态二维码加载失败", "", str, "", " performId:" + str2 + " , voucherUniqueKey:" + str3 + " , url:" + str4), xn2.TICKLET_PERFORM_DETAIL_RENDER_STATIC_ERROR_CODE, "静态二维码加载失败");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681479086")) {
            ipChange.ipc$dispatch("-1681479086", new Object[]{str, str2, str3, str4});
            return;
        }
        xn2.c(xn2.f("静态二维码加载失败", "", str, "", " performId:" + str2 + " , voucherUniqueKey:" + str3 + " , url:" + str4), xn2.TICKLET_FLOAT_RENDER_STATIC_ERROR_CODE, "静态二维码加载失败");
    }
}
