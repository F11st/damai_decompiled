package com.youku.live.messagechannel.message;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.messagechannel.utils.MyLog;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observer;
import io.reactivex.b;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MCMessageStream<T> implements Observer<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TAG = getClass().getName();
    private PublishSubject<T> subject = PublishSubject.c();

    public b<T> getObservable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "735913023") ? (b) ipChange.ipc$dispatch("735913023", new Object[]{this}) : this.subject.toFlowable(BackpressureStrategy.BUFFER);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-397083542")) {
            ipChange.ipc$dispatch("-397083542", new Object[]{this});
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025303798")) {
            ipChange.ipc$dispatch("2025303798", new Object[]{this, th});
        } else {
            MyLog.e(this.TAG, "Message stream error.", th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "395582284")) {
            ipChange.ipc$dispatch("395582284", new Object[]{this, t});
            return;
        }
        try {
            MyLog.v(this.TAG, "Message stream onNext, className: ", t.getClass().getName());
            this.subject.onNext(t);
        } catch (Exception e) {
            onError(e);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1029520687")) {
            ipChange.ipc$dispatch("1029520687", new Object[]{this, disposable});
        }
    }
}
