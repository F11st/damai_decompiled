package tb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.preview.DXTemplatePreviewActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class od0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-690776960")) {
            ipChange.ipc$dispatch("-690776960", new Object[]{context, str});
            return;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                str = URLDecoder.decode(str, "UTF-8");
            }
            cb1.c("DynamicxPreviewUtil", str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str) || !str.contains("templateMock=")) {
            return;
        }
        String substring = str.substring(str.indexOf(61) + 1);
        cb1.c("DynamicxPreviewUtil", "params:" + substring);
        Intent intent = new Intent(context, DXTemplatePreviewActivity.class);
        intent.putExtra(DXTemplatePreviewActivity.PREVIEW_INFO, substring.substring(substring.indexOf("=") + 1));
        context.startActivity(intent);
    }
}
