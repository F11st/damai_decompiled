package tb;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.address.bean.AddressBean;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.pay.AliPayActivity;
import cn.damai.ultron.secondpage.chooseaddress.DmLoginReceiver;
import cn.damai.ultron.view.activity.DmOrderActivity;
import cn.damai.ultron.view.bean.DmUltronPayResultBean;
import cn.damai.wxapi.DamaiWXPayActivity;
import cn.damai.wxapi.WXPayEntryActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.ultron.common.model.IDMComponent;
import mtopsdk.common.util.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class lb0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static String a(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749348182")) {
            return (String) ipChange.ipc$dispatch("1749348182", new Object[]{addressBean});
        }
        StringBuilder sb = new StringBuilder();
        String str = "";
        String county = (StringUtils.isEmpty(addressBean.getCounty()) || addressBean.getCity().equals(addressBean.getCounty())) ? "" : addressBean.getCounty();
        if (!StringUtils.isEmpty(addressBean.getStreet()) && !"暂不选择".equals(addressBean.getStreet())) {
            str = addressBean.getStreet();
        }
        sb.append(addressBean.getProvince());
        sb.append(addressBean.getCity());
        sb.append(county);
        sb.append(str);
        sb.append(addressBean.getAddressDetail());
        return sb.toString();
    }

    public static IdCardTypes b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-719951801")) {
            return (IdCardTypes) ipChange.ipc$dispatch("-719951801", new Object[]{Integer.valueOf(i)});
        }
        IdCardTypes idCardTypes = new IdCardTypes();
        idCardTypes.id = i;
        return idCardTypes;
    }

    public static void c(Activity activity, DmUltronPayResultBean dmUltronPayResultBean) {
        IDMComponent g;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1677531645")) {
            ipChange.ipc$dispatch("1677531645", new Object[]{activity, dmUltronPayResultBean});
            return;
        }
        String str = dmUltronPayResultBean.bizOrderId;
        String str2 = dmUltronPayResultBean.nextUrl;
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                bundle.putString("orderId", str);
                bundle.putBoolean("payResult", true);
                bundle.putBoolean(AliPayActivity.FROM_HN_CRETE_ORDER_PAGE, true);
                DMNav.from(activity).clearTop().withExtras(bundle).toUri(NavUri.b("my_hn_orderdetails"));
                activity.finish();
                return;
            }
            DMNav.from(activity).withExtras(new Bundle()).toUri(NavUri.b("my_showorder"));
            activity.finish();
            return;
        }
        DmOrderActivity dmOrderActivity = (DmOrderActivity) activity;
        int e = (dmOrderActivity == null || (g = fb0.g(dmOrderActivity.getPresenter())) == null) ? 0 : new va0(g).e();
        if (e == 1) {
            Intent intent = new Intent(activity, AliPayActivity.class);
            intent.putExtra("alipay_param", str2);
            intent.putExtra("orderid", str);
            intent.putExtra("projectId", ua0.b(activity));
            intent.putExtra("from", AliPayActivity.FROM_HN_CRETE_ORDER_PAGE);
            activity.startActivityForResult(intent, 38);
        } else if (e == 2) {
            WXPayEntryActivity.context = activity;
            Intent intent2 = new Intent(activity, DamaiWXPayActivity.class);
            intent2.putExtra("orderId", str);
            intent2.putExtra("PayParm", str2);
            intent2.putExtra("from", AliPayActivity.FROM_HN_CRETE_ORDER_PAGE);
            activity.startActivityForResult(intent2, 38);
        } else {
            Toast.makeText(activity, "暂不支持该支付方式，请选择其他方式支付", 0).show();
        }
    }

    public static DmLoginReceiver d(Activity activity, DmLoginReceiver.OnLoginListener onLoginListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390030381")) {
            return (DmLoginReceiver) ipChange.ipc$dispatch("390030381", new Object[]{activity, onLoginListener});
        }
        DmLoginReceiver dmLoginReceiver = new DmLoginReceiver(onLoginListener);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(vb1.BROADCAST_LOGIN_SUCCESS);
        intentFilter.addAction(vb1.BROADCAST_LOGOUT_SUCCESS);
        activity.registerReceiver(dmLoginReceiver, intentFilter);
        return dmLoginReceiver;
    }
}
