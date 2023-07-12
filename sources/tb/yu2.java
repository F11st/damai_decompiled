package tb;

import android.content.Context;
import androidx.annotation.NonNull;
import com.uploader.export.IUploaderDependency;
import com.uploader.export.IUploaderEnvironment;
import com.uploader.export.IUploaderLog;
import com.uploader.export.IUploaderStatistics;
import com.uploader.export.UploaderGlobal;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yu2 implements IUploaderDependency {
    static Context d;
    private IUploaderEnvironment a;
    private IUploaderLog b;
    private IUploaderStatistics c;

    public yu2() {
        this(null, new av2(UploaderGlobal.f()), new cv2(), new dv2());
    }

    @Override // com.uploader.export.IUploaderDependency
    @NonNull
    public IUploaderEnvironment getEnvironment() {
        return this.a;
    }

    @Override // com.uploader.export.IUploaderDependency
    public IUploaderLog getLog() {
        return this.b;
    }

    @Override // com.uploader.export.IUploaderDependency
    public IUploaderStatistics getStatistics() {
        return this.c;
    }

    public yu2(Context context) {
        this(context, new av2(context), new cv2(), new dv2());
    }

    public yu2(Context context, IUploaderEnvironment iUploaderEnvironment) {
        this(context, iUploaderEnvironment, new cv2(), new dv2());
    }

    public yu2(Context context, IUploaderEnvironment iUploaderEnvironment, IUploaderLog iUploaderLog, IUploaderStatistics iUploaderStatistics) {
        if (context == null) {
            d = UploaderGlobal.f();
        } else {
            d = context;
        }
        this.a = iUploaderEnvironment;
        this.b = iUploaderLog;
        this.c = iUploaderStatistics;
    }
}
