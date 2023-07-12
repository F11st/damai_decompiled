package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = new Parcelable.Creator<LocalDayWeatherForecast>() { // from class: com.amap.api.services.weather.LocalDayWeatherForecast.1
        private static LocalDayWeatherForecast a(Parcel parcel) {
            return new LocalDayWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ LocalDayWeatherForecast createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ LocalDayWeatherForecast[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public LocalDayWeatherForecast() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDate() {
        return this.a;
    }

    public String getDayTemp() {
        return this.e;
    }

    public String getDayWeather() {
        return this.c;
    }

    public String getDayWindDirection() {
        return this.g;
    }

    public String getDayWindPower() {
        return this.i;
    }

    public String getNightTemp() {
        return this.f;
    }

    public String getNightWeather() {
        return this.d;
    }

    public String getNightWindDirection() {
        return this.h;
    }

    public String getNightWindPower() {
        return this.j;
    }

    public String getWeek() {
        return this.b;
    }

    public void setDate(String str) {
        this.a = str;
    }

    public void setDayTemp(String str) {
        this.e = str;
    }

    public void setDayWeather(String str) {
        this.c = str;
    }

    public void setDayWindDirection(String str) {
        this.g = str;
    }

    public void setDayWindPower(String str) {
        this.i = str;
    }

    public void setNightTemp(String str) {
        this.f = str;
    }

    public void setNightWeather(String str) {
        this.d = str;
    }

    public void setNightWindDirection(String str) {
        this.h = str;
    }

    public void setNightWindPower(String str) {
        this.j = str;
    }

    public void setWeek(String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }

    public LocalDayWeatherForecast(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = parcel.readString();
    }
}
