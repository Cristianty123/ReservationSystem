package service;

import dao.ConferenceRoomDao;
import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReservationSystemTest {

    private ReservationSystem system;
    private ConferenceRoomDao conferenceRoomMock;
    
    @BeforeEach
    public void setUp() {
    conferenceRoomMock =mock(ConferenceRoomDao.class);
    system = new ReservationSystem(conferenceRoomMock);
    }

    @Test
    public void testReserveRoomWhenIsTrue() {
        // Implementar pruebas aquí
        ConferenceRoom RoomBeta = new ConferenceRoom("A1",5);
        when(conferenceRoomMock.getRoomById("A1")).thenReturn(RoomBeta);
        assertEquals(true,system.reserveRoom("A1"));
    }
    @Test
    public void testReserveRoomWhenIsFalse() {
        // Implementar pruebas aquí
        
        when(conferenceRoomMock.getRoomById("A1")).thenReturn(null);
        assertEquals(false,system.reserveRoom("A1"));
    }

    @Test
    public void testCancelReservationWhenIsFalse() {
        // Implementar pruebas aquí
        
        when(conferenceRoomMock.getRoomById("A1")).thenReturn(null);
        assertEquals(false,system.cancelReservation("A1"));
    }
    @Test
    public void testCancelReservationWhenIsTrue() {
        // Implementar pruebas aquí
        
        ConferenceRoom roomBeta = new ConferenceRoom("A1",5);
        roomBeta.setReserved(true);
        when(conferenceRoomMock.getRoomById("A1")).thenReturn(roomBeta);
        assertEquals(true,system.cancelReservation("A1"));
        
        
    }

    // Puedes añadir más pruebas según lo consideres necesario
}
