package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketSearch;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketSearchManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketSearchManager manager = new TicketSearchManager(repository);

    TicketSearch search1 = new TicketSearch(289, 7899, "SVO", "LED", 90);
    TicketSearch search2 = new TicketSearch(112, 21000, "NOZ", "DME", 240);
    TicketSearch search3 = new TicketSearch(29, 2199, "SVO", "LED", 160);
    TicketSearch search4 = new TicketSearch(14, 56000, "DME", "JFK", 450);
    TicketSearch search5 = new TicketSearch(109, 22560, "BCN", "LED", 189);
    TicketSearch search6 = new TicketSearch(80, 18999, "SVO", "LED", 300);

    @BeforeEach
    void setUp() {
        manager.add(search1);
        manager.add(search2);
        manager.add(search3);
        manager.add(search4);
        manager.add(search5);
        manager.add(search6);
    }

    @Test
    public void shouldFindAllTicketSearchByAirports() {
        TicketSearch[] expected = new TicketSearch[]{search3, search1, search6}; //done
        TicketSearch[] actual = manager.searchByAirport("SVO", "LED");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicketSearchByAirports() {
        TicketSearch[] expected = new TicketSearch[]{search4};
        TicketSearch[] actual = manager.searchByAirport("DME", "JFK");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        TicketSearch[] expected = new TicketSearch[]{search1, search2, search3, search4, search5, search6};
        TicketSearch[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNothingIfNotFound() {
        TicketSearch[] expected = new TicketSearch[0];
        TicketSearch[] actual = manager.searchByAirport("DME", "SVO");
        assertArrayEquals(expected, actual);
    }
}