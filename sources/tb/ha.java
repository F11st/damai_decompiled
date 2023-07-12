package tb;

import com.airbnb.lottie.model.animatable.AnimatableValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class ha<V, O> implements AnimatableValue<V, O> {
    final List<u71<V>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha(V v) {
        this(Collections.singletonList(new u71(v)));
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<u71<V>> getKeyframes() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public boolean isStatic() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).h());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha(List<u71<V>> list) {
        this.a = list;
    }
}
