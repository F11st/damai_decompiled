package tb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ju1 {
    private static long a = 100000;

    private static void a(Element element) {
        if (element == null) {
            return;
        }
        if ("text".equalsIgnoreCase(element.getNodeName())) {
            element.setAttribute("id", "tId_" + a);
            a = a + 1;
            return;
        }
        String attribute = element.getAttribute("floorId");
        if (TextUtils.isEmpty(attribute)) {
            return;
        }
        String str = "floorId_" + attribute;
        String attribute2 = element.getAttribute("row_id");
        if (TextUtils.isEmpty(attribute2)) {
            element.setAttribute("id", str);
            return;
        }
        element.setAttribute("id", str + "_rowId_" + attribute2);
    }

    private static void b(NodeList nodeList) {
        if (nodeList == null || nodeList.getLength() == 0) {
            return;
        }
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            if (item.getNodeType() == 1) {
                NodeList childNodes = item.getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    b(childNodes);
                } else {
                    a((Element) item);
                }
            }
        }
    }

    public static String c(String str) {
        return "floorId_" + str;
    }

    public static String d(String str, String str2) {
        return "floorId_" + str + "_rowId_" + str2;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("floorId_");
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("tId_");
    }

    @Nullable
    public static String[] g(String str) {
        int indexOf;
        String str2;
        String str3 = null;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("floorId_")) >= 0) {
            String[] strArr = new String[2];
            int indexOf2 = str.indexOf("_rowId_");
            if (indexOf2 < 0) {
                str2 = str.substring(indexOf + 8);
            } else {
                String substring = str.substring(indexOf + 8, indexOf2);
                str3 = str.substring(indexOf2 + 7);
                str2 = substring;
            }
            strArr[0] = str2;
            strArr[1] = str3;
            return strArr;
        }
        return null;
    }

    public static String h(InputStream inputStream) throws Exception {
        Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
        NodeList childNodes = parse.getDocumentElement().getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == 1) {
                NodeList childNodes2 = item.getChildNodes();
                if (childNodes2 != null && childNodes2.getLength() > 0) {
                    if (childNodes2.getLength() == 1 && childNodes2.item(0).getNodeType() == 3) {
                        a((Element) item);
                    } else {
                        b(childNodes2);
                    }
                } else {
                    a((Element) item);
                }
            }
        }
        try {
            StringWriter stringWriter = new StringWriter();
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("omit-xml-declaration", "no");
            newTransformer.setOutputProperty("method", "xml");
            newTransformer.setOutputProperty("indent", BQCCameraParam.VALUE_YES);
            newTransformer.setOutputProperty("encoding", "UTF-8");
            newTransformer.transform(new DOMSource(parse), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error converting to String", e);
        }
    }
}
