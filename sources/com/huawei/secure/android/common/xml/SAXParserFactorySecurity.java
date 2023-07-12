package com.huawei.secure.android.common.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SAXParserFactorySecurity {
    public static SAXParserFactory getInstance() throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException, NullPointerException {
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setFeature("http://xml.org/sax/features/namespaces", true);
        newInstance.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
        newInstance.setFeature("http://xml.org/sax/features/validation", false);
        newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
        newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        newInstance.setFeature("http://xml.org/sax/features/string-interning", true);
        return newInstance;
    }
}
