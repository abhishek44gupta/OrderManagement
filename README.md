# OrderManagement
Order Management Service

To access H2 database:
http://localhost:8080/h2-console
driver class: org.h2.Driver
jdbc url: jdbc:h2:mem:omsdb
user id: omsadmin
password: omsadmin


Base URL: /oms/v1
Following end points are supported:
/order (HTTP POST)
Sample Order Request:
{
    "customerName" : "Ramesh",
    "orderDate" : "2020-06-08T22:10:33.001",
    "shippingAddress" : "Abcd street, London",
    "total" : 30.0
}


/order/{orderId}/orderItem (HTTP POST)
{
    "productCode" : "PROD03",
    "productName" : "Cup",
    "quantity" : 3
}

HTTP GET
/orders (to get all orders)
/order/{orderid} (to get one order)
/order/{orderId}/orderItem/{orderItemId} (to get one order item)
/order/{orderId}/orderItems (to get all order items)

HTTP PUT:
/order/{orderId}
{
    "customerName" : "Ramesh",
    "orderDate" : "2020-06-08T22:10:33.001",
    "shippingAddress" : "Abcd street, London",
    "total" : 30.0
}

/order/{orderId}/orderItem/{orderItemId}
{
    "productCode" : "PROD03",
    "productName" : "Cup",
    "quantity" : 3
}

HTTP DELETE:
/order/{orderId}
/order/{orderId}/orderItem/{orderItemId}
/order/{orderId}/orderItems




What is not included:
Feign client
Unit/integration test cases
