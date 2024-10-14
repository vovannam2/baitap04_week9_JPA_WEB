package vn.iostar.services;

import java.util.List;

import vn.iostar.entity.Video;

public interface IVideoService {
	List<Video> findAll();
	void insert(Video video);
	void delete(int videoid) throws Exception;

}
