package app.domain.service;
 
import java.util.List;
import app.domain.model.Order;
import app.domain.repository.OrderRepository;
 
public class OrderService
{
 
    private final OrderRepository repository;
 
    public OrderService(OrderRepository repository)
    {
        this.repository = repository;
    }
 
    public void registerOrder(Order order)
    {
        if (repository.findById(order.getOrderId()).isPresent())
        {
            throw new IllegalArgumentException("Ya existe una orden con este ID.");
        }
        repository.add(order);
    }
 
    public List<Order> listOrders()
    {
        return repository.getAll();
    }
 
    public void updateOrder(Order order)
    {
        repository.update(order);
    }
 
    public void deleteOrder(String orderId)
    {
        repository.delete(orderId);
    }
}