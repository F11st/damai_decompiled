package ntk.cellular;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
@RequiresApi(api = 21)
/* loaded from: classes2.dex */
public class a {
    private static volatile String e = "";
    @Nullable
    protected Network a = null;
    protected ConcurrentHashMap<Integer, ParcelFileDescriptor> b = new ConcurrentHashMap<>();
    private int c = -100;
    protected final ConnectivityManager.NetworkCallback d = new C0439a();

    /* compiled from: Taobao */
    /* renamed from: ntk.cellular.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0439a extends ConnectivityManager.NetworkCallback {
        C0439a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            a aVar = a.this;
            aVar.a = network;
            aVar.k(0);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            a.this.k(-3);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            a.this.k(-2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT != 23;
    }

    public static String g(@Nullable Context context) {
        synchronized (e) {
            if (context != null) {
                if (TextUtils.isEmpty(e)) {
                    File file = new File(context.getFilesDir().getAbsolutePath(), "ntk_cfg");
                    if (file.exists() && !file.isDirectory()) {
                        file.delete();
                    }
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    e = file.getAbsolutePath();
                }
            }
        }
        return e;
    }

    public synchronized void b(Context context) {
        if (this.a == null) {
            return;
        }
        if (a(context)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            Log.i("HTTP_KIT_LOG", "closeChannel!" + getClass().getSimpleName());
            connectivityManager.unregisterNetworkCallback(this.d);
            k(-99);
            this.a = null;
        }
    }

    public synchronized boolean c(int i) {
        if (i == 0) {
            return false;
        }
        ParcelFileDescriptor parcelFileDescriptor = this.b.get(Integer.valueOf(i));
        if (parcelFileDescriptor == null) {
            return false;
        }
        try {
            parcelFileDescriptor.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.b.remove(Integer.valueOf(i));
        return true;
    }

    public synchronized int d(String str) {
        if (str != null) {
            if (str.length() > 0) {
                try {
                    URL url = new URL(str);
                    if (url.getPort() <= -1) {
                        url.getDefaultPort();
                    }
                    Network network = this.a;
                    if (network == null) {
                        return 0;
                    }
                    ParcelFileDescriptor fromSocket = ParcelFileDescriptor.fromSocket(network.getSocketFactory().createSocket());
                    int fd = fromSocket.getFd();
                    this.b.put(Integer.valueOf(fd), fromSocket);
                    return fd;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
        }
        return 0;
    }

    public synchronized int e(String str, String str2) {
        Socket createSocket;
        if (str != null) {
            if (str.length() > 0) {
                try {
                    URL url = new URL(str);
                    int port = url.getPort();
                    if (port <= -1) {
                        port = url.getDefaultPort();
                    }
                    Network network = this.a;
                    if (network == null) {
                        return 0;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        createSocket = network.getSocketFactory().createSocket(url.getHost(), port);
                    } else {
                        createSocket = network.getSocketFactory().createSocket(InetAddress.getByName(str2), port);
                    }
                    ParcelFileDescriptor fromSocket = ParcelFileDescriptor.fromSocket(createSocket);
                    int fd = fromSocket.getFd();
                    this.b.put(Integer.valueOf(fd), fromSocket);
                    return fd;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return -1;
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized int f() {
        return this.c;
    }

    public int h(Context context) {
        int f = f();
        if (f == 0 || Settings.Global.getInt(context.getContentResolver(), "mobile_data", -10) == 1) {
            return f;
        }
        return -10;
    }

    public synchronized void i(Context context) {
        if (this.a != null) {
            return;
        }
        if (a(context)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return;
            }
            Log.i("HTTP_KIT_LOG", "will openChannel cell!");
            connectivityManager.requestNetwork(new NetworkRequest.Builder().addTransportType(0).addCapability(12).build(), this.d);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() != 5) {
                k(-4);
            }
            Log.i("HTTP_KIT_LOG", "MobileNetworkInfo state :" + telephonyManager.getSimState());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> j(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Network network = this.a;
        if (network == null) {
            return arrayList;
        }
        try {
            InetAddress[] allByName = network.getAllByName(str);
            int length = allByName.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                InetAddress inetAddress = allByName[i];
                if (inetAddress instanceof Inet6Address) {
                    arrayList.add(inetAddress.getHostAddress());
                    break;
                }
                i++;
            }
            for (InetAddress inetAddress2 : allByName) {
                if (inetAddress2 instanceof Inet4Address) {
                    arrayList.add(inetAddress2.getHostAddress());
                    if (arrayList.size() > 5) {
                        break;
                    }
                }
            }
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    protected synchronized void k(int i) {
        this.c = i;
        Log.i("HTTP_KIT_LOG", "setAvailable openChannel:" + getClass().getSimpleName() + " available:" + i);
    }
}
