package tb;

import com.real.android.nativehtml.common.dom.Platform;
import com.real.android.nativehtml.common.io.InternalLinkHandler;
import com.real.android.nativehtml.common.io.RequestHandler;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class b60 implements RequestHandler {
    private final Platform a;
    private TreeSet<String> b = new TreeSet<>();
    protected InternalLinkHandler c;

    public b60(Platform platform) {
        this.a = platform;
    }

    public void a(String str) {
        this.b.add(str);
    }

    public void b(URI uri) {
        try {
            this.c.loadHtml(new InputStreamReader(this.a.openInputStream(uri), "utf-8"), uri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void c(InternalLinkHandler internalLinkHandler) {
        this.c = internalLinkHandler;
    }

    @Override // com.real.android.nativehtml.common.io.RequestHandler
    public void openLink(URI uri) {
        if (this.c != null) {
            String uri2 = uri.toString();
            Iterator<String> it = this.b.iterator();
            while (it.hasNext()) {
                if (uri2.startsWith(it.next())) {
                    b(uri);
                    return;
                }
            }
        }
        this.a.openInBrowser(uri);
    }
}
