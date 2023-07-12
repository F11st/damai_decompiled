package com.squareup.okhttp.internal.http;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Network;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import tb.jg1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RouteSelector {
    private final Address address;
    private final OkHttpClient client;
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private ConnectionSpec lastSpec;
    private final Network network;
    private int nextInetSocketAddressIndex;
    private int nextProxyIndex;
    private int nextSpecIndex;
    private final Request request;
    private final RouteDatabase routeDatabase;
    private final URI uri;
    private List<Proxy> proxies = Collections.emptyList();
    private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    private List<ConnectionSpec> connectionSpecs = Collections.emptyList();
    private final List<Route> postponedRoutes = new ArrayList();

    private RouteSelector(Address address, URI uri, OkHttpClient okHttpClient, Request request) {
        this.address = address;
        this.uri = uri;
        this.client = okHttpClient;
        this.routeDatabase = Internal.instance.routeDatabase(okHttpClient);
        this.network = Internal.instance.network(okHttpClient);
        this.request = request;
        resetNextProxy(uri, address.getProxy());
    }

    public static RouteSelector get(Address address, Request request, OkHttpClient okHttpClient) throws IOException {
        return new RouteSelector(address, request.uri(), okHttpClient, request);
    }

    static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean hasNextConnectionSpec() {
        return this.nextSpecIndex < this.connectionSpecs.size();
    }

    private boolean hasNextInetSocketAddress() {
        return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
    }

    private boolean hasNextPostponed() {
        return !this.postponedRoutes.isEmpty();
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private ConnectionSpec nextConnectionSpec() throws IOException {
        boolean isEmpty = this.connectionSpecs.isEmpty();
        String str = WVUtils.URL_SEPARATOR;
        if (isEmpty) {
            StringBuilder sb = new StringBuilder();
            sb.append("No route to ");
            if (this.uri.getScheme() != null) {
                str = this.uri.getScheme() + jg1.SCHEME_SLASH;
            }
            sb.append(str);
            sb.append(this.address.getUriHost());
            sb.append("; no connection specs");
            throw new UnknownServiceException(sb.toString());
        } else if (!hasNextConnectionSpec()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No route to ");
            if (this.uri.getScheme() != null) {
                str = this.uri.getScheme() + jg1.SCHEME_SLASH;
            }
            sb2.append(str);
            sb2.append(this.address.getUriHost());
            sb2.append("; exhausted connection specs: ");
            sb2.append(this.connectionSpecs);
            throw new SocketException(sb2.toString());
        } else {
            List<ConnectionSpec> list = this.connectionSpecs;
            int i = this.nextSpecIndex;
            this.nextSpecIndex = i + 1;
            return list.get(i);
        }
    }

    private InetSocketAddress nextInetSocketAddress() throws IOException {
        if (hasNextInetSocketAddress()) {
            List<InetSocketAddress> list = this.inetSocketAddresses;
            int i = this.nextInetSocketAddressIndex;
            this.nextInetSocketAddressIndex = i + 1;
            InetSocketAddress inetSocketAddress = list.get(i);
            resetConnectionSpecs();
            return inetSocketAddress;
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted inet socket addresses: " + this.inetSocketAddresses);
    }

    private Route nextPostponed() {
        return this.postponedRoutes.remove(0);
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List<Proxy> list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted proxy configurations: " + this.proxies);
    }

    private void resetConnectionSpecs() {
        this.connectionSpecs = new ArrayList();
        List<ConnectionSpec> connectionSpecs = this.address.getConnectionSpecs();
        int size = connectionSpecs.size();
        for (int i = 0; i < size; i++) {
            ConnectionSpec connectionSpec = connectionSpecs.get(i);
            if (this.request.isHttps() == connectionSpec.isTls()) {
                this.connectionSpecs.add(connectionSpec);
            }
        }
        this.nextSpecIndex = 0;
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws IOException {
        String uriHost;
        int effectivePort;
        this.inetSocketAddresses = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                uriHost = getHostString(inetSocketAddress);
                effectivePort = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            uriHost = this.address.getUriHost();
            effectivePort = Util.getEffectivePort(this.uri);
        }
        if (effectivePort >= 1 && effectivePort <= 65535) {
            for (InetAddress inetAddress : this.network.resolveInetAddresses(uriHost)) {
                this.inetSocketAddresses.add(new InetSocketAddress(inetAddress, effectivePort));
            }
            this.nextInetSocketAddressIndex = 0;
            return;
        }
        throw new SocketException("No route to " + uriHost + ":" + effectivePort + "; port is out of range");
    }

    private void resetNextProxy(URI uri, Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            this.proxies = new ArrayList();
            List<Proxy> select = this.client.getProxySelector().select(uri);
            if (select != null) {
                this.proxies.addAll(select);
            }
            this.proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.proxies.add(Proxy.NO_PROXY);
        }
        this.nextProxyIndex = 0;
    }

    private boolean shouldSendTlsFallbackIndicator(ConnectionSpec connectionSpec) {
        return connectionSpec != this.connectionSpecs.get(0) && connectionSpec.isTls();
    }

    public void connectFailed(Route route, IOException iOException) {
        if (route.getProxy().type() != Proxy.Type.DIRECT && this.address.getProxySelector() != null) {
            this.address.getProxySelector().connectFailed(this.uri, route.getProxy().address(), iOException);
        }
        this.routeDatabase.failed(route);
        if ((iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException)) {
            return;
        }
        while (this.nextSpecIndex < this.connectionSpecs.size()) {
            List<ConnectionSpec> list = this.connectionSpecs;
            int i = this.nextSpecIndex;
            this.nextSpecIndex = i + 1;
            ConnectionSpec connectionSpec = list.get(i);
            this.routeDatabase.failed(new Route(this.address, this.lastProxy, this.lastInetSocketAddress, connectionSpec, shouldSendTlsFallbackIndicator(connectionSpec)));
        }
    }

    public boolean hasNext() {
        return hasNextConnectionSpec() || hasNextInetSocketAddress() || hasNextProxy() || hasNextPostponed();
    }

    public Route next() throws IOException {
        if (!hasNextConnectionSpec()) {
            if (!hasNextInetSocketAddress()) {
                if (!hasNextProxy()) {
                    if (hasNextPostponed()) {
                        return nextPostponed();
                    }
                    throw new NoSuchElementException();
                }
                this.lastProxy = nextProxy();
            }
            this.lastInetSocketAddress = nextInetSocketAddress();
        }
        ConnectionSpec nextConnectionSpec = nextConnectionSpec();
        this.lastSpec = nextConnectionSpec;
        Route route = new Route(this.address, this.lastProxy, this.lastInetSocketAddress, this.lastSpec, shouldSendTlsFallbackIndicator(nextConnectionSpec));
        if (this.routeDatabase.shouldPostpone(route)) {
            this.postponedRoutes.add(route);
            return next();
        }
        return route;
    }
}
