package com.alibaba.emas.publish.channel;

import android.content.Context;
import android.os.Build;
import com.alibaba.emas.publish.channel.mtop.PublishMtopRequest;
import com.alibaba.emas.publish.channel.mtop.PublishMtopResponse;
import com.alibaba.emas.publish.channel.ut.PublishUtRequest;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.client.GlobalClientInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class a implements ChannelService {
    private String a = "mtop.alibaba.emas.publish.update.outer.get";
    private Boolean b;
    private Boolean c;
    public Context d;
    public String e;
    public String f;
    public boolean g;
    private Map<String, String> h;
    private Map<String, String> i;
    private List<String> j;
    private com.alibaba.emas.publish.channel.mtop.a k;
    private com.alibaba.emas.publish.channel.ut.a l;

    public a(Context context, String str, String str2, com.alibaba.emas.publish.channel.mtop.a aVar, com.alibaba.emas.publish.channel.ut.a aVar2, Boolean bool) {
        this.g = false;
        this.d = context;
        this.g = bool.booleanValue();
        this.f = str;
        this.e = str2;
        this.k = aVar;
        this.l = aVar2;
    }

    private String a() {
        try {
            String str = this.e;
            if (str != null) {
                String[] split = str.split("\\@");
                return split.length > 1 ? split[0] : "unKnown";
            }
            return "unKnown";
        } catch (Exception unused) {
            return "unKnown";
        }
    }

    private boolean b() {
        if (this.c == null) {
            try {
                Class.forName(AccsDataListener.class.getName());
                this.c = Boolean.TRUE;
            } catch (Throwable unused) {
                this.c = Boolean.FALSE;
            }
        }
        return this.c.booleanValue();
    }

    private boolean c() {
        if (this.b == null) {
            try {
                Class.forName(Mtop.class.getName());
                this.b = Boolean.TRUE;
            } catch (Throwable unused) {
                this.b = Boolean.FALSE;
            }
        }
        return this.b.booleanValue();
    }

    @Override // com.alibaba.emas.publish.channel.ChannelService
    public void addVersionAndArgs(String str, String str2, Map<String, String> map) throws Exception {
        if (str != null && str2 != null) {
            if (this.h == null) {
                this.h = new HashMap();
            }
            if (!this.h.containsKey(str)) {
                this.h.put(str, str2);
            }
        }
        if (str != null) {
            if (this.j == null) {
                this.j = new ArrayList();
            }
            if (!this.j.contains(str)) {
                this.j.add(str);
            }
        }
        if (map == null || map.size() <= 0) {
            return;
        }
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.i.putAll(map);
    }

    @Override // com.alibaba.emas.publish.channel.ChannelService
    public void registAccs(String str) {
        if (b()) {
            GlobalClientInfo.getInstance(this.d).registerService(str, "com.alibaba.emas.publish.channel.accs.PublishAccsService");
        }
    }

    @Override // com.alibaba.emas.publish.channel.ChannelService
    public void registUt() throws Exception {
        this.l.a();
    }

    @Override // com.alibaba.emas.publish.channel.ChannelService
    public PublishMtopResponse sendActiveMtop(String str, String str2, List<String> list, Map<String, String> map, Map<String, String> map2) throws Exception {
        PublishMtopRequest publishMtopRequest = new PublishMtopRequest();
        publishMtopRequest.brand = Build.getMANUFACTURER();
        publishMtopRequest.model = Build.getMODEL();
        publishMtopRequest.apiLevel = Build.VERSION.SDK_INT;
        publishMtopRequest.identifier = this.f;
        publishMtopRequest.versions = map;
        publishMtopRequest.bizTypes = list;
        publishMtopRequest.channel = a();
        if (map2 != null && map2.size() > 0) {
            publishMtopRequest.args = map2;
        }
        if (this.g) {
            publishMtopRequest.API_NAME = this.a;
        }
        if (str != null) {
            publishMtopRequest.API_NAME = str;
        }
        if (str2 != null) {
            publishMtopRequest.appVersion = str2;
        }
        if (c()) {
            return this.k.a(publishMtopRequest, this.d, this.e, this.g);
        }
        return null;
    }

    @Override // com.alibaba.emas.publish.channel.ChannelService
    public PublishMtopResponse sendMtop() throws Exception {
        PublishMtopRequest publishMtopRequest = new PublishMtopRequest();
        publishMtopRequest.brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
        publishMtopRequest.model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        publishMtopRequest.identifier = this.f;
        publishMtopRequest.apiLevel = Build.VERSION.SDK_INT;
        publishMtopRequest.versions = this.h;
        publishMtopRequest.bizTypes = this.j;
        publishMtopRequest.args = this.i;
        publishMtopRequest.channel = a();
        if (this.g) {
            publishMtopRequest.API_NAME = this.a;
        }
        if (c()) {
            return this.k.a(publishMtopRequest, this.d, this.e, this.g);
        }
        return null;
    }

    @Override // com.alibaba.emas.publish.channel.ChannelService
    public void sendUtData(PublishUtRequest publishUtRequest) throws Exception {
        this.l.b(publishUtRequest);
    }
}
