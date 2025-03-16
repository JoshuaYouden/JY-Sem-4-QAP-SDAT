package com.keyin.rest.members;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

        Members member = membersService.findByName(members.getMemberName());

        if (member != null) {
            results.add(member);
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
