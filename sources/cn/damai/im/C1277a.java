package cn.damai.im;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.im.AliMeUtil;
import com.alibaba.pictures.bricks.alime.IAliMeCouponFaq;
import com.alibaba.pictures.bricks.alime.OnAliMeListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.p4;

/* compiled from: Taobao */
/* renamed from: cn.damai.im.a */
/* loaded from: classes5.dex */
public class C1277a implements IAliMeCouponFaq {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.im.a$a */
    /* loaded from: classes5.dex */
    public class C1278a implements AliMeUtil.UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnAliMeListener a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ Context d;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.im.a$a$a */
        /* loaded from: classes5.dex */
        public class C1279a implements AliMeUtil.AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1279a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1256640067")) {
                    ipChange.ipc$dispatch("-1256640067", new Object[]{this});
                    return;
                }
                AliMeUtil.o();
                C1278a.this.a.onAliMeOpenFail();
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1291944425")) {
                    ipChange.ipc$dispatch("-1291944425", new Object[]{this, str});
                } else if (!TextUtils.isEmpty(str)) {
                    C1278a.this.a.onAliMeOpenSuccess();
                    C1278a c1278a = C1278a.this;
                    AliMeUtil.b(C1278a.this.d, AliMeUtil.h(AliMeUtil.SESSION_COUPON_ORDER_DETAIL, str, c1278a.b, c1278a.c));
                } else {
                    AliMeUtil.o();
                    C1278a.this.a.onAliMeOpenFail();
                }
            }
        }

        C1278a(C1277a c1277a, OnAliMeListener onAliMeListener, String str, String str2, Context context) {
            this.a = onAliMeListener;
            this.b = str;
            this.c = str2;
            this.d = context;
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-962054992")) {
                ipChange.ipc$dispatch("-962054992", new Object[]{this});
                return;
            }
            this.a.onAliMeOpenFail();
            AliMeUtil.o();
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1610317066")) {
                ipChange.ipc$dispatch("1610317066", new Object[]{this, Long.valueOf(j)});
            } else {
                AliMeUtil.e(j, AliMeUtil.SESSION_COUPON_ORDER_DETAIL, new C1279a());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.im.a$b */
    /* loaded from: classes5.dex */
    public class C1280b implements AliMeUtil.UserCodeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnAliMeListener a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ Context e;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.im.a$b$a */
        /* loaded from: classes5.dex */
        public class C1281a implements AliMeUtil.AliMeTokenListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C1281a() {
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onFailed() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "96669630")) {
                    ipChange.ipc$dispatch("96669630", new Object[]{this});
                    return;
                }
                AliMeUtil.o();
                C1280b.this.a.onAliMeOpenFail();
            }

            @Override // cn.damai.im.AliMeUtil.AliMeTokenListener
            public void onSuccess(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "658355830")) {
                    ipChange.ipc$dispatch("658355830", new Object[]{this, str});
                } else if (!TextUtils.isEmpty(str)) {
                    C1280b.this.a.onAliMeOpenSuccess();
                    C1280b c1280b = C1280b.this;
                    AliMeUtil.b(C1280b.this.e, AliMeUtil.g(AliMeUtil.SESSION_COUPON_ORDER_DETAIL, str, c1280b.b, c1280b.c, c1280b.d));
                } else {
                    AliMeUtil.o();
                    C1280b.this.a.onAliMeOpenFail();
                }
            }
        }

        C1280b(C1277a c1277a, OnAliMeListener onAliMeListener, String str, String str2, String str3, Context context) {
            this.a = onAliMeListener;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = context;
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "545496817")) {
                ipChange.ipc$dispatch("545496817", new Object[]{this});
                return;
            }
            this.a.onAliMeOpenFail();
            AliMeUtil.o();
        }

        @Override // cn.damai.im.AliMeUtil.UserCodeListener
        public void onSuccess(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1331340533")) {
                ipChange.ipc$dispatch("-1331340533", new Object[]{this, Long.valueOf(j)});
            } else {
                AliMeUtil.e(j, AliMeUtil.SESSION_COUPON_ORDER_DETAIL, new C1281a());
            }
        }
    }

    public static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-512960233")) {
            ipChange.ipc$dispatch("-512960233", new Object[0]);
        } else {
            p4.INSTANCE.b(new C1277a());
        }
    }

    @Override // com.alibaba.pictures.bricks.alime.IAliMeCouponFaq
    public void openAliMe4Fag(@NonNull Context context, String str, String str2, @NonNull OnAliMeListener onAliMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-667349602")) {
            ipChange.ipc$dispatch("-667349602", new Object[]{this, context, str, str2, onAliMeListener});
        } else {
            AliMeUtil.j(new C1278a(this, onAliMeListener, str, str2, context));
        }
    }

    @Override // com.alibaba.pictures.bricks.alime.IAliMeCouponFaq
    public void openAliMe4SingleFaq(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull OnAliMeListener onAliMeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "678495986")) {
            ipChange.ipc$dispatch("678495986", new Object[]{this, context, str, str2, str3, onAliMeListener});
        } else {
            AliMeUtil.j(new C1280b(this, onAliMeListener, str, str2, str3, context));
        }
    }
}
