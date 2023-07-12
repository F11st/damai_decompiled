package tb;

import android.graphics.Path;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class id1 {
    private final List<BaseKeyframeAnimation<jb2, Path>> a;
    private final List<BaseKeyframeAnimation<Integer, Integer>> b;
    private final List<Mask> c;

    public id1(List<Mask> list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(list.get(i).b().createAnimation());
            this.b.add(list.get(i).c().createAnimation());
        }
    }

    public List<BaseKeyframeAnimation<jb2, Path>> a() {
        return this.a;
    }

    public List<Mask> b() {
        return this.c;
    }

    public List<BaseKeyframeAnimation<Integer, Integer>> c() {
        return this.b;
    }
}
