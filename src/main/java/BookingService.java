interface PaymentService {
    boolean processPayment();
}

public class BookingService {
    private final PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean book() {
        return paymentService.processPayment();
    }
}

