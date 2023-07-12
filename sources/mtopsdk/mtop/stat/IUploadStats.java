package mtopsdk.mtop.stat;

import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IUploadStats {
    void onCommit(String str, String str2, Map<String, String> map, Map<String, Double> map2);

    void onRegister(String str, String str2, Set<String> set, Set<String> set2, boolean z);
}
