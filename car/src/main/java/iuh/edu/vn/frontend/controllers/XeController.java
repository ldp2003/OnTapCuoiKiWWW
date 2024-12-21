package iuh.edu.vn.frontend.controllers;

import iuh.edu.vn.backend.models.Xe;
import iuh.edu.vn.backend.services.LoaiXeService;
import iuh.edu.vn.backend.services.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/xe")
public class XeController {
    @Autowired
    private XeService xeService;

    @Autowired
    private LoaiXeService LoaiXeService;

    @GetMapping("/listXe")
    public String showXeList(Model model,
                             @RequestParam(value = "searchTerm", required = false) String searchTerm,
                             @RequestParam(value = "searchCriteria", required = false) String searchCriteria) {
        if(xeService.findAll().isEmpty())
            model.addAttribute("xes", null);
        if(searchTerm != null && !searchTerm.trim().isEmpty() && searchCriteria != null) {
            model.addAttribute("xes", xeService.TimKiem(searchTerm.trim(), searchCriteria));
        } else {
            model.addAttribute("xes", xeService.findAll());
        }
        return "Xe/listXe";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/addXe")
    public String showAddXeForm(Model model) {
        model.addAttribute("xe", new Xe());
        model.addAttribute("loaiXes", LoaiXeService.findAll());
        model.addAttribute("maXeRandom", "randommaxe");
        return "Xe/addXe";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addXe")
    public String addXe(Xe xe) {
        xeService.add(xe);
        return "redirect:/xe/listXe";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/editXe/{id}")
    public String showEditXeForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("xeEditing", xeService.findById(id));
        model.addAttribute("loaiXes", LoaiXeService.findAll());
        return "Xe/editXe";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/editXe/{id}")
    public String editXe(@PathVariable("id") long id, @ModelAttribute Xe xe) {
        xeService.update(xe);
        return "redirect:/xe/listXe";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/deleteXe/{id}")
    public String deleteXe(@PathVariable("id") long id) {
        xeService.delete(id);
        return "redirect:/xe/listXe";
    }

    @GetMapping("/list-api")
    public String showXeListApi() {
        return "Xe/listXeApi";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/add-api")
    public String showAddXeFormApi(Model model) {
        Random random = new Random();

        String maXeRandom = Math.round(random.nextDouble()  * 10000000000000000L) + "";
        model.addAttribute("xe", new Xe());
        model.addAttribute("loaiXes", LoaiXeService.findAll());
        model.addAttribute("maXeRandom", maXeRandom);
        return "Xe/addXeApi";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit-api/{id}")
    public String showEditXeFormApi(@PathVariable("id") long id, Model model) {
        model.addAttribute("xeEditing", xeService.findById(id));
        model.addAttribute("loaiXes", LoaiXeService.findAll());
        return "Xe/editXeApi";
    }


}
