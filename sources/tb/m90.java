package tb;

import android.text.TextUtils;
import cn.damai.tetris.v2.adpater.VDinamicXViewHolder;
import cn.damai.tetris.v2.util.LocalDxTemplate;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class m90 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Map<Integer, DXTemplateItem> a = new HashMap();
    private static Map<DXTemplateItem, Integer> b = new HashMap();
    private static Map<DXTemplateItem, List<WeakReference<VDinamicXViewHolder>>> c = new HashMap();
    private static Map<String, JSONObject> d = new HashMap();
    private static AtomicInteger e = new AtomicInteger(90000);

    public static void a(VDinamicXViewHolder vDinamicXViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1970241146")) {
            ipChange.ipc$dispatch("-1970241146", new Object[]{vDinamicXViewHolder});
            return;
        }
        DXTemplateItem dXTemplateItem = vDinamicXViewHolder.d;
        if (dXTemplateItem == null) {
            return;
        }
        List<WeakReference<VDinamicXViewHolder>> list = c.get(dXTemplateItem);
        if (list == null) {
            list = new ArrayList<>();
            c.put(vDinamicXViewHolder.d, list);
        }
        list.add(new WeakReference<>(vDinamicXViewHolder));
    }

    public static DXTemplateItem b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039757265")) {
            return (DXTemplateItem) ipChange.ipc$dispatch("-2039757265", new Object[]{str});
        }
        try {
            JSONObject c2 = c(str);
            if (c2 != null) {
                return (DXTemplateItem) JSON.parseObject(c2.toJSONString(), DXTemplateItem.class);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject c(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1850851288") ? (JSONObject) ipChange.ipc$dispatch("-1850851288", new Object[]{str}) : d.get(str);
    }

    public static List<String> d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243597543")) {
            return (List) ipChange.ipc$dispatch("1243597543", new Object[0]);
        }
        Map<String, JSONObject> map = d;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return new ArrayList(d.keySet());
    }

    public static DXTemplateItem e(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-727130645") ? (DXTemplateItem) ipChange.ipc$dispatch("-727130645", new Object[]{Integer.valueOf(i)}) : a.get(Integer.valueOf(i));
    }

    public static int f(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624626525")) {
            return ((Integer) ipChange.ipc$dispatch("-1624626525", new Object[]{jSONObject})).intValue();
        }
        DXTemplateItem dXTemplateItem = (DXTemplateItem) JSON.parseObject(jSONObject.toJSONString(), DXTemplateItem.class);
        if (dXTemplateItem == null || dXTemplateItem.name == null) {
            return 0;
        }
        if (b.containsKey(dXTemplateItem)) {
            return b.get(dXTemplateItem).intValue();
        }
        int andIncrement = e.getAndIncrement();
        a.put(Integer.valueOf(andIncrement), dXTemplateItem);
        b.put(dXTemplateItem, Integer.valueOf(andIncrement));
        return andIncrement;
    }

    public static boolean g(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "480381512") ? ((Boolean) ipChange.ipc$dispatch("480381512", new Object[]{str})).booleanValue() : d.containsKey(str);
    }

    public static void h(String str, LocalDxTemplate localDxTemplate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-799043807")) {
            ipChange.ipc$dispatch("-799043807", new Object[]{str, localDxTemplate});
        } else if (TextUtils.isEmpty(str) || localDxTemplate == null || TextUtils.isEmpty(localDxTemplate.name)) {
        } else {
            d.put(str, JSON.parseObject(JSON.toJSONString(localDxTemplate)));
        }
    }

    public static void i(DXTemplateItem dXTemplateItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-750057837")) {
            ipChange.ipc$dispatch("-750057837", new Object[]{dXTemplateItem});
        } else if (dXTemplateItem != null && c.containsKey(dXTemplateItem)) {
            List<WeakReference<VDinamicXViewHolder>> list = c.get(dXTemplateItem);
            if (list != null && list.size() > 0) {
                for (WeakReference<VDinamicXViewHolder> weakReference : list) {
                    VDinamicXViewHolder vDinamicXViewHolder = weakReference.get();
                    if (vDinamicXViewHolder != null && vDinamicXViewHolder.itemView.getParent() != null) {
                        vDinamicXViewHolder.h(dXTemplateItem);
                    }
                }
            }
            c.remove(dXTemplateItem);
        }
    }
}
