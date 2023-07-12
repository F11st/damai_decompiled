package cn.damai.mine.report;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static transient /* synthetic */ IpChange $ipChange;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile ViewModelFactory INSTANCE;
    private final Application mApplication;
    private final ReportRepository mRepository;

    private ViewModelFactory(Application application, ReportRepository reportRepository) {
        this.mApplication = application;
        this.mRepository = reportRepository;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369024514")) {
            ipChange.ipc$dispatch("-369024514", new Object[0]);
        } else {
            INSTANCE = null;
        }
    }

    public static ViewModelFactory getInstance(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-757189618")) {
            return (ViewModelFactory) ipChange.ipc$dispatch("-757189618", new Object[]{application});
        }
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(application, ReportRepository.a());
                }
            }
        }
        return INSTANCE;
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000451024")) {
            return (T) ipChange.ipc$dispatch("2000451024", new Object[]{this, cls});
        }
        if (cls.isAssignableFrom(ReportViewModel.class)) {
            return new ReportViewModel(this.mApplication, this.mRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + cls.getName());
    }
}
