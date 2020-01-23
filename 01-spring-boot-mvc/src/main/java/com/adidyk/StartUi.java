package com.adidyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * Class StartUi.
 */
@SpringBootApplication
public class StartUi {

    //private final SmartPhoneService smartPhoneService;

    //private final OrderService orderService;

    //private final UserService userService;

    //@Autowired
    /*
    public StartUi(SmartPhoneService smartPhoneService, OrderService orderService, UserService userService) {
        this.smartPhoneService = smartPhoneService;
        this.orderService = orderService;
        this.userService = userService;
    }
    */



    /**
     * main - main.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        System.out.println("viber-bot");
        System.getProperties().put("server.port", 8081);
        SpringApplication.run(StartUi.class, arg);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void testJpaMethods() {

        // add smart phone
        //SmartPhone iphone = new SmartPhone("samsung", "galaxy", "smart phone", 10, 500);
        //this.smartPhoneService.save(iphone);

        // add order
        //Order order = new Order();

        // add user
        //User user = this.userService.findById(5);
        //System.out.println();
        //System.out.println();
        //System.out.println(user);
        //this.userService.save(user);
        //Order order = new Order(new Date());
        //ArrayList<SmartPhone> list = new ArrayList<>();
        //list.add(new SmartPhone(1));
        //list.add(new SmartPhone(3));
        //order.setSmartPhones(list);
        //order.setUser(new User(5));
        //ArrayList<Order> listOrder = new ArrayList<>();
        //listOrder.add(order);
        //user.setOrders(listOrder);
        //System.out.println();
        //System.out.println();
        //System.out.println(user);
        //this.userService.save(user);
        //order.setUser(new User(3));
        //this.orderService.save(order);




        //Order order = new Order("order 1");
        //this.orderService.save(order);
        /*
        Order order = this.orderService.findById(1);
        ArrayList<SmartPhone> list = new ArrayList<>();
        list.add(new SmartPhone(3));
        list.add(new SmartPhone(2));
        order.setSmartPhones(list);
        this.orderService.save(order);
        System.out.println(this.orderService.findById(1).getSmartPhones());
        */
        //Order order = new Order("order 2");
        //this.orderService.save(order);


        /*
        SmartPhone iphone = new SmartPhone("apple", "70", "smart phone", 10);
        SmartPhone nokia = new SmartPhone("nokia", "71", "smart phone", 5);
        SmartPhone samsung = new SmartPhone("samsung", "galaxy", "smart phone", 3);
        SmartPhone lg = new SmartPhone("lg", "11", "smart phone", 4);
        this.service.add(iphone);
        this.service.add(nokia);
        this.service.add(samsung);
        this.service.add(lg);
        */
        /*
        SmartPhone lg = new SmartPhone(10,"lg", "11", "smart phone", 66);
        //this.service.update(lg);
        System.out.println(this.service.get(7));
        System.out.println(this.service.get(8));
        System.out.println(this.service.get(9));
        System.out.println(this.service.get(10));
        System.out.println(this.service.get(11));

        for (SmartPhone smartPhone : this.service.getAll()) {
            System.out.println(smartPhone);
        }
        SmartPhone item = new SmartPhone();
        item.setCompany("nokia");
        System.out.println(this.service.findAllByCompany(item));
        */


    }

}