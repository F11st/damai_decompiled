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
/* renamed from: com.alibaba.poplayer.trigger.a */
/* loaded from: classes8.dex */
public abstract class AbstractC3680a<ConfigItemType extends BaseConfigItem> {
    public static final String KEY_BLACK_LIST = "poplayer_black_list";
    @Monitor.TargetField(name = ip1.MONITOR_CONFIG_SET)
    protected String a = "";
    @Monitor.TargetField(name = ip1.MONITOR_CONFIG_ITEMS)
    protected List<ConfigItemType> b = new ArrayList();
    @Monitor.TargetField(name = ip1.MONITOR_BLACKLIST)
    protected List<String> c = new ArrayList();
    private AbstractC3680a<ConfigItemType>.AsyncTaskC3681a d;
    private IConfigAdapter e;
    private volatile boolean f;
    private final String g;
    private final String h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.a$a */
    /* loaded from: classes8.dex */
    public class AsyncTaskC3681a extends AsyncTask<Boolean, Void, AbstractC3680a<ConfigItemType>.C3682b> {
        private final Context a;

        public AsyncTaskC3681a(Context context) {
            this.a = context;
        }

        private AbstractC3680a<ConfigItemType>.C3682b c(boolean z) {
            dt1.b("UpdateCacheConfigTask.updateCacheConfig?init=%s.run.start", Boolean.valueOf(z));
            ArrayList arrayList = new ArrayList();
            String configItemByKey = AbstractC3680a.this.e.getConfigItemByKey(this.a, AbstractC3680a.this.g);
            if (AbstractC3680a.l(configItemByKey)) {
                dt1.b("UpdateCacheConfigTask.configSet.empty.return", new Object[0]);
                return new C3682b(AbstractC3680a.this);
            }
            dt1.b("UpdateCacheConfigTask.configSet.%s", configItemByKey);
            String configItemByKey2 = AbstractC3680a.this.e.getConfigItemByKey(this.a, AbstractC3680a.this.h);
            List arrayList2 = AbstractC3680a.l(configItemByKey2) ? new ArrayList() : Arrays.asList(configItemByKey2.split(","));
            dt1.b("UpdateCacheConfigTask.blacklist.%s", configItemByKey2);
            for (String str : configItemByKey.split("\\,")) {
                String trim = str.trim();
                String configItemByKey3 = AbstractC3680a.this.e.getConfigItemByKey(this.a, trim);
                dt1.b("UpdateCacheConfigTask.config{%s}", configItemByKey3);
                try {
                    BaseConfigItem r = AbstractC3680a.this.r(configItemByKey3);
                    if (r != null) {
                        r.entityId = trim;
                        arrayList.add(r);
                    }
                } catch (Throwable th) {
                    dt1.c("UpdateCacheConfigTask.parse.error.uuid{" + trim + "}.content{" + configItemByKey3 + "}", th);
                }
            }
            AbstractC3680a abstractC3680a = AbstractC3680a.this;
            abstractC3680a.v(abstractC3680a.e, this.a);
            return new C3682b(AbstractC3680a.this, arrayList, configItemByKey, arrayList2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public AbstractC3680a<ConfigItemType>.C3682b doInBackground(Boolean... boolArr) {
            try {
                return c(boolArr[0].booleanValue());
            } catch (Throwable th) {
                dt1.c("UpdateCacheConfigTask.doInBackground.fail." + th.toString(), th);
                return new C3682b(AbstractC3680a.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(AbstractC3680a<ConfigItemType>.C3682b c3682b) {
            try {
                AbstractC3680a.this.b = ((C3682b) c3682b).a;
                AbstractC3680a.this.a = ((C3682b) c3682b).b;
                AbstractC3680a.this.c = ((C3682b) c3682b).c;
                AbstractC3680a abstractC3680a = AbstractC3680a.this;
                abstractC3680a.p(abstractC3680a.b, abstractC3680a.a, abstractC3680a.c);
                AbstractC3680a.this.f = false;
            } catch (Throwable th) {
                dt1.c("UpdateCacheConfigTask.onPostExecute.error", th);
            }
        }
    }

    public AbstractC3680a(IConfigAdapter iConfigAdapter, String str, String str2) {
        this.e = iConfigAdapter;
        this.g = str;
        this.h = str2;
    }

    public static boolean l(String str) {
        return str == null || "".equals(str) || "\"\"".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(Event event, BaseConfigItem.C3677a c3677a) {
        String str = c3677a == null ? null : c3677a.c;
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
            CommonConfigRule.ConfigStatus b = CommonConfigRule.b(event, next);
            if (CommonConfigRule.ConfigStatus.VALIED == b) {
                vw2Var.a.add(next);
            } else if (CommonConfigRule.ConfigStatus.VALIED_BUT_UNSTARTED == b) {
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
    public boolean n(Event event, BaseConfigItem.C3677a c3677a) {
        if (c3677a == null) {
            return false;
        }
        if (event.uri.equals(c3677a.a)) {
            return true;
        }
        String[] strArr = c3677a.b;
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
    public BaseConfigItem.C3677a t(String str, String str2) {
        BaseConfigItem.C3677a c3677a = new BaseConfigItem.C3677a();
        try {
            JSONObject parseObject = JSON.parseObject(str);
            c3677a.a = parseObject.getString("uri");
            String string = parseObject.getString("uris");
            if (!TextUtils.isEmpty(string)) {
                List parseArray = JSON.parseArray(string, String.class);
                c3677a.b = (String[]) parseArray.toArray(new String[parseArray.size()]);
            }
            c3677a.c = parseObject.getString("paramContains");
        } catch (Throwable unused) {
            dt1.b("PageConfigMgr.parseConfig.error:currentUUID:{%s}.", str2);
        }
        return c3677a;
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
        AbstractC3680a<ConfigItemType>.AsyncTaskC3681a asyncTaskC3681a = this.d;
        if (asyncTaskC3681a != null && AsyncTask.Status.FINISHED != asyncTaskC3681a.getStatus()) {
            this.d.cancel(true);
        }
        AbstractC3680a<ConfigItemType>.AsyncTaskC3681a asyncTaskC3681a2 = new AsyncTaskC3681a(context);
        this.d = asyncTaskC3681a2;
        asyncTaskC3681a2.execute(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.trigger.a$b */
    /* loaded from: classes8.dex */
    public final class C3682b {
        private final List<ConfigItemType> a;
        private final String b;
        private final List<String> c;

        public C3682b(AbstractC3680a abstractC3680a, List<ConfigItemType> list, String str, List<String> list2) {
            this.a = list;
            this.b = str;
            this.c = list2;
        }

        public C3682b(AbstractC3680a abstractC3680a) {
            this.a = new ArrayList();
            this.b = "";
            this.c = new ArrayList();
        }
    }
}
