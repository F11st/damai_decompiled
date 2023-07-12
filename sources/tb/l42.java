package tb;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class l42 {
    @NotNull
    private final z52 a;
    @NotNull
    private final SVGAVideoEntity b;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class a {
        @Nullable
        private final String a;
        @NotNull
        private final e52 b;

        public a(@Nullable l42 l42Var, @NotNull String str, e52 e52Var) {
            b41.j(e52Var, "frameEntity");
            this.a = str;
            this.b = e52Var;
        }

        @NotNull
        public final e52 a() {
            return this.b;
        }

        @Nullable
        public final String b() {
            return this.a;
        }
    }

    public l42(@NotNull SVGAVideoEntity sVGAVideoEntity) {
        b41.j(sVGAVideoEntity, "videoItem");
        this.b = sVGAVideoEntity;
        this.a = new z52();
    }

    public void a(@NotNull Canvas canvas, int i, @NotNull ImageView.ScaleType scaleType) {
        b41.j(canvas, "canvas");
        b41.j(scaleType, "scaleType");
        d(canvas, scaleType);
    }

    @NotNull
    public final z52 b() {
        return this.a;
    }

    @NotNull
    public final SVGAVideoEntity c() {
        return this.b;
    }

    public void d(@NotNull Canvas canvas, @NotNull ImageView.ScaleType scaleType) {
        b41.j(canvas, "canvas");
        b41.j(scaleType, "scaleType");
        this.a.g(canvas.getWidth(), canvas.getHeight(), (float) this.b.h().b(), (float) this.b.h().a(), scaleType);
    }

    @NotNull
    public final List<a> e(int i) {
        List<d52> g = this.b.g();
        ArrayList arrayList = new ArrayList();
        for (d52 d52Var : g) {
            a aVar = null;
            if (i >= 0 && i < d52Var.a().size() && d52Var.a().get(i).a() > 0.0d) {
                aVar = new a(this, d52Var.b(), d52Var.a().get(i));
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
