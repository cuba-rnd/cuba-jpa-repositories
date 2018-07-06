package com.company.sample.web.customer;

import com.company.sample.entity.Customer;
import com.company.sample.entity.SalesOrder;
import com.company.sample.service.OrderService;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.GroupTable;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerBrowse extends AbstractLookup {

    @Inject
    private OrderService orderService;

    @Inject
    private GroupTable<Customer> customersTable;

    public void showOrders() {
        Customer customer = customersTable.getSingleSelected();
        if (customer != null) {
            List<SalesOrder> orders = orderService.getSalesOrdersForCustomer(customer);
            showNotification(orders.stream().map(SalesOrder::getNumber).collect(Collectors.joining(",")));
        }
    }
}