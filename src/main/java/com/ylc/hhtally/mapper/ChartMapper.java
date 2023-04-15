package com.ylc.hhtally.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartMapper {
    Double[] getMonthSumIncome(@Param("month") String month,@Param("userId") int userId);
    Double[] getMonthSum(@Param("month") String month,@Param("userId") int userId);
    Double[] getDaySum(@Param("time1") String time1,@Param("time2") String time2,@Param("userId") int userId);
}
