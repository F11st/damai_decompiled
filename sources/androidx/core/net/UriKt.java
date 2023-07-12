package androidx.core.net;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0001¨\u0006\u0005"}, d2 = {"", "Landroid/net/Uri;", "toUri", "Ljava/io/File;", "toFile", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UriKt {
    @NotNull
    public static final File toFile(@NotNull Uri uri) {
        b41.i(uri, "<this>");
        if (b41.d(uri.getScheme(), "file")) {
            String path = uri.getPath();
            if (path != null) {
                return new File(path);
            }
            throw new IllegalArgumentException(b41.r("Uri path is null: ", uri).toString());
        }
        throw new IllegalArgumentException(b41.r("Uri lacks 'file' scheme: ", uri).toString());
    }

    @NotNull
    public static final Uri toUri(@NotNull String str) {
        b41.i(str, "<this>");
        Uri parse = Uri.parse(str);
        b41.h(parse, "parse(this)");
        return parse;
    }

    @NotNull
    public static final Uri toUri(@NotNull File file) {
        b41.i(file, "<this>");
        Uri fromFile = Uri.fromFile(file);
        b41.h(fromFile, "fromFile(this)");
        return fromFile;
    }
}
