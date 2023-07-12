package tb;

import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p80 {
    public static final String ERROR_CODE_BYTE_READ_ERROR = "byteReadError";
    public static final String ERROR_CODE_BYTE_TO_PARSER_ERROR = "byteToParserError";
    public static final String ERROR_CODE_EVENT_HANDLER_EXCEPTION = "eventHandlerException";
    public static final String ERROR_CODE_EVENT_HANDLER_NOT_FOUND = "eventHandlerNotFound";
    public static final String ERROR_CODE_OTHER = "other";
    public static final String ERROR_CODE_TEMPLATE_FILE_EMPTY = "templateFileEmpty";
    public static final String ERROR_CODE_TEMPLATE_FILE_LOST = "templateFileLost";
    public static final String ERROR_CODE_TEMPLATE_INFO_ERROR = "templateInfoError";
    public static final String ERROR_CODE_TEMPLATE_NOT_FOUND = "templateNotFound";
    public static final String ERROR_CODE_TEMPLATE_PARSER_EXCEPTION = "parserException";
    public static final String ERROR_CODE_TEMPLATE_PARSER_NOT_FOUND = "parserNotFound";
    public static final String ERROR_CODE_VIEW_EXCEPTION = "viewException";
    public static final String ERROR_CODE_VIEW_NOT_FOUND = "viewNotFound";
    public static final String ERROR_CODE_XML_BLOCK_CONSTRUCTOR_REFLECT_ERROR = "xmlBlockConstructorReflectError";
    public static final String ERROR_CODE_XML_RES_PARSER_ERROR = "xmlResourceParserError";
    private HashMap<String, String> a = new HashMap<>();
    private String b;

    public p80(String str) {
        this.b = str;
    }

    public void a(String str, String str2) {
        if (!this.a.containsKey(str)) {
            HashMap<String, String> hashMap = this.a;
            hashMap.put(str, this.b + ":" + str2 + ";");
        }
        HashMap<String, String> hashMap2 = this.a;
        hashMap2.put(str, this.a.get(str) + str2 + ";");
    }

    public String b() {
        return this.a.toString();
    }

    public HashMap<String, String> c() {
        return this.a;
    }

    public boolean d() {
        return this.a.isEmpty();
    }
}
