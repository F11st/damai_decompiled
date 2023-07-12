package com.caverock.ext;

import android.text.TextUtils;
import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SVGTransform {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class SVGParseException extends SAXException {
        SVGParseException(String str) {
            super(str);
        }

        SVGParseException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static float a(InputStream inputStream) throws SVGParseException {
        float f = 1.0f;
        if (inputStream == null) {
            return 1.0f;
        }
        try {
            inputStream.reset();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            newPullParser.setInput(inputStream, null);
            boolean z = false;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.nextToken()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if (newPullParser.getPrefix() != null) {
                        name = newPullParser.getPrefix() + jn1.CONDITION_IF_MIDDLE + name;
                    }
                    String name2 = newPullParser.getName();
                    if (name2.length() > 0) {
                        name = name2;
                    }
                    if ("svg".equals(name)) {
                        int attributeCount = newPullParser.getAttributeCount();
                        int i = 0;
                        while (true) {
                            if (i >= attributeCount) {
                                break;
                            } else if ("transform".equals(newPullParser.getAttributeName(i))) {
                                f = b(newPullParser.getAttributeValue(i));
                                break;
                            } else {
                                i++;
                            }
                        }
                        z = true;
                    }
                }
                if (z) {
                    break;
                }
            }
            return f;
        } catch (IOException e) {
            throw new SVGParseException("Stream error", e);
        } catch (XmlPullParserException e2) {
            throw new SVGParseException("XML parser problem", e2);
        }
    }

    private static float b(String str) {
        int indexOf;
        String substring;
        int indexOf2;
        if (!TextUtils.isEmpty(str)) {
            String replaceAll = str.replaceAll(" ", "");
            if (replaceAll.contains("scale(") && (indexOf = replaceAll.indexOf("scale(")) < replaceAll.length() && (indexOf2 = (substring = replaceAll.substring(indexOf)).indexOf(jn1.BRACKET_END_STR)) != -1) {
                try {
                    return Float.parseFloat(substring.substring(6, indexOf2));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return 1.0f;
    }
}
