package cn.damai.trade.newtradeorder.ui.orderdetail.bean.hn;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class HnInvoiceDeliveryInfo {
    public static final String DELIVERY_TYPE_EXPRESS = "1";
    public static final String DELIVERY_TYPE_E_TICKET = "3";
    public static final String DELIVERY_TYPE_SELF_PICKUP = "2";
    public HnInvoiceDeliveryAddress deliveryAddress;
    public String deliveryMessage;
    public String deliveryWay;
    public String deliveryWayStr;
    public String postFee;
    public String threeSideMessage;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public static class HnInvoiceDeliveryAddress {
        private static transient /* synthetic */ IpChange $ipChange;
        public String address;
        public String cityId;
        public String cityName;
        public String consignee;
        public String districtId;
        public String districtName;
        public String email;
        public String mobile;
        public String prefix;
        public String provinceId;
        public String provinceName;
        public String streetId;
        public String streetName;
        public String telephone;
        public String zipCode;

        public String getDetailAddress() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1270679686")) {
                return (String) ipChange.ipc$dispatch("-1270679686", new Object[]{this});
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.provinceName)) {
                sb.append(this.provinceName);
            }
            if (!TextUtils.isEmpty(this.cityName)) {
                sb.append(this.cityName);
            }
            if (!TextUtils.isEmpty(this.districtName)) {
                sb.append(this.districtName);
            }
            if (!TextUtils.isEmpty(this.streetName)) {
                sb.append(this.streetName);
            }
            if (!TextUtils.isEmpty(this.address)) {
                sb.append(this.address);
            }
            return sb.toString();
        }
    }
}
