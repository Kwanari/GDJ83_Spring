package com.kwan.app.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/location/")
@Controller
public class LocationController {

	@Autowired
	LocationService locationService;

	@RequestMapping("list")
	public void getList(Model model) throws Exception {

		List<LocationDTO> ar = locationService.getList();

		model.addAttribute("list", ar);
	}

	@RequestMapping("detail")
	public void getDetail(Model model, int location_id) throws Exception {
		System.out.println("detail");

		LocationDTO locationDTO = locationService.getDetail(location_id);

		model.addAttribute("dto", locationDTO);

	}

}
