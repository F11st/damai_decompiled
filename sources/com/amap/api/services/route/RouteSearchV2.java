package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.bg;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.pl2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class RouteSearchV2 {
    private IRouteSearchV2 a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class CurveCost {
        private float a;
        private float b;

        public float getAccess() {
            return this.a;
        }

        public float getValue() {
            return this.b;
        }

        public void setAccess(float f) {
            this.a = f;
        }

        public void setValue(float f) {
            this.b = f;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class CustomCostMode {
        private List<SpeedCost> a;
        private CurveCost b;
        private SlopeCost c;
        private float d;
        private TransCost e;
        private float f;
        private PowerTrainLoss g;

        public float getAuxCost() {
            return this.d;
        }

        public CurveCost getCurveCost() {
            return this.b;
        }

        public float getFerryCost() {
            return this.f;
        }

        public PowerTrainLoss getPowerTrainLosses() {
            return this.g;
        }

        public SlopeCost getSlopeCost() {
            return this.c;
        }

        public List<SpeedCost> getSpeedCosts() {
            return this.a;
        }

        public TransCost getTransCost() {
            return this.e;
        }

        public void setAuxCost(float f) {
            this.d = f;
        }

        public void setCurveCost(CurveCost curveCost) {
            this.b = curveCost;
        }

        public void setFerryCost(float f) {
            this.f = f;
        }

        public void setPowerTrainLosses(PowerTrainLoss powerTrainLoss) {
            this.g = powerTrainLoss;
        }

        public void setSlopeCost(SlopeCost slopeCost) {
            this.c = slopeCost;
        }

        public void setSpeedCosts(List<SpeedCost> list) {
            this.a = list;
        }

        public void setTransCost(TransCost transCost) {
            this.e = transCost;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<SpeedCost> list = this.a;
                if (list != null) {
                    for (SpeedCost speedCost : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("speed", speedCost.getSpeed());
                        jSONObject2.put("value", speedCost.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("speed_cost", jSONArray);
                }
                if (this.b != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(pl2.TAG_ACCESS, this.b.getAccess());
                    jSONObject3.put("value", this.b.getValue());
                    jSONObject.put("curve_cost", jSONObject3);
                }
                if (this.c != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("up", this.c.getUp());
                    jSONObject4.put("down", this.c.getDown());
                    jSONObject.put("slope_cost", jSONObject4);
                }
                jSONObject.put("aux_cost", this.d);
                if (this.e != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(pl2.TAG_ACCESS, this.e.getAccess());
                    jSONObject5.put("decess", this.e.getDecess());
                    jSONObject.put("trans_cost", jSONObject5);
                }
                jSONObject.put("ferry_cost", this.f);
                if (this.g != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("powerdemand", this.g.getPowerDemand());
                    jSONObject6.put("value", this.g.getPowerDemandValue());
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("speed", this.g.getSpeed());
                    jSONObject7.put("value", this.g.getSpeedValue());
                    jSONArray2.put(jSONObject6);
                    jSONArray2.put(jSONObject7);
                    jSONObject.put("powertrain_loss", jSONArray2);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.DriveRouteQuery.1
            private static DriveRouteQuery a(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery[] newArray(int i) {
                return a(i);
            }

            private static DriveRouteQuery[] a(int i) {
                return new DriveRouteQuery[i];
            }
        };
        private FromAndTo a;
        private NewEnergy b;
        private int c;
        private List<LatLonPoint> d;
        private List<List<LatLonPoint>> e;
        private String f;
        private boolean g;
        private int h;
        private String i;
        private int j;

        public DriveRouteQuery(FromAndTo fromAndTo, DrivingStrategy drivingStrategy, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.c = DrivingStrategy.DEFAULT.getValue();
            this.g = true;
            this.h = 0;
            this.i = null;
            this.j = 1;
            this.a = fromAndTo;
            this.c = drivingStrategy.getValue();
            this.d = list;
            this.e = list2;
            this.f = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
                String str = this.f;
                if (str == null) {
                    if (driveRouteQuery.f != null) {
                        return false;
                    }
                } else if (!str.equals(driveRouteQuery.f)) {
                    return false;
                }
                List<List<LatLonPoint>> list = this.e;
                if (list == null) {
                    if (driveRouteQuery.e != null) {
                        return false;
                    }
                } else if (!list.equals(driveRouteQuery.e)) {
                    return false;
                }
                FromAndTo fromAndTo = this.a;
                if (fromAndTo == null) {
                    if (driveRouteQuery.a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(driveRouteQuery.a)) {
                    return false;
                }
                if (this.c != driveRouteQuery.c) {
                    return false;
                }
                List<LatLonPoint> list2 = this.d;
                if (list2 == null) {
                    if (driveRouteQuery.d != null) {
                        return false;
                    }
                } else if (!list2.equals(driveRouteQuery.d) || this.g != driveRouteQuery.isUseFerry() || this.h != driveRouteQuery.h || this.j != driveRouteQuery.j) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getAvoidRoad() {
            return this.f;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.e;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.e;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.e.size(); i++) {
                List<LatLonPoint> list2 = this.e.get(i);
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    LatLonPoint latLonPoint = list2.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list2.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i < this.e.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.h;
        }

        public String getExclude() {
            return this.i;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public DrivingStrategy getMode() {
            return DrivingStrategy.fromValue(this.c);
        }

        public NewEnergy getNewEnergy() {
            return this.b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.d.size(); i++) {
                LatLonPoint latLonPoint = this.d.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.d.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public int getShowFields() {
            return this.j;
        }

        public boolean hasAvoidRoad() {
            return !i.a(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !i.a(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !i.a(getPassedPointStr());
        }

        public int hashCode() {
            String str = this.f;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.e;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.a;
            int hashCode3 = (((hashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.c) * 31;
            List<LatLonPoint> list2 = this.d;
            return ((hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.h;
        }

        public boolean isUseFerry() {
            return this.g;
        }

        public void setCarType(int i) {
            this.h = i;
        }

        public void setExclude(String str) {
            this.i = str;
        }

        public void setNewEnergy(NewEnergy newEnergy) {
            this.b = newEnergy;
        }

        public void setShowFields(int i) {
            this.j = i;
        }

        public void setUseFerry(boolean z) {
            this.g = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.c);
            parcel.writeTypedList(this.d);
            List<List<LatLonPoint>> list = this.e;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                for (List<LatLonPoint> list2 : this.e) {
                    parcel.writeTypedList(list2);
                }
            }
            parcel.writeString(this.f);
            parcel.writeInt(this.g ? 1 : 0);
            parcel.writeInt(this.h);
            parcel.writeString(this.i);
            parcel.writeInt(this.j);
        }

        /* renamed from: clone */
        public DriveRouteQuery m236clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                i.a(e, "RouteSearchV2", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.a, DrivingStrategy.fromValue(this.c), this.d, this.e, this.f);
            driveRouteQuery.setUseFerry(this.g);
            driveRouteQuery.setCarType(this.h);
            driveRouteQuery.setExclude(this.i);
            driveRouteQuery.setShowFields(this.j);
            driveRouteQuery.setNewEnergy(this.b);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.c = DrivingStrategy.DEFAULT.getValue();
            this.g = true;
            this.h = 0;
            this.i = null;
            this.j = 1;
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.c = parcel.readInt();
            this.d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.e = null;
            } else {
                this.e = new ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.e.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f = parcel.readString();
            this.g = parcel.readInt() == 1;
            this.h = parcel.readInt();
            this.i = parcel.readString();
            this.j = parcel.readInt();
        }

        public DriveRouteQuery() {
            this.c = DrivingStrategy.DEFAULT.getValue();
            this.g = true;
            this.h = 0;
            this.i = null;
            this.j = 1;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum DrivingStrategy {
        DEFAULT(32),
        AVOID_CONGESTION(33),
        HIGHWAY_PRIORITY(34),
        AVOID_HIGHWAY(35),
        LESS_CHARGE(36),
        ROAD_PRIORITY(37),
        SPEED_PRIORITY(38),
        AVOID_CONGESTION_HIGHWAY_PRIORITY(39),
        AVOID_CONGESTION_AVOID_HIGHWAY(40),
        AVOID_CONGESTION_LESS_CHARGE(41),
        LESS_CHARGE_AVOID_HIGHWAY(42),
        AVOID_CONGESTION_LESS_CHARGE_AVOID_HIGHWAY(43),
        AVOID_CONGESTION_ROAD_PRIORITY(44),
        AVOID_CONGESTION_SPEED_PRIORITY(45);
        
        int a;

        DrivingStrategy(int i) {
            this.a = i;
        }

        public static DrivingStrategy fromValue(int i) {
            return values()[i - 32];
        }

        public final int getValue() {
            return this.a;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearchV2.FromAndTo.1
            private static FromAndTo a(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo[] newArray(int i) {
                return a(i);
            }

            private static FromAndTo[] a(int i) {
                return new FromAndTo[i];
            }
        };
        private LatLonPoint a;
        private LatLonPoint b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                FromAndTo fromAndTo = (FromAndTo) obj;
                String str = this.d;
                if (str == null) {
                    if (fromAndTo.d != null) {
                        return false;
                    }
                } else if (!str.equals(fromAndTo.d)) {
                    return false;
                }
                LatLonPoint latLonPoint = this.a;
                if (latLonPoint == null) {
                    if (fromAndTo.a != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(fromAndTo.a)) {
                    return false;
                }
                String str2 = this.c;
                if (str2 == null) {
                    if (fromAndTo.c != null) {
                        return false;
                    }
                } else if (!str2.equals(fromAndTo.c)) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.b;
                if (latLonPoint2 == null) {
                    if (fromAndTo.b != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(fromAndTo.b)) {
                    return false;
                }
                String str3 = this.e;
                if (str3 == null) {
                    if (fromAndTo.e != null) {
                        return false;
                    }
                } else if (!str3.equals(fromAndTo.e)) {
                    return false;
                }
                String str4 = this.f;
                if (str4 == null) {
                    if (fromAndTo.f != null) {
                        return false;
                    }
                } else if (!str4.equals(fromAndTo.f)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public String getDestinationPoiID() {
            return this.d;
        }

        public String getDestinationType() {
            return this.f;
        }

        public LatLonPoint getFrom() {
            return this.a;
        }

        public String getOriginType() {
            return this.e;
        }

        public String getPlateNumber() {
            return this.g;
        }

        public String getStartPoiID() {
            return this.c;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public int hashCode() {
            String str = this.d;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.a;
            int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.b;
            int hashCode4 = (hashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.e;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f;
            return hashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.d = str;
        }

        public void setDestinationType(String str) {
            this.f = str;
        }

        public void setOriginType(String str) {
            this.e = str;
        }

        public void setPlateNumber(String str) {
            this.g = str;
        }

        public void setStartPoiID(String str) {
            this.c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
        }

        /* renamed from: clone */
        public FromAndTo m237clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                i.a(e, "RouteSearchV2", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.a, this.b);
            fromAndTo.setStartPoiID(this.c);
            fromAndTo.setDestinationPoiID(this.d);
            fromAndTo.setOriginType(this.e);
            fromAndTo.setDestinationType(this.f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class NewEnergy {
        private String a;
        private CustomCostMode b;
        private float c = -1.0f;
        private float d = -1.0f;
        private float e = 1.5f;
        private float f = 100.0f;
        private float g = 0.0f;

        public String buildParam() {
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                sb.append("&key=");
                sb.append(this.a);
            }
            if (this.b != null) {
                sb.append("&custom_cost_mode=");
                sb.append(this.b.toJson());
            }
            if (this.c > 0.0f) {
                sb.append("&max_vehicle_charge=");
                sb.append(this.c);
            }
            if (this.d > 0.0f) {
                sb.append("&vehicle_charge=");
                sb.append(this.d);
            }
            sb.append("&load=");
            sb.append(this.e);
            sb.append("&leaving_percent=");
            sb.append(this.f);
            sb.append("&arriving_percent=");
            sb.append(this.g);
            return sb.toString();
        }

        public float getArrivingPercent() {
            return this.g;
        }

        public CustomCostMode getCustomCostMode() {
            return this.b;
        }

        public String getKey() {
            return this.a;
        }

        public float getLeavingPercent() {
            return this.f;
        }

        public float getLoad() {
            return this.e;
        }

        public float getMaxVehicleCharge() {
            return this.c;
        }

        public float getVehicleCharge() {
            return this.d;
        }

        public void setArrivingPercent(float f) {
            this.g = f;
        }

        public void setCustomCostMode(CustomCostMode customCostMode) {
            this.b = customCostMode;
        }

        public void setKey(String str) {
            this.a = str;
        }

        public void setLeavingPercent(float f) {
            this.f = f;
        }

        public void setLoad(float f) {
            this.e = f;
        }

        public void setMaxVehicleCharge(float f) {
            this.c = f;
        }

        public void setVehicleCharge(float f) {
            this.d = f;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface OnRouteSearchListener {
        void onDriveRouteSearched(DriveRouteResultV2 driveRouteResultV2, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class PowerTrainLoss {
        private int a;
        private float b;
        private int c;
        private int d;

        public int getPowerDemand() {
            return this.a;
        }

        public float getPowerDemandValue() {
            return this.b;
        }

        public int getSpeed() {
            return this.c;
        }

        public int getSpeedValue() {
            return this.d;
        }

        public void setPowerDemand(int i) {
            this.a = i;
        }

        public void setPowerDemandValue(float f) {
            this.b = f;
        }

        public void setSpeed(int i) {
            this.c = i;
        }

        public void setSpeedValue(int i) {
            this.d = i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int CHARGE_STATION_INFO = 64;
        public static final int CITIES = 8;
        public static final int COST = 1;
        public static final int ELEC_COSUME_INFO = 32;
        public static final int NAVI = 4;
        public static final int POLINE = 16;
        public static final int TMCS = 2;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class SlopeCost {
        private float a;
        private float b;

        public float getDown() {
            return this.b;
        }

        public float getUp() {
            return this.a;
        }

        public void setDown(float f) {
            this.b = f;
        }

        public void setUp(float f) {
            this.a = f;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class SpeedCost {
        private int a;
        private float b;

        public int getSpeed() {
            return this.a;
        }

        public float getValue() {
            return this.b;
        }

        public void setSpeed(int i) {
            this.a = i;
        }

        public void setValue(float f) {
            this.b = f;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class TransCost {
        private float a;
        private float b;

        public float getAccess() {
            return this.a;
        }

        public float getDecess() {
            return this.b;
        }

        public void setAccess(float f) {
            this.a = f;
        }

        public void setDecess(float f) {
            this.b = f;
        }
    }

    public RouteSearchV2(Context context) throws AMapException {
        if (this.a == null) {
            try {
                this.a = new bg(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public DriveRouteResultV2 calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearchV2 iRouteSearchV2 = this.a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
