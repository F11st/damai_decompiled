package android.taobao.windvane.urlintercept;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVURLInterceptData {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class RuleData {
        public String pattern;
        public int rutype;
        public int target;
        public boolean needdecode = true;
        public Map<String, Integer> indexp = new HashMap();
        public Map<String, String> namep = new HashMap();
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class URLInfo {
        public int code;
        public String feature;
        public Map<String, String> params = new HashMap();
        public String rule;
        public String url;
    }
}
