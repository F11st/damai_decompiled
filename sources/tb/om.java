package tb;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import cn.damai.tetris.core.config.ComponentConfig;
import cn.damai.tetris.core.ut.TrackProxy;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class om {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "ConfigManager";
    static om e;
    private Context d;
    AtomicInteger c = new AtomicInteger(101);
    private final ConcurrentHashMap<String, Integer> a = new ConcurrentHashMap<>();
    private final SparseArray<Pair<String, ComponentConfig>> b = new SparseArray<>(10);

    private om(Context context) {
        this.d = context;
        f(context);
    }

    private ComponentConfig b(int i, ComponentConfig componentConfig, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2143991632")) {
            return (ComponentConfig) ipChange.ipc$dispatch("2143991632", new Object[]{this, Integer.valueOf(i), componentConfig, str});
        }
        jb1.a(TAG, "getComponentConfigFromRaw start. ");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.d.getResources().openRawResource(this.d.getResources().getIdentifier(str, "raw", this.d.getPackageName()))));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            JSONObject jSONObject = (JSONObject) JSON.parse(stringBuffer.toString());
            if (jSONObject != null && jSONObject.containsKey("component")) {
                componentConfig = (ComponentConfig) JSON.parseObject(jSONObject.getString("component"), ComponentConfig.class);
            }
            this.b.put(i, new Pair<>(str, componentConfig));
        } catch (Exception e2) {
            e2.printStackTrace();
            jb1.b(TAG, "getComponentConfigFromRaw." + e2.getMessage());
        }
        jb1.a(TAG, "getComponentConfigFromRaw. retirm config : " + componentConfig);
        jb1.a(TAG, "getComponentConfigFromRaw cost : " + (System.currentTimeMillis() - currentTimeMillis));
        return componentConfig;
    }

    public static om c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "277953815")) {
            return (om) ipChange.ipc$dispatch("277953815", new Object[]{context});
        }
        if (e == null) {
            if (context == null) {
                context = AppInfoProviderProxy.getApplication();
            }
            e = new om(context.getApplicationContext());
        }
        return e;
    }

    private void f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1828676760")) {
            ipChange.ipc$dispatch("-1828676760", new Object[]{this, context});
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        jb1.a(TAG, "initComponentsTypeFromRawFile");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(context.getResources().getIdentifier(Constants.COMPONENT, "raw", context.getPackageName()))));
        try {
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (readLine.isEmpty()) {
                    break;
                }
                this.a.put(readLine, Integer.valueOf(this.c.incrementAndGet()));
                this.b.put(this.c.intValue(), new Pair<>(readLine, null));
                jb1.a(TAG, "initComponentsTypeFromRawFile: " + readLine + ", type :" + this.c.intValue());
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            jb1.b(TAG, "initComponentsTypeFromRawFile." + e2.getMessage());
        }
        jb1.a(TAG, "initComponentsTypeFromRawFile cost : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public ComponentConfig a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-184590239")) {
            return (ComponentConfig) ipChange.ipc$dispatch("-184590239", new Object[]{this, Integer.valueOf(i)});
        }
        jb1.a(TAG, "getComponentCfgByType start. + type " + i);
        Pair<String, ComponentConfig> pair = this.b.get(i);
        if (pair == null) {
            jb1.a(TAG, "getComponentCfgByType : get pair is null .");
            return null;
        }
        ComponentConfig componentConfig = (ComponentConfig) pair.second;
        if (componentConfig != null) {
            jb1.a(TAG, " == getComponentCfgByType. return cached " + componentConfig.toString());
            return componentConfig;
        }
        String str = (String) pair.first;
        if (str != null && !str.isEmpty()) {
            ComponentConfig b = b(i, componentConfig, str);
            jb1.a(TAG, "getComponentCfgByType. config : " + b.toString());
            return b;
        }
        jb1.a(TAG, "getComponentCfgByType. fileName null ");
        return componentConfig;
    }

    public int d(String str) {
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "683284624")) {
            return ((Integer) ipChange.ipc$dispatch("683284624", new Object[]{this, str})).intValue();
        }
        jb1.a(TAG, "getViewTypeById start key . " + str);
        if (str != null && !str.isEmpty() && this.a.get(str) != null) {
            int intValue = this.a.get(str).intValue();
            jb1.a(TAG, "getViewTypeById . key : " + str + ", id :" + intValue);
            return intValue;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("componentId", str + "");
        if (e() == null) {
            str2 = "0";
        } else {
            str2 = e().size() + "";
        }
        hashMap.put("viewTypeSize", str2);
        TrackProxy.c("-506", "组件ViewType不存在", hashMap);
        return 0;
    }

    public SparseArray<Pair<String, ComponentConfig>> e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "71476875") ? (SparseArray) ipChange.ipc$dispatch("71476875", new Object[]{this}) : this.b;
    }
}
