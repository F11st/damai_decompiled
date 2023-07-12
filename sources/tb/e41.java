package tb;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class e41 {
    public static BufferedReader a(String str) {
        return new BufferedReader(new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
    }
}
