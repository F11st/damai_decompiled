package com.taobao.android.dinamicx.monitor;

import com.taobao.android.dinamicx.DinamicXEngine;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.d90;
import tb.nz;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXFontSize {
    private static volatile DXFontSize c;
    private static final Map<String, String> d = new ConcurrentHashMap(512);
    private static final Map<Double, Double> e = new ConcurrentHashMap(512);
    private IDXFontSize a;
    private int b = 1;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface IDXFontSize {
        int getCurrentFontSizeLevel();

        double sizeByFactor(double d);

        double sizeByFactor(double d, double d2);

        double sizeByFactor(double d, double d2, double d3, double d4, double d5);

        void updateFontSize(int i);
    }

    public static DXFontSize b() {
        if (c == null) {
            synchronized (DXFontSize.class) {
                if (c == null) {
                    c = new DXFontSize();
                    return c;
                }
                return c;
            }
        }
        return c;
    }

    public int a() {
        IDXFontSize iDXFontSize = this.a;
        if (iDXFontSize == null) {
            return this.b;
        }
        return iDXFontSize.getCurrentFontSizeLevel();
    }

    public Double c(Double d2) {
        if (this.a == null) {
            return d2;
        }
        Map<Double, Double> map = e;
        if (map.containsKey(d2)) {
            return map.get(d2);
        }
        Double valueOf = Double.valueOf(new BigDecimal(Double.valueOf(this.a.sizeByFactor(d2.doubleValue())).doubleValue()).setScale(1, 4).doubleValue());
        map.put(d2, valueOf);
        return valueOf;
    }

    public Double d(Double d2, Double d3) {
        return this.b == 4 ? d3 : c(d2);
    }

    public Double e(Double d2, Double d3, Double d4, Double d5, Double d6) {
        int i = this.b;
        return i == 4 ? d6 : i == 3 ? d5 : i == 2 ? d4 : i == 0 ? d2 : d3;
    }

    public String f(String str) {
        String format;
        if (this.a == null) {
            return str;
        }
        Map<String, String> map = d;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        try {
            if (str.contains(d90.DIMEN_SUFFIX_NP)) {
                Double valueOf = Double.valueOf(this.a.sizeByFactor(Double.valueOf(Double.parseDouble(str.replace(d90.DIMEN_SUFFIX_NP, ""))).doubleValue()));
                String str2 = String.format(Locale.CHINA, "%.1f", valueOf) + d90.DIMEN_SUFFIX_NP;
                map.put(str, str2);
                return str2;
            }
            if (str.contains("ap")) {
                String replace = str.replace("ap", "");
                format = String.format(Locale.CHINA, "%.1f", Double.valueOf(this.a.sizeByFactor(Double.valueOf(Double.parseDouble(replace)).doubleValue())));
                map.put(str, format);
                map.put(replace, format);
            } else {
                format = String.format(Locale.CHINA, "%.1f", Double.valueOf(this.a.sizeByFactor(Double.valueOf(Double.parseDouble(str)).doubleValue())));
                map.put(str, format);
                map.put(str + "ap", format);
            }
            return format;
        } catch (NumberFormatException unused) {
            if (DinamicXEngine.x()) {
                nz.u(nz.TAG, str, "写法错误，解析出错");
            }
            d.put(str, str);
            return str;
        }
    }

    public String g(String str, String str2) {
        return this.b == 4 ? str2 : f(str);
    }

    public String h(String str, String str2, String str3, String str4, String str5) {
        int i = this.b;
        return i == 4 ? str5 : i == 3 ? str4 : i == 2 ? str3 : i == 0 ? str : str2;
    }

    public void i(int i) {
        IDXFontSize iDXFontSize = this.a;
        if (iDXFontSize != null) {
            iDXFontSize.updateFontSize(i);
        }
    }
}
