package vn.iostar.controllers.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iostar.entity.Category;
import vn.iostar.services.ICategoryServices;
import vn.iostar.services.impl.CategoryServices;
import static vn.iostar.utils.constant.*;



@MultipartConfig(fileSizeThreshold = 1024*1024,maxFileSize = 1024*1024*5,maxRequestSize=1024*1024*5*5)
@WebServlet(urlPatterns = { "/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/edit", "/admin/category/update", "/admin/category/delete" })
public class CategoryControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ICategoryServices cateService = new CategoryServices();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if (url.contains("/admin/categories")) {
			List<Category> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		} else if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		} else if (url.contains("/admin/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Category category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		} else {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				cateService.delete(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// chuyển trang
			resp.sendRedirect(req.getContextPath() + "/admin/categories");

		}
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		 if (url.contains("/admin/category/insert")) {
		 // lấy dữ liệu từ form
		 String categoryname = req.getParameter("categoryname");
		 int status = Integer.parseInt(req.getParameter("status"));
		 String images = req.getParameter("images");
		 // đưa dữ liệu vào model
		 Category category = new Category();
		 category.setCategoryname(categoryname);
		 category.setStatus(status);
		 
		 String fname = "";
		 String uploadPath = UPLOAD_DIRECTORY; // upload vào thư mục bất kỳ
		 File uploadDir = new File(uploadPath);
		 if (!uploadDir.exists()) {
			 uploadDir.mkdir();
		 }
		 
		 try {
			 Part part = req.getPart("images1");
			 if (part.getSize() > 0) {
				 String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
				 // đổi tên file 
				 int index = filename.lastIndexOf(".");
				 String ext = filename.substring(index + 1);
				 
				 fname = System.currentTimeMillis() + "." + ext;
				 // upload file 
				 part.write(uploadPath + "/" + fname);
				 // ghi tên file vào data 
				 category.setImages(fname);
		 
			 } else if (images != null) {
				 category.setImages(images);
			 } else {
				 category.setImages("avatar.png");
			 }
		 } catch (FileNotFoundException fne) {
			 fne.printStackTrace();
		 }
		 
		 // đưa model vào phương thức insert
		 cateService.insert(category);
		 // chuyển trang
		 resp.sendRedirect(req.getContextPath() + "/admin/categories");
		 }
		 
		 if (url.contains("/admin/category/update")) {
		 // lấy dữ liệu từ form
		 int categoryid = Integer.parseInt(req.getParameter("categoryid"));
		 String categoryname = req.getParameter("categoryname");
		 int status = Integer.parseInt(req.getParameter("status"));
		 String images = req.getParameter("images");
		 // đưa dữ liệu vào model
		 Category category = cateService.findById(categoryid);
		 String fileold = category.getImages();
		 category.setCategoryname(categoryname);
		 category.setStatus(status);
		 // lưu hình cũ 
		 String fname = "";
		 String uploadPath = UPLOAD_DIRECTORY; // upload vào thư mục bất kỳ
		 File uploadDir = new File(uploadPath);
		 if (!uploadDir.exists())
		 uploadDir.mkdir();
		 try {
			 Part part = req.getPart("images1");
			 if (part.getSize() > 0) {
			 // xóa file cũ trên thư mục
			 if (!category.getImages().substring(0, 5).equals("https") ) {
			 deleteFile(uploadPath+ "\\" + fileold);
			 }
			 String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			 int index = filename.lastIndexOf(".");
			 String ext = filename.substring(index + 1);
			 fname = System.currentTimeMillis() + "." + ext;
			 part.write(uploadPath + "/" + fname);
			 category.setImages(fname);
			 } else if (images != null) {
			 category.setImages(images);
			 } else {
			 category.setImages(fileold);
			 }
		 } 
		 catch (FileNotFoundException fne) {
		 fne.printStackTrace();
		 }
		 // đưa model vào phương thức insert
		 cateService.update(category);
		 // chuyển trang
		 resp.sendRedirect(req.getContextPath() + "/admin/categories");
		 }
		 
	}
	public static void deleteFile(String filePath) throws IOException {
		
		 
	}
}
