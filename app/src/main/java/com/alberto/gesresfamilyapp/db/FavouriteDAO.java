package com.alberto.gesresfamilyapp.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.alberto.gesresfamilyapp.domain.Favourite;

import java.util.List;

@Dao
public interface FavouriteDAO {

    @Query("SELECT * FROM favourite WHERE idProfesional=:id")
    Favourite getFavourite(long id);

    @Query("SELECT * FROM favourite")
    List<Favourite> getAllFavourites();

    @Insert
    void insert(Favourite favourite);

    @Delete
    void delete(Favourite favourite);
}
