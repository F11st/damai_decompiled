package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import cn.damai.commonbusiness.seatbiz.view.model.DMSVG;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.C0863b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.caverock.androidsvg.C4761f;
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
            C4761f a = new m52().a(inputStream, C9318js.b());
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
            return new C0863b().b(inputStream).a();
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
        if (C9318js.c()) {
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
