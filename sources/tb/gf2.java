package tb;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import androidx.core.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.taobao.weex.dom.WXAttr;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class gf2 {
    private String a;

    public gf2(WXComponent wXComponent) {
        this.a = "";
        if (wXComponent != null) {
            String s = s(wXComponent, "spmId");
            this.a = s;
            if (TextUtils.isEmpty(s) || !Pattern.matches("^[\\w\\-\\.\\/]+$", this.a)) {
                this.a = "0.0";
            }
        }
    }

    private ArrayList<WXComponent> b(WXComponent wXComponent, String str) {
        ArrayList<WXComponent> arrayList = new ArrayList<>();
        if (wXComponent instanceof WXVContainer) {
            WXVContainer wXVContainer = (WXVContainer) wXComponent;
            if (wXVContainer.getChildCount() > 0) {
                for (int i = 0; i < wXVContainer.getChildCount(); i++) {
                    WXComponent child = wXVContainer.getChild(i);
                    if (str.equals(child.getComponentType())) {
                        arrayList.add(child);
                    }
                    ArrayList<WXComponent> b = b(child, str);
                    if (b.size() > 0) {
                        arrayList.addAll(b);
                    }
                }
            }
        }
        return arrayList;
    }

    private Pair<String, String> c() {
        String[] split = this.a.split("\\.");
        return split.length == 2 ? new Pair<>(split[0], split[1]) : new Pair<>("0", "0");
    }

    private boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = -1;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        return i >= 0;
    }

    private int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void f(WXComponent wXComponent, String str, String str2) {
        wXComponent.getAttrs().put(str, (Object) str2);
    }

    private void g(WXComponent wXComponent, String str, boolean z) {
        String str2 = this.a;
        f(wXComponent, "dataSpmAnchorId", str);
        if (TextUtils.isEmpty(str2) || "0.0".equals(str2)) {
            return;
        }
        String t = t(wXComponent);
        if (z) {
            return;
        }
        q(wXComponent, p(t, str));
    }

    private void h(WXComponent wXComponent, boolean z) {
        String str = this.a;
        String t = t(wXComponent);
        String k = k(t);
        int i = 0;
        if (!TextUtils.isEmpty(str) && str.split("\\.").length == 2) {
            String[] strArr = new String[3];
            strArr[0] = str;
            strArr[1] = "0";
            strArr[2] = TextUtils.isEmpty(i(wXComponent)) ? "0" : i(wXComponent);
            String str2 = "";
            while (i < 3) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(strArr[i]);
                sb.append(i == 2 ? "" : ".");
                str2 = sb.toString();
                i++;
            }
            g(wXComponent, str2, z);
        } else if (TextUtils.isEmpty(t) || TextUtils.isEmpty(k)) {
        } else {
            q(wXComponent, t.replaceAll("&?\\bspm=[^&#]*", "").replaceAll("&{2,}", "&").replaceFirst("\\?&", "?").replaceFirst("\\?$", "").replaceFirst("\\?#", Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
        }
    }

    private String i(WXComponent wXComponent) {
        Pair<String, String> c = c();
        if (c.first.equals("0") && c.second.equals("0")) {
            return "0";
        }
        String s = s(wXComponent, "dataSpm");
        return (TextUtils.isEmpty(s) || !Pattern.matches("^d\\w+$", s)) ? "" : s;
    }

    private ArrayList<WXComponent> j(WXComponent wXComponent, boolean z) {
        boolean z2;
        ArrayList<WXComponent> arrayList = new ArrayList<>();
        ArrayList<WXComponent> b = b(wXComponent, "a");
        int size = b.size();
        for (int i = 0; i < size; i++) {
            WXComponent wXComponent2 = b.get(i);
            WXComponent wXComponent3 = wXComponent2;
            do {
                wXComponent3 = wXComponent3.getParent();
                if (wXComponent3 == null || wXComponent3 == wXComponent) {
                    z2 = false;
                    break;
                }
            } while (TextUtils.isEmpty(s(wXComponent3, "dataSpm")));
            z2 = true;
            if (!z2) {
                String s = s(wXComponent2, "dataAutoSpmd");
                if (!z && !"t".equals(s)) {
                    arrayList.add(wXComponent2);
                } else if (z && "t".equals(s)) {
                    arrayList.add(wXComponent2);
                }
            }
        }
        return arrayList;
    }

    private String k(String str) {
        Matcher matcher = Pattern.compile("&?\\bspm=([^&#]*)").matcher(str);
        return (!matcher.find() || matcher.groupCount() <= 0) ? "" : matcher.group(1);
    }

    private void l(WXComponent wXComponent, String str, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            str = s(wXComponent, "dataSpm");
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList<WXComponent> j = j(wXComponent, z2);
        if (j.size() == 0) {
            return;
        }
        String str2 = this.a;
        if (Pattern.matches("^[\\w\\-\\*]+(\\.[\\w\\-\\*\\/]+)?$", str2)) {
            if (!str.contains(".")) {
                if (!str2.contains(".")) {
                    str2 = str2 + ".0";
                }
                str = str2 + '.' + str;
            } else if (!str.startsWith(str2)) {
                String[] split = str2.split("\\.");
                String[] split2 = str.split("\\.");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    split2[i] = split[i];
                }
                int i2 = 0;
                while (i2 < split2.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(split2[i2]);
                    sb.append(i2 == split2.length + (-1) ? "" : ".");
                    str = sb.toString();
                    i2++;
                }
            }
        }
        if (Pattern.matches("^[\\w\\-\\*]+\\.[\\w\\-\\*\\/]+\\.[\\w\\-\\*\\/]+$", str)) {
            String str3 = z2 ? "dataAutoSpmdMaxIdx" : "dataSpmMaxIdx";
            int e = e(s(wXComponent, str3));
            int size = j.size();
            for (int i3 = 0; i3 < size; i3++) {
                WXComponent wXComponent2 = j.get(i3);
                String t = t(wXComponent2);
                if (z2 || !TextUtils.isEmpty(t)) {
                    String s = s(wXComponent2, "dataSpmAnchorId");
                    if (!TextUtils.isEmpty(s) && m(s)) {
                        g(wXComponent2, s, z);
                    } else {
                        e++;
                        String i4 = i(wXComponent2);
                        if (TextUtils.isEmpty(i4)) {
                            i4 = String.valueOf(e);
                        }
                        if (z2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("at");
                            sb2.append(d(i4) ? 1000 : "");
                            sb2.append(i4);
                            i4 = sb2.toString();
                        }
                        g(wXComponent2, str + '.' + i4, z);
                    }
                }
            }
            f(wXComponent, str3, String.valueOf(e));
        }
    }

    private boolean m(String str) {
        String str2;
        String str3 = this.a;
        String[] split = str.split("\\.");
        String str4 = "";
        if (split.length > 1) {
            str4 = split[0];
            str2 = split[1];
        } else {
            str2 = "";
        }
        return (str4 + '.' + str2).equals(str3);
    }

    private void n(WXComponent wXComponent, boolean z) {
        String s = s(wXComponent, "dataSpmAnchorId");
        if (!TextUtils.isEmpty(s) && m(s)) {
            g(wXComponent, s, z);
            return;
        }
        Pair<String, WXComponent> o = o(wXComponent.getParent());
        String str = o.first;
        if (TextUtils.isEmpty(str)) {
            h(wXComponent, z);
            return;
        }
        l(o.second, str, z, false);
        l(o.second, str, z, true);
    }

    private Pair<String, WXComponent> o(WXComponent wXComponent) {
        String str;
        WXVContainer wXVContainer = wXComponent;
        while (wXVContainer != null && !WXComponent.ROOT.equals(wXVContainer.getRef())) {
            str = s(wXVContainer, "dataSpm");
            if (!TextUtils.isEmpty(str)) {
                wXComponent = wXVContainer;
                break;
            }
            wXVContainer = wXVContainer.getParent();
            if (wXVContainer == null) {
                break;
            }
        }
        str = "";
        if (!TextUtils.isEmpty(str) && !Pattern.matches("^[\\w\\-\\.\\/]+$", str)) {
            str = "0";
        }
        return new Pair<>(str, wXComponent);
    }

    private String p(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        if (TextUtils.isEmpty(str) || str.startsWith("tel:")) {
            return str;
        }
        Matcher matcher = Pattern.compile("&?\\bspm=[^&#]*").matcher(str);
        String str7 = "&";
        String str8 = "";
        if (!TextUtils.isEmpty(str) && matcher.find()) {
            str = str.replaceAll("&?\\bspm=[^&#]*", "").replaceAll("&{2,}", "&").replaceFirst("\\?&", "?").replaceFirst("\\?$", "");
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.contains(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            if (split.length > 0) {
                str = split[0];
            }
            str3 = "";
            int i = 1;
            while (i < split.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(split[i]);
                sb.append(i == split.length - 1 ? "" : Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                str3 = sb.toString();
                i++;
            }
        } else {
            str3 = "";
        }
        String[] split2 = str.split("\\?");
        int length = split2.length - 1;
        String[] split3 = split2[0].split(WVUtils.URL_SEPARATOR);
        split3[split3.length - 1].split("/");
        if (length <= 0 || split2.length <= 0) {
            str4 = str;
            str5 = "";
        } else {
            str5 = split2[split2.length - 1];
            str4 = "";
            int i2 = 0;
            while (i2 < split2.length - 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(split2[i2]);
                sb2.append(i2 == (split2.length - 1) - 1 ? "" : "?");
                str4 = sb2.toString();
                i2++;
            }
        }
        if (!TextUtils.isEmpty(str5) && length > 1 && str5.indexOf(38) == -1 && str5.indexOf(37) != -1) {
            str7 = "%26";
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str4);
        sb3.append("?spm=");
        sb3.append("");
        sb3.append(str2);
        if (TextUtils.isEmpty(str5)) {
            str6 = "";
        } else {
            str6 = str7 + str5;
        }
        sb3.append(str6);
        if (!TextUtils.isEmpty(str3)) {
            str8 = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str3;
        }
        sb3.append(str8);
        return sb3.toString();
    }

    private void q(WXComponent wXComponent, String str) {
        f(wXComponent, "href", str);
    }

    private String r(WXComponent wXComponent) {
        return wXComponent.getComponentType();
    }

    private String s(WXComponent wXComponent, String str) {
        WXAttr attrs = wXComponent.getAttrs();
        if (attrs != null) {
            Object obj = attrs.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return null;
    }

    private String t(WXComponent wXComponent) {
        try {
            return s(wXComponent, "href").trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public void a(WXComponent wXComponent) {
        while (wXComponent != null) {
            String r = r(wXComponent);
            if (TextUtils.isEmpty(r)) {
                return;
            }
            if (!"a".equals(r) && !ExifInterface.GPS_MEASUREMENT_IN_PROGRESS.equals(r) && !"AREA".equals(r)) {
                if (WXComponent.ROOT.equals(r)) {
                    return;
                }
                wXComponent = wXComponent.getParent();
            } else {
                n(wXComponent, false);
                return;
            }
        }
    }
}
