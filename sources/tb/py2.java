package tb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.fission.util.FissionUtil;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.member.R$drawable;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.PerformTable;
import cn.damai.ticklet.bean.TicketAlipayCardBean;
import cn.damai.ticklet.bean.TicketExtAttr;
import cn.damai.ticklet.bean.TicketNftExtAttr;
import cn.damai.ticklet.bean.TicketSouvenirBean;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.ui.activity.TickletTransferManageActivity;
import cn.damai.ticklet.ui.activity.TickletVenueActivity;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.youku.arch.v3.util.ColorUtil;
import java.util.ArrayList;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class py2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static py2 a;
    private static long b;

    /* compiled from: Taobao */
    /* renamed from: tb.py2$a */
    /* loaded from: classes7.dex */
    public class C9573a implements GenerateImageUtil.OnImageGenerateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        C9573a(py2 py2Var, View view) {
            this.a = view;
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2117192064")) {
                ipChange.ipc$dispatch("2117192064", new Object[]{this});
            } else {
                this.a.setClickable(true);
            }
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "346881127")) {
                ipChange.ipc$dispatch("346881127", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
            ShareManager.E().C();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.py2$b */
    /* loaded from: classes7.dex */
    public class C9574b implements GenerateImageUtil.OnImageGenerateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        C9574b(py2 py2Var, View view) {
            this.a = view;
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1606657887")) {
                ipChange.ipc$dispatch("1606657887", new Object[]{this});
            } else {
                this.a.setClickable(true);
            }
        }

        @Override // cn.damai.commonbusiness.share.generateimage.GenerateImageUtil.OnImageGenerateListener
        public void onSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-163653050")) {
                ipChange.ipc$dispatch("-163653050", new Object[]{this});
                return;
            }
            this.a.setClickable(true);
            ShareManager.E().C();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.py2$c */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC9575c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ Context b;

        View$OnClickListenerC9575c(String str, Context context) {
            this.a = str;
            this.b = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "131227509")) {
                ipChange.ipc$dispatch("131227509", new Object[]{this, view});
            } else if (TextUtils.isEmpty(this.a)) {
            } else {
                new h4(this.b).i(this.b.getResources().getString(R$string.ticklet_perform_change_notice)).c(false).e(this.a).h(this.b.getResources().getString(R$string.ticklet_know), null).j();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.py2$d */
    /* loaded from: classes7.dex */
    public class C9576d implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        C9576d(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1935479896")) {
                ipChange.ipc$dispatch("-1935479896", new Object[]{this, c0501d});
                return;
            }
            if (c0501d != null) {
                String.valueOf(c0501d.a);
            }
            int i = this.a;
            if (i != -1) {
                this.b.setImageResource(i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.py2$e */
    /* loaded from: classes7.dex */
    public class C9577e implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C9577e(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "717324093")) {
                ipChange.ipc$dispatch("717324093", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
            } else {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.py2$f */
    /* loaded from: classes7.dex */
    public class C9578f implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        C9578f(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1987669420")) {
                ipChange.ipc$dispatch("1987669420", new Object[]{this, c0501d});
                return;
            }
            if (c0501d != null) {
                String.valueOf(c0501d.a);
            }
            int i = this.a;
            if (i != -1) {
                this.b.setImageResource(i);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.py2$g */
    /* loaded from: classes7.dex */
    public class C9579g implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C9579g(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1714983359")) {
                ipChange.ipc$dispatch("-1714983359", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
            } else {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.py2$h */
    /* loaded from: classes7.dex */
    public class C9580h implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C9580h(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-345723218")) {
                ipChange.ipc$dispatch("-345723218", new Object[]{this, c0501d});
                return;
            }
            if (c0501d != null) {
                String.valueOf(c0501d.a);
            }
            this.a.setVisibility(8);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.py2$i */
    /* loaded from: classes7.dex */
    public class C9581i implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C9581i(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1363830211")) {
                ipChange.ipc$dispatch("1363830211", new Object[]{this, c0502e});
            } else if (c0502e == null || (bitmap = c0502e.b) == null) {
            } else {
                this.a.setVisibility(0);
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    private py2() {
    }

    public static void A(Context context, String str, int i, String str2, LinearLayout linearLayout, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006969353")) {
            ipChange.ipc$dispatch("2006969353", new Object[]{context, str, Integer.valueOf(i), str2, linearLayout, Integer.valueOf(i2)});
            return;
        }
        linearLayout.removeAllViews();
        if (!TextUtils.isEmpty(str2)) {
            linearLayout.setVisibility(0);
            TextView textView = new TextView(context);
            textView.setGravity(i2);
            textView.setTextSize(1, i);
            z(str, textView, "#111111", "#999999");
            textView.setText(str2);
            linearLayout.addView(textView);
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0092, code lost:
        if (r6.equals("2") == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void B(java.lang.String r6, android.widget.ImageView r7) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.py2.B(java.lang.String, android.widget.ImageView):void");
    }

    public static void C(String str, ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861088451")) {
            ipChange.ipc$dispatch("1861088451", new Object[]{str, imageView});
        } else if (xh2.c(str)) {
            imageView.setVisibility(8);
        } else {
            str.hashCode();
            if (str.equals("1")) {
                imageView.setImageResource(R$drawable.ticket_has_entrance_state);
                imageView.setVisibility(0);
            } else if (!str.equals("2")) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageResource(R$drawable.ticket_has_exit_state);
                imageView.setVisibility(0);
            }
        }
    }

    public static void D(Context context, TextView textView, String str, long j, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004645999")) {
            ipChange.ipc$dispatch("1004645999", new Object[]{context, textView, str, Long.valueOf(j), str2, str3, str4});
            return;
        }
        if (xh2.c(str)) {
            str = x30.h(Long.valueOf(j), "yyyy.MM.dd HH:mm");
        }
        if (!TextUtils.isEmpty(str4) && in2.PERFORM_CANCEL.equals(str4)) {
            H(context, textView, str, R$drawable.ticklet_perform_cancel, null);
        } else if ("1".equals(str2)) {
            H(context, textView, str, R$drawable.ticklet_detail_change_tip_icon, new View$OnClickListenerC9575c(str3, context));
        } else {
            textView.setText(str);
        }
    }

    public static void E(View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465871444")) {
            ipChange.ipc$dispatch("-1465871444", new Object[]{view, Boolean.valueOf(z)});
        } else if (z) {
            if (view.getVisibility() == 8) {
                view.setVisibility(0);
            }
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public static void F(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1118384028")) {
            ipChange.ipc$dispatch("-1118384028", new Object[]{textView, str});
        } else if (!TextUtils.isEmpty(str)) {
            textView.setVisibility(0);
            textView.setText(str);
        } else {
            textView.setVisibility(8);
        }
    }

    public static void G(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778491563")) {
            ipChange.ipc$dispatch("1778491563", new Object[]{view});
        } else if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            view.setVisibility(0);
        }
    }

    public static void H(Context context, TextView textView, String str, int i, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113262261")) {
            ipChange.ipc$dispatch("2113262261", new Object[]{context, textView, str, Integer.valueOf(i), onClickListener});
        } else if (context != null) {
            if (onClickListener != null) {
                textView.setOnClickListener(onClickListener);
            }
            u11 u11Var = new u11(context, i);
            SpannableString spannableString = new SpannableString(AltriaXLaunchTime.SPACE + str);
            spannableString.setSpan(u11Var, 0, 1, 33);
            textView.setText(spannableString);
        }
    }

    public static boolean e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "388222970")) {
            return ((Boolean) ipChange.ipc$dispatch("388222970", new Object[]{context})).booleanValue();
        }
        return (Build.VERSION.SDK_INT >= 8 ? context.getResources().getConfiguration().uiMode & 48 : 0) == 32;
    }

    public static py2 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "809650971")) {
            return (py2) ipChange.ipc$dispatch("809650971", new Object[0]);
        }
        if (a == null) {
            synchronized (py2.class) {
                if (a == null) {
                    a = new py2();
                }
            }
        }
        return a;
    }

    public static boolean p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1541009126")) {
            return ((Boolean) ipChange.ipc$dispatch("1541009126", new Object[0])).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b < 500) {
            b = currentTimeMillis;
            return true;
        }
        b = currentTimeMillis;
        return false;
    }

    public static void q(Context context, ImageView imageView, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1111646923")) {
            ipChange.ipc$dispatch("-1111646923", new Object[]{context, imageView, str, Integer.valueOf(i)});
        } else {
            C0504a.b().e(str).k(new DMRoundedCornersBitmapProcessor(t60.a(context, 6.0f), 0)).n(new C9577e(imageView)).e(new C9576d(i, imageView)).f();
        }
    }

    public static void r(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-858904574")) {
            ipChange.ipc$dispatch("-858904574", new Object[]{imageView, str});
        } else {
            C0504a.b().e(str).k(new DMRoundedCornersBitmapProcessor(6, 0)).n(new C9581i(imageView)).e(new C9580h(imageView)).f();
        }
    }

    public static void s(ImageView imageView, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-856208575")) {
            ipChange.ipc$dispatch("-856208575", new Object[]{imageView, str, Integer.valueOf(i)});
        } else {
            C0504a.b().e(str).k(new DMRoundedCornersBitmapProcessor(6, 0)).n(new C9579g(imageView)).e(new C9578f(i, imageView)).f();
        }
    }

    public static void v(ImageView imageView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165467936")) {
            ipChange.ipc$dispatch("-165467936", new Object[]{imageView});
            return;
        }
        imageView.setImageResource(R$drawable.ticket_refund_coupon_state);
        imageView.setVisibility(0);
    }

    public static void w(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723211168")) {
            ipChange.ipc$dispatch("1723211168", new Object[]{view});
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public static void x(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477347194")) {
            ipChange.ipc$dispatch("-477347194", new Object[]{view});
        } else if (view.getVisibility() == 0) {
            view.setVisibility(4);
        }
    }

    public static void y(Context context, UserTicketTable userTicketTable, LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308515651")) {
            ipChange.ipc$dispatch("-1308515651", new Object[]{context, userTicketTable, linearLayout});
        } else if (TextUtils.isEmpty(userTicketTable.seatInfo) && TextUtils.isEmpty(userTicketTable.getPrice())) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            if (!TextUtils.isEmpty(userTicketTable.seatInfo)) {
                TextView textView = new TextView(context);
                textView.setGravity(17);
                textView.setTextSize(1, 16.0f);
                z(userTicketTable.getVoucherState(), textView, "#000000", "#999999");
                textView.setText(userTicketTable.seatInfo);
                linearLayout.addView(textView);
            }
            if (TextUtils.isEmpty(userTicketTable.getPrice())) {
                return;
            }
            TextView textView2 = new TextView(context);
            textView2.setGravity(17);
            textView2.setTextSize(1, 13.0f);
            textView2.setTextColor(Color.parseColor("#999999"));
            textView2.setText(userTicketTable.getPrice());
            linearLayout.addView(textView2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams.topMargin = t60.a(context, 9.0f);
            textView2.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r7.equals("20") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void z(java.lang.String r7, android.widget.TextView r8, java.lang.String r9, java.lang.String r10) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.py2.$ipChange
            java.lang.String r1 = "1118326251"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L1d
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r6] = r7
            r2[r5] = r8
            r2[r4] = r9
            r2[r3] = r10
            r0.ipc$dispatch(r1, r2)
            return
        L1d:
            r7.hashCode()
            r0 = -1
            int r1 = r7.hashCode()
            switch(r1) {
                case 49: goto L49;
                case 50: goto L3e;
                case 51: goto L33;
                case 1598: goto L2a;
                default: goto L28;
            }
        L28:
            r3 = -1
            goto L53
        L2a:
            java.lang.String r1 = "20"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L53
            goto L28
        L33:
            java.lang.String r1 = "3"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L3c
            goto L28
        L3c:
            r3 = 2
            goto L53
        L3e:
            java.lang.String r1 = "2"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L47
            goto L28
        L47:
            r3 = 1
            goto L53
        L49:
            java.lang.String r1 = "1"
            boolean r7 = r7.equals(r1)
            if (r7 != 0) goto L52
            goto L28
        L52:
            r3 = 0
        L53:
            switch(r3) {
                case 0: goto L5e;
                case 1: goto L5e;
                case 2: goto L5e;
                case 3: goto L5e;
                default: goto L56;
            }
        L56:
            int r7 = android.graphics.Color.parseColor(r10)
            r8.setTextColor(r7)
            goto L65
        L5e:
            int r7 = android.graphics.Color.parseColor(r9)
            r8.setTextColor(r7)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.py2.z(java.lang.String, android.widget.TextView, java.lang.String, java.lang.String):void");
    }

    public void a(View view, Activity activity, TicketSouvenirBean ticketSouvenirBean, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2065426754")) {
            ipChange.ipc$dispatch("-2065426754", new Object[]{this, view, activity, ticketSouvenirBean, bitmap});
        } else if (activity == null) {
        } else {
            view.setClickable(false);
            DMShareMessage dMShareMessage = new DMShareMessage();
            dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_NEW_SHARE;
            dMShareMessage.sharePictureUrl = ticketSouvenirBean.projectImage;
            dMShareMessage.shareTitle = ticketSouvenirBean.projectName;
            dMShareMessage.shareLink = ticketSouvenirBean.projectDetailH5Url;
            dMShareMessage.businessBitmap = bitmap;
            dMShareMessage.projectId = ticketSouvenirBean.itemId;
            dMShareMessage.commentType = "";
            dMShareMessage.tip = "去大麦了解更多";
            dMShareMessage.bgImageUrl = ticketSouvenirBean.bgImage;
            DMShareMessage.QRCodeColor qRCodeColor = new DMShareMessage.QRCodeColor();
            qRCodeColor.radius = t60.a(activity, 6.0f);
            qRCodeColor.solidColor = "#ffffff";
            qRCodeColor.strokeColor = "#FFEAD8";
            qRCodeColor.strokeWidth = t60.a(activity, 3.0f);
            dMShareMessage.qrCodeColor = qRCodeColor;
            GenerateImageUtil.q(activity, dMShareMessage, false);
            GenerateImageUtil.G(new C9574b(this, view));
        }
    }

    public List<PerformTable> b(List<PerformTable> list) {
        String trim;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2063202307")) {
            return (List) ipChange.ipc$dispatch("2063202307", new Object[]{this, list});
        }
        ArrayList arrayList = new ArrayList();
        new PerformTable();
        for (PerformTable performTable : list) {
            try {
                PerformTable performTable2 = (PerformTable) performTable.clone();
                if (performTable2.sepType == 0) {
                    if (xh2.c(performTable2.getTimeTitle()) && performTable2.getStartTimeByLong() == 0) {
                        performTable2.timeShow = null;
                    }
                    if (xh2.c(performTable2.getTimeTitle())) {
                        trim = x30.h(Long.valueOf(performTable2.getStartTimeByLong()), "yyyy.MM.dd HH:mm");
                    } else {
                        trim = performTable2.getTimeTitle().trim();
                    }
                    performTable2.timeShow = trim;
                    if (in2.PERFORM_CANCEL.equals(performTable2.performStatus)) {
                        performTable2.timeShowIcon = performTable2.isHistoryTicket() ? R$drawable.ticklet_perform_cancel_history : R$drawable.ticklet_perform_cancel;
                    } else if ("1".equals(performTable2.isTimeChanged)) {
                        if (performTable2.isHistoryTicket()) {
                            i = R$drawable.ticklet_detail_change_tip_icon_history;
                        } else {
                            i = R$drawable.ticklet_list_change_tip_icon;
                        }
                        performTable2.timeShowIcon = i;
                    } else {
                        performTable2.timeShowIcon = -1;
                    }
                }
                performTable = performTable2;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            arrayList.add(performTable);
        }
        return arrayList;
    }

    public int[] c(int i, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "688467923")) {
            return (int[]) ipChange.ipc$dispatch("688467923", new Object[]{this, Integer.valueOf(i), arrayList});
        }
        int[] iArr = {i, i, ColorUtil.parseColorSafely(in2.DETAIL_PAGE_DEFAULT_COLOR)};
        if (arrayList != null && arrayList.size() > 0) {
            int e = wh2.e(arrayList);
            if (e < 2) {
                return iArr;
            }
            iArr = new int[e];
            for (int i2 = 0; i2 < e; i2++) {
                iArr[i2] = ColorUtil.parseColorSafely(arrayList.get(i2));
            }
        }
        return iArr;
    }

    public int d(float f, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-567421826") ? ((Integer) ipChange.ipc$dispatch("-567421826", new Object[]{this, Float.valueOf(f), Integer.valueOf(i)})).intValue() : (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public void g(FrameLayout frameLayout, TextView textView, TicketExtAttr ticketExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "458719633")) {
            ipChange.ipc$dispatch("458719633", new Object[]{this, frameLayout, textView, ticketExtAttr});
        } else if (ticketExtAttr != null && !TextUtils.isEmpty(ticketExtAttr.ticketGetModelMark)) {
            G(frameLayout);
            textView.setText(ticketExtAttr.ticketGetModelMark);
        } else {
            w(frameLayout);
        }
    }

    public float[] h(boolean z, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1282377229")) {
            return (float[]) ipChange.ipc$dispatch("-1282377229", new Object[]{this, Boolean.valueOf(z), iArr});
        }
        return iArr.length == 2 ? new float[]{0.0f, 1.0f} : new float[]{0.0f, z ? 0.37f : 0.4f, 1.0f};
    }

    public String i(Context context, DamaiBaseActivity damaiBaseActivity, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1638533095") ? (String) ipChange.ipc$dispatch("1638533095", new Object[]{this, context, damaiBaseActivity, Integer.valueOf(i)}) : (context == null || damaiBaseActivity == null || damaiBaseActivity.isFinishing()) ? "" : context.getResources().getString(i);
    }

    public void j(Activity activity, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1095152788")) {
            ipChange.ipc$dispatch("1095152788", new Object[]{this, activity, str, str2, Integer.valueOf(i)});
        } else if (activity == null || TextUtils.isEmpty(str)) {
        } else {
            Intent intent = new Intent();
            intent.putExtra(TicketDetailExtFragment.PERFORM_ID, str);
            intent.putExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str2);
            intent.setClass(activity, TickletTransferManageActivity.class);
            activity.startActivityForResult(intent, i);
        }
    }

    public void k(Context context, String str, TicketAlipayCardBean ticketAlipayCardBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1724769580")) {
            ipChange.ipc$dispatch("-1724769580", new Object[]{this, context, str, ticketAlipayCardBean});
        } else if (TextUtils.isEmpty(str) || ticketAlipayCardBean == null || context == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(TicketDetailExtFragment.PERFORM_ID, str);
            bundle.putSerializable("ecertTipsInfo", ticketAlipayCardBean);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("ticklet_toalipayguide"));
        }
    }

    public void l(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343702057")) {
            ipChange.ipc$dispatch("1343702057", new Object[]{this, context, str, str2});
        } else if (context == null || TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(TicketDetailExtFragment.PERFORM_ID, str);
            bundle.putString(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str2);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.TICKET_E_SOUNENVIR));
        }
    }

    public void m(Context context, String str, String str2, boolean z, String str3, String str4, String str5, String str6, String str7, String str8, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505049389")) {
            ipChange.ipc$dispatch("1505049389", new Object[]{this, context, str, str2, Boolean.valueOf(z), str3, str4, str5, str6, str7, str8, Boolean.valueOf(z2)});
        } else if (z && (context instanceof DamaiBaseActivity)) {
            FissionUtil fissionUtil = new FissionUtil();
            fissionUtil.h((DamaiBaseActivity) context, fissionUtil.f(str3, str4, str5, "", str6, str8, str7, "4", "3", z2 ? "1" : "0"));
        } else {
            l(context, str, str2);
        }
    }

    public void n(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2050323637")) {
            ipChange.ipc$dispatch("-2050323637", new Object[]{this, context, str});
        } else if (TextUtils.isEmpty(str) || context == null) {
        } else {
            new Bundle().putString("url", str);
            DMNav.from(context).toUri(str);
        }
    }

    public void o(Context context, String str, String str2, String str3, String str4, String str5, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989505776")) {
            ipChange.ipc$dispatch("1989505776", new Object[]{this, context, str, str2, str3, str4, str5, Integer.valueOf(i)});
        } else if (context == null || TextUtils.isEmpty(str)) {
        } else {
            Intent intent = new Intent();
            intent.putExtra(TicketDetailExtFragment.PERFORM_ID, str);
            intent.putExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID, str2);
            intent.putExtra("chosenLat", str3);
            intent.putExtra("chosenLng", str4);
            intent.putExtra("venueName", str5);
            intent.putExtra(PushConstants.CLICK_TYPE, i);
            intent.putExtra("from", TickletVenueActivity.TICKLET_VENUE_FROM_MAP);
            intent.setClass(context, TickletVenueActivity.class);
            context.startActivity(intent);
        }
    }

    public void t(View view, Activity activity, TicketNftExtAttr ticketNftExtAttr, String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "650804835")) {
            ipChange.ipc$dispatch("650804835", new Object[]{this, view, activity, ticketNftExtAttr, str, str2, Boolean.valueOf(z)});
        } else if (activity == null) {
        } else {
            view.setClickable(false);
            DMShareMessage dMShareMessage = new DMShareMessage();
            dMShareMessage.shareImageStyle = GenerateImageUtil.STYLE_GENERATE_NFT_CARD_SHARE;
            dMShareMessage.windowTitle = "炫耀一下";
            dMShareMessage.sharePictureUrl = ticketNftExtAttr.coverURL;
            dMShareMessage.shareTitle = ticketNftExtAttr.title;
            dMShareMessage.userNick = str;
            dMShareMessage.ycCode = ticketNftExtAttr.acSn;
            dMShareMessage.shareLink = str2;
            dMShareMessage.vip = z;
            GenerateImageUtil.q(activity, dMShareMessage, false);
            GenerateImageUtil.G(new C9573a(this, view));
        }
    }

    public void u(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1236485573")) {
            ipChange.ipc$dispatch("1236485573", new Object[]{this, activity, str});
        } else if (activity == null || activity.isFinishing() || TextUtils.isEmpty(str)) {
        } else {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            PicInfo picInfo = new PicInfo();
            picInfo.setPicUrl(str);
            arrayList.add(picInfo);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("pic_info", arrayList);
            bundle.putInt("position", 0);
            DMNav.from(activity).withExtras(bundle).toUri(cs.e());
        }
    }
}
