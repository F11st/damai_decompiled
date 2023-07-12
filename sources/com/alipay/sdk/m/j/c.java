package com.alipay.sdk.m.j;

import android.taobao.windvane.service.WVEventId;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public enum c {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    ACTIVITY_NOT_START_EXIT(WVEventId.ZIPAPP_FAILED, "支付未完成"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(JosStatusCodes.RTN_CODE_COMMON_ERROR, "支付结果确认中");
    
    public int a;
    public String b;

    c(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public void a(int i) {
        this.a = i;
    }

    public int b() {
        return this.a;
    }

    public static c b(int i) {
        if (i != 4001) {
            if (i != 5000) {
                if (i != 8000) {
                    if (i != 9000) {
                        if (i != 6001) {
                            if (i != 6002) {
                                return FAILED;
                            }
                            return NETWORK_ERROR;
                        }
                        return CANCELED;
                    }
                    return SUCCEEDED;
                }
                return PAY_WAITTING;
            }
            return DOUBLE_REQUEST;
        }
        return PARAMS_ERROR;
    }

    public void a(String str) {
        this.b = str;
    }

    public String a() {
        return this.b;
    }
}
