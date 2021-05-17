package ru.netology.repository;

import ru.netology.domain.TicketSearch;

public class TicketRepository {
    private TicketSearch[] items = new TicketSearch[0];

    public void save(TicketSearch item) {
        int length = items.length + 1;
        TicketSearch[] tmp = new TicketSearch[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketSearch[] findAll() {
        return items;
    }

    public TicketSearch findById(int id) {
        for (TicketSearch item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        TicketSearch[] tmp = new TicketSearch[length];
        int index = 0;
        for (TicketSearch item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
