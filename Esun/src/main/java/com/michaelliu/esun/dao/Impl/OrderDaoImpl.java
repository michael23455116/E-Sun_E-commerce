package com.michaelliu.esun.dao.Impl;

import com.michaelliu.esun.dao.OrderDao;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
