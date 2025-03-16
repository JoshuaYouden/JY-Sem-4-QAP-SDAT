package com.keyin.rest.members;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends CrudRepository<Members, Long> {
    public Members findByMemberName(String memberName);
    public Members findByMemberAddress(String memberAddress);
    public Members findByMemberEmail(String memberEmail);
    public Members findByMemberPhoneNumber(String memberPhoneNumber);
    public Members findByMemberStartDate(String memberStartDate);
    public Members findByMembershipDuration(int membershipDuration);
}
