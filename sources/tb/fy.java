package tb;

import com.taobao.android.dinamicx.IDXElderTextSizeStrategy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fy {
    private IDXElderTextSizeStrategy a;
    private final Map<Float, Float> b = new ConcurrentHashMap(512);

    public fy(IDXElderTextSizeStrategy iDXElderTextSizeStrategy) {
        this.a = iDXElderTextSizeStrategy;
    }

    public Float a(Float f) {
        if (this.b.containsKey(f)) {
            return this.b.get(f);
        }
        IDXElderTextSizeStrategy iDXElderTextSizeStrategy = this.a;
        if (iDXElderTextSizeStrategy == null) {
            return f;
        }
        float convertTextSize = iDXElderTextSizeStrategy.convertTextSize(f.floatValue());
        this.b.put(f, Float.valueOf(convertTextSize));
        return Float.valueOf(convertTextSize);
    }
}
