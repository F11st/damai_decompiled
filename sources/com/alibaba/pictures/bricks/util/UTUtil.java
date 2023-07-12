package com.alibaba.pictures.bricks.util;

import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class UTUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final UTUtil INSTANCE = new UTUtil();
    @NotNull
    private static final String a = "a2o4t.";
    @NotNull
    private static ArrayList<UTExposureBean> b = new ArrayList<>();
    @NotNull
    private static HashMap<String, String> c = new HashMap<>();
    @NotNull
    private static UTExposureBean d = new UTExposureBean();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class UTExposureBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        @NotNull
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 1;
        @Nullable
        private String area;
        private long duration;
        @Nullable
        private HashMap<String, String> exargs;
        @Nullable
        private String spm;
        @Nullable
        private String viewid;

        /* compiled from: Taobao */
        /* loaded from: classes7.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(k50 k50Var) {
                this();
            }
        }

        @Nullable
        public final String getArea() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "879730014") ? (String) ipChange.ipc$dispatch("879730014", new Object[]{this}) : this.area;
        }

        public final long getDuration() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1502105585") ? ((Long) ipChange.ipc$dispatch("-1502105585", new Object[]{this})).longValue() : this.duration;
        }

        @Nullable
        public final HashMap<String, String> getExargs() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1808195006") ? (HashMap) ipChange.ipc$dispatch("-1808195006", new Object[]{this}) : this.exargs;
        }

        @Nullable
        public final String getSpm() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "47975221") ? (String) ipChange.ipc$dispatch("47975221", new Object[]{this}) : this.spm;
        }

        @Nullable
        public final String getViewid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2005352879") ? (String) ipChange.ipc$dispatch("-2005352879", new Object[]{this}) : this.viewid;
        }

        public final void setArea(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1209069888")) {
                ipChange.ipc$dispatch("1209069888", new Object[]{this, str});
            } else {
                this.area = str;
            }
        }

        public final void setDuration(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1590150421")) {
                ipChange.ipc$dispatch("1590150421", new Object[]{this, Long.valueOf(j)});
            } else {
                this.duration = j;
            }
        }

        public final void setExargs(@Nullable HashMap<String, String> hashMap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1110549440")) {
                ipChange.ipc$dispatch("1110549440", new Object[]{this, hashMap});
            } else {
                this.exargs = hashMap;
            }
        }

        public final void setSpm(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1389187359")) {
                ipChange.ipc$dispatch("-1389187359", new Object[]{this, str});
            } else {
                this.spm = str;
            }
        }

        public final void setViewid(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "863478189")) {
                ipChange.ipc$dispatch("863478189", new Object[]{this, str});
            } else {
                this.viewid = str;
            }
        }
    }

    private UTUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String a(java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r8 = r19
            r9 = r20
            com.android.alibaba.ip.runtime.IpChange r2 = com.alibaba.pictures.bricks.util.UTUtil.$ipChange
            java.lang.String r3 = "571397317"
            boolean r4 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r2, r3)
            r10 = 2
            r11 = 1
            r12 = 0
            if (r4 == 0) goto L28
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r12] = r0
            r4[r11] = r1
            r4[r10] = r8
            r1 = 3
            r4[r1] = r9
            java.lang.Object r1 = r2.ipc$dispatch(r3, r4)
            java.lang.String r1 = (java.lang.String) r1
            return r1
        L28:
            boolean r2 = android.text.TextUtils.isEmpty(r19)
            java.lang.String r13 = "this as java.lang.String…ing(startIndex, endIndex)"
            r14 = 0
            java.lang.String r15 = "_"
            java.lang.String r7 = "this as java.lang.String).substring(startIndex)"
            if (r2 != 0) goto L66
            int r2 = r19.length()
            int r2 = r2 - r11
            java.lang.String r2 = r8.substring(r2)
            tb.b41.h(r2, r7)
            boolean r2 = r0.b(r2)
            if (r2 == 0) goto L66
            boolean r2 = kotlin.text.g.K(r8, r15, r12, r10, r14)
            if (r2 == 0) goto L66
            r4 = 0
            r5 = 0
            r6 = 6
            r16 = 0
            java.lang.String r3 = "_"
            r2 = r19
            r10 = r7
            r7 = r16
            int r2 = kotlin.text.g.f0(r2, r3, r4, r5, r6, r7)
            java.lang.String r2 = r8.substring(r12, r2)
            tb.b41.h(r2, r13)
            r8 = r2
            goto L67
        L66:
            r10 = r7
        L67:
            boolean r2 = android.text.TextUtils.isEmpty(r20)
            if (r2 != 0) goto L9a
            int r2 = r20.length()
            int r2 = r2 - r11
            java.lang.String r2 = r9.substring(r2)
            tb.b41.h(r2, r10)
            boolean r2 = r0.b(r2)
            if (r2 == 0) goto L9a
            r2 = 2
            boolean r2 = kotlin.text.g.K(r9, r15, r12, r2, r14)
            if (r2 == 0) goto L9a
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            java.lang.String r3 = "_"
            r2 = r20
            int r2 = kotlin.text.g.f0(r2, r3, r4, r5, r6, r7)
            java.lang.String r2 = r9.substring(r12, r2)
            tb.b41.h(r2, r13)
            goto L9b
        L9a:
            r2 = r9
        L9b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "page_"
            r3.append(r4)
            r3.append(r1)
            r1 = 95
            r3.append(r1)
            r3.append(r8)
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.util.UTUtil.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private final boolean b(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078280178")) {
            return ((Boolean) ipChange.ipc$dispatch("-1078280178", new Object[]{this, str})).booleanValue();
        }
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void c(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, long j, @Nullable HashMap<String, String> hashMap, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1216308689")) {
            ipChange.ipc$dispatch("-1216308689", new Object[]{this, str, str2, str3, str4, Long.valueOf(j), hashMap, Integer.valueOf(i)});
            return;
        }
        b41.i(str, "widgetName");
        b41.i(str2, "moduleName");
        b41.i(str3, "pageName");
        b41.i(str4, com.youku.live.dago.liveplayback.widget.Constants.ACTION_PARAMS_AREA);
        String str5 = "page_" + str3;
        String a2 = a(str3, str2, str);
        String str6 = (a + str3 + '.' + str2) + '.' + str;
        b.clear();
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        UTExposureBean uTExposureBean = new UTExposureBean();
        d = uTExposureBean;
        uTExposureBean.setArea(str4);
        d.setDuration(j);
        d.setExargs(hashMap2);
        d.setViewid(str6);
        d.setSpm(str6);
        b.add(d);
        String jSONString = JSON.toJSONString(b);
        HashMap<String, String> hashMap3 = c;
        b41.h(jSONString, "expdataStr");
        hashMap3.put("expdata", jSONString);
        try {
            UTAnalytics.getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder(str5, i, a2, null, null, c).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
