package com.alibaba.security.realidentity.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import java.util.Calendar;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a {
    public static final int i = 500;
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    public int a;
    public int b;
    public int c;
    public Calendar e;
    public InterfaceC0174a n;
    private SensorManager o;
    private Sensor p;
    public long d = 0;
    public boolean f = false;
    public boolean g = false;
    boolean h = false;
    public int m = 0;
    private int q = 1;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0174a {
        void a();
    }

    public a(InterfaceC0174a interfaceC0174a) {
        this.n = interfaceC0174a;
    }

    private void a(InterfaceC0174a interfaceC0174a) {
        this.n = interfaceC0174a;
    }

    private boolean b() {
        return this.h && this.q <= 0;
    }

    private void c() {
        this.f = true;
        this.q--;
    }

    private void d() {
        this.f = false;
        this.q++;
    }

    private void e() {
        this.q = 1;
    }

    private void a(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor == null) {
            return;
        }
        if (this.f) {
            this.m = 0;
            this.g = false;
            this.a = 0;
            this.b = 0;
            this.c = 0;
        } else if (sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            int i2 = (int) fArr[0];
            int i3 = (int) fArr[1];
            int i4 = (int) fArr[2];
            Calendar calendar = Calendar.getInstance();
            this.e = calendar;
            long timeInMillis = calendar.getTimeInMillis();
            this.e.get(13);
            if (this.m != 0) {
                int abs = Math.abs(this.a - i2);
                int abs2 = Math.abs(this.b - i3);
                int abs3 = Math.abs(this.c - i4);
                if (Math.sqrt((abs * abs) + (abs2 * abs2) + (abs3 * abs3)) > 1.4d) {
                    this.m = 2;
                } else {
                    if (this.m == 2) {
                        this.d = timeInMillis;
                        this.g = true;
                    }
                    if (this.g && timeInMillis - this.d > 500 && !this.f) {
                        this.g = false;
                        InterfaceC0174a interfaceC0174a = this.n;
                        if (interfaceC0174a != null) {
                            interfaceC0174a.a();
                        }
                    }
                    this.m = 1;
                }
            } else {
                this.d = timeInMillis;
                this.m = 1;
            }
            this.a = i2;
            this.b = i3;
            this.c = i4;
        }
    }

    private void a() {
        this.m = 0;
        this.g = false;
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
}
