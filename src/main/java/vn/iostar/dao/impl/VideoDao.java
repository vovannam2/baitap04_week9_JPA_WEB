package vn.iostar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.iostar.config.JPAConfig;
import vn.iostar.dao.IVideoDao;
import vn.iostar.entity.Video;

public class VideoDao implements IVideoDao{
	@Override
	public void insert(Video video) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			// goi phuong thuc insert ,update ,delete

			enma.persist(video);// insert vao bang
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {
			enma.close();
		}
	}
	@Override
	public List<Video> findAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);

		return query.getResultList();

	}
	@Override
	public void delete(int videoid) throws Exception {
		
			EntityManager enma = JPAConfig.getEntityManager();

			EntityTransaction trans = enma.getTransaction();

			try {

				trans.begin();

				Video vi = enma.find(Video.class, videoid);

				if (vi != null) {

					enma.remove(vi);

				} else {

					throw new Exception("Không tìm thấy");

				}

				trans.commit();

			} catch (Exception e) {

				e.printStackTrace();

				trans.rollback();

				throw e;

			} finally {

				enma.close();

			}

		}
			
}
