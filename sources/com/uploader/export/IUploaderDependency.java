package com.uploader.export;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IUploaderDependency {
    @NonNull
    IUploaderEnvironment getEnvironment();

    IUploaderLog getLog();

    IUploaderStatistics getStatistics();
}
