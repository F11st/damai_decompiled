package tb;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.android.ultron.trade.theme.IConfiguration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class km2 {
    private Context a;
    private IConfiguration b;
    private Map<String, List<String>> c = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class b implements IConfiguration {
        public static final String PATH = "theme/configuration.json";

        private b() {
        }

        @Override // com.alibaba.android.ultron.trade.theme.IConfiguration
        public String getConfigurationPath() {
            return PATH;
        }

        @Override // com.alibaba.android.ultron.trade.theme.IConfiguration
        public Map<String, List<String>> getCustomKV() {
            return null;
        }
    }

    public km2(Context context) {
        if (context != null) {
            this.a = context;
            this.b = new b();
            d();
            return;
        }
        throw new IllegalArgumentException("param context can not be null");
    }

    private List<String> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        return arrayList;
    }

    private JSONObject b(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    return JSON.parseObject(sb.toString());
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    private void d() {
        IConfiguration iConfiguration = this.b;
        if (iConfiguration != null) {
            JSONObject b2 = b(iConfiguration.getConfigurationPath(), this.a);
            if (b2 != null) {
                for (String str : b2.keySet()) {
                    String string = b2.getString(str);
                    if (!TextUtils.isEmpty(string)) {
                        f(str, string.split(SymbolExpUtil.SYMBOL_VERTICALBAR));
                    }
                }
            }
            e(this.b.getCustomKV());
        }
    }

    public List<String> c(String str) {
        return this.c.get(str);
    }

    public void e(Map<String, List<String>> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.c.putAll(map);
    }

    public void f(String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        this.c.put(str, a(strArr));
    }

    public void g(IConfiguration iConfiguration) {
        this.b = iConfiguration;
        d();
    }
}
