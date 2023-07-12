package com.alibaba.pictures.uploader;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.uu2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u000f"}, d2 = {"Lcom/alibaba/pictures/uploader/FileUploadListener;", "", "", "Ltb/uu2;", "uploadInfoGroup", "Ltb/wt2;", "onAllSuccess", "Lcom/alibaba/pictures/uploader/UploadErrorCode;", "errorCode", "onFailure", "onSingleTaskProgress", "", "progress", "onAllTaskProgress", "onCancel", "uploader_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public interface FileUploadListener {
    void onAllSuccess(@NotNull List<uu2> list);

    void onAllTaskProgress(float f);

    void onCancel();

    void onFailure(@NotNull UploadErrorCode uploadErrorCode, @NotNull List<uu2> list);

    void onSingleTaskProgress(@Nullable uu2 uu2Var);
}
