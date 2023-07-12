package cn.damai.common.soloader.relinker;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ReLinkerInstance$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ C0523a this$0;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$library;
    final /* synthetic */ ReLinker$LoadListener val$listener;
    final /* synthetic */ String val$version;

    ReLinkerInstance$1(C0523a c0523a, Context context, String str, String str2, ReLinker$LoadListener reLinker$LoadListener) {
        this.val$context = context;
        this.val$library = str;
        this.val$version = str2;
        this.val$listener = reLinker$LoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385636144")) {
            ipChange.ipc$dispatch("385636144", new Object[]{this});
            return;
        }
        try {
            C0523a.a(this.this$0, this.val$context, this.val$library, this.val$version);
            this.val$listener.success();
        } catch (MissingLibraryException e) {
            this.val$listener.failure(e);
        } catch (UnsatisfiedLinkError e2) {
            this.val$listener.failure(e2);
        }
    }
}
