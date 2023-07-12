package com.alipay.camera.util;

import com.alipay.mobile.bqcscanservice.BQCCameraParam;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraSceneParamConfig {
    private String a;

    public String getCurCameraScene() {
        return this.a;
    }

    public void updateScene(String str) {
        if ("auto".equalsIgnoreCase(str)) {
            this.a = "auto";
        } else if ("action".equalsIgnoreCase(str)) {
            this.a = "action";
        } else if ("portrait".equalsIgnoreCase(str)) {
            this.a = "portrait";
        } else if ("landscape".equalsIgnoreCase(str)) {
            this.a = "landscape";
        } else if (BQCCameraParam.SCENE_NIGHT.equalsIgnoreCase(str)) {
            this.a = BQCCameraParam.SCENE_NIGHT;
        } else if (BQCCameraParam.SCENE_NIGHT_P.equalsIgnoreCase(str)) {
            this.a = "night-portrait";
        } else if (BQCCameraParam.SCENE_THEATRE.equalsIgnoreCase(str)) {
            this.a = BQCCameraParam.SCENE_THEATRE;
        } else if (BQCCameraParam.SCENE_BEACH.equalsIgnoreCase(str)) {
            this.a = BQCCameraParam.SCENE_BEACH;
        } else if (BQCCameraParam.SCENE_SNOW.equalsIgnoreCase(str)) {
            this.a = BQCCameraParam.SCENE_SNOW;
        } else if (BQCCameraParam.SCENE_SUNSET.equalsIgnoreCase(str)) {
            this.a = BQCCameraParam.SCENE_SUNSET;
        } else if (BQCCameraParam.SCENE_ST_PHOTO.equalsIgnoreCase(str)) {
            this.a = "steadyphoto";
        } else if (BQCCameraParam.SCENE_FIREWORKS.equalsIgnoreCase(str)) {
            this.a = BQCCameraParam.SCENE_FIREWORKS;
        } else if (BQCCameraParam.SCENE_SPORTS.equalsIgnoreCase(str)) {
            this.a = BQCCameraParam.SCENE_SPORTS;
        } else if (BQCCameraParam.SCENE_PARTY.equalsIgnoreCase(str)) {
            this.a = BQCCameraParam.SCENE_PARTY;
        } else if (BQCCameraParam.SCENE_CANDLE.equalsIgnoreCase(str)) {
            this.a = "candlelight";
        } else if ("barcode".equalsIgnoreCase(str)) {
            this.a = "barcode";
        } else {
            this.a = null;
        }
    }
}
