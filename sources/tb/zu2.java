package tb;

import com.uploader.export.IUploaderEnvironment;
import com.uploader.export.UploaderGlobal;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class zu2 implements IUploaderEnvironment {
    private final int instanceType;

    public zu2(int i) {
        this.instanceType = i;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    @Deprecated
    public final String getAppKey() {
        return getCurrentElement().b;
    }

    public ze0 getCurrentElement() {
        return UploaderGlobal.b(getEnvironment(), getInstanceType());
    }

    @Override // com.uploader.export.IUploaderEnvironment
    @Deprecated
    public final String getDomain() {
        return getCurrentElement().c;
    }

    @Override // com.uploader.export.IUploaderEnvironment
    @Deprecated
    public abstract int getEnvironment();

    @Override // com.uploader.export.IUploaderEnvironment
    public final int getInstanceType() {
        return this.instanceType;
    }
}
