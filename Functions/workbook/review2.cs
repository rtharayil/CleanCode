
public int ComputeDiscountOnTotalAmount(Order order, decimal discountAmount)  
{  
    order.total =  order.total - discountAmount;

    return order.total;
}  