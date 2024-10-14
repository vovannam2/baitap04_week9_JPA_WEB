package vn.iostar.dao;

import java.util.List;

import vn.iostar.entity.Video;

public interface IVideoDao {

	List<Video> findAll();

	void insert(Video video);
	
	void delete(int videoid) throws Exception;

}
