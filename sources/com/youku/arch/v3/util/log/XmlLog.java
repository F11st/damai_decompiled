package com.youku.arch.v3.util.log;

import android.util.Log;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.LogUtil;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class XmlLog {
    private static transient /* synthetic */ IpChange $ipChange;

    private static String formatXML(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1650304065")) {
            return (String) ipChange.ipc$dispatch("1650304065", new Object[]{str});
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", BQCCameraParam.VALUE_YES);
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            return streamResult.getWriter().toString().replaceFirst(jn1.G, ">\n");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static void printXml(String str, String str2, String str3) {
        String[] split;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469122103")) {
            ipChange.ipc$dispatch("-469122103", new Object[]{str, str2, str3});
            return;
        }
        String str4 = str2 != null ? str3 + StringUtils.LF + formatXML(str2) : str3 + LogUtil.NULL_TIPS;
        LogUtil.printLine(str, true);
        for (String str5 : str4.split(LogUtil.LINE_SEPARATOR)) {
            if (!LogUtil.isEmpty(str5)) {
                Log.d(str, "║ " + str5);
            }
        }
        LogUtil.printLine(str, false);
    }
}
