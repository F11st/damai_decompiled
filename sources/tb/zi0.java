package tb;

import java.io.File;
import java.io.FileOutputStream;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class zi0 extends yi0 {
    public static void a(@NotNull File file, @NotNull byte[] bArr) {
        b41.i(file, "<this>");
        b41.i(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            wt2 wt2Var = wt2.INSTANCE;
            xj.a(fileOutputStream, null);
        } finally {
        }
    }
}
