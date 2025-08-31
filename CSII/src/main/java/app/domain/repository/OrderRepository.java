package app.domain.repository;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import app.domain.model.Order;
 
public class OrderRepository
{
 
    private List<Order> orders = new ArrayList<>();
 
    public void add(Order order)
    {
        orders.add(order);
    }
 
    public List<Order> getAll()
    {
        return new ArrayList<>(orders);
    }
 
    public Optional<Order> findById(String orderId)
    {
        if (orderId == null) return Optional.empty();
 
        return orders.stream()
                .filter(o -> orderId.equals(o.getOrderId()))
                .findFirst();
    }
 
    public void update(Order updatedOrder)
    {
        findById(updatedOrder.getOrderId()).ifPresent(o ->
        {
            orders.remove(o);
            orders.add(updatedOrder);
        });
    }
 
    public void delete(String orderId)
    {
        orders.removeIf(o -> o.getOrderId().equals(orderId));
    }
}