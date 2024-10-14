package vn.iostar.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.entity.Video;
import vn.iostar.services.IVideoService;
import vn.iostar.services.impl.VideoServices;

@MultipartConfig(fileSizeThreshold = 1024*1024,maxFileSize = 1024*1024*5,maxRequestSize=1024*1024*5*5)
@WebServlet(urlPatterns = { "/admin/videos", "/admin/video/add", "/admin/video/insert",
		"/admin/video/edit", "/admin/video/update", "/admin/video/delete" })
public class VideoControllers extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public IVideoService viservice = new VideoServices();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if (url.contains("/admin/videos")) {
			List<Video> list = viservice.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/video-list.jsp").forward(req, resp);
		} else if (url.contains("/admin/video/add")) {
			req.getRequestDispatcher("/views/video/video-add.jsp").forward(req, resp);
		} else {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				viservice.delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// chuyển trang
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}
}
