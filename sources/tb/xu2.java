package tb;

import com.alibaba.pictures.uploader.FileUploader;
import com.alibaba.pictures.uploader.UploadStatus;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class xu2 implements ITaskListener {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final FileUploader a;

    public xu2(@NotNull FileUploader fileUploader) {
        b41.i(fileUploader, "fileUploader");
        this.a = fileUploader;
    }

    @Override // com.uploader.export.ITaskListener
    public void onCancel(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1523913329")) {
            ipChange.ipc$dispatch("-1523913329", new Object[]{this, iUploaderTask});
        } else {
            this.a.t(iUploaderTask);
        }
    }

    @Override // com.uploader.export.ITaskListener
    public void onFailure(@Nullable IUploaderTask iUploaderTask, @Nullable fl2 fl2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-671126527")) {
            ipChange.ipc$dispatch("-671126527", new Object[]{this, iUploaderTask, fl2Var});
        } else {
            this.a.u(iUploaderTask, fl2Var);
        }
    }

    @Override // com.uploader.export.ITaskListener
    public void onPause(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394997361")) {
            ipChange.ipc$dispatch("394997361", new Object[]{this, iUploaderTask});
        } else {
            this.a.v(iUploaderTask, UploadStatus.PAUSE);
        }
    }

    @Override // com.uploader.export.ITaskListener
    public void onProgress(@Nullable IUploaderTask iUploaderTask, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673180799")) {
            ipChange.ipc$dispatch("-673180799", new Object[]{this, iUploaderTask, Integer.valueOf(i)});
        } else {
            this.a.w(iUploaderTask, i);
        }
    }

    @Override // com.uploader.export.ITaskListener
    public void onResume(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-399464190")) {
            ipChange.ipc$dispatch("-399464190", new Object[]{this, iUploaderTask});
        } else {
            this.a.v(iUploaderTask, UploadStatus.RESUME);
        }
    }

    @Override // com.uploader.export.ITaskListener
    public void onStart(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952132643")) {
            ipChange.ipc$dispatch("-952132643", new Object[]{this, iUploaderTask});
        } else {
            this.a.v(iUploaderTask, UploadStatus.START);
        }
    }

    @Override // com.uploader.export.ITaskListener
    public void onSuccess(@Nullable IUploaderTask iUploaderTask, @Nullable ITaskResult iTaskResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1470273632")) {
            ipChange.ipc$dispatch("-1470273632", new Object[]{this, iUploaderTask, iTaskResult});
        } else {
            this.a.x(iUploaderTask, iTaskResult);
        }
    }

    @Override // com.uploader.export.ITaskListener
    public void onWait(@Nullable IUploaderTask iUploaderTask) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "127653770")) {
            ipChange.ipc$dispatch("127653770", new Object[]{this, iUploaderTask});
        } else {
            this.a.v(iUploaderTask, UploadStatus.WAIT);
        }
    }
}
