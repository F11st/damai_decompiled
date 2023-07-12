package cn.damai.common.uploader;

import android.content.Context;
import cn.damai.common.AppConfig;
import com.alibaba.pictures.uploader.FileUploader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class AusConfigCenter {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void initUploader(Context context) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "601866675")) {
            ipChange.ipc$dispatch("601866675", new Object[]{context});
            return;
        }
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            i = 2;
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            i = 1;
        }
        FileUploader.s(context, Integer.valueOf(i), AppConfig.c(), "");
        FileUploader.B(Boolean.valueOf(AppConfig.v()));
    }
}
