package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ExpressionDict {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MAX_LINE = 3;
    public static final int MAX_ROW = 8;
    private static volatile ExpressionDict dict;
    private static final Object mMutex = new Object();
    private String reg1;
    private String reg1LowLv;
    private String reg2;
    private String reg2LowLv;
    private Map<String, BeanExpression> resMap = new HashMap();
    private Map<String, BeanExpression> realMap = new HashMap();

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d0 A[Catch: IOException -> 0x00cc, TRY_LEAVE, TryCatch #5 {IOException -> 0x00cc, blocks: (B:43:0x00c8, B:47:0x00d0), top: B:54:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private ExpressionDict() {
        /*
            Method dump skipped, instructions count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionDict.<init>():void");
    }

    public static ExpressionDict getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1263278853")) {
            return (ExpressionDict) ipChange.ipc$dispatch("-1263278853", new Object[0]);
        }
        if (dict == null) {
            synchronized (mMutex) {
                if (dict == null) {
                    dict = new ExpressionDict();
                }
            }
        }
        return dict;
    }

    public static int getMaxIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "892037898") ? ((Integer) ipChange.ipc$dispatch("892037898", new Object[0])).intValue() : isNewExpression() ? 50 : 24;
    }

    public static String getPrefix() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "204806684") ? (String) ipChange.ipc$dispatch("204806684", new Object[0]) : isNewExpression() ? "n" : "f";
    }

    public static boolean isNewExpression() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1404823106")) {
            return ((Boolean) ipChange.ipc$dispatch("1404823106", new Object[0])).booleanValue();
        }
        return true;
    }

    private void parseXML(InputStream inputStream, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1049000635")) {
            ipChange.ipc$dispatch("1049000635", new Object[]{this, inputStream, Boolean.valueOf(z)});
            return;
        }
        try {
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("dict");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                BeanExpression beanExpression = new BeanExpression();
                NodeList childNodes = ((Element) elementsByTagName.item(i)).getChildNodes();
                for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                    Node item = childNodes.item(i2);
                    if (item.getNodeType() == 1) {
                        Element element = (Element) item;
                        if (element.getNodeName().equals("key")) {
                            String nodeValue = element.getFirstChild().getNodeValue();
                            beanExpression.setResName(nodeValue);
                            this.reg1 += nodeValue + "|";
                            if (!z) {
                                this.reg1LowLv += nodeValue + "|";
                            }
                        } else if (element.getNodeName().equals("string")) {
                            String nodeValue2 = element.getFirstChild().getNodeValue();
                            beanExpression.setRealName(nodeValue2);
                            if (nodeValue2.length() > 0) {
                                String str = "\\[" + nodeValue2.substring(1, nodeValue2.length() - 1) + "\\" + jn1.ARRAY_END_STR;
                                this.reg2 += str + "|";
                                if (!z) {
                                    this.reg2LowLv += str + "|";
                                }
                            }
                        }
                        this.resMap.put(beanExpression.getResName(), beanExpression);
                        this.realMap.put(beanExpression.getRealName(), beanExpression);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getConvertStringWithRealName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1272928043") ? (String) ipChange.ipc$dispatch("-1272928043", new Object[]{this, str}) : ExpressionManager.getInstance().getExpressionString(str, this.reg2, 1);
    }

    public String getConvertStringWithRealNameLowLv(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1513164299") ? (String) ipChange.ipc$dispatch("1513164299", new Object[]{this, str}) : ExpressionManager.getInstance().getExpressionString(str, this.reg2LowLv, 1);
    }

    public String getConvertStringWithResName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-413612959") ? (String) ipChange.ipc$dispatch("-413612959", new Object[]{this, str}) : ExpressionManager.getInstance().getExpressionString(str, this.reg1, 0);
    }

    public BeanExpression getExpressionByRealName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1350345178") ? (BeanExpression) ipChange.ipc$dispatch("1350345178", new Object[]{this, str}) : this.realMap.get(str);
    }

    public BeanExpression getExpressionByResName(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-30551104") ? (BeanExpression) ipChange.ipc$dispatch("-30551104", new Object[]{this, str}) : this.resMap.get(str);
    }
}
