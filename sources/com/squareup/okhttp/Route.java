package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class Route {
    final Address address;
    final ConnectionSpec connectionSpec;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;
    final boolean shouldSendTlsFallbackIndicator;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress, ConnectionSpec connectionSpec) {
        this(address, proxy, inetSocketAddress, connectionSpec, false);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return this.address.equals(route.address) && this.proxy.equals(route.proxy) && this.inetSocketAddress.equals(route.inetSocketAddress) && this.connectionSpec.equals(route.connectionSpec) && this.shouldSendTlsFallbackIndicator == route.shouldSendTlsFallbackIndicator;
        }
        return false;
    }

    public Address getAddress() {
        return this.address;
    }

    public ConnectionSpec getConnectionSpec() {
        return this.connectionSpec;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public boolean getShouldSendTlsFallbackIndicator() {
        return this.shouldSendTlsFallbackIndicator;
    }

    public InetSocketAddress getSocketAddress() {
        return this.inetSocketAddress;
    }

    public int hashCode() {
        return ((((((((527 + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode()) * 31) + this.connectionSpec.hashCode()) * 31) + (this.shouldSendTlsFallbackIndicator ? 1 : 0);
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress, ConnectionSpec connectionSpec, boolean z) {
        Objects.requireNonNull(address, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        Objects.requireNonNull(connectionSpec, "connectionConfiguration == null");
        this.address = address;
        this.proxy = proxy;
        this.inetSocketAddress = inetSocketAddress;
        this.connectionSpec = connectionSpec;
        this.shouldSendTlsFallbackIndicator = z;
    }
}
