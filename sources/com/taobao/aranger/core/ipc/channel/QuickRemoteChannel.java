package com.taobao.aranger.core.ipc.channel;

import android.app.ActivityThread;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Call;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.ipc.proxy.RemoteServiceProxy;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IRemoteService;
import com.taobao.aranger.utils.IPCUtils;
import com.taobao.aranger.utils.ReflectUtils;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.z01;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class QuickRemoteChannel extends b {
    private static final String f = "QuickRemoteChannel";
    private static final Set<String> g = new CopyOnWriteArraySet();
    private final Uri c;
    private final String d;
    private IRemoteService e;
    private final ActivityThread b = ActivityThread.currentActivityThread();
    private final ContentResolver a = ARanger.getContext().getContentResolver();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class QuickBinderDeathRecipient implements IBinder.DeathRecipient {
        private final IBinder iBinder;
        private final String processName;

        public QuickBinderDeathRecipient(IBinder iBinder, String str) {
            this.iBinder = iBinder;
            this.processName = str;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            try {
                this.iBinder.unlinkToDeath(this, 0);
                synchronized (QuickRemoteChannel.class) {
                    if (!TextUtils.isEmpty(this.processName) && QuickRemoteChannel.g.contains(this.processName)) {
                        Intent intent = new Intent();
                        intent.setAction(Constants.ACTION_DISCONNECT);
                        intent.putExtra(Constants.PARAM_PROCESS_NAME, this.processName);
                        ARanger.getContext().sendBroadcast(intent);
                        QuickRemoteChannel.g.remove(this.processName);
                    }
                }
            } catch (Exception e) {
                z01.c(QuickRemoteChannel.f, "[QuickBinderDeathRecipient][binderDied]", e, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QuickRemoteChannel(Uri uri) {
        this.c = uri;
        this.d = IPCUtils.getProcessNameFromUri(uri);
    }

    private IRemoteService i(Uri uri) throws Exception {
        IRemoteService iRemoteService = this.e;
        if (iRemoteService == null || (iRemoteService.isRemote() && !this.e.asBinder().isBinderAlive())) {
            IContentProvider iContentProvider = null;
            try {
                try {
                    Method hideMethod = ReflectUtils.getHideMethod(ContentResolver.class, Constants.ACQUIRE_UNSTABLE_PROVIDER, Uri.class);
                    hideMethod.setAccessible(true);
                    iContentProvider = (IContentProvider) hideMethod.invoke(this.a, uri);
                } catch (Exception e) {
                    z01.c(f, "[getRemoteService][acquireUnstableProvider]", e, new Object[0]);
                }
                if (iContentProvider == null) {
                    try {
                        String authority = uri.getAuthority();
                        Method hideMethod2 = ReflectUtils.getHideMethod(ContentResolver.class, Constants.ACQUIRE_UNSTABLE_PROVIDER, Context.class, String.class);
                        hideMethod2.setAccessible(true);
                        iContentProvider = (IContentProvider) hideMethod2.invoke(this.a, ARanger.getContext(), authority);
                    } catch (Exception e2) {
                        z01.c(f, "[getRemoteService][acquireUnstableProvider]", e2, new Object[0]);
                    }
                }
                if (iContentProvider == null) {
                    int i = Build.VERSION.SDK_INT;
                    if (i <= 16) {
                        iContentProvider = this.b.acquireProvider(ARanger.getContext(), uri.getAuthority(), false);
                    } else if (i < 21) {
                        iContentProvider = this.b.acquireProvider(ARanger.getContext(), uri.getAuthority(), Binder.getCallingUid() / 100000, false);
                    } else {
                        iContentProvider = this.b.acquireProvider(ARanger.getContext(), IPCUtils.getAuthorityWithoutUserId(uri.getAuthority()), IPCUtils.getUserIdFromAuthority(uri.getAuthority(), Process.myUserHandle().hashCode()), false);
                    }
                }
                if (iContentProvider != null) {
                    this.e = RemoteServiceProxy.a(iContentProvider.asBinder());
                } else {
                    throw new IPCException(19, "can't get content provider");
                }
            } catch (Exception e3) {
                throw new IPCException(19, e3);
            }
        }
        if (this.e.isRemote()) {
            Set<String> set = g;
            if (!set.contains(this.d)) {
                set.add(this.d);
                IBinder asBinder = this.e.asBinder();
                try {
                    asBinder.linkToDeath(new QuickBinderDeathRecipient(asBinder, this.d), 0);
                } catch (RemoteException e4) {
                    z01.c(f, "[getRemoteService][linkToDeath]", e4, new Object[0]);
                }
            }
        }
        return this.e;
    }

    @Override // com.taobao.aranger.core.ipc.channel.b
    public void c() throws IPCException {
        try {
            i(this.c).connect();
        } catch (Exception e) {
            if (!(e instanceof IPCException)) {
                if (e instanceof RemoteException) {
                    throw new IPCException(1, e);
                }
                throw new IPCException(9, e);
            }
            throw ((IPCException) e);
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.b
    public Reply d(Call call) throws IPCException {
        try {
            return i(this.c).sendCall(call);
        } catch (Exception e) {
            if (!(e instanceof IPCException)) {
                if (e instanceof RemoteException) {
                    throw new IPCException(1, e);
                }
                throw new IPCException(9, e);
            }
            throw ((IPCException) e);
        }
    }

    @Override // com.taobao.aranger.core.ipc.channel.IChannel
    public void internalRecycle(List<String> list) throws IPCException {
        try {
            i(this.c).recycle(list);
        } catch (Exception e) {
            if (!(e instanceof IPCException)) {
                if (e instanceof RemoteException) {
                    throw new IPCException(1, e);
                }
                throw new IPCException(9, e);
            }
            throw ((IPCException) e);
        }
    }
}
