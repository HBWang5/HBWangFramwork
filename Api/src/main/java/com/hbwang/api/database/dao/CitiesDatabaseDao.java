package com.hbwang.api.database.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.hbwang.api.database.DatabaseHelper;
import com.hbwang.api.database.been.CitiesDBEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/10.
 */

public class CitiesDatabaseDao {
    private Context context;
    private Dao<CitiesDBEntity, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public CitiesDatabaseDao(Context context) {
        this.context = context;
        try {
            helper = DatabaseHelper.getHelper(context);
            userDaoOpe = helper.getUserDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(CitiesDBEntity obj) {
        try {
            userDaoOpe.create(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * 删除一个数据
     *
     */
    public void remove(CitiesDBEntity obj) {
        try {
            userDaoOpe.delete(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更改一个数据
     *
     */
    public void updata(CitiesDBEntity obj) {
        try {
            userDaoOpe.update(obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 查询所有数据
     */
    public List<CitiesDBEntity> queryForAll() {
        List<CitiesDBEntity> objList = null;
        try {
            objList = userDaoOpe.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objList;
    }

    /**
     * 删除所有数据
     */
    public void closeMsgs() {
        helper.close();
    }
}
