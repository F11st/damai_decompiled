package com.alibaba.poplayerconsole;

import android.taobao.windvane.jsbridge.WVCallMethodContext;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.alibaba.poplayer.utils.ConsoleLogger$Level;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LogCache {
    public static final String LOG_TAG_ALL = "All";
    public static final String LOG_TAG_WVPLUGIN = "WindVane";
    public static final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    public static int a = 100;
    private static final LinkedList<LogDO> b = new LinkedList<>();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class LogDO implements Serializable {
        private static final long serialVersionUID = 1;
        public final String content;
        public final String data = LogCache.df.format(new Date());
        public final String lineNumber;
        public final ConsoleLogger$Level msgLevel;
        public final String source;
        public final String tag;

        public LogDO(String str, String str2, ConsoleLogger$Level consoleLogger$Level, String str3, String str4) {
            this.tag = str;
            this.content = str2;
            this.msgLevel = consoleLogger$Level;
            this.source = str3;
            this.lineNumber = str4;
        }

        public Spannable toSpannableString() {
            SpannableString spannableString = new SpannableString(toString());
            spannableString.setSpan(new ForegroundColorSpan(this.msgLevel.color), 0, spannableString.length(), 17);
            return spannableString;
        }

        public String toString() {
            return String.format("%s%s/%s:%s", this.data, this.msgLevel, this.tag, this.content);
        }
    }

    public static final void a(LogDO logDO) {
        int i = a;
        LinkedList<LogDO> linkedList = b;
        if (i == linkedList.size()) {
            linkedList.remove();
        }
        linkedList.add(logDO);
    }

    public static void b() {
        b.clear();
    }

    public static LogDO c(String str, ConsoleLogger$Level consoleLogger$Level) {
        if (str.startsWith("Console")) {
            char charAt = str.split("\\.")[1].charAt(0);
            return new LogDO("Console", str.substring(String.format("%s.%s.", "Console", Character.valueOf(charAt)).length()), ConsoleLogger$Level.find(charAt), null, null);
        } else if (str.startsWith("WindVane")) {
            return new LogDO("WindVane", str.substring(String.format("%s.", "WindVane").length()), consoleLogger$Level, null, null);
        } else {
            return new LogDO("PopLayer", str, consoleLogger$Level, null, null);
        }
    }

    public static String d(WVCallMethodContext wVCallMethodContext, String str) {
        return TextUtils.isEmpty(str) ? String.format("%s.WVPlugin{%s}.method{%s}.call.params{%s}", "WindVane", wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext.params) : String.format("%s.WVPlugin{%s}.method{%s}.callback.params{%s}.result{%s}", "WindVane", wVCallMethodContext.objectName, wVCallMethodContext.methodName, wVCallMethodContext.params, str);
    }

    public static List<LogDO> e(String str) {
        if (!TextUtils.isEmpty(str) && !LOG_TAG_ALL.equals(str)) {
            ArrayList arrayList = new ArrayList();
            Iterator<LogDO> it = b.iterator();
            while (it.hasNext()) {
                LogDO next = it.next();
                if (str.equals(next.tag)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
        return b;
    }

    public static void f(int i) {
        if (i < 0 || i > 500) {
            i = a;
        }
        a = i;
    }
}
