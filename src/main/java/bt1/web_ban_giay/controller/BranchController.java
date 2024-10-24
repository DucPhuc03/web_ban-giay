package bt1.web_ban_giay.controller;

import bt1.web_ban_giay.entity.Branch;
import bt1.web_ban_giay.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    BranchService branchService;
    @GetMapping("/branch/get")
    public ResponseEntity<List<Branch>> getBranch(){
        return ResponseEntity.ok(branchService.getBranch());
    }
}
