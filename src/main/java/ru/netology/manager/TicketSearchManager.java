package ru.netology.manager;

import ru.netology.domain.TicketSearch;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketSearchManager {
    TicketRepository repository;

    public TicketSearchManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(TicketSearch item) {
        repository.save(item);
    }

    public TicketSearch[] searchByAirport(String from, String to) {
        TicketSearch[] result = new TicketSearch[0];
        for (TicketSearch item : repository.findAll()) {
            if (item.matches(from, to)) {
                TicketSearch[] tmp = new TicketSearch[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}
