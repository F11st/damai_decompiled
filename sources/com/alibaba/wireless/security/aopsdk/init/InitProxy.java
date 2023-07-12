package com.alibaba.wireless.security.aopsdk.init;

import android.net.LocalServerSocket;
import com.alibaba.wireless.security.aopsdk.AopBridge;
import com.alibaba.wireless.security.aopsdk.AopManager;
import com.alibaba.wireless.security.aopsdk.Invocation;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/* loaded from: classes.dex */
public class InitProxy extends AopBridge {
    public static void BaseDexClassLoaderInitProxy(BaseDexClassLoader baseDexClassLoader, String str, File file, String str2, ClassLoader classLoader) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("dalvik.system.BaseDexClassLoader.<init>(java.lang.String,java.io.File,java.lang.String,java.lang.ClassLoader)", baseDexClassLoader, str, file, str2, classLoader);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void DatagramSocketInitProxy(DatagramSocket datagramSocket) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.DatagramSocket.<init>()", datagramSocket, new Object[0]);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void DexClassLoaderInitProxy(DexClassLoader dexClassLoader, String str, String str2, String str3, ClassLoader classLoader) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("dalvik.system.DexClassLoader.<init>(java.lang.String,java.lang.String,java.lang.String,java.lang.ClassLoader)", dexClassLoader, str, str2, str3, classLoader);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileInitProxy(File file, String str) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.File.<init>(java.lang.String)", file, str);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileInputStreamInitProxy(FileInputStream fileInputStream, String str) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.FileInputStream.<init>(java.lang.String)", fileInputStream, str);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileOutputStreamInitProxy(FileOutputStream fileOutputStream, String str) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.FileOutputStream.<init>(java.lang.String)", fileOutputStream, str);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void HttpURLConnectionInitProxy(HttpURLConnection httpURLConnection) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.HttpURLConnection.<init>()", httpURLConnection, new Object[0]);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void LocalServerSocketInitProxy(LocalServerSocket localServerSocket, String str) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("android.net.LocalServerSocket.<init>(java.lang.String)", localServerSocket, str);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void PathClassLoaderInitProxy(PathClassLoader pathClassLoader, String str, ClassLoader classLoader) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("dalvik.system.PathClassLoader.<init>(java.lang.String,java.lang.ClassLoader)", pathClassLoader, str, classLoader);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void RandomAccessFileInitProxy(RandomAccessFile randomAccessFile, String str, String str2) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.RandomAccessFile.<init>(java.lang.String,java.lang.String)", randomAccessFile, str, str2);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void ServerSocketInitProxy(ServerSocket serverSocket) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.ServerSocket.<init>()", serverSocket, new Object[0]);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void URLClassLoaderInitProxy(URLClassLoader uRLClassLoader, URL[] urlArr) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.URLClassLoader.<init>(java.net.URL[])", uRLClassLoader, urlArr);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void DatagramSocketInitProxy(DatagramSocket datagramSocket, SocketAddress socketAddress) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.DatagramSocket.<init>(java.net.SocketAddress)", datagramSocket, socketAddress);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileInitProxy(File file, String str, String str2) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.File.<init>(java.lang.String,java.lang.String)", file, str, str2);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileInputStreamInitProxy(FileInputStream fileInputStream, File file) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.FileInputStream.<init>(java.io.File)", fileInputStream, file);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileOutputStreamInitProxy(FileOutputStream fileOutputStream, String str, boolean z) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.FileOutputStream.<init>(java.lang.String,boolean)", fileOutputStream, str, Boolean.valueOf(z));
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void LocalServerSocketInitProxy(LocalServerSocket localServerSocket, FileDescriptor fileDescriptor) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("android.net.LocalServerSocket.<init>(java.io.FileDescriptor)", localServerSocket, fileDescriptor);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void PathClassLoaderInitProxy(PathClassLoader pathClassLoader, String str, String str2, ClassLoader classLoader) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("dalvik.system.PathClassLoader.<init>(java.lang.String,java.lang.String,java.lang.ClassLoader)", pathClassLoader, str, str2, classLoader);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void RandomAccessFileInitProxy(RandomAccessFile randomAccessFile, File file, String str) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.RandomAccessFile.<init>(java.io.File,java.lang.String)", randomAccessFile, file, str);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void ServerSocketInitProxy(ServerSocket serverSocket, int i) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.ServerSocket.<init>(int)", serverSocket, Integer.valueOf(i));
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void URLClassLoaderInitProxy(URLClassLoader uRLClassLoader, URL[] urlArr, ClassLoader classLoader) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.URLClassLoader.<init>(java.net.URL[],java.lang.ClassLoader)", uRLClassLoader, urlArr, classLoader);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void DatagramSocketInitProxy(DatagramSocket datagramSocket, int i) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.DatagramSocket.<init>(int)", datagramSocket, Integer.valueOf(i));
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileInitProxy(File file, File file2, String str) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.File.<init>(java.io.File,java.lang.String)", file, file2, str);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileInputStreamInitProxy(FileInputStream fileInputStream, FileDescriptor fileDescriptor) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.FileInputStream.<init>(java.io.FileDescriptor)", fileInputStream, fileDescriptor);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileOutputStreamInitProxy(FileOutputStream fileOutputStream, File file) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.FileOutputStream.<init>(java.io.File)", fileOutputStream, file);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void ServerSocketInitProxy(ServerSocket serverSocket, int i, int i2) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.ServerSocket.<init>(int,int)", serverSocket, Integer.valueOf(i), Integer.valueOf(i2));
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void URLClassLoaderInitProxy(URLClassLoader uRLClassLoader, URL[] urlArr, ClassLoader classLoader, URLStreamHandlerFactory uRLStreamHandlerFactory) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.URLClassLoader.<init>(java.net.URL[],java.lang.ClassLoader,java.net.URLStreamHandlerFactory)", uRLClassLoader, urlArr, classLoader, uRLStreamHandlerFactory);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void DatagramSocketInitProxy(DatagramSocket datagramSocket, int i, InetAddress inetAddress) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.DatagramSocket.<init>(int,java.net.InetAddress)", datagramSocket, Integer.valueOf(i), inetAddress);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileInitProxy(File file, URI uri) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.File.<init>(java.net.URI)", file, uri);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileOutputStreamInitProxy(FileOutputStream fileOutputStream, File file, boolean z) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.FileOutputStream.<init>(java.io.File,boolean)", fileOutputStream, file, Boolean.valueOf(z));
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void ServerSocketInitProxy(ServerSocket serverSocket, int i, int i2, InetAddress inetAddress) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.net.ServerSocket.<init>(int,int,java.net.InetAddress)", serverSocket, Integer.valueOf(i), Integer.valueOf(i2), inetAddress);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }

    public static void FileOutputStreamInitProxy(FileOutputStream fileOutputStream, FileDescriptor fileDescriptor) throws Throwable {
        AopBridge bridge = AopManager.getInstance().getBridge();
        Invocation invocation = new Invocation("java.io.FileOutputStream.<init>(java.io.FileDescriptor)", fileOutputStream, fileDescriptor);
        bridge.callOnConstructor(invocation);
        bridge.reportTimeCost(invocation);
    }
}
