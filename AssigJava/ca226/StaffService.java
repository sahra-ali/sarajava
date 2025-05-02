package com.just.ca226;



import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

    @Service
    public class StaffService {
        private Map<Long, Staff> Staffs=new ConcurrentHashMap<>();
        private AtomicLong autoid=new AtomicLong();

        public  Collection<Staff> getAllStaffs(){
            return Staffs.values();
        }

        public Staff getStaffById(Long id){
            return Staffs.get(id);
        }

        public Staff createStaff(Staff NewStaff){
            Long staffid=NewStaff.getId() !=null
                    ? NewStaff.getId()
                    :autoid.incrementAndGet();
            NewStaff.setId(staffid);
            Staffs.put(staffid,NewStaff);
            return  NewStaff;
        }


        public Staff UpdateStaff(Long id, Staff newStaff) {
            if (Staffs.containsKey(id)) {
                Staff oldStaff = getStaffById(id);
                oldStaff.setName(newStaff.getName());
                oldStaff.setRole(newStaff.getRole());

                Staffs.put(id, oldStaff);
                return oldStaff;
            } else {
                return null;
            }
        }


        public void deleteStaff(Long id){
            Staffs.remove(id);
        }

    }

