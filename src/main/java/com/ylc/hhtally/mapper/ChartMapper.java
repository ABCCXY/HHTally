package com.ylc.hhtally.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartMapper {
    Double[] getMonthSumIncome(@Param("month") String month,@Param("userId") int userId);
    Double[] getMonthSum(@Param("month") String month,@Param("userId") int userId);
    Double[] getDaySum(@Param("year") String year,@Param("month") String month,@Param("day") String day,@Param("userId") int userId);
}
