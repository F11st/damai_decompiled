package tb;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class eg0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "sb.toString()");
        return sb2;
    }
}
