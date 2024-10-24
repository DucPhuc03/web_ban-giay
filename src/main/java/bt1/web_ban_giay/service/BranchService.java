package bt1.web_ban_giay.service;

import bt1.web_ban_giay.entity.Branch;
import bt1.web_ban_giay.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;
    public List<Branch> getBranch(){
        return branchRepository.findAll();
    }
}
