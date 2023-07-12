package cn.damai.wxapi.weixin.accesstoken;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.wxapi.qrcode.WeiXinQRCodeBean;
import cn.damai.wxapi.qrcode.WeiXinQRCodeRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class WeiXinQRCodeUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int SHARE_WX_JUMUSHARE_SUCCESS = 400;
    public static final int SHARE_WX_QRCODE_FAILED = 500;
    public static final int SHARE_WX_QRCODE_FINISHED = 300;
    private static WeiXinQRCodeUtils mInstance;

    private WeiXinQRCodeUtils() {
    }

    public static WeiXinQRCodeUtils getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "117092381")) {
            return (WeiXinQRCodeUtils) ipChange.ipc$dispatch("117092381", new Object[0]);
        }
        if (mInstance == null) {
            synchronized (WeiXinQRCodeUtils.class) {
                if (mInstance == null) {
                    mInstance = new WeiXinQRCodeUtils();
                }
            }
        }
        return mInstance;
    }

    public void getWeiXinQRCodeFromServer(String str, String str2, final Handler handler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300841139")) {
            ipChange.ipc$dispatch("1300841139", new Object[]{this, str, str2, handler});
            return;
        }
        WeiXinQRCodeRequest weiXinQRCodeRequest = new WeiXinQRCodeRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", str);
            jSONObject.put("page", str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        weiXinQRCodeRequest.qrcodeParam = jSONObject.toString();
        weiXinQRCodeRequest.request(new DMMtopRequestListener<WeiXinQRCodeBean>(WeiXinQRCodeBean.class) { // from class: cn.damai.wxapi.weixin.accesstoken.WeiXinQRCodeUtils.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1878412724")) {
                    ipChange2.ipc$dispatch("-1878412724", new Object[]{this, str3, str4});
                    return;
                }
                Message message = new Message();
                message.what = 500;
                message.obj = str3;
                handler.sendMessage(message);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(WeiXinQRCodeBean weiXinQRCodeBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1400003440")) {
                    ipChange2.ipc$dispatch("1400003440", new Object[]{this, weiXinQRCodeBean});
                } else if (weiXinQRCodeBean == null || TextUtils.isEmpty(weiXinQRCodeBean.getQrcodeURL())) {
                } else {
                    Message message = new Message();
                    message.what = 300;
                    message.obj = weiXinQRCodeBean.getQrcodeURL();
                    handler.sendMessage(message);
                }
            }
        });
    }
}
