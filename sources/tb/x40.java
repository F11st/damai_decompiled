package tb;

import android.util.Xml;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class x40 {
    private static transient /* synthetic */ IpChange $ipChange;
    private cc a;

    x40(cc ccVar) {
        this.a = ccVar;
    }

    public static x40 b(cc ccVar) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1975264688") ? (x40) ipChange.ipc$dispatch("-1975264688", new Object[]{ccVar}) : new x40(ccVar);
    }

    public w40 a(InputStream inputStream) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1693420720")) {
            return (w40) ipChange.ipc$dispatch("1693420720", new Object[]{this, inputStream});
        }
        w40 w40Var = new w40();
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(inputStream, "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("kantai".equalsIgnoreCase(name)) {
                        y40 y40Var = new y40(this.a);
                        String attributeValue = newPullParser.getAttributeValue(0);
                        y40Var.j(attributeValue);
                        String attributeValue2 = newPullParser.getAttributeValue(1);
                        y40Var.u.clear();
                        y40Var.u.addAll(l91.a(attributeValue2, ","));
                        String attributeValue3 = newPullParser.getAttributeValue(2);
                        y40Var.v.clear();
                        y40Var.v.addAll(l91.a(attributeValue3, ","));
                        String attributeValue4 = newPullParser.getAttributeValue(3);
                        y40Var.w.clear();
                        y40Var.w.addAll(l91.a(attributeValue4, ","));
                        String attributeValue5 = newPullParser.getAttributeValue(4);
                        y40Var.x.clear();
                        y40Var.x.addAll(l91.a(attributeValue5, ","));
                        String attributeValue6 = newPullParser.getAttributeValue(5);
                        y40Var.y.clear();
                        y40Var.y.addAll(l91.a(attributeValue6, ","));
                        String attributeValue7 = newPullParser.getAttributeValue(6);
                        y40Var.z.clear();
                        y40Var.z.addAll(l91.a(attributeValue7, ","));
                        String attributeValue8 = newPullParser.getAttributeValue(7);
                        y40Var.A.clear();
                        y40Var.A.addAll(l91.a(attributeValue8, ","));
                        String attributeValue9 = newPullParser.getAttributeValue(8);
                        y40Var.B.clear();
                        y40Var.B.addAll(l91.a(attributeValue9, ","));
                        String attributeValue10 = newPullParser.getAttributeValue(9);
                        y40Var.C.clear();
                        y40Var.C.addAll(l91.a(attributeValue10, ","));
                        String attributeValue11 = newPullParser.getAttributeValue(10);
                        y40Var.D.clear();
                        y40Var.D.addAll(l91.a(attributeValue11, ","));
                        String attributeValue12 = newPullParser.getAttributeValue(11);
                        y40Var.E.clear();
                        y40Var.E.addAll(l91.a(attributeValue12, ","));
                        y40Var.i(newPullParser.getAttributeValue(12));
                        w40Var.a.put(attributeValue, y40Var);
                    } else if ("head".equalsIgnoreCase(name)) {
                        String attributeValue13 = newPullParser.getAttributeValue(0);
                        String attributeValue14 = newPullParser.getAttributeValue(1);
                        if (!cc.c().equalsIgnoreCase(attributeValue13)) {
                            C9269io.a("binrary", ".bin is not Quantum Binary!");
                        } else if (!cc.f().equalsIgnoreCase(attributeValue14)) {
                            C9269io.a("binrary", ".bin version is not support!");
                        }
                    } else if ("dict".equalsIgnoreCase(name)) {
                        LinkedHashMap<String, ArrayList<String>> linkedHashMap = new LinkedHashMap<>();
                        String attributeValue15 = newPullParser.getAttributeValue(0);
                        String attributeValue16 = newPullParser.getAttributeValue(1);
                        String attributeValue17 = newPullParser.getAttributeValue(2);
                        linkedHashMap.put("floorDict", l91.b(attributeValue15, ","));
                        linkedHashMap.put("rowDict", l91.b(attributeValue16, ","));
                        linkedHashMap.put("chairDict", l91.b(attributeValue17, ","));
                        c50 d = c50.d();
                        d.c(linkedHashMap);
                        w40Var.b = d;
                    }
                } else if (eventType != 3) {
                    continue;
                } else {
                    String name2 = newPullParser.getName();
                    if (!"kantai".equalsIgnoreCase(name2) && !"head".equalsIgnoreCase(name2)) {
                        "dict".equalsIgnoreCase(name2);
                    }
                }
            }
        } catch (Throwable th) {
            C9269io.b("binary", "DecodeParser error:" + th.toString());
            th.printStackTrace();
        }
        return w40Var;
    }
}
