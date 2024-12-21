package iuh.edu.vn.backend.resources;

import iuh.edu.vn.backend.models.Xe;
import iuh.edu.vn.backend.services.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/xe")
public class XeResource {
    @Autowired
    private XeService xeService;

    @GetMapping("/listXe")
    public List<Xe> showXeList() {
        return xeService.findAll();
    }

    @PostMapping("/addApi")
    public ResponseEntity addXeApi(Xe xe) {
        xeService.add(xe);
        return ResponseEntity.status(302).header("Location", "/xe/list-api").build();
    }

    @PostMapping("/editApi")
    public ResponseEntity editXeApi(Xe xe) {
        xeService.update(xe);
        return ResponseEntity.status(302).header("Location", "/xe/list-api").build();
    }

    @GetMapping("/deleteApi/{id}")
    public ResponseEntity<Void> deleteXeApi(@PathVariable("id") Long id) {
        xeService.delete(id);
        return ResponseEntity.status(302).header("Location", "/xe/list-api").build();
    }
}
