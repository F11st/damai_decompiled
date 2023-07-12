package cn.damai.search.component.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class SearchScriptBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private String costTime;
    @Nullable
    private String descLocal;
    @Nullable
    private String femaleCount;
    @Nullable
    private String grade;
    @Nullable
    private ArrayList<String> highlightWord;
    @Nullable
    private String id;
    @Nullable
    private String itemScore;
    @Nullable
    private String itemStar;
    @Nullable
    private String manCount;
    @Nullable
    private String maxPeopleCount;
    @Nullable
    private String minPeopleCount;
    @Nullable
    private String name;
    @Nullable
    private String peopleDesc;
    @Nullable
    private String schema;
    private final long serialVersionUID = 1;
    @Nullable
    private ArrayList<String> tagList;
    @Nullable
    private String url;

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041 A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:17:0x0031, B:19:0x0035, B:25:0x0041, B:26:0x004b, B:28:0x0051, B:30:0x0059, B:31:0x005c, B:34:0x0062, B:36:0x006c, B:37:0x0077, B:39:0x007d, B:45:0x0089, B:46:0x008f, B:48:0x0093, B:54:0x009f, B:55:0x00a7, B:57:0x00ab, B:61:0x00b4, B:62:0x00bc), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0089 A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:17:0x0031, B:19:0x0035, B:25:0x0041, B:26:0x004b, B:28:0x0051, B:30:0x0059, B:31:0x005c, B:34:0x0062, B:36:0x006c, B:37:0x0077, B:39:0x007d, B:45:0x0089, B:46:0x008f, B:48:0x0093, B:54:0x009f, B:55:0x00a7, B:57:0x00ab, B:61:0x00b4, B:62:0x00bc), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093 A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:17:0x0031, B:19:0x0035, B:25:0x0041, B:26:0x004b, B:28:0x0051, B:30:0x0059, B:31:0x005c, B:34:0x0062, B:36:0x006c, B:37:0x0077, B:39:0x007d, B:45:0x0089, B:46:0x008f, B:48:0x0093, B:54:0x009f, B:55:0x00a7, B:57:0x00ab, B:61:0x00b4, B:62:0x00bc), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009f A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:17:0x0031, B:19:0x0035, B:25:0x0041, B:26:0x004b, B:28:0x0051, B:30:0x0059, B:31:0x005c, B:34:0x0062, B:36:0x006c, B:37:0x0077, B:39:0x007d, B:45:0x0089, B:46:0x008f, B:48:0x0093, B:54:0x009f, B:55:0x00a7, B:57:0x00ab, B:61:0x00b4, B:62:0x00bc), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ab A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:17:0x0031, B:19:0x0035, B:25:0x0041, B:26:0x004b, B:28:0x0051, B:30:0x0059, B:31:0x005c, B:34:0x0062, B:36:0x006c, B:37:0x0077, B:39:0x007d, B:45:0x0089, B:46:0x008f, B:48:0x0093, B:54:0x009f, B:55:0x00a7, B:57:0x00ab, B:61:0x00b4, B:62:0x00bc), top: B:66:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4 A[Catch: Exception -> 0x00d0, TryCatch #0 {Exception -> 0x00d0, blocks: (B:17:0x0031, B:19:0x0035, B:25:0x0041, B:26:0x004b, B:28:0x0051, B:30:0x0059, B:31:0x005c, B:34:0x0062, B:36:0x006c, B:37:0x0077, B:39:0x007d, B:45:0x0089, B:46:0x008f, B:48:0x0093, B:54:0x009f, B:55:0x00a7, B:57:0x00ab, B:61:0x00b4, B:62:0x00bc), top: B:66:0x0031 }] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String buildDesc() {
        /*
            r9 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.search.component.bean.SearchScriptBean.$ipChange
            java.lang.String r1 = "776291798"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L17
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r9
            java.lang.Object r0 = r0.ipc$dispatch(r1, r2)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L17:
            java.lang.String r0 = r9.descLocal
            if (r0 == 0) goto L24
            int r0 = r0.length()
            if (r0 != 0) goto L22
            goto L24
        L22:
            r0 = 0
            goto L25
        L24:
            r0 = 1
        L25:
            if (r0 != 0) goto L2a
            java.lang.String r0 = r9.descLocal
            return r0
        L2a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " | "
            java.util.ArrayList<java.lang.String> r2 = r9.tagList     // Catch: java.lang.Exception -> Ld0
            if (r2 == 0) goto L3e
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Exception -> Ld0
            if (r2 == 0) goto L3c
            goto L3e
        L3c:
            r2 = 0
            goto L3f
        L3e:
            r2 = 1
        L3f:
            if (r2 != 0) goto L77
            java.util.ArrayList<java.lang.String> r2 = r9.tagList     // Catch: java.lang.Exception -> Ld0
            tb.b41.f(r2)     // Catch: java.lang.Exception -> Ld0
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> Ld0
            r5 = 0
        L4b:
            boolean r6 = r2.hasNext()     // Catch: java.lang.Exception -> Ld0
            if (r6 == 0) goto L6c
            java.lang.Object r6 = r2.next()     // Catch: java.lang.Exception -> Ld0
            int r7 = r5 + 1
            if (r5 >= 0) goto L5c
            kotlin.collections.C8212k.p()     // Catch: java.lang.Exception -> Ld0
        L5c:
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> Ld0
            r8 = 2
            if (r5 < r8) goto L62
            goto L6a
        L62:
            r0.append(r6)     // Catch: java.lang.Exception -> Ld0
            java.lang.String r5 = "·"
            r0.append(r5)     // Catch: java.lang.Exception -> Ld0
        L6a:
            r5 = r7
            goto L4b
        L6c:
            int r2 = r0.length()     // Catch: java.lang.Exception -> Ld0
            int r2 = r2 - r4
            r0.deleteCharAt(r2)     // Catch: java.lang.Exception -> Ld0
            r0.append(r1)     // Catch: java.lang.Exception -> Ld0
        L77:
            java.lang.String r2 = r9.getPeopleCountDesc()     // Catch: java.lang.Exception -> Ld0
            if (r2 == 0) goto L86
            int r5 = r2.length()     // Catch: java.lang.Exception -> Ld0
            if (r5 != 0) goto L84
            goto L86
        L84:
            r5 = 0
            goto L87
        L86:
            r5 = 1
        L87:
            if (r5 != 0) goto L8f
            r0.append(r2)     // Catch: java.lang.Exception -> Ld0
            r0.append(r1)     // Catch: java.lang.Exception -> Ld0
        L8f:
            java.lang.String r2 = r9.costTime     // Catch: java.lang.Exception -> Ld0
            if (r2 == 0) goto L9c
            int r2 = r2.length()     // Catch: java.lang.Exception -> Ld0
            if (r2 != 0) goto L9a
            goto L9c
        L9a:
            r2 = 0
            goto L9d
        L9c:
            r2 = 1
        L9d:
            if (r2 != 0) goto La7
            java.lang.String r2 = r9.costTime     // Catch: java.lang.Exception -> Ld0
            r0.append(r2)     // Catch: java.lang.Exception -> Ld0
            r0.append(r1)     // Catch: java.lang.Exception -> Ld0
        La7:
            java.lang.String r2 = r9.grade     // Catch: java.lang.Exception -> Ld0
            if (r2 == 0) goto Lb1
            int r2 = r2.length()     // Catch: java.lang.Exception -> Ld0
            if (r2 != 0) goto Lb2
        Lb1:
            r3 = 1
        Lb2:
            if (r3 != 0) goto Lbc
            java.lang.String r2 = r9.grade     // Catch: java.lang.Exception -> Ld0
            r0.append(r2)     // Catch: java.lang.Exception -> Ld0
            r0.append(r1)     // Catch: java.lang.Exception -> Ld0
        Lbc:
            int r1 = r0.length()     // Catch: java.lang.Exception -> Ld0
            int r1 = r1 + (-3)
            int r2 = r0.length()     // Catch: java.lang.Exception -> Ld0
            java.lang.StringBuilder r0 = r0.delete(r1, r2)     // Catch: java.lang.Exception -> Ld0
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Ld0
            r9.descLocal = r0     // Catch: java.lang.Exception -> Ld0
        Ld0:
            java.lang.String r0 = r9.descLocal
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.search.component.bean.SearchScriptBean.buildDesc():java.lang.String");
    }

    @Nullable
    public final String getCostTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "12016615") ? (String) ipChange.ipc$dispatch("12016615", new Object[]{this}) : this.costTime;
    }

    @Nullable
    public final String getDescLocal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1018084739") ? (String) ipChange.ipc$dispatch("1018084739", new Object[]{this}) : this.descLocal;
    }

    @Nullable
    public final String getFemaleCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1274523980") ? (String) ipChange.ipc$dispatch("1274523980", new Object[]{this}) : this.femaleCount;
    }

    @Nullable
    public final String getGrade() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-559458176") ? (String) ipChange.ipc$dispatch("-559458176", new Object[]{this}) : this.grade;
    }

    @Nullable
    public final ArrayList<String> getHighlightWord() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2055670803") ? (ArrayList) ipChange.ipc$dispatch("2055670803", new Object[]{this}) : this.highlightWord;
    }

    @Nullable
    public final String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "138524616") ? (String) ipChange.ipc$dispatch("138524616", new Object[]{this}) : this.id;
    }

    @Nullable
    public final String getItemScore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-170836760") ? (String) ipChange.ipc$dispatch("-170836760", new Object[]{this}) : this.itemScore;
    }

    @Nullable
    public final String getItemStar() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1768033230") ? (String) ipChange.ipc$dispatch("-1768033230", new Object[]{this}) : this.itemStar;
    }

    @Nullable
    public final String getManCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1106164738") ? (String) ipChange.ipc$dispatch("1106164738", new Object[]{this}) : this.manCount;
    }

    @Nullable
    public final String getMaxPeopleCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1389528855") ? (String) ipChange.ipc$dispatch("-1389528855", new Object[]{this}) : this.maxPeopleCount;
    }

    @Nullable
    public final String getMinPeopleCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1242094139") ? (String) ipChange.ipc$dispatch("1242094139", new Object[]{this}) : this.minPeopleCount;
    }

    @Nullable
    public final String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "49052856") ? (String) ipChange.ipc$dispatch("49052856", new Object[]{this}) : this.name;
    }

    @Nullable
    public final String getPeopleCountDesc() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1037692058")) {
            return (String) ipChange.ipc$dispatch("1037692058", new Object[]{this});
        }
        String str = this.minPeopleCount;
        if (str == null || str.length() == 0) {
            String str2 = this.maxPeopleCount;
            if ((str2 == null || str2.length() == 0) ? true : true) {
                return null;
            }
            return this.maxPeopleCount + (char) 20154;
        }
        String str3 = this.maxPeopleCount;
        if ((str3 == null || str3.length() == 0) ? true : true) {
            return this.minPeopleCount + (char) 20154;
        } else if (b41.d(this.minPeopleCount, this.maxPeopleCount)) {
            return this.minPeopleCount + (char) 20154;
        } else {
            return this.minPeopleCount + '-' + this.maxPeopleCount + (char) 20154;
        }
    }

    @Nullable
    public final String getPeopleDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "931342829") ? (String) ipChange.ipc$dispatch("931342829", new Object[]{this}) : this.peopleDesc;
    }

    @Nullable
    public final String getSchema() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-474324914") ? (String) ipChange.ipc$dispatch("-474324914", new Object[]{this}) : this.schema;
    }

    @Nullable
    public final ArrayList<String> getTagList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1169646887") ? (ArrayList) ipChange.ipc$dispatch("-1169646887", new Object[]{this}) : this.tagList;
    }

    @Nullable
    public final String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1814290024") ? (String) ipChange.ipc$dispatch("-1814290024", new Object[]{this}) : this.url;
    }

    public final void setCostTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "490187223")) {
            ipChange.ipc$dispatch("490187223", new Object[]{this, str});
        } else {
            this.costTime = str;
        }
    }

    public final void setDescLocal(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469349037")) {
            ipChange.ipc$dispatch("-469349037", new Object[]{this, str});
        } else {
            this.descLocal = str;
        }
    }

    public final void setFemaleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444413526")) {
            ipChange.ipc$dispatch("-1444413526", new Object[]{this, str});
        } else {
            this.femaleCount = str;
        }
    }

    public final void setGrade(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1966934026")) {
            ipChange.ipc$dispatch("-1966934026", new Object[]{this, str});
        } else {
            this.grade = str;
        }
    }

    public final void setHighlightWord(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "350012165")) {
            ipChange.ipc$dispatch("350012165", new Object[]{this, arrayList});
        } else {
            this.highlightWord = arrayList;
        }
    }

    public final void setId(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1159352042")) {
            ipChange.ipc$dispatch("-1159352042", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public final void setItemScore(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328790158")) {
            ipChange.ipc$dispatch("1328790158", new Object[]{this, str});
        } else {
            this.itemScore = str;
        }
    }

    public final void setItemStar(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143216876")) {
            ipChange.ipc$dispatch("1143216876", new Object[]{this, str});
        } else {
            this.itemStar = str;
        }
    }

    public final void setManCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "49040668")) {
            ipChange.ipc$dispatch("49040668", new Object[]{this, str});
        } else {
            this.manCount = str;
        }
    }

    public final void setMaxPeopleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757171733")) {
            ipChange.ipc$dispatch("757171733", new Object[]{this, str});
        } else {
            this.maxPeopleCount = str;
        }
    }

    public final void setMinPeopleCount(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "733105923")) {
            ipChange.ipc$dispatch("733105923", new Object[]{this, str});
        } else {
            this.minPeopleCount = str;
        }
    }

    public final void setName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1227881766")) {
            ipChange.ipc$dispatch("1227881766", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public final void setPeopleDesc(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991940497")) {
            ipChange.ipc$dispatch("991940497", new Object[]{this, str});
        } else {
            this.peopleDesc = str;
        }
    }

    public final void setSchema(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080704848")) {
            ipChange.ipc$dispatch("1080704848", new Object[]{this, str});
        } else {
            this.schema = str;
        }
    }

    public final void setTagList(@Nullable ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788677121")) {
            ipChange.ipc$dispatch("-1788677121", new Object[]{this, arrayList});
        } else {
            this.tagList = arrayList;
        }
    }

    public final void setUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1010132190")) {
            ipChange.ipc$dispatch("1010132190", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }
}
