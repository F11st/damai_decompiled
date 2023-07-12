package tb;

import android.graphics.Path;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class v42 {
    private final String a;
    private Path b;

    public v42(@NotNull String str) {
        boolean K;
        b41.j(str, "originValue");
        K = StringsKt__StringsKt.K(str, ",", false, 2, null);
        this.a = K ? kotlin.text.o.z(str, ",", " ", false, 4, null) : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(android.graphics.Path r16, java.lang.String r17, java.util.StringTokenizer r18) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.v42.b(android.graphics.Path, java.lang.String, java.util.StringTokenizer):void");
    }

    public final void a(@NotNull Path path) {
        Set set;
        b41.j(path, "toPath");
        Path path2 = this.b;
        if (path2 != null) {
            path.set(path2);
            return;
        }
        Path path3 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.a, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!(nextToken.length() == 0)) {
                set = w42.a;
                if (set.contains(nextToken)) {
                    b41.e(nextToken, "segment");
                    if (b41.d(nextToken, "Z") || b41.d(nextToken, "z")) {
                        b(path3, nextToken, new StringTokenizer("", ""));
                    }
                    str = nextToken;
                } else {
                    b(path3, str, new StringTokenizer(nextToken, " "));
                }
            }
        }
        this.b = path3;
        path.set(path3);
    }
}
