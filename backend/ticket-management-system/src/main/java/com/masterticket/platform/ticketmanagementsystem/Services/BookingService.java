package com.masterticket.platform.ticketmanagementsystem.Services;

import org.springframework.stereotype.Service;
import com.masterticket.platform.ticketmanagementsystem.Repo.BookingRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepo bookingRepo;
    private final UserService userService;

    public Double[] refundBooking(Integer bookingID) {
        var bookingInDb = bookingRepo.getReferenceById(bookingID);
        var user = bookingInDb.getUser();
        userService.refundUser(user.getUserID(), bookingInDb.getAmountPaid());
        bookingInDb.setRefunded(true);
        bookingRepo.save(bookingInDb);
        return new Double[] {
                bookingInDb.getAmountPaid(),
                (double) bookingInDb.getTickets().size()
        };
    }
}
