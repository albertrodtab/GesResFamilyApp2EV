package com.alberto.gesresfamilyapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.alberto.gesresfamilyapp.domain.Favourite;

@Database(entities = {Favourite.class}, version = 1)
public abstract class GesResFavourites extends RoomDatabase {
    public abstract FavouriteDAO getFavouriteDAO();
}
