package tb;

import com.taobao.phenix.builder.Builder;
import com.taobao.phenix.loader.file.C6860a;
import com.taobao.phenix.loader.file.FileLoader;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class li0 implements Builder<FileLoader> {
    private boolean a;
    private FileLoader b;

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: a */
    public synchronized FileLoader build() {
        if (this.a) {
            return this.b;
        }
        this.a = true;
        if (this.b == null) {
            this.b = new C6860a();
        }
        return this.b;
    }

    @Override // com.taobao.phenix.builder.Builder
    /* renamed from: b */
    public li0 with(FileLoader fileLoader) {
        cu1.e(!this.a, "FileLoaderBuilder has been built, not allow with() now");
        this.b = fileLoader;
        return this;
    }
}
