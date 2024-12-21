package iuh.edu.vn.frontend.controllers;

import iuh.edu.vn.backend.services.LoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loaixe")
public class LoaiXeController {
    @Autowired
    private LoaiXeService loaiXeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listLoaiXe")
    public String showLoaiXeList(Model model) {
        model.addAttribute("loaiXes", loaiXeService.findAll());
        return "LoaiXe/listLoaiXe";
    }
}
