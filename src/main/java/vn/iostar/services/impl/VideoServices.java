package vn.iostar.services.impl;

import java.util.List;

import vn.iostar.dao.IVideoDao;
import vn.iostar.dao.impl.VideoDao;
import vn.iostar.entity.Video;
import vn.iostar.services.IVideoService;

public class VideoServices implements IVideoService{

	IVideoDao viDao = new VideoDao();
	@Override
	public List<Video> findAll() {
		
		return viDao.findAll();
	}

	@Override
	public void insert(Video video) {
		viDao.insert(video);
	}

	@Override
	public void delete(int videoid) throws Exception {
		viDao.delete(videoid);
	}

}
