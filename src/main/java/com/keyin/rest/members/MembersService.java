package com.keyin.rest.members;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService {
    @Autowired
    private MembersRepository membersRepository;

    public List<Members> findAllMembers() {
        return (List<Members>) membersRepository.findAll();
    }

    public Members findMemberById(long id) {
        Optional<Members> optionalMembers = membersRepository.findById(id);
        
        return optionalMembers.orElse(null);
    }

    public Members findByMemberName(String memberName) {
        return membersRepository.findByMemberName(memberName);
    }

    public Members findByMemberEmail(String memberEmail) {
        return membersRepository.findByMemberEmail(memberEmail);
    }

    public Members findByMemberPhoneNumber(String memberPhoneNumber) {
        return membersRepository.findByMemberPhoneNumber(memberPhoneNumber);
    }

    public Members findByMemberStartDate(String memberStartDate) {
        return membersRepository.findByMemberStartDate(memberStartDate);
    }

    public Members createMember(Members newMember) {
        return membersRepository.save(newMember);
    }

    public Members updateMember(long id, Members updatedMember) {
        Members memberToUpdate = findMemberById(id);

        if (memberToUpdate != null) {
            memberToUpdate.setMemberName(updatedMember.getMemberName());
            memberToUpdate.setMemberAddress(updatedMember.getMemberAddress());
            memberToUpdate.setMemberEmail(updatedMember.getMemberEmail());
            memberToUpdate.setMemberPhoneNumber(updatedMember.getMemberPhoneNumber());
            memberToUpdate.setMemberStartDate(updatedMember.getMemberStartDate());
            memberToUpdate.setMembershipDuration(updatedMember.getMembershipDuration());

            return membersRepository.save(memberToUpdate);
        }

        return null;
    }
}
