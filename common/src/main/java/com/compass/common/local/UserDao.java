package com.compass.common.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.compass.common.user.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM USER WHERE current = 1")
    User getCurrentUser();

    /**
     * select user by cid
     * @param cid id
     * @return
     */
    @Query("SELECT * FROM USER WHERE cid = :cid")
    User getUserByCid(String cid);

    /**
     * insert a user onConflict
     * @param user new user
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

}
