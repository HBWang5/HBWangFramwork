package com.hbwang.api.database.been;

import com.google.gson.Gson;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/7/10.
 */
@DatabaseTable(tableName = "cities_content")
public class CitiesDBEntity {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "province_name")
    private String Province_Name;
    @DatabaseField(columnName = "city_name")
    private String City_Name;
    @DatabaseField(columnName = "CarCodeLen")
    private String CarCodeLen;
    @DatabaseField(columnName = "CarEngineLen")
    private String CarEngineLen;
    @DatabaseField(columnName = "CarNumberPrefix")
    private String CarNumberPrefix;

    public CitiesDBEntity() {
    }

    public void setCarNumberPrefix(String carNumberPrefix) {
        CarNumberPrefix = carNumberPrefix;
    }

    public String getCarNumberPrefix() {
        return CarNumberPrefix;
    }

    public void setCarCodeLen(String carCodeLen) {
        CarCodeLen = carCodeLen;
    }

    public void setCarEngineLen(String carEngineLen) {
        CarEngineLen = carEngineLen;
    }

    public int getId() {
        return id;
    }

    public String getProvince_Name() {
        return Province_Name;
    }

    public String getCity_Name() {
        return City_Name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProvince_Name(String province_Name) {
        Province_Name = province_Name;
    }

    public void setCity_Name(String city_Name) {
        City_Name = city_Name;
    }

    public String getCarCodeLen() {
        return CarCodeLen;
    }

    public String getCarEngineLen() {
        return CarEngineLen;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
