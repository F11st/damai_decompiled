package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public interface ParserCallback {
    void characters(char[] cArr, int i, int i2);

    void endDocument();

    void endElement(int i, String str);

    void startDocument(int i);

    void startElement(c cVar);
}
