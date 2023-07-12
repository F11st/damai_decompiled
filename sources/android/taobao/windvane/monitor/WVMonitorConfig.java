package android.taobao.windvane.monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVMonitorConfig {
    public String v = "0";
    public StatRule stat = new StatRule();
    public boolean isErrorBlacklist = true;
    public List<ErrorRule> errorRule = new ArrayList();
    public double perfCheckSampleRate = 0.0d;
    public String perfCheckURL = "";

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class ErrorRule {
        public String url = "";
        public Pattern urlPattern = null;
        public String msg = "";
        public Pattern msgPattern = null;
        public String code = "";

        public ErrorRule() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class StatRule {
        public int resSample;
        public long onLoad = 0;
        public long onDomLoad = 0;
        public long resTime = 0;
        public boolean netstat = false;

        public StatRule() {
        }
    }

    public ErrorRule newErrorRuleInstance(String str, String str2, String str3) {
        ErrorRule errorRule = new ErrorRule();
        errorRule.url = str;
        errorRule.msg = str2;
        errorRule.code = str3;
        return errorRule;
    }
}
