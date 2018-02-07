package com.jzyqd.dao;

import java.util.List;

import com.jzyqd.entity.Favorite;

public interface IFavoriteDAO {

	public boolean save(Favorite favorite);
	public boolean delete(int id);
	public boolean update(Favorite favorite);
	public Favorite findById(int id);
	public List<Favorite> findAll();
}
