package cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.seatbiz.view.svgview.core.helper.parser.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CSSStyle {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static int TYPE_CLASS = 102;
    public static int TYPE_ID = 153;
    public static int TYPE_TAG = 136;
    private String selector;
    private int selectorType;
    private HashMap<String, String> styleMap = new HashMap<>();

    public CSSStyle(@NonNull String str, @NonNull String str2) {
        if (str.startsWith(".")) {
            this.selector = str.replaceFirst(".", "");
            this.selectorType = TYPE_CLASS;
        } else if (str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
            this.selector = str.replaceFirst(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, "");
            this.selectorType = TYPE_ID;
        } else {
            this.selectorType = TYPE_TAG;
        }
        for (String str3 : str2.split(";")) {
            String[] split = str3.split(":");
            if (split.length == 2) {
                this.styleMap.put(split[0].trim(), split[1].trim());
            }
        }
    }

    @Nullable
    public static List<CSSStyle> parse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1161102296")) {
            return (List) ipChange.ipc$dispatch("-1161102296", new Object[]{str});
        }
        try {
            return parseInner(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<CSSStyle> parseInner(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "459217886")) {
            return (List) ipChange.ipc$dispatch("459217886", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.trim().split("[{}]");
        if (split.length <= 0 || split.length % 2 != 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < split.length; i += 2) {
            String trim = split[i].trim();
            String trim2 = split[i + 1].trim();
            if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2)) {
                arrayList.add(new CSSStyle(trim, trim2));
            }
        }
        return arrayList;
    }

    public Integer getColor(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1258397722") ? (Integer) ipChange.ipc$dispatch("-1258397722", new Object[]{this, str}) : parseColor(getString(str));
    }

    public String getSelector() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1596317843") ? (String) ipChange.ipc$dispatch("-1596317843", new Object[]{this}) : this.selector;
    }

    public int getSelectorType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "285480172") ? ((Integer) ipChange.ipc$dispatch("285480172", new Object[]{this})).intValue() : this.selectorType;
    }

    @Nullable
    public String getString(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1348319979") ? (String) ipChange.ipc$dispatch("-1348319979", new Object[]{this, str}) : this.styleMap.get(str);
    }

    public boolean isClassSelector() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1977656831") ? ((Boolean) ipChange.ipc$dispatch("1977656831", new Object[]{this})).booleanValue() : this.selectorType == TYPE_CLASS;
    }

    public boolean isIdSelector() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "71531746") ? ((Boolean) ipChange.ipc$dispatch("71531746", new Object[]{this})).booleanValue() : this.selectorType == TYPE_ID;
    }

    public boolean isNameEquals(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "806657308") ? ((Boolean) ipChange.ipc$dispatch("806657308", new Object[]{this, str})).booleanValue() : TextUtils.equals(str, this.selector);
    }

    public boolean isTagSelector() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1137441245") ? ((Boolean) ipChange.ipc$dispatch("1137441245", new Object[]{this})).booleanValue() : this.selectorType == TYPE_TAG;
    }

    public Integer parseColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "69899395")) {
            return (Integer) ipChange.ipc$dispatch("69899395", new Object[]{this, str});
        }
        try {
            return c.c(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
