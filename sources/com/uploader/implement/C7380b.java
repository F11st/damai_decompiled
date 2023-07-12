package com.uploader.implement;

import com.uploader.export.IUploaderStatistics;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.uploader.implement.b */
/* loaded from: classes11.dex */
public class C7380b {
    private static volatile IUploaderStatistics a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void a(IUploaderStatistics iUploaderStatistics) {
        a = iUploaderStatistics;
    }

    public static void b(String str, String str2, Map<String, Double> map, Map<String, String> map2) {
        IUploaderStatistics iUploaderStatistics = a;
        if (iUploaderStatistics == null) {
            return;
        }
        iUploaderStatistics.onCommit(str, str2, map, map2);
    }

    public static void c(String str, String str2, Set<String> set, Set<String> set2, boolean z) {
        IUploaderStatistics iUploaderStatistics = a;
        if (iUploaderStatistics == null) {
            return;
        }
        iUploaderStatistics.onRegister(str, str2, set, set2, z);
    }
}
