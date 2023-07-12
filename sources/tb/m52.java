package tb;

import androidx.annotation.Nullable;
import com.caverock.androidsvg.C4761f;
import com.caverock.androidsvg.SVG;
import com.caverock.ext.SVGTransform;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class m52 {
    @Nullable
    public C4761f a(InputStream inputStream, boolean z) {
        if (inputStream == null) {
            return null;
        }
        if (z) {
            try {
                inputStream = new ByteArrayInputStream(ju1.h(inputStream).getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            try {
                inputStream.reset();
                float a = SVGTransform.a(inputStream);
                inputStream.reset();
                C4761f c4761f = new C4761f(SVG.h(inputStream));
                c4761f.u(a);
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return c4761f;
            } catch (Exception e3) {
                e3.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return null;
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }
}
