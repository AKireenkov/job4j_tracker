package ru.job4j.tracker;

public class Create10000Actions implements UserAction {
    private final Output out;

    public Create10000Actions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new 10000 Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create a new Item ====");
        for (int i = 0; i <= 10000; i++) {
            tracker.add(new Item("item " + i));
        }
        return true;
    }
}