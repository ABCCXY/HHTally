package com.ylc.hhtally.mapper;

import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.pojo.Label;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BillMapper {
    int add(Bill bill);
    int remove(@Param("billId")int billId,@Param("userId")int userId);
    List<Bill> getByDate(@Param("date") String date,@Param("userId") int userId);
    List<Bill> getByLabel(@Param("labelId") int labelId,@Param("userId") int userId);
    List<Bill> getAll(int userId);
}
