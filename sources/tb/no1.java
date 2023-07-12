package tb;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import cn.damai.common.util.ToastUtil;
import cn.damai.pay.AliPayActivity;
import cn.damai.pay.UnionPayActivity;
import cn.damai.pay.WapPayActivity;
import cn.damai.trade.newtradeorder.ui.orderdetail.bean.OrderPayDTO;
import cn.damai.trade.newtradeorder.ui.orderdetail.net.api.OrderDetailConstantsApi;
import cn.damai.trade.oldtradeorder.ui.orderdetail.detail.model.OrderParmasResult;
import cn.damai.wxapi.DamaiWXPayActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class no1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String a = "支付方式调起失败，请稍后再试!";
    private static String b = "订单支付按钮接口回调数据支付链接为空";

    private static void a(Activity activity, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-840161592")) {
            ipChange.ipc$dispatch("-840161592", new Object[]{activity, str, str2});
        } else if (activity == null) {
        } else {
            if (TextUtils.isEmpty(str)) {
                ToastUtil.i(a);
                ap1.b(OrderDetailConstantsApi.API_ORDER_DETAIL_PAY_ORDER, null, null, str2, b);
                return;
            }
            Intent intent = new Intent(activity, AliPayActivity.class);
            intent.putExtra("orderid", str2);
            intent.putExtra("alipay_param", str);
            intent.putExtra("from", "OrderDetailPage");
            activity.startActivityForResult(intent, 2000);
        }
    }

    public static void b(Activity activity, OrderPayDTO orderPayDTO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-883433095")) {
            ipChange.ipc$dispatch("-883433095", new Object[]{activity, orderPayDTO});
        } else if (orderPayDTO == null) {
        } else {
            int i = orderPayDTO.payTypeId;
            if (i == 1) {
                a(activity, orderPayDTO.payUrl, orderPayDTO.orderId);
            } else if (i == 2) {
                e(activity, orderPayDTO.payUrl, orderPayDTO.orderId);
            } else if (i != 3) {
            } else {
                d(activity, WapPayActivity.TYPE_WALLET, orderPayDTO.payUrl, orderPayDTO.orderId);
            }
        }
    }

    public static void c(Activity activity, OrderParmasResult orderParmasResult, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2048361827")) {
            ipChange.ipc$dispatch("2048361827", new Object[]{activity, orderParmasResult, str});
        } else if (activity == null) {
        } else {
            if (orderParmasResult == null) {
                ToastUtil.i("支付方式调起失败，请稍后再试!");
                return;
            }
            switch (orderParmasResult.payId) {
                case 0:
                    if (!TextUtils.isEmpty(orderParmasResult.error)) {
                        ToastUtil.i(orderParmasResult.error);
                        return;
                    } else {
                        ToastUtil.i(a);
                        return;
                    }
                case 1:
                case 4:
                case 6:
                case 7:
                case 10:
                case 11:
                case 14:
                case 16:
                case 18:
                case 20:
                case 23:
                case 28:
                default:
                    ToastUtil.i("支付方式调起失败，请稍后再试!");
                    return;
                case 2:
                    a(activity, orderParmasResult.payParm, str);
                    return;
                case 3:
                    d(activity, WapPayActivity.TYPE_ZHIFUBAO, orderParmasResult.payParm, str);
                    return;
                case 5:
                    e(activity, orderParmasResult.payParm, str);
                    return;
                case 8:
                    Intent intent = new Intent(activity, UnionPayActivity.class);
                    intent.putExtra("uninpay_param", orderParmasResult.payParm);
                    intent.putExtra("orderid", str);
                    activity.startActivityForResult(intent, 2000);
                    return;
                case 9:
                    d(activity, WapPayActivity.TYPE_WALLET, orderParmasResult.payParm, str);
                    return;
                case 12:
                    d(activity, WapPayActivity.TYPE_CHINA_BANK, orderParmasResult.payParm, str);
                    return;
                case 13:
                    d(activity, WapPayActivity.TYPE_PUFA_BANK, orderParmasResult.payParm, str);
                    return;
                case 15:
                    d(activity, WapPayActivity.TYPE_ICBC_BANK, orderParmasResult.payParm, str);
                    return;
                case 17:
                    d(activity, WapPayActivity.TYPE_JD_PAY, orderParmasResult.payParm, str);
                    return;
                case 19:
                    d(activity, WapPayActivity.TYPE_UNION_BANK, orderParmasResult.payParm, str);
                    return;
                case 21:
                    d(activity, WapPayActivity.TYPE_PINGAN_BANK, orderParmasResult.payParm, str);
                    return;
                case 22:
                    d(activity, WapPayActivity.TYPE_JCB_BANK, orderParmasResult.payParm, str);
                    return;
                case 24:
                    d(activity, WapPayActivity.TYPE_PUFA_CARD_BANK, orderParmasResult.payParm, str);
                    return;
                case 25:
                    d(activity, WapPayActivity.TYPE_GUANGFA_CARD_BANK, orderParmasResult.payParm, str);
                    return;
                case 26:
                    d(activity, WapPayActivity.TYPE_AE_CARD, orderParmasResult.payParm, str);
                    return;
                case 27:
                    d(activity, WapPayActivity.TYPE_ANT_CHECK_LATER, orderParmasResult.payParm, str);
                    return;
                case 29:
                    d(activity, WapPayActivity.TYPE_GUANGDA_CARD_BANK, orderParmasResult.payParm, str);
                    return;
            }
        }
    }

    private static void d(Activity activity, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138241574")) {
            ipChange.ipc$dispatch("-138241574", new Object[]{activity, str, str2, str3});
        } else if (activity == null) {
        } else {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                Intent intent = new Intent(activity, WapPayActivity.class);
                intent.putExtra("type", str);
                intent.putExtra("orderid", str3);
                intent.putExtra("wappay_url", str2);
                intent.putExtra("from", "OrderDetailPage");
                activity.startActivityForResult(intent, 2000);
                return;
            }
            ToastUtil.i(a);
            ap1.b(OrderDetailConstantsApi.API_ORDER_DETAIL_PAY_ORDER, null, null, str3, b);
        }
    }

    private static void e(Activity activity, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2068307201")) {
            ipChange.ipc$dispatch("-2068307201", new Object[]{activity, str, str2});
        } else if (activity == null) {
        } else {
            if (TextUtils.isEmpty(str)) {
                ToastUtil.i(a);
                ap1.b(OrderDetailConstantsApi.API_ORDER_DETAIL_PAY_ORDER, null, null, str2, b);
                return;
            }
            Intent intent = new Intent(activity, DamaiWXPayActivity.class);
            intent.putExtra("orderId", str2);
            intent.putExtra("PayParm", str);
            intent.putExtra("from", "OrderDetailPage");
            activity.startActivityForResult(intent, 2000);
        }
    }
}
