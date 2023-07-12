package com.alibaba.poplayer.trigger;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.poplayer.PopLayer;
import com.alibaba.poplayer.norm.IConfigAdapter;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.CommonConfigRule;
import com.alibaba.poplayer.utils.Monitor;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import tb.dt1;
import tb.ip1;
import tb.vw2;

/* compiled from: Taobao */
@Monitor.TargetClass
/* loaded from: classes8.dex */
public abstract class a<ConfigItemType extends BaseConfigItem> {
    public static final String KEY_BLACK_LIST = "poplayer_black_list";
    @Monitor.TargetField(name = ip1.MONITOR_CONFIG_SET)
    protected String a = "";
    @Monitor.TargetField(name = ip1.MONITOR_CONFIG_ITEMS)
    protected List<ConfigItemType> b = new ArrayList();
    @Monitor.TargetField(name = ip1.MONITOR_BLACKLIST)
    protected List<String> c = new ArrayList();
    private a<ConfigItemType>.AsyncTaskC0157a d;
    private IConfigAdapter e;
    private volatile boolean f;
    private final String g;
    private final String h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class AsyncTaskC0157a extends AsyncTask<Boolean, Void, a<ConfigItemType>.b> {
        private final Context a;

        public AsyncTaskC0157a(Context context) {
            this.a = context;
        }

        private a<ConfigItemType>.b c(boolean z) {
            dt1.b("UpdateCacheConfigTask.updateCacheConfig?init=%s.run.start", Boolean.valueOf(z));
            ArrayList arrayList = new ArrayList();
            String configItemByKey = a.this.e.getConfigItemByKey(this.a, a.this.g);
            if (a.l(configItemByKey)) {
                dt1.b("UpdateCacheConfigTask.configSet.empty.return", new Object[0]);
                return new b(a.this);
            }
            dt1.b("UpdateCacheConfigTask.configSet.%s", configItemByKey);
            String configItemByKey2 = a.this.e.getConfigItemByKey(this.a, a.this.h);
            List arrayList2 = a.l(configItemByKey2) ? new ArrayList() : Arrays.asList(configItemByKey2.split(","));
            dt1.b("UpdateCacheConfigTask.blacklist.%s", configItemByKey2);
            for (String str : configItemByKey.split("\\,")) {
                String trim = str.trim();
                String configItemByKey3 = a.this.e.getConfigItemByKey(this.a, trim);
                dt1.b("UpdateCacheConfigTask.config{%s}", configItemByKey3);
                try {
                    BaseConfigItem r = a.this.r(configItemByKey3);
                    if (r != null) {
                        r.entityId = trim;
                        arrayList.add(r);
                    }
                } catch (Throwable th) {
                    dt1.c("UpdateCacheConfigTask.parse.error.uuid{" + trim + "}.content{" + configItemByKey3 + "}", th);
                }
            }
            a aVar = a.this;
            aVar.v(aVar.e, this.a);
            return new b(a.this, arrayList, configItemByKey, arrayList2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public a<ConfigItemType>.b doInBackground(Boolean... boolArr) {
            try {
                return c(boolArr[0].booleanValue());
            } catch (Throwable th) {
                dt1.c("UpdateCacheConfigTask.doInBackground.fail." + th.toString(), th);
                return new b(a.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(a<ConfigItemType>.b bVar) {
            try {
                a.this.b = ((b) bVar).a;
                a.this.a = ((b) bVar).b;
                a.this.c = ((b) bVar).c;
                a aVar = a.this;
                aVar.p(aVar.b, aVar.a, aVar.c);
                a.this.f = false;
            } catch (Throwable th) {
                dt1.c("UpdateCacheConfigTask.onPostExecute.error", th);
            }
        }
    }

    public a(IConfigAdapter iConfigAdapter, String str, String str2) {
        this.e = iConfigAdapter;
        this.g = str;
        this.h = str2;
    }

    public static boolean l(String str) {
        return str == null || "".equals(str) || "\"\"".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(Event event, BaseConfigItem.a aVar) {
        String str = aVar == null ? null : aVar.c;
        if (TextUtils.isEmpty(str)) {
            dt1.b("DefaultConfigManager.checkUrlContains.paramContains is empty,check success.", new Object[0]);
            return true;
        }
        String str2 = event.param;
        try {
            str2 = URLDecoder.decode(str2, "utf-8");
        } catch (Throwable unused) {
            dt1.b("DefaultConfigManager.checkUrlContains.currentParam:{%s} decode failed", str2);
        }
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (Throwable unused2) {
            dt1.b("DefaultConfigManager.checkUrlContains.paramContains:{%s} decode failed", str);
        }
        dt1.b("DefaultConfigManager.checkUrlContains.after decode:currentParam:{%s},paramContains{%s}.", str2, str);
        if (str2 != null && str2.contains(str)) {
            dt1.b("DefaultConfigManager.checkUrlContains.currentParam.contains(paramContains),check success.", new Object[0]);
            return true;
        }
        dt1.b("DefaultConfigManager.checkUrlContains.miss.currentParam{%s}.notContains.paramContain{%s}", str2, str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public vw2<ConfigItemType> f(Event event, ArrayList<ConfigItemType> arrayList) {
        vw2<ConfigItemType> vw2Var = new vw2<>();
        dt1.b("ConfigManager.blackList check.", new Object[0]);
        if (m(this.c)) {
            return vw2Var;
        }
        Iterator<ConfigItemType> it = arrayList.iterator();
        while (it.hasNext()) {
            ConfigItemType next = it.next();
            CommonConfigRule.ConfigStatus b2 = CommonConfigRule.b(event, next);
            if (CommonConfigRule.ConfigStatus.VALIED == b2) {
                vw2Var.a.add(next);
            } else if (CommonConfigRule.ConfigStatus.VALIED_BUT_UNSTARTED == b2) {
                vw2Var.b.add(next);
            }
        }
        return vw2Var;
    }

    public vw2<ConfigItemType> g(Event event) {
        vw2<ConfigItemType> vw2Var = new vw2<>();
        if (q(event)) {
            vw2Var.a.add(s(event));
            return vw2Var;
        }
        return h(event);
    }

    public abstract vw2<ConfigItemType> h(Event event);

    protected String i() {
        return Build.getMODEL();
    }

    protected String j() {
        return Build.VERSION.getRELEASE();
    }

    public IConfigAdapter k() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(List<String> list) {
        if (list != null && !list.isEmpty()) {
            String i = i();
            boolean contains = list.contains(i);
            if (!contains) {
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (Pattern.compile(next).matcher(i).matches()) {
                        dt1.b("ConfigManager.list.in regex : %s,buildType: %s ", next, i);
                        contains = true;
                        break;
                    }
                }
            }
            dt1.b("ConfigManager.isInList.return?contains-%s=%s", i(), Boolean.valueOf(contains));
            boolean contains2 = list.contains(j());
            dt1.b("ConfigManager.isInList.return?containsVersion-%s=%s", j(), Boolean.valueOf(contains2));
            return contains || contains2;
        }
        dt1.b("ConfigManager.isInList.return.emptyList", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(Event event, BaseConfigItem.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (event.uri.equals(aVar.a)) {
            return true;
        }
        String[] strArr = aVar.b;
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (event.uri.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean o() {
        return this.f;
    }

    protected abstract void p(List<ConfigItemType> list, String str, List<String> list2);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(Event event) {
        return event.originUri.startsWith(PopLayer.SCHEMA) && "directly".equals(Uri.parse(event.originUri).getQueryParameter("openType"));
    }

    protected abstract ConfigItemType r(String str);

    public abstract ConfigItemType s(Event event);

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseConfigItem.a t(String str, String str2) {
        BaseConfigItem.a aVar = new BaseConfigItem.a();
        try {
            JSONObject parseObject = JSON.parseObject(str);
            aVar.a = parseObject.getString("uri");
            String string = parseObject.getString("uris");
            if (!TextUtils.isEmpty(string)) {
                List parseArray = JSON.parseArray(string, String.class);
                aVar.b = (String[]) parseArray.toArray(new String[parseArray.size()]);
            }
            aVar.c = parseObject.getString("paramContains");
        } catch (Throwable unused) {
            dt1.b("PageConfigMgr.parseConfig.error:currentUUID:{%s}.", str2);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public org.json.JSONObject u(Uri uri) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2 = null;
        try {
            jSONObject = new org.json.JSONObject();
        } catch (Throwable unused) {
        }
        try {
            for (String str : uri.getQueryParameterNames()) {
                jSONObject.put(str, uri.getQueryParameter(str));
            }
            return jSONObject;
        } catch (Throwable unused2) {
            jSONObject2 = jSONObject;
            return jSONObject2;
        }
    }

    protected void v(IConfigAdapter iConfigAdapter, Context context) {
    }

    public final void w(boolean z, Context context) {
        this.f = true;
        a<ConfigItemType>.AsyncTaskC0157a asyncTaskC0157a = this.d;
        if (asyncTaskC0157a != null && AsyncTask.Status.FINISHED != asyncTaskC0157a.getStatus()) {
            this.d.cancel(true);
        }
        a<ConfigItemType>.AsyncTaskC0157a asyncTaskC0157a2 = new AsyncTaskC0157a(context);
        this.d = asyncTaskC0157a2;
        asyncTaskC0157a2.execute(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public final class b {
        private final List<ConfigItemType> a;
        private final String b;
        private final List<String> c;

        public b(a aVar, List<ConfigItemType> list, String str, List<String> list2) {
            this.a = list;
            this.b = str;
            this.c = list2;
        }

        public b(a aVar) {
            this.a = new ArrayList();
            this.b = "";
            this.c = new ArrayList();
        }
    }
}
