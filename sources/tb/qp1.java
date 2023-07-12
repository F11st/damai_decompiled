package tb;

import android.os.Bundle;
import cn.damai.common.nav.DMNav;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.channel.params.PageArgument;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Set;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class qp1 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final qp1 INSTANCE = new qp1();
    @NotNull
    private static final ArrayList<String> a;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(DMNav.KRequestCodeReferrer);
        arrayList.add("referrer");
        a = arrayList;
    }

    private qp1() {
    }

    @NotNull
    public final Bundle a(@Nullable Bundle bundle) {
        Set<String> keySet;
        boolean n;
        boolean q;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1862200802")) {
            return (Bundle) ipChange.ipc$dispatch("1862200802", new Object[]{this, bundle});
        }
        Bundle bundle2 = new Bundle();
        PageArgument pageArgument = new PageArgument();
        JSONObject jSONObject = new JSONObject();
        if (bundle != null && (keySet = bundle.keySet()) != null) {
            b41.h(keySet, "keySet()");
            for (String str : keySet) {
                Object obj = bundle.get(str);
                n = C8604o.n("patternName", str, true);
                String str2 = null;
                if (n) {
                    pageArgument.patternName = obj != null ? obj.toString() : null;
                } else {
                    q = C8604o.q("patternVersion", str, true);
                    if (q) {
                        pageArgument.patternVersion = obj != null ? obj.toString() : null;
                    } else if (!a.contains(str)) {
                        jSONObject.put((JSONObject) str, obj != null ? obj.toString() : null);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Bundle 入参： ");
                sb.append(str);
                sb.append(" = ");
                if (obj != null) {
                    str2 = obj.toString();
                }
                sb.append(str2);
                sb.append(' ');
                nd.a(sb.toString(), "PageArg");
            }
        }
        pageArgument.args = jSONObject.toJSONString();
        bundle2.putParcelable("KEY_PAGE_ARGS", pageArgument);
        return bundle2;
    }

    @Nullable
    public final PageArgument b(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549888919")) {
            return (PageArgument) ipChange.ipc$dispatch("-1549888919", new Object[]{this, bundle});
        }
        if (bundle != null) {
            try {
                return (PageArgument) bundle.getParcelable("KEY_PAGE_ARGS");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
