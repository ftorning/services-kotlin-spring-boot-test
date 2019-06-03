package com.urbn.rewards.controller

import com.urbn.rewards.models.Customer
import com.urbn.rewards.models.OrderRequest
import com.urbn.rewards.models.Rewards
import com.urbn.rewards.service.OrderService
import org.springframework.web.bind.annotation.*

// RestController denotes that this class has web functionality
// The constructor value (orderService) is initialized through dependency injection (Spring magic)
@RestController
class RewardsController(private val orderService: OrderService) {

    // **Endpoint 1**
    @PostMapping("/purchase")
    fun purchase(@RequestBody orderRequest: OrderRequest): Customer? {
        // right now the orderService returns a map of all customers once created.
        // TASK: we should return only the customer that made the request
        return orderService.purchase(orderRequest)
    }

    // **Endpoint 2**
    @GetMapping("/customer/{email}")
    fun getCustomerRewards(@PathVariable email: String): Customer? {
        return orderService.getCustomer(email)
    }

    // **Endpoint 3**
    @GetMapping("/customers")
    fun getAllCustomerRewards(): List<Customer>? {
        return orderService.getCustomers()
    }

    // existing
    @GetMapping("/rewards")
    fun getRewardsTiers(): Array<Rewards> {
        return orderService.rewards
    }
}

