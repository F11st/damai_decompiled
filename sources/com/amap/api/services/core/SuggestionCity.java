package com.amap.api.services.core;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SuggestionCity {
    private String a;
    private String b;
    private String c;
    private int d;

    protected SuggestionCity() {
    }

    public String getAdCode() {
        return this.c;
    }

    public String getCityCode() {
        return this.b;
    }

    public String getCityName() {
        return this.a;
    }

    public int getSuggestionNum() {
        return this.d;
    }

    public void setAdCode(String str) {
        this.c = str;
    }

    public void setCityCode(String str) {
        this.b = str;
    }

    public void setCityName(String str) {
        this.a = str;
    }

    public void setSuggestionNum(int i) {
        this.d = i;
    }

    public SuggestionCity(String str, String str2, String str3, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }
}
