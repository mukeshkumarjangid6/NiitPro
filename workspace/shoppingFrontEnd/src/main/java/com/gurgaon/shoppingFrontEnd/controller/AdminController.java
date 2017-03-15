package com.gurgaon.shoppingFrontEnd.controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.gurgaon.delhi.shoppingBackEnd.dao.ProductDao;
import com.gurgaon.delhi.shoppingBackEnd.dto.Product;

@Controller
public class AdminController {
	@Autowired
	private ProductDao productDao;
	@Autowired
	HttpServletRequest request;

	// For Admin
	@RequestMapping(value = { "/admin/adminIndex" })
	public ModelAndView productcrud() {
		ModelAndView model = new ModelAndView("admin/adminIndex");
		model.addObject("title", "Product Management");
		// model.addObject("userClickProductCRUD", "true"); //redirect product
		// insert page
		model.addObject("product", new Product());

		/*
		 * List<Integer> sections = new ArrayList<Integer>(); sections.add(1);
		 * model.addObject("categoryId", sections); List<Boolean> ActiveIs = new
		 * ArrayList<Boolean>(); ActiveIs.add(Boolean.TRUE);
		 * ActiveIs.add(Boolean.FALSE); model.addObject("ActiveIs", ActiveIs);
		 */ // to do later on to populate dropdown list

		// model.addObject("productList", productDao.productList()); to avoid
		// display products at this page
		return model;
	}

	@RequestMapping(value = "/productData.do", method = RequestMethod.POST)
	private ModelAndView doActions(@ModelAttribute("product") @Valid Product product, BindingResult result,
			@RequestParam String action) {
		System.out.println(product.getName() + " " + product.getDescription());
		Product productResult = new Product();
		if (result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("admin/adminIndex");
			model1.addObject("title", "Product Management");
	
			return model1;
		}
		switch (action.toLowerCase()) {
		case "add":
			if (!(product.getFile().getOriginalFilename().equals(""))) {
				product.setProductImg_url(uploadImage(product.getFile(),product));
			}
			System.out.println("Image uploaded");
			productDao.add(product);
			productResult = product;
			break;
		case "update":
			productDao.update(product);
			productResult = product;
			break;
		case "delete":
			productDao.delete(product.getId());
			productResult = product;
			break;
		}
		ModelAndView model1 = new ModelAndView("admin/result");
		model1.addObject("title", "Product Management");
		model1.addObject("product", productResult);
		model1.addObject("productList", productDao.productList());
		model1.addObject("success", "Data has been processed");
		return model1;
	}

	public String uploadImage(MultipartFile multipart, Product product) {
		System.out.println("MultiPart1");
		String folderToUpload = "/assets/Image/";
		String fileName = multipart.getOriginalFilename();
		System.out.println("MultiPart2");
		String realPath = request.getServletContext().getRealPath(folderToUpload);
		System.out.println(realPath);
		if (!new File(realPath).exists()) {
			System.out.println("MultiPart4");
			new File(realPath).mkdirs();
		}
		System.out.println("MultiPart5");
		String filePath = realPath + product.getName()+".jpg";
		File destination = new File(filePath);
		try {
			System.out.println("MultiPart6");
			multipart.transferTo(destination);
		} catch (Exception e) {
			
		}
		System.out.println(fileName);
		return fileName;
	}

	@RequestMapping(value = "/deleteorUpdate/{id}", method = RequestMethod.GET)
	public ModelAndView product11(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("admin/DeleteUpdate");
		mv.addObject("msg", productDao.getProduct(id));

		mv.addObject("title", "Product Management");
		// model.addObject("userClickProductCRUD", "true"); //redirect product
		// insert page
		mv.addObject("product", productDao.getProduct(id));

		return mv;
	}

	// Send list of Category for select the list
	/*
	 * @ModelAttribute("category") public List<Integer> initializeCategory() {
	 * // List<Category> sections = categoryDao.list(); List<Integer> sections =
	 * new ArrayList<Integer>(); sections.add(1); return sections; }
	 * 
	 * @ModelAttribute("ActiveIs") public List<Boolean> initializeIsActive() {
	 * 
	 * List<Boolean> ActiveIs = new ArrayList<Boolean>();
	 * ActiveIs.add(Boolean.TRUE); ActiveIs.add(Boolean.FALSE); return ActiveIs;
	 * }
	 */

}