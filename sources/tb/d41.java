package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.address.bean.AddressBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class d41 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String INVOICE_DELIVERY_NOTIFY_ = "1";
    public static final String INVOICE_DELIVERY_TYPE_COMPANY = "2";
    public static final String INVOICE_DELIVERY_TYPE_DELIVERY = "1";
    public static final int INVOICE_DETAIL_VIEW_DELIVERY = 1;
    public static final int INVOICE_DETAIL_VIEW_LOGISTICS = 2;
    public static final int INVOICE_DETAIL_VIEW_TYPE = 0;
    public static final int INVOICE_TITLE_COMPANY = 2;
    public static final int INVOICE_TITLE_PERSONAL = 1;
    public static final String ORDER_DETAIL_INVOICE_ADD = "1";
    public static final String ORDER_DETAIL_INVOICE_DETAIL = "2";
    public static final String ORDER_DETAIL_INVOICE_DISENABLE = "0";
    public static final String ORDER_DETAIL_INVOICE_TIP = "3";
    public static final int REQUEST_CODE_ADD_ADDRESS = 10001;

    public static String a(AddressBean addressBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1431535016")) {
            return (String) ipChange.ipc$dispatch("-1431535016", new Object[]{addressBean});
        }
        if (addressBean == null) {
            return "";
        }
        String province = addressBean.getProvince();
        String city = addressBean.getCity();
        String county = addressBean.getCounty();
        String street = addressBean.getStreet();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(county) && !TextUtils.isEmpty(addressBean.getCountyCode()) && !addressBean.getCityCode().equals("-1")) {
            if (county.equals(city)) {
                sb.append(province);
                sb.append(city);
                sb.append(addressBean.getAddressDetail());
            } else if (!TextUtils.isEmpty(street) && !street.equals("暂不选择")) {
                sb.append(province);
                sb.append(city);
                sb.append(county);
                sb.append(street);
                sb.append(addressBean.getAddressDetail());
            } else {
                sb.append(province);
                sb.append(city);
                sb.append(county);
                sb.append(addressBean.getAddressDetail());
            }
        } else {
            sb.append(province);
            sb.append(city);
            sb.append(addressBean.getAddressDetail());
        }
        return sb.toString();
    }
}
