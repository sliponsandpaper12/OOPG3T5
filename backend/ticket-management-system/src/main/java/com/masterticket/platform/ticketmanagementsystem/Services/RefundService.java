package com.masterticket.platform.ticketmanagementsystem.Services;

import com.masterticket.platform.ticketmanagementsystem.Models.Booking;
import com.masterticket.platform.ticketmanagementsystem.Repo.BookingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RefundService {

    private final BookingRepo bookingRepo;
    private final IssuedTicketService issuedTicketService;

    @Transactional
    public Double[] refundBooking(Integer bookingId) {
        Booking booking = bookingRepo.getReferenceById(bookingId);
        if (booking.isRefunded()) {
            throw new IllegalStateException("Booking already refunded");
        }
        
        double totalRefundAmount = 0;
        int totalTicketsRefunded = 0;
        
//        for (IssuedTicket ticket : booking.getTickets()) {
//            if (!ticket.isCancelled()) {
//                // Assuming the refund amount is the full price of the ticket minus cancellation fees
//                double refundAmount = ticket.getPrice() - ticket.getEventCategory().getCancellationFee();
//                totalRefundAmount += refundAmount;
//                ticket.setCancelled(true);
//                issuedTicketService.save(ticket); // Assuming you have a save method to update tickets
//                totalTicketsRefunded++;
//            }
//        }
        
        booking.setRefunded(true);
        bookingRepo.save(booking);
        
        return new Double[] {totalRefundAmount, (double) totalTicketsRefunded};
    }
}
