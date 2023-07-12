package cn.damai.ultron.utils;

import android.app.Activity;
import android.content.DialogInterface;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.uikit.view.DMThemeDialog;
import cn.damai.ultron.view.activity.DmOrderActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.ib0;
import tb.mb0;
import tb.xj1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DmUltronRequestErrorUtils {
    private static transient /* synthetic */ IpChange $ipChange;
    private static DmUltronRequestErrorUtils d;
    private BizType a;
    private DefaultError b = DefaultError.ERROR_LAYOUT;
    private NetError c = NetError.NO_NETWORK_TOAST;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum BizType {
        BUILD,
        ADJUEST,
        CREATE
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum DefaultError {
        ERROR_LAYOUT,
        DIALOG
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum ErrorType {
        NO_NETWORK,
        NO_NETWORK_TOAST,
        TOAST,
        BACK,
        BACK_SEAT,
        ORDER_LIST,
        BUILD_ADJUST_LIMIT,
        CREATE_LIMIT,
        ITEM_EXPIRED,
        DEFAULT_ERROR_LAYOUT,
        DEFAULT_DIALOG,
        LIMIT_DIALOG,
        NONE
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum NetError {
        NO_NETWORK,
        NO_NETWORK_TOAST
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ultron.utils.DmUltronRequestErrorUtils$a */
    /* loaded from: classes17.dex */
    public class DialogInterface$OnClickListenerC2644a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        DialogInterface$OnClickListenerC2644a(DmUltronRequestErrorUtils dmUltronRequestErrorUtils, DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2128211671")) {
                ipChange.ipc$dispatch("2128211671", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                this.a.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ultron.utils.DmUltronRequestErrorUtils$b */
    /* loaded from: classes17.dex */
    public class DialogInterface$OnClickListenerC2645b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        DialogInterface$OnClickListenerC2645b(DmUltronRequestErrorUtils dmUltronRequestErrorUtils, DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1197174602")) {
                ipChange.ipc$dispatch("-1197174602", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DMNav.from(this.a).toUri(NavUri.b("my_showorder"));
            this.a.finish();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ultron.utils.DmUltronRequestErrorUtils$c */
    /* loaded from: classes17.dex */
    public class DialogInterface$OnClickListenerC2646c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        DialogInterface$OnClickListenerC2646c(DmUltronRequestErrorUtils dmUltronRequestErrorUtils, DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-227593579")) {
                ipChange.ipc$dispatch("-227593579", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                this.a.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.ultron.utils.DmUltronRequestErrorUtils$d */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class C2647d {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ErrorType.values().length];
            b = iArr;
            try {
                iArr[ErrorType.NO_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ErrorType.NO_NETWORK_TOAST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ErrorType.TOAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ErrorType.BACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[ErrorType.BACK_SEAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[ErrorType.DEFAULT_DIALOG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[ErrorType.ORDER_LIST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[ErrorType.BUILD_ADJUST_LIMIT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[ErrorType.CREATE_LIMIT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[ErrorType.ITEM_EXPIRED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[ErrorType.DEFAULT_ERROR_LAYOUT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[ErrorType.LIMIT_DIALOG.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr2 = new int[BizType.values().length];
            a = iArr2;
            try {
                iArr2[BizType.BUILD.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[BizType.ADJUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[BizType.CREATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    private ErrorType c(Activity activity, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212183200")) {
            return (ErrorType) ipChange.ipc$dispatch("-1212183200", new Object[]{this, activity, str});
        }
        if (!xj1.b(activity)) {
            NetError netError = this.c;
            if (netError == NetError.NO_NETWORK) {
                return ErrorType.NO_NETWORK;
            }
            if (netError == NetError.NO_NETWORK_TOAST) {
                return ErrorType.NO_NETWORK_TOAST;
            }
        }
        int i = C2647d.a[this.a.ordinal()];
        if (i == 1 || i == 2) {
            for (String str2 : ib0.d) {
                if (str2.equalsIgnoreCase(str)) {
                    return ErrorType.ITEM_EXPIRED;
                }
            }
        } else if (i == 3) {
            if (str.startsWith("B-00203-4")) {
                return ErrorType.ORDER_LIST;
            }
            if (str.startsWith("B-00203-1")) {
                return ErrorType.TOAST;
            }
            if (!"CUSTOM_REASON_CANNOT_BUY_C".equals(str) && !"CUSTOM_REASON_CANNOT_BUY".equals(str) && !"F-10007-10-10-025".equals(str) && !"MAX_BUY_QUANTITY_EXCEEDED".equals(str)) {
                return ErrorType.BACK;
            }
            return ErrorType.LIMIT_DIALOG;
        }
        for (String str3 : ib0.e) {
            if (str3.equalsIgnoreCase(str)) {
                return ErrorType.DEFAULT_DIALOG;
            }
        }
        if (this.b == DefaultError.ERROR_LAYOUT) {
            return ErrorType.DEFAULT_ERROR_LAYOUT;
        }
        return ErrorType.DEFAULT_DIALOG;
    }

    public static synchronized DmUltronRequestErrorUtils d() {
        synchronized (DmUltronRequestErrorUtils.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "615395929")) {
                return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("615395929", new Object[0]);
            }
            if (d == null) {
                d = new DmUltronRequestErrorUtils();
            }
            return d;
        }
    }

    private boolean e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597828222")) {
            return ((Boolean) ipChange.ipc$dispatch("597828222", new Object[]{this, str})).booleanValue();
        }
        if (mb0.f().g(str)) {
            return false;
        }
        for (String str2 : ib0.d) {
            if (str2.equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cn.damai.ultron.utils.DmUltronRequestErrorUtils a(cn.damai.ultron.view.activity.DmOrderActivity r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.ultron.utils.DmUltronRequestErrorUtils.$ipChange
            java.lang.String r1 = "2094986285"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L23
            r2 = 5
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r6 = 0
            r2[r6] = r8
            r2[r5] = r9
            r2[r4] = r10
            r2[r3] = r11
            r9 = 4
            r2[r9] = r12
            java.lang.Object r9 = r0.ipc$dispatch(r1, r2)
            cn.damai.ultron.utils.DmUltronRequestErrorUtils r9 = (cn.damai.ultron.utils.DmUltronRequestErrorUtils) r9
            return r9
        L23:
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L55
            int[] r1 = cn.damai.ultron.utils.DmUltronRequestErrorUtils.C2647d.a
            cn.damai.ultron.utils.DmUltronRequestErrorUtils$BizType r2 = r8.a
            int r2 = r2.ordinal()
            r1 = r1[r2]
            if (r1 == r5) goto L48
            if (r1 == r4) goto L48
            if (r1 == r3) goto L3b
            goto L55
        L3b:
            java.lang.String r1 = tb.ib0.b(r10)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L55
            cn.damai.ultron.utils.DmUltronRequestErrorUtils$ErrorType r0 = cn.damai.ultron.utils.DmUltronRequestErrorUtils.ErrorType.BACK
            goto L56
        L48:
            java.lang.String r1 = tb.ib0.a(r10)
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L55
            cn.damai.ultron.utils.DmUltronRequestErrorUtils$ErrorType r0 = cn.damai.ultron.utils.DmUltronRequestErrorUtils.ErrorType.BUILD_ADJUST_LIMIT
            goto L56
        L55:
            r1 = r11
        L56:
            r4 = r0
            if (r4 == 0) goto L62
            r2 = r8
            r3 = r9
            r5 = r10
            r6 = r1
            r7 = r12
            r2.b(r3, r4, r5, r6, r7)
            goto L95
        L62:
            cn.damai.ultron.utils.DmUltronRequestErrorUtils$ErrorType r4 = r8.c(r9, r10)
            r2 = r8
            r3 = r9
            r5 = r10
            r6 = r1
            r7 = r12
            r2.b(r3, r4, r5, r6, r7)
            boolean r11 = r8.e(r10)
            if (r11 == 0) goto L95
            cn.damai.ultron.utils.DmUltronRequestErrorUtils$BizType r11 = r8.a
            cn.damai.ultron.utils.DmUltronRequestErrorUtils$BizType r0 = cn.damai.ultron.utils.DmUltronRequestErrorUtils.BizType.BUILD
            if (r11 != r0) goto L82
            tb.mb0 r11 = tb.mb0.f()
            r11.c(r9, r12, r10, r1)
            goto L95
        L82:
            cn.damai.ultron.utils.DmUltronRequestErrorUtils$BizType r0 = cn.damai.ultron.utils.DmUltronRequestErrorUtils.BizType.ADJUEST
            if (r11 != r0) goto L8e
            tb.mb0 r11 = tb.mb0.f()
            r11.b(r9, r12, r10, r1)
            goto L95
        L8e:
            tb.mb0 r11 = tb.mb0.f()
            r11.d(r9, r12, r10, r1)
        L95:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.ultron.utils.DmUltronRequestErrorUtils.a(cn.damai.ultron.view.activity.DmOrderActivity, java.lang.String, java.lang.String, java.lang.String):cn.damai.ultron.utils.DmUltronRequestErrorUtils");
    }

    public void b(DmOrderActivity dmOrderActivity, ErrorType errorType, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-78504397")) {
            ipChange.ipc$dispatch("-78504397", new Object[]{this, dmOrderActivity, errorType, str, str2, str3});
            return;
        }
        switch (C2647d.b[errorType.ordinal()]) {
            case 1:
                if (dmOrderActivity != null) {
                    dmOrderActivity.dmErrorViewHolder.f(this.a, 0, str, str2, str3);
                    return;
                }
                return;
            case 2:
                ToastUtil.i("网络异常，请稍后重试");
                return;
            case 3:
                ToastUtil.i(str2);
                return;
            case 4:
            case 5:
            case 6:
                if (dmOrderActivity != null) {
                    new DMThemeDialog(dmOrderActivity).r(DMThemeDialog.DMDialogTheme.THEME_ORDER_FAILURE).k(str2).i("我知道了", new DialogInterface$OnClickListenerC2644a(this, dmOrderActivity)).show();
                    return;
                }
                return;
            case 7:
                if (dmOrderActivity != null) {
                    new DMThemeDialog(dmOrderActivity).r(DMThemeDialog.DMDialogTheme.THEME_ORDER_FAILURE).k(str2).i("查看订单", new DialogInterface$OnClickListenerC2645b(this, dmOrderActivity)).show();
                    return;
                }
                return;
            case 8:
            case 9:
                if (dmOrderActivity != null) {
                    dmOrderActivity.dmErrorViewHolder.f(this.a, 5, str, str2, str3);
                    return;
                }
                return;
            case 10:
                if (dmOrderActivity != null) {
                    dmOrderActivity.dmErrorViewHolder.f(this.a, 6, str, str2, str3);
                    return;
                }
                return;
            case 11:
                if (dmOrderActivity != null) {
                    dmOrderActivity.dmErrorViewHolder.f(this.a, 0, str, str2, str3);
                    return;
                }
                return;
            case 12:
                if (dmOrderActivity != null) {
                    new DMThemeDialog(dmOrderActivity).r(DMThemeDialog.DMDialogTheme.THEME_ORDER_FAILURE).k("亲，您当前账户或购票人已超出限购数量，您可以调整数量、更换购票账户或购票人").i("我知道了", new DialogInterface$OnClickListenerC2646c(this, dmOrderActivity)).show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public DmUltronRequestErrorUtils f(BizType bizType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939325312")) {
            return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("1939325312", new Object[]{this, bizType});
        }
        this.a = bizType;
        return this;
    }

    public DmUltronRequestErrorUtils g(DefaultError defaultError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634190628")) {
            return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("-1634190628", new Object[]{this, defaultError});
        }
        this.b = defaultError;
        return this;
    }

    public DmUltronRequestErrorUtils h(NetError netError) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056285844")) {
            return (DmUltronRequestErrorUtils) ipChange.ipc$dispatch("2056285844", new Object[]{this, netError});
        }
        this.c = netError;
        return this;
    }
}
