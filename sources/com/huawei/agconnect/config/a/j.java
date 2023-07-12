package com.huawei.agconnect.config.a;

import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.youku.playerservice.axp.utils.Utils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class j {
    public static AGCRoutePolicy a(String str, String str2) {
        if (str != null) {
            char c = 65535;
            switch (str.hashCode()) {
                case 2155:
                    if (str.equals("CN")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2177:
                    if (str.equals("DE")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2627:
                    if (str.equals("RU")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2644:
                    if (str.equals("SG")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return AGCRoutePolicy.CHINA;
                case 1:
                    return AGCRoutePolicy.GERMANY;
                case 2:
                    return AGCRoutePolicy.RUSSIA;
                case 3:
                    return AGCRoutePolicy.SINGAPORE;
            }
        }
        if (str2 != null) {
            if (str2.contains("connect-drcn")) {
                return AGCRoutePolicy.CHINA;
            }
            if (str2.contains("connect-dre")) {
                return AGCRoutePolicy.GERMANY;
            }
            if (str2.contains("connect-drru")) {
                return AGCRoutePolicy.RUSSIA;
            }
            if (str2.contains("connect-dra")) {
                return AGCRoutePolicy.SINGAPORE;
            }
        }
        return AGCRoutePolicy.UNKNOWN;
    }

    public static String a(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        a(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }

    public static String a(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return "/" + str.substring(i);
    }

    public static Map<String, String> a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e(Utils.TAG, "Exception when closing the 'Closeable'.");
            }
        }
    }

    public static void a(Reader reader, Writer writer) throws IOException {
        a(reader, writer, new char[4096]);
    }

    public static void a(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            }
            writer.write(cArr, 0, read);
        }
    }
}
