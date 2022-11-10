package com.codegym.controller;


import com.codegym.dto.facility.FacilityDTO;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.service.IFacilityRentTypeService;
import com.codegym.service.IFacilityService;
import com.codegym.service.IFacilityTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IFacilityRentTypeService facilityRentTypeService;

    @GetMapping
    public String showAll(@RequestParam( required = false,defaultValue = "") String nameSearch,
                          @RequestParam(required = false, defaultValue = "") String facilityTye,
                          Model model, @PageableDefault(value = 3)Pageable pageable) {

        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        Page<Facility> facilityPage = facilityService.findAll(nameSearch, facilityTye,pageable);
        List<RentType> rentTypeList = facilityRentTypeService.findAll();
        model.addAttribute("facilityEmpty", new Facility());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("facilityTye", facilityTye);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("rentTypeList", rentTypeList);
        return "/facility/list";
    }

    @GetMapping("/delete")
    public String deleteFacility(@RequestParam int id,
                                 RedirectAttributes redirectAttributes) {
        Optional<Facility> facility = facilityService.findById(id);
        if(!facility.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Delete fail!");
        } else {
            facility.get().setStatus(true);
            facilityService.save(facility.get());
            redirectAttributes.addFlashAttribute("message", "Delete "+facility.get().getName()+" OK!");
        }
        return "redirect:/facility";
    }

    @GetMapping("/create")
    public String showCreateFacility(Model model) {
        List<RentType> rentTypeList = facilityRentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("facilityDTOEmpty", new FacilityDTO());
        model.addAttribute("rentTypeList", rentTypeList);
        return "/facility/create";
    }

    @PostMapping("/create")
    public String createFacility(@Validated @ModelAttribute(value = "facilityDTOEmpty") FacilityDTO facilityDTO,
                                 BindingResult  bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        new FacilityDTO().validate(facilityDTO, bindingResult);
        if(bindingResult.hasErrors()) {
            List<RentType> rentTypeList = facilityRentTypeService.findAll();
            List<FacilityType> facilityTypeList = facilityTypeService.findAll();
            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            model.addAttribute("facilityDTOEmpty", facilityDTO);
            return "/facility/create";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDTO, facility);
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("Create new " + facility.getName() + " Ok!");
        return "redirect:/facility";
    }

    @GetMapping("/edit")
    public String editCustomer(@ModelAttribute(value = "facilityEmpty") Facility facility,
                               RedirectAttributes redirectAttributes) {
        if(!facilityService.findById(facility.getId()).isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Edit fail!");
        } else {
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Edit  Ok!");
        }
        return "redirect:/facility";
    }

}
