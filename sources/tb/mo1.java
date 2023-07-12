package tb;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ACache;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderDetailTicketService;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.PurchaseNotice;
import cn.damai.trade.newtradeorder.ui.orderdetail.ui.activity.OrderDetailActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class mo1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String NOTIFY_CANCEL_SELL = "order_detail_cancel_sell";
    public static final String NOTIFY_JUMP_TICKET_SERVICE = "order_detail_ticket_service";
    public static final String NOTIFY_OPEN_NOTICE_POP = "NOTIFY_OPEN_NOTICE_POP";
    public static final int ORDER_DETAIL_ADAPTER_ADDRESS = 1;
    public static final int ORDER_DETAIL_ADAPTER_DELIVERY = 6;
    public static final int ORDER_DETAIL_ADAPTER_GUIDE = 10;
    public static final int ORDER_DETAIL_ADAPTER_INVOICE = 8;
    public static final int ORDER_DETAIL_ADAPTER_KEFU = 7;
    public static final int ORDER_DETAIL_ADAPTER_LINE = 11;
    public static final int ORDER_DETAIL_ADAPTER_LOGIST = 0;
    public static final int ORDER_DETAIL_ADAPTER_PICKUP = 2;
    public static final int ORDER_DETAIL_ADAPTER_PRICE = 5;
    public static final int ORDER_DETAIL_ADAPTER_PROJECT = 4;
    public static final int ORDER_DETAIL_ADAPTER_SHARE = 12;
    public static final int ORDER_DETAIL_ADAPTER_TICKET_SERVICE = 3;
    public static final int ORDER_DETAIL_ADAPTER_TIME = 9;
    public static final int ORDER_DETAIL_TAG_CANCEL = 0;
    public static final int ORDER_DETAIL_TAG_LOGIST = 3;
    public static final int ORDER_DETAIL_TAG_MODIFYADDRESS = 4;
    public static final int ORDER_DETAIL_TAG_PAY = 1;
    public static final int ORDER_DETAIL_TAG_TICKET = 2;
    public static final String REFUND_CHECK_SERVICE = "order_detail_refund_check";
    public static final int REQUEST_ADDRESS_MODIFY = 1001;
    public static final int REQUEST_ADDRESS_SELECT = 1002;
    public static final int REQUEST_ADD_INVOICE = 1005;
    public static final int REQUEST_CHOOSE_SEAT_CODE = 1101;
    public static final int TIMER_TYPE_FIRST_PAY_CHOOSE_SEAT = 1;
    public static final int TIMER_TYPE_ORDER_DETAIL_PAY = 0;
    public static String a = null;
    public static boolean b = false;
    public static boolean c = true;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-733359920")) {
                ipChange.ipc$dispatch("-733359920", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            dialogInterface.dismiss();
            Context context = this.a;
            context.startActivity(wl1.a(context));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "236221103")) {
                ipChange.ipc$dispatch("236221103", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    public static List<ServiceNote> a(ArrayList<OrderDetailTicketService> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "446404164")) {
            return (List) ipChange.ipc$dispatch("446404164", new Object[]{arrayList});
        }
        ArrayList arrayList2 = new ArrayList();
        int e = wh2.e(arrayList);
        for (int i = 0; i < e; i++) {
            ServiceNote serviceNote = new ServiceNote();
            serviceNote.isSupport = "false";
            serviceNote.tagName = arrayList.get(i).ruleName;
            serviceNote.tagDesc = arrayList.get(i).contexts;
            serviceNote.tagDescWithStyle = arrayList.get(i).contextsWithStyle;
            serviceNote.imgUrl = arrayList.get(i).imgUrl;
            arrayList2.add(serviceNote);
        }
        return arrayList2;
    }

    public static int[] b(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838799324")) {
            return (int[]) ipChange.ipc$dispatch("-838799324", new Object[]{Long.valueOf(j)});
        }
        int[] iArr = new int[3];
        if (j >= 3600) {
            iArr[0] = (int) (j / 3600);
            int i = (int) (j - (iArr[0] * ACache.TIME_HOUR));
            iArr[1] = i / 60;
            iArr[2] = i % 60;
        } else {
            iArr[0] = 0;
            iArr[1] = (int) (j / 60);
            iArr[2] = (int) (j % 60);
        }
        return iArr;
    }

    public static boolean c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579872533")) {
            return ((Boolean) ipChange.ipc$dispatch("-579872533", new Object[]{str})).booleanValue();
        }
        return (TextUtils.isEmpty(str) || r30.a("yyyyMMdd").equals(z20.B(OrderDetailActivity.REFUND_POPWINDPW))) ? false : true;
    }

    public static void d(Context context, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2124298336")) {
            ipChange.ipc$dispatch("-2124298336", new Object[]{context, str, Boolean.valueOf(z)});
        } else if (str == null) {
        } else {
            if (z) {
                cn.damai.common.user.c.e().x(pp2.u().D(str));
            } else {
                cn.damai.common.user.c.e().x(pp2.u().R(str));
            }
            Bundle bundle = new Bundle();
            bundle.putString("orderid", str);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.M));
        }
    }

    public static void e(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-343925335")) {
            ipChange.ipc$dispatch("-343925335", new Object[]{context, str, str2, str3});
            return;
        }
        cn.damai.common.user.c.e().x(pp2.u().S(str));
        Bundle bundle = new Bundle();
        bundle.putString("orderId", str);
        bundle.putString("addressId", str3);
        bundle.putString("projectId", str2);
        DMNav.from(context).withExtras(bundle).forResult(1001).toUri(NavUri.b(cs.j));
    }

    public static void f(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "770589137")) {
            ipChange.ipc$dispatch("770589137", new Object[]{context, str, str2});
        } else if (str == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("orderId", str);
            bundle.putString("imageUrl", str2);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.i));
        }
    }

    public static void g(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1547737918")) {
            ipChange.ipc$dispatch("1547737918", new Object[]{context, str, str2});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IssueConstants.ProjectID, str);
        bundle.putString("projectImage", str2);
        DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.b));
    }

    public static void h(Context context, PurchaseNotice purchaseNotice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1464798011")) {
            ipChange.ipc$dispatch("1464798011", new Object[]{context, purchaseNotice});
        } else if (purchaseNotice != null) {
            cn.damai.common.user.c.e().x(pp2.u().L(purchaseNotice.orderId, purchaseNotice.itemId));
            Bundle bundle = new Bundle();
            bundle.putString("itemId", purchaseNotice.itemId);
            bundle.putString("conform", "false");
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b("purchase_notice"));
        }
    }

    public static void i(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1804881336")) {
            ipChange.ipc$dispatch("1804881336", new Object[]{context});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", 1);
        DMNav.from(context).withExtras(bundle).forResult(1002).toUri(NavUri.b(cs.d));
    }

    public static void j(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1595232134")) {
            ipChange.ipc$dispatch("-1595232134", new Object[]{context, str});
            return;
        }
        cn.damai.common.user.c.e().x(pp2.u().Q(str));
        Bundle bundle = new Bundle();
        bundle.putString("orderId", str);
        DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.Z));
    }

    public static void k(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906890750")) {
            ipChange.ipc$dispatch("1906890750", new Object[]{context, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            DMNav.from(context).withExtras(bundle).toUri(NavUri.b(cs.t));
        }
    }

    public static void l(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1622153454")) {
            ipChange.ipc$dispatch("-1622153454", new Object[]{context});
        } else if (wl1.b(context)) {
            if (context != null) {
                DMDialog dMDialog = new DMDialog(context);
                dMDialog.q("选座前将通过APP消息通知您，请您不要关闭通知哦");
                dMDialog.n("知道了", new b());
                dMDialog.show();
            }
        } else {
            DMDialog dMDialog2 = new DMDialog(context);
            dMDialog2.v(PurchaseConstants.NORMAL_WARNING_TITLE);
            dMDialog2.q("您未打开通知权限，为了保证第一时间收到选座通知，请您先打开通知权限");
            dMDialog2.n("打开", new a(context));
            dMDialog2.i("关闭", null);
            dMDialog2.show();
        }
    }

    public static String m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476407343")) {
            return (String) ipChange.ipc$dispatch("1476407343", new Object[]{str});
        }
        if (str != null && !str.equals("")) {
            try {
                return URLEncoder.encode(new String(str.getBytes(), "UTF-8"), "UTF-8");
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
