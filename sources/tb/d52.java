package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class d52 {
    @Nullable
    private final String a;
    @NotNull
    private final List<e52> b;

    public d52(@NotNull JSONObject jSONObject) {
        List<e52> A0;
        SVGAVideoShapeEntity sVGAVideoShapeEntity;
        b41.j(jSONObject, "obj");
        this.a = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    e52 e52Var = new e52(optJSONObject);
                    if ((!e52Var.d().isEmpty()) && (sVGAVideoShapeEntity = (SVGAVideoShapeEntity) kotlin.collections.k.P(e52Var.d())) != null && sVGAVideoShapeEntity.e() && arrayList.size() > 0) {
                        e52Var.f(((e52) kotlin.collections.k.b0(arrayList)).d());
                    }
                    arrayList.add(e52Var);
                }
            }
        }
        A0 = CollectionsKt___CollectionsKt.A0(arrayList);
        this.b = A0;
    }

    @NotNull
    public final List<e52> a() {
        return this.b;
    }

    @Nullable
    public final String b() {
        return this.a;
    }

    public d52(@NotNull SpriteEntity spriteEntity) {
        List<e52> g;
        int q;
        SVGAVideoShapeEntity sVGAVideoShapeEntity;
        b41.j(spriteEntity, "obj");
        this.a = spriteEntity.imageKey;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            q = kotlin.collections.n.q(list, 10);
            g = new ArrayList<>(q);
            e52 e52Var = null;
            for (FrameEntity frameEntity : list) {
                b41.e(frameEntity, AdvanceSetting.NETWORK_TYPE);
                e52 e52Var2 = new e52(frameEntity);
                if ((!e52Var2.d().isEmpty()) && (sVGAVideoShapeEntity = (SVGAVideoShapeEntity) kotlin.collections.k.P(e52Var2.d())) != null && sVGAVideoShapeEntity.e() && e52Var != null) {
                    e52Var2.f(e52Var.d());
                }
                g.add(e52Var2);
                e52Var = e52Var2;
            }
        } else {
            g = kotlin.collections.m.g();
        }
        this.b = g;
    }
}
