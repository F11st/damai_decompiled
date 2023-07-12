package cn.damai.common.image.luban;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface InputStreamProvider {
    String getPath();

    InputStream open() throws IOException;
}
