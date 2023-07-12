package com.taobao.update.datasource.mtop;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.update.datasource.UpdateDataSource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import tb.gn1;
import tb.lu2;
import tb.pu2;
import tb.qp;

/* compiled from: Taobao */
/* renamed from: com.taobao.update.datasource.mtop.a */
/* loaded from: classes11.dex */
public class C6923a {
    public Context mContext;
    public String mFrom;
    public String mGroup;
    public boolean mIsOutApk;
    public String mTtid;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.update.datasource.mtop.a$b */
    /* loaded from: classes11.dex */
    public static class C6925b {
        private Context a;
        private String b;
        private String c;
        private boolean d;
        private String e;

        private C6925b(Context context) {
            this.a = context;
        }

        public static C6925b newBuilder(Context context) {
            return new C6925b(context);
        }

        public C6923a build() {
            return new C6923a(this.a, this.b, this.c, this.d, this.e);
        }

        public C6925b setFrom(String str) {
            this.e = str;
            return this;
        }

        public C6925b setGroup(String str) {
            this.c = str;
            return this;
        }

        public C6925b setOutApk(boolean z) {
            this.d = z;
            return this;
        }

        public C6925b setTtid(String str) {
            this.b = str;
            return this;
        }
    }

    private boolean a() {
        String str;
        String str2 = null;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
            str = (String) method.invoke(null, "ro.yunos.version");
            try {
                str2 = (String) method.invoke(null, "java.vm.name");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        return (str2 != null && str2.toLowerCase().contains("lemur")) || (str != null && str.trim().length() > 0);
    }

    public JSONObject queryUpdateInfo() {
        UpdateRequest updateRequest = new UpdateRequest(this.mIsOutApk);
        if (!TextUtils.isEmpty(this.mFrom) && !this.mFrom.equals(lu2.MTOP_SOURCE)) {
            updateRequest.betaSource = this.mFrom;
        }
        updateRequest.brand = Build.getMANUFACTURER();
        updateRequest.model = Build.getMODEL();
        updateRequest.identifier = this.mGroup;
        updateRequest.appVersion = pu2.getVersionName();
        updateRequest.apiLevel = Build.VERSION.SDK_INT;
        updateRequest.patchVersion = 0L;
        updateRequest.cpuArch = qp.getCpuArch();
        updateRequest.dexpatchVersion = 0L;
        updateRequest.isYunos = a();
        ArrayList arrayList = new ArrayList();
        arrayList.add(lu2.MAIN);
        arrayList.add(lu2.DYNAMIC);
        arrayList.add(lu2.HOTPATCH);
        arrayList.add("bundles");
        arrayList.add("andfix");
        arrayList.add(lu2.DEXPATCH);
        updateRequest.updateTypes = arrayList;
        return UpdateDataSource.sUpdateAdapter.invokePullApi(updateRequest, this.mContext, this.mTtid, this.mIsOutApk);
    }

    private C6923a(Context context, String str, String str2, boolean z, String str3) {
        this.mContext = context;
        this.mTtid = str;
        this.mGroup = str2;
        this.mIsOutApk = z;
        this.mFrom = str3;
    }
}
