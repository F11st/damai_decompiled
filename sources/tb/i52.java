package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import cn.damai.commonbusiness.seatbiz.view.model.DMSVG;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class i52 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static BaseSVG a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217306755")) {
            return (BaseSVG) ipChange.ipc$dispatch("1217306755", new Object[]{inputStream});
        }
        try {
            com.caverock.androidsvg.f a = new m52().a(inputStream, js.b());
            DMSVG dmsvg = new DMSVG();
            dmsvg.initSVGData(a);
            return dmsvg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BaseSVG b(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773101477")) {
            return (BaseSVG) ipChange.ipc$dispatch("1773101477", new Object[]{inputStream});
        }
        try {
            return new cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.b().b(inputStream).a();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BaseSVG c(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1979745818")) {
            return (BaseSVG) ipChange.ipc$dispatch("1979745818", new Object[]{inputStream});
        }
        if (js.c()) {
            return a(inputStream);
        }
        return b(inputStream);
    }

    public static BaseSVG d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1447434809")) {
            return (BaseSVG) ipChange.ipc$dispatch("1447434809", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(new ByteArrayInputStream(str.getBytes()));
    }
}
