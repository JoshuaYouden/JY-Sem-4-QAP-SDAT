package com.keyin.rest.members;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class MembersController {
    @Autowired
    private MembersService membersService;

    @GetMapping("/members")
    public List<Members> getAllMembers() {
        return membersService.findAllMembers();
    }

    @GetMapping("/members/{id}")
    public Members getMemberById(@PathVariable(value = "id") long id) {
        return membersService.findMemberById(id);
    }

    @PostMapping("/members_search")
    public List<Members> searchMembers(@RequestBody Members members) {
        List<Members> results = new ArrayList<Members>();

        if (members.getMemberName() != null) {
            Members member = membersService.findByMemberName(members.getMemberName());
            if (member != null) {
                results.add(member);
            }
        }
    
        if (members.getMemberEmail() != null) {
            Members member = membersService.findByMemberEmail(members.getMemberEmail());
            if (member != null && !results.contains(member)) {
                results.add(member);
            }
        }
    
        if (members.getMemberPhoneNumber() != null) {
            Members member = membersService.findByMemberPhoneNumber(members.getMemberPhoneNumber());
            if (member != null && !results.contains(member)) {
                results.add(member);
            }
        }
    
        if (members.getMemberStartDate() != null) {
            Members member = membersService.findByMemberStartDate(members.getMemberStartDate());
            if (member != null && !results.contains(member)) {
                results.add(member);
            }
        }
    
        return results;
    }

    @PostMapping("/members")
    public Members createMember(@RequestBody Members newMember) {
        return membersService.createMember(newMember);
    }

    @PutMapping("/members/{id}")
    public Members updateMember(@PathVariable(value = "id") long id, @RequestBody Members updatedMember) {
        return membersService.updateMember(id, updatedMember);
    }
}
