package tb;

import com.taobao.downloader.download.protocol.DLInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jv0 implements DLInputStream {
    private InputStream a;

    public jv0(InputStream inputStream) {
        this.a = new BufferedInputStream(inputStream, C9613qq.f);
    }

    @Override // com.taobao.downloader.download.protocol.DLInputStream
    public void close() throws Exception {
        this.a.close();
    }

    @Override // com.taobao.downloader.download.protocol.DLInputStream
    public int read(byte[] bArr) throws Exception {
        return this.a.read(bArr, 0, bArr.length);
    }
}
