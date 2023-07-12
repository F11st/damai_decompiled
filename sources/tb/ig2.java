package tb;

import com.taobao.agoo.TaobaoConstants;
import com.taobao.orange.OConstant;
import com.taobao.weex.ui.module.WXModalUIModule;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ig2 {
    public static final String ERR_CONNECT_FAILED = "ERR_CONNECT_FAILED";
    public static final String ERR_INVALID_REQUEST = "ERR_INVALID_REQUEST";
    public static final String UNKNOWN_STATUS = "unknown status";
    private static Map<String, String> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(MessageService.MSG_DB_COMPLETE, "Continue");
        a.put(OConstant.CODE_POINT_EXP_BIND_SERVICE, "Switching Protocol");
        a.put("200", WXModalUIModule.OK);
        a.put("201", "Created");
        a.put("202", "Accepted");
        a.put("203", "Non-Authoritative Information");
        a.put("204", "No Content");
        a.put("205", "Reset Content");
        a.put("206", "Partial Content");
        a.put("300", "Multiple Choice");
        a.put("301", "Moved Permanently");
        a.put("302", "Found");
        a.put("303", "See Other");
        a.put("304", "Not Modified");
        a.put("305", "Use Proxy");
        a.put("306", "unused");
        a.put("307", "Temporary Redirect");
        a.put("308", "Permanent Redirect");
        a.put("400", "Bad Request");
        a.put("401", "Unauthorized");
        a.put("402", "Payment Required");
        a.put("403", "Forbidden");
        a.put("404", "Not Found");
        a.put("405", "Method Not Allowed");
        a.put("406", "Not Acceptable");
        a.put("407", "Proxy Authentication Required");
        a.put("408", "Request Timeout");
        a.put("409", "Conflict");
        a.put("410", "Gone");
        a.put("411", "Length Required");
        a.put("412", "Precondition Failed");
        a.put("413", "Payload Too Large");
        a.put("414", "URI Too Long");
        a.put("415", "Unsupported Media Type");
        a.put("416", "Requested Range Not Satisfiable");
        a.put("417", "Expectation Failed");
        a.put("418", "I'm a teapot");
        a.put("421", "Misdirected Request");
        a.put("426", "Upgrade Required");
        a.put("428", "Precondition Required");
        a.put("429", "Too Many Requests");
        a.put("431", "Request Header Fields Too Large");
        a.put("500", "Internal Server Error");
        a.put("501", "Not Implemented");
        a.put("502", "Bad Gateway");
        a.put("503", "Service Unavailable");
        a.put(TaobaoConstants.DEVICETOKEN_ERROR, "Gateway Timeout");
        a.put("505", "HTTP Version Not Supported");
        a.put("506", "Variant Also Negotiates");
        a.put("507", "Variant Also Negotiates");
        a.put("511", "Network Authentication Required");
    }

    public static String a(String str) {
        return !a.containsKey(str) ? UNKNOWN_STATUS : a.get(str);
    }
}
